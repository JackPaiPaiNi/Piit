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
		<div  id="grid-parent" class="col-xs-12">
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
										<label class="input-group-addon">订舱单号&nbsp;&nbsp;</label>
										<input type="text" name="dcdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出运类型&nbsp;&nbsp;</label>
										<select role="select" name="cylx" size="1" class="form-control skyselect">
								           	${fns:loadDictOption('CYLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">目的国家&nbsp;&nbsp;</label> <select
											role="select" name="xwgj" size="1" class="form-control skyselect ">
											${fns:loadCountryOption('0')}
										</select>
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
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="kh" class="form-control"/>
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
							<div class="space-4"></div>
							<div class="row">
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
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var grid_selector_dcxx = "#grid-table";
	var editurl="<c:url value='/booking/booking/editPage'/>";
	var viewurl ="<c:url value='/booking/booking/viewPageList'/>";
	var cancelurl = "<c:url value='/booking/booking/cancel'/>";
	var getbackurl = "<c:url value='/booking/booking/getback'/>";
	var isEdit = false;
	<shiro:hasPermission name="booking:booking:edit">isEdit=true;</shiro:hasPermission>
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		
 		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/booking/booking/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			sortname:'zdsj',
			sortorder:'desc',
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'sjc',label:'sjc',hidden:true,width:60,editable:false},
				{name :'processId',label:'processId',hidden:true,width:60,editable:false}, 
				{name:'scjdmc', index:'scjdmc',label:'生产基地名称', width:80 },
				{name:'dcdh', index:'dcdh',label:'订舱单号', width:120 },
				{name:'zt', index:'zt', label:'状态', width:80 ,edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('DJZT')}"}},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'cylx', index:'cylx', label:'出运类型', width:80,edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('CYLX')}"} },   
				{name:'qygmc', index:'qygmc', label:'起运港', width:80},
				{name:'mdg', index:'mdg', label:'目的港', width:80},
				{name:'xwgjmc', index:'xwgjmc', label:'目的国家', width:80},
				{name:'khbm', index:'dch', label:'客户编码', width:80},
				{name:'khmc', index:'dch', label:'客户名称', width:80},
				{name:'yssfcq', index:'yssfcq', label:'客户应收是否超期', width:80, edittype:"select",formatter: "select",
					editoptions:{value:"1:是;0:否"}}
			]
		},{
			add:false,
			edit:isEdit,
			edittext:'确认',
			del:isEdit,
			view:isEdit,
			editfunc:editfunc,
			delfunc:delfunc,
			viewfunc:viewfunc,
		}); 
 		<shiro:hasPermission name="booking:booking:edit">
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
							location.href = editurl + "?id=" + id +  "&&sfBg=1";
						}
					}
				},
				position:"last"
			});
	 		/*测试遗留单据删除代办用 
	 		$(grid_selector).navButtonAdd(pager_selector,{
				caption:"取回", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
				
							$("body").bindSweetAlert({
								title:"确定要取回吗?"
							},{
								callback:function(){
									$.bindAjax({
										url:getbackurl,
										data:{id:"1e7d83c7-a192-48fc-b2c5-6244c4a97aae",processId:"5366265"},
										action:"edit"
									},function(response){
										$(grid_selector).trigger("reloadGrid");
									});
								}
							});
							
						
					}
				},
				position:"last"
			}); */
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
	        	$("#export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/pi/pi/export'/>"});
	    			}
	    		});
	        }
		});
	});
	// 编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if(zt == 1){
				location.href = editurl +"?&id=" + selr;
			}else if (zt == 3){
				swal("","驳回的单据请从待办页面进行编辑","warning");
				return;
			}else {
				swal("","只有草稿单据才可编辑","warning");
				return;
			}
		}
	}
	// 删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		var processId = rowData.processId;
		if(selr==null||selr==""){
			swal("","请选择一条记录！","warning");
			return;
		}else{
			if (zt != 1 && zt != 3) {
				swal("", "只能删除草稿或驳回的单据!", "warning");
				return;
			} else {
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?"
	    		},{
	    			callback:function(){
	    				$.bindAjax({
	    					url:"<c:url value='/booking/booking/delete'/>",
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
	// 查看
	function viewfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		//location.href = viewurl + "?id=" + id+ "&processId=" + rowData.processId;
		window.open(viewurl + "?id=" + id+ "&processId=" + rowData.processId);
	}
</script>
</html>