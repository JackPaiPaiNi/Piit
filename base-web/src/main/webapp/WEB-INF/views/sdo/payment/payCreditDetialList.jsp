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
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PI号&nbsp;&nbsp;</label>
										<input type="text" name="piid" class="form-control"/>
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
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">付款条件&nbsp;&nbsp;</label>
										<input type="text" name="fktj" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">节点&nbsp;&nbsp;</label>
										<input type="text" name="jd" class="form-control"/>
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
	<shiro:hasPermission name="payment:payCreditDetial:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(grid_selector).bindTable({
			url: "<c:url value='/payment/payCreditDetial/search'/>",
			editurl: "<c:url value='/payment/payCreditDetial/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'ddid', index:'ddid', label:'订单号', width:100},
				{name:'piid', index:'piid', label:'PI号', width:100},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100},
				{name:'khbm', index:'khbm', label:'客户编码', width:100},
				{name:'khmc', index:'khmc', label:'客户名称', width:120, hidden: true, editrules:{edithidden:true}},
				{name:'fktj', index:'fktj', label:'付款条件', width:80},
				{name:'jd', index:'jd', label:'节点', width:80},
				{name:'fklx', index:'fklx', label:'付款类型', width:100},
				{name:'lcKzh', index:'lcKzh', label:'LC开证行', width:80},
				{name:'lcKzhmc', index:'lcKzhmc', label:'LC开证行名称', width:80},
				{name:'pije', index:'pije', label:'PI金额', width:80},
				{name:'je', index:'je', label:'金额', width:80},
				{name:'tpje', index:'tpje', label:'特批金额', width:80},
				{name:'bz', index:'bz', label:'币种', width:80},
				{name:'sj', index:'sj', label:'时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'tpdh', index:'tpdh', label:'特批单号', width:80},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:80},
				{name:'edbz', index:'edbz', label:'额度币种', width:80},
				{name:'edje', index:'edje', label:'额度金额', width:80},
				{name:'ydEdHl', index:'ydEdHl', label:'原单到额度汇率', width:80}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/payCreditDetial/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
</script>
</html>