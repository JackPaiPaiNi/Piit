<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
</head>
<body>
<div class="page-content">
	<form id="form-submit">
		<div class="row">
			<div class="input-group">
				<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
				<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
				<input type="hidden" name="id" value="<%=request.getParameter("id")%>" />
				<label class="input-group-btn">审核意见&nbsp;&nbsp;</label>
				<textarea id="spyj" name="spyj" class="autosize-transition form-control" rows="5"></textarea>
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
		</div>
		<div class="space-4"></div>
		<div class="row" style="margin: 0px 8px;">
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">项目阶段&nbsp;&nbsp;</label> 
					<select role="select" name="xmjd" size="1" class="form-control skyselect">
						${fns:loadDictOption('PROJECT_XMJD')}
					</select>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">处理人&nbsp;&nbsp;</label>
					<input type="hidden" name="clr" />
					<input type="text"   name="clrmc" class="form-control"/>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">要求处理时间&nbsp;&nbsp;</label> 
					<input type="text" name="yqclsj" class="form-control date-picker" /> 
					<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">预计处理时间&nbsp;&nbsp;</label>
				    <input type="text" name="yjclsj" class="form-control date-picker" />
				    <span class="input-group-addon"> <i class="icon-calendar bigger-110"></i> </span>
				</div>
			</div>
		</div>
		<div class="space-4"></div>
		<div class="row" style="margin: 0px 8px;">
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
					<label class="input-group-addon">优先级&nbsp;&nbsp;</label>
					<select role="select" name="yxj" size="1" class="form-control skyselect">
						${fns:loadDictOption('BUG_YXJ')}
					</select>
				</div>
			</div>
			<div class="col-xs-6 col-sm-3">
				<div class="input-group input-group-sm">
				   <label class="input-group-addon">问题分类&nbsp;&nbsp;</label> 
				   <select role="select" name="wtfl" size="1" class="form-control skyselect">
						${fns:loadDictOption('BUG_WTFL')}
					</select>
				</div>
			</div>
			<div class="col-xs-6 col-sm-6">
			    <div class="input-group input-group-sm">
					<label class="input-group-addon">处理类型&nbsp;&nbsp;</label>
					<div class="form-control">
						<label class="radio-inline">
							<input type="radio" name="flag" class="skyradio" value="1">关闭问题
						</label>
						<label class="radio-inline">
							<input type="radio" name="flag" checked="checked" class="skyradio" value="0">分派处理
						</label>
					</div>
				</div>
			</div>
		</div>
	  </div>
	</form>
	<h5 class="header blue" style="margin-top:4px;">详细信息</h5>
    <div class="row" style="margin: 0px 8px;">
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 29%"><b>问题单号：</b>${projectBug.wtdh}</td>
				<td style="width: 29%"><b>项目阶段：</b>${projectBug.xmjdmc}</td>
				<td style="width: 29%"><b>提出人：</b>${projectBug.tcrmc}</td>
				<td style="width: 29%"><b>提出部门：</b>${projectBug.tcbmmc}</td>
			</tr>
			<tr>
			    <td><b>提出时间：</b><fmt:formatDate value="${projectBug.tcsj}" pattern="yyyy-MM-dd"/></td>
				<td><b>状态：</b>${projectBug.ztmc}</td>
				<td><b>优先级：</b>${projectBug.yxjmc}</td>
				<td><b>菜单名称：</b>${projectBug.cdmc}</td>
			</tr>
			<tr>
				<td><b>提出时间：</b><fmt:formatDate value="${projectBug.tcsj}" pattern="yyyy-MM-dd"/></td>
				<td><b>要求处理时间：</b><fmt:formatDate value="${projectBug.yqclsj}" pattern="yyyy-MM-dd"/></td>
				<td><b>预计处理时间：</b><fmt:formatDate value="${projectBug.yjclsj}" pattern="yyyy-MM-dd"/></td>
				<td><b>处理时间：</b><fmt:formatDate value="${projectBug.sjclsj}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td><b>关闭时间：</b>${projectBug.gbsj}</td>
				<td><b>问题分类：</b>${projectBug.wtflmc}</td>
				<td><b>处理人：</b>${projectBug.clrmc}</td>
			</tr>
			<tr>
				<td colspan="4"><b>问题描述：</b>${projectBug.wtms}</td>
			</tr>
			<tr>
				<td colspan="4"><b>处理说明：</b>${projectBug.clsm}</td>
			</tr>
		</table>
	</div>
	<!-- 审批日志 -->
	<div class="space-4"></div>
	<h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
	<div class="space-4"></div>
	<c:import url="/pub/showLog/projectBug" charEncoding="UTF-8" />
</div>
</div>
<div class="row">
	<!-- PAGE CONTENT BEGINS -->
	<div class="row" style="margin: 0px 8px;">
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 20%">
					<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
						<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
							<i class="fa-file-image-o icon-on-right bigger-110"></i>
							流程图
						</button>
						&nbsp;
					</c:if>
				</td>
			</tr>
		</table>
	</div>
<!-- /.page-content -->
</body>
<script type="text/javascript" >
    var id  = $('#form-submit [name=id]').val();
    var taskId = $('#form-submit [name=taskId]').val();
    var processId = $('#form-submit [name=processId]').val();
	$(function($){
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
		//初始化页面数据
		initClr() ;
		//初始化页面数据
		 bindFormData(id) ;
	});
	//页面数据初始化
	function bindFormData(id){
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/project/projectBug/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				 $("#form-submit").setFormData(response);
				 //复制冲掉以下值后重新赋值
				 $('#form-submit [name=id]').val(id);
				 $('#form-submit [name=taskId]').val(taskId);
				 $('#form-submit [name=processId]').val(processId);
			});
		}
	}
	//处理人
	function initClr(){
		$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:"1-yx-kfry"},
			function(result){
					var data = $.map(result, function (obj) {
				       obj.id = obj.empCode;
				       obj.text = obj.text || obj.userName;	
				       return obj;
				     });
					$("#form-submit [name=clrmc]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
						if(e.added){
							$("#form-submit [name=clrmc]").val(e.added.userName);
							$("#form-submit [name=clr]").val(e.added.empCode);
						}
					});
			}, "json");
	}
	//审批
	function approve(type){
		var param = $("#form-submit").getFormData();
		param.approveType = type;
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/project/projectBug/approve'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
</script>
</html>