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
			<div id="search-box" class="widget-box">
				<div class="widget-header header-color-blue2">
					<h5>待办事项</h5>
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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">单号&nbsp;&nbsp;</label>
										<input type="text" name="dh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务类型&nbsp;&nbsp;</label>
										<input type="text" name="ywlx" class="form-control"/>
									</div>
								</div>
								<!-- <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发起人&nbsp;&nbsp;</label>
										<input type="text" name="fqr" class="form-control"/>
									</div>
								</div> -->
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">(公司)客户&nbsp;&nbsp;</label>
										<input type="text" name="gskh" class="form-control"/>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			
			<!-- PAGE CONTENT BEGINS -->
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
	var batchqx = false;
	<shiro:hasPermission name="order:batchApprove:approve">batchqx=true;</shiro:hasPermission>
	
	jQuery(function($) {
		jQuery(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/base/bpm/searchTask'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect: batchqx,
			//shrinkToFit: false,
			//autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			rowNum : 50,
			colModel: [
				{name:'businessId',index:'businessId',label:'业务主键',sortable:false, hidden: true, width:60, editable:false, sorttype:"int",hideCol:false},
				{name:'formKey',index:'formKey',label:'连接地址',sortable:false, hidden: true, width:60, editable:false, sorttype:"string",hideCol:false},
				{name:'processId',index:'processId',label:'流程实例ID',sortable:false, hidden: true, width:60, editable:false, sorttype:"int",hideCol:false},
				{name:'taskId',index:'taskId',label:'任务ID',sortable:false, hidden: true, width:60, editoptions:{size:"20",maxlength:"30"}},
				{name:'type',index:'type',label:'业务类型',sortable:false, width:150},
				{name:'processType',index:'processType',label:'流程类型',sortable:false, hidden: true, width:70,edittype:"select",formatter: "select",editoptions: {value:"add:新增;upd:修改;del:删除"}},
				{name:'code',index:'code',label:'单号',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'taskName',index:'taskName',label:'任务节点',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'processName',index:'processName',label:'流程名称',sortable:false, hidden: true, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'applyUser',index:'applyUser',label:'流程发起人',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'applyTime',index:'applyTime',label:'流程发起时间',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'createTime',index:'createTime',label:'待办接受时间',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'name',index:'name',label:'(公司)客户',sortable:false, width:150, editoptions:{size:"20",maxlength:"100"}}
			],
			sortable:true,
			sortname:"createTime",
			sortorder:"desc",
	        ondblClickRow: function(rowid){
				var rowData = jQuery(grid_selector).jqGrid('getRowData',rowid);
				location.href = "<c:url value='/"+rowData.formKey+"'/>?id="+rowData.businessId+"&processId=" 
						+ rowData.processId + "&taskId=" + rowData.taskId + "&taskName=" + rowData.taskName + "&sfApprove=1";
	        }
		},{
			add:false,
			del:false,
			edit:false,
			view:false
		});
		<shiro:hasPermission name="order:batchApprove:approve">
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"订单批量通过", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				batchApprove();
			},
			position:"last"
		});
		</shiro:hasPermission>
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
	});
	
	function batchApprove(){
		var ids = $(grid_selector).jqGrid("getGridParam","selarrrow");
		if(ids.length < 1){
			swal("", "请选择数据！", "warning");
			return;
		}
		var approveJson = [];
		$.each(ids, function(i,n){
			var tmpParam = {};
			var data = $(grid_selector).jqGrid('getRowData', n);
			tmpParam.id = data.businessId;
			tmpParam.processId = data.processId;
			tmpParam.taskId = data.taskId;
			tmpParam.formKey = data.formKey;
			approveJson.push(tmpParam);
		});
		$("body").bindSweetAlert({
			title:"若所选待办不符合订单批量处理要求会自动忽略！确定要批量通过所选订单吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/order/batchApprove/approve'/>",
					data:{approveJson : JSON.stringify(approveJson)},
					action : "save",
				},function(response){
					$(grid_selector).trigger("reloadGrid");
				}); 
			}
		});
	}
	
</script>
</html>