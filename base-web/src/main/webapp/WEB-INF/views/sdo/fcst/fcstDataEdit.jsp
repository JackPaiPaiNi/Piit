<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div id="grid-parent" class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->			
			<div id="search-box" class="widget-box">
				<div class="widget-header header-color-blue2">
					<h5>本周公告<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ny}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${zc}</span></h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
					<div class="widget-toolbar no-border">
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							导出
						</button>
							&nbsp;
						<button id="btn-import" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload-alt icon-on-right bigger-110"></i>
							导入
						</button>
							&nbsp;
						<button id="btn-save" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-save icon-on-right bigger-110"></i>
							保存
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main" id="gg">
					${notice}
					</div>
					<form id="form-search" name="form-search" class="form-search">
					    <input id="zc" name="zc" type="hidden" value="${zc}"/>
					    <input id="lrfs" name="lrfs" type="hidden" value="1"/>
						<input id ="userId" name="userId" type ="hidden" value="${sessionScope.user.loginAcct}">
					    <input id ="userName" name="userName" type ="hidden" value="${sessionScope.user.userName}">
					</form>
				</div>	
			</div>
			<div class="space-4"></div>
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";
var form_search = "#form-search";
var isEdit = false;
<shiro:hasPermission name="fcst:fcstData:edit">isEdit=true;</shiro:hasPermission>
var isHide = true;

$(function($) {
	/**************************************************编辑表初始化开始区域************************************************/
	$(grid_selector).bindTable({
		url:"<c:url value='/fcst/fcstData/search'/>",
		pager: pager_selector,
		gridParent: "#grid-parent",
		formSearch: "#form-search",
		//去掉编辑表分页按钮
		pgbuttons: false,
		pginput: false,
		rowList: [],
		recordtext: "",
		autoheight:true,
		extraheight:$('#search-box').height() + 80,
		editTable:true,
	    rowNum : 200,
		shrinkToFit: false,
		autoScroll: false, 
		footerrow: true,
		multiselect:true, 
		colModel: [  
			{name:'id', label:'ID', hidden: true, width:60, editable:false},
			{name:'khbm', index:'khbm', label:'客户编码', width:80, editable:true,editoptions : {disabled:true},editrules:{required:true}},
			{name:'khmc', index:'khmc', label:'客户名称', width:120, editable:true,editoptions:{dataInit : InitKH,readonly:true},editrules:{required:true}},
			{name:'pid', index:'pid', label:'PID', width:80,editable:true,editoptions : {dataInit : InitPID,readonly:true},editrules:{required:true}},
			{name:'jixing', index:'jxing', label:'机型', width:80,editable:true,hidden:true, disabled:true},
			{name:'jixin', index:'jixin', label:'机芯', width:80,editable:true,hidden:true, disabled:true},
			{name:'pp', index:'pp', label:'品牌', width:80,editrules:{required:true}},
			{name:'xwgjbm', index:'xwgjbm', label:'销往国家编码', width:80,hidden:true,editrules:{required:true}},
			{name:'xwgj', index:'xwgj', label:'销往国家', width:80,edittype:"select",formatter: "select",
				editoptions:{value:"${fns:loadCountryOption('1')}",dataInit: initXwgj},editrules:{required:true}},
			{name:'zhfs', index:'zhfs', label:'走货方式编码', hidden:true,width:80, hidden:true},
			{name:'zhfsmc', index:'zhfsmc', label:'走货方式', hidden:true,width:80, editoptions:{disabled:true}},
			{name:'cc', index:'cc', label:'尺寸', width:80, hidden:true,align: "right",editoptions:{disabled:true}},
			//{name:'iszjh', index:'iszjh', label:'是否组件号', width:80, hidden:true,align: "right",editoptions:{disabled:true}},
		    <c:forEach items="${hbtitles}" var="t" varStatus="stat">
		    <c:if test="${t.flag==2}" >
			    {name:'${t.week}Ycs', index:'${t.week}Ycs', label:'FCST需求', align: "right", formatter:"integer",width:70, editrules:{integer:true,minValue :0}
			    <c:choose>
				    <c:when test="${t.editable==2}">, hidden:true, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:when test="${t.editable==5}">,hidden:true, editable:false, classes:"fcst_qlz_td"</c:when>
			    </c:choose>},
			    {name:'${t.week}Dds', index:'${t.week}Dds', label:'订单数', formatter:"integer",align:'right',
			      width:70, editable:false
				<c:choose>
				    <c:when test="${t.editable==2}">, hidden:true, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:when test="${t.editable==5}">, hidden:true,editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:otherwise>, editable:false</c:otherwise>
		    	</c:choose>}
			    <c:if test="${!stat.last}" >,</c:if>
		    </c:if>
		    </c:forEach>
		],
		editComplete: function(lastEdit, rowData){
			sumGrid();
		},
		gridComplete:function(){
			sumGrid();
		}
	},{
		add:isEdit,
		edit:isEdit,
		del:isEdit,
		deltext:'消除',
		complete:isEdit
	});
	$(grid_selector).navButtonAdd(pager_selector,{
		caption:"移除", 
		buttonicon:"fa-pencil-square grey", 
		onClickButton: function(){
			var param = $("#form-search").getFormData();
			var data = [];
			var rowids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
			if(rowids == null || rowids == ""){
				swal("", "请选择需要移除的数据！", "warning");
				return;
			}else{
		    	   $.each(rowids,function(index,value){
				        var rowData = $(grid_selector).jqGrid("getRowData", value);
				        data.push(rowData);
				   });
		    	   param.list = JSON.stringify(data);
					$("body").bindSweetAlert({
						title:"确定要移除吗?"
					},{
						callback:function(){
							$.bindAjax({
								url:"<c:url value='/fcst/fcstData/remove'/>",
								data:param,
								action:"edit"
							},function(response){
								$(grid_selector).trigger("reloadGrid");
							});
						}
					});
			}
		},
		position:"last"
	});
	$(grid_selector).navButtonAdd(pager_selector,{
		caption:"刷新", 
		buttonicon:"ui-icon fa-refresh green", 
		onClickButton: function(){
			$(grid_selector).trigger("reloadGrid");
		},
		position:"last"
	});
	$(grid_selector).navSeparatorAdd(pager_selector,
			{sepclass : "ui-separator",sepcontent: ''}
	).navButtonAdd(pager_selector,{
		caption:"清零周", 
		buttonicon:"fa-square aquamarine",
		position:"last"
	});
	$(grid_selector).setCustomGroupHeaders({
		useColSpanStyle: true,
		groupHeaders:[
		      		<c:forEach items="${hbtitles}" var="t" varStatus="stat">
		      		<c:if test="${t.flag==1}" >
		      	        {startColumnName:'${t.week}Ycs', numberOfColumns:'${t.colspan}', titleText: '${t.colname}'}<c:if test="${!stat.last}" >,</c:if>
		      	    </c:if>
		      	    </c:forEach>
		] 
	 }).setCustomGroupHeaders({
		 useColSpanStyle: true,
	     groupHeaders:[
				<c:forEach items="${hbtitles}" var="t" varStatus="stat">
					<c:if test="${t.flag==2}" >
				      {startColumnName:'${t.week}Ycs', numberOfColumns:'${t.colspan}', titleText: '${t.colname}'}<c:if test="${!stat.last}" >,</c:if>
				  </c:if>
				  </c:forEach>
	     ] 
	 }); 
	/**************************************************编辑表初始化开始区域************************************************/	
	
	/**************************************************function开始区域************************************************/	
	$("#btn-save").click(function(){
		save();
	});
		
	$("#btn-export").click(function(){
		    var curNum=$(grid_selector).getGridParam("records");
		    if(curNum==0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstData/export'/>",params:{fileName:$("#userName").val()+$("#zc").val()+"周FCST填报周"}});
	    			}
	    		});
	        }
		});
	$('#btn-import').click(function(){
		$.importDialog({
			title:"选择文件",
			data: {sfzg:0,lrfs:1},
			url:"<c:url value='/fcst/fcstData/import'/>"
		},{
			callback:function(results){
				$(grid_selector).trigger("reloadGrid");
			}
		});
	});
	});
	
	//初始化编辑表select2
	function initSelect2(elem){
		$(elem).width(140).addClass("skyselect").select2();
	}
	function initXwgj(elem){
		$(elem).width(140).addClass("skyselect").select2();
		$(elem).click(function() {
			$(elem).closest("tr.jqgrow").find("[name='xwgjbm']").val($(elem).val());
		});
	}
    // 保存
	function save() {
		var param = $("#form-search").getFormData();
 		var lastEdit = $(grid_selector).data('lastEdit');
 		var result = true; 
 		if(lastEdit){
			result = $(grid_selector).saveRow(lastEdit, false, 'clientArray');
		} 
 		if(!result){
			return;
		} 
		var data = $(grid_selector).getRowData();
		var _chkpixx =0;
		var _msg="";
		// 同一PI和客户在表内只能存在一行
		$.each(data, function(i, m){
			var _pid = data[i].pid;
			var _khbm = data[i].khbm;
			var h =i+1;
			for (var j = h;j < data.length; j++){
				var _pid_list = data[j].pid;
				var _khbm_list = data[j].khbm;
				if(_pid == _pid_list && _khbm ==_khbm_list){
					_chkpixx = 1;
					_msg = "错误:第"+Number(i+1)+"行与第"+Number(j+1)+"行的PID,客户相同!";
					break;
				}
			}
			if(_chkpixx == 1){
				return false;
			}
		});
		if(_chkpixx == 1){
			swal(_msg);
			return;
		}
		param.itemListStr = JSON.stringify(data);
		param.lrfs=1;//录入方式常规录入2
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/fcst/fcstData/edit'/>",
					data : param,
					action : "save"
				}, function(response) {
	
				});
			}
		});
	}
	//初始化PID绑定
	function InitPID(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title:"PID选择",
				searchCond:[{"name":"PID","value":"pid"}],
				colModel:[{name:'pid', index:'pid', label:'PID', width:80},
				          {name:'jixing', index:'jixing', label:'型号', width:80},
				          {name:'jixin', index:'jixin', label:'机芯', width:80},
				          {name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80}
				        ],
				url:"<c:url value='/fcst/fcstData/searchPid'/>"
			},{
				callback:function(rows){
					console.info(rows);
					if(rows){
						$(elem).closest("tr.jqgrow").find("[name='jixin']").val(rows.jixin);
						$(elem).closest("tr.jqgrow").find("[name='jixing']").val(rows.jixing);
						$(elem).closest("tr.jqgrow").find("[name='zhfs']").val(rows.zhfs);
						$(elem).closest("tr.jqgrow").find("[name='zhfsmc']").val(rows.zhfsmc);
						$(elem).closest("tr.jqgrow").find("[name='cc']").val(rows.cc);   //
						//$(elem).closest("tr.jqgrow").find("[name='iszjh']").val(rows.iszjh);
						$(elem).val(rows.pid);
					}else{
						$(elem).closest("tr.jqgrow").find("[name='jixin']").val("");
						$(elem).closest("tr.jqgrow").find("[name='jixing']").val("");
						$(elem).closest("tr.jqgrow").find("[name='zhfs']").val("");
						$(elem).closest("tr.jqgrow").find("[name='zhfsmc']").val("");
						$(elem).closest("tr.jqgrow").find("[name='cc']").val("");
						//$(elem).closest("tr.jqgrow").find("[name='iszjh']").val("");
						$(elem).val("");
					}
					
				}
			});
		});
	}
	//初始化客户绑定
	function InitKH(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title:"客户选择",
				searchCond:[{"name":"客户","value":"khbm"}],
				colModel:[{name:'khmc', index:'khmc', label:'客户', width:80},
				          {name:'khbm', index:'khbm', label:'客户编码', width:80},
				          {name:'pp', index:'pp', label:'品牌', width:80},
				          {name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:80}
				        ],
					url:"<c:url value='/pub/widget/findCustByXsy'/>?xsyid="+$('#form-search [name=userId]').val()
			},{
				callback:function(rows){
					$(elem).closest("tr.jqgrow").find("[name='pp']").val(rows.pp);
					$(elem).closest("tr.jqgrow").find("[name='khbm']").val(rows.khbm);
					$(elem).closest("tr.jqgrow").find("[name='xwgj']").select2("val",rows.xwgj);
					$(elem).closest("tr.jqgrow").find("[name='xwgjbm']").val(rows.xwgj);
					$(elem).val(rows.khmc);
				}
			});
		});
	}
	//计算列合计
    function sumGrid(){
		var rowNum = $(grid_selector).getGridParam('records');
		if(rowNum>0){
			$(grid_selector).footerData("set",{"pid":"合计",align: "right",formatter:'number',
			    <c:forEach items="${hbtitles}" var="t" varStatus="stat">
			    <c:if test="${t.flag==2}" >
				    "${t.week}Ycs":$(grid_selector).getCol("${t.week}Ycs",false,"sum"),
				    "${t.week}Dds":$(grid_selector).getCol("${t.week}Dds",false,"sum")<c:if test="${!stat.last}" >,</c:if>
				 </c:if>
		        </c:forEach>
			});
	    }
    } 
	/**************************************************function結束区域************************************************/	
</script>
</html>