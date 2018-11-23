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
	var combineurl= "<c:url value='/deliverplan/deliverPlan/combine'/>";
	var cancelurl= "<c:url value='/deliverplan/deliverPlan/cancel'/>";
	var viewurl= "<c:url value='/deliverplan/deliverPlan/viewPage'/>";
	<shiro:hasPermission name="deliverplan:deliverPlan:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$("#form-search [name=zgsj]").bindDateRange({startElement:$("#szgkssj"),endElement:$("#ezgjssj")});
		$(grid_selector).bindTable({
			url: "<c:url value='/deliverplan/deliverPlan/searchWhb'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			sortname:'zdsj',
			sortorder:'desc',
			multiselect: true,
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
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
			add:false,
			edit:false,
			del:false,
			view:isEdit,
			viewfunc:viewfunc
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"合并走货计划", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var data = $(grid_selector).jqGrid("getGridParam","selarrrow");
				// 判断是否选了数据
				if(!data.length > 0){
					swal("","请至少勾选一条记录！","warning");
					return;
				}else{
					// 拼接走货计划单号
					var zhjhdhs = "";
					var message = "";
					for(var i=0; i<data.length; i++){
						var rowData = $(grid_selector).jqGrid("getRowData",data[i]);
						if(rowData.lx == 2){
							message = "合并的走货单中不能包含已合并的单据！";
						}else if(rowData.zt != 5){
							message = "合并的走货单必须是已生效的单据！";
						}
						zhjhdhs += rowData.zhjhdh;
						if(i != data.length-1){
							zhjhdhs += ",";
						}
					}
					if(message.length>0){
						swal("",message,"warning");
						return;
					}
					var param = $("#form-search").getFormData();
					param.zhjhdhs = zhjhdhs;
					$("body").bindSweetAlert({
						title:"确定要合并吗?"
					},{
						callback:function(){
							$.bindAjax({
								url:combineurl,
								data : param,
								action:"save"
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
			caption:"取消", 
			buttonicon:"fa-square-o orange", 
			onClickButton: function(){
				var data = $(grid_selector).jqGrid("getGridParam","selarrrow");
				if(data.length > 1){
					swal("","只允许对一行数据进行操作！","warning");
					return;
				}
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5){
						swal("","请选择一行已生效数据！","warning");
						return;
					} else if(rowData.lx != 2){
						swal("","请选择一行已合并的数据！","warning");
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
		//导出
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/deliverplan/deliverPlan/combineExport'/>"});
	    			}
	    		});
	        }
		});
	});
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		if(id==null || id==""){
			swal("","请选择一行数据！","warning");
		}else{
			var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
			window.open(viewurl + "?id=" + id);
		}
	}
</script>
</html>