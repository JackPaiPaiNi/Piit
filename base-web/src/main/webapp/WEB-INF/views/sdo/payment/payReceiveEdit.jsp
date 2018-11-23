<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>

</head>
<%
	String id = request.getParameter("id");
    String oper = request.getParameter("oper");
	String sjc = request.getParameter("sjc");
	String sfBg = request.getParameter("sfBg");
%>
<body>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<input type="hidden" name="id" />
					<input type="hidden" name="bbh" />
					<input type="hidden" name="oper">
					<input type="hidden" name="sjc"/>
					<input type="hidden" name="sfBg" />
					<input type="hidden" name="token" value="${token}"/>
				<h5 class="header blue" style="margin-top: 4px;">收款信息登记</h5>
				<div class="space-4"></div>	
				<ul class="nav nav-tabs">
					<li class="active"><a href="#dtxx-tab" data-toggle="tab">单条信息录入</a></li>
					<li><a href="#plxx-tab" data-toggle="tab">批量数据导入</a></li>
				</ul>
				
				<div class="tab-content">
					<div class="tab-pane fade active in" id="dtxx-tab">
					<!--收款信息 -->
						<div class="row">
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收款单号&nbsp;&nbsp;</label> <input
										type="text" name="skdh" class="form-control"  readonly />
								</div>
							</div>
						    <div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
								  
									<label class="input-group-addon">付款人&nbsp;&nbsp;</label> 
									<input type="text" name="fkr" class="form-control" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">付款银行&nbsp;&nbsp;</label> <input
										type="text" name="fkyh" class="form-control" />
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row">
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">付款国家&nbsp;&nbsp;</label>
									<select role="select" name="fkgj" size="1" class="form-control skyselect">
										${fns:loadCountryOption('0')}
									</select>
								</div>
							</div>
						    <div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">币种&nbsp;&nbsp;</label>
									<select role="select" name="bz" size="1" class="form-control skyselect">
										${fns:loadDictOption('BZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收款日期&nbsp;&nbsp;</label> <input
										type="text" name="skrq" class="form-control date-picker" /> <span
										class="input-group-addon"> <i
										class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row">
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收款银行名称&nbsp;&nbsp;</label>
									<input type="text" name="skyhmc" onfocus="this.blur()" class="form-control  parent-node"/>
									<span class="input-group-addon">
										<i class="icon-search bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收款银行账号&nbsp;&nbsp;</label> <input
										type="text" name="skyh" class="form-control" readonly />
								</div>
							</div>
							
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">接单主体&nbsp;&nbsp;</label> <!-- <input
										type="text" name="gsbm" class="form-control" disabled="disabled"/> -->
									<select role="select" name="gsbm" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadCompanyOption('0')}
									</select> 
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row">
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">金额&nbsp;&nbsp;</label> <input
										type="text" name="je" class="form-control" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">参考手续费&nbsp;&nbsp;</label> <input
										type="text" name="cksxf" class="form-control" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">状态&nbsp;&nbsp;</label>
									<select role="select" name="zt" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('DJZT')}
									</select>
								</div>
							</div>
						
						</div>
						<div class="space-4"></div>
						<div class="row">
							<div class="col-xs-6 col-sm-4">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收款类别&nbsp;&nbsp;</label> 
									<select role="select" name="sklb" size="1" class="form-control skyselect">
										${fns:loadDictOption('SKLB')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row">
							<div class="col-xs-6 col-sm-12">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
									<textarea name="bzxx" class="autosize-transition form-control"></textarea>
								</div>
							</div>
						</div>
						<div class="space-8"></div>
						<div class="row" style="text-align: center;">
							<button id="btn-save" type="button" class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp;
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="btn-back" type="button" class="btn btn-sm">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
						</div>
					</div>
					<div class="tab-pane fade" id="plxx-tab">
						<div id="list">
							<div class="space-4"></div>
							<div class="btn-group">
							          <button id="btn-download" type="button" class="btn btn-info btn-sm">
											<i class="icon-download-alt icon-on-right bigger-110"></i>
											导入模板下载
									  </button>
									  <button id="btn-import" type="button" class="btn btn-info btn-sm">
											<i class="icon-upload-alt icon-on-right bigger-110"></i>
											   导入
									  </button>
									 <!--  <button id="btn-save-item" type="button" class="btn btn-info btn-sm">
										   <i class="icon-ok icon-on-right bigger-110"></i> 
										    保存导入明细
									  </button> -->
						          </div>
							<div class="row">
								<div class="col-xs-12 col-sm-12">
									<div id="grid-parent">
										<table id="grid-table"></table>
										<div id="grid-pager"></div>
									</div>
								</div>
							</div>
							<div class="space-8"></div>
							<div class="row" style="text-align: center;">
								<button id="btn-save-item" type="button" class="btn btn-success btn-sm">
									<i class="icon-save icon-on-right bigger-110"></i> 保存
								</button>
								&nbsp;
								<button id="btn-submit-item" type="button" class="btn btn-info btn-sm">
									<i class="icon-ok icon-on-right bigger-110"></i> 提交
								</button>
								&nbsp;
								<button id="btn-back-item" type="button" class="btn btn-sm">
									<i class="icon-undo icon-on-right bigger-110"></i> 返回
								</button>
							</div>
						</div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
	<!-- /.page-content -->

</body>
<script type="text/javascript">
    var  oper="<%=oper%>"
    var id='<%=id == null ? "" : id%>';
	var sjc = "<%=sjc%>";
	var sfBg = "<%=sfBg%>";
	var isEdit = false;
	var grid_selector= "#grid-table";
	var pager_selector= "#grid-pager";
	<shiro:hasPermission name="payment:payReceive:edit">isEdit = true;</shiro:hasPermission>

	$(function($) {
		$(".date-picker").bindDate();
		$(".skyselect").select2();
		// 银行选择框
		$("#form-submit [name=skyhmc]").parent().click(function(){
			bindSkyh();
		});
		//初始化表达验证机制
        initValidate();
      	//保存按钮
    	$("#btn-save").click(function() {
    		save();
    	});
    	//提交
    	$("#btn-submit").click(function() {
    		submit(); 
    	});
    	//返回按钮
    	$('#btn-back').click(function() {
    		window.history.back(-1);
    	});
    	//编辑表初始化
    	if(oper=="add"){
    		initGrid();
    	}else{
    		$('#list').hide();
    	}
    	//收款登记
    	 mbxz();
    	//初始化页面数据
    	initPageData(id);
    	//批量保存按钮
    	$("#btn-save-item").click(function() {
    		saveItem();
    	});
    	//批量提交
    	$("#btn-submit-item").click(function() {
    		submitItem(); 
    	});
    	//批量返回按钮
    	$('#btn-back-item').click(function() {
    		window.history.back(-1);
    	});
    	
    	$('#form-submit [name=sklb]').on('change',function(e){
    		if($(this).val() == 3){
    			$('#form-submit [name=gsbm]').removeProp('disabled').removeAttr("disabled");
    		}else{
    			$('#form-submit [name=gsbm]').prop('disabled','disabled');
    		}
    	});
    	
	});
	
	//初始化页面数据
	function initPageData(id){ 
		if(id.length==0){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=zt]").select2("val",1);
		} else {
			// edit
			var editUrl = "<c:url value='/payment/payReceive/findById'/>";
			var param = {id : id};
			if(sfBg == 1){
				editUrl = "<c:url value='/payment/payReceive/changeById'/>";
				param.sjc = sjc;
			}
			$.bindAjax({
				url : editUrl,
				data : param,
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$("#form-submit [name=oper]").val("edit");
			});
		}
	}
	
	//绑定银行选择框
	function bindSkyh(){
		$.tableDialogPage({
			title:"银行选择",
			searchCond:[{"name":"公司编码","value":"gsbm"},
			            {"name":"银行账号","value":"yhzh"}],
			colModel:[{name:'id', index:'id', label:'ID',hidden:true}, 
			          {name:'gsbm', index:'gsbm', label:'公司编码', width:80},
		 	          {name:'zwmc', index:'zwmc', label:'银行名称', width:80}, 
					  {name:'yhzh', index:'yhzh', label:'银行账号', width:80},
					  {name:'bz', index:'bz', label:'币种', width:80}],
			url:"<c:url value='/pub/widget/findCompanyBank'/>"
		},{
			callback:function(rows){
				if(rows){
					$("#form-submit [name=skyhmc]").val(rows.zwmc);
					$("#form-submit [name=skyh]").val(rows.yhzh);
					$("#form-submit [name=gsbm]").select2("val",rows.gsbm);
				}else{
					$("#form-submit [name=skyhmc]").val("");
					$("#form-submit [name=skyh]").val("");
					$("#form-submit [name=gsbm]").select2("val","");
				}
			}
		});
	}
	
    //初始化表单验证机制
    function initValidate(){
    	 $('#form-submit').validate({
 			onfocusout: false,
 			onkeyup: false,
 			onclick: false,
 			focusInvalid: false,
 			focusCleanup: false,
 			ignore: 'input[type=hidden]',
 			rules: {
 				fkr:  'required',
 				/* fkyh: 'required',
 				fkgj: 'required', */
 				bz:   'required',
 				skrq: 'required',
 				//skyhmc: 'required',
 				je:   'required',
 				pzh:  'required',
 				je:   { required:true , number:true },
 				cksxf:'number',
 				sklb: 'required'
 			},
 			messages: {
 				fkr:  '付款人不能为空！',
 				/* fkyh: '付款银行不能为空！',
 				fkgj: '付款国家不能为空，请选择！', */
 				bz:   '币种不能为空，请选择！',
 				skrq: '收款日期不能为空，请选择！',
 				//skyhmc: '收款银行不能为空，请选择！',
 				pzh:  '凭证号不能为空！',
 				je:   '金额不能为空！',
 				je:   '金额必须为数值！',
 				cksxf:'参考手续费必须为数值！',
 				sklb: '收款类别不能为空'
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
    
    //保存方法
    function save(){
    	//当收款类别为保理和普通时，收款银行为必填
    	if($("#form-submit [name=sklb]").val() != 3 && $("#form-submit [name=skyhmc]").val().length == 0){
    		swal("", "收款银行不能为空，请选择！！", "warning");
			return;
    	}
		if(!$('#form-submit').valid()){
			return false;
		}	
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		},{
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payReceive/edit'/>",
					data : param,
					action : "save"
				}, function(response) {
					//状态变更  更新时间戳 ID赋值  版本号赋值
					var data = JSON.parse(response);
					$("#form-submit [name=id]").val(data.id);
					$("#form-submit [name=skdh]").val(data.skdh);
					$("#form-submit [name=sjc]").val(data.sjc);
					$("#form-submit [name=bbh]").val(data.bbh);
					$("#form-submit [name=token]").val(data.token);
				});
			}
		});
    }
    
    
  //初始化grid
	function initGrid(){		
		$(grid_selector).bindTable({
			caption: "",
			pager: pager_selector,
			//去掉编辑表分页按钮
			pgbuttons: false,
			pginput: false,
			rowList: [],
			//recordtext: "",
			gridParent: "#grid-parent",
			//footerrow:true,
			datatype: "local",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
			    {name : 'fkr',index : 'fkr',label : '付款人',editable : true,width : 90},
				{name : 'fkyh',index : 'fkyh',label : '付款银行',editable : true,width : 80},
				{name:'fkgj', index:'fkgj', label:'付款国家', width:80, editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadCountryOption('1')}",dataInit: initSelect2}},
				{name:'sklb', index:'sklb', label:'收款类别', width:80, editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('SKLB')}",dataInit: initSelect2}},
			    {name : 'bz', index : 'bz', label : '币种', width : 80, editable : true,
		    	    edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('BZ')}",dataInit: initSelect2}},
	    	    {name:'skrq', index:'skrq', label:'收款日期', width:80, formatter:'date',editoptions:{dataInit:innitTime}, formatoptions:{newformat:'Y-m-d'}},
				{name : 'skyh',index : 'skyh',label:'收款银行账号', width:80},
				{name : 'skyhmc',index : 'skyhmc',label : '收款银行名称',width : 80,editable : true, editoptions:{dataInit: initBank}},
				{name:'gsbm', index:'gsbm', label:'接单主体', width:100,editable:true, editrules:{required:true},edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadCompanyOption('1')}",dataInit: initSelect2}},
				{name : 'je',index : 'je',label : '金额',width : 80,align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name : 'cksxf',index : 'cksxf',label : '参考手续费',width : 80,align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name : 'bzxx',index : 'bzxx',label : '备注信息',width : 180}
			],
			gridComplete: function(){
				
		   	},
			editTable:true,
			editComplete: function(lastEdit, rowData){
				
			}
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			complete:isEdit
		});
	}
	//选择银行
	function initBank(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
			title:"银行选择",
			searchCond:[{"name":"公司编码","value":"gsbm"},
			            {"name":"银行账号","value":"yhzh"}],
			colModel:[{name:'id', index:'id', label:'ID',hidden:true}, 
			          {name:'gsbm', index:'gsbm', label:'公司编码', width:80},
		 	          {name:'zwmc', index:'zwmc', label:'银行名称', width:80}, 
					  {name:'yhzh', index:'yhzh', label:'银行账号', width:80},
					  {name:'bz', index:'bz', label:'币种', width:80}],
			url:"<c:url value='/pub/widget/findCompanyBank'/>"
		},{
			callback:function(rows){
				if(rows){
					$(elem).closest("tr.jqgrow").find("[name='zwmc']").val(rows.zwmc);
					$(elem).closest("tr.jqgrow").find("[name='skyh']").val(rows.yhzh);
					$(elem).closest("tr.jqgrow").find("[name='gsbm']").val(rows.gsbm);
				}else{
					$(elem).closest("tr.jqgrow").find("[name='zwmc']").val("");
					$(elem).closest("tr.jqgrow").find("[name='skyh']").val("");
					$(elem).closest("tr.jqgrow").find("[name='gsbm']").val("");
				}
			}
			});
		});
	}
    //提交
    function submit(){
    	//当收款类别为保理和普通时，收款银行为必填
    	if($("#form-submit [name=sklb]").val() != 3 && $("#form-submit [name=skyhmc]").val().length == 0){
    		swal("", "收款银行不能为空，请选择！！", "warning");
			return;
    	}
    	if(!$('#form-submit').valid()){
			return false;
		}	
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		},{
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payReceive/submit'/>",
					data : param,
					action : "save"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
    }
    // 导入控件绑定
	$('#btn-import').click(function(){
		$.importDialog({
			title:"选择文件",
			url:"<c:url value='/payment/payReceive/getList'/>"
		},{
			callback:function(response){
			    $(grid_selector).jqGrid('clearGridData');
		    	$(grid_selector).jqGrid("addRowData", null,JSON.parse(response), "last");
			}
		});
	});
	 //保存导入明细
	function saveItem(){
		var param = $("#form-submit").getFormData();
		//结束表格编辑
		lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector).saveRow(lastEdit, false, 'clientArray');
			if(!result){
				return;
			}
		}
		param.list =  JSON.stringify($(grid_selector).getRowData());
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		},{
			callback : function() {
				$.bindAjax({
					url:"<c:url value='/payment/payReceive/saveList'/>",
					data :param,
					action : "save"
				}, function(response) {
					var result = JSON.parse(response);
					$(grid_selector).jqGrid('clearGridData');
					$('#form-submit [name=token]').val(result.token);
				});
			}
		});
	};
    
	 //提交导入明细
	function submitItem(){
		var param = $("#form-submit").getFormData();
		//结束表格编辑
		lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector).saveRow(lastEdit, false, 'clientArray');
			if(!result){
				return;
			}
		}
		param.list =  JSON.stringify($(grid_selector).getRowData());
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		},{
			callback : function() {
				$.bindAjax({
					url:"<c:url value='/payment/payReceive/submitList'/>",
					data :param,
					action : "save"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	};
	 
    // 初始化编辑表select2
	function initSelect2(elem){
		$(elem).width("100%").addClass("skyselect").select2();
	}
    //导入日期绑定
	function innitTime(elem){
		$(elem).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
    }
	//模板下载
	function mbxz(){
	  $('#btn-download').click(function(){
		  window.location.href=encodeURI("<c:url value='/template/skdj.xlsx'/>");
	  })};
	    
</script>
</html>