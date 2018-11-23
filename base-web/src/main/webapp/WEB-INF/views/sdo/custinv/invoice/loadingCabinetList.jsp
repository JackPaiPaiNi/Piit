<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String fpmb = request.getParameter("fpmb");
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
						<form id="form-search-Cabinet" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出货通知书&nbsp;&nbsp;</label>
										<input type="text" name="p_chdh" class="form-control smaller"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="p_ddid" class="form-control smaller"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">柜号&nbsp;&nbsp;</label>
										<input type="text" name="p_guino" class="form-control smaller"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">在线管理系统类别&nbsp;&nbsp;</label>
										<input type="text" name="p_xtlb" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">中文品名&nbsp;&nbsp;</label>
										<input type="text" name="p_zwpm" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
						</form>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div id="grid-parent" class="col-xs-12">
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
			</div>
			<div class="space-4"></div>
			<h5 class="header blue" style="margin-top:4px;">出库订单信息</h5>
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
	var fpmb=<%=fpmb %>
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var grid_selector_qrxx = "#grid-table-qrxx";
	var pager_selector_qrxx = "#grid-pager-qrxx";
	var isEdit = false;
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZgrq"),endElement:$("#endZgrq")});
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/custinv/custinv/searchCabinet'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search-Cabinet",
			autoScroll: false,
			rowList: [10, 20, 50, 100, 200, 500, 1000],
			rowNum: 10,
			colModel: [
				{name:'',index:'', label: '&nbsp', width:30, sortable:false, resize:false, 
					formatter:function(cellvalue, options, rowObject){
						return "<i style='cursor:pointer;' class='fa fa-plus fa-border green'></i>";}},
				{name:'id', label:'ID', hidden: true, width:20},
				{name:'chdh', index:'chdh', label:'出货通知书号', width:70},
				{name:'ddid', index:'ddid', label:'订单号', width:80},
				{name:'dcno', index:'dcno', label:'订舱号', width:120},
				{name:'guino', index:'guino', label:'柜号', width:120},
				{name:'gxnam', index:'gxnam', label:'柜型', width:60},
				{name:'ftno', index:'ftno', label:'封条号', width:100},
				{name:'wlbh', index:'wlbh', label:'物料编号',  width:80},
				{name:'khlh', index:'khlh', label:'客户料号', width:80},
				{name:'wlms', index:'wlms', label:'物料描述',  width:60},
				{name:'sfqty', index:'sfqty', label:'实发数', width:60},
				{name:'boxnum', index:'boxnum', label:'箱数', width:60},
				{name:'kbnum', index:'kbnum', label:'板重', width:80,},
				{name:'kbzwet', index:'kbzwet', label:'卡板总毛重', width:60},
				{name:'zxzmz', index:'zxzmz', label:'箱总毛重', width:60},
				{name:'sumzv', index:'sumzv', label:'总体积', width:80,},
				{name:'zwpm', index:'zwpm', label:'中文品名', width:60},
				{name:'xtlb', index:'xtlb', label:'在线管理系统类别', width:60},
				{name:'jixing', index:'jixing', label:'1',hidden: true, width:60},
				{name:'hscode', index:'1', label:'hscode',hidden: true, width:60},
				{name:'sl', index:'sl', label:'1', hidden: true,width:60},
				{name:'dw', index:'dw', label:'1',hidden: true, width:60},
				{name:'zxzwet', index:'zxzwet', label:'1',hidden: true, width:60},
				{name:'dj', index:'dj', label:'1',hidden: true, width:60},
				{name:'je', index:'je', label:'1',hidden: true, width:60},
				{name:'khms', index:'khms', label:'1',hidden: true, width:60},
				{name:'gysmc', index:'gysmc', label:'1',hidden: true, width:60},
				{name:'gysdz', index:'gysdz', label:'1',hidden: true, width:60},
				{name:'ycgj', index:'ycgj', label:'1',hidden: true, width:60},
				{name:'kbno', index:'kbno', label:'1', hidden: true,width:60},
				{name:'boxno', index:'boxno', label:'1',hidden: true, width:60},
				{name:'khxh', index:'khxh', label:'1',hidden: true, width:60},
				{name:'dgjz', index:'dgjz', label:'1',hidden: true, width:60},
				{name:'ddqty', index:'ddqty', label:'1',hidden: true, width:60},
				{name:'bsqty', index:'bsqty', label:'1',hidden: true, width:60},
				{name:'ddje', index:'ddje', label:'1',hidden: true, width:60},
				{name:'bsje', index:'bsje', label:'1',hidden: true, width:60},
				{name:'gszjh', index:'gszjh', label:'1',hidden: true, width:60},
				{name:'gszjms', index:'gszjms', label:'1',hidden: true, width:60},
				{name:'gszjsl', index:'gszjsl', label:'1',hidden: true, width:60},
				{name:'dxsl', index:'dxsl', label:'1',hidden: true, width:60},
				{name:'zxmz', index:'zxmz', label:'1',hidden: true, width:60},
				{name:'zxjz', index:'zxjz', label:'1',hidden: true, width:60},
				{name:'zxnum', index:'zxnum', label:'1',hidden: true, width:60},
				{name:'zxzjz', index:'zxzjz', label:'1',hidden: true, width:60},
				{name:'zxC', index:'zxC', label:'1',hidden: true, width:60},
				{name:'zxK', index:'zxK', label:'1',hidden: true, width:60},
				{name:'zxG', index:'zxG', label:'1',hidden: true, width:60},
				{name:'kbC', index:'kbC', label:'1',hidden: true, width:60},
				{name:'kbK', index:'kbK', label:'1',hidden: true, width:60},
				{name:'kbG', index:'kbG', label:'1',hidden: true, width:60},
				{name:'kbwet', index:'kbwet', label:'1',hidden: true, width:60},
				{name:'pono', index:'pono', label:'1',hidden: true, width:60},
				{name:'zgdsn', index:'zgdsn', label:'1',hidden: true, width:60},
				{name:'erdat', index:'erdat', label:'erdat', hidden: true, width:60},
				{name:'ertim', index:'ertim', label:'ertim', hidden: true, width:60},
				{name:'chdat', index:'chdat', label:'chdat', hidden: true, width:60},
				{name:'cftno', index:'cftno', label:'cftno', hidden: true, width:60}
			],
			onCellSelect: function(rowid, iCol, cellcontent, e){
				if(iCol == 1){
					var rowData = $(grid_selector).jqGrid('getRowData', rowid);
					var qrData = $(grid_selector_qrxx).getRowData();
					var i = 0;
					$.each(qrData, function(j, m){
						 if(m.chdh == rowData.chdh && m.ddid == rowData.ddid && m.guino == rowData.guino 
								 && m.chdat == rowData.chdat && m.cftno == rowData.cftno && m.zgdsn == rowData.zgdsn){
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

		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"全选", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				selectAll();
			},
			position:"last"
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
				{name:'id', label:'ID', hidden: true, width:20},
				{name:'chdh', index:'chdh', label:'出货通知书号', width:70},
				{name:'ddid', index:'ddid', label:'订单号', width:80},
				{name:'dcno', index:'dcno', label:'订舱号', width:120},
				{name:'guino', index:'guino', label:'柜号', width:120},
				{name:'gxnam', index:'gxnam', label:'柜型', width:60},
				{name:'ftno', index:'ftno', label:'封条号', width:100},
				{name:'wlbh', index:'wlbh', label:'物料编号',  width:80},
				{name:'khlh', index:'khlh', label:'客户料号', width:80},
				{name:'wlms', index:'wlms', label:'物料描述',  width:60},
				{name:'sfqty', index:'sfqty', label:'实发数', width:60},
				{name:'boxnum', index:'boxnum', label:'箱数', width:60},
				{name:'kbnum', index:'kbnum', label:'板重', width:80,},
				{name:'kbzwet', index:'kbzwet', label:'卡板总毛重', width:60},
				{name:'zxzmz', index:'zxzmz', label:'箱总毛重', width:60},
				{name:'sumzv', index:'sumzv', label:'总体积', width:80,},
				{name:'zwpm', index:'zwpm', label:'中文品名', width:60},
				{name:'xtlb', index:'xtlb', label:'在线管理系统类别', width:60},
				{name:'jixing', index:'jixing', label:'1',hidden: true, width:60},
				{name:'hscode', index:'1', label:'hscode',hidden: true, width:60},
				{name:'sl', index:'sl', label:'1', hidden: true,width:60},
				{name:'dw', index:'dw', label:'1',hidden: true, width:60},
				{name:'zxzwet', index:'zxzwet', label:'1',hidden: true, width:60},
				{name:'dj', index:'dj', label:'1',hidden: true, width:60},
				{name:'je', index:'je', label:'1',hidden: true, width:60},
				{name:'khms', index:'khms', label:'1',hidden: true, width:60},
				{name:'gysmc', index:'gysmc', label:'1',hidden: true, width:60},
				{name:'gysdz', index:'gysdz', label:'1',hidden: true, width:60},
				{name:'ycgj', index:'ycgj', label:'1',hidden: true, width:60},
				{name:'kbno', index:'kbno', label:'1', hidden: true,width:60},
				{name:'boxno', index:'boxno', label:'1',hidden: true, width:60},
				{name:'khxh', index:'khxh', label:'1',hidden: true, width:60},
				{name:'dgjz', index:'dgjz', label:'1',hidden: true, width:60},
				{name:'ddqty', index:'ddqty', label:'1',hidden: true, width:60},
				{name:'bsqty', index:'bsqty', label:'1',hidden: true, width:60},
				{name:'ddje', index:'ddje', label:'1',hidden: true, width:60},
				{name:'bsje', index:'bsje', label:'1',hidden: true, width:60},
				{name:'gszjh', index:'gszjh', label:'1',hidden: true, width:60},
				{name:'gszjms', index:'gszjms', label:'1',hidden: true, width:60},
				{name:'gszjsl', index:'gszjsl', label:'1',hidden: true, width:60},
				{name:'dxsl', index:'dxsl', label:'1',hidden: true, width:60},
				{name:'zxmz', index:'zxmz', label:'1',hidden: true, width:60},
				{name:'zxjz', index:'zxjz', label:'1',hidden: true, width:60},
				{name:'zxnum', index:'zxnum', label:'1',hidden: true, width:60},
				{name:'zxzjz', index:'zxzjz', label:'1',hidden: true, width:60},
				{name:'zxC', index:'zxC', label:'1',hidden: true, width:60},
				{name:'zxK', index:'zxK', label:'1',hidden: true, width:60},
				{name:'zxG', index:'zxG', label:'1',hidden: true, width:60},
				{name:'kbC', index:'kbC', label:'1',hidden: true, width:60},
				{name:'kbK', index:'kbK', label:'1',hidden: true, width:60},
				{name:'kbG', index:'kbG', label:'1',hidden: true, width:60},
				{name:'kbwet', index:'kbwet', label:'1',hidden: true, width:60},
				{name:'pono', index:'pono', label:'1',hidden: true, width:60},
				{name:'zgdsn', index:'zgdsn', label:'1',hidden: true, width:60},
				{name:'erdat', index:'erdat', label:'erdat', hidden: true, width:60},
				{name:'ertim', index:'ertim', label:'ertim', hidden: true, width:60},
				{name:'chdat', index:'chdat', label:'chdat', hidden: true, width:60},
				{name:'cftno', index:'cftno', label:'cftno', hidden: true, width:60}
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
	//全选
	function selectAll(){
		var data = $(grid_selector).getRowData();
		if(data == null || data == ""){
			alert("请输入条件查询数据！");
			return;
		}else{
			var ddids = "";
			var qrData = $(grid_selector_qrxx).getRowData();
			$.each(data,function(i,n){
				$.each(qrData, function(j, m){
					if(m.chdh == n.chdh && m.ddid == n.ddid && m.guino == n.guino 
							 && m.chdat == n.chdat && m.cftno == n.cftno && m.zgdsn == n.zgdsn){
						 ddids = ddids + n.ddid+ n.zgdsn +",";
					 }
				});
			})
			if(ddids != ""){
				alert(ddids + "订单行已经添加!");
				return;
			}else{
				// 添加
				$(grid_selector_qrxx).jqGrid("addRowData", null, data, "last");
			}
		}
	}
	
	// 发票选订单
	function save(){
		var _chkbasexx = 0;
		var obj = $(grid_selector_qrxx).jqGrid("getDataIDs");
		$.each(obj, function(j, m){
			$(grid_selector_qrxx).jqGrid("saveRow",m);
		});
		var data = $(grid_selector_qrxx).jqGrid("getRowData");
		// 检查公司、客户、生产基地是否一致
		/*$.each(data, function(i, m){
			var _gsbm = data[i].gsbm;
			var _khbm = data[i].khbm;
			var _scjd = data[i].scjd;
			$.each(data, function(j, m){
				var _gsbm_list = data[j].gsbm;
				var _khbm_list = data[j].khbm;
				var _scjd_list = data[j].scjd;
				if(_gsbm != _gsbm_list || _khbm !=_khbm_list || _scjd !=_scjd_list){
					_chkbasexx = 1;
					return false;
				};
			});
			if(_chkbasexx == 1){
				return false;
			}
		});
		if(_chkbasexx == 1){
			swal("", "所选出货信息公司、客户或生产基地不一致！", "warning");
			return;
		}*/
		//alert(JSON.stringify(data));
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