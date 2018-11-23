<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
	<!-- 富文本框使用引入 -->
	<link href="<%=request.getContextPath()%>/static/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/umeditor/umeditor.config.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/umeditor/umeditor.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/umeditor/lang/zh-cn/zh-cn.js"></script>
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
					<input type="hidden" name="id" /><!-- 订单id -->
					<input type="hidden" name="oper" />
					<input type="hidden" name="sjc" />
					<input type="hidden" name="sfBg"/>
					<input type="hidden" name="sfCh"/>
					<input type="hidden" name="tssapzt"/>
					<!-- <input type="hidden" name="bbh" /> -->
					<input type="hidden" name="taskId" />
					<input type="hidden" name="token" value="${token}" />
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
							<input type="text" name="ddid" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单类别&nbsp;&nbsp;</label>
							<select role="select" name="ddlb" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('DDLB_DH')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">原订单号&nbsp;&nbsp;</label>
							<input type="text" name="yddid" class="form-control skydisabled" disabled="disabled" />
						</div>
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
				<div  class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">参考订单号&nbsp;&nbsp;</label>
							<input type="text" name="ckddh" onfocus="this.blur()" 
								class="form-control parent-node skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">关联订单号&nbsp;&nbsp;</label>
							<input type="text" name="glddh" onfocus="this.blur()" 
								class="form-control parent-node skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>						
					    </div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">是否模组CKD&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio skydisabled" name="sfMzckd" value="1">是
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio skydisabled" name="sfMzckd" value="0" checked="checked">否
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">供应商&nbsp;&nbsp;</label>
							<select role="select" name="gysbm" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('GYS')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<button id="btn-piSelect" type="button" class="btn btn-purple btn-sm" >
							<i class="fa fa-plus icon-on-right bigger-110"></i>
							PI选择
						</button>
					</div>
				</div>
				
				<div  class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3 changeJeSelect" style="display:none">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">更改数量金额：&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" name="slje" class="skyradio" value="1">数量
								</label>
								<label class="radio-inline">
									<input type="radio" name="slje" checked="checked" class="skyradio" value="0">金额
								</label>
							</div>
						</div>
					</div>
				</div>
			
				<h5 class="header blue" style="margin-top:4px;">PI信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div id="grid-parent-pixx">
							<table id="grid-table-pixx"></table>
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
							<label class="input-group-addon">公司&nbsp;&nbsp;</label>
							<input  type="text" name="gsbm"  class="form-control skydisabled" disabled="disabled" >
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">编码选择&nbsp;&nbsp;</label>
							<select role="select" name="ddbmlx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
									${fns:loadDictOption('DDBM_DH')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单类型&nbsp;&nbsp;</label>
							<input type="hidden" name="ddlx" >
							<input type="text" name="ddlxmc" class="form-control skydisabled" disabled="disabled">
						</div>
					</div>
					
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">业务类型&nbsp;&nbsp;</label>
								<select role="select" name="ywlx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
									${fns:loadDictOption('YWLX')}
								</select>
							</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单状态&nbsp;&nbsp;</label>
							<select role="select" name="zt" size="1" class="form-control skydisabled" disabled="disabled">
								${fns:loadDictOption('DJZT')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
							<input type="text" name="zdrmc" class="form-control skydisabled" disabled="disabled"/>
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
							<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
							<input type="hidden" name="xsyid" />
							<input type="text" name="xsymc" class="form-control skydisabled" disabled="disabled">
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
							<input type="hidden" name="ywz" />
							<input type="text" name="ywzmc" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售组织&nbsp;&nbsp;</label>
							<input type="hidden" name="xszz" />
							<input type="text" name="xszzmc" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">版本号&nbsp;&nbsp;</label>
							<input type="text" name="bbh" class="form-control" readonly/>
						</div>
					</div>
				</div>
				
				<div class="space-8"></div>
				<ul class="nav nav-tabs">
					<li class="active"><a href="#jbxx-tab" data-toggle="tab">基本信息</a></li>
					<li><a href="#khxx-tab" data-toggle="tab">客户信息</a></li>
					<li><a href="#cpxx-tab" data-toggle="tab">产品信息</a></li>
					<li><a href="#mgxx-tab" data-toggle="tab">美工信息</a></li>
					<li><a href="#bswlxx-tab" data-toggle="tab">物料信息</a></li>
				</ul>
				
				<div class="tab-content">
					<!-- 基本信息TAB -->
					<div class="tab-pane fade active in" id="jbxx-tab">
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">PID&nbsp;&nbsp;</label>
									<input type="text" name="pid" onfocus="this.blur()" class="form-control parent-node"/>
									<span class="input-group-addon">
										<i class="icon-search bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">我司型号&nbsp;&nbsp;</label>
									<input type="text" name="wsxh" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">机芯&nbsp;&nbsp;</label>
									<input type="text" name="jixin" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">买家型号&nbsp;&nbsp;</label>
									<input type="text" name="mjxh" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">外协订单&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfWxdd" value="1">外协
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfWxdd" value="0" checked="checked">非外协
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">内销研发产品&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfNxyfcp" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfNxyfcp" value="0" checked="checked">否
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">规格明细&nbsp;&nbsp;</label>
									<select role="select" name="ggmx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('GGMX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="ggmxbz" placeholder="规格明细备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否新品&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfXp" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfXp" value="0" checked="checked">否
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">付款条件&nbsp;&nbsp;</label>
									<input type="hidden" name="fktj" />
									<input type="text" name="fktjmc" class="form-control" readonly/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">国际贸易条款&nbsp;&nbsp;</label>
									<!-- <input type="hidden" name="gjmytk" />
									<input type="text" name="gjmytkmc" class="form-control"/> -->
									<select role="select" name="gjmytk" size="1" class="form-control skyselect" >
										${fns:loadDictOption('PIGJMYTK')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="gjmytkbz" placeholder="国际贸易条款备注" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-2">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">币种&nbsp;&nbsp;</label>
									<input type="text" name="bz" class="form-control" readonly/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-2">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">大货数量&nbsp;&nbsp;</label>
									<input type="text" name="sl" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-2">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收费样机数量&nbsp;&nbsp;</label>
									<input type="text" name="yjsl" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">走货方式&nbsp;&nbsp;</label>
								    <select role="select" name="zhfs" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('PI_ZHFS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">加工方式&nbsp;&nbsp;</label>
								    <select role="select" name="jgfs" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('ZHFS')}
									</select>
								</div>
							</div>
						</div>
						<shiro:hasPermission name="order:orderProduct:price">
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">	
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">单价&nbsp;&nbsp;</label>
									<input type="text" name="dj" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">金额&nbsp;&nbsp;</label>
									<input type="text" name="je" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">付费备损金额&nbsp;&nbsp;</label>
									<input type="text" name="ffbsje" class="form-control  skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">总金额（含备损）&nbsp;&nbsp;</label>
									<input type="text" name="zje" class="form-control  skydisabled" disabled="disabled"/>
								</div>
							</div>
							
						</div>
						</shiro:hasPermission>
						<div class="space-4"></div>
					    <div id="zhbhwj" class="row" style="margin: 0px;">
					    	<div class="col-xs-6 col-sm-9">
								<div class="input-group input-group-sm" >
									<label class="input-group-addon">走货不含物件&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
											<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="zhbhwjP" value="1">屏
										</label>
										<label class="checkbox-inline">
								      		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="zhbhwjJk" value="1">机壳
								      	</label>
								      	<label class="checkbox-inline">
								      		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="zhbhwjYkq" value="1">遥控器
								     	</label>
								     	<label class="checkbox-inline">
								     		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="zhbhwjLb" value="1">喇叭
								     	</label>
								     	<label class="checkbox-inline">
								     		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="zhbhwjZx" value="1">纸箱
								    	</label>
								    	<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="zhbhwjPm" value="1">高频头
								    	</label>
								    	<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="zhbhwjJxZb" value="1">机芯+主板
								  		</label>
								  	</div>
								</div>
							</div>
					    </div>
					    <div class="space-4"></div>
						<div id="xddzhw" class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">需单独走货物&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
											<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="xddzhP" value="1">屏
										  </label>
										  <label class="checkbox-inline">
										    <input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="xddzhJk" value="1">机壳
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="xddzhLb" value="1">喇叭
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="xddzhZx" value="1">纸箱
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="xddzhJxZb" value="1">机芯+主板
										  </label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">出运类型&nbsp;&nbsp;</label>
									<select id = "cylx" role="select" name="cylx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('CYLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="cylxbz" placeholder="出运类型备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">交货日期&nbsp;&nbsp;</label>
									<input type="text" name="jhrq" class="form-control skydisabled" disabled="disabled"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">分公司收货日期&nbsp;&nbsp;</label>
									<input type="text" name="fgsshrq" class="form-control date-picker skydisabled" disabled="disabled"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
					    <div class="space-4"></div>
					    <div class="row" style="margin: 0px;">
					       <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">预测周数&nbsp;&nbsp;</label>
									<input type="text" name="yczs" class="form-control skydisabled" readonly/>
									<span class="input-group-btn">
									<button id="btn-FcstDataSelect" type="button" class="btn btn-primary btn-sm" disabled="disabled">
										查看预测
									</button>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">预测日期&nbsp;&nbsp;</label>
									<input type="text" name="ycrq" class="form-control date-picker skydisabled" readonly/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">预测数量&nbsp;&nbsp;</label>
									<input type="text" name="ycsl" class="form-control  skydisabled" readonly/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">渠道&nbsp;&nbsp;</label>
									<select role="select" name="qd" size="1" class="form-control skyselect">
										${fns:loadDictOption('QD')}
									</select>
								</div>
							</div>
					    </div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否验货&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfYh" value="1" onclick="javascript:sfYh_show();">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfYh" value="0" checked="checked" onclick="javascript:sfYh_hide();">否
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="sfyhbz" placeholder="是否验货备注" class="form-control  skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">验货日期&nbsp;&nbsp;</label>
									<input type="text" name="yhrq" class="form-control date-picker skydisabled" disabled="disabled"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<!-- 富文本框容器 -->
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-12">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">基本信息备注&nbsp;&nbsp;</label>
									<script type="text/plain" id="jbxxbz"
										style="width: 100%; height: 100px;">
									</script>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-12">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">变更信息备注&nbsp;&nbsp;</label>
									<script type="text/plain" id="bgbz"
										style="width: 100%; height: 100px;">
									</script>
								</div>
							</div>
						</div>
						<!-- <div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							 <div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">基本信息备注&nbsp;&nbsp;</label>
									<textarea name="jbxxbz" class="autosize-transition form-control skydisabled" disabled="disabled"></textarea>
								</div>
							</div> 
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">变更信息备注&nbsp;&nbsp;</label>
									<textarea name="bgbz" class="autosize-transition form-control"></textarea>
								</div>
							</div>
						</div>-->
					</div> 
					<!-- 客户信息TAB -->
					<div class="tab-pane fade" id="khxx-tab">
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
									<input type="text" name="khbm" class="form-control  skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
									<input type="text" name="khmc" class="form-control  skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">销往国家&nbsp;&nbsp;</label>
									<input type="text" name="xwgj" class="form-control skydisabled" disabled="disabled"/>
							    </div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">时区&nbsp;&nbsp;</label>
									<input type="text" name="sq" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">品牌&nbsp;&nbsp;</label>
									<input type="text" name="pp" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">出厂语言&nbsp;&nbsp;</label>
									<%-- <select role="select" name="ccyy" size="1" class="form-control skyselect">
										${fns:loadDictOption('CCYY')}
									</select> --%>
									<input type="text" name="ccyymc" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						   <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">开机Logo&nbsp;&nbsp;</label>
									<input type="text" name="kjlogo" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">开机模式&nbsp;&nbsp;</label>
									<select role="select" name="kjms" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('KJMS')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">电子POP&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="dzpop" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="dzpop" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
							<!-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">附件&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="kjlogofj" type="file" class="form-control">
									</div>
									<input type="hidden" name="kjlogofj" />
								</div>
							</div> -->
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-9">
							</div>
							<!-- <div class="col-xs-6 col-sm-3">
								<div id="multiFileQueue"> </div>
								<div id="kjlogofjxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
							</div> -->
						</div>
					</div>
					<!-- 产品信息TAB -->
					<div class="tab-pane fade" id="cpxx-tab">
						<h5 class="header blue" style="margin: 0; padding: 0;">屏体信息</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏品牌&nbsp;&nbsp;</label>
									<input type="text" name="ppp" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏型号&nbsp;&nbsp;</label>
									<input type="text" name="pxh" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏编码&nbsp;&nbsp;</label>
									<input type="text" name="pxxbc" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<!-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">2D/3D&nbsp;&nbsp;</label>
									<div class="form-control ">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" name="sf3d" value="0" checked="checked" >2D
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" name="sf3d" value="1">3D
										</label>
									</div>
								</div>
							</div> -->
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">分辨率&nbsp;&nbsp;</label>
									<select role="select" name="fbl" size="1"    class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('FBL')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="fblbz" placeholder="分辨率备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏包装要求&nbsp;&nbsp;</label>
									<select role="select" name="pbzyq" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('PBZYQ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="pbzyqbz" placeholder="屏包装要求备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏亮点选项&nbsp;&nbsp;</label>
									<select role="select" name="pld" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('PLDXX')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏是否需要保护膜&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfBhm" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfBhm" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<h5 class="header blue" style="margin: 0; padding: 0;">认证信息</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">认证：安全&nbsp;&nbsp;</label>
									<div class="form-control">
									    <label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Cb" value="1">CB
									    </label>
								    	<label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Etl" value="1">ETL
									    </label>
									    <label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Cetl" value="1">cETL
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Paq" value="1">PSE-安全
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Raq" value="1">RED-安全
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Smaq" value="1">S-mark 安全
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group-sm">
									<input type="text" name="rz1Bz" placeholder="备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">认证：电磁兼容&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz2Emc" value="1">EMC
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz2Fcc" value="1">FCC
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz2Rtte" value="1">RTTE
									    </label>
									    <label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz2Pe" value="1">PSE-EMC
									    </label>
									     <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz2Rr" value="1">RED-RF
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz2Sme" value="1">S-mark -EMC
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="rz2Bz" placeholder="备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">认证：能效&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz4Erp" value="1">ERP
									    </label>
									    <label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz4Gems" value="1">GEMS
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz4Bee" value="1">BEE
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz4Nrc" value="1">NRcan
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz4Nfnx" value="1">南非能效
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz4Eg" value="1">Energy Guide
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="rz3Bz" placeholder="备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">认证：专利&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
											<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz3Hdmi" value="1">HDMI
										</label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz3Dd" value="1">DD
									    </label>
									     <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz3Dts" value="1">DTS
									    </label>
									    <label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz3Cij" value="1">CI+
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz3Bqb" value="1">BQB
									    </label>
									    <label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz3Mhl" value="1">MHL
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="rz3Bz" placeholder="备注" class="form-control skydisabled" disabled="disabled" />
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px 8px;">
							<div class="col-xs-6 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">老格式认证项：（新下PID不能勾选）&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Ce" value="1">CE
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Ul" value="1">UL
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Pse" value="1">PSE
									    </label>
									    <label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz2Meps" value="1">MEPS
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz2Es" value="1">Energy Star
									    </label>
									     <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz3Usb" value="1">USB
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Rf" value="1">RF
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Rte" value="1">RTE
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Cet" value="1">cETLus
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz1Nom" value="1">NOM
									    </label>
									     <label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz3Ddj" value="1">DD+
									    </label>
									     <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz4Es7" value="1">Energy star 7.0
									    </label>
								    </div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">认证：其他&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="rz5Qt" value="1">其他
									    </label>
								    </div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否需要RoHS&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfRohs" value="1" checked="checked">需要
										</label>
										<!-- <label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfRohs" value="0">不需要
										</label> -->
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否需要REACH&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfReach" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfReach" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<h5 class="header blue" style="margin: 0; padding: 0;">电源信息</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group input-group-sm">
									<label class="input-group-addon">插头类型&nbsp;&nbsp;</label>
									<select role="select" name="ctlx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('CTLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group-sm">
									<input type="text" name="ctlxbz" placeholder="插头类型备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">适配器&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfSpq" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfSpq" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<h5 class="header blue" style="margin: 0; padding: 0;">结构特性信息</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">外壳颜色标准&nbsp;&nbsp;</label>
									<input type="text" name="wkysbz" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group input-group-sm">
									<label class="input-group-addon">泡沫&nbsp;&nbsp;</label>
									<select role="select" name="paomo" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('PM')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">防火料&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fhlQk" value="1">前壳
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fhlHk" value="1">后壳
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fhlDzjlz" value="1">底座及立柱
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fhlAvzj" value="1">AV支架
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fhlBxy" value="1">不需要
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="fhlBz" placeholder="防火料备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">模组贴纸&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="mztzDsky" value="1">带SKYWORTH
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="mztzBdsky" value="1">不带SKYWORTH
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="mztzDmichina" value="1">带MADE IN CHINA
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="mztzBdmichina" value="1">不带MADE IN CHINA
									    </label>
								    </div>
								</div>
							</div>					
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">外包装箱贴纸&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="wbzxtzDsky" value="1">带SKYWORTH
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="wbzxtzBdsky" value="1">不带SKYWORTH
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="wbzxtzDmichina" value="1">带MADE IN CHINA
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="wbzxtzBdmichina" value="1">不带MADE IN CHINA
									    </label>
								    </div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">	
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否需要带卡板出货&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
											<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="kbchjdbyqP" value="1">屏
										  </label>
										  <label class="checkbox-inline">
										    <input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="kbchjdbyqSj" value="1">散件
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="kbchjdbyqZj" value="1">整机
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="kbchjdbyqJzj" value="1">假整机
										  </label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<h5 class="header blue" style="margin: 0; padding: 0;">附件信息</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group input-group-sm">
									<label class="input-group-addon">挂架&nbsp;&nbsp;</label>
									<select role="select" name="guajia" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('GJLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="guajiabz" placeholder="挂架备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group input-group-sm">
									<label class="input-group-addon">挂架包装&nbsp;&nbsp;</label>
									<select role="select" name="gjbz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('GJBZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="gjbzbz" placeholder="挂架包装备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">电池&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfDc" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfDc" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
							<!-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">3D眼镜&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" name="sf3dyj" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" name="sf3dyj" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div> -->
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">底座包装&nbsp;&nbsp;</label>
									<select role="select" name="dzbz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('DZBZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="dzbzbz" placeholder="底座包装备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">其他附件备注&nbsp;&nbsp;</label>
									<textarea name="qtfjbz" class="autosize-transition form-control skydisabled" disabled="disabled"></textarea>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div id="hideSkdCkd">
							<h5 class="header blue" style="margin: 0; padding: 0;">SKD/CKD选项</h5>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px;">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">有无屏&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline">
												<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfP" value="1" checked="checked">有
											</label>
											<label class="radio-inline">
												<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfP" value="0">无
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">IC程序烧录&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline">
												<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfIc" value="1">需要
											</label>
											<label class="radio-inline">
												<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfIc" value="0" checked="checked">不需要
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">S/H/CKD辅料供应&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline">
												<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfShckdflgy" value="1">需要
											</label>
											<label class="radio-inline">
												<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfShckdflgy" value="0" checked="checked">不需要
											</label>
										</div>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">SKD前壳需加工配件&nbsp;&nbsp;</label>
										<input type="text" name="skdqkxjgpj" class="form-control skydisabled" disabled="disabled"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">S/H/CKD加工要求&nbsp;&nbsp;</label>
										<textarea name="shckdjgyq" class="autosize-transition form-control skydisabled" disabled="disabled"></textarea>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm" style="width:20px;">
										<label class="input-group-addon">附件&nbsp;&nbsp;</label>
										<div class="form-control" style="text-align:left;">
											<input id="shckdjgyqbz" type="file" class="form-control">
										</div>
										<input type="hidden" name="shckdjgyqbz" />
									</div>
						    	</div>
						    	<div class="col-xs-6 col-sm-3">
									<div id="multiFileQueue"> </div>
									<div id="shckdjgyqbzfjxx">
										<ul class="list-unstyled spaced"></ul>
									</div>
								</div>
						    </div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">S/H/CKD需成型物料明细&nbsp;&nbsp;</label>
										<input type="text" name="shckdxcxwlmx" class="form-control skydisabled" disabled="disabled"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm" style="width:20px;">
										<label class="input-group-addon">附件&nbsp;&nbsp;</label>
										<div class="form-control" style="text-align:left;">
											<input id="shckdxcxwlmxfj" type="file" class="form-control">
										</div>
										<input type="hidden" name="shckdxcxwlmxfj" />
									</div>
						    	</div>
						    	<div class="col-xs-6 col-sm-3">
									<div id="multiFileQueue"> </div>
									<div id="shckdxcxwlmxfjxx">
										<ul class="list-unstyled spaced"></ul>
									</div>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">产品其他备注信息</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">产品其他要求备注&nbsp;&nbsp;</label>
									<!-- <textarea name="cpqtyqbz" class="autosize-transition form-control" disabled="disabled"></textarea> -->
									<script type="text/plain" id="cpqtyqbz"
										style="width: 800px; height: 100px;">
									</script>
								</div>
							</div>
					    </div>
					    <div class="space-4"></div>
					    <div class="row" style="margin: 0px;">
					    	<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">附件&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="cpqtyqfj" type="file" class="form-control">
									</div>
									<input type="hidden" name="cpqtyqfj" />
								</div>
					    	</div>
					    	<div class="col-xs-6 col-sm-3">
								<div id="multiFileQueue"> </div>
								<div id="cpqtyqfjxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
							</div>
						</div>
					</div>
					<!-- 美工信息TAB -->
					<div class="tab-pane fade" id="mgxx-tab">
					    <h5 class="header blue" style="margin: 0; padding: 0;">客户Logo</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">面壳&nbsp;&nbsp;</label>
									<select role="select" name="mk" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MG_LOGO')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="mkbz" placeholder="面壳备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">装饰件&nbsp;&nbsp;</label>
									<select role="select" name="zsj" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MG_LOGO')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="zsjbz" placeholder="装饰件备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">Logo造型是否变更&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled"  name="sfLogozxbg" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfLogozxbg" value="0" checked="checked">否
										</label>
									</div>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">遥控器</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">遥控器选项&nbsp;&nbsp;</label>
									<select role="select" name="ykq" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MG_YKQXX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="ykqbz" placeholder="遥控器选项备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">说明书</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">说明书&nbsp;&nbsp;</label>
									<select role="select" name="sms" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="smsbz" placeholder="说明书备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">说明书语种&nbsp;&nbsp;</label>
									<input name="smsyz" type="text" class="form-control skydisabled"  disabled="disabled">
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">语言排版顺序&nbsp;&nbsp;</label>
									<input name="yypbsx" type="text" class="form-control skydisabled" disabled="disabled" >
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">快速安装指南&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="ksazzn" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="ksazzn" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">纸箱</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">纸箱&nbsp;&nbsp;</label>
									<select role="select" name="zx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('ZX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="zxbz" placeholder="纸箱备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">印刷资料&nbsp;&nbsp;</label>
									<select role="select" name="yszl" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MG_YSZL')}
									</select>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">贴纸</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">后盖贴纸&nbsp;&nbsp;</label>
									<select role="select" name="hgtz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="hgtzbz" placeholder="后盖贴纸备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">POP贴纸&nbsp;&nbsp;</label>
									<select role="select" name="poptz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="poptzbz" placeholder="POP贴纸备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>	
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">	
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">能效贴纸&nbsp;&nbsp;</label>
									<select role="select" name="nxtz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="nxtzbz" placeholder="能效贴纸备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">适配器贴纸&nbsp;&nbsp;</label>
									<select role="select" name="spqtz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MG_SPQTZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="spqtzbz" placeholder="适配器贴纸备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">保证卡</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">保证卡&nbsp;&nbsp;</label>
									<select role="select" name="bzk" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="bzkbz" placeholder="保证卡备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						
						<h5 class="header blue" style="margin: 0; padding: 0;">底座安装说明</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
						    <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">底座安装说明&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="dzazsm" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="dzazsm" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">底座安装说明书语种&nbsp;&nbsp;</label>
									<input name="dzazsmsyz" type="text" class="form-control skydisabled" disabled="disabled" >
								</div>
							</div>
						</div>
						
						<h5 class="header blue" style="margin: 0; padding: 0;">整机序号贴纸</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">序列号&nbsp;&nbsp;</label>
									<!-- <input name="xlh" type="text" class="form-control skydisabled"> -->
									<select role="select" name=xlh size="1" class="form-control skyselect skydisabled" disabled="disabled" >
										${fns:loadDictOption('XLH')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="xlhbz" placeholder="序列号备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">用量&nbsp;&nbsp;</label>
									<input name="yl" type="text" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">粘贴位置要求&nbsp;&nbsp;</label>
									<input name="ztwzyq" type="text" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">尺寸要求&nbsp;&nbsp;</label>
									<select role="select" name="ccyq" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MG_CCYQ')}
									</select>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">小语种翻译方式</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">小语种翻译方式&nbsp;&nbsp;</label>
									<select role="select" name="xyzfyfs" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MG_XYZFYFS')}
									</select>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">只提供美工资料不提供实物</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="input-group input-group-sm" >
								<div class="form-control">
									<label class="checkbox-inline">
										<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlMk" value="1">面壳
									</label>
									<label class="checkbox-inline">
							      		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlZsj" value="1">装饰件
							      	</label>
							      	<label class="checkbox-inline">
							      		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlYkq" value="1">遥控器
							     	</label>
							     	<label class="checkbox-inline">
							     		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlSms" value="1">说明书
							     	</label>
							     	<label class="checkbox-inline">
							     		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlZx" value="1">纸箱
							    	</label>
							    	<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlHgtz" value="1">后盖贴纸
							    	</label>
							    	<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlPoptz" value="1">POP贴纸
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlNxtz" value="1">能效贴纸
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlSpqtz" value="1">适配器贴纸
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlBzk" value="1">保证卡
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlDzazsm" value="1">底座安装说明
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ztgmgzlZjxhtz" value="1">整机序号贴纸
							  		</label>
							  	</div>
							</div>
						</div>
						<div class="space-4"></div>
						<h5 class="header blue" style="margin: 0; padding: 0;">美工其他备注信息</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">美工其他要求备注&nbsp;&nbsp;</label>
									<!-- <textarea name="mgqtyqbz" class="autosize-transition form-control skydisabled" disabled="disabled"></textarea> -->
									<script type="text/plain" id="mgqtyqbz"
										style="width: 800px; height: 100px;">
									</script>
								</div>
							</div>
					    	<!-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">附件&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="mgqtyqfj" type="file" class="form-control">
									</div>
									<input type="hidden" name="mgqtyqfj" />
								</div>
					    	</div>
					    	<div class="col-xs-6 col-sm-3">
								<div id="multiFileQueue"> </div>
								<div id="mgqtyqfjxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
							</div> -->
						</div>
					</div>
				    <!-- 备损及物料信息TAB -->
					<div class="tab-pane fade" id="bswlxx-tab">
				        <h5 class="header blue" style="margin: 0; padding: 0;">备损信息</h5>
					    <div class="space-8" ></div>
						<div class="row" style="margin: 0px;">
						   	<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否付费备损&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfFfbs" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfFfbs" value="0" checked="checked">否
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">付费备损清单&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="ffbsqdfj" type="file" class="form-control">
									</div>
									<input type="hidden" name="ffbsqdfj" />
								</div>
					    	</div>
					    	<div class="col-xs-6 col-sm-3">
								<div id="multiFileQueue"> </div>
								<div id="ffbsqdxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
						    <div class="col-xs-6 col-sm-3" >
								<div class="input-group input-group-sm">
									<label class="input-group-addon">免费备损&nbsp;&nbsp;</label>
									<select role="select" name="mfbs" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MFBS')}
									</select>
								</div>
							 </div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">免费备损清单&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="mfbsqdfj" type="file" class="form-control">
									</div>
									<input type="hidden" name="mfbsqdfj" />
								</div>
					    	</div>
					    	<div class="col-xs-6 col-sm-3">
								<div id="multiFileQueue"> </div>
								<div id="mfbsqdxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
						    <div class="col-xs-6 col-sm-3">
						        <div class="input-group input-group-sm">
									<label class="input-group-addon">免费备损比例&nbsp;&nbsp;</label>
									<input type="text" name="mfbsbl"  class="form-control skydisabled" disabled="disabled"/>
							    </div>
						    </div>
						    <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">备损包装&nbsp;&nbsp;</label>
									<select role="select" name="bsbz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('BSBZ')}
									</select>
								</div>
							 </div>
							 <div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="bsbzbz" placeholder="备损包装备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						     <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">跟单备损料走柜&nbsp;&nbsp;</label>
									<select role="select" name="gdbslzg" size="1" class="form-control skyselect skydisabled" disabled="disabled">
									    ${fns:loadDictOption('GDBSZG')}
									</select>
								</div>
							 </div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
						    <div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
								    <label class="input-group-addon">备损备注&nbsp;&nbsp;</label>
									<textarea name="bsxxbz" class="autosize-transition form-control skydisabled" disabled="disabled"></textarea>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">物料清单附件（CBU/SKD/CKD）&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="cbuwlfj" type="file" class="form-control">
									</div>
									<input type="hidden" name="cbuwlfj" />
								</div>
					    	</div>
						</div>
					   <h5 class="header blue" style="margin: 0; padding: 0;">CKD物料清单</h5>
					   <div class="space-4"></div>
					   <div class="row" style="margin: 0px;">
					      <div class="col-xs-6 col-sm-3">
					          <div class="input-group input-group-sm">
									<label class="input-group-addon">物料编码&nbsp;&nbsp;</label>
									<input type="text" id="ckd-wlbm" name="wlbm" class="form-control"/>
						      </div>
						  </div>
						  <div class="col-xs-6 col-sm-3">
					          <div class="input-group input-group-sm">
									<label class="input-group-addon">描述&nbsp;&nbsp;</label>
									<input type="text" id="ckd-ms" name="ms" class="form-control"/>
						      </div>
						  </div>
						  <div class="col-xs-12 col-sm-6">
							  <div class="btn-group">
								  <button id="btn-search" type="button" class="btn btn-info btn-sm">
										<i class="icon-search icon-on-right bigger-110"></i>
										查询
								  </button>
						          <button id="ckd-template-download" type="button" class="btn btn-info btn-sm">
										<i class="icon-download-alt icon-on-right bigger-110"></i>
										模板下载
								  </button>
								 <!--  <button id="ckd-compute" type="button" class="btn btn-info btn-sm" disabled="disabled">
										<i class="icon-ok icon-on-right bigger-110"></i>
										生成明细
								  </button> -->
								  <button id="ckd-import" type="button" class="btn btn-info btn-sm">
										<i class="icon-upload-alt icon-on-right bigger-110"></i>
										导入
								  </button>
								  <button id="ckd-export" type="button" class="btn btn-info btn-sm">
										<i class="icon-download-alt icon-on-right bigger-110"></i>
										导出
								  </button>
								  <!--  <button id="snyc-pidbom" type="button" class="btn btn-info btn-sm" disabled="disabled">
										<i class="icon-download-alt icon-on-right bigger-110"></i>
										同步PID_BOM
								  </button> -->
					          </div>
						  </div>
					   </div>
					   <div class="space-4"></div>
					   <div class="row" style="margin: 0px;">
					     <div class="col-xs-12 col-sm-12">
						   <div id="grid-parent-ckdwl">
								<table id="grid-table-ckdwl"></table>
								<div id="ckdwl-pager"></div>
						    </div>
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
					<!-- 审批日志 -->
				    <div class="space-4"></div>
				    <h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
				    <div class="space-4"></div>
				    <c:import url="/pub/showLog/orderProduct" charEncoding="UTF-8" />
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
	// 变量定义
	var grid_pixx_selector = "#grid-table-pixx";
	var parent_pixx_selector = "#grid-parent-pixx";
	
	var grid_ckdwl_selector = "#grid-table-ckdwl"; 
	var parent_ckdwl_selector = "#grid-parent-ckdwl";
	var ckdwl_pager = "#ckdwl-pager";

	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	// 权限判断
	<shiro:hasPermission name="order:orderProduct:edit">isEdit=true;</shiro:hasPermission>
	// 初始化
	$(function($){
		$(".skyselect").select2();
		$(".date-picker").bindDate();
		// 富文本框初始化(操作API可参照static/umeditor下的index.html)
		UM.getEditor('jbxxbz');
		UM.getEditor('bgbz');
		UM.getEditor('cpqtyqbz');
		UM.getEditor('mgqtyqbz');
		/* $("#form-submit [name=jhrq]").bindDate().on('changeDate', function(e){
			countFgsshrq();
			changeFcst();
		}); */
		/* // 参考订单号选择
		$("#form-submit [name=ckddh]").click(function(){
			selectDdidInit();
		});
		// 关联订单号选择
		$("#form-submit [name=glddh]").click(function(){
			selectGlddhInit();
		});
		// 产品ID选择
		$("#form-submit [name=pid]").click(function(){
			selectPidInit();
		}); */
		//PI选择
		$("#btn-piSelect").click(function(){
		    var width = 1366;
			var height =768;
			var left = 0;
			var top =  0; 
			var ddid = $("#form-submit [name=ddid]").val();
			var pageUrl = "<c:url value='/order/orderReferPi'/>"+"?ddid=" + ddid;
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				var data = window.showModalDialog(pageUrl,null,dialogArgs);
				if(data){
					initPiData(data);
				}
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,resizable=yes,left="+left+"px,top="+top+"px";
				var opener = window.open(pageUrl,null,dialogArgs);
				opener.openerCallBack = function(data){
					initPiData(data);
				}
			}
		});
		// PI明细信息编辑表
		pixxTableInit();
	    //初始化ckd物料明细表
		initCkdwl();
		// ckd导入控件绑定
		$('#ckd-import').click(function(){
			var ddid = $("#form-submit [name=ddid]").val();
			var bbh =  $("#form-submit [name=bbh]").val();
			var sfBg =  $("#form-submit [name=sfBg]").val();
			if(ddid == ""){
				swal("", "请先保存订单！", "warning");
			} else {
				$.importDialog({
					title:"选择文件",
					data: {ddid:ddid, bbh:bbh,sfBg:sfBg},
					url:"<c:url value='/order/orderProduct/ckdImport'/>"
				},{
					callback:function(results){
						$(grid_ckdwl_selector).trigger('reloadGrid');
					}
				});
			}
		});
	    ckdBindExport();
	    bindCkdQueryEvent()
	    /* bindComputeEvent();
		bindCtlxEvent();
		bindGuajiaEvent();
		bindGjbzEvent();
		bindDzbzEvent();
		bindSmsyzEvent();
		bindSpqEvent();
		bindYkqEvent();
		bindFblEvent();
		bindPbzyqEvent();
		bindSnycPidBom();
		//序列号绑定事件
		bindXlhEvent();
		// 销往国家change事件
		$("#form-submit [name=xwgj]").on("change", function(e) {
			countFgsshrq();
		});
		//走货方式change事件
		$('#form-submit [name=zhfs]').on('change',function(e){
			if(e.val == 3){
				$(grid_ckdwl_selector).jqGrid("clearGridData");
				$("#hideSkdCkd").hide();
				//走货方式为CUB，走货不含物件，需单独走货物不可编辑；
				$("#zhbhwj").find(".skycheckbox").prop("disabled","disabled");
				$("#xddzhw").find(".skycheckbox").prop("disabled","disabled");
			}else{
				$("#hideSkdCkd").show();
				$("#zhbhwj").find(".skycheckbox").removeProp("disabled").removeAttr("disabled");
				$("#xddzhw").find(".skycheckbox").removeProp("disabled").removeAttr("disabled");
			}
		}); */
		//数量change事件
		$("#form-submit [name=sl]").on("change", function(e) {
			changeDj();
		});
		// 文件上传控件初始化
		kjlogoUpload();
		shckdjgyqUpload();
		shckdxcxwlmxUpload();
		cpqtyqbzUpload();
		mgqtyqfjUpload();
		ffbsqdfjUpload();
		mfbsqdfjUpload();
		cbuwlUpload();
		// 前端数据校验
		validate();
		// add or edit
		initPageData(id);
		//初始化固定值
		initStaticValue();
		//销往国家
		getXwgj();
		//免费备损事件绑定
		bindMfbsCheck();
	    //模板下载事件绑定
	    bingMbxz();
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
	});
	
	/**************************************************function开始区域************************************************/
	//模板下载
	function bingMbxz(){
	  $('#ckd-template-download').click(function(){
		  window.location.href=encodeURI("<c:url value='/template/ckddrmb.xlsx'/>");
	  })};
    //订单类别绑定验证逻辑
	function ddlbBindValidate(){
		$("#form-submit [name=ddlb]").on("change", function(e) {
		    //只有翻单纯翻单才选参考订单号
		    if($(this).val() == "2" || $(this).val() == "3"){
				 $('#form-submit [name=ckddh]').removeAttr('disabled');
			}else{
				 $('#form-submit [name=ckddh]').val("");
			     $('#form-submit [name=ckddh]').prop('disabled','disabled');
			}
			//翻单，产品信息不可更改
			if($(this).val() == "2"){
				$('#mgxx-tab').find('.skydisabled').removeProp("disabled").removeAttr('disabled');
				$('#cpxx-tab').find('.skydisabled').prop("disabled","disabled");
				$('input [name=fbl]').prop('disabled','disabled');
				//翻单时，产品信息的“屏包装要求”、“SKD/CKD选项”可修改，其他产品信息不可修改
				$('#form-submit [name=pbzyq]').removeProp("disabled").removeAttr('disabled');
				$('#hideSkdCkd').find('.skydisabled').removeProp("disabled").removeAttr('disabled');
			}
			//纯翻单，产品信息和美工信息均不可更改
			if($(this).val() == "3"){
				//设置美工信息相关字段的值
				$("#form-submit [name=bzk]").select2("val",2);
				$("#form-submit [name=hgtz]").select2("val",2);
				$("#form-submit [name=sms]").select2("val",2);
				$("#form-submit [name=zx]").select2("val",3);
				$("#form-submit [name=poptz]").select2("val",2);
				$("#form-submit [name=khlogo]").select2("val",3);
				$("#form-submit [name=ykq]").select2("val",3);
				//$('#mgxx-tab').find(".skydisabled").prop("disabled","disabled");
				$('#cpxx-tab').find('.skydisabled').prop("disabled","disabled");
				//纯翻单时，产品信息的“屏包装要求”、“SKD/CKD选项”可修改，其他产品信息不可修改；美工信息的“序列号”可修改，其他美工信息不可修改
				$('#form-submit [name=pbzyq]').removeProp("disabled").removeAttr('disabled');
				$('#hideSkdCkd').find('.skydisabled').removeProp("disabled").removeAttr('disabled');
				$('#form-submit [name=xlh]').removeProp("disabled").removeAttr('disabled');
			}
			//以上两者都不是，都可编辑
			if($(this).val() != "3"  && $(this).val() != "2"){
				$('#cpxx-tab').find('.skydisabled').removeProp("disabled").removeAttr("disabled");
				$('#mgxx-tab').find('.skydisabled').removeProp("disabled").removeAttr("disabled");
			}
		});
	}
	// 根据国家、走货方式计算分公司收货日期
	function countFgsshrq(){
		var ywlx = $('#form-submit [name=ywlx]').select2("val");
		var xwgj = $('#form-submit [name=xwgj]').select2("val");
		var zhfs = $('#form-submit [name=zhfs]').select2("val");
		var jhrq = $('#form-submit [name=jhrq]').val();
		// 只有品牌分公司业务才可以填写分公司收货日期
		if(ywlx == "3"){
			$('#form-submit [name=fgsshrq]').removeAttr('disabled');
		}else{
			$('#form-submit [name=fgsshrq]').val("");
			$('#form-submit [name=fgsshrq]').prop('disabled','disabled');
		}
		if(ywlx == 3 && xwgj != "" && zhfs != "" && jhrq != ""){
			$.bindAjax({
				url : "<c:url value='/mdm/shippmentDays/search'/>",
				data : {gj : xwgj, zhfs : zhfs},
				action : "search"
			},function(response){
				if(response[0]){
					// 计算天数
					var days = response[0].bgts + response[0].hsts + response[0].qgts + response[0].wxgcts;
					// 计算分公司收货日期
					var jhrqTemp = new Date(jhrq);
					temp = jhrqTemp.valueOf();
					temp += days * 24 * 60 * 60 * 1000;
					var fgsshrq = new Date(temp);
					var year = fgsshrq.getFullYear();
					var month = fgsshrq.getMonth()+1 > 9 ? fgsshrq.getMonth()+1 : "0"+(fgsshrq.getMonth()+1);
					var day = fgsshrq.getDate()>9 ? fgsshrq.getDate() : "0"+fgsshrq.getDate();
					$('#form-submit [name=fgsshrq]').val(year+"-"+month+"-"+day);
				}
			});
		}
	}
	//修改数量，重算单价
	function changeDj(){
		var sl = $('#form-submit [name=sl]').val();
		var je = $('#form-submit [name=je]').val();
		var dj = "";
		if(sl != "" && je != ""){
			dj = parseFloat(je/sl).toFixed(6);
		}
		$('#form-submit [name=dj]').val(dj);
	}
	//是否验货
	function sfYh_show(){
		$('#form-submit [name=sfyhbz]').removeAttr('disabled');
		$('#form-submit [name=yhrq]').removeAttr('disabled');
	}
	function sfYh_hide(){
		$('#form-submit [name=sfyhbz]').val("");
		$('#form-submit [name=yhrq]').val("");
	    $('#form-submit [name=sfyhbz]').prop('disabled','disabled');
	    $('#form-submit [name=yhrq]').prop('disabled','disabled');
	}
	function initFcstData(data){
		if(data.length>0){
			$('#form-submit [name=yczs]').val(data[0].zc);
			$('#form-submit [name=ycrq]').val(data[0].zdsj);
			$('#form-submit [name=ycsl]').val(data[0].ycs);
		}else{
			$('#form-submit [name=yczs]').val("");
			$('#form-submit [name=ycrq]').val("");
			$('#form-submit [name=ycsl]').val("");
		}

	}
	//参考订单号 
	function selectDdidInit(){
		$.tableDialogPage({
			title:"订单ID选择",
			searchCond:[
			            {"name":"参考订单号","value":"ddid"},
			            {"name":"客户","value":"khmc"},
			            {"name":"公司","value":"gsbm"},
			            {"name":"PID","value":"pid"}
			            ],
			colModel:[
			          {name:'id', index:'id',hidden:true},
			          {name:'ddid', index:'ddid', label:'订单号'},
			          {name:'gsbm', index:'gsbm', label:'公司'},
			          {name:'khmc', index:'khmc', label:'客户名称'},
			          {name:'pid', index:'pid', label:'PID'},
			          {name:'zdsj', index:'zdsj', label:'制单时间'}
			          ],
		    url:"<c:url value='/order/orderProduct/search'/>"+"?zt=5"
		},{
			callback:function(rows){
				$.loading();
				if(rows){
					$("#form-submit [name=ckddh]").val(rows.ddid);
					$("#form-submit [name=bzkbz]").val(rows.ddid);
					$("#form-submit [name=hgtzbz]").val(rows.ddid);
					$("#form-submit [name=smsbz]").val(rows.ddid);
					$("#form-submit [name=zxbz]").val(rows.ddid);
					$("#form-submit [name=poptzbz]").val(rows.ddid);
					$("#form-submit [name=khlogobz]").val(rows.ddid);
					$("#form-submit [name=ykqckddh]").val(rows.ddid);
					$("#form-submit [name=mkbz]").val(rows.ddid);
					$("#form-submit [name=zsjbz]").val(rows.ddid);
					$("#form-submit [name=ykqbz]").val(rows.ddid);
					$("#form-submit [name=nxtzbz]").val(rows.ddid);
					$("#form-submit [name=spqtzbz]").val(rows.ddid);
					$("#form-submit [name=mk]").select2("val",3);
					$("#form-submit [name=zsj]").select2("val",3);
					$("#form-submit [name=ykq]").select2("val",3);
					$("#form-submit [name=sms]").select2("val",2);
					$("#form-submit [name=zx]").select2("val",1);
					$("#form-submit [name=hgtz]").select2("val",2);
					$("#form-submit [name=poptz]").select2("val",2);
					$("#form-submit [name=nxtz]").select2("val",2);
					$("#form-submit [name=spqtz]").select2("val",4);
					$("#form-submit [name=bzk]").select2("val",2);
				// 参考订单号不需要赋值的字段
				var array = new Array("id","oper","sjc","bbh","taskId","ddid","ckddh","ddlb","bz",
						"fktj","fktjmc","gjmytk","gjmytkmc","sl","dj","je","ffbsje","zje","xsyid","xsymc",/* "zhfs", */"jhrq",
						"khbm","khmc","cylx","bzkbz","hgtzbz","smsbz","zxbz","poptzbz","khlogobz",
						"ykqckddh","zt","mkbz","zsjbz","ykqbz","nxtzbz","spqtzbz", "mk", "zsj", "ykq", 
						"sms", "hgtz", "poptz", "nxtz", "spqtz", "bzk", "tssapzt","zdrmc","zdsj","sfBg");
				// 根据参考订单号初始化数据
				$.bindAjax({
					url : "<c:url value='/order/orderProduct/findById'/>",
					data : {id : rows.id},
					action : "search"
				},function(response){
					$("#form-submit").find(".skycheckbox").prop("checked","checked");
					var values = $("#form-submit").getFormData();
					$("#form-submit").find(".skycheckbox").removeProp("checked").removeAttr("checked");
					$("#form-submit [name=ddlb]").trigger("change");
					$.each(values, function(name, value){
						var val = response[name];
						var element = $("#form-submit").find("[name="+name+"]");
						// 根据需求某些字段不赋值
						var isContinue = true;
						$.each(array, function(index, value){
							if(value == name){
								isContinue = false;
								return false;
							}
						});
						if(!isContinue){
							return true;
						}
						if(val != null){
							if(element.hasClass("skycheckbox")){
								if(val.toString().indexOf(",") > -1){
									var temp = val.split(",");
									$.each(temp, function(i, n){
										$("#form-submit").find("[name="+name+"][value="+n+"]").prop("checked","checked");
									})
								}else if(val == 1){
									$("#form-submit").find("[name="+name+"][value="+val+"]").prop("checked","checked");
								}else{
									element.removeProp("checked").removeAttr("checked");
								}
							}else if(element.hasClass("skyselect")){
								if(val.toString().indexOf(",") > -1){
									element.val(val.split(",")).trigger("change");
								}else if(val != null){
									element.val(val).trigger("change");
								}
							}else if(element.hasClass("skyradio")){
								$("#form-submit").find("[name="+name+"][value="+val+"]").prop("checked","checked");
							} else {
								element.val(val);
							}
						} else {
							element.val("");
						}
					});
					$.hideLoad();
				});
			   }else{
				   $('#form-submit [name=ckddh]').val("");
			   }
			}
		});
	}  
	//关联订单号
	function selectGlddhInit(){
		$.tableDialogPage({
			title:"订单选择",
			searchCond:[
			            {"name":"参考订单号","value":"ddid"},
			            {"name":"客户名称","value":"khmc"},
			            {"name":"PID","value":"pid"},
			            {"name":"公司","value":"gsbm"}],
			colModel:[
			          {name:'id', index:'id',hidden:true},
			          {name:'ddid', index:'ddid', label:'订单号'},
			          {name:'gsmc', index:'gsmc', label:'公司'},
			          {name:'khmc', index:'khmc', label:'客户名称'},
			          {name:'pid', index:'pid', label:'PID'},
			          {name:'zdsj', index:'zdsj', label:'制单时间'}
			          ],
		    url:"<c:url value='/order/orderProduct/search'/>?zt=5"
		},{
			callback:function(rows){
				if(rows){
					$("#form-submit [name=glddh]").val(rows.ddid);
				}else{
					$("#form-submit [name=glddh]").val("");
				}
			}
		});
	}
	//新建订单，初始化表单固定值
	function initStaticValue(){
		if(id == "null"){
			$("#form-submit [name=ddlb]").select2("val",1);
			$("#form-submit [name=ckddh]").prop('disabled','disabled');
			$("#form-submit [name=ddlx]").val(1);
			$("#form-submit [name=ddlxmc]").val("大货订单");
			// 防火料默认后壳
			$("#form-submit [name=fhlHk]").prop("checked","checked");
			//产品信息初始化固定值
			$("#form-submit [name=ctlxbz]").prop("disabled","disabled");
			$("#form-submit [name=gjbzbz]").prop("disabled","disabled");
			$("#form-submit [name=dzbzbz]").prop("disabled","disabled");
			$("#form-submit [name=fblbz]").prop("disabled","disabled");
			$('#form-submit [name=pbzyqbz]').prop('disabled','disabled');
			$('#form-submit [name=fhlbz]').prop('disabled','disabled');
			$('#form-submit [name=spqtz]').select2('val',8);
			//美工信息初始化固定值
			$("#form-submit [name=bzk]").select2("val",1);
			$("#form-submit [name=hgtz]").select2("val",2);
			$("#form-submit [name=sms]").select2("val",2);
			$("#form-submit [name=ykq]").select2("val",3);
			$("#form-submit [name=zx]").select2("val",1);
			$("#form-submit [name=poptz]").select2("val",1);
			$("#form-submit [name=khlogo]").select2("val",1);
			$("#form-submit [name=scjd]").select2("val",2110);
		}
	};
	// PID选择
	function selectPidInit(){
		$.tableDialogPage({
			title:"PID选择",
			searchCond:[{"name":"PID","value":"pid"},
			            {"name":"机型","value":"jixing"},
			            {"name":"机芯","value":"jixin"}],
			colModel:[{name:'pid', index:'pid', label:'PID', width:80},
			          {name:'khmc', index:'khmc', label:'客户名称', width:80},
			          {name:'pp', index:'pp', label:'品牌名称', width:80},
			          {name:'jixing', index:'jixing', label:'机型', width:80},
			          {name:'jixin', index:'jixin', label:'机芯', width:80},
			          {name:'zdrmc', index:'zdrmc', label:'申请人', width:80}
			        ],
			url:"<c:url value='/pub/widget/findPid'/>"
		},{
			callback:function(rows){
				if(rows){
					/*
					var jixin = $('input[name=jixin]').val();
					var jixing = $('input[name=wsxh]').val();
					//如果PI的机型和机芯都不为空，那么和客户选的PID对应的校验，如果为空，则将用户选择的PID的机型和机芯赋值给PI明细
					if(jixin && jixin.length>0 && jixing && jixing.length>0 ){
						// 检查PID型号机芯和PI的所选内容是否一致
						if(!(rows.jixing == jixing)){
							swal("", "该PID的机型和我司型号不一致，请重新选择PID！", "warning");
							return false;
						}
						if(!(rows.jixin == jixin )){
							swal("", "该PID的机芯和PI的机芯不一致，请重新选择PID！", "warning");
							return false;
						}
					}else{
						$('input[name=jixin]').val(rows.jixin);
					    $('input[name=wsxh]').val(rows.jixing);
					};
					*/
					$('input[name=jixin]').val(rows.jixin);
				    $('input[name=wsxh]').val(rows.jixing);
					// 根据所选PID赋值相关信息
					$("input[name=pid]").val(rows.pid);
					//除了CUB之外的其他走货方式，走货不含物件，需单独走货物可编辑；
					if(rows.zhfs != "3"){
						$("#zhbhwj").find(".skycheckbox").removeProp("disabled").removeAttr("disabled");
						$("#xddzhw").find(".skycheckbox").removeProp("disabled").removeAttr("disabled");
					}else{
						$("#zhbhwj").find(".skycheckbox").prop("disabled","disabled");
						$("#xddzhw").find(".skycheckbox").prop("disabled","disabled");
					}
					if(rows.zhfs == "3"){
						$("#hideSkdCkd").hide();
					}else{
						$("#hideSkdCkd").show();
					}
					$("#form-submit [name=zhfs]").select2("val",rows.zhfs);
					$("#form-submit [name=fbl]").select2("val",rows.fbl);
					$("#form-submit [name=ctlx]").select2("val",rows.ctlx);
					checkBoxBindDate(rows);
					$("#form-submit [name=paomo]").select2("val",rows.paomo);
					$("#form-submit [name=guajia]").select2("val",rows.guajia);
					$("#form-submit [name=gjbz]").select2("val",rows.gjbz);
					$("#form-submit [name=dzbz]").select2("val",rows.dzbz);
					$("#form-submit [name=ggmx]").select2("val",rows.ggmx);
					if( rows.fbl == "4" ){
						$('#form-submit [name=fblbz]').removeProp("disabled").removeAttr('disabled');
					}else{
						$('#form-submit [name=fblbz]').prop('disabled','disabled');
					}
					if( rows.gjbz == "3" ){
						$('#form-submit [name=gjbzbz]').removeProp("disabled").removeAttr('disabled');
					}else{
						$('#form-submit [name=gjbzbz]').prop('disabled','disabled');
					}
					if( rows.dzbz == "3" ){
						$('#form-submit [name=dzbzbz]').removeProp("disabled").removeAttr('disabled');
					}else{
						$('#form-submit [name=dzbzbz]').prop('disabled','disabled');
					}
					if(rows.guajia == "2"){
						$("#form-submit [name=gjbz]").prop('disabled','disabled');
						$("#form-submit [name=guajiabz]").prop('disabled','disabled');
						
					}else{
						$('#form-submit [name=gjbz]').removeProp("disabled").removeAttr('disabled');
						$('#form-submit [name=guajiabz]').removeProp("disabled").removeAttr('disabled');
					}
					// 判断交货日期是否为空来判断预测
					if($('#form-submit [name=jhrq]').val().length==0){
						$('#form-submit [name=yczs]').val("");
						$('#form-submit [name=ycrq]').val("");
						$('#form-submit [name=ycsl]').val("");
					}else{
						changeFcst();
					}
				}
			}
		});
	}
	/************************文件上传控件初始化开始********************************/
	//开机logo
	function kjlogoUpload(){
		$('#kjlogofj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#kjlogofj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#kjlogofjxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=kjlogofj]").val($('#kjlogofjxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#kjlogofjxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=kjlogofj]").val($('#kjlogofjxx').html());
				}
			});
		});
	}
	//shckd  加工要求
	function shckdjgyqUpload(){
		$('#shckdjgyqbz').uploadify($.extend($.lfsUploadOptions, {
			width : $('#shckdjgyqbz').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#shckdjgyqbzfjxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=shckdjgyqbz]").val($('#shckdjgyqbzfjxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#shckdjgyqbzfjxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=shckdjgyqbz]").val($('#shckdjgyqbzfjxx').html());
				}
			});
		});
	}
	//shckd  明细要求
	function shckdxcxwlmxUpload(){
		$('#shckdxcxwlmxfj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#shckdxcxwlmxfj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#shckdxcxwlmxfjxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=shckdxcxwlmxfj]").val($('#shckdxcxwlmxfjxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#shckdxcxwlmxfjxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=shckdxcxwlmxfj]").val($('#shckdxcxwlmxfjxx').html());
				}
			});
		});
	}
	//产品其他要求备注
	function cpqtyqbzUpload(){
		$('#cpqtyqfj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#cpqtyqfj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#cpqtyqfjxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=cpqtyqfj]").val($('#cpqtyqfjxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#cpqtyqfjxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=cpqtyqfj]").val($('#cpqtyqfjxx').html());
				}
			});
		});
	}
	//美工其他要求备注
	function mgqtyqfjUpload(){
		$('#mgqtyqfj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#mgqtyqfj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#mgqtyqfjxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=mgqtyqfj]").val($('#mgqtyqfjxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#mgqtyqfjxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=mgqtyqfj]").val($('#mgqtyqfjxx').html())
				}
			});
		});
	}
	// 付费备损清单
	function ffbsqdfjUpload(){
		$('#ffbsqdfj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#ffbsqdfj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#ffbsqdxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=ffbsqdfj]").val($('#ffbsqdxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#ffbsqdxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=ffbsqdfj]").val($('#ffbsqdxx').html());
				}
			});
		});
	}
	// 免费备损清单
	function mfbsqdfjUpload(){
		$('#mfbsqdfj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#mfbsqdfj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#mfbsqdxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=mfbsqdfj]").val($('#mfbsqdxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#mfbsqdxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=mfbsqdfj]").val($('#mfbsqdxx').html());
				}
			});
		});
	}
	//CBU物料清单
	function cbuwlUpload(){
		$('#cbuwlfj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#cbuwlfj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#cbuwlxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=cbuwlfj]").val($('#cbuwlxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#cbuwlxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=cbuwlfj]").val($('#cbuwlxx').html());
				}
			});
		});
	}
	/************************文件上传控件初始化区域开始结束*****************************/
	//免费备损绑定校验
	function bindMfbsCheck(){
		$('#form-submit [name=mfbs]').on('change',checkMfbs) ;
	}
	//免费备损绑定校验
	function checkMfbs(){
		 var zhfs = $('#form-submit [name=zhfs]').select2('val');
		 var mfbs = $('#form-submit [name=mfbs]').select2('val');
		 if(zhfs=='1' && mfbs=='1' ){
			 swal('','走货方式是CKD不能选择跟单标准备损','warning');
			 return ;
		 }
	}
	//导出ckd明细
	function ckdBindExport(){
		$("#ckd-export").click(function(){
		    var curNum=$(grid_ckdwl_selector).getGridParam("records");
		    var id = $("#form-submit [name=id]").val();
		    if(curNum==0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#ckd-export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_ckdwl_selector).exportExcel({url: "<c:url value='/order/orderProduct/ckdExport'/>"+"?id="+id});
	    			}
	    		});
	        }
		});
	}
	//ckd查询绑定 
	 function bindCkdQueryEvent(){
		 $("#btn-search").click(function(){
			 queryEvent();
		});
	 };
	 //已移除和未移除查询按钮
	 function queryEvent(){
		 var postData  = $(grid_ckdwl_selector).getGridParam("postData");
		 var wlbm = $('#ckd-wlbm').val();
		 var ms = $('#ckd-ms').val(); 
		 postData.wlbm = wlbm;
		 postData.ms = ms; 
		 $(grid_ckdwl_selector).setGridParam({postData: postData}).trigger("reloadGrid");
	 }
	/* // ckd生成明细按钮
	function bindComputeEvent(){
		$("#ckd-compute").click(function(){
			var param = $("#form-submit").getFormData();
			if(param.ddid == ""){
				swal("", "请先保存订单！", "warning");
			} else {
				$("body").bindSweetAlert({
					title:"生成明细会清除掉已有ckd明细，确定要执行此操作？"
				},{
					callback:function(){
						$.bindAjax({
							url:"<c:url value='/order/orderProduct/computeCkd'/>",
							data:param,
							action:"save"
						},function(response){
							$(grid_ckdwl_selector).trigger('reloadGrid');
						});
					} 
				});
		  }
		});
	} */
	
	/* //同步PID_BOM 
	function bindSnycPidBom(){
		$("#snyc-pidbom").click(function(){
			var param = $("#form-submit").getFormData();
			//param.pid = "PI0001";
			if(param.pid.length == 0){
				swal("","请先选择PID","warning");
				return  ;
			}
			if(param.ddid == ""){
				swal("", "请先保存订单！", "warning");
			} else {
				$.bindAjax({
					url:"<c:url value='/order/orderProduct/snycPidBom'/>",
					data:param,
					action:"save"
				},function(response){
					
				});
			}
		});
	} */
	// CKD物料清单
	function initCkdwl(){
		$(grid_ckdwl_selector).bindTable({
			caption: "",
			pager: ckdwl_pager,
			gridParent: parent_ckdwl_selector,
		    //multiselect: true,
		    rowList: [15, 50, 100],
		    rowNum:10,
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', index:'id', label:'ID', hidden:true, formoptions:{rowpos: 1, colpos: 1}},
				{name:'flag', index:'flag', label:'操作类型', width:80, editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('CZLX')}", dataInit:initSelect2}, formoptions:{rowpos: 2, colpos: 1}},
				{name:'wlbm', index:'yzhlx', label:'物料编码', width:130, formoptions:{rowpos: 2, colpos: 2}}, 
				{name:'ms', index:'ms', label:'描述', width:80, formoptions:{rowpos: 2, colpos: 3}},
				{name:'sfYj', index:'sfYj', label:'是否样机', width:80, editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"0:否;1:是"}, formoptions:{rowpos: 3, colpos: 1}},
				{name:'djyl', index:'djyl', label:'单机用量', width:80, align:'right', formatter:'integer',
					formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 3, colpos: 2}},
				{name:'sdjysl', index:'sdjysl', label:'上单结余数量',width:80, align:'right', formatter:'number',
					formatoptions:{thousandsSeparator: ','},formoptions:{rowpos: 3, colpos: 3}},
				{name:'dhsl', index:'dhsl', label:'大货数量', width:80, align:'right', formatter:'number',
					formatoptions:{thousandsSeparator: ','},formoptions:{rowpos: 4, colpos: 1}},
				{name:'mfbssl', index:'mfbssl', label:'免费备损数量', width:80, align:'right', formatter:'number',
					formatoptions:{thousandsSeparator: ','},formoptions:{rowpos: 4, colpos: 2}},
				{name:'ffbssl', index:'ffbssl', label:'付费备损数量', width:80, align:'right', formatter:'number',
					formatoptions:{thousandsSeparator: ','},formoptions:{rowpos: 4, colpos: 3}},
				{name:'moqsl', index:'moqsl', label:'MOQ数量', width:80, align:'right', formatter:'integer',
					formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 5, colpos: 1}},
				{name:'xdsl', index:'xdsl', label:'下单数量', width:80, align:'right', formatter:'number',
					formatoptions:{thousandsSeparator: ','},formoptions:{rowpos: 5, colpos: 2}},
				{name:'sapdhddsl', index:'sapdhsl', label:'SAP大货订单数量', width:80, align:'right', formatter:'number',
					formatoptions:{thousandsSeparator: ','},formoptions:{rowpos: 5, colpos: 3}},
				{name:'bdjysl', index:'sapdhsl', label:'本单结余数量', width:80, align:'right', formatter:'number',
					formatoptions:{thousandsSeparator: ','},formoptions:{rowpos: 6, colpos: 1}},
				{name:'ne', index:'ne', label:'NE', width:80, formoptions:{rowpos: 6, colpos: 2}},
				{name:'po', index:'po', label:'PO', width:80, formoptions:{rowpos: 6, colpos: 3}},
				{name:'ncmcode', index:'NCM CODE', label:'NCM CODE', width:80, formoptions:{rowpos: 7, colpos: 1}},
				{name:'ncm', index:'ncm', label:'NCM', width:80, formoptions:{rowpos: 7, colpos: 2}},
				{name:'bz', index:'bz', label:'币种', width:80, formoptions:{rowpos: 7, colpos: 3}},
				{name:'dw', index:'dw', label:'单位', width:80, formoptions:{rowpos: 8, colpos: 1}},
				<shiro:hasPermission name="order:orderProduct:price">
				{name:'dj', index:'dj', label:'单价', width:80, align:'right', formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:4},
					editoptions:{disabled:true},formoptions:{rowpos: 8, colpos: 2}},
			    </shiro:hasPermission>
				{name:'jz', index:'jz', label:'净重', width:80, align:'right', formoptions:{rowpos: 8, colpos: 3}},
				{name:'mz', index:'mz', label:'毛重', width:80, align:'right', formoptions:{rowpos: 9, colpos: 1}},
				{name:'gysbm', index:'gysbm', label:'供应商编码', width:80, formoptions:{rowpos: 9, colpos: 2}},
				{name:'gysmc', index:'gysmc', label:'供应商名称', width:80, formoptions:{rowpos: 9, colpos: 3}},
				{name:'gysdz', index:'gysdz', label:'供应商地址', width:80, formoptions:{rowpos: 10, colpos: 1}},
				{name:'ycd', index:'ycd', label:'原产地', width:80, formoptions:{rowpos: 10, colpos: 2}},
				{name:'pid', index:'pid', label:'PID', width:80, formoptions:{rowpos: 10, colpos: 3}}
			]
		},{
			add:true,
			edit:true,
			view:false,
			del:false
		});
	}
	// PI明细信息编辑表
	function pixxTableInit(){
		$(grid_pixx_selector).bindTable({
			caption: "",
			gridParent: parent_pixx_selector,
			//shrinkToFit: false,
			//autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'piid', index:'piid', label:'PI号', width:80},
				{name:'pilx', index:'pilx', label:'PI类型', hidden: true, width:80},
				{name:'pilxmc', index:'pilxmc', label:'PI类型', width:80},
				{name:'piitemid', index:'piitemid', label:'PI明细id', hidden: true, width:80},
				{name:'mxlx', index:'mxlx', label:'明细类型', width:80, hidden: true},
				{name:'mxlxmc', index:'mxlxmc', label:'明细类型', width:80},
				{name:'pid', index:'pid', label:'PID', width:60},
				{name:'khxhms', index:'khxhms', label:'客户型号描述', width:80},
				{name:'jixing', index:'jixing', label:'机型', width:80},
				{name:'jixin', index:'jixin', label:'机芯', width:80},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:60},
				{name:'bz', index:'bz', label:'币种', width:80},
				{name:'sl', index:'sl', label:'大货数量', align:'right', width:60, 
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'yjsl', index:'yjsl', label:'收费样机数量', align:'right', width:80, 
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				<shiro:hasPermission name="order:orderProduct:price">
				{name:'dj', index:'dj', label:'单价', align:'right', width:60, 
					formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6},editrules:{number:true}},
				</shiro:hasPermission>
				{name:'khbm', index:'khbm', label:'客户编码', width:80, hidden:true},
				{name:'khmc', index:'khmc', label:'客户名称', width:80, hidden:true},
				{name:'gsbm', index:'gsbm', label:'公司编码', width:60, hidden:true},
				{name:'ks', index:'ks', label:'款式', width:80, hidden:true},
				{name:'ksmc', index:'ksmc', label:'款式名称', width:80, hidden:true},
				{name:'fktj', index:'fktj', label:'付款条件', width:80, hidden:true},
				{name:'fktjmc', index:'fktjmc', label:'付款条件名称', width:80, hidden:true},
				{name:'xsyid', index:'xsyid', label:'销售员ID', width:80, hidden:true},
				{name:'xsymc', index:'xsymc', label:'销售员名称', width:80, hidden:true},
				{name:'xszz', index:'xszz', label:'销售组织', width:80, hidden:true},
				{name:'xszzmc', index:'xszzmc', label:'销售组织名称', width:80, hidden:true},
				{name:'ywz', index:'ywz', label:'业务组', width:80, hidden:true},
				{name:'ywzmc', index:'ywzmc', label:'业务组名称', width:80, hidden:true},
				{name:'zhfs', index:'zhfs', label:'走货方式', width:80, hidden:true},
				{name:'gjmytk', index:'gjmytk', label:'国际贸易条款', width:80, hidden:true},
				{name:'gjmytkmc', index:'gjmytkmc', label:'国际贸易条款', width:80, hidden:true},
				{name:'gjmytkbz', index:'gjmytkbz', label:'国际贸易条款备注', width:80, hidden:true },
				{name:'cylx', index:'cylx', label:'出运类型', width:80, hidden:true},
				{name:'cylxmc', index:'cylxmc', label:'出运类型', width:80, hidden:true},
				{name:'DelBtn', index:'DelBtn', label:'删除', width:40, editable:false}
			],
		   	gridComplete: function(){
				var ids = $(grid_pixx_selector).jqGrid('getDataIDs');
	            for(var i=0;i < ids.length;i++) {
					var delBtn = "<a href='javascript:void(0);' class='btn btn-danger btn-xs' onclick='javascript:delPI(\""+ids[i]+"\");' >删除</a>";
	                $(grid_pixx_selector).setRowData(ids[i],{DelBtn:delBtn});
	            }
		   	}
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
			ignore: 'input[type=hidden]',
			rules: {
				sl: { required:true , number:true },
				dj: { required:true , number:true },
				gjmytk: 'required',
				qd:'required'
			},
			messages: {
				sl: '数量必填且必为数字',
				dj: '单价必填且必为数字',
				gjmytk: '国际贸易条款不能为空',
				qd:'渠道未填写'
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
	}
	// add or edit
	function initPageData(id){
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=ddlx]").val("110001");
			$("#form-submit [name=zt]").val("1");
			$("#form-submit [name=sfBg]").val("0");
			initCkdGrid();
			sfYh_hide();
		} else {
			$.loading();
			$.bindAjax({
				url : "<c:url value='/order/orderProduct/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				// 富文本框赋值
				if(response.jbxxbz){
					UM.getEditor('jbxxbz').setContent(response.jbxxbz);
				}
				if(response.bgbz){
					UM.getEditor('bgbz').setContent(response.bgbz);
				}
				if(response.cpqtyqbz){
					UM.getEditor('cpqtyqbz').setContent(response.cpqtyqbz);
				}
				if(response.mgqtyqbz){
					UM.getEditor('mgqtyqbz').setContent(response.mgqtyqbz);
				}
				// 变更草稿编辑时，客户、币种、付款条件、走货方式、PID、生产基地不允许修改
				if(response.sfBg == 1 || response.sfCh == 1){
					$("#form-submit [name=scjd]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit [name=zhfs]").prop("disabled","disabled").addClass("skydisabled");
					$("#form-submit [name=pid]").prop("disabled","disabled").addClass("skydisabled");
					$('.changeJeSelect').show();//驳回时选择修改金额还是单价
					$("#form-submit [name=slje][value=0]").prop("checked","checked");//默认修改金额
				}
				$("#kjlogofjxx").html(response.kjlogofj);
				$("#shckdjgyqbzfjxx").html(response.shckdjgyqbz);
				$("#shckdxcxwlmxfjxx").html(response.shckdxcxwlmxfj);
				$("#cpqtyqfjxx").html(response.cpqtyqfj);
				$("#mgqtyqfjxx").html(response.mgqtyqfj);
				$("#ffbsqdxx").html(response.ffbsqdfj);
				$("#mfbsqdxx").html(response.mfbsqdfj);
				$("#cbuwlfj").html(response.cbuwlfj);
				if(response.sfYh == 0){
					sfYh_hide();
				} else {
					sfYh_show();
				}
				//挂架初始化时
// 				if(response.guajia != "2"){
// 					$('#form-submit [name=gjbz]').removeAttr('disabled');	
// 					$('#form-submit [name=guajiabz]').removeAttr('disabled');
// 				}else{
// 					$('#form-submit [name=gjbz]').attr('disabled','disabled');
// 					$('#form-submit [name=guajiabz]').attr('disabled','disabled');
// 				}
// 				//序列号初始化
// 				if(response.xlh != "1"){
// 					$('#form-submit [name=xlhbz]').removeAttr('disabled');
// 				}else{
// 					$('#form-submit [name=xlhbz]').attr('disabled','disabled');
// 				}
				// 加载PI明细
				if(response.orderReferPiList){
					$(grid_pixx_selector).jqGrid("addRowData", null, response.orderReferPiList, "last");
				}
				$("#form-submit [name=oper]").val("edit");
				$("#form-submit [name=taskId]").val(taskId);
				initCkdGrid();
				var sfbj = $("#form-submit [name=sfBg]").val();
				if(!sfbj || sfbj.length == 0){
					 $("#form-submit [name=sfBg]").val("0");
				}
				$.hideLoad();
			});
		}
		
	}
	
	//初始化ckd两个表格
	function initCkdGrid(){
		// 未移除ckd物料
		$(grid_ckdwl_selector).setGridParam({
			url: "<c:url value='/order/orderProduct/queryCkd'/>",
			editurl: "<c:url value='/order/orderProduct/editCkd'/>",
			postData: {
						ddid: $("#form-submit [name=ddid]").val(),
						bbh: $("#form-submit [name=bbh]").val()
				     	//sfYc: 0
		     	     },
	     	editPostData: {ddid: $("#form-submit [name=ddid]").val(),
				bbh: $("#form-submit [name=bbh]").val()},
		}).trigger("reloadGrid");
	}
	// 保存
	function save(){
		//去掉ckd物料编辑时产生的表单，防止验证时表单嵌表单报错
		$('#FrmGrid_grid-table-ckdwl').remove();
		var data = $(grid_pixx_selector).getRowData();
		if(data.length == 0){
			swal('未选择任何PI');
			return ;
		}
		//检查走货方式和屏包装要求是否匹配
		//走货方式 1：CKD 2：SKD 3：CBU
		//屏包装要求：1 ：单独包装出货 2：假整机 3：CKD模组 4：整机 5：其他
		var zhfs = $('#form-submit [name=zhfs]').select2("val");
		var pbzyq = $('#form-submit [name=pbzyq]').select2('val');
		if((zhfs ==1 || zhfs ==2) && (pbzyq==4 || pbzyq==5   )){
			swal('走货方式和屏包装要求不匹配');
			return  ;
		}
		if(zhfs ==3 && (pbzyq==1 || pbzyq==2 || pbzyq==3)){
			swal('走货方式和屏包装要求不匹配');
			return  ;
		}
		//检查免费备损和走货方式是否通过
		checkMfbs();
        //表单数据验证
		if(!$('#form-submit').valid()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
		if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		var param = $('#form-submit').getFormData();
		// 富文本框取值
		param.jbxxbz = UM.getEditor('jbxxbz').getContent();
		param.bgbz = UM.getEditor('bgbz').getContent();
		param.cpqtyqbz = UM.getEditor('cpqtyqbz').getContent();
		param.mgqtyqbz = UM.getEditor('mgqtyqbz').getContent();
	    $("#form-submit [name=ddlb]").trigger("change");
		param.piList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/order/orderProduct/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=ddid]").val(result.ddid);
					$("#form-submit [name=yddid]").val(result.yddid);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
				    $('#form-submit [name=token]').val(result.token);
				    $(grid_ckdwl_selector).trigger('clearGridData');
				    initCkdGrid();
				   
				  
				});
			} 
		});
	}
	// 提交
	function submit(){
		var data = $(grid_pixx_selector).getRowData();
		if(data.length == 0){
			swal('未选择任何PI');
			return ;
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
		// 富文本框取值
		param.jbxxbz = UM.getEditor('jbxxbz').getContent();
		param.bgbz = UM.getEditor('bgbz').getContent();
		param.cpqtyqbz = UM.getEditor('cpqtyqbz').getContent();
		param.mgqtyqbz = UM.getEditor('mgqtyqbz').getContent();
		var data = $(grid_pixx_selector).getRowData();
		param.piList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/order/orderProduct/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	//分辨率事件绑定
	function bindFblEvent(){
		$('#form-submit [name=fbl]').on('change',function(e){
			$("#fblbz").val("");
			if(e.val != 4){
				$('#form-submit [name=fblbz]').attr('disabled','disabled');
			}else{
				$('#form-submit [name=fblbz]').removeAttr('disabled');
			}
		});
	}
	//屏包装要求
	function bindPbzyqEvent(){
		$('#form-submit [name=pbzyq]').on('change',function(e){
			if(e.val != 5){
				$('#form-submit [name=pbzyqbz]').attr('disabled','disabled');
			}else{
				$('#form-submit [name=pbzyqbz]').removeAttr('disabled');
			}
		});
	}
	function bindCtlxEvent(){
		$('#form-submit [name=ctlx]').on('change',function(e){
			if(e.val != 5){
				$('#form-submit [name=ctlxbz]').attr('disabled','disabled');
			}else{
				$('#form-submit [name=ctlxbz]').removeAttr('disabled');
			}
		});
	}
	
	//挂架绑定事件
	function bindGuajiaEvent(){
		$('#form-submit [name=guajia]').on('change',function(e){
			if(e.val != 2){
				$('#form-submit [name=gjbz]').removeAttr('disabled');	
				$('#form-submit [name=guajiabz]').removeAttr('disabled');
			}else{
				$('#form-submit [name=gjbz]').attr('disabled','disabled');
				$('#form-submit [name=guajiabz]').attr('disabled','disabled');
			}
		});
	}
	//挂架包装绑定事件
	function bindGjbzEvent(){
		$('#form-submit [name=gjbz]').on('change',function(e){
			if(e.val != 3){
				$('#form-submit [name=gjbzbz]').attr('disabled','disabled');
			}else{
				$('#form-submit [name=gjbzbz]').removeAttr('disabled');
			}
		});
	}
	//底座包装事件绑定
	function bindDzbzEvent(){
		$('#form-submit [name=dzbz]').on('change',function(e){
			if(e.val != 3){
				$('#form-submit [name=dzbzbz]').attr('disabled','disabled');
			}else{
				$('#form-submit [name=dzbzbz]').removeAttr('disabled');
			}
		});
	}
	//说明书语种绑定事件
	function bindSmsyzEvent(){
		$('#form-submit [name=sms]').on('change',function(e){
			if(e.val != 1){
				$('#form-submit [name=smsyz]').attr('disabled','disabled');
			}else{
				$('#form-submit [name=smsyz]').removeAttr('disabled');
			}
		});
	}
	//遥控器选项
	function bindYkqEvent(){
		$('#form-submit [name=ykq]').on('change',function(e){
			if(e.val != 2){
				$('#form-submit [name=qtyqbz]').prop('disabled','disaled');
			}else{
				$('#form-submit [name=qtyqbz]').removeProp("disabled").removeAttr('disabled');
			}
		});
	}
	//适配器切换事件绑定sfSpq
	function bindSpqEvent(){
		$('#form-submit [name=sfSpq]').click(function(){
			var value = $("input[name='sfSpq']:checked").val();
			if(value == 0){
				$('#form-submit [name=spqtz]').select2("val",8);
			}else{
				$('#form-submit [name=spqtz]').select2("val","");
			}
		});
	}
	//序列号切换事件绑定
	function bindXlhEvent(){
		$('#form-submit [name=xlh]').on('change',function(e){
			if(e.val == 1){
				$('#form-submit [name=xlhbz]').prop('disabled','disaled');
			}else{
				$('#form-submit [name=xlhbz]').removeProp("disabled").removeAttr('disabled');
			}
		});
	}
	//变更时检验订单里的PID、走货方式、客户编码、币种、付款条件、公司编码所选PI是否一致
	function validatePiData(data){
		var pid = $('#form-submit [name=pid]').val();
		//var zhfs = $('#form-submit [name=zhfs]').val();
		var khbm = $('#form-submit [name=khbm]').val();
		var bz = $('#form-submit [name=bz]').val();
		var fktj = $('#form-submit [name=fktj]').val();
		var gsbm = $('#form-submit [name=gsbm]').val();
		var isSame = false;
		$.each(data,function(index,rowData){
			/* alert(rowData.pid+","+pid);
			alert(rowData.khbm+","+khbm);
			alert(rowData.bz+","+bz);
			alert(rowData.fktj+","+fktj);
			alert(rowData.gsbm+","+gsbm); */
   			//变更时PID、客户编码、币种、付款条件、公司编码不允许变更
   			if(rowData.pid == null || rowData.pid == ""){
   				if(rowData.khbm == khbm && rowData.bz == bz && rowData.fktj == fktj 
   						&& rowData.gsbm == gsbm){
   	   				isSame = true ;
   	   			}
   			}else {
   				if(rowData.pid == pid && rowData.khbm == khbm && rowData.bz == bz 
   						&& rowData.fktj == fktj && rowData.gsbm == gsbm){
   	   				isSame = true ;
   	   			}
   			}
   	   });
	   return isSame;
	}
	// 初始化PI数据
	function initPiData(data){
		// 获取PI信息
		var piData = $(grid_pixx_selector).getRowData();
		var sfCh = $("#form-submit [name=sfCh]").val();
		//alert("sfch="+sfCh);
		if(!validatePiData(data) && sfCh != 1){
			swal("","所选PID、客户、币种、付款条件、公司编码与原订单不一致","warning");
			return;
		} 
		if(piData.length > 0){
	       	$.each(data,function(index,rowData){
	       		var isExists = false ;
	       		$.each(piData,function(i,value){
	       			if(rowData.piitemid == value.piitemid){
	       				isExists = true ;
	       			}
	       		});
	       		if(!isExists){
	       			// 添加数据到编辑表
	       			$(grid_pixx_selector).jqGrid("addRowData", rowData.piitemid, rowData, "last");
	       		}
       	   });
		}else{
			// 添加数据到编辑表
   			$(grid_pixx_selector).jqGrid("addRowData", null, data, "last");
		}
		// 根据所选PI计算金额和赋值
		piCollect();
		// 判断交货日期是否为空来判断预测
		if($('#form-submit [name=jhrq]').val().length==0){
			$('#form-submit [name=yczs]').val("");
			$('#form-submit [name=ycrq]').val("");
			$('#form-submit [name=ycsl]').val("");
		}else{
			changeFcst();
		}
	}
	// 删除Pi明细
	function delPI(id){
		// 删除本行数据
		$(grid_pixx_selector).jqGrid("delRowData", id);
		// 根据PI信息计算金额和赋值
		piCollect();
	}
	// 根据所选PI计算金额和赋值
	function piCollect(){
		// 获取PI信息
		var piData = $(grid_pixx_selector).getRowData();
		var _data = [];
		var xdsl = 0;
		var yjsl = 0;
		var je = 0;
		var ffbsje = 0;
		var zje = 0;
		// 判断是否存在整机或屏
		var bZJP = false;
		var firstMxlx = "";
		$.each(piData,function(i,j){
			if(piData[i].mxlx == '1' || piData[i].mxlx == '2'){
				bZJP = true;
				return false;
			}
		});
		$.each(piData,function(i,j){
			if(piData[i].pilx != '2' && piData[i].mxlx != '4'){
				_data[0] = piData[i];
				firstMxlx = piData[i].mxlx;
				return false;
			}
		});
		$.each(piData,function(i,j){
			if(!bZJP){
				// 无整机或屏
				if(piData[i].pilx != '2' && piData[i].mxlx == firstMxlx){
					xdsl += parseInt(piData[i].sl);
					yjsl += parseInt(piData[i].yjsl);
				}
			} else {
				// 有整机或屏
				if(piData[i].pilx != '2'){
					// 数量只汇总整机和屏的数量
					if(piData[i].mxlx == '1' || piData[i].mxlx == '2'){
						xdsl += parseInt(piData[i].sl);
						yjsl += parseInt(piData[i].yjsl);
					}
				}
			}
			if(piData[i].pilx != '2'){
				//大货PI中，明细项是备损的金额
				if(piData[i].mxlx=='4'){
					ffbsje += parseInt(piData[i].sl)*(parseFloat(piData[i].dj)*1000000)/1000000;
				}else{
					je += (parseInt(piData[i].sl) + parseInt(piData[i].yjsl))*(parseFloat(piData[i].dj)*1000000)/1000000;
				}
			}else{
				//如果是备损PI则全部累计
				ffbsje += parseInt(piData[i].sl)*(parseFloat(piData[i].dj)*1000000)/1000000;
			}
		});
		zje = parseFloat(ffbsje+je);
		// 页面赋值开始
		if(_data.length > 0){
			//$("#form-submit [name=scjd]").select2("val",_data[0].scjd);
			if(_data[0].gsbm && _data[0].gsbm.length>0){
				$("#form-submit [name=gsbm]").val(_data[0].gsbm);
			}
			if(_data[0].xsyid && _data[0].xsyid.length>0){
				$("#form-submit [name=xsyid]").val(_data[0].xsyid);
				$("#form-submit [name=xsymc]").val(_data[0].xsymc);
			}
			if(_data[0].ywz && _data[0].ywz.length>0){
				$("#form-submit [name=ywz]").val(_data[0].ywz);
				$("#form-submit [name=ywzmc]").val(_data[0].ywzmc);
			}
			if(_data[0].xszz && _data[0].xszz.length>0){
				$("#form-submit [name=xszz]").val(_data[0].xszz);
				$("#form-submit [name=xszzmc]").val(_data[0].xszzmc);
			}
			if(_data[0].khbm && _data[0].khbm.length>0){
				$("#form-submit [name=khbm]").val(_data[0].khbm);
				$("#form-submit [name=khmc]").val(_data[0].khmc);
			}
			if(_data[0].bz && _data[0].bz.length>0){
				$("#form-submit [name=bz]").val(_data[0].bz);
			}
			if(_data[0].fktj && _data[0].fktj.length>0){
				$("#form-submit [name=fktj]").val(_data[0].fktj);
				$("#form-submit [name=fktjmc]").val(_data[0].fktjmc);
			}
			if(_data[0].gjmytk && _data[0].gjmytk.length>0){
				$("#form-submit [name=gjmytk]").val(_data[0].gjmytk);
				$("#form-submit [name=gjmytkmc]").val(_data[0].gjmytkmc);
				$("#form-submit [name=gjmytkbz]").val(_data[0].gjmytkbz);
			}
			/* $("#form-submit [name=wsxh]").val(_data[0].jixing);
			$("#form-submit [name=jixin]").val(_data[0].jixin);
			$("#form-submit [name=zhfs]").select2("val",_data[0].zhfs); */
			if(_data[0].cylx && _data[0].cylx.length>0){
				$("#form-submit [name=cylx]").select2("val",_data[0].cylx);
			}
			/* if(_data[0].pid && _data[0].pid.length>0){
				$("#form-submit [name=pid]").val(_data[0].pid);
			} */
			//外壳颜色标准取pi明细中的款式
			if(_data[0].wkysbz &&_data[0].wkysbz.length>0){
				$("#form-submit [name=wkysbz]").val(_data[0].ksmc);
			}
			// 走货方式影响ckd物料清单（CBU-整机）
			/* if(_data[0].zhfs == 3){
				$(grid_ckdwl_selector).jqGrid("clearGridData");
				$("#hideSkdCkd").hide();
			}else{
				$("#hideSkdCkd").show();
			} */
		}
		$("#form-submit [name=sl]").val(xdsl);
		$("#form-submit [name=yjsl]").val(yjsl);
		$("#form-submit [name=je]").val(je);
		$("#form-submit [name=dj]").val(parseFloat(je/(xdsl+yjsl)).toFixed(6));
		$("#form-submit [name=ffbsje]").val(ffbsje);
		$("#form-submit [name=zje]").val(zje);
		// 页面赋值结束
	}
    // 认证和防火料checkbox赋值
    function checkBoxBindDate(data){
    	// 认证1
    	$("#form-submit [name=rz1Cb][value="+data.rz1Cb+"]").prop("checked","checked");
		$("#form-submit [name=rz1Ce][value="+data.rz1Ce+"]").prop("checked","checked");
		$("#form-submit [name=rz1Etl][value="+data.rz1Etl+"]").prop("checked","checked");
		$("#form-submit [name=rz1Ul][value="+data.rz1Ul+"]").prop("checked","checked");
		$("#form-submit [name=rz1Pse][value="+data.rz1Pse+"]").prop("checked","checked");
		$("#form-submit [name=rz1Qt][value="+data.rz1Qt+"]").prop("checked","checked");
		/* 新增认证1字段 */
		$("#form-submit [name=rz1Cet][value="+data.rz1Cet+"]").prop("checked","checked");
		$("#form-submit [name=rz1Paq][value="+data.rz1Paq+"]").prop("checked","checked");
		$("#form-submit [name=rz1Nom][value="+data.rz1Nom+"]").prop("checked","checked");
		$("#form-submit [name=rz1Raq][value="+data.rz1Raq+"]").prop("checked","checked");
		$("#form-submit [name=rz1Smaq][value="+data.rz1Smaq+"]").prop("checked","checked");
		//认证2
		$("#form-submit [name=rz2Emc][value="+data.rz2Emc+"]").prop("checked","checked");
		$("#form-submit [name=rz2Fcc][value="+data.rz2Fcc+"]").prop("checked","checked");
		$("#form-submit [name=rz2Meps][value="+data.rz2Meps+"]").prop("checked","checked");
		$("#form-submit [name=rz2Es][value="+data.rz2Es+"]").prop("checked","checked");
		$("#form-submit [name=rz2Qt][value="+data.rz2Qt+"]").prop("checked","checked");
		/* 新增认证2字段 */
		$("#form-submit [name=rz2Pe][value="+data.rz2Pe+"]").prop("checked","checked");
		$("#form-submit [name=rz2Rr][value="+data.rz2Rr+"]").prop("checked","checked");
		$("#form-submit [name=rz2Rtte][value="+data.rz2Rtte+"]").prop("checked","checked");
		$("#form-submit [name=rz2Sme][value="+data.rz2Sme+"]").prop("checked","checked");
		//认证3
		$("#form-submit [name=rz3Hdmi][value="+data.rz3Hdmi+"]").prop("checked","checked");
		$("#form-submit [name=rz3Usb][value="+data.rz3Usb+"]").prop("checked","checked");
		$("#form-submit [name=rz3Qt][value="+data.rz3Qt+"]").prop("checked","checked");
		/* 新增认证3字段 */
		$("#form-submit [name=rz3Dd][value="+data.rz3Dd+"]").prop("checked","checked");
		$("#form-submit [name=rz3Ddj][value="+data.rz3Ddj+"]").prop("checked","checked");
		$("#form-submit [name=rz3Dts][value="+data.rz3Dts+"]").prop("checked","checked");
		$("#form-submit [name=rz3Cij][value="+data.rz3Cij+"]").prop("checked","checked");
		$("#form-submit [name=rz3Mhl][value="+data.rz3Mhl+"]").prop("checked","checked");
		$("#form-submit [name=rz3Bqb][value="+data.rz3Bqb+"]").prop("checked","checked");
		//认证4
		$("#form-submit [name=rz4Erp][value="+data.rz4Erp+"]").prop("checked","checked");
		$("#form-submit [name=rz4Gems][value="+data.rz4Gems+"]").prop("checked","checked");
		$("#form-submit [name=rz4Bee][value="+data.rz4Bee+"]").prop("checked","checked");
		$("#form-submit [name=rz4Nrc][value="+data.rz4Nrc+"]").prop("checked","checked");
		$("#form-submit [name=rz4Nfnx][value="+data.rz4Nfnx+"]").prop("checked","checked");
		$("#form-submit [name=rz4Es7][value="+data.rz4Es7+"]").prop("checked","checked");
		//认证5
		$("#form-submit [name=rz5Qt][value="+data.rz5Qt+"]").prop("checked","checked");
		// 防火料
		$("#form-submit [name=fhlQk][value="+data.fhlQk+"]").prop("checked","checked");
		$("#form-submit [name=fhlHk][value="+data.fhlHk+"]").prop("checked","checked");
		$("#form-submit [name=fhlDzjlz][value="+data.fhlDzjlz+"]").prop("checked","checked");
		$("#form-submit [name=fhlAvzj][value="+data.fhlAvzj+"]").prop("checked","checked");
    }
  //初始化销往国家select2信息
	function getXwgj(){
		$.post("<c:url value='/pub/select2/selectCountry'/>",{},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.code;
			       obj.text =  obj.cnName ;		      
			       return obj;
			     });
				$("#form-submit [name=xwgj]").addClass("skyselect").select2({data:data}).on("change",function(e){
					if(e.added){
						$("#form-submit [name=sq]").val(e.added.sdsq);
					}
				  });
		}, "json");
	}
  //
    function changeFcst(){
    	// 根据参考订单号初始化数据
		$.bindAjax({
			url : "<c:url value='/order/orderReferPi/searchOrderFcst'/>",
			data : {pid : $("#form-submit [name=pid]").val(),
				    khbm :$("#form-submit [name=khbm]").val(),
				    jhrq :$("#form-submit [name=jhrq]").val(),
				    xsyid :$("#form-submit [name=xsyid]").val()},
			action : "search"
		},function(response){
			if(response.length>0){
				$('#form-submit [name=yczs]').val(response[0].zc);
				$('#form-submit [name=ycrq]').val(response[0].zdsj);
				$('#form-submit [name=ycsl]').val(response[0].ycs);
			}else{
				swal("","该客户、PID尚未做过预测，需先在预测表录入预测数据！", "warning");
				$('#form-submit [name=yczs]').val("");
				$('#form-submit [name=ycrq]').val("");
				$('#form-submit [name=ycsl]').val("");
			}
		});
  	}
  
    function initSelect2(elem){
		$(elem).width(140).addClass(".skyselect").select2();
	}
	/**************************************************function结束区域************************************************/
</script>
</html>