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
						&nbsp;
						<button id="export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt  btn-success icon-on-right"></i>
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
											<label class="input-group-addon">付款条件代码&nbsp;&nbsp;</label> <input
												type="text" name="fktjdm" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">付款条件描述&nbsp;&nbsp;</label> <input
												type="text" name="fktjms" class="form-control" />
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
	<shiro:hasPermission name="payment:payTerm:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/payment/payTerm/search'/>",
			editurl: "<c:url value='/payment/payTerm/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'fktjdm', index:'fktjdm', label:'付款条件代码', width:70},
				{name:'fktjms', index:'fktjms', label:'付款条件描述', width:180},
				{name:'xdTt', index:'xdTt', label:'下单时TT', width:70,formatter:percentFormat,unformat:unPercentFormat},
				{name:'ckTt', index:'ckTt', label:'出库时TT', width:70,formatter:percentFormat,unformat:unPercentFormat},
				{name:'xdLc', index:'xdLc', label:'下单时LC', width:70,formatter:percentFormat,unformat:unPercentFormat},
				{name:'xdOa', index:'xdOa', label:'下单时OA', width:70,formatter:percentFormat,unformat:unPercentFormat},
				{name:'xdDp', index:'xdDp', label:'下单时DP', width:70,formatter:percentFormat,unformat:unPercentFormat},
				{name:'zq', index:'zq', label:'账期', width:70}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit
		});
	
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
	        	$("body").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/payTerm/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	function percentFormat(cellValue){
		if(cellValue != null && cellValue != ""){
			return (cellValue*100).toFixed(0)+"%";
		}else{
			return "";
		}		
	}
	function unPercentFormat(cellValue){
		if(cellValue != null && cellValue != ""){
			var value = cellValue.replace("%","");
			value = parseFloat(value)/100;
			return value;
		}else{
			return "";
		}
	}
</script>
</html>