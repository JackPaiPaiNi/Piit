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
		String sjc = request.getParameter("sjc");
		String sfBg = request.getParameter("sfBg");
	%>
<body>
<div class="zheZhao"></div>
<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<form id="form-submit">
					<h5 class="header blue" style="margin-top: 4px;">登记信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">登记人&nbsp;&nbsp;</label>
								<input type="text" name="zdrmc" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">登记时间&nbsp;&nbsp;</label>
								<input type="text" name="zdsj" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">状态&nbsp;&nbsp;</label>
								<select role="select" name="zt" size="1" class="form-control skyselect skydisabled" disabled="true">
									${fns:loadDictOption('DJZT')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">版本号&nbsp;&nbsp;</label>
								<input type="text" name="bbh" class="form-control" readonly />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">操作历史</h5>
					<!-- 审批历史 -->
					<div id="grid-parent">
						<table id="grid-table"></table>
					<h5 class="header blue" style="margin-top: 4px;">L/C摘录基本信息</h5>
				    <div class="space-4"></div>	
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">信用证号&nbsp;&nbsp;</label>
								<input type="text" name="lcbh" class="form-control skydisabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">获取信用证日期&nbsp;&nbsp;</label>
								<input type="text" name="hqrq" class="form-control date-picker" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">信用证正本存放处&nbsp;&nbsp;</label>
								<input type="text" name="zbcfc" class="form-control"  readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">绑定PI号&nbsp;&nbsp;</label>
								<input type="text" name="piid" class="form-control" readonly />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">申请人&nbsp;&nbsp;</label>
								<input type="text" name="khbm" onfocus="this.blur()" class="form-control  parent-node"/>
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">申请人名称&nbsp;&nbsp;</label>
								<input type="text" name="khmc" class="form-control" readonly/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">开证日期&nbsp;&nbsp;</label>
								<input type="text" name="kzrq" class="form-control date-picker" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">受益人&nbsp;&nbsp;</label>
								<select role="select" name="gsbm" size="1" class="form-control skyselect">
									${fns:loadCompanyOption('0')}
								</select>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">有效期至&nbsp;&nbsp;</label>
								<input type="text" name="yxq" class="form-control date-picker " />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">最晚装船期&nbsp;&nbsp;</label>
								<input type="text" name="zwzcq" class="form-control date-picker" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">议付交单期（天数）&nbsp;&nbsp;</label>
								<input type="text" name="yfjdq" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">议付后付款天数&nbsp;&nbsp;</label>
								<input type="text" name="yfhcksj" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">信用证性质&nbsp;&nbsp;</label>
								<select role="select" name="xyzxz" size="1" class="form-control skyselect">
									${fns:loadDictOption('XYZXZ')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">远期天数&nbsp;&nbsp;</label>
								<select role="select" name="xyzxzts" size="1" class="form-control skyselect skydisabled" disabled="disabled">
									${fns:loadDictOption('XYZXZTS')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">是否循环L/C&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline"> <input type="radio"
										name="sfxhlc" class="skyradio" value="1">是
									</label> <label class="radio-inline"> <input type="radio"
										checked="checked" name="sfxhlc" class="skyradio" value="0">否
									</label>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">是否备用信用证&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline"> <input type="radio"
										name="sfbyxyz" class="skyradio" value="1">是
									</label> <label class="radio-inline"> <input type="radio"
										checked="checked" name="sfbyxyz" class="skyradio" value="0">否
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">形式发票号&nbsp;&nbsp;</label>
								<input type="text" name="xsfph" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">信用证修改版号&nbsp;&nbsp;</label>
								<input type="text" name="xgbbh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">LC付款条件&nbsp;&nbsp;</label>
								<input type="text" name="fktj" class="form-control"/>
							</div>
						</div>	
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm" style="width:100px;">
								<label class="input-group-addon">附件&nbsp;&nbsp;</label>
								<div class="form-control" style="text-align:center;">
									<input id="fj" type="file" class="form-control">
								</div>
								<input type="hidden" name="fj" />
							</div>
						</div>	
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-sm-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
								<textarea name="bzxx" rows="5" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div id="multiFileQueue"> </div>
							<div id="fjxx">
								<ul class="list-unstyled spaced"></ul>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<h5 class="header blue" style="margin-top: 4px;">贸易信息</h5>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">交货条件&nbsp;&nbsp;</label>
								<select role="select" name="mytk" size="1" class="form-control skyselect">
									${fns:loadDictOption('PIGJMYTK')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">起运港&nbsp;&nbsp;</label>	
								<select role="select" name="qyg" size="1" class="form-control skyselect">
					           	 	${fns:loadDictOption('QYG')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">目的港&nbsp;&nbsp;</label>
								<input type="text" name="mdg" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">允许装运条款&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="checkbox-inline"> <input
										type="checkbox" class="skycheckbox" name="zytkYxfy"
										value="1">分运
									</label> <label class="checkbox-inline"> <input
										type="checkbox" class="skycheckbox" name="zytkYxzy"
										value="1">转运
									</label>
								</div>
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">银行信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">开证行&nbsp;&nbsp;</label> 
								<input type="text" name="kzh" onfocus="this.blur()" class="form-control parent-node" /> 
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">开证行SwiftCode&nbsp;&nbsp;</label>
								<input type="text" name="kzhdm" class="form-control skydisabled" disabled="disabled"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">
									<input type="checkbox" name="sfybdh" value="1" class="checkbox-inline skycheckbox">
								</span>
								<label class="input-group-addon">保兑行名称&nbsp;&nbsp;</label>
								<input type="text" name="bdh" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<span class="input-group-addon">
									<input type="checkbox" name="sfycfh" value="1" class="checkbox-inline skycheckbox">
								</span>
								<label class="input-group-addon">偿付行名称&nbsp;&nbsp;</label>
								<input type="text" name="cfh" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">通知行&nbsp;&nbsp;</label>
								<input type="text"  name="tzh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">指定议付行&nbsp;&nbsp;</label>
								<input type="text" name="zdyfh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">银行参考号&nbsp;&nbsp;</label>
								<input type="text" name="yhckh" class="form-control" />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">L/C金额信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">L/C金额&nbsp;&nbsp;</label>
								<input type="text" name="je" class="form-control" />
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">已使用金额&nbsp;&nbsp;</label>
								<input type="text" name="ysyje" class="form-control" readonly />
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
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">循环L/C次数上限&nbsp;&nbsp;</label>
								<input type="text" name="xhlccssx" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-8"></div>
					<div class="row" style="margin: 0px; text-align: center;">
						<input type="hidden" name="id" /> 
						<input type="hidden" name="oper" /> 
						<input type="hidden" name="sjc" />
						<input type="hidden" name="taskId" />
						<input type="hidden" name="token" value="${token}"/>
						<input type="hidden" name="sfBg" />
						<div class="col-xs-6 col-sm-12">
							<button id="btn-save" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp;
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="undo" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
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

</body>
<script type="text/javascript">
	// 变量定义开始
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var sjc = "<%=sjc%>";
	var sfBg = "<%=sfBg%>";
	var isEdit = false;
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	<shiro:hasPermission name="payment:lcReg:edit">isEdit=true;</shiro:hasPermission>
	// 变量定义结束 
	// 加载开始
	$(function($){
	    $(".skyselect").select2();
		$(".date-picker").bindDate(); 
		// 客户选择
		$("#form-submit [name=khbm]").click(function(){
			bindKhbm();
		});
		
		//加载开证行
		$("#form-submit [name=kzh]").click(function(){
			InitLCKZH();
	    });
		//初始化审批历史表
		$(grid_selector).bindTable({
			caption: "",
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			//autoheight:true,
			//extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true},
				{name:'lcbh', index:'lcbh', label:'LC编号', width:80},
				{name:'bbh', index:'bbh',label:'版本号', width:80 },
				{name:'zdrmc', index:'zdrid', label:'操作人名称', width:80},
				{name:'zdsj', index:'zdrmc', label:'操作时间', width:60},
				/* {name:'fj', index:'fj', label:'附件', width:60}, */
				{name:'bzxx', index:'bzxx', label:'处理意见', width:80}
			]
		});
		
		
  		// 是否保兑行
  		$("#form-submit [name=sfybdh]").click(function(){
 			 if($(this).is(":checked")){
 				$("#form-submit [name=bdh]").removeProp("disabled").removeAttr("disabled");
			}else{
 				$("#form-submit [name=bdh]").val("");
 				$("#form-submit [name=bdh]").prop("disabled","disabled");
			} 
		});
  		
  		// 是否偿付行
  		$("#form-submit [name=sfycfh]").click(function(){
			 if($(this).is(":checked")){
	 			$("#form-submit [name=cfh]").removeProp("disabled").removeAttr("disabled");
 			}else{
  				$("#form-submit [name=cfh]").val("");
  				$("#form-submit [name=cfh]").prop("disabled","disabled");
 			} 
  		});
  		
		$("#btn-save").click(function(){
			save();
		});
		$("#undo").click(function(){
			window.history.back(-1);
	    });
		$("#btn-submit").click(function(){
			submit();
	    }); 
		
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

		//初始化页面数据		
 		bindFormData();
 		initValidate();
 		fillValue();
 		// 付款方式初始化
		bindFktjSelect();
		// 信用证性质
		$('#form-submit [name=xyzxz]').on('change',function(e){
			if($(this).val() == 2){
				$('#form-submit [name=xyzxzts]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=xyzxzts]').select2("val","");
				$('#form-submit [name=xyzxzts]').prop('disabled','disabled');
			}
		});
	});
	
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户编码","value":"khbm"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:60},
					  {name:'khmc', index:'khmc', label:'客户名称', width:100}],
			url:"<c:url value='/pub/widget/findCust'/>"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
				}
				
			}
		});
	}
	
	//加载开证行
	function InitLCKZH() {
		$.tableDialogPage({
			title:"银行选择",
			searchCond:[{"name":"银行名称","value":"zwmc"},
			            {"name":"SWIFT代码","value":"swiftdm"},
			            {"name":"英文名称","value":"ywmc"}],
			colModel:[{name:'zwmc', index:'zwmc', label:'银行名称', width:80, hidden: true},
					  {name:'swiftdm', index:'swiftdm', label:'swift代码', width:80},
					  {name:'ywmc', index:'ywmc', label:'英文名称', width:80},
					  {name:'ywdz', index:'ywdz', label:'英文地址', width:80}],
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
	
	//初始化页面数据
	function bindFormData() {
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=bbh]").val(1);
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=zt]").select2('val', 1);
		} else {
			// edit
			var editUrl = "<c:url value='/payment/lcReg/findById'/>";
			var param = {id : id};
			if(sfBg == 1){
				editUrl = "<c:url value='/payment/lcReg/changeById'/>";
				param.sjc = sjc;
			}
			$.bindAjax({
				url : editUrl,
				data : param,
				action : "search"
			},function(response) {
				$("#form-submit").setFormData(response);
				$("#fjxx").html(response.fj);
				$("#form-submit [name=lcbh]").prop('disabled','disabled');
				$("#form-submit [name=oper]").val("edit");
				$("#form-submit [name=taskId]").val(taskId);
			});
		}
	}
	
	//取付款条件
	function bindFktjSelect(){
		$.post("<c:url value='/pub/select2/selectLcPayTerm'/>",{},
			function(result){
				var data = $.map(result, function (obj) {
					obj.id = obj.fktjdm;
			        obj.text = obj.fktjdm + "-" + obj.fktjms;	      
			        return obj;
				});
				$("#form-submit [name=fktj]").addClass("skyselect").select2({data:data});
 			}, "json");
	}
	
	// 保存
	function save() {
		if(!$('#form-submit').valid()){
			return false;
		}	
		if($("#form-submit [name=xyzxz]").select2("val") == 2 && $("#form-submit [name=xyzxzts]").select2("val") == ""){
    		swal('','信用证性质为远期时请选择天数！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/lcReg/edit'/>",
					data : param,
					action : "save"
				}, function(response) {
					//状态变更  更新时间戳 ID赋值  版本号赋值
					var data = JSON.parse(response);
					if(response.htylist){
						$(grid_selector).jqGrid("addRowData", null, response.htylist, "last"); 
					}
					$("#form-submit [name=zt]").select2('val', data.zt);
					$("#form-submit [name=id]").val(data.id);
					$("#form-submit [name=sjc]").val(data.sjc);
					$("#form-submit [name=bbh]").val(data.bbh);
					$("#form-submit [name=zdrmc]").val(data.zdrmc);
					$("#form-submit [name=zdsj]").val(data.zdsj);
					$("#form-submit [name=token]").val(data.token);
					/* $(".skydisabled").prop("disabled","disabled"); */
				});
			}
		});
	}
	
	// 提交
	function submit() {
		if(!$('#form-submit').valid()){
			return false;
		}
		if($("#form-submit [name=xyzxz]").select2("val") == 2 && $("#form-submit [name=xyzxzts]").select2("val") == ""){
    		swal('','信用证性质为远期时请选择天数！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/lcReg/submit'/>",
					data : param,
					action : "save"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	
	//填写通行后给信用证本存放处赋值
	function fillValue (){
		$('#form-submit [name=tzh]').on('change', function(){
			$('input[name=zbcfc]').val($('input[name=tzh]').val());
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
 				lcbh : 'required',
 				hqrq : 'required',
 				yxq : 'required',
 				zwzcq :'required',
 				khbm :'required',
 				xyzxz :'required',
 				sfxhlc: 'required',
 				kzh: 'required',
 				bz: 'required',
 				kzhdm:'required',
 				yfjdq : { required:true , digits:true },
 				yfhcksj: { required:true , digits:true },
 				je : { required:true , number:true },
 				tzh : 'required'
 			},
 			messages: {
 				lcbh : '信用证号必填',
 				hqrq : '获取信用证日期必填',
 				yxq : '信用证有效期必填',
 				zwzcq :'最晚装船期必填',
 				khbm :'申请人必填',
 				xyzxz :'信用证性质必填',
 				sfxhlc: '是否循环L/C必填',
 				kzh: 'L/C开证行必填',
 				bz: '币种必填',
 				yfjdq :  '议付交单期必须为数字',
 				yfhcksj: '议付后付款天数必须为数字',
 				je:   '金额必须为数字',
 				tzh : '通知行必填'
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
    
</script>
</html>