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
					<input type="hidden" name="sfFjelbg"/>
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
					<div class="col-xs-6 col-sm-3 approveSelect" style="display:none">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">是否提交到驳回人：&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" name="sftjbhr" class="skyradio" value="1">是
								</label>
								<label class="radio-inline">
									<input type="radio" name="sftjbhr" checked="checked" class="skyradio" value="0">否
								</label>
							</div>
						</div>
					</div>
					<!-- <div class="col-xs-6 col-sm-3">
						<button id="btn-piSelect" type="button" class="btn btn-purple btn-sm" >
							<i class="fa fa-plus icon-on-right bigger-110"></i>
							PI选择
						</button>
					</div> -->
				</div>
			
				<h5 class="header blue" style="margin-top:4px;">PI信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div id ="grid-parent-pixx">
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
									<input type="text" name="pid" onfocus="this.blur()" class="form-control parent-node skydisabled" disabled="disabled"/>
									<span class="input-group-addon">
										<i class="icon-search bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">我司型号&nbsp;&nbsp;</label>
									<input type="text" name="wsxh" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">机芯&nbsp;&nbsp;</label>
									<input type="text" name="jixin" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">买家型号&nbsp;&nbsp;</label>
									<input type="text" name="mjxh" class="form-control"/>
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
											<input type="radio" class="skyradio" name="sfWxdd" value="1">外协
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfWxdd" value="0" checked="checked">非外协
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">内销研发产品&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfNxyfcp" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfNxyfcp" value="0" checked="checked">否
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">规格明细&nbsp;&nbsp;</label>
									<select role="select" name="ggmx" size="1" class="form-control skyselect">
										${fns:loadDictOption('GGMX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="ggmxbz" placeholder="规格明细备注" class="form-control"/>
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
											<input type="radio" class="skyradio" name="sfXp" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfXp" value="0" checked="checked">否
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">付款条件&nbsp;&nbsp;</label>
									<input type="hidden" name="fktj" />
									<input type="text" name="fktjmc" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">国际贸易条款&nbsp;&nbsp;</label>
									<input type="hidden" name="gjmytk" />
									<input type="text" name="gjmytkmc" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="gjmytkbz" placeholder="国际贸易条款备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-2">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">币种&nbsp;&nbsp;</label>
									<input type="text" name="bz" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-2">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">大货数量&nbsp;&nbsp;</label>
									<input type="text" name="sl" class="form-control skydisabled" disabled="disabled"/>
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
								    <%-- <select role="select" name="jgfs" size="1" class="form-control skyselect">
										${fns:loadDictOption('ZHFS')}
									</select> --%>
									<input type="text" name="jgfs" class="form-control"/>
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
											<input type="checkbox" class="skycheckbox" name="zhbhwjP" value="1">屏
										</label>
										<label class="checkbox-inline">
								      		<input type="checkbox" class="skycheckbox" name="zhbhwjJk" value="1">机壳
								      	</label>
								      	<label class="checkbox-inline">
								      		<input type="checkbox" class="skycheckbox" name="zhbhwjYkq" value="1">遥控器
								     	</label>
								     	<label class="checkbox-inline">
								     		<input type="checkbox" class="skycheckbox" name="zhbhwjLb" value="1">喇叭
								     	</label>
								     	<label class="checkbox-inline">
								     		<input type="checkbox" class="skycheckbox" name="zhbhwjZx" value="1">纸箱
								    	</label>
								    	<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox" name="zhbhwjPm" value="1">高频头
								    	</label>
								    	<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox" name="zhbhwjJxZb" value="1">机芯+主板
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
											<input type="checkbox" class="skycheckbox" name="xddzhP" value="1">屏
										  </label>
										  <label class="checkbox-inline">
										    <input type="checkbox" class="skycheckbox" name="xddzhJk" value="1">机壳
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox" name="xddzhLb" value="1">喇叭
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox" name="xddzhZx" value="1">纸箱
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox" name="xddzhJxZb" value="1">机芯+主板
										  </label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">走货码&nbsp;&nbsp;</label>
									<select role="select" name="zhm" size="1" class="form-control skyselect skydisabled" readonly>
										${fns:loadDictOption('ZHM')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">版本号&nbsp;&nbsp;</label>
									<select id = "version" role="select" name="version" size="1" class="form-control skydisabled" readonly>
										${fns:loadDictOption('VERSION')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">标识号&nbsp;&nbsp;</label>
									<select id = "bs" role="select" name="bs" size="1" class="form-control skydisabled" readonly>
										${fns:loadDictOption('BS')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">走货码&nbsp;&nbsp;</label>
									<select id = "zhmt" role="select" name="zhmt" size="1" class="form-control skydisabled" readonly>
										${fns:loadDictOption('ZHM')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">版本号&nbsp;&nbsp;</label>
									<select id = "versiont" role="select" name="versiont" size="1" class="form-control skydisabled" readonly>
										${fns:loadDictOption('VERSION')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">标识号&nbsp;&nbsp;</label>
									<select id = "bst" role="select" name="bst" size="1" class="form-control skydisabled" readonly>
										${fns:loadDictOption('BS')}
									</select>
								</div>
							</div>
						</div>
						
						
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">出运类型&nbsp;&nbsp;</label>
									<select id = "cylx" role="select" name="cylx" size="1" class="form-control skyselect">
										${fns:loadDictOption('CYLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="cylxbz" placeholder="出运类型备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">交货日期&nbsp;&nbsp;</label>
									<input type="text" name="jhrq" class="form-control"/>
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
									<button id="btn-FcstDataSelect" type="button" class="btn btn-primary btn-sm" >
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
									<select role="select" name="qd" size="1" class="form-control skyselect skydisabled" readonly">
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
											<input type="radio" class="skyradio" name="sfYh" value="1" onclick="javascript:sfYh_show();">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfYh" value="0" checked="checked" onclick="javascript:sfYh_hide();">否
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="sfyhbz" placeholder="是否验货备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">验货日期&nbsp;&nbsp;</label>
									<input type="text" name="yhrq" class="form-control date-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
									<label class="input-group-addon">电视机类型&nbsp;&nbsp;</label>
									<select role="select" name="dsjlx" size="1" class="form-control skyselect skydisabled" readonly">
										${fns:loadDictOption('DSJLX')}
									</select>
								</div>
							</div>
						</div>
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
									<label class="input-group-addon">辅助变更备注&nbsp;&nbsp;</label>
									<script type="text/plain" id="fzbgbz"
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
									<textarea name="jbxxbz" class="autosize-transition form-control"></textarea>
								</div>
							</div>
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">辅助变更备注&nbsp;&nbsp;</label>
									<textarea name="fzbgbz" class="autosize-transition form-control"></textarea>
								</div>
							</div>
						</div> -->
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
									<input type="text" name="xwgj" class="form-control"/>
							    </div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">时区&nbsp;&nbsp;</label>
									<input type="text" name="sq" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">品牌&nbsp;&nbsp;</label>
									<input type="text" name="pp" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">出厂语言&nbsp;&nbsp;</label>
									<%-- <select role="select" name="ccyy" size="1" class="form-control skyselect">
										${fns:loadDictOption('CCYY')}
									</select> --%>
									<input type="text" name="ccyymc" class="form-control"/>
								</div>
							</div>
						   <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">开机Logo&nbsp;&nbsp;</label>
									<input type="text" name="kjlogo" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">开机模式&nbsp;&nbsp;</label>
									<select role="select" name="kjms" size="1" class="form-control skyselect">
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
											<input type="radio" class="skyradio" name="dzpop" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="dzpop" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">附件&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="kjlogofj" type="file" class="form-control">
									</div>
									<input type="hidden" name="kjlogofj" />
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-9">
							</div>
							<div class="col-xs-6 col-sm-3">
								<div id="multiFileQueue"> </div>
								<div id="kjlogofjxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
							</div>
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
									<input type="text" name="ppp" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏型号&nbsp;&nbsp;</label>
									<input type="text" name="pxh" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏编码&nbsp;&nbsp;</label>
									<input type="text" name="pxxbc" class="form-control"/>
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
									<select role="select" name="fbl" size="1"    class="form-control skyselect">
										${fns:loadDictOption('FBL')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="fblbz" placeholder="分辨率备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏包装要求&nbsp;&nbsp;</label>
									<select role="select" name="pbzyq" size="1" class="form-control skyselect">
										${fns:loadDictOption('PBZYQ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="pbzyqbz" placeholder="屏包装要求备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏亮点选项&nbsp;&nbsp;</label>
									<select role="select" name="pld" size="1" class="form-control skyselect">
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
											<input type="radio" class="skyradio" name="sfBhm" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfBhm" value="0" checked="checked">不需要
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
								    		<input type="checkbox" class="skycheckbox" name="rz1Cb" value="1">CB
									    </label>
								    	<label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox" name="rz1Etl" value="1">ETL
									    </label>
									    <label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox" name="rz1Cetl" value="1">cETL
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Paq" value="1">PSE-安全
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Raq" value="1">RED-安全
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Smaq" value="1">S-mark 安全
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group-sm">
									<input type="text" name="rz1Bz" placeholder="备注" class="form-control"/>
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
								    		<input type="checkbox" class="skycheckbox" name="rz2Emc" value="1">EMC
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz2Fcc" value="1">FCC
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz2Rtte" value="1">RTTE
									    </label>
									    <label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox" name="rz2Pe" value="1">PSE-EMC
									    </label>
									     <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz2Rr" value="1">RED-RF
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz2Sme" value="1">S-mark -EMC
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="rz2Bz" placeholder="备注" class="form-control"/>
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
								    		<input type="checkbox" class="skycheckbox" name="rz4Erp" value="1">ERP
									    </label>
									    <label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox" name="rz4Gems" value="1">GEMS
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz4Bee" value="1">BEE
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz4Nrc" value="1">NRcan
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz4Nfnx" value="1">南非能效
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz4Eg" value="1">Energy Guide
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="rz4Bz" placeholder="备注" class="form-control"/>
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
											<input type="checkbox" class="skycheckbox" name="rz3Hdmi" value="1">HDMI
										</label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz3Dd" value="1">DD
									    </label>
									     <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz3Dts" value="1">DTS
									    </label>
									    <label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox" name="rz3Cij" value="1">CI+
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz3Bqb" value="1">BQB
									    </label>
									    <label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox" name="rz3Mhl" value="1">MHL
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="rz3Bz" placeholder="备注" class="form-control" />
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
									      	<input type="checkbox" class="skycheckbox" name="rz1Ce" value="1">CE
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Ul" value="1">UL
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Pse" value="1">PSE
									    </label>
									    <label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox" name="rz2Meps" value="1">MEPS
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz2Es" value="1">Energy Star
									    </label>
									     <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz3Usb" value="1">USB
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Rf" value="1">RF
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Rte" value="1">RTE
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Cet" value="1">cETLus
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz1Nom" value="1">NOM
									    </label>
									     <label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox" name="rz3Ddj" value="1">DD+
									    </label>
									     <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="rz4Es7" value="1">Energy star 7.0
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
								    		<input type="checkbox" class="skycheckbox" name="rz5Qt" value="1">其他
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
											<input type="radio" class="skyradio" name="sfRohs" value="1" checked="checked">需要
										</label>
										<!-- <label class="radio-inline">
											<input type="radio" class="skyradio" name="sfRohs" value="0">不需要
										</label> -->
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否需要REACH&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfReach" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfReach" value="0" checked="checked">不需要
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
									<select role="select" name="ctlx" size="1" class="form-control skyselect">
										${fns:loadDictOption('CTLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group-sm">
									<input type="text" name="ctlxbz" placeholder="插头类型备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">适配器&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfSpq" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfSpq" value="0" checked="checked">不需要
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
									<input type="text" name="wkysbz" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group input-group-sm">
									<label class="input-group-addon">泡沫&nbsp;&nbsp;</label>
									<select role="select" name="paomo" size="1" class="form-control skyselect">
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
								    		<input type="checkbox" class="skycheckbox" name="fhlQk" value="1">前壳
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="fhlHk" value="1">后壳
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="fhlDzjlz" value="1">底座及立柱
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="fhlAvzj" value="1">AV支架
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="fhlBxy" value="1">不需要
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="fhlBz" placeholder="防火料备注" class="form-control"/>
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
								    		<input type="checkbox" class="skycheckbox" name="mztzDsky" value="1">带SKYWORTH
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="mztzBdsky" value="1">不带SKYWORTH
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="mztzDmichina" value="1">带MADE IN CHINA
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="mztzBdmichina" value="1">不带MADE IN CHINA
									    </label>
								    </div>
								</div>
							</div>					
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">外包装箱贴纸&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox" name="wbzxtzDsky" value="1">带SKYWORTH
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="wbzxtzBdsky" value="1">不带SKYWORTH
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="wbzxtzDmichina" value="1">带MADE IN CHINA
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox" name="wbzxtzBdmichina" value="1">不带MADE IN CHINA
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
											<input type="checkbox" class="skycheckbox" name="kbchjdbyqP" value="1">屏
										  </label>
										  <label class="checkbox-inline">
										    <input type="checkbox" class="skycheckbox" name="kbchjdbyqSj" value="1">散件
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox" name="kbchjdbyqZj" value="1">整机
										  </label>
										  <label class="checkbox-inline">
										     <input type="checkbox" class="skycheckbox" name="kbchjdbyqJzj" value="1">假整机
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
									<select role="select" name="guajia" size="1" class="form-control skyselect ">
										${fns:loadDictOption('GJLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="guajiabz" placeholder="挂架备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" >
								<div class="input-group input-group-sm">
									<label class="input-group-addon">挂架包装&nbsp;&nbsp;</label>
									<select role="select" name="gjbz" size="1" class="form-control skyselect">
										${fns:loadDictOption('GJBZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="gjbzbz" placeholder="挂架包装备注" class="form-control"/>
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
											<input type="radio" class="skyradio" name="sfDc" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfDc" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
							<!-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">3D眼镜&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sf3dyj" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sf3dyj" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div> -->
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">底座包装&nbsp;&nbsp;</label>
									<select role="select" name="dzbz" size="1" class="form-control skyselect">
										${fns:loadDictOption('DZBZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="dzbzbz" placeholder="底座包装备注" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">其他附件备注&nbsp;&nbsp;</label>
									<textarea name="qtfjbz" class="autosize-transition form-control"></textarea>
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
												<input type="radio" class="skyradio" name="sfP" value="1" checked="checked">有
											</label>
											<label class="radio-inline">
												<input type="radio" class="skyradio" name="sfP" value="0">无
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">IC程序烧录&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline">
												<input type="radio" class="skyradio" name="sfIc" value="1">需要
											</label>
											<label class="radio-inline">
												<input type="radio" class="skyradio" name="sfIc" value="0" checked="checked">不需要
											</label>
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">S/H/CKD辅料供应&nbsp;&nbsp;</label>
										<div class="form-control">
											<label class="radio-inline">
												<input type="radio" class="skyradio" name="sfShckdflgy" value="1">需要
											</label>
											<label class="radio-inline">
												<input type="radio" class="skyradio" name="sfShckdflgy" value="0" checked="checked">不需要
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
										<input type="text" name="skdqkxjgpj" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row" style="margin: 0px;">
								<div class="col-xs-6 col-sm-6">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">S/H/CKD加工要求&nbsp;&nbsp;</label>
										<textarea name="shckdjgyq" class="autosize-transition form-control"></textarea>
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
										<input type="text" name="shckdxcxwlmx" class="form-control"/>
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
							<div class="col-xs-6 col-sm-12">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">产品其他要求备注&nbsp;&nbsp;</label>
									<script type="text/plain" id="cpqtyqbz"
										style="width: 800px; height: 100px;">
									</script>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<!-- <div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">产品其他要求备注&nbsp;&nbsp;</label>
									<textarea name="cpqtyqbz" class="autosize-transition form-control"></textarea>
								</div>
							</div> -->
					    	<div class="col-xs-6 col-sm-6">
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
									<select role="select" name="mk" size="1" class="form-control skyselect">
										${fns:loadDictOption('MG_LOGO')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="mkbz" placeholder="面壳备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">装饰件&nbsp;&nbsp;</label>
									<select role="select" name="zsj" size="1" class="form-control skyselect">
										${fns:loadDictOption('MG_LOGO')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="zsjbz" placeholder="装饰件备注" class="form-control"/>
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
											<input type="radio" class="skyradio" name="sfLogozxbg" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfLogozxbg" value="0" checked="checked">否
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
									<select role="select" name="ykq" size="1" class="form-control skyselect">
										${fns:loadDictOption('MG_YKQXX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="ykqbz" placeholder="遥控器选项备注" class="form-control"/>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">说明书</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">说明书&nbsp;&nbsp;</label>
									<select role="select" name="sms" size="1" class="form-control skyselect">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="smsbz" placeholder="说明书备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">说明书语种&nbsp;&nbsp;</label>
									<input name="smsyz" type="text" class="form-control"  >
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">语言排版顺序&nbsp;&nbsp;</label>
									<input name="yypbsx" type="text" class="form-control" >
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
											<input type="radio" class="skyradio" name="ksazzn" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="ksazzn" value="0" checked="checked">不需要
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
									<select role="select" name="zx" size="1" class="form-control skyselect">
										${fns:loadDictOption('ZX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="zxbz" placeholder="纸箱备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">印刷资料&nbsp;&nbsp;</label>
									<select role="select" name="yszl" size="1" class="form-control skyselect">
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
									<select role="select" name="hgtz" size="1" class="form-control skyselect">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="hgtzbz" placeholder="后盖贴纸备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">POP贴纸&nbsp;&nbsp;</label>
									<select role="select" name="poptz" size="1" class="form-control skyselect">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="poptzbz" placeholder="POP贴纸备注" class="form-control"/>
								</div>
							</div>
						</div>	
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">	
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">能效贴纸&nbsp;&nbsp;</label>
									<select role="select" name="nxtz" size="1" class="form-control skyselect">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="nxtzbz" placeholder="能效贴纸备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">适配器贴纸&nbsp;&nbsp;</label>
									<select role="select" name="spqtz" size="1" class="form-control skyselect">
										${fns:loadDictOption('MG_SPQTZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="spqtzbz" placeholder="适配器贴纸备注" class="form-control"/>
								</div>
							</div>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">保证卡</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">保证卡&nbsp;&nbsp;</label>
									<select role="select" name="bzk" size="1" class="form-control skyselect">
										${fns:loadDictOption('BZKTZSMS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="bzkbz" placeholder="保证卡备注" class="form-control"/>
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
											<input type="radio" class="skyradio" name="dzazsm" value="1">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="dzazsm" value="0" checked="checked">不需要
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">底座安装说明书语种&nbsp;&nbsp;</label>
									<input name="dzazsmsyz" type="text" class="form-control" >
								</div>
							</div>
						</div>
						
						<h5 class="header blue" style="margin: 0; padding: 0;">整机序号贴纸</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">序列号&nbsp;&nbsp;</label>
									<!-- <input name="xlh" type="text" class="form-control"> -->
									<select role="select" name=xlh size="1" class="form-control skyselect">
										${fns:loadDictOption('XLH')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="xlhbz" placeholder="序列号备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">用量&nbsp;&nbsp;</label>
									<input name="yl" type="text" class="form-control" >
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">粘贴位置要求&nbsp;&nbsp;</label>
									<input name="ztwzyq" type="text" class="form-control" >
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">尺寸要求&nbsp;&nbsp;</label>
									<select role="select" name="ccyq" size="1" class="form-control skyselect">
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
									<select role="select" name="xyzfyfs" size="1" class="form-control skyselect">
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
										<input type="checkbox" class="skycheckbox" name="ztgmgzlMk" value="1">面壳
									</label>
									<label class="checkbox-inline">
							      		<input type="checkbox" class="skycheckbox" name="ztgmgzlZsj" value="1">装饰件
							      	</label>
							      	<label class="checkbox-inline">
							      		<input type="checkbox" class="skycheckbox" name="ztgmgzlYkq" value="1">遥控器
							     	</label>
							     	<label class="checkbox-inline">
							     		<input type="checkbox" class="skycheckbox" name="ztgmgzlSms" value="1">说明书
							     	</label>
							     	<label class="checkbox-inline">
							     		<input type="checkbox" class="skycheckbox" name="ztgmgzlZx" value="1">纸箱
							    	</label>
							    	<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox" name="ztgmgzlHgtz" value="1">后盖贴纸
							    	</label>
							    	<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox" name="ztgmgzlPoptz" value="1">POP贴纸
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox" name="ztgmgzlNxtz" value="1">能效贴纸
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox" name="ztgmgzlSpqtz" value="1">适配器贴纸
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox" name="ztgmgzlBzk" value="1">保证卡
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox" name="ztgmgzlDzazsm" value="1">底座安装说明
							  		</label>
							  		<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox" name="ztgmgzlZjxhtz" value="1">整机序号贴纸
							  		</label>
							  	</div>
							</div>
						</div>
						<div class="space-4"></div>
						<h5 class="header blue" style="margin: 0; padding: 0;">美工其他备注信息</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-12">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">美工其他要求备注&nbsp;&nbsp;</label>
									<script type="text/plain" id="mgqtyqbz"
										style="width: 800px; height: 100px;">
									</script>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<!-- <div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">美工其他要求备注&nbsp;&nbsp;</label>
									<textarea name="mgqtyqbz" class="autosize-transition form-control"></textarea>
								</div>
							</div> -->
					    	<div class="col-xs-6 col-sm-6">
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
							</div>
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
											<input type="radio" class="skyradio" name="sfFfbs" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfFfbs" value="0" checked="checked">否
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
									<select role="select" name="mfbs" size="1" class="form-control skyselect">
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
									<input type="text" name="mfbsbl"  class="form-control"/>
							    </div>
						    </div>
						    <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">备损包装&nbsp;&nbsp;</label>
									<select role="select" name="bsbz" size="1" class="form-control skyselect">
										${fns:loadDictOption('BSBZ')}
									</select>
								</div>
							 </div>
							 <div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="bsbzbz" placeholder="备损包装备注" class="form-control"/>
								</div>
							</div>
						     <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">跟单备损料走柜&nbsp;&nbsp;</label>
									<select role="select" name="gdbslzg" size="1" class="form-control skyselect">
									    ${fns:loadDictOption('GDBSZG')}
									</select>
								</div>
							 </div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:20px;">
									<label class="input-group-addon">CBU物料清单&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:left;">
										<input id="cbuwlfj" type="file" class="form-control">
									</div>
									<input type="hidden" name="cbuwlfj" />
								</div>
					    	</div>
					    	<div class="col-xs-6 col-sm-3">
								<div id="multiFileQueue"> </div>
								<div id="cbuwlxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
						    <div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
								    <label class="input-group-addon">备损备注&nbsp;&nbsp;</label>
									<textarea name="bsxxbz" class="autosize-transition form-control"></textarea>
								</div>
							</div>
						</div>
						
					   <h5 class="header blue" style="margin: 0; padding: 0;">CKD物料清单</h5>
					   <!-- <div class="space-4"></div>
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
								  <button id="ckd-compute" type="button" class="btn btn-info btn-sm">
										<i class="icon-ok icon-on-right bigger-110"></i>
										生成明细
								  </button>
								  <button id="ckd-import" type="button" class="btn btn-info btn-sm">
										<i class="icon-upload-alt icon-on-right bigger-110"></i>
										导入
								  </button>
								  <button id="ckd-export" type="button" class="btn btn-info btn-sm">
										<i class="icon-download-alt icon-on-right bigger-110"></i>
										导出
								  </button>
								   <button id="snyc-pidbom" type="button" class="btn btn-info btn-sm">
										<i class="icon-download-alt icon-on-right bigger-110"></i>
										同步PID_BOM
								  </button>
					          </div>
						  </div>
					   </div> -->
					   <div class="space-4"></div>
					   <div class="row" style="margin: 0px;">
					     <div class="col-xs-12 col-sm-12">
						   <div id="grid-parent-ckdwl">
								<table id="grid-table-ckdwl"></table>
								<div id="ckdwl-pager"></div>
						    </div>
				          </div>
					   </div>
					   <h5 class="header blue" style="margin: 0; padding: 0;">已移除物料清单</h5>
					   <div class="space-4"></div>
					   <div class="row" style="margin: 0px;">
					     <div class="col-xs-12 col-sm-12">
						    <div id="grid-parent-yycwl">
								<table id="grid-table-yycwl"></table>
								<div id="yycckdwl-pager"></div>
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
	
	var grid_yycwl_selector = "#grid-table-yycwl"    ;
	var parent_yycwl_selector = "#grid-parent-yycwl"  ;
	var yycckdwl_pager = "#yycckdwl-pager";

	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	// 权限判断
	<shiro:hasPermission name="orderfzbg:orderProductFzbg:edit">isEdit=true;</shiro:hasPermission>
	// 初始化
	$(function($){
		if(taskId != "null" && taskId != ""){
			$('.approveSelect').show();
		}
		$(".skyselect").select2();
		$(".date-picker").bindDate();
		// 富文本框初始化(操作API可参照static/umeditor下的index.html)
		UM.getEditor('jbxxbz');
		UM.getEditor('fzbgbz');
		UM.getEditor('cpqtyqbz');
		UM.getEditor('mgqtyqbz');
		$("#form-submit [name=jhrq]").bindDate().on('changeDate', function(e){
			countFgsshrq();
			changeFcst();
		});
		//FCST预测
		$("#btn-FcstDataSelect").click(function(){
			var jhrq = $("#form-submit [name=jhrq]").val();
			var pid = $("#form-submit [name=pid]").val();
			var khbm = $("#form-submit [name=khbm]").val();
			var xsyid = $("#form-submit [name=xsyid]").val();
			if(jhrq ==null ||jhrq.length==0){
				swal("","交货日期不能为空!","warning");
				return;
			}
			if(pid ==null ||pid.length==0){
				swal("","PID不能为空!","warning");
				return;
			}
			if(khbm ==null ||khbm.length==0){
				swal("","客户不能为空!","warning");
				return;
			}
			if(xsyid ==null ||xsyid.length==0){
				swal("","销售员不能为空!","warning");
				return;
			}
			var width = 1000;
			var height = 300;
			var left = (window.screen.width-width)/2;
			var top = (window.screen.height-height)/2;
			var pageUrl = "<c:url value='/order/orderReferPi/fcst'/>?jhrq="+jhrq+"&khbm="+khbm+"&pid="+pid+"&xsyid="+xsyid;
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				var data = window.showModalDialog(pageUrl,null,dialogArgs);
				if(data){
					initFcstData(data);
				}
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
				var opener = window.open(pageUrl,null,dialogArgs);
				opener.openerCallBack = function(data){
					initFcstData(data);
				}
			}
		});
		// PI明细信息编辑表
		pixxTableInit();
	    //初始化ckd物料明细表
		initCkdwl();
		//初始化已移除明细表
		initYycwl();
		/* bindCtlxEvent();
		bindGuajiaEvent();
		bindGjbzEvent();
		bindDzbzEvent();
		bindSmsyzEvent();
		bindSpqEvent();
		bindYkqEvent();
		bindFblEvent();
		bindPbzyqEvent();
		//bindSnycPidBom();
		//序列号绑定事件
		bindXlhEvent(); */
		// 销往国家change事件
		$("#form-submit [name=xwgj]").on("change", function(e) {
			countFgsshrq();
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
		 //加工方式change
		$("#form-submit [name=jgfs]").on("change", function(e) {
			bindJgfsChange($(this).val());
		}); 
	});
	
	/**************************************************function开始区域************************************************/

    //模板下载
	function bingMbxz(){
	  $('#ckd-template-download').click(function(){
		  window.location.href=encodeURI("<c:url value='/template/ckddrmb.xlsx'/>");
	  })};
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
	// CKD未移除物料清单
	function initCkdwl(){
		$(grid_ckdwl_selector).bindTable({
			caption: "",
			pager: ckdwl_pager,
			gridParent: parent_ckdwl_selector,
		    //multiselect: true,
		    rowList: [5, 10, 15],
		    rowNum:5,
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', index:'id', label:'ID', hidden:true, formoptions:{rowpos: 1, colpos: 1}},
				{name:'wlbm', index:'yzhlx', label:'物料编码', width:80, formoptions:{rowpos: 2, colpos: 1}}, 
				{name:'ms', index:'ms', label:'描述', width:80, formoptions:{rowpos: 2, colpos: 2}},
				{name:'djyl', index:'djyl', label:'单机用量', width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 2, colpos: 3}},
				{name:'sdjysl', index:'sdjysl', label:'上单结余数量',width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 3, colpos: 1}},
				{name:'dhsl', index:'dhsl', label:'大货数量', width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 3, colpos: 2}},
				{name:'mfbssl', index:'mfbssl', label:'免费备损数量', width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 3, colpos: 3}},
				{name:'ffbssl', index:'ffbssl', label:'付费备损数量', width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 4, colpos: 1}},
				{name:'moqsl', index:'moqsl', label:'MOQ数量', width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 4, colpos: 2}},
				{name:'xdsl', index:'xdsl', label:'下单数量', width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 4, colpos: 3}},
				{name:'sapdhddsl', index:'sapdhsl', label:'SAP大货订单数量', width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 5, colpos: 1}},
				{name:'bdjysl', index:'sapdhsl', label:'本单结余数量', width:80, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},formoptions:{rowpos: 5, colpos: 2}},
				{name:'ne', index:'ne', label:'NE', width:80, formoptions:{rowpos: 5, colpos: 3}},
				{name:'po', index:'po', label:'PO', width:80, formoptions:{rowpos: 6, colpos: 1}},
				{name:'ncmcode', index:'NCM CODE', label:'NCM CODE', width:80, formoptions:{rowpos: 6, colpos: 2}},
				{name:'ncm', index:'ncm', label:'NCM', width:80, formoptions:{rowpos: 6, colpos: 3}},
				{name:'bz', index:'bz', label:'币种', width:80, formoptions:{rowpos: 7, colpos: 1}},
				{name:'dw', index:'dw', label:'单位', width:80, formoptions:{rowpos: 7, colpos: 2}},
				<shiro:hasPermission name="order:orderProduct:price">
				{name:'dj', index:'dj', label:'单价', width:80, align:'right',
					 formatter:'number',formatoptions:{thousandsSeparator: ','}, editoptions:{disabled:true},formoptions:{rowpos: 7, colpos: 3}},
			    </shiro:hasPermission>
				{name:'jz', index:'jz', label:'净重', width:80, align:'right', formoptions:{rowpos: 8, colpos: 1}},
				{name:'mz', index:'mz', label:'毛重', width:80, align:'right', formoptions:{rowpos: 8, colpos: 2}},
				{name:'gysbm', index:'gysbm', label:'供应商编码', width:80, formoptions:{rowpos: 8, colpos: 3}},
				{name:'gysmc', index:'gysmc', label:'供应商名称', width:80, formoptions:{rowpos: 9, colpos: 1}},
				{name:'gysdz', index:'gysdz', label:'供应商地址', width:80, formoptions:{rowpos: 9, colpos: 2}},
				{name:'ycd', index:'ycd', label:'原产地', width:80, formoptions:{rowpos: 9, colpos: 3}},
				{name:'pid', index:'pid', label:'PID', width:80, formoptions:{rowpos: 10, colpos: 1}},
				{name:'sfYc', index:'sfYc', label:'是否移除',hidden:true}
			]
		},{
			add:false,
			edit:false,
			view:false,
			del:false
		});
	}
	// 已移除物料清单
	function initYycwl(){
		$(grid_yycwl_selector).bindTable({
			caption: "",
			pager: yycckdwl_pager,
			gridParent: parent_yycwl_selector,
			//multiselect: true,
			rowList: [5, 10, 15],
		    rowNum: 5,
			//shrinkToFit: false,
			//autoScroll:  false,
			colModel: [
				{name:'wlbm', index:'wlbm', label:'物料编码', width:200}, 
				{name:'ms', index:'ms', label:'描述', width:200},
				{name:'djyl', index:'djyl', label:'单机用量', width:200, align:'right',
					 formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'moqsl', index:'moqsl', label:'MOQ数量', width:200, align:'right',
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}}
			]
		},{
			add:false,
			edit:false,
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
					formatter:'number',formatoptions:{thousandsSeparator: ','},editrules:{number:true}},
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
				{name:'cylxmc', index:'cylxmc', label:'出运类型', width:80, hidden:true}
			]
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
			rules: {
				xwgj: 'required',
				pp: 'required',
				wsxh: 'required',
				jixin: 'required',
				mjxh :'required',
				jhrq :'required',
				mfbsbl: {number:true },	
			},
			messages: {
				xwgj: '销往国家未填写',
				pp: '品牌未填写',
				wsxh: '我司型号不能为空',
				jixin: '机芯不能为空',
				mjxh :'买家型号未填写',
				jhrq :'交货日期未填写',
				mfbsbl:'免费备损比例只能是数字格式',
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
			//是否提交驳回人，驳回时用到
			$("#form-submit [name=sftjbhr][value=0]").prop("checked","checked");
			changeZhfs("");
		} else {
			$.loading();
			$.bindAjax({
				url : "<c:url value='/orderfzbg/orderProductFzbg/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				//加载加工方式
				changeZhfs(response.zhfs);
				$("#form-submit").setFormData(response);
				// 富文本框赋值
				if(response.jbxxbz){
					UM.getEditor('jbxxbz').setContent(response.jbxxbz);
				}
				if(response.fzbgbz){
					UM.getEditor('fzbgbz').setContent(response.fzbgbz);
				}
				if(response.cpqtyqbz){
					UM.getEditor('cpqtyqbz').setContent(response.cpqtyqbz);
				}
				if(response.mgqtyqbz){
					UM.getEditor('mgqtyqbz').setContent(response.mgqtyqbz);
				}
				//走货方式
				if(response.zhfs == 3){
					$("#hideSkdCkd").hide();
				}else{
					$("#hideSkdCkd").show();
				}
				$("#form-submit [name=sftjbhr][value=0]").prop("checked","checked");
				$("#kjlogofjxx").html(response.kjlogofj);
				$("#shckdjgyqbzfjxx").html(response.shckdjgyqbz);
				$("#shckdxcxwlmxfjxx").html(response.shckdxcxwlmxfj);
				$("#cpqtyqfjxx").html(response.cpqtyqfj);
				$("#mgqtyqfjxx").html(response.mgqtyqfj);
				$("#ffbsqdxx").html(response.ffbsqdfj);
				$("#mfbsqdxx").html(response.mfbsqdfj);
				$("#cbuwlxx").html(response.cbuwlfj);
				if(response.sfYh == 0){
					sfYh_hide();
				} else {
					sfYh_show();
				}
				/* //挂架初始化时
				if(response.guajia != "2"){
					$('#form-submit [name=gjbz]').removeAttr('disabled');	
					$('#form-submit [name=guajiabz]').removeAttr('disabled');
				}else{
					$('#form-submit [name=gjbz]').attr('disabled','disabled');
					$('#form-submit [name=guajiabz]').attr('disabled','disabled');
				} */
				/* //序列号初始化
				if(response.xlh != "1"){
					$('#form-submit [name=xlhbz]').removeAttr('disabled');
				}else{
					$('#form-submit [name=xlhbz]').attr('disabled','disabled');
				} */
				// 加载PI明细
				if(response.orderReferPiList){
					$(grid_pixx_selector).jqGrid("addRowData", null, response.orderReferPiList, "last");
				}
				$("#form-submit [name=oper]").val("edit");
				$("#form-submit [name=taskId]").val(taskId);
				//加载CKD明细
				if(response.wycCkdList){
					$(grid_ckdwl_selector).jqGrid("addRowData", null, response.wycCkdList, "last");
				}
				if(response.yycCkdList){
					$(grid_yycwl_selector).jqGrid("addRowData", null, response.yycCkdList, "last");
				}
				$.hideLoad();
			});
		}
		
	}
	
	// 保存
	function save(){
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
		/* var sfFjelbg = $("#form-submit [name=sfFjelbg]").val();//
		if(sfFjelbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	} */
		var param = $('#form-submit').getFormData();
    	// 富文本框取值
		param.jbxxbz = UM.getEditor('jbxxbz').getContent();
		param.fzbgbz = UM.getEditor('fzbgbz').getContent();
		param.cpqtyqbz = UM.getEditor('cpqtyqbz').getContent();
		param.mgqtyqbz = UM.getEditor('mgqtyqbz').getContent();
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/orderfzbg/orderProductFzbg/edit'/>",
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
				    $(grid_yycwl_selector).trigger('clearGridData');
				    //initCkdGrid();
				   
				  
				});
			} 
		});
	}
	// 提交
	function submit(){
		if(!$('#form-submit').valid()){
			return false;
		}
		/* var sfFjelbg = $("#form-submit [name=sfFjelbg]").val();//
		if(sfFjelbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	} */
		var param = $("#form-submit").getFormData();
    	// 富文本框取值
		param.jbxxbz = UM.getEditor('jbxxbz').getContent();
		param.fzbgbz = UM.getEditor('fzbgbz').getContent();
		param.cpqtyqbz = UM.getEditor('cpqtyqbz').getContent();
		param.mgqtyqbz = UM.getEditor('mgqtyqbz').getContent();
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/orderfzbg/orderProductFzbg/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	/* //分辨率事件绑定
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
 */
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
 
	   //加工方式变化，联动带出屏包装方式
	function bindJgfsChange(jgfs){
		if(jgfs == "1" ||jgfs == "4" ||jgfs == "5"){
			$("#form-submit [name=pbzyq]").select2("val","1");
		}else if(jgfs == "2"){
			$("#form-submit [name=pbzyq]").select2("val","2");
		}else if(jgfs == "6" ||jgfs == "7" ||jgfs == "8"||jgfs == "10"){
			$("#form-submit [name=pbzyq]").select2("val","3");
		}else if(jgfs == "3"){
			$("#form-submit [name=pbzyq]").select2("val","4");
		}else{
			$("#form-submit [name=pbzyq]").select2("val","");
		}
	} 
	 //走货方式联动带出加工方式下拉框，如果PID有值，则确认加工方式、屏包装方式的值
	 function changeZhfs(zhfs){
		 $("#form-submit [name=pbzyq]").select2("val","");
		$.post("<c:url value='/pub/select2/selectJgfs'/>",{zhfs:zhfs},
				function(result){
					if(result.length > 0){
						var data = $.map(result, function (obj) {
					       obj.id = obj.code;
					       obj.text =  obj.name ;		      
					       return obj;
					     });
						$("#form-submit [name=jgfs]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
							if(e.added){
								bindJgfsChange(e.added.code);
							}
						  });
					}	
			}, "json");
	} 
	/**************************************************function结束区域************************************************/
</script>
</html>