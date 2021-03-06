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
										<input type="text" name="conditionFph" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">提单号&nbsp;&nbsp;</label>
										<input type="text" name="conditionTdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="conditionZt" size="1" class="form-control skyselect">
											${fns:loadDictOption('FPZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="conditionKh" class="form-control"/>
									</div>
								</div>
							</div>
							<div class='space-4'></div>
							<div class="row">
							<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="conditionZdr" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票时间&nbsp;&nbsp;</label>
										<input type="text" name="conditionZdsj" class="form-control timeInterval"/>
										<input type="hidden" id="conditionSDdDate" name="conditionSDdDate"/>
										<input type="hidden" id="conditionEDdDate" name="conditionEDdDate"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="conditionDdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出货单号&nbsp;&nbsp;</label>
										<input type="text" name="conditionChdh" class="form-control"/>
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
	var editurl = "<c:url value='/custinv/custinv/editPage'/>";
	var viewurl = "<c:url value='/custinv/custinv/viewPage'/>";
	var delurl = "<c:url value='/custinv/custinv/delete'/>";
	var searchurl= "<c:url value='/custinv/custinv/search'/>";
	var expurl = "<c:url value='/custinv/custinv/export'/>";
	var isEdit = false;
	<shiro:hasPermission name="custinv:custinv:edit">isEdit=true;</shiro:hasPermission>
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#conditionSDdDate"),endElement:$("#conditionEDdDate")});
	  	// 日期控件绑定
		$(".date-picker").bindDate();
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
				{name:'sjc', label:'SJC', hidden: true, width:20, editable:false},
				{name:'id', label:'ID', hidden: true, width:20, editable:false},
				{name:'fph', index:'fph', label:'发票号', width:180},
				{name:'fprq', index:'fprq', label:'发票日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'gszwmc', index:'gszwmc', label:'公司名称', width:110},
				{name:'khmc', index:'khmc', label:'客户名称', width:160},
				{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:80},
				{name:'fktjmc', index:'fktjmc', label:'付款条件', width:160},
				{name:'tdh', index:'tdh', label:'提单号', width:140},
				{name:'zt', index:'zt', label:'状态', width:60 ,edittype:"select", 
					formatter:"select", editoptions:{value:"${fns:loadDictEditOption('FPZT')}"}},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zdrmc', index:'zdrmc', label:'制单人', width:90}
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
					
					$("body").bindSweetAlert({
		    			title:"确定要取消发票？",
		    			closeOnConfirm: true
		    		},{
		    			callback:function(){
		    				//加载层-风格2
		    				$.bindAjax({
								url:"<c:url value='/custinv/custinv/cancle'/>",
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
</script>
</html>