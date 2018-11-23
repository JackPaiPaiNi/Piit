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
								<input type="hidden" name="sfDyhpi" value="1">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PI号&nbsp;&nbsp;</label>
										<input type="text" name="piid" class="form-control smaller"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">公司&nbsp;&nbsp;</label>
										<select role="select" id="gsbm" name="gsbm" size="1" class="form-control skyselect">
											${fns:loadCompanyOption('0')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
										<input type="text" name="xsymc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
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
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('DJZT')}
										</select>
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
	var editurl = "<c:url value='/pi/piDiversity/editPage'/>";
	var viewurl = "<c:url value='/pi/piDiversity/viewPage'/>";
	var delurl = "<c:url value='/pi/piDiversity/delete'/>";
	var searchurl= "<c:url value='/pi/piDiversity/screenSearch'/>";
	var expurl = "<c:url value='/pi/piDiversity/screenExport'/>";
	var changeurl = "<c:url value='/pi/piDiversity/change'/>";
	var bfchangeurl = "<c:url value='/pi/piDiversity/bfchange'/>";
	var cancelurl = "<c:url value='/pi/piDiversity/cancel'/>";
	var getbackurl = "<c:url value='/pi/piDiversity/getback'/>";
	var isEdit = false;
	<shiro:hasPermission name="pi:piDiversity:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			caption: "",
			url: searchurl,
			editurl: delurl,
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
				{name:'sjc', label:'SJC', hidden: true, width:60, editable:false},
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name :'processId',label:'processId',hidden:true,width:60,editable:false}, 
				/* {name:'scjdmc', index:'scjdmc', label:'生产基地', width:80}, */
				{name:'piid', index:'piid', label:'PI号', width:100},
				{name:'zt', index:'zt', label:'状态', hidden:true},
				{name:'ztmc', index:'ztmc', label:'状态名称',width:70},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:70, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'xszzmc', index:'xszzmc', label:'销售组织', width:80},
				{name:'ywzmc', index:'ywzmc', label:'业务组', width:80},
				{name:'xsymc', index:'xsymc', label:'销售员', width:80},
				{name:'gsbm', index:'gsbm', label:'公司', width:80},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:150},
				{name:'fktjmc', index:'fktjmc', label:'付款条件', width:120},
				 <shiro:hasPermission name="pi:piDiversity:price"> 	
				{name:'zje', index:'zje', label:'总金额',align:'right', width:100, formatter:'number',formatoptions:{thousandsSeparator: ','}},
				 </shiro:hasPermission> 	
				{name:'bz', index:'bz', label:'币种', width:40},
				{name:'zdrmc', index:'zdrmc', label:'制单人', width:80}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
			delfunc:delfunc,
			addfunc:addfunc,
			editfunc: editfunc,
			viewfunc:viewfunc
		});
		<shiro:hasPermission name="pi:piDiversity:edit">
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
			caption:"部分变更", 
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
									url:bfchangeurl,
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
						$("body").bindSweetAlert({
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
					if(rowData.zt == 2 || rowData.zt == 3){
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
						swal("","请选择一行审批中的单据！","warning");
					}
				}
			},
			position:"last"
		});
		</shiro:hasPermission>
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		//回车键响应
		 $("body").keypress(function (e) {
				var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
				if (keyCode == 13){
					$(grid_selector).trigger("reloadGrid");
				}
		}); 
		// 文件导出
		$("#export").click(function(){
		    var curNum=$(grid_selector).getGridParam("records");
		    if(curNum==0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("body").bindSweetAlert({
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
		location.href = editurl+ "?sfDyhp=1";
	}
	
	//编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(zt == 1){
			location.href = editurl + "?id=" + selr;
		}else if (zt == 2) {
			swal("", "该PI正在审批中,不能修改！", "warning");
			return;
		}else if (zt == 3){
			swal("","驳回的PI请从待办页面进行编辑","warning");
			return;
		}else if (zt == 4 || zt == 5) {
			swal("", "该PI已生效,不能修改！", "warning");
			return;
		} 
	}
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		var processId = rowData.processId;
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (zt != 1 && zt != 3) {
				swal("", "只能删除草稿或驳回的单据!", "warning");
				return;
			}else{
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$.bindAjax({
	    					url:delurl,
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
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		//location.href = viewurl + "?id=" + id + "&processId=" + rowData.processId;
		window.open(viewurl + "?id=" + id + "&processId=" + rowData.processId);
	}
</script>
</html>