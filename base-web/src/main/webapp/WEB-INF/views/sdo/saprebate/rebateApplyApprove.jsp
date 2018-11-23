<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String sfApprove = request.getParameter("sfApprove");
		String processInstanceId = request.getParameter("processId");
		pageContext.setAttribute("sfApprove", sfApprove);
		pageContext.setAttribute("processInstanceId", processInstanceId);
	%>
	<style type="text/css">
table {
	width: 100%;
}
table {
	max-width: 200%;
}
table td {
	padding: 5px;
}
.dialog .modal-dialog{
			width:1100px;
		}
</style>
</head>
<body>
<div class="page-content">
	<form id="form-submit">
		<div class="row">
			<div class="input-group">
			    <input type="hidden" name="id" value="${title.id}"/>
			    <input type="hidden" name="zdjlx"  value="${title.zdjlx}">
				<input type="hidden" name="sjc" value="${title.sjc}"/>
				<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
				<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
				<%-- <input type="hidden" name="token" value="${token}" /> --%>
				<label class="input-group-btn">审核意见&nbsp;&nbsp;</label>
				<textarea id="nr" name="nr" class="autosize-transition form-control" rows="5"></textarea>
			</div>
		</div>
		<div class="space-4"></div>
		<div class="row" align="center">
			<button id="btn-agree" type="button" class="btn btn-info btn-sm" onclick="javascript:approve(1);">
				<i class="icon-ok icon-on-right bigger-110"></i>
				通过
			</button>
			&nbsp;
			<button id="btn-reject" type="button" class="btn btn-danger btn-sm" onclick="javascript:approve(2);">
				<i class="fa-times icon-on-right bigger-110"></i>
				驳回
			</button>
			&nbsp;
			<button type="button" class="btn btn-sm" onclick="javascript:history.back(-1);">
				<i class="icon-undo icon-on-right bigger-110"></i>
				返回
			</button>
			<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
				<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
					<i class="fa-file-image-o icon-on-right bigger-110"></i>
					流程图
				</button>
				&nbsp;
			</c:if>
		</div>
	</form>
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>审批单流水号：</b>${title.splsh}</td>
						<td style="width: 25%"><b>公司代码：</b>${title.bukrs}</td>
					    <td style="width: 25%"><b>公司名称：</b>${title.gsmc}</td>
						<td style="width: 25%"><b>申请人：</b>${title.userid}</td>
					</tr>
					<tr>
					    <td><b>提交日期：</b><fmt:formatDate value="${title.cpudt}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top: 4px;">返利申请明细</h5> 
			<table id="grid-table"></table>
		
			<h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
			<div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>单据号</th>
						<th>操作类型</th>
						<th>操作人账号</th>
						<th>操作人名称</th>
						<th>操作时间</th>
						<th>处理意见</th>
					</tr>
					<c:forEach items="${title.logList}" var="item">
						<tr>
							<td>${item.dh}</td>
							<td>${item.czlx}</td>
							<td>${item.czr}</td>
							<td>${item.czrmc}</td>
							<td><fmt:formatDate value="${item.czsj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${item.nr}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";
$(function($) {
	var id="${title.id}";
	$('#btn-back').hide();
	$(grid_selector).bindTable({
		url: "<c:url value='/rebate/rebateApply/queryById'/>",
		postData: {id:id},
		rowNum:-1,
		autoheight:true,
		multiselect: true,
		shrinkToFit: false,
		colModel: [
			{name:'id', label:'ID', hidden: true, width:60, editable:false},
			{name:'sFgx', label:'sFgx', hidden: true, width:60, editable:true},
			{name:'hhao', index:'hhao',hidden: true, width:80},
			{name:'splsh', index:'splsh',label:'审批流水号',hidden:true,width:140},
			{name:'zflnm', index:'zflnm',label:'返利申报单号', width:140},
			{name:'zitem', index:'zitem',label:'序号', width:20},
			{name:'kunnr', index:'kunnr',label:'客户', width:80},
			{name:'khmc', index:'khmc',label:'客户名称', width:120},
			{name:'zrcnm', index:'zrcnm',label:'返利分类', width:80},
			{name:'zrcnmms', index:'zrcnmms',label:'返利分类编码描述', width:80},
			{name:'zmodl', index:'zmodl',label:'型号', width:80},
			{name:'zfamt', index:'zfamt',label:'返利申报金额', width:80},
			{name:'waers', index:'waers',label:'货币', width:80},
			{name:'xtjyje', index:'xtjyje',label:'系统计算返利申报金额', width:80},
			{name:'cyje', index:'cyje',label:'差异金额', width:80},
			{name:'zlart', index:'zlart',label:'凭证类型', width:80},
			{name:'zlartms', index:'zlartms',label:'凭证类型描述', width:80},
			{name:'sbyy', index:'sbyy',label:'申报原因', width:80},
			{name:'zsalm', index:'zsalm',label:'业务员', width:80},
			{name:'zsalmms', index:'zsalmms',label:'业务员描述', width:80}
		],
		gridComplete: function(){
            var rowIds = $(grid_selector).jqGrid('getDataIDs'); 
            $.each(rowIds,function(index,rowid){
            	$(grid_selector).setCell(rowid, 'sFgx',0);
            });
	   	},
		onSelectRow: function(rowid, status) {
	    	if(status){
	    		//勾选了的，将该行sFgx的值设置为1，相反为0
	    		$(grid_selector).setCell(rowid, 'sFgx',1);
	    	}else{
	    		$(grid_selector).setCell(rowid, 'sFgx',0);
	    	}
	    },
	    onSelectAll:function(rowids,status){
			if(status){
				//全部选中
				$.each(rowids,function(index,rowid){
					$(grid_selector).setCell(rowid, 'sFgx',1);
				});
			}else{
				//全部取消
				$.each(rowids,function(index,rowid){
					$(grid_selector).setCell(rowid, 'sFgx',0);
				});
			}
	    }
});
	
	
	
	/* 
	
	//初始化表格
	$(grid_selector).bindTable({
		url: "<c:url value='/rebate/rebateApply/queryById'/>",
		postData: {id:id},
		multiselect: true,
		autoheight:true,
		shrinkToFit: false,
		rownum:-1,//默认显示所有数据
		colModel: [
			{name:'id', label:'ID', hidden: true, width:60, editable:false},
			{name:'sFgx', label:'sFgx', hidden: true, width:60, editable:true},
			{name:'hhao', index:'hhao',hidden: true, width:80},
			{name:'splsh', index:'splsh',label:'返利申报单号', width:140},
			{name:'zitem', index:'zitem',label:'序号', width:20},
			{name:'kunnr', index:'kunnr',label:'客户', width:80},
			{name:'khmc', index:'khmc',label:'客户名称', width:120},
			{name:'zrcnm', index:'zrcnm',label:'返利分类', width:80},
			{name:'zrcnmms', index:'zrcnmms',label:'返利分类编码描述', width:80},
			{name:'zmodl', index:'zmodl',label:'型号', width:80},
			{name:'zfamt', index:'zfamt',label:'返利申报金额', width:80},
			{name:'waers', index:'waers',label:'货币', width:80},
			{name:'xtjyje', index:'xtjyje',label:'系统计算返利申报金额', width:80},
			{name:'cyje', index:'cyje',label:'差异金额', width:80},
			{name:'zlart', index:'zlart',label:'凭证类型', width:80},
			{name:'zlartms', index:'zlartms',label:'凭证类型描述', width:80},
			{name:'sbyy', index:'sbyy',label:'申报原因', width:80},
			{name:'zsalm', index:'zsalm',label:'业务员', width:80},
			{name:'zsalmms', index:'zsalmms',label:'业务员描述', width:80}
		],
		gridComplete: function(){
	            var rowIds = $(grid_selector).jqGrid('getDataIDs'); 
	            $.each(rowIds,function(index,rowid){
	            	$(grid_selector).setCell(rowid, 'sFgx',0);
	            });
		   	},
		onSelectRow: function(rowid, status) {
	    	if(status){
	    		//勾选了的，将该行sFgx的值设置为1，相反为0
	    		$(grid_selector).setCell(rowid, 'sFgx',1);
	    	}else{
	    		$(grid_selector).setCell(rowid, 'sFgx',0);
	    	}
	    },
	    onSelectAll:function(rowids,status){
			if(status){
				//全部选中
				$.each(rowids,function(index,rowid){
					$(grid_selector).setCell(rowid, 'sFgx',1);
				});
			}else{
				//全部取消
				$.each(rowids,function(index,rowid){
					$(grid_selector).setCell(rowid, 'sFgx',0);
				});
			}
		}
	});
	$(grid_selector).closest(".ui-jqgrid-bdiv").css({'overflow-y':'scroll'}); */
});
//通过
function approve(type){
	var param = $("#form-submit").getFormData();
	var rows = $(grid_selector).jqGrid("getRowData");
	var selectedRowIds =$(grid_selector).jqGrid("getGridParam","selarrrow");
	var note="";
	if(selectedRowIds==null||selectedRowIds==""){
		note="返利申请明细未选择,会自动驳回！";
	}
	param.approveType = type;
	param.itemList=JSON.stringify(rows) ;
	$("body").bindSweetAlert({
		title:note+"确定要提交吗?"
	},{
		callback:function(){
			$.bindAjax({
				url:"<c:url value='/rebate/rebateApply/approve'/>",
				data:param,
				action:"save"
			},function(response){
				window.history.back(-1);
			}); 
		}
	});
}

//查看流程
$("#btn-flow").click(function(){
	bootbox.dialog({
		title : "流程图",
		message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
	});
});
</script>
</html>