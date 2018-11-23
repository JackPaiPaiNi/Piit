<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
</head>
<body>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<h5 class="header blue" style="margin-top: 4px;">特批登记</h5>
				<div class="space-4"></div>	
				<ul class="nav nav-tabs">
					<li class="active"><a href="#plxx-tab" data-toggle="tab">批量特批</a></li>
					<li><a href="#dtxx-tab" data-toggle="tab">单个特批</a></li>
				</ul>
				<div class="tab-content">
				<div class="tab-pane fade active in" id="plxx-tab">
					<form id="pl_form-submit">
							<input type="hidden" name="oper" value="add">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">特批节点&nbsp;&nbsp;</label>
										<select role="select" name="tpjd" size="1" class="form-control skyselect">
											${fns:loadDictOption('TPJD')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-9">
									<span class="pl_btn-xd" hidden="true">
										<button id="pl_btn-xdSelect" type="button" class="btn btn-purple btn-sm" >
											<i class="fa fa-plus icon-on-right bigger-110"></i>
											订单选择
										</button>
										&nbsp;
									</span>
									<span class="pl_btn-yzh" hidden="true">
										<button id="pl_btn-yzhSelect" type="button" class="btn btn-purple btn-sm" >
											<i class="fa fa-plus icon-on-right bigger-110"></i>
											预走货选择
										</button>
										&nbsp;
									</span>
									<span class="pl_btn-yscq" hidden="true">
										<button id="pl_btn-yscqSelect" type="button" class="btn btn-purple btn-sm" >
											<i class="fa fa-plus icon-on-right bigger-110"></i>
											应收超期预走货
										</button>
										&nbsp;
									</span>
									<button id="pl_btn-submit" type="button" class="btn btn-info btn-sm">
										<i class="icon-ok btn-info icon-on-right bigger-110"></i>
										提交
									</button>
									&nbsp;
									<button id="pl_btn-back" type="button" class="btn btn-xs">
										<i class="icon-undo icon-on-right"></i> 返回
									</button>
									&nbsp;
									<button id="pl_btn-clear" type="button" class="btn btn-danger btn-xs">
										<i class="icon-remove icon-on-right"></i> 清空
									</button>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-12 col-sm-12">
									<div id="grid-parent">
										<table id="grid-table"></table>
										<div id="grid-pager"></div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="tab-pane fade" id="dtxx-tab">
						<form id="form-submit">
						<div class="row">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">特批节点&nbsp;&nbsp;</label>
									<select role="select" name="tpjd" size="1" class="form-control skyselect">
										${fns:loadDictOption('TPJD')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-9">
								<span class="btn-xd" hidden="true">
									<button id="btn-xdSelect" type="button" class="btn btn-purple btn-sm" >
										<i class="fa fa-plus icon-on-right bigger-110"></i>
										订单选择
									</button>
									&nbsp;
								</span>
								<span class="btn-yzh" hidden="true">
									<button id="btn-yzhSelect" type="button" class="btn btn-purple btn-sm" >
										<i class="fa fa-plus icon-on-right bigger-110"></i>
										预走货选择
									</button>
									&nbsp;
								</span>
								<span class="btn-yscq" hidden="true">
									<button id="btn-yscqSelect" type="button" class="btn btn-purple btn-sm" >
										<i class="fa fa-plus icon-on-right bigger-110"></i>
										应收超期预走货
									</button>
									&nbsp;
								</span>
								<button id="btn-submit" type="button" class="btn btn-info btn-sm">
									<i class="icon-ok btn-info icon-on-right bigger-110"></i>
									提交
								</button>
								&nbsp;
								<button id="btn-back" type="button" class="btn btn-xs">
									<i class="icon-undo icon-on-right"></i> 返回
								</button>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row">
							<input type="hidden" name="id" />
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">特批单号&nbsp;&nbsp;</label>
									<input type="text" name="tpdh" class="form-control" readonly="true" />
									<input type="hidden" name="oper" value="add" />
									<input type="hidden" name="sjc" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">单号&nbsp;&nbsp;</label>
									<input type="text" name="dh" class="form-control" readonly="true" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">单据类型&nbsp;&nbsp;</label>
									<input type="hidden" name="djlx"  />
									<input type="text" name="djlxmc" class="form-control" readonly="true" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
									<input type="text" name="khbm" class="form-control" readonly="true" />
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
									<input type="text" name="khmc" class="form-control" readonly="true" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">特批类别&nbsp;&nbsp;</label>
									<input type="hidden" name="tplb" value="2" />
									<input type="text" name="tplbmc" value="领导特批" class="form-control" readonly="true" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">特批时间&nbsp;&nbsp;</label>
									<input type="text" name="tpsj" class="form-control date-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
									<input type="text" name="bzxx" class="form-control" />
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row">
							<div class="col-xs-6 col-sm-2">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">附件&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="fj" type="file" class="form-control">
									</div>
									<input type="hidden" name="fj" />
								</div>
							</div> 	
							<div class="col-xs-6 col-sm-6">
								<div id="fjxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
								<div id="multiFileQueue"> </div>
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>
				<!-- PAGE CONTENT ENDS -->
		</div>
	</div>
		<!-- /.row -->
	<!-- /.page-content -->
</body>
<script type="text/javascript">
	var isEdit = false;
	var grid_selector= "#grid-table";
	var pager_selector= "#grid-pager";
	<shiro:hasPermission name="payment:paySpecial:edit">isEdit = true;</shiro:hasPermission>
	$(function($) {
		$(".skyselect").select2();
		$(".date-picker").bindDate();
		$('#form-submit [name=tpjd]').on('change',function(e){
			if(e.val == 1){
				$(".btn-xd").show();
				$(".btn-yzh").hide();
				$(".btn-yscq").hide();
			}else if(e.val == 2){
				$(".btn-xd").hide();
				$(".btn-yzh").show();
				$(".btn-yscq").hide();
			}else if(e.val == 3){
				$(".btn-xd").hide();
				$(".btn-yzh").hide();
				$(".btn-yscq").show();
			}else{
				$(".btn-xd").hide();
				$(".btn-yzh").hide();
				$(".btn-yscq").hide();
			}
		});
		// 订单选择（下单）
		$("#btn-xdSelect").click(function(){
			$.tableDialogPage({
				title:"订单选择",
	            searchCond:[{"name":"公司","value":"gsbm"},
				            {"name":"客户","value":"khbm"},
    			            {"name":"销售员","value":"xsymc"},
    			            {"name":"订单号","value":"dh"}],
			  	colModel:[{label:"订单号", index:"dh", name:"dh", width:80},
				          {label:"订单类型", index:"djlxmc", name:"djlxmc", width:80},
				          {label:"公司", index:"gsbm", name:"gsbm", width:60},
				          {label:"销售员", index:"xsymc", name:"xsymc", width:80},
				          {label:"客户编码", index:"khbm", name:"khbm", width:80},
				          {label:"客户名称", index:"khmc", name:"khmc", width:120}],
				url:"<c:url value='/payment/paySpecial/orderSearch'/>"
			},{
				callback:function(rows){
					if(rows){
						$("#form-submit [name=dh]").val(rows.dh);
						$("#form-submit [name=djlx]").val(rows.djlx);
						$("#form-submit [name=djlxmc]").val(rows.djlxmc);
						$("#form-submit [name=khbm]").val(rows.khbm);
						$("#form-submit [name=khmc]").val(rows.khmc);
					}else{
						$("#form-submit [name=dh]").val("");
						$("#form-submit [name=djlx]").val("");
						$("#form-submit [name=djlxmc]").val("");
						$("#form-submit [name=khbm]").val("");
						$("#form-submit [name=khmc]").val("");
					}
				}
			});
		});
		// 预走货选择
		$("#btn-yzhSelect").click(function(){
			$.tableDialogPage({
				title:"预走货选择",
				searchCond:[{"name":"公司","value":"gsbm"},
				            {"name":"客户","value":"khbm"},
    			            {"name":"销售员","value":"xsymc"},
    			            {"name":"预走货单号","value":"dh"}],
				colModel:[{label:"预走货单号", index:"dh", name:"dh", width:80},
				          {label:"预走货类型", index:"djlxmc", name:"djlxmc", width:80},
				          {label:"公司", index:"gsbm", name:"gsbm", width:60},
				          {label:"销售员", index:"xsymc", name:"xsymc", width:80},
				          {label:"客户编码", index:"khbm", name:"khbm", width:80},
				          {label:"客户名称", index:"khmc", name:"khmc", width:120}],
				url:"<c:url value='/payment/paySpecial/yzhSearch'/>?tpjd=2"
			},{
				callback:function(rows){
					if(rows){
						$("#form-submit [name=dh]").val(rows.dh);
						$("#form-submit [name=djlx]").val(rows.djlx);
						$("#form-submit [name=djlxmc]").val(rows.djlxmc);
						$("#form-submit [name=khbm]").val(rows.khbm);
						$("#form-submit [name=khmc]").val(rows.khmc);
					}else{
						$("#form-submit [name=dh]").val("");
						$("#form-submit [name=djlx]").val("");
						$("#form-submit [name=djlxmc]").val("");
						$("#form-submit [name=khbm]").val("");
						$("#form-submit [name=khmc]").val("");
					}
				}
			});
		});
		// 预走货选择(应收超期)
		$("#btn-yscqSelect").click(function(){
			$.tableDialogPage({
				title : "预走货选择",
				searchCond:[{"name":"公司","value":"gsbm"},
				            {"name":"客户","value":"khbm"},
    			            {"name":"销售员","value":"xsymc"},
    			            {"name":"预走货单号","value":"dh"}],
				colModel:[{label:"预走货单号", index:"dh", name:"dh", width:80},
				          {label:"预走货类型", index:"djlxmc", name:"djlxmc", width:80},
				          {label:"公司", index:"gsbm", name:"gsbm", width:60},
				          {label:"销售员", index:"xsymc", name:"xsymc", width:80},
				          {label:"客户编码", index:"khbm", name:"khbm", width:80},
				          {label:"客户名称", index:"khmc", name:"khmc", width:120}],
				          url:"<c:url value='/payment/paySpecial/yzhSearch'/>?tpjd=3"
			}, {
				callback : function(rows) {
					if(rows){
						$("#form-submit [name=dh]").val(rows.dh);
						$("#form-submit [name=djlx]").val(rows.djlx);
						$("#form-submit [name=djlxmc]").val(rows.djlxmc);
						$("#form-submit [name=khbm]").val(rows.khbm);
						$("#form-submit [name=khmc]").val(rows.khmc);
					}else{
						$("#form-submit [name=dh]").val("");
						$("#form-submit [name=djlx]").val("");
						$("#form-submit [name=djlxmc]").val("");
						$("#form-submit [name=khbm]").val("");
						$("#form-submit [name=khmc]").val("");
					}
				}
			});
		});
		// 附件
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

		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
		//返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: 'input[type=hidden]',
			rules: {
				tpjd: 'required',
				dh: 'required',
				djlxmc: 'required',
				khbm: 'required',
				khmc: 'required',
				tplbmc: 'required',
				tpsj: 'required'
				
			},
			messages: {
				tpjd: '特批节点不能为空',
				dh: '单号不能为空',
				djlxmc: '单据类型不能为空',
				khbm: '客户编码不能为空',
				khmc: '客户名称不能为空',
				tplbmc: '特批类别不能为空',
				tpsj: '特批时间不能为空'
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
		//********************************以下是批量特批功能初始化*********************************
		$('#pl_form-submit [name=tpjd]').on('change',function(e){
			if(e.val == 1){
				$(".pl_btn-xd").show();
				$(".pl_btn-yzh").hide();
				$(".pl_btn-yscq").hide();
			}else if(e.val == 2){
				$(".pl_btn-xd").hide();
				$(".pl_btn-yzh").show();
				$(".pl_btn-yscq").hide();
			}else if(e.val == 3){
				$(".pl_btn-xd").hide();
				$(".pl_btn-yzh").hide();
				$(".pl_btn-yscq").show();
			}else{
				$(".pl_btn-xd").hide();
				$(".pl_btn-yzh").hide();
				$(".pl_btn-yscq").hide();
			}
			$(grid_selector).jqGrid('clearGridData');
		});
		//初始化grid
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
			    {name : 'dh',index : 'dh',label : '单号',editoptions:{disabled:true},width : 90} ,
			    {name : 'djlx',index : 'djlx',label : '单据类型',hidden:true,editoptions:{disabled:true},width : 90},
			    {name : 'djlxmc',index : 'djlxmc',label : '单据类型',editoptions:{disabled:true},width : 90},
			    {name : 'khbm',index : 'khbm',label : '客户编码',editoptions:{disabled:true},width : 90},
			    {name : 'khmc',index : 'khmc',label : '客户名称',editoptions:{disabled:true},width : 160},
			    {name : 'tplb',index : 'tplb',label : '特批类别',width:80,hidden: true,editoptions:{disabled:true,dataInit: function(elem){$(elem).val("2")}}},
			    {name : 'tplbmc',index : 'tplbmc',label : '特批类别',width:100,editoptions:{disabled:true,dataInit: function(elem){$(elem).val("领导特批")}}},
			    {name : 'tpsj',index : 'tpsj',label : '特批时间',width : 90,formatter:'date',editoptions:{dataInit:initTime}, formatoptions:{newformat:'Y-m-d'}},
			    {name : 'bzxx',index : 'bzxx',label : '备注',width : 160} 
			],
			editTable:true,
		},{
			add:false,
			edit:isEdit,
			del:isEdit,
			complete:isEdit
		});
		
		// 批量订单选择（下单）
		$("#pl_btn-xdSelect").click(function(){
			$.tableDialogPage({
				multiselect : true,
				title:"订单选择",
	            searchCond:[{"name":"公司","value":"gsbm"},
				            {"name":"客户","value":"khbm"},
    			            {"name":"销售员","value":"xsymc"},
    			            {"name":"订单号","value":"dh"}],
			  	colModel:[{label:"ID", index:"id", name:"id", hidden: true},
			  	          {label:"订单号", index:"dh", name:"dh", width:80},
			  	          {label:"订单类型", index:"djlx", name:"djlx", hidden: true},
				          {label:"订单类型", index:"djlxmc", name:"djlxmc", width:80},
				          {label:"公司", index:"gsbm", name:"gsbm", width:60},
				          {label:"销售员", index:"xsymc", name:"xsymc", width:80},
				          {label:"客户编码", index:"khbm", name:"khbm", width:80},
				          {label:"客户名称", index:"khmc", name:"khmc", width:120}],
				url:"<c:url value='/payment/paySpecial/orderSearch'/>"
			},{
				callback:function(rows){
					var cfdh = validDh(rows);
					if(cfdh == ""){
						$.each( rows, function(i,v){  
				              v.tplb = "2";
				              v.tplbmc = "领导特批";
				              v.tpsj = new Date();
				            });  
						//填充明细表格
						$(grid_selector).jqGrid("addRowData", null, rows,"last");
					}else{
						swal("",cfdh+"单号不能重复选择!","warning");
						return;
					}
				}
			});
		});
		// 批量预走货选择
		$("#pl_btn-yzhSelect").click(function(){
			$.tableDialogPage({
				multiselect : true,
				title:"预走货选择",
				searchCond:[{"name":"公司","value":"gsbm"},
				            {"name":"客户","value":"khmc"},
    			            {"name":"销售员","value":"xsymc"},
    			            {"name":"预走货单号","value":"dh"}],
				colModel:[{label:"ID", index:"id", name:"id", hidden: true},
				          {label:"预走货单号", index:"dh", name:"dh", width:80},
				          {label:"预走货类型", index:"djlx", name:"djlx", hidden: true},
				          {label:"预走货类型", index:"djlxmc", name:"djlxmc", width:80},
				          {label:"公司", index:"gsbm", name:"gsbm", width:60},
				          {label:"销售员", index:"xsymc", name:"xsymc", width:80},
				          {label:"客户编码", index:"khbm", name:"khbm", width:80},
				          {label:"客户名称", index:"khmc", name:"khmc", width:120}],
				url:"<c:url value='/payment/paySpecial/yzhSearch'/>?tpjd=2"
			},{
				callback:function(rows){
					var cfdh = validDh(rows);
					if(cfdh == ""){
						$.each( rows, function(i,v){  
				              v.tplb = "2";
				              v.tplbmc = "领导特批";
				              v.tpsj = new Date();
				            });  
						//填充明细表格
						$(grid_selector).jqGrid("addRowData", null, rows,"last");
					}else{
						swal("",cfdh+"单号不能重复选择!","warning");
						return;
					}
				}
			});
		});
		// 批量预走货选择(应收超期)
		$("#pl_btn-yscqSelect").click(function(){
			$.tableDialogPage({
				multiselect : true,
				title : "预走货选择",
				searchCond:[{"name":"公司","value":"gsbm"},
				            {"name":"客户","value":"khmc"},
    			            {"name":"销售员","value":"xsymc"},
    			            {"name":"预走货单号","value":"dh"}],
				colModel:[{label:"ID", index:"id", name:"id", hidden: true},
				          {label:"预走货单号", index:"dh", name:"dh", width:80},
				          {label:"预走货类型", index:"djlx", name:"djlx", hidden: true},
				          {label:"预走货类型", index:"djlxmc", name:"djlxmc", width:80},
				          {label:"公司", index:"gsbm", name:"gsbm", width:60},
				          {label:"销售员", index:"xsymc", name:"xsymc", width:80},
				          {label:"客户编码", index:"khbm", name:"khbm", width:80},
				          {label:"客户名称", index:"khmc", name:"khmc", width:120}],
				          url:"<c:url value='/payment/paySpecial/yzhSearch'/>?tpjd=3"
			}, {
				callback : function(rows) {
					var cfdh = validDh(rows);
					if(cfdh == ""){
						$.each( rows, function(i,v){  
				              v.tplb = "2";
				              v.tplbmc = "领导特批";
				              v.tpsj = new Date();
				            });  
						//填充明细表格
						$(grid_selector).jqGrid("addRowData", null, rows,"last");
					}else{
						swal("",cfdh+"单号不能重复选择!","warning");
						return;
					}
				}
			});
		});
		
		//批量提交
		$("#pl_btn-submit").click(function(){
			pl_submit();
	    });
		//批量返回
		$("#pl_btn-back").click(function(){
			window.history.back(-1);
	    });
		//清空
		$("#pl_btn-clear").click(function(){
			$(grid_selector).jqGrid('clearGridData');
	    });
		$('#pl_form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: 'input[type=hidden]',
			rules: {
				tpjd: 'required'
				
			},
			messages: {
				tpjd: '特批节点不能为空'
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
		
		//*************************************批量特批初始化结束**************************************
	});
	
	// 提交
	function submit(){
		if(!$('#form-submit').valid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		param.fj = $('#fjxx').html();
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/paySpecial/edit'/>",
					data : param,
					action : "save"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	
	//********************************以下是批量特批功能初始化*********************************
    //日期绑定
	function initTime(elem){
		$(elem).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
    }
	//校验已选中的单据不能重复选中
	function validDh(rows){
		var dhlist = "";
		var list = $(grid_selector).getRowData();
		$.each(list, function(i,v){  
			var yxzdh = v.dh;
			$.each(rows, function(j,n){  
	            var wxzdh = n.dh;
	            if(yxzdh == wxzdh){
	            	dhlist = dhlist + yxzdh +",";
	            }
	          }); 
          }); 
		return dhlist;
	}
	// 批量提交
	function pl_submit(){
		if(!$('#pl_form-submit').valid()){
			return false;
		}
		var param = $("#pl_form-submit").getFormData();
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
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/paySpecial/pledit'/>",
					data : param,
					action : "save"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	//*************************************批量特批结束**************************************
</script>
</html>