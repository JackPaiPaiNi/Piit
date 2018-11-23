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
					    <input id="lrfs" name="lrfs" type="hidden" value="2"/>
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
		rowNum : 100,
		shrinkToFit: false,
		autoScroll: false,
		footerrow: true,
		multiselect:true,
		colModel: [  
			{name:'id', label:'ID', hidden: true, width:60},
			{name:'khbm', index:'khbm', label:'客户编码', width:80},
			{name:'khmc', index:'khmc', label:'客户名称', width:80},
			{name:'pid', index:'pid', label:'PID', width:80},
			{name:'jixing', index:'jixing', label:'机型', width:80},
			{name:'jixin', index:'jixin', label:'机芯', width:80},
			{name:'pp', index:'pp', label:'品牌', width:80},
			{name:'xwgjbm', index:'xwgjbm', label:'销往国家', width:80},
			{name:'xwgj', index:'xwgj', label:'销往国家', width:80, hidden:true},
			{name:'zhfs', index:'zhfs', label:'走货方式', width:80},
			{name:'zhfsmc', index:'zhfsmc', label:'走货方式名称', width:80, hidden:true},
			{name:'cc', index:'cc', label:'尺寸', width:80},
		    <c:forEach items="${hbtitles}" var="t" varStatus="stat">
			    <c:if test="${t.flag==2}" >
			    {name:'${t.week}Ycs', index:'${t.week}Ycs', label:'FCST需求',formatter:"integer", align: "right",width:70, editrules:{integer:true,minValue :0}
			    <c:choose>
				    <c:when test="${t.editable==2}">, hidden:true, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:when test="${t.editable==5}">, hidden:true, editable:false, classes:"fcst_qlz_td"</c:when>
			        <c:otherwise>, editable:true</c:otherwise>
			    </c:choose>},
			    {name:'${t.week}Dds', index:'${t.week}Dds', label:'订单数',formatter:"integer", width:70, align: "right"
			    <c:choose>
				    <c:when test="${t.editable==2}">, hidden:true, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:when test="${t.editable==5}">, hidden:true, editable:false, classes:"fcst_qlz_td"</c:when>
				    <c:otherwise>, editable:false</c:otherwise>
			    </c:choose>}<c:if test="${!stat.last}" >,</c:if>
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstData/export'/>"});
	    			}
	    		});
	        }
		});
	$('#btn-import').click(function(){
		$.importDialog({
			title:"选择文件",
			data: {sfzg:0,lrfs:2},
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
	function initDdlb(elem){
		$(elem).width(140).addClass("skyselect").select2();
		$(elem).click(function() {
			$(elem).closest("tr.jqgrow").find("[name='ddlbbm']").val($(elem).val());
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
	    }else{
			$(grid_selector).footerData("set",{"pid":"合计",align: "right",formatter:'number',
			    <c:forEach items="${hbtitles}" var="t" varStatus="stat">
			    <c:if test="${t.flag==2}" >
				    "${t.week}Ycs":null,
				    "${t.week}Dds":null<c:if test="${!stat.last}" >,</c:if>
				 </c:if>
		        </c:forEach>
			});
	    }
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
		param.itemListStr = JSON.stringify(data);
		param.lrfs=2;//录入方式特殊录入2
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
	/**************************************************function結束区域************************************************/	
</script>
</html>