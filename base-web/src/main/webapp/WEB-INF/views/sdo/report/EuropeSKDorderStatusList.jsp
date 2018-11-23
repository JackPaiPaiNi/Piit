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
						&nbsp;
						<button id="btn-import" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload icon-on-right bigger-110"></i>
							导入
						</button>
					 	&nbsp;	
						<button id="btn-download" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							下载模板
						</button>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
					<form id="form-search" name="form-search" class="form-search">
                         <div class="row">
                         		<input type="hidden" name="level"/>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<!-- <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div> -->
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
	$(function($) {
		//$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			url: "<c:url value='/report/skdOrderStatus/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			rowNum:20,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'ddid', index:'ddid', label:'订单号', width:100, frozen:true},
				//{name:'bbh', index:'bbh', label:'', width:100},
				{name:'khbm', index:'khbm', label:'客户编码', width:100},
				{name:'khmc', index:'khmc', label:'客户名称', width:100},
				{name:'zzkhm', index:'zzkhm', label:'最终客户名', width:100},
				//{name:'zhfs', index:'zhfs', label:'走货方式', width:100},
				{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80},
				//{name:'gjmytk', index:'gjmytk', label:'贸易条款', width:100},
				{name:'gjmytkmc', index:'gjmytkmc', label:'贸易条款', width:80},
				{name:'pid', index:'pid', label:'PID', width:160},
				{name:'jixin', index:'jixin', label:'机芯', width:80},
				{name:'jixing', index:'jixing', label:'机型', width:80},
				{name:'ccyq', index:'ccyq', label:'尺寸', width:60, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name:'mjxh', index:'mjxh', label:'客户型号', width:100},
				{name:'pp', index:'pp', label:'客户品牌', width:80},
				//{name:'xwgj', index:'xwgj', label:'销往国家', width:100},
				{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:100},
				{name:'zsj', index:'zsj', label:'订单总数量', width:80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name:'dtjgf', index:'dtjgf', label:'单台加工费', width:80, align:'right', formatter:'number', formatoptions:{thousandsSeparator:','}},
				{name:'jgfhj', index:'jgfhj', label:'加工费合计', width:80, align:'right', formatter:'number', formatoptions:{thousandsSeparator:','}},
				{name:'dj', index:'dj', label:'订单单价', width:80, align:'right', formatter:'number', formatoptions:{thousandsSeparator:','}},
				{name:'zzkhdj', index:'zzkhdj', label:'最终客户单价', width:100, align:'right', formatter:'number', formatoptions:{thousandsSeparator:','}},
				{name:'zdsj', index:'zdsj', label:'建单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'jhrq', index:'jhrq', label:'预计交货日', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				//{name:'chdh', index:'chdh', label:'', width:100},
				{name:'etd', index:'etd', label:'ETD', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'eta', index:'eta', label:'ETA port', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'khyqddjhrq', index:'khyqddjhrq', label:'客户要求交货日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'hsztsl', index:'hsztsl', label:'海上在途数量', width:100},
				{name:'wlddblgcsl', index:'wlddblgcsl', label:'物料到达波兰工厂数量', width:100},
				{name:'skddscsl', index:'skddscsl', label:'skd待生产数量', width:100},
				{name:'zjdchsl', index:'zjdchsl', label:'整机待出货数量', width:100},
				{name:'zjblpsl', index:'zjblpsl', label:'整机不良品数量', width:100},
				{name:'wztsl', index:'wztsl', label:'无状态数量', width:100},
				{name:'chsl', index:'chsl', label:'出货数量', width:100},
				{name:'blgcchrq', index:'blgcchrq', label:'波兰工厂出货日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bcchkhmc', index:'bcchkhmc', label:'本次出货客户名', width:100},
				{name:'bzxx', index:'bzxx', label:'备注', width:100}
			]
		},{
			add:false,
			edit:false,
			del:false
		}).jqGrid('setFrozenColumns');
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/report/skdOrderStatus/export'/>"});
	    			}
	    		});
	        }
		});
		
		//导入
		$('#btn-import').click(function(){
			$.importDialog({
				title:"选择文件",
				//data: $('#form-submit').getFormData(),
				url:"<c:url value='/report/skdOrderStatus/import'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		
		//模板下载
		$('#btn-download').on('click',function(){
			window.location.href=encodeURI("<c:url value='/template/EuroprSKDorderStatus.xlsx'/>");
		})
	})
</script>
</html>