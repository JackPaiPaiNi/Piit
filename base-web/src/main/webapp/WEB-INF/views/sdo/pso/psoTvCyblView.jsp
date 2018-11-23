<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<style type="text/css">
table {
	width: 100%;
}

table td {
	padding: 5px;
}
</style>
</head>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form id="form-submit">
					<input type="hidden" name="id" value="${PsoVo.id}" /> <input
						type="hidden" name="oper" value="${PsoVo.oper}" /> <input
						type="hidden" name="sjc" value="${PsoVo.sjc}" /> <%-- <input
						type="hidden" name="bbh" value="${PsoVo.bbh} }" /> --%>
					<div class="row" style="margin: 0px 8px;" align="right">
						<button id="btn-back" class="btn btn-sm" type="button">
							<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
					</div>
					<h5 class="header blue" style="margin-top: -30px;">用柜用车信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table>
							<tr>
								<td style="width: 25%"><b>总柜数：</b>${PsoVo.ygZgs}</td>
								<td style="width: 50%"><b>20'GP：</b>${PsoVo.yg20gp}&nbsp;&nbsp;
									<b>40'GP：</b>${PsoVo.yg40gp}&nbsp;&nbsp; <b>40'HQ：</b>${PsoVo.yg40hq}&nbsp;&nbsp;
								</td>
								<td style="width: 25%"><b>柜数备注：</b>${PsoVo.ygGsbz}</td>
							</tr>
							<tr>
								<td><b>总车数:</b>${PsoVo.dcZcs}</td>
								<td><b>3吨：</b>${PsoVo.dc3d}&nbsp;&nbsp; <b>5吨：</b>${PsoVo.dc5d}&nbsp;&nbsp;
									<b>8吨：</b>${PsoVo.dc8d}&nbsp;&nbsp; <b>10吨：</b>${PsoVo.dc10d}&nbsp;&nbsp;
									<b>12吨：</b>${PsoVo.dc12d}&nbsp;&nbsp;</td>
								<td><b>吨车备注：</b>${PsoVo.dcDcbz}</td>
							</tr>
						</table>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">表头信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td style="width: 25%"><b>预走货单号：</b>${PsoVo.yzhdh}</td>
								<td style="width: 25%"><b>参考预走货单号：</b>${PsoVo.ckyzhdh}</td>
								<td style="width: 25%"><b>主体预走货单号单号：</b>
								<%-- ${orderProduct.glddh} --%></td>
								<td style="width: 25%"><b>公司：</b>${PsoVo.gsbm}</td>
							</tr>
							<tr>
								<td><b>制单人：</b>${PsoVo.zdrmc}</td>
								<td><b>预走货类型：</b>${PsoVo.yzhlxmc}</td>
								<td><b>是否代收代付运费</b> <input type="radio" class="skyradio"
									<c:if test="${PsoVo.sfDsdfyf == 1}">checked="checked"</c:if>>是
									<input type="radio" class="skyradio"
									<c:if test="${PsoVo.sfDsdfyf == 0}">checked="checked"</c:if>>否
								</td>
								<td><b>客户名称：</b>${PsoVo.khmc}</td>
							</tr>
							<tr>
								<td><b>销售员：</b>${PsoVo.xsymc}</td>
								<td><b>业务组：</b>${PsoVo.ywzmc}</td>
								<td><b>销售组织：</b>${PsoVo.xszzmc}</td>
								<td><b>制单时间：</b>${PsoVo.zdsj}</td>
							</tr>
							<tr>
								<td style="width: 25%"><b>状态：</b>${PsoVo.ztmc}</td>
								<td><b>生产基地：</b>${PsoVo.scjdmc}</td>
								<td><b>版本号：</b>${PsoVo.bbh}</td>
								<td></td>
							</tr>
						</table>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">走货主信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td style="width: 25%"><b>付款条件：</b>${PsoVo.fktjmc}</td>
								<td style="width: 25%"><b>贸易条款：</b>${PsoVo.mytkmc}</td>
								<td style="width: 25%"><b>装柜时间：</b><fmt:formatDate value="${PsoVo.zgsj}"
										pattern="yyyy-MM-dd" /></td>
								<td style="width: 25%"><b>挂架：</b> <input type="radio"
									class="skyradio"
									<c:if test="${PsoVo.bzyqGj == 1}">checked="checked"</c:if>>箱内包装
									<input type="radio" class="skyradio"
									<c:if test="${PsoVo.bzyqGj == 0}">checked="checked"</c:if>>箱外独立包装
								</td>
							</tr>
							<tr>
								<td style="width: 25%"><b>底座：</b> <input type="radio"
									class="skyradio"
									<c:if test="${PsoVo.bzyqDz == 1}">checked="checked"</c:if>>箱内包装
									<input type="radio" class="skyradio"
									<c:if test="${PsoVo.bzyqDz == 0}">checked="checked"</c:if>>箱外独立包装
								</td>
								<td><b>木质卡板：</b> <input type="radio" class="skyradio"
									<c:if test="${PsoVo.bzyqBzkb == 1}">checked="checked"</c:if>>箱内包装
									<input type="radio" class="skyradio"
									<c:if test="${PsoVo.bzyqBzkb == 0}">checked="checked"</c:if>>箱外独立包装
								</td>
								<td><b>附件：</b>${PsoVo.fj}</td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">补充信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td><b>跟单备损:</b>${PsoVo.bcGdbs}</td>
							</tr>
							<tr>
								<td><b>SPO备损:</b>${PsoVo.bcSpobs}</td>
							</tr>
							<tr>
								<td><b>文件要求:</b>${PsoVo.bcWjyq}</td>
							</tr>
							<tr>
								<td><b>装柜要求:</b>${PsoVo.bcZgyq}</td>
							</tr>
							<tr>
								<td><b>其他备注:</b>${PsoVo.bcQt}</td>
							</tr>
						</table>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">船务信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td style="width: 25%"><b>出运类型:</b>${PsoVo.cylxmc}</td>
								<td style="width: 25%"><b>起运港:</b>${PsoVo.qygmc}</td>
								<td style="width: 25%"><b>起运港备注:</b>${PsoVo.qygbz}</td>
								<td style="width: 25%"><b>目的港:</b>${PsoVo.mdg}</td>
							</tr>
							<tr>
								<td><b>目的国家:</b>${PsoVo.xwgjmc}</td>
								<td><b>是否需要验货:</b> <input type="radio" class="skyradio"
									<c:if test="${PsoVo.sfXyyh == 1}">checked="checked"</c:if>>是
									<input type="radio" class="skyradio"
									<c:if test="${PsoVo.sfXyyh == 0}">checked="checked"</c:if>>否
								</td>
								<td colspan="2"><b>预计验货日期:</b><fmt:formatDate value="${PsoVo.yjyhrq}" pattern="yyyy-MM-dd" /></td>
							</tr>
						</table>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">船代公司信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td style="width: 25%"><b>船代公司编码:</b>${PsoVo.cdgsbm}</td>
								<td style="width: 25%"><b>船代公司联系人:</b>${PsoVo.cdgslxr}</td>
								<td style="width: 25%"><b>船代公司电话:</b>${PsoVo.cdgsdh}</td>
								<td style="width: 25%"><b>船代公司邮箱:</b>${PsoVo.cdgsyx}</td>
							</tr>
							<tr>
								<td><b>船代公司传真:</b>${PsoVo.cdgscz}</td>
								<td><b>船代公司邮编:</b>${PsoVo.cdgscz}</td>
								<td><b>船代公司名称:</b>${PsoVo.cdgsmc}</td>
								<td><b>船代公司联系人:</b>${PsoVo.cdgslxr}</td>
							</tr>
						</table>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">快递信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td style="width: 25%"><b>快递类型:</b>${PsoVo.kd}</td>
								<td style="width: 25%"><b>快递公司:</b>${PsoVo.kdmc}</td>
								<td style="width: 25%"><b>快递备注:</b>${PsoVo.kdbz}</td>
								<td style="width: 25%"><b>运费承担:</b> <input type="radio"
									class="skyradio"
									<c:if test="${PsoVo.yfcd == 1}">checked="checked"</c:if>>客户承担
									<input type="radio" class="skyradio"
									<c:if test="${PsoVo.yfcd == 0}">checked="checked"</c:if>>我司承担
								</td>
							</tr>
							<tr>
								<td><b>运费承担类型：</b>${PsoVo.yflxmc}</td>
								<td><b>到付账户：</b>${PsoVo.dfzh}</td>
								<td><b>本次预估费用：</b><fmt:formatNumber value="${PsoVo.ygyf}" pattern="#,##0.00"/></td>
								<td><b>运费币种：</b>${PsoVo.yfbz}</td>
							</tr>
							<tr>
								<td><b>运费特批报告附件：</b>${PsoVo.yffj}</td>
							</tr>
						</table>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">走货明细信息</h5>
					<div class="row" style="margin: 0px 8px;">
						<table class="table table-bordered">
							<tr>
								<th>订单号</th>
								<th>我司型号</th>
								<th>客户型号</th>
								<th>机芯</th>
								<th>尺寸</th>
								<th>走货方式</th>
								<th>出货分类</th>
								<th>商品名称</th>
								<th>品牌</th>
								<th>品牌类型</th>
							    <th>出口享惠情况</th>
								<th>数量</th>
								<th>件数</th>
								<th>免费机数量</th>
								<shiro:hasPermission name="pso:tvPsoCybl:price">
			         	    	<th>单价</th>
			         	    	<th>金额</th>
			         	    	</shiro:hasPermission>
			         	    	<th>币种</th>
								<th>订单要求交货日期</th>
								<th>规格明细</th>
								<th>屏品牌</th>
								<th>屏型号</th>
								<th>屏编码</th>
								<th>GTIN码</th>
								<th>CAS码</th>
								<th>电视机类型</th>
								<th>备注信息</th>
								<th>是否计算相符</th>
							</tr>
							<c:forEach items="${PsoVo.psoItemList}" var="item">
								<tr>
									<td>${item.ddid}</td>
									<td>${item.jixing}</td>
									<td>${item.khxhms}</td>
									<td>${item.jixin}</td>
									<td>${item.cc}</td>
									<td>${item.zhfsmc}</td>
									<td>${item.chflmc}</td>
									<td>${item.spmc}</td>
									<td>${item.pp}</td>
									<td>${item.pplx}</td>
									<td>${item.ckxhqk}</td>
									<td align="right"><fmt:formatNumber value="${item.sl}"
											pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.js}"
											pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.mfjsl}"
											pattern="#,##0" /></td>
									<shiro:hasPermission name="pso:tvPsoCybl:price">
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.00"/></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.00"/></td>
									</shiro:hasPermission>
									<td>${item.bz}</td>
									<td>${item.ddyqjhrq}</td>
									<td>${item.ggmxmc}</td>
									<td>${item.ppp}</td>
									<td>${item.pxh}</td>
									<td>${item.pbh}</td>
									<td>${item.gtin}</td>
									<td>${item.cas}</td>
									<td>${item.dsjlxmc}</td>
									<td>${item.bzxx}</td>
									<td>${item.sfJsxf}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
		            <h5 class="header blue" style="margin-top: 4px;">收货方信息</h5>
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>收货人代码：</b>${PsoVo.shfdm}</td>
							<td style="width: 25%"><b>收货人名称：</b>${PsoVo.shfmc}</td>
							<td style="width: 25%"><b>收货人电话：</b>${PsoVo.shrdh}</td>
							<td style="width: 25%"><b>收货人地址：</b>${PsoVo.shfdz}</td>
						</tr>
						<tr>
							<td><b>AEO企业编码：</b>${PsoVo.aeoqybm}</td>
							<td><b>具体联络人：</b>${PsoVo.shflxr}</td>
							<td><b>具体联络人电话：</b>${PsoVo.shfdh}</td>
							<td><b>传真：</b>${PsoVo.shfcz}</td>
						</tr>
						<tr>
							<td><b>邮编：</b>${PsoVo.shfyb}</td>
							<td><b>邮箱：</b>${PsoVo.shfyx}</td>
							<td></td>
							<td></td>
						</tr>
					</table>
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
					</div>
					
					 <h5 class="header blue" style="margin-top: 4px;">审批日志</h5>
						<div class="row" style="margin: 0px 8px;">
							<table class="table table-bordered">
								<tr>
									<th>预走货单号</th>
									<th>版本号</th>
									<th>操作类型</th>
									<th>操作职位</th>
									<th>操作人账号</th>
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
										<td>${item.czr}</td>
										<td>${item.czrmc}</td>
										<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd"/></td>
										<td>${item.nr}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
				</form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function($) {
	$(".skyradio").prop("disabled","disabled");
	$('#btn-back').click(function(){
		window.history.back(-1);
	});
});
</script>
</html>

