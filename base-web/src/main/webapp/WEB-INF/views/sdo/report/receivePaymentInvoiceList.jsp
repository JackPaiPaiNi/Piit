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
							<i class="icon-search icon-on-right bigger-110"></i>
							查询
						</button>
 						&nbsp;
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							导出
						</button>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
					<form id="form-search" name="form-search" class="form-search">
                         <div class="row">
                         	<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">认领单号&nbsp;&nbsp;</label>
									<input type="text" name="rldh" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收款单号&nbsp;&nbsp;</label>
									<input type="text" name="skdh" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户&nbsp;&nbsp;</label>
									<input type="text" name="khmc" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
									<input type="text" name="fph" class="form-control"/>
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
	$(function($) {
		//$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			url: "<c:url value='/report/receivePaymentInvoice/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			rowNum:20,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'rldh', index:'rldh', label:'认领单号', width:110, frozen:true},    
				{name:'skdh', index:'skdh', label:'收款单号', width:100, frozen:true},
                {name:'khbm', index:'khbm', label:'客户编码', width:100, frozen:true},    
                {name:'khmc', index:'khmc', label:'客户名称', width:140},
                {name:'fph', index:'fph', label:'发票号', width:160},
                {name:'fpbz', index:'fpbz', label:'发票币种', width:70},
                {name:'fpzje', index:'fpzje', label:'发票金额', width:70},
                {name:'ddid', index:'ddid', label:'订单号', width:110},
                {name:'fprq', index:'fprq', label:'发票日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
                {name:'fpdqr', index:'fpdqr', label:'发票到期日', width:100},
                {name:'ddzje', index:'ddzje', label:'订单总金额', width:80},
                {name:'ddkpje', index:'ddkpje', label:'订单开票金额', width:90},
                {name:'ddsykkpje', index:'ddsykkpje', label:'剩余可开票金额', width:100},
                {name:'hkje', index:'hkje', label:'回款金额', width:70},
                {name:'ddychwsk', index:'ddychwsk', label:'订单已出货未收款', width:120},
				{name:'fktjmc', index:'fktjmc', label:'付款条件', width:100}
			
			]
		},{
			add:false,
			edit:false,
			del:false
		}).jqGrid('setFrozenColumns');
		//敲击回车响应查询
		$("body").keypress(function (e) {
			var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if (keyCode == 13){
				$(grid_selector).trigger("reloadGrid");
			}
		}); 
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		$("#btn-export").click(function(){
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/report/receivePaymentInvoice/export'/>"});
	    			}
	    		});
	        }
		});
	})
</script>
</html>