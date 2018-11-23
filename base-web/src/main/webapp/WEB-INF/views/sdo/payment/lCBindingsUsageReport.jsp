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
							<input type ="hidden" value ="9" name ="lx">
						</div>	
					</form>
				</div>	
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
		extraheight:$('#search-box').height(),
		editTable:false,
		rowNum : 20,
		colModel: [
			{name:'lcbh', index:'lcbh', label:'L/C号'},
			{name:'bz', index:'bz', label:'币种'},
			{name:'je', index:'je', label:'L/C金额'},
			{name:'lc_ybd', index:'lc_ybd', label:'已绑定金额'},
			{name:'lc_wbd', index:'lc_wbd', label:'未绑定金额'}
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