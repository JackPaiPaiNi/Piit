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
										<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
										<input type="text" name="xsymc" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单类别&nbsp;&nbsp;</label>
										<select role="select" name="ddlb" size="1" class="form-control skyselect">
											
											${fns:loadDictOption('DDLB_BS')}
										</select>
									</div>
								</div>
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
										<label class="input-group-addon">订单状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											
											${fns:loadDictOption('DJZT')}
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
							</div>
							<div class="space-4"></div>
							<div class="row">
							    <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
										<select role="select" name="scjd" size="1" class="form-control skyselect">
											${fns:loadDictOption('SCJD')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
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
										<label class="input-group-addon">原订单号&nbsp;&nbsp;</label>
										<input type="text" name="yddid" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PI号&nbsp;&nbsp;</label>
										<input type="text" name="piid" class="form-control"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<table id="grid-table"></table>
			
			<div id="grid-pager"></div>
			
			<div id="grid-parent-wlxx" hidden="hidden">
				<table id="grid-table-wlxx"></table>
				<div id="grid-pager-wlxx"></div>
			</div>
			

			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
<div id="consoleDlg" class="page-content" >
 <hr cellspacing="0" cellpadding="0">
 <div id="formContainer" class="row">
    <div class="col-xs-12">
     	<form id="consoleForm">
     	     <input type="hidden"  name="id"  />
     	     <input type="hidden"  name="sjc"  />
     	     <input type="hidden"  name="type"  />
      	 <div class="row">
			<div class="col-xs-6 col-sm-12">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">取消备注&nbsp;&nbsp;</label> 
					<textarea name="qxbz" class="autosize-transition form-control" ></textarea>
				</div>
			</div>
      	 </div>
      	 <div class="space-4"></div>
      	 <div class="row">
      	 	 <div class="col-xs-6 col-sm-12" align="center">
				<button id="btn_ok" type="button" class="btn btn-info  btn-minier bigger" onclick="cancel()">
					<i class="icon-ok icon-on-left bigger-110"></i>
					确定
				</button> 
				&nbsp;&nbsp;&nbsp;
			    <button id="btn_cancel" type="button" class="btn btn-danger btn-minier bigger"  onclick="back()">
					 <i class="fa-times icon-on-right bigger-110"></i>
					返回
				</button> 
			</div>
      	 </div>
     	</form>
    	</div>
    </div>
 </div>
</body>
<script type="text/javascript">
    var grid_wlxx_selector = "#grid-table-wlxx";
    var pager_wlxx_selector = "#grid-pager-wlxx";
	
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	var editurl = "<c:url value='/order/orderSpo/editPage'/>";
	var viewurl = "<c:url value='/order/orderSpo/viewPage'/>";
	var changeurl = "<c:url value='/order/orderSpo/change'/>";
	var cancelurl = "<c:url value='/order/orderSpo/cancel'/>";
	var getbackurl = "<c:url value='/order/orderSpo/getback'/>";
	var changeEditurl = "<c:url value='/order/orderSpo/changeEditPage'/>";
	var isEdit = false;
	var isChdelete = false;
	<shiro:hasPermission name="order:orderSpo:chdelete">isChdelete=true;</shiro:hasPermission>
	<shiro:hasPermission name="order:orderSpo:edit">isEdit=true;</shiro:hasPermission>
	$(function($) {
		// 配置模态对话框
		$("#consoleDlg").dialog({
		autoOpen : false, // 是否自动弹出窗口
		modal : true, // 设置为模态对话框
		resizable : true,
		width : 600,
		height : 220,
		position : "center" // 窗口显示的位置
		});
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/order/orderSpo/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			sortname:'zdsj',
			sortorder:'desc',
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, frozen:true},
				{name:'sjc', label:'SJC', hidden: true, width:60, frozen:true},
				{name:'sfBg', label:'sfBg', hidden: true, width:60, frozen:true},
				{name:'sfCh', label:'sfCh', hidden: true, width:60, frozen:true},
				{name:'processId', label:'processId', hidden: true, width:60, frozen:true},
				{name:'taskId', label:'taskId', hidden: true, width:60, frozen:true},
				{name:'scjdmc', index:'scjdmc', label:'生产基地', width:110, frozen:true},
				{name:'ddid', index:'ddid', label:'订单号', width:110, editoptions:{readonly:"true"}, frozen:true},
				{name:'bbh', index:'bbh', label:'版本号', hidden: true, width:60, frozen:true},
				{name:'zt', index:'zt', label:'订单状态', width:80, hidden:true, frozen:true},
				{name:'ztmc', index:'ztmc', label:'订单状态', width:80, frozen:true},
				{name:'ddlbmc', index:'ddlbmc', label:'订单类别', width:100},
				{name:'jhrq', index:'jhrq', label:'交货日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zsl', index:'sl', label:'订单数量', width:80, align:'right',formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'fkbzzt', index:'fkbzzt', label:'付款保障状态', width:85, formatter:fkbzCellAddHref},
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:105, formatter:tsSAPCellAddHref},
				<shiro:hasPermission name="order:orderSpo:price">
				{name:'zje', index:'zje', label:'订单金额', width:80, align:'right',formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'yzhje', index:'yzhje', label:'已走货金额',align:'right', width:80, formatter:'number',formatoptions:{thousandsSeparator: ','}},
				</shiro:hasPermission>
				{name:'zdrmc', index:'zdrmc', label:'制单人', width:80, frozen:true},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d H:i:s'}},
				{name:'xszzmc', index:'xszzmc', label:'销售组织', width:80},
				{name:'ywzmc', index:'ywzmc', label:'业务组', width:80},
				{name:'xsymc', index:'xsymc', label:'销售员', width:80},
				{name:'gsbm', index:'gsbm', label:'公司', width:60},
				{name:'khbm', index:'khbm', label:'客户编码', width:70},
				{name:'khmc', index:'khmc', label:'客户名称', width:150},
				{name:'fktjmc', index:'fktjmc', label:'付款条件', width:120},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'yddid', index:'yddid', label:'原订单号', width:110, editoptions:{readonly:"true"}},
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
			addfunc:addfunc,
			editfunc:editfunc,
			delfunc: delfunc,
			viewfunc:viewfunc
		}).jqGrid('setFrozenColumns');
		<shiro:hasPermission name="order:orderSpo:edit">
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"变更", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt != 5){
							swal("","请选择一行已生效数据！","warning");
							return;
						} else {
							$("body").bindSweetAlert({
								title:"确定要变更吗?"
							},{
								callback:function(){
									$.bindAjax({
										url:changeurl,
										data:{id:id, sjc:rowData.sjc},
										action:"edit"
									},function(response){
										$(grid_selector).trigger("reloadGrid");
									});
								}
							});
						}
					}
				},
				position:"last"
			});
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"取回", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt == 2 || rowData.zt == 4 || rowData.zt == 3){
							$("body").bindSweetAlert({
								title:"确定要取回吗?"
							},{
								callback:function(){
									$.bindAjax({
										url:getbackurl,
										data:{id:id, sjc:rowData.sjc, processId:rowData.processId},
										action:"edit"
									},function(response){
										$(grid_selector).trigger("reloadGrid");
									});
								}
							});
							
						} else{
							swal("","请选择一行审批中或审批通过的单据！","warning");
						}
					}
				},
				position:"last"
			});
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"撤回", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt != 5){
							swal("","请选择一行已生效数据！","warning");
							return;
						} else {
							$("body").bindSweetAlert({
								title:"确定要撤回吗?"
							},{
								callback:function(){
									$.bindAjax({
										url:cancelurl,
										data:{id:id, sjc:rowData.sjc, type:2},
										action:"edit"
									},function(response){
										$(grid_selector).trigger("reloadGrid");
									});
								}
							});
						}
					}
				},
				position:"last"
			});
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"取消", 
				buttonicon:"fa-square-o orange", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt != 5){
							swal("","请选择一行已生效数据！","warning");
						} else{
							initDlg(rowData,1);
							/* $("body").bindSweetAlert({
								title:"确定要取消吗?"
							},{
								callback:function(){
									$.bindAjax({
										url:cancelurl,
										data:{id:id, sjc:rowData.sjc, type:1},
										action:"edit"
									},function(response){
										$(grid_selector).trigger("reloadGrid");
									});
								}
							}); */
						}
					}
				},
				position:"last"
			});
			/* $(grid_selector).navButtonAdd(pager_selector,{
				caption:"付款保障检查", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt != 4 && rowData.tssapzt != "已通过"){
							swal("","请选择一行审批通过且未推送sap的数据！","warning");
							return;
						}
						$.bindAjax({
							url:"<c:url value='/payment/payValidate/checkOrder'/>",
							data:{id:id, ddlx:2},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				},
				position:"last"
			}); */
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"推送SAP", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt != 4 || rowData.fkbzzt != "已通过" || rowData.tssapzt == "已通过"){
							swal("","请选择一行审批通过且付款保障状态通过且未推送sap的数据！","warning");
							return;
						}
						$.bindAjax({
							url:"<c:url value='/order/orderSpo/pushSAP'/>",
							//data:{ ddid : rowData.ddid, id : id, sjc : rowData.sjc,tssapzt : tsSAPCellToNumber(rowData.tssapzt) },
							data:{id : id},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				},
				position:"last"
			});
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"备损明细导出", 
				buttonicon:"fa-download blue", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						$(grid_wlxx_selector).exportExcelNoData({url: "<c:url value='/order/orderSpo/itemExport'/>"+"?id="+rowData.id});
					}
				},
				position:"last"
			});
		</shiro:hasPermission>
		
		// 查询
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
		// 导出
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/order/orderSpo/export'/>"});
	    			}
	    		});
	        }
		});
		//备损物料明细导出
		$(grid_wlxx_selector).bindTable({
			caption: "",
			pager: pager_wlxx_selector,
			gridParent: "#grid-parent-wlxx",
			rowList: [5, 10, 15],
		    rowNum:5,
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
						{name:'id', label:'ID'},
						{name:'piid', index:'piid', label:'PI号' },
						/* {name:'piitemid', index:'piitemid', label:'PI明细id'}, */
						/* {name:'wllx', index:'wllx', label:'物料类型'}, */
						{name:'wlbh', index:'wlbh', label:'物料编码'},
						{name:'wlms', index:'wlms', label:'物料描述'},
						{name:'bz', index:'bz', label:'币种'},
						{name:'dw', index:'dw', label:'单位'},
						{name:'sl', index:'sl', label:'数量',formatter:'number'},
					    {name:'dj', index:'dj', label:'单价（含税）',formatter:'number'},
						{name:'je', index:'je', label:'总金额',formatter:'number'},
						{name:'ckddh', index:'ckddh', label:'参考订单'},
						{name:'jixing', index:'jixing', label:'机型'},
						{name:'jixin', index:'jixin', label:'机芯'}
					]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit
			
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
	
	//新增
	function addfunc(){
		location.href = editurl;
	}
	
	function tsSAPCellAddHref(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html = "已通过";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		} else if(cellvalue == "2"){
			html += "海外通过,制造失败</a>";
		}else if(cellvalue == "3"){
			html += "海外通过,制造不推</a>";
		}
		return html;
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
	
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		var processId = rowData.processId;
		if(selr == null || selr == ""){
			swal("", "请选择一行数据！", "warning");
			return;
		}else{
			if(!isChdelete){
				if(rowData.sfCh == 1 ){
					swal("", "已生效再撤回的草稿不能删除!", "warning");
					return;
				}
			}
			if (zt != 1 && zt != 3) {
				swal("", "只能删除草稿或驳回的单据!", "warning");
				return;
			}else{
				$("body").bindSweetAlert({
					title:"确定要删除吗?"
				},{
					callback:function(){
						$.bindAjax({
							url:"<c:url value='/order/orderSpo/delete'/>",
							data:{id:rowData.id,sjc :rowData.sjc, zt: zt, processId: processId},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
			}
		}
	}
	
	//编辑
	function editfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		var zt = rowData.zt;
		var sfBg = rowData.sfBg;
		if(zt == 1){
			if(sfBg == 1){
				location.href = changeEditurl + "?id=" + id;
			}else{
				location.href = editurl + "?id=" + id;
			}
		}else if (zt == 2) {
			swal("", "审批中的单据不可修改！", "warning");
			return;
		}else if (zt == 3){
			swal("","驳回的单据请从待办页面进行编辑","warning");
			return;
		}else if (zt == 4 || zt == 5) {
			swal("", "审批通过或已生效的单据不可修改！", "warning");
			return;
		}
	}
	
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		//location.href = viewurl + "?id=" + id + "&processId=" + rowData.processId;
		window.open(viewurl + "?id=" + id + "&processId=" + rowData.processId);
	}
	//初始化对话框数据
	function initDlg(rowData,type){
		$('#consoleDlg [name=type]').val(type);
		$('#consoleDlg [name=id]').val(rowData.id);
		$('#consoleDlg [name=sjc]').val(rowData.sjc);
		$("#consoleDlg").dialog("option", "title", "订单取消").dialog("open");
	}
	//返回
    function back(){
    	$("#consoleDlg input").attr("value","");
    	$('#consoleDlg [name=qxbz]').val("");
    	$("#consoleDlg").dialog("close")
	}
    //取消
	function cancel(){
	    var param = $("#consoleForm").getFormData();
	    back();
		$("body").bindSweetAlert({
			title:"确定要取消吗?取消后将不允许恢复！"
		}, {
			callback : function() {
				$.bindAjax({
					url:cancelurl,
					data : param,
					action:"edit"
				},function(response){
					$(grid_selector).trigger("reloadGrid");
				});
			}
	   });
	}
</script>
</html>