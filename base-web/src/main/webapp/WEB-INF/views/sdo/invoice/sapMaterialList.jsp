<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String id = request.getParameter("id");
	%>
<style type="text/css">
	html{
		position:static;
	}
</style>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
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
							<input type="hidden" name="id" value="<%=id=="null"?"":id%>"/>
							<div class="row">
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料编码&nbsp;&nbsp;</label>
										<input type="text" name="wlbh" class="form-control smaller"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">描述&nbsp;&nbsp;</label>
										<input type="text" name="wlms" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">柜号&nbsp;&nbsp;</label>
										<input type="text" name="gh" class="form-control"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<h5 class="header blue" style="margin-top:4px;">出库物料信息</h5>
			<div class="space-4"></div>
			<div  id="grid-parent">
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
			</div>
			<h5 class="header blue" style="margin-top:4px;">物料信息确认</h5>
			<div class="space-4"></div>
			<div  id="grid-parent-yc">
				<table id="grid-table-yc"></table>
				<div id="grid-pager-yc"></div>
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
	var grid_selector_yc = "#grid-table-yc";
	var pager_selector_yc = "#grid-pager-yc";
	var isEdit = false;
	$(function($) {
		$(".skyselect").select2();
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/invoice/invoice/searchMaterial'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect: true,
			autoScroll: false,
			rowList: [10,50,100,200,500,1000],
			rowNum:10,
			//autoheight:true,
			//extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60},
				{name:'chdh', index:'chdh', label:'出货通知书编号', width:80},
				{name:'ddid', index:'ddid', label:'订单号', width:80},
				{name:'wlbh', index:'wlbh', label:'物料号', width:80},
				{name:'spms', index:'spms', label:'商品描述', width:60},
				{name:'zsl', index:'zsl', label:'数量', width:80, align:'right', 
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'dj', index:'dj', label:'单价', width:60, align:'right',
					formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zje', index:'zje', label:'金额', width:80, align:'right',
					formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
			/* 	{name:'fph', index:'fph', label:'发票号', hidden: true, width:60},
				{name:'cklsh', index:'cklsh', label:'出库流水号', hidden: true, width:60},
				{name:'jhdh', index:'jhdh', label:'交货单号', hidden: true, width:60},
				{name:'gx', index:'gx', label:'Container Type', hidden: true, width:80}, */
				{name:'gh', index:'gh', label:'柜号',  width:80},
			/* 	{name:'fth', index:'fth', label:'Seal NO.', hidden: true, width:80},
				{name:'kbh', index:'kbh', label:'Plts No.', hidden: true, width:40},
				{name:'xh', index:'xh', label:'CTN#', hidden: true, width:50},
				{name:'xs', index:'xs', label:'CTNS', hidden: true, width:50},
				{name:'jixing', index:'jixing', label:'Model No.', hidden: true, width:60},
				{name:'mxsl', index:'mxsl', label:'QTY/CARTON', hidden: true, width:80},
				{name:'dhsl', index:'dhsl', label:'order Quantity', hidden: true, width:80},
				{name:'mfsl', index:'mfsl', label:'FOC Quantity', hidden: true, width:80},
				{name:'dw', index:'dw', label:'Unit', hidden: true, width:80},
				{name:'dhje', index:'dhje', label:'Order Amount', hidden: true, width:50},
				{name:'mfje', index:'mfje', label:'FOC Amount', hidden: true, width:50},
				{name:'zxC', index:'zxC', label:'L(CARTON)', hidden: true, width:60},
				{name:'zxK', index:'zxK', label:'W(CARTON)', hidden: true, width:50},
				{name:'zxG', index:'zxG', label:'H(CARTON)', hidden: true, width:50},
				{name:'dgzl', index:'dgzl', label:'Weight(kg)per unit', hidden: true, width:60},
				{name:'djzmx', index:'djzmx', label:'NET/CARTON(kg)', hidden: true, width:50},
				{name:'dmzmx', index:'dmzmx', label:'GROSS/CARTON（kg)', hidden: true, width:80},
				{name:'zjz', index:'zjz', label:'TTL NET(kg)', hidden: true, width:80},
				{name:'zmz', index:'zmz', label:'TTL GROSS（kg)', hidden: true, width:80},
				{name:'hgbm', index:'hgbm', label:'HS.CODE', hidden: true, width:80},
				{name:'ycgj', index:'ycgj', label:'Origin', hidden: true, width:80},
				{name:'khlh', index:'khlh', label:'Philco Code', hidden: true, width:60},
				{name:'pono', index:'pono', label:'P.O.NO.', hidden: true, width:50},
				{name:'potype', index:'potype', label:'PO-TYPE', hidden: true, width:50},
				{name:'wlmsYw', index:'wlmsYw', label:'ENGLISH DESCRIPTION', hidden: true, width:60},
				{name:'wlmsZw', index:'wlmsZw', label:'Chinese Description', hidden: true, width:50},
				{name:'wlmxKhyy', index:'wlmxKhyy', label:'Portuguese Description', hidden: true, width:80},
				{name:'mkbmz', index:'mkbmz', label:'Incl. Plt (kg)', hidden: true, width:80},
				{name:'kbC', index:'kbC', label:'Pallet Dim (L)cm', hidden: true, width:80},
				{name:'kbK', index:'kbK', label:'Pallet Dim (W)cm', hidden: true, width:80},
				{name:'kbG', index:'kbG', label:'Pallet Dim (H)cm', hidden: true, width:80},
				{name:'kbtj', index:'kbtj', label:'TTL CBM', hidden: true, width:80},
				{name:'gysdm', index:'gysdm', label:'Supplier Code', hidden: true, width:80},
				{name:'gysmc', index:'gysmc', label:'Supplier Name', hidden: true, width:80}, */
				{name:'gysdz', index:'gysdz', label:'Supplier Address', hidden: true, width:40}
			],
			beforeSelectRow: function (rowid, e) {
 			    var $myGrid = $(this),  
			        i = $.jgrid.getCellIndex($(e.target).closest('td')[0]),  
			        cm = $myGrid.jqGrid('getGridParam', 'colModel');  
			    return (cm[i].name === 'cb');
			},
 			ondblClickRow: function(id){
				return;
		    },
		    onCellSelect: function(rowid,iCol){
		    	return ;
		    },
		    onSelectRow: function(rowid,status) {
		    	    if(status==false){
		    	    	$(grid_selector_yc).jqGrid('delRowData',rowid);
		    	    }else{
						var selr = $(grid_selector).jqGrid('getGridParam','selrow');
						var rowData = $(grid_selector).jqGrid('getRowData',selr);
						var obj = $(grid_selector_yc).jqGrid("getRowData");
						var i =0 ;
						 $.each(obj, function(j, m){
							 if(m.id == rowData.id){
								 i+=1;
							 }
							});
						if(i > 0){
							swal("","已存在,请勿重复添加!","warning");
							return;
						}else{// 添加主体
							$(grid_selector_yc).jqGrid("addRowData", rowData.id, rowData);
							};
						}
		    	    }
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
		});
		
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"全选向下", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				$(grid_selector_yc).jqGrid("clearGridData");
				var selectedIds = $(grid_selector).jqGrid("getGridParam", "selarrrow");
				 $.each(selectedIds, function(s, id){
						var rowData = $(grid_selector).jqGrid('getRowData',id);
						$(grid_selector_yc).jqGrid("addRowData", rowData.id, rowData);
				 });
				
			},
			position:"last"
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		$(grid_selector_yc).bindTable({
			caption: "",
			pager: pager_selector_yc,
			gridParent: "#grid-parent-yc",
			multiselect: true,
			autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60},
				{name:'chdh', index:'chdh', label:'出货通知书编号', width:80},
				{name:'ddid', index:'ddid', label:'订单号', width:80},
				{name:'wlbh', index:'wlbh', label:'物料号', width:80},
				{name:'spms', index:'spms', label:'商品描述', width:60},
				{name:'zsl', index:'zsl', label:'数量', width:80, align:'right', 
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'dj', index:'dj', label:'单价', width:60, align:'right',
					formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zje', index:'zje', label:'金额', width:80, align:'right',
					formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
			/* 	{name:'fph', index:'fph', label:'发票号', hidden: true, width:60},
				{name:'cklsh', index:'cklsh', label:'出库流水号', hidden: true, width:60},
				{name:'jhdh', index:'jhdh', label:'交货单号', hidden: true, width:60},
				{name:'gx', index:'gx', label:'Container Type', hidden: true, width:80}, */
				{name:'gh', index:'gh', label:'柜号', width:80},
			/* 	{name:'fth', index:'fth', label:'Seal NO.', hidden: true, width:80},
				{name:'kbh', index:'kbh', label:'Plts No.', hidden: true, width:40},
				{name:'xh', index:'xh', label:'CTN#', hidden: true, width:50},
				{name:'xs', index:'xs', label:'CTNS', hidden: true, width:50},
				{name:'jixing', index:'jixing', label:'Model No.', hidden: true, width:60},
				{name:'mxsl', index:'mxsl', label:'QTY/CARTON', hidden: true, width:80},
				{name:'dhsl', index:'dhsl', label:'order Quantity', hidden: true, width:80},
				{name:'mfsl', index:'mfsl', label:'FOC Quantity', hidden: true, width:80},
				{name:'dw', index:'dw', label:'Unit', hidden: true, width:80},
				{name:'dhje', index:'dhje', label:'Order Amount', hidden: true, width:50},
				{name:'mfje', index:'mfje', label:'FOC Amount', hidden: true, width:50},
				{name:'zxC', index:'zxC', label:'L(CARTON)', hidden: true, width:60},
				{name:'zxK', index:'zxK', label:'W(CARTON)', hidden: true, width:50},
				{name:'zxG', index:'zxG', label:'H(CARTON)', hidden: true, width:50},
				{name:'dgzl', index:'dgzl', label:'Weight(kg)per unit', hidden: true, width:60},
				{name:'djzmx', index:'djzmx', label:'NET/CARTON(kg)', hidden: true, width:50},
				{name:'dmzmx', index:'dmzmx', label:'GROSS/CARTON（kg)', hidden: true, width:80},
				{name:'zjz', index:'zjz', label:'TTL NET(kg)', hidden: true, width:80},
				{name:'zmz', index:'zmz', label:'TTL GROSS（kg)', hidden: true, width:80},
				{name:'hgbm', index:'hgbm', label:'HS.CODE', hidden: true, width:80},
				{name:'ycgj', index:'ycgj', label:'Origin', hidden: true, width:80},
				{name:'khlh', index:'khlh', label:'Philco Code', hidden: true, width:60},
				{name:'pono', index:'pono', label:'P.O.NO.', hidden: true, width:50},
				{name:'potype', index:'potype', label:'PO-TYPE', hidden: true, width:50},
				{name:'wlmsYw', index:'wlmsYw', label:'ENGLISH DESCRIPTION', hidden: true, width:60},
				{name:'wlmsZw', index:'wlmsZw', label:'Chinese Description', hidden: true, width:50},
				{name:'wlmxKhyy', index:'wlmxKhyy', label:'Portuguese Description', hidden: true, width:80},
				{name:'mkbmz', index:'mkbmz', label:'Incl. Plt (kg)', hidden: true, width:80},
				{name:'kbC', index:'kbC', label:'Pallet Dim (L)cm', hidden: true, width:80},
				{name:'kbK', index:'kbK', label:'Pallet Dim (W)cm', hidden: true, width:80},
				{name:'kbG', index:'kbG', label:'Pallet Dim (H)cm', hidden: true, width:80},
				{name:'kbtj', index:'kbtj', label:'TTL CBM', hidden: true, width:80},
				{name:'gysdm', index:'gysdm', label:'Supplier Code', hidden: true, width:80},
				{name:'gysmc', index:'gysmc', label:'Supplier Name', hidden: true, width:80}, */
				{name:'gysdz', index:'gysdz', label:'Supplier Address', hidden: true, width:40}
			]
		},{
			add:isEdit,
			view:isEdit,
			edit:isEdit,
			refresh:isEdit,
			delfunc:delfunc
		});
		$(grid_selector_yc).navButtonAdd(pager_selector_yc,{
			caption:"确认", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				save(1);
			},
			position:"last"
		});
		$(grid_selector_yc).navButtonAdd(pager_selector_yc,{
			caption:"反选确认", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				save(0);
			},
			position:"last"
		});
	});
	
	// 删除
	function delfunc(){
		var selectedRowIds =$(grid_selector_yc).jqGrid("getGridParam","selarrrow"); 
		if(selectedRowIds==null||selectedRowIds==""){
			swal("", "请选择需要删除的数据！", "warning");
			return;
		}else{ 
			var len = selectedRowIds.length;  
			for(var i = 0;i < len ;i ++) {  
			$(grid_selector_yc).jqGrid("delRowData", selectedRowIds[0]);  
			} 
		}
	}
	
	// 出货通知书信息确认
	function save(flag){
		// flag 0反选 1开票
		var data = $(grid_selector_yc).jqGrid("getRowData");
		if(data.length < 1){
			swal("", "请选择数据！", "warning");
		}else{
			var ids = "";
			for(var i=0; i<data.length; i++){
				ids += data[i].id;
				if(i != data.length-1){
					ids += ",";
				}
			}
			$.bindAjax({
				url : "<c:url value='/invoice/invoice/saveMaterial'/>",
				data : {ids:ids, flag:flag},
				action : "save"
			},function(response) {
				// 关闭当前窗口
				window.close();
			});
			
			//上传确定，后的回调处理
			/* if(window.showModalDialog){//支持showModalDialog函数
				window.returnValue = data;
			}else{//新版chrome不支持showModalDialog函数
				if(window.openerCallBack && typeof(window.openerCallBack) === "function"){
					// 调用父窗口的方法
					window.openerCallBack(data);
				}
			} */
		}
	}
	
</script>
</html>