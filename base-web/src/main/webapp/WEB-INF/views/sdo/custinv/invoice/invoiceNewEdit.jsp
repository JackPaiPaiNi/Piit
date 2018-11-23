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
						<!-- 隐藏信息 -->
						<!-- 总数量 -->
						<input type="hidden" name="zsl" />
						<!-- 总金额 -->
						<input type="hidden" name="zje" />
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">发票模板&nbsp;&nbsp;</label>
								<select role="select" name="fpmb" size="1" id="fpmbSel" class="form-control skyselect">
									${fns:loadDictOption('FPMB')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">箱单模板&nbsp;&nbsp;</label>
								<select role="select" name="xdmb" size="1" class="form-control skyselect">
									${fns:loadDictOption('XDMB')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-orderSelect" type="button"
								class="btn btn-purple btn-sm">
								<i class="fa fa-plus icon-on-right bigger-110"></i> 出货信息选择
							</button>
						</div>
						<div class="col-xs-6 col-sm-3">
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-save" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp;
							<button id="btn-submit" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
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
								<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
								<input type="text" name="fph" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">发票日期&nbsp;&nbsp;</label>
								<input type="text" name="fprq" class="form-control date-picker" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">发票状态&nbsp;&nbsp;</label>
								<select role="select" name="zt" size="1" class="form-control skydisabled" disabled="disabled">
									${fns:loadDictOption('FPZT')}
								</select>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
								<textarea name="orderno" rows="3" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">公司信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司名称&nbsp;&nbsp;</label>
								<input type="text" name="gsywmc" class="form-control skydisabled" disabled="disabled" />
								<!-- 公司中文名称 -->
								<input type="hidden" name="gszwmc" />
								<!-- 公司编码 -->
								<input type="hidden" name="gsbm" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司联系电话&nbsp;&nbsp;</label>
								<input type="text" name="gsdh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司地址&nbsp;&nbsp;</label> 
								<input type="text" name="gsdz" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">Sold to Messrs</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
								<input type="text" name="khmc" class="form-control skydisabled" disabled="disabled"/>
								<!-- 客户编码 -->
								<input type="hidden" name="khbm" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户联系电话&nbsp;&nbsp;</label>
								<input type="text" name="khdh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户地址&nbsp;&nbsp;</label>
								<input type="text" name="khdz" class="form-control" />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">Consignee to</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">收货人名称&nbsp;&nbsp;</label> 
								<input type="text" name="shfmc" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">收货人电话&nbsp;&nbsp;</label>
								<input type="text" name="shfdh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">收货人地址&nbsp;&nbsp;</label>
								<input type="text" name="shfdz" class="form-control" />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">Delivery to</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">收货地名称&nbsp;&nbsp;</label> 
								<input type="text" name="shdmc"  class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">收货地电话&nbsp;&nbsp;</label>
								<input type="text" name="shddh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">收货地地址&nbsp;&nbsp;</label>
								<input type="text" name="shddz" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-8"></div>
					<ul class="nav nav-tabs">
						<li class="active"><a href="#jbxx-tab" data-toggle="tab">基本信息</a></li>
						<li><a href="#fpxx-tab" data-toggle="tab">发票明细</a></li>
						<li><a href="#qtfy-tab" data-toggle="tab">箱单明细</a></li>
					</ul>
					<div class="tab-content">
						<!-- 基本信息TAB -->
						<div class="tab-pane fade active in" id="jbxx-tab">
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">起运港&nbsp;&nbsp;</label>
										<input type="text" name="qyg" class="form-control" />
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
										<label class="input-group-addon">贸易条款&nbsp;&nbsp;</label>
										<select role="select" name="mytk" size="1" class="form-control skyselect">
											${fns:loadDictOption('PIGJMYTK')}
										</select>
										<!-- 贸易条款名称 -->
										<input type="hidden" name="mytkmc" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">付款条件&nbsp;&nbsp;</label>
										<input type="text" name="fktj" class="form-control"/>
										<!-- 付款条件名称 -->
										<input type="hidden" name="fktjmc" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船名航次&nbsp;&nbsp;</label>
										<input type="text" name="cmhc" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">起运日期&nbsp;&nbsp;</label>
										<input type="text" name="qyrq" class="form-control date-picker" />
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预计到港日期&nbsp;&nbsp;</label>
										<input type="text" name="yjdgq" class="form-control date-picker" />
										<span class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">提单号&nbsp;&nbsp;</label>
										<input type="text" name="tdh" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">Country Of Origin&nbsp;&nbsp;</label>
										<input type="text" name="ycgj" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">Marks &Nos&nbsp;&nbsp;</label>
										<input type="text" name="marks" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-sm-6 col-sm-12">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">Description&nbsp;&nbsp;</label>
										<textarea name="ms" class="autosize-transition form-control"></textarea>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-sm-6 col-sm-12">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票底部描述&nbsp;&nbsp;</label>
										<textarea name="footer" rows="4" class="autosize-transition form-control"></textarea>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">定金&nbsp;&nbsp;</label>
										<input type="text" name="deposit" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">剩余未收款&nbsp;&nbsp;</label>
										<input type="text" name="tobepaid" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户PO&nbsp;&nbsp;</label>
										<input type="text" name="khpo" class="form-control" />
											
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">走货方式&nbsp;&nbsp;</label>
										<select role="select" name="zhfs" size="1" class="form-control skyselect">
											 ${fns:loadDictOption('ZHFS')}
										</select>
										<!-- 付款条件名称 -->
										<input type="hidden" name="zhfsmc" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出运类型&nbsp;&nbsp;</label>
										<select role="select" name="cylx" size="1" class="form-control skyselect">
											${fns:loadDictOption('CYLX_FP')}
										</select>
										<!-- 出运类型名称 cylxmc -->
										<input type="hidden" name="cylxmc" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款银行名称&nbsp;&nbsp;</label>
										<input type="text" name="skyhmc" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款银行地址&nbsp;&nbsp;</label>
										<input type="text" name="skyhdz" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款银行代码&nbsp;&nbsp;</label>
										<input type="text" name="skyhdm" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款银行账号&nbsp;&nbsp;</label>
										<input type="text" name="skyhzh" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">受益人&nbsp;&nbsp;</label>
										<input type="text" name="syr" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">受益人地址&nbsp;&nbsp;</label>
										<input type="text" name="syrdz" class="form-control" />
									</div>
								</div>
							</div>
						</div>
						<!-- 发票信息TAB -->
						<div class="tab-pane fade" id="fpxx-tab">
							<div class="space-4"></div>
							<div id="grid-parent-fpxx">
								<table id="grid-table-fpxx"></table>
								<div id="grid-pager-fpxx"></div>
							</div>
						</div>
						<!-- 装箱单TAB -->
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
	<input type="hidden" id="ddids" name="ddids">
	<input type="hidden" id="chdhs" name="chdhs">
	
</body>
<script type="text/javascript">
	var isModify=false;
	// 变量定义开始
	//判断是否为第一次选择物料信息
	var isOne=true;
	var id = "<%=id%>";
	var zt = "<%=zt%>";
	var grid_fpxx_selector = "#grid-table-fpxx";
	var pager_fpxx_selector = "#grid-pager-fpxx";
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
		}
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
		// 付款条件初始化
		bindFktjSelect();
		//订单信息选择
		orderSelect();
		// 发票信息编辑表
		bindGridItem();
		// 其他信息编辑表
		bindGridQtfy();
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
	    $("#fpmbSel").change(function(){
	        //要触发的事件
	    	fpmbValueChange();
	       });
  		// 提交
		$("#btn-submit").click(function(){
			submit();
	    });
	});
	/**************************************************function开始区域************************************************/
	//取付款条件
	function bindFktjSelect(){
		$.post("<c:url value='/pub/select2/selectPayTerm'/>",{},
			function(result){
				var data = $.map(result, function (obj) {
					obj.id = obj.fktjdm;
			        obj.text = obj.fktjdm + "-" + obj.fktjms;	      
			        return obj;
				});
				$("#form-submit [name=fktj]").addClass("skyselect").select2({data:data});
 			}, "json");
	}
	// 订单选择 fpmb
	function orderSelect(){
		$("#btn-orderSelect").click(function(){
			if($("#form-submit [name=fpmb]").val() == ""){
				swal("","请先选择发票模板！","warning");
				return;	
			}
			var width = 900;
			var height = 600;
			var left = (window.screen.width-width)/2;
			var top = (window.screen.height-height)/2;
			var pageUrl = "<c:url value='/custinv/custinv/loadingCabinetList'/>?fpmb="+$("#form-submit [name=fpmb]").val();
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
	var orders=[];
	function formatOrders(data){
		for (var i = 0; i < data.length; i++) {
			var fal=true;
			for (var j = 0; j < orders.length; j++) {
				if(data[i].ddid==orders[j]){
					fal=false;
					break;
				}
			}
			if(fal){
				orders.push(data[i].ddid);
			}
		}
		var orderNo="";
		for (var i = 0; i < orders.length; i++) {
			orderNo+=orders[i];
			if(i<orders.length-1){
				orderNo+="\n";
			}
		}
		$("#form-submit [name=orderno]").val(orderNo);
	}
	
	
	//初始化订单出货明细信息
	function initOrderData(data){
		var chdhs = "";
		var ddids = "";
		var  flag=true;
		ddids = data[data.length-1].ddid;
		chdhs = data[data.length-1].chdh;
		var chxxArray = [];
		if($("#form-submit [name=fpmb]").val()== 3){
			$.each(data, function(i, value){
				var isExists = false;
				var chxx = value.chdh + "|" + value.ddid;
				$.each(chxxArray, function(index, n){
					if(n == chxx){
						isExists = true;
						return false;
					}
				});
				if(!isExists){
					chxxArray.push(chxx);
				}
			});
		}
		$.bindAjax({
			url : "<c:url value='/custinv/custinv/searchCustinv'/>",
			data : {
				p_chdh:chdhs,
				p_ddid:ddids,
				p_chxx:chxxArray.join(",")
			},
			action : "search"
		},function(response){
			if($("#form-submit [name=fpmb]").val()==3){
				if(response.fpList!=null&&response.fpList!= undefined){
					$(grid_fpxx_selector).jqGrid("addRowData", null,response.fpList, "last");
				}
			}
			if(isOne && id=="null"){
				var vo=response.vo;
				$("#form-submit [name=fph]").val(vo.fph);
				$("#form-submit [name=fprq]").val(vo.fprq);
				$("#form-submit [name=gsbm]").val(vo.gsbm);
				$("#form-submit [name=gszwmc]").val(vo.gszwmc);
				$("#form-submit [name=gsywmc]").val(vo.gsywmc);
				$("#form-submit [name=gsdz]").val(vo.gsdz);
				$("#form-submit [name=khbm]").val(vo.khbm);
		 		$("#form-submit [name=khmc]").val(vo.khmc);
		 		$("#form-submit [name=khdh]").val(vo.khdh);
		 		$("#form-submit [name=khdz]").val(vo.khdz);
		 		$("#form-submit [name=shfmc]").val(vo.shfmc);
		 		$("#form-submit [name=shfdz]").val(vo.shfdz);
		 		$("#form-submit [name=shfdh]").val(vo.shfdh);
		 		$("#form-submit [name=shdmc]").val(vo.shdmc);
		 		$("#form-submit [name=shddz]").val(vo.shddz);
		 		$("#form-submit [name=shddh]").val(vo.shddh);
		 		$("#form-submit [name=qyg]").val(vo.qygmc);
		 		$("#form-submit [name=mdg]").val(vo.mdg);
		 	    $("#form-submit [name=mytk]").select2("val",vo.mytk);
		 		$("#form-submit [name=mytkmc]").val(vo.mytkmc);
		 		$("#form-submit [name=fktj]").select2("val",vo.fktj);
				$("#form-submit [name=fktjmc]").val(vo.fktjmc);
				$("#form-submit [name=cmhc]").val(vo.cmhc);
				$("#form-submit [name=qyrq]").val(vo.qyrq);
				$("#form-submit [name=yjdgq]").val(vo.yjdgq);
				$("#form-submit [name=zhfs]").select2("val",vo.zhfs);
				$("#form-submit [name=zhfsmc]").val(vo.zhfsmc);
		 		$("#form-submit [name=cylx]").select2("val",vo.cylx);
				$("#form-submit [name=cylxmc]").val(vo.cylxmc);
				$("#form-submit [name=skyhzh]").val(vo.skyhzh);
				$("#form-submit [name=skyhmc]").val(vo.skyhmc);
				$("#form-submit [name=skyhdz]").val(vo.skyhdz);
				$("#form-submit [name=skyhdm]").val(vo.skyhdm);
				$("#form-submit [name=syr]").val(vo.syr);
				$("#form-submit [name=syrdz]").val(vo.syrdz);
			}
			// 加载发票明细
		});
		//柜号  出货单号  订单号  zgdsn
		formatOrders(data);
		loadInvoiceMx(data);
		
	}
	//加载发票箱单明细
	function loadInvoiceMx(data){
		var xdData = $(grid_qtfy_selector).jqGrid("getGridParam", "data"); 
		for (var i = 0; i < data.length; i++) {
			var flagX=true;
			for (var j = 0; j < xdData.length; j++) {
				if(data[i].guino==xdData[j].guino && data[i].chdh==xdData[j].chdh && data[i].ddid==xdData[j].chdh && data[i].zgdsn==xdData[j].chdh){
					flagX=false;
					break;
				}
			}
		}
		if(flagX){
			$(grid_qtfy_selector).jqGrid("addRowData", null,data, "last");
			var rowsD = $(grid_qtfy_selector).jqGrid("getGridParam", "data"); 
			$(grid_qtfy_selector).setGridParam({data: rowsD}).trigger('reloadGrid');
			if($("#form-submit [name=fpmb]").val()!=3){
				$(grid_fpxx_selector).jqGrid("addRowData", null,data, "last");
				var rowsD = $(grid_fpxx_selector).jqGrid("getGridParam", "data"); 
				$(grid_fpxx_selector).setGridParam({data: rowsD}).trigger('reloadGrid');
			}
		}
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
			rowNum:20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'fph', index:'fph', hidden: true, label:'发票号', width:80, editable:false},
				{name:'chdh', index:'chdh', hidden: true, label:'出货单号', width:60, editable:false},
				{name:'ddid', index:'ddid', label:'Job No.',width:90, editable:false},
				{name:'wlbh', index:'wlbh', label:'Part No.', width:90, editable:false},
				{name:'wlms', index:'wlms', label:'DESCRIPTION', width:80, editable:false},
				{name:'hscode', index:'hscode', label:'HS CODE', width:80, editable:false},
				{name:'sl', index:'sl', label:'QTY',editable:false, width:80,formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'dw', index:'dw', label:'UNIT', width:80, editable:false},
				{name:'zxzwet', index:'zxzwet', label:'TTL NET WEIGHT (KG)', width:80,
					align:'right', editable:false,formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces:6}},
				{name:'dj', index:'dj', label:'UNIT PRICE(USD)', width:80,
					align:'right', editable:false,formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces:6}},
				{name:'je', index:'je', label:'AMOUNT (USD)', editable:false,  width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces:6}},
				{name:'khlh', index:'khlh', label:'BRIC PART NUMBER', width:80, editable:false},
				{name:'khms', index:'khms', label:'BRIC DESCRIPTION', width:80, editable:false},
				{name:'gysmc', index:'gysmc', label:'MANUFACTURER NAME', width:150, editable:false},
				{name:'gysdz', index:'gysdz', label:'MANUFACTURER ADDRESS', width:250, editable:false},
				{name:'ycgj', index:'ycgj', label:'ORIGINAL OF COUNTRY', width:250, editable:false},
				{name:'spmc', index:'spmc', label:'Description', width:250,editable:false},
				{name:'khxh', index:'khxh', label:'Model No.', width:250, editable:false}
			],
			footerrow:true,
			gridComplete: function(){
				sumfpGrid();
		   	},
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
	}
	
	//初始化装箱单grid
	function bindGridQtfy(){
		$(grid_qtfy_selector).bindTable({
			caption: "",
			pager: pager_qtfy_selector,
			gridParent: "#grid-parent-qtfy",
			datatype: "local",
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'chdh', label:'chdh', hidden: true, width:60, editable:false},
				{name:'fph', index:'fph', label:'发票号',  width:60, hidden: true, editable:false},
				{name:'guino', index:'guino', label:'柜号',  width:80, editable:false},
				{name:'gxnam', index:'gxnam', label:'柜型', width:60, editable:false},
				{name:'ftno', index:'ftno', label:'封条号', width:60, editable:false},
				{name:'kbno', index:'kbno', label:'卡板号',width:60, editable:false},
				{name:'boxno', index:'boxno', label:'箱编号',width:60, editable:false},
				{name:'ddid', index:'ddid', label:'订单号',  width:60, editable:false},
				{name:'wlbh', index:'wlbh', label:'物料编号',width:60, editable:false},
				{name:'wlms', index:'wlms', label:'物料描述',width:60, editable:false},
				{name:'khxh', index:'khxh', label:'客户型号', width:60, editable:false},
				{name:'dgjz', index:'dgjz', label:'单个净重', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'sfqty', index:'sfqty', label:'实发数',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'dw', index:'dw', label:'单位', width:60, editable:false},
				{name:'ddqty', index:'ddqty', label:'订单数',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'bsqty', index:'bsqty', label:'1%备损数',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'dj', index:'dj', label:'单价', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'ddje', index:'ddje', label:'订单金额', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'bsje', index:'bsje', label:'备损金额', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'gszjh', index:'gszjh', label:'创维组件号', width:60, editable:false},
				{name:'gszjms', index:'gszjms', label:'创维组件描述',  width:60, editable:false},
				{name:'gszjsl', index:'gszjsl', label:'创维组件数量',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'dxsl', index:'dxsl', label:'单箱数量',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'zxmz', index:'zxmz', label:'单箱毛重', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'zxjz', index:'zxjz', label:'单箱净重', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'zxnum', index:'zxnum', label:'箱数', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'zxzmz', index:'zxzmz', label:'箱总毛重', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'zxzjz', index:'zxzjz', label:'箱总净重', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'zxC', index:'zxC', label:'纸箱长cm', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'zxK', index:'zxK', label:'纸箱宽cm', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'zxG', index:'zxG', label:'纸箱高cm', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'kbC', index:'kbC', label:'卡板长cm', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'kbK', index:'kbK', label:'卡板宽cm', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'kbG', index:'kbG', label:'卡板高cm', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'kbnum', index:'kbnum', label:'卡板数',align:'right', width:50, formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'kbwet', index:'kbwet', label:'每卡板重量', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'kbzwet', index:'kbzwet', label:'卡板总重量', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'sumzv', index:'sumzv', label:'总体积', align:'right',width:60,formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'ycgj', index:'ycgj', label:'原产国家',  width:60, editable:false},
				{name:'pono', index:'pono', label:'p.o.no.',  width:60, editable:false},
				{name:'gysmc', index:'gysmc', label:'供应商名称', width:60, editable:false},
				{name:'khlh', index:'khlh', label:'客户料号',  width:60, editable:false},
				{name:'khms', index:'khms', label:'客户描述',  width:60, editable:false},
				{name:'hscode', index:'hscode', label:'hs code', hidden: true, width:60, editable:false},
				{name:'zgdsn', index:'zgdsn', label:'zgdsn', hidden: true, width:60, editable:false},
				{name:'erdat', index:'erdat', label:'erdat', hidden: true, width:60},
				{name:'ertim', index:'ertim', label:'ertim', hidden: true, width:60},
				{name:'chdat', index:'chdat', label:'chdat', hidden: true, width:60},
				{name:'cftno', index:'cftno', label:'cftno', hidden: true, width:60}
			],
			footerrow:true,
			gridComplete: function(){
				sumGrid();
		   	},
			editTable:false
		},{
			add:false,
			edit:false,
			del:false,
			complete:false
		});
	}
	// 计算发票合计行
	function sumfpGrid(){
		var sl=0;
		var je=0;
		$(grid_fpxx_selector).footerData("set",{"ddid":"共计"}); //合计
		var rowsD = $(grid_fpxx_selector).jqGrid("getGridParam", "data"); 
		for(var i=0;i<rowsD.length;i++){
			sl += parseFloat(rowsD[i].sl); 
			je += parseFloat(rowsD[i].je);
		}
		$(grid_fpxx_selector).footerData("set",{"sl":sl, "je":je}); //将合计值显示出来
	}
	
	// 计算合计行
	function sumGrid(){
		var zxnum=0;
		var bsje=0;
		var bsqty=0;
		var ddqty=0;
		var ddje=0;
		var kbnum=0;
		var sumzv=0;
		var zxzjz=0;
		var kbzwet=0;
		var sfqty=0;
		$(grid_qtfy_selector).footerData("set",{"guino":"总计"}); //合计
		var rowsD = $(grid_qtfy_selector).jqGrid("getGridParam", "data"); 
		for(var i=0;i<rowsD.length;i++){
			zxnum += parseFloat(rowsD[i].zxnum); 
			sfqty += parseFloat(rowsD[i].sfqty);
			ddje += parseFloat(rowsD[i].ddje); 
			kbnum += parseFloat(rowsD[i].kbnum);
			sumzv += parseFloat(rowsD[i].sumzv); 
			zxzjz += parseFloat(rowsD[i].zxzjz);
			kbzwet += parseFloat(rowsD[i].kbzwet); 
			bsje += parseFloat(rowsD[i].bsje); 
			bsqty += parseFloat(rowsD[i].bsqty);
			ddqty += parseFloat(rowsD[i].ddqty); 
		}
		$(grid_qtfy_selector).footerData("set",{"sfqty":sfqty,"ddqty":ddqty,"zxnum":zxnum,"kbnum":kbnum,"ddje":ddje,"sumzv":sumzv,"zxzjz":zxzjz,"kbzwet":kbzwet,"bsje":bsje,"bsqty":bsqty}); //将合计值显示出来
	}
	
	//下拉框 发票模板值改变
	function fpmbValueChange(){
		$(grid_fpxx_selector).clearGridData();
		$(grid_qtfy_selector).clearGridData();
		if($("#form-submit [name=fpmb]").val()==""){
			return;
		}else if($("#form-submit [name=fpmb]").val()=="3"){
			//阿根廷发票模板      showCol   hideCol
			isModify=true;
			//显示列
			$(grid_fpxx_selector).showCol(["ddid","spmc","khxh","dw","sl","dj","je"]);
			//隐藏列
			$(grid_fpxx_selector).hideCol(["wlbh","wlms","hscode","zxzwet","khlh","khms","gysmc","gysdz","ycgj"]);
			//是否允许编辑列
		}else if($("#form-submit [name=fpmb]").val()=="1" || $("#form-submit [name=fpmb]").val()=="2"){
			//欧洲、巴西 发票模板      showCol   hideCol
			//显示列
			$(grid_fpxx_selector).showCol(["ddid","wlbh","wlms","hscode","sl","dw","zxzwet","dj","je","khlh","khms","gysmc","gysdz","ycgj"]);
			//隐藏列
			$(grid_fpxx_selector).hideCol(["khxh","spmc"]);
			//是否允许编辑列
		}
	}
	
	
	//初始化页面数据
	function bindFormData(id){
		//view or edit
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/custinv/custinv/findById'/>",
				data : {
					id : id
				},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				// 加载发票明细
				$("#form-submit [name=oper]").val("edit");//编辑
				$(grid_fpxx_selector).clearGridData(); 
				$(grid_fpxx_selector).setGridParam({data: response.custInvItems}).trigger('reloadGrid');
				//加载箱单信息
				$(grid_qtfy_selector).clearGridData();
				$(grid_qtfy_selector).setGridParam({data: response.custInvPackings}).trigger('reloadGrid');
				formatOrders(response.custInvPackings);
			});
		}else{
			//初始化页面参数
			$("#form-submit [name=oper]").val("add");//权限:add
			$("#form-submit [name=zt]").val("1");//PI状态:草稿
			$("#form-submit [name=marks]").val("N/M");
			$("#form-submit [name=ycgj]").val("CHINA");
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
			fprq : 'required',
			qyrq : 'required',
			yjdgq : 'required',
			bz    : 'required',
			mytk: 'required',
			sjfpzje: {required:true, number:true}
		},
		messages: {
			fph : '发票号不能为空！',
			fplx : '发票类型不能为空！',
			kpfs : '开票方式不能为空！',
			fprq : '发票日期不能为空！',
			qyrq : '起运日期不能为空！',
			yjdgq : '预计到港日期不能为空！',
			bz    : '币种不能为空！',
			mytk: '贸易条款不能为空！',
			sjpfzje:'实际发票总金额不能为空,且必须为数字！'
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
		var param = $("#form-submit").getFormData();
		//编辑表结束编辑    grid_fpxx_selector
		var lastEdit = $(grid_qtfy_selector).data('lastEdit');
		if(lastEdit){
			$(grid_qtfy_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var itemData = $(grid_qtfy_selector).jqGrid("getGridParam", "data"); 
		param.packingListStr = JSON.stringify(itemData);
		var lastEdit = $(grid_fpxx_selector).data('lastEdit');
		if(lastEdit){
			$(grid_fpxx_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var packingData = $(grid_fpxx_selector).jqGrid("getGridParam", "data");
		param.itemListStr = JSON.stringify(packingData);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			 callback:function(){
				$.bindAjax({
					url:"<c:url value='/custinv/custinv/save'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
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
		var qtfyData = $(grid_qtfy_selector).jqGrid("getGridParam", "data");
		param.qtList = JSON.stringify(qtfyData);
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/custinv/custinv/submit'/>",
					data:{
						id:$("#form-submit [name=id]").val(),
						sjc:$("#form-submit [name=sjc]").val()
					},
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
		
	}
	
	/**************************************************function结束区域************************************************/
</script>
</html>