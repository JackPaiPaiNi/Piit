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
						<button id="btn-export-mx" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i> 导出明细
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
										<input type="hidden" name="zt" value ="5"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">公司编码&nbsp;&nbsp;</label>
									<select role="select" id="gsbm" name="gsbm" size="1" class="form-control skyselect">										
										${fns:loadCompanyOption('0')}
									</select>
									</div>
								</div>
								<!-- <input type ="hidden" name="pilx" value="1"> -->
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
										<input type="text" name="xsymc" class="form-control"/>
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
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">信用证号&nbsp;&nbsp;</label>
										<input type="text" name="lcbh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">认领单号&nbsp;&nbsp;</label>
										<input type="text" name="rldh" class="form-control"/>
									</div>
								</div>
							</div>							
						</form>
					</div>
				</div>
			</div>
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
			
			<div id="grid-parent-bindmx" hidden="hidden">
				<table id="grid-table-bindmx"></table>
				<div id="grid-pager-bindmx"></div>
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
	var grid_bindmx_selector = "#grid-table-bindmx";
    var pager_bindmx_selector = "#grid-pager-bindmx";
	var form_search = "#form-search";
	var isEdit = false;
	<shiro:hasPermission name="payment:payPiBind:edit"> isEdit=true;</shiro:hasPermission>
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/payment/payPiBind/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'pilx', index:'pilx', label:'PI类型', width:80, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('PILX')}"}},
				{name:'piid', index:'piid', label:'PI号', width:143},
				{name:'xsymc', index:'xsymc', label:'销售员名称', width:143},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'gsbm', index:'gsbm', label:'公司', width:80},
				{name:'khbm', index:'khbm', label:'客户编码', width:100},
				{name:'khmc', index:'khmc', label:'客户名称', width:160},
				{name:'fktjmc', index:'fktjmc', label:'付款方式', width:280},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'ttYbdje', index:'ttYbdje', label:'TT已绑定金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'lcYbd', index:'lcYbd', label:'LC已绑定金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'zje', index:'zje', label:'总金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}}
			]
		},{
			add:false,
			edit:isEdit,
			edittext:"绑定",
			del:isEdit,
			editfunc: editfunc,
			viewfunc:viewfunc,
			deltext:"解绑",
			delfunc:editfunc
		});
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });	
		
		//备损物料明细导出
		$(grid_bindmx_selector).bindTable({
			caption: "",
			pager: pager_bindmx_selector,
			gridParent: "#grid-parent-bindmx",
			rowList: [5, 10, 15],
		    rowNum:5,
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
						{name:'id', label:'ID'},
						{name:'piid', index:'piid', label:'PI号', },
						{name:'rldh', index:'rldh', label:'认领单号'},
						{name:'bdlx', index:'bdlx', label:'绑定类型'},
						{name:'bz', index:'bz', label:'币种'},
						{name:'lcbh', index:'lcbh', label:'LC编号'},
						{name:'kzh', index:'kzh', label:'开证行'},
						{name:'kzhdm', index:'kzhdm', label:'开证行代码'},
						{name:'je', index:'je', label:'金额'}/* ,
					    {name:'zdrmc', index:'zdrmc', label:'认领人名称'},
						{name:'edbz', index:'edbz', label:'额度币种'},
						{name:'edje', index:'edje', label:'额度金额'},
						{name:'ydEdHl', index:'ydEdHl', label:'原单到额度汇率'} */
					]
		},{
			add:false,
			edit:false,
			del:false
			
		});
	
		$("#btn-export-mx").click(function(){
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
	    				$(grid_bindmx_selector).exportExcelNoData({url: "<c:url value='/payment/payPiBind/exportitem'/>"});
	    			}
	    		});
	        }
		});
		
		$("#btn-export").click(function(){
		    var curNum=$(grid_selector).getGridParam("records");
		    if(curNum==0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#body").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/payPiBind/export'/>"});
	    			}
	    		});
	        }
		});
	});
	
	
	//编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		if(selr==null || selr==""){
			swal("", "请选择一行数据！", "warning");
			return;
		}else{
			location.href = "<c:url value='/payment/payPiBind/editPage'/>" + "?piid=" + rowData.piid;
		}
	}

	//查看
	function viewfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		if(selr==null || selr==""){
			swal("", "请选择一行数据！", "warning");
			return;
		}else{
			location.href = "<c:url value='/payment/payPiBind/viewPage'/>" + "?piid=" + rowData.piid;
		}
    };
	
</script>
</html>