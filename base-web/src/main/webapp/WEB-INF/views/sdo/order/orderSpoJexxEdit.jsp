<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>   
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
					<input type="hidden" name="id"/><!-- 订单id -->
					<input type="hidden" name="oper"/>
					<input type="hidden" name="sjc"/>
					<input type="hidden" name="sfBg"/>
					<input type="hidden" name="tssapzt"/>
					<!-- <input type="hidden" name="bbh"/> -->
					<input type="hidden" name="taskId" />
					<input type="hidden" name="token" value="${token}" />
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
							<input type="text" name="ddid" class="form-control" readonly/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单类别&nbsp;&nbsp;</label>
							<select id="ddlb" role="select" name="ddlb" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('DDLB_BS')}
							</select>
						</div>
					</div>
					
					
					<div class="col-xs-6 col-sm-3">
						<button id="btn-piSelect" type="button" class="btn btn-purple btn-sm" >
							<i class="fa fa-plus icon-on-right bigger-110"></i>
							PI选择
						</button>
					</div>
					<div class="col-xs-6 col-sm-3">
						<button id="btn-save" type="button" class="btn btn-success btn-sm">
							<i class="icon-save icon-on-right bigger-110"></i>
							保存
						</button>
						&nbsp;
						<button id="btn-submit" type="button" class="btn btn-info btn-sm">
							<i class="icon-ok icon-on-right bigger-110"></i>
							提交
						</button>
						&nbsp;
						<button id="btn-back" type="button" class="btn btn-sm" >
							<i class="icon-undo icon-on-right bigger-110"></i>
							返回
						</button>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">原订单号&nbsp;&nbsp;</label>
							<input type="text" name="yddid" class="form-control skydisabled" disabled="disabled" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">是否传制造SAP&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfCzz" value="1">是
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio"  name="sfCzz" value="0" checked="checked">否
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3 changeJeSelect" style="display:none">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">更改物料金额：&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" name="wlje" class="skyradio" value="1">物料
								</label>
								<label class="radio-inline">
									<input type="radio" name="wlje" checked="checked" class="skyradio" value="0">金额
								</label>
							</div>
						</div>
					</div>
				</div>
				
				<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
				    <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
							<select role="select" name="scjd" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('SCJD')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单类型&nbsp;&nbsp;</label>
							<select role="select" name="ddlx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('DDLX')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">公司&nbsp;&nbsp;</label>
							<select role="select" name="gsbm" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadCompanyOption('0')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
							<input type="hidden" name="xsyid" class="form-control"/>
							<input type="text" name="xsymc" onfocus="this.blur()"
								class="form-control parent-node skydisabled" disabled="disabled" style="cursor: pointer!important;" />
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
				    <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
							<input type="hidden" name="ywz" class="form-control"/>
							<input type="text" name="ywzmc" class="form-control" readonly/>
						</div>
					</div>
				    <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售组织&nbsp;&nbsp;</label>
							<input type="hidden" name="xszz" class="form-control"/>
							<input type="text" name="xszzmc" class="form-control" readonly/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
							<input type="text" name="zdrmc" class="form-control" readonly/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">制单日期&nbsp;&nbsp;</label>
							<input type="text" name="zdsj" class="form-control date-picker skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
				    <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单状态&nbsp;&nbsp;</label>
							<select role="select" name="zt" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('DJZT')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">是否免费&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfMf" value="1">是
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfMf" value="0" checked="checked">否
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">责任划分&nbsp;&nbsp;</label>
							<select role="select" name="zrhf" size="1" class="form-control skyselect">
								${fns:loadDictOption('ZRHF')}
							</select>
						</div>
					</div>
					
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客诉编号&nbsp;&nbsp;</label>
							<input type="text" name="ksbh" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">版本号&nbsp;&nbsp;</label>
							<input type="text" name="bbh" class="form-control" readonly/>
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">基本信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
				   <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
							<input type="text" name="khbm" onfocus="this.blur()" class="form-control skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
				   <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
							<input type="text" name="khmc" class="form-control" readonly/>
						</div>
					</div>
					
				   <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">付款条件&nbsp;&nbsp;</label>
							<input type="hidden" name="fktj" />
							<input type="text" name="fktjmc" onfocus="this.blur()" class="form-control parent-node skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					
				
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">交货日期&nbsp;&nbsp;</label>
							<input type="text" name="jhrq" class="form-control date-picker"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">业务类型&nbsp;&nbsp;</label>
							<select role="select" name="ywlx" size="1" class="form-control skyselect">
								${fns:loadDictOption('YWLX')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">出运类型&nbsp;&nbsp;</label>
							<select role="select" name="cylx" size="1" class="form-control skyselect">
								${fns:loadDictOption('CYLX')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">币种&nbsp;&nbsp;</label>
							<select role="select" name="bz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('BZ')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销往国家&nbsp;&nbsp;</label>
							<select role="select" name="xwgj" size="1" class="form-control skyselect">
								${fns:loadCountryOption('0')}
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">国际贸易条款&nbsp;&nbsp;</label>
							<select role="select" name="gjmytk" size="1" class="form-control skyselect">
								${fns:loadDictOption('PIGJMYTK')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="gjmytkbz" placeholder="国际贸易条款备注" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">装运/起运港&nbsp;&nbsp;</label>
							<select role="select" name="zyg" size="1" class="form-control skyselect">
								${fns:loadDictOption('QYG')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">费用承担部门&nbsp;&nbsp;</label>
							<input type="hidden" name="fycdbm" />
							<input type="text" name="fycdbmmc" onfocus="this.blur()" class="form-control parent-node"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-sm-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">免费补料原因&nbsp;&nbsp;</label>
							<textarea name="mfblyy" class="autosize-transition form-control"></textarea>
						</div>
					</div>
					<div class="col-sm-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">备注&nbsp;&nbsp;</label>
							<textarea name="bzxx" class="autosize-transition form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-sm-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">变更信息备注&nbsp;&nbsp;</label>
							<textarea name="bgbz" class="autosize-transition form-control"></textarea>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm" style="width:20px;">
							<label class="input-group-addon">附件&nbsp;&nbsp;</label>
							<div class="form-control" style="text-align:left;">
								<input id="fj" type="file" class="form-control">
							</div>
							<input type="hidden" name="fj" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div id="fjxx">
							<ul class="list-unstyled spaced"></ul>
						</div>
						<div id="multiFileQueue"> </div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">物料清单</h5>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-6">
						<button id="btn-download" type="button" class="btn btn-sm">
							<i class="icon-download-alt icon-on-right bigger-110"></i>导出模板
						</button>
						<button id="btn-import" type="button" class="btn btn-sm">
							<i class="icon-upload-alt icon-on-right bigger-110"></i>导入数据
						</button>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div id="grid-parent-wlxx">
							<table id="grid-table-wlxx"></table>
							<div id="grid-pager-wlxx"></div>
						</div>
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
			</form>
			
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
</span>
</body>
<script type="text/javascript">
	var pilx_list = new Array("1","4","7");
	var grid_wlxx_selector = "#grid-table-wlxx";
	var pager_wlxx_selector = "#grid-pager-wlxx";
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	<shiro:hasPermission name="order:orderSpo:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($){
		$(".skyselect").select2();
		$(".date-picker").bindDate();
		// 客户选择
		$("#form-submit [name=khbm]").click(function(){
			bindKhbm();
		});
		$("#form-submit [name=fktjmc]").click(function(){
			bindFktj();
		});
		// 费用承担部门选择
		bindFybmSelect();
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
		// PI选择
		$("#btn-piSelect").click(function(){
			var width = 1366;
			var height = 768;
			var left = 0;
			var top = 0;
			var ddid = $("#form-submit [name=ddid]").val();
			var pageUrl = "<c:url value='/order/orderReferPi/spo'/>"+"?ddid=" + ddid;
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
		// 销售员选择
		bindXsySelect();
		// 物料信息编辑表
		bindGridWlxx();
		// 初始化表单信息
		initFormData(id);
		//币种change事件
		changeBzEvent();
		// 表单验证
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: 'input[type=hidden]',
			rules: {
				gsbm: 'required',
				ddlb: 'required',
				ywlx: 'required',
				khbm: 'required',
				xsymc: 'required',
				jhrq: 'required',
				cylx: 'required',
				bz: 'required',
				xwgj: 'required',
				gjmytk: 'required',
				gjmytkbz: 'required',
				//zyg: 'required',
				scjd: 'required',
				
			},
			messages: {
				gsbm: '公司不能为空',
				ddlb: '订单类别不能为空',
				ywlx: '业务类型不能为空',
				khbm: '客户编码不能为空',
				xsymc: '销售员不能为空',
				jhrq: '交货日期不能为空',
				cylx: '出运类型不能为空',
				bz: '币种不能为空',
				xwgj: '销往国家不能为空',
				gjmytk: '国际贸易条款不能为空',
				gjmytkbz: '国际贸易条款备注不能为空',
				//zyg: '装运/起运港 不能为空',
				scjd : '生产基地未填写'
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
		$("#btn-save").click(function(){
			save();
	    });
		// 提交
		$("#btn-submit").click(function(){
			submit();
	    });
		// 返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		// 订单类别change事件
		$("#form-submit [name=ddlb]").on("change", function(e) {
			//订单类别改变时，清楚客户和付款条件信息
	    	$("input[name=khbm]").val("");
			$("input[name=khmc]").val("");
			$("input[name=fktj]").val("");
			$("input[name=fktjmc]").val("");
			//收费备损（营销客户收费备损、分公司购买备损、收费市场物料、备损组大客户备损、工装物料）
			if($(this).val() == "1" || $(this).val() == "4" || $(this).val() == "7" || $(this).val() == "13" || $(this).val() == "14"){
				// 选PI
				$("#btn-piSelect").removeProp("disabled").removeAttr("disabled");
				$("#form-submit [name=sfMf][value=0]").prop("checked","checked");
				$("#form-submit [name=zrhf]").prop("disabled","disabled");
				$("#form-submit [name=fycdbmmc]").prop("disabled","disabled");
				$("#form-submit [name=ksbh]").prop("disabled","disabled");
				$("#form-submit [name=fktjmc]").prop("disabled","disabled");
				// 禁用编辑表按钮和列编辑
				//$("#add_grid-table-wlxx").hide();
				$("#btn-download").prop("disabled","disabled");
				$("#btn-import").prop("disabled","disabled");
				
				/* $(grid_wlxx_selector).setColProp("wllx",{editoptions:{disabled:true}});
				$(grid_wlxx_selector).setColProp("wlbh",{editoptions:{disabled:true}});
				$(grid_wlxx_selector).setColProp("wlms",{editoptions:{disabled:true}});
				$(grid_wlxx_selector).setColProp("bz",{editoptions:{disabled:true}});
				$(grid_wlxx_selector).setColProp("dj",{editoptions:{disabled:true}});
				$(grid_wlxx_selector).setColProp("ckddh",{editoptions:{disabled:true}}); */

			} else {
				// 手动录入
				$("#btn-piSelect").prop("disabled","disabled");
				$("#form-submit [name=sfMf][value=1]").prop("checked","checked");
				$("#form-submit [name=zrhf]").removeProp("disabled").removeAttr("disabled");
				$("#form-submit [name=fycdbmmc]").removeProp("disabled").removeAttr("disabled");
				$("#form-submit [name=ksbh]").removeProp("disabled").removeAttr("disabled");
				//免费备损时，可以选择付款条件
				$("#form-submit [name=fktjmc]").removeProp("disabled").removeAttr("disabled");
				// 启用编辑表按钮和列编辑
				$("#add_grid-table-wlxx").show();
				$("#btn-download").removeProp("disabled").removeAttr("disabled");
				$("#btn-import").removeProp("disabled").removeAttr("disabled");
				
				$(grid_wlxx_selector).setColProp("wllx",{editoptions:{disabled:false}});
				$(grid_wlxx_selector).setColProp("wlbh",{editoptions:{disabled:false}});
				$(grid_wlxx_selector).setColProp("wlms",{editoptions:{disabled:false}});
				$(grid_wlxx_selector).setColProp("bz",{editoptions:{disabled:false}});
				//$(grid_wlxx_selector).setColProp("dj",{editoptions:{disabled:false}});
				$(grid_wlxx_selector).setColProp("ckddh",{editoptions:{disabled:false}});
				
			}
		});
		// 导出按钮
		$("#btn-download").click(function(){
			window.location.href=encodeURI("<%=request.getContextPath()+"/template/orderSpoItem.xlsx"%>");
	    });
		// 导入按钮
		$('#btn-import').click(function(){
			$.importDialog({
				title:"选择文件",
				//data: $('#form-submit').getFormData(),
				url:"<c:url value='/order/orderSpo/importExcel'/>"
			},{
				callback:function(results){
					var rows = eval("(" + results + ")");
					$(grid_wlxx_selector).jqGrid('setGridParam', {
					    datatype : 'local',
					    data : rows.items
					}).trigger("reloadGrid");
				}
			});
		});
	});
	/**************************************************function开始区域************************************************/
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户编码","value":"khbm"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:60},
					  {name:'khmc', index:'khmc', label:'客户名称', width:100},
					  {name:'fktj', index:'fktj', label:'付款条件', width:60},
					  {name:'fktjms', index:'fktjms', label:'付款条件名称', width:100}],
				  url:"<c:url value='/pub/widget/findCustByXsy'/>?xsyid="+$('#form-submit [name=xsyid]').val()
		},{
			callback:function(rows){
				if(rows){
					var ddlb = $("#form-submit [name=ddlb]").val();
					if(ddlb=="1" || ddlb=="4" || ddlb=="7" || ddlb=="13" || ddlb=="14"){
						$("input[name=fktj]").val(rows.fktj);
						$("input[name=fktjmc]").val(rows.fktjms);
					}else { //当订单类别是免费时直接指定付款条件为FREE OF CHARGE
						if(rows.fktj !='9999'){
							swal("","你选择客户的付款条件和该订单类别的付款条件不一致，请检查!",'warning');
							return ;
						}
						$("#form-submit [name=fktjmc]").val("FREE OF CHARGE");
						$("#form-submit [name=fktj]").val("9999");
						$("#form-submit [name=sfMf]").removeAttr('checked');
						$("#form-submit [name=sfMf][value=1]").prop('checked','checked');
					}
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
					$("input[name=fktj]").val("");
					$("input[name=fktjmc]").val("");
				}
			}
		});
	}
	function bindFktj(){
		$.tableDialogPage({
			title:"付款条件选择",
			searchCond:[{"name":"付款条件代码","value":"fktjdm"},
			            {"name":"付款条件描述","value":"fktjms"}],
			colModel:[{name:'fktjdm', index:'fktjdm', label:'付款条件代码', width:60},
					  {name:'fktjms', index:'fktjms', label:'付款条件描述', width:100}],
					  url: "<c:url value='/payment/payTerm/search'/>",
		},{
			callback:function(rows){
				if(rows){
					$("input[name=fktj]").val(rows.fktjdm);
					$("input[name=fktjmc]").val(rows.fktjms);
				}else{
					$("input[name=fktj]").val("");
					$("input[name=fktjmc]").val("");
				}
			}
		});
	}
	//费用承担部门选择
	function bindFybmSelect(){
		$("input[name='fycdbmmc']").bindTreeDialog({
			title:"所属组织",
			url : "<c:url value='/core/organization/loadTree'/>",
			searchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"}
		},{
			callback:function(node){
				if(node){
					$("input[name='fycdbm']").val(node.id);
					$("input[name='fycdbmmc']").val(node.name);
				}else{
					$("input[name='fycdbm']").val("");
					$("input[name='fycdbmmc']").val("");
				}
			}
		});
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
				$("input[name=fktj]").val("");
				$("input[name=fktjmc]").val("");
			}
		});
	}
	
	// 初始化物料信息表格
	function bindGridWlxx(){
		$(grid_wlxx_selector).bindTable({
			caption: "",
			pager: pager_wlxx_selector,
			gridParent: "#grid-parent-wlxx",
			rowList: [1000],
			rowNum:1000,
			footerrow:true,
			datatype:"local",
			colModel: [
						{name:'id', label:'ID', hidden: true, width:60, editable:false},
						{name:'piid', index:'piid', label:'PI号', hidden: true, width:80},
						{name:'piitemid', index:'piitemid', label:'PI明细id', hidden: true, width:80},
						{name:'flag', index:'flag', label:'操作类型', width:80, editable:true, edittype:"select",formatter: "select",
							editoptions:{value:"${fns:loadDictEditOption('CZLX')}", dataInit:initSelect2}},
						{name:'wllx', index:'wllx', label:'物料类型', width:80, editable:true, edittype:"select",formatter: "select",
							editoptions:{value:"${fns:loadDictEditOption('WLLX')}",dataInit: initSelect2},hidden:true},
						{name:'wlbh', index:'wlbh', label:'物料编码', width:60, editoptions : {dataInit : InitWL}},
						{name:'wlms', index:'wlms', label:'物料描述', width:80},
						{name:'bz', index:'bz', label:'币种', hidden: true, width:80},
						{name:'dw', index:'dw', label:'单位', width:80,editoptions:{disabled:true}},
						{name:'sl', index:'sl', label:'数量', width:80, align:'right',
							 formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},editoptions:{dataInit: initSl}},
					    <shiro:hasPermission name="order:orderSpo:price">
					    {name:'dj', index:'dj', label:'单价（含税）', align:'right',
							 formatter:'number',formatoptions:{thousandsSeparator: ',', decimalPlaces: 6},width:80,editoptions:{disabled:true}},
						{name:'je', index:'je', label:'总金额',align:'right',
							 formatter:'number',formatoptions:{thousandsSeparator: ',', decimalPlaces: 6},width:80,editoptions:{disabled:true}},
						</shiro:hasPermission>
						{name:'ckddh', index:'ckddh', label:'参考订单', width:80,editoptions : {dataInit : InitDDH}},
						{name:'jixing', index:'jixing', label:'机型', width:80,editoptions:{disabled:true}},
						{name:'jixin', index:'jixin', label:'机芯', width:80,editoptions:{disabled:true}}
						
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
			del:false,
			complete:isEdit
		});
	}
	// 初始化表单数据
	function initFormData(id){
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=ddlx]").select2("val","2");
			$("#form-submit [name=zt]").select2("val","1");
			$("#form-submit [name=scjd]").select2("val",2110);
			$("#btn-piSelect").prop("disabled","disabled");
			$("#form-submit [name=zrhf]").prop("disabled","disabled");
			$("#form-submit [name=fycdbmmc]").prop("disabled","disabled");
			$("#form-submit [name=fktjmc]").prop("disabled","disabled");
		} else {
			// edit
			$.bindAjax({
				url : "<c:url value='/order/orderSpo/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				// 变更草稿编辑时，客户、币种、付款条件、走货方式、PID、生产基地不允许修改
				if(response.sfBg == 1){
					$("#form-submit [name=scjd]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit [name=khbm]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit [name=bz]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit [name=fktjmc]").prop("disabled","disabled").addClass("skydisabled");
					$('.changeJeSelect').show();//驳回时选择修改金额还是物料
					$("#form-submit [name=wlje][value=0]").prop("checked","checked");//默认修改金额
				}
				// 加载物料明细
				if(response.orderSpoItemList){
					$(grid_wlxx_selector).jqGrid("addRowData", null, response.orderSpoItemList, "last");
				}
				$("#fjxx").html(response.fj);
				$("#form-submit [name=oper]").val("edit");
				$("#form-submit [name=taskId]").val(taskId);
			});
		}
	}
	// 保存
	function save(){
		// 编辑表结束编辑
		var lastEdit = $(grid_wlxx_selector).data('lastEdit');
		if(lastEdit){
			$(grid_wlxx_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var ddlb =  $("#form-submit [name=ddlb]").val();
		//当订单类别为免费备损时，责任划分为必填
		if(ddlb == "2" || ddlb == "3"|| ddlb == "5" || ddlb == "6" || ddlb == "8"|| ddlb == "9"
				|| ddlb == "10"|| ddlb == "11" ||ddlb == "12"){
			var zrhf = $("#form-submit [name=zrhf]").val();
			if(zrhf == null || zrhf == ""){
				swal("", "责任划分不能为空！", "warning");
				return;
			}
		}
		// 表单验证
		if(!$('#form-submit').valid()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
		if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		var wlData = $(grid_wlxx_selector).getRowData();
		param.wlList = JSON.stringify(wlData);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/order/orderSpo/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=ddid]").val(result.ddid);
					$("#form-submit [name=yddid]").val(result.yddid);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
					$("#form-submit [name=token]").val(result.token);
					$(grid_wlxx_selector).jqGrid("clearGridData");
					$(grid_wlxx_selector).jqGrid("addRowData", null, result.orderSpoItemList, "last");
				}); 
			}
		});
	}
	// 提交
	function submit(){
		// 编辑表结束编辑
		var lastEdit = $(grid_wlxx_selector).data('lastEdit');
		if(lastEdit){
			$(grid_wlxx_selector).saveRow(lastEdit, false, 'clientArray');
		}
		// 表单验证
		if(!$('#form-submit').valid()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
		if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		var wlData = $(grid_wlxx_selector).getRowData();
		if(wlData.length == 0){
			swal("", "物料清单数据不能为空！", "warning");
		}else{
			param.wlList = JSON.stringify(wlData);
			$("body").bindSweetAlert({
				title:"确定要提交吗?"
			},{
				callback:function(){
					$.bindAjax({
						url:"<c:url value='/order/orderSpo/submit'/>",
						data:param,
						action:"save"
					},function(response){
						window.history.back(-1);
					}); 
				}
			});
		}
	}
	
	function initSelect2(elem){
		$(elem).width(140).addClass(".skyselect").select2();
	}
	//初始化物料
	function InitWL(elem) {
		var bz = $("#form-submit [name=bz]").val();
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			if($(elem).prop("disabled")){
				return;
			}
			$.tableDialogPage({
				title:"物料价格选择",
				searchCond:[{"name":"物料编号","value":"wlbh"}],
				colModel:[{name:'id', index:'id', label:'ID',hidden:true},
				          {name:'wlbh', index:'wlbh', label:'物料编号', width:100},
				          {name:'wlms', index:'wlms', label:'物料描述', width:100},
						  {name:'wldw', index:'wldw', label:'单位', width:60},
						  {name:'dj', index:'dj', label:'单价', width:60}],
			url: "<c:url value='/pub/widget/findMaterial'/>?bz="+bz
			},{
				callback:function(rows){
					if(rows){
						$(elem).closest("tr.jqgrow").find("input[name='dw']").val(rows.wldw);
						$(elem).closest("tr.jqgrow").find("input[name='dj']").val(rows.dj);
						$(elem).closest("tr.jqgrow").find("input[name='bz']").val(bz);
						$(elem).closest("tr.jqgrow").find("input[name='wlms']").val(rows.wlms);
						$(elem).val(rows.wlbh);
					}else{
						$(elem).closest("tr.jqgrow").find("input[name='dw']").val("");
						$(elem).closest("tr.jqgrow").find("input[name='dj']").val("");
						$(elem).closest("tr.jqgrow").find("input[name='bz']").val("");
						$(elem).closest("tr.jqgrow").find("input[name='wlms']").val("");
						$(elem).val("");
					}
				}
			});
		});
	}
	//币种change事件
	function changeBzEvent(){
		$('#form-submit [name=bz]').on('change',function(e){
			if(e.val != ""){
				$(grid_wlxx_selector).jqGrid("clearGridData");
				$(grid_wlxx_selector).trigger("reloadGrid");
			}
		});
	}
	//初始化参考订单绑定
	function InitDDH(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			if($(elem).prop("disabled")){
				return;
			}
			$.tableDialogPage({
				title:"订单选择",
				searchCond:[
				            {"name":"参考订单号","value":"ddid"},
				            {"name":"客户","value":"khmc"},
				            {"name":"公司","value":"gsbm"},
				            {"name":"PID","value":"pid"}
				            ],
				            colModel:[{name:'id', index:'id',hidden:true},
							          {name:'ddid', index:'ddid', label:'订单号'},
							          {name:'gsbm', index:'gsbm', label:'公司'},
							          {name:'khmc', index:'khmc', label:'客户名称'},
							          {name:'pid', index:'pid', label:'PID'},
							          {name:'zdsj', index:'zdsj', label:'制单时间'}
							          ],
			url: "<c:url value='/order/orderProduct/search'/>?zt=5"
			},{
				callback:function(rows){
					if(rows){
						$(elem).closest("tr.jqgrow").find("input[name='jixin']").val(rows.jixin);
						$(elem).closest("tr.jqgrow").find("input[name='jixing']").val(rows.wsxh);
						$(elem).val(rows.ddid);
					}else{
						$(elem).closest("tr.jqgrow").find("input[name='jixin']").val("");
						$(elem).closest("tr.jqgrow").find("input[name='jixing']").val("");
						$(elem).val("");
					}
				}
			});
		});
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
			$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(6));
		});
	}
	/* function initDj(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).closest("tr.jqgrow").find("[name='sl']").val();
			var dj = $(elem).val();
			var je = "";
			if(sl != "" && dj != ""){
				je = sl * dj;
			}
			$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(6));
		});
	} */
	// 计算合计行
	function sumGrid(){
		var sl;
		var je;
		$(grid_wlxx_selector).footerData("set",{"wlms":"合计"}); //合计
		var rowNum = $(grid_wlxx_selector).jqGrid('getGridParam','records');
		if(rowNum >0 ){
			 sl = $(grid_wlxx_selector).getCol("sl",false,"sum"); 
			 je = $(grid_wlxx_selector).getCol("je",false,"sum"); 
		}
		$(grid_wlxx_selector).footerData("set",{"sl":sl, "je":je}); //将合计值显示出来
	}
	
	// 初始化PI
	function initPiData(data){
		$(grid_wlxx_selector).jqGrid("clearGridData");
		$(grid_wlxx_selector).jqGrid("addRowData", null, data, "last");
		//$("#form-submit [name=scjd]").select2("val",data[0].scjd);
		$("#form-submit [name=gsbm]").select2("val",data[0].gsbm);
		$("#form-submit [name=khbm]").val(data[0].khbm);
		$("#form-submit [name=khmc]").val(data[0].khmc);
		$("#form-submit [name=fktj]").val(data[0].fktj);
		$("#form-submit [name=fktjmc]").val(data[0].fktjmc);
		$("#form-submit [name=gjmytk]").select2("val", data[0].gjmytk);
		$("#form-submit [name=gjmytkbz]").val(data[0].gjmytkbz);
		$("#form-submit [name=xsyid]").val(data[0].xsyid);
		$("#form-submit [name=xsymc]").val(data[0].xsymc);
		$("#form-submit [name=xszz]").val(data[0].xszz);
		$("#form-submit [name=xszzmc]").val(data[0].xszzmc);
		$("#form-submit [name=ywz]").val(data[0].ywz);
		$("#form-submit [name=ywzmc]").val(data[0].ywzmc);
		$("#form-submit [name=bz]").select2("val",data[0].bz);
	}
</script>
</html>