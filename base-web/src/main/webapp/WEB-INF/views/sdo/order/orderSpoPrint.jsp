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
			word-wrap : break-word;
			word-break : break-all;
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
			<c:if test="${orderSpo.gsbm != 'MCO'}">
				<div style="float: left;">
					<img style="width:200px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_logo.jpg">
				</div>
				<div style="float: left;">
					<div style="font-size: x-large; margin-left: 0px;"><b>${orderSpo.gsmc}</b></div>
					<%-- <div style="font-size: 13px;">RGB
						${orderSpo.gsywmc}</div> --%>
				</div>
			</c:if>
			<c:if test="${orderSpo.gsbm == 'MCO'}">
				<div style="float: center;">
					<div style="font-size: x-large; margin-left: 0px;"><b>${orderSpo.gsmc}</b></div>
				</div>
			</c:if>
			<div style="clear: both;"></div>
		</div>
		<hr>
		<%-- <div style="margin-top: -5px;">SHENZHENSHIYANG${orderSpo.gsywdz}</div> --%>
		<div style="font-size: large; font-weight: bold; text-decoration: underline; padding: 5px;">备损订单</div>
		<div style="text-align: right; float: right;"><b>&nbsp;&nbsp;&nbsp;&nbsp;订单类别：</b>${orderSpo.ddlbmc}</div>
		<div style="text-align: right; float: right;"><b>订单号：</b>${orderSpo.ddid}</div>
		<br>
	</div>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">表头信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>生产基地:</b></td>
			<td style="width: 23%;">${orderSpo.scjdmc}</td>
			<td style="width: 10%;"><b>PI号:</b></td>
			<td style="width: 23%;"><%-- ${orderSpo.piid} --%></td>
			<td style="width: 10%;"><b>公司编码:</b></td>
			<td style="width: 23%;">${orderSpo.gsbm}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>公司名称:</b></td>
			<td style="width: 23%;">${orderSpo.gsmc}</td>
			<td style="width: 10%;"><b>订单状态:</b></td>
			<td style="width: 23%;">${orderSpo.ztmc}</td>
			<td style="width: 10%;"><b>客户编码:</b></td>
			<td style="width: 23%;">${orderSpo.khbm}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>客户名称:</b></td>
			<td style="width: 23%;">${orderSpo.khmc}</td>
			<td style="width: 10%;"><b>制单人:</b></td>
			<td style="width: 23%;">${orderSpo.zdrmc}</td>
			<td style="width: 10%;"><b>制单日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderSpo.zdsj}" pattern="yyyy-MM-dd"/></td>
			
		</tr>
		<tr>
			<td style="width: 10%;"><b>付款条件:</b></td>
			<td style="width: 23%;">${orderSpo.fktjmc}</td>
			<td style="width: 10%;"><b>是否免费:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSpo.sfMf == 1}">checked="checked"</c:if>>是
				<input type="radio" class="skyradio" <c:if test="${orderSpo.sfMf == 0}">checked="checked"</c:if>>否
			</td>
			<td style="width: 10%;"><b>责任划分:</b></td>
			<td style="width: 23%;">${orderSpo.zrhfmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>客诉编号:</b></td>
			<td style="width: 23%;">${orderSpo.ksbh}</td>
			<td style="width: 10%;"><b>是否传制造:</b></td>
			<td style="width: 23%;">
				<input type="radio" class="skyradio" <c:if test="${orderSpo.sfCzz == 1}">checked="checked"</c:if>>是
				<input type="radio" class="skyradio" <c:if test="${orderSpo.sfCzz == 0}">checked="checked"</c:if>>否
			</td>
			<td style="width: 10%;"><b>版本号:</b></td>
			<td style="width: 23%;">${orderSpo.bbh}</td>
		</tr>
	</table>
	<br><br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">基本信息</th>
		</tr>
		<tr>
			<td style="width: 10%;"><b>销售员:</b></td>
			<td style="width: 23%;">${orderSpo.xsyid}</td>
			<td style="width: 10%;"><b>业务组:</b></td>
			<td style="width: 23%;">${orderSpo.ywz}</td>
			<td style="width: 10%;"><b>销售组织:</b></td>
			<td style="width: 23%;">${orderSpo.xszz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>交货日期:</b></td>
			<td style="width: 23%;"><fmt:formatDate value="${orderSpo.jhrq}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 10%;"><b>业务类型:</b></td>
			<td style="width: 23%;">${orderSpo.ywlxmc}</td>
			<td style="width: 10%;"><b>出运类型:</b></td>
			<td style="width: 23%;">${orderSpo.cylxmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>币种:</b></td>
			<td style="width: 23%;">${orderSpo.bz}</td>
			<td style="width: 10%;"><b>国际贸易条款:</b></td>
			<td style="width: 23%;">${orderSpo.gjmytkmc}</td>
			<td colspan="2">${orderSpo.gjmytkbz}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>销往国家:</b></td>
			<td style="width: 23%;">${orderSpo.xwgjmc}</td>
			<td style="width: 10%;"><b>装运/起运港:</b></td>
			<td style="width: 23%;">${orderSpo.zygmc}</td>
			<td style="width: 10%;"><b>费用承担部门:</b></td>
			<td style="width: 23%;">${orderSpo.fycdbmmc}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>渠道:</b></td>
			<td style="width: 23%;">${orderSpo.qdmc}</td>
			<td style="width: 10%;"><b>电视机类型:</b></td>
			<td style="width: 23%;">${orderSpo.dsjlxmc}</td>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>附件:</b></td>
			<td colspan="5">${orderSpo.fj}</td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>免费补料原因:</b></td>
			<td colspan="5"><PRE class="pre">${orderSpo.mfblyy}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>备注:</b></td>
			<td colspan="5"><PRE class="pre">${orderSpo.bzxx}</PRE></td>
		</tr>
		<tr>
			<td style="width: 10%;"><b>变更信息备注:</b></td>
			<td colspan="5"><PRE class="pre">${orderSpo.bgbz}</PRE></td>
		</tr>
	</table>
	<br>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="12" style="font-size: 13px; text-align: left;">物料清单</th>
		</tr>
		<tr>
			<th style="width: 10%;">PI号</th>
			<th style="width: 5%;">操作类型</th>
			<!-- <th>物料类型</th> -->
			<th style="width: 13%;">物料编码</th>
			<th style="width: 12%;">物料描述</th>
			<th style="width: 5%;">币种</th>
			<th style="width: 6%;">数量</th>
			<th style="width: 5%;">单位</th>
			<shiro:hasPermission name="order:orderSpo:price">
			<th style="width: 9%;">单价（含税）</th>
			<th style="width: 12%;">金额</th>
			</shiro:hasPermission>
			<th style="width: 7%;">参考订单</th>
			<th style="width: 7%;">机型</th>
			<th style="width: 5%;">机芯</th>
		</tr>
		<c:forEach items="${orderSpo.orderSpoItemList}" var="item">
			<tr>
				<td style="width: 10%;">${item.piid}</td>
				<td style="width: 5%;">${item.flagmc}</td>
				<%-- <td>${item.wllxmc}</td> --%>
				<td style="width: 13%;">${item.wlbh}</td>
				<td style="width: 12%;">${item.wlms}</td>
				<td style="width: 5%;">${item.bz}</td>
				<td style="width: 6%;" align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
				<td style="width: 5%;">${item.dw}</td>
				<shiro:hasPermission name="order:orderSpo:price">
				<td style="width: 9%;" align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
				<td style="width: 12%;" align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
				</shiro:hasPermission>
				<td style="width: 7%;">${item.ckddh}</td>
				<td style="width: 7%;">${item.jixing}</td>
				<td style="width: 5%;">${item.jixin}</td>
			</tr>
		</c:forEach>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td colspan="2"><b>总数量:</b></td>
			<td>${orderSpo.zsl}</td>
			<shiro:hasPermission name="order:orderSpo:price">
			<td colspan="2"><b>总金额:</b></td>
			<td><fmt:formatNumber value="${orderSpo.zje}" pattern="#,##0.000000"/></td>
			</shiro:hasPermission>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
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