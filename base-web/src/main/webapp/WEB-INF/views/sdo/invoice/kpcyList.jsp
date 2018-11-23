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
					<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出
					</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
						    <input type="hidden" name="ddids" value="<%=request.getParameter("ddids") %>">
				    	    <input type="hidden" name="chdhs" value="<%=request.getParameter("chdhs")  %>">
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
	var form_search = "#form-search" ;
	$(function($) {
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/invoice/invoicenew/searchKpcy'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: form_search,
			shrinkToFit: true,
			autoScroll: true,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'ddid', index:'ddid', label:'订单ID', width:80,align:'right'},
				{name:'jhdje', index:'jhdje', label:'交货单金额', width:80,align:'right'},
				{name:'chdhje', index:'chdhje', label:'出货通知书金额', width:80,align:'right'},
				{name:'cyje', index:'cyje', label:'差异金额', width:80,align:'right'}]
		},{ add:false,
			edit:false,
			view:false,
			del:false
		});
		// 查询
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/invoice/invoicenew/exportKpcy'/>"});
	    			}
	    		});
	        }
		}); 
		
	});

</script>
</html>