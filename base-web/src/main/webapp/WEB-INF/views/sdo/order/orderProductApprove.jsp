<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String processInstanceId = request.getParameter("processId");
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
<div class="page-content">
	<form id="form-submit">
		<div class="row" style="margin: 0px 8px;">
			<input type="hidden" name="id" value="${orderProduct.id}"/><!-- 订单id -->
			<input type="hidden" name="sjc" value="${orderProduct.sjc}"/>
			<input type="hidden" name="ddid" value="${orderProduct.ddid}"/>
			<input type="hidden" name="sfWxdd" value="${orderProduct.sfWxdd}"/>
			<input type="hidden" name="sfZt" value="${orderProduct.sfZt}"/>
			<input type="hidden" name="isRestart" value="${isRestart}"/>
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 15%"><b>订单号：</b>${orderProduct.ddid}</td>
					<td style="width: 15%"><b>订单类别：</b>${orderProduct.ddlbmc}</td>
					<td style="width: 15%"><b>参考订单号：</b>${orderProduct.ckddh}</td>
					<td style="width: 15%"><b>关联订单号：</b><%-- ${orderProduct.glddh} --%></td>
					<td style="width: 15%"><b>文件编号：</b>${orderProduct.wjbh}</td>
					<td style="width: 25%">
						<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
							<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
								<i class="fa-file-image-o icon-on-right bigger-110"></i>
								流程图
							</button>
							&nbsp;
						</c:if>
						<button id="btn-print" type="button" class="btn btn-light btn-sm">
							<i class="icon-print icon-on-right bigger-110"></i>
							打印
						</button>
					</td>
				</tr>
				<tr>
					<td style="width: 15%"><input type="radio" class="skyradio" <c:if test="${orderProduct.sfMzckd == 1}">checked="checked"</c:if>>模组CKD</td>
					<td style="width: 15%"><b>供应商：</b>${orderProduct.gysmc}</td>
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
					<th>我司型号</th>
					<th>客户型号描述</th>
					<th>大货数量</th>
					<th>收费样机数量</th>
					<shiro:hasPermission name="order:orderProduct:price">
					<th>单价</th>
					</shiro:hasPermission>
				</tr>
				<c:forEach items="${orderProduct.orderReferPiList}" var="item">
					<tr>
						<td>${item.piid}</td>
						<td>${item.pilxmc}</td>
						<td>${item.mxlxmc}</td>
						<td>${item.pid}</td>
						<td>${item.bz}</td>
						<td>${item.jixing}</td>
						<td>${item.khxhms}</td>
						<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
						<td align="right"><fmt:formatNumber value="${item.yjsl}" pattern="#,##0"/></td>
						<shiro:hasPermission name="order:orderProduct:price">
						<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
						</shiro:hasPermission>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<%-- <td style="width: 25%">PI号：${orderProduct.piid}</td> --%>
					<td style="width: 25%"><b>生产基地：</b>${orderProduct.scjdmc}</td>
					<td style="width: 25%"><b>公司：</b>${orderProduct.gsbm}-${orderProduct.gsmc}</td>
					<td style="width: 25%"><b>订单编码类型：</b>${orderProduct.ddbmlx}-${orderProduct.ddbmlxmc}</td>
					<td style="width: 25%"><b>订单类型：</b>${orderProduct.ddlxmc}</td>
				</tr>
				<tr>
					<td style="width: 25%"><b>业务类型：</b>${orderProduct.ywlxmc}</td>
					<td><b>订单状态：</b>${orderProduct.ztmc}</td>
					<td><b>制单人：</b>${orderProduct.zdrmc}</td>
					<td><b>制单日期：</b><fmt:formatDate value="${orderProduct.zdsj}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td><b>销售员：</b>${orderProduct.xsymc}</td>
					<td><b>业务组：</b>${orderProduct.ywzmc}</td>
					<td><b>销售组织：</b>${orderProduct.xszzmc}</td>
					<td><b>版本号：</b>${orderProduct.bbh}</td>
				</tr>
			</table>
		</div>
		
		<!-- <ul class="nav nav-tabs">
			<li class="active"><a href="#jbxx-tab" data-toggle="tab">基本信息</a></li>
			<li><a href="#khxx-tab" data-toggle="tab">客户信息</a></li>
			<li><a href="#cpxx-tab" data-toggle="tab">产品信息</a></li>
			<li><a href="#mgxx-tab" data-toggle="tab">美工信息</a></li>
			<li><a href="#bswlxx-tab" data-toggle="tab">备损物料信息</a></li>
		</ul> -->
		
		<!-- <div class="tab-content">
		基本信息TAB
		<div class="tab-pane fade active in" id="jbxx-tab"> -->
		<h5 class="header blue" style="margin-top:4px;">基本信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%"><b>PID：</b>${orderProduct.pid}</td>
					<td style="width: 25%"><b>我司型号：</b>${orderProduct.wsxh}</td>
					<td style="width: 25%"><b>机芯：</b>${orderProduct.jixin}</td>
					<td style="width: 25%"><b>买家型号：</b>${orderProduct.mjxh}</td>
				</tr>
				<tr>
					<td><b>外协订单：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfWxdd == 1}">checked="checked"</c:if>>外协
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfWxdd == 0}">checked="checked"</c:if>>非外协
					</td>
					<td><b>内销研发产品：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfNxyfcp == 1}">checked="checked"</c:if>>是
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfNxyfcp == 0}">checked="checked"</c:if>>否
					</td>
					<td><b>规格明细：</b>${orderProduct.ggmxmc}</td>
					<td><b>规格明细备注：</b>${orderProduct.ggmxbz}</td>
				</tr>
				<tr>
					<td><b>是否新品：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfXp == 1}">checked="checked"</c:if>>是
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfXp == 0}">checked="checked"</c:if>>否
					</td>
					<td><b>付款条件：</b>${orderProduct.fktjmc}</td>
					<td><b>国际贸易条款：</b>${orderProduct.gjmytkmc}</td>
					<td><b>国际贸易条款备注：</b>${orderProduct.gjmytkbz}</td>
				</tr>
				<tr>
					<td><b>币种：</b>${orderProduct.bz}</td>
					<td><b>大货数量：</b><fmt:formatNumber value="${orderProduct.sl}" pattern="#,##0"/>&nbsp;&nbsp;<b>收费样机数量：</b><fmt:formatNumber value="${orderProduct.yjsl}" pattern="#,##0"/></td>
					<td><b>走货方式：</b>${orderProduct.zhfsmc}</td>
					<td><b>加工方式：</b>${orderProduct.jgfsmc}</td>
				</tr>
				<shiro:hasPermission name="order:orderProduct:price">
				<tr>
					<td><b>单价：</b><fmt:formatNumber value="${orderProduct.dj}" pattern="#,##0.000000"/></td>
					<td><b>金额：</b><fmt:formatNumber value="${orderProduct.je}" pattern="#,##0.000000"/></td>								
					<td><b>付费备损金额：</b><fmt:formatNumber value="${orderProduct.ffbsje}" pattern="#,##0.000000"/></td>
					<td><b>总金额（含备损）：</b><fmt:formatNumber value="${orderProduct.zje}" pattern="#,##0.000000"/></td>
				</tr>
				</shiro:hasPermission>
				<tr>
					<td colspan="4"><b>走货不含物件：</b>
			    		<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.zhbhwjP == 1}">checked="checked"</c:if>>屏&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.zhbhwjJk == 1}">checked="checked"</c:if>>机壳&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.zhbhwjYkq == 1}">checked="checked"</c:if>>遥控器&nbsp;&nbsp;
				    	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.zhbhwjLb == 1}">checked="checked"</c:if>>喇叭&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.zhbhwjZx == 1}">checked="checked"</c:if>>纸箱&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.zhbhwjPm == 1}">checked="checked"</c:if>>高频头&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.zhbhwjJxZb == 1}">checked="checked"</c:if>>机芯+主板
					</td>
				</tr>
				<tr>
					<td colspan="4"><b>需单独走货物：</b>
				    	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.xddzhP == 1}">checked="checked"</c:if>>屏&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.xddzhJk == 1}">checked="checked"</c:if>>机壳&nbsp;&nbsp;
				    	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.xddzhLb == 1}">checked="checked"</c:if>>喇叭&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.xddzhZx == 1}">checked="checked"</c:if>>纸箱&nbsp;&nbsp;
				    	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.xddzhJxZb == 1}">checked="checked"</c:if>>机芯+主板
					</td>
				</tr>
				<tr>
					<td><b>出运类型：</b>${orderProduct.cylxmc}</td>
					<td><b>出运类型备注：</b>${orderProduct.cylxbz}</td>
					<td><b>交货日期：</b><fmt:formatDate value="${orderProduct.jhrq}" pattern="yyyy-MM-dd"/></td>
					<td><b>分公司收货日期：</b><fmt:formatDate value="${orderProduct.fgsshrq}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td><b>预测周数：</b>${orderProduct.yczs}</td>
					<td><b>预测日期：</b><fmt:formatDate value="${orderProduct.ycrq}" pattern="yyyy-MM-dd"/></td>
					<td><b>预测数量：</b>${orderProduct.ycsl}</td>
					<td><b>渠道：</b>${orderProduct.qdmc}</td>
				</tr>
				<tr>
					<td><b>是否验货：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfYh == 1}">checked="checked"</c:if>>是
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfYh == 0}">checked="checked"</c:if>>否
					</td>
					<td><b>是否验货备注：</b>${orderProduct.sfyhbz}</td>
					<td><b>验货日期：</b><fmt:formatDate value="${orderProduct.yhrq}" pattern="yyyy-MM-dd"/></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"><PRE class="pre"><b>基本信息备注：</b>${orderProduct.jbxxbz}</PRE></td>
				</tr>
<%--								<tr>
									<td colspan="4"><PRE class="pre"><b>变更信息备注：</b>${orderProduct.bgbz}</PRE></td>
								</tr>
 								<tr>
									<td colspan="4"><PRE class="pre"><b>辅助变更备注：</b>${orderProduct.fzbgbz}</PRE></td>
								</tr> --%>
			</table>
		</div>
		<!-- </div> -->
		<!-- 客户信息TAB -->
		<!-- <div class="tab-pane fade" id="khxx-tab"> -->
		<h5 class="header blue" style="margin-top:4px;">客户信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%"><b>客户编码：</b>${orderProduct.khbm}</td>
					<td style="width: 25%"><b>客户名称：</b>${orderProduct.khmc}</td>
					<td style="width: 25%"><b>销往国家：</b>${orderProduct.xwgjmc}</td>
					<td style="width: 25%"><b>时区：</b>${orderProduct.sq}</td>
				</tr>
				<tr>
					<td><b>品牌：</b>${orderProduct.pp}</td>
					<td><b>出厂语言：</b>${orderProduct.ccyymc}</td>
					<td><b>开机Logo：</b>${orderProduct.kjlogo}</td>
					<td><b>开机模式：</b>${orderProduct.kjmsmc}</td>
				</tr>
				<tr>
					<td><b>电子POP：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.dzpop == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.dzpop == 0}">checked="checked"</c:if>>不需要
					</td>
					<%-- <td><b>开机Logo附件：</b>${orderProduct.kjlogofj}</td> --%>
					<c:set var="kjlogofj" value="${orderProduct.kjlogofj}"/>
					<c:set var="kjlogofjxx" value="${fn:replace(kjlogofj,'icon-remove', 'fa fa-file')}"/>
					<td><b>开机Logo附件：</b>${fn:replace(kjlogofjxx,'red', '')}</td>
				</tr>
			</table>
		</div>
		<!-- </div> -->
		<!-- 产品信息TAB -->
		<!-- <div class="tab-pane fade" id="cpxx-tab"> -->
		<h5 class="header blue" style="margin-top:4px;">产品信息</h5>
		<h5 class="header black" style="margin: 0; padding: 0;">屏体信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%"><b>屏品牌：</b>${orderProduct.ppp}</td>
					<td style="width: 25%"><b>屏型号：</b>${orderProduct.pxh}</td>
					<td style="width: 25%"><b>屏编码：</b>${orderProduct.pxxbc}</td>
					<td style="width: 25%"><b>分辨率：</b>${orderProduct.fblmc}</td>
					<%-- <td style="width: 25%"><b>2D/3D：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sf3d == 0}">checked="checked"</c:if>>2D
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sf3d == 1}">checked="checked"</c:if>>3D
					</td> --%>
				</tr>
				<tr>
					<td><b>分辨率备注：</b>${orderProduct.fblbz}</td>
					<td><b>屏包装要求：</b>${orderProduct.pbzyqmc}</td>
					<td><b>屏包装要求备注：</b>${orderProduct.pbzyqbz}</td>
					<td><b>屏亮点选项：</b>${orderProduct.pldmc}</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">认证信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td colspan="2"><b>认证：安全</b>
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Cb == 1}">checked="checked"</c:if>>CB&nbsp;&nbsp;  
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Etl == 1}">checked="checked"</c:if>>ETL&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Cetl == 1}">checked="checked"</c:if>>cETL&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Paq == 1}">checked="checked"</c:if>>PSE-安全&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Raq == 1}">checked="checked"</c:if>>RED-安全&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Smaq == 1}">checked="checked"</c:if>>S-mark 安全
					</td>
					<td colspan="2">${orderProduct.rz1Bz}</td>
				</tr>
				<tr>
					<td colspan="2"><b>认证：电磁兼容</b>
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz2Emc == 1}">checked="checked"</c:if>>EMC&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz2Fcc == 1}">checked="checked"</c:if>>FCC&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz2Rtte == 1}">checked="checked"</c:if>>RTTE&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz2Pe == 1}">checked="checked"</c:if>>PSE-EMC&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz2Rr == 1}">checked="checked"</c:if>>RED-RF&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz2Sme == 1}">checked="checked"</c:if>>S-mark -EMC
					</td >
					<td colspan="2">${orderProduct.rz2Bz}</td>
				</tr>
				<tr>
					<td colspan="2"><b>认证：能效</b>
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz4Erp == 1}">checked="checked"</c:if>>ERP&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz4Gems == 1}">checked="checked"</c:if>>GEMS&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz4Bee == 1}">checked="checked"</c:if>>BEE&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz4Nrc == 1}">checked="checked"</c:if>>NRcan&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz4Nfnx == 1}">checked="checked"</c:if>>南非能效&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz4Eg == 1}">checked="checked"</c:if>>Energy Guide
					</td>
					<td colspan="2">${orderProduct.rz4Bz}</td>
				</tr>
				<tr>
					<td colspan="2"><b>认证：专利</b>
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz3Hdmi == 1}">checked="checked"</c:if>>HDMI&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz3Dd == 1}">checked="checked"</c:if>>DD&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz3Dts == 1}">checked="checked"</c:if>>DTS&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz3Cij == 1}">checked="checked"</c:if>>CI+&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz3Bqb == 1}">checked="checked"</c:if>>BQB&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz3Mhl == 1}">checked="checked"</c:if>>MHL
					</td>
					<td colspan="2">${orderProduct.rz3Bz}</td>
				</tr>
				<tr>
					<td colspan="4"><b>老格式认证项：（新下PID不能勾选）</b>
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Ce == 1}">checked="checked"</c:if>>CE&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Ul == 1}">checked="checked"</c:if>>UL&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Pse == 1}">checked="checked"</c:if>>PSE&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz2Meps == 1}">checked="checked"</c:if>>MEPS&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz2Es == 1}">checked="checked"</c:if>>Energy Star&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz3Usb == 1}">checked="checked"</c:if>>USB&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Rf == 1}">checked="checked"</c:if>>RF&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Rte == 1}">checked="checked"</c:if>>RTE&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Cet == 1}">checked="checked"</c:if>>cETLus&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz1Nom == 1}">checked="checked"</c:if>>NOM&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz3Ddj == 1}">checked="checked"</c:if>>DD+&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz4Es7 == 1}">checked="checked"</c:if>>Energy star 7.0
					</td>
				</tr>
				<tr>
					<td colspan="4"><b>认证：其他</b>
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.rz5Qt == 1}">checked="checked"</c:if>>其他
					</td>
				</tr>
				<tr>
					<td><b>是否需要RoHS：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfRohs == 1}">checked="checked"</c:if>>需要
						<%-- <input type="radio" class="skyradio" <c:if test="${orderProduct.sfRohs == 0}">checked="checked"</c:if>>不需要 --%>
					</td>
					<td><b>是否需要REACH：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfReach == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfReach == 0}">checked="checked"</c:if>>不需要
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">电源信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>插头类型：</b>${orderProduct.ctlxmc}</td>
					<td style="width: 25%;"><b>插头类型备注：</b>${orderProduct.ctlxbz}</td>
					<td style="width: 50%;"><b>适配器：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfSpq == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfSpq == 0}">checked="checked"</c:if>>不需要
					</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">结构特性信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 50%;"><b>外壳颜色标准：</b>${orderProduct.wkysbz}</td>
					<td style="width: 50%;"><b>泡沫：</b>${orderProduct.paomomc}</td>
				</tr>
				<tr>
					<td><b>防火料：</b>
			    		<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fhlQk == 1}">checked="checked"</c:if>>前壳&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fhlHk == 1}">checked="checked"</c:if>>后壳&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fhlDzjlz == 1}">checked="checked"</c:if>>底座及立柱&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fhlAvzj == 1}">checked="checked"</c:if>>AV支架&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fhlQt == 1}">checked="checked"</c:if>>其他
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fhlBxy == 1}">checked="checked"</c:if>>不需要
						
					</td>
					<td><b>防火料备注：</b>${orderProduct.fhlBz}</td>
				</tr>
				<tr>
					<td><b>模组贴纸：</b>
			    		<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.mztzDsky == 1}">checked="checked"</c:if>>带SKYWORTH&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.mztzBdsky == 1}">checked="checked"</c:if>>不带SKYWORTH&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.mztzDmichina == 1}">checked="checked"</c:if>>带MADE IN CHINA&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.mztzBdmichina == 1}">checked="checked"</c:if>>不带MADE IN CHINA&nbsp;&nbsp;		
					</td>								
					<td><b>外包装箱贴纸：</b>
			    		<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.wbzxtzDsky == 1}">checked="checked"</c:if>>带SKYWORTH&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.wbzxtzBdsky == 1}">checked="checked"</c:if>>不带SKYWORTH&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.wbzxtzDmichina == 1}">checked="checked"</c:if>>带MADE IN CHINA&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.wbzxtzBdmichina == 1}">checked="checked"</c:if>>不带MADE IN CHINA&nbsp;&nbsp;		
					</td>
				</tr>
				<tr>
					<td><b>是否需要带卡板出货：</b>
			    		<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.kbchjdbyqP == 1}">checked="checked"</c:if>>屏&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.kbchjdbyqSj == 1}">checked="checked"</c:if>>散件&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.kbchjdbyqZj == 1}">checked="checked"</c:if>>整机&nbsp;&nbsp;
				      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.kbchjdbyqJzj == 1}">checked="checked"</c:if>>假整机&nbsp;&nbsp;		
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">附件信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>挂架：</b>${orderProduct.guajiamc}</td>
					<td style="width: 25%;"><b>挂架备注：</b>${orderProduct.guajiabz}</td>
					<td style="width: 25%;"><b>挂架包装：</b>${orderProduct.gjbzmc}</td>
					<td style="width: 25%;"><b>挂架包装备注：</b>${orderProduct.gjbzbz}</td>
				</tr>
				<tr>
					<td><b>电池：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfDc == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfDc == 0}">checked="checked"</c:if>>不需要
					</td>
					<%-- <td><b>3D眼睛：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sf3dyj == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sf3dyj == 0}">checked="checked"</c:if>>不需要
					</td> --%>
					<td><b>底座包装：</b>${orderProduct.dzbzmc}</td>
					<td><b>底座包装备注：</b>${orderProduct.dzbzbz}</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"><PRE class="pre"><b>其他附件备注：</b>${orderProduct.qtfjbz}</PRE></td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">SKD/CKD选项</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>有无屏：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfP == 1}">checked="checked"</c:if>>有
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfP == 0}">checked="checked"</c:if>>无
					</td>
					<td style="width: 25%;"><b>IC程序烧录：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfIc == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfIc == 0}">checked="checked"</c:if>>不需要
					</td>
					<td style="width: 50%;"><b>S/H/CKD辅料供应：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfShckdflgy == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfShckdflgy == 0}">checked="checked"</c:if>>不需要
					</td>
					<td style="width: 25%;">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="4"><PRE class="pre"><b>SKD前壳需加工配件：</b>${orderProduct.skdqkxjgpj}</PRE></td>
				</tr>
				<tr>
					<td colspan="2"><PRE class="pre"><b>S/H/CKD加工要求：</b>${orderProduct.shckdjgyq}</PRE></td>
					<%-- <td colspan="2"><b>S/H/CKD加工要求附件：</b>${orderProduct.shckdjgyqbz}</td> --%>
					<c:set var="shckdjgyqbz" value="${orderProduct.shckdjgyqbz}"/>
					<c:set var="shckdjgyqbzfjxx" value="${fn:replace(shckdjgyqbz,'icon-remove', 'fa fa-file')}"/>
					<td colspan="2"><b>S/H/CKD加工要求附件：</b>${fn:replace(shckdjgyqbzfjxx,'red', '')}</td>
				</tr>
				<tr>
					<td colspan="2"><b>S/H/CKD需成型物料明细：</b>${orderProduct.shckdxcxwlmx}</td>
					<%-- <td colspan="2"><b>S/H/CKD需成型物料明细附件：</b>${orderProduct.shckdxcxwlmxfj}</td> --%>
					<c:set var="shckdxcxwlmxfj" value="${orderProduct.shckdxcxwlmxfj}"/>
					<c:set var="shckdxcxwlmxfjxx" value="${fn:replace(shckdxcxwlmxfj,'icon-remove', 'fa fa-file')}"/>
					<td><b>S/H/CKD加工要求附件：</b>${fn:replace(shckdxcxwlmxfjxx,'red', '')}</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">产品其他备注信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><PRE class="pre"><b>产品其他要求备注：</b>${orderProduct.cpqtyqbz}</PRE></td>
				</tr>
				<tr>
					<%-- <td><b>产品其他要求附件：</b>${orderProduct.cpqtyqfj}</td> --%>
					<c:set var="cpqtyqfj" value="${orderProduct.cpqtyqfj}"/>
					<c:set var="cpqtyqfjxx" value="${fn:replace(cpqtyqfj,'icon-remove', 'fa fa-file')}"/>
					<td><b>产品其他要求附件：</b>${fn:replace(cpqtyqfjxx,'red', '')}</td>
				</tr>
			</table>
		</div>
		<!-- </div> -->
		<!-- 美工信息TAB -->
		<!-- <div class="tab-pane fade" id="mgxx-tab"> -->
		<h5 class="header blue" style="margin-top:4px;">美工信息</h5>
		<h5 class="header black" style="margin: 0; padding: 0;">客户Logo</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>面壳：</b>${orderProduct.mkmc}</td>
					<td style="width: 25%;"><b>面壳备注：</b>${orderProduct.mkbz}</td>
					<td style="width: 25%;"><b>装饰件：</b>${orderProduct.zsjmc}</td>
					<td style="width: 25%;"><b>装饰件备注：</b>${orderProduct.zsjbz}</td>
				</tr>
				<tr>
					<td style="width: 25%;"><b>Logo造型是否变更：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfLogozxbg == 1}">checked="checked"</c:if>>是
						<input type="radio" class="skyradio" <c:if test="${orderProduct.sfLogozxbg == 0}">checked="checked"</c:if>>否
					</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">遥控器</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>遥控器：</b>${orderProduct.ykqmc}</td>
					<td style="width: 25%;"><b>遥控器备注：</b>${orderProduct.ykqbz}</td>
					<td style="width: 25%;">&nbsp;</td>
					<td style="width: 25%;">&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">说明书</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>说明书：</b>${orderProduct.smsmc}</td>
					<td style="width: 25%;"><b>说明书备注：</b>${orderProduct.smsbz}</td>
					<td style="width: 25%;"><PRE class="pre"><b>说明书语种：</b>${orderProduct.smsyz}</PRE></td>
					<td style="width: 25%;"><b>语言排版顺序：</b>${orderProduct.yypbsx}</td>
				</tr>
				<tr>
					<td style="width: 25%;"><b>快速安装指南：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.ksazzn == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.ksazzn == 0}">checked="checked"</c:if>>不需要
					</td>
					<td style="width: 25%;">&nbsp;</td>
					<td style="width: 25%;">&nbsp;</td>
					<td style="width: 25%;">&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">纸箱</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>纸箱：</b>${orderProduct.zxmc}</td>
					<td style="width: 25%;"><b>纸箱备注：</b>${orderProduct.zxbz}</td>
					<td style="width: 25%;"><b>印刷资料：</b>${orderProduct.yszlmc}</td>
					<td style="width: 25%;">&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">贴纸</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>后盖贴纸：</b>${orderProduct.hgtzmc}</td>
					<td style="width: 25%;"><b>后盖贴纸备注：</b>${orderProduct.hgtzbz}</td>
					<td style="width: 25%;"><b>POP贴纸：</b>${orderProduct.poptzmc}</td>
					<td style="width: 25%;"><b>POP贴纸备注：</b>${orderProduct.poptzbz}</td>
				</tr>
				<tr>
					<td><b>能效贴纸：</b>${orderProduct.nxtzmc}</td>
					<td><b>能效贴纸备注：</b>${orderProduct.nxtzbz}</td>
					<td><b>适配器贴纸：</b>${orderProduct.spqtzmc}</td>
					<td><b>适配器贴纸备注：</b>${orderProduct.spqtzbz}</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">保证卡</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>保证卡：</b>${orderProduct.bzkmc}</td>
					<td style="width: 25%;"><b>保证卡备注：</b>${orderProduct.bzkbz}</td>
					<td style="width: 25%;">&nbsp;</td>
					<td style="width: 25%;">&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">底座安装说明</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>底座安装说明：</b>
						<input type="radio" class="skyradio" <c:if test="${orderProduct.dzazsm == 1}">checked="checked"</c:if>>需要
						<input type="radio" class="skyradio" <c:if test="${orderProduct.dzazsm == 0}">checked="checked"</c:if>>不需要
					</td>
					<td style="width: 25%;"><b>底座安装说明书语种：</b>${orderProduct.dzazsmsyz}</td>
					<td style="width: 25%;">&nbsp;</td>
					<td style="width: 25%;">&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">整机序号贴纸</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>序列号：</b>${orderProduct.xlhmc}</td>
					<td style="width: 25%;"><b>序列号备注：</b>${orderProduct.xlhbz}</td>
					<td style="width: 25%;"><b>用量：</b>${orderProduct.yl}</td>
					<td style="width: 25%;"><b>粘贴位置要求：</b>${orderProduct.ztwzyq}</td>
				</tr>
				<tr>
					<td style="width: 25%;"><b>尺寸要求：</b>${orderProduct.ccyqmc}</td>
					<td style="width: 25%;"></td>
					<td style="width: 25%;"></td>
					<td style="width: 25%;"></td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">小语种翻译方式</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 25%;"><b>小语种翻译方式：</b>${orderProduct.xyzfyfsmc}</td>
					<td style="width: 25%;">&nbsp;</td>
					<td style="width: 25%;">&nbsp;</td>
					<td style="width: 25%;">&nbsp;</td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">只提供美工资料不提供实物</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlMk == 1}">checked="checked"</c:if>>面壳&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlZsj == 1}">checked="checked"</c:if>>装饰件&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlYkq == 1}">checked="checked"</c:if>>遥控器&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlSms == 1}">checked="checked"</c:if>>说明书&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlZx == 1}">checked="checked"</c:if>>纸箱&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlHgtz == 1}">checked="checked"</c:if>>后盖贴纸&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlPoptz == 1}">checked="checked"</c:if>>POP贴纸&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlNxtz == 1}">checked="checked"</c:if>>能效贴纸&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlSpqtz == 1}">checked="checked"</c:if>>适配器贴纸&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlBzk == 1}">checked="checked"</c:if>>保证卡&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlDzazsm == 1}">checked="checked"</c:if>>底座安装说明&nbsp;&nbsp;
						<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.ztgmgzlZjxhtz == 1}">checked="checked"</c:if>>整机序号贴纸
				    </td>
				</tr>
			</table>
		</div>
		<h5 class="header black" style="margin: 0; padding: 0;">美工其他备注信息</h5>
		<div class="row" style="margin: 0px 8px;">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td><PRE class="pre"><b>美工其他要求备注：</b>${orderProduct.mgqtyqbz}</PRE></td>
					<%-- <td style="width: 50%;">${orderProduct.mgqtyqfj}</td> --%>
				</tr>
				<tr>
					<c:set var="mgqtyqfj" value="${orderProduct.mgqtyqfj}"/>
					<c:set var="mgqtyqfjxx" value="${fn:replace(mgqtyqfj,'icon-remove', 'fa fa-file')}"/>
					<td><b>美工其他要求附件：</b>${fn:replace(mgqtyqfjxx,'red', '')}</td>
				</tr>
				<tr>
					<c:set var="cbuwlfj" value="${orderProduct.cbuwlfj}"/>
					<c:set var="cbuwlfjxx" value="${fn:replace(cbuwlfj,'icon-remove', 'fa fa-file')}"/>
					<td><b>CBU物料明细：</b>${fn:replace(cbuwlfjxx,'red', '')}</td>
				</tr>
			</table>
		</div>
		<!-- </div> -->
		<!-- 备损物料信息TAB -->
		<!-- <div class="tab-pane fade" id="bswlxx-tab"> -->
		<h5 class="header blue" style="margin-top:4px;">备损物料信息</h5>
		<h5 class="header black" style="margin: 0; padding: 0;">备损信息</h5>
		<div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%;"><b>是否付费备损：</b>
							<input type="radio" class="skyradio" <c:if test="${orderProduct.sfFfbs == 1}">checked="checked"</c:if>>是
							<input type="radio" class="skyradio" <c:if test="${orderProduct.sfFfbs == 0}">checked="checked"</c:if>>否
						</td>
						<%-- <td style="width: 25%;"><b>付费备损清单：</b>${orderProduct.ffbsqdfj}</td> --%>
						<c:set var="ffbsqdfj" value="${orderProduct.ffbsqdfj}"/>
						<c:set var="ffbsqdxx" value="${fn:replace(ffbsqdfj,'icon-remove', 'fa fa-file')}"/>
						<td><b>付费备损清单：</b>${fn:replace(ffbsqdxx,'red', '')}</td>
						<td style="width: 25%;"><b>免费备损：</b>${orderProduct.mfbsmc}</td>
						<%-- <td style="width: 25%;"><b>免费备损清单：</b>${orderProduct.mfbsqdfj}</td> --%>
						<c:set var="mfbsqdfj" value="${orderProduct.mfbsqdfj}"/>
						<c:set var="mfbsqdxx" value="${fn:replace(mfbsqdfj,'icon-remove', 'fa fa-file')}"/>
						<td><b>免费备损清单：</b>${fn:replace(mfbsqdxx,'red', '')}</td>
					</tr>
					<tr>
						<td><b>免费备损比例：</b>${orderProduct.mfbsbl}</td>
						<td><b>备损包装：</b>${orderProduct.bsbzmc}</td>
						<td><b>备损包装备注：</b>${orderProduct.bsbzbz}</td>
						<td><b>跟单备损料走柜：</b>${orderProduct.gdbslzgmc}</td>
					</tr>
					<tr>
						<td colspan="4"><PRE class="pre"><b>备损备注：</b>${orderProduct.bsxxbz}</PRE></td>
					</tr>
				</table>
			</div>
			<h5 class="header black" style="margin: 0; padding: 0;">CKD物料清单</h5>
			<div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>操作类型</th>
						<th>物料编码</th>
						<th>描述</th>
						<th>单机用量</th>
					<!-- 	<th>上次结余数量</th>
						<th>大货数量</th> -->
						<th>免费备损数量</th>
						<th>付费备损数量</th>
						<th>MOQ数量</th>
						<!-- <th>下单数量</th> -->
						<th>SAP大货订单数量</th>
				<!-- 		<th>本单结余数量</th> -->
						<!-- <th>NE</th>
						<th>PO</th>
						<th>NCM CODE</th>
						<th>NCM</th>
						<th>单位</th>
						<th>净重</th>
						<th>毛重</th>
						<th>供应商编码</th>
						<th>供应商名称</th>
						<th>供应商地址</th>
						<th>原产地</th> -->
					</tr>
					<c:forEach items="${orderProduct.wycCkdList}" var="item">
						<tr>
							<td>
								<c:choose> 
								  <c:when test="${item.flag =='S'}">   
								       不变 
								  </c:when> 
								  <c:when test="${item.flag =='I'}">   
								       新增
								  </c:when> 
								  <c:when test="${item.flag =='D'}">   
								       删除 
								  </c:when> 
								  <c:when test="${item.flag =='U'}">   
								       修改 
								  </c:when> 
								</c:choose> 
						   </td>
							<td>${item.wlbm}</td>
							<td>${item.ms}</td>
							<td align="right"><fmt:formatNumber value="${item.djyl}" pattern="#,##0"/></td>
							<%-- <td align="right"><fmt:formatNumber value="${item.sdjysl}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.dhsl}" pattern="#,##0"/></td> --%>
							<td align="right"><fmt:formatNumber value="${item.mfbssl}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.ffbssl}" pattern="#,##0"/></td>
						    <td align="right"><fmt:formatNumber value="${item.moqsl}" pattern="#,##0"/></td>
						<%-- 	<td align="right"><fmt:formatNumber value="${item.xdsl}" pattern="#,##0"/></td> --%>
							 <td align="right"><fmt:formatNumber value="${item.sapdhddsl}" pattern="#,##0"/></td>
						<%-- 	<td align="right"><fmt:formatNumber value="${item.bdjysl}" pattern="#,##0"/></td>
							<td>${item["ne"]}</td>
							<td>${item.po}</td>
							<td>${item.ncmcode}</td>
							<td>${item.ncm}</td>
							<td>${item.dw}</td>
							<td align="right"><fmt:formatNumber value="${item.jz}" pattern="#,##0.00"/></td>
							<td align="right">${item.mz}</td>
							<td>${item.gysbm}</td>
							<td>${item.gysmc}</td>
							<td>${item.gysdz}</td>
							<td>${item.ycd}</td> --%>
						</tr>
					</c:forEach>
				</table>
			</div>
			<h5 class="header black" style="margin: 0; padding: 0;">已移除物料清单</h5>
			 <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>物料编码</th>
						<th>描述</th>
						<th>单机用量</th>
						<th>MOQ数量</th>
					</tr>
					<c:forEach items="${orderProduct.yycCkdList}" var="item">
						<tr>
							<td>${item.wlbm}</td>
							<td>${item.ms}</td>
							<td align="right"><fmt:formatNumber value="${item.djyl}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.moqsl}" pattern="#,##0"/></td>
						</tr>
					</c:forEach>
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
					<c:forEach items="${orderProduct.bgmxList}" var="item">
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
						<td colspan="4"><PRE class="pre"><b>变更信息备注：</b>${orderProduct.bgbz}</PRE></td>
					</tr>
					<tr>
						<td colspan="4"><PRE class="pre"><b>辅助变更备注：</b>${orderProduct.fzbgbz}</PRE></td>
					</tr>
				</table>
			</div>
			<div class="row">
				<div class="input-group">
					<input type="hidden" id="processId" name="processId" value="<%=request.getParameter("processId")%>" />
					<input type="hidden" id="taskId" name="taskId" value="<%=request.getParameter("taskId")%>" />
					<input type="hidden" name="token" value="${token}" />
					<input type="hidden" name="sfjp" value="1" >
					<label class="input-group-btn"><b>审核意见</b>&nbsp;&nbsp;</label>
					<textarea id="spyj" name="spyj" class="autosize-transition form-control" rows="5"></textarea>
				</div>
			</div>
			<!-- <h5 class="header blue" style="margin-top: 4px;">加批处理</h5>
			<div class="row" id="jpcl">
				<div class="col-xs-6 col-sm-3">
					<div class="input-group input-group-sm">
						<label class="input-group-addon">是否加批&nbsp;&nbsp;</label>
						<div class="form-control">
							<label class="radio-inline">
								<input type="radio" class="skyradio kczRadio" name="sfjp" value="1" checked="checked">是
							</label>
							<label class="radio-inline">
								<input type="radio" class="skyradio kczRadio" name="sfjp" value="0" >否
							</label>
						</div>
					</div>
				</div>
			</div> -->
			<div class="space-4"></div>
			<div class="row" align="center">
				<button id="btn-agree" type="button" class="btn btn-info btn-sm" onclick="javascript:approve(1);">
					<i class="icon-ok icon-on-right bigger-110"></i>
					通过
				</button>
				&nbsp;
				<shiro:hasPermission name="order:orderProduct:reject">
				    <%-- <c:if test="${isRestart != null}"> --%>
					<button id="btn-reject" type="button" class="btn btn-danger btn-sm" onclick="javascript:approve(2);">
						<i class="fa-times icon-on-right bigger-110"></i>
						驳回
					</button>
					&nbsp;
					<%-- </c:if> --%>
				</shiro:hasPermission>
				<button type="button" class="btn btn-sm" onclick="javascript:history.back(-1);">
					<i class="icon-undo icon-on-right bigger-110"></i>
					返回
				</button>
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
					<c:forEach items="${orderProduct.logList}" var="item">
						<tr>
							<td>${item.ddid}</td>
							<td>${item.bbh}</td>
							<td>${item.czlx}</td>
							<td>${item.czzw}</td>
							<td>${item.czr}</td>
							<td>${item.czrmc}</td>
							<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${item.nr}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	</form>
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	$(function($) {
		//$("#jpcl").find(".skyradio").removeProp("disabled").removeAttr("disabled");
		$(".skycheckbox").prop("disabled","disabled");
		$(".skyradio").prop("disabled","disabled");
		//打印
		$("#btn-print").click(function(){
			window.open("<c:url value='/order/orderProduct/printPage'/>?id=" + $("input[name='id']").val());
		})
		// 查看流程
		$("#btn-flow").click(function(){
			bootbox.dialog({
				title : "流程图",
				className : "dialog",
				message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
		
		$.bindAjax({
			url:"<c:url value='/payment/payValidate/search'/>",
			data:{id : "${orderProduct.id}" },
			action:"search"
		},function(response){
			if(response[0]){
				$("#fkbzrz").html(response[0].zy);
			}else{
				$("#fkbzrz").html('无');
			}
			//$(".kczRadio").removeProp("disabled").removeAttr("disabled");
		});
	});
	function approve(type){
		var param = $("#form-submit").getFormData();
		param.approveType = type;
		var sfZt = $('#form-submit [name=sfZt]').val();
		var url = "";
		if(sfZt != null && sfZt != ""){
			url = "<c:url value='/order/orderProduct/pauseApprove'/>";
		}else{
			url = "<c:url value='/order/orderProduct/approve'/>";
		}
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:url,
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
</script>
</html>