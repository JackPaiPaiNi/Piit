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
			<c:if test="${orderDiversity.gsbm != 'MCO'}">
				<div style="float: left;">
					<img style="width:200px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_logo.jpg">
				</div>
				<div style="float: left;">
					<div style="font-size: x-large; margin-left: 0px;"><b>${orderDiversity.gsmc}</b></div>
					<%-- <div style="font-size: 13px;">RGB
						${orderDiversity.gsywmc}</div> --%>
				</div>
			</c:if>
			<c:if test="${orderDiversity.gsbm == 'MCO'}">
				<div style="float: center;">
					<div style="font-size: x-large; margin-left: 0px;"><b>${orderDiversity.gsmc}</b></div>
				</div>
			</c:if>
			<div style="clear: both;"></div>
		</div>
		<hr>
		<%-- <div style="margin-top: -5px;">SHENZHENSHIYANG${orderDiversity.gsywdz}</div> --%>
		<div style="font-size: large; font-weight: bold; text-decoration: underline; padding: 5px;">多元化订单</div>
		<div style="text-align: right; float: right;"><b>&nbsp;&nbsp;&nbsp;&nbsp;收费类型：</b>
			<input type="radio" class="skyradio" <c:if test="${orderDiversity.sfMf == 0}">checked="checked"</c:if>>收费
			<input type="radio" class="skyradio" <c:if test="${orderDiversity.sfMf == 1}">checked="checked"</c:if>>免费
		</div>
		<div style="text-align: right; float: right;"><b>订单号：</b>${orderDiversity.ddid}</div>
		<br>
	</div>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">表头信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>发货公司:</b></td>
			<td style="width: 23%;">${orderDiversity.scjdmc}</td>
			<td style="width: 10%;"><b>PI号:</b></td>
			<td style="width: 23%;"><%-- ${orderDiversity.piid} --%></td>
			<td style="width: 10%;"><b>公司编码:</b></td>
			<td style="width: 23%;">${orderDiversity.gsbm}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>公司名称:</b></td>
			<td style="width: 23%;">${orderDiversity.gsmc}</td>
			<td style="width: 10%;"><b>订单类型:</b></td>
			<td style="width: 23%;">${orderDiversity.ddlxmc}</td>
			<td style="width: 10%;"><b>订单类别:</b></td>
			<td style="width: 23%;">${orderDiversity.ddlbmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>业务类型:</b></td>
			<td style="width: 23%;">${orderDiversity.ywlxmc}</td>
			<td style="width: 10%;"><b>订单状态:</b></td>
			<td style="width: 23%;">
				<c:choose>
				   <c:when test="${orderDiversity.zt == '1'}">草稿 
				   </c:when>
				   <c:when test="${orderDiversity.zt == '2'}">审批中 
				   </c:when>
				   <c:when test="${orderDiversity.zt == '3'}">驳回 
				   </c:when>
				   <c:when test="${orderDiversity.zt == '4'}">审批通过 
				   </c:when>
				   <c:when test="${orderDiversity.zt == '5'}">已生效 
				   </c:when>
				   <c:when test="${orderDiversity.zt == '6'}">取消 
				   </c:when>
				</c:choose>
			</td>
			<td style="width: 10%;"><b>制单人:</b></td>
			<td style="width: 23%;">${orderDiversity.zdrmc}</td>
		</tr>
		<tr>
			
			<td style="width: 10%;"><b>制单日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderDiversity.zdsj}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>销售员:</b></td>
			<td style="width: 23%;">${orderDiversity.xsymc}</td>
			<td style="width: 10%;"><b>业务组:</b></td>
			<td style="width: 23%;">${orderDiversity.ywzmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>销售组织:</b></td>
			<td style="width: 23%;">${orderDiversity.xszzmc}</td>
			<td style="width: 10%;"><b>版本号:</b></td>
			<td style="width: 23%;">${orderDiversity.bbh}</td>
			<td style="width: 10%;">&nbsp;</td>
			<td style="width: 23%;">&nbsp;</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="11" style="font-size: 13px; text-align: left;">PI信息</th>
		</tr>
		<tr>
			<th>PI号</th>
			<th>产品类型</th>
			<th>物料编号</th>
			<th>我司型号</th>
			<th>客户型号</th>
			<th>描述</th>
			<th>数量</th>
			<%-- <shiro:hasPermission name="order:orderDiversity:price">
			<th>单价</th>
			<th>金额</th>
			</shiro:hasPermission> --%>
			<th>免费数量</th>
		</tr>
		<c:forEach items="${orderDiversity.orderDiversityItemList}" var="item">
				<tr>
					<td>${item.piid}</td>
					<td>${item.cplxmc}</td>
					<td>${item.wlbh}</td>
					<td>${item.model}</td>
					<td>${item.khxh}</td>
					<td>${item.khxhms}</td>
					<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
					<%-- <shiro:hasPermission name="order:orderDiversity:price">
					<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.00"/></td>
					<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.00"/></td>
					</shiro:hasPermission> --%>
					<td align="right"><fmt:formatNumber value="${item.mfsl}" pattern="#,##0"/></td>
				</tr>
			</c:forEach>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">基本信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>走货方式:</b></td>
			<td style="width: 23%;">${orderDiversity.zhfsmc}</td>
			<td style="width: 10%;"><b>交货日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderDiversity.jhrq}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>国际贸易条款:</b></td>
			<td style="width: 23%;">${orderDiversity.gjmytkmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>付款条件:</b></td>
			<td style="width: 23%;">${orderDiversity.fktjmc}</td>
			<td style="width: 10%;"><b>币种:</b></td>
			<td colspan="3">${orderDiversity.bz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>验货日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderDiversity.yhrq}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>渠道:</b></td>
			<td style="width: 23%;">${orderDiversity.qdmc}</td>
			<td colspan="2"></td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">客户信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>客户名称:</b></td>
			<td style="width: 23%;">${orderDiversity.khmc}</td>
			<td style="width: 10%;"><b>客户编码:</b></td>
			<td style="width: 23%;">${orderDiversity.khbm}</td>
			<td style="width: 10%;"><b>销往国家:</b></td>
			<td style="width: 23%;">${orderDiversity.xwgjmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>时区:</b></td>
			<td style="width: 23%;">${orderDiversity.sq}</td>
			<td style="width: 10%;"><b>品牌:</b></td>
			<td style="width: 23%;">${orderDiversity.pp}</td>
			<td style="width: 10%;"><b>出厂语言:</b></td>
			<td style="width: 23%;">${orderDiversity.ccyymc}</td>
		</tr>
		<tr>
		     <td style="width: 10%;"><b>付款保证状态:</b></td>
		     <td style="width: 90%;" colspan="5">
		        <c:choose>
				   <c:when test="${orderDiversity.fkbzzt == '1'}">通过</c:when>
				   <c:when test="${orderDiversity.fkbzzt == '0'}">未通过</c:when>
		         </c:choose>
		     </td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="10" style="font-size: 13px; text-align: left;">产品信息</th>
		</tr>
		<tr>
			<td>操作类型</td>
			<th>产品类型</th>
			<th>物料编号</th>
			<th>订单数量</th>
			<%-- <shiro:hasPermission name="order:orderDiversity:price">
			<th>单价</th>
			<th>金额</th>
			</shiro:hasPermission> --%>
			<th>免费数量</th>
		</tr>
		<c:forEach items="${orderDiversity.orderDiversityItemList}" var="item">
			<tr>
				<td>${item.flagmc}</td>
				<td>${item.cplxmc}</td>
				<td>${item.wlbh}</td>
				<td align="right">${item.sl}</td>
				<%-- <shiro:hasPermission name="order:orderDiversity:price">
				<td align="right">${item.dj}</td>
				<td align="right">${item.je}</td>
				</shiro:hasPermission> --%>
				<td align="right">${item.mfsl}</td>
			</tr>
		</c:forEach>
	</table>
	<%-- <div style="text-align: right; float: right; margin-right: 100px;"><b>总金额：</b>${orderDiversity.zje}</div> --%>
	<br>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="10" style="font-size: 13px; text-align: left;">备注信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>备注:</b></td>
			<td colspan="5"><PRE class="pre">${orderDiversity.bzxx}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>变更信息备注:</b></td>
			<td colspan="5"><PRE class="pre">${orderDiversity.bgbz}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>附件:</b></td>
			<td colspan="5">${orderDiversity.fj}</td>
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