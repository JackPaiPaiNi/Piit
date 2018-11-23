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
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出
						</button>
						&nbsp;
						<button id="btn-tbwljg" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							同步
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料编号&nbsp;&nbsp;</label>
										<input type="text" name="wlbh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">更新时间&nbsp;&nbsp;</label>
										<input type="text" name="gxsj" class="form-control date-picker"/>
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
	<shiro:hasPermission name="price:materialPrice:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			url: "<c:url value='/price/materialPrice/search'/>",
			editurl: "<c:url value='/price/materialPrice/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:80, formoptions:{rowpos: 2, colpos: 1}},
				{name:'dj', index:'dj', label:'单价（RMB）', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ',', decimalPlaces: 4}, formoptions:{rowpos: 2, colpos: 2}},
				{name:'djUsd', index:'djUsd', label:'单价（USD）',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ',', decimalPlaces: 4}, width:80, formoptions:{rowpos: 3, colpos: 1}},
				{name:'djHkd', index:'djHkd', label:'单价（HKD）',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ',', decimalPlaces: 4}, width:80, formoptions:{rowpos: 3, colpos: 2}},
				{name:'gxsj', index:'gxsj', label:'更新时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 4, colpos: 1}},
				{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true, editable:false}
			]
		},{
			add:false,
			edit:false,
			del:false
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/price/materialPrice/export'/>"});
	    			}
	    		});
	        }
		});
		//同步物料价格数据
		$("#btn-tbwljg").click(function(){
        	$("body").bindSweetAlert({
    			title:"确定要同步吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$.bindAjax({
						url:"<c:url value='/price/materialPrice/tbwljg'/>",
						action:"edit"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
    			}
    		});
		});
		
	});
</script>
</html>