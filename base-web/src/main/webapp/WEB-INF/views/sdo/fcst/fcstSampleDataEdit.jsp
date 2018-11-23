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
				<form id="form-submit">
					<input id="zc" name="zc" type="hidden" value="${zc}"/>
					<input id="zcrq" name="zcrq" type="hidden" value="${zcrq}"/>
			    	<input id="xsyid" name="xsyid" type="hidden" value="${xsyid}"/>
				</form>
				<div class="widget-header header-color-blue2">
					<h5>采购FCST样机填报</h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
					<div class="widget-toolbar no-border">
						<button id="btn-save" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-save icon-on-right bigger-110"></i>
							提交
						</button>
					</div>
				</div>
				<div class="widget-body">
					<form id="form-search" name="form-search" class="form-search">
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
<shiro:hasPermission name="fcst:fcstSampleData:edit">isEdit=true;</shiro:hasPermission>

$(function($) {
	/**************************************************编辑表初始化开始区域************************************************/
	var gridTable = $(grid_selector).bindTable({
		pager: pager_selector,
		gridParent: "#grid-parent",
		formSearch: "#form-search",
		//去掉编辑表分页按钮
		pgbuttons: false,
		pginput: false,
		rowList: [],
		recordtext: "",
		autoheight:true,
		extraheight:$('#search-box').height()+5,
		editTable:true,
		multiselect: true,
		colModel: [  
			{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true},
			{name:'id', label:'ID', hidden: true, width:60, editable:false},
			{name:'zc', index:'zc', label:'周次', hidden:true,width:80, editoptions : {dataInit : InitZc}},
			{name:'zcrq', index:'zcrq', label:'周次', width:120, editoptions : {dataInit : InitZcrq}},
			{name:'xsymc', index:'xsymc', label:'销售员', hidden: true, width:80},
			{name:'xsyid', index:'xsyid', label:'销售员', width:80, editoptions : {dataInit : InitXsy}},
			{name:'khbm', index:'khbm', label:'客户', width:80,editrules:{required:true}},
			{name:'khmc', index:'khmc', label:'客户名称', width:80, hidden: true},
			{name:'xwgj', index:'xwgj', label:'销往地', width:80, edittype:"select", formatter:"select", 
				editoptions:{value:"${fns:loadCountryOption('1')}",dataInit: initSelect2},editrules:{required:true}},
			{name:'jixing', index:'jxing', label:'机型', width:80, editable:true, editrules:{required:true}},
			{name:'jixin', index:'jixin', label:'机芯', width:80, editable:true, editrules:{required:true}},
			{name:'sl', index:'sl', label:'数量', width:80,align:'right',formatter:'number',editrules:{required:true}},
			{name:'ptbh', index:'ptbh', label:'屏体编号', width:80,editrules:{required:true}},
			{name:'wgys', index:'wgys', label:'外观颜色', width:80,editrules:{required:true}},
			{name:'logo', index:'logo', label:'Logo', width:80,editrules:{required:true}},
			{name:'yjyt', index:'yjyt', label:'样机用途', width:80, edittype:"select", formatter:"select", 
				editoptions:{value:"${fns:loadDictEditOption('YJYT')}",dataInit: initSelect2},editrules:{required:true}},
			{name:'chsj', index:'chsj', label:'出货时间', width:80,editrules:{required:true}}
		],editComplete: function(lastEdit, rowData){
			
		}
	},{
		add:isEdit,
		edit:isEdit,
		del:isEdit,
		complete:isEdit
	});
	
	/**************************************************function开始区域************************************************/	
 	//初始化周次
	function InitZc(elem){
		var zc = $("#form-submit [name=zc]").val();
		$(elem).val(zc);
		$(elem).attr({"disabled":true});
	}
 	//初始化周次日期
	function InitZcrq(elem){
		var zcrq = $("#form-submit [name=zcrq]").val();
		$(elem).val(zcrq);
		$(elem).attr({"disabled":true});
	}
	//初始化销售员
	function InitXsy(elem){
		var xsyid = $("#form-submit [name=xsyid]").val();
		$(elem).val(xsyid);
		$(elem).attr({"disabled":true});
	} 
	//初始化状态
	function initZT(elem){
		$(elem).width(140).addClass("skyselect").select2();
		$(elem).select2("val",1);
		$(elem).attr({"disabled":true});
	}
	
	$("#btn-save").click(function(){
		save();
	});
});
	//初始化编辑表select2
	function initSelect2(elem){
		$(elem).width(140).addClass("skyselect").select2();
	}
    // 保存
	function save() {
		var lastSel = $(grid_selector).getGridParam('selrow');
		$(grid_selector).saveRow(lastSel, false, 'clientArray');
		var data = $(grid_selector).jqGrid("getGridParam", "selarrrow");
 		var lastEdit = $(grid_selector).data('lastEdit');
 		var result = true; 
 		if(lastEdit){
			result = $(grid_selector).saveRow(lastEdit, false, 'clientArray');
		} 
 		if(!result){
			return;
		} 
		// 判断是否选了数据
		if(!data.length > 0){
			swal("","请至少勾选一条记录！","warning");
			return;
		}
		// 循环处理选中数据（可多选）
		var rows = [];
		for (var i = 0; i < data.length; i++) {
			var rowData = $(grid_selector).jqGrid("getRowData", data[i]);
			rows.push(rowData);
		}
		// 获取表单数据
		var param = $("#form-search").getFormData();
		param.itemListStr = JSON.stringify(rows);
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/fcst/fcstSampleData/edit'/>",
					data : param,
					action : "save"
				}, function(response) {
					$(grid_selector).jqGrid("clearGridData");
				});
			}
		});
	} 
	/**************************************************function結束区域************************************************/	
</script>
</html>