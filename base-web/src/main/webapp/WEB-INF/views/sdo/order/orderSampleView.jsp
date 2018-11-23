<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String sfApprove = request.getParameter("sfApprove");
		String processInstanceId = request.getParameter("processId");
		pageContext.setAttribute("sfApprove", sfApprove);
		pageContext.setAttribute("processInstanceId", processInstanceId);
	%>
	<style type="text/css">
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
		.dialog .modal-dialog{
			width:1100px;
		}
		.pre{
			background-color:#ffffff;
			border:0px solid #ffffff;
			padding :0px;
			font-size : 14px;
			font-family:"Open Sans","Helvetica Neue",Helvetica,Arial,sans-serif;
			/* float:left; */
		}
		.hh td,.hh th{
			word-wrap : break-word;
			word-break : break-all;
		}
	</style>
</head>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row" style="margin: 0px 8px;">
				<input type="hidden" name="id" value="${orderSample.id}"/><!-- 订单id -->
				<input type="hidden" name="sjc" value="${orderSample.sjc}"/>
				<input type="hidden" name="sfMf" value="${orderSample.sfMf}"/>
				<input type="hidden" name="sfWx" value="${orderSample.sfWx}"/>
				<input type="hidden" name="xszz" value="${orderSample.xszz}"/>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 80%"><b>订单号：</b>${orderSample.ddid}</td>
						<td style="width: 20%">
							<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
								<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
									<i class="fa-file-image-o icon-on-right bigger-110"></i>
									流程图
								</button>
								&nbsp;
							</c:if>
							<c:if test="${sfApprove != 1}">
								<c:if test="${orderSample.zt == '2' ||orderSample.zt == '4' || orderSample.zt == '5'}">
									<button id="btn-print" type="button" class="btn btn-light btn-sm">
										<i class="icon-print icon-on-right bigger-110"></i>
										打印
									</button>
									&nbsp;
								</c:if>
								<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
									返回
								</button>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
		
			<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>生产基地：</b>${orderSample.scjdmc}</td>
						<td style="width: 25%"><b>公司编码：</b>${orderSample.gsbm}-${orderSample.gsmc}</td>
						<td style="width: 25%"><b>订单类型：</b>${orderSample.ddlxmc}</td>
						<td style="width: 25%"><b>订单状态：</b>${orderSample.ztmc}</td>
					</tr>
					<tr>
						<td><b>制单人：</b>${orderSample.zdrmc}</td>
						<td><b>制单日期：</b><fmt:formatDate value="${orderSample.zdsj}" pattern="yyyy-MM-dd"/></td>
						<td><b>销售员：</b>${orderSample.xsymc}</td>
						<td><b>业务组：</b>${orderSample.ywzmc}</td>
					</tr>
					<tr>
						<td><b>销售组织：</b>${orderSample.xszzmc}</td>
						<td><b>业务类型：</b>${orderSample.ywlxmc}</td>
						<td><b>版本号：</b>${orderSample.bbh}</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			
			<h5 class="header blue" style="margin-top:4px;">PI信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>PI号</th>
						<th>PI类型</th>
						<th>明细类型</th>
						<th>PID</th>
						<th>币种</th>
						<th>机型</th>
						<th>机芯</th>
						<th>客户型号描述</th>
						<th>数量</th>
					    <shiro:hasPermission name="order:orderSample:price">
						<th>单价</th>
						</shiro:hasPermission>
					</tr>
					<c:forEach items="${orderSample.orderReferPiList}" var="item">
						<tr>
							<td>${item.piid}</td>
							<td>${item.pilxmc}</td>
							<td>${item.mxlxmc}</td>
							<td>${item.pid}</td>
							<td>${item.bz}</td>
							<td>${item.jixing}</td>
							<td>${item.jixin}</td>
							<td>${item.khxhms}</td>
							<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
							<shiro:hasPermission name="order:orderSample:price">
							<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
							</shiro:hasPermission>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<!-- <div class="space-8"></div>
			<ul class="nav nav-tabs">
				<li class="active"><a href="#jbxx-tab" data-toggle="tab">基本信息</a></li>
				<li><a href="#cpgs-tab" data-toggle="tab">产品概述</a></li>
				<li><a href="#cpxxgnxq-tab" data-toggle="tab">产品详细功能需求</a></li>
				<li><a href="#jgtx-tab" data-toggle="tab">结构特性</a></li>
			</ul> -->
			
			<!-- <div class="tab-content"> -->
				<!-- 基本信息TAB -->
				<!-- <div class="tab-pane fade active in" id="jbxx-tab"> -->
				<h5 class="header blue" style="margin-top:4px;">基本信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td style="width: 25%"><b>客户编码：</b>${orderSample.khbm}</td>
								<td style="width: 25%"><b>客户名称：</b>${orderSample.khmc}</td>
								<td style="width: 25%"><b>销往国家：</b>${orderSample.xwgjmc}</td>
								<td style="width: 25%"><b>销售性质：</b>${orderSample.xsxzmc}</td>
							</tr>
							<tr>
								<td><b>样机类型：</b>${orderSample.yjlxmc}</td>
								<td><b>样机用途：</b>${orderSample.yjytmc}</td>
								<td><b>工厂：</b>${orderSample.gcmc}</td>
								<td><b>是否返退：</b>
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfFt == 1}">checked="checked"</c:if>>是
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfFt == 0}">checked="checked"</c:if>>否
								</td>
							</tr>
							<tr>
								<td><b>是否外协：</b>
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfWx == 1}">checked="checked"</c:if>>是
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfWx == 0}">checked="checked"</c:if>>否
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfWx == 2}">checked="checked"</c:if>>直接提取
								</td>
								<td><b>是否免费：</b>
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfMf == 1}">checked="checked"</c:if>>是
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfMf == 0}">checked="checked"</c:if>>否
								</td>
								<td><b>规格明细：</b>${orderSample.ggmxmc}</td>
								<td><b>规格明细备注：</b>${orderSample.ggmxbz}</td>
							</tr>
							<tr>
								<td><b>付款条件：</b>${orderSample.fktjmc}</td>
								<td><b>交货日期：</b><fmt:formatDate value="${orderSample.jhrq}" pattern="yyyy-MM-dd"/></td>
								<td><b>国际贸易条款：</b>${orderSample.gjmytkmc}</td>
								<td><b>国际贸易条款备注：</b>${orderSample.gjmytkbz}</td>
							</tr>
							<tr>
								<td><b>渠道：</b>${orderSample.qdmc}</td>
								<td><b>电视机类型：</b>${orderSample.dsjlxmc}</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<%-- <tr>
								<td colspan="4"></b><PRE class="pre"><b>辅助变更备注：${orderSample.fzbgbz}</PRE></td>
							</tr> --%>
						</table>
					</div>
				<!-- </div> -->
				<!-- 产品概述TAB -->
				<!-- <div class="tab-pane fade" id="cpgs-tab"> -->
				<h5 class="header blue" style="margin-top:4px;">产品概述</h5>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<%-- <tr>
								<td><b>屏幕：</b>${orderSample.pmmc}</td>
								<td><b>注塑：</b>${orderSample.zsmc}</td>
								<td><b>五金：</b>${orderSample.wjmc}</td>
								<td><b>主板：</b>${orderSample.zbmc}</td>
							</tr> --%>
							<tr>
								<%-- <td><b>电源：</b>${orderSample.dymc}</td>
								<td><b>包材：</b>${orderSample.bcmc}</td> --%>
								<td><b>PID：</b>${orderSample.pid}</td>
								<td><b>机型：</b>${orderSample.jixing}</td>
								<!-- <td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr> -->
								<td><b>机芯：</b>${orderSample.zbxh}</td>
								<td><b>主板方案：</b>${orderSample.zbfamc}</td>
								<%-- <td><b>品牌：</b>${orderSample.pp}</td>
								<td>&nbsp;</td> --%>
							</tr>
							<shiro:hasPermission name="order:orderSample:price">
							<tr>
								<td><b>单价：</b><fmt:formatNumber value="${orderSample.dj}" pattern="#,##0.000000"/></td>
								<td><b>加工费：</b><fmt:formatNumber value="${orderSample.jgf}" pattern="#,##0.000000"/></td>
								<td><b>运费：</b><fmt:formatNumber value="${orderSample.yf}" pattern="#,##0.000000"/></td>
								<td><b>单台总价：</b><fmt:formatNumber value="${orderSample.dtzj}" pattern="#,##0.000000"/></td>
							</tr>
							</shiro:hasPermission>
							<tr>
								<td><b>数量：</b><fmt:formatNumber value="${orderSample.sl}" pattern="#,##0"/></td>
								<td><b>币种：</b>${orderSample.bz}</td>
								<shiro:hasPermission name="order:orderSample:price">
								<td><b>总金额：</b><fmt:formatNumber value="${orderSample.zje}" pattern="#,##0.000000"/></td>
								</shiro:hasPermission>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td colspan="2"><PRE class="pre"><b>客户验货要求：</b>${orderSample.khyhyq}</PRE></td>
								<td colspan="2"><PRE class="pre"><b>其他备注：</b>${orderSample.qtbz}</PRE></td>
							</tr>
							<%-- <tr>
								<td colspan="4"><PRE class="pre"><b>变更信息备注：</b>${orderSample.bgbz}</PRE></td>
							</tr> --%>
						</table>
					</div>
				<!-- </div> -->
				<!-- 产品详细功能需求TAB -->
				<!-- <div class="tab-pane fade" id="cpxxgnxq-tab"> -->
				<h5 class="header blue" style="margin-top:4px;">产品详细功能需求</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td><b>电源插头：</b>${orderSample.ctlxmc}&nbsp;&nbsp;${orderSample.ctlxbz}</td>
								<td><b>电压：</b>${orderSample.dianyamc}&nbsp;&nbsp;${orderSample.dianyabz}</td>
								<%-- <td><b>是否需要电源开关：</b>
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfDykg == 1}">checked="checked"</c:if>>需要
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfDykg == 0}">checked="checked"</c:if>>不需要
								</td> --%>
								<td><b>是否需要后壳RoHS：</b>
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfRohs == 1}">checked="checked"</c:if>>需要
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfRohs == 0}">checked="checked"</c:if>>不需要
								</td>
								<td><b>是否需要REACH：</b>
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfReach == 1}">checked="checked"</c:if>>需要
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfReach == 0}">checked="checked"</c:if>>不需要
								</td>
							</tr>
							<tr>
								<td><b>待机功率 ：</b>${orderSample.djglmc}&nbsp;&nbsp;${orderSample.djglbz}</td>
								<td><b>OSD语言：</b>${orderSample.osdyy}</td>
								<td><b>附加功能：</b>
							      	<%-- <input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgbPgs3d == 1}">checked="checked"</c:if>>偏光式3D&nbsp;&nbsp;
							      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgnKms3d == 1}">checked="checked"</c:if>>快门式3D&nbsp;&nbsp; --%>
							      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgnCij == 1}">checked="checked"</c:if>>CI+&nbsp;&nbsp;
							      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgnCi == 1}">checked="checked"</c:if>>CI&nbsp;&nbsp;
							      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgnScart == 1}">checked="checked"</c:if>>SCART&nbsp;&nbsp;
							      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgnWifi == 1}">checked="checked"</c:if>>WIFI&nbsp;&nbsp;
							      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgnWifidongle == 1}">checked="checked"</c:if>>WIFI Dongle&nbsp;&nbsp;
								</td>
								<td><b>能效等级：</b>${orderSample.nxdj}</td>
								<%-- <td><b>3D眼镜盒：</b>${orderSample.sl3dyjh}</td> --%>
								<!-- <td>&nbsp;</td> -->
							</tr>
						</table>
					</div>
				<!-- </div> -->
				<!-- 结构特性TAB -->
				<!-- <div class="tab-pane fade" id="jgtx-tab"> -->
				<h5 class="header blue" style="margin-top:4px;">结构特性</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td colspan="3"><b>外壳颜色标准化：</b>${orderSample.wkysbz}</td>
								<td><b>泡沫：</b>${orderSample.paomomc}</td>
							</tr>
							<tr>
								<td><b>前壳工艺：</b>${orderSample.qkgymc}</td>
								<td>
							      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.sfQkfhl == 1}">checked="checked"</c:if>>防火料&nbsp;&nbsp;
								</td>
								<td><b>后壳工艺：</b>${orderSample.hkgymc}</td>
								<td>
							      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.sfHkfhl == 1}">checked="checked"</c:if>>防火料&nbsp;&nbsp;
									<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.sfHkxraytz == 1}">checked="checked"</c:if>>X-RAY贴纸&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<td colspan="3"><b>底座工艺：</b>${orderSample.dzgymc}&nbsp;&nbsp;${orderSample.dzgybz}</td>
								<td>
									<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.sfDzfhl == 1}">checked="checked"</c:if>>防火料&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<td colspan="4"><b>底座包装方式：</b>${orderSample.dzbzmc}&nbsp;&nbsp;${orderSample.dzbzbz}</td>
							</tr>
							<tr>
								<td><b>挂架：</b>${orderSample.guajiamc}</td>
								<td><b>挂架备注：</b>${orderSample.guajiabz}</td>
								<td><b>挂架包装方式：</b>${orderSample.gjbzmc}</td>
							</tr>
							<tr>
								<%-- <td><b>屏品牌：</b>${orderSample.ppp}</td> --%>
								<td><b>屏型号：</b>${orderSample.pxh}</td>
								<td><b>屏编号：</b>${orderSample.pbh}</td>
								<!-- <td>&nbsp;</td> -->
							<!-- </tr>
							<tr> -->
								<td><b>分辨率：</b>${orderSample.fblmc}</td>
								<td><b>2D/3D：</b>
									<input type="radio" class="skyradio" <c:if test="${orderSample.sf3d == 1}">checked="checked"</c:if>>3D
									<input type="radio" class="skyradio" <c:if test="${orderSample.sf3d == 0}">checked="checked"</c:if>>2D
								</td>
								<!-- <td>&nbsp;</td> -->
							</tr>
							<tr>
								<td colspan="2"><b>电源类型：</b>${orderSample.dylxmc}&nbsp;&nbsp;${orderSample.dylxbz}</td>
							<!-- </tr>
							<tr> -->
								<td><b>开机LOGO：</b>${orderSample.kjlogo}</td>
								<td><b>OSD出厂语言设置：</b>${orderSample.osdccyysz}</td>
								<!-- <td>&nbsp;</td> -->
							</tr>
							<tr>
								<td colspan="2"><b>遥控器：</b>${orderSample.ykqmc}&nbsp;&nbsp;${orderSample.ykqbz}</td>
								<td colspan="2"><b>是否需要电池：</b>
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfDc == 1}">checked="checked"</c:if>>需要
									<input type="radio" class="skyradio" <c:if test="${orderSample.sfDc == 0}">checked="checked"</c:if>>不需要
								</td>
							</tr>
							
							<tr>
								<td colspan="4"><b>模拟量标准：</b>${orderSample.mnlbzmc}&nbsp;&nbsp;${orderSample.mnlbzbz}</td>
							</tr>
							<tr>
								<td colspan="4"><b>质量标准：</b>${orderSample.zlbzmc}&nbsp;&nbsp;${orderSample.zlbzbz}</td>
							</tr>
							<tr>
								<td colspan="2"><b>检验要求：</b>
							    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqGzps == 1}">checked="checked"</c:if>>主观评审&nbsp;&nbsp;
							    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqJgaq == 1}">checked="checked"</c:if>>结构安全&nbsp;&nbsp;
							    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqDxn == 1}">checked="checked"</c:if>>电性能&nbsp;&nbsp;
							    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqAqgy == 1}">checked="checked"</c:if>>安全工艺&nbsp;&nbsp;
							    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqRzcs == 1}">checked="checked"</c:if>>认证测试&nbsp;&nbsp;
								</td>
								<td colspan="2"><b>是否需要木箱：</b>
								<input type="radio" class="skyradio" <c:if test="${orderSample.sfMx == 1}">checked="checked"</c:if>>需要
								<input type="radio" class="skyradio" <c:if test="${orderSample.sfMx == 0}">checked="checked"</c:if>>不需要
							</td>
							</tr>
							
							<%-- <tr>
								<td><b>产品经理：</b>${orderSample.cpjlmc}</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr> --%>
						</table>
					</div>
				<!-- </div> -->
						<h5 class="header blue" style="margin: 0; padding: 0;">付款保障检查情况</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px 8px;">
							<label id="fkbzrz"></label>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">变更明细情况</h5>
					    <div class="space-4"></div>
						<div class="row" style="margin: 0px 8px;">
							<table class="table table-bordered hh">
								<tr>
									<th style="width: 8%">订单号</th>
									<th style="width: 4%">变更前版本号</th>
									<th style="width: 4%">变更后版本号</th>
									<th style="width: 15%">字段名称</th>
									<th style="width: 28%">变更前内容</th>
									<th style="width: 28%">变更后内容</th>
									<th style="width: 13%">状态</th>
									<!-- <th>操作人</th>
									<th>操作时间</th> -->
								</tr>
								<c:forEach items="${orderSample.bgmxList}" var="item">
									<tr>
										<td>${item.ddid}</td>
										<td>${item.bbhOld}</td>
										<td>${item.bbh}</td>
										<td>${item.zdmx}<c:if test="${item.zdmc != null}">(${item.zdmc})</c:if></td>
										<td>${item.zdnrOld}</td>
										<td>${item.zdnrNew}</td>
										<td>${item.flagMx}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="row" style="margin: 0px 8px;">
							<table cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="4"><PRE class="pre"><b>变更信息备注：</b>${orderSample.bgbz}</PRE></td>
								</tr>
								<tr>
									<td colspan="4"><PRE class="pre"><b>辅助变更备注：</b>${orderSample.fzbgbz}</PRE></td>
								</tr>
							</table>
						</div>
						<h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
					    <div class="space-4"></div>
						<div class="row" style="margin: 0px 8px;">
							<table class="table table-bordered hh">
								<tr>
									<th style="width:10%">订单号</th>
									<th style="width:5%">版本号</th>
									<th style="width:10%">操作类型</th>
									<th style="width:10%">操作职位</th>
									<th style="width:20%">操作人账号</th>
									<th style="width:20%">操作人名称</th>
									<th style="width:10%">操作时间</th>
									<th style="width:15%">处理意见</th>
								</tr>
								<c:forEach items="${orderSample.logList}" var="item">
									<tr>
										<td>${item.ddid}</td>
										<td>${item.bbh}</td>
										<td>${item.czlx}</td>
										<td>${item.czzw}</td>
										<td>${item.czr}</td>
										<td>${item.czrmc}</td>
										<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td>${item.nr}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
			</div>
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
	$(function($){
		$(".skycheckbox").prop("disabled","disabled");
		$(".skyradio").prop("disabled","disabled");
		//打印
		$("#btn-print").click(function(){
			window.open("<c:url value='/order/orderSample/printPage'/>?id=" + $("input[name='id']").val());
		})
		// 查看流程
		$("#btn-flow").click(function(){
			bootbox.dialog({
				title : "流程图",
				className : "dialog",
				message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
		//返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		
		$.bindAjax({
			url:"<c:url value='/payment/payValidate/search'/>",
			data:{id : "${orderSample.id}" },
			action:"search"
		},function(response){
			if(response[0]){
				$("#fkbzrz").html(response[0].zy);
			}else{
				$("#fkbzrz").html('无');
			}
		});
		
	});
		
</script>
</html>