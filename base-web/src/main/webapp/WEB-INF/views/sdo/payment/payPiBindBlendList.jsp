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
							<i class="icon-search  btn-info icon-on-right"></i>
							查询
						</button>
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i> 导出
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PI号&nbsp;&nbsp;</label>
										<input type="text" name="piid" class="form-control"/>
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
										<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">付款类型&nbsp;&nbsp;</label>
											<input type="text" name="fklx" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">节点&nbsp;&nbsp;</label>
											<input type="text" name="jd" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">认领单号/LC编号&nbsp;&nbsp;</label>
										<input type="text" name="dh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款单号&nbsp;&nbsp;</label>
										<input type="text" name="skdh" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
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
	var isEdit = false;
	 <shiro:hasPermission name="payment:payPiBindBlend:edit"> isEdit=true;</shiro:hasPermission> 
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/payment/payPiBindBlend/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'piid', index:'piid', label:'PI号', width:100},
				{name:'ddid', index:'ddid', label:'订单号', width:100},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:200},
				{name:'fph', index:'fph', label:'发票号', width:160},
				{name:'fklx', index:'fklx', label:'付款类型', width:80},
				{name:'jd', index:'jd', label:'节点', width:80},
				{name:'bz', index:'bz', label:'币种', width:80},
				{name:'syje', index:'syje', label:'使用金额', width:80},
				{name:'dh', index:'dh', label:'认领单/LC编号', width:120},
				{name:'bdje', index:'bdje', label:'绑定金额', width:80},
				{name:'gdje', index:'gdje', label:'勾兑金额', width:80},
				{name:'skdh', index:'skdh', label:'收款单号', width:80},
				{name:'skbzxx', index:'skbzxx', label:'收款备注信息', width:100},
				{name:'ye', index:'ye', label:'余额', width:80, hidden: true},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:80},
			/* 	{name:'zdrid', index:'zdrid', label:'勾兑人', width:80}, */
				{name:'zdrmc', index:'zdrmc', label:'勾兑人', width:80},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'gdsj', index:'gdsj', label:'勾兑时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'sfZdgd', index:'sfZdgd', label:'是否自动勾兑', width:100, edittype:"select", formatter: "select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}}
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
		

		$("#btn-export").click(function(){
		    var curNum=$(grid_selector).getGridParam("records");
		    if(curNum==0){ 
	            swal("","结果集为空不能导出","warning");
	            return false;
	        }else{
	        	$("body").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcelNoData({url: "<c:url value='/payment/payPiBindBlend/export'/>"});
	    			}
	    		});
	        }
		});
	});
	
</script>
</html>