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
                         		<input type="hidden" name="level"/>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
										<input type="text" name="fph" class="form-control"/>
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
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货通知书&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
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
							<div class="space-4" ></div>
						      <div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
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
										<label class="input-group-addon">公司&nbsp;&nbsp;</label>
										<input type="text" name="gsbm" class="form-control"/>
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
	$(function($) {
		$("#zdsj").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			url: "<c:url value='/report/invoiceTable/searchInvoice'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			rowNum:20,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'fph', index:'fph', label:'发票号', width:160,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'fph'+rowId+"\'";
				}},
				{name:'fprq', index:'fprq', label:'发票日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'},cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'fprq'+rowId+"\'";
				}},
				{name:'zdsj', index:'zdsj', label:'SDO开票日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'},cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'zdsj'+rowId+"\'";
				}},
				//{name:'xsyid', index:'xsyid', label:'船务专员ID', width:100, hidden:true},
				{name:'xsymc', index:'xsymc', label:'业务员', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'xsymc'+rowId+"\'";
				}},
				{name:'cwczzy', index:'cwczzy', label:'船务操作专员', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'cwczzy'+rowId+"\'";
				}},
				//{name:'zdrid', index:'zdrid', label:'制单人ID', width:100, hidden:true},
				{name:'zdrmc', index:'zdrmc', label:'船务单证专员', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'zdrmc'+rowId+"\'";
				}},
				{name:'khbm', index:'khbm', label:'客户编码', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'khbm'+rowId+"\'";
				}},
				{name:'khmc', index:'khmc', label:'客户名称', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'khmc'+rowId+"\'";
				}},
				{name:'tssapzt_syfp', index:'tssapzt_syfp', label:'推商业发票状态', width:80, formatter:tsSAPCellAddHref_syfp,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'tssapzt_syfp'+rowId+"\'";
				}},
				{name:'tssapzt_gsjfp', index:'tssapzt_gsjfp', label:'推公司间发票状态', width:80, formatter:tsSAPCellAddHref_gsjfp,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'tssapzt_gsjfp'+rowId+"\'";
				}},
				{name:'brandName', index:'brandName', label:'品牌', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'brandName'+rowId+"\'";
				}},
				{name:'lcbh', index:'lcbh', label:'L/C NO.', width:100},
				//{name:'fktj', index:'fktj', label:'付款条件编码', width:100, hidden:true},
				{name:'fktjmc', index:'fktjmc', label:'付款条件', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'fktjmc'+rowId+"\'";
				}},
				//{name:'zhfs', index:'zhfs', label:'走货方式', width:100, hidden:true},
				{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'zhfsmc'+rowId+"\'";
				}},
				{name:'ddid', index:'ddid', label:'订单号', width:100},
				{name:'spmc', index:'spmc', label:'商品名称', width:100},
				{name:'jixing', index:'jixing', label:'MODEL', width:80},
				{name:'sl', index:'sl', label:'QTY', width:65, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name:'mfjsl', index:'mfjsl', label:'免费机数量', width:80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				//{name:'mytk', index:'mytk', label:'贸易条款', width:80, hidden:true},
				{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'mytkmc'+rowId+"\'";
				}},
				{name:'dj', index:'dj', label:'UNIT PRICE', width:80, align:'right', formatter:'number', formatoptions:{thousandsSeparator:','}},
				{name:'xtkpzje', index:'xtkpzje', label:'SA MODEL AMOUNT', width:100, align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'sjfpzje', index:'sjfpzje', label:'SDO TTL INV. AMOUNT', width:100, align:'right', formatter:'number', formatoptions:{thousandsSeparator:','}},
				{name:'bz', index:'bz', label:'币种', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'bz'+rowId+"\'";
				}},
				{name:'qtfyje', index:'qtfyje', label:'其他费用', width:80, align:'right', formatter:'number', formatoptions:{thousandsSeparator:','},cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'qtfyje'+rowId+"\'";
				}},
				{name:'bzxx', index:'bzxx', label:'SDO发票备注', width:120,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'bzxx'+rowId+"\'";
				}},
				{name:'cylxmc', index:'cylxmc', label:'出运类型', width:80},
				{name:'cdgsmc', index:'cdgsmc', label:'船代公司', width:100},
				{name:'cm', index:'cm', label:'船名', width:100},
				{name:'hc', index:'hc', label:'航次', width:100},
				/* {name:'hbh', index:'hbh', label:'航班号', width:100},
				{name:'xhg', index:'xhg', label:'卸货港', width:100}, */
				{name:'mdg', index:'mdg', label:'目的港', width:100},
				//{name:'xwgj', index:'xwgj', label:'目的国家编码', width:100, hidden:true},
				{name:'xwgjmc', index:'xwgjmc', label:'目的国家', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'xwgjmc'+rowId+"\'";
				}},
				{name:'qygmc', index:'qygmc', label:'起运港', width:100},
				{name:'zcrq', index:'zcrq', label:'预计开船日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'yjdgq', index:'yjdgq', label:'预计到港日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'tdh', index:'tdh', label:'B/L no.', width:100},
				{name:'gx', index:'gx', label:'柜型', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'gx'+rowId+"\'";
				}},
				{name:'gs', index:'gs', label:'柜数', width:100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','},cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'gs'+rowId+"\'";
				}},
				{name:'gh', index:'gh', label:'柜号', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'gh'+rowId+"\'";
				}},
				{name:'tcgs', index:'tcgs', label:'拖车公司', width:100,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'tcgs'+rowId+"\'";
				}},
				/* {name:'tcgsfp', index:'tcgsfp', label:'拖车公司发票', width:100}, 
				{name:'transportCosts', index:'transportCosts', label:'transport costs', width:100},*/
				{name:'chdh', index:'chdh', label:'出货通知书号', width:100}, 
				{name:'yzhdh', index:'yzhdh', label:'预走货通知书', width:100},
				{name:'receiveDate', index:'receiveDate', label:'预走货提交时间', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'remark', index:'remark', label:'REMARK', width:100},
				{name:'gsbm', index:'gsbm', label:'发票公司', width:100}
				/* {name:'czrmc', index:'czrmc', label:'操作人名称', width:100}, */
			],
			gridComplete: function(){
	            //合并单元格
	            merge('fph','fph');
	            merge('fph','fprq');
	            merge('fph','zdsj');
	            merge('fph','xsymc');
	            merge('fph','xwgjmc');
	            merge('fph','zdrmc');
	            merge('fph','cwczzy');
	            merge('fph','khbm');
	            merge('fph','khmc');
	            merge('fph','tssapzt_syfp');
	            merge('fph','tssapzt_gsjfp');
	            merge('fph','brandName');
	            merge('fph','fktjmc');
	            merge('fph','zhfsmc');
	            merge('fph','mytkmc');
	            merge('fph','gx');
	            merge('fph','gs');
	            merge('fph','gh');
	            merge('fph','tcgs');
	            merge('fph','bz');
	            merge('fph','bzxx');
	            merge('fph','cwczzy');
	            merge('fph','qtfyje');
	            
		   	}
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/report/invoiceTable/export'/>"});
	    			}
	    		});
	        }
		});
	})
	function tsSAPCellAddHref_syfp(cellvalue, options, rowData){
		if(cellvalue == "1"){
			return "已通过";
		} else if(cellvalue == "0"){
			return "未通过";
		}else if(cellvalue == "2"){
			return "已冲销";
		} else {
			return "";
		}
	}
	
	function tsSAPCellAddHref_gsjfp(cellvalue, options, rowData){
		if(cellvalue == "1"){
			return "已通过";
		} else if(cellvalue == "0"){
			return "未通过";
		}else if(cellvalue == "2"){
			return "已冲销";
		}else if(cellvalue == "3"){
			return "不需要推";
		} else {
			return "";
		}
	}
	
	//合并行单元格
	function merge(FphCell,CellName){
		var mya=$(grid_selector).getDataIDs();
		var length=mya.length;
		for(var i=0;i<length;i++){
			var before=$(grid_selector).jqGrid('getRowData',mya[i]);
			var rowSpanCount=1;
			for(var j=i+1;j<=length;j++){
				var end=$(grid_selector).jqGrid('getRowData',mya[j]);
				if(before[CellName]==end[CellName] && before[FphCell]==end[FphCell] && before['gx']==end['gx'] && before['gh']==end['gh']){
					rowSpanCount++;
					$(grid_selector).setCell(mya[j],CellName,'',{display:'none'});
				}else{
					rowSpanCount = 1;
					break;
				}
				$("#"+CellName+""+mya[i]+"").attr("rowspan",rowSpanCount);
			}
		}
	}
</script>
</html>