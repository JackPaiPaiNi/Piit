<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<%@include file="/WEB-INF/views/index/lfs.jsp"%>
<script type="text/javascript">
	$(function($) {
		$('.skyselect').select2();
		// 运费附件信息
		$('#yffj').uploadify($.extend($.lfsUploadOptions, {
			queueID : 'multiFileQueue2',// 上传队列容器
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>" + result.filename + "</a>";
						$("#form-submit [name=yffj]").val(tmpUrl);
						$("#yffjxx").empty().append(tmpUrl);
					} else {
						alert(result.msg);
					}
				}
			}
		}));
		//选择需发邮件船务专员
		$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:"1-yx-cwzy"},
				function(result){
					var data = $.map(result, function (obj) {
				       obj.id = obj.empCode;
				       obj.text = obj.text || obj.userName;	
				       return obj;
				     });
					$("#form-submit [name=yjcwzyid]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
						if(e.added){
							$("#form-submit [name=yjcwzymc]").val(e.added.userName);
						}
					});
			}, "json");
	});
</script>
</head>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form id="form-submit">
					<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
					<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
					<input type="hidden" name="cwsfcl" value="1" />
					<input type="hidden" name="token" value="${token}">
					<div class="row">
						<div class="input-group">
							<label class="input-group-btn">审核意见&nbsp;&nbsp;</label>
							<textarea id="spyj" name="spyj" class="autosize-transition form-control" rows="5"></textarea>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">船务预估运费</h5>
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">本次预估费用&nbsp;&nbsp;</label>
								<input type="text" name="ygyf" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">费用币种&nbsp;&nbsp;</label>
								<select role="select" name="yfbz" size="1" class="form-control skyselect">
									${fns:loadDictOption('BZ')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<input type="hidden" name="yffj" />
								<label class="input-group-addon">运费特批报告附件&nbsp;&nbsp;</label>
								<span class="input-group-addon">
									<input id="yffj" type="file" class="form-control" />
								</span>
								<div id="yffjxx" class="form-control"></div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							<div id="multiFileQueue2"></div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">需发邮件船务专员&nbsp;&nbsp;</label>
								<input type="hidden" name="yjcwzymc" />
								<input type="text" name="yjcwzyid" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-8"></div>
					<div class="row" align="center">
						<button id="btn-agree" type="button" class="btn btn-info btn-sm"
							onclick="javascript:approve(1);">
							<i class="icon-ok icon-on-right bigger-110"></i> 通过并保存
						</button>
						&nbsp;
						<button id="btn-reject" type="button"
							class="btn btn-danger btn-sm" onclick="javascript:approve(2);">
							<i class="fa-times icon-on-right bigger-110"></i> 驳回
						</button>
						&nbsp;
						<button type="button" class="btn btn-sm"
							onclick="javascript:history.back(-1);">
							<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
					</div>
					<div class="row">
						<!-- c:import的url默认接受父页面的参数，如果需要添加参数用c:param -->
						<c:import url="/pso/tvPso/viewPage" charEncoding="UTF-8">
							<%-- <c:param name="type">大货订单</c:param> --%>
						</c:import>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	// 保存方法 
	function approve(type) {
		//拿到表单数据
		var param = $('#form-submit').getFormData();
		param.approveType = type;
		//提交时如果运费承担主体为我司承担且费用承担类型不为客户付款，那预估运费所有条目必填
		if(type == 1 && param.yfcd == 0 && param.yflx != 1){
			var ygfy = $('#form-submit [name=ygyf]').val();
			var yfbz = $('#form-submit [name=yfbz]').val();
			if (ygfy.length == 0 || yfbz.length == 0) {
				swal("", "预估费用，费用币种为必填项", "warning");
				return;
			}
		}
		//保存
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/pso/tvPso/cwyclSave'/>",
					data : param,
					action : "save",
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
</script>
</html>


