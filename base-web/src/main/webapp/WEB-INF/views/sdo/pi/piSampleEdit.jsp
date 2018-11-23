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
				    <input type="hidden" name="token" value="${token}" />
					<input type="hidden" name="id"/><!-- id -->
					<input type="hidden" name="oper"/>
					<input type="hidden" name="sjc"/>
					<input type="hidden" name="sfBg"/>
					<input type="hidden" name="sfCh"/>
					<input type="hidden" name="bbh"/>
					<input type="hidden" name="taskId" />
					<!-- 销售员选择隐藏字段 -->
					<%-- <input type="hidden" name="xszz" value="${xszz}" />
					<input type="hidden" name="xszzmc" value="${xszzmc}"  />
					<input type="hidden" name="ywz" value="${ywz}" />
					<input type="hidden" name="ywzmc" value="${ywzmc}" /> --%>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">参考PI号&nbsp;&nbsp;</label>
							<input type="text" id="ckpih" name="ckpih" onfocus="this.blur()" class="form-control  parent-node"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<%-- <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
							<select role="select" name="scjd" size="1" class="form-control skyselect">	
								 ${fns:loadDictOption('SCJD')}
							</select>
						</div>
					</div> --%>
					<div class="col-xs-6 col-sm-6">
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
						<button id="undo" class="btn btn-sm" type="button">
							<i class="icon-undo icon-on-right bigger-110"></i>
							返回
						</button>
					</div>
				</div>
			
				<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">PI号&nbsp;&nbsp;</label>
							<input type="text" name="piid" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">公司&nbsp;&nbsp;</label>
							<input type="text" name="gsbm" class="form-control">
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">PI类型&nbsp;&nbsp;</label>
							<select role="select" name="pilx" size="1" class="form-control skydisabled" disabled="disabled">
								 ${fns:loadDictOption('PILX')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
							<input type="hidden" name="xsyid" value="${xsyid}" class="form-control"/>
							<input type="text" name="xsymc" value="${xsymc}" onfocus="this.blur()"
								class="form-control parent-node" style="cursor: pointer!important;" />
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
							<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
							<input type="text" name="zdsj" class="form-control date-picker skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
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
							<label class="input-group-addon">状态&nbsp;&nbsp;</label>
							<select role="select" name="zt" size="1" class="form-control skydisabled" disabled="disabled">
								${fns:loadDictOption('DJZT')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">PI有效至&nbsp;&nbsp;</label>
							<input type="text" name="piyxq" class="form-control date-picker"/>
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
							<label class="input-group-addon">销售组织&nbsp;&nbsp;</label>
							<input type="text" name="xszzmc" class="form-control skydisabled" value="${xszzmc}" disabled="disabled">
							<input type="hidden" name="xszz" value="${xszz}" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
							<input type="text" name="ywzmc" class="form-control skydisabled" value="${ywzmc}" disabled="disabled">
							<input type="hidden" name="ywz" value="${ywz}" />
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">客户信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">To&nbsp;&nbsp;</label>
							<input type="text" id="khmc" name="khmc" onfocus="this.blur()" class="form-control  parent-node"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">Customer Code&nbsp;&nbsp;</label>
							<input type="text" name="khbm" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">TEL&nbsp;&nbsp;</label>
							<input type="text" name="khdh" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">E-MAIL&nbsp;&nbsp;</label>
							<input type="text" name="khyx" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">ATTN&nbsp;&nbsp;</label>
							<input type="text" name="khlxr" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-6">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">Address&nbsp;&nbsp;</label>
							<input type="text" name="khdz" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">Currency&nbsp;&nbsp;</label>
							<select role="select" name="bz" size="1" class="form-control skyselect">
								${fns:loadDictOption('BZ')}
							</select>
						</div>
					</div>
				</div>	
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">Brand&nbsp;&nbsp;</label>
							<input type="text" name="khpp" class="form-control"/>
						</div>
					</div>
				</div>	
				<div class="space-8"></div>
				<ul class="nav nav-tabs">
					<li class="active"><a href="#zyxx-tab" data-toggle="tab">装运信息</a></li>
					<li><a href="#cpxx-tab" data-toggle="tab">产品信息</a></li>
					<li><a href="#yhxx-tab" data-toggle="tab">银行信息</a></li>
				</ul>
				<div class="tab-content">
					<!-- 装运信息TAB -->
					<div class="tab-pane fade active in" id="zyxx-tab">
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Format&nbsp;&nbsp;</label>
									<select role="select" name="zhfs" size="1" class="form-control skyselect">
										 ${fns:loadDictOption('PI_ZHFS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Purpose&nbsp;&nbsp;</label>
									<select id = "pimd" role="select" name="pimd" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('PURPOSE')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group-sm">
									<input type="text" name="pimdbz" placeholder="Purpose Remark" class="form-control" disabled="disabled"/>
								</div>
							</div>
								
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Pay Terms&nbsp;&nbsp;</label>
									<input type="text" name="fktj" class="form-control"/>
									<input type="hidden" name="xdLc"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Credit Balance&nbsp;&nbsp;</label>
									<input type="text" name="xyedye" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Price Terms&nbsp;&nbsp;</label>
									<select role="select" name="gjmytk" size="1" class="form-control skyselect">
										 ${fns:loadDictOption('PIGJMYTK')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input id ="gjmytkbz" type="text" name="gjmytkbz" placeholder="Price Terms Remark" class="form-control"/>
								</div>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Target Delivery Date&nbsp;&nbsp;</label>
									<input type="text" name="yqdhrq1" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="yqdhrq2" class="form-control  skydisabled" disabled="disabled" value="days after receipt of"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<select id = "yqdhrq3" role="select" name="yqdhrq3" size="1" class="form-control skyselect">
										${fns:loadDictOption('DHYQ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="yqdhrq4" class="form-control  skydisabled" disabled="disabled" value="and confirming the artwork"/>
								</div>
							</div>						
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Shipment&nbsp;&nbsp;</label>
									<select id = "cylx" role="select" name="cylx" size="1" class="form-control skyselect">
										${fns:loadDictOption('CYLX_FP')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group-sm">
									<input id ="cylxbz" type="text" name="cylxbz" placeholder="Shipment Remark" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-sm-6 col-sm-12">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">变更信息备注&nbsp;&nbsp;</label>
									<textarea name="bgbz" class="autosize-transition form-control"></textarea>
								</div>
							</div>
						</div>
					</div>
					<!-- 产品信息TAB -->
					<div class="tab-pane fade" id="cpxx-tab">
						<h5 class="header blue yxd" style="margin: 0; padding: 0;display:none">已下单(包含审批中订单数量)</h5>
				    	<div class="space-4"></div>
						<div id="yxd_grid-parent" class="yxd"  style="display:none">
							<table id="yxd_grid-table"></table>
							<div id="yxd_grid-pager"></div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">未下单</h5>
				    	<div class="space-4"></div>
						<div id="grid-parent">
							<table id="grid-table"></table>
							<div id="grid-pager"></div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Product Remark&nbsp;&nbsp;</label>
									<textarea name="cpbzxx" rows="5" class="autosize-transition form-control"></textarea>
								</div>
						</div>
					</div>
					<!-- 银行信息TAB -->
					<div class="tab-pane fade" id="yhxx-tab">						
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Bank Name&nbsp;&nbsp;</label>
									<input type="text" name="skyhmc" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Bank Address&nbsp;&nbsp;</label>
									<input type="text" name="skyhdz" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>				
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Swift Code&nbsp;&nbsp;</label>
									<input type="text" name="skyhdm" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Account No.&nbsp;&nbsp;</label>
									<input type="text" name="skyhzh" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>						
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">L/C Advising Bank Name&nbsp;&nbsp;</label>
									<input type="text" name="lcskyhmc" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">L/C Advising Bank Address&nbsp;&nbsp;</label>
									<input type="text" name="lcskyhdz" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>				
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">L/C Advising Swift Code&nbsp;&nbsp;</label>
									<input type="text" name="lcskyhdm" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">L/C Advising Account No.&nbsp;&nbsp;</label>
									<input type="text" name="lcskyhzh" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>							
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Beneficiary&nbsp;&nbsp;</label>
									<input type="text" name="syr" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Beneficiary Address&nbsp;&nbsp;</label>
									<input type="text" name="syrdz" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-sm-12 col-sm-12">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Remark&nbsp;&nbsp;</label>
									<textarea name="bzxx" rows="5" class="autosize-transition form-control"></textarea>
								</div>
							</div>
						</div>
					</div>
					<!-- 审批日志 -->
				    <div class="space-4"></div>
				    <h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
				    <div class="space-4"></div>
				    <c:import url="/pub/showLog/piSimple" charEncoding="UTF-8" />
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
	// 变量定义开始
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var yxd_grid_selector = "#yxd_grid-table";
	var yxd_pager_selector = "#yxd_grid-pager";
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	// 不可编辑
	var isEdit = false;
	var isEdit = false;
	var respData  ={} ;
	var yhSffz = false ;
	var zhSffz = false ; 
	// 权限判断
	<shiro:hasPermission name="pi:piSample:edit">isEdit=true;</shiro:hasPermission>
	// 变量定义结束 
	// 加载开始
	$(function($){
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
	  	// 页面id赋值
		$("#form-submit [name=id]").val(id);		
		//取公司信息
		get_gsxx();
 		// 币种change事件
		$('#form-submit [name=bz]').on('change',function(e){
			var gsbm = $('#form-submit [name=gsbm]').val();
			var fktj = $("#form-submit [name=fktj]").val();
			
		});
 		// PI目的change事件 为Other时可填备注  	
		$('#form-submit [name=pimd]').on('change',function(e){
			if($(this).val() == 4){
				$('#form-submit [name=pimdbz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=pimdbz]').val("");
				$('#form-submit [name=pimdbz]').prop('disabled','disabled');
			}
		});
		// 参考PI号选择
		$("#ckpih").parent().click(function(){
			bindPiid();
		});
		// 客户选择框
		$("#khmc").click(function(){
			var xsyid = $("#form-submit [name=xsyid]").val();
			if(xsyid == null || xsyid == ""){
				swal('','请先选择销售员！','warning'); 
	    		return ;
			}else {
				bindKhbm();
			}
		});
		// 销售员选择
		selectXsyInit();
		// 付款方式初始化
		bindFktjSelect();
 		// 初始化grid
 		bindGrid();
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
		//银行swift代码改变时，重新加载银行账号信息
		$("#form-submit [name=skyhdm],#form-submit [name=lcskyhdm]").on('change',function(e) {
			changeYhzh();
		});
		//公司，币种，付款条件，改变时，重新加载银行信息
		$("#form-submit [name=bz],#form-submit [name=gsbm]").on('change',function(e) {
			changeYhxx();
		});
		// 初始化页面数据
 		bindFormData(id);
 		//初始化受益人名称
 		bindSyrmcSelect();
 		//初始化受益人地址
 		bindSyrdzSelect();
	});
	/**************************************************function开始区域************************************************/
	//取公司信息
	function get_gsxx(){
		$.post("<c:url value='/pub/select2/companyInfos'/>",{},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.gsbm || obj.gsmc;
			       obj.text = obj.text || obj.gsbm + "-" + obj.gszwmc;		      
			       return obj;
			     });
				$("#form-submit [name=gsbm]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
					if(e.added){
						//$("#form-submit [name=syr]").val(e.added.gsywmc);
						//$("#form-submit [name=syrdz]").val(e.added.gsywdz);
						$("#form-submit [name=syr]").select2('val',e.added.gsywmc);
						$("#form-submit [name=syrdz]").select2('val',e.added.gsywdz);
					}
				  });
		}, "json");
	}
	/******************************银行信息赋值逻辑控制开始************************************************/
	//加载银行信息
	function changeYhxx(){
		var gsbm = $('#form-submit [name=gsbm]').select2('val');
		var fktj = $('#form-submit [name=fktj]').select2('val');
		var bz = $('#form-submit [name=bz]').select2('val');
		var xdLc = $("#form-submit [name=xdLc]").val();
		if(respData !={}){
		    if(!yhSffz){
				gsbm = respData.gsbm;
				fktj = respData.fktj ;
				bz   = respData.bz ;
				xdLc = respData.xdLc ;
			}
		}
		
		if(gsbm == "" || bz == "" || fktj == ""){
			return;
		}
		// 清除所有银行信息
		$('#form-submit [name^=skyh]').removeProp('disabled').removeAttr('disabled');
		$('#form-submit [name^=lcskyh]').removeProp('disabled').removeAttr('disabled');
		var selector =  '#form-submit [name=skyhdm],#form-submit [name=skyhmc],'+
		                '#form-submit [name=lcskyhdm],#form-submit [name=lcskyhmc],'+
		                '#form-submit [name=skyhdz],#form-submit [name=lcskyhdz]';
		$(selector).val('');
		if($("#form-submit [name=skyhmc]").hasClass("skyselect")){
			$("#form-submit [name=skyhmc]").select2({data:{}});
		}else{
			$("#form-submit [name=skyhmc]").val('');
		}
		if($("#form-submit [name=skyhzh]").hasClass("skyselect")){
			$("#form-submit [name=skyhzh]").select2({data:{}});
		}else{
			$("#form-submit [name=skyhzh]").val('');
		}
		if($("#form-submit [name=lcskyhmc]").hasClass("skyselect")){
			$("#form-submit [name=lcskyhmc]").select2({data:{}});
		}else{
			$("#form-submit [name=lcskyhmc]").val('');
		}
		if($("#form-submit [name=lcskyhzh]").hasClass("skyselect")){
			$("#form-submit [name=lcskyhzh]").select2({data:{}});
		}else{
			$("#form-submit [name=lcskyhzh]").val('');
		}
		var sfLc = "" ;
		if(xdLc==1){
			//L"""
			$('#form-submit [name^=skyh]').prop('disabled','disabled');
			sfLc = "1";
		}else if(xdLc>0  && xdLc < 1){
			//既有LC也有其他
			sfLc = "2";
		}else{
			//非LC
			$('#form-submit [name^=lcskyh]').prop('disabled','disabled');
			sfLc = "0";
		}
		//开始加载银行信息
		$.post("<c:url value='/pub/select2/companyBank'/>",{gsbm:gsbm,bz:bz},
				function(result){
					var data = $.map(result, function (obj) {
						obj.id = obj.zwmc;
					    obj.text = obj.text || obj.zwmc;
					    return obj;
					});
					if(sfLc =="0"){
						$("#form-submit [name=skyhmc]").addClass("skyselect").select2({data:data}).on("change",function(e){
							if(e.added){
								$("#form-submit [name=skyhmc]").val(e.added.zwmc).trigger("change");
								$("#form-submit [name=skyhdz]").val(e.added.zwdz);
								$("#form-submit [name=skyhdm]").val(e.added.swiftdm).trigger("change");
							}
						});
					}else if(sfLc =="1"){
						$("#form-submit [name=lcskyhmc]").addClass("skyselect").select2({data:data}).on("change",function(e){
							if(e.added){
								$("#form-submit [name=lcskyhmc]").val(e.added.zwmc).trigger("change");
								$("#form-submit [name=lcskyhdz]").val(e.added.zwdz);
								$("#form-submit [name=lcskyhdm]").val(e.added.swiftdm).trigger("change");
							}
						});
					}else{
						$("#form-submit [name=skyhmc]").addClass("skyselect").select2({data:data}).on("change",function(e){
							if(e.added){
								$("#form-submit [name=skyhmc]").val(e.added.zwmc).trigger("change");
								$("#form-submit [name=skyhdz]").val(e.added.zwdz);
								$("#form-submit [name=skyhdm]").val(e.added.swiftdm).trigger("change");
							}
						});
						$("#form-submit [name=lcskyhmc]").addClass("skyselect").select2({data:data}).on("change",function(e){
							if(e.added){
								$("#form-submit [name=lcskyhmc]").val(e.added.zwmc).trigger("change");
								$("#form-submit [name=lcskyhdz]").val(e.added.zwdz);
								$("#form-submit [name=lcskyhdm]").val(e.added.swiftdm).trigger("change");
							}
						});
					}
					//银行还未赋值
					if(!yhSffz){
						if(respData!={}){
							if(sfLc == "0"){
								$("#form-submit [name=skyhmc]").select2('val',respData.skyhmc);
							    $("#form-submit [name=skyhdm]").val(respData.skyhdm) ;
								$("#form-submit [name=skyhdz]").val(respData.skyhdz) ;  
							}
							if(sfLc == "1"){
								$("#form-submit [name=lcskyhmc]").select2('val',respData.lcskyhmc) ;
								$("#form-submit [name=lcskyhdm]").val(respData.lcskyhdm) ;
								$("#form-submit [name=lcskyhdz]").val(respData.lcskyhdz) ;
							}
							if(sfLc == "2"){
								$("#form-submit [name=lcskyhmc]").select2('val',respData.lcskyhmc);
								$("#form-submit [name=skyhdm]").val(respData.skyhdm) ;
								$("#form-submit [name=skyhdz]").val(respData.skyhdz) ; 
								$("#form-submit [name=skyhmc]").select2('val',respData.skyhmc);
							    $("#form-submit [name=lcskyhdm]").val(respData.lcskyhdm) ;
								$("#form-submit [name=lcskyhdz]").val(respData.lcskyhdz) ; 
							}
							yhSffz = true ;
						}
					}
					if(yhSffz && zhSffz){
						respData ={};
					}
			
			}, "json");
	}
	//加载银行账号信息
	function changeYhzh(){
		var bz = $('#form-submit [name=bz]').select2('val');
		var gsbm = $('#form-submit [name=gsbm]').select2('val');
		var fktj = $('#form-submit [name=fktj]').select2('val');
		var skswiftdm = $('#form-submit [name=skyhdm]').val();
		var lcswiftdm = $('#form-submit [name=lcskyhdm]').val();
		var swiftdm = skswiftdm=="" ? lcswiftdm:skswiftdm ;
		var xdLc = $("#form-submit [name=xdLc]").val();
		if(respData && respData!={} ){
		    if(!yhSffz){
				gsbm = respData.gsbm;
				fktj = respData.fktj ;
				bz   = respData.bz ;
				xdLc = respData.xdLc ;
				skswiftdm = respData.skswiftdm;
				lcswiftdm = respData.lcswiftdm;
			}
		}
		if(gsbm == "" || bz ==  "" || (skswiftdm == "" && lcswiftdm=="") ){
			return;
		}
		// 清空银行账号信息
		$('#form-submit [name=lcskyhzh]').removeProp('disabled').removeAttr('disabled');
		$('#form-submit [name=skyhzh]').removeProp('disabled').removeAttr('disabled');
		if($("#form-submit [name=lcskyhzh]").hasClass("skyselect")){
			$("#form-submit [name=lcskyhzh]").select2({data:{}});
		}else{
			$("#form-submit [name=lcskyhzh]").val('');
		}
		if($("#form-submit [name=skyhzh]").hasClass("skyselect")){
			$("#form-submit [name=skyhzh]").select2({data:{}});
		}else{
			$("#form-submit [name=skyhzh]").val('');
		}
		var sfLc = "";
		if(xdLc == 1){
			// LC银行
			sfLc = "1";
			$('#form-submit [name=skyhzh]').prop('disabled','disabled');
		}else if(xdLc >0 && xdLc<1 ){
			sfLc = "2";
		}else{
			// 非LC银行
			sfLc = "0";
			$('#form-submit [name=lcskyhzh]').prop('disabled','disabled');
		}
		//加载非lc银行数据//取收款银行账号，不再区分lc银行账号和非lc银行账号  
		$.post("<c:url value='/pub/select2/companyBankAcconut'/>",{gsbm:gsbm,bz:bz,swiftdm:swiftdm},
				function(result){
					var data = $.map(result, function (obj) {
						obj.id = obj.yhzh;
					    obj.text = obj.yhzh;
					    return obj;
					});
					if(sfLc =="0"){
						$("#form-submit [name=skyhzh]").addClass("skyselect").select2({data:data});
					}else if(sfLc=="1"){
						$("#form-submit [name=lcskyhzh]").addClass("skyselect").select2({data:data});
					}else{
						$("#form-submit [name=skyhzh]").addClass("skyselect").select2({data:data});
						$("#form-submit [name=lcskyhzh]").addClass("skyselect").select2({data:data});
					}
					if(!zhSffz){
						if(respData !={}){
							if(sfLc == "0"){
								$("#form-submit [name=skyhzh]").select2('val',respData.skyhzh) ;
							}
							if(sfLc == "1"){
								$("#form-submit [name=lcskyhzh]").select2('val',respData.lcskyhzh) ;
							}
							if(sfLc == "2"){
								$("#form-submit [name=skyhzh]").select2('val',respData.skyhzh) ;
								$("#form-submit [name=lcskyhzh]").select2('val',respData.lcskyhzh) ;
							}
							zhSffz = true ;
						}
					}
					if(yhSffz && zhSffz){
						respData ={};
					}
			}, "json");
	}
	/******************************银行信息赋值逻辑控制结束************************************************/
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户","value":"khbm"},
			            {"name":"客户类型","value":"khlx"}],
			colModel:[{name:'id', index:'id', label:'ID',hidden:true}, 
			          {name:'khbm', index:'khbm', label:'客户编码', width:80},
		 	          {name:'khmc', index:'khmc', label:'客户名称', width:80}, 
					  {name:'khlx', index:'khlx', label:'客户类型', width:60},
					  {name:'fktjms', index:'fktjms', label:'付款条件', width:120}],
			     url:"<c:url value='/pub/widget/findCustByXsy'/>?xsyid="+$('#form-submit [name=xsyid]').val()
		},{
			callback:function(rows){
				if(rows){
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
					$("input[name=khdz]").val(rows.dz);
					$("input[name=khdh]").val(rows.dh);
					$("input[name=khyx]").val(rows.yx);
					$("input[name=khlxr]").val(rows.lxr);
					$("input[name=khpp]").val(rows.pp);
					$("input[name=fktj]").select2("val",rows.fktj);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
					$("input[name=khdz]").val("");
					$("input[name=khdh]").val("");
					$("input[name=khyx]").val("");
					$("input[name=khlxr]").val("");
					$("input[name=khpp]").val("");
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
					if(e.added){
						$("#form-submit [name=xdLc]").val(e.added.xdLc);
						changeYhxx();
					}
				});
 			}, "json");
	}
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
					/* if(record.xszz == '0105' || record.xszz == '0103'){
						$(grid_selector).setColProp("dj",{editoptions:{disabled:true}});
					}else{
						$(grid_selector).setColProp("dj",{editoptions:{disabled:false}});
					}  */
				}else{
					$("#form-submit [name=xsyid]").val("");
					$("#form-submit [name=xsymc]").val("");
					$("#form-submit [name=xszz]").val("");
					$("#form-submit [name=xszzmc]").val("");
					$("#form-submit [name=ywz]").val("");
					$("#form-submit [name=ywzmc]").val("");
				}
				$("input[name=khbm]").val("");
				$("input[name=khmc]").val("");
				$("input[name=khdz]").val("");
				$("input[name=khdh]").val("");
				$("input[name=khyx]").val("");
				$("input[name=khlxr]").val("");
				$("input[name=fktj]").select2("val","");
				//changeYhxx();
			}
		});
	}
	// PI选择
	function bindPiid(){
		$.tableDialogPage({
			title:"PI选择",
			searchCond:[{"name":"参考PI号","value":"piid"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'id', index:'id', label:'ID',hidden:true},
			          {name:'piid', index:'piid', label:'参考PI号'},
			          {name:'khbm', index:'khbm', label:'客户编码'},
			          {name:'khmc', index:'khmc', label:'客户名称'},
			          {name:'bbh', index:'bbh', label:'参考PI版本号'}],
			url:"<c:url value='/pi/piSample/search'/>"+ "?sfDyhpi=0&pilx=3&zt=5" 
		},{
			callback:function(rows){
				if(rows){
					//2017-10-23若跨销售组织则不允许复制PI
					/* var xszz = $('#form-submit [name=xszz]').val();
					var ywz = $('#form-submit [name=ywz]').val();
					var xszzmc = $('#form-submit [name=xszzmc]').val();
					var ywzmc = $('#form-submit [name=ywzmc]').val(); */
					
					var token =$('#form-submit [name=token]').val();
					var id = $('#form-submit [name=id]').val();
					var piid = $('#form-submit [name=piid]').val();
					var sjc = $('#form-submit [name=sjc]').val();
					var bbh = $('#form-submit [name=bbh]').val();
					var zt = $('#form-submit [name=zt]').val();
					var taskId = $('#form-submit [name=taskId]').val();
					var sfBg = $('#form-submit [name=sfBg]').val();
					var gsbm = $('#form-submit [name=gsbm]').select2('val');
					$("#form-submit").setFormData(rows);
					$("#ckpih").val($("#form-submit [name=piid]").val());
					$("#form-submit [name=oper]").val("add");//权限:add
					$("#form-submit [name=id]").val(id);
					$("#form-submit [name=piid]").val(piid);
					$("#form-submit [name=sjc]").val(sjc);
					$("#form-submit [name=bbh]").val(bbh);
					$('#form-submit [name=taskId]').val(taskId);
					$('#form-submit [name=sfBg]').val(sfBg);
					if(id == null || id.length == 0){
						$("#form-submit [name=zt]").val("1");
					}else {
						$("#form-submit [name=zt]").val(zt);
					}
					$('#form-submit [name=token]').val(token);
					/* $('#form-submit [name=ywz]').val(rows.ywz);
					$('#form-submit [name=ywzmc]').val(rows.ywzmc);
					$('#form-submit [name=xszz]').val(rows.xszz);
					$('#form-submit [name=xszzmc]').val(rows.xszzmc); */
				    $('#form-submit [name=gsbm]').select2("val",gsbm);
				    //参考PI后清空销售员
				    /* $('#form-submit [name=xsyid]').val("");
					$('#form-submit [name=xsymc]').val("");  */
					// 根据参考订单号初始化数据
					$.bindAjax({
						url : "<c:url value='/pi/piSample/findById'/>",
						data : {id : rows.id},
						action : "search"
					},function(response){
						// 型号。付费备损加载
						if(response.piItemList){
							//参考订单时，已下单数量清零
							var data = response.piItemList;
							$.each( data, function(i,v){  
					              v.yxdsl = 0;
					              v.spzsl = 0;
					            }); 
							$(grid_selector).jqGrid("clearGridData");
							$(grid_selector).jqGrid("addRowData", null, data, "last");
						} 
					});
				}else{
					$("#form-submit [name=ckpih]").val("");
				}
			}
		});
	}
	//初始化grid
	function bindGrid(){	
		//已下单
		$(yxd_grid_selector).bindTable({
			caption: "",
			pager: yxd_pager_selector,
			gridParent: "#yxd_grid-parent",
			footerrow:true,
			datatype: "local",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'mxlx', index:'mxlx', label:'行类型', width:80, hidden:true, 
					editoptions:{dataInit: function(elem){$(elem).val("1")}}},
				/* {name:'mxlxmc', index:'mxlxmc', label:'行类型', width:80, 
					editoptions:{disabled:true, dataInit: function(elem){$(elem).val("整机")}}}, */
				{name:'pid', index:'pid', label:'PID', width:100,editoptions : {dataInit : InitPID}},
				{name:'jixing', index:'jixing', label:'Model', width:100,editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadModelOption('1','1')}",dataInit: initSelect2}},
				{name:'jixin', index:'jixin', label:'Chassis', width:80,editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadModelOption('1','0')}",dataInit: initSelect2}}, 
				{name:'khxhms', index:'khxhms', label:'Description', edittype:"textarea", width:80},
				{name:'ks', index:'ks', label:'款式', width:80, editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('KS')}",dataInit: initSelect2}},
				{name:'sl', index:'sl', label:'Quantity', align:'right', width:80,editrules:{integer:true},
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editoptions:{dataInit: initSl}},
			   <shiro:hasPermission name="pi:piSample:price"> 	
				{name:'dj', index:'dj', label:'Unit Price', align:'right', width:80,editrules:{number:true},
					formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6},editoptions:{dataInit: initDj}},
				{name:'je', index:'je', label:'Total Amount', align:'right', width:80,
					formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6},editoptions:{disabled:true}},
			   </shiro:hasPermission> 	
				{name:'yxdsl', index:'yxdsl', label:'已下单数量',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}, 
		    	editoptions:{disabled:true}},
		    	{name:'spzsl', index:'spzsl', label:'审批中数量',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}, 
			    	editoptions:{disabled:true}}
			],
			editTable:false,
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
		//未下单
		$(grid_selector).bindTable({
			caption: "",
			pager: pager_selector,
			gridParent: "#grid-parent",
			footerrow:true,
			datatype: "local",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'mxlx', index:'mxlx', label:'行类型', width:80, hidden:true, 
					editoptions:{dataInit: function(elem){$(elem).val("1")}}},
				/* {name:'mxlxmc', index:'mxlxmc', label:'行类型', width:80, 
					editoptions:{disabled:true, dataInit: function(elem){$(elem).val("整机")}}}, */
				{name:'pid', index:'pid', label:'PID', width:100,editoptions : {dataInit : InitPID}},
				{name:'jixing', index:'jixing', label:'Model', width:100,editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadModelOption('1','1')}",dataInit: initSelect2}},
				{name:'jixin', index:'jixin', label:'Chassis', width:80,editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadModelOption('1','0')}",dataInit: initSelect2}}, 
				{name:'khxhms', index:'khxhms', label:'Description', edittype:"textarea", width:80},
				{name:'ks', index:'ks', label:'款式', width:80, editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('KS')}",dataInit: initSelect2}},
				{name:'sl', index:'sl', label:'Quantity', align:'right', width:80,editrules:{integer:true},
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editoptions:{dataInit: initSl}},
			   <shiro:hasPermission name="pi:piSample:price"> 	
				{name:'dj', index:'dj', label:'Unit Price', align:'right', width:80,editrules:{number:true},
					formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6},editoptions:{dataInit: initDj}},
				{name:'je', index:'je', label:'Total Amount', align:'right', width:80,
					formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6},editoptions:{disabled:true}},
			   </shiro:hasPermission> 	
				{name:'yxdsl', index:'yxdsl', label:'已下单数量',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}, 
		    	editoptions:{disabled:true}},
		    	{name:'spzsl', index:'spzsl', label:'审批中数量',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}, 
			    	editoptions:{disabled:true}}
			],
			gridComplete: function(){
	            sumGrid();
		   	},
			editTable:true,
			editComplete: function(lastEdit, rowData){
				/* if(Number(rowData.sl) < Number(rowData.yxdsl)){//后台过程判断
					swal("", "PI明细数量小于该明细的已下单数量，请重新修改数量!", "warning");
					return false;
				} */
				var xszz = $("#form-submit [name=xszz]").val();//销售员所属部门编码
				if(xszz == '0105'/*  || xszz == '0103' */){
					var dj="";
					dj=selectprice(rowData.mxlx,rowData.pid,rowData.ks,rowData.jixin,rowData.jixing);
					if(dj != "" && dj != "0"){
						$(grid_selector).jqGrid('setRowData', lastEdit, {dj:parseFloat(dj)}); 
						if(rows.sl!='' && rows.sl!=null){
							$(grid_selector).jqGrid('setRowData', lastEdit, {je:parseFloat(rows.sl*dj).toFixed(6)}); 
						}
					} 
				}
				sumGrid();
			}
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			complete:isEdit,
			delfunc:delfunc
		});
	}	
	// 明细删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		// 结束选中行编辑
		$(grid_selector).saveRow(selr, false, 'clientArray');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (rowData.yxdsl > 0 || rowData.spzsl>0) {
				swal("", "已存在下单，不可删除!", "warning");
			}else{
	    		$(grid_selector).jqGrid("delRowData", selr);
	    		$(grid_selector).trigger("reloadGrid");
	    		
			}
		}
	}
	
	//初始化页面数据
	function bindFormData(id){	
		//view or edit
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/pi/piSample/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				respData = response ;
				$("#form-submit").setFormData(response);
				$(grid_selector).jqGrid("clearGridData");
				// 变更草稿编辑时，客户、币种、付款条件、走货方式、PID、生产基地不允许修改
				/* if(response.sfBg == 1){
					$("#form-submit [name=khmc]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit [name=bz]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit [name=fktj]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit [name=zhfs]").prop("disabled","disabled").addClass("skydisabled");
				} */
				// 型号。付费备损加载
				if(response.piItemList){
					var data = response.piItemList;
					var yxdData = [];
					var wxdData = [];
					var flag = false ;
					$.each( data, function(i,v){  
			              if(v.yxdsl>0 || v.spzsl>0){
			            	  flag = true;
			            	  yxdData.push(v);
			              }else{
			            	  wxdData.push(v);
			              }
			            }); 
					if(flag == true){
						//显示已下单的明细grid
						$('.yxd').show();
						$(yxd_grid_selector).jqGrid("addRowData", null, yxdData, "last"); 
						// 部分变更时客户、币种、付款条件、走货方式、公司、国际贸易条款不允许修改
						$("#form-submit [name=gsbm]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=khmc]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=bz]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=fktj]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=zhfs]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=gjmytk]").prop("disabled","disabled").addClass("skydisabled");
					}else{
						$('.yxd').hide();
					}
					$(grid_selector).jqGrid("addRowData", null, wxdData, "last");
					//$(grid_selector).jqGrid("addRowData", null, response.piItemList, "last"); 
				}
				$("#form-submit [name=taskId]").val(taskId);
				$("#form-submit [name=oper]").val("edit");//编辑权限
			});
		}else{
			//初始化页面参数
			//$("#form-submit [name=scjd]").select2("val","2110");//默认为深圳基地
			$("#form-submit [name=id]").val("");//PIID:空
			$("#form-submit [name=pilx]").val("3");//PI类型:样机PI
			$("#form-submit [name=oper]").val("add");//权限:add
			$("#form-submit [name=zt]").val("1");//PI状态:草稿
			$("#form-submit [name=zhfs]").select2("val","3");//走货方式:CBU
			$("#form-submit [name=bz]").select2("val","USD");//币种:USD
			$("#form-submit [name=pimd]").select2("val","2");;//PI目的:Sample
			$("#form-submit [name=bzxx]").val("1.Property of goods belongs to supplier till full payment settled down.\n"+
					"2.International INCOTERMS 2010 specification will be applied for the agreed trade. \n"+
					"3.Disputes arising out of or in connection with this PI shall be submitted to Hong Kong International Arbitration Centre for arbitration in Hong Kong. Laws of Hong Kong shall be applied.\n"+
					"4.The customer request Skyworth to indicate the place of production＂ made in ____＂\n"+
					"5.Quality issues shall be judged and handled according to SKYWORTH's Quality Standard Documents, except otherwise a written agreement between the Parties is concluded.\n");//受益人地址
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
			gsbm : 'required',
			xsymc: 'required',
			khmc : 'required',
			zhfs : 'required',
			pimd : 'required',
			fktj : 'required',
			gjmytk : 'required',
			gjmytkbz : 'required',
			bz     : 'required',
			cylx : 'required',
			yqdhrq1 : 'required',
			 khyx: {
		        email: true
		      }, 
			//yqdhrq3 : 'required'
			//scjd : 'required'
			
		},
		messages: {
			gsbm:'公司编码未填写',
			xsymc:'销售员未填写',
			khmc:'To未填写',
			zhfs:'Format未填写',
			pimd:"Perpose未填写",
			fktj:"Pay Terms未填写",
			gjmytk:"Price Terms未填写",
			gjmytkbz:"Price Terms Remark未填写",
			bz:"Currency未填写",
			cylx:"Shipment未填写",
		    yqdhrq1:"Target Delivery Date未填写",
		    //yqdhrq3 :"recept of days 未填写",
		    khyx:"Email格式不对"
		    //scjd :"生产基地未填写"
		},
        showErrors: function(errorMap, errorList) {
        	var rowNum = $(grid_selector).jqGrid('getGridParam','records');
        	if(rowNum == 0){
        		swal("产品信息为空!");
        		return ;
        	}
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
		// 取产品表数据,先保存明细表再校验
		var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			$(grid_selector).removeData('lastEdit');
		}
		if(!$('#form-submit').valid()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
    	if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		//验证PI有效期必须大于当前日期
		var piyxq = new   Date(Date.parse(param.piyxq.replace(/-/g,"/")));
		if(piyxq <= new Date()){
			swal('','PI有效期必须大于今天！','warning'); 
    		return ;
		}
		if(param.xdLc=="" || !param.xdLc || param.xdLc==null){
			param.xdLc=-1;param.lcskyhzh="" ;
		}
		if(param.xdLc == 1){
			param.skyhzh="" ;
		}
		var data = $(grid_selector).getRowData();
		param.piList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/pi/piSample/edit'/>",
					data:param,
					action:"save"
				},function(response){
 					var result = JSON.parse(response);
 					$('#form-submit [name=token]').val(result.token);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=piid]").val(result.piid);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
				});
			}
		});
	}
	//提交
	function submit(){
		// 取产品表数据,先保存明细表再校验
		var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			$(grid_selector).removeData('lastEdit');
		}
		if(!$('#form-submit').valid()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
		if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		//验证PI有效期必须大于当前日期
		var piyxq = new   Date(Date.parse(param.piyxq.replace(/-/g,"/")));
		if(piyxq <= new Date()){
			swal('','PI有效期必须大于今天！','warning'); 
    		return ;
		}
		var data = $(grid_selector).getRowData();
		param.piList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/pi/piSample/submit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
 					$('#form-submit [name=token]').val(result.token);
 					window.history.back(-1);
				}); 
			}
		});
	}
	
	function sumGrid(){
		var sl;
		var je;
		$(grid_selector).footerData("set",{"khxhms":"合计"}); //合计
		var rowNum = $(grid_selector).jqGrid('getGridParam','records');
		if(rowNum >0 ){
			sl = $(grid_selector).getCol("sl",false,"sum");
			je = $(grid_selector).getCol("je",false,"sum"); 
		}
		$(grid_selector).footerData("set",{"sl":sl, "je":je}); //将合计值显示出来
		// 结束编辑表
		var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			$(grid_selector).removeData('lastEdit');
		}
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
	//初始化PID绑定
	function InitPID(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title:"PID选择",
				searchCond:[{"name":"PID","value":"pid"},
				            {"name":"机芯","value":"jixin"}],
				colModel:[{name:'id', index:'id', label:'ID',hidden:true},
				          {name:'pid', index:'pid', label:'PID'},
				          {name:'jixing', index:'jixing', label:'机型'},
				          {name:'jixin', index:'jixin', label:'机芯'}],
				url:"<c:url value='/mdm/pidInfo/search'/>"
			},{
				callback:function(rows){
					if(rows){
						$(elem).closest("tr.jqgrow").find("[name='jixin']").select2("val",rows.jixin);
						$(elem).closest("tr.jqgrow").find("[name='jixing']").select2("val",rows.jixing);
						$(elem).val(rows.pid);
					}else{
						$(elem).closest("tr.jqgrow").find("[name='jixin']").select2("val","");
						$(elem).closest("tr.jqgrow").find("[name='jixing']").select2("val","");
						$(elem).val("");
					}
				}
			});
		});
	} 

	//价格查询
	function selectprice(mxlx,pid,ks,jixin,jixing){
		var price="";
		var khbm=$("#form-submit [name=khbm]").val();//客户编码
		var zhfs=$("#form-submit [name=zhfs]").val();//走货方式
		var gjmytk=$("#form-submit [name=gjmytk]").val();//国际贸易条款
		var zdsj=$("#form-submit [name=zdsj]").val();//制单时间
		$.ajax({  
		       type: "post",  
		       url: "<c:url value='/price/branchPrice/getPrice'/>", 
		       data:{mxlx:mxlx,gjmytk:gjmytk,khbm:khbm,zhfs:zhfs,pid:pid,ks:ks,jixin:jixin,jixing:jixing,zdsj:zdsj},
		       async:false,  
		       dataType: "json",  
			   success: function(data){ 
				   price = data.dj;
		       }  
		});
		return price; 
	}
	// 初始化编辑表select2
	function initSelect2(elem){
		$(elem).width(140).addClass("skyselect").select2();
	}
	//受益人名称
	function bindSyrmcSelect(){
		$.post("<c:url value='/mdm/companyInfo/selectSyr'/>?type=1",{},
			function(result){
				var data = $.map(result, function (obj) {
					obj.id = obj.syrmc;
			        obj.text = obj.syrmc;	      
			        return obj;
				});
				$("#form-submit [name=syr]").addClass("skyselect").select2({data:data}).on("change",function(e){
				    	
				})
 			}, "json");
	}
	//受益人地址
	function bindSyrdzSelect(){
		$.post("<c:url value='/mdm/companyInfo/selectSyr'/>?type=2",{},
			function(result){
				var data = $.map(result, function (obj) {
					obj.id = obj.syrdz;
			        obj.text = obj.syrdz;	      
			        return obj;
				});
				$("#form-submit [name=syrdz]").addClass("skyselect").select2({data:data}).on("change",function(e){
				    	
				})
 			}, "json");
	}
	/**************************************************function结束区域************************************************/
</script>
</html>