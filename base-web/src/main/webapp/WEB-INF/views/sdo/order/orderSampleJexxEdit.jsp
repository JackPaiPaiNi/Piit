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
					<input type="hidden" name="id"/><!-- 订单id -->
					<input type="hidden" name="oper"/>
					<input type="hidden" name="sjc"/>
					<input type="hidden" name="sfBg"/>
					<input type="hidden" name="tssapzt"/>
					<!-- <input type="hidden" name="bbh"/> -->
					<input type="hidden" name="taskId" />
					<input type="hidden" name="token" value="${token}" />
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
							<input type="text" name="ddid" class="form-control" readonly/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">原订单号&nbsp;&nbsp;</label>
							<input type="text" name="yddid" class="form-control" readonly/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<button id="btn-piSelect" type="button" class="btn btn-purple btn-sm" >
							<i class="fa fa-plus icon-on-right bigger-110"></i>
							PI选择
						</button>
					</div>
					<div class="col-xs-6 col-sm-3"></div>
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
				
				<div  class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3 changeJeSelect" style="display:none">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">过样机室/中试部：&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" name="slje" class="skyradio" value="1">是
								</label>
								<label class="radio-inline">
									<input type="radio" name="slje" checked="checked" class="skyradio" value="0">否
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
							<label class="input-group-addon">订单类型&nbsp;&nbsp;</label>
							<select role="select" name="ddlx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('DDLX')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">公司&nbsp;&nbsp;</label>
							<select role="select" name="gsbm" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadCompanyOption('0')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">业务类型&nbsp;&nbsp;</label>
							<select role="select" name="ywlx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('YWLX')}
							</select>
						</div>
					</div>
					
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单状态&nbsp;&nbsp;</label>
							<select role="select" name="zt" size="1" class="form-control skyselect skydisabled" disabled="disabled">
								${fns:loadDictOption('DJZT')}
							</select>
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
							<label class="input-group-addon">制单日期&nbsp;&nbsp;</label>
							<input type="text" name="zdsj" class="form-control date-picker skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
							<input type="hidden" name="xsyid" class="form-control"/>
							<input type="text" name="xsymc" onfocus="this.blur()"
								class="form-control parent-node skydisabled" disabled="disabled" style="cursor: pointer!important;" />
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
							<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
							<input type="hidden" name="ywz" class="form-control"/>
							<input type="text" name="ywzmc" class="form-control" readonly/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售组织&nbsp;&nbsp;</label>
							<input type="hidden" name="xszz" class="form-control"/>
							<input type="text" name="xszzmc" class="form-control" readonly/>
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
					<li><a href="#cpgs-tab" data-toggle="tab">产品概述</a></li>
					<li><a href="#cpxxgnxq-tab" data-toggle="tab">产品详细功能需求</a></li>
					<li><a href="#jgtx-tab" data-toggle="tab">结构特性</a></li>
				</ul>
				
				<div class="tab-content">
					<!-- 基本信息TAB -->
					<div class="tab-pane fade active in" id="jbxx-tab">
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
									<input type="text" name="khbm" onfocus="this.blur()" class="form-control skydisabled" disabled="disabled"/>
									<span class="input-group-addon">
										<i class="icon-search bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
									<input type="text" name="khmc" class="form-control" readonly/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">销往国家&nbsp;&nbsp;</label>
									<select role="select" name="xwgj" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadCountryOption('0')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">销售性质&nbsp;&nbsp;</label>
									<select role="select" name="xsxz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('XSXZ')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">样机类型&nbsp;&nbsp;</label>
									<select role="select" name="yjlx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('YJLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">样机用途&nbsp;&nbsp;</label>
									<select role="select" name="yjyt" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('YJYT')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">工厂&nbsp;&nbsp;</label>
									<select role="select" name="gc" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否返退&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfFt" value="1" checked="checked">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfFt" value="0">否
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否外协&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfWx" value="1">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfWx" value="0" checked="checked">否
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfWx" value="2" checked="checked">直接提取
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否免费&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfMf" value="1"  onclick="hidden_pid();">是
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio" name="sfMf" value="0" checked="checked"  onclick="show_pid();">否
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
									<label class="input-group-addon">付款条件&nbsp;&nbsp;</label>
									<input type="text" name="fktj" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">交货日期&nbsp;&nbsp;</label>
									<input type="text" name="jhrq" class="form-control date-picker skydisabled" disabled="disabled"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">国际贸易条款&nbsp;&nbsp;</label>
									<select role="select" name="gjmytk" size="1" class="form-control skyselect" >
										${fns:loadDictOption('PIGJMYTK')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="gjmytkbz" placeholder="国际贸易条款备注" class="form-control "/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">渠道&nbsp;&nbsp;</label>
									<select role="select" name="qd" size="1" class="form-control skyselect">
										${fns:loadDictOption('QD')}
									</select>
								</div>
							</div>
						</div>
					</div>
					<!-- 产品概述TAB -->
					<div class="tab-pane fade" id="cpgs-tab">
						<%-- <div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏幕&nbsp;&nbsp;</label>
									<select role="select" name="pm" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('WLLY')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">注塑&nbsp;&nbsp;</label>
									<select role="select" name="zs" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('WLLY')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">五金&nbsp;&nbsp;</label>
									<select role="select" name="wj" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('WLLY')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">主板&nbsp;&nbsp;</label>
									<select role="select" name="zb" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('WLLY')}
									</select>
								</div>
							</div>
						</div> --%>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<%-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">电源&nbsp;&nbsp;</label>
									<select role="select" name="dy" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('WLLY')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">包材&nbsp;&nbsp;</label>
									<select role="select" name="bc" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('WLLY')}
									</select>
								</div>
							</div> --%>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">PID&nbsp;&nbsp;</label>
									<input type="text" id="pid" name="pid" onfocus="this.blur()" class="form-control parent-node skydisabled" disabled="disabled"/>
									<span class="input-group-addon">
										<i class="icon-search bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">机型&nbsp;&nbsp;</label>
									<select role="select" name="jixing" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										<%-- ${fns:loadDictOption('JIXING')} --%>
										${fns:loadModelOption('0','1')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">机芯&nbsp;&nbsp;</label>
									<input type="text" name="zbxh" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">主板方案&nbsp;&nbsp;</label>
									<select role="select" name="zbfa" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										
										${fns:loadDictOption('ZBFA')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
						</div>
						<div class="space-4"></div>
						<!-- <div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">品牌&nbsp;&nbsp;</label>
								<input type="text" name="pp" class="form-control skydisabled" disabled="disabled"/>
							</div>
						</div> -->
						<shiro:hasPermission name="order:orderSample:price">
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">单价&nbsp;&nbsp;</label>
									<input type="text" name="dj" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">加工费&nbsp;&nbsp;</label>
									<input type="text" name="jgf" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">运费&nbsp;&nbsp;</label>
									<input type="text" name="yf" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">单台总价&nbsp;&nbsp;</label>
									<input type="text" name="dtzj" class="form-control" readonly/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						</shiro:hasPermission>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">数量&nbsp;&nbsp;</label>
								<!-- 	<input type="text" name="sl" class="form-control skydisabled" disabled="disabled"/> -->
								<input type="text" name="sl" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">币种&nbsp;&nbsp;</label>
									<select role="select" name="bz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('BZ')}
									</select>
								</div>
							</div>
							<shiro:hasPermission name="order:orderSample:price">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">总金额&nbsp;&nbsp;</label>
									<input type="text" name="zje" class="form-control" readonly/>
								</div>
							</div>
							</shiro:hasPermission>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户验货要求&nbsp;&nbsp;</label>
									<textarea name="khyhyq" class="autosize-transition form-control skydisabled" disabled="disabled"></textarea>
								</div>
							</div>
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">其他备注&nbsp;&nbsp;</label>
									<textarea name="qtbz" class="autosize-transition form-control skydisabled" disabled="disabled"></textarea>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-sm-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">变更信息备注&nbsp;&nbsp;</label>
									<textarea name="bgbz" class="autosize-transition form-control"></textarea>
								</div>
							</div>
						</div>
					</div>
					<!-- 产品详细功能需求TAB -->
					<div class="tab-pane fade" id="cpxxgnxq-tab">
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">电源插头&nbsp;&nbsp;</label>
									<select role="select" name="ctlx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('CTLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="ctlxbz" placeholder="电源插头备注" class="form-control skydisabled " disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">电压&nbsp;&nbsp;</label>
									<select role="select" name="dianya" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('DIANYA')} 
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="dianyabz" placeholder="电压备注" class="form-control skydisabled " disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<!-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否需要电源开关&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfDykg" value="1" checked="checked">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfDykg" value="0">不需要
										</label>
									</div>
								</div>
							</div> -->
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">后壳RoHS&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfRohs" value="1" checked="checked">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfRohs" value="0">不需要
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">REACH&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfReach" value="1" checked="checked">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfReach" value="0">不需要
										</label>
									</div>
								</div>
							</div>
							<!-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">3D眼镜盒数&nbsp;&nbsp;</label>
									<input type="text" name="sl3dyjh" class="form-control skydisabled" disabled="disabled" />
								</div>
							</div> -->
						<!-- </div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;"> -->
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">待机功率&nbsp;&nbsp;</label>
									<select role="select" name="djgl" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('DJGL')} 
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="djglbz" placeholder="待机功率备注" class="form-control skydisabled skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">OSD语言&nbsp;&nbsp;</label>
									<input type="text" name="osdyy" class="form-control skydisabled" disabled="disabled" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">附加功能&nbsp;&nbsp;</label>
									<div class="form-control">
										<!-- <label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fjgbPgs3d" value="1">偏光式3D
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fjgnKms3d" value="1">快门式3D
									    </label> -->
								    	<label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fjgnCij" value="1">CI+
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fjgnCi" value="1">CI
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fjgnScart" value="1">SCART
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fjgnWifi" value="1">WIFI
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="fjgnWifidongle" value="1">WIFI Dongle
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">能效等级&nbsp;&nbsp;</label>
									<input type="text" name="nxdj" class="form-control skydisabled" disabled="disabled" />
								</div>
							</div>
						</div>
					</div>
					<!-- 结构特性TAB -->
					<div class="tab-pane fade" id="jgtx-tab">
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-12 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">外壳颜色标准化&nbsp;&nbsp;</label>
									<input type="text" name="wkysbz" class="form-control skydisabled" disabled="disabled" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
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
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">前壳工艺&nbsp;&nbsp;</label>
									<select role="select" name="qkgy" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('QKGY')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="sfQkfhl" value="1">防火料
								    </label>
							    </div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">后壳工艺&nbsp;&nbsp;</label>
									<select role="select" name="hkgy" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('QKGY')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="sfHkfhl" value="1">防火料
								    </label>
								    <label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="sfHkxraytz" value="1">X-RAY贴纸
								    </label>
							    </div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">底座工艺&nbsp;&nbsp;</label>
									<select role="select" name="dzgy" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('QKGY')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group-sm">
									<input type="text" name="dzgybz" placeholder="底座工艺备注" class="form-control skydisabled " disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="checkbox-inline">
							    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="sfDzfhl" value="1">防火料
								    </label>
							    </div>
							</div>
						</div>
						
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">底座包装方式&nbsp;&nbsp;</label>
									<select role="select" name="dzbz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('DZBZFS')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group-sm">
									<input type="text" name="dzbzbz" placeholder="底座包装方式备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
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
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">挂架包装方式&nbsp;&nbsp;</label>
									<select role="select" name="gjbz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('GJBZ')}
									</select>
								</div>
							</div>
							<!-- <div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏品牌&nbsp;&nbsp;</label>
									<input type="text" name="ppp" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div> -->
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏型号&nbsp;&nbsp;</label>
									<input type="text" name="pxh" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">屏编号&nbsp;&nbsp;</label>
									<input type="text" name="pbh" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">分辨率&nbsp;&nbsp;</label>
									<select role="select" name="fbl" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('FBL')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">2D/3D&nbsp;&nbsp;</label>
									<div class="form-control ">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sf3d" value="0" checked="checked" >2D
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sf3d" value="1">3D
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">电源类型&nbsp;&nbsp;</label>
									<select role="select" name="dylx" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('DY')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="dylxbz" placeholder="电源类型备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">开机LOGO&nbsp;&nbsp;</label>
									<input type="text" name="kjlogo" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">OSD出厂语言设置&nbsp;&nbsp;</label>
									<input type="text" name="osdccyysz" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">遥控器&nbsp;&nbsp;</label>
									<select role="select" name="ykq" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('YKQ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="ykqbz" placeholder="遥控器备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否需要电池&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfDc" value="1" checked="checked">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfDc" value="0">不需要
										</label>
									</div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">模拟量标准&nbsp;&nbsp;</label>
									<select role="select" name="mnlbz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('MNLBZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="mnlbzbz" placeholder="模拟量标准备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">质量标准&nbsp;&nbsp;</label>
									<select role="select" name="zlbz" size="1" class="form-control skyselect skydisabled" disabled="disabled">
										${fns:loadDictOption('ZLBZ')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="zlbzbz" placeholder="质量标准备注" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">检验要求&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="checkbox-inline">
								    		<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="jyyqGzps" value="1">主观评审
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="jyyqJgaq" value="1">结构安全
									    </label>
								    	<label class="checkbox-inline">
									    	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="jyyqDxn" value="1">电性能
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="jyyqAqgy" value="1">安全工艺
									    </label>
									    <label class="checkbox-inline">
									      	<input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="jyyqRzcs" value="1">认证测试
									    </label>
								    </div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">是否需要木箱&nbsp;&nbsp;</label>
									<div class="form-control">
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfMx" value="1" checked="checked">需要
										</label>
										<label class="radio-inline">
											<input type="radio" class="skyradio skydisabled" disabled="disabled" name="sfMx" value="0">不需要
										</label>
									</div>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3" style="display:none">
								<div class="input-group input-group-sm">
									<label class="input-group-addon" >产品经理&nbsp;&nbsp;</label>
									<input type="text" name="cpjlid" class="form-control skydisabled" disabled="disabled"/>
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
	var grid_pixx_selector = "#grid-table-pixx";
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	<shiro:hasPermission name="order:orderSample:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($){
		$(".skyselect").select2();
		$(".date-picker").bindDate();
		// 客户选择
		$("#form-submit [name=khbm]").click(function(){
			bindKhbm();
		});
		// 产品ID选择
		$("#form-submit [name=pid]").click(function(){
			bindPidSelect();
		});
		// 销售员选择
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
					$("#form-submit [name=ywz]").val(record.ywz);
					$("#form-submit [name=ywzmc]").val(record.ywzmc);
					$("#form-submit [name=xszz]").val(record.xszz);
					$("#form-submit [name=xszzmc]").val(record.xszzmc);
				}else{
					$("#form-submit [name=xsyid]").val("");
					$("#form-submit [name=xsymc]").val("");
					$("#form-submit [name=ywz]").val("");
					$("#form-submit [name=ywzmc]").val("");
					$("#form-submit [name=xszz]").val("");
					$("#form-submit [name=xszzmc]").val("");
				}
				$("input[name=khbm]").val("");
				$("input[name=khmc]").val("");
				$("input[name=fktj]").select2("val","");
			}
		});
		// 电源插头的绑定事件 为其他时可填备注
  		bindCtlxEvent();
  		// 电压的绑定事件 为其他时可填备注
  		bindDianyaEvent();
  		// 待机功率的绑定事件 为其他时可填备注
  		bindDjglEvent();
  		// 底座包装的绑定事件 为其他时可填备注
  		bindDzbzEvent();
  		// 底座工艺的绑定事件 为其他时可填备注
  		bindDzgyEvent();
  		// 挂机类型的绑定事件 为其他时可填备注
  		bindGuajiaEvent();
  		// 电源类型的绑定事件 为其他时可填备注
  		bindDylxEvent();
  		// 遥控器的绑定事件 为其他时可填备注
  		bindYkqEvent();
  		// 模拟量标准的绑定事件 为客户模拟量标准时可填备注
  		bindMnlbzEvent();
  		// 质量标准的绑定事件 为客户标准时可填备注
  		bindZlbzEvent();
		// 付款方式初始化
		bindFktjSelect();
		// PI明细信息编辑表
		bindGridPixx();
		// 初始化页面数据
		initFormData(id);
		// 前端数据校验
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: 'input[type=hidden]',
			rules: {
				dj: { required:true , number:true },
				jgf: 'number',
				yf: { required:true , number:true },
				sl: { required:true , number:true },
				fktj: 'required',
				gjmytk: 'required',
				gjmytkbz: 'required',
				qd:'required'
			},
			messages: {
				dj: '单价不能为空',
				jgf: '加工费不能为空',
				yf: '运费不能为空',
				sl: '数量不能为空',
				fktj: '付款条件不能为空',
				gjmytk: '国际贸易条款不能为空',
				gjmytkbz: '国际贸易条款备注不能为空',
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
	
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户编码","value":"khbm"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:80},
					  {name:'khmc', index:'khmc', label:'客户名称', width:80},
					  {name:'khdz', index:'khdz', label:'客户地址', width:80,hidden:true},
					  {name:'dh', index:'dh', label:'电话', width:80,hidden:true},
					  {name:'yx', index:'yx', label:'邮箱', width:80,hidden:true},
					  {name:'lxr', index:'lxr', label:'联系人', width:80,hidden:true},
					  {name:'fktj', index:'fktj', hidden:true},
					  {name:'fktjms', index:'fktjms', label:'付款条件', width:120}],
				  url:"<c:url value='/pub/widget/findCustByXsy'/>?xsyid="+$('#form-submit [name=xsyid]').val()
		},{
			callback:function(rows){
				if(rows){
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
					$("input[name=fktj]").select2("val",rows.fktj);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
					$("input[name=fktj]").select2("val","");
				}
			}
		});
	}
	// PID选择
	function bindPidSelect(){
		$.tableDialogPage({
			title:"PID选择",
			searchCond:[{"name":"PID","value":"pid"},
			            {"name":"机芯","value":"jixin"}],
			colModel:[{name:'id', index:'id', label:'ID',hidden:true},
			          {name:'pid', index:'pid', label:'PID'},
			          {name:'jixing', index:'jixing', label:'机型'},
			          {name:'jixin', index:'jixin', label:'机芯'}],
			url:"<c:url value='/pub/widget/findPid'/>"
		},{
			callback:function(rows){
				if(rows){
					if(rows){
						$("#form-submit [name=pid]").val(rows.pid);
						$("#form-submit [name=jixing]").select2("val", rows.jixing);
					}else{
						$("#form-submit [name=pid]").val("");
						$("#form-submit [name=jixing]").select2("val", "");
					}
				}
			}
		});
	}
	// 电源插头的绑定事件 为其他时可填备注
	function bindCtlxEvent(){
		$('#form-submit [name=ctlx]').on('change',function(e){
			if(e.val == 5){
				$('#form-submit [name=ctlxbz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=ctlxbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=ctlxbz]').val("");
				$('#form-submit [name=ctlxbz]').prop('disabled','disabled');
			}
		});
	}
	// 电压的绑定事件 为其他时可填备注
	function bindDianyaEvent(){
		$('#form-submit [name=dianya]').on('change',function(e){
			if(e.val == 3){
				$('#form-submit [name=dianyabz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=dianyabz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=dianyabz]').val("");
				$('#form-submit [name=dianyabz]').prop('disabled','disabled');
			}
		});
	}
	// 待机功率的绑定事件 为其他时可填备注
	function bindDjglEvent(){
		$('#form-submit [name=djgl]').on('change',function(e){
			if(e.val == 4){
				$('#form-submit [name=djglbz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=djglbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=djglbz]').val("");
				$('#form-submit [name=djglbz]').prop('disabled','disabled');
			}
		});
	}
	// 底座包装的绑定事件 为其他时可填备注
	function bindDzbzEvent(){
		$('#form-submit [name=dzbz]').on('change',function(e){
			if(e.val == 4){
				$('#form-submit [name=dzbzbz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=dzbzbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=dzbzbz]').val("");
				$('#form-submit [name=dzbzbz]').prop('disabled','disabled');
			}
		});
	}
	// 底座工艺的绑定事件 为其他时可填备注
	function bindDzgyEvent(){
		$('#form-submit [name=dzgy]').on('change',function(e){
			if(e.val == 3){
				$('#form-submit [name=dzgybz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=dzgybz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=dzgybz]').val("");
				$('#form-submit [name=dzgybz]').prop('disabled','disabled');
			}
		});
	}
	// 挂架类型的绑定事件 为其他时可填备注
	function bindGuajiaEvent(){
		$('#form-submit [name=guajia]').on('change',function(e){
			if(e.val == 3){
				$('#form-submit [name=guajiabz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=guajiabz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=guajiabz]').val("");
				$('#form-submit [name=guajiabz]').prop('disabled','disabled');
			}
		});
	}
	// 电源类型的绑定事件 为其他时可填备注
	function bindDylxEvent(){
		$('#form-submit [name=dylx]').on('change',function(e){
			if(e.val == 4){
				$('#form-submit [name=dylxbz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=dylxbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=dylxbz]').val("");
				$('#form-submit [name=dylxbz]').prop('disabled','disabled');
			}
		});
	}
	// 遥控器的绑定事件 为其他时可填备注
	function bindYkqEvent(){
		$('#form-submit [name=ykq]').on('change',function(e){
			if(e.val == 2){
				$('#form-submit [name=ykqbz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=ykqbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=ykqbz]').val("");
				$('#form-submit [name=ykqbz]').prop('disabled','disabled');
			}
		});
	}
	// 模拟量标准的绑定事件 为客户模拟量标准时可填备注
	function bindMnlbzEvent(){
		$('#form-submit [name=mnlbz]').on('change',function(e){
			if(e.val == 2){
				$('#form-submit [name=mnlbzbz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=mnlbzbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=mnlbzbz]').val("");
				$('#form-submit [name=mnlbzbz]').prop('disabled','disabled');
			}
		});
	}
	// 质量标准的绑定事件 为客户标准时可填备注
	function bindZlbzEvent(){
		$('#form-submit [name=zlbz]').on('change',function(e){
			if(e.val == 1){
				$('#form-submit [name=zlbzbz]').removeProp('disabled').removeAttr("disabled");
			}else{
				$('#form-submit [name=zlbzbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=zlbzbz]').val("");
				$('#form-submit [name=zlbzbz]').prop('disabled','disabled');
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
	// PI明细信息编辑表
	function bindGridPixx(){
		$(grid_pixx_selector).bindTable({
			caption: "",
			gridParent: "#grid-parent-pixx",
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
				//{name:'wlbh', index:'wlbh', label:'物料编号', width:60},
				{name:'pid', index:'pid', label:'PID', width:60},
				{name:'khxhms', index:'khxhms', label:'客户型号描述', width:80},
				{name:'jixing', index:'jixing', label:'机型', width:80},
				{name:'jixin', index:'jixin', label:'机芯', width:80},
				{name:'bz', index:'bz', label:'币种', width:80},
				{name:'sl', index:'sl', label:'数量', width:60, align:'right', 
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true},},
				<shiro:hasPermission name="order:orderSample:price">
				{name:'dj', index:'dj', label:'单价', width:60,align:'right', 
						formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6}},
				</shiro:hasPermission>	
				//{name:'dw', index:'dw', label:'单位', width:80},
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
	//初始化页面数据
	function initFormData(id){
		if(id == "null"){
			//add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=ddlx]").select2("val","3");
			$("#form-submit [name=zt]").select2("val","1");
			$("#form-submit [name=pm]").select2("val","1");
			$("#form-submit [name=zs]").select2("val","1");
			$("#form-submit [name=wj]").select2("val","1");
			$("#form-submit [name=zb]").select2("val","1");
			$("#form-submit [name=dy]").select2("val","1");
			$("#form-submit [name=bc]").select2("val","1");
			$("#form-submit [name=scjd]").select2("val",2110);
			$('#form-submit [name=ctlxbz]').prop("disabled","disabled");//插头类型备注
			$('#form-submit [name=dianyabz]').prop("disabled","disabled");//电源备注
			$('#form-submit [name=djglbz]').prop("disabled","disabled");//待机功率备注
			$('#form-submit [name=dzgybz]').prop("disabled","disabled");//底座工艺备注
			$('#form-submit [name=dzbzbz]').prop("disabled","disabled");//底座包装备注
			$('#form-submit [name=guajiabz]').prop("disabled","disabled");//挂架备注
			$('#form-submit [name=dylxbz]').prop("disabled","disabled");//电源类型备注
			$('#form-submit [name=ykqbz]').prop("disabled","disabled");//遥控器备注
			$('#form-submit [name=mnlbzbz]').prop("disabled","disabled");//模拟量标准备注
			$('#form-submit [name=zlbzbz]').prop("disabled","disabled");//质量标准备注
		} else {
			// edit
			$.bindAjax({
				url : "<c:url value='/order/orderSample/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				if(response){
					$("#form-submit").setFormData(response);
					// 变更草稿编辑时，客户、币种、付款条件、走货方式、PID、生产基地不允许修改
					if(response.sfBg == 1){
						$("#form-submit [name=scjd]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=khbm]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=fktj]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=bz]").prop("disabled","disabled").addClass("skydisabled");
						$("#form-submit [name=pid]").prop("disabled","disabled").addClass("skydisabled");
						$('.changeJeSelect').show();//驳回时选择修改金额还是单价
						$("#form-submit [name=slje][value=0]").prop("checked","checked");//默认修改金额
					}
					// 加载PI明细
					if(response.orderReferPiList){
						$(grid_pixx_selector).jqGrid("addRowData", null, response.orderReferPiList, "last");
					}
					$("#form-submit [name=oper]").val("edit");
					$("#form-submit [name=taskId]").val(taskId);
					if(response.sfMf != 1){
						show_pid();
					} else {
						hidden_pid();
					}
				}
			});
		}
	}
	
	function delPI(id){
		$(grid_pixx_selector).jqGrid("delRowData", id);
	}
	
	function save(){
		// 表单验证
		if(!$('#form-submit').valid()){
			return false;
		}
		if(!validDTZJ()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
		if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		var data = $(grid_pixx_selector).getRowData();
		param.piList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/order/orderSample/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					if(result){
						$("#form-submit [name=id]").val(result.id);
						$("#form-submit [name=ddid]").val(result.ddid);
						$("#form-submit [name=yddid]").val(result.yddid);
						$("#form-submit [name=sjc]").val(result.sjc);
						$("#form-submit [name=bbh]").val(result.bbh);
						$("#form-submit [name=token]").val(result.token);
					}
				}); 
			}
		});
	}
	
	function submit(){
		if(!$('#form-submit').valid()){
			return false;
		}
		if(!validDTZJ()){
			return false;
		}
		var sfbg = $("#form-submit [name=sfBg]").val();//
		if(sfbg == 1 && $("#form-submit [name=bgbz]").val() == ""){
    		swal('','变更备注信息不能为空！','warning'); 
    		return ;
    	}
		var param = $("#form-submit").getFormData();
		var data = $(grid_pixx_selector).getRowData();
		param.piList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/order/orderSample/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	
	$("#btn-piSelect").click(function(){
		var width = 1366;
		var height = 768;
		var left = 0;
		var top = 0;
		var ddid = $("#form-submit [name=ddid]").val();
		var pageUrl = "<c:url value='/order/orderReferPi/sample'/>"+"?ddid=" + ddid;
		if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
			var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
			var data = window.showModalDialog(pageUrl,null,dialogArgs);
			if(data){
				initPiData(data);
			}
		}else{
			var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
			var opener = window.open(pageUrl,null,dialogArgs);
			opener.openerCallBack = function(data){
				initPiData(data);
			}
		}
	});
	
	// 隐藏PI
	function show_pid(){
		$("#btn-piSelect").removeProp("disabled").removeAttr("disabled");
	}
	// 显示PI
	function hidden_pid(){
		$("#btn-piSelect").prop("disabled","disabled");
	}
	//变更时检验订单里的PID、客户编码、币种、付款条件与所选PI是否一致
	function validatePiData(data){
		var pid = $('#form-submit [name=pid]').val();
		var khbm = $('#form-submit [name=khbm]').val();
		var bz = $('#form-submit [name=bz]').val();
		var fktj = $('#form-submit [name=fktj]').val();
		var gsbm = $('#form-submit [name=gsbm]').val();
		var isSame = false;
   		//变更时PID、走货方式、客户编码、币种、付款条件不允许变更
   		if(data.pid == null || data.pid == ""){
   			if(data.khbm == khbm && data.bz == bz && data.fktj == fktj && data.gsbm == gsbm){
   				isSame = true ;
   			}
   		}else {
   			if(data.pid == pid && data.khbm == khbm &&
   					data.bz == bz && data.fktj == fktj && data.gsbm == gsbm){
   				isSame = true ;
   			}
   			alert("ok");
   		}
	   return isSame;
	}
	function initPiData(data){
		if(!validatePiData(data)){
			swal("","所选PI的客户、币种、付款条件、公司编码与原订单不一致","warning");
			return;
		} 
		$(grid_pixx_selector).jqGrid("clearGridData");
		$(grid_pixx_selector).jqGrid("addRowData", null, data, "last");
		//$("#form-submit [name=scjd]").select2("val",data.scjd);
		$("#form-submit [name=gsbm]").select2("val",data.gsbm);
		$("#form-submit [name=khbm]").val(data.khbm);
		$("#form-submit [name=khmc]").val(data.khmc);
		$("#form-submit [name=fktj]").select2("val", data.fktj);
		$("#form-submit [name=xsyid]").val(data.xsyid);
		$("#form-submit [name=xsymc]").val(data.xsymc);
		$("#form-submit [name=xszz]").val(data.xszz);
		$("#form-submit [name=xszzmc]").val(data.xszzmc);
		$("#form-submit [name=ywz]").val(data.ywz);
		$("#form-submit [name=ywzmc]").val(data.ywzmc);
		$("#form-submit [name=bz]").select2("val", data.bz);
		$("#form-submit [name=dtzj]").val(data.dj);
		$("#form-submit [name=sl]").val(data.sl);
		$("#form-submit [name=zje]").val(data.je);
		$("#form-submit [name=pid]").val(data.pid);
		$("#form-submit [name=jixing]").val(data.jixing);
		$("#form-submit [name=gjmytk]").select2("val", data.gjmytk);
		$("#form-submit [name=gjmytkbz]").val(data.gjmytkbz);
		
	}
	//单价、加工费、运费之和等于单台总价校验
	function validDTZJ(){
		var dj = $("#form-submit [name=dj]").val();
		var jgf = $("#form-submit [name=jgf]").val();
		var yf = $("#form-submit [name=yf]").val();
		var dtzj = $("#form-submit [name=dtzj]").val();
		var sfmf = $("#form-submit [name=sfMf]").val();
		if(sfmf == 1){
			$("#form-submit [name=dtzj]").val(Number(dj)+Number(jgf)+Number(yf));
		} else {
			if(Number(dj)+Number(jgf)+Number(yf) != Number(dtzj)){
				swal("", "订单的价格（单台总价）与PI的价格不一致！", "warning");
				return false;
			}
		}
		return true;
	}
</script>
</html>