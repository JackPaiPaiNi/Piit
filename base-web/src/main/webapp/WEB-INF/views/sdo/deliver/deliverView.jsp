<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<style type="text/css">
table {
	width: 100%;
}
table {
	max-width: 200%;
}
table td {
	padding: 5px;
}
.pre{
	background-color:#ffffff;
	border:1px solid #ffffff;
	margin:-20px 0 0 70px;
	padding:0px;
}
.pre2{
	background-color:#ffffff;
	border:1px solid #ffffff;
	margin :0px 0 0 0px;
	padding:0px;
}
.dialog .modal-dialog{
	width:1100px;
}
</style>
</head>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<input type="hidden" name="id" value="${deliver.id}" />
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 75%">&nbsp;</td>
							<td style="width: 25%">
								<button id="btn-print" type="button" class="btn btn-light btn-sm">
									<i class="icon-print icon-on-right bigger-110"></i>打印
								</button>
								&nbsp;
								<button id="btn-print-bg" type="button" class="btn btn-light btn-sm">
									<i class="icon-print icon-on-right bigger-110"></i>报关打印
								</button>
								<!-- &nbsp;
								<button id="btn-print-gys" type="button" class="btn btn-light btn-sm">
									<i class="icon-print icon-on-right bigger-110"></i>打印（供应商）
								</button> -->
								&nbsp;
								<button id="btn-back" class="btn btn-sm" type="button">
									<i class="icon-undo icon-on-right bigger-110"></i> 返回
								</button>
							</td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">表头信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="4">
							<b>公司：
							</b>
							<c:choose>
								<c:when test="${deliver.scjd == '2110'}">深圳创维-RGB电子有限公司</c:when>
								<c:when test="${deliver.scjd == '2120'}">广州创维平面显示科技有限公司</c:when>
								<c:otherwise>${deliver.gsmc}</c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<td style="width: 25%"><b>出货单号：</b>${deliver.chdh}</td>
							<td style="width: 25%"><b>原出货单号：</b>${deliver.ychdh}</td>
							<td style="width: 25%"><b>客户：</b>
								<c:if test="${deliver.gsbm != 'RGB'}">
									<c:choose>
										<c:when test="${deliver.scjd == '2110'}">${deliver.gsmc}</c:when>
										<c:when test="${deliver.scjd == '2120'}">${deliver.gsmc}</c:when>
										<c:otherwise>${deliver.khmc}</c:otherwise>
									</c:choose>
								</c:if>
								<c:if test="${deliver.gsbm == 'RGB'}">${deliver.khmc}</c:if>
							</td>
							<td style="width: 25%"><b>收函人：</b>${deliver.shr}</td>
						</tr>
						<tr>
							<td><b>发函人：</b>${deliver.fhr}</td>
							<td><b>单据状态：</b>${deliver.ztmc}</td>
							<td><b>生产基地：</b>${deliver.scjdmc}</td>
							<td><b>发票号：</b>${deliver.fph}</td>
						</tr>
						<c:if test="${deliver.scjd == '2110'}">
							<td><b>发货人代码：</b>4403131697</td>
							<td><b>发货人电话：</b>0755-27357825</td>
							<td><b>发货人AEO企业编码：</b>AEOCN4403131697</td>
							<td></td>
						</c:if>
						<c:if test="${deliver.scjd == '2120'}">
							<td><b>发货人代码：</b>4401330026</td>
							<td><b>发货人电话：</b>0755-27357825</td>
							<td><b>发货人AEO企业编码：</b></td>
							<td></td>
						</c:if>
						<tr>
							<td colspan="4"><b>更改说明：</b>${deliver.ggsm}</td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">出货信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>终端客户编码：</b>${deliver.khbm}</td>
							<td style="width: 25%"><b>终端客户名称：</b>${deliver.khmc}</td>
							<td style="width: 25%"><b>销售员：</b>${deliver.xsymc}</td>
							<td style="width: 25%"><b>报关方式：</b>${deliver.bgfsmc}</td>
						</tr>
						<tr>
							<td colspan="4"><b>报关方式备注：</b>${deliver.bgfsbz}</td>
						</tr>
					</table>
				</div>
				<div class="row" style="margin: 0px 8px;">
					<table class="table table-bordered">
						<tr>
							<th>预走货单号</th>
							<th>订单号</th>
							<c:if test="${deliver.gsbm != 'SMO'}">
							<th>贸易条款</th>
							</c:if>
							<th>商品名称</th>
							<th>数量</th>
							<th>免费机数量</th>
							<th>件数</th>
							<th>我司型号</th>
							<th>客户型号</th>
							<th>品牌</th>
							<th>品牌类型</th>
							<th>出口享惠情况</th>
							<th>出货分类</th>
							<shiro:hasPermission name="deliver:deliver:price">
							<th>币种</th>
							<th>单价</th>
							<th>付费备损金额</th>
							<th>总价</th>
							</shiro:hasPermission>
							<th>GTIN码</th>
							<th>CAS码</th>
							<th>电视机类型</th>
							<th>备案料号</th>
							<th>备注</th>
						</tr>
						<c:forEach items="${deliver.deliverItemList}" var="item">
							<tr>
								<td>${item.yzhdh}</td>
								<td>${item.ddid}</td>
								<c:if test="${deliver.gsbm != 'SMO'}">
								<td>${item.mytkmc}</td>
								</c:if>
								<td>${item.spmc}</td>
								<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
								<td align="right"><fmt:formatNumber value="${item.mfjsl}" pattern="#,##0"/></td>
								<td align="right"><fmt:formatNumber value="${item.js}" pattern="#,##0"/></td>
								<td>${item.jixing}</td>
								<td>${item.khxhms}</td>
								<td>${item.pp}</td>
								<td>${item.pplx}</td>
								<td>${item.ckxhqk}</td>
								<td>${item.chflmc}</td>
								<shiro:hasPermission name="deliver:deliver:price">
								<td>${item.bz}</td>
								<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
								<td align="right"><fmt:formatNumber value="${item.ffbsje}" pattern="#,##0.000000"/></td>
								<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
								</shiro:hasPermission>
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
								<c:if test="${deliver.gsbm != 'SMO'}">
								<td>&nbsp;</td>
								</c:if>
							    <td>&nbsp;</td>
							    <td align="right"><fmt:formatNumber value="${deliver.zsl}" pattern="#,##0"/></td>
								<td>&nbsp;</td>
							    <td>&nbsp;</td>
								<td>&nbsp;</td>
							    <td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<shiro:hasPermission name="deliver:deliver:price">
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							    <td>&nbsp;</td>
								<td align="right"><fmt:formatNumber value="${deliver.zje}" pattern="#,##0.000000"/></td>
								</shiro:hasPermission>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
					
					</table>
				</div>
					<c:if test="${fn:length(deliver.deliverCostList)>0}">
					<h5 class="header blue" style="margin-top: 4px;">费用明细</h5>
					<div class="row" style="margin: 0px 8px;">
					<table class="table table-bordered">
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
				</div>
				</c:if>
				
				<h5 class="header blue" style="margin-top: 4px;">装柜信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td><b>跟单备损：</b><PRE class="pre"> ${deliver.bcGdbs}</PRE></td>
						</tr>
						<tr>
							<td><b>SPO备损：</b><PRE class="pre">${deliver.bcSpobs}</PRE></td>
						</tr>
						<tr>
							<td><b>文件要求：</b><PRE class="pre">${deliver.bcWjyq}</PRE></td>
						</tr>
						<tr>
							<td><b>装柜要求：</b><PRE class="pre">${deliver.bcZgyq}</PRE></td>
						</tr>
						<tr>
							<td><b>其他：</b><PRE class="pre">${deliver.bcQt}</PRE></td>
						</tr>
						<tr>
							<td><b>屏信息：</b><PRE class="pre">${deliver.pxx}</PRE></td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">船务信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>出运类型：</b>${deliver.cylxmc}</td>
							<td style="width: 25%"><b>船名：</b>${deliver.cm}</td>
							<td style="width: 25%"><b>航次：</b>${deliver.hc}</td>
							<td style="width: 25%"><b>航班号：</b>${deliver.hbh}</td>
						</tr>
						<tr>
							<td><b>订舱号：</b>${deliver.dch}</td>
							<td><b>目的国家：</b>${deliver.xwgjmc}</td>
							<td><b>起运港：</b>${deliver.qygmc}</td>
							<td><b>起运港备注：</b>${deliver.qygbz}</td>
						</tr>
						<tr>
							<td><b>目的港：</b>${deliver.mdg}</td>
							<td><b>装柜时间：</b><fmt:formatDate value="${deliver.zgrq}" pattern="yyyy-MM-dd HH:mm" /></td>
							<td><b>截放行条时间：</b><fmt:formatDate value="${deliver.jfxtsj}" pattern="yyyy-MM-dd HH:mm" /></td>
							<td><b>截重时间：</b><fmt:formatDate value="${deliver.jcsj}" pattern="yyyy-MM-dd HH:mm" /></td>
						</tr>
					</table>
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 15%"><b>总柜数：</b>${deliver.ygZgs}</td>
							<td style="width: 35%">
								<b>20'GP：</b>${deliver.yg20gp}&nbsp;&nbsp;
								<b>40'GP：</b>${deliver.yg40gp}&nbsp;&nbsp;
								<b>40'HQ：</b>${deliver.yg40hq}&nbsp;&nbsp;
							</td>
							<td style="width: 50%"><b>柜数备注：</b>${deliver.ygGsbz}</td>
						</tr>
						<tr>
							<td><b>总车数：</b>${deliver.dcZcs}</td>
							<td>
								<b>3吨：</b>${deliver.dc3d}&nbsp;&nbsp;
								<b>5吨：</b>${deliver.dc5d}&nbsp;&nbsp;
								<b>8吨：</b>${deliver.dc8d}&nbsp;&nbsp;
								<b>10吨：</b>${deliver.dc10d}&nbsp;&nbsp;
								<b>12吨：</b>${deliver.dc12d}&nbsp;&nbsp;
							</td>
							<td><b>吨车备注：</b>${deliver.dcDcbz}</td>
						</tr>
					</table>
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>开舱时间 ：</b><fmt:formatDate value="${deliver.kcsj}" pattern="yyyy-MM-dd HH:mm" /></td>
							<td style="width: 25%"><b>截补料/ENS/AMS时间：</b>
								<fmt:formatDate value="${deliver.jblsj}" pattern="yyyy-MM-dd HH:mm" /></td>
							<td style="width: 25%"><b>截VGM ：</b><fmt:formatDate value="${deliver.jgq}" pattern="yyyy-MM-dd HH:mm" /></td>
							<td style="width: 25%"><b>预计开船期（ETD）：</b>
								<fmt:formatDate value="${deliver.yjkcq}" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<td><b>预计到港期（ETA）：</b><fmt:formatDate value="${deliver.yjdgq}" pattern="yyyy-MM-dd" /></td>
							<td><b>快递信息：</b>${deliver.kdxx}</td>
							<td><b>船代公司：</b>${deliver.cdgsmc}</td>
							<td><b>船代公司联系人：</b>${deliver.cdgslxr}</td>
						</tr>
						<tr>
							<td><b>船代公司电话：</b>${deliver.cdgsdh}</td>
							<td><b>船代公司传真：</b>${deliver.cdgscz}</td>
							<td><b>船代公司邮箱：</b>${deliver.cdgsyx}</td>
							<td><b>船代公司邮编：</b>${deliver.cdgsyb}</td>
						</tr>
						<tr>
							<td><b>拖车公司：</b>${deliver.tcgs}</td>
							<td colspan="3"><b>备注信息 ：</b>${deliver.bzxx}</td>
						</tr>
						<tr>
							<td colspan="4"><b>附件 ：</b>${deliver.fj}</td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">收货方信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>收货人代码：</b>${deliver.shfdm}</td>
							<td style="width: 25%"><b>收货人名称：</b>${deliver.shfmc}</td>
							<td style="width: 25%"><b>收货人电话：</b>${deliver.shrdh}</td>
							<td style="width: 25%"><b>收货人地址：</b>${deliver.shfdz}</td>
						</tr>
						<tr>
							<td><b>AEO企业编码：</b>${deliver.aeoqybm}</td>
							<td><b>具体联络人：</b>${deliver.shflxr}</td>
							<td><b>具体联络人电话：</b>${deliver.shfdh}</td>
							<td><b>传真：</b>${deliver.shfcz}</td>
						</tr>
						<tr>
							<td><b>邮编：</b>${deliver.shfyb}</td>
							<td><b>邮箱：</b>${deliver.shfyx}</td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">提单通知人信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table class="table table-bordered">
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
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function($) {
		$(".skyradio").prop("disabled","disabled");
		// 返回
		$('#btn-back').click(function() {
			window.history.back(-1);
		});
		// 打印
		$("#btn-print").click(function(){
			window.open("<c:url value='/deliver/deliver/printPage'/>?id=" + $("input[name='id']").val() + "&sfGys=0");
		});
		// 打印（供应商）
		$("#btn-print-gys").click(function(){
			window.open("<c:url value='/deliver/deliver/printPage'/>?id=" + $("input[name='id']").val() + "&sfGys=1");
		});
		
		//btn-print-bg
		$("#btn-print-bg").click(function(){
			window.open("<c:url value='/deliver/deliver/printBgPage'/>?id=" + $("input[name='id']").val());
		});
	});
</script>
</html>