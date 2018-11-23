<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		.print_page{
			width: 1056px;
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
			border:0px solid #ffffff;
			margin:-13px 0 0 70px;
			padding:0px;
		}
		.pre2{
			background-color:#ffffff;
			border:1px solid #ffffff;
			margin :0px 0 0 0px;
			padding:0px;
		}
		/* .print_table tr:LAST-CHILD td{
			border: none;
		} */
	</style>
</head>
<body>
<div class="print_page">
	<div style="text-align: center;">
		<div>
			<%-- <c:if test="${deliver.gsbm=='SOS' || deliver.gsbm=='MCO' || deliver.gsbm=='SMO' || deliver.gsbm=='SOD'}"> --%>
				<c:if test="${deliver.scjd=='2120'}">
					<!-- 广州基地 -->
					<div style="float: left; margin-left: 30px;">
						<img style="width:200px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_logo.jpg">
					</div>
					<div style="float: left; margin-left: 120px;">
						<div style="font-size: x-large;"><b>广州创维平面显示科技有限公司</b></div>
						<div style="font-size: 13px;">GUANGZHOU SKYWORTH FLAT DISPLAY TECHNOLOGY  CO. ,  LTD.</div>
					</div>
				</c:if>
				<c:if test="${deliver.scjd=='2110'}">
					<!-- 深圳基地 -->
					<div style="float: left; margin-left: 30px;">
						<img style="width:200px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_logo.jpg">
					</div>
					<div style="float: left; margin-left: 120px;">
						<div style="font-size: x-large;"><b>深圳创维-RGB电子有限公司</b></div>
						<div style="font-size: 13px;">SHENZHEN CHUANGWEI-RGB ELECTRONICS CO.,LTD</div>
					</div>
				</c:if>
			<%-- </c:if> --%>
			<div style="clear: both;"></div>
		</div>
		<hr>
		<div style="font-size: large; font-weight: bold; padding: 5px;">出货通知书</div>
	</div>
	<br>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 15%;"><b>出库通知书单号:</b></td>
			<td style="width: 55%;">${deliver.chdh}</td>
			<td style="width: 8%;"><b>日期:</b></td>
			<td style="width: 22%;"><fmt:formatDate value="${deliver.zdsj}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td><b>收函人:</b></td>
			<td colspan="3">${deliver.shr}</td>
		</tr>
		<tr>
			<td><b>发函人:</b></td>
			<td colspan="3">${deliver.fhr}</td>
		</tr>
	</table>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<c:if test="${deliver.scjd == '2110'}">
				<td style="width: 15%;"><b>发货人代码：</b></td>
				<td style="width: 15%">4403131697</td>
				<td><b>发货人电话：</b>0755-27357825</td>
				<td><b>发货人AEO企业编码：</b>AEOCN4403131697</td>
			</c:if>
			<c:if test="${deliver.scjd == '2120'}">
				<td style="width: 15%;"><b>发货人代码：</b></td>
				<td style="width: 15%">4401330026</td>
				<td><b>发货人电话：</b>0755-27357825</td>
				<td><b>发货人AEO企业编码：</b></td>
			</c:if>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th style="width: 80px;">预走货单号</th>
			<th style="width: 80px;">订单号</th>
			<c:if test="${deliver.gsbm == 'RGB'}">
			<th style="width: 80px;">贸易条款</th>
			</c:if>
			<th style="width: 120px;">商品名称</th>
			<th style="width: 60px;">数量</th>
			<th style="width: 60px;">免费机</th>
			<th style="width: 60px;">件数</th>
			<th style="width: 60px;">我司型号/物料编号</th>
			<th style="width: 60px;">客户型号/产品描述</th>
			<th style="width: 60px;">品牌</th>
			<th style="width: 60px;">品牌类型</th>
			<th style="width: 60px;">出口享惠情况</th>
			<c:if test="${sfGys != '1'}">
			<shiro:hasPermission name="deliver:deliver:price">
			<th style="width: 60px;">币种</th>
			<th style="width: 60px;">出口单价</th>
			<th style="width: 60px;">出口付费备损金额</th>
			<!-- <th style="width: 60px;">总价</th> -->
			<th style="width: 60px;">出口总价</th>
			</shiro:hasPermission>
			</c:if>
			<th style="width: 60px;">GTIN码</th>
			<th style="width: 60px;">CAS码</th>
			<th style="width: 100px;">电视机类型</th>
			<th style="width: 100px;">备案料号</th>
			<th style="width: 100px;">备注</th>
		</tr>
		<c:forEach items="${deliver.deliverItemList}" var="item">
			<tr>
				<td>${item.yzhdh}</td>
				<td>${item.ddid}</td>
				<c:if test="${deliver.gsbm == 'RGB'}">
				<td>${item.mytkmc}</td>
				</c:if>
				<td>${item.spmc}</td>
				<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0" /></td>
				<td align="right"><fmt:formatNumber value="${item.mfjsl}" pattern="#,##0" /></td>
				<td align="right"><fmt:formatNumber value="${item.js}" pattern="#,##0" /></td>
				<td>${item.jixing}</td>
				<td>${item.khxhms}</td>
				<td>${item.pp}</td>
				<td>${item.pplx}</td>
				<td>${item.ckxhqk}</td>
				<c:if test="${sfGys != '1'}">
				<shiro:hasPermission name="deliver:deliver:price">
				<td>${item.bz}</td>
				<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000"/></td>
				<td align="right"><fmt:formatNumber value="${item.ffbsje}" pattern="#,##0.000"/></td>
				<%-- <td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000"/></td> --%>
				<td align="right"><fmt:formatNumber value="${item.bgje}" pattern="#,##0.000"/></td>
				</shiro:hasPermission>
				</c:if>
				<td>${item.gtin}</td>
				<td>${item.cas}</td>
				<td>${item.dsjlxmc}</td>
				<td>${item.balh}</td>
				<td><pre class="pre2">${item.bzxx}</pre></td>
			</tr>
		</c:forEach>
		<tr>
			<td><b>合计</b></td>
				<td>&nbsp;</td>
				<c:if test="${deliver.gsbm == 'RGB'}">
				<td>&nbsp;</td>
				</c:if>
				<td>&nbsp;</td>
				<td align="right"><fmt:formatNumber value="${deliver.zsl}" pattern="#,##0" /></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<c:if test="${sfGys != '1'}">
				<shiro:hasPermission name="deliver:deliver:price">
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td align="right"><fmt:formatNumber value="${deliver.zje}" pattern="#,##0.00"/></td>
				</shiro:hasPermission>
				</c:if>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
		</tr>
	</table>
	<br>
	<c:if test="${fn:length(deliver.deliverExhibitionList)>0}">
		<table class="print_table" cellspacing="0" cellpadding="0">
			<tr>
				<th>样机预走货单号</th>
				<th>版本号</th>
				<th>商品名称</th>
				<th>样机来源</th>
			    <th>机型</th>
				<th>数量</th>
				<shiro:hasPermission name="deliver:deliver:price">
				<th>币种</th>
				<th>单价</th>
				<th>金额</th>
				</shiro:hasPermission>
				<th>备注信息</th>
			</tr>
			<c:forEach items="${deliver.deliverExhibitionList}" var="item">
				<tr>
					<td>${item.yzhdh}</td>
					<td>${item.bbh}</td>
					<td>${item.spmc}</td>
					<td>${item.yjly}</td>
					<td>${item.jixing}</td>
					<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
					<shiro:hasPermission name="deliver:deliver:price">
					<td>${item.bz}</td>
					<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.00"/></td>
					<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.00"/></td>
					</shiro:hasPermission>
					<td><pre class="pre2">${item.bzxx}</pre></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${fn:length(deliver.deliverCostList)>0}">
		<h5 class="header blue" style="margin-top: 4px;">费用明细</h5>
		<table class="print_table" cellspacing="0" cellpadding="0">
			<tr>
				<th>预走货单号</th>
				<th>版本号</th>
				<th>其他项目名称</th>
				<th>币种</th>
			    <th>用途描述</th>
				<th>金额</th>
				<th>收款单号</th>
			</tr>
			<c:forEach items="${deliver.deliverCostList}" var="item">
				<tr>
					<td>${item.yzhdh}</td>
					<td>${item.bbh}</td>
					<td>${item.qtxmmc}</td>
					<td>${item.bz}</td>
					<td>${item.yt}</td>
		        	<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.00"/></td>
					<td>${item.skdh}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 15%;"><b>收货人代码：</b></td>
			<td style="width: 15%;">${deliver.shfdm}</td>
			<td style="width: 15%;"><b>收货人名称：</b></td>
			<td style="width: 25%;">${deliver.shfmc}</td>
			<td style="width: 15%;"><b>收货人电话：</b></td>
			<td style="width: 15%;">${deliver.shrdh}</td>
		</tr>
		<tr>
			<td><b>收货人地址：</b></td>
			<td colspan="5">${deliver.shfdz}</td>
		</tr>
		<tr>
			<td><b>AEO企业编码：</b></td>
			<td>${deliver.aeoqybm}</td>
			<td><b>具体联络人：</b></td>
			<td>${deliver.shflxr}</td>
			<td><b>具体联络人电话：</b></td>
			<td>${deliver.shfdh}</td>
		</tr>
		<tr>
			<td><b>收货方传真：</b></td>
			<td>${deliver.shfcz}</td>
			<td><b>收货方邮编：</b></td>
			<td>${deliver.shfyb}</td>
			<td><b>收货方邮箱：</b></td>
			<td>${deliver.shfyx}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th>通知方代码</th>
			<th>通知方电话</th>
			<th>通知人名称</th>
			<th>通知人地址</th>
			<th>通知人联系人</th>
			<th>通知人电话</th>
			<th>通知人传真</th>
			<th>通知人邮编</th>
			<th>通知人邮箱</th>
		</tr>
		<c:forEach items="${deliver.notifyList}" var="item">
			<tr>
				<td>${item.tzfdm}</td>
				<td>${item.tzfdh}</td>
				<td>${item.tzrmc}</td>
				<td>${item.tzrdz}</td>
				<td>${item.tzrlxr}</td>
				<td>${item.tzrdh}</td>
				<td>${item.tzrcz}</td>
				<td>${item.tzryb}</td>
				<td>${item.tzryx}</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td><b>报关方式:</b></td>
			<td>${deliver.bgfsmc}</td>
			<td colspan="2"><b>报关方式备注:</b></td>
			<td colspan="6">${deliver.bgfsbz}</td>
		</tr>
		<tr>
			<td style="width: 8%;"><b>20'GP:</b></td>
			<td style="width: 14%;">${deliver.yg20gp}</td>
			<td style="width: 8%;"><b>40'GP:</b></td>
			<td style="width: 13%;">${deliver.yg40gp}</td>
			<td style="width: 8%;"><b>40'HQ:</b></td>
			<td style="width: 13%;">${deliver.yg40hq}</td>
			<td style="width: 8%;"><b>总柜数:</b></td>
			<td style="width: 6%;">${deliver.ygZgs}</td>
			<td style="width: 8%;"><b>柜数备注:</b></td>
			<td style="width: 14%;">${deliver.ygGsbz}</td>
		</tr>
	</table>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 6%;"><b>3吨车:</b></td>
			<td style="width: 6%;">${deliver.dc3d}</td>
			<td style="width: 6%;"><b>5吨车:</b></td>
			<td style="width: 6%;">${deliver.dc5d}</td>
			<td style="width: 6%;"><b>8吨车:</b></td>
			<td style="width: 6%;">${deliver.dc8d}</td>
			<td style="width: 8%;"><b>10吨车:</b></td>
			<td style="width: 6%;">${deliver.dc10d}</td>
			<td style="width: 8%;"><b>12吨车:</b></td>
			<td style="width: 6%;">${deliver.dc12d}</td>
			<td style="width: 8%;"><b>总车数:</b></td>
			<td style="width: 6%;">${deliver.dcZcs}</td>
			<td style="width: 8%;"><b>吨车备注:</b></td>
			<td style="width: 14%;">${deliver.dcDcbz}</td>
		</tr>
	</table>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 8%;"><b>跟单备损:</b><PRE class="pre">${deliver.bcGdbs}</PRE></td>
		</tr>
		<tr>
			<td><b>SPO备损:</b><PRE class="pre">${deliver.bcSpobs}</PRE></td>
		</tr>
		<tr>
			<td><b>文件要求:</b><PRE class="pre">${deliver.bcWjyq}</PRE></td>
		</tr>
		<tr>
			<td><b>装柜要求:</b><PRE class="pre">${deliver.bcZgyq}</PRE></td>
		</tr>
		<tr>
			<td><b>其他:</b><PRE class="pre">${deliver.bcQt}</PRE></td>
		</tr>
		<tr>
			<td><b>屏信息:</b><PRE class="pre">${deliver.pxx}</PRE></td>
		</tr>
	</table>
	<table cellspacing="0" cellpadding="0">
		<tr>
			<td style="width: 13%"><b>起运港:</b></td>
			<c:if test="${deliver.qyg == 4}">
				<td style="width: 17%">${deliver.qygbz}</td>
			</c:if>
			<c:if test="${deliver.qyg != 4}">
				<td style="width: 17%">${deliver.qygmc}</td>
			</c:if>
			<td style="width: 12%"><b>目的国家:</b></td>
			<td style="width: 22%">${deliver.xwgjmc}</td>
			<td align="right" style="width: 15%"><b>目的港口:&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
			<td style="width: 21%">${deliver.mdg}</td>
		</tr>
		<c:if test="${sfGys != '1'}">
		<tr>
			<td><b>客户名:</b></td>
			<td colspan="5">${deliver.khmc}</td>
		</tr>
		</c:if>
		<tr>
			<c:if test="${deliver.gsbm != 'MCO'}">
				<td><b>销售员:</b></td>
				<td>${deliver.xsymc}</td>
			</c:if>
			<c:if test="${deliver.gsbm == 'MCO'}">
				<td><b>销售员:</b></td>
				<td>陈子君</td>
			</c:if>
			<td><b>发票号:</b></td>
			<td colspan="3">${deliver.fph}</td>
		</tr>
		<tr>
			<td><b>订舱号:</b></td>
			<td>${deliver.dch}</td>
			<td><b>船名航次:</b></td>
			<td colspan="3">${deliver.cm}/${deliver.hc}</td>
		</tr>
		<tr>
			<td><b>船代公司：</b></td>
			<td>${deliver.cdgsmc}</td>
			<td colspan="4"><b>船代公司电话:</b>&nbsp;&nbsp;${deliver.cdgsdh}</td>
		</tr>
		<tr>
			<td><b>装柜时间:</b></td>
			<td><fmt:formatDate value="${deliver.zgrq}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td><b>截放行条时间:</b></td>
			<td><fmt:formatDate value="${deliver.jfxtsj}" pattern="yyyy-MM-dd HH:mm"/></td>
			<td align="right"><b>截重时间:</b>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><fmt:formatDate value="${deliver.jcsj}" pattern="yyyy-MM-dd HH:mm"/></td>
		</tr>
		<tr>
			<td><b>截VGM:</b></td>
			<td><fmt:formatDate value="${deliver.jgq}" pattern="yyyy-MM-dd HH:mm"/></td>
		    <td><b>快递信息:</b></td>
			<td>${deliver.kdxx}</td>
			<td align="right"><b>拖车公司:</b>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td>${deliver.tcgs}</td>
		</tr>
		<tr>
			<td><b>预计开船期（ETD）:</b></td>
			<td><fmt:formatDate value="${deliver.yjkcq}" pattern="yyyy-MM-dd" /></td>
		    <td><b>预计到港期（ETA）:</b></td>
			<td><fmt:formatDate value="${deliver.yjdgq}" pattern="yyyy-MM-dd" /></td>
			<c:if test="${deliver.gsbm == 'MCO'}">
				<td><b>核单人:</b></td>
				<td>${deliver.xsymc}</td>
			</c:if>
		</tr>
		<tr>
		    <td><b>备注信息:</b></td>
			<td colspan="5">${deliver.bzxx}</td>
		</tr>
		<tr>
			<c:set var="fj" value="${deliver.fj}"/>
			<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
			<td><b>附件：</b></td>
			<td>${fn:replace(fjxx,'red', '')}</td>
		</tr>
	</table>
</div>
</body>
</html>