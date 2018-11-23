<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<%@page import="com.ey.piit.core.utils.UserUtils"%>  
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
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
						<span class="widget-toolbar"> <a href="#"
							data-action="collapse"> <i class="icon-chevron-up"></i>
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
											<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
											<input type="text" name="yzhdh" class="form-control" />
											<input type ="hidden" name="yzhlx" value="2">
											<input type="hidden" name="sfDyhyzh" value="0">
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
											<input type="text" name="ddid" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">公司&nbsp;&nbsp;</label> <input
												type="text" name="gsbm" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">客户&nbsp;&nbsp;</label> <input
												type="text" name="khmc" class="form-control" />
										</div>
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
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
											<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
											<select role="select" name="scjd" size="1" class="form-control skyselect">
												${fns:loadDictOption('SCJD')}
											</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">状态&nbsp;&nbsp;</label> <select
												role="select" name="zt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('DJZT')}
											</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">是否订舱&nbsp;&nbsp;</label>
											<select role="select" name="sfDc" size="1" class="form-control skyselect">
												${fns:loadDictOption('SF')}
											</select>
										</div>
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">是否出货&nbsp;&nbsp;</label>
											<select role="select" name="sfCh" size="1" class="form-control skyselect">
												${fns:loadDictOption('SF')}
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
											<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
											<input type="text" name="xsymc" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">审核状态&nbsp;&nbsp;</label>
											<select role="select" name="smozt" size="1" class="form-control skyselect">
												<option value="0">全部</option>
												<option value="1">已审核</option>
												<option value="2">未审核</option>
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
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.page-content -->
</body>
<script type="text/javascript">
	
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var isEdit = false;
	var editurl = "<c:url value='/pso/spoPso/editPage'/>";
	var viewurl = "<c:url value='/pso/spoPso/viewPage'/>";
	var delurl = "<c:url value='/pso/spoPso/delete'/>";
	var changeurl = "<c:url value='/pso/spoPso/change'/>";
	var cancelurl = "<c:url value='/pso/spoPso/cancel'/>";
	var getbackurl = "<c:url value='/pso/spoPso/getback'/>";
	<shiro:hasPermission name="pso:spoPso:edit">isEdit = true;</shiro:hasPermission>
	/******************************页面控件加载开始***************************************************/
	$(function($) {
		$('.skyselect').select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			caption : "",
			url : "<c:url value='/pso/spoPso/search'/>",
			pager : pager_selector,
			gridParent : "#grid-parent",
			formSearch : "#form-search",
			sortname:'zdsj',
			sortorder:'desc',
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel : [ 
	             { name : 'id', label : 'ID', hidden : true, width : 60, editable : false }, 
	             { name : 'bbh', label : 'bbh', hidden : true, width : 60, editable : false }, 
	             { name : 'sjc', label : 'sjc', hidden : true, width : 60, editable : false }, 
	             { name : 'processId', label : 'processId', hidden : true, width : 60, editable : false }, 
	             { name : 'scjdmc', index : 'scjdmc', label : '生产基地', width : 80 }, 
	             { name : 'yzhdh', index : 'yzhdh', label : '预走货单号', width : 100 }, 
	             { name : 'zt', index : 'zt', label : '状态', width : 60, edittype:"select",  
	               formatter:"select", editoptions:{value:"${fns:loadDictEditOption('DJZT')}"} }, 
	             { name : 'zdsj', index : 'zdsj', label : '制单时间', width : 80, 
	               formatter : 'date', formatoptions : { newformat : 'Y-m-d' } }, 
	             { name : 'yzhlxmc', index : 'yzhlxmc', label : '预走货类型', width : 60 }, 
	             { name : 'gsbm', index : 'gsbm', label : '公司', width : 40 }, 
	             { name : 'khbm', index : 'khbm', label : '客户编码', width : 60 }, 
	             { name : 'khmc', index : 'khmc', label : '客户名称', width : 150 }, 
	             { name : 'xsymc', index : 'xsymc', label : '销售员', width : 80 }, 
	             { name : 'ywzmc', index : 'ywzmc', label : '业务组', width : 80 },
	             { name : 'xszzmc', index : 'xszzmc', label : '销售组织', width : 80 },
	             { name : 'zje', index : 'zje', label : '总金额', width : 70 },
	             { name : 'zdrmc', index : 'zdrmc', label : '制单人', width : 80 },
	             { name : 'fkbzzt', index : 'fkbzzt', label : '付款保障状态', width : 80, formatter:fkbzCellAddHref},
	             { name : 'smoshzt', index : 'smoshzt', label : 'SMO/SOS/MCO审核状态', width : 80, formatter:smoshCellShow},
	             {name:'sfDc', index:'sfDc', label:'是否订舱', width:55, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
	             {name:'sfCh', index:'sfCh', label:'是否出货', width:55, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}}
			  ]
		}, {
			add : isEdit,
			edit : isEdit,
			del : isEdit,
			view : isEdit,
			addfunc : addfunc,
			editfunc : editfunc,
			viewfunc : viewfunc,
			delfunc	: delfunc
		});
		<shiro:hasPermission name="pso:spoPso:edit">
			/* $(grid_selector).navButtonAdd(pager_selector,{
				caption:"付款保障检查", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt != 4){
							swal("","请选择一行审批通过的数据！","warning");
							return;
						}
						$.bindAjax({
							url:"<c:url value='/payment/payValidate/checkPso'/>",
							data:{id:id},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				},
				position:"last"
			}); */
			/* $(grid_selector).navButtonAdd(pager_selector,{
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
			}); */
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
		</shiro:hasPermission>
		<shiro:hasPermission name="pso:spoPso:smoApprove">
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"SMO/SOS/MCO审核", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5 || rowData.smoshzt != "未审核"){
						swal("","请选择一行已生效且未进行SMO/SOS/MCO审核的数据！","warning");
						return;
					}
					$.bindAjax({
						url:"<c:url value='/pso/spoPso/smoApprove'/>",
						data:{id:id, sjc:rowData.sjc},
						action:"save"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
				}
			},
			position:"last"
		});
		</shiro:hasPermission>
		
		// 查询
		$("#btn-search").click(function() {
			$(grid_selector).trigger("reloadGrid");
		});
		//回车键响应
		 $("body").keypress(function (e) {
				var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
				if (keyCode == 13){
					$(grid_selector).trigger("reloadGrid");
				}
		}); 
		// 导出
		$("#export").click(function() {
			var curNum = $(grid_selector).getGridParam("records");
			if (curNum == 0) {
				swal("结果集为空不能导出", "", "warning");
				return false;
			} else {
				$("#export").bindSweetAlert({
					title : "确定要导出吗?",
					closeOnConfirm : true
				}, {
					callback : function() {
						$(grid_selector).exportExcel({
							url : "<c:url value='/pso/tvPso/export'/>"
						});
					}
				});
			}
		});

	});
	// 新增
	function addfunc() {
		location.href =editurl;
	}
	 // 编辑
	function editfunc() {
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if(zt == 1){
				var id = jQuery(grid_selector).jqGrid('getGridParam', 'selrow');
				location.href = editurl + "?id=" + id;
			}else if (zt == 3){
				swal("","驳回的单据请从待办页面进行编辑","warning");
				return;
			}else {
				swal("","只有草稿单据才可编辑","warning");
				return;
			}
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
	    					data:{id:rowData.id,sjc :rowData.sjc, zt : zt, processId : processId},
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
	function viewfunc() {
		var id = jQuery(grid_selector).jqGrid('getGridParam', 'selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		//location.href = viewurl + "?id=" + id + "&processId=" + rowData.processId;
		window.open(viewurl + "?id=" + id + "&processId=" + rowData.processId);
	}
	
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
	function smoshCellShow(cellvalue, options, rowData){
		var html = "";
		if(cellvalue == 1){
			html = "已审核";
		} else {
			html = "未审核";
		}
		return html;
	}
</script>
</html>