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
					<form id="form-search" name="form-search" class="form-search">
                         <div class="row">
							<input type ="hidden" value ="16" name ="lx">
						</div>	
					</form>
				</div>
			</div>
			<div class="space-4"></div>
			<div id="grid-table-div">
			    <table id="grid-table"></table>
			</div>
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
	$(".date-picker").bindYearMonth();
	/**************************************************编辑表初始化开始区域************************************************/
	var gridTable = $(grid_selector).bindTable({
		url:"<c:url value='/payment/reports/searchReport'/>",
		pager: pager_selector,
		gridParent: "#grid-parent",
		formSearch: "#form-search",
		autoheight:true,
		extraheight:$('#search-box').height()+5,
		editTable:false,
		rowNum : 20,
		colModel: [
			{name:'ywzmc', index:'ywzmc', label:'区域'},
			{name:'xsymc', index:'xsymc', label:'业务员'},
			{name:'khmc', index:'khmc', label:'客户'},
			{name:'khbm', index:'khbm', label:'客户编码'},
			{name:'bz', index:'bz', label:'币种'},
			{name:'ddje', index:'ddje', label:'订单金额'},
			{name:'fpje', index:'fpje', label:'开票金额'},
			{name:'yhkje', index:'yhkje', label:'已回款金额'},
			{name:'whkje', index:'whkje', label:'未回款金额'},
			{name:'tpwxcje', index:'tpwxcje', label:'特批未消除金额'}
		]
	},{
		add:false,
		edit:false,
		del:false,
		view:false
	});
	/**************************************************编辑表初始化开始区域************************************************/	
	
	/**************************************************function开始区域************************************************/	

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
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/reports/export'/>"});
	    			}
	    		});
	        }
		});
	//查询
	$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
    });
	});
	/**************************************************function結束区域************************************************/	
</script>
</html>