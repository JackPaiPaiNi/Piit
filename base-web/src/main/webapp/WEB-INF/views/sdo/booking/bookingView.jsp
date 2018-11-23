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
				<input type="hidden" name="id" value="${booking.id}" /> <input
					type="hidden" name="sjc" value="${booking.sjc}" />
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 80%"></td>
							<td style="width: 20%"><c:if
									test="${processInstanceId != 'null' && processInstanceId != ''}">
									<button id="btn-flow" type="button"
										class="btn btn-yellow btn-sm">
										<i class="fa-file-image-o icon-on-right bigger-110"></i> 流程图
									</button>
										&nbsp;
								</c:if> <c:if test="${sfApprove != 1}">
									<button id="btn-back" class="btn btn-sm" type="button">
										<i class="icon-undo icon-on-right bigger-110"></i> 返回
									</button>
								</c:if></td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">预走货信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table class="table table-bordered">
						<tr>
							<th>预走货类型</th>
							<th>预走货单号</th>
							<th>是否客体</th>
							<th>装柜日期</th>
							<th>柜数（40'HQ）</th>
							<th>柜数（40'GP）</th>
							<th>柜数（20'GP）</th>
							<th>柜数备注</th>
							<th>3吨车</th>
							<th>5吨车</th>
							<th>8吨车</th>
							<th>10吨车</th>
							<th>12吨车</th>
							<th>吨车备注</th>
						</tr>
						<c:forEach items="${booking.bookingItemList}" var="item">
							<tr>
								<td>${item.yzhlxmc}</td>
								<td>${item.yzhdh}</td>
								<td>${item.sfkt}</td>
								<td><fmt:formatDate value="${item.zgsj}"
										pattern="yyyy-MM-dd" /></td>
								<td align="right"><fmt:formatNumber value="${item.yg_40hq}"
										pattern="#,##0" /></td>
								<td align="right"><fmt:formatNumber value="${item.yg_40gp}"
										pattern="#,##0" /></td>
								<td align="right"><fmt:formatNumber value="${item.yg_20gp}"
										pattern="#,##0" /></td>
								<td>${item.yg_gsbz}</td>
								<td align="right"><fmt:formatNumber value="${item.dc_3d}"
										pattern="#,##0" /></td>
								<td align="right"><fmt:formatNumber value="${item.dc_5d}"
										pattern="#,##0" /></td>
								<td align="right"><fmt:formatNumber value="${item.dc_8d}"
										pattern="#,##0" /></td>
								<td align="right"><fmt:formatNumber value="${item.dc_10d}"
										pattern="#,##0" /></td>
								<td align="right"><fmt:formatNumber value="${item.dc_12d}"
										pattern="#,##0" /></td>
								<td>${item.dc_dcbz}</td>
							</tr>
						</c:forEach>
					</table>
				</div>

				<h5 class="header blue" style="margin-top: 4px;">订舱确认信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%">订舱流水号 ：${booking.dcdh}</td>
							<td style="width: 25%">制单人：${booking.zdrmc}</td>
							<td style="width: 25%">制单时间：<fmt:formatDate
									value="${booking.zdsj}" pattern="yyyy-MM-dd" /></td>
							<td>状态： <c:choose>
									<c:when test="${booking.zt == '1'}">草稿 
								   </c:when>
									<c:when test="${booking.zt == '2'}">审批中 
								   </c:when>
									<c:when test="${booking.zt == '3'}">驳回 
								   </c:when>
									<c:when test="${booking.zt == '4'}">审批通过 
								   </c:when>
									<c:when test="${booking.zt == '5'}">已生效 
								   </c:when>
									<c:when test="${booking.zt == '6'}">取消 
								   </c:when>
								</c:choose>
							</td>
						</tr>

						<tr>
							<td style="width: 25%">生产基地：${booking.scjd}</td>
							<td style="width: 25%">客户编码：${booking.khbm}</td>
							<td style="width: 25%">客户名称：${booking.khmc}</td>
							<td style="width: 25%">公司编码：${booking.gsbm}</td>
						</tr>
						<tr>
							<td style="width: 25%">公司名称：${booking.gsmc}</td>

							<td style="width: 25%">出运类型 ：${booking.cylxmc}</td>
							<td style="width: 25%">目的国家：${booking.xwgj}</td>
							<td style="width: 25%">起运港：${booking.qygmc}</td>
						</tr>
						<tr>
							<td style="width: 25%">目的港口：${booking.mdg}</td>

							<td>贸易条款：${booking.mytkmc}</td>
							<td>船代公司编码：${booking.cdgsbm}</td>
							<td>船代公司名称：${booking.cdgsmc}</td>
						</tr>
						<tr>
							<td>船代公司联系人：${booking.cdgslxr}</td>

							<td>船代公司电话：${booking.cdgsdh}</td>
							<td colspan="3">快递信息：${booking.kdlxmc}&nbsp;&nbsp;${booking.kdmc}&nbsp;&nbsp;${booking.kdbz}</td>
						</tr>
						<tr>
							<td>到付账户：${booking.dfzh}</td>
							<td>装柜日期：<fmt:formatDate value="${booking.zgrq}"
									pattern="yyyy-MM-dd" /></td>
							<td>预计开船期：<fmt:formatDate value="${booking.yjkcq}"
									pattern="yyyy-MM-dd" /></td>
							<td>预计到港期：<fmt:formatDate value="${booking.yjdgq}"
									pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<td>柜数(20'GP)：${booking.yg20gp}</td>
							<td>柜数(40'GP)：${booking.yg40gp}</td>
							<td>柜数(40'HQ)：${booking.yg40hq}</td>
							<td>总柜数 ：${booking.ygZgs}</td>
						</tr>
						<tr>
							<td>柜数备注：${booking.ygGsbz}</td>
							<td>3吨车 ：${booking.dc3d}</td>
							<td>5吨车 ：${booking.dc5d}</td>
							<td>8吨车 ：${booking.dc8d}</td>
						</tr>
						<tr>
							<td>10吨车 ：${booking.dc10d}</td>
							<td>12吨车 ：${booking.dc12d}</td>
							<td>总车数 ：${booking.dcZcs}</td>
							<td>吨车备注 ：${booking.dcDcbz}</td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">订舱信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td>订舱号：${booking.dch}</td>
							<td>船名：${booking.cm}</td>
							<td>航次：${booking.hc}</td>
							<td>航班号：${booking.hbh}</td>
						</tr>
						<tr>
							<td>截重时间：<fmt:formatDate value="${booking.jcsj}"
									pattern="yyyy-MM-dd HH:mm" /></td>
							<td>截放行条时间：<fmt:formatDate value="${booking.jfxtsj}"
									pattern="yyyy-MM-dd HH:mm" /></td>
							<td>截补料/ENS/AMS时间：<fmt:formatDate value="${booking.jblsj}"
									pattern="yyyy-MM-dd HH:mm" /></td>
							<td>开舱时间：<fmt:formatDate value="${booking.kcsj}"
									pattern="yyyy-MM-dd HH:mm" /></td>
						</tr>
						<tr>
							<td>截VGM：<fmt:formatDate value="${booking.jgq}"
									pattern="yyyy-MM-dd HH:mm" /></td>
							<td colspan="3">附件：${booking.fj}</td>
						</tr>
						<tr>
							<td colspan="4">备注 ：${booking.bzxx}</td>
						</tr>
					</table>
				</div>

				<h5 class="header blue" style="margin-top: 4px;">审批日志</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<table class="table table-bordered">
						<tr>
							<th>订舱单号</th>
							<th>操作类型</th>
							<th>操作职位</th>
							<th>操作人账号</th>
							<th>操作人名称</th>
							<th>操作时间</th>
							<th>处理意见</th>
						</tr>
						<c:forEach items="${booking.logList}" var="item">
							<tr>
								<td>${item.dcdh}</td>
								<td>${item.czlx}</td>
								<td>${item.czzw}</td>
								<td>${item.czr}</td>
								<td>${item.czrmc}</td>
								<td><fmt:formatDate value="${item.czrj}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td>${item.nr}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
	<span class="loading-indicator"> <label><i
			class="icon-spinner icon-spin icon-large"></i> 处理中... </label>
	</span>
</body>
<script type="text/javascript">
	$(function($) {
		$('#btn-back').click(function() {
			window.history.back(-1);
		});
	});
	
	// 查看流程
	$("#btn-flow").click(function(){
		bootbox.dialog({
			title : "流程图",
			message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
		});
	});
</script>
</html>