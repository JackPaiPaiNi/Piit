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
				
			<div  id="search-box" class="widget-box">
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
										<label class="input-group-addon">走货计划单号&nbsp;&nbsp;</label>
										<input type="text" name="zhjhdh" class="form-control"/>
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
										<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
									</div>
								</div>	
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrmc" class="form-control"/>
									</div>
								</div>				
							</div>
							<div class="space-4"></div>
							<div class="row">
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
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜时间&nbsp;&nbsp;</label>
										<input type="hidden" id="szgkssj" name="szgkssj"/>
										<input type="hidden" id="ezgjssj" name="ezgjssj"/>
										<input type="text" name="zgsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>	
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">类型&nbsp;&nbsp;</label>
										<select role="select" name="lx" size="1" class="form-control skyselect">
											${fns:loadDictOption('ZHJHDLX')}
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
	var editurl= "<c:url value='/deliverplan/deliverPlan/editPage'/>";
	var delurl= "<c:url value='/deliverplan/deliverPlan/delete'/>";
	var viewurl= "<c:url value='/deliverplan/deliverPlan/viewPage'/>";
	var cancelurl= "<c:url value='/deliverplan/deliverPlan/cancel'/>";
	<shiro:hasPermission name="deliverplan:deliverPlan:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$("#form-search [name=zgsj]").bindDateRange({startElement:$("#szgkssj"),endElement:$("#ezgjssj")});
		$(grid_selector).bindTable({
			url: "<c:url value='/deliverplan/deliverPlan/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height() /* + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'zhjhdh', index:'zhjhdh', label:'走货计划单号', width:120,  editrules:{edithidden:true}},
				{name:'zt', index:'zt', label:'状态',width:70, hidden:true},
				{name:'ztmc', index:'ztmc', label:'状态',width:70},
				{name:'lx', index:'lx', label:'类型',width:70, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('ZHJHDLX')}"}},
				{name:'zdrid', index:'zdrid', label:'制单人', width:80,  editrules:{edithidden:true}},
				{name:'zdrmc', index:'zdrmc', label:'制单人名称', width:100,  editrules:{edithidden:true}},
				{name:'zgkssj', index:'zgkssj', label:'装柜开始时间', width:100,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zgjssj', index:'zgjssj', label:'装柜结束时间', width:100,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:100,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'sjc', index:'sjc', label:'时间戳', width:60, hidden:true,  editrules:{edithidden:true}}
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			delfunc:delfunc,
			viewfunc:viewfunc,
			addfunc:addfunc,
			editfunc: editfunc
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
						return;
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
 
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
			
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/deliverplan/deliverPlan/export'/>"});
	    			}
	    		});
	        }
		});
		
		//新增
		function addfunc(){
			location.href = editurl;
		}
		
		//查看
		function viewfunc(){
			var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			if(id==null || id==""){
				swal("","请选择一行数据！","warning");
			}else{
				var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				location.href = viewurl + "?id=" + selr;
			}
		}
		
		//编辑
		function editfunc(){
			var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			if(id==null || id==""){
				swal("","请选择一行数据！","warning");
			}else{
				var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
				if(rowData.zt != 1){
					swal("","请选择一行草稿数据！","warning");
					return;
				} else {
					var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					location.href = editurl + "?id=" + selr;
				}
			}
		}
		
		//删除
		function delfunc(){
			var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
			if(rowData.zt != 1){
				swal("","请选择一行草稿数据！","warning");
				return;
			} else {
				$("body").bindSweetAlert({
					title:"确定要删除吗?"
				},{
					callback:function(){
						$.bindAjax({
							url:delurl,
							data:{id:rowData.id, sjc:rowData.sjc},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
			}
		}
	});
</script>
</html>