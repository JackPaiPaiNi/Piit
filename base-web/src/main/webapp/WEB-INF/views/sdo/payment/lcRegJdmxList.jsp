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
						&nbsp;
						<button id="export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出
						</button>
				
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
								<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">信用证号&nbsp;&nbsp;</label>
										<input type="text" name="lcbh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
										<input type="text" name="fph" class="form-control"/>
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
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
										<input type="text" name="xsymc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船务专员&nbsp;&nbsp;</label>
										<input type="text" name="cwymc" class="form-control"/>
									</div>
								</div>
							</div>
						</form>
						<div class="space-4"></div>
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
	<shiro:hasPermission name="payment:lcReg:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/payment/lcReg/searchJdmx'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:100},
				{name:'lcbh', index:'lcbh', label:'信用证号', width:150},
				{name:'fph', index:'fph', label:'发票号', width:150},
				{name:'fpje', index:'fpje', label:'发票金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'fprq', index:'fprq', label:'发票日期', width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'fpbz', index:'fpbz', label:'发票币种', width:80},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号',  width:100},
				{name:'ddid', index:'ddid', label:'订单号',  width:100},
				{name:'qymc', index:'qymc', label:'区域名称', width:80},
				{name:'xsymc', index:'xsymc', label:'销售员', width:100},
				{name:'cwymc', index:'cwymc', label:'船务专员', width:100},
				{name:'wjjryhrq', index:'wjjryhrq', label:'文件寄入银行日期',  width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'tzhsdwjrq', index:'tzhsdwjrq', label:'通知行收到文件日期', width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'etdkcrq', index:'etdkcrq', label:'ETD开船日期', width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'tzhjdrq', index:'tzhjdrq', label:'通知行寄单日期',  width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'gzhm', index:'gzhm', label:'跟踪号码', width:140},
				{name:'lcbfxx', index:'lcbfxx', label:'L/C不符信息', width:140},
				{name:'dqfkr', index:'dqfkr', label:'到期付款日',  width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'sfyhk', index:'sfyhk', label:'是否已回款', width:140},
				{name:'hkje', index:'hkje', label:'回款金额', width:140},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:80}
			],
			sortname: 'lcbh',
			sortorder: 'asc'
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		}).jqGrid('setFrozenColumns');
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		$("#export").click(function(){
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/lcReg/jdmxExport'/>"});
	    			}
	    		});
	        }
		});
	
	});
	
</script>
</html>