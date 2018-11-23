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
<!-- 							&nbsp;
						<button id="btn-import" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload-alt icon-on-right bigger-110"></i>
							导入
						</button> -->
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;︱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button id="btn-dzzg" type="button" class="btn btn-info btn-minier bigger skydisabled" disabled="disabled">
							<i class="icon-ok icon-on-right bigger-110"></i>
							当周终稿
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main" id="gg">
					${notice}
					</div>
					<form id="form-search" name="form-search" class="form-search">
					<input id="zc" name="zc" type="hidden" value="${zc}"/>
					<input id="sfps" name="sfps" type="hidden" value="${sfps}"/>
					<input id ="compName" name="compName" type ="hidden" value="${sessionScope.user.compName}">
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
var url_pid = "<c:url value='/fcst/fcstData/snycPpxxBom'/>";
var isEdit = false;
<shiro:hasPermission name="fcst:fcstData:edit">isEdit=true;</shiro:hasPermission>
var isHide = true;

$(function($) {
	/**************************************************编辑表初始化开始区域************************************************/
	var gridTable = $(grid_selector).bindTable({
		url:"<c:url value='/fcst/fcstData/searchApproveFcst'/>",
		editurl: "<c:url value='/fcst/fcstData/editFcstApproveData'/>",
		pager: pager_selector,
		gridParent: "#grid-parent",
		formSearch: "#form-search",
		autoheight:true,
		extraheight:$('#search-box').height() + 80,
		width:window.screen.availWidth-20,  
		rowNum : 100,
        shrinkToFit: false,  
		autoScroll: true,
		footerrow: true,
		multiselect:true, 
		colModel: [  
			{name:'id', label:'ID', hidden: true, width:60},
			{name:'lrfsmc', index:'lrfsmc', label:'录入方式', width:80},
			{name:'xszzmc', index:'xszzmc', label:'业务部', width:80,},
			{name:'ywzmc', index:'ywzmc', label:'业务组', width:80},
			{name:'xsymc', index:'xsymc', label:'业务员', width:80},
			{name:'khmc', index:'khmc', label:'客户名称', width:80},
			{name:'pid', index:'pid', label:'PID', width:80},
			{name:'jixing', index:'jixing', label:'机型', width:80},
			{name:'jixin', index:'jixin', label:'机芯', width:80},
			{name:'pp', index:'pp', label:'品牌', width:80},
			{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:80},
			{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80},
			{name:'cc', index:'cc', label:'尺寸', width:80},
			{name:'pxh', index:'pxh', label:'配屏', width:80},
 			<c:forEach items="${hbtitles}" var="t" varStatus="stat">
			    <c:if test="${t.flag==2}" >
			    {name:'${t.week}Ycs', index:'${t.week}Ycs',label:'FCST需求', align: "right",width:70, editrules:{integer:true,minValue :0}, 
			    	formoptions:{label:'${t.colname}FCST需求'}, align: "right"
			    <c:choose>
				    <c:when test="${t.editable==2}">, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:when test="${t.editable==5}">, editable:false, classes:"fcst_qlz_td"</c:when>
			        <c:otherwise>, editable:false</c:otherwise>
			    </c:choose>},
			    {name:'${t.week}Dds', index:'${t.week}Dds', label:'订单数', width:70,align: "right"
			    <c:choose>
				    <c:when test="${t.editable==2}">, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:when test="${t.editable==5}">, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:otherwise>, editable:false</c:otherwise>
		    	</c:choose>},
			    {name:'${t.week}Wxds', index:'${t.week}Wxds', label:'未下单数', width:70,align: "right"
		    	<c:choose>
				    <c:when test="${t.editable==2}">, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:when test="${t.editable==5}">, editable:false, classes:"fcst_qlz_td"</c:when>
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
		add:false,
		edit:false,
		del:false,
		view:false
	});
	$(grid_selector).navSeparatorAdd(pager_selector,
			{sepclass : "ui-separator",sepcontent: ''}
	).navButtonAdd(pager_selector,{
		caption:"清零周", 
		buttonicon:"fa-square aquamarine",
		position:"last"
	});/* 
	$(grid_selector).navButtonAdd(pager_selector,{
		caption:"查看配屏信息", 
		buttonicon:"fa-square-o orange", 
		onClickButton: function(){
			var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
			if(id==null || id==""){
				swal("","请选择一行数据！","warning");
			}else if(rowData.pxh.length > 0){
				swal("","请选择配屏信息为空的数据！","warning");
			}else{
				
					$.bindAjax({
						url:url_pid,
						data:{pid:rowData.pid},
						action:"edit"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
			}
		},
		position:"last"
	}); */
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
	if($("#sfps").val()=='0'){
		$("#btn-dzzg").removeProp("disabled").removeAttr("disabled");
	}
	/**************************************************编辑表初始化开始区域************************************************/	
	
	/**************************************************function开始区域************************************************/	
	
	$("#btn-save").click(function(){
		save();
	});
	$("#btn-dzzg").click(function(){
    	$("body").bindSweetAlert({
			title:"确定要终稿吗?",
			closeOnConfirm: true
		},{
			callback:function(){
				$.bindAjax({
					url : "<c:url value='/fcst/fcstData/editDzzg'/>",
					data : {zc:$("#zc").val()},
					action : "save"
				}, function(response) {
					$(grid_selector).trigger("reloadGrid");
					$("#btn-dzzg").prop('disabled','disabled');
				});
			}
		});
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstData/exportApproveFcst'/>",params:{fileName:$("#compName").val()+$("#zc").val()+"周采购FCST评审表"}});
	    			}
	    		});
	        }
	});
	$('#btn-import').click(function(){
		$.importDialog({
			title:"选择文件",
			data: {sfzg:1},
			url:"<c:url value='/fcst/fcstData/importApprove'/>"
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
	
    //计算列合计
	function sumGrid(){
		var rowNum = $(grid_selector).getGridParam('records');
		if(rowNum>0){
			$(grid_selector).footerData("set",{"pid":"合计",align: "right",formatter:'number', formatoptions:{thousandsSeparator: ','},
			    <c:forEach items="${hbtitles}" var="t" varStatus="stat">
			    <c:if test="${t.flag==2}" >
				    "${t.week}Ycs":$(grid_selector).getCol("${t.week}Ycs",false,"sum"),
				    "${t.week}Dds":$(grid_selector).getCol("${t.week}Dds",false,"sum"),
				    "${t.week}Wxds":$(grid_selector).getCol("${t.week}Wxds",false,"sum")<c:if test="${!stat.last}" >,</c:if>
				 </c:if>
		        </c:forEach>
			});
	    }else{
	    	$(grid_selector).footerData("set",{"pid":"合计",align: "right",formatter:'number', formatoptions:{thousandsSeparator: ','},
			    <c:forEach items="${hbtitles}" var="t" varStatus="stat">
			    <c:if test="${t.flag==2}" >
				    "${t.week}Ycs":null,
				    "${t.week}Dds":null,
				    "${t.week}Wxds":null<c:if test="${!stat.last}" >,</c:if>
				 </c:if>
		        </c:forEach>
			});
	    }
    } 

    // 保存
	function save() {
		var param = $("#form-search").getFormData();
		var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var data = $(grid_selector).getRowData();
		param.itemListStr = JSON.stringify(data);
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
    //移除
	function delfunc() {
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr == null || selr == ""){
			swal("", "请选择一行数据！", "warning");
			return;
		}else{
				$("body").bindSweetAlert({
					title:"确定要移除吗?"
				},{
					callback:function(){
						$.bindAjax({
							url:"<c:url value='/fcst/fcstData/delete'/>",
							data:{id:rowData.id},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
		}
	}
    

	//初始化PID绑定
	function InitPID(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title:"PID选择",
				searchCond:[{"name":"PID","value":"pid"},
				            {"name":"客户编码","value":"khbm"}],
				colModel:[{name:'pid', index:'pid', label:'PID', width:80},
				          {name:'khmc', index:'khmc', label:'客户名称', width:80},
				          {name:'khbm', index:'khbm', label:'客户编码', width:80},
				          {name:'pp', index:'pp', label:'品牌', width:80},
				          {name:'jixing', index:'jixing', label:'型号', width:80},
				          {name:'jixin', index:'jixin', label:'机芯', width:80},
				          {name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:80},
				          {name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80}
				        ],
				url:"<c:url value='/mdm/pidInfo/search'/>"
			},{
				callback:function(rows){
					if(rows){
						$(elem).closest("tr.jqgrow").find("[name='jixin']").select2("val",rows.jixin);
						$(elem).closest("tr.jqgrow").find("[name='jixing']").select2("val",rows.jixing);
						$(elem).closest("tr.jqgrow").find("[name='pp']").val(rows.pp);
						$(elem).closest("tr.jqgrow").find("[name='xwgj']").select2("val",rows.xwgj);
						$(elem).closest("tr.jqgrow").find("[name='zhfs']").select2("val",rows.zhfs);
						$(elem).closest("tr.jqgrow").find("[name='khbm']").val(rows.khbm);
						$(elem).closest("tr.jqgrow").find("[name='khmc']").val(rows.khmc);
						$(elem).closest("tr.jqgrow").find("[name='cc']").val(rows.cc);
						$(elem).val(rows.pid);
					}else{
						$(elem).closest("tr.jqgrow").find("[name='jixin']").select2("val","");
						$(elem).closest("tr.jqgrow").find("[name='jixing']").select2("val","");
						$(elem).closest("tr.jqgrow").find("[name='pp']").val(rows.pp);
						$(elem).closest("tr.jqgrow").find("[name='xwgj']").select2("val","");
						$(elem).closest("tr.jqgrow").find("[name='zhfs']").select2("val","");
						$(elem).closest("tr.jqgrow").find("[name='khbm']").val("");
						$(elem).closest("tr.jqgrow").find("[name='khmc']").val("");
						$(elem).closest("tr.jqgrow").find("[name='cc']").val("");
						$(elem).val("");
					}
					
				}
			});
		});
	}
	/**************************************************function結束区域************************************************/	
</script>
</html>