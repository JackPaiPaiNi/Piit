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
										<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
										<input type="text" name="fph" class="form-control"/>
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
										<label class="input-group-addon">出货通知书单号&nbsp;&nbsp;</label>
										<input type="text" name="chdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">柜号&nbsp;&nbsp;</label>
										<input type="text" name="gh" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料编号&nbsp;&nbsp;</label>
										<input type="text" name="wlbh" class="form-control"/>
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
	<shiro:hasPermission name="deliver:deliver:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/deliver/deliver/SAPDeliverSearch'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: form_search,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen : true},
				{name:'serino',index:'serino',label:'行号',hidden: true,width:80, frozen : true},
				{name:'fph',index:'fph',label:'发票号',width:80, frozen : true},
				{name:'ztmc',index:'ztmc',label:'发票状态',width:80, frozen : true},
				{name:'chdh',index:'chdh',label:'出货单号',width:80, frozen : true},
				{name:'ddid',index:'ddid',label:'订单号',width:80, frozen : true},
				{name:'scbj',index:'scbj',label:'是否删除',width:80, edittype:"select", formatter: "select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}, frozen : true},
				{name:'mxlx',index:'mxlx',label:'出库明细类型',width:80},
				{name:'jhdh',index:'jhdh',label:'交货单号',width:80},
				{name:'jhdhxmh',index:'jhdhxmh',label:'交货单行项目号',width:100},
				{name:'zgrq',index:'zgrq',label:'装柜日期',width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'pono',index:'pono',label:'P.O.NO.',width:80},
				{name:'potype',index:'potype',label:'PO-TYPE',width:80},
				{name:'kbh',index:'kbh',label:'卡板号',width:80},
				{name:'gx',index:'gx',label:'柜型',width:80},
				{name:'gh',index:'gh',label:'柜号',width:80},
				{name:'pz',index:'pz',label:'皮重KG',width:80},
				{name:'fth',index:'fth',label:'封条号',width:80},
				{name:'xh',index:'xh',label:'箱号',width:80},
				{name:'xs',index:'xs',label:'箱数',width:80},
				{name:'jixing',index:'jixing',label:'型号',width:80},
				{name:'jixin',index:'jixin',label:'机芯',width:80},
				{name:'khxhms',index:'khxhms',label:'客户型号',width:80},
				{name:'spms',index:'spms',label:'商品描述',width:80},
				{name:'wllb',index:'wllb',label:'物料类别',width:80},
				{name:'wlbh',index:'wlbh',label:'物料编号',width:80},
				{name:'wlmsYw',index:'wlmsYw',label:'物料描述（英文）',width:120},
				{name:'wlmsZw',index:'wlmsZw',label:'物料描述（中文）',width:120},
				{name:'wlmsKhyy',index:'wlmsKhyy',label:'物料描述（客户语言）',width:120},
				{name:'khlh',index:'khlh',label:'客户料号',width:80},
				{name:'mxsl',index:'mxsl',label:'每箱数量',width:80},
				{name:'moq',index:'moq',label:'MOQ最小包装量',width:120},
				{name:'dw',index:'dw',label:'单位',width:80},
				{name:'dj',index:'dj',label:'单价（RMB）',width:80},
				{name:'zsl',index:'zsl',label:'总数量',width:80},
				{name:'zje',index:'zje',label:'总金额',width:80},
				{name:'dhsl',index:'dhsl',label:'大货数量',width:80},
				{name:'dhje',index:'dhje',label:'大货金额',width:80},
				{name:'mfsl',index:'mfsl',label:'免费数量',width:80},
				{name:'mfje',index:'mfje',label:'免费金额',width:80},
				{name:'zxC',index:'zxC',label:'纸箱长CM',width:80},
				{name:'zxK',index:'zxK',label:'纸箱宽CM',width:80},
				{name:'zxG',index:'zxG',label:'纸箱高CM',width:80},
				{name:'dgzl',index:'dgzl',label:'单个重量（净重）KG',width:150},
				{name:'djzmx',index:'djzmx',label:'单净重/箱KG',width:150},
				{name:'dmzmx',index:'dmzmx',label:'单毛重/箱KG',width:150},
				{name:'zjz',index:'zjz',label:'净重（总）KG',width:80},
				{name:'zmz',index:'zmz',label:'毛重（总）KG',width:80},
				{name:'mkbmz',index:'mkbmz',label:'每卡板毛重TTL GW',width:150},
				{name:'kbC',index:'kbC',label:'卡板长CM',width:80},
				{name:'kbK',index:'kbK',label:'卡板宽CM',width:80},
				{name:'kbG',index:'kbG',label:'卡板高CM',width:80},
				{name:'kbtj',index:'kbtj',label:'卡板体积',width:80},
				{name:'zkbzl',index:'zkbzl',label:'总卡板重量KG',width:120},
				{name:'gysdm',index:'gysdm',label:'供应商代码',width:80},
				{name:'gysmc',index:'gysmc',label:'供应商名称',width:80},
				{name:'gysdz',index:'gysdz',label:'供应商地址',width:80},
				{name:'ycgj',index:'ycgj',label:'原产国家',width:80},
				{name:'khhgbm',index:'khhgbm',label:'客户海关编码',width:120},
				{name:'khhgbmms',index:'khhgbmms',label:'客户海关编码描述',width:120},
				{name:'sjc',index:'sjc',label:'时间戳',hidden: true,width:80}
			]
		},{
			add:false,
			edit:false,
			view:false,
			del:false
		}).jqGrid('setFrozenColumns');
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/deliver/deliver/SAPDeliverexport'/>"});
	    			}
	    		});
	        }
		});
		
	});

</script>
</html>