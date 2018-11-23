<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<%@page import="com.ey.piit.core.utils.UserUtils"%>  
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp" %>
<%
  String  zdrid =   UserUtils.getUser().getEmpCode() ;
%>
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
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">公司&nbsp;&nbsp;</label>
										<select role="select" name="gsbm" size="1" class="form-control skyselect">
											${fns:loadCompanyOption('0')}
										</select>
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
										<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
										<input type="text" name="xsymc" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务类型&nbsp;&nbsp;</label>
										<select role="select" name="ywlx" size="1" class="form-control skyselect">
											${fns:loadDictOption('YWLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">付款保障状态&nbsp;&nbsp;</label>
										<select role="select" name="fkbzzt" size="1" class="form-control skyselect">
											${fns:loadDictOption('FKBZZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<table id="grid-table"></table>
			
			<div id="grid-pager"></div>
			<div id="grid-parent-ckd" hidden="hidden">
				<table id="grid-table-ckd"></table>
				<div id="grid-pager-ckd"></div>
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
	
	var grid_selector_ckd = "#grid-table-ckd";
	var pager_selector_ckd = "#grid-pager-ckd";
	
	var form_search = "#form-search";
	var viewOrderurl = "<c:url value='/order/orderProduct/viewPage'/>";
	var viewSpourl = "<c:url value='/order/orderSpo/viewPage'/>";
	var viewSampleurl = "<c:url value='/order/orderSample/viewPage'/>";
	var viewDiversityurl = "<c:url value='/order/orderDiversity/viewPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="order:orderProduct:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/order/orderToSap/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			sortname:'zdsj',
			sortorder:'desc',
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, frozen:true},
				{name:'sfBg', label:'sfBg', hidden: true, width:60, frozen:true},
				{name:'sfCh', label:'sfCh', hidden: true, width:60, frozen:true},
				{name:'sjc', label:'sjc', hidden: true, width:60, frozen:true},
				{name:'processId', label:'processId', hidden: true, width:60, frozen:true},
				{name:'taskId', label:'taskId', hidden: true, width:60, frozen:true},
				{name:'scjdmc', index:'scjdmc', label:'工厂/生产基地', width:110, frozen:true},
				{name:'ddid', index:'ddid', label:'订单号', width:110, frozen:true},
				{name:'bbh', index:'bbh', label:'版本号', width:50, frozen:true},
				{name:'zt', index:'zt',label:'订单状态', hidden:true, frozen:true},
				{name:'ztmc', index:'ztmc', label:'订单状态',width:80, frozen:true},
				{name:'zdrmc', index:'zdrmc', label:'制单人',width:80, frozen:true},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, frozen:true},
				{name:'ddlx', index:'ddlx', label:'订单类型', width:60,hidden:true},
				{name:'ddlxmc', index:'ddlxmc', label:'订单类型', width:60},
				{name:'ddlbmc', index:'ddlbmc', label:'订单类别', width:60},
				{name:'xszzmc', index:'xszzmc', label:'销售组织', width:80},
				{name:'ywzmc', index:'ywzmc', label:'业务组', width:80},
				{name:'xsymc', index:'xsymc', label:'销售员', width:80},
				{name:'gsbm', index:'gsbm', label:'公司', width:60},
				{name:'khbm', index:'khbm', label:'客户编码', width:70},
				{name:'khmc', index:'khmc', label:'客户名称', width:150},
				{name:'fktjmc', index:'fktjmc', label:'付款条件', width:120},
				{name:'pid', index:'pid', label:'PID', width:80},
				{name:'jhrq', index:'jhrq', label:'交货日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'sl', index:'sl', label:'订单数量', align:'right',width:80, formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'zje', index:'zje', label:'订单金额',align:'right', width:80, formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'yzhje', index:'yzhje', label:'已走货金额',align:'right', width:80, formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'fkbzzt', index:'fkbzzt', label:'付款保障状态', width:85, formatter:fkbzCellAddHref},
				{name:'bg_hwtssapzt', index:'bg_hwtssapzt', label:'变更-海外推送SAP状态', width:105, formatter: getbgTssapZt},
				{name:'bg_zztssapzt', index:'bg_zztssapzt', label:'变更-制造推送SAP状态', width:105, formatter: getbgTssapZt},
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态(原)', width:105, formatter:tsSAPCellAddHref},
				{name:'yddid', index:'yddid', label:'原订单号', width:110},
				{name:'sfFjelbg', index:'sfFjelbg', label:'辅助变更状态', width:80, formatter:getFzbgMC}
				]
		},{
			add:false,
			edit:false,
			del:false,
			viewfunc:viewfunc
		}).jqGrid('setFrozenColumns');
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"关闭", 
			buttonicon:"fa-square-o orange", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					$("body").bindSweetAlert({
						title:"海外:"+rowData.bg_hwtssapzt+",制造:"+rowData.bg_zztssapzt+",确定要关闭吗?"
					},{
						callback:function(){
							$.bindAjax({
								url:"<c:url value='/order/orderToSap/closeOrder'/>",
								data:{id : id, sjc : rowData.sjc,ddlx : rowData.ddlx},
								action:"save"
							},function(response){
								$(grid_selector).trigger("reloadGrid");
							});
						}
					})
				}
			},
			position:"last"
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"推送海外SAP", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.bg_hwtssapzt == "已推送"){
						swal("","请选择一行未推送海外sap的数据！","warning");
						return;
					}
					$.bindAjax({
						url:"<c:url value='/order/orderToSap/pushToHwSAP'/>",
						data:{id : id,ddlx :rowData.ddlx,sjc :rowData.sjc,ddid: rowData.ddid},
						action:"save"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
				}
			},
			position:"last"
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"推送制造SAP", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.bg_zztssapzt == "已推送"){
						swal("","请选择一行未推送制造sap的数据！","warning");
						return;
					}
					$.bindAjax({
						url:"<c:url value='/order/orderToSap/pushToZzSAP'/>",
						data:{id : id,ddlx :rowData.ddlx,sjc :rowData.sjc,ddid: rowData.ddid},
						action:"save"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
				}
			},
			position:"last"
		});
		<shiro:hasPermission name="order:orderToSap:addtssap">
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"以新增推送海外SAP", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.bg_hwtssapzt == "已推送"){
						swal("","请选择一行未推送海外sap的数据！","warning");
						return;
					}
					$.bindAjax({
						url:"<c:url value='/order/orderToSap/addpushToHwSAP'/>",
						data:{id : id,ddlx :rowData.ddlx,sjc :rowData.sjc,ddid: rowData.ddid},
						action:"save"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
				}
			},
			position:"last"
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"以新增推送制造SAP", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.bg_zztssapzt == "已推送"){
						swal("","请选择一行未推送制造sap的数据！","warning");
						return;
					}
					$.bindAjax({
						url:"<c:url value='/order/orderToSap/addpushToZzSAP'/>",
						data:{id : id,ddlx :rowData.ddlx,sjc :rowData.sjc,ddid: rowData.ddid},
						action:"save"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
				}
			},
			position:"last"
		});
		</shiro:hasPermission>
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		 //敲击回车响应查询
		$("body").keypress(function (e) {
			var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if (keyCode == 13){
				$(grid_selector).trigger("reloadGrid");
			}
		}); 
		//导出
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/order/orderProduct/export'/>"});
	    			}
	    		});
	        }
		});
	});
	
	function fkbzCellAddHref(cellvalue, options, rowData){
		var html = "<a onclick=\"fkbzCellShowLog('"+ rowData.id +"')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html = "已通过";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		}
		return html;
	}
	
	function fkbzCellShowLog(id){
		$.bindAjax({
			url:"<c:url value='/payment/payValidate/search'/>",
			data:{id:id},
			action:"search"
		},function(response){
			if(response[0]){
				bootbox.dialog({
					title : "付款保障检查日志",
					message : response[0].zy
				});
			}
		});
	}
	
	function tsSAPCellAddHref(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html = "已通过";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		} else if(cellvalue == "2"){
			html += "海外通过,制造失败</a>";
		} else if(cellvalue == "3"){
			html += "海外通过,制造不推</a>";
		}
		return html;
	}
	function getFzbgMC(cellvalue){
		if(cellvalue == 1){
			return "辅助变更中";
		}else{
			return "";
		}
	}
	function getbgTssapZt(cellvalue){
		if(cellvalue == 1){
			return "已推送";
		}else{
			return "未推送";
		}
	}
	function tssapCellShowLog(id){
		$.bindAjax({
			url:"<c:url value='/log/sapInterfaceLog/search'/>",
			data:{id:id},
			action:"search"
		},function(response){
			if(response[0]){
				bootbox.dialog({
					title : "推送SAP日志",
					message : response[0].fhxx
				});
			}
		});
	}
	
	function tsSAPCellToNumber(cellvalue){
		if(cellvalue == "已通过"){
			return "1";
		} else if(cellvalue.substring(cellvalue.indexOf('>')+1,cellvalue.lastIndexOf('<')) == "海外通过,制造失败"){
			return "2";
		} else if(cellvalue.substring(cellvalue.indexOf('>')+1,cellvalue.lastIndexOf('<')) == "未通过"){
			return "0";
		}else 
			return "-1";
	}
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		if(rowData.ddlx==1){
			location.href = viewOrderurl + "?id=" + id + "&processId=" + rowData.processId;
		}else if(rowData.ddlx==2){
			location.href = viewSpourl + "?id=" + id + "&processId=" + rowData.processId;
		}else if(rowData.ddlx==3){
			location.href = viewSampleurl + "?id=" + id + "&processId=" + rowData.processId;
		}else if(rowData.ddlx==4){
			location.href = viewDiversityurl + "?id=" + id + "&processId=" + rowData.processId;
		}
		
	}
</script>
</html>