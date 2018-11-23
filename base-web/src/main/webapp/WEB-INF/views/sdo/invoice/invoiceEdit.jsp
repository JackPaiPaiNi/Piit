<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<%@include file="/WEB-INF/views/index/lfs.jsp"%>
<%
		String id = request.getParameter("id");
		String zt = request.getParameter("zt");
		String taskId = request.getParameter("taskId");
	%>
</head>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form id="form-submit">
					<div class="row" style="margin: 0px 8px;">
						<input type="hidden" name="id" />
						<!-- id -->
						<input type="hidden" name="oper" /> <input type="hidden"
							name="sjc" />
						<%-- <input type="hidden" name="token" value="${token}"/> --%>
						<input type="hidden" name="taskId" /> <input type="hidden"
							name="gsbm" /> <input type="hidden" name="khbm" /> <input
							type="hidden" name="xsyid" /> <input type="hidden" name="xsymc" />
						<input type="hidden" name="ywz" /> <input type="hidden"
							name="ywzmc" /> <input type="hidden" name="xszz" /> <input
							type="hidden" name="xszzmc" />
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">发票号&nbsp;&nbsp;</label> <input
									type="text" name="fph" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">发票号2&nbsp;&nbsp;</label> <input
									type="text" name="fph2" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-2">
							<button id="btn-orderSelect" type="button"
								class="btn btn-purple btn-sm">
								<i class="fa fa-plus icon-on-right bigger-110"></i> 订单信息选择
							</button>
						</div>
						<div class="col-xs-6 col-sm-3"></div>
						<div class="col-xs-6 col-sm-4">
							<button id="btn-save" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp;
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="fjbtn-submit" type="button"
								class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交附件
							</button>
							&nbsp;
							<button id="undo" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">发票类型&nbsp;&nbsp;</label> <select
									role="select" name="fplx" size="1"
									class="form-control skyselect">
									${fns:loadDictOption('FPLX')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">发票状态&nbsp;&nbsp;</label> <select
									role="select" name="zt" size="1"
									class="form-control skydisabled" disabled="disabled">
									${fns:loadDictOption('FPZT')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">开票方式&nbsp;&nbsp;</label> <select
									role="select" name="kpfs" size="1"
									class="form-control skyselect skydisabled">
									${fns:loadDictOption('KPFS')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">实际发票总金额&nbsp;&nbsp;</label> <input
									type="text" name="sjfpzje" class="form-control " />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">公司信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司名称&nbsp;&nbsp;</label> <input
									type="text" name="gsmc" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司联系电话&nbsp;&nbsp;</label> <input
									type="text" name="gslxdh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司地址&nbsp;&nbsp;</label> <input
									type="text" name="gsdz" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">Sold to
						Messrs</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
									type="text" name="khmc" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户联系电话&nbsp;&nbsp;</label> <input
									type="text" name="khdh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户地址&nbsp;&nbsp;</label> <input
									type="text" name="khdz" class="form-control" />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">Consignee to</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
									type="text" name="shfmc" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户联系电话&nbsp;&nbsp;</label> <input
									type="text" name="shfdh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户地址&nbsp;&nbsp;</label> <input
									type="text" name="shfdz" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-8"></div>
					<ul class="nav nav-tabs">
						<li class="active"><a href="#jbxx-tab" data-toggle="tab">基本信息</a></li>
						<li><a href="#fpxx-tab" data-toggle="tab">发票信息</a></li>
						<li><a href="#xdxx-tab" data-toggle="tab">箱单信息</a></li>
						<li><a href="#qtfy-tab" data-toggle="tab">其他费用</a></li>
					</ul>
					<div class="tab-content">
						<!-- 基本信息TAB -->
						<div class="tab-pane fade active in" id="jbxx-tab">
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出运类型&nbsp;&nbsp;</label> <select
											role="select" name="cylx" size="1"
											class="form-control skyselect">
											${fns:loadDictOption('CYLX_FP')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">币种&nbsp;&nbsp;</label> <select
											role="select" name="bz" size="1"
											class="form-control skyselect">
											${fns:loadDictOption('BZ')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票总金额&nbsp;&nbsp;</label> <input
											type="text" name="zje" class="form-control skydisabled"
											disabled="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否需报关&nbsp;&nbsp;</label>
										<div class="form-control ">
											<label class="radio-inline"> <input type="radio"
												class="skyradio" name="sfBg" value="1" checked="checked">是
											</label> <label class="radio-inline"> <input type="radio"
												class="skyradio" name="sfBg" value="0">否
											</label>
										</div>
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
										<label class="input-group-addon">L/C编号&nbsp;&nbsp;</label> <input
											type="text" id="lcbh" name="lcbh" onfocus="this.blur()"
											class="form-control parent-node" /> <span
											class="input-group-addon"> <i
											class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">贸易条款&nbsp;&nbsp;</label> <select
											role="select" name="mytk" size="1"
											class="form-control skyselect">
											${fns:loadDictOption('PIGJMYTK')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group-sm">
										<input type="text" name="gjmytkbz" placeholder="贸易条款备注备注"
											class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">起运港&nbsp;&nbsp;</label> <input
											type="text" name="qyg" class="form-control" />
										<%-- 									<select role="select" name="qyg" size="1" class="form-control skyselect">
										${fns:loadDictOption('QYG')}
									</select> --%>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">卸货港&nbsp;&nbsp;</label> <input
											type="text" name="xhg" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">目的港&nbsp;&nbsp;</label> <input
											type="text" name="mdg" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船名&nbsp;&nbsp;</label> <input
											type="text" name="cm" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票日期&nbsp;&nbsp;</label> <input
											type="text" name="fprq" class="form-control date-picker" /> <span
											class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">起运日期&nbsp;&nbsp;</label> <input
											type="text" name="qyrq" class="form-control date-picker" /> <span
											class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预计到港日期&nbsp;&nbsp;</label> <input
											type="text" name="yjdgq" class="form-control date-picker" />
										<span class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">航次&nbsp;&nbsp;</label> <input
											type="text" name="hc" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">提单号&nbsp;&nbsp;</label> <input
											type="text" name="tdh" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否按比例拆分价格&nbsp;&nbsp;</label>
										<div class="form-control ">
											<label class="radio-inline"> <input type="radio"
												class="skyradio" id="sfAfktjcfjg" name="sfAfktjcfjg"
												value="1">是
											</label> <label class="radio-inline"> <input type="radio"
												class="skyradio" id="sfAfktjcfjg" name="sfAfktjcfjg"
												value="0" checked="checked">否
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">拆分比例&nbsp;&nbsp;</label> <input
											type="text" name="cfbl1" class="form-control" /> <span
											class="input-group-addon">+</span> <input type="text"
											name="cfbl2" class="form-control skydisabled"
											disabled="disabled" /> <span class="input-group-addon">=100</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票箱单模板&nbsp;&nbsp;</label> <select
											role="select" name="fpmb" size="1"
											class="form-control skyselect">
											${fns:loadDictOption('FPMB')}
										</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">箱单物料描述语言&nbsp;&nbsp;</label>
										<select role="select" name="xdwlmsyy" size="1"
											class="form-control skyselect">
											${fns:loadDictOption('XDWLMSYY')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">海关商品编码&nbsp;&nbsp;</label> <select
											role="select" name="hgspbm" size="1"
											class="form-control skyselect">
											${fns:loadDictCodeNameOption('HGSPBM')}
										</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm" style="width: 20px;">
										<label class="input-group-addon">发票&箱单附件&nbsp;&nbsp;</label> 
									    <div class="form-control" style="text-align: left;">
											<input id="fj" type="file" class="form-control">
										</div>
										<input type="hidden" name="fj" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">
									<div id="fjxx">
										<ul class="list-unstyled spaced"></ul>
									</div>
									<div id="multiFileQueue"></div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-sm-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票备注&nbsp;&nbsp;</label>
										<textarea name="bzxx" class="autosize-transition form-control"></textarea>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div id="multiFileQueue"></div>
								</div>
							</div>
						</div>
						<!-- 发票信息TAB -->
						<div class="tab-pane fade" id="fpxx-tab">
							<button id="btn-materialSelect" type="button"
								class="btn btn-purple btn-sm">
								<i class="fa fa-plus icon-on-right bigger-110"></i> 物料信息选择
							</button>
							<div class="space-4"></div>
							<div id="grid-parent-fpxx">
								<table id="grid-table-fpxx"></table>
								<div id="grid-pager-fpxx"></div>
							</div>
						</div>
						<!-- 箱单信息TAB -->
						<div class="tab-pane fade" id="xdxx-tab">
							<div id="grid-parent-xdxx">
								<table id="grid-table-xdxx"></table>
								<div id="grid-pager-xdxx"></div>
							</div>
						</div>
						<!-- 其他费用TAB -->
						<div class="tab-pane fade" id="qtfy-tab">
							<div id="grid-parent-qtfy">
								<table id="grid-table-qtfy"></table>
								<div id="grid-pager-qtfy"></div>
							</div>
						</div>
					</div>
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
	// 变量定义开始
	var id = "<%=id%>";
	var zt = "<%=zt%>";
	var taskId = "<%=taskId%>";
	var grid_fpxx_selector = "#grid-table-fpxx";
	var pager_fpxx_selector = "#grid-pager-fpxx";
	var grid_xdxx_selector = "#grid-table-xdxx";
	var pager_xdxx_selector = "#grid-pager-xdxx";
	var grid_qtfy_selector = "#grid-table-qtfy";
	var pager_qtfy_selector = "#grid-pager-qtfy";
	// 不可编辑
	var isEdit = false;
	// 权限判断
	<shiro:hasPermission name="invoice:invoice:edit">isEdit=true;</shiro:hasPermission>
	// 变量定义结束 
	// 加载开始
	$(function($){
		if(zt == 2){
			$("#btn-save").prop("disabled","disabled");
			$("#btn-submit").prop("disabled","disabled");
		}else{
			$("#fjbtn-submit").prop("disabled","disabled");
		}
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
		// L/C选择框
		$("#lcbh").parent().click(function(){
			bindLcbh();
		});
		// 付款条件初始化
		getFktj();
		//是否按付款条件拆分价格选择是可编辑拆分比例
  		bindSfAfktjcfjgEvent();
 		//海关商品编码绑定事件
 		bindHgspmsEvent();
 		//开票方式绑定事件
 		bindKpfsEvent();
		// 发票信息编辑表
		bindGridItem();
		// 箱单信息编辑表
		bindGridXdxx();
		// 其他信息编辑表
		bindGridQtfy();
		//订单信息选择
		orderSelect();
		//物料信息选择
		materialSelect();
 		// 初始化页面数据
 		bindFormData(id);
  		// 保存
		$("#btn-save").click(function(){
			save();
		});
  		// 返回
		$("#undo").click(function(){
			window.history.back(-1);
	    });
  		// 提交
		$("#btn-submit").click(function(){
			submit();
	    }); 
		//上传附件
  		fjxxInit();
  		// 提交
		$("#fjbtn-submit").click(function(){
			submitFj();
	    }); 
	});
	/**************************************************function开始区域************************************************/
	//上传附件
	function fjxxInit(){
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
	}
	//绑定LC选择框
	function bindLcbh(){
		$.tableDialogPage({
			title : "LC选择",
			searchCond : [{"name":"信用证号","value":"lcbh"},
				          {"name":"客户名称","value":"khmc"}],
			colModel : [ {name:'id', index:'id', label:'ID',hidden:true},
			             {name:'lcbh', index:'lcbh', label:'信用证号'},
				         {name:'khbm', index:'khbm', label:'客户编码'},
				         {name:'khmc', index:'khmc', label:'客户名称'},
				         {name:'kzh', index:'kzh', label:'开证行'},
				         {name:'kzhdm', index:'kzhdm', label:'Swift Code'},
						 {name:'je', index:'je', label:'L/C金额'},
				         {name:'mytkmc', index:'mytkmc', label:'交货条件'},
						 {name:'zwzcq', index:'zwzcq', label:'最晚装船期'}],
			url : "<c:url value='/pub/widget/findLc'/>"
		}, {
			callback : function(rows) {
				if(rows){
					$("input[name=lcbh]").val(rows.lcbh);
					$("#form-submit [name=khbm]").val(rows.khbm);
				}else{
					$("input[name=lcbh]").val("");
					$("#form-submit [name=khbm]").val("");
				}
			}
		});
	}
	//取付款方式
	function getFktj(){
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
	//是否按付款条件拆分价格事件绑定sfAfktjcfjg
	function bindSfAfktjcfjgEvent(){
		$("#form-submit [name='sfAfktjcfjg']").on('change', function(){
			if($(this).val() == 0){
			    $('#form-submit [name=cfbl1]').val("");
				$('#form-submit [name=cfbl2]').val("");
				$('#form-submit [name=cfbl1]').prop('disabled','disaled').rules("remove", "required");
				$("#form-submit [name=cfbl1]").closest('.input-group').removeClass('has-error');
				$('#form-submit [name=fph2]').val("");
				$('#form-submit [name=fph2]').prop('disabled','disaled').rules("remove", "required");
		    }else{
			    $('#form-submit [name=cfbl1]').removeProp("disabled").removeAttr('disabled').rules("add", {required: true});
			    $('#form-submit [name=fph2]').removeProp("disabled").removeAttr('disabled').rules("add", {required: true});
		    }
	    });
		$('#form-submit [name=cfbl1]').on('blur', function(){
			var bl1 = $('#form-submit [name=cfbl1]').val();
			if(Number(bl1) > 0){
				$('#form-submit [name=cfbl2]').val(100 - Number(bl1));
			}
		});
		
	}
	//开票方式绑定事件
	function bindKpfsEvent(){
		$('#form-submit [name=kpfs]').on('change',function(e){
			if($(this).val() == "2"){
				$("#btn-materialSelect").removeAttr("disabled").removeProp("disabled");
				$(grid_fpxx_selector).showCol('serino');
				$(grid_fpxx_selector).showCol('chdh');
				$(grid_fpxx_selector).showCol('gx');
				$(grid_fpxx_selector).showCol('gh');
				$(grid_fpxx_selector).showCol('fth');
				$(grid_fpxx_selector).showCol('kbh');
				$(grid_fpxx_selector).showCol('xh');
				$(grid_fpxx_selector).showCol('xs');
				$(grid_fpxx_selector).showCol('jixing');
				$(grid_fpxx_selector).showCol('wlbh');
				$(grid_fpxx_selector).showCol('khlh');
				//$(grid_fpxx_selector).showCol('wlmsYw');
				$(grid_fpxx_selector).showCol('wlmxKhyy');
				$(grid_fpxx_selector).showCol('moq');
				$(grid_fpxx_selector).showCol('mxsl');
				$(grid_fpxx_selector).showCol('dhsl');
				$(grid_fpxx_selector).showCol('mfsl');
				$(grid_fpxx_selector).showCol('dhje');
				$(grid_fpxx_selector).showCol('mfje');
				$(grid_fpxx_selector).showCol('dgzl');
				$(grid_fpxx_selector).showCol('djzmx');
				$(grid_fpxx_selector).showCol('dmzmx');
				$(grid_fpxx_selector).showCol('zjz');
				$(grid_fpxx_selector).showCol('zmz');
				$(grid_fpxx_selector).showCol('zxC');
				$(grid_fpxx_selector).showCol('zxK');
				$(grid_fpxx_selector).showCol('zxG');
				$(grid_fpxx_selector).showCol('mkbmz');
				$(grid_fpxx_selector).showCol('kbC');
				$(grid_fpxx_selector).showCol('kbK');
				$(grid_fpxx_selector).showCol('kbG');
				$(grid_fpxx_selector).showCol('kbtj');
				$(grid_fpxx_selector).showCol('gysdm');
				$(grid_fpxx_selector).showCol('gysmc');
				$(grid_fpxx_selector).showCol('gysdz');
				$(grid_fpxx_selector).showCol('hgbm');
				$(grid_fpxx_selector).showCol('ycgj');
				$(grid_fpxx_selector).hideCol('zsl');
				$(grid_fpxx_selector).hideCol('zje');
			}else{
				$("#btn-materialSelect").prop("disabled","disabled");
				$(grid_fpxx_selector).hideCol('serino');
				$(grid_fpxx_selector).hideCol('chdh');
				$(grid_fpxx_selector).hideCol('gx');
				$(grid_fpxx_selector).hideCol('gh');
				$(grid_fpxx_selector).hideCol('fth');
				$(grid_fpxx_selector).hideCol('kbh');
				$(grid_fpxx_selector).hideCol('xh');
				$(grid_fpxx_selector).hideCol('xs');
				$(grid_fpxx_selector).hideCol('jixing');
				$(grid_fpxx_selector).hideCol('wlbh');
				$(grid_fpxx_selector).hideCol('khlh');
				//$(grid_fpxx_selector).hideCol('wlmsYw');
				$(grid_fpxx_selector).hideCol('wlmxKhyy');
				$(grid_fpxx_selector).hideCol('moq');
				$(grid_fpxx_selector).hideCol('mxsl');
				$(grid_fpxx_selector).hideCol('dhsl');
				$(grid_fpxx_selector).hideCol('mfsl');
				$(grid_fpxx_selector).hideCol('dhje');
				$(grid_fpxx_selector).hideCol('mfje');
				$(grid_fpxx_selector).hideCol('dgzl');
				$(grid_fpxx_selector).hideCol('djzmx');
				$(grid_fpxx_selector).hideCol('dmzmx');
				$(grid_fpxx_selector).hideCol('zjz');
				$(grid_fpxx_selector).hideCol('zmz');
				$(grid_fpxx_selector).hideCol('zxC');
				$(grid_fpxx_selector).hideCol('zxK');
				$(grid_fpxx_selector).hideCol('zxG');
				$(grid_fpxx_selector).hideCol('mkbmz');
				$(grid_fpxx_selector).hideCol('kbC');
				$(grid_fpxx_selector).hideCol('kbK');
				$(grid_fpxx_selector).hideCol('kbG');
				$(grid_fpxx_selector).hideCol('kbtj');
				$(grid_fpxx_selector).hideCol('gysdm');
				$(grid_fpxx_selector).hideCol('gysmc');
				$(grid_fpxx_selector).hideCol('gysdz');
				$(grid_fpxx_selector).hideCol('hgbm');
				$(grid_fpxx_selector).hideCol('ycgj');
				$(grid_fpxx_selector).showCol('zsl');
				$(grid_fpxx_selector).showCol('zje');
			}
		});
	}
	//海关商品描述绑定事件
	function bindHgspmsEvent(){
		$('#form-submit [name=hgspms]').on('change',function(e){
			if(e.val != ""){
				$('#form-submit [name=hgspbm]').val(e.val);
			}else{
				$('#form-submit [name=hgspbm]').val("");
			}
		});
	}
	// 订单选择
	function orderSelect(){
		$("#btn-orderSelect").click(function(){
			if($("#form-submit [name=kpfs]").val() == ""){
				return;
			}
			var width = 900;
			var height = 500;
			var left = (window.screen.width-width)/2;
			var top = (window.screen.height-height)/2;
			var pageUrl = "<c:url value='/invoice/invoice/sapOrderlist'/>?id="+$("#form-submit [name=id]").val();
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				var data = window.showModalDialog(pageUrl,null,dialogArgs);
				if(data){
					//初始订单明细数据
					initOrderData(data);
				}
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
				var opener = window.open(pageUrl,null,dialogArgs);
				opener.openerCallBack = function(data){
					initOrderData(data);
				}
			}
		});
	}
	//初始化订单出货明细信息
	function initOrderData(data){
		var chdhs = "";
		var ddids = "";
		for(var i=0; i<data.length; i++){
			ddids += data[i].ddid;
			chdhs += data[i].chdh;
			if(i != data.length-1){
				chdhs += ",";
				ddids += ",";
			}
		}
		$.bindAjax({
			url : "<c:url value='/invoice/invoice/searchMain'/>",
			data : {
				id : $("#form-submit [name=id]").val(),
				kpfs : $("#form-submit [name=kpfs]").val(),
				chdhs : chdhs,
				ddids : ddids,
				xdwlmsyy : $("#form-submit [name=xdwlmsyy]").val()
			},
			action : "search"
		},function(response){
			$("#form-submit [name=xsyid]").val(response.xsyid);
			$("#form-submit [name=xsymc]").val(response.xsymc);
			$("#form-submit [name=ywz]").val(response.ywz);
			$("#form-submit [name=ywzmc]").val(response.ywzmc);
			$("#form-submit [name=xszz]").val(response.xszz);
			$("#form-submit [name=xszzmc]").val(response.xszzmc);
	 		$("#form-submit [name=gsbm]").val(response.gsbm);
	 		$("#form-submit [name=gsmc]").val(response.gsmc);
	 		$("#form-submit [name=gsdz]").val(response.gsdz);
	 		$("#form-submit [name=gslxdh]").val(response.gslxdh);
	 		$("#form-submit [name=khbm]").val(response.khbm);
	 		$("#form-submit [name=khmc]").val(response.khmc);
	 		$("#form-submit [name=khdh]").val(response.khdh);
	 		$("#form-submit [name=khdz]").val(response.khdz);
	 		$("#form-submit [name=shfmc]").val(response.shfmc);
	 		$("#form-submit [name=shfdz]").val(response.shfdz);
	 		$("#form-submit [name=shfdh]").val(response.shfdh);
	 		//$("#form-submit [name=cylx]").select2("val",response.cylx).trigger("change");
	 		$("#form-submit [name=bz]").select2("val",response.bz).trigger("change");
	 		$("#form-submit [name=fktj]").select2("val",response.fktj).trigger("change");
	 		$("#form-submit [name=mytk]").select2("val",response.mytk).trigger("change");
	 		//$("#form-submit [name=qyg]").select2("val",response.qyg).trigger("change");
	 	    //$("#form-submit [name=qyg]").val(response.qyg);
	 		//$("#form-submit [name=xhg]").val(response.xhg);
	 		$("#form-submit [name=mdg]").val(response.mdg);
	 		$("#form-submit [name=cm]").val(response.cm);
			$("#form-submit [name=hc]").val(response.hc);
			$("#form-submit [name=id]").val(response.id);
			$("#form-submit [name=fprq]").val(response.fprq);
			$("#form-submit [name=qyrq]").val(response.qyrq);
			$("#form-submit [name=yjdgq]").val(response.yjdgq);
			if(response.xdLc == null){
				$("#form-submit [name=lcbh]").val("");
				$('#form-submit [name=lcbh]').attr('disabled','disabled');
			}else{
				$('#form-submit [name=lcbh]').removeAttr('disabled');
			}
			// 加载发票明细
			var postData = {id : $("#form-submit [name=id]").val(),
					xdwlmsyy : $("#form-submit [name=xdwlmsyy]").val()};
			setTimeout(function(){
// 				$(grid_fpxx_selector).setGridParam({postData: postData,
// 					url:"<c:url value='/invoice/invoice/searchItem'/>"}).trigger("reloadGrid");
				$.bindAjax({
					url : "<c:url value='/invoice/invoice/searchItem'/>",
					data : postData,
					action : "search"
				},function(response) {	
					$(grid_fpxx_selector).setGridParam({data: response.items}).trigger('reloadGrid');
				});
			},500);
			// 加载箱单明细
			setTimeout(function(){
// 				$(grid_xdxx_selector).setGridParam({postData: postData,
// 					url:"<c:url value='/invoice/invoice/searchPacking'/>"}).trigger("reloadGrid");
				$.bindAjax({
					url : "<c:url value='/invoice/invoice/searchPacking'/>",
					data : postData,
					action : "search"
				},function(response) {	
					$(grid_xdxx_selector).setGridParam({data: response.items}).trigger('reloadGrid');
				});
			},1000);
			// 加载其他费用明细
			setTimeout(function(){
// 				$(grid_qtfy_selector).setGridParam({postData: postData,
// 					url:"<c:url value='/invoice/invoice/searchOther'/>"}).trigger("reloadGrid");
				$.bindAjax({
					url : "<c:url value='/invoice/invoice/searchOther'/>",
					data : postData,
					action : "search"
				},function(response) {	
					$(grid_qtfy_selector).setGridParam({data: response.items}).trigger('reloadGrid');
				});
			},500);
		});
		$("#form-submit [name=kpfs]").prop("disabled","disabled");
	}
	// 物料信息选择
	function materialSelect(){
		$("#btn-materialSelect").click(function(){
			var width = 900;
			var height = 650;
			var left = (window.screen.width-width)/2;
			var top = (window.screen.height-height)/2;
			var id = $("#form-submit [name=id]").val();
			var pageUrl = "<c:url value='/invoice/invoice/sapMateriallist'/>?id="+id;
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				window.showModalDialog(pageUrl,null,dialogArgs);
				setTimeout(function(){$(grid_fpxx_selector).trigger("reloadGrid");}, 500);
				setTimeout(function(){$(grid_xdxx_selector).trigger("reloadGrid");}, 1000);
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
				window.open(pageUrl,null,dialogArgs);
				setTimeout(function(){$(grid_fpxx_selector).trigger("reloadGrid");}, 500);
				setTimeout(function(){$(grid_xdxx_selector).trigger("reloadGrid");}, 1000);
			}
		});
	}
	//初始化发票明细信息grid
	function bindGridItem(){
		$(grid_fpxx_selector).bindTable({
			caption: "",
			pager: pager_fpxx_selector,
			gridParent: "#grid-parent-fpxx",
			datatype: "local",
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'serino', index:'serino', label:'行号', hidden: true, width:60},
				{name:'chdh', index:'chdh', label:'出货通知书', hidden: true, width:90},
				{name:'ddid', index:'ddid', label:'Marks&No.', width:90},
				{name:'gx', index:'gx', label:'Container Type', hidden: true, width:100},
				{name:'gh', index:'gh', label:'Container No.', hidden: true, width:100},
				{name:'fth', index:'fth', label:'Seal No.', hidden: true, width:80},
				{name:'kbh', index:'kbh', label:'Plts No.', hidden: true, width:80},
				{name:'xh', index:'xh', label:'CTN No.', hidden: true, width:80},
				{name:'xs', index:'xs', label:'CTNS', hidden: true, width:60,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'jixing', index:'jixing', label:'Model No.', width:80},
				{name:'spms', index:'spms', label:'Description of Goods', width:120},
				{name:'dw', index:'dw', label:'Unit', width:80},
				{name:'dj', index:'dj', label:'Unit Price', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zsl', index:'zsl', label:'Total QTY', width:80},
				{name:'zje', index:'zje', label:'Amount', width:80},
				{name:'khhgbm', index:'khhgbm', label:'HS.CODE', width:80},
				{name:'ycgj', index:'ycgj', label:'Origin', width:80},
				{name:'wlbh', index:'wlbh', label:'Part No.', width:100},
				{name:'wlmsYw', index:'wlmsYw', label:'English Description', width:150},
				{name:'wlmsKhyy', index:'wlmsKhyy', label:'Other Language Description', width:150},
				{name:'wlmsZw', index:'wlmsZw', label:'Chinese Description', width:50},
				{name:'khlh', index:'khlh', label:'Client Part No.', hidden: true, width:100},
				{name:'moq', index:'moq', label:'MOQ', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'mxsl', index:'mxsl', hidden: true, label:'QTY PER CARTON', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dhsl', index:'dhsl', hidden: true, label:'Order QTY', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'mfsl', index:'mfsl', hidden: true, label:'FOC QTY', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dhje', index:'dhje', label:'Order Amount', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'mfje', index:'mfje', label:'FOC Amount', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dgzl', index:'dgzl', label:'Weight(kg)per unit', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'djzmx', index:'djzmx', label:'NET/CARTON(kg)', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dmzmx', index:'dmzmx', label:'GROSS/CARTON（kg)', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zjz', index:'zjz', label:'TTL NET(kg)', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zmz', index:'zmz', label:'TTL GROSS（kg)', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zxC', index:'zxC', label:'L(CARTON)', hidden: true, width:60,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zxK', index:'zxK', label:'W(CARTON)', hidden: true, width:60,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zxG', index:'zxG', label:'H(CARTON)', hidden: true, width:60,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'mkbmz', index:'mkbmz', label:'Incl. Plt (kg)', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'kbC', index:'kbC', label:'Pallet Dim (L)cm', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'kbK', index:'kbK', label:'Pallet Dim (W)cm', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'kbG', index:'kbG', label:'Pallet Dim (H)cm', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'kbtj', index:'kbtj', label:'TTL CBM', hidden: true, width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'gysdm', index:'gysdm', label:'Supplier Code', hidden: true, width:80},
				{name:'gysmc', index:'gysmc', label:'Supplier Name', hidden: true, width:150},
				{name:'gysdz', index:'gysdz', label:'Supplier Address', hidden: true, width:150},
				{name:'pono', index:'pono', label:'P.O.NO.', hidden: true, width:50},
				{name:'potype', index:'potype', label:'PO-TYPE', hidden: true, width:50}
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
	}
	//初始化箱单信息grid
	function bindGridXdxx(){
		$(grid_xdxx_selector).bindTable({
			caption: "",
			pager: pager_xdxx_selector,
			gridParent: "#grid-parent-xdxx",
			datatype: "local",
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'serino', index:'serino', label:'行号', hidden: true, width:60},
				{name:'chdh', index:'chdh', label:'出货通知书', width:90},
				{name:'ddid', index:'ddid', label:'Job No.', width:90},
				{name:'gx', index:'gx', label:'Container Type', width:100},
				{name:'gh', index:'gh', label:'Container No.', width:100},
				{name:'fth', index:'fth', label:'Seal No.', width:80},
				{name:'kbh', index:'kbh', label:'Plts No.', width:80},
				{name:'xh', index:'xh', label:'CTN No.', width:80},
				{name:'xs', index:'xs', label:'CTNS', width:60,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'jixing', index:'jixing', label:'Model No.', width:80},
				{name:'spms', index:'spms', label:'Description of Goods', width:120},
				{name:'wlbh', index:'wlbh', label:'Part No.', width:100},
				{name:'khlh', index:'khlh', label:'Client Part No.', width:100},
				{name:'wlmsYw', index:'wlmsYw', label:'English Description', width:150},
				{name:'wlmsKhyy', index:'wlmsKhyy', label:'Other Language Description', width:150},
				{name:'moq', index:'moq', label:'MOQ', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'mxsl', index:'mxsl', label:'QTY PER CARTON', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
			    {name:'zsl', index:'zsl', label:'Total QTY', width:80,
						align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dhsl', index:'dhsl', label:'Order QTY', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'mfsl', index:'mfsl', label:'FOC QTY', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dw', index:'dw', label:'Unit', width:80},
				{name:'dj', index:'dj', label:'Unit Price', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dhje', index:'dhje', label:'Order Amount', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'mfje', index:'mfje', label:'FOC Amount', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dgzl', index:'dgzl', label:'Weight(kg)per unit', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'djzmx', index:'djzmx', label:'NET/CARTON(kg)', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'dmzmx', index:'dmzmx', label:'GROSS/CARTON（kg)', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zjz', index:'zjz', label:'TTL NET(kg)', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zmz', index:'zmz', label:'TTL GROSS（kg)', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zxC', index:'zxC', label:'L(CARTON)', width:60,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zxK', index:'zxK', label:'W(CARTON)', width:60,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zxG', index:'zxG', label:'H(CARTON)', width:60,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'mkbmz', index:'mkbmz', label:'Incl. Plt (kg)', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'kbC', index:'kbC', label:'Pallet Dim (L)cm', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'kbK', index:'kbK', label:'Pallet Dim (W)cm', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'kbG', index:'kbG', label:'Pallet Dim (H)cm', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'kbtj', index:'kbtj', label:'TTL CBM', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'gysdm', index:'gysdm', label:'Supplier Code', width:80},
				{name:'gysmc', index:'gysmc', label:'Supplier Name', width:150},
				{name:'gysdz', index:'gysdz', label:'Supplier Address', width:150},
				{name:'khhgbm', index:'khhgbm', label:'HS.CODE', width:80},
				{name:'ycgj', index:'ycgj', label:'Origin', width:80},
				{name:'zje', index:'zje', label:'Amount', hidden: true, width:80},
				{name:'pono', index:'pono', label:'P.O.NO.', hidden: true, width:50},
				{name:'potype', index:'potype', label:'PO-TYPE', hidden: true, width:50},
				{name:'wlmsZw', index:'wlmsZw', label:'Chinese Description', hidden: true, width:50}
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
	}
	//初始化其他费用grid
	function bindGridQtfy(){
		$(grid_qtfy_selector).bindTable({
			caption: "",
			pager: pager_qtfy_selector,
			//去掉编辑表分页按钮
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			gridParent: "#grid-parent-qtfy",
			footerrow:true,
			datatype: "local",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'chdh', index:'chdh', label:'出货通知书', hidden: true, width:60, editable:false},
				{name:'qtxm', index:'qtxm', label:'类型', width:80, editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('QTFYLX')}"}},
				{name:'ms', index:'ms', label:'描述', width:200},
				{name:'sl', index:'sl', label:'数量',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','} ,
						editrules:{integer:true} ,editoptions:{dataInit: initSl}},
				{name:'dj', index:'dj', label:'单价',align:'right', width:50,formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','},
							editoptions:{dataInit: initDj}},
				{name:'je', index:'je', label:'金额', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','},
								editoptions:{readonly:true}}
			],
			gridComplete: function(){
	            sumGrid();
		   	},
			editTable:true,
			editComplete: function(lastEdit, rowData){
				sumGrid();
			}
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			complete:isEdit
		});
	}
	// 计算合计行
	function sumGrid(){
		var sl;
		var je;
		$(grid_qtfy_selector).footerData("set",{"ms":"合计"}); //合计
		var rowNum = $(grid_qtfy_selector).jqGrid('getGridParam','records');
		if(rowNum >0 ){
			sl = $(grid_qtfy_selector).getCol("sl",false,"sum");
			je = $(grid_qtfy_selector).getCol("je",false,"sum"); 
		}
		$(grid_qtfy_selector).footerData("set",{"sl":sl, "je":je}); //将合计值显示出来
	}
	// 初始化编辑表数量*单价=金额
	function initSl(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).val();
			var dj = $(elem).closest("tr.jqgrow").find("[name='dj']").val();
			var je = "";
			if(sl != "" && dj != ""){
				je = sl * dj;
			}
			$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(2));
		});
	}
	function initDj(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).closest("tr.jqgrow").find("[name='sl']").val();
			var dj = $(elem).val();
			var je = "";
			if(sl != "" && dj != ""){
				je = sl * dj;
			}
			$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(2));
		});
	}
	//初始化页面数据
	function bindFormData(id){	
		//view or edit
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/invoice/invoice/searchMain'/>",
				data : {
					id : id,
					kpfs : $("#form-submit [name=kpfs]").val(),
					chdhs : "",
					ddids : "",
					xdwlmsyy : $("#form-submit [name=xdwlmsyy]").val()
				},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				// 加载发票明细
				var postData = {id : id, xdwlmsyy : $("#form-submit [name=xdwlmsyy]").val()};
				setTimeout(function(){
// 					$(grid_fpxx_selector).setGridParam({postData: postData,
// 						url:"<c:url value='/invoice/invoice/searchItem'/>"}).trigger("reloadGrid");
					$.bindAjax({
						url : "<c:url value='/invoice/invoice/searchItem'/>",
						data : postData,
						action : "search"
					},function(response) {
						$(grid_fpxx_selector).setGridParam({data: response.items}).trigger('reloadGrid');
					});
				},500);
				// 加载箱单明细
				setTimeout(function(){
// 					$(grid_xdxx_selector).setGridParam({postData: postData,
// 						url:"<c:url value='/invoice/invoice/searchPacking'/>"}).trigger("reloadGrid");
					$.bindAjax({
						url : "<c:url value='/invoice/invoice/searchPacking'/>",
						data : postData,
						action : "search"
					},function(response) {	
						$(grid_xdxx_selector).setGridParam({data: response.items}).trigger('reloadGrid');
					});
				},1000);
				// 加载其他费用明细
				setTimeout(function(){
// 					$(grid_qtfy_selector).setGridParam({postData: postData,
// 						url:"<c:url value='/invoice/invoice/searchOther'/>"}).trigger("reloadGrid");
					$.bindAjax({
						url : "<c:url value='/invoice/invoice/searchOther'/>",
						data : postData,
						action : "search"
					},function(response) {	
						$(grid_qtfy_selector).setGridParam({data: response.items}).trigger('reloadGrid');
					});
				},500);
				$("#form-submit [name=taskId]").val(taskId);
				$("#form-submit [name=oper]").val("edit");//编辑
			});
		}else{
			//初始化页面参数
			$("#form-submit [name=oper]").val("add");//权限:add
			$("#form-submit [name=zt]").val("1");//PI状态:草稿
			$('#form-submit [name=cfbl1]').prop("disabled","disabled");//拆分比例1
			$('#form-submit [name=fplx]').select2("val","1");//发票类型为商业发票
			$('#form-submit [name=kpfs]').select2("val","2");//开票方式为明细开票
			$("#form-submit [name=kpfs]").removeProp("disabled").removeAttr("disabled");
			$('#form-submit [name=cylx]').select2("val","1");//出运方式为by sea
		}
	}
	//验证
	$('#form-submit').validate({
		onfocusout: false,
		onkeyup: false,
		onclick: false,
		focusInvalid: false,
		focusCleanup: false,
		ignore: 'input[type=hidden]',
		rules: {
			fph : 'required',
			fplx : 'required',
			kpfs : 'required',
			cfbl1 : 'number',
			//lcbh : 'required',
			fprq : 'required',
			//tdh : 'required',
			qyrq : 'required',
			yjdgq : 'required',
			bz    : 'required',
			mytk: 'required',
			sjfpzje:{required:true, number:true}
			
		},
		messages: {
			fph : '发票号不能为空！',
			fplx : '发票类型不能为空！',
			kpfs : '开票方式不能为空！',
			cfbl1 : '拆分比例1必须为数字！',
			//lcbh : 'L/C编号不能为空！',
			fprq : '发票日期不能为空！',
			//tdh : '提单号不能为空！',
			qyrq : '起运日期不能为空！',
			yjdgq : '预计到港日期不能为空！',
			bz    : '币种不能为空！',
			mytk: '贸易条款不能为空！',
			sjpfzje:'实际发票总金额不能为空且必须为数字！'
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
	// 保存
	function save(){
		if(!$('#form-submit').valid()){
			return false;
		}	
		var value = $("input[name='sfAfktjcfjg']:checked").val();
		if(value == 1){
			var fph2 = $('#form-submit [name=fph2]').val();
			if(fph2==""){
				swal("","发票号2不能为空!","warning");
				return false;
			}
		}
		
		var param = $("#form-submit").getFormData();
		//编辑表结束编辑
		var lastEdit = $(grid_qtfy_selector).data('lastEdit');
		if(lastEdit){
			$(grid_qtfy_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var qtfyData = $(grid_qtfy_selector).getRowData();
		param.qtList = JSON.stringify(qtfyData);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			 callback:function(){
				$.bindAjax({
					url:"<c:url value='/invoice/invoice/edit'/>",
					data:param,
					action:"save"
				},function(response){
 					var result = JSON.parse(response);
					//$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=fph]").val(result.fph);
					$("#form-submit [name=fph2]").val(result.fph2);
					//$("#form-submit [name=zt]").val(result.zt);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=zje]").val(result.zje);
					$("#form-submit [name=sjfpzje]").val(result.sjfpzje);
					//$('#form-submit [name=token]').val(result.token);
					bindFormData($("#form-submit [name=id]").val());
				}); 
			} 
		});
	}
	//提交
	function submit(){
		if(!$('#form-submit').valid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		//编辑表结束编辑
		var lastEdit = $(grid_qtfy_selector).data('lastEdit');
		if(lastEdit){
			$(grid_qtfy_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var qtfyData = $(grid_qtfy_selector).getRowData();
		param.qtList = JSON.stringify(qtfyData);
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/invoice/invoice/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
		
	}
	//附件提交
	function submitFj(){
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title:"确定要提交附件吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/invoice/invoice/submitFj'/>",
					data:param,
					action:"save"
				},function(response){
					location.href = "<c:url value='/invoice/invoice'/>";
				}); 
			}
		});
	}
	/**************************************************function结束区域************************************************/
</script>
</html>