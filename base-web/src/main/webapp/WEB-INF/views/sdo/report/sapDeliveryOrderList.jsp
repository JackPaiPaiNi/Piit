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
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出货通知书单号&nbsp;&nbsp;</label>
										<input type="text" name="chdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">实际发货日期&nbsp;&nbsp;</label>
										<input type="hidden" id="beginSjfhrq" name="beginSjfhrq"/>
										<input type="hidden" id="endSjfhrq" name="endSjfhrq"/>
										<input type="text" id="sjfhrq" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
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
										<label class="input-group-addon">交货单号&nbsp;&nbsp;</label>
										<input type="text" name="jhdh" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
										<input type="text" name="fph" class="form-control"/>
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
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船务开票人&nbsp;&nbsp;</label>
										<input type="text" name="cwkpr" class="form-control"/>
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
	$("#sjfhrq").bindDateRange({startElement:$("#beginSjfhrq"),endElement:$("#endSjfhrq")});
	$(function($) {
		$(".skyselect").select2();
		$(grid_selector).bindTable({
			url: "<c:url value='/report/sapDeliveryOrder/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			rowNum:20,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60},
				{name:'chdh', index:'chdh', label:'出货通知书单号', width:110},
				{name:'cwzymc', index:'cwzymc', label:'船务专员', width:80},
				{name:'sjfhrq', index:'sjfhrq', label:'实际发货日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'ddid', index:'ddid', label:'订单号', width:90},
				{name:'jhdh', index:'jhdh', label:'交货单号', width:90},
				{name:'fph', index:'fph', label:'发票号', width:120},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:140},
				{name:'jhsl', index:'jhsl', label:'交货数量', width:70},
				{name:'wldw', index:'wldw', label:'物料单位', width:70},
				{name:'wlms', index:'wlms', label:'物料描述', width:120},
				{name:'xmlb', index:'xmlb', label:'项目类别', width:70, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('XMLB')}"}},
				{name:'dj', index:'dj', label:'销售单价', width:70},
				{name:'jgdw', index:'jgdw', label:'价格单位', width:70},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:90,formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'ddhjje', index:'ddhjje', label:'订单合计金额', width:100},
				{name:'tssapzt_syfp', index:'tssapzt_syfp', label:'推送商业发票状态', width:100, formatter:tsSAPCellAddHref_syfp},
				{name:'tssapzt_gsjfp', index:'tssapzt_gsjfp', label:'推送公司间发票状态', width:100, formatter:tsSAPCellAddHref_gsjfp},
				{name:'fpje', index:'fpje', label:'发票金额', width:100},
				{name:'zdrmc', index:'zdrmc', label:'发票制单人', width:100},
				{name:'khbm', index:'khbm', label:'客户编码',hidden: true, width:100},
				{name:'khmc', index:'khmc', label:'客户名称', width:100},
				{name:'cwkprmc', index:'cwkprmc', label:'船务开票人', width:100}
			]
		},{
			add:false,
			edit:false,
			del:false
		});
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
		
		$("#btn-export").click(function(){
			var param = $("#form-search").getFormData();
			if(param.chdh == "" && param.ddid == "" && param.jhdh == "" && param.fph == "" ){
				if(param.beginSjfhrq=="" || param.endSjfhrq==""){
					 swal("警告","数据量大，请输入实际发货日期!","warning");
					 return ;
				}
				if(param.beginSjfhrq.substring(0,7) != param.endSjfhrq.substring(0,7)){
					 swal("警告","数据量大，实际发货日期不能跨月!","warning");
					 return ;
				}
			}
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/report/sapDeliveryOrder/export'/>"});
	    			}
	    		});
	        }
		});
		
		//查看推送SAP日志
		function tsSAPCellAddHref_syfp(cellvalue, options, rowData){
			var html = "";
			if(cellvalue == "1"){
				html += "已通过";
			} else if(cellvalue == "0"){
				html += "未通过";
			}else if(cellvalue == "2"){
				html += "已冲销";
			} else {
				html = "";
			}
			return html;
		}
		
		function tsSAPCellAddHref_gsjfp(cellvalue, options, rowData){
			var html = "";
			if(cellvalue == "1"){
				html += "已通过";
			} else if(cellvalue == "0"){
				html += "未通过";
			}else if(cellvalue == "2"){
				html += "已冲销";
			}else if(cellvalue == "3"){
				html += "不需要推";
			} else {
				html = "";
			}
			return html;
		}
	});
</script>
</html>