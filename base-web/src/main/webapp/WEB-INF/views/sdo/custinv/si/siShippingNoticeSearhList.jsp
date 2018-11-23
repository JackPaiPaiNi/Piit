<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<style type="text/css">
html {
	position: static;
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
						<span class="widget-toolbar"> <a href="#"
							data-action="collapse"> <i class="icon-chevron-up"></i>
						</a>
						</span>
						<div class="widget-toolbar no-border">
							<button id="btn-search" type="button"
								class="btn btn-info btn-minier bigger">
								<i class="icon-search icon-on-right"></i> 查询
							</button>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<form id="form-search" class="form-search">
								<div class="row">
									<div class="col-xs-6 col-sm-4">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
												type="text" name="khmc" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">出货通知书&nbsp;&nbsp;</label> <input
												type="text" name="chtzs" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-5">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">出货通知书创建日期&nbsp;&nbsp;</label>
											<input type="text" name="zgrq"
												class="form-control timeInterval" /> <input type="hidden"
												id="beginZgrq" name="beginZgrq" /> <input type="hidden"
												id="endZgrq" name="endZgrq" /> <span
												class="input-group-addon"> <i
												class="icon-calendar bigger-110"></i>
											</span>
										</div>
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
									<div class="col-xs-6 col-sm-4">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">订单号&nbsp;&nbsp;</label> <input
												type="text" name="ddh" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">柜号&nbsp;&nbsp;</label> <input
												type="text" name="guino" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">是否开具SI&nbsp;&nbsp;</label>
											<select role="select" name="sfsi" size="1" class="form-control skyselect">
												<option value="-1">全部</option>
												<option value="1">已开具</option>
												<option value="0" selected="selected">未开具</option>
											</select>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div id="grid-parent">
					<table id="grid-table"></table>
					<div id="grid-pager"></div>
				</div>
				<div class="space-4"></div>
				<h5 class="header blue" style="margin-top: 4px;">已选信息</h5>
				<div class="space-4"></div>
				<div id="grid-parent-select">
					<table id="grid-table-select"></table>
					<div id="grid-pager-select"></div>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";

	var grid_selector_select = "#grid-table-select";
	var pager_selector_select = "#grid-pager-select";

	$(function($) {
		$('.skyselect').select2();
		$("#form-search [name=zgrq]").bindDateRange({
			startElement : $("#beginZgrq"),
			endElement : $("#endZgrq")
		});
		

		$(grid_selector)
				.bindTable(
						{
							caption : "",
							url : "<c:url value='/custinv/si/searhList'/>",
							pager : pager_selector,
							gridParent : "#grid-parent",
							formSearch : "#form-search",
							//multiselect: true,
							shrinkToFit : false,
							autoScroll : false,
							sortname : 'zgrq',
							sortorder : 'desc',
							rowList : [5, 10, 20, 50, 100, 200],
							rowNum : 5,
							colModel : [
									{
										name : '',
										index : '',
										label : '&nbsp',
										width : 20,
										sortable : false,
										resize : false,
										formatter : function(cellvalue,
												options, rowObject) {
											return "<i style='cursor:pointer;' class='fa fa-plus fa-border green'></i>";
										}
									}, {
										name : 'khmc',
										index : 'khmc',
										label : '客户名称',
										width : 160
									}, {
										name : 'zgrq',
										index : 'zgrq',
										label : '装柜日期',
										width : 80,
										formatter : 'date',
										formatoptions : {
											newformat : 'Y-m-d'
										}
									}, {
										name : 'chdno',
										index : 'chdno',
										label : '出货通知书',
										width : 90
									}, {
										name : 'guino',
										index : 'guino',
										label : 'CTNR NO.',
										width : 90
									}, {
										name : 'ftno',
										index : 'ftno',
										label : 'SEAL NO.',
										width : 90
									}, {
										name : 'gxnam',
										index : 'gxnam',
										label : 'CTNR TYPE',
										width : 90
									}, {
										name : 'dcno',
										index : 'dcno',
										label : 'S/O NO.',
										width : 90
									}, {
										name : 'tare',
										index : 'tare',
										label : 'TARE',
										width : 80
									}],
							onCellSelect : function(rowid, iCol, cellcontent, e) {
								if (iCol == 1) {
									var rowData = $(grid_selector).jqGrid(
											'getRowData', rowid);
									var ids = $(grid_selector_select).jqGrid(
											"getDataIDs");
									var i = 0;
									$.each(ids, function(j, m) {
										if (m == rowData.chdno) {
											i += 1;
										}
									});
									if (i > 0) {
										alert("该行数据已经添加!");
										return;
									} else {
										// 添加
										$(grid_selector_select).jqGrid(
												"addRowData", rowData.chdno,
												rowData);
									}
								}
							}
						}, {
							add : false,
							edit : false,
							del : false,
							view : false,
						});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"全选", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				selectAll();
			},
			position:"last"
		});

		//查询
		$("#btn-search").click(function() {
			$(grid_selector).trigger("reloadGrid");
		});

		$(grid_selector_select).bindTable({
			caption : "",
			pager : pager_selector_select,
			gridParent : "#grid-parent-select",
			multiselect : true,
			shrinkToFit : false,
			autoScroll : false,
			pgbuttons : false,
			pginput : false,
			rowList : [],
			recordtext : "",
			colModel : [ {
				name : 'khmc',
				index : 'khmc',
				label : '客户名称',
				width : 160
			}, {
				name : 'zgrq',
				index : 'zgrq',
				label : '装柜日期',
				width : 80,
				formatter : 'date',
				formatoptions : {
					newformat : 'Y-m-d'
				}
			}, {
				name : 'chdno',
				index : 'chdno',
				label : '出货通知书',
				width : 90
			}, {
				name : 'guino',
				index : 'guino',
				label : 'CTNR NO.',
				width : 90
			}, {
				name : 'ftno',
				index : 'ftno',
				label : 'SEAL NO.',
				width : 90
			}, {
				name : 'gxnam',
				index : 'gxnam',
				label : 'CTNR TYPE',
				width : 90
			}, {
				name : 'dcno',
				index : 'dcno',
				label : 'S/O NO.',
				width : 90
			}, {
				name : 'tare',
				index : 'tare',
				label : 'TARE',
				width : 80
			} ]
		}, {
			add : false,
			edit : false,
			del : true,
			view : false,
			refresh : false,
			delfunc : delfunc
		});

		$(grid_selector_select).navButtonAdd(pager_selector_select, {
			caption : "确认",
			buttonicon : "fa-check-square-o blue",
			onClickButton : function() {
				confirm();
			},
			position : "last"
		});

	});
	
	//全选
	function selectAll(){
		var data = $(grid_selector).getRowData();
		if(data == null || data == ""){
			alert("请输入条件查询数据！");
			return;
		}else{
			var guinos = "";
			var qrData = $(grid_selector_select).getRowData();
			$.each(data,function(i,n){
				$.each(qrData, function(j, m){
					 if(m.chdno == n.chdno && m.guino == n.guino && m.ftno == n.ftno && m.dcno == n.dcno){
						 guinos = guinos + n.chdno + ":" + n.guino +",";
					 }
				});
			})
			if(guinos != ""){
				alert(guinos + "出货通知书柜号已经添加!");
				return;
			}else{
				// 添加
				$(grid_selector_select).jqGrid("addRowData", null, data, "last");
			}
		}
	}

	// 删除
	function delfunc() {
		var selectedRowIds = $(grid_selector_select).jqGrid("getGridParam",
				"selarrrow");
		if (selectedRowIds == null || selectedRowIds == "") {
			alert("请选择一行数据！");
			return;
		} else {
			var len = selectedRowIds.length;
			for (var i = 0; i < len; i++) {
				$(grid_selector_select).jqGrid("delRowData", selectedRowIds[0]);
			}
		}
	}

	//选择信息确认
	function confirm() {
		var data = $(grid_selector_select).jqGrid("getRowData");
		// 判断是否选了数据
		if (!data.length > 0) {
			swal("", "请至少勾选一条记录！", "warning");
			return;
		}
		// 关闭当前窗口
		window.close();
		//上传确定，后的回调处理
		if (window.showModalDialog) {//支持showModalDialog函数
			window.returnValue = data;
		} else {//新版chrome不支持showModalDialog函数
			if (window.openerCallBack
					&& typeof (window.openerCallBack) === "function") {
				// 调用父窗口的方法
				window.openerCallBack(data);
			}
		}
	}
</script>
</html>