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
	var searchdburl = "<c:url value='/payment/payPiBindBlend/searchDb'/>";
	var gdurl = "<c:url value='/payment/payPiBindBlend/blendAuto'/>";
	/* 
	<shiro:hasPermission name="payment:payPiBindBlend:edit"> isEdit=true;</shiro:hasPermission> */
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
	/* 	$(grid_selector).bindTable({
			caption: "",
			url:searchdburl,
			pager:pager_selector,
			gridParent: "#grid-parent",
			formSearch:"#form-search",
			autoScroll: false,
			multiselect: true,
			//shrinkToFit: false,
			//autoScroll: false,
			//autoheight:true,
			//extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'piid', index:'piid', label:'PI号', width:100},
				{name:'ddid', index:'ddid', label:'订单号', width:100},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100},
				{name:'fklx', index:'fklx', label:'付款类型', width:80},
				{name:'jd', index:'jd', label:'节点', width:80},
				{name:'bz', index:'bz', label:'币种', width:80},
				{name:'syje', index:'syje', label:'使用金额', width:80},
				{name:'gddh', index:'gddh', label:'勾兑单号', width:150},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		}); */
		
		$(grid_selector).bindTable({
			caption: "",
			url: searchdburl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			autoScroll: false,
			multiselect: true,
			//rowList: [5],
			rowNum: 20,
			colModel: [
						{name:'id', label:'ID', hidden: true, width:60, editable:false},
						{name:'piid', index:'piid', label:'PI号', width:100},
						{name:'ddid', index:'ddid', label:'订单号', width:100},
						{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100},
						{name:'fklx', index:'fklx', label:'付款类型', width:80},
						{name:'jd', index:'jd', label:'节点', width:80},
						{name:'bz', index:'bz', label:'币种', width:80},
						{name:'syje', index:'syje', label:'使用金额', width:80},
						{name:'gddh', index:'gddh', label:'勾兑单号', width:150},
						{name:'zdsj', index:'zdsj', label:'制单时间', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
					]
		},{
			add:false,
			edit:false,
			del:false,
			view:false,
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"自动勾兑", 
			buttonicon:"fa-pencil-square blue", 
			onClickButton: function(){
				var data = $(grid_selector).jqGrid("getGridParam","selarrrow");
				// 判断是否选了数据
				if(!data.length > 0){
					swal("","请至少勾选一条记录！","warning");
					return;
				}
				// 循环处理选中数据（可多选）
				var piids = "";
				for(var i=0; i<data.length; i++){
					var rowData = $(grid_selector).jqGrid("getRowData",data[i]);
					piids = piids + "," + rowData.piid;
				}
				if(piids != ""){
					piids = piids.substring(1);
				}
				$("body").bindSweetAlert({
					title : "确定要勾兑吗?"
				},{
					callback : function() {
						$.bindAjax({
							url : gdurl,
							data:{piids : piids},
							action:"save"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
			},
			position:"last"
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
	    				$(grid_selector).exportExcelNoData({url: "<c:url value='/payment/payPiBindBlend/exportDb'/>"});
	    			}
	    		});
	        }
		});
	});
</script>
</html>