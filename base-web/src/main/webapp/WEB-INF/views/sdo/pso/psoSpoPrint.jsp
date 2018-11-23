<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
	<style type="text/css">
		.print_page{
			width: 1080px;
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
		.print_lable{
			width: 100%;
			float: left;
			color: blue; 
			font-size: 15px; 
			font-weight: bold; 
			background-color: #AAAAAA;
		}
		.pre{
			background-color:#ffffff;
			border:1px solid #ffffff;
			margin :0px 0 0 0px;
			padding:0px;
		}
	</style>
</head>
<body>
	<div class="print_page">
		<div style="text-align: center;">
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 33%"><b>预走货单号：</b>${PsoVo.yzhdh}</td>
				<td style="width: 33%"><b>参考预走货单号：</b>${PsoVo.ckyzhdh}</td>
				<td style="width: 33%"><b>主体预走货单号：</b>${PsoVo.ztyzhdh}</td>
			</tr>
		</table>
		</div>
		<br>
		<table class="print_table" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="8" style="font-size: 13px; text-align: left;">表头信息</th>
			</tr>
			<tr>
				<td style="width: 10%;"><b>公司:</b></td>
				<c:if test="${PsoVo.gsbm != 'MCO'}">
					<td style="width: 15%;">${PsoVo.gsbm}</td>
				</c:if>
				<c:if test="${PsoVo.gsbm == 'MCO'}">
					<td style="width: 15%;">至诚</td>
				</c:if>
				<td style="width: 10%;"><b>预走货类型:</b></td>
				<td style="width: 15%;">${PsoVo.yzhlxmc}</td>
				<td style="width: 10%;"><b>是否代收代付运费:</b></td>
				<td style="width: 15%;">
				<input type="radio" class="skyradio" <c:if test="${PsoVo.sfDsdfyf == 1}">checked="checked"</c:if>>是
				<input type="radio" class="skyradio" <c:if test="${PsoVo.sfDsdfyf == 0}">checked="checked"</c:if>>否
				</td>
				<td style="width: 10%;"><b>客户名称:</b></td>
				<td style="width: 15%;">${PsoVo.khmc}</td>
			</tr>
			<tr>
				<td style="width: 10%;"><b>销售员:</b></td>
				<c:if test="${PsoVo.gsbm != 'MCO'}">
					<td style="width: 15%;">${PsoVo.xsymc}</td>
				</c:if>
				<c:if test="${PsoVo.gsbm == 'MCO'}">
					<td style="width: 15%;">陈子君</td>
				</c:if>
				<td style="width: 10%;"><b>业务组:</b></td>
				<td style="width: 15%;">${PsoVo.ywzmc}</td>
				<td style="width: 10%;"><b>销售组织:</b></td>
				<td style="width: 15%;">${PsoVo.xszzmc}</td>
				<td style="width: 10%;"><b>制单人:</b></td>
				<td style="width: 15%;">${PsoVo.zdrmc}</td>
			</tr>
			<tr>
				<td style="width: 10%;"><b>制单时间:</b></td>
				<td style="width: 15%;"><fmt:formatDate value="${PsoVo.zdsj}" pattern="yyyy-MM-dd" /></td>
				<td style="width: 10%;"><b>状态:</b></td>
				<td style="width: 15%;">${PsoVo.ztmc}</td>
				<c:if test="${PsoVo.gsbm != 'MCO'}">
					<td style="width: 10%;"><b>生产基地:</b></td>
					<td style="width: 15%;">${PsoVo.scjdmc}</td>
				</c:if>
				<c:if test="${PsoVo.gsbm == 'MCO'}">
					<td style="width: 10%;"><b>供应商:</b></td>
					<c:if test="${PsoVo.scjdmc == '深圳基地'}">
						<td style="width: 15%;">RGB</td>
					</c:if>
					<c:if test="${PsoVo.scjdmc == '广州基地'}">
						<td style="width: 15%;">广州平面</td>
					</c:if>
				</c:if>
				<td style="width: 10%;"><b>海外供应链:</b></td>
				<td style="width: 15%;">${PsoVo.hwgylmc}</td>
			</tr>
			<c:if test="${PsoVo.gsbm == 'MCO'}">
			<tr>
				<td style="width: 10%;"><b>核单人:</b></td>
				<td style="width: 15%;">${PsoVo.xsymc}</td>
				<td style="width: 10%;">&nbsp;</td>
				<td style="width: 15%;">&nbsp;</td>
				<td style="width: 10%;">&nbsp;</td>
				<td style="width: 15%;">&nbsp;</td>
				<td style="width: 10%;">&nbsp;</td>
				<td style="width: 15%;">&nbsp;</td>
			</tr>
			</c:if>
		</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="24" style="font-size: 13px; text-align: left;">走货明细信息</th>
		</tr>
		<tr>
			<th>订单号</th>
			<th>数量</th>
			<shiro:hasPermission name="pso:spoPso:price">
			<th>金额</th>
			</shiro:hasPermission>
			<th>出货分类</th>
			<th>商品名称</th>
			<th>币种</th>
			<th>订单要求交货日期</th>
			<th>GTIN码</th>
			<th>CAS码</th>
			<th>电视机类型</th>
			<th>品牌类型</th>
			<th>出口享惠情况</th>
			<th>备注信息</th>
		</tr>
		<c:forEach items="${PsoVo.psoItemList}" var="item">
		<tr>
			<td>${item.ddid}</td>
			<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
			<shiro:hasPermission name="pso:spoPso:price">
			<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
			</shiro:hasPermission>
			<td>${item.chflmc}</td>
			<td>${item.spmc}</td>
			<td>${item.bz}</td>
			<td><fmt:formatDate value="${item.ddyqjhrq}" pattern="yyyy-MM-dd" /></td>
			<td>${item.gtin}</td>
			<td>${item.cas}</td>
			<td>${item.dsjlxmc}</td>
			<td>${item.pplx}</td>
			<td>${item.ckxhqk}</td>
			<td>${item.bzxx}</td>
		</tr>
		</c:forEach>
		<c:if test="${not empty PsoVo.mxzje}">
			<tr>
				<td><b>合计</b></td>
				<td align="right"><b><fmt:formatNumber value="${PsoVo.mxzsl}" pattern="#,##0"/></b></td>
				<shiro:hasPermission name="pso:spoPso:price"> 
				<td align="right"><b><fmt:formatNumber value="${PsoVo.mxzje}" pattern="#,#00.0000"/></b></td>
				</shiro:hasPermission>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
		</c:if>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">PI信息</th>
		</tr>
		<tr>
			<th>订单号</th>
			<th>订单类型</th>
			<th>PI号</th>
			<th>币种</th>
			<shiro:hasPermission name="pso:spoPso:price">
			<th>金额</th>
			</shiro:hasPermission>
		</tr>
		<c:forEach items="${PsoVo.psoPiList}" var="item">
			<tr>
				<td>${item.ddid}</td>
				<td>${item.ddlxmc}</td>
				<td>${item.piid}</td>
				<td>${item.bz}</td>
				<shiro:hasPermission name="pso:spoPso:price">
				<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
				</shiro:hasPermission>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="8" style="font-size: 13px; text-align: left;">走货主信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>付款条件:</b></td>
			<td style="width: 15%;">${PsoVo.fktjmc}</td>
			<td style="width: 10%;"><b>贸易条款:</b></td>
			<td style="width: 15%;">${PsoVo.mytkmc}</td>
			<td style="width: 10%;"><b>装柜时间：</b></td>
			<td style="width: 40%;"><fmt:formatDate value="${PsoVo.zgsj}" pattern="yyyy-MM-dd" /></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>卡板包装：</b></td>
			<td style="width: 15%;">
				<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqBzkb == 1}">checked="checked"</c:if>>带
				<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqBzkb == 0}">checked="checked"</c:if>>不带			
			</td>
			<td style="width: 10%;"><b>卡板备注：</b></td>
			<td style="width: 15%;">${PsoVo.kbbz}</td>
			<td style="width: 10%;"><b>有无木质包装：</b></td>
			<td style="width: 15%;">
				<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqMzbz == 1}">checked="checked"</c:if>>有
				<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqMzbz == 0}">checked="checked"</c:if>>没有			
			</td>
		</tr>
		<tr>
			<c:set var="fj" value="${PsoVo.fj}"/>
			<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
			<td style="width: 10%;"><b>附件：</b></td>
			<td colspan="7" style="width: 40%;">${fn:replace(fjxx,'red', '')}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>备注信息:</b></td>
			<td colspan="7"><PRE class="pre">${PsoVo.bzxx}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>变更信息备注:</b></td>
			<td colspan="7"><PRE class="pre">${PsoVo.bgbz}</PRE></td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="14" style="font-size: 13px; text-align: left;">用柜用车信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>总柜数:</b></td>
			<td style="width: 15%;">${PsoVo.ygZgs}</td>
			<td style="width: 5%;"><b>20'GP：</b></td>
			<td style="width: 5%;">${PsoVo.yg20gp}</td>
			<td style="width: 5%;"><b>40'GP：</b></td>
			<td style="width: 5%;">${PsoVo.yg40gp}</td>
			<td style="width: 5%;"><b>40'HQ：</b></td>
			<td colspan=5 style="width: 5%;">${PsoVo.yg40hq}</td>
			<td style="width: 10%;"><b>柜数备注：</b></td>
			<td style="width: 15%;">${PsoVo.ygGsbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>总车数:</b></td>
			<td style="width: 15%;">${PsoVo.dcZcs}</td>
			<td style="width: 5%;"><b>3吨：</b></td>
			<td style="width: 5%;">${PsoVo.dc3d}</td>
			<td style="width: 5%;"><b>5吨：</b></td>
			<td style="width: 5%;">${PsoVo.dc5d}</td>
			<td style="width: 5%;"><b>8吨：</b></td>
			<td style="width: 5%;">${PsoVo.dc8d}</td>
			<td style="width: 5%;"><b>10吨：</b></td>
			<td style="width: 5%;">${PsoVo.dc10d}</td>
			<td style="width: 5%;"><b>12吨：</b></td>
			<td style="width: 5%;">${PsoVo.dc12d}</td>
			<td style="width: 10%;"><b>吨车备注：</b></td>
			<td style="width: 15%;">${PsoVo.dcDcbz}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="8" style="font-size: 13px; text-align: left;">船务信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>出运类型:</b></td>
			<td style="width: 15%;">${PsoVo.cylxmc}</td>
			<td style="width: 10%;"><b>起运港:</b></td>
			<td style="width: 15%;">${PsoVo.qygmc}</td>
			<td style="width: 10%;"><b>起运港备注:</b></td>
			<td style="width: 15%;">${PsoVo.qygbz}</td>
			<td style="width: 10%;"><b>中转港:</b></td>
			<td style="width: 15%;">${PsoVo.zzg}</td>
		</tr>
		<tr>
		<td style="width: 10%;"><b>目的港:</b></td>
			<td style="width: 15%;">${PsoVo.mdg}</td>
			<td style="width: 10%;"><b>目的国家:</b></td>
			<td style="width: 15%;">${PsoVo.xwgjmc}</td>
			<td style="width: 10%;"><b>是否需要验货:</b></td>
			<td style="width: 15%;">
				<input type="radio" class="skyradio" <c:if test="${PsoVo.sfXyyh == 1}">checked="checked"</c:if>>是
				<input type="radio" class="skyradio" <c:if test="${PsoVo.sfXyyh == 0}">checked="checked"</c:if>>否		
			</td>
			<td style="width: 10%;"><b>预计验货日期:</b></td>
			<td style="width: 15%;"><fmt:formatDate value="${PsoVo.yjyhrq}" pattern="yyyy-MM-dd" /></td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="8" style="font-size: 13px; text-align: left;">船代公司信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>船代公司编码:</b></td>
			<td style="width: 15%;">${PsoVo.cdgsbm}</td>
			<td style="width: 10%;"><b>船代公司联系人:</b></td>
			<td style="width: 15%;">${PsoVo.cdgslxr}</td>
			<td style="width: 10%;"><b>船代公司电话:</b></td>
			<td style="width: 15%;">${PsoVo.cdgsdh}</td>
			<td style="width: 10%;"><b>船代公司邮箱:</b></td>
			<td style="width: 15%;">${PsoVo.cdgsyx}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>船代公司传真:</b></td>
			<td style="width: 15%;">${PsoVo.cdgscz}</td>
			<td style="width: 10%;"><b>船代公司邮编:</b></td>
			<td style="width: 15%;">${PsoVo.cdgsyb}</td>
			<td style="width: 10%;"><b>船代公司名称:</b></td>
			<td style="width: 15%;">${PsoVo.cdgsmc}</td>
			<td style="width: 10%;"><b>船代公司联系人:</b></td>
			<td style="width: 15%;">${PsoVo.cdgslxr}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">快递信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>快递类型:</b></td>
			<td style="width: 15%;">
				<c:choose>
					<c:when test="${PsoVo.kdlx == '1'}">国内速递 </c:when>
					<c:when test="${PsoVo.kdlx == '2'}">国际速递 </c:when>
					<c:when test="${PsoVo.kdlx == '3'}">其他 </c:when>
				</c:choose>
			</td>
			<td style="width: 10%;"><b>快递公司:</b></td>
			<td style="width: 15%;">${PsoVo.kdmc}</td>
			<td style="width: 10%;"><b>快递备注:</b></td>
			<td style="width: 50%;">${PsoVo.kdbz}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="8" style="font-size: 13px; text-align: left;">额外运费信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>运费承担:</b></td>
			<td style="width: 15%;">
				<input type="radio" class="skyradio" <c:if test="${PsoVo.yfcd == 1}">checked="checked"</c:if>>客户承担
				<input type="radio" class="skyradio" <c:if test="${PsoVo.yfcd == 0}">checked="checked"</c:if>>我司承担
				<input type="radio" class="skyradio" <c:if test="${PsoVo.yfcd == 2}">checked="checked"</c:if>>无
			</td>
			<td style="width: 10%;"><b>运费承担类型：</b></td>
			<td style="width: 15%;">${PsoVo.yflxmc}</td>
			<td style="width: 10%;"><b>到付账户：</b></td>
			<td style="width: 15%;">${PsoVo.dfzh}</td>
			<td style="width: 10%;"><b>本次预估费用：</b></td>
			<td style="width: 15%;">${PsoVo.ygyf}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>运费币种：</b></td>
			<td style="width: 15%;">${PsoVo.yfbz}</td>
			<c:set var="yffj" value="${PsoVo.yffj}"/>
			<c:set var="yffjxx" value="${fn:replace(yffj,'icon-remove', 'fa fa-file')}"/>
			<td style="width: 10%;"><b>运费特批报告附件：</b></td>
			<td colspan=5 style="width: 15%;">${fn:replace(yffjxx,'red', '')}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">走货其他信息</th>
		</tr>
		<tr>
			<th>其他项目</th>
			<th>币种</th>
			<th>用途</th>
			<shiro:hasPermission name="pso:tvPso:price">
			<th>金额</th>
			</shiro:hasPermission>
			<th>收款单号</th>
		</tr>
		<c:forEach items="${PsoVo.psoOtherList}" var="item">
			<tr>
				<td>${item.qtxmmc}</td>
				<td>${item.bz}</td>
				<td>${item.yt}</td>
		        <shiro:hasPermission name="pso:tvPso:price">
		        <td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
		        </shiro:hasPermission>
				<td>${item.skdh}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="8" style="font-size: 13px; text-align: left;">收货方信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>收货人代码：</b></td>
			<td style="width: 15%;">${PsoVo.shfdm}</td>
			<td style="width: 10%;"><b>收货人名称：</b></td>
			<td style="width: 15%;">${PsoVo.shfmc}</td>
			<td style="width: 10%;"><b>收货人电话：</b></td>
			<td style="width: 15%;">${PsoVo.shrdh}</td>
			<td style="width: 10%;"><b>收货人地址：</b></td>
			<td style="width: 15%;">${PsoVo.shfdz}</td>
		</tr>
		<tr>
			<td><b>AEO企业编码：</b></td>
			<td>${PsoVo.aeoqybm}</td>
			<td><b>具体联络人：</b></td>
			<td>${PsoVo.shflxr}</td>
			<td><b>具体联络人电话：</b></td>
			<td>${PsoVo.shfdh}</td>
			<td><b>收货方传真：</b></td>
			<td>${PsoVo.shfcz}</td>
		</tr>
		<tr>
			<td><b>收货方邮编：</b></td>
			<td>${PsoVo.shfyb}</td>
			<td><b>收货方邮箱：</b></td>
			<td colspan="5">${PsoVo.shfyx}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="9" style="font-size: 13px; text-align: left;">提单通知人信息</th>
		</tr>
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
		<c:forEach items="${PsoVo.psoNotifyList}" var="item">
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
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="8" style="font-size: 13px; text-align: left;">审批日志</th>
		</tr>
			<tr>
				<th>预走货单号</th>
				<th>版本号</th>
				<th>操作类型</th>
				<th>操作职位</th>
				<c:if test="${PsoVo.gsbm != 'MCO'}">
				<th>操作人账号</th>
				</c:if>
				<th>操作人名称</th>
				<th>操作时间</th>
				<th>处理意见</th>
			</tr>
			<c:forEach items="${PsoVo.logList}" var="item">
				<tr>
					<td>${item.yzhdh}</td>
					<td>${item.bbh}</td>
					<td>${item.czlx}</td>
					<td>${item.czzw}</td>
					<c:if test="${PsoVo.gsbm != 'MCO'}">
					<td>${item.czr}</td>
					</c:if>
					<td>${item.czrmc}</td>
					<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${item.nr}</td>
				</tr>
			</c:forEach>
	</table>
	</div>
</body>
<script type="text/javascript">
	$(function($){
		$(".skyradio").prop("disabled","disabled");
	})
</script>
</html>