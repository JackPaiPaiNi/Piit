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
				
			<div id="search-box"  class="widget-box">
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
						<button id="export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							导出
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
									<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单类型&nbsp;&nbsp;</label>
										<select  role="select" name="ddlx" size="1" class="form-control skyselect">
											${fns:loadDictOption('DDLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单类别&nbsp;&nbsp;</label>
										<select  role="select" name="ddlb" size="1" class="form-control skyselect">
											${fns:loadDictOption('DDLB_DH')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">走货方式&nbsp;&nbsp;</label>
										<select  role="select" name="zhfs" size="1" class="form-control skyselect">
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
	<shiro:hasPermission name="track:trackStepDayDeadline:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		  $(".skyselect").select2();
		$(grid_selector).bindTable({
			url: "<c:url value='/track/trackStepDayDeadline/search'/>",
			editurl: "<c:url value='/track/trackStepDayDeadline/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false,formoptions:{rowpos: 1, colpos: 1},frozen : true,},
				{name:'ddlx', index:'ddlx', label:'订单类型', width:80,formoptions:{rowpos: 2, colpos: 1},frozen : true,
				 edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('DDLX')}",dataInit: initSelect2}},
				{name:'ddlb', index:'ddlb', label:'订单类别', width:80,formoptions:{rowpos: 2, colpos: 2},frozen : true,
				 edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('DDLB_DH')}",dataInit: initSelect2}},
				{name:'zhfs', index:'zhfs', label:'走货方式', width:80,formoptions:{rowpos: 2, colpos: 3},frozen : true,
			     edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('ZHFS')}",dataInit: initSelect2}},
				{name:'khlx', index:'khlx', label:'客户类型', width:80,formoptions:{rowpos: 3, colpos: 1},frozen : true,
		    	 edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('KHLX')}",dataInit: initSelect2}},
		    	{name:'xwgj', index:'xwgj', label:'销往国家', width:80,formoptions:{rowpos: 3, colpos: 2},frozen : true,
		         edittype:"select", formatter:"select", editoptions:{value:"${fns:loadCountryOption('1')}",dataInit: initSelect2}},
		        {name:'sfxp', index:'sfxp', label:'是否新品', width:80,formoptions:{rowpos: 3, colpos: 3},frozen : true,
			         edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}",dataInit: initSelect2}},
		        {name:'xd', index:'xd', label:'下单', width:80,formoptions:{rowpos: 4, colpos: 1},align:'right'},
		    	{name:'ddsp', index:'ddsp', label:'订单审批', width:80,formoptions:{rowpos: 4, colpos: 2},align:'right'}, 
		    	{name:'scddxd', index:'scddxd', label:'生产订单下达', width:80,formoptions:{rowpos: 4, colpos: 3},align:'right'}, 
		    	{name:'ycps', index:'ycps', label:'一次评审', width:80,formoptions:{rowpos: 5, colpos: 1},align:'right'}, 
		    	{name:'mgqr', index:'mgqr', label:'美工确认', width:80,formoptions:{rowpos: 5, colpos: 2},align:'right'}, 
		    	{name:'ddzgd', index:'ddzgd', label:'订单转工单', width:80,formoptions:{rowpos: 5, colpos: 3},align:'right'},
				{name:'rjqr', index:'rjqr', label:'软件确认', width:80,formoptions:{rowpos: 6, colpos: 1},align:'right'},
				{name:'scjhwc', index:'scjhwc', label:'生产计划完成', width:80,formoptions:{rowpos: 6, colpos: 2},align:'right'},
				{name:'yzhcj', index:'yzhcj', label:'预走货创建', width:80,formoptions:{rowpos: 6, colpos: 3},align:'right'},
				{name:'yzhwc', index:'yzhwc', label:'预走货完成', width:80,formoptions:{rowpos: 7, colpos: 1},align:'right'},
				{name:'rk', index:'rk', label:'入库', width:80,formoptions:{rowpos: 7, colpos: 2},align:'right'},
			    {name:'ck', index:'ck', label:'出库', width:80,formoptions:{rowpos: 7, colpos: 3},align:'right'}
				 /*{name:'bg', index:'bg', label:'报关', width:80,formoptions:{rowpos: 8, colpos: 1},align:'right'},
				{name:'cy', index:'cy', label:'出运', width:80,formoptions:{rowpos: 8, colpos: 2},align:'right'},
				{name:'sjsh', index:'sjsh', label:'散件收货', width:80,formoptions:{rowpos: 8, colpos: 3},align:'right'},
				{name:'zjsh', index:'zjsh', label:'整机收货', width:80,formoptions:{rowpos: 9, colpos: 1},align:'right'} */
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/track/trackStepDayDeadline/export'/>"});
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