<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<%
	String sfApprove = request.getParameter("sfApprove");
	String processInstanceId = request.getParameter("processId");
	pageContext.setAttribute("sfApprove", sfApprove);
	pageContext.setAttribute("processInstanceId", processInstanceId);
%>
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
.dialog .modal-dialog{
			width:1100px;
		}
.pre{
		background-color:#ffffff;
		border:0px solid #ffffff;
		padding :0px;
		font-size : 12px;
		font-family:"Open Sans","Helvetica Neue",Helvetica,Arial,sans-serif;
		/* float:left; */
	}
</style>
</head>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<input type="hidden" name="id" value="${PsoVo.id}" />
				<input type="hidden" name="sjc" value="${PsoVo.sjc}" />
				<%-- <input type="hidden" name="bbh" value="${PsoVo.bbh}" /> --%>
				<input type="hidden" name="yfcd" value="${PsoVo.yfcd}">
				<input type="hidden" name="yflx" value="${PsoVo.yflx}">
				<input type="hidden" name="yflx" value="${PsoVo.yzhlx}">
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>预走货单号：</b>${PsoVo.yzhdh}</td>
							<td style="width: 25%"><b>参考预走货单号：</b>${PsoVo.ckyzhdh}</td>
							<td style="width: 30%"><b>主体预走货单号：</b>${PsoVo.ztyzhdh}</td>
							<td style="width: 20%">
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
								<c:if test="${sfApprove != 1}">
									<button id="btn-back" class="btn btn-sm" type="button">
										<i class="icon-undo icon-on-right bigger-110"></i> 返回
									</button>
								</c:if>
								
							</td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">表头信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>公司：</b>${PsoVo.gsbm}</td>
							<td style="width: 25%"><b>预走货类型：</b>${PsoVo.yzhlxmc}</td>
							<td style="width: 25%"><b>是否代收代付运费</b>
								<input type="radio" class="skyradio" <c:if test="${PsoVo.sfDsdfyf == 1}">checked="checked"</c:if>>是
								<input type="radio" class="skyradio" <c:if test="${PsoVo.sfDsdfyf == 0}">checked="checked"</c:if>>否
							</td>
							<td style="width: 25%"><b>客户名称：</b>${PsoVo.khmc}</td>
						</tr>
						<tr>
							<td><b>销售员：</b>${PsoVo.xsymc}</td>
							<td><b>业务组：</b>${PsoVo.ywzmc}</td>
							<td><b>销售组织：</b>${PsoVo.xszzmc}</td>
							<td><b>制单人：</b>${PsoVo.zdrmc}</td>
						</tr>
						<tr>
							<td><b>制单时间：</b> <fmt:formatDate value="${PsoVo.zdsj}" pattern="yyyy-MM-dd" /></td>
							<td><b>状态：</b>${PsoVo.ztmc}</td>
							<td><b>生产基地：</b>${PsoVo.scjdmc}</td>
							<td><b>版本号：</b>${PsoVo.bbh}</td>
						</tr>
						<tr>
							<td><b>海外供应链：</b>${PsoVo.hwgylmc}</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">走货明细信息</h5>
				<div class="row" style="margin: 0px 8px; width: 100%; overflow: scroll;">
					<table class="table table-bordered" style="width: 1800px;">
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
							<th>币种</th>
							<shiro:hasPermission name="pso:tvPso:price">
							<th>单价</th>
							<th>付费备损金额</th>
							<th>总价</th>
							</shiro:hasPermission>
							<th>订单要求交货日期</th>
							<th>规格明细</th>
							<th>产品分类</th>
							<th>屏品牌</th>
							<th>屏型号</th>
							<th>屏编码</th>
							<shiro:hasPermission name="pso:tvPso:price">
							<th>屏单价</th>
							</shiro:hasPermission>
							<th>GTIN码</th>
							<th>CAS码</th>
							<th>电视机类型</th>
							<th>PID</th>
							<th>走货码</th>
							<th>版本号</th>
							<th>标识号</th>
							<th>是否计算相符</th>
							<th>备注信息</th>
						</tr>
						<c:forEach items="${PsoVo.psoItemList}" var="item">
							<tr>
								<td><a style="cursor: pointer;" onclick="javascript:showDdxx('${item.ddid}');">${item.ddid}</a></td>
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
								<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
								<td align="right"><fmt:formatNumber value="${item.js}" pattern="#,##0"/></td>
								<td align="right"><fmt:formatNumber value="${item.mfjsl}" pattern="#,##0"/></td>
								<td>${item.bz}</td>
								<shiro:hasPermission name="pso:tvPso:price">
								<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
								<td align="right"><fmt:formatNumber value="${item.ffbsje}" pattern="#,##0.000000"/></td>
								<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
								</shiro:hasPermission>
								<td><fmt:formatDate value="${item.ddyqjhrq}" pattern="yyyy-MM-dd" /></td>
								<td>${item.ggmxmc}</td>
								<td>${item.cpflmc}</td>
								<td>${item.ppp}</td>
								<td>${item.pxh}</td>
								<td>${item.pbh}</td>
								<shiro:hasPermission name="pso:tvPso:price">
								<td><fmt:formatNumber value="${item.pdj}" pattern="#,##0.0000"/></td>
								</shiro:hasPermission>
								<td>${item.gtin}</td>
								<td>${item.cas}</td>
								<td>${item.dsjlxmc}</td>
								<td>${item.pid}</td>
								<td>${item.zhmmc}</td>
								<td>${item.versionmc}</td>
								<td>${item.bsmc}</td>
								<td>${item.sfJsxf}</td>
								<td>${item.bzxx}</td>
							</tr>
						</c:forEach>
						<c:if test="${not empty PsoVo.mxzje}">
							<tr>
								<td><b>合计</b></td>
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
								<td align="right"><b><fmt:formatNumber value="${PsoVo.mxzsl}" pattern="#,##0"/></b></td>
								<td align="right"><b><fmt:formatNumber value="${PsoVo.mxzjs}" pattern="#,##0"/></b></td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<shiro:hasPermission name="pso:tvPso:price"> 
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
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</c:if>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">PI信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table class="table table-bordered" style="width: 60%;">
						<tr>
							<th>订单号</th>
							<th>订单类型</th>
							<th>PI号</th>
							<th>PI类型</th>
							<th>币种</th>
							<shiro:hasPermission name="pso:tvPso:price">
							<th>金额</th>
							</shiro:hasPermission>
							<th>PI付款保障绑定信息</th>
						</tr>
						<c:forEach items="${PsoVo.psoPiList}" var="item">
							<tr>
								<td>${item.ddid}</td>
								<td>${item.ddlxmc}</td>
								<td><a style="cursor: pointer;" onclick="javascript:showPixx('${item.piid}');">${item.piid}</a></td>
								<td>${item.pilxmc}</td>
								<td>${item.bz}</td>
								<shiro:hasPermission name="pso:tvPso:price">
								<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
								</shiro:hasPermission>
								<td><a style="cursor: pointer;" onclick="javascript:showPibd('${item.piid}');">${item.piid}</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">走货主信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>付款条件：</b>${PsoVo.fktjmc}</td>
							<td style="width: 25%"><b>贸易条款：</b>${PsoVo.mytkmc}</td>
							<td style="width: 25%"><b>装柜时间：</b> <fmt:formatDate value="${PsoVo.zgsj}" pattern="yyyy-MM-dd" /></td>
							<td style="width: 25%"><b>挂架：</b>
								<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqGj == 1}">checked="checked"</c:if>>箱内包装
								<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqGj == 0}">checked="checked"</c:if>>箱外独立包装
							</td>
						</tr>
						<tr>
							<td style="width: 25%"><b>底座：</b>
								<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqDz == 1}">checked="checked"</c:if>>箱内包装
								<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqDz == 0}">checked="checked"</c:if>>箱外独立包装
							</td>
							<td><b>卡板包装：</b>
								<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqBzkb == 1}">checked="checked"</c:if>>带
								<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqBzkb == 0}">checked="checked"</c:if>>不带
							</td>
							<td style="width: 25%"><b>卡板备注：</b>${PsoVo.kbbz}</td>
							<td><b>有无木质包装：</b>
								<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqMzbz == 1}">checked="checked"</c:if>>有
								<input type="radio" class="skyradio" <c:if test="${PsoVo.bzyqMzbz == 0}">checked="checked"</c:if>>没有
							</td>
						</tr>
						<tr>
							<td colspan="4"><b>备注信息：</b><PRE class="pre">${PsoVo.bzxx}</PRE></td>
						</tr>
						<tr>
							<td colspan="4"><b>变更信息备注：</b><PRE class="pre">${PsoVo.bgbz}</PRE></td>
						</tr>
						<tr>
							<c:set var="fj" value="${PsoVo.fj}"/>
							<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
							<td><b>附件：</b></td>
							<td>${fn:replace(fjxx,'red', '')}</td>
							<td></td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">用柜用车信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table>
						<tr>
							<td style="width: 15%"><b>总柜数：</b>${PsoVo.ygZgs}</td>
							<td style="width: 35%">
								<b>20'GP：</b>${PsoVo.yg20gp}&nbsp;&nbsp;
								<b>40'GP：</b>${PsoVo.yg40gp}&nbsp;&nbsp;
								<b>40'HQ：</b>${PsoVo.yg40hq}&nbsp;&nbsp;
							</td>
							<td style="width: 50%"><b>柜数备注：</b>${PsoVo.ygGsbz}</td>
						</tr>
						<tr>
							<td><b>总车数:</b>${PsoVo.dcZcs}</td>
							<td>
								<b>3吨：</b>${PsoVo.dc3d}&nbsp;&nbsp;
								<b>5吨：</b>${PsoVo.dc5d}&nbsp;&nbsp;
								<b>8吨：</b>${PsoVo.dc8d}&nbsp;&nbsp;
								<b>10吨：</b>${PsoVo.dc10d}&nbsp;&nbsp;
								<b>12吨：</b>${PsoVo.dc12d}&nbsp;&nbsp;
							</td>
							<td><b>吨车备注：</b>${PsoVo.dcDcbz}</td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">补充信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td><b>跟单备损:</b><PRE class="pre">${PsoVo.bcGdbs}</PRE></td>
						</tr>
						<tr>
							<td><b>SPO备损:</b><PRE class="pre">${PsoVo.bcSpobs}</PRE></td>
						</tr>
						<tr>
							<td><b>文件要求:</b><PRE class="pre">${PsoVo.bcWjyq}</PRE></td>
						</tr>
						<tr>
							<td><b>装柜要求:</b><PRE class="pre">${PsoVo.bcZgyq}</PRE></td>
						</tr>
						<tr>
							<td><b>其他备注:</b><PRE class="pre">${PsoVo.bcQt}</PRE></td>
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
							<td style="width: 25%"><b>中转港:</b>${PsoVo.zzg}</td>
						</tr>
						<tr>
						<td style="width: 25%"><b>目的港:</b>${PsoVo.mdg}</td>
							<td><b>目的国家:</b>${PsoVo.xwgjmc}</td>
							<td><b>是否需要验货:</b>
								<input type="radio" class="skyradio" <c:if test="${PsoVo.sfXyyh == 1}">checked="checked"</c:if>>是
								<input type="radio" class="skyradio" <c:if test="${PsoVo.sfXyyh == 0}">checked="checked"</c:if>>否
							</td>
							<td><b>预计验货日期:</b><fmt:formatDate value="${PsoVo.yjyhrq}" pattern="yyyy-MM-dd" /></td>
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
							<td style="width: 25%"><b>快递类型:</b>
								<c:choose>
									<c:when test="${PsoVo.kdlx == '1'}">国内速递 </c:when>
									<c:when test="${PsoVo.kdlx == '2'}">国际速递 </c:when>
									<c:when test="${PsoVo.kdlx == '3'}">其他 </c:when>
								</c:choose>
							</td>
							<td style="width: 25%"><b>快递公司:</b>${PsoVo.kdmc}</td>
							<td style="width: 25%"><b>快递备注:</b>${PsoVo.kdbz}</td>
							<td style="width: 25%"></td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">额外运费信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>运费承担:</b>
								<input type="radio" class="skyradio" <c:if test="${PsoVo.yfcd == 1}">checked="checked"</c:if>>客户承担
								<input type="radio" class="skyradio" <c:if test="${PsoVo.yfcd == 0}">checked="checked"</c:if>>我司承担
								<input type="radio" class="skyradio" <c:if test="${PsoVo.yfcd == 2}">checked="checked"</c:if>>无
							</td>
							<td style="width: 25%"><b>运费承担类型：</b>${PsoVo.yflxmc}</td>
							<td style="width: 25%"><b>到付账户：</b>${PsoVo.dfzh}</td>
							<td style="width: 25%"><b>本次预估费用：</b>${PsoVo.ygyf}</td>
						</tr>
						<tr>
							<td><b>运费币种：</b>${PsoVo.yfbz}</td>
							<td><b>运费特批报告附件：</b>${PsoVo.yffj}</td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">走货其他信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table class="table table-bordered">
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
				</div>
				<h5 class="header blue" style="margin-top: 4px;">收货方信息</h5>
				<div class="row" style="margin: 0px 8px;">
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
								<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
								<td>${item.nr}</td>
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
		$('#btn-back').click(function() {
			//location.href = "<c:url value='/pso/tvPso'/>";
			window.history.back(-1);
		});
		//打印
		$("#btn-print").click(function(){
			window.open("<c:url value='/pso/tvPso/printPage'/>?id=" + $("input[name='id']").val());
		})
	});
	//打开订单查看界面
	function showDdxx(ddid){
		var url = "" ;
    	//大货
		url = "<c:url value='/order/orderProduct/viewPageByDh'/>" + "?ddid=" + ddid;
		if(url.length >  0){
			 window.open(url); 
		} 
	}
	//打开PI查看界面
	function showPixx(piid){
		var url = "" ;
    	//大货
		url = "<c:url value='/pi/pi/viewPageByDh'/>" + "?piid=" + piid;
		if(url.length >  0){
			 window.open(url); 
		} 
	}
	
	//打开PI绑定查看界面
	function showPibd(piid){
		var url = "" ;
    	//大货
		url = "<c:url value='/payment/payPiBind/viewPage'/>" + "?piid=" + piid;
		if(url.length >  0){
			 window.open(url); 
		} 
	}
	
	// 查看流程
	$("#btn-flow").click(function(){
		bootbox.dialog({
			title : "流程图",
			className : "dialog",
			message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
		});
	});
</script>
</html>