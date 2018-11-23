<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>

</head>
<%
	String id = request.getParameter("id");
	String sjc = request.getParameter("sjc");
	String sfBg = request.getParameter("sfBg");
%>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<!--信用额度信息 -->
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<input type="hidden" name="id" /> 
							<input type="hidden" name="oper" /> 
							<input type="hidden" name="sjc" /> 
							<input type="hidden" name="bbh" /> 
							<input type="hidden" name="zt" />
							<input type="hidden" name="sfBg" />
							<input type="hidden" name="token" value="${token}"/>
							<div class="input-group input-group-sm">
								<label class="input-group-addon">信用额度类型&nbsp;&nbsp;</label> <select
									role="select" name="xyedlx" size="1"
									class="form-control skyselect">
									${fns:loadDictOption('XYEDLX')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
								<input type="text" name="khbm" onfocus="this.blur()" class="form-control parent-node" />
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
									type="text" name="khmc" class="form-control" readonly="true"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
					  <div class="col-xs-6 col-sm-4">
							 <div class="input-group input-group-sm">
								<label class="input-group-addon">是否虚拟客户&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline">
										<input type="radio" class="skyradio" name="sfXnkh" value="1" onclick="javascript:show();">是
									</label>
									<label class="radio-inline">
										<input type="radio" class="skyradio" name="sfXnkh" value="0" checked="checked" onclick="javascript:show();">否
									</label>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">中信保买方编码&nbsp;&nbsp;</label>
								<input type="text" name="zxbmfdm" class="form-control skydisabled"   disabled="disabled"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">LC开证行&nbsp;&nbsp;</label> 
								<input type="text" name="kzh" onfocus="this.blur()" class="form-control parent-node" /> 
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">LC开证行SWIFT&nbsp;&nbsp;</label>
								<input type="text" name="kzhdm" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">所属组织&nbsp;&nbsp;</label> 
								<input type="text" name="sszzmc" onfocus="this.blur()" class="form-control parent-node" /> 
								<input type="hidden" name="sszz" /> 
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">国家&nbsp;&nbsp;</label>
									<select role="select" name="gj" size="1" class="form-control skyselect">
												${fns:loadCountryOption('0')}
								      </select>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">中信保额度&nbsp;&nbsp;</label> <input
									type="text" name="zxbed" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">内部管理额度&nbsp;&nbsp;</label> <input
									type="text" name="nbgled" class="form-control" />
							</div>
						</div>
				
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">开始有效期&nbsp;&nbsp;</label> <input
									type="text" name="ksyxq" class="form-control date-picker"/> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">结束有效期&nbsp;&nbsp;</label> <input
									type="text" name="yxq" class="form-control date-picker"/> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">限额闲置期&nbsp;&nbsp;</label> <input
									type="text" name="xexzq" class="form-control" />
								<label class="input-group-addon">天</label>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">赔付比例&nbsp;&nbsp;</label> <input
									type="text" name="pfbl" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">是否循环&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="checkbox-inline"> <input type="checkbox"
										class="skycheckbox" name="sfxh" value="1" >
									</label>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">账期&nbsp;&nbsp;</label> <input
									type="text" name="zq" class="form-control" />
								<label class="input-group-addon">天</label>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">赔付比例（拒收风险）&nbsp;&nbsp;</label> <input
									type="text" name="pfblJsfx" class="form-control" />
							</div>
						</div>
					</div>
					<div class="row" style="margin: 0px 8px;">
						<div class="space-4"></div>
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">币种&nbsp;&nbsp;</label> <input
										type="text" name="bz" value="USD" class="form-control"
										readonly="true" />
							</div>
						</div>  
					</div>
					<div class="row" style="margin: 0px;">
						<div class="space-4"></div>
						<div class="col-sm-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
								<textarea name="bzxx" class="autosize-transition form-control"></textarea>
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
	var sjc = "<%=sjc%>";
	var sfBg = "<%=sfBg%>";
	var isEdit = false;
	<shiro:hasPermission name="payment:payCredit:edit">isEdit = true;</shiro:hasPermission>

	$(function($) {
		$(".date-picker").bindDate();
		$(".skyselect").select2();
		$('#form-submit').validate({});
		//加载客户
	    $("#form-submit [name=khbm]").click(function(){
	    	InitKHBM();
	    });
		//加载开证行
		$("#form-submit [name=kzh]").click(function(){
			InitLCKZH();
	    });
		//加载所属组织
		InitSSZZ();
		//信用额度类型change事件
		InitXYEDLX();
		//加载数据
		bindFormData();
		/* //保存按钮
		$("#btn-save").click(function() {
			save();
		}); */
		//保存按钮
		$("#btn-submit").click(function() {
			submit();
		});
		//返回按钮
		$('#btn-back').click(function() {
			window.history.back(-1);
		});
		//中信保额度change事件
		$("#form-submit [name=zxbed]").on("blur",function() {
			var zxbed = $("#form-submit [name=zxbed]").val();
			if(!isNaN(zxbed)){
				$("#form-submit [name=nbgled]").val(zxbed);
			}
		});
	});
	/**************************************************function开始区域************************************************/
	//加载客户
	function InitKHBM() {
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户编码","value":"khbm"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码',width:80},
					  {name:'khmc', index:'khmc', label:'客户名称',width:120}],
			url:"<c:url value='/pub/widget/findCust'/>"
		}, {
			callback : function(rows) {
				if(rows){
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
					$("input[name=zxbmfdm]").val(rows.zxbmfdm);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
					$("input[name=zxbmfdm]").val("");
				}
				
			}
		});
	}
	//加载所属组织
	function InitSSZZ() {
		$("#form-submit [name='sszzmc']").bindTreeDialog({
			title:"所属组织",
			url : "<c:url value='/core/organization/loadTree'/>",
			searchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"}
		},{
			callback:function(node){
				if(node != "" && node != undefined){
					$("input[name='sszzmc']").val($.trim(node.name));
					$("input[name='sszz']").val(node.id);
				}else if(node == ""){
					$("input[name='sszzmc']").val("");
					$("input[name='sszz']").val("");
				}
			}
		});	
	}
	//信用额度类型change事件
	function InitXYEDLX(){
		$("#form-submit [name=xyedlx]").on("change", function(e) {
			//只有LC时，可以选择LC开证行
			if(e.val == "2"){
				$("#form-submit [name=kzh]").removeProp('disabled').removeAttr('disabled')
					.rules("add", {required: true});
				$("#form-submit [name=kzhdm]").removeProp('disabled').removeAttr('disabled')
					.rules("add", {required: true});
			}else{
				$("#form-submit [name=kzh]").prop('disabled','disabled').rules("remove", "required");
				$("#form-submit [name=kzhdm]").prop('disabled','disabled').rules("remove", "required");
				
				$("#form-submit [name=kzh]").closest('.input-group').removeClass('has-error');
				$("#form-submit [name=kzhdm]").closest('.input-group').removeClass('has-error');
			}
		});
	}
	//加载开证行
	function InitLCKZH() {
		$.tableDialogPage({
			title:"银行选择",
			searchCond:[{"name":"银行名称","value":"ywmc"},
			            {"name":"SWIFT代码","value":"swiftdm"}],
			colModel:[{name:'ywmc', index:'ywmc', label:'银行名称', width:80},
					  {name:'swiftdm', index:'swiftdm', label:'swift代码', width:80}],
			url:"<c:url value='/pub/widget/findBank'/>?sfKhkzh=1"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=kzh]").val(rows.ywmc);
					$("input[name=kzhdm]").val(rows.swiftdm);
				}else{
					$("input[name=kzh]").val("");
					$("input[name=kzhdm]").val("");
				}
			}
		});
	}
	//加载数据
	function bindFormData() {
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=bbh]").val(1);
			$("#form-submit [name=kzh]").prop('disabled','disabled');
			$("#form-submit [name=kzhdm]").prop('disabled','disabled');
			$("#form-submit [name=sfxh][value=1]").prop("checked","checked");
		} else {
			var editUrl = "<c:url value='/payment/payCredit/findById'/>";
			var param = {id : id};
			if(sfBg == 1){
				editUrl = "<c:url value='/payment/payCredit/changeById'/>";
				param.sjc = sjc;
			}
			$.bindAjax({
				url : editUrl,
				data : param,
				action : "search"
			},function(response) {
				$("#form-submit").setFormData(response);
				$("#form-submit [name=oper]").val("edit");
				adddisabled();
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
			xyedlx : 'required',
			khbm : 'required',
			//zxbmfdm : 'required',
			gj : 'required',
			zxbed : { required:true , number:true },
			nbgled : { required:true , number:true },
			yxq : { required:true , date:true },
			ksyxq : { required:true , date:true },
			xexzq : { required:true , digits:true },
			pfbl :{max : 1},
			zq : { required:true , number:true },
			pfblJsfx :{max : 1}
		},
		messages : {
			xyedlx : '信用额度类型不能为空!',
			khbm : '客户不能为空!',
			//zxbmfdm : '中信保买方代码不能为空!',
			gj : '国家不能为空!',
			zxbed : '中信保额度必须为数字!',
			nbgled : '内部管理额度必须为数字!',
			yxq : '结束有效期不能为空且必须为日期!',
			xexzq : '限额闲置期必须为整数!',
			pfbl : '赔付比例值不能大于1!',
			kzh : 'LC开证行不能为空!',
			kzhdm : 'LC开证行SWIFT不能为空!',
			zq : '账期不能为空!',
			ksyxq : '开始有效期不能为空且必须为日期!'
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

	//业务逻辑验证
	function Ywvalidate(){
		var param = $("#form-submit").getFormData();
		var nbgled=parseFloat(param.nbgled);
		var zxbed=parseFloat(param.zxbed);
		//非虚拟客户，中信保买方代码不能为空
		if(param.sfXnkh == 0){
			if(param.zxbmfdm.length == 0){
				swal("","非虚拟客户的中信保买方代码不能为空!","warning");
				return ;
			}
		}
		if(nbgled>zxbed){
			swal("","内部管理额度不能大于中信保额度!","warning");
			return false;
		}else{
			if(param.xyedlx == 2 && (param.kzh == "" || param.kzhdm == "")){
				swal("","LC开证行和开征行Swift Code不能为空!","warning");
				return false;
			}else{
				return true;
			}
		}
	}
	/* //保存按钮
	function save() {
		if (!$('#form-submit').valid()) {
			return false;
		}
		if(!Ywvalidate()){
			return false;
		}
		removedisabled();
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payCredit/edit'/>",
					data : param,
					action : "save"
				}, function(response) {
					adddisabled();
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);

				});
			}
		});
	}; */

	//提交
	function submit() {
		if (!$('#form-submit').valid()) {
			return false;
		}
		if(!Ywvalidate()){
			return false;
		}
		removedisabled();
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payCredit/submit'/>",
					data : param,
					action : "submit"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	
	function removedisabled(){
		$("#form-submit [name=xyedlx]").removeProp('disabled').removeAttr('disabled');
		$("#form-submit [name=khbm]").removeProp('disabled').removeAttr('disabled');
		$("#form-submit [name=kzh]").removeProp('disabled').removeAttr('disabled');
		$("#form-submit [name=kzhdm]").removeProp('disabled').removeAttr('disabled');
	}
	function adddisabled(){
		$("#form-submit [name=xyedlx]").prop("disabled","disabled");
		$("#form-submit [name=khbm]").prop("disabled","disabled");
		$("#form-submit [name=kzh]").prop("disabled","disabled");
		$("#form-submit [name=kzhdm]").prop("disabled","disabled");
	}
	function show(){
		//虚拟客户的中信保买方代码可以为空
		var  sfXnkh  =  $("#form-submit  [name='sfXnkh']:checked").val();
		if(sfXnkh == 0){
			$("#form-submit [name=zxbmfdm]").prop("disabled","disabled");
		}
		if(sfXnkh ==1){
			$('#form-submit [name=zxbmfdm]').removeProp('disabled').removeAttr('disabled') ;
		}
	}
	
	
	/**************************************************function结束区域************************************************/
</script>
</html>