<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
   <%
		String id = request.getParameter("id");
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
					<input type="hidden" name="id"   /> 
					<input type="hidden" name="oper" />
					<input type="hidden" name="sjc" />
					<input type="hidden" name="sfBg"/> 
					<input type="hidden" name="bbh" />
					<input type="hidden" name="taskId" />
					<input type="hidden" name="cysfbl" />
					<input type="hidden" name="cwsfcl" />
					<input type="hidden" name="jfsfsp" />
					<input type="hidden" name="cwzyid" />
					<input type="hidden" name="cwzymc" />
					<input type="hidden" name="yssfcq" />
					<input type="hidden" name="sfChehui"/>
					<input type="hidden" name="token" value="${token}" />
					<div class="row" style="margin: 0px 8px;">
						<button id="btn-back" type="button" class="btn btn-sm">
							<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
						&nbsp;
						<button id="btn-save" type="button" class="btn btn-success btn-sm">
							<i class="icon-save icon-on-right bigger-110"></i> 保存
						</button>
						&nbsp;
						<button id="btn-submit" type="button" class="btn btn-info btn-sm">
							<i class="icon-ok icon-on-right bigger-110"></i> 提交
						</button>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">参考预走货单号&nbsp;&nbsp;</label> 
								<input type="text" name="ckyzhdh" onfocus="this.blur()" class="form-control parent-node">
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
							    </span>
							    <span id="cksc" class="input-group-addon" style="cursor:pointer;">
									<i class="fa fa-times red"></i>
								</span>
							</div>
						</div>
					</div>
					<!-- <div class="space-4 approveSelect"></div>
					<div class="row approveSelect" style="margin: 0px 8px;display:none" >
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">船务处理分支：&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline">
										<input type="radio" name="sfRestart1" class="skyradio" value="restart">重新审核
									</label>
									<label class="radio-inline">
										<input type="radio" name="sfRestart1" checked="checked" class="skyradio" value="continue">继续审核
									</label>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">业务&财务处理分支：&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline">
										<input type="radio" name="sfRestart2" class="skyradio" value="restart">重新审核
									</label>
									<label class="radio-inline">
										<input type="radio" name="sfRestart2" class="skyradio" checked="checked" value="continue">继续审核
									</label>
								</div>
							</div>
						</div>
					</div> -->
					<div class="space-4 approveSelect"></div>
					<div class="row approveSelect cyblSelect" style="margin: 0px 8px;display:none" >
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">储运是否补录：&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline">
										<input type="radio" name="sfCybl" class="skyradio" value="1">是
									</label>
									<label class="radio-inline">
										<input type="radio" name="sfCybl" checked="checked" class="skyradio" value="0">否
									</label>
								</div>
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">表头信息</h5>
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
								<label class="input-group-addon">公司&nbsp;&nbsp;</label>
								<input type="hidden" name="gsbm" />
								<input type="text" name="gsmc" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label> 
								<input type="text" name="yzhdh"  class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">预走货类型&nbsp;&nbsp;</label>
								<select role="select" name="yzhlx" size="1" value="1" class="form-control skydisabled" disabled="disabled">
									${fns:loadDictOption('YZHLX')}
								</select>
							</div>
						</div>
						
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">是否代收代付运费&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline"> 
									   <input type="radio" name="sfDsdfyf" id="yes" class="skyradio" value="1">是
									</label>
								    <label class="radio-inline"> 
								        <input type="radio" name="sfDsdfyf" id="no" class="skyradio" checked="checked" value="0">否
									</label>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户&nbsp;&nbsp;</label>
								<input type="hidden" name="khbm" />
								<input type="text" name="khmc" class="form-control skydisabled" disabled="disabled" />
							</div>
					   </div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
								<input type="hidden" name="xsyid" />
								<input type="text" name="xsymc" class="form-control skydisabled" disabled="disabled" />
							</div>
					    </div>
					    <div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
								<input type="hidden" name="ywz" />
								<input type="text" name="ywzmc" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
						
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">销售组织&nbsp;&nbsp;</label>
								<input type="hidden" name="xszz" />
								<input type="text" name="xszzmc" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div> 
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
								<input type="hidden" name="zdrid"/>
							    <input type="text" name="zdrmc" class="form-control skydisabled" disabled = "disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">制单时间&nbsp;&nbsp;</label> <input
									type="text" name="zdsj"
									class="form-control date-picker skydisabled"
									disabled="disabled" /> <span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
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
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">海外供应链&nbsp;&nbsp;</label>
								<select role="select" name="hwgyl" size="1" class="form-control skyselect">
									${fns:loadDictOption('HWGYL')}
								</select>
							</div>
						</div>
					</div>
					<div class="space-8"></div>
					<ul class="nav nav-tabs">
						<li class="active"><a href="#zhmx-tab" data-toggle="tab">走货订单\费用明细</a></li>
						<li><a href="#bcxx-tab" data-toggle="tab">补充信息</a></li>
						<li><a href="#cwxx-tab" data-toggle="tab">船务信息</a></li>
						<li><a href="#tdshxx-tab" data-toggle="tab">提单人/收货人信息</a></li>
					</ul>
					<div class="tab-content">
						<!-- 走货明细信息 -->
						<div class="tab-pane fade active in" id="zhmx-tab">
						 	<h5 class="header blue" style="margin-top: 4px;"><!-- 出货明细[有订单] -->
								<button id="btn-ddSelect" type="button" class="btn btn-purple btn-sm" >
									<i class="fa fa-plus icon-on-right"></i>
									订单选择
								</button>
							</h5>
							<div class="row" style="margin: 0px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">主体预走货单号&nbsp;&nbsp;</label> 
										<input 	type="text" name="ztyzhdh"  class="form-control ">
										<span class="input-group-addon">
									    	<i class="icon-search bigger-110"></i>
								        </span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">付款条件&nbsp;&nbsp;</label>
										<input type="hidden" name="fktj" />
										<input type="text" name="fktjmc" class="form-control skydisabled " disabled="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">贸易条款&nbsp;&nbsp;</label> 
										<select
											role="select" name="mytk" size="1" class="form-control skyselect "  >
											${fns:loadDictOption('PIGJMYTK')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜时间&nbsp;&nbsp;</label> <input
											type="text" name="zgsj" class="form-control date-picker " />
										<span class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">挂架：&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline"> <input type="radio"
												name="bzyqGj" id="yes" class="skyradio" value="1">箱内包装
											</label> <label class="radio-inline"> <input type="radio"
												name="bzyqGj" id="no" class="skyradio" checked="checked"
												value="0">箱外独立包装
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">底座：&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline"> 
											  <input type="radio"	name="bzyqDz" id="yes" class="skyradio" value="1">箱内包装
											</label> 
											<label class="radio-inline">
											 <input type="radio" name="bzyqDz" id="no" class="skyradio" checked="checked" value="0">箱外独立包装
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">卡板包装：&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline"> <input type="radio"
												name="bzyqBzkb" id="yes" class="skyradio" value="1">带
											</label> <label class="radio-inline"> <input type="radio"
												name="bzyqBzkb" id="no" class="skyradio" checked="checked"
												value="0">不带
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">卡板备注：&nbsp;&nbsp;</label>
									   <input
											type="text" name="kbbz" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">有无木质包装：&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline"> <input type="radio"
												name="bzyqMzbz" id="yes" class="skyradio" value="1">有
											</label> <label class="radio-inline"> <input type="radio"
												name="bzyqMzbz" id="no" class="skyradio" checked="checked"
												value="0">没有
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px;">
								<div class="col-sm-6 col-sm-12">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
										<textarea name="bzxx" class="autosize-transition form-control"></textarea>
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
							<div class="space-4"></div>
							<div id="grid-parent-item">
								<table id="grid-table-item"></table>
								<div id="grid-pager-item"></div>
							</div>
							<div class="space-4"></div>
							<h5 class="header blue" style="margin-top: 4px;">PI信息（请保证预走货订单行项目的金额=PI信息中相同订单的汇总金额）</h5>
							<div id="grid-parent-pi">
								<table id="grid-table-pi"></table>
								<div id="grid-pager-pi"></div>
							</div>
							<div id ="fymx">
								<div class="space-4"></div>
								<h5 class="header blue" style="margin-top: 4px;">费用明细</h5>
								<div id="grid-parent-other">
									<table id="grid-table-other"></table>
									<div id="grid-pager-other"></div>
								</div>
							</div>
							<h5 class="header blue" style="margin-top: 4px;">用柜/车要求</h5>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">总柜数&nbsp;&nbsp;</label> 
										<input type="text" id="ygZgs" name="ygZgs" class="form-control skydisabled" disabled ="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">20'GP&nbsp;&nbsp;</label>
										<input type="text" id="yg20gp" name="yg20gp"   class="form-control skydisabled" disabled ="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">40'GP&nbsp;&nbsp;</label> 
										<input type="text" id="yg40gp"  name="yg40gp"   class="form-control skydisabled" disabled ="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">40'HQ&nbsp;&nbsp;</label>
								        <input type="text" id="yg40hq"  name="yg40hq"   class="form-control skydisabled" disabled ="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">柜数备注&nbsp;&nbsp;</label>
									    <input 	type="text" name="ygGsbz" class="form-control skydisabled" disabled ="disabled" />
									</div>
								</div>
							</div>
							<h5 class="header blue" style="margin-top: 4px;">吨车要求</h5>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">总车数&nbsp;&nbsp;</label> 
										<input type="text" id="dcZcs" name="dcZcs" class="form-control skydisabled" disabled ="disabled"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										 <label class="input-group-addon">3吨&nbsp;&nbsp;</label> 
										 <input type="text" id="dc3d" class="form-control skydisabled" name="dc3d" disabled ="disabled"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										 <label class="input-group-addon">5吨&nbsp;&nbsp;</label> 
										 <input type="text" id="dc5d" class="form-control skydisabled" name="dc5d" disabled ="disabled"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">8吨&nbsp;&nbsp;</label> 
										<input type="text" id="dc8d" class="form-control skydisabled" name="dc8d" disabled ="disabled"/>
									</div>								
								</div>
								<div class="col-xs-6 col-sm-2">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">10吨&nbsp;&nbsp;</label> 
											<input type="text" id="dc10d" class="form-control skydisabled" name="dc10d" disabled ="disabled"/>
										</div>
								</div>
								<div class="col-xs-6 col-sm-2">
								    <div class="input-group input-group-sm">
									    <label class="input-group-addon">12吨&nbsp;&nbsp;</label> 
										<input type="text" id="dc12d" class="form-control skydisabled" name="dc12d" disabled ="disabled"/>
								    </div>
								</div>
							</div>
						</div>
						<!--补充信息 -->
						<div class="tab-pane fade" id="bcxx-tab">
							<div class="row" style="margin: 0px 8px;">
								<div class="row" style="margin: 0px 8px;">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">跟单备损&nbsp;&nbsp;</label>
										<textarea name="bcGdbs" rows="4"
											class="autosize-transition form-control"></textarea>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="row" style="margin: 0px 8px;">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">SPO备损&nbsp;&nbsp;</label>
										<textarea name="bcSpobs" rows="4"
											class="autosize-transition form-control"></textarea>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="row" style="margin: 0px 8px;">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">文件要求&nbsp;&nbsp;</label>
										<textarea name="bcWjyq" rows="4"
											class="autosize-transition form-control"></textarea>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="row" style="margin: 0px 8px;">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜要求&nbsp;&nbsp;</label>
										<textarea name="bcZgyq" rows="4"
											class="autosize-transition form-control"></textarea>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="row" style="margin: 0px 8px;">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">其他备注&nbsp;&nbsp;</label>
										<textarea name="bcQt" rows="4"
											class="autosize-transition form-control"></textarea>
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
								<div class="col-xs-6 col-sm-6">
									<div id="fjxx">
										<ul class="list-unstyled spaced"></ul>
									</div>
									<div id="multiFileQueue"> </div>
								</div>
						   </div>
						</div>
						<!--船务信息 -->
						<div class="tab-pane fade" id="cwxx-tab">
						    <h5 class="header blue" style="margin-top: 4px;">出运信息</h5>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出运类型&nbsp;&nbsp;</label>
										 <select
											role="select" name="cylx" size="1" class="form-control skyselect ">
											${fns:loadDictOption('CYLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">起运港&nbsp;&nbsp;</label> 
										<select role="select" name="qyg" id="qyg" size="1" class="form-control skyselect ">
											${fns:loadDictOption('QYG')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">起运港备注&nbsp;&nbsp;</label> <input
											type="text" name="qygbz" id="qygbz" class="form-control skydisabled" disabled ="disabled"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">中转港&nbsp;&nbsp;</label> <input
											type="text" name="zzg" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
							<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">目的港&nbsp;&nbsp;</label> <input
											type="text" name="mdg" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">目的国家&nbsp;&nbsp;</label> <select
											role="select" name="xwgj" size="1" class="form-control skyselect ">
											${fns:loadCountryOption('0')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否需要验货&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline"> 
											<input type="radio" name="sfXyyh" id="yes" class="skyradio" value="1">是
											</label> <label class="radio-inline"> 
											<input type="radio" name="sfXyyh" id="no" class="skyradio" checked="checked" value="0">否
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预计验货日期&nbsp;&nbsp;</label>
										 <input type="text" name="yjyhrq" id="yjyhrq" class="form-control date-picker skydisabled"  disabled ="disabled"/>
										<span class="input-group-addon"> <i
											class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<h5 class="header blue" style="margin-top: 4px;">船代公司信息</h5>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">编码&nbsp;&nbsp;</label> 
										<input type="text" name="cdgsbm" onfocus="this.blur()"class="form-control  parent-node" /> 
										<span class="input-group-addon"> 
											<i class="icon-search bigger-110"></i>
										</span>
								    </div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">联系人&nbsp;&nbsp;</label> <input
											type="text" name="cdgslxr" class="form-control skydisabled" disabled="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">电话&nbsp;&nbsp;</label> <input
											type="text" name="cdgsdh" class="form-control skydisabled" disabled="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">邮箱&nbsp;&nbsp;</label> <input
											type="text" name="cdgsyx" class="form-control skydisabled" disabled="disabled" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">传真&nbsp;&nbsp;</label> <input
										type="text" name="cdgscz" class="form-control skydisabled" disabled="disabled" />
								</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">邮编&nbsp;&nbsp;</label> <input
											type="text" name="cdgsyb" class="form-control skydisabled" disabled="disabled" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">名称&nbsp;&nbsp;</label> <input
											type="text" name="cdgsmc" class="form-control skydisabled" disabled="disabled" />
									</div>
								</div>
							</div>
						    <div class="space-4"></div>
							<h5 class="header blue" style="margin-top: 4px;">快递信息</h5>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">快递类型&nbsp;&nbsp;</label>
											<input type="text" name="kdlx" class="form-control skydisabled" disabled ="disabled"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">快递公司&nbsp;&nbsp;</label> 
										<input type="text" name="kd" class="form-control skydisabled" disabled ="disabled"/>
	
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">快递备注&nbsp;&nbsp;</label> 
										<input type="text" name="kdbz" class="form-control skydisabled" disabled="disabled">
									</div>
								</div>
							</div>
							<h5 class="header blue" style="margin-top: 4px;">额外运费信息</h5>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
							    <div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">费用承担主体&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline">
												<input type="radio" class="skyradio" name="yfcd" value="1" >客户承担
											</label>
											<label class="radio-inline">
												<input type="radio" class="skyradio" name="yfcd" value="0" >我司承担
											</label>
											<label class="radio-inline">
												<input type="radio" class="skyradio" name="yfcd" value="2" checked="checked">无
											</label>
										</div>
									</div>
							    </div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">运费承担类型&nbsp;&nbsp;</label> 
										<select role="select" name="yflx" size="1" class="form-control skyselect ">
											${fns:loadDictOption('YFLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">到付账户&nbsp;&nbsp;</label> 
										<input type="text" name="dfzh" class="form-control  ">
									</div>
								</div>
							</div>
						</div>
						<!--收货人通知人信息 -->
						<div class="tab-pane fade" id="tdshxx-tab">
						    <h5 class="header blue" style="margin-top: 4px;">收货人信息[CONSIGNEE]</h5>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收货人代码&nbsp;&nbsp;</label> 
										<input type="text"  name="shfdm"  class="form-control  ">
									</div>
								</div>
								<div class="col-xs-3 col-sm-3">
									<div class="form-control">
										<label class="checkbox-inline">
											<input type="checkbox" class="skycheckbox" id="chk_shfmc">指定收货人为TO ORDER
										</label>
									</div>
								</div>
							 	<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收货人名称&nbsp;&nbsp;</label> 
										<input type="text"  name="shfmc"  class="form-control  ">
									</div>
								</div>
								<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收货人电话&nbsp;&nbsp;</label> 
										<input type="text"  name="shrdh"  class="form-control  ">
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收货人地址&nbsp;&nbsp;</label> 
										<input type="text"  name="shfdz"  class="form-control  ">
									</div>
								</div>
								<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">AEO企业编码&nbsp;&nbsp;</label> 
										<input type="text"  name="aeoqybm"  class="form-control  ">
									</div>
								</div>
							 	<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">具体联络人&nbsp;&nbsp;</label> 
										<input type="text"  name="shflxr"  class="form-control  ">
									</div>
								</div>
								<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">具体联络人电话&nbsp;&nbsp;</label> 
										<input type="text"  name="shfdh"  class="form-control  ">
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">传真&nbsp;&nbsp;</label> 
										<input type="text"  name="shfcz"  class="form-control  ">
									</div>
								</div>
							 	<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">邮编&nbsp;&nbsp;</label> 
										<input type="text"  name="shfyb"  class="form-control  ">
									</div>
								</div>
								<div class="col-xs-3 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">邮箱&nbsp;&nbsp;</label> 
										<input type="text"  name="shfyx"  class="form-control  ">
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<h5 class="header blue" style="margin-top: 4px;">提单通知人信息[NOTIFY PARTY]</h5>
							<div class="row" style="margin: 0px 8px;">
								<div class="col-xs-12 col-sm-12">
									<div id="grid-parent-notify">
										<table id="grid-table-notify"></table>
										<div id="grid-pager-notify"></div>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
						</div>
						<!-- 审批日志 -->
					    <div class="space-4"></div>
					    <h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
					    <div class="space-4"></div>
					    <c:import url="/pub/showLog/orderProductPso" charEncoding="UTF-8" />
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
	<!-- /.page-content -->
<!-- 	<span class="loading-indicator"> 
		<label> <i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
	</span> -->
</body>
<script type="text/javascript">
    var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	// 出货明细[有订单]
	var grid_selector_item = "#grid-table-item";
	var pager_selector_item = "#grid-pager-item";
	// 出货明细[PI] 
	var grid_selector_pi = "#grid-table-pi";
	var pager_selector_pi = "#grid-pager-pi";
	// 费用明细
	var grid_selector_other = "#grid-table-other";
	var pager_selector_other = "#grid-pager-other";
	// 提单通知人信息
	var grid_selector_notify = "#grid-table-notify";
	var pager_selector_notify = "#grid-pager-notify";
	
	var isEdit = false;
	<shiro:hasPermission name="pso:tvPso:edit">isEdit = true;</shiro:hasPermission>
	/******************************页面控件加载开始***************************************************/
	$(function($) {
		if(taskId != "null"){
			$('.approveSelect').show();
			$("#btn-save").prop("disabled","disabled");
		}
		$(".date-picker").bindDate();
		$('.skyselect').select2();
		// 快递类型
		getKdlxInfo();
		// 订单明细
		initItmeGrid();
		// PI明细
		initPiGrid();
		// 费用明细
		initOtherGrid();
		// 提单通知人信息
		initNotifyGrid();
		// 参考预走货单号选择
		bindYzhdh();
		// 绑定主体预走货单号
		bindZtyzh();
		// 附件上传控件
		fjUpload();
		// 选择change事件
		bindChangeEvent();
		// 船代公司选择
		$("#form-submit [name=cdgsbm]").parent().click(function(){
			bindCdgsbm();
		});
		// 页面按钮事件绑定
	    bindButtonEvent();
		// 初始化表单数据
	    initFormDataByid(id);
		// 数据校验
	    validate();
	});
	/*******************functions start*********************************/
	// 初始化出货明细[有订单]grid
	function initItmeGrid(){
		$(grid_selector_item).bindTable({
			caption : "",
			pager : pager_selector_item,
			footerrow:true,
			gridParent : "#grid-parent-item",
			shrinkToFit : false,
			autoScroll : false,
			pgbuttons: false,
			pginput: false,
			//rowList: [],
			rowNum:50,
			recordtext: "",
			colModel : [ {name : 'id',label : 'ID',width : 60, hidden : true, editable : false,frozen:true} ,
			             {name : 'ddid',label : 'ddid',hidden:true,frozen:true} ,
			             {name : 'ddlink',index : 'ddlink',label : '订单号', editable : false,width : 80,formatter:ddxx,frozen:true},
			             {name : 'jixing',index : 'wsxh',label : '我司型号',width : 70,frozen:true},
			             {name : 'khxhms',index : 'khxhms',label : '客户型号描述',editable:false,width : 80},
			             {name : 'jixin',index : 'jixin',label : '机芯',editable:false,width : 70},
				         {name : 'chfl',index : 'chfl',label : '出货分类',editable : true,edittype:"select",formatter:"select", 
						  editoptions:{value:"${fns:loadDictEditOption('CHFL')}",dataInit: initSelect2/*initChfl*/},width : 120},
						 {name : 'spmc',index : 'spmc',label : '商品名称',width : 160},
						 {name : 'pp',index : 'pp',label : '品牌',/* editable:false, */width : 80,editoptions:{dataInit: initPP}},
						 {name:'pplx', index:'pplx', label:'品牌类型', width:140, editoptions:{disabled:true}},
						 {name:'ckxhqk', index:'ckxhqk', label:'出口享惠情况',edittype:"select",formatter:"select", 
							  editoptions:{value:"${fns:loadDictEditOption('CKXHQK')}", dataInit:initSelect2},width : 100},
			             {name : 'sl',index : 'sl',label : '数量',width : 80,align:'right',
							 formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},editoptions:{dataInit: initSl}},
			             {name : 'mfjsl',index : 'mfjsl',label : '免费机数量',width : 80,align:'right',
			            	 formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
			            <shiro:hasPermission name="pso:tvPso:price">{name : 'dj',index : 'dj',label : '单价',width : 80,align:'right',
							 formatter:'number',formatoptions:{thousandsSeparator: ',', decimalPlaces: 6}, editrules:{number:true},editoptions:{dataInit: initDj}},
						 {name : 'ffbsje',index : 'ffbsje',label : '付费备损金额',width : 80,align:'right',
								 formatter:'number',formatoptions:{thousandsSeparator: ',', decimalPlaces: 4}, editrules:{number:true},editoptions:{dataInit: initFfbsje}},
					/* 	 {name : 'ce',index : 'ce',label : '误差金额',width : 80,align:'right',
							 formatter:'number',formatoptions:{thousandsSeparator: ','}, editrules:{number:true},editoptions:{readonly:true}}, */
						 {name : 'je',index : 'je',label : '金额',width : 80,align:'right',
								 formatter:'number',formatoptions:{thousandsSeparator: ',', decimalPlaces: 6}, editrules:{number:true}},</shiro:hasPermission>
					     {name : 'bz',index : 'bz',label : '币种',editable:false, width:50},
						 {name : 'cc',index : 'cc',label : '尺寸',width : 50,align:'right',editoptions:{readonly:true}}, 
			             {name : 'zhfs',index : 'zhfs',hidden:true },
			             {name : 'zhfsmc',index : 'zhfsmc',label : '走货方式',editable:false, width : 50},
						 {name : 'js',index : 'js',hidden:true,label : '件数',width : 80, align:'right',
							 formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}}, 
						 {name : 'ddyqjhrq',index : 'ddyqjhrq',editable:false,label : '订单要求交货日期',width : 120,formatter : 'date',
						  formatoptions : {newformat : 'Y-m-d'}}, 
						 {name : 'ggmx',hidden:true,width : 80}, 
						 {name : 'ggmxmc',index : 'ggmxmc',label : '规格明细',width : 100,editoptions:{readonly:true}},
						 {name : 'cpfl',hidden:true,width : 80}, 
						 {name : 'cpflmc',index : 'cpflmc',label : '产品分类',width : 100,editoptions:{readonly:true}},
						 <shiro:hasPermission name="pso:tvPso:price">{name : 'pdj',index : 'pdj',label : '屏单价',width : 80,align:'right',
							 formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},</shiro:hasPermission>
						 {name : 'ppp',index : 'ppp',label : '屏品牌',width : 80},
						 {name : 'pxh',index : 'pxh',label : '屏型号',width : 80},
						 {name : 'pbh',index : 'pbh',editable:false,label : '屏编码',width : 80},
						 {name : 'gtin',index : 'gtin',label : 'GTIN码',width : 100},
						 {name : 'cas',index : 'cas',label : 'CAS码',width : 100},
						 {name : 'dsjlx',index : 'dsjlx',label : '电视机类型',width : 100,edittype:"select",formatter:"select",
							 editoptions:{value:"${fns:loadDictEditOption('DSJLX')}", dataInit:initSelect2}},
						 {name : 'pid',index : 'pid',label : 'PID',width : 100,editable:false},
						 {name : 'zhm',index : 'zhm',label : '走货码',width : 100,editable : true,edittype:"select",formatter:"select",
							 editoptions:{value:"${fns:loadDictEditOption('ZHM')}", dataInit:initSelect2}},
						 {name : 'version',index : 'version',label : '版本号',width : 100,editable : true,edittype:"select",formatter:"select",
							 editoptions:{value:"${fns:loadDictEditOption('VERSION')}", dataInit:initSelect2}},
						 {name : 'bs',index : 'bs',label : '标识号',width : 100,edittype:"select",formatter:"select",
							 editoptions:{value:"${fns:loadDictEditOption('BS')}", dataInit:initSelect2}},	 
						 {name : 'versionmc',index : 'versionmc',label : '版本号名称',width : 100,hidden:true},
						 {name : 'bsmc',index : 'bsmc',label : '标识号名称',width : 100,hidden:true},
						 {name : 'dsjlxmc',index : 'dsjlxmc',label : '电视机类型',width : 100,hidden:true},
						 {name : 'bzxx',index : 'bzxx',label : '备注信息',width : 160},
						 {name : 'ddlx',index :'ddlx',hidden:true} ,
						 {name : 'ddlxmc',index :'ddlxmc',hidden:true},
						 {name : 'gsbm',index :'gsbm',hidden:true},
						 {name : 'khbm',index :'khbm',hidden:true},
						 {name : 'xsyid',index :'xsyid',hidden:true},
						 {name : 'scjd',index :'scjd',hidden:true} 
					],
			editTable : true,
			gridComplete: function(){
				sumItem();
		   	},
		   	editComplete:function(lastEdit,rowData){
				sumItem();
		   	}
		}, {
			add : false,
			edit : isEdit,
			del : isEdit,
			complete:isEdit
		}).jqGrid('setFrozenColumns');
	}
	//初始化订单查看链接
	function ddxx(cellvalue, options, rowData){
	    var href = "<a onclick='javascript:showDdxx(\""+rowData.ddid+"\""+");' >"+rowData.ddid+"</a>";
		return  href ;
	}
	//打开订单查看界面
	function showDdxx(ddid){
		var url = "" ;
    	//大货
		url = "<c:url value='/order/orderProduct/viewPageByDh'/>" + "?ddid=" + ddid;
		if(url.length >  0){
			 window.open(url); 
		} 
	}
	// 初始化编辑表商品名称 = 规格明细名称 + 尺寸 +出货分类
	function initChfl(elem){
		$(elem).on("blur", function(){
			var chfl = $(elem).find("option:selected").text();
			var cc = $(elem).closest("tr.jqgrow").find("[name='cc']").val();
			var ggmxmc = $(elem).closest("tr.jqgrow").find("[name='ggmxmc']").val();
			var spmc = "";
			if(chfl != "" && cc != "" && ggmxmc != ""){
				spmc = ggmxmc + cc + chfl;
			}
			$(elem).closest("tr.jqgrow").find("[name='spmc']").val(spmc);
		});
		$(elem).width(140).addClass(".skyselect").select2();
	}
	// 初始化编辑表数量*单价+付费备损金额+差额=金额
	function initSl(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).val();
			var dj = $(elem).closest("tr.jqgrow").find("[name='dj']").val();
			var ffbsje = $(elem).closest("tr.jqgrow").find("[name='ffbsje']").val();
			//var ce = $(elem).closest("tr.jqgrow").find("[name='ce']").val();
			var je = "";
			if(sl != "" && dj != "" && ffbsje != ""){
				je = sl * dj + parseFloat(ffbsje) /* + parseFloat(ce)*/; 
			}
			$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(6));
		});
	}
	//初始化单价
	function initDj(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).closest("tr.jqgrow").find("[name='sl']").val();
			var dj = $(elem).val();
			var ffbsje = $(elem).closest("tr.jqgrow").find("[name='ffbsje']").val();
			//var ce = $(elem).closest("tr.jqgrow").find("[name='ce']").val();
			var je = "";
			if(sl != "" && dj != "" && ffbsje != ""){
				je = sl * dj + parseFloat(ffbsje) /* + parseFloat(ce) */;
			}
			$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(6));
		});
	}
	//初始化品牌
	/*
	境内自主品牌：COOCAA,SKYWORTH,光韵达
	境内收购品牌:METZ
	境外品牌(其他）:BOE，CHIMEI
	境外品牌（贴牌生产）:非以上值且非无非空
	其它品牌：无 或 空*/
	function initPP(elem){
		$(elem).on("blur", function(){
			var pp = $(elem).closest("tr.jqgrow").find("[name='pp']").val();
			var pplx = "";
			pp = pp.toUpperCase();
			if(pp == "COOCAA" || pp == "SKYWORTH" || pp == "光韵达"){
				pplx = "境内自主品牌";
			}else if(pp == "METZ"){
				pplx = "境内收购品牌";
			}else if(pp == "BOE" || pp == "CHIMEI"){
				pplx = "境外品牌(其他）";
			}else if(pp == "" || pp == "无"){
				pplx = "其他品牌";
			}else{
				pplx = "境外品牌（贴牌生产）";
			}
			$(elem).closest("tr.jqgrow").find("[name='pplx']").val(pplx);
		});
	}
	//初始化付费备损金额
	function initFfbsje(elem){
		$(elem).on("blur", function(){
			$.bindAjax({
				url : "<c:url value='/pso/tvPso/queryDdxx'/>",
				data : {ddid : $(elem).closest("tr.jqgrow").find("[name='ddid']").val(),
						yzhlx :1},
				action : "search"
			},function(response){
				 if($(elem).val() > response.items[0].ffbsje){
					 swal("","订单："+response.items[0].ddid+"的付费备损金额不能大于原来的值！","warning");
					 $(elem).closest("tr.jqgrow").find("[name='ffbsje']").val(response.items[0].ffbsje);
				 }else{
						var sl = $(elem).closest("tr.jqgrow").find("[name='sl']").val();
						var ffbsje = $(elem).val();
						var dj = $(elem).closest("tr.jqgrow").find("[name='dj']").val();
						//var ce = $(elem).closest("tr.jqgrow").find("[name='ce']").val();
						var je = "";
						if(sl != "" && dj != "" && ffbsje != ""){
							je = sl * dj + parseFloat(ffbsje) /* + parseFloat(ce) */;
						}
						$(elem).closest("tr.jqgrow").find("[name='je']").val(je.toFixed(6)); 
				 }
			});
		});
	}
	// 计算订单金额数量合计行
	function sumItem(){
		var sl;
		var je;
		var ffbsje;
		$(grid_selector_item).footerData("set",{"jixing":"合计"}); //合计
		var rowNum = $(grid_selector_item).jqGrid('getGridParam','records');
		if(rowNum >=0 ){
			 sl = $(grid_selector_item).getCol("sl",false,"sum"); 
			 je = $(grid_selector_item).getCol("je",false,"sum"); 
			 ffbsje = $(grid_selector_item).getCol("ffbsje",false,"sum"); 
		}
		$(grid_selector_item).footerData("set",{"sl":sl, "je":je, "ffbsje":ffbsje}); //将合计值显示出来
	}
	// PI明细
	function initPiGrid(){
		$(grid_selector_pi).bindTable({
			caption : "",
			pager : pager_selector_pi,
			gridParent : "#grid-parent-pi",
			footerrow:true,
			shrinkToFit : false,
			autoScroll : false,
			pgbuttons: false,
			pginput: false,
			//rowList: [],
			rowNum:50,
			recordtext: "",
			colModel : [ 
			             {name : 'id',label : 'ID',hidden : true,width : 60,editable : false} ,
			             {name : 'ddid',index : 'ddid',label : '订单号', editable : false, width : 80},
			             {name : 'ddlx',index : 'ddlx',label : '订单类型', hidden : true, width : 80},
			             {name : 'ddlxmc',index : 'ddlxmc',label : '订单类型', hidden : true, width : 80},
			             {name : 'piid',index : 'piid',label : 'PI号', hidden : true, width : 80},
			             {name : 'pilx',index : 'pilx',label : 'PI号', hidden : true, width : 80},
			             {name : 'pilink',index : 'pilink',label : 'PI号',editable : false,width : 80,formatter:pixx},
			             {name : 'pilxmc',index : 'pilxmc',label : 'PI类型', width : 80, editable : false},
						 {name : 'bz',index : 'bz',label : '币种',editable:false,width : 80},
						 <shiro:hasPermission name="pso:tvPso:price">{name : 'je',index : 'je',label : '金额',width : 80,align:'right',
							 formatter:'number',formatoptions:{thousandsSeparator: ',', decimalPlaces: 6}}</shiro:hasPermission>
						 ],
			editTable : true,
			gridComplete: function(){
				sumpi();
		   	},
		   	editComplete:function(lastEdit,rowData){
				sumpi();
		   	}
		}, {
			add  : false,
			edit : isEdit,
			del  : isEdit,
			complete : isEdit
		});
	}
	//初始化PI查看链接
	function pixx(cellvalue, options, rowData){
		 var href = "" ;
		 if(rowData.piid){
			 href = "<a onclick='javascript:showPixx(\""+rowData.piid+"\""+");' >"+rowData.piid+"</a>";
		 }
		return  href ;
	}
	//打开PI查看界面
	function showPixx(piid){
		var url = "" ;
    	//大货
		url = "<c:url value='/pi/pi/viewPageByDh'/>" + "?piid=" + piid;
		if(url.length >  0){
			 window.open(url); 
		} 
	}
	// 计算出货明细[无订单]合计行
	function sumpi(){
		var je;
		$(grid_selector_pi).footerData("set",{"ddid":"合计"}); //合计
		var rowNum = $(grid_selector_pi).jqGrid('getGridParam','records');
		if(rowNum >= 0){
			 je = $(grid_selector_pi).getCol("je",false,"sum"); 
		}
		$(grid_selector_pi).footerData("set",{"je":je}); //将合计值显示出来
	}
	// 初始化费用明细
	function initOtherGrid(){
		$(grid_selector_other).bindTable({
			caption : "",
			pager : pager_selector_other,
			gridParent :"#grid-parent-other",
			footerrow:true,
			shrinkToFit : false,
			autoScroll : false,
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			colModel : [ 
			    {name : 'id',label : 'ID',hidden : true,width : 200,editable : true},
			    {name : 'qtxm',index : 'qtxm',label : '费用项目',editable : true,edittype:"select",formatter:"select", 
				 editoptions:{value:"${fns:loadDictEditOption('QTFYXM')}"},width : 180},
				{name :  'bz',index : 'bz',label : '币种',editable : true,edittype:"select", formatter:"select", 
				 editoptions:{value:"${fns:loadDictEditOption('BZ')}"}},
				{name : 'yt',index : 'yt',label : '用途',width : 180},
				<shiro:hasPermission name="pso:tvPso:price">{name : 'je',index : 'je',label : '金额',width : 180,align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},</shiro:hasPermission>
				{name : 'skdh',index : 'skdh',label : '收款单号',width : 370} 
			],
			editTable : true,
			gridComplete: function(){
				sumItemOther();
		   	},
		   	editComplete:function(lastEdit,rowData){
				sumItemOther();
		   	}
		}, {
			add : isEdit,
			edit : isEdit,
			del : isEdit
		});
	}
	// 计算其他费用明细合计行
	function sumItemOther(){
		var je;
		$(grid_selector_other).footerData("set",{"yt":"合计"}); //合计
		var rowNum = $(grid_selector_other).jqGrid('getGridParam','records');
		if(rowNum >=0 ){
			je = $(grid_selector_other).getCol("je",false,"sum"); 
		}
		$(grid_selector_other).footerData("set",{"je":je}); //将合计值显示出来
	}
	//提单通知人信息明细表
	function initNotifyGrid(){
		$(grid_selector_notify).bindTable({
			caption : "",
			pager : pager_selector_notify,
			gridParent : "#grid-parent-notify",
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			datatype:"local",
			colModel : [ 
				 {name : 'tzfdm',index : 'tzfdm',label : '通知方代码',width : 120},
				 {name : 'tzfdh',index : 'tzfdh',label : '通知方电话',width : 120},
				 {name : 'tzrmc',index : 'tzrmc',label : '公司名称',width : 120},
				 {name : 'tzrlxr',index: 'tzrdz',label : '联系人',width :120},
				 {name : 'tzrdh',index : 'tzrdz',label : '电话',width : 120},
				 {name : 'tzrcz',index : 'tzrdz',label : '传真',width : 120},
				 {name : 'tzryb',index : 'tzrdz',label : '邮编',width : 120},
				 {name : 'tzryx',index : 'tzrdz',label : '邮箱',width : 120}, 
				 {name : 'tzrdz',index : 'tzrdz',label : '地址',width : 300}
				],
			editTable : true,
			editComplete: function(lastEdit, rowData){
				if(lastEdit){
					$(grid_selector_notify).saveRow(lastEdit, false, 'clientArray');
					$(grid_selector_notify).removeData('lastEdit');
				}
			}
			
		}, {
			add : isEdit,
			edit : isEdit,
			del : isEdit
		});
		
		$(grid_selector_notify).navButtonAdd(pager_selector_notify,{
			caption:"复制收货人", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
			  var rowData={};
			  if($("#form-submit [name=shfmc]").val()){
				  rowData.tzrmc=$("#form-submit [name=shfmc]").val();
				  rowData.tzrdz=$("#form-submit [name=shfdz]").val();
				  rowData.tzrlxr=$("#form-submit [name=shflxr]").val();
				  rowData.tzrdh=$("#form-submit [name=shfdh]").val();
				  rowData.tzryx=$("#form-submit [name=shfyx]").val();
				  rowData.tzrcz=$("#form-submit [name=shfcz]").val();
				  rowData.tzryb=$("#form-submit [name=shfyb]").val();
				  rowData.tzfdm=$("#form-submit [name=shfdm]").val();
				  rowData.tzfdh=$("#form-submit [name=shrdh]").val();
			      $(grid_selector_notify).jqGrid("clearGridData");
			  	  $(grid_selector_notify).jqGrid("addRowData", null,rowData,"last");
			  	  $(grid_selector_notify).removeData('lastEdit');
			  }
			},
			position:"last"
		});
	}
	
	function bindChangeEvent(){
		// 是否需要验货change事件
		$("#form-submit [name='sfXyyh']").on('change', function(){
		   if($(this).val()==0){
			   $('#yjyhrq').val("")
			   $('#yjyhrq').attr('disabled','disabled');
		   }else{
			   $('#yjyhrq').removeProp('disabled').removeAttr('disabled');
		   }
	    });
		// 起运港change事件
		$('#form-submit [name=qyg]').on('change',function(e){
			if(e.val != 4 ){
				$('#form-submit [name=qygbz]').val("")
				$('#form-submit [name=qygbz]').attr('disabled','disabled');
			}else{
				$('#form-submit [name=qygbz]').removeProp('disabled').removeAttr('disabled');
			}
	    });
		// 是否代收代付运费change事件
		$('#form-submit [name=sfDsdfyf]').on('change',function(){
			if($(this).val() == 0 ){
				$(grid_selector_other).jqGrid("clearGridData");
				$("#fymx").hide().children("div").hide();
			}else{
				$(grid_selector_other).jqGrid("clearGridData");
				$("#fymx").show().children("div").show();
			}
	    });
		// 出运类型change事件
		$('#form-submit [name=cylx]').on('change',function(e){
			  if(e.val != 4 ){
				  $('#form-submit [name=kdlx]').select2("val","");
			      $('#form-submit [name=kd]').select2("val","");
			      $('#form-submit [name=kdbz]').val("");
				  $('#form-submit [name=kdlx]').attr('disabled','disabled');
			      $('#form-submit [name=kd]').attr('disabled','disabled');
			      $('#form-submit [name=kdbz]').attr('disabled','disabled');
			  }else{
				  $('#form-submit [name=kdlx]').removeAttr('disabled');
			      $('#form-submit [name=kd]').removeAttr('disabled');
			      $('#form-submit [name=kdbz]').removeAttr('disabled');
			  }
		 });
		// 指定收货人为TO ORDER
		$('#chk_shfmc').change(function() {
			 if($("#chk_shfmc").is(":checked")){
				 $('#form-submit [name=shfmc]').val("TO ORDER");
				 $('#form-submit [name=shfmc]').addClass("skydisabled").attr('disabled','disabled');
				 $("#form-submit [name=shfdm]").rules("remove", "required");
				 $("#form-submit [name=shfdm]").closest('.input-group').removeClass('has-error');
				 $("#form-submit [name=shrdh]").rules("remove", "required");
				 $("#form-submit [name=shrdh]").closest('.input-group').removeClass('has-error');
				 $("#form-submit [name=shfdz]").rules("remove", "required");
				 $("#form-submit [name=shfdz]").closest('.input-group').removeClass('has-error');
				 $("#form-submit [name=shflxr]").rules("remove", "required");
				 $("#form-submit [name=shflxr]").closest('.input-group').removeClass('has-error');
				 $("#form-submit [name=shfdh]").rules("remove", "required");
				 $("#form-submit [name=shfdh]").closest('.input-group').removeClass('has-error');
			 }else{
				 $('#form-submit [name=shfmc]').val("");
				 $('#form-submit [name=shfmc]').removeClass("skydisabled").removeAttr('disabled');
				 $("#form-submit [name=shfdm]").rules("add", {required: true});
				 $("#form-submit [name=shrdh]").rules("add", {required: true});
				 $("#form-submit [name=shfdz]").rules("add", {required: true});
				 $("#form-submit [name=shflxr]").rules("add", {required: true});
				 $("#form-submit [name=shfdh]").rules("add", {required: true});
			 }
		});
	}
	
	//取船代公司select2信息
// 	function getCdgsInfo(){
// 		$.post("<c:url value='/pub/select2/shippingCompany'/>",{},
// 			function(result){
// 				var data = $.map(result, function (obj) {
// 			       obj.id = obj.gsbm || obj.gsmc;
// 			       obj.text =  obj.gsbm ;		      
// 			       return obj;
// 			     });
// 				$("#form-submit [name=cdgsbm]").addClass("skyselect").select2({data:data}).on("change",function(e){
// 					if(e.added){
// 						$("#form-submit [name=cdgsbm]").val(e.added.gsbm);
// 						$("#form-submit [name=cdgsmc]").val(e.added.gsmc);
// 						$("#form-submit [name=cdgslxr]").val(e.added.lxr);
// 						$("#form-submit [name=cdgsdh]").val(e.added.dh);
// 						$("#form-submit [name=cdgsyx]").val(e.added.yx);
// 						$("#form-submit [name=cdgscz]").val(e.added.cz);
// 						$("#form-submit [name=cdgsyb]").val(e.added.yb);
// 					}
// 				  });
// 		}, "json");
// 	}
	
	//船代公司选择框
	function bindCdgsbm(){
		$.tableDialogPage({
			title:"船代公司选择",
			searchCond:[{"name":"船代公司编码","value":"gsbm"},
			            {"name":"船代公司名称","value":"gsmc"}],
			colModel:[{name:'gsbm', index:'gsbm', label:'船代公司编码', width:60},
					  {name:'gsmc', index:'gsmc', label:'船代公司名称', width:100}],
			url:"<c:url value='/mdm/shippingCompany/search'/>"
		},{
			callback:function(rows){
				if(rows.gsbm == 'GS000'){
					$('#form-submit [name=cdgsbm]').removeAttr('disabled');
					$('#form-submit [name=cdgsmc]').removeAttr('disabled');
					$('#form-submit [name=cdgslxr]').removeAttr('disabled');
					$('#form-submit [name=cdgsdh]').removeAttr('disabled');
					$("#form-submit [name=cdgsyx]").removeAttr('disabled');
					$("#form-submit [name=cdgscz]").removeAttr('disabled');
					$("#form-submit [name=cdgsyb]").removeAttr('disabled');
					//$("#form-submit [name=cdgsbm]").val("");
					$("#form-submit [name=cdgsbm]").val(rows.gsbm);
					$("#form-submit [name=cdgsmc]").val("");
					$("#form-submit [name=cdgslxr]").val("");
					$("#form-submit [name=cdgsdh]").val("");
					$("#form-submit [name=cdgsyx]").val("");
					$("#form-submit [name=cdgscz]").val("");
					$("#form-submit [name=cdgsyb]").val("");
				}else{
					$("#form-submit [name=cdgsbm]").val(rows.gsbm);
					$("#form-submit [name=cdgsmc]").val(rows.gsmc);
					$("#form-submit [name=cdgslxr]").val(rows.lxr);
					$("#form-submit [name=cdgsdh]").val(rows.dh);
					$("#form-submit [name=cdgsyx]").val(rows.yx);
					$("#form-submit [name=cdgscz]").val(rows.cz);
					$("#form-submit [name=cdgsyb]").val(rows.yb);
					$('#form-submit [name=cdgsmc]').attr('disabled','disabled');
					$('#form-submit [name=cdgslxr]').attr('disabled','disabled');
					$('#form-submit [name=cdgsdh]').attr('disabled','disabled');
					$("#form-submit [name=cdgsyx]").attr('disabled','disabled');
					$("#form-submit [name=cdgscz]").attr('disabled','disabled');
					$("#form-submit [name=cdgsyb]").attr('disabled','disabled');
				}
			}
		});
	}
	
	//取快递类型select2信息
	function getKdlxInfo(){
		$.post("<c:url value='/pub/select2/dict'/>",{type : "KDLX"},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.code || obj.name;
			       obj.text =  obj.name ;		      
			       return obj;
			     });
				$("#form-submit [name=kdlx]").addClass("skyselect").select2({data:data}).on("change",function(e){
					if(e.added){
						$.post("<c:url value='/pub/select2/dict'/>",{type : getKdType($("#form-submit [name=kdlx]").val())},
								function(result){
									var data = $.map(result, function (obj) {
								       obj.id = obj.code || obj.name;
								       obj.text =  obj.name ;		      
								       return obj;
								     });
								$("#form-submit [name=kd]").addClass("skyselect").select2({data:data});
						}, "json")
					};
				  });
		}, "json");
	}
	// 取快递select2
	function selectKd(type){
		$.post("<c:url value='/pub/select2/dict'/>",{type : getKdType(type)},
				function(result){
					var data = $.map(result, function (obj) {
				       obj.id = obj.code || obj.name;
				       obj.text =  obj.name ;		      
				       return obj;
				     });
				$("#form-submit [name=kd]").addClass("skyselect").select2({data:data});
		}, "json")
	}
	//绑定参考预走货单号
	function bindYzhdh(){
        $("#form-submit [name=ckyzhdh]").click(function(){
        	$.tableDialogPage({
    			title:"参考预走货单号选择",
    			searchCond:[{"name":"客户","value":"khmc"},
    			            {"name":"销售员","value":"xsymc"},
    			            {"name":"预走货单号","value":"yzhdh"},
    			            {"name":"发起人","value":"zdrid"},
    			            {"name":"业务组","value":"ywz"}
    			            ],
    			colModel:[{name:'id', index:'id', label:'ID',hidden:true},
    			          {name:'yzhdh', index:'yzhdh', label:'预走货单号'},
    			          {name:'khbm', index:'khbm', label:'客户编码'},
    			          {name:'khmc', index:'khmc', label:'客户名称'},
    			          {name:'xsymc', index:'xsymc', label:'销售员名称'},
    			          {name:'ywzmc', index:'ywzmc', label:'业务组名称'},
    			          {name:'bbh', index:'bbh', label:'版本号'},
    			          ],
    			      	url:"<c:url value='/pso/tvPso/search'/>"  +"?yzhlx=1&zt=5"
    		},{
    			callback:function(rows){
    				if(rows){
    					initValue(rows.id);
    				}else{
    					  $("#form-submit [name=ckyzhdh]").val("");
    				}
    			}
    		});
		});
        $('#cksc').click(function(){
			if($("#form-submit [name=ckyzhdh]").val() != ""){
				$("body").bindSweetAlert({
					title : "确定要清空参考吗?",
					closeOnConfirm: true
				}, {
					callback : function() {
						initFormDataByid(id);
						$("#form-submit [name=ckyzhdh]").val("");
					}
				});
			}
		});
	}
	//根据参考预走货单号填充页面内容
	function initValue(id){
		$.bindAjax({
			url : "<c:url value='/pso/tvPso/findById'/>",
			data : {id : id},
			action : "search"
		},function(response){
			 $('#form-submit [name=ckyzhdh]').val(response.yzhdh);
			 $('#form-submit [name=gsbm]').select2("val",response.gsbm);
		     $('#gsmc').val(response.gsmc);
		 	 $('#form-submit [name=khbm]').val(response.khbm);
			 $('#form-submit [name=khmc]').val(response.khmc);
			 $('#form-submit [name=xsyid]').val(response.xsyid);
			 $('#form-submit [name=xsymc]').val(response.xsymc);
			 $('#form-submit [name=xszz]').val(response.xszz);
			 $('#form-submit [name=xszzmc]').val(response.xszzmc);
			 $('#form-submit [name=ywz]').val(response.ywz);
			 $('#form-submit [name=ywzmc]').val(response.ywzmc);
			 $('#form-submit [name=bcGdbs]').val(response.bcGdbs);
			 $('#form-submit [name=bcSpobs]').val(response.bcSpobs);
			 $('#form-submit [name=bcWjyq]').val(response.bcWjyq);
			 $('#form-submit [name=bcZgyq]').val(response.bcZgyq);
			 $('#form-submit [name=bcQt]').val(response.bcQt);
			 $('#form-submit [name=cylx]').select2("val",response.cylx);
			 $('#form-submit [name=kdlx]').select2("val",response.kdlx);
			 $('#form-submit [name=kd]').select2("val",response.kd);
			 $('#form-submit [name=kdbz]').val(response.kdbz);
			 $('#form-submit [name=qyg]').select2("val",response.qyg);
			 $('#form-submit [name=qygbz]').val(response.qygbz);
			 $('#form-submit [name=mdg]').val(response.mdg);
			 $('#form-submit [name=xwgj]').select2("val",response.xwgj);
			 $('#form-submit [name=yjyhrq]').val(response.yjyhrq);
			 $('#form-submit [name=tdshrxx]').val(response.tdshrxx);
			 $('#form-submit [name=tdtzrxx]').val(response.tdtzrxx);
			 $('#form-submit [name=cdgsbm]').val(response.cdgsbm);
			 $('#form-submit [name=cdgsmc]').val(response.cdgsmc);
			 $('#form-submit [name=cdgsyx]').val(response.cdgsyx);
			 $('#form-submit [name=cdgsdh]').val(response.cdgsdh);
			 $('#form-submit [name=cdgsyb]').val(response.cdgsyb);
			 $('#form-submit [name=cdgscz]').val(response.cdgscz);
			 $('#form-submit [name=cdgslxr]').val(response.cdgslxr);
			 $('#form-submit [name=yflx]').select2("val",response.yflx);
			 $('#form-submit [name=dfzh]').val(response.dfzh);
			 // 收货人信息
			 $('#form-submit [name=shfmc]').val(response.shfmc);
			 $('#form-submit [name=shflxr]').val(response.shflxr);
			 $('#form-submit [name=shfdh]').val(response.shfdh);
			 $('#form-submit [name=shfcz]').val(response.shfcz);
			 $('#form-submit [name=shfyb]').val(response.shfyb);
			 $('#form-submit [name=shfyx]').val(response.shfyx);
			 $('#form-submit [name=shfdz]').val(response.shfdz);
			 $('#form-submit [name=shfdm]').val(response.shfdm);
			 $('#form-submit [name=shrdh]').val(response.shrdh);
			 $('#form-submit [name=aeoqybm]').val(response.aeoqybm);
			//清空明细数据
			$(grid_selector_notify).jqGrid("clearGridData");
			//填充明细表格
			$(grid_selector_notify).jqGrid("addRowData", null, response.psoNotifyList,"last");
			//指定收货人名称为TO ORDER时
			if(response.shfmc == "TO ORDER"){
				$('#chk_shfmc').prop("checked",true).trigger("change");
			} else {
				$('#chk_shfmc').trigger("change");
			}
		});
	}
	//绑定主体预走货单号
	function bindZtyzh(){
		$("#form-submit [name=ztyzhdh]").parent().click(function(){
			$.tableDialogPage({
    			title:"主体预走货单号选择",
    			searchCond:[{"name":"客户","value":"khmc"},
    			            {"name":"销售员","value":"xsymc"},
    			            {"name":"预走货单号","value":"yzhdh"},
    			            {"name":"发起人","value":"zdrid"},
    			            {"name":"业务组","value":"ywz"}
    			            ],
    			colModel:[{name:'id', index:'id', label:'ID',hidden:true},
    			          {name:'yzhdh', index:'yzhdh', label:'预走货单号'},
    			          {name:'khbm', index:'khbm', label:'客户编码'},
    			          {name:'khmc', index:'khmc', label:'客户名称'},
    			          {name:'xsymc', index:'xsymc', label:'销售员名称'},
    			          {name:'ywzmc', index:'ywzmc', label:'业务组名称'},
    			          {name:'bbh', index:'bbh', label:'版本号'}
    			          ],
    			//选取主体预走货不做类型和 状态的限制
    			//url:"<c:url value='/pso/tvPso/search'/>" +"?&zt=5"
    			url:"<c:url value='/pso/tvPso/search'/>"
    		},{
    			callback:function(rows){
    				if(rows){
    					$('#form-submit [name=ztyzhdh]').val(rows.yzhdh);
    				}else{
    					$('#form-submit [name=ztyzhdh]').val("");
    				}
    			}
    		});
		});
	}
	//根据ID初始化表单数据
	function initFormDataByid(id){
		if(id != "null"){
			//$.loading();
			$.bindAjax({
				url : "<c:url value='/pso/tvPso/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$("#fjxx").html(response.fj);
				//清空明细数据
				$(grid_selector_item).jqGrid("clearGridData");
				$(grid_selector_pi).jqGrid("clearGridData");
				$(grid_selector_other).jqGrid("clearGridData");
				$(grid_selector_notify).jqGrid("clearGridData");
				//填充明细表格
				$(grid_selector_item)[0].addJSONData({items:response.psoItemList});
				$(grid_selector_pi).jqGrid("addRowData", null,response.psoPiList ,"last");
				$(grid_selector_other).jqGrid("addRowData", null, response.psoOtherList,"last");
				$(grid_selector_notify).jqGrid("addRowData", null, response.psoNotifyList,"last");
				//$.hideLoad();
				$("#form-submit [name=taskId]").val(taskId);
				$("#form-submit [name=oper]").val("edit");//编辑权限
				selectKd($("#form-submit [name=kdlx]").val());
				//驳回时初始化分支默认值为重新审核
				//$("#form-submit [name=sfRestart1][value=restart]").prop("checked","checked");
				//$("#form-submit [name=sfRestart2][value=restart]").prop("checked","checked");
				$("#form-submit [name=sfCybl][value=0]").prop("checked","checked");
				//若是变更编辑则显示储运补录选择
				if(response.sfBg == 1){
					$('.cyblSelect').show();
				}
				//指定收货人名称为TO ORDER时
				if(response.shfmc == "TO ORDER"){
					$('#chk_shfmc').prop("checked",true).trigger("change");
				} else {
					$('#chk_shfmc').trigger("change");
				}
			});
		}else{
			 //初始化页面参数s
			$("#form-submit [name=id]").val("");//ID:空
			$("#form-submit [name=yzhlx]").val("1");//预走货类型:大货预走货
			$("#form-submit [name=oper]").val("add");//权限:add
			$("#form-submit [name=zt]").val("1");//预走货状态:草稿
			$("#fymx").hide().children("div").hide();
			selectKd("1");
			//清空明细数据
			$(grid_selector_item).jqGrid("clearGridData");
			$(grid_selector_pi).jqGrid("clearGridData");
			$(grid_selector_other).jqGrid("clearGridData");
			$(grid_selector_notify).jqGrid("clearGridData");
		}
	}
	// 附件
	function fjUpload(){
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
	// 前端数据校验
	function validate(){
		// 前端数据校验
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: ["hidden","disabled"],
			rules: {	
				gsbm  : 'required',
				khmc  : 'required',
				xsymc :	'required',
				zgsj  : 'required',
			    cylx  : 'required',
			    //cdgsyx: 'email',
				//shfyx : 'email',
				xwgj  : 'required',
				//scjd : 'required'
				hwgyl : 'required',
				shfmc : 'required',
				//shfdz : 'required'
			},
			messages: {
				gsbm  : '公司编码不能为空',
				khmc  : '客户名称不能为空',
				xsymc : '销售员名称不能为空',
				zgsj  : '装柜时间不能为空',
			    cylx  : '出运类型不能为空',
			    //cdgsyx: '船代公司邮箱格式不正确',
				//shfyx : '收货方邮箱格式不正确',
				xwgj  : '目的国家不能为空',
				//scjd  : '生产基地不能为空'
				hwgyl : '海外供应链不能为空',
				shfdm : '收货人代码不能为空',
				shfmc : '收货人名称不能为空',
				shrdh : '收货人电话不能为空',
				shfdz : '收货人地址不能为空',
				shflxr: '具体联络人不能为空',
				shfdh : '具体联络人电话不能为空'
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
		//用户要求 保存时不做校验
		 if(!$('#form-submit').valid()){
			return false;
		} 
		var result = false ;
		//结束表格编辑
	    var lastEdit = $(grid_selector_item).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_item).saveRow(lastEdit, false, 'clientArray');
			  $(grid_selector_item).removeData('lastEdit');
			if(!result){
				return ;
			}
		}
	    
		lastEdit = $(grid_selector_pi).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_pi).saveRow(lastEdit, false, 'clientArray');
		    $(grid_selector_pi).removeData('lastEdit');
			if(!result){
				return;
			}
		}
		
	    lastEdit = $(grid_selector_other).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_other).saveRow(lastEdit, false, 'clientArray');
		    $(grid_selector_other).removeData('lastEdit');
			if(!result){
				return;
			}
		}
	    
	    lastEdit = $(grid_selector_notify).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_notify).saveRow(lastEdit, false, 'clientArray');
		    $(grid_selector_notify).removeData('lastEdit');
			if(!result){
				return;
			}
		}
		var item =  $(grid_selector_item).getRowData();
		var pi =  $(grid_selector_pi).getRowData();
		if(item.length==0){
			swal("","走货订单明细不能为空","warning");
			return;
		}
		result = true;
		$.each(item, function(i, order){
		/* 	var je = Number(order.je);
			var sl = Number(order.sl);
			var dj = Number(order.dj);
			if(je != sl*dj){
				swal("","订单："+order.ddid+"的金额不等于数量*单价！","warning");
				result = false;
				return false;
			} */

			//预走货行项目中，用户要求允许相同的订单号存在 下面这段控制是为了汇总相同订单号的金额-------- 开始--------如果不允许相同订单存在注释下面这块代码，放开上面那段注释代码即可
		/* 	var je1 = parseFloat(order.je);
			var sl = Number(order.sl);
			var dj = parseFloat(order.dj);
			var ffbsje = parseFloat(order.ffbsje);
			var ce = parseFloat(order.ce);
			var je2 = parseFloat(sl*dj+ffbsje+ce).toFixed(4);
			//if(Number(order.je) != Number(order.sl)*Number(order.dj)+Number(order.ffbsje)){
			if(je1 != je2){
				swal("","订单："+order.ddid+"的金额不等于数量*单价+付费备损金额+误差金额！","warning");
				result = false;
				return false;
			} */
			var je=0;
			$.each(item, function(t, orderRow){
				if(order.ddid == orderRow.ddid){
					je =  je + Number(orderRow.je);
				}
			});
			
			//预走货行项目中，用户要求允许相同的订单号存在 下面这段控制是为了汇总相同订单号的金额-------- 结束--------如果不允许相同订单存在注释上面这块代码，放开上面那段注释代码即可
			var piJe=0;
			$.each(pi, function(j, piData){
				if(piData.ddid == order.ddid){
					piJe = piJe + Number(piData.je);
				}
			});
			if(je != piJe){
				swal("","订单："+order.ddid+"的汇总金额不等于该订单对应的PI明细汇总金额！","warning");
				result = false;
				return false;
			}
				
		});
		if(!result){
			return;
		} 
		result = true;
		var message = "";
		$.each( item, function(i,order){  
			if(order.spmc == "" || order.spmc == null){
            	message += "第"+(i+1)+"行，商品名称不能为空.";
    			result = false;
            }
            if(order.jixing == "" || order.jixing == null){
            	message += "第"+(i+1)+"行，我司型号不能为空.";
    			result = false;
            }
            if(order.pp == "" || order.pp == null){
            	message += "第"+(i+1)+"行，品牌不能为空.";
    			result = false;
            }
            if(order.gtin == "" || order.gtin == null){
            	message += "第"+(i+1)+"行，GTIN码不能为空.";
    			result = false;
            }
            if(order.cas == "" || order.cas == null){
            	message += "第"+(i+1)+"行，CAS码不能为空.";
    			result = false;
            }
            if(order.dsjlx == "" || order.dsjlx == null){
            	message += "第"+(i+1)+"行，电视机类型不能为空.";
            	result = false;
            }
            if(order.pid == "" || order.pid == null){
            	message += "第"+(i+1)+"行，PID不能为空.";
            	result = false;
            }
            /* if(order.version == "" || order.version == null){
            	message += "第"+(i+1)+"行，版本号不能为空.";
            	result = false;
            } */
            if(order.ckxhqk == "" || order.ckxhqk == null){
            	message += "第"+(i+1)+"行，出口享惠情况不能为空.";
    			result = false;
            }
          }); 
		if(result == false){
			swal("",message,"warning");
			return;
		}
	    //拿到表单数据
		var param = $('#form-submit').getFormData();
		var other =  $(grid_selector_other).getRowData();
		var notity =  $(grid_selector_notify).getRowData();
		param.itemList = JSON.stringify(item);
		param.piList = JSON.stringify(pi);
		param.otherList = JSON.stringify(other);
		param.notityList = JSON.stringify(notity);
		if($("#qyg").select2("val")==4 && $("#qygbz").val()==""){
			swal("", "起运港备注不能为空！", "warning");
			return;
		}
		if(param.sfChehui == "1" && param.bgbz == ""){
			swal("", "变更备注不能为空！", "warning");
			return;
		}
		if(notity.length == 0){
			swal("", "请填写提单通知人信息！", "warning");
			return;
		}
		var myFlag = false;
		var myMsg = "提单通知人信息：";
		$.each(notity, function(i, n){
			if(n.tzfdm == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，通知方代码不能为空！";
			}
			if(n.tzfdh == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，通知方电话不能为空！";
			}
			if(n.tzrmc == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，公司名称不能为空！";
			}
			if(n.tzrlxr == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，联系人不能为空！";
			}
			if(n.tzrdh == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，电话不能为空！";
			}
			if(n.tzrdz == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，地址不能为空！";
			}
		});
		if(myFlag){
			swal("", myMsg, "warning");
			return;
		}
		$("#save").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/pso/tvPso/edit'/>",
					data:param,
					action:"save",
				},function(response){
					var result = JSON.parse(response);
					$('#form-submit [name=token]').val(result.token);
					$('#form-submit [name=yzhdh]').val(result.yzhdh);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh); 
					$("#form-submit [name=yzhlx]").val(result.yzhlx); 
				}); 
			}
		});
	}
	// 提交
	function submit(){
		//选择需要储运补录，但出运类型为快递时，不能进行提交
		var sfCybl = $("#form-submit [name='sfCybl']:checked").val();
		var cylx =  $("#form-submit [name=cylx]").select2("val");
		var ztyzhdh = $("#form-submit [name=ztyzhdh]").val();
		if(sfCybl == 1 && (cylx == 4 || ztyzhdh.length != 0)){
			swal("","当出运类型为快递或选择主体预走货时，不进行储运补录，请重新进行选择！","warning");
			return;
		}
		//用户要求 保存时不做校验
		if(!$('#form-submit').valid()){
			return false;
		} 
		var result = false ;
		//结束表格编辑
	    var lastEdit = $(grid_selector_item).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_item).saveRow(lastEdit, false, 'clientArray');
			if(!result){
				return ;
			}
		}
	    
		lastEdit = $(grid_selector_pi).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_pi).saveRow(lastEdit, false, 'clientArray');
			if(!result){
				return;
			}
		}
		
	    lastEdit = $(grid_selector_other).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_other).saveRow(lastEdit, false, 'clientArray');
			if(!result){
				return;
			}
		}
	    
	    lastEdit = $(grid_selector_notify).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_notify).saveRow(lastEdit, false, 'clientArray');
			if(!result){
				return;
			}
		}
		var item =  $(grid_selector_item).getRowData();
		var pi =  $(grid_selector_pi).getRowData();
		if(item.length==0){
			swal("","走货订单明细不能为空","warning");
			return;
		}
		result = true;
		$.each(item, function(i, order){
			/* 	var je = Number(order.je);
				var sl = Number(order.sl);
				var dj = Number(order.dj);
				if(je != sl*dj){
					swal("","订单："+order.ddid+"的金额不等于数量*单价！","warning");
					result = false;
					return false;
				} */
				

			//预走货行项目中，用户要求允许相同的订单号存在 下面这段控制是为了汇总相同订单号的金额-------- 开始--------如果不允许相同订单存在注释下面这块代码，放开上面那段注释代码即可
		/*	var je1 = parseFloat(order.je);
			var sl = Number(order.sl);
			var dj = parseFloat(order.dj);
			var ffbsje = parseFloat(order.ffbsje);
			var ce = parseFloat(order.ce);
			var je2 = parseFloat(sl*dj+ffbsje+ce).toFixed(4);
			//if(Number(order.je) != Number(order.sl)*Number(order.dj)+Number(order.ffbsje)){
		 	if(je1 != je2){
				swal("","订单："+order.ddid+"的金额不等于数量*单价+付费备损金额+误差金额！","warning");
				result = false;
				return false;
			} */
			var je=0;
			$.each(item, function(t, orderRow){
				if(order.ddid == orderRow.ddid){
					je =  je + Number(orderRow.je);
				}
			});
	
			//预走货行项目中，用户要求允许相同的订单号存在 下面这段控制是为了汇总相同订单号的金额-------- 结束--------如果不允许相同订单存在注释上面这块代码，放开上面那段注释代码即可
			var piJe=0;
			$.each(pi, function(j, piData){
				if(piData.ddid == order.ddid){
					piJe = piJe + Number(piData.je);
				}
			})
			
			if(je.toFixed(4) != piJe.toFixed(4)){
				swal("","订单："+order.ddid+"的汇总金额不等于该订单对应的PI明细汇总金额！","warning");
				result = false;
				return false;
			}
		});
		if(!result){
			return;
		}
		result = true;
		var message = "";
		$.each( item, function(i,order){  
            if(order.spmc == "" || order.spmc == null){
            	message += "第"+(i+1)+"行，商品名称不能为空.";
    			result = false;
            }
            if(order.jixing == "" || order.jixing == null){
            	message += "第"+(i+1)+"行，我司型号不能为空.";
    			result = false;
            }
            if(order.pp == "" || order.pp == null){
            	message += "第"+(i+1)+"行，品牌不能为空.";
    			result = false;
            }
            if(order.gtin == "" || order.gtin == null){
            	message += "第"+(i+1)+"行，GTIN码不能为空.";
    			result = false;
            }
            if(order.cas == "" || order.cas == null){
            	message += "第"+(i+1)+"行，CAS码不能为空.";
    			result = false;
            }
            if(order.dsjlx == "" || order.dsjlx == null){
            	message += "第"+(i+1)+"行，电视机类型不能为空.";
            	result = false;
            }
            if(order.ckxhqk == "" || order.ckxhqk == null){
            	message += "第"+(i+1)+"行，出口享惠情况不能为空.";
    			result = false;
            }
          }); 
		if(result == false){
			swal("",message,"warning");
			return;
		}
	    //拿到表单数据
		var param = $('#form-submit').getFormData();
		var other =  $(grid_selector_other).getRowData();
		var notity =  $(grid_selector_notify).getRowData();
		param.itemList = JSON.stringify(item);
		param.piList = JSON.stringify(pi);
		param.otherList = JSON.stringify(other);
		param.notityList = JSON.stringify(notity);
		if($("#qyg").select2("val")==4 && $("#qygbz").val()==""){
			swal("", "起运港备注不能为空！", "warning");
			return;
		}
		if(param.sfChehui == "1" && param.bgbz == ""){
			swal("", "变更备注不能为空！", "warning");
			return;
		}
		if(notity.length == 0){
			swal("", "请填写提单通知人信息！", "warning");
			return;
		}
		var myFlag = false;
		var myMsg = "提单通知人信息：";
		$.each(notity, function(i, n){
			if(n.tzfdm == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，通知方代码不能为空！";
			}
			if(n.tzfdh == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，通知方电话不能为空！";
			}
			if(n.tzrmc == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，公司名称不能为空！";
			}
			if(n.tzrlxr == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，联系人不能为空！";
			}
			if(n.tzrdh == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，电话不能为空！";
			}
			if(n.tzrdz == ""){
				myFlag = true;
				myMsg += "第"+(i+1)+"行，地址不能为空！";
			}
		});
		if(myFlag){
			swal("", myMsg, "warning");
			return;
		}
		$("#submit").bindSweetAlert({
			title:"确定要提交吗？"
		},{
			callback:function(){
				if($("#form-submit [name=ztyzhdh]").val() != ""){
					swal("", "预走货选择了与其他预走货合票,请与主体预走货发起人线下沟通确保能满足拼柜/车要求！", "warning");
				}
				$.bindAjax({
					url:"<c:url value='/pso/tvPso/submit'/>",
					data:param,
					action:"save",
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	function bindButtonEvent(){
		//返回按钮
		$('#btn-back').click(function() {
			window.history.back(-1);
		});
		//保存按钮
		$('#btn-save').click(function() {
			save();
		});
		//提交按钮
		$('#btn-submit').click(function() {
			submit();
		});
		//订单选择按钮
		$('#btn-ddSelect').click(function() {
			var lastEdit = $(grid_selector_item).data('lastEdit');
  		    if(lastEdit){
  		    	$(grid_selector_item).saveRow(lastEdit, false, 'clientArray');
  		    }
			initDdid();
		});
		// 目的国家change事件
		/* $('#form-submit [name=xwgj]').on('change',function(e){
			$.post("<c:url value='/pub/select2/selectShfdm'/>",{xwgj : e.val},
				function(result){
					var data = $.map(result, function (obj) {
				       obj.id = obj.companyCode;
				       obj.text =  obj.companyCode ;		      
				       return obj;
				    });
					$("#form-submit [name=shfdm]").addClass("skyselect").select2({data:data}).select2('val', result[0].companyCode);
				}, "json");
		}); */
	}
	//订单选择
	function initDdid(){
			var width = 1000;
			var height = 700;
			var left = (window.screen.width-width)/2;
			var top = (window.screen.height-height)/2;
			var pageUrl = "<c:url value='/pso/tvPso/ddcxPage'/>?&yzhlx="
			               +$("#form-submit [name=yzhlx]").val();
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				var data = window.showModalDialog(pageUrl,null,dialogArgs);
				if(data){
					initData(data);
				}
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
				var opener = window.open(pageUrl,null,dialogArgs);
				opener.openerCallBack = function(data){
					initData(data);
				}
			}
	  }
	  //将带回数据填充
      function initData(data){
		  
		  
		  console.info(data);
	  
    	   var lastEdit = $(grid_selector_item).data('lastEdit');
  		   if(lastEdit){
  			 $(grid_selector_item).saveRow(lastEdit, false, 'clientArray');
  		   }
    	   var localData = $(grid_selector_item).getRowData();
	       // 添加数据
	       if(localData.length > 0){
		       	$.each(data,function(index,rowData){
		       		var isExists = false ;
		       		//预走货明细行存在相同订单的情况，注释订单校验逻辑
		       		 $.each(localData,function(index,value){
		       			// 是否存在
		       			if(rowData.ddid == value.ddid){
		       				//isExists = true;
		       				//return false;
		       				rowData.id=rowData.id+"_"+(localData.length+index);//防止id序号重复
		       				
		       			}
		       		}); 
		       		// 数据是否合格
	       			if(!($("#form-submit [name=khbm]").val() == rowData.khbm 
	       				 && $("#form-submit [name=gsbm]").val() == rowData.gsbm 
	       				 && $("#form-submit [name=xsyid]").val() == rowData.xsyid 
	       				 && $("#form-submit [name=scjd]").select2("val") == rowData.scjd)){
	       				isExists = true;
						return false;
					}
		       		if(!isExists){
		       			localData.push(rowData);
		       			//$(grid_selector_item)[0].addJSONData({items:rowData});
		       		}
	       	    });
		       	$(grid_selector_item).jqGrid("clearGridData");
		       	$(grid_selector_item)[0].addJSONData({items:localData});
	       }else{
      		   $(grid_selector_item)[0].addJSONData({items:data});
	    	   $("#form-submit [name=gsbm]").val(data[0].gsbm);
			   $("#form-submit [name=gsmc]").val(data[0].gsmc);
			   $("#form-submit [name=khbm]").val(data[0].khbm);
			   $("#form-submit [name=khmc]").val(data[0].khmc);
			   $("#form-submit [name=xsyid]").val(data[0].xsyid);
			   $("#form-submit [name=xsymc]").val(data[0].xsymc);
			   $("#form-submit [name=ywz]").val(data[0].ywz);
			   $("#form-submit [name=ywzmc]").val(data[0].ywzmc);
			   $("#form-submit [name=xszz]").val(data[0].xszz);
			   $("#form-submit [name=xszzmc]").val(data[0].xszzmc);
			   $("#form-submit [name=fktj]").val(data[0].fktj);
			   $("#form-submit [name=fktjmc]").val(data[0].fktjmc);
			   $("#form-submit [name=mytk]").select2("val",data[0].gjmytk);
	     	   $("#form-submit [name=xwgj]").select2("val",data[0].xwgj);
	     	   $("#form-submit [name=cylx]").select2("val",data[0].cylx);
	     	   $("#form-submit [name=scjd]").select2("val",data[0].scjd);
	    	   $.bindAjax({
	    		   url:"<c:url value='/pub/widget/findCust'/>",
				   data:{khbm:data[0].khbm},
				   action:"search",
			   },function(response){
				   $("#form-submit [name=shfmc]").val(response.items[0].khmc);
				   $("#form-submit [name=shflxr]").val(response.items[0].lxr);
				   $("#form-submit [name=shfdh]").val(response.items[0].dh);
				   $("#form-submit [name=shfdz]").val(response.items[0].dz);
				   $("#form-submit [name=shfyx]").val(response.items[0].yx);
		    	   $('#chk_shfmc').trigger("change");
			   });
	       }
/* 			var localData = $(grid_selector_item).getRowData();
			for (var i=0;i<localData.length;i++){
				rowid=localData[0].id;
				 var rec = $(grid_selector_item).jqGrid('getRowData', rowid);
				 alert(rowid);
				 alert($("#bde6a96d-b7e7-4caa-9350-5acd2771686b_sl").val());
				$('#bde6a96d-b7e7-4caa-9350-5acd2771686b_sl').attr('disabled','disabled');
			} */
			var orderData = $(grid_selector_item).getRowData();
			var ddids = "";
			for(var i=0; i<orderData.length; i++){
				ddids += orderData[i].ddid;
				if(i != orderData.length-1){
					ddids += ",";
				}
       		}
	       $.bindAjax({
    		   url:"<c:url value='/pso/tvPso/queryPixx'/>",
			   data:{
				   yzhlx:$("#form-submit [name=yzhlx]").val(),
				   ddid:ddids
			   },
			   action:"search",
		   },function(response){
			   $(grid_selector_pi).jqGrid("clearGridData");
			   $(grid_selector_pi).jqGrid("addRowData", null, response, "last");
		   });
      }
	 
	  // 取字典快递类型
	  function getKdType(type){
		  var Type = "";
		  if(type == "1"){
			  Type = "GNKD";
		  }else if(type == "2"){
			  Type = "GJKD"; 
		  }else if(type == "3"){
			  Type = "QTKD"; 
		  }
		  return Type;
	  }
	// 初始化编辑表select2
	function initSelect2(elem){
		$(elem).width(140).addClass(".skyselect").select2();
	}
/*	function initVersion(elem){
		$(elem).width(140).addClass(".skyselect").select2("00",'00');
		
	}*/
/*******************functions end*********************************/
</script>
</html>