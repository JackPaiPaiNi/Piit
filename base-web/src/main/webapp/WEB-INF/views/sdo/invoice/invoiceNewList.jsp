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
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
										<input type="text" name="fph" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">提单号&nbsp;&nbsp;</label>
										<input type="text" name="tdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('FPZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
							</div>
							<div class='space-4'></div>
							<div class="row">
							<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票时间&nbsp;&nbsp;</label>
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
										<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
							</div>
							<div class='space-4'></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出货单号&nbsp;&nbsp;</label>
										<input type="text" name="chdh" class="form-control"/>
									</div>
								</div>
							</div>
							<!-- <div class='space-4'></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">冲销日期（冲销才填）&nbsp;&nbsp;</label> <input
											type="text" name="cxrq" class="form-control date-picker" /> <span
											class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div> -->
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
	var editurl = "<c:url value='/invoice/invoicenew/editPage'/>";
	var viewurl = "<c:url value='/invoice/invoicenew/viewPage'/>";
	var delurl = "<c:url value='/invoice/invoicenew/delete'/>";
	var searchurl= "<c:url value='/invoice/invoicenew/search'/>";
	var expurl = "<c:url value='/invoice/invoicenew/export'/>";
	var isEdit = false;
	<shiro:hasPermission name="invoice:invoice:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
	  	// 日期控件绑定
		$(".date-picker").bindDate();
		$(grid_selector).bindTable({
			caption: "",
			url: searchurl,
			editurl: delurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			sortname: 'zdsj',
			sortorder: 'desc',
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'sjc', label:'SJC', hidden: true, width:20, editable:false},
				{name:'id', label:'ID', hidden: true, width:20, editable:false},
				{name:'fph', index:'fph', label:'发票号', width:180},
				{name:'fprq', index:'fprq', label:'发票日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'gsmc', index:'gsmc', label:'公司名称', width:110},
				{name:'khmc', index:'khmc', label:'客户名称', width:160},
				{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:80},
				{name:'fktjmc', index:'fktjmc', label:'付款条件', width:160},
				{name:'tdh', index:'tdh', label:'提单号', width:140},
				{name:'zt', index:'zt', label:'状态', width:60 ,edittype:"select", 
					formatter:"select", editoptions:{value:"${fns:loadDictEditOption('FPZT')}"}},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zdrmc', index:'zdrmc', label:'制单人', width:90},
				{name:'tssapzt_syfp', index:'tssapzt_syfp', label:'推商业发票状态', width:80, formatter:tsSAPCellAddHref_syfp},
				{name:'tssapzt_gsjfp', index:'tssapzt_gsjfp', label:'推公司间发票状态', width:80, formatter:tsSAPCellAddHref_gsjfp}
				/* {name:'gztssapzt', index:'gztssapzt', label:'海运费推送SAP状态', width:90, formatter:gztsSAPCellAddHref} */
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
		<shiro:hasPermission name="invoice:invoice:edit">
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"推商业发票", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(!(rowData.zt ==2 && rowData.tssapzt != "已通过" )){
						swal("","请选择一行已终稿且未推送SAP状态的数据！","warning");
						return;
					}
					$("body").bindSweetAlert({
		    			title:"确定要推商业间发票到SAP?",
		    			closeOnConfirm: true
		    		},{
		    			callback:function(){
		    				$.bindAjax({
								url:"<c:url value='/invoice/invoicenew/pushSAP'/>",
								data:{id:id, sjc:rowData.sjc,fplx:1},
								action:"edit"
							},function(response){
								$(grid_selector).trigger("reloadGrid");
							});
		    			}
		    		});
					
				}
			},
			position:"last"
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"推公司间发票", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(!(rowData.zt ==2 && rowData.tssapzt != "已通过")){
						swal("","请选择一行已终稿且未推送SAP状态的数据！","warning");
						return;
					}
					if(rowData.tssapzt_gsjfp == "不需要推"){
						swal("","该发票不需要推送公司间发票到SAP！","warning");
						return;
					}
					$("body").bindSweetAlert({
		    			title:"确定要推公司间发票到SAP?",
		    			closeOnConfirm: true
		    		},{
		    			callback:function(){
		    				$.bindAjax({
								url:"<c:url value='/invoice/invoicenew/pushSAP'/>",
								data:{id:id, sjc:rowData.sjc,fplx:2},
								action:"edit"
							},function(response){
								$(grid_selector).trigger("reloadGrid");
							});
		    			}
		    		});
					
				}
			},
			position:"last"
		});
		/* $(grid_selector).navButtonAdd(pager_selector,{
			caption:"推工装运费", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(!(rowData.zt ==2 && rowData.gztssapzt != "已通过") ){
						swal("","请选择一行已终稿且工装海运费未全部推送SAP状态的数据！","warning");
						return;
					}
					$("body").bindSweetAlert({
		    			title:"确定要推工装运费?",
		    			closeOnConfirm: true
		    		},{
		    			callback:function(){
		    				$.bindAjax({
								url:"<c:url value='/invoice/invoicenew/pushChargesToSAP'/>",
								data:{id:id, sjc:rowData.sjc},
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
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt !=2){
						swal("","请选择一行已终稿的数据！","warning");
						return;
					}
					/*var cxrq = 	$('#form-search [name=cxrq]').val();
					 if( cxrq == "" ){
						swal("","请选择冲销日期！","warning");
						return;
					} */
					$("body").bindSweetAlert({
		    			title:"确定要取消发票，系统会先自动冲销SAP销售发票和公司间发票，冲销成功后才会取消此商业发票？",
		    			closeOnConfirm: true
		    		},{
		    			callback:function(){
		    				//加载层-风格2
		    				$.bindAjax({
								url:"<c:url value='/invoice/invoicenew/cancle'/>",
								data:{id:id, sjc:rowData.sjc,fph:rowData.fph,cxrq:""},
								action:"edit"
							},function(response){
								$(grid_selector).trigger("reloadGrid");
							});
		    			}
		    		});
					
				}
			},
			position:"last"
		});
		
	
		</shiro:hasPermission>
		
		<shiro:hasPermission name="invoice:invoice:changeFpzt">	
		//修改发票推送状态
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"修改推送状态", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(!(rowData.zt ==2 && rowData.tssapzt != "已通过")){
						swal("","请选择一行已终稿且未推送SAP状态的数据！","warning");
						return;
					}
					$("body").bindSweetAlert({
		    			title:"确定要修改推送状态吗?",
		    			closeOnConfirm: true
		    		},{
		    			callback:function(){
		    				$.bindAjax({
								url:"<c:url value='/invoice/invoicenew/changeFpzt'/>",
								data:{id:id, sjc:rowData.sjc},
								action:"edit"
							},function(response){
								$(grid_selector).trigger("reloadGrid");
							});
		    			}
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
	            swal("","结果集为空不能导出","warning");
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
		location.href = editurl;
	}
	
	//编辑
	function editfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		if(rowData.zt == 6){
			swal("", "取消的发票不能再修改!", "warning");
			return;
		}else{
			location.href = editurl + "?id=" + id+"&zt="+rowData.zt;
			
		}
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
			if (zt != 1) {
				swal("", "只能删除草稿!", "warning");
				return;
			} else {
				$("body").bindSweetAlert({
					title : "确定要删除吗?"/* ,
					closeOnConfirm : true */
				}, {
					callback : function() {
						$.bindAjax({
							url : delurl,
							data : {
								id : rowData.id,
								sjc : rowData.sjc
							},
							action : "edit"
						}, function(response) {
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
			}
		}
	}
	
	//查看
	function viewfunc() {
		var selr = jQuery(grid_selector).jqGrid('getGridParam', 'selrow');
		location.href = viewurl + "?id=" + selr;
	}
	
	//查看推送SAP日志
	function tsSAPCellAddHref_syfp(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"','1')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html += "已通过</a>";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		}else if(cellvalue == "2"){
			html += "已冲销</a>";
		} else {
			html = "";
		}
		return html;
	}
	
	function tsSAPCellAddHref_gsjfp(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"','2')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html += "已通过</a>";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		}else if(cellvalue == "2"){
			html += "已冲销</a>";
		}else if(cellvalue == "3"){
			html += "不需要推</a>";
		} else {
			html = "";
		}
		return html;
	}
	
	function gztsSAPCellAddHref(cellvalue, options, rowData){
		if(cellvalue == "1"){
			return "已通过";
		} else if(cellvalue == "2"){
			return "部分通过";
		}else if(cellvalue == "0"){
			return "未通过";
		} else{
			return "";//空或者3 都显示为空
		}
	}
	
	function tssapCellShowLog(id,fplx){
		var width = 900;
		var height = 400;
		var left = (window.screen.width-width)/2;
		var top = (window.screen.height-height)/2;
		var pageUrl = "<c:url value='/invoice/invoicenew/searchInvoiceDzb'/>?id="+id+"&fplx="+fplx;
		if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
			var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
			 window.showModalDialog(pageUrl,null,dialogArgs);
		}else{
			var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
			window.open(pageUrl,null,dialogArgs);
		}

	}
</script>
</html>