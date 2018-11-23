<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<style type="text/css">
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
		th{
			white-space: nowrap;
		}
		.pre{
			background-color:#ffffff;
			border:1px solid #ffffff;
			margin :0px 0 0 0px;
			padding:0px !important; 
			white-space: pre-line!important;      
			white-space: -moz-pre-wrap; 
			white-space: -pre-wrap;     
			white-space: -o-pre-wrap;   
			word-wrap: break-word;  
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
				<input type="hidden" name="id" value="${invoice.id}"/>
				<input type="hidden" name="sjc" value="${invoice.sjc}"/>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td  style="width: 25%">发票模板：${invoice.fpmbmc}</td>
						<td style="width: 25%">箱单模板：${invoice.xdmbmc}</td>
						<td style="width: 25%"></td>
						<td style="width: 25%">
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
								返回
							</button>
							&nbsp;
							<button id="btn-fpPrint" type="button" class="btn btn-light btn-sm">
								<i class="icon-print icon-on-right bigger-110"></i>
								发票打印
							</button>
							&nbsp;
							 <button id="btn-xdPrint" type="button" class="btn btn-light btn-sm">
								<i class="icon-print icon-on-right bigger-110"></i>
								箱单打印
							</button> 
							<button id="btn-exportInvoiceInfo" type="button" class="btn btn-light btn-sm">
								<i class="icon-print icon-on-right bigger-110"></i>
								发票信息导出
							</button> 
						</td>
					</tr>
					<tr>
						<td style="width: 25%">发票号：${invoice.fph}</td>
						<td style="width: 25%">发票时间：<fmt:formatDate value="${invoice.fprq}" pattern="yyyy-MM-dd"/></td>
						<td style="width: 25%">发票状态：
							<c:choose>
							   <c:when test="${invoice.zt == '1'}">草稿 
							   </c:when>
							   <c:when test="${invoice.zt == '2'}">终稿
							   </c:when>
							</c:choose>
						</td>
						<td style="width: 25%"></td>
					</tr>
				</table>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 80px;">订单号：</td>
						<td><pre class="pre">${invoice.orderno}</pre></td>
					</tr>
				</table>
			</div>
		
			<h5 class="header blue" style="margin-top:4px;">公司信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">公司名称：${invoice.gsywmc}</td>
						<td style="width: 25%">公司联系电话：${invoice.gsdh}</td>
						<td style="width: 50%">公司地址：${invoice.gsdz}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">Sold to Messrs</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">客户名称：${invoice.khmc}</td>
						<td style="width: 25%">客户联系电话：${invoice.khdh}</td>
						<td style="width: 50%">客户地址：${invoice.khdz}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">Consignee to</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">公司名称：${invoice.shfmc}</td>
						<td style="width: 25%">公司联系电话：${invoice.shfdh}</td>
						<td style="width: 50%">公司地址：${invoice.shfdz}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">Delivery to</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">公司名称：${invoice.shdmc}</td>
						<td style="width: 25%">公司联系电话：${invoice.shddh}</td>
						<td style="width: 50%">公司地址：${invoice.shddz}</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">基本信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%">起运港：${invoice.qyg}</td>
						<td style="width: 25%">目的港：${invoice.mdg}</td>
						<td style="width: 25%">贸易条款：${invoice.mytkmc}</td>
						<td style="width: 25%">付款条件：${invoice.fktjmc}</td>
					</tr>
					<tr>
						<td>航名航次：${invoice.cmhc}</td>
						<td>起运日期：<fmt:formatDate value="${invoice.qyrq}" pattern="yyyy-MM-dd"/></td>
						<td>预计到港期：<fmt:formatDate value="${invoice.yjdgq}" pattern="yyyy-MM-dd"/></td>
						<td>提单号：${invoice.tdh}</td>
					</tr>
					<tr>
						<td colspan="2">Country Of Origin：${invoice.ycgj}</td>
						<td colspan="2">Marks &Nos：${invoice.marks}</td>
					</tr>
					<tr>
						<td colspan="4">Description：<pre class="pre">${invoice.ms}</pre></td>
					</tr>
					<tr>
						<td colspan="4">发票底部描述：<pre class="pre">${invoice.footer}</pre></td>
					</tr>
					<tr>
						<td>定金：${invoice.deposit}</td>
						<td>剩余未收款：${invoice.tobepaid}</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>客户PO：${invoice.khpo}</td>
						<td>走货方式：${invoice.zhfsmc}</td>
						<td>出运类型：${invoice.cylxmc}</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2">收款银行名称：${invoice.skyhmc}</td>
						<td colspan="2">收款银行地址：${invoice.skyhdz}</td>
					</tr>
					<tr>
						<td colspan="2">收款银行代码：${invoice.skyhdm}</td>
						<td colspan="2">收款银行账号：${invoice.skyhzh}</td>
					</tr>
					<tr>
						<td colspan="2">受益人：${invoice.syr}</td>
						<td colspan="2">受益人地址：${invoice.syrdz}</td>
					</tr>
				</table>
			</div>
			<div class="space-8"></div>
			<ul class="nav nav-tabs">
				<li class="active"><a href="#fpxx-tab" data-toggle="tab">发票明细</a></li>
				<li><a href="#qtfy-tab" data-toggle="tab">箱单明细</a></li>
			</ul>
			<div class="tab-content">
				<!-- 发票信息TAB -->
				<div class="tab-pane fade active in" id="fpxx-tab">
					<div class="row" style="margin: 0px 8px; overflow-x: auto;">
						<table class="table table-bordered">
							<tr>
								<th>invoice no</th>
								<th>Shipping no</th>
								<th>Job No.</th>
								<th>Part No.</th>
								<th>DESCRIPTION</th>
								<th>HS CODE</th>
								<th>QTY</th>
								<th>UNIT</th>
								<th>TTL NET WEIGHT (KG)</th>
								<th>UNIT PRICE(USD)</th>
								<th>AMOUNT (USD)</th>
								<th>BRIC PART NUMBER</th>
								<th>BRIC DESCRIPTION</th>
								<th>MANUFACTURER NAME</th>
								<th>MANUFACTURER<br>ADDRESS</th>
								<th>ORIGINAL OF COUNTRY</th>
								<th>Description</th>
								<th>Model No.</th>
							</tr>
							<c:forEach items="${invoice.custInvItems}" var="item">
								<tr>
									<td>${item.fph}</td>
									<td>${item.chdh}</td>
									<td>${item.ddid}</td>
									<td>${item.wlbh}</td>
									<td>${item.wlms}</td>
									<td>${item.hscode}</td>
									<td>${item.sl}</td>
									<td>${item.dw}</td>
									<td align="right"><fmt:formatNumber value="${item.zxzwet}" pattern="#,##0.000" /></td>
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.00" /></td>
									<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.00" /></td>
									<td>${item.khlh}</td>
									<td>${item.khms}</td>
									<td>${item.gysmc}</td>
									<td>${item.gysdz}</td>
									<td>${item.ycgj}</td>
									<td>${item.spmc}</td>
									<td>${item.khxh}</td>
								</tr>
							</c:forEach>
							<tr>
								<th>TOTAL</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th align="right"><fmt:formatNumber value="${invoice.zsl}" pattern="#,##0" /></th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th align="right"><fmt:formatNumber value="${invoice.zje}" pattern="#,##0.00" /></th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
								<th>&nbsp;</th>
							</tr>
						</table>
					</div>
				</div>
				<!-- 箱单TAB -->
				<div class="tab-pane fade" id="qtfy-tab">
					<div class="row" style="margin: 0px 8px; overflow-x: auto;">
						<table class="table table-bordered">
							<tr>
								<th>发票号</th>
								<th>柜号</th>
								<th>封条号</th>
								<th>卡板号</th>
								<th>箱编号</th>
								<th>订单号</th>
								<th>物料编号</th>
								<th>物料描述</th>
								<th>客户型号</th>
								<th>单个净重</th>
								<th>实发数</th>
								<th>单位</th>
								<th>订单数</th>
								<th>1%备损</th>
								<th>单价</th>
								<th>订单金额</th>
								<th>备损金额</th>
								<th>创维组件号</th>
								<th>创维组件描述</th>
								<th>创维组件数量</th>
								<th>单箱数量</th>
								<th>单箱毛重</th>
								<th>单箱净重</th>
								<th>箱数</th>
								<th>箱总毛重</th>
								<th>箱总净重</th>
								<th>纸箱长cm</th>
								<th>纸箱宽cm</th>
								<th>纸箱高cm</th>
								<th>卡板长cm</th>
								<th>卡板宽cm</th>
								<th>卡板高cm</th>
								<th>卡板数</th>
								<th>每卡板重量</th>
								<th>卡板总重量</th>
								<th>总体积</th>
								<th>原产国家</th>
								<th>p.o.no.</th>
								<th>供应商名称</th>
								<th>客户料号</th>
								<th>客户描述</th>
							</tr>
							<c:forEach items="${invoice.custInvPackings}" var="item">
								<tr>
									<td>${item.fph}</td>
									<td>${item.guino}</td>
									<td>${item.ftno}</td>
									<td>${item.kbno}</td>
									<td>${item.boxno}</td>
									<td>${item.ddid}</td>
									<td>${item.wlbh}</td>
									<td>${item.wlms}</td>
									<td>${item.khxh}</td>
									<td align="right"><fmt:formatNumber value="${item.dgjz}" pattern="#,##0.000" /></td>
									<td align="right"><fmt:formatNumber value="${item.sfqty}" pattern="#,##0" /></td>
									<td>${item.dw}</td>
									<td align="right"><fmt:formatNumber value="${item.ddqty}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.bsqty}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.00" /></td>
									<td align="right"><fmt:formatNumber value="${item.ddje}" pattern="#,##0.00" /></td>
									<td align="right"><fmt:formatNumber value="${item.bsje}" pattern="#,##0.00" /></td>
									<td>${item.gszjh}</td>
									<td>${item.gszjms}</td>
									<td align="right"><fmt:formatNumber value="${item.gszjsl}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.dxsl}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.zxmz}" pattern="#,##0.000" /></td>
									<td align="right"><fmt:formatNumber value="${item.zxjz}" pattern="#,##0.000" /></td>
									<td align="right"><fmt:formatNumber value="${item.zxnum}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.zxzmz}" pattern="#,##0.000" /></td>
									<td align="right"><fmt:formatNumber value="${item.zxzjz}" pattern="#,##0.000" /></td>
									<td align="right"><fmt:formatNumber value="${item.zxC}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.zxK}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.zxG}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.kbC}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.kbK}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.kbG}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.kbnum}" pattern="#,##0" /></td>
									<td align="right"><fmt:formatNumber value="${item.kbwet}" pattern="#,##0.000" /></td>
									<td align="right"><fmt:formatNumber value="${item.kbzwet}" pattern="#,##0.000" /></td>
									<td align="right"><fmt:formatNumber value="${item.sumzv}" pattern="#,##0.000" /></td>
									<td>${item.ycgj}</td>
									<td>${item.pono}</td>
									<td>${item.gysmc}</td>
									<td>${item.khlh}</td>
									<td>${item.khms}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
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
	$(function($){
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		
		$(".skycheckbox").prop("disabled","disabled");
		$(".skyradio").prop("disabled","disabled");
		
		$("#btn-fpPrint").click(function(){
			window.open("<c:url value='/custinv/custinv/printPage'/>?id=${invoice.id}&fpmb=${invoice.fpmb}");
	    });
		
		$("#btn-xdPrint").click(function(){
			window.open("<c:url value='/custinv/custinv/printPacking'/>?id=${invoice.id}&packingType=${invoice.xdmb}");
	    }); 
				//导出
		$("#btn-exportInvoiceInfo").click(function(){
        	$("#export").bindSweetAlert({
    			title:"确定要导出吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				window.open("<c:url value='/custinv/custinv/exportInvoice'/>?id=${invoice.id}");
    			}
    		});
		});
	});
		
</script>
</html>