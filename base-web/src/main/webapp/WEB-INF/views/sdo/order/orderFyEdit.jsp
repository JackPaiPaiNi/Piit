<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<%@include file="/WEB-INF/views/index/lfs.jsp"%>
<!-- 富文本框使用引入 -->
<link
	href="<%=request.getContextPath()%>/static/umeditor/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/umeditor/umeditor.config.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/umeditor/umeditor.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/umeditor/lang/zh-cn/zh-cn.js"></script>
</head>
<%
	String id = request.getParameter("id");
	String taskId = request.getParameter("taskId");
%>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<form id="form-submit">
					<div class="row" style="margin: 0px 8px;">
						<input type="hidden" name="id" />
						<!-- 订单id -->
						<input type="hidden" name="oper" /> <input type="hidden"
							name="sjc" /> <input type="hidden" name="sfBg" /> <input
							type="hidden" name="sfCh" /> <input type="hidden" name="tssapzt" />
						<!-- <input type="hidden" name="bbh"/> -->
						<input type="hidden" name="taskId" /> <input type="hidden"
							name="token" value="${token}" />
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订单号&nbsp;&nbsp;</label> <input
									type="text" name="ddid" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">是否免费&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline"> <input type="radio"
										class="skyradio" name="sfMf" value="0" checked="checked"
										onclick="show_pid();">否
									</label> <label class="radio-inline"> <input type="radio"
										class="skyradio" name="sfMf" value="1" onclick="hidden_pid();">是
									</label>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-piSelect" type="button"
								class="btn btn-purple btn-sm">
								<i class="fa fa-plus icon-on-right bigger-110"></i> PI选择
							</button>
						</div>

						<div class="col-xs-6 col-sm-3">
							<button id="btn-save" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp;
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">原订单号&nbsp;&nbsp;</label> <input
									type="text" name="yddid" class="form-control"
									readonly="readonly" />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">表头信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">工厂&nbsp;&nbsp;</label> <select
									role="select" name="scjd" size="1"
									class="form-control skydisabled" disabled="disabled">
									${fns:loadDictOption('SCJD_DYH')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订单类型&nbsp;&nbsp;</label> <select
									role="select" name="ddlx" size="1"
									class="form-control skydisabled" disabled="disabled">
									${fns:loadDictOption('DDLX')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司&nbsp;&nbsp;</label> <select
									role="select" name="gsbm" size="1"
									class="form-control skyselect">
									${fns:loadCompanyOption('0')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订单类别&nbsp;&nbsp;</label> <select
									role="select" name="ddlb" size="1"
									class="form-control skyselect">
									${fns:loadDictOption('DDLB_FY')}
								</select>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订单状态&nbsp;&nbsp;</label> <select
									role="select" name="zt" size="1"
									class="form-control skydisabled" disabled="disabled">
									${fns:loadDictOption('DJZT')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">业务类型&nbsp;&nbsp;</label> <select
									role="select" name="ywlx" size="1"
									class="form-control skyselect">
									${fns:loadDictOption('YWLX')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">制单人&nbsp;&nbsp;</label> <input
									type="text" name="zdrmc" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">制单日期&nbsp;&nbsp;</label> <input
									type="text" name="zdsj"
									class="form-control date-picker skydisabled"
									disabled="disabled" /> <span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">销售员&nbsp;&nbsp;</label> <input
									type="hidden" name="xsyid" class="form-control" /> <input
									type="text" name="xsymc" onfocus="this.blur()"
									class="form-control parent-node"
									style="cursor: pointer !important;" /> <span
									class="input-group-addon"> <i
									class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">业务组&nbsp;&nbsp;</label> <input
									type="hidden" name="ywz" class="form-control" /> <input
									type="text" name="ywzmc" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">销售组织&nbsp;&nbsp;</label> <input
									type="hidden" name="xszz" class="form-control" /> <input
									type="text" name="xszzmc" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">版本号&nbsp;&nbsp;</label> <input
									type="text" name="bbh" class="form-control" readonly />
							</div>
						</div>
					</div>

					<h5 class="header blue" style="margin-top: 4px;">基本信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">走货方式&nbsp;&nbsp;</label> <select
									role="select" name="zhfs" size="1"
									class="form-control skyselect skydisabled" disabled="disabled">
									${fns:loadDictOption('ZHFS')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">交货日期&nbsp;&nbsp;</label> <input
									type="text" name="jhrq" class="form-control date-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">国际贸易条款&nbsp;&nbsp;</label> <select
									role="select" name="gjmytk" size="1"
									class="form-control skyselect">
									${fns:loadDictOption('PIGJMYTK')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group-sm">
								<input type="text" name="gjmytkbz" placeholder="目的地"
									class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">付款条件&nbsp;&nbsp;</label> <input
									type="text" name="fktj" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">币种&nbsp;&nbsp;</label> <select
									role="select" name="bz" size="1" class="form-control skyselect">
									${fns:loadDictOption('BZ')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">是否验货&nbsp;&nbsp;</label> <select
									role="select" name="sfYh" size="1"
									class="form-control skyselect">
									${fns:loadDictOption('SF')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group-sm">
								<input type="text" id="sfyhbz" name="sfyhbz"
									placeholder="是否验货备注" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">PID&nbsp;&nbsp;</label> <input
									type="text" name="pid" onfocus="this.blur()"
									class="form-control parent-node" /> <span
									class="input-group-addon"> <i
									class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">验货日期&nbsp;&nbsp;</label> <input
									type="text" name="yhrq" class="form-control date-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">渠道&nbsp;&nbsp;</label> <select
									role="select" name="qd" size="1" class="form-control skyselect">
									${fns:loadDictOption('QD')}
								</select>
							</div>
						</div>
					</div>

					<h5 class="header blue" style="margin-top: 4px;">客户信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label> <input
									type="text" name="khbm" onfocus="this.blur()"
									class="form-control" /> <span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
									type="text" name="khmc" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">销往国家&nbsp;&nbsp;</label> <select
									role="select" name="xwgj" size="1"
									class="form-control skyselect">
									${fns:loadCountryOption('0')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">时区&nbsp;&nbsp;</label> <input
									type="text" name="sq" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">品牌&nbsp;&nbsp;</label> <input
									type="text" name="pp" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">出厂语言&nbsp;&nbsp;</label> <select
									role="select" name="ccyy" size="1"
									class="form-control skyselect skydisabled" disabled="disabled">
									${fns:loadDictOption('CCYY')}
								</select>
							</div>
						</div>
					</div>

					<h5 class="header blue" style="margin-top: 4px;">产品信息</h5>
					<div id="grid-parent-cpxx">
						<table id="grid-table-cpxx"></table>
						<div id="grid-pager-cpxx"></div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">备注信息</h5>
					<!-- 富文本框容器 -->
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
								<script type="text/plain" id="bzxx"
									style="width: 100%; height: 100px;">
									</script>
							</div>
						</div>
					</div>
					<!-- 富文本框容器 -->
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">变更信息备注&nbsp;&nbsp;</label>
								<script type="text/plain" id="bgbz"
									style="width: 100%; height: 100px;">
									</script>
							</div>
						</div>
					</div>
					<!-- <div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-sm-6 col-sm-6">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">备注&nbsp;&nbsp;</label>
							<textarea name="bzxx" class="autosize-transition form-control"></textarea>
						</div>
					</div>
					<div class="col-sm-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">变更信息备注&nbsp;&nbsp;</label>
							<textarea name="bgbz" class="autosize-transition form-control"></textarea>
						</div>
					</div>
				</div> -->
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm" style="width: 20px;">
								<label class="input-group-addon">附件&nbsp;&nbsp;</label>
								<div class="form-control" style="text-align: left;">
									<input id="fj" type="file" class="form-control">
								</div>
								<input type="hidden" name="fj" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<!-- <div id="multiFileQueue">
						</div> -->
							<div id="fjxx">
								<ul class="list-unstyled spaced"></ul>
							</div>
							<div id="multiFileQueue"></div>
						</div>
					</div>
					<h5 class="header blue" style="margin: 0; padding: 0;">审批意见</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-sm-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">申请人提交意见&nbsp;&nbsp;</label>
								<textarea name="spyj" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<!-- 审批日志 -->
					<div class="space-4"></div>
					<h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
					<div class="space-4"></div>
					<c:import url="/pub/showLog/orderFy" charEncoding="UTF-8" />
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
	<span class="loading-indicator"> <label><i
			class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
	</span>
</body>
<script type="text/javascript">
	var grid_cpxx_selector = "#grid-table-cpxx";
	var pager_cpxx_selector = "#grid-pager-cpxx";
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	var hasDelete = false;
	<shiro:hasPermission name="order:orderFy:edit">isEdit=true;hasDelete=true;</shiro:hasPermission>
	
	$(function($){
		$(".skyselect").select2();
		$(".date-picker").bindDate();
		// 富文本框初始化(操作API可参照static/umeditor下的index.html)
		UM.getEditor('bzxx');
		UM.getEditor('bgbz');
		// 附件控件
		$('#fj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#fj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#fjxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=fj]").val($('#fjxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#fjxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=fj]").val($('#fjxx').html());
				}
			});
		});
		// 销售员选择
		bindXsySelect();
		// 产品ID选择
		$("#form-submit [name=pid]").click(function(){
			selectPidInit();
		});
		// 客户选择
		$("#form-submit [name=khbm]").click(function(){
			//bindKhbm();
			var xsyid = $("#form-submit [name=xsyid]").val();
			if(xsyid == null || xsyid == ""){
				swal('','请先选择销售员！','warning'); 
	    		return ;
			}else {
				bindKhbm();
			}
		});
		// PI类型	
		$('#form-submit [name=ddlb]').on('change',function(e){
			if(id == "null"){
				if($(this).val() == 8){
					$('#form-submit [name=scjd]').removeProp('disabled').removeAttr("disabled");
				}else{
					$('#form-submit [name=scjd]').prop('disabled','disabled');
				}
			}
			if($(this).val() == 7){
				$('#form-submit [name=zhfs]').removeProp('disabled').removeAttr("disabled");
				$('#form-submit [name=sq]').removeProp('disabled').removeAttr("disabled");
				$('#form-submit [name=ccyy]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=zhfs]').select2("val","");
				$('#form-submit [name=sq]').val("");
				$('#form-submit [name=ccyy]').select2("val","");
				$('#form-submit [name=zhfs]').prop('disabled','disabled');
				$('#form-submit [name=sq]').prop('disabled','disabled');
				$('#form-submit [name=ccyy]').prop('disabled','disabled');
			}
		});
		// 付款条件初始化
		bindFktjSelect();
		// 初始化页面数据
		initFormData(id);
		// 保存
		$("#btn-save").click(function(){
			save();
	    });
		// 提交
		$("#btn-submit").click(function(){
			submit();
	    });
		//前端数据校验
		validate();
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		// PI选择
		$("#btn-piSelect").click(function(){
			var width = 1366;
			var height = 768;
			var left = 0;
			var top = 0;
			var ddid = $("#form-submit [name=ddid]").val();
			var pageUrl = "<c:url value='/order/orderReferPi/fy'/>"+"?ddid=" + ddid;
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				var data = window.showModalDialog(pageUrl,null,dialogArgs);
				if(data){
					initPiData(data);
				}
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
				var opener = window.open(pageUrl,null,dialogArgs);
				opener.openerCallBack = function(data){
					initPiData(data);
				}
			}
		});
	});
	
	
	
	// 前端数据校验
	function validate(){
		// 前端数据校验
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: 'input[type=hidden]',
			rules: {
				gsbm: 'required',
				xsymc:'required',
				ddbmlx: 'required',
				ddlb: 'required',
				//zhfs: 'required',
				ywlx: 'required',
				//pid : 'required',
				mjxh :'required',
				ggmx :'required',
				jhrq :'required',
				pbzyq:'required',
				gjmytk:'required',
				gjmytkbz:'required',
				fktj:'required',
				bz:'required',
				sfYh:'required',
				//yhrq:'required',
				khbm:'required',
				xwgj:'required',
				scjd:'required',
				qd:'required'
			},
			messages: {
				gsbm: '公司未填写',
				xsymc:'销售员名称未填写',
				ddlb: '订单类别未填写',
				//zhfs: '走货方式未填写',
				ywlx: '业务类型未填写',
				//pid : 'PID未填写',
				mjxh :'买家型号未填写',
				ggmx :'规格明细未填写',
				jhrq :'交货日期未填写',
				pbzyq:'屏包装要求未填写',
				gjmytk:'国际贸易条款未填写',
				gjmytkbz:'国际贸易条款备注未填写',
				fktj:'付款条件未填写',
				bz:'币种未填写',
				sfYh:'是否验货未填写',
				//yhrq:'验货日期未填写',
				khbm:'客户编码未填写',
				xwgj:'销往国家未填写',
				scjd:'工厂未填写',
				qd:'渠道未填写'
			},
	        showErrors: function(errorMap, errorList) {  
	        	$('.input-group').removeClass('has-error');
	            if(errorList.length != 0){
		            var msg = "";  
		            $.each( errorList, function(i,v){  
		              msg += (v.message+"\r\n"); 
		              $(v.element).closest('.input-group').addClass('has-error');
		            });  
	            	swal({title: "校验不通过！",text: msg,type: "error"},	function(){
						return false;
					});
	            }
	        }
		});
	}
	
	// PID选择
	function selectPidInit(){
		$.tableDialogPage({
			title:"PID选择",
			searchCond:[{"name":"PID","value":"pid"},
			            {"name":"机型","value":"jixing"},
			            {"name":"机芯","value":"jixin"}],
			colModel:[{name:'pid', index:'pid', label:'PID', width:80},
			          {name:'khmc', index:'khmc', label:'客户名称', width:80},
			          {name:'pp', index:'pp', label:'品牌名称', width:80},
			          {name:'jixing', index:'jixing', label:'机型', width:80},
			          {name:'jixin', index:'jixin', label:'机芯', width:80},
			          {name:'zdrmc', index:'zdrmc', label:'申请人', width:80}
			        ],
			url:"<c:url value='/pub/widget/findPid'/>"
		},{
			callback:function(rows){
				if(rows){
					// 根据所选PID赋值相关信息
					$("input[name=pid]").val(rows.pid);
				}
			}
		});
	}
	
	function initPiData(data){
		$(grid_cpxx_selector).jqGrid("clearGridData");
		$(grid_cpxx_selector).jqGrid("addRowData", null, data, "last");
		//$("#form-submit [name=scjd]").select2("val",data[0].scjd);
		$("#form-submit [name=gsbm]").select2("val",data[0].gsbm);
		$("#form-submit [name=khbm]").val(data[0].khbm);
		$("#form-submit [name=khmc]").val(data[0].khmc);
		$("#form-submit [name=fktj]").select2("val",data[0].fktj);
		$("#form-submit [name=gjmytk]").select2("val",data[0].gjmytk);
		$("#form-submit [name=gjmytkbz]").val(data[0].gjmytkbz);
		$("#form-submit [name=xsyid]").val(data[0].xsyid);
		$("#form-submit [name=xsymc]").val(data[0].xsymc);
		$("#form-submit [name=xszz]").val(data[0].xszz);
		$("#form-submit [name=xszzmc]").val(data[0].xszzmc);
		$("#form-submit [name=ywz]").val(data[0].ywz);
		$("#form-submit [name=ywzmc]").val(data[0].ywzmc);
		$("#form-submit [name=zhfs]").select2("val",data[0].zhfs);
		$("#form-submit [name=bz]").select2("val",data[0].bz);
		//PI类型7、8、9、10：外采、工装、线体、设备，订单类别：7.8.9.10
		if(data.length>0){
			$("#form-submit [name=ddlb]").select2("val",data[0].pilx);
		}
		/* if(data[0].pilx == "6"){
			$("#form-submit [name=ddlb]").select2("val","5");
		} */
	}
	// 销售员选择
	function bindXsySelect(){
		$("#form-submit [name=xsymc]").bindTreeTableDialog({
			title:"销售员选择",
			leftUrl : "<c:url value='/core/organization/loadTree'/>",//左侧树查询的url
			rightUrl : "<c:url value='/mdm/employee/search'/>",//右侧列表查询的url
			leftSearchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			rightSearchParams:[{"name":"员工号","value":"empCode"},{"name":"员工名","value":"name"}],
			rightColModel:[{"colName":"empCode","colTitle":"员工号","width":"40%"},
				           {"colName":"name","colTitle":"员工名","width":"40%"},
				           {"colName":"xszz","colTitle":"销售组织",hidden:true},
				           {"colName":"xszzmc","colTitle":"销售组织名称",hidden:true},
				           {"colName":"ywz","colTitle":"业务组",hidden:true},
				           {"colName":"ywzmc","colTitle":"业务组名称",hidden:true}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"},//查询基础架构
			nodeParams:[{"nodeField":"id","searchParam":"deptCode"}]//右侧查询时会附带选中的树节点的信息，取节点的id属性值以deptCode这个参数名传到后台
		},{
			callback:function(record){
				if(record){
					$("#form-submit [name=xsyid]").val(record.empCode);//参考rightColModel
					$("#form-submit [name=xsymc]").val(record.name);
					$("#form-submit [name=ywz]").val(record.ywz);
					$("#form-submit [name=ywzmc]").val(record.ywzmc);
					$("#form-submit [name=xszz]").val(record.xszz);
					$("#form-submit [name=xszzmc]").val(record.xszzmc);
				}else{
					$("#form-submit [name=xsyid]").val("");
					$("#form-submit [name=xsymc]").val("");
					$("#form-submit [name=ywz]").val("");
					$("#form-submit [name=ywzmc]").val("");
					$("#form-submit [name=xszz]").val("");
					$("#form-submit [name=xszzmc]").val("");
				}
				$("input[name=khbm]").val("");
				$("input[name=khmc]").val("");
				$("input[name=fktj]").select2("val","");
			}
		});
	}
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户编码","value":"khbm"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:80},
					  {name:'khmc', index:'khmc', label:'客户名称', width:80},
					  {name:'khdz', index:'khdz', label:'客户地址', width:80,hidden:true},
					  {name:'dh', index:'dh', label:'电话', width:80,hidden:true},
					  {name:'yx', index:'yx', label:'邮箱', width:80,hidden:true},
					  {name:'lxr', index:'lxr', label:'联系人', width:80,hidden:true},
					  {name:'fktj', index:'fktj',hidden:true},
					  {name:'fktjms', index:'fktjms', label:'付款条件名称', width:120}],
				  url:"<c:url value='/pub/widget/findCustByXsy'/>?xsyid="+$('#form-submit [name=xsyid]').val()
		},{
			callback:function(rows){
				if(rows){
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
					$("input[name=fktj]").select2("val",rows.fktj);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
					$("input[name=fktj]").select2("val","");
				}
			}
		});
	}
	//取付款条件
	function bindFktjSelect(){
		$.post("<c:url value='/pub/select2/selectPayTerm'/>",{},
			function(result){
				var data = $.map(result, function (obj) {
					obj.id = obj.fktjdm;
			        obj.text = obj.fktjdm + "-" + obj.fktjms;	      
			        return obj;
				});
 				$("#form-submit [name=fktj]").addClass("skyselect").select2({data:data}).on("change",function(e){
 				})
 			}, "json");
	}
	
	// 产品信息编辑表初始化
	function bindGridCpxx(){
		$(grid_cpxx_selector).bindTable({
			caption: "",
			pager: pager_cpxx_selector,
			gridParent: "#grid-parent-cpxx",
			footerrow:true,
			datatype: "local",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60},
				{name:'rn', label:'rn', hidden: true, width:60},
				{name:'piitemid', index:'piitemid', label:'PI明细ID', width:80, hidden:true},
				{name:'flag', index:'flag', label:'操作类型', width:80, editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('CZLX')}", dataInit:initSelect2}},
				{name:'piid', index:'piid', label:'PI号', width:80, hidden:false},
				{name:'cplx', index:'cplx', label:'产品类型', width:80, editable : true, edittype:"select", formatter:"select",
					editoptions:{value:"${fns:loadDictEditOption('CPLX_FY')}", dataInit:initSelect2}},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:150, editoptions : {dataInit : InitWL}},
				{name:'model', index:'model', label:'我司型号', width:150, editoptions:{disabled:true}},
				{name:'khxh', index:'khxh', label:'客户型号', width:150},
				{name:'khxhms', index:'khxhms', label:'客户型号描述', width:80},
				{name:'sl', index:'sl', label:'数量', align:'right', width:80, formatter:'integer',
					formatoptions:{thousandsSeparator: ','}, editrules:{integer:true}, editoptions:{dataInit: initSl}},
				<shiro:hasPermission name="order:orderFy:price">
				{name:'dj', index:'dj', label:'单价', align:'right', width:80, formatter:'number',
					editrules:{number:true},formatoptions:{thousandsSeparator: ',', decimalPlaces: 6},editoptions:{dataInit: initDj}},
				{name:'je', index:'je', label:'金额', align:'right', width:80, formatter:'number',editrules:{number:true},
					formatoptions:{thousandsSeparator: ',', decimalPlaces: 6},editoptions:{disabled:true}},
				</shiro:hasPermission>
				{name:'mfsl', index:'mfsl', label:'免费数量', align:'right', width:80,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}}
			],
			gridComplete: function(){
	            sumGrid();
		   	},
			editTable:true ,
			editComplete: function(lastEdit, rowData){
				sumGrid();
			}
		},{
			add:isEdit,
			edit:isEdit,
			del:hasDelete,
			complete:isEdit
		});
	}
	
	//初始化页面数据
	function initFormData(id){
		if(id == "null"){
			//add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=ddlx]").val("5");
			$("#form-submit [name=ddlb]").select2("val","7");//
			$("#form-submit [name=ywlx]").select2("val","4");
			$("#form-submit [name=zt]").val("1");
			$("#form-submit [name=zhfs]").select2("val","3");//走货方式:CBU
			$("#form-submit [name=bz]").select2("val","USD");//币种:USD
			$("#form-submit [name=yhxs]").select2("val","1");//验货形式:SGS
			//$("#form-submit [name=scjd]").select2("val",2110);
			$("#form-submit [name=scjd]").val(2110);
			$('#form-submit [name=zhfs]').removeProp('disabled').removeAttr("disabled");
			$('#form-submit [name=sq]').removeProp('disabled').removeAttr("disabled");
			$('#form-submit [name=ccyy]').removeProp('disabled').removeAttr("disabled");
			show_pid();
			// 产品信息编辑表初始化
			bindGridCpxx();
		} else {
			// edit
			$.bindAjax({
				url : "<c:url value='/order/orderFy/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				if(response){
					$("#form-submit [name=ddlb]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit").setFormData(response);
					// 富文本框赋值
					if(response.bzxx){
						UM.getEditor('bzxx').setContent(response.bzxx);
					}
					if(response.bgbz){
						UM.getEditor('bgbz').setContent(response.bgbz);
					}
					// 变更草稿编辑时，客户、币种、付款条件、走货方式、PID、生产基地不允许修改
					if(response.sfBg == 1){
						//$("#form-submit [name=scjd]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=khbm]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=fktj]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=bz]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=zhfs]").prop("disabled","disabled").addClass("skydisabled");
					}
					if(response.sfMf == 0){
						show_pid();
					} else {
						hidden_pid();
					}
					// 是否可以删除
					if(response.sfBg && response.sfBg == 1){
						hasDelete = false;
					}
					// 产品信息编辑表初始化
					bindGridCpxx();
					// 加载产品信息明细
					if(response.orderFyItemList){
						$(grid_cpxx_selector).jqGrid("addRowData", null, response.orderFyItemList, "last");
					}
					$("#form-submit [name=oper]").val("edit");
					$("#form-submit [name=taskId]").val(taskId);
					$("#form-submit [name=zhfs]").trigger("change");
					$("#form-submit [name=ccyy]").trigger("change");
				}
			});
		}
	}
	//保存
	function save(){
		// 编辑表结束编辑
		var lastEdit = $(grid_cpxx_selector).data('lastEdit');
		if(lastEdit){
			$(grid_cpxx_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var cpData = $(grid_cpxx_selector).getRowData();
		if(cpData.length == 0){
			swal('产品信息为空!');
			return  ;
	    }
		//表单数据验证
		if(!$('#form-submit').valid()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
		if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		param.bzxx = UM.getEditor('bzxx').getContent();
		param.bgbz = UM.getEditor('bgbz').getContent();
		param.cpList = JSON.stringify(cpData);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/order/orderFy/edit'/>",
					data:param,
					action:"save"
				},function(response){
					if(response){
						var result = JSON.parse(response);
						$('#form-submit [name=token]').val(result.token);
						$("#form-submit [name=id]").val(result.id);
						$("#form-submit [name=ddid]").val(result.ddid);
						$("#form-submit [name=yddid]").val(result.yddid);
						$("#form-submit [name=sjc]").val(result.sjc);
						$("#form-submit [name=bbh]").val(result.bbh);
					}
				}); 
			}
		});
	}
	//提交
	function submit(){
		// 编辑表结束编辑
		var lastEdit = $(grid_cpxx_selector).data('lastEdit');
		if(lastEdit){
			$(grid_cpxx_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var cpData = $(grid_cpxx_selector).getRowData();
		if(cpData.length == 0){
			swal('产品信息为空!');
			return  ;
	    }
		//表单数据验证
		if(!$('#form-submit').valid()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
		if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		// 编辑表结束编辑
		var lastEdit = $(grid_cpxx_selector).data('lastEdit');
		if(lastEdit){
			$(grid_cpxx_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var param = $("#form-submit").getFormData();
		param.bzxx = UM.getEditor('bzxx').getContent();
		param.bgbz = UM.getEditor('bgbz').getContent();
		var cpData = $(grid_cpxx_selector).getRowData();
		param.cpList = JSON.stringify(cpData);
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/order/orderFy/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	// 隐藏PI
	function show_pid(){
		$("#btn-piSelect").removeProp("disabled").removeAttr("disabled");
		// 禁用编辑表按钮和列编辑
		$("#add_grid-table-cpxx").hide();
		$(grid_cpxx_selector).setColProp("wlbh",{editoptions:{disabled:true}});
		$(grid_cpxx_selector).setColProp("dj",{editoptions:{disabled:true}});
		$(grid_cpxx_selector).setColProp("je",{editoptions:{disabled:true}});
	}
	// 显示PI
	function hidden_pid(){
		$("#btn-piSelect").prop("disabled","disabled");
		// 启用编辑表按钮和列编辑
		$("#add_grid-table-cpxx").show();
		$(grid_cpxx_selector).setColProp("wlbh",{editoptions:{disabled:false}});
		$(grid_cpxx_selector).setColProp("dj",{editoptions:{disabled:false}});
		$(grid_cpxx_selector).setColProp("je",{editoptions:{disabled:false}});
	}
	
	// 初始化编辑表select2
	function initSelect2(elem){
		$(elem).width("100%").addClass("skyselect").select2();
	}
	// 初始化编辑表数量*单价=金额
	function initSl(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).val();
			var dj = $(elem).closest("tr.jqgrow").find("[name='dj']").val();
			var je = "";
			if(sl != "" && dj != ""){
				je = sl * dj;
				$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(6));
			}
		});
	}
	function initDj(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).closest("tr.jqgrow").find("[name='sl']").val();
			var dj = $(elem).val();
			var je = "";
			if(sl != "" && dj != ""){
				je = sl * dj;
				$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(6));
			}
		});
	}
	// 计算合计行
	function sumGrid(){
		var sl;
		var je;
		$(grid_cpxx_selector).footerData("set",{"khxhms":"合计"}); //合计
		var rowNum = $(grid_cpxx_selector).jqGrid('getGridParam','records');
		if(rowNum >0 ){
			sl = $(grid_cpxx_selector).getCol("sl",false,"sum"); 
			je = $(grid_cpxx_selector).getCol("je",false,"sum"); 
		}
		$(grid_cpxx_selector).footerData("set",{"sl":sl, "je":je}); //将合计值显示出来
	}
	
	//初始化物料
	function InitWL(elem) {
		$(elem).wrap('<span style="cursor:pointer;width:100%;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title:"物料选择",
				searchCond:[{"name":"物料编号","value":"wlbh"},
				            {"name":"我司型号","value":"model"}],
				colModel:[{name:'id', index:'id', label:'ID',hidden:true},
				          {name:'wlbh', index:'wlbh', label:'物料编号', width:80},
				          {name:'model', index:'model', label:'我司型号', width:80},
				          {name:'wlms', index:'wlms', label:'物料描述', width:80},
						  {name:'wldw', index:'wldw', label:'单位', width:80}],
			url: "<c:url value='/pub/widget/findMaterial'/>"
			},{
				callback:function(rows){
					if(rows){
					  $(elem).val(rows.wlbh);
					  $(elem).closest("tr.jqgrow").find("[name='khxhms']").val(rows.wlms);
					  //客户型号和我司型号大多时候是一样的
					  $(elem).closest("tr.jqgrow").find("[name='model']").val(rows.model);
					  $(elem).closest("tr.jqgrow").find("[name='khxh']").val(rows.model);
					}else{
					  $(elem).val("");	
					}
				}
			});
		});
	}
	
	function initSelect2(elem){
		$(elem).width(140).addClass(".skyselect").select2();
	}
</script>
</html>