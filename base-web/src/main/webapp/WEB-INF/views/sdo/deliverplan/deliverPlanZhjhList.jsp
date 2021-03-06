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
					<h5>查询条件</h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
					<div class="widget-toolbar no-border">
						<button id="btn-search" type="button" class="btn btn-info btn-minier bigger">
							<i class="icon-search icon-on-right"></i>
							查询
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
							    <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrmc" class="form-control"/>
									</div>
								</div>
							</div>
							<!-- <div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜日期&nbsp;&nbsp;</label>
										<input type="hidden" id="zgkssj" name="zgkssj"/>
										<input type="hidden" id="zgjssj" name="zgjssj"/>
										<input type="text" name="zgsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div> -->
						</form>
						<div class="space-4"></div>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div id="grid-parent" class="col-xs-12">
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
			</div>
			<div class="space-4"></div>
			<h5 class="header blue" style="margin-top:4px;">走货计划明细信息</h5>
			<div class="space-4"></div>
			<div id="grid-parent-qrxx" class="col-xs-12">
				<table id="grid-table-qrxx"></table>
				<div id="grid-pager-qrxx"></div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";
var grid_selector_qrxx = "#grid-table-qrxx";
var pager_selector_qrxx = "#grid-pager-qrxx";
var isEdit = false;
$(function($) {
	$(".skyselect").select2();
	$(".timeInterval").bindDateRange({startElement:$("#zgkssj"),endElement:$("#zgjssj")});
	$(grid_selector).bindTable({
		caption: "",
		url: "<c:url value='/deliverplan/deliverPlan/searchZhjh'/>",
		pager: pager_selector,
		gridParent: "#grid-parent",
		formSearch: "#form-search",
		autoScroll: false,
		//rowList: [5],
		rowNum: 10,
		colModel: [
			{name:'',index:'', label: '&nbsp', width:30, sortable:false, resize:false, 
				formatter:function(cellvalue, options, rowObject){
					return "<i style='cursor:pointer;' class='fa fa-plus fa-border green'></i>";}},
			{name:'id', label:'ID', hidden: true, width:60, editable:false},
			{name:'xszzmc', index:'xszzmc', label:'销售组织', width:100, editable:false, hidden: true},
			{name:'xszz', index:'xszz', label:'销售组织', width:100, editable:false, hidden: true},
			{name:'ywzmc', index:'ywzmc', label:'业务组', width:80, editable:false, hidden: true},
			{name:'ywz', index:'ywz', label:'业务组', width:80, editable:false, hidden: true},
			{name:'xsymc', index:'xsymc', label:'销售员', width:80, editable:false},
			{name:'xsyid', index:'xsyid', label:'销售员', width:80, editable:false, hidden: true},
			{name:'zdrmc', index:'zdrmc', label:'预走货制单人', width:80, editable:false},
			{name:'zdrid', index:'zdrid', label:'预走货制单人', width:80, editable:false, hidden: true},
			{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:140, editable:false},
			{name:'yzhsj', index:'yzhsj', label:'预走货时间', width:100, editable:false},
			{name:'yzhlxmc', index:'yzhlxmc', label:'预走货类型', width:80, editable:false},
			{name:'dcdh', index:'dcdh', label:'订舱单号', width:150, editable:false},
			{name:'khmc', index:'khmc', label:'客户名称', width:140, editable:false},
			{name:'khbm', index:'khbm', label:'客户编码', width:100, editable:false, hidden: true},
			{name:'ddid', index:'ddid', label:'订单号', width:120, editable:false},
			{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80, editable:false},
			{name:'zhfs', index:'zhfs', label:'走货方式', width:80, editable:false, hidden: true},
			{name:'jixing', index:'jixing', label:'机型', width:80, editable:false, hidden: true},
			{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:80, editable:false, hidden: true},
			{name:'xwgj', index:'xwgj', label:'销往国家', width:80, editable:false, hidden: true},
			{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:80, editable:false, hidden: true},
			{name:'mytk', index:'mytk', label:'贸易条款', width:80, editable:false, hidden: true},
			{name:'sl', index:'sl', label:'数量',align:'right', width:80, formatter:'number',editrules:{number:true, required:true},
				formatoptions:{thousandsSeparator: ',',decimalPlaces:4}, editable:false},
			{name:'dj', index:'dj', label:'单价', width:100,formatter:'number',editrules:{number:true, required:true},
				formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
		    {name:'je', index:'je', label:'金额', width:100, align:'right',
					 formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
		    {name:'bz', index:'bz', label:'币种', width:60, editable:false},
			{name:'yjyhrq', index:'yjyhrq', label:'预计验货日期', width:100, hidden: true},
			{name:'zgkssj', index:'zgkssj', label:'装柜开始日期', width:100},
			{name:'zgjssj', index:'zgjssj', label:'装柜结束日期', width:100},
			{name:'jgq', index:'jgq', label:'截关期', width:100, hidden: true},
			{name:'yjkcq', index:'yjkcq', label:'预计开船期', width:100, hidden: true},
			{name:'jfxtsj', index:'jfxtsj', label:'截放行条时间', width:100, hidden: true},
			{name:'kcsj', index:'kcsj', label:'开船时间', width:100, hidden: true},
			{name:'kcy', index:'kcy', label:'开船月', width:100, hidden: true},
			{name:'qygmc', index:'qygmc', label:'起运港', width:80, editable:false, hidden: true},
			{name:'qyg', index:'qyg', label:'起运港', width:80, editable:false, hidden: true},
			{name:'chzt', index:'chzt', label:'出货状态', width:80, editable:false, hidden: true},
			{name:'yzhlx', index:'yzhlx', label:'预走货类型', width:80, editable:false, hidden: true},
			{name:'ygZgs', index:'ygZgs', label:'用柜总柜数',align:'right', width:80, formatter:'integer',
				formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'yg20gp', index:'yg20gp', label:'20GP',align:'right', width:80, formatter:'integer',
					formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'yg40gp', index:'yg40gp', label:'40GP',align:'right', width:80, formatter:'integer',
						formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'yg40hq', index:'yg40hq', label:'40HQ',align:'right', width:80, formatter:'integer',
							formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'ygGsbz', index:'ygGsbz', label:'用柜备注', width:80,editable:false, hidden: true},
			{name:'dcZcs', index:'dcZcs', label:'吨车总数',align:'right', width:80, formatter:'integer',
				formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc3d', index:'dc3d', label:'3吨车数',align:'right', width:80, formatter:'integer',
					formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc5d', index:'dc5d', label:'5吨车数',align:'right', width:80, formatter:'integer',
						formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc8d', index:'dc8d', label:'8吨车数',align:'right', width:80, formatter:'integer',
							formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc10d', index:'dc10d', label:'10吨车数',align:'right', width:80, formatter:'integer',
								formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc12d', index:'dc12d', label:'12吨车数',align:'right', width:80, formatter:'integer',
									formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dcDcbz', index:'dcDcbz', label:'吨车备注', width:80,editable:false, hidden: true},
			{name:'cdgsmc', index:'cdgsmc', label:'船贷公司', width:80, editable:false, hidden: true},
			{name:'cdgsbm', index:'cdgsbm', label:'船贷公司', width:80, editable:false, hidden: true},
			{name:'cylxmc', index:'cylxmc', label:'出运类型', width:80, editable:false, hidden: true},
			{name:'cylx', index:'cylx', label:'出运类型', width:80, editable:false, hidden: true},
			{name:'mdg', index:'mdg', label:'目的港', width:100, hidden: true},
			{name:'jcsj', index:'jcsj', label:'截重时间', width:100, hidden: true},
			{name:'jblsj', index:'jblsj', label:'截补料时间', width:100, hidden: true},
			{name:'gsmc', index:'gsmc', label:'公司', width:80, editable:false, hidden: true},
			{name:'gsbm', index:'gsbm', label:'公司', width:80, editable:false}
		],
		onCellSelect: function(rowid, iCol, cellcontent, e){
			if(iCol == 1){
				var rowData = $(grid_selector).jqGrid('getRowData', rowid);
				var qrData = $(grid_selector_qrxx).getRowData();
				var i = 0;
				$.each(qrData, function(j, m){
					 if(m.yzhdh == rowData.yzhdh && m.dcdh == rowData.dcdh && m.ddid == rowData.ddid){
						 i += 1;
					 }
				});
				if(i > 0){
					alert("该行数据已经添加!");
					return;
				}else{
					// 添加
					$(grid_selector_qrxx).jqGrid("addRowData", rowid, rowData);
				}
			}
		}
	},{
		add:false,
		edit:false,
		del:false,
		view:false,
	});
	$(grid_selector_qrxx).bindTable({
		caption: "",
		pager: pager_selector_qrxx,
		gridParent: "#grid-parent-qrxx",
		multiselect: true,
		//shrinkToFit : false,
		//autoScroll : false,
		pgbuttons: false,
		pginput: false,
		rowList: [1000],
		rowNum: 1000,
		recordtext: "",
		colModel: [
			{name:'id', label:'ID', hidden: true, width:60, editable:false},
			{name:'xszzmc', index:'xszzmc', label:'销售组织', width:100, editable:false, hidden: true},
			{name:'xszz', index:'xszz', label:'销售组织', width:100, editable:false, hidden: true},
			{name:'ywzmc', index:'ywzmc', label:'业务组', width:80, editable:false, hidden: true},
			{name:'ywz', index:'ywz', label:'业务组', width:80, editable:false, hidden: true},
			{name:'xsymc', index:'xsymc', label:'销售员', width:80, editable:false},
			{name:'xsyid', index:'xsyid', label:'销售员', width:80, editable:false, hidden: true},
			{name:'zdrmc', index:'zdrmc', label:'预走货制单人', width:80, editable:false},
			{name:'zdrid', index:'zdrid', label:'预走货制单人', width:80, editable:false, hidden: true},
			{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:140, editable:false},
			{name:'yzhsj', index:'yzhsj', label:'预走货时间', width:100, editable:false},
			{name:'yzhlxmc', index:'yzhlxmc', label:'预走货类型', width:80, editable:false},
			{name:'dcdh', index:'dcdh', label:'订舱单号', width:150, editable:false},
			{name:'khmc', index:'khmc', label:'客户名称', width:140, editable:false},
			{name:'khbm', index:'khbm', label:'客户编码', width:100, editable:false, hidden: true},
			{name:'ddid', index:'ddid', label:'订单号', width:120, editable:false},
			{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80, editable:false},
			{name:'zhfs', index:'zhfs', label:'走货方式', width:80, editable:false, hidden: true},
			{name:'jixing', index:'jixing', label:'机型', width:80, editable:false, hidden: true},
			{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:80, editable:false, hidden: true},
			{name:'xwgj', index:'xwgj', label:'销往国家', width:80, editable:false, hidden: true},
			{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:80, editable:false, hidden: true},
			{name:'mytk', index:'mytk', label:'贸易条款', width:80, editable:false, hidden: true},
			{name:'sl', index:'sl', label:'数量',align:'right', width:80, formatter:'number',editrules:{number:true, required:true},
				formatoptions:{thousandsSeparator: ',',decimalPlaces:4}, editable:false},
			{name:'dj', index:'dj', label:'单价', width:100,formatter:'number',editrules:{number:true, required:true},
				formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
		    {name:'je', index:'je', label:'金额', width:100, align:'right',
					 formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
		    {name:'bz', index:'bz', label:'币种', width:60, editable:false},
			{name:'yjyhrq', index:'yjyhrq', label:'预计验货日期', width:100, hidden: true},
			{name:'zgkssj', index:'zgkssj', label:'装柜开始日期', width:100},
			{name:'zgjssj', index:'zgjssj', label:'装柜结束日期', width:100},
			{name:'jgq', index:'jgq', label:'截关期', width:100, hidden: true},
			{name:'yjkcq', index:'yjkcq', label:'预计开船期', width:100, hidden: true},
			{name:'jfxtsj', index:'jfxtsj', label:'截放行条时间', width:100, hidden: true},
			{name:'kcsj', index:'kcsj', label:'开船时间', width:100, hidden: true},
			{name:'kcy', index:'kcy', label:'开船月', width:100, hidden: true},
			{name:'qygmc', index:'qygmc', label:'起运港', width:80, editable:false, hidden: true},
			{name:'qyg', index:'qyg', label:'起运港', width:80, editable:false, hidden: true},
			{name:'chzt', index:'chzt', label:'出货状态', width:80, editable:false, hidden: true},
			{name:'yzhlx', index:'yzhlx', label:'预走货类型', width:80, editable:false, hidden: true},
			{name:'ygZgs', index:'ygZgs', label:'用柜总柜数',align:'right', width:80, formatter:'integer',
				formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'yg20gp', index:'yg20gp', label:'20GP',align:'right', width:80, formatter:'integer',
					formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'yg40gp', index:'yg40gp', label:'40GP',align:'right', width:80, formatter:'integer',
						formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'yg40hq', index:'yg40hq', label:'40HQ',align:'right', width:80, formatter:'integer',
							formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'ygGsbz', index:'ygGsbz', label:'用柜备注', width:80,editable:false, hidden: true},
			{name:'dcZcs', index:'dcZcs', label:'吨车总数',align:'right', width:80, formatter:'integer',
				formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc3d', index:'dc3d', label:'3吨车数',align:'right', width:80, formatter:'integer',
					formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc5d', index:'dc5d', label:'5吨车数',align:'right', width:80, formatter:'integer',
						formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc8d', index:'dc8d', label:'8吨车数',align:'right', width:80, formatter:'integer',
							formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc10d', index:'dc10d', label:'10吨车数',align:'right', width:80, formatter:'integer',
								formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dc12d', index:'dc12d', label:'12吨车数',align:'right', width:80, formatter:'integer',
									formatoptions:{thousandsSeparator: ','}, editable:false, hidden: true},
			{name:'dcDcbz', index:'dcDcbz', label:'吨车备注', width:80,editable:false, hidden: true},
			{name:'cdgsmc', index:'cdgsmc', label:'船贷公司', width:80, editable:false, hidden: true},
			{name:'cdgsbm', index:'cdgsbm', label:'船贷公司', width:80, editable:false, hidden: true},
			{name:'cylxmc', index:'cylxmc', label:'出运类型', width:80, editable:false, hidden: true},
			{name:'cylx', index:'cylx', label:'出运类型', width:80, editable:false, hidden: true},
			{name:'mdg', index:'mdg', label:'目的港', width:100, hidden: true},
			{name:'jcsj', index:'jcsj', label:'截重时间', width:100, hidden: true},
			{name:'jblsj', index:'jblsj', label:'截补料时间', width:100, hidden: true},
			{name:'gsmc', index:'gsmc', label:'公司', width:80, editable:false, hidden: true},
			{name:'gsbm', index:'gsbm', label:'公司', width:80, editable:false}
		]
	},{
		add:false,
		del:true,
		view:false,
		edit:false,
		refresh:false,
		delfunc:delfunc
	});
	$(grid_selector_qrxx).navButtonAdd(pager_selector_qrxx,{
		caption:"确认", 
		buttonicon:"fa-check-square-o blue", 
		onClickButton: function(){
			save();
		},
		position:"last"
	});
	
	//查询
	$("#btn-search").click(function(){
		$(grid_selector).trigger("reloadGrid");
		$(grid_selector_qrxx).jqGrid("clearGridData");
    });
	
});
// 删除
function delfunc(){
	var selectedRowIds =$(grid_selector_qrxx).jqGrid("getGridParam","selarrrow"); 
	if(selectedRowIds==null||selectedRowIds==""){
		alert("请选择一行数据！");
		return;
	}else{ 
		var len = selectedRowIds.length;  
		for(var i = 0;i < len ;i ++) {  
			$(grid_selector_qrxx).jqGrid("delRowData", selectedRowIds[0]);  
		} 
	}
}

// 选走货计划明细
function save(){
	var _chkbasexx = 0;
	var obj = $(grid_selector_qrxx).jqGrid("getDataIDs");
	$.each(obj, function(j, m){
		$(grid_selector_qrxx).jqGrid("saveRow",m);
	});
	var data = $(grid_selector_qrxx).jqGrid("getRowData");
	if(data.length <1 ){
		swal("", "请选择数据！", "warning");
	}else{
		// 关闭当前窗口
		window.close();
		//上传确定，后的回调处理
		if(window.showModalDialog){//支持showModalDialog函数
			window.returnValue = data;
		}else{//新版chrome不支持showModalDialog函数
			if(window.openerCallBack && typeof(window.openerCallBack) === "function"){
				// 调用父窗口的方法
				window.openerCallBack(data);
			}
		}
	}
}
</script>
</html>