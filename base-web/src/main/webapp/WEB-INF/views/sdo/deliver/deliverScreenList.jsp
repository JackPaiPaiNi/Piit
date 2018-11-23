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
										<label class="input-group-addon">出货通知书单号&nbsp;&nbsp;</label>
										<input type="text" name="chdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货通知书单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
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
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddh" class="form-control"/>
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
										<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<input type="text" name="zdsj" readonly="readonly" class="form-control timeInterval"/>
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
	var editurl = "<c:url value='/deliver/deliver/editPage'/>";
	var viewurl = "<c:url value='/deliver/deliver/viewPage'/>";
	var cancelurl = "<c:url value='/deliver/deliver/cancel'/>";
	var isEdit = false;
	<shiro:hasPermission name="deliver:deliver:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/deliver/deliver/screenSearch'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			sortname:'chdh',
			sortorder:'desc',
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'scjdmc', index:'scjdmc', label:'生产基地名称', width:80},
				{name:'chdh', index:'chdh', label:'出货通知书单号', width:90},
				{name:'bbh', index:'bbh', label:'版本号', width:60},
				{name:'zt', label:'状态', hidden: true, width:60},
				{name:'ztmc', index:'ztmc', label:'状态', width:60},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:80},
				{name:'zgrq', index:'zgrq', label:'装柜日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'cylxmc', index:'cylxmc', label:'出运类型', width:80},
				{name:'zdrmc', index:'zdrmc', label:'制单人', width:80},
				{name:'sjc', label:'SJC', hidden: true, width:60, editable:false},
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:105, formatter:tsSAPCellAddHref},
				{name:'sfYfyj', index:'sfYfyj', label:'是否已发邮件', width:120, edittype:"select", formatter: "select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
				{name:'gsbm', label:'gsbm', hidden: true}
			]
		},{
			add:false,
			edit:isEdit,
			view:isEdit,
			del:isEdit,
			editfunc:editfunc,
			viewfunc:viewfunc,
			delfunc:delfunc
		});
		<shiro:hasPermission name="deliver:deliver:edit">
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"变更", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = $(grid_selector).jqGrid("getGridParam", "selrow");
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					} else {
						var rowData = $(grid_selector).jqGrid('getRowData', id);
						if(rowData.zt != 5){
							swal("","请选择一行已生效数据！","warning");
							return;
						} else {
							var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
							location.href = editurl + "?id=" + id + "&sjc=" + rowData.sjc + "&&sfBg=1";
/* 							$.bindAjax({
								url:"<c:url value='/deliver/deliver/pushSAP'/>",
								data:{id : id,tssaplx : 2,sjc : rowData.sjc},
								action:"edit"
							},function(response){
								location.href = editurl + "?id=" + id + "&sjc=" + rowData.sjc + "&&sfBg=1";
							}); */
						}
					}
				},
				position:"last"
			});
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"推送SAP", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
						return;
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt != 5 || rowData.tssapzt == "已通过"){
							swal("","请选择一行已生效且未推送sap的数据！","warning");
							return;
						}
						$.bindAjax({
							url:"<c:url value='/deliver/deliver/pushSAP'/>",
							data:{id:id,sjc:rowData.sjc,chdh:rowData.chdh ,tssaplx : 1},
							action:"save"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				},
				position:"last"
			});
			
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"发送邮件", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
						return;
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						if(rowData.zt != 5 || rowData.tssapzt != "已通过"){
							swal("","请选择一行已生效且推送sap成功的数据进行邮件发送！","warning");
							return;
						}
						$.bindAjax({
							url:"<c:url value='/deliver/deliver/sendEmail'/>",
							data:{id : id, gsbm : rowData.gsbm},
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
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		$("body").keypress(function (e) {
			var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if (keyCode == 13){
				$(grid_selector).trigger("reloadGrid");
			}
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/deliver/deliver/screenExport'/>"});
	    			}
	    		});
	        }
		});
		
	});
	
	// 编辑
	function editfunc(){
		var id = $(grid_selector).jqGrid("getGridParam", "selrow");
		var rowData = $(grid_selector).jqGrid('getRowData', id);
		if(rowData.zt != 1){
			swal("","只允许修改草稿！","warning");
			return;
		} else {
			location.href = editurl + "?id=" + id;
		}
	}
	
	// 查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		//location.href = viewurl + "?id=" + id;
		window.open(viewurl + "?id=" + id);
	}
	
	// 删除
	function delfunc(){
		var selr = $(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = $(grid_selector).jqGrid('getRowData',selr);
		if(selr == null || selr == ""){
			swal("", "请选择一行数据！", "warning");
			return;
		}else{
			if (rowData.zt != 1) {
				swal("", "只能删除草稿!", "warning");
				return;
			}else{
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?"
	    		},{
	    			callback:function(){
	    				$.bindAjax({
	    					url:"<c:url value='/deliver/deliver/delete'/>",
	    					data:{id:rowData.id,sjc :rowData.sjc},
	    					action:"edit"
	    				},function(response){
	    					$(grid_selector).trigger("reloadGrid");
	    				}); 
	    			}
	    		});
			}
		}
	}
	
	function tsSAPCellAddHref(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html = "已通过";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
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
</script>
</html>