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
										<label class="input-group-addon">国家&nbsp;&nbsp;</label>
										<select role="select" name="gj" size="1" class="form-control skyselect">
											
											${fns:loadCountryOption('0')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">走货方式&nbsp;&nbsp;</label>
										<select role="select" name="zhfs" size="1" class="form-control skyselect">
											
											${fns:loadDictOption('ZHFS')}
										</select>
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
	<shiro:hasPermission name="mdm:shippmentDays:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/mdm/shippmentDays/search'/>",
			editurl: "<c:url value='/mdm/shippmentDays/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:50, editable:false},
				{name:'gj', index:'gj', label:'国家', width:200, edittype:"select", formatter:"select", 
					editoptions:{value:"${fns:loadCountryOption('1')}",dataInit: initSelect2}, formoptions:{rowpos: 1, colpos: 1}},
				{name:'zhfs', index:'zhfs', label:'走货方式', width:180, edittype:"select", formatter:"select", 
					editoptions:{value:"${fns:loadDictEditOption('ZHFS')}",dataInit: initSelect2}, formoptions:{rowpos: 1, colpos: 2}},
				{name:'bgts', index:'bgts', label:'报关天数',align:'right', width:180, formoptions:{rowpos: 2, colpos: 1}},
				{name:'hsts', index:'hsts', label:'海上天数',align:'right', width:180, formoptions:{rowpos: 2, colpos: 2}},
				{name:'qgts', index:'qgts', label:'清关天数',align:'right', width:180, formoptions:{rowpos: 3, colpos: 1}},
				{name:'wxgcts', index:'wxgcts', label:'外协工厂天数',align:'right', width:180, formoptions:{rowpos: 3, colpos: 2}}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/order/shippmentDays/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	
	function initSelect2(elem){
		$(elem).width(140).select2();
	}
</script>
</html>