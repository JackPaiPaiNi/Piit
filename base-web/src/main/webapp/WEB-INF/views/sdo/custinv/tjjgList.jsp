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
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">调价对象&nbsp;&nbsp;</label>
										<select role="select" name="tjdx" size="1" class="form-control skyselect">
											<option value="0" selected="selected">全部</option>
											<option value="1">装柜清单</option>
											<option value="2">交货单</option>
										</select>
									</div>
								</div>	
							<!--  	<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">订单号&nbsp;&nbsp;</label>
										<input type="text" id="ddid" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">客户编码&nbsp;&nbsp;</label>
										<input type="text" id="khbm" name="khbm" class="form-control"/>
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
			url: "<c:url value='/custinv/tjjg/search'/>",
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
			sortname:'dj_tz',
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
				{name:'dw', index:'dw', label:'单位', width:80},
				{name:'jgkdj', index:'jgkdj', label:'价格库单价', width:100, align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:6}},				
				{name:'jgkje', index:'jgkje', label:'金额', width:120, align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:2}},
				{name:'tzdj', index:'tzdj', label:'调整单价', width:100, align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:6}},				
				{name:'tzje', index:'tzje', label:'调整后金额', width:120, align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:2}},
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
	});
</script>
</html>