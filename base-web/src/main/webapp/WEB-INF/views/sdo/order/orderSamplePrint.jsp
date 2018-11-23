<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
	<style type="text/css">
		.print_page{
			width: 756px;
			margin: 0 auto;
			font-family: Bookman Old Style;
			font-size: 11px;
		}
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
		.print_table tr:FIRST-CHILD td, .print_table tr:FIRST-CHILD th{
			border-top: 1px solid #000;
		}
		.print_table tr td:FIRST-CHILD, .print_table tr th:FIRST-CHILD{
			border-left: 1px solid #000;
		}
		.print_table td,.print_table th{
			border-bottom: 1px solid #000;
			border-right: 1px solid #000;
		}
		.pre{
			background-color:#ffffff;
			border:1px solid #ffffff;
			margin :0px 0 0 0px;
			padding:0px;
			white-space: pre-line!important;  
			white-space: -moz-pre-wrap; 
			white-space: -pre-wrap;     
			white-space: -o-pre-wrap;   
			word-wrap: break-word;
		}
	</style>
	
</head>
<body>
<div class="print_page">
	<div style="text-align: center;">
		<div>
			<c:if test="${orderSample.gsbm != 'MCO'}">
				<div style="float: left;">
					<img style="width:200px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_logo.jpg">
				</div>
				<div style="float: left;">
					<div style="font-size: x-large; margin-left: 0px;"><b>${orderSample.gsmc}</b></div>
					<%-- <div style="font-size: 13px;">RGB
						${orderSample.gsywmc}</div> --%>
				</div>
			</c:if>
			<c:if test="${orderSample.gsbm == 'MCO'}">
				<div style="float: center;">
					<div style="font-size: x-large; margin-left: 0px;"><b>${orderSample.gsmc}</b></div>
				</div>
			</c:if>
			<div style="clear: both;"></div>
		</div>
		<hr>
		<%-- <div style="margin-top: -5px;">SHENZHENSHIYANG${orderSample.gsywdz}</div> --%>
		<div style="font-size: large; font-weight: bold; text-decoration: underline; padding: 5px;">样机订单</div>
		<div style="text-align: right;"><b>订单号：</b>${orderSample.ddid}</div>
		<%--<div style="text-align: right;"><b>Date：</b><fmt:formatDate value="${orderSample.zdsj}" pattern="yyyy-MM-dd"/></div> --%>
	</div>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">表头信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>生产基地:</b></td>
			<td style="width: 23%;">${orderSample.scjdmc}</td>
			<td style="width: 10%;"><b>PI号:</b></td>
			<td style="width: 23%;"><%-- ${orderSample.piid} --%></td>
			<td style="width: 10%;"><b>公司编码:</b></td>
			<td style="width: 23%;">${orderSample.gsbm}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>公司名称:</b></td>
			<td style="width: 23%;">${orderSample.gsmc}</td>
			<td style="width: 10%;"><b>订单类型:</b></td>
			<td style="width: 23%;">${orderSample.ddlxmc}</td>
			<td style="width: 10%;"><b>制单人:</b></td>
			<td style="width: 23%;">${orderSample.zdrmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>制单日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderSample.zdsj}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>销售员:</b></td>
			<td style="width: 23%;">${orderSample.xsymc}</td>
			<td style="width: 10%;"><b>业务组:</b></td>
			<td style="width: 23%;">${orderSample.ywz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>销售组织:</b></td>
			<td style="width: 23%;">${orderSample.xszz}</td>
			<td style="width: 10%;"><b>订单状态:</b></td>
			<td style="width: 23%;">
				<c:choose>
				   <c:when test="${orderSample.zt == '1'}">草稿 
				   </c:when>
				   <c:when test="${orderSample.zt == '2'}">审批中 
				   </c:when>
				   <c:when test="${orderSample.zt == '3'}">驳回 
				   </c:when>
				   <c:when test="${orderSample.zt == '4'}">审批通过 
				   </c:when>
				   <c:when test="${orderSample.zt == '5'}">已生效 
				   </c:when>
				   <c:when test="${orderSample.zt == '6'}">取消 
				   </c:when>
				</c:choose>
			</td>
			<td style="width: 10%;"><b>业务类型:</b></td>
			<td style="width: 23%;">${orderSample.ywlxmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>版本号:</b></td>
			<td style="width: 23%;">${orderSample.bbh}</td>
			<td style="width: 10%;">&nbsp;</td>
			<td style="width: 23%;">&nbsp;</td>	
			<td style="width: 10%;">&nbsp;</td>
			<td style="width: 23%;">&nbsp;</td>	
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="10" style="font-size: 13px; text-align: left;">PI信息</th>
		</tr>
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
		    <%-- <shiro:hasPermission name="order:orderSample:price">
			<th>单价</th>
			</shiro:hasPermission> --%>
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
				<%-- <shiro:hasPermission name="order:orderSample:price">
				<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.00"/></td>
				</shiro:hasPermission> --%>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">基本信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>客户编码:</b></td>
			<td style="width: 23%;">${orderSample.khbm}</td>
			<td style="width: 10%;"><b>客户名称:</b></td>
			<td style="width: 23%;">${orderSample.khmc}</td>
			<td style="width: 10%;"><b>销往国家:</b></td>
			<td style="width: 23%;">${orderSample.xwgjmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>销售性质:</b></td>
			<td style="width: 23%;">${orderSample.xsxzmc}</td>
			<td style="width: 10%;"><b>样机类型:</b></td>
			<td style="width: 23%;">${orderSample.yjlxmc}</td>
			<td style="width: 10%;"><b>样机用途:</b></td>
			<td style="width: 23%;">${orderSample.yjytmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>工厂:</b></td>
			<td style="width: 23%;">${orderSample.gcmc}</td>
			<td style="width: 10%;"><b>是否返退:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfFt == 1}">checked="checked"</c:if>>是
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfFt == 0}">checked="checked"</c:if>>否
			</td>
			<td style="width: 10%;"><b>是否外协:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfWx == 1}">checked="checked"</c:if>>是
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfWx == 0}">checked="checked"</c:if>>否
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfWx == 2}">checked="checked"</c:if>>直接提取
			</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>是否免费:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfMf == 1}">checked="checked"</c:if>>是
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfMf == 0}">checked="checked"</c:if>>否
			</td>
			<td style="width: 10%;"><b>规格明细:</b></td>
			<td style="width: 23%;">${orderSample.ggmxmc}</td>
			<td style="width: 10%;"><b>规格明细备注:</b></td>
			<td style="width: 23%;">${orderSample.ggmxbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>付款条件:</b></td>
			<td style="width: 23%;">${orderSample.fktjmc}</td>
			<td style="width: 10%;"><b>交货日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderSample.jhrq}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>国际贸易条款:</b></td>
			<td style="width: 23%;">${orderSample.gjmytkmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>国际贸易条款备注:</b></td>
			<td style="width: 23%;">${orderSample.gjmytkbz}</td>
			<td style="width: 10%;"><b>渠道:</b></td>
			<td style="width: 23%;">${orderSample.qdmc}</td>
			<td style="width: 10%;">电视机类型</td>
			<td style="width: 23%;">${orderSample.dsjlxmc}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">产品概述</th>
		</tr>
		<%-- <tr>
			<td style="width: 10%;"><b>屏幕:</b></td>
			<td style="width: 23%;">${orderSample.pmmc}</td>
			<td style="width: 10%;"><b>注塑:</b></td>
			<td style="width: 23%;">${orderSample.zsmc}</td>
			<td style="width: 10%;"><b>五金:</b></td>
			<td style="width: 23%;">${orderSample.wjmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>主板:</b></td>
			<td style="width: 23%;">${orderSample.zbmc}</td>
			<td style="width: 10%;"><b>电源:</b></td>
			<td style="width: 23%;">${orderSample.dymc}</td>
			<td style="width: 10%;"><b>包材:</b></td>
			<td style="width: 23%;">${orderSample.bcmc}</td>
		</tr> --%>
		<tr>
			<td style="width: 10%;"><b>PID:</b></td>
			<td style="width: 23%;">${orderSample.pid}</td>
			<td style="width: 10%;"><b>型号:</b></td>
			<td style="width: 23%;">${orderSample.jixing}</td>
			<td style="width: 10%;"><b>主板型号:</b></td>
			<td style="width: 23%;">${orderSample.zbxh}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>主板方案:</b></td>
			<td style="width: 23%;">${orderSample.zbfamc}</td>
			<%-- <td style="width: 10%;"><b>品牌:</b></td>
			<td colspan ="3" style="width: 23%;">${orderSample.pp}</td> --%>
			<%-- <shiro:hasPermission name="order:orderSample:price">
			<td style="width: 10%;"><b>单价:</b></td>
			<td style="width: 23%;">${orderSample.dj}</td>
			</shiro:hasPermission> --%>
		<!-- </tr>
		<tr> -->
			<%-- <shiro:hasPermission name="order:orderSample:price">
			<td style="width: 10%;"><b>加工费:</b></td>
			<td style="width: 23%;">${orderSample.jgf}</td>
			<td style="width: 10%;"><b>运费:</b></td>
			<td style="width: 23%;">${orderSample.yf}</td>
			<td style="width: 10%;"><b>单台总价:</b></td>
			<td style="width: 23%;">${orderSample.dtzj}</td>
			</shiro:hasPermission> --%>
		<!-- </tr>
		<tr> -->
			<td style="width: 10%;"><b>数量:</b></td>
			<td style="width: 23%;">${orderSample.sl}</td>
			<td style="width: 10%;"><b>币种:</b></td>
			<td style="width: 23%;">${orderSample.bz}</td>
			<%-- <shiro:hasPermission name="order:orderSample:price">
			<td style="width: 10%;"><b>总金额:</b></td>
			<td style="width: 23%;">${orderSample.zje}</td>
			</shiro:hasPermission> --%>
		</tr>
		<tr>
			<td style="width: 10%;"><b>客户验货要求:</b></td>
			<td style="width: 89%;" colspan="5"><PRE class="pre">${orderSample.khyhyq}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>其他备注:</b></td>
			<td style="width: 89%;" colspan="5"><PRE class="pre">${orderSample.qtbz}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>变更信息备注:</b></td>
			<td style="width: 89%;" colspan="5"><PRE class="pre">${orderSample.bgbz}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>辅助变更备注:</b></td>
			<td style="width: 89%;" colspan="5"><PRE class="pre">${orderSample.fzbgbz}</PRE></td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">产品详细功能需求</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>电源插头:</b></td>
			<td style="width: 23%;">${orderSample.ctlxmc}</td>
			<td style="width: 33%;" colspan="4">${orderSample.ctlxbz}</td>
			<%-- <td style="width: 10%;"><b>是否需要电源开关:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfDykg == 1}">checked="checked"</c:if>>需要
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfDykg == 0}">checked="checked"</c:if>>不需要
			</td> --%>
		</tr>
		<tr>
			<td style="width: 10%;"><b>电压:</b></td>
			<td style="width: 23%;">${orderSample.dianyamc}</td>
			<td style="width: 33%;" colspan="2">${orderSample.dianyabz}</td>
			<td style="width: 10%;"><b>是否需要后壳RoHS:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfRohs == 1}">checked="checked"</c:if>>需要
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfRohs == 0}">checked="checked"</c:if>>不需要
			</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>是否需要REACH:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfReach == 1}">checked="checked"</c:if>>需要
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfReach == 0}">checked="checked"</c:if>>不需要
			</td>
			<td style="width: 10%;"><b>待机功率 :</b></td>
			<td style="width: 23%;">${orderSample.djglmc}</td>
			<td style="width: 33%;" colspan="2">${orderSample.djglbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>OSD语言 :</b></td>
			<td style="width: 23%;">${orderSample.osdyy}</td>
			<td><b>附加功能:</b></td>
			<td colspan="3">
				<%-- <input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fjgbPgs3d == 1}">checked="checked"</c:if>>偏光式3D&nbsp;&nbsp;
		      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fjgnKms3d == 1}">checked="checked"</c:if>>快门式3D&nbsp;&nbsp; --%>
		      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fjgnCij == 1}">checked="checked"</c:if>>CI+&nbsp;&nbsp;
		    	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fjgnCi == 1}">checked="checked"</c:if>>CI&nbsp;&nbsp;
		      	<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.fjgnScart == 1}">checked="checked"</c:if>>SCART
		      	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgnWifi == 1}">checked="checked"</c:if>>WIFI&nbsp;&nbsp;
				<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.fjgnWifidongle == 1}">checked="checked"</c:if>>WIFI Dongle&nbsp;&nbsp;
	      	</td>
		</tr>
		</tr>
			<td><b>能效等级 :</b></td>
			<td colspan="5">${orderSample.nxdj}</td>
			<%-- <td style="width: 10%;"><b>3D眼镜盒 :</b></td>
			<td style="width: 23%;">${orderSample.sl3dyjh}</td> --%>
		<tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">结构特性</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>外壳颜色标准化:</b></td>
			<td style="width: 56%;" colspan="3">${orderSample.wkysbz}</td>
			<td style="width: 10%;"><b>泡沫:</b></td>
			<td style="width: 23%;">${orderSample.paomomc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>前壳工艺:</b></td>
			<td style="width: 23%;">${orderSample.qkgymc}</td>
			<td colspan="4">
				<input type="checkbox" class="skycheckbox" <c:if test="${orderProduct.sfQkfhl == 1}">checked="checked"</c:if>>防火料&nbsp;&nbsp;
	      	</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>后壳工艺:</b></td>
			<td style="width: 23%;">${orderSample.hkgymc}</td>
			<td colspan="4">
				<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.sfQkfhl == 1}">checked="checked"</c:if>>防火料&nbsp;&nbsp;
				<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.sfHkxraytz == 1}">checked="checked"</c:if>>X-RAY贴纸&nbsp;&nbsp;
	      	</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>底座工艺:</b></td>
			<td style="width: 23%;">${orderSample.dzgymc}</td>
			<td style="width: 33%;" colspan="2">${orderSample.dzgybz}</td>
			<td colspan="2">
				<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.sfDzfhl == 1}">checked="checked"</c:if>>防火料&nbsp;&nbsp;
	      	</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>底座包装方式:</b></td>
			<td style="width: 23%;">${orderSample.dzbzmc}</td>
			<td colspan="4">${orderSample.dzbzbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>挂架:</b></td>
			<td style="width: 23%;">${orderSample.guajiamc}</td>
			<td style="width: 10%;"><b>挂架备注:</b></td>
			<td style="width: 23%;">${orderSample.guajiabz}</td>
			<td style="width: 10%;"><b>挂架包装方式:</b></td>
			<td style="width: 23%;">${orderSample.gjbzmc}</td>
		</tr>
		<tr>
			<%-- <td style="width: 10%;"><b>屏品牌:</b></td>
			<td style="width: 23%;">${orderSample.ppp}</td> --%>
			<td style="width: 10%;"><b>屏型号:</b></td>
			<td style="width: 23%;">${orderSample.pxh}</td>
			<td style="width: 10%;"><b>屏编号:</b></td>
			<td style="width: 23%;">${orderSample.pbh}</td>
			<td style="width: 10%;"><b>分辨率 :</b></td>
			<td style="width: 23%;">${orderSample.fblmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>2D/3D:</b></td>
			<td style="width: 23%;">${orderSample.sf3d}</td>
			<td style="width: 10%;"><b>电源类型:</b></td>
			<td style="width: 23%;">${orderSample.dylxmc}</td>
			<td colspan="2">${orderSample.dylxbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>遥控器:</b></td>
			<td style="width: 23%;">${orderSample.ykqmc}</td>
			<td colspan="2">${orderSample.ykqbz}</td>
			<td style="width: 10%;"><b>是否需要电池:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfDc == 1}">checked="checked"</c:if>>需要
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfDc == 0}">checked="checked"</c:if>>不需要
			</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>开机LOGO :</b></td>
			<td style="width: 23%;">${orderSample.kjlogo}</td>
			<td style="width: 10%;"><b>OSD出厂语言设置:</b></td>
			<td style="width: 56%;" colspan="3">${orderSample.osdccyysz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>模拟量标准:</b></td>
			<td style="width: 23%;">${orderSample.mnlbzmc}</td>
			<td colspan="4">${orderSample.mnlbzbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>质量标准:</b></td>
			<td style="width: 23%;">${orderSample.zlbzmc}</td>
			<td colspan="4">${orderSample.zlbzbz}</td>
		</tr>
		<tr>
			<td><b>检验要求:</b></td>
			<td colspan="3">
				<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqGzps == 1}">checked="checked"</c:if>>主观评审&nbsp;&nbsp;
		    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqJgaq == 1}">checked="checked"</c:if>>结构安全&nbsp;&nbsp;
		    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqDxn == 1}">checked="checked"</c:if>>电性能&nbsp;&nbsp;
		    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqAqgy == 1}">checked="checked"</c:if>>安全工艺&nbsp;&nbsp;
		    	<input type="checkbox" class="skycheckbox" <c:if test="${orderSample.jyyqRzcs == 1}">checked="checked"</c:if>>认证测试&nbsp;&nbsp;
	      	</td>
	      	<td style="width: 10%;"><b>是否需要木箱:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfMx == 1}">checked="checked"</c:if>>需要
				<input type="radio" class="skyradio" <c:if test="${orderSample.sfMx == 0}">checked="checked"</c:if>>不需要
			</td>
		</tr>
		<%-- <tr>
	      	<td style="width: 10%;"><b>产品经理:</b></td>
			<td colspan="5">${orderSample.cpjlmc}</td>
		</tr> --%>
		<tr>
		    <td style="width: 10%;"><b>付款保障 状态：</b></td>
			<td colspan="6">
			   <c:choose>
				   <c:when test="${orderSample.fkbzzt == '1'}">通过</c:when>
				   <c:when test="${orderSample.fkbzzt == '0'}">未通过</c:when>
		       </c:choose>
			</td>
		</tr>
	</table>
</div>
</body>
<script type="text/javascript">
	$(function($){
		$(".skycheckbox").prop("disabled","disabled");
		$(".skyradio").prop("disabled","disabled");
	});
</script>
</html>