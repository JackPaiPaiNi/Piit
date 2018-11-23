<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	
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
					<input type="hidden" name="id"/><!--id -->
					<input type="hidden" name="oper"/>
					<input type="hidden" name="sjc"/>
					<input type="hidden" name="taskId" />
					<input type="hidden" name="token" value="${token}"/>
					<!-- 销售员选择隐藏字段 -->
					<input type="hidden" name="xszz"/>
					<input type="hidden" name="ywz"/>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">申请单号&nbsp;&nbsp;</label>
							<input type="text" name="sqdh" class="form-control" readOnly/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">状态&nbsp;&nbsp;</label>
							<select role="select" name="zt" size="1" class="form-control skydisabled" disabled="disabled">
								${fns:loadDictOption('DJZT')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
						</div>
					</div>
					<!-- <div class="col-xs-6 col-sm-1"></div> -->
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
						<button id="btn-back" class="btn btn-sm" type="button">
							<i class="icon-undo icon-on-right bigger-110"></i>
							返回
						</button>
					</div>
				</div>
			
				<h5 class="header blue" style="margin-top:4px;">客户申请信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
							<input type="text" name="khmc" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户简称&nbsp;&nbsp;</label>
							<input type="text" name="khjc" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户地址&nbsp;&nbsp;</label>
							<input type="text" name="xxdz" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">官网网址&nbsp;&nbsp;</label>
							<input type="text" name="gwdz" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户联系人&nbsp;&nbsp;</label>
							<input type="text" name="lxr" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="lxr2" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="lxr3" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">手机号码&nbsp;&nbsp;</label>
							<input type="text" name="sjh" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">联系电话&nbsp;&nbsp;</label>
							<input type="text" name="dh" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">Email&nbsp;&nbsp;</label>
							<input type="text" name="yx" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">Skype&nbsp;&nbsp;</label>
							<input type="text" name="skype" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">Whatapp&nbsp;&nbsp;</label>
							<input type="text" name="whatapp" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">品牌&nbsp;&nbsp;</label>
							<input type="text" name="pp" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">付款条件&nbsp;&nbsp;</label>
							<input type="text" name="fktj" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
							<input type="hidden" name="xsyid" class="form-control"/>
							<input type="text" name="xsymc" onfocus="this.blur()"
								class="form-control parent-node" style="cursor: pointer!important;" />
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">关联客户编码&nbsp;&nbsp;</label>
							<input type="text" name="glkhbm" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-sm-6 col-sm-6">
						<div class="input-group">
							<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
							<textarea name="bzxx" class="autosize-transition form-control"></textarea>
						</div>
					</div>
				</div>
				<!-- 审批日志 -->
			    <div class="space-4"></div>
			    <h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
			    <div class="space-4"></div>
			    <c:import url="/pub/showLog/customerApply" charEncoding="UTF-8" />
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
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	<shiro:hasPermission name="mdm:customerApply:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($){
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
	  	// 页面id赋值
		$("#form-submit [name=id]").val(id);
		// 销售员选择
		selectXsyInit();
		// 付款方式初始化
		get_fkfs();
		//初始化页面数据
		bindFormData(id);
		// 前端数据校验
		validate();
		// 保存
		$("#btn-save").click(function(){
			save();
	    });
		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
	});
	// 销售员选择
	function selectXsyInit(){
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
					$("#form-submit [name=xszz]").val(record.xszz);
					$("#form-submit [name=xszzmc]").val(record.xszzmc);
					$("#form-submit [name=ywz]").val(record.ywz);
					$("#form-submit [name=ywzmc]").val(record.ywzmc);
				}else{
					$("#form-submit [name=xsyid]").val("");
					$("#form-submit [name=xsymc]").val("");
					$("#form-submit [name=xszz]").val("");
					$("#form-submit [name=xszzmc]").val("");
					$("#form-submit [name=ywz]").val("");
					$("#form-submit [name=ywzmc]").val("");
				}
			}
		});
	}
	//取付款方式
	function get_fkfs(){
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
	//初始化页面数据
	function bindFormData(id){
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=zt]").val("1");//状态:草稿
		} else {
			// edit
			$.bindAjax({
				url : "<c:url value='/mdm/customerApply/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$("#form-submit [name=oper]").val("edit");
				$("#form-submit [name=taskId]").val(taskId);
			});
		}
	}
	// 前端数据校验
	function validate(){
		// 前端数据校验
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			rules: {
				khmc: 'required',
				fktj: 'required',
				xsymc: 'required'
			},
			messages: {
				khmc: '客户名称不能为空',
				fktj: '付款条件不能为空',
				xsymc: '销售员不能为空'
			},
	        showErrors: function(errorMap, errorList) {  
	            if(errorList.length == 0){
	            	$('.input-group').removeClass('has-error');
	            }else{
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
	// 保存
	function save(){
		if(!$('#form-submit').valid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		$("#save").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			 callback:function(){
				$.bindAjax({
					url:"<c:url value='/mdm/customerApply/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=sqdh]").val(result.sqdh);
					$("#form-submit [name=zt]").val(result.zt);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
					$("#form-submit [name=token]").val(result.token);
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
		$("#save").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/mdm/customerApply/submit'/>",
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