<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>

</head>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<div class="space-4"></div>
					<!--PI付款保障关联信息 -->
					<div class="row">
						<div class="col-xs-12 col-sm-9">
							<table class="table table-bordered">
								<tr>
									<th>PI号</th>
									<th>客户编码</th>
									<th>客户名称</th>
									<th>付款条件</th>
									<th>总金额</th>
									<th>币种</th>
								</tr>
								<tr>
									<td>${pibind.piid}</td>
									<td>${pibind.khbm}</td>
									<td>${pibind.khmc}</td>
									<td>${pibind.fktjmc}</td>
									<td><fmt:formatNumber value="${pibind.zje}" pattern="#,#00.00" /></td>
									<td>${pibind.bz}</td>
								</tr>	
							</table>
						</div>
						<div class="col-xs-6 col-sm-3">
							&nbsp;
							<button id="btn-back" type="button" class="btn btn-xs">
								<i class="icon-undo icon-on-right"></i>
								返回
							</button>
						</div>
					</div>
					<h4 class="header blue" style="margin-top:4px;">T/T要求</h4>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-9">
							<table class="table table-bordered">
								<tr>
									<th>下单前要求金额</th>
									<th>占总金额的比例</th>
									<th>出库前要求金额</th>
									<th>占总金额的比例</th>
									<th>已绑定定金金额</th>
									<th>还需绑定金额</th>
									<th>已使用金额</th>
									<th>未使用定金额</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${pibind.tt_xdyq}" pattern="#,#00.00" /></td>
									<td>
									<fmt:formatNumber value="${pibind.tt_xdzb}" type="percent"/>
									</td>
									<td><fmt:formatNumber value="${pibind.tt_ckyq}" pattern="#,#00.00" /></td>
									<td>
									<fmt:formatNumber value="${pibind.tt_ckzb}" type="percent"/>
									</td>
									<td><fmt:formatNumber value="${pibind.tt_ybdje}" pattern="#,#00.00" /></td>
									<td><fmt:formatNumber value="${pibind.tt_hxbdje}" pattern="#,#00.00" /></td>
									<td><fmt:formatNumber value="${pibind.tt_ysyje}" pattern="#,#00.00" /></td>
									<td><fmt:formatNumber value="${pibind.tt_wsyje}" pattern="#,#00.00" /></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-8">
							<table class="table table-bordered">
								<tr>
									<th>认领单号</th>
									<th>剩余额度</th>
									<th>币种</th>
									<th>本次使用额度</th>
									<th>汇率</th>
									<th>PI币种</th>
									<th>本次使用额度（PI币种）</th>
								</tr>
								<c:forEach items="${pibind.tt_xxlist}" var="item">
									<tr>
										<td>${item.rldh}</td>
										<td><fmt:formatNumber value="${item.syed}" pattern="#,#00.0000" /></td>
										<td>${item.edbz}</td>
										<td><fmt:formatNumber value="${item.edje}" pattern="#,#00.0000" /></td>
										<td><fmt:formatNumber value="${item.ydEdHl}" pattern="#,##0.000000000" /></td>
										<td>${item.bz}</td>
										<td><fmt:formatNumber value="${item.je}" pattern="#,#00.0000" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<h4 class="header blue" style="margin-top:4px;">L/C要求</h4>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-6 col-sm-6">
							<table class="table table-bordered">
								<tr>
									<th>L/C要求金额</th>
									<th>占总金额的比例</th>
									<th>已绑定金额</th>
									<th>还需绑定金额</th>
									<th>是否满足要求</th>
									<th>已使用金额</th>
									<th>未使用金额</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${pibind.lc_yq}" pattern="#,#00.00" /></td>
									<td>
									<fmt:formatNumber value="${pibind.lc_zb}" type="percent"/>
									</td>
									<td><fmt:formatNumber value="${pibind.lc_ybd}" pattern="#,#00.00" /></td>
									<td><fmt:formatNumber value="${pibind.lc_hxbd}" pattern="#,#00.00" /></td>
									<td>${pibind.lc_sfmzyq}</td>
									<td><fmt:formatNumber value="${pibind.lc_ysyje}" pattern="#,#00.00" /></td>
									<td><fmt:formatNumber value="${pibind.lc_wsyje}" pattern="#,#00.00" /></td>
								</tr>
							</table>
						</div>
					</div>
					
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-9">
							<table class="table table-bordered">
								<tr>
									<th>LC编号</th>
									<th>剩余额度</th>
									<th>开户行</th>
									<th>币种</th>
									<th>本次使用额度</th>
									<th>汇率</th>
									<th>PI币种</th>
									<th>本次使用额度（PI币种）</th>
								</tr>
								<c:forEach items="${pibind.lc_xxlist}" var="item">
									<tr>
										<td>${item.lcbh}</td>
										<td><fmt:formatNumber value="${item.syed}" pattern="#,#00.0000" /></td>
										<td>${item.kzh}</td>
										<td>${item.edbz}</td>
										<td><fmt:formatNumber value="${item.edje}" pattern="#,#00.0000" /></td>
										<td><fmt:formatNumber value="${item.ydEdHl}" pattern="#,##0.000000000" /></td>
										<td>${item.bz}</td>
										<td><fmt:formatNumber value="${item.je}" pattern="#,#00.0000" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
					<h4 class="header blue" style="margin-top:4px;">信用额度要求</h4>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-3 col-sm-3">
							<table class="table table-bordered">
								<tr>
									<th>O/A要求金额</th>
									<th>占总金额的比例</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${pibind.oa_yq}" pattern="#,#00.00" /></td>
									<td>
									<fmt:formatNumber value="${pibind.oa_zb}" type="percent"/>
									</td>
								</tr>
							</table>
						</div>
						<div class="col-xs-3 col-sm-3">
							<table class="table table-bordered">
								<tr>
									<th>D/P要求金额</th>
									<th>占总金额的比例</th>
								</tr>
								<tr>
									<td><fmt:formatNumber value="${pibind.dp_yq}" pattern="#,#00.00" /></td>
									<td>
									<fmt:formatNumber value="${pibind.dp_zb}" type="percent"/>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
$(function($){
	$("#btn-back").click(function(){
		window.history.back(-1);
    });
});
</script>
</html>