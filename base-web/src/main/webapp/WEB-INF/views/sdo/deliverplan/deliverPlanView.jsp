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
</style>
</head>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row" style="margin: 0px 8px;">
				<input type="hidden" name="id" id="id" value="${deliverPlan.id}"/>
				<table cellspacing="0" cellpadding="0">
					<tr>
					    <td style="width: 80%"></td>
						<td style="width: 20%">
						<button id="btn-back" class="btn btn-sm" type="button">
						<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
						</td>
					</tr>
				</table>
			</div>
			<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>走货计划单号 ：</b>${deliverPlan.zhjhdh}</td>
						<td style="width: 25%"><b>类型：</b>${deliverPlan.lxmc}</td>
						<td style="width: 25%"><b>状态：</b>${deliverPlan.ztmc}</td>
						<td style="width: 25%"><b>制单人：</b>${deliverPlan.zdrmc}</td>
					</tr>
					<tr>
						<td><b>制单时间：</b><fmt:formatDate value="${deliverPlan.zdsj}" pattern="yyyy-MM-dd" /></td>
						<td><b>装柜开始时间：</b><fmt:formatDate value="${deliverPlan.zgkssj}" pattern="yyyy-MM-dd" /></td>
						<td><b>装柜结束时间：</b><fmt:formatDate value="${deliverPlan.zgjssj}" pattern="yyyy-MM-dd" /></td>
						<td></td>
					</tr>	
				</table>
			</div>
			<h5 class="header blue" style="margin-top: 4px;">出货信息</h5>
			<div class="row" style="margin: 0px 8px; width: 100%; overflow: scroll;">
				<table class="table table-bordered" style="width: 1800px;" id="zhjh-table">
		         	 <tr>
						<th>走货计划单号</th>
						<th>销售组织</th>
						<th>业务组</th>
						<th>销售员</th>
						<th>预走货制单人</th>
						<th>预走货单号</th>
						<th>预走货时间</th>
						<th>预走货类型</th>
						<th>客户名称</th>
						<th>客户编码</th>
						<th>订单号</th>
						<th>走货方式</th>
						<th>机型</th>
						<th>销往国家</th>
						<th>贸易条款</th>
						<th>数量</th>
						<th>单价</th>
						<th>金额</th>
						<th>币种</th>
						<th>预计验货日期</th>
						<th>装柜开始日期</th>
						<th>装柜结束日期</th>
						<th>截关期</th>
						<th>预计开船期</th>
						<th>截放行条时间</th>
						<th>开船时间</th>
						<th>开船月</th>
						<th>起运港</th>
						<th>出货状态</th>
						<th>用柜总柜数</th>
						<th>20GP</th>
						<th>40GP</th>
						<th>40HQ</th>
						<th>用柜备注</th>
						<th>吨车总数</th>
						<th>3吨车数</th>
						<th>5吨车数</th>
						<th>8吨车数</th>
						<th>10吨车数</th>
						<th>12吨车数</th>
						<th>吨车备注</th>
						<th>船贷公司</th>
						<th>出运类型</th>
						<th>目的港</th>
						<th>截重时间</th>
						<th>截补料时间</th>
						<th>公司名称</th>
					</tr>
					<c:forEach items="${deliverPlan.deliverPlanItemList}" var="item">
						<tr>
							<td>${item.zhjhdh}</td>
							<td>${item.xszzmc}</td>
							<td>${item.ywzmc}</td>
							<td>${item.xsymc}</td>
							<td>${item.zdrmc}</td>
							<td>${item.yzhdh}</td>
							<td>${item.yzhsj}</td>
							<%-- <td><fmt:formatDate value="${item.yzhsj}" pattern="yyyy-MM-dd" /></td> --%>
							<td>${item.yzhlxmc}</td>
							<td>${item.khmc}</td>
							<td>${item.khbm}</td>
							<td>${item.ddid}</td>
							<td>${item.zhfsmc}</td>
							<td>${item.jixing}</td>
							<td>${item.xwgjmc}</td>
							<td>${item.mytkmc}</td>
							<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
							<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
							<td>${item.bz}</td>
							<%-- <td><fmt:formatDate value="${item.yjyhrq}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.zgkssj}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.zgjssj}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.jgq}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.yjkcq}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.jfxtsj}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.kcsj}" pattern="yyyy-MM-dd" /></td> --%>
							<td>${item.yjyhrq}</td>
							<td>${item.zgkssj}</td>
							<td>${item.zgjssj}</td>
							<td>${item.jgq}</td>
							<td>${item.yjkcq}</td>
							<td>${item.jfxtsj}</td>
							<td>${item.kcsj}</td>
							<td>${item.kcy}</td>
							<td>${item.qygmc}</td>
							<td>${item.chzt}</td>
							<td align="right"><fmt:formatNumber value="${item.ygZgs}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.yg20gp}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.yg40gp}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.yg40hq}" pattern="#,##0"/></td>
							<td>${item.ygGsbz}</td>
							<td align="right"><fmt:formatNumber value="${item.dcZcs}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.dc3d}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.dc5d}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.dc8d}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.dc10d}" pattern="#,##0"/></td>
							<td align="right"><fmt:formatNumber value="${item.dc12d}" pattern="#,##0"/></td>
							<td>${item.dcDcbz}</td>
							<td>${item.cdgsmc}</td>
							<td>${item.cylxmc}</td>
							<td>${item.mdg}</td>
							<%-- <td><fmt:formatDate value="${item.jcsj}" pattern="yyyy-MM-dd" /></td>
							<td><fmt:formatDate value="${item.jblsj}" pattern="yyyy-MM-dd" /></td> --%>
							<td>${item.jcsj}</td>
							<td>${item.jblsj}</td>
							<td>${item.gsbm}</td>
						</tr>
					</c:forEach>
	         	</table>
			</div>
		</div><!-- /.col -->
	</div><!-- /.row -->
</div>
</body>
<script type="text/javascript">
	$(function($) {
		$(".skyradio").prop("disabled","disabled");
		// 返回
		$('#btn-back').click(function() {
			window.history.back(-1);
		});
		//合并单元格
		merge(0,47,"zhjh-table");
		
	});
	function merge(min_Col,max_Col,tableId) {
		            var tab = document.getElementById(tableId); //要合并的tableID
		            var maxCol = max_Col, val, count, start,yzhdh_before;  //maxCol：合并单元格作用到多少列  
		            if (tab != null) {
		                for (var col = maxCol - 1; col >= min_Col; col--) {
		                    count = 1;
		                    val = "";
		                    yzhdh_before = "";//预走货单号
		                    for (var i = 0; i < tab.rows.length; i++) {
		                        if (val == tab.rows[i].cells[col].innerHTML && yzhdh_before == tab.rows[i].cells[5].innerHTML) {//预走货单号校验
		                            count++;
		                        } else {
		                            if (count > 1) { //合并
		                                start = i - count;
		                                tab.rows[start].cells[col].rowSpan = count;
		                                for (var j = start + 1; j < i; j++) {
		                                    tab.rows[j].cells[col].style.display = "none";
		                                }
		                                count = 1;
		                            }
		                            val = tab.rows[i].cells[col].innerHTML;
		                            yzhdh_before = tab.rows[i].cells[5].innerHTML;//
		                        }
		                    }
		                    if (count > 1) { //合并，最后几行相同的情况下
		                        start = i - count;
		                        tab.rows[start].cells[col].rowSpan = count;
		                        for (var j = start + 1; j < i; j++) {
		                            tab.rows[j].cells[col].style.display = "none";
		                        }
		                    }
		                }
		            }
		        };
	
	

</script>
</html>