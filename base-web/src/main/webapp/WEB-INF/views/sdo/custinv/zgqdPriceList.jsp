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
				
			<div  id="search-box" class="widget-box">
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
					   &nbsp;
						<button id="btn-compute-zgqd1" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-ok icon-on-right"></i>
							计算装柜清单价格（方案一）
						</button>
						&nbsp;
						<button id="btn-compute-zgqd2" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-ok icon-on-right"></i>
							计算装柜清单价格（方案二）
						</button>
						&nbsp;
						<button id="btn-compute-jhd" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-ok icon-on-right bigger-110"></i>
							计算SAP交货单价格
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">		
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">出货通知书单号&nbsp;&nbsp;</label>
										<input type="text" name="chdh" id="chdh" class="form-control"/>
									</div>
								</div>	
								<!-- <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">订单号&nbsp;&nbsp;</label>
										<input type="text" id="ddid" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">物料编号&nbsp;&nbsp;</label>
										<input type="text" id="wlbh" name="wlbh" class="form-control"/>
									</div>
								</div> -->
							</div>
						</form>
					</div>
				</div>
			</div>
			
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
	
	$(function($) {
		$(grid_selector).bindTable({
			url: "<c:url value='/custinv/zgqdPrice/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			rowList : [50, 100, 200, 500, 1000, 2000],
			rowNum: 50,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			multiselect: true,
			multiboxonly: true,
			sortname:'dj',
			sortorder:'desc',
			colModel: [
				{name:'id', index:'id', label:'ID', hidden:true},
				{name:'chdh', index:'chdh', label:'出货通知书单号', width:110},
				{name:'ddid', index:'ddid', label:'订单号', width:90},
				{name:'khbm', index:'khbm', label:'客户编码', width:90},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:150},
				{name:'wlms', index:'wlms', label:'物料描述', width:220},
				{name:'sl', index:'sl', label:'数量', width:90, align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:0}},
				{name:'bz', index:'bz', label:'币种', width:80},
				{name:'dj', index:'dj', label:'单价', width:100, align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:6}},
				{name:'dw', index:'dw', label:'单位', width:80},
				{name:'ddje', index:'ddje', label:'订单金额', width:120, align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:2}},
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});

		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		$('#btn-compute-zgqd1').click(function(){
			var ids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
			var ddwls = [];
			$.each(ids, function(i, n){
				var rowData = $(grid_selector).jqGrid("getRowData", n);
				ddwls.push(rowData.ddid + "|" + rowData.wlbh);
			});
			//alert(wlbhs.join(","));
			var chdh = $("#form-search [name=chdh]").val();
			var wlbhs = ddwls.join(",");
			$.post("<c:url value='/custinv/zgqdPrice/zgqdAdjust1'/>",{chdh:chdh, wlbhs:wlbhs}, function(result){
				swal(result.resultMsg);
			}, "json");
		});
		
		$('#btn-compute-zgqd2').click(function(){
			var ids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
			var ddwls = [];
			$.each(ids, function(i, n){
				var rowData = $(grid_selector).jqGrid("getRowData", n);
				ddwls.push(rowData.ddid + "|" + rowData.wlbh);
			});
			//alert(wlbhs.join(","));
			var chdh = $("#form-search [name=chdh]").val();
			var wlbhs = ddwls.join(",");
			$.post("<c:url value='/custinv/zgqdPrice/zgqdAdjust2'/>",{chdh:chdh, wlbhs:wlbhs}, function(result){
				swal(result.resultMsg);
			}, "json");
		});
		
		$("#btn-compute-jhd").click(function(){
			var chdh = $("#form-search [name=chdh]").val();
			$.post("<c:url value='/custinv/zgqdPrice/jhdAdjust'/>",{chdh:chdh}, function(result){
				swal(result.resultMsg);
			}, "json");
	    });
	});
</script>
</html>