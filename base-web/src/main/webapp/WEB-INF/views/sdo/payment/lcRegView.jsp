<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
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
	</style>
</head>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row" style="margin: 0px 8px;">
				<input type="hidden" name="id" id="id" value="${lcReg.id}"/>
				<input type="hidden" name="sjc" id="scj" value="${lcReg.sjc}"/>
				<input type="hidden" name="zt" id="zt" value="${lcReg.zt}"/>
				<table cellspacing="0" cellpadding="0">
					<tr>
					    <td style="width: 80%"></td>
						<td style="width: 20%">
						<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
							<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
								<i class="fa-file-image-o icon-on-right bigger-110"></i>
								流程图
							</button>
							&nbsp;
						</c:if>
						<button id="undo" class="btn btn-sm" type="button">
						<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
						</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">登记信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>登记人 ：</b>${lcReg.zdrmc}</td>
						<td style="width: 25%"><b>登记时间：</b><fmt:formatDate value="${lcReg.zdsj}" pattern="yyyy-MM-dd"/></td>
						<td style="width: 25%"><b>状态：</b>${lcReg.ztmc}</td>
						<td style="width: 25%"><b>版本号：</b>${lcReg.bbh}</td>
					</tr>	
				</table>
			</div>
			 <h5 class="header blue" style="margin-top: 4px;">操作历史</h5>
						<div class="row" style="margin: 0px 8px;">
							<table class="table table-bordered">
								<tr>
									<th>LC编号</th>
									<th>版本号</th>
									<th>制单人</th>
									<th>操作时间</th>
									<!-- <th>附件</th> -->
									<th>备注</th>
								</tr>
								<c:forEach items="${lcReg.htylist}" var="item">
									<tr>
										<td>${item.lcbh}</td>
										<td>${item.bbh}</td>
										<td>${item.zdrmc}</td>
										<td><fmt:formatDate value="${item.zdsj}" pattern="yyyy-MM-dd"/></td>
										<%-- <td>${item.fj}</td> --%>
										<td>${item.bzxx}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
			<h5 class="header blue" style="margin-top:4px;">L/C摘录基本信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>信用证号 ：</b><label id="lcbh">${lcReg.lcbh}</label></td>
						<td style="width: 25%"><b>获取信用证日期：</b><fmt:formatDate value="${lcReg.hqrq}" pattern="yyyy-MM-dd"/></td>
						<td style="width: 25%"><b>信用证正本存放处：</b>${lcReg.zbcfc}</td>
						<td style="width: 25%"><b>绑定PI号：</b>${lcReg.piid}</td>
					</tr>
					<tr>
						<td><b>申请人：</b>${lcReg.khbm}</td>
						<td><b>申请人名称：</b>${lcReg.khmc}</td>
						<td><b>开证日期：</b><fmt:formatDate value="${lcReg.kzrq}" pattern="yyyy-MM-dd"/></td>
						<td><b>受益人：</b>${lcReg.gsmc}</td>
					</tr>
					<tr>
						<td><b>有效期至：</b><fmt:formatDate value="${lcReg.yxq}" pattern="yyyy-MM-dd"/></td>
						<td><b>最晚装船期：</b><fmt:formatDate value="${lcReg.zwzcq}" pattern="yyyy-MM-dd"/></td>
						<td><b>议付交单期（天数）：</b>${lcReg.yfjdq}</td>
						<td><b>议付后付款期（天数）：</b>${lcReg.yfhcksj}</td>
					</tr>
					<tr>
						<td><b>信用证性质：</b>${lcReg.xyzxzmc} - ${lcReg.xyzxzts}</td>
						<td><b>是否循环L/C：</b>
							<input type="radio" class="skyradio" <c:if test="${lcReg.sfxhlc == 1}">checked="checked"</c:if>>是
							<input type="radio" class="skyradio" <c:if test="${lcReg.sfxhlc == 0}">checked="checked"</c:if>>否
						</td>
						<td><b>是否备用信用证：</b>
							<input type="radio" class="skyradio" <c:if test="${lcReg.sfbyxyz == 1}">checked="checked"</c:if>>是
							<input type="radio" class="skyradio" <c:if test="${lcReg.sfbyxyz == 0}">checked="checked"</c:if>>否
						</td>
						<c:set var="fj" value="${lcReg.fj}"/>
						<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
						<td><b>附件：</b></td>
						<td>${fn:replace(fjxx,'red', '')}</td>
					</tr>
					<tr>
						<td><b>形式发票号：</b>${lcReg.xsfph}</td>
						<td><b>修改版本号：</b>${lcReg.xgbbh}</td>
						<td><b>付款条件：</b>${lcReg.fktjmc}</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">贸易信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>交货条件：</b>${lcReg.mytkmc}</td>
						<td style="width: 25%"><b>始发港：</b>${lcReg.qyg}</td>
						<td style="width: 25%"><b>目的港：</b>${lcReg.mdg}</td>
						<td style="width: 25%"><b>装运条款-允许分运：</b>
							<input type="checkbox" class="skycheckbox" <c:if test="${lcReg.zytkYxfy == 1}">checked="checked"</c:if>>分运&nbsp;&nbsp;
							<input type="checkbox" class="skycheckbox" <c:if test="${lcReg.zytkYxzy == 1}">checked="checked"</c:if>>转运</td>
					</tr>
				</table>
			</div>
		    <h5 class="header blue" style="margin-top:4px;">银行信息</h5>
		    <div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>开证行 ：</b>${lcReg.kzh}</td>
						<td style="width: 25%"><b>开证行SwiftCode：</b>${lcReg.kzhdm}</td>
					    <td style="width: 25%"><b>是否有保兑行：</b>${lcReg.sfybdh}</td>
						<td style="width: 25%"><b>是否有偿付行：</b>${lcReg.sfycfh}</td>	
					</tr>
					<tr>
						<td><b>通知行：</b>${lcReg.tzh}</td>
						<td><b>指定议付行：</b>${lcReg.zdyfh}</td>
						<td><b>保兑行名称 ：</b>${lcReg.bdh}</td>
						<td><b>偿付行名称：</b>${lcReg.cfh}</td>
					</tr>
					<tr>
						<td><b>银行参考号：</b>${lcReg.yhckh}</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div> 
			<h5 class="header blue" style="margin-top:4px;">L/C金额信息</h5>
		 	<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>L/C金额 ：</b><fmt:formatNumber value="${lcReg.je}" pattern="#,##0.00"/></td>
						<td style="width: 25%"><b>已使用金额：</b><fmt:formatNumber value="${lcReg.ysyje}" pattern="#,##0.00"/></td>
					    <td style="width: 25%"><b>币种：</b>${lcReg.bz}</td>
						<td style="width: 25%"><b>循环L/C次数上限：</b>${lcReg.xhlccssx}</td>
					</tr>		
				</table>
			</div> 
			<h5 class="header blue" style="margin-top: 4px;">交单明细信息</h5>
			<div class="row" style="margin: 0px 8px; width: 100%; overflow: scroll;">
				<table class="table table-bordered" style="width: 1800px;">
		         	 <tr>
						<th>发票号</th>
						<th>发票金额</th>
						<th>发票日期</th>
						<th>发票币种</th>
						<th>出货单号</th>
						<th>预走货单号</th>
						<th>订单号</th>
						<th>区域</th>
						<th>销售员</th>
						<th>船务专员</th>
						<th>文件寄入银行日期</th>
						<th>通知行收到文件日期</th>
						<th>ETD开船日期</th>
						<th>通知行寄单日期</th>
						<th>跟踪号码</th>
						<th>L/C不符信息</th>
						<th>不符点费用</th>
						<th>附件</th>
						<th>不符点原因</th>
						<th>到期付款日</th>
						<th>是否已回款</th>
						<th>回款金额</th>
						<th>备注信息</th>
					</tr>
					<c:forEach items="${lcReg.itemVoList}" var="item">
						<tr>
							<td>${item.fph}</td>
							<td align="right"><fmt:formatNumber value="${item.fpje}" pattern="#,##0.0000"/></td>
							<td><fmt:formatDate value="${item.fprq}" pattern="yyyy-MM-dd" /></td>
							<td>${item.fpbz}</td>
							<td>${item.chdh}</td>
							<td>${item.yzhdh}</td>
							<td>${item.ddid}</td>
							<td>${item.qymc}</td>
							<td>${item.xsymc}</td>
							<td>${item.cwymc}</td>
							<td><fmt:formatDate value="${item.wjjryhrq}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.tzhsdwjrq}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.etdkcrq}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.tzhjdrq}" pattern="yyyy-MM-dd" /></td>
							<td>${item.gzhm}</td>
							<td>${item.lcbfxx}</td>
							<td align="right"><fmt:formatNumber value="${item.bfdfy}" pattern="#,##0.0000"/></td>
							<c:set var="fj" value="${item.fj}"/>
							<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
							<td>${fn:replace(fjxx,'red', '')}</td>
							<td>${item.bfdyy}</td>
							<td><fmt:formatDate value="${item.dqfkr}" pattern="yyyy-MM-dd" /></td>
							<td><c:if test="${item.sfyhk == 1}">是</c:if>
							    <c:if test="${item.sfyhk == 0}">否</c:if>
							</td>
							<td align="right"><fmt:formatNumber value="${item.hkje}" pattern="#,##0.0000"/></td>
							<td>${item.bzxx}</td>
						</tr>
					</c:forEach>
	         	</table>
			</div>
			 <h5 class="header blue" style="margin-top: 4px;">审批日志</h5>
						<div class="row" style="margin: 0px 8px;">
							<table class="table table-bordered" style="table-layout:fixed;">
								<tr>
									<th style="word-wrap:break-word;width: 10%">LC编号</th>
									<th style="word-wrap:break-word;width: 5%">版本号</th>
									<th style="word-wrap:break-word;width: 5%">操作类型</th>
									<th style="word-wrap:break-word;width: 10%">操作职位</th>
									<th style="word-wrap:break-word;width: 25%">操作人账号</th>
									<th style="word-wrap:break-word;width: 25%">操作人名称</th>
									<th style="word-wrap:break-word;width: 10%">操作时间</th>
									<th style="word-wrap:break-word;width: 10%">处理意见</th>
								</tr>
								<c:forEach items="${lcReg.logList}" var="item">
									<tr>
										<td style="word-wrap:break-word;width: 10%">${item.lcbh}</td>
										<td style="word-wrap:break-word;width: 5%">${item.bbh}</td>
										<td style="word-wrap:break-word;width: 5%">${item.czlx}</td>
										<td style="word-wrap:break-word;width: 10%">${item.czzw}</td>
										<td style="word-wrap:break-word;width: 25%">${item.czr}</td>
										<td style="word-wrap:break-word;width: 25%">${item.czrmc}</td>
										<td style="word-wrap:break-word;width: 10%"><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td style="word-wrap:break-word;width: 10%">${item.nr}</td>
									</tr>
								</c:forEach>
							</table>
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
	$(".skycheckbox").prop("disabled","disabled");
	$(".skyradio").prop("disabled","disabled");
	
	// 查看流程
	$("#btn-flow").click(function(){
		bootbox.dialog({
			title : "流程图",
			message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
		});
	});
	//返回
	$("#undo").click(function(){
		window.history.back(-1);
    });
</script>
</html>