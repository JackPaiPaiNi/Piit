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
										<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control smaller"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜日期&nbsp;&nbsp;</label>
										<input type="text" name="zgrq" class="form-control timeInterval"/>
										<input type="hidden" id="beginZgrq" name="beginZdsj"/>
										<input type="hidden" id="endZgrq" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出货通知书&nbsp;&nbsp;</label>
										<input type="text" name="chdh" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
							</div>
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
			url: "<c:url value='/invoice/invoicenew/searchOrder'/>",
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
				{name:'id', label:'ID', hidden: true, width:20},
				{name:'gsbm', index:'gsbm', label:'公司编码', width:70},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:120},
				{name:'chdh', index:'chdh', label:'出货通知书', width:120},
				{name:'ddid', index:'ddid', label:'订单号', width:100},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'zhfs', index:'zhfs', label:'走货方式', hidden:true, width:80},
				{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80},
				{name:'qyg', index:'qyg', label:'起运港', hidden:true, width:60},
				{name:'qygmc', index:'qygmc', label:'起运港', width:60},
				{name:'mdg', index:'mdg', label:'目的港', width:60},
				{name:'zgrq', index:'zgrq', label:'装柜日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'cwzy', index:'cwzy', hidden: true, label:'船务专员', width:60},
				{name:'cwzymc', index:'cwzymc', label:'船务专员', width:60},
				{name:'scjd', index:'scjd', hidden: true, label:'生产基地', width:50},
				{name:'scjdmc', index:'scjdmc', label:'生产基地名称', width:60}
			],
			onCellSelect: function(rowid, iCol, cellcontent, e){
				if(iCol == 1){
					var rowData = $(grid_selector).jqGrid('getRowData', rowid);
					var qrData = $(grid_selector_qrxx).getRowData();
					var i = 0;
					$.each(qrData, function(j, m){
						 if(m.chdh == rowData.chdh && m.ddid == rowData.ddid){
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
				{name:'id', label:'ID', hidden: true, width:60},
				{name:'gsbm', index:'gsbm', label:'公司编码', width:70},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:120},
				{name:'chdh', index:'chdh', label:'出货通知书', width:120},
				{name:'ddid', index:'ddid', label:'订单号', width:100},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'zhfs', index:'zhfs', label:'走货方式', hidden:true, width:80},
				{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80},
				{name:'qyg', index:'qyg', label:'起运港', hidden:true, width:60},
				{name:'qygmc', index:'qygmc', label:'起运港', width:60},
				{name:'mdg', index:'mdg', label:'目的港', width:60},
				{name:'zgrq', index:'zgrq', label:'装柜日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'cwzy', index:'cwzy', hidden: true, label:'船务专员', width:60},
				{name:'cwzymc', index:'cwzymc', label:'船务专员', width:60},
				{name:'scjd', index:'scjd', hidden: true, label:'生产基地', width:50},
				{name:'scjdmc', index:'scjdmc', label:'生产基地名称', width:60}
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
					 if(m.chdh == n.chdh && m.ddid == n.ddid){
						 ddids = ddids + n.ddid +",";
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
/* 	function save(){
		var _chkbasexx = 0;
		var _zhfsflag = 0;
		var obj = $(grid_selector_qrxx).jqGrid("getDataIDs");
		$.each(obj, function(j, m){
			$(grid_selector_qrxx).jqGrid("saveRow",m);
		});
		var data = $(grid_selector_qrxx).jqGrid("getRowData");
		alert(JSON.stringify(data));
		// 检查公司、客户是否一致//检查所选订单的走货方式是否一致
		$.each(data, function(i, m){
			var _gsbm = data[i].gsbm;
			var _khbm = data[i].khbm;
			var _zhfs = data[i].zhfs;
			$.each(data, function(j, m){
				var _gsbm_list = data[j].gsbm;
				var _khbm_list = data[j].khbm;
				var _zhfs_list = data[j].zhfs;
				 if(_gsbm != _gsbm_list || _khbm !=_khbm_list){
					_chkbasexx = 1;
					return false;
				}; 
				alert(_zhfs);
				alert(_zhfs_list);
				 //1、8 为CKD，3为CBU，其余都是SKD
				if(((_zhfs == 1 || _zhfs == 8) && _zhfs_list != 1 && _zhfs_list != 8) || 
				   (_zhfs == 3 && _zhfs_list != 3) ||
				   ((_zhfs == 2 || _zhfs == 4 || _zhfs == 5 || _zhfs == 6 || _zhfs == 7) && _zhfs_list != 2 && _zhfs_list != 4 && _zhfs_list != 5 && _zhfs_list != 6 && _zhfs_list != 7)){
					_zhfsflag = 1;
					return false;
				} 
			});
			if(_chkbasexx == 1){
				return false;
			}
		});
		 if(_chkbasexx == 1){
			swal("", "所选出货信息公司、客户不一致！", "warning");
			return;
		} 
		if(_zhfsflag == 1){
			swal("", "所选订单走货方式不一致，不能一起开票!", "warning");
			return;	
		}
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
	} */
	// 发票选订单
	function save(){
		var _chkbasexx = 0;
		var obj = $(grid_selector_qrxx).jqGrid("getDataIDs");
		$.each(obj, function(j, m){
			$(grid_selector_qrxx).jqGrid("saveRow",m);
		});
		var data = $(grid_selector_qrxx).jqGrid("getRowData");
		// 检查公司、客户、生产基地是否一致
		$.each(data, function(i, m){
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
		}
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