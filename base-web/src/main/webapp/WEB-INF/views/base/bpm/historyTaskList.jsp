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
				
			<div class="widget-box">
				<div class="widget-header header-color-blue2">
					<h5>查询条件</h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
					<div class="widget-toolbar no-border">
						<button id="btn-search" type="button" class="btn btn-info btn-minier bigger">
							<i class="icon-search icon-on-right bigger-110"></i>
							查询
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form class="form-search">
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">编码&nbsp;&nbsp;</label>
											<input type="text" name="code" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">实体名称&nbsp;&nbsp;</label>
											<input type="text" name="name" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">待办状态&nbsp;&nbsp;</label>
											<select role="select" name="status" size="1" class="form-control skyselect">
												<option role="option" value="">--请选择--</option>
												<option role="option" value="run">正在运行</option>
												<option role="option" value="finish">已完成</option>
											</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">主数据类型&nbsp;&nbsp;</label>
											<select role="select" name="type" size="1" class="form-control skyselect">
												<option role="option" value="">--请选择--</option>
												<option role="option" value="company">公司</option>
												<option role="option" value="business">业务事项</option>
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
	
	jQuery(function($) {
		$(".skyselect").select2();
		jQuery(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/base/bpm/searchHistoryTask'/>",
			pager: pager_selector,
			gridParent:"#grid-parent",
			colModel: [
				{name:'businessId',index:'businessId',label:'业务主键',sortable:false, hidden: true, width:60, editable:false, sorttype:"int",hideCol:false},
				{name:'formKey',index:'formKey',label:'连接地址',sortable:false, hidden: true, width:60, editable:false, sorttype:"string",hideCol:false},
				{name:'processId',index:'processId',label:'流程实例ID',sortable:false, hidden: true, width:60, editable:false, sorttype:"int",hideCol:false},
				{name:'taskId',index:'taskId',label:'任务ID',sortable:false, hidden: true, width:60, editoptions:{size:"20",maxlength:"30"}},
				{name:'type',index:'type',label:'业务类型',sortable:false, width:150},
				{name:'processType',index:'processType',label:'流程类型',sortable:false, hidden: true, width:70,edittype:"select",formatter: "select",editoptions: {value:"add:新增;upd:修改;del:删除"}},
				{name:'code',index:'code',label:'单号',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'name',index:'name',label:'实体名称',sortable:false, hidden: true, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'taskName',index:'taskName',label:'任务节点',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'processName',index:'processName',label:'流程名称',sortable:false, hidden: true, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'applyUser',index:'applyUser',label:'流程发起人',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'applyTime',index:'applyTime',label:'流程发起时间',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'createTime',index:'createTime',label:'待办接受时间',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'endTime',index:'endTime',label:'待办结束时间',sortable:false, width:150, editoptions:{size:"20",maxlength:"30"}}
			],
			gridComplete: function() {
				$("#grid-table_createTime").children("div").children("span").show();
				$("#grid-table_createTime span[sort='desc']").removeClass("ui-state-disabled");
	        },
	        ondblClickRow: function(rowid){
				var rowData = jQuery(grid_selector).jqGrid('getRowData',rowid);
				location.href = "<c:url value='/"+rowData.formKey+"'/>?id="+rowData.businessId+"&sign=histTask";
	        }
		},{
			add:false,
			del:false,
			view:false,
			edit:false
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
	});
</script>
</html>