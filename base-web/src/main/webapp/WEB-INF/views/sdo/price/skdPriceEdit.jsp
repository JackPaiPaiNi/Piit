<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>

</head>
<%
	String id = request.getParameter("id");
%>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<!--SKD价格信息 -->
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
						    <input type="hidden" name="id" /> 
							<input type="hidden" name="oper" /> 
							<input type="hidden" name="token" value="${token}"/>
							<div class="input-group input-group-sm">
								<label class="input-group-addon">物料编号&nbsp;&nbsp;</label> <input
									type="text" name="wlbh" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">物料描述&nbsp;&nbsp;</label> <input
									type="text" name="wlms" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">单位&nbsp;&nbsp;</label> <input
									type="text" name="dw" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">币种&nbsp;&nbsp;</label>
									<select role="select" name="bz" size="1" class="form-control skyselect">	
									${fns:loadDictOption('BZ')}
									</select>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">单价&nbsp;&nbsp;</label> <input
									type="text" name="dj" class="form-control"/>
							</div>
						</div>
					   <div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">有效期开始&nbsp;&nbsp;</label> <input
									type="text" name="yxqks" class="form-control date-picker"/> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">有效期结束&nbsp;&nbsp;</label> <input
									type="text" name="yxqjs" class="form-control date-picker"/> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>

					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px; text-align: center;">
						<div class="col-xs-6 col-sm-12">
							<!-- <button id="btn-save" type="button" class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp; -->
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
						</div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var id = "<%=id%>";
	var isEdit = false;
	<shiro:hasPermission name="price:skdPrice:edit">isEdit = true;</shiro:hasPermission>

	$(function($) {
		$(".date-picker").bindDate();
		$(".skyselect").select2();
		$('#form-submit').validate({});
		//加载数据
		bindFormData();
		//保存按钮
		$("#btn-submit").click(function() {
			submit();
		});
		//返回按钮
		$('#btn-back').click(function() {
			window.history.back(-1);
		});
	});
	/**************************************************function开始区域************************************************/

	//加载数据
	function bindFormData() {
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");
		} else {
			var editUrl = "<c:url value='/price/skdPrice/findById'/>";
			var param = {id : id};
			$.bindAjax({
				url : editUrl,
				data : param,
				action : "search"
			},function(response) {
				$("#form-submit").setFormData(response);
				$("#form-submit [name=oper]").val("edit");
			});
		}
	}
	//校验
	$('#form-submit').validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		focusInvalid: false,
		focusCleanup: false,
		ignore: 'input[type=hidden]',
		rules : {
			wlbh : 'required',
			dj : 'required',
			dj : 'number',
			bz : 'required',
			yxqks : 'required',
			yxqjs : { required:true , date:true }
		},
		messages : {
			wlbh : '物料编号不能为空！',
			dj : '单价不能为空！',
			dj : '单价必须为数字！',
			bz : '币种不能为空！',
			yxqks : '有效期开始必须为日期且不能为空！',
			yxqjs : '有效期结束必须为日期且不能为空！'
		},
		showErrors : function(errorMap, errorList) {
			if (errorList.length == 0) {
				$('.input-group').removeClass('has-error');
			} else {
				var msg = "";
				$.each(errorList, function(i, v) {
					msg += (v.message+"\r\n"); 
					$(v.element).closest('.input-group').addClass('has-error');
				});
				swal({title : "校验不通过！",text : msg,type : "error"}, function() {
					return false;
				});
			}
		}
	});

	//提交
	function submit() {
		if (!$('#form-submit').valid()) {
			return false;
		}
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/price/skdPrice/submit'/>",
					data : param,
					action : "submit"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	/**************************************************function结束区域************************************************/
</script>
</html>