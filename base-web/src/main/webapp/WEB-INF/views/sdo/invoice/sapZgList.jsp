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
									<label class="input-group-addon">出货通知号&nbsp;&nbsp;</label>
										<input type="text" name="chdno" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="vbeln" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">订舱号&nbsp;&nbsp;</label>
										<input type="text" name="dcno" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">柜号&nbsp;&nbsp;</label>
										<input type="text" name="guino" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">封条号&nbsp;&nbsp;</label>
										<input type="text" name="ftno" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">物料编号&nbsp;&nbsp;</label>
										<input type="text" name="matnr" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">PO号/批次&nbsp;&nbsp;</label>
										<input type="text" name="polote" class="form-control" />
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
	<shiro:hasPermission name="invoice:zglist:edit">isEdit=true;</shiro:hasPermission>
	$(function($) {
		$(".skyselect").select2();
		
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/invoice/zglist/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height() + 50,
			width:window.screen.availWidth-20,  
			rowNum : 20,
			colModel: [
				{name : 'id', label:'ID', hidden: true, width:60, editable:false},
				{name : 'chdno', index : 'chdno', label : 'SA NO.', width : 100},
				{name : 'vbeln', index : 'vbeln', label : 'JOB NO.', width : 100},
				{name : 'dcno', index : 'dcno', label : 'SO NO.', width : 100},
				{name : 'guino', index : 'guino', label : 'CONTAINER NO.', width : 120},
				{name : 'ftno', index : 'ftno', label : 'SEAL NO.', width : 100},
				{name : 'gxnam', index : 'gxnam', label : 'CONTAINER TYPE', width : 120},
				{name : 'kbno', index : 'kbno', label : 'PLT NO.', width : 80},
				{name : 'boxno', index : 'boxno', label : 'CTN NO.', width : 80},
				{name : 'matnr', index : 'matnr', label : 'PART NO.', width : 80},
				{name : 'kmatnr', index : 'kmatnr', label : 'Customer data', width : 110},
				{name : 'maktx', index : 'maktx', label : 'DESCRIPTION ON', width : 120},
				{name : 'ktype', index : 'ktype', label : 'MODEL CODE', width : 110},
				{name : 'perwet', index : 'perwet', label : 'N.W.(kg)/Unit', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},			
				{name : 'dgmz', index : 'dgmz', label : 'G.W.(kg)/Unit', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'sfqty', index : 'sfqty', label : 'TIL QTY.', width : 70, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'meins', index : 'meins', label : 'UTIN', width : 60},
				//{name : 'ddqty', index : 'ddqty', label : 'ORDER QTY', width : 90, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'yfqty', index : 'yfqty', label : 'ORDER QTY', width : 90, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'foc01', index : 'foc01', label : 'F.O.C QTY', width : 80},
				{name : 'boxqty', index : 'boxqty', label : 'UNIT/CTN', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'jpwet', index : 'jpwet', label : 'N.W.(kg)/ctn', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'mpwet', index : 'mpwet', label : 'G.W.(kg)/ctn', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'boxnum', index : 'boxnum', label : 'CTNS', width : 60, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'boxl', index : 'boxl', label : 'LONG', width : 60, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'boxw', index : 'boxw', label : 'WIDE', width : 60, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'boxh', index : 'boxh', label : 'HIGH', width : 60, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'jzwet', index : 'jzwet', label : 'TTL G.W(KGS)', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'mzwet', index : 'mzwet', label : 'TTL N.W(KGS)', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbl', index : 'kbl', label : 'LONG', width : 60, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbw', index : 'kbw', label : 'WIDE', width : 60, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbh', index : 'kbh', label : 'HIGH', width : 60, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbnum', index : 'kbnum', label : 'PLT QTY', width : 70, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbpwet', index : 'kbpwet', label : 'KGS/PLT', width : 70, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbzjz', index : 'kbzjz', label : 'TTL G.W(KGS)', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbzwet', index : 'kbzwet', label : 'TTL N.W(KGS)', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'boxpv', index : 'boxpv', label : 'TTL MEAS.(CBM)', width : 110, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'ycgj', index : 'ycgj', label : 'Country of origin', width : 120},
				{name : 'polote', index : 'polote', label : 'P.O.NO./LOTE', width : 100},
				{name : 'lifnr', index : 'lifnr', label : 'Supplier Code ', width : 110},
				{name : 'egname', index : 'egname', label : 'Supplier Name', width : 110},
				{name : 'egaddr', index : 'egaddr', label : 'Supplier Address', width : 110},
				{name : 'pmaktx', index : 'pmaktx', label : 'Portuguese Description', width : 110},
				{name : 'hscode', index : 'hscode', label : 'HS CODE', width : 70},
				{name : 'cpmna', index : 'cpmna', label : '&nbsp;', width : 80},
				{name : 'ztype', index : 'ztype', label : '&nbsp;', width : 80},
				{name : 'pmoney', index : 'pmoney', label : 'Unit Price/USD', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'zmoney', index : 'zmoney', label : 'Total Amount/USD', width : 100, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'gszjh', index : 'gszjh', label : "Ass'y Part No.assembled by Skyworth", width : 120},
				{name : 'gszjm', index : 'gszjm', label : "Ass'y description", width : 120},
				{name : 'gszjs', index : 'gszjs', label : "Ass'y Qty.", width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'tare', index : 'tare', label : 'TARE', width : 80}

				/* {name : 'chdat', index : 'chdat', label : '出货日期', width : 80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name : 'cftno', index : 'cftno', label : '厂封', width : 80},
				{name : 'zgdsn', index : 'zgdsn', label : '装柜清单项目', width : 80},
				{name : 'bukrs', index : 'bukrs', label : '公司代码', width : 80},
				{name : 'sygs', index : 'sygs', label : '运输公司', width : 80},
				{name : 'fhnam', index : 'fhnam', label : '发货员 ', width : 80},
				{name : 'poter', index : 'poter', label : '港口', width : 80},
				{name : 'cheno', index : 'cheno', label : '车牌', width : 80},
				{name : 'bynam', index : 'bynam', label : '搬运工', width : 80},
				{name : 'jctim', index : 'jctim', label : '进厂时间', width : 80},
				{name : 'cctim', index : 'cctim', label : '出厂时间', width : 80},
				{name : 'erdat', index : 'erdat', label : '创建日期 ', width : 80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name : 'ertim', index : 'ertim', label : '创建时间', width : 80},
				{name : 'ernam', index : 'ernam', label : '创建的用户名', width : 80},
				{name : 'zflag', index : 'zflag', label : '确认标识 ', width : 80},
				{name : 'note1', index : 'note1', label : '备注', width : 80},
				{name : 'cyxno', index : 'cyxno', label : '储运箱单号', width : 80},
				{name : 'cyxsn', index : 'cyxsn', label : '储运箱单项目 ', width : 80},
				{name : 'zgroup', index : 'zgroup', label : '群组', width : 80},
				{name : 'cmatnr', index : 'cmatnr', label : '备案序号', width : 80},
				{name : 'cmaktx', index : 'cmaktx', label : '商品名称', width : 80},
				{name : 'cmeins', index : 'cmeins', label : '申报单位 ', width : 80},
				{name : 'aenam', index : 'aenam', label : '最近修改的用户名', width : 80},
				{name : 'aedat', index : 'aedat', label : '修改日期', width : 80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name : 'aetim', index : 'aetim', label : '修改时间', width : 80},
				{name : 'jgtyp', index : 'jgtyp', label : '加工类型', width : 80},
				{name : 'boxnum', index : 'boxnum', label : '箱数', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'yfqty', index : 'yfqty', label : '应发数 ', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'bcwet', index : 'bcwet', label : '包材重量/箱kg', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'ztype', index : 'ztype', label : '类别', width : 80},
				{name : 'kbpjwet', index : 'kbpjwet', label : '每卡板净重kg', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbqty', index : 'kbqty', label : '每卡板数量', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'kbpv', index : 'kbpv', label : '每卡板体积M3', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'dutyr', index : 'dutyr', label : 'Duty rate', width : 80},
				{name : 'epmna', index : 'epmna', label : '英文品名', width : 80},
				{name : 'htno', index : 'htno', label : '合同号', width : 80},
				{name : 'minbz', index : 'minbz', label : '最小包装', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'pmaktx', index : 'pmaktx', label : '葡语描述', width : 80},
				{name : 'csmgj', index : 'csmgj', label : '潮湿敏感等级', width : 80},
				{name : 'khfl', index : 'khfl', label : '类型/客户分类', width : 80},
				{name : 'jxtyp', index : 'jxtyp', label : '机型', width : 80},
				{name : 'jixin', index : 'jixin', label : '机芯', width : 80},
				{name : 'potype', index : 'potype', label : 'PO-TYPE', width : 80},
				{name : 'neno', index : 'neno', label : 'N.E.号 ', width : 80},
				{name : 'ncmno', index : 'ncmno', label : 'NCM Code', width : 80},
				{name : 'ncm', index : 'ncm', label : 'NCM', width : 80},
				{name : 'djqty', index : 'djqty', label : '单机用量', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'weihao', index : 'weihao', label : '位号', width : 80},
				{name : 'ckdno', index : 'ckdno', label : '参考订单', width : 80},
				{name : 'boxpv', index : 'boxpv', label : '箱子体积M3', width : 80, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}},
				{name : 'bey01', index : 'bey01', label : '备用窗口01', width : 80},
				{name : 'bey02', index : 'bey02', label : '备用窗口02', width : 80},
				{name : 'bey03', index : 'bey03', label : '备用窗口03', width : 80},
				{name : 'bey04', index : 'bey04', label : '备用窗口04', width : 80},
				{name : 'zhlx', index : 'zhlx', label : '走货类型', width : 80} */
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
		$(grid_selector).setCustomGroupHeaders({
			useColSpanStyle: true,
			groupHeaders:[
			      	{startColumnName:'chdno', numberOfColumns:'1', titleText: "出货通知书号"},
			      	{startColumnName:'vbeln', numberOfColumns:'1', titleText: "订单号"},
			      	{startColumnName:'dcno', numberOfColumns:'1', titleText: "订舱号"},
			      	{startColumnName:'guino', numberOfColumns:'1', titleText: "柜号"},
			      	{startColumnName:'ftno', numberOfColumns:'1', titleText: "封条号"},
			      	{startColumnName:'gxnam', numberOfColumns:'1', titleText: "柜型"},
			      	{startColumnName:'kbno', numberOfColumns:'1', titleText: "卡板号"},
			      	{startColumnName:'boxno', numberOfColumns:'1', titleText: "箱编号"},
			      	{startColumnName:'matnr', numberOfColumns:'1', titleText: "物料编号"},
			      	{startColumnName:'kmatnr', numberOfColumns:'1', titleText: "客户料号"},
			      	{startColumnName:'maktx', numberOfColumns:'1', titleText: "物料描述"},
			      	{startColumnName:'ktype', numberOfColumns:'1', titleText: "客户机型"},
			      	{startColumnName:'perwet', numberOfColumns:'1', titleText: "单个净重"},
			      	{startColumnName:'dgmz', numberOfColumns:'1', titleText: "单个毛重"},
			      	{startColumnName:'sfqty', numberOfColumns:'1', titleText: "实发数"},
			      	{startColumnName:'meins', numberOfColumns:'1', titleText: "单位"},
			      	{startColumnName:'yfqty', numberOfColumns:'1', titleText: "订单数量"},
			      	{startColumnName:'foc01', numberOfColumns:'1', titleText: "1%备损"},
			      	{startColumnName:'boxqty', numberOfColumns:'1', titleText: "单箱数量"},
			      	{startColumnName:'jpwet', numberOfColumns:'1', titleText: "单箱净重"},
			      	{startColumnName:'mpwet', numberOfColumns:'1', titleText: "单箱毛重"},
			      	{startColumnName:'boxnum', numberOfColumns:'1', titleText: "箱数"},
			      	{startColumnName:'boxl', numberOfColumns:'3', titleText: "箱尺寸 CTN MEAS(CM)"},
			      	{startColumnName:'jzwet', numberOfColumns:'1', titleText: "箱总净重"},
			      	{startColumnName:'mzwet', numberOfColumns:'1', titleText: "箱总毛重"},
			      	{startColumnName:'kbl', numberOfColumns:'3', titleText: "卡板尺寸 PLT MEAS(CM)"},
			      	{startColumnName:'kbnum', numberOfColumns:'1', titleText: "板数"},
			      	{startColumnName:'kbpwet', numberOfColumns:'1', titleText: "每卡板重量"},
			      	{startColumnName:'kbzjz', numberOfColumns:'1', titleText: "卡板总净重"},
			      	{startColumnName:'kbzwet', numberOfColumns:'1', titleText: "卡板总毛重"},
			      	{startColumnName:'boxpv', numberOfColumns:'1', titleText: "总体积"},
			      	{startColumnName:'ycgj', numberOfColumns:'1', titleText: "原产国"},
			      	{startColumnName:'polote', numberOfColumns:'1', titleText: "PO号/批次"},
			      	{startColumnName:'lifnr', numberOfColumns:'1', titleText: "供应商代码"},
			      	{startColumnName:'egname', numberOfColumns:'1', titleText: "供应商英文名称"},
			      	{startColumnName:'egaddr', numberOfColumns:'1', titleText: "供应商英文地址"},
			      	{startColumnName:'pmaktx', numberOfColumns:'1', titleText: "客户描述"},
			      	{startColumnName:'hscode', numberOfColumns:'1', titleText: "海关代码"},
			      	{startColumnName:'cpmna', numberOfColumns:'1', titleText: "中文品名"},
			      	{startColumnName:'ztype', numberOfColumns:'1', titleText: "在线管理系统类别"},
			      	{startColumnName:'pmoney', numberOfColumns:'1', titleText: "单价"},
			      	{startColumnName:'zmoney', numberOfColumns:'1', titleText: "总价"},
			      	{startColumnName:'gszjh', numberOfColumns:'1', titleText: "创维组件号"},
			      	{startColumnName:'gszjm', numberOfColumns:'1', titleText: "组件号描述"},
			      	{startColumnName:'gszjs', numberOfColumns:'1', titleText: "组件数量"},
			      	{startColumnName:'tare', numberOfColumns:'1', titleText: "柜重"}
			] 
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/invoice/zglist/export'/>"});
	    			}
	    		});
	        }
		});
	});
</script>
</html>