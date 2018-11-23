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
						<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出货通知书单号&nbsp;&nbsp;</label>
										<input type="text" name="chdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">公司&nbsp;&nbsp;</label>
										<input type="text" name="gsbm" class="form-control"/>
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
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('WKPZT')}
										</select>
									</div>
								</div>
							</div>
							<div class='space-4'></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船务单证人员&nbsp;&nbsp;</label>
										<input type="text" name="cwkpr" value="${user.userName}" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<input type="text"   id="zdsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出运类型&nbsp;&nbsp;</label>
										<select role="select" name="cylx" size="1" class="form-control skyselect">
											${fns:loadDictOption('CYLX')}
										</select>
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
	<shiro:hasPermission name="invoice:invoicenew:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$("#zdsj").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(".skyselect").select2();

		$("#form-search [name=zt]").select2("val",1);
		
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/invoice/invoicenew/WkptjSearch'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: form_search,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'gsbm', index:'gsbm', label:'公司', width:40},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100},
				{name:'chdh', index:'chdh', label:'出货通知书单号', width:110},
				{name:'chztmc', index:'chztmc', label:'出货通知书状态', width:110},
				{name:'ddid', index:'ddid', label:'订单号', width:90},
				{name:'fph', index:'fph', label:'发票号', width:130},	
				{name:'cylxmc', index:'cylxmc', label:'出运类型', width:130},	
			 	{name:'zgrq', index:'zgrq', label:'装柜日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}}, 
			 	{name:'zdsj', index:'zdsj', label:'出货通知书时间', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
			 	{name:'xwgjmc', index:'xwgjmc', label:'目的国家', width:100},
			 	{name:'cwkprmc', index:'cwkprmc', label:'船务单证专员', width:100},
				{name:'zdrmc', index:'zdrmc', label:'船务操作专员', width:100},
				{name:'ztmc', index:'ztmc', label:'状态', width:80},
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:105, formatter:tsSAPCellAddHref},
				{name:'xsymc', index:'xsymc', label:'销售员', width:60},
				{name:'jhdh', index:'jhdh', label:'交货单号', width:140},
				{name:'khbm', index:'khbm', label:'客户编码', width:90},
				{name:'khmc', index:'khmc', label:'客户名称', width:120},
			]
		},{
			add:false,
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/invoice/invoicenew/Wkptjexport'/>"});
	    			}
	    		});
	        }
		});
		
	});
	
	function tsSAPCellAddHref(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html = "已通过";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		}
		return html;
	}

</script>
</html>