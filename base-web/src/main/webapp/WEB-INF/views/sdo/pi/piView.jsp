<%@page import="com.ey.piit.sdo.pi.vo.PiVo"%>
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
	String permission = "" ;
	PiVo pi = (PiVo)request.getAttribute("pi");
	System.out.println(pi.getPilx());
    if( "1".equals(pi.getPilx())){
    	 //大货
	     permission = "pi:pi:price" ;
    }else if("2".equals(pi.getPilx())){
    	//备损
    	  permission = "pi:piSPO:price" ;	
    }else if("3".equals(pi.getPilx())){
    	//样机
  	    permission = "pi:piSample:price" ;	
    }else if("4".equals(pi.getPilx())){
    	 //多元化
    	  permission = "pi:piDiversity:price" ;	
    }else if("5".equals(pi.getPilx())){
    	//多元化屏
   	      permission = "pi:piDiversity:price" ;	
    }else if("6".equals(pi.getPilx())){
    	//多元化屏
 	      permission = "pi:piDiversity:price" ;	
  	}else if("7".equals(pi.getPilx())||"8".equals(pi.getPilx())||"9".equals(pi.getPilx())||"10".equals(pi.getPilx())){
    	//副营业务
	      permission = "pi:piFy:price" ;	
	}
    request.setAttribute("permission", permission);
%>
<style type="text/css">
table {
	width: 100%;
}

table td {
	padding: 5px;
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
					<input type="hidden" name="id" value="${pi.id}" />
					<!-- piid -->
					<input type="hidden" name="sjc" value="${pi.sjc}" /> 
					<input type="hidden" name="bbh" value="${pi.bbh}" /> 
					<input type="hidden" name="zt" value="${pi.zt}" /> 
					<input type="hidden" id="pilx" name="pilx" value="${pi.pilx}" />
					<input type="hidden" name="khbm" value="${pi.khbm}" /> 
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>参考PI号：</b>${pi.ckpih}</td>
							<td style="width: 50%">&nbsp;<%-- <b>生产基地：</b>${pi.scjdmc} --%></td>
							<td style="width: 25%">
								<c:if test="${sfApprove != 1}">
							
										<button id="btn-print" type="button" class="btn btn-light btn-sm">
											<i class="icon-print icon-on-right bigger-110"></i>
											打印
										</button>
										&nbsp;
								
									<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
										<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
											<i class="fa-file-image-o icon-on-right bigger-110"></i>
											流程图
										</button>
										&nbsp;
									</c:if>
									<button id="btn-back" onclick="javascript:history.back(-1);" class="btn btn-sm" type="button">
									<i class="icon-undo icon-on-right bigger-110"></i>
										返回
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
							<td style="width: 25%"><b>PI号 ：</b>${pi.piid}</td>
							<td style="width: 25%"><b>公司 ：</b>${pi.gsbm}</td>
							<td style="width: 25%"><b>PI类型：</b>${pi.pilxmc}</td>
							<td style="width: 25%"><b>销售员：</b>${pi.xsymc}</td>
						</tr>
						<tr>
							<td><b>制单日期：</b>
							<fmt:formatDate value="${pi.zdsj}" pattern="yyyy-MM-dd" /></td>
							<td><b>制单人：</b>${pi.zdrmc}</td>
							<td><b>状态：</b>${pi.ztmc}</td>
							<td><b>PI有效至：</b> 
							 <fmt:formatDate value="${pi.piyxq}" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<c:if test="${pi.pilx == '2'}">
								<td><b>PI类别：</b>${pi.pilbmc}</td>
							</c:if>
							<c:if test="${pi.pilx == '4'}">
								<td><b>是否白电：</b>
									<input type="radio" class="skyreadonly" <c:if test="${pi.sfBd == 1}">checked="checked"</c:if>>是
									<input type="radio" class="skyreadonly" <c:if test="${pi.sfBd == 0}">checked="checked"</c:if>>否
								</td>
							</c:if>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">客户信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>To ：</b>${pi.khmc}</td>
							<td style="width: 25%"><b>Customer Code：</b>${pi.khbm}</td>
							<td style="width: 25%"><b>TEL：</b>${pi.khdh}</td>
							<td style="width: 25%"><b>E-MAIL：</b>${pi.khyx}</td>
						</tr>
						<tr>
							<td><b>ATTN：</b>${pi.khlxr}</td>
							<td colspan="2"><b>Address：</b>${pi.khdz}</td>
							<td><b>Currency：</b>${pi.bz}</td>
						</tr>
						<tr>
							<td><b>Brand：</b>${pi.khpp}</td>
							<td><b>是否分公司特价：</b>
								<input type="radio" class="skyreadonly" <c:if test="${pi.sfFgstj == 1}">checked="checked"</c:if>>是
								<input type="radio" class="skyreadonly" <c:if test="${pi.sfFgstj == 0}">checked="checked"</c:if>>否	
							</td>
						</tr>
						<tr>
							<c:if test="${pi.pilx == '4'}">
								<td><b>多元化采购供应商PI附件：</b>${pi.dyhcggyspi}</td>
							</c:if>
							<c:if test="${pi.pilx == '1' || pi.pilx == '7'|| pi.pilx == '8'|| pi.pilx == '9'|| pi.pilx == '10'}">
								<td><b>附件：</b>${pi.dyhcggyspi}</td>
							</c:if>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">装运信息</h5>
				<!-- 基本信息 -->
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 25%"><b>Format ：</b>${pi.zhfsmc}</td>
							<td colspan="3" style="width: 75%"><b>Purpose：</b>${pi.pimdmc}&nbsp;&nbsp;&nbsp;&nbsp;${pi.pimdbz}</td>						
						</tr>
						<tr>
							<td style="width: 25%"><b>Pay Terms：</b>${pi.fktjmc}</td>
							<td style="width: 25%"><b>Credit Balance：</b><fmt:formatNumber value="${pi.xyedye}" pattern="#,##0.00"/></td>
							<td colspan="2" style="width: 50%"><b>Price Terms：</b>${pi.gjmytkmc}&nbsp;&nbsp;&nbsp;&nbsp;${pi.gjmytkbz}</td>
						</tr>
						<tr>
							<td colspan="4">
								<b>Target Delivery Date：</b>${pi.yqdhrq1}&nbsp;&nbsp;&nbsp;&nbsp;${pi.yqdhrq2}
								&nbsp;&nbsp;&nbsp;&nbsp;${pi.yqdhrq5}&nbsp;&nbsp;&nbsp;&nbsp;${pi.yqdhrq4}
							</td>
						</tr>
						<tr>
							<td colspan="4"><b>Shipment：</b>${pi.cylxmc}&nbsp;&nbsp;&nbsp;&nbsp;${pi.cylxbz}</td>
						</tr>
						<tr>
							<td colspan="4"><b>变更信息备注：</b><PRE class="pre">${pi.bgbz}</PRE></td>
						</tr>
					</table>
				</div>
				<h5 class="header blue" style="margin-top: 4px;">产品信息</h5>
				<c:if test="${pi.pilx == '1'}">
					<!-- 产品信息 -->
					<div class="row" style="margin: 0px 8px;">
						<table class="table table-bordered">
							<tr>
								<th>行类型</th>
								<th>PID</th>
								<th>Model</th>
								<th>Chassis</th>
								<th>Description</th>
								<th>款式</th>
								<th>Quantity</th>
								<shiro:hasPermission name="${permission}">
								<c:if test="${pi.sfFgstj == 0}">
								<th>Unit Price</th>
								</c:if>
								<c:if test="${pi.sfFgstj == 1}">
								<th>特价</th>
								</c:if>
								<th>Total Amount</th>
								</shiro:hasPermission>
								<th>状态</th>
								<th>已下单数量</th>
								<th>审批中数量</th>
							</tr>
							<c:forEach items="${pi.piItemList}" var="item">
								<tr>
									<td>${item.mxlxmc}</td>
									<td>${item.pid}</td>
									<td>${item.jixing}</td>
									<td>${item.jixin}</td>
									<td align="left">${item.khxhms}</td>
									<td align="left">${item.ksmc}</td>
									<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
									<shiro:hasPermission name="${permission}">
									<c:if test ="${pi.sfFgstj == 0}">
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
									</c:if>
									<c:if test="${pi.sfFgstj == 1}">
									<td align="right"><fmt:formatNumber value="${item.tj}" pattern="#,##0.000000"/></td>
									</c:if>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
									</shiro:hasPermission>
									<td>${item.ztmc}</td>
									<td>${item.yxdsl}</td>
									<td>${item.spzsl}</td>
								</tr>
							</c:forEach>
							<c:if test="${not empty pi.zsl}">
								<tr>
									<td><b>合计</b></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td align="right"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
									<td>&nbsp;</td>
									<shiro:hasPermission name="${permission}"> 
									<td align="right"><b><fmt:formatNumber value="${pi.zje}" pattern="#,#00.000000"/></b></td>
									</shiro:hasPermission>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</c:if>
						</table>
					</div>
				</c:if>
				<c:if test="${pi.pilx == '2'}">
					<!-- 产品信息 -->
					<div class="row" style="margin: 0px 8px;">
						<table class="table table-bordered">
							<tr>
								<th>Type</th>
								<th>Meterial</th>
								<th>Description</th>
								<th>Unit</th>
								<th>Quantity</th>
							    <shiro:hasPermission name="${permission}"> 
							    <th>Unit Price</th>
								<th>Total Amount</th>
								</shiro:hasPermission>
								<th>Refer Order</th>
								<th>Mechanism</th>
								<th>Model No</th>
								<th>状态</th>
								<th>已下单数量</th>
								<th>审批中数量</th>
							</tr>
							<c:forEach items="${pi.piItemList}" var="item">
								<tr>
									<td>${item.mxlxmc}</td>
									<td>${item.wlbh}</td>
									<td>${item.khxhms}</td>
									<td>${item.dw}</td>
									<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
									<shiro:hasPermission name="${permission}"> 
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
									</shiro:hasPermission>
									<td>${item.ckddh}</td>
									<td>${item.jixin}</td>
									<td>${item.jixing}</td>
									<td>${item.ztmc}</td>
									<td>${item.yxdsl}</td>
									<td>${item.spzsl}</td>
								</tr>
							</c:forEach>
							<c:if test="${not empty pi.zsl}">
								<tr>
									<td><b>合计</b></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td align="right"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
									<td>&nbsp;</td>
									<shiro:hasPermission name="${permission}"> 
									<td align="right"><b><fmt:formatNumber value="${pi.zje}" pattern="#,##0.000000"/></b></td>
									</shiro:hasPermission>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</c:if>
						</table>
					</div>
				</c:if>
				<c:if test="${pi.pilx == '3'}">
					<!-- 产品信息 -->
					<div class="row" style="margin: 0px 8px;">
						<table class="table table-bordered">
							<tr>
								<th>PID</th>
								<th>Model</th>
								<th>Chassis</th>
								<th>Description</th>
								<th>款式</th>
								<th>Quantity</th>
							    <shiro:hasPermission name="${permission}"> 
								<th>Unit Price</th>
								<th>Total Amount</th>
								</shiro:hasPermission>
								<th>状态</th>
								<th>已下单数量</th>
								<th>审批中数量</th>
							</tr>
							<c:forEach items="${pi.piItemList}" var="item">
								<tr>
									<td>${item.pid}</td>
									<td>${item.jixing}</td>
									<td>${item.jixin}</td>
									<td>${item.khxhms}</td>
									<td>${item.ksmc}</td>
									<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
									<shiro:hasPermission name="${permission}"> 
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
									</shiro:hasPermission>
									<td>${item.ztmc}</td>
									<td>${item.yxdsl}</td>
									<td>${item.spzsl}</td>
								</tr>
							</c:forEach>
							<c:if test="${not empty pi.zsl}">
								<tr>
									<td><b>合计</b></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td align="right"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
									<shiro:hasPermission name="${permission}"> 
									<td align="right"><b><fmt:formatNumber value="${pi.zje}" pattern="#,#00.000000"/></b></td>
									</shiro:hasPermission>
									<td>&nbsp;</td>
								</tr>
							</c:if>
						</table>
					</div>
				</c:if>
				<c:if test="${pi.pilx == '4' || pi.pilx == '5' || pi.pilx == '6'}">
					<!-- 产品信息 -->
					<div class="row" style="margin: 0px 8px;">
						<table class="table table-bordered">
							<tr>
								<th>Material</th>
								<th>Model</th>
								<th>CustModel</th>
								<th>Description</th>
								<th>Quantity</th>
								<shiro:hasPermission name="${permission}"> 
								<th>Unit Price</th>
								<th>Total Amount</th>
								</shiro:hasPermission>
								<th>免费数量</th>
								<th>状态</th>
								<th>已下单数量</th>
								<th>审批中数量</th>
							</tr>
							<c:forEach items="${pi.piItemList}" var="item">
								<tr>
									<td>${item.wlbh}</td>
									<td>${item.model}</td>
									<td>${item.khxh}</td>
									<td>${item.khxhms}</td>
									<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
									<shiro:hasPermission name="${permission}">
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
									</shiro:hasPermission>
									<td align="right"><fmt:formatNumber value="${item.mfsl}" pattern="#,##0"/></td>
									<td>${item.ztmc}</td>
									<td>${item.yxdsl}</td>
									<td>${item.spzsl}</td>
								</tr>
							</c:forEach>
							<c:if test="${not empty pi.zsl}">
								<tr>
									<td><b>合计</b></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td align="right"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
									<td>&nbsp;</td>
									<shiro:hasPermission name="${permission}"> 
									<td align="right"><b><fmt:formatNumber value="${pi.zje}" pattern="#,##0.000000"/></b></td>
									</shiro:hasPermission>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</c:if>
						</table>
					</div>
				</c:if>
				<c:if test="${pi.pilx == '8'}">
					<!-- 产品信息 -->
					<div class="row" style="margin: 0px 8px;">
						<table class="table table-bordered">
							<tr>
								<th>Type</th>
								<th>Material</th>
								<th>Description</th>
								<th>Quantity</th>
								<shiro:hasPermission name="${permission}"> 
								<th>Unit Price</th>
								<th>Total Amount</th>
								</shiro:hasPermission>
								<th>Refer Order</th>
								<th>Mechanism</th>
								<th>Model No</th>
								<th>免费数量</th>
								<th>状态</th>
								<th>已下单数量</th>
								<th>审批中数量</th>
							</tr>
							<c:forEach items="${pi.piItemList}" var="item">
								<tr>
									<td>${item.mxlxmc}</td>
									<td>${item.wlbh}</td>
									<td>${item.khxhms}</td>
									<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
									<shiro:hasPermission name="${permission}">
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
									</shiro:hasPermission>
									<td>${item.ckddh}</td>
									<td>${item.jixin}</td>
									<td>${item.jixing}</td>
									<td align="right"><fmt:formatNumber value="${item.mfsl}" pattern="#,##0"/></td>
									<td>${item.ztmc}</td>
									<td>${item.yxdsl}</td>
									<td>${item.spzsl}</td>
								</tr>
							</c:forEach>
							<c:if test="${not empty pi.zsl}">
								<tr>
									<td><b>合计</b></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td align="right"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
									<td>&nbsp;</td>
									<shiro:hasPermission name="${permission}"> 
									<td align="right"><b><fmt:formatNumber value="${pi.zje}" pattern="#,##0.000000"/></b></td>
									</shiro:hasPermission>
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
				</c:if>
				<c:if test="${pi.pilx == '7' || pi.pilx == '9'|| pi.pilx == '10'}">
					<!-- 产品信息 -->
					<div class="row" style="margin: 0px 8px;">
						<table class="table table-bordered">
							<tr>
								<th>Material</th>
								<th>Model</th>
								<th>CustModel</th>
								<th>Description</th>
								<th>Quantity</th>
								<shiro:hasPermission name="${permission}"> 
								<th>Unit Price</th>
								<th>Total Amount</th>
								</shiro:hasPermission>
								<th>免费数量</th>
								<th>状态</th>
								<th>已下单数量</th>
								<th>审批中数量</th>
							</tr>
							<c:forEach items="${pi.piItemList}" var="item">
								<tr>
									<td>${item.wlbh}</td>
									<td>${item.model}</td>
									<td>${item.khxh}</td>
									<td>${item.khxhms}</td>
									<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
									<shiro:hasPermission name="${permission}">
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
									</shiro:hasPermission>
									<td align="right"><fmt:formatNumber value="${item.mfsl}" pattern="#,##0"/></td>
									<td>${item.ztmc}</td>
									<td>${item.yxdsl}</td>
									<td>${item.spzsl}</td>
								</tr>
							</c:forEach>
							<c:if test="${not empty pi.zsl}">
								<tr>
									<td><b>合计</b></td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td align="right"><b><fmt:formatNumber value="${pi.zsl}" pattern="#,##0"/></b></td>
									<td>&nbsp;</td>
									<shiro:hasPermission name="${permission}"> 
									<td align="right"><b><fmt:formatNumber value="${pi.zje}" pattern="#,##0.000000"/></b></td>
									</shiro:hasPermission>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
								</tr>
							</c:if>
						</table>
					</div>
				</c:if>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="4"><b>Product Remark：</b><PRE class="pre">${pi.cpbzxx}</PRE></td>
					</tr>
				</table>
				<h5 class="header blue" style="margin-top: 4px;">银行信息</h5>
				<!-- 银行信息 -->
				<div class="row" style="margin: 0px 8px;">
					<table cellspacing="0" cellpadding="0">
						<tr>
							<td style="width: 50%"><b>Bank Name ：</b>${pi.skyhmc}</td>
							<td style="width: 50%"><b>Bank Address：</b>${pi.skyhdz}</td>
						</tr>
						<tr>
							<td><b>Swift Code：</b>${pi.skyhdm}</td>
							<td><b>Account No.：</b>${pi.skyhzh}</td>
						</tr>
						<tr>
							<td><b>L/C Advising Bank Name ：</b>${pi.lcskyhmc}</td>
							<td><b>L/C Advising Bank Address：</b>${pi.lcskyhdz}</td>
						</tr>
						<tr>
							<td><b>L/C Advising Swift Code：</b>${pi.lcskyhdm}</td>
							<td><b>L/C Advising Account No.：</b>${pi.lcskyhzh}</td>
						</tr>
						<tr>
							<td><b>Beneficiary ：</b>${pi.syr}</td>
							<td><b>Beneficiary Address：</b>${pi.syrdz}</td>
						</tr>
						<tr>
							<td colspan="2"><b>Remark：</b><PRE class="pre">${pi.bzxx}</PRE></td>
						</tr>
					</table>
				</div>
			    <h5 class="header blue" style="margin-top: 4px;">审批日志</h5>
			    <div class="space-4"></div>
						<div class="row" style="margin: 0px 8px;">
							<table class="table table-bordered">
								<tr>
									<th>PI号</th>
									<th>版本号</th>
									<th>操作类型</th>
									<th>操作职位</th>
									<th>操作人账号</th>
									<th>操作人名称</th>
									<th>操作时间</th>
									<th>处理意见</th>
								</tr>
								<c:forEach items="${pi.logList}" var="item">
									<tr>
										<td>${item.piid}</td>
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
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
	</div>
</body>
<script type="text/javascript">
	var pilx = $("input[name=pilx]").val();
	var printUrl = "";
	if(pilx == '1'){	//大货pi
		printUrl = "<c:url value='/pi/pi/print'/>";
	}else if(pilx == '2'){	//备损pi
		printUrl = "<c:url value='/pi/piSPO/print'/>";
	}else if(pilx == '3'){	//样机pi
		printUrl = "<c:url value='/pi/piSample/print'/>";
	}else if(pilx == '4' || pilx == '5' || pilx == '6'){	//多元化或多元化屏pi
		printUrl = "<c:url value='/pi/piDiversity/print'/>";
	}else if(pilx == '7' || pilx == '8' || pilx == '9'|| pilx == '10'){	//副营
		printUrl = "<c:url value='/pi/piFy/print'/>";
	}
	//$(".skyreadonly").prop("disabled","disabled");
	//var printUrl = "<c:url value='/pi/pi/print'/>";
	$(".skyreadonly").addReadonly();
	//打印
	$("#btn-print").click(function() {
		var zt = $("input[name=zt]").val();
		var id = $("input[name=id]").val();
		window.open(printUrl + "?id=" + id);

	})
	
	// 查看流程
		$("#btn-flow").click(function(){	
			bootbox.dialog({
				title : "流程图",
				message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
</script>
</html>