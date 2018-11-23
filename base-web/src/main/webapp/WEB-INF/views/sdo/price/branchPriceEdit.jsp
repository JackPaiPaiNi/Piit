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
					<!--分公司产品价格信息 -->
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<input type="hidden" name="id" /> 
							<input type="hidden" name="oper" /> 
							<input type="hidden" name="token" value="${token}"/>
							<div class="input-group input-group-sm">
								<label class="input-group-addon">销售员&nbsp;&nbsp;</label> <input
									type="text" name="xsyid" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">销售员名称&nbsp;&nbsp;</label> <input
									type="text" name="xsymc" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label> <input
									type="text" name="khbm" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
									type="text" name="khmc" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">币种&nbsp;&nbsp;</label>
									<select role="select" name="bz" size="1" class="form-control skyselect">	
									${fns:loadDictOption('BZ')}
									</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">付款条件&nbsp;&nbsp;</label> <input
									type="text" name="fktj" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">天数&nbsp;&nbsp;</label> <input
									type="text" name="ts" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">保费率&nbsp;&nbsp;</label> <input
									type="text" name="bfl" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">品牌&nbsp;&nbsp;</label> <input
									type="text" name="pp" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">区域&nbsp;&nbsp;</label> <input
									type="text" name="qy" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">加工方式&nbsp;&nbsp;</label> <input
									type="text" name="jgfs" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">产品PID&nbsp;&nbsp;</label> <input
									type="text" name="pid" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">最新配屏编号&nbsp;&nbsp;</label> <input
									type="text" name="zxppbm" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">尺寸&nbsp;&nbsp;</label> <input
									type="text" name="cc" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">产品类别&nbsp;&nbsp;</label> <input
									type="text" name="cplb" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">2D/3D&nbsp;&nbsp;</label> <input
									type="text" name="sf3d" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">Panel Type&nbsp;&nbsp;</label> <input
									type="text" name="paneltype" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">机型&nbsp;&nbsp;</label> <input
									type="text" name="jixing" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">机芯&nbsp;&nbsp;</label> <input
									type="text" name="jixin" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">款式&nbsp;&nbsp;</label> <input
									type="text" name="ks" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">Polyfoam泡沫&nbsp;&nbsp;</label> <input
									type="text" name="pm" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">Carton纸箱&nbsp;&nbsp;</label> <input
									type="text" name="zx" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">Gift彩盒&nbsp;&nbsp;</label> <input
									type="text" name="ch" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">挂架&nbsp;&nbsp;</label> <input
									type="text" name="gj" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">屏包材&nbsp;&nbsp;</label> <input
									type="text" name="pbc" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">1%备损(不含屏)&nbsp;&nbsp;</label> <input
									type="text" name="bsbhp" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">其他特殊要求&nbsp;&nbsp;</label> <input
									type="text" name="qttsyq" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">FOB屏价格&nbsp;&nbsp;</label> <input
									type="text" name="fobP" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">FOB散件价格&nbsp;&nbsp;</label> <input
									type="text" name="fobSj" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">FOB 最低报价(USD)&nbsp;&nbsp;</label> <input
									type="text" name="fobZj" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">FOB主板价格&nbsp;&nbsp;</label> <input
									type="text" name="fobZb" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">CIF屏价格&nbsp;&nbsp;</label> <input
									type="text" name="cifP" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">CIF散件价格&nbsp;&nbsp;</label> <input
									type="text" name="cifSj" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">CIF最低报价（USD）&nbsp;&nbsp;</label> <input
									type="text" name="cifZj" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">CIF主板价格&nbsp;&nbsp;</label> <input
									type="text" name="cifZb" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
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
					<div class="space-8"></div>
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
	<shiro:hasPermission name="price:branchPrice:edit">isEdit = true;</shiro:hasPermission>

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
			var editUrl = "<c:url value='/price/branchPrice/findById'/>";
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
			khbm : 'required',
			jixing : 'required',
			jixin : 'required',
			ks : 'required',
			ts : 'number',
			bfl : 'number',
			cc : 'number',
			fobP : 'number',
			fobSj : 'number',
			fobZj : 'number',
			fobZb : 'number',
			cifP : 'number',
			cifSj : 'number',
			cifZj : 'number',
			cifZb : 'number',
			yxqks : 'required',
			yxqjs : { required:true , date:true }
		},
		messages : {
			khbm : '客户编码不能为空！',
			jixing : '机型不能为空！',
			jixin : '机芯不能为空！',
			ks : '款式不能为空！',
			ts : '天数必须为数字！',
			bfl : '保费率必须为数字！',
			cc : '尺寸必须为数字！',
			fobP : 'fob屏价格必须为数字！',
			fobSj : 'fob散件价格必须为数字！',
			fobZj : 'fob整机价格必须为数字！',
			fobZb : 'fob主板价格必须为数字！',
			cifP : 'cif屏价格必须为数字！',
			cifSj : 'cif散件价格必须为数字！',
			cifZj : 'cif整机价格必须为数字！',
			cifZb : 'cif主板价格必须为数字！',
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
					url : "<c:url value='/price/branchPrice/submit'/>",
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