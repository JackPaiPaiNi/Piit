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
	 %>
<body>
<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<div class="row" style="margin: 0px 8px;">
						<input type="hidden" name="id"/>
						<input type="hidden" name="oper"/>
						<input type="hidden" name="token" value="${token}"/>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同编码&nbsp;&nbsp;</label>
								<input type="text" name="htbh" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同名称&nbsp;&nbsp;</label>
								<input type="text" name="htmc" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
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
					<h5 class="header blue" style="margin-top: 4px;">合同信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同发起人&nbsp;&nbsp;</label> 
								<!-- <input type="hidden" name="fqrid" class="form-control"/>
								<input type="text" name="fqrmc" onfocus="this.blur()"
									class="form-control parent-node" style="cursor: pointer!important;" />
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span> -->
								<input type="text" name="fqrmc" class="form-control" />
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同发起日期&nbsp;&nbsp;</label> 
								<input type="text" name="fqrq" class="form-control date-picker"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					    <div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同类型&nbsp;&nbsp;</label> 
								<select role="select" name="htlx" size="1" class="form-control skyselect">
									${fns:loadDictOption('HTLX')}
								</select>
							</div>
						 </div>
						 <div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> 
								<input type="text" id="khmc" name="khmc" onfocus="this.blur()" class="form-control  parent-node"/>
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
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label> 
								<input type="text" name="khbm" class="form-control" readOnly/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户地址&nbsp;&nbsp;</label> 
								<input type="text" name="khdz" class="form-control" readOnly/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">收/付款&nbsp;&nbsp;</label>
								<select role="select" name="sfk" size="1" class="form-control skyselect">
									${fns:loadDictOption('SFK')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">付款条件&nbsp;&nbsp;</label> 
								<input type="text" name="fktj" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">签约方&nbsp;&nbsp;</label> 
								<input type="text" name="qyf" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group-sm">
								<input type="text" name="qyf2" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group-sm">
								<input type="text" name="qyf3" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同份数&nbsp;&nbsp;</label> 
								<input type="text" name="htfs" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同金额&nbsp;&nbsp;</label> 
								<input type="text" name="htje" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同货币&nbsp;&nbsp;</label> 
								<select role="select" name="bz" size="1" class="form-control skyselect">
									${fns:loadDictOption('BZ')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">有效期&nbsp;&nbsp;</label> 
								<input type="text" name="yxqks" class="form-control date-picker"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">至&nbsp;&nbsp;</label> 
								<input type="text" name="yxqjs" class="form-control date-picker"/>
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
								<label class="input-group-addon">状态&nbsp;&nbsp;</label> 
								<select role="select" name="zt" size="1" class="form-control skyselect">
									${fns:loadDictOption('HTZT')}
								</select>
							</div>
						 </div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">归档状态&nbsp;&nbsp;</label> 
								<select role="select" name="gdzt" size="1" class="form-control skyselect">
									${fns:loadDictOption('GDZT')}
								</select>
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">归档日期&nbsp;&nbsp;</label> 
								<input type="text" name="gdrq" class="form-control date-picker"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-sm-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">合同简况&nbsp;&nbsp;</label>
								<textarea name="htjk" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="col-sm-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">备注&nbsp;&nbsp;</label>
								<textarea name="bzxx" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
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
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
	<!-- /.page-content -->
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
</span>
</body>
<script type="text/javascript">
	// 变量定义开始
	var id = "<%=id%>";
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	// 不可编辑
	var isEdit = false;
	// 权限判断
	<shiro:hasPermission name="mdm:contract:edit">isEdit = true;</shiro:hasPermission>

	$(function($){
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
	  	// 页面id赋值
		$("#form-submit [name=id]").val(id);
		// 客户选择框
		$("#khmc").parent().click(function(){
			bindKhbm();
		});
		//发起人选择
	  	//selectFqrInit();
	 	// 付款方式初始化
		bindFktjSelect();
	  	//初始化页面数据
		bindFormData(id);
		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
		//返回按钮
		$('#btn-back').click(function(){
			window.history.back(-1);
		});
		
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
	});
	/**************************************************function开始区域************************************************/
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户编码","value":"khbm"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:80},
					  {name:'khmc', index:'khmc', label:'客户名称', width:80},
					  {name:'fktj', index:'fktj', label:'付款条件', width:80}],
			url:"<c:url value='/pub/widget/findCust'/>"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
					$("input[name=khdz]").val(rows.dz);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
					$("input[name=khdz]").val("");
				}
			}
		});
	}
	// 发起人选择
	function selectFqrInit(){
		$("#form-submit [name=fqrmc]").bindTreeTableDialog({
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
					$("#form-submit [name=fqrid]").val(record.empCode);//参考rightColModel
					$("#form-submit [name=fqrmc]").val(record.name);
				}else{
					$("#form-submit [name=fqrid]").val("");
					$("#form-submit [name=fqrmc]").val("");
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
	//初始化页面数据
	function bindFormData(id){	
		//view or edit
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/mdm/contract/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$("#form-submit [name=oper]").val("edit");//编辑权限
				$("#fjxx").html(response.fj);
			});
		}else{
			//初始化页面参数
			$("#form-submit [name=id]").val("");//PIID:空
			$("#form-submit [name=oper]").val("add");//权限:add
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
		rules: {
			htbh : {required:true , maxlength:20},
			//fqrmc : 'required',
			//fqrq : 'required',
			htlx : 'required',
			//khbm : 'required',
			htfs : { required:true , number:true },
			//htje : { number:true }
		},
		messages: {
			htbh : '合同编号不能为空,且长度不能大于20!',
			//fqrmc : '合同发起人不能为空!',
			//fqrq : '合同发起日期不能为空!',
			htlx : '合同类型不能为空!',
			//khbm : '客户编码不能为空!',
			htfs : '合同份数不能为空，且必须为数字!',
			//htje : '合同金额必须为数字!'
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
	//提交
	function submit(){
		if(!$('#form-submit').valid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/mdm/contract/edit'/>",
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