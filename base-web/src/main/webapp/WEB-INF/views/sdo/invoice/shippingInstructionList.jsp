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
				
			<div  id="search-box" class="widget-box">
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
										<label class="input-group-addon">补料单号&nbsp;&nbsp;</label>
										<input type="text" name="bldh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船代公司&nbsp;&nbsp;</label>
										<input type="text" name="cdgs" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船务专员&nbsp;&nbsp;</label>
										<input type="text" name="cwzymc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
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
			
			<div id="grid-parent-chmx" hidden="hidden">
				<table id="grid-table-chmx"></table>
				<div id="grid-pager-chmx"></div>
			</div>

			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var grid_selector_chmx = "#grid-table-chmx";
	var pager_selector_chmx = "#grid-pager-chmx";
	var form_search = "#form-search";
	var editurl = "<c:url value='/invoice/shippingInstruction/editPage'/>";
	var viewurl = "<c:url value='/invoice/shippingInstruction/viewPage'/>";
	var delurl = "<c:url value='/invoice/shippingInstruction/delete'/>";
	var searchurl= "<c:url value='/invoice/shippingInstruction/search'/>";
	var expurl = "<c:url value='/invoice/shippingInstruction/export'/>";
	var isEdit = false;
	<shiro:hasPermission name="invoice:shippingInstruction:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$("#form-search [name=zdsj]").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		
		$(grid_selector).bindTable({
			caption: "",
			url: searchurl,
			editurl: delurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'chxx', index:'chxx', label:'出货信息', hidden: true, width:60, editable:false},
				{name:'bldh', index:'bldh', label:'补料单号', width:80},
				{name:'cdgs', index:'cdgs', label:'船代公司', width:100},
				{name:'cdgslxr', index:'cdgslxr', label:'船代公司联系人', width:80},
				{name:'cwzy', index:'cwzy', label:'船务专员', width:80},
				{name:'qyg', index:'qyg', label:'起运港', width:80},
				{name:'xhg', index:'xhg', label:'卸货港', width:80},
				{name:'mdg', index:'mdg', label:'目的港', width:80},
				{name:'cmhchbh', index:'cmhchbh', label:'船名航次航班号', width:80},
				{name:'mytk', index:'mytk', label:'贸易条款', width:100},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
			addfunc:addfunc,
			editfunc: editfunc,
			delfunc:delfunc,
			viewfunc:viewfunc
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"出库明细导出", 
			buttonicon:"fa-download blue", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					$(grid_selector_chmx).exportExcelNoData({url: "<c:url value='/invoice/shippingInstruction/ckmxExport'/>"+"?chxx="+rowData.chxx});
				}
			},
			position:"last"
		});
		
		$(grid_selector_chmx).bindTable({
			caption: "",
			pager: pager_selector_chmx,
			gridParent: "#grid-parent-chmx",
			//formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'serino', index:'serino', label:'行号', width:80, hidden: true},
				{name:'fph', index:'fph', label:'发票号', width:80, hidden: true},
				{name:'mxlx', index:'mxlx', label:'出库明细类型', width:80, hidden: true},
				{name:'chdh', index:'chdh', label:'出货单号', width:80, hidden: true},
				{name:'ddid', index:'ddid', label:'订单号', width:80, hidden: true},
				{name:'jhdh', index:'jhdh', label:'交货单号', width:80, hidden: true},
				{name:'jhdhxmh', index:'jhdhxmh', label:'交货单行项目号', width:80, hidden: true},
				{name:'zgrq', index:'zgrq', label:'装柜日期', width:80, hidden: true, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'pono', index:'pono', label:'P.O.NO.', width:80, hidden: true},
				{name:'potype', index:'potype', label:'PO-TYPE', width:80, hidden: true},
				{name:'kbh', index:'kbh', label:'卡板号', width:80, hidden: true},
				{name:'gx', index:'gx', label:'柜型', width:80, hidden: true},
				{name:'gh', index:'gh', label:'柜号', width:80, hidden: true},
				{name:'pz', index:'pz', label:'皮重KG', width:80, hidden: true},
				{name:'fth', index:'fth', label:'封条号', width:80, hidden: true},
				{name:'xh', index:'xh', label:'箱号', width:80, hidden: true},
				{name:'xs', index:'xs', label:'箱数', width:80, hidden: true},
				{name:'jixing', index:'jixing', label:'型号', width:80, hidden: true},
				{name:'jixin', index:'jixin', label:'机芯', width:80, hidden: true},
				{name:'khxhms', index:'khxhms', label:'客户型号', width:80, hidden: true},
				{name:'spms', index:'spms', label:'商品描述', width:80, hidden: true},
				{name:'wllb', index:'wllb', label:'物料类别', width:80, hidden: true},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:80, hidden: true},
				{name:'wlmsYw', index:'wlmsYw', label:'物料描述（英文）', width:80, hidden: true},
				{name:'wlmsZw', index:'wlmsZw', label:'物料描述（中文）', width:80, hidden: true},
				{name:'wlmsKhyy', index:'wlmsKhyy', label:'物料描述（客户语言）', width:80, hidden: true},
				{name:'khlh', index:'khlh', label:'客户料号', width:80, hidden: true},
				{name:'mxsl', index:'mxsl', label:'每箱数量', width:80, hidden: true},
				{name:'moq', index:'moq', label:'MOQ最小包装量', width:80, hidden: true},
				{name:'dw', index:'dw', label:'单位', width:80, hidden: true},
				{name:'dj', index:'dj', label:'单价（RMB）', width:80, hidden: true},
				{name:'zsl', index:'zsl', label:'总数量', width:80, hidden: true},
				{name:'zje', index:'zje', label:'总金额', width:80, hidden: true},
				{name:'dhsl', index:'dhsl', label:'大货数量', width:80, hidden: true},
				{name:'dhje', index:'dhje', label:'大货金额', width:80, hidden: true},
				{name:'mfsl', index:'mfsl', label:'免费数量', width:80, hidden: true},
				{name:'mfje', index:'mfje', label:'免费金额', width:80, hidden: true},
				{name:'zxC', index:'zxC', label:'纸箱长CM', width:80, hidden: true},
				{name:'zxK', index:'zxK', label:'纸箱宽CM', width:80, hidden: true},
				{name:'zxG', index:'zxG', label:'纸箱高CM', width:80, hidden: true},
				{name:'dgzl', index:'dgzl', label:'单个重量（净重）KG', width:80, hidden: true},
				{name:'djzmx', index:'djzmx', label:'单净重/箱KG', width:80, hidden: true},
				{name:'dmzmx', index:'dmzmx', label:'单毛重/箱KG', width:80, hidden: true},
				{name:'zjz', index:'zjz', label:'净重（总）KG', width:80, hidden: true},
				{name:'zmz', index:'zmz', label:'毛重（总）KG', width:80, hidden: true},
				{name:'mkbmz', index:'mkbmz', label:'每卡板毛重TTL GW', width:80, hidden: true},
				{name:'kbC', index:'kbC', label:'卡板长CM', width:80, hidden: true},
				{name:'kbK', index:'kbK', label:'卡板宽CM', width:80, hidden: true},
				{name:'kbG', index:'kbG', label:'卡板高CM', width:80, hidden: true},
				{name:'kbtj', index:'kbtj', label:'卡板体积', width:80, hidden: true},
				{name:'gysdm', index:'gysdm', label:'供应商代码', width:80, hidden: true},
				{name:'gysmc', index:'gysmc', label:'供应商名称', width:80, hidden: true},
				{name:'gysdz', index:'gysdz', label:'供应商地址', width:80, hidden: true},
				{name:'ycgj', index:'ycgj', label:'原产国家', width:80, hidden: true},
				{name:'khhgbm', index:'khhgbm', label:'客户海关编码', width:80, hidden: true},
				{name:'khhgbmms', index:'khhgbmms', label:'客户海关编码描述', width:80, hidden: true}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit
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
	    				$(grid_selector).exportExcel({url: expurl});
	    			}
	    		});
	        }
		});
		
	});
	//新增
	function addfunc(){
		location.href = editurl;
	}
	//编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		location.href = editurl + "?id=" + selr;
	}
	//删除
	function delfunc() {
		var selr = jQuery(grid_selector).jqGrid('getGridParam', 'selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData', selr);
		var zt = rowData.zt;
		if (selr == null || selr == "") {
			swal("", "请选择一行数据!", "warning");
			return;
		} else {
			$("body").bindSweetAlert({
				title : "确定要删除吗?",
				closeOnConfirm : true
			}, {
				callback : function() {
					$.bindAjax({
						url : delurl,
						data : {
							id : rowData.id
						},
						action : "edit"
					}, function(response) {
						$(grid_selector).trigger("reloadGrid");
					});
				}
			});
		}
	}
	//查看
	function viewfunc() {
		var selr = jQuery(grid_selector).jqGrid('getGridParam', 'selrow');
		window.open(viewurl + "?id=" + selr);
	}
</script>
</html>