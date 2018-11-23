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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
						<input type="hidden" id="zt" name="zt" value="5"/>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款单号&nbsp;&nbsp;</label>
										<input type="text" name="skdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">付款人&nbsp;&nbsp;</label>
										<input type="text" name="fkr" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">付款银行&nbsp;&nbsp;</label>		
										<select role="select" name="fkyh" size="1" class="form-control skyselect">
											${fns:loadBankInfoOption('0')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款日期&nbsp;&nbsp;</label>
										<input type="hidden" id="ssksj" name="ssksj"/>
										<input type="hidden" id="esksj" name="esksj"/>
										<input type="text" name="skrq" class="form-control"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">登记时间&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" class="form-control"/>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">收款类别&nbsp;&nbsp;</label>
											<select role="select" name="sklb" size="1" class="form-control skyselect">
												${fns:loadDictOption('SKLB')}
											</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">接单主体&nbsp;&nbsp;</label>
										<select role="select" name="gsbm" size="1" class="form-control skyselect">
											${fns:loadCompanyOption('0')}
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
	var editurl = "<c:url value='/payment/payReceiveClaim/editPage'/>";
	var searchurl = "<c:url value='/payment/payReceiveClaim/searchDB'/>";
	var isEdit = false;
	<shiro:hasPermission name="payment:payReceiveClaim:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$("#form-search [name=zdsj]").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$("#form-search [name=skrq]").bindDateRange({startElement:$("#ssksj"),endElement:$("#esksj")});
		
		$(grid_selector).bindTable({
			caption:"",
			url: searchurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen:true},
				{name:'skdh', index:'skdh', label:'收款单号', width:80, formoptions:{rowpos: 2, colpos: 1}, frozen:true},
				{name:'zt', index:'zt', label:'状态', hidden:true, frozen:true},
				{name:'fkr', index:'fkr', label:'付款人', width:80, frozen:true},
				{name:'fkyh', index:'fkyh', label:'付款银行', width:100},
				{name:'fkgj', index:'fkgj', label:'付款国家', width:80, hidden: true},
				{name:'fkgjmc', index:'fkgjmc', label:'付款国家', width:80},
				{name:'sklb', index:'sklb', label:'收款类别', width:60, hidden:true},
				{name:'sklbmc', index:'sklbmc', label:'收款类别', width:80},
				{name:'je', index:'je', label:'金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'sjsxf', index:'sjsxf', label:'实际手续费', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'yrlje', index:'yrlje', label:'已认领', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'wrlje', index:'wrlje', label:'未认领', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'rlzt', index:'rlzt', label:'认领状态', width:80},
				{name:'skrq', index:'skrq', label:'收款日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'skyh', index:'skyh', label:'收款银行', width:100, hidden: true},
				{name:'skyhmc', index:'skyhmc', label:'收款银行', width:100},
				{name:'gsbm', index:'gsbm', label:'接单主体', width:80},
				{name:'cksxf', index:'cksxf', label:'参考手续费', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:100, hidden: true},
				{name:'zdrmc', index:'zdrmc', label:'财务登记人', width:80},
				{name:'zdsj', index:'zdsj', label:'登记时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bbh', index:'bbh', label:'版本号', width:60, hidden: true},
				{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true},
				{name:'djje', index:'djje', label:'冻结金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'djyy', index:'djyy', label:'冻结原因', width:150},
				{name:'jybz', index:'jybz', label:'认领币种', width:150},
				{name:'hl', index:'hl', label:'汇率', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}}
			],
			sortname: 'skdh',
			sortorder: 'asc'
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		}).jqGrid('setFrozenColumns');
		//认领非保理类型的收款
		$(grid_selector).navButtonAdd(pager_selector,{
			caption: "认领", 
			buttonicon: "icon-edit", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id == null){
					swal("","请选择一条记录！","warning");
					return;
				} else {
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.sklb ==2 || rowData.sklb ==4 ){
						swal("","请选择一行普通收款的数据！","warning");
					}else{
						location.href = editurl + "?skdh=" + rowData.skdh;
					}
				}
			},
			position: "last"
		});
		<shiro:hasPermission name="payment:payReceiveClaim:rlbl">
		//认领保理类型的收款
		$(grid_selector).navButtonAdd(pager_selector,{
			caption: "认领保理", 
			buttonicon: "icon-edit", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id == null){
					swal("","请选择一条记录！","warning");
					return;
				} else {
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.sklb != 2){
						swal("","请选择一行保理收款的数据！","warning");
					}else{
						location.href = editurl + "?skdh=" + rowData.skdh;
					}
				}
			},
			position: "last"
		});
		//认领LC类型的收款
		$(grid_selector).navButtonAdd(pager_selector,{
			caption: "认领LC", 
			buttonicon: "icon-edit", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id == null){
					swal("","请选择一条记录！","warning");
					return;
				} else {
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.sklb != 4){
						swal("","请选择一行LC收款的数据！","warning");
					}else{
						location.href = editurl + "?skdh=" + rowData.skdh;
					}
				}
			},
			position: "last"
		});
		</shiro:hasPermission>
		
        //查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
	});

	function initSelect2(elem){
		$(elem).width(140).select2();
	}

</script>
</html>