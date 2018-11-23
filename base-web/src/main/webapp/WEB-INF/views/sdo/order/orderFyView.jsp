<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String sfApprove = request.getParameter("sfApprove");
		String processInstanceId = request.getParameter("processId");
		pageContext.setAttribute("sfApprove", sfApprove);
		pageContext.setAttribute("processInstanceId", processInstanceId);
	%>
	<style type="text/css">
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
		.pre{
			background-color:#ffffff;
			border:0px solid #ffffff;
			padding :0px;
			font-size : 14px;
			font-family:"Open Sans","Helvetica Neue",Helvetica,Arial,sans-serif;
			/* float:left; */
		}
		.hh td,.hh th{
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
				<input type="hidden" name="id" value="${orderFy.id}"/><!-- 订单id -->
				<input type="hidden" name="sjc" value="${orderFy.sjc}"/>
				<input type="hidden" name="sfMf" value="${orderFy.sfMf}"/>
				<input type="hidden" name="ddlx" value="${orderFy.ddlx}"/>
				<input type="hidden" name="sfCh" value="${orderFy.sfCh}"/>
				<input type="hidden" name="gsbm" value="${orderFy.gsbm}"/>
				<input type="hidden" name="ddlb" value="${orderFy.ddlb}"/>
				<input type="hidden" name="yddid" value=" "/>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>订单号：</b>${orderFy.ddid}</td>
						<td style="width: 55%"><b>是否免费：</b>
							<input type="radio" class="skyradio" <c:if test="${orderFy.sfMf == 1}">checked="checked"</c:if>>是
							<input type="radio" class="skyradio" <c:if test="${orderFy.sfMf == 0}">checked="checked"</c:if>>否
						</td>
						<td style="width: 20%">
							<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
								<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
									<i class="fa-file-image-o icon-on-right bigger-110"></i>
									流程图
								</button>
								&nbsp;
							</c:if>
							<c:if test="${sfApprove != 1}">
								<c:if test="${orderFy.zt == '4' || orderFy.zt == '5'}">
									<button id="btn-print" type="button" class="btn btn-light btn-sm">
										<i class="icon-print icon-on-right bigger-110"></i>
										打印
									</button>
									&nbsp;
								</c:if>
								<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
									返回
								</button>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
		
			<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>生产基地：</b>${orderFy.scjdmc}</td>
						<td style="width: 25%"><b>公司：</b>${orderFy.gsbm}-${orderFy.gsmc}</td>
						<td style="width: 25%"><b>订单类型：</b>${orderFy.ddlxmc}</td>
						<td style="width: 25%"><b>订单状态：</b>${orderFy.ztmc}</td>
					</tr>
					<tr>
						<td><b>订单类别：</b>${orderFy.ddlbmc}</td>
						<td><b>业务类型：</b>${orderFy.ywlxmc}</td>
						<td><b>制单人：</b>${orderFy.zdrmc}</td>
						<td><b>制单日期：</b><fmt:formatDate value="${orderFy.zdsj}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>销售员：</b>${orderFy.xsymc}</td>
						<td><b>业务组：</b>${orderFy.ywzmc}</td>
						<td><b>销售组织：</b>${orderFy.xszzmc}</td>
						<td><b>版本号：</b>${orderFy.bbh}</td>
					</tr>
				</table>
			</div>

			<h5 class="header blue" style="margin-top:4px;">基本信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>走货方式：</b>${orderFy.zhfsmc}</td>
						<td style="width: 25%"><b>交货日期：</b><fmt:formatDate value="${orderFy.jhrq}" pattern="yyyy-MM-dd"/></td>
						<td style="width: 50%" colspan="2"><b>国际贸易条款：</b>${orderFy.gjmytkmc}&nbsp;&nbsp;${orderFy.gjmytkbz}</td>
					</tr>
					<tr>
						<td><b>付款条件：</b>${orderFy.fktjmc}</td>
						<td><b>币种：</b>${orderFy.bz}</td>
						<td colspan="2">
							<b>是否验货：</b>
							<c:choose>
							   <c:when test="${orderFy.sfYh == '0'}">否
							   </c:when>
							   <c:when test="${orderFy.sfYh == '1'}">是 
							   </c:when>
							</c:choose> 
							&nbsp;&nbsp;
							${orderFy.sfyhbz}</td>
					</tr>
					<tr>
						<td><b>PID：</b>${orderFy.pid}</td>
						<td><b>验货日期：</b><fmt:formatDate value="${orderFy.yhrq}" pattern="yyyy-MM-dd"/></td>
						<td><b>渠道：</b>${orderFy.qdmc}</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			
			<h5 class="header blue" style="margin-top:4px;">客户信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 20%"><b>客户名称：</b>${orderFy.khmc}</td>
						<td style="width: 25%"><b>客户编码：</b>${orderFy.khbm}</td>
						<td style="width: 25%"><b>销往国家：</b>${orderFy.xwgjmc}</td>
						<td style="width: 30%"><b>时区：</b>${orderFy.sq}</td>
					</tr>
					<tr>
						<td><b>品牌：</b>${orderFy.pp}</td>
						<td><b>出厂语言：</b>${orderFy.ccyymc}</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			
			<h5 class="header blue" style="margin-top:4px;">产品信息</h5>
			 <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>操作类型</th>
						<th>PI号</th>
						<th>产品类型</th>
						<th>物料编号</th>
						<th>我司型号</th>
						<th>客户型号</th>
						<th>中文描述</th>
						<th>英文描述</th>
						<th>数量</th>
						<shiro:hasPermission name="order:orderFy:price">
						<th>单价</th>
						<th>金额</th>
						</shiro:hasPermission>
						<th>免费数量</th>
					</tr>
					<c:forEach items="${orderFy.orderFyItemList}" var="item">
						<tr>
							<td>${item.flagmc}</td>
							<td>${item.piid}</td>
							<td>${item.cplxmc}</td>
							<td>${item.wlbh}</td>
							<td>${item.model}</td>
							<td>${item.khxh}</td>
							<td>${item.wlzwms}</td>
							<td>${item.khxhms}</td>
							<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
							<shiro:hasPermission name="order:orderFy:price">
							<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
							<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
							</shiro:hasPermission>
							<td align="right"><fmt:formatNumber value="${item.mfsl}" pattern="#,##0"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<h5 class="header blue" style="margin-top:4px;">备注信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td><PRE class="pre"><b>备注：</b>${orderFy.bzxx}</PRE></td>
					</tr>
					<tr>
						<td><PRE class="pre"><b>变更信息备注：</b>${orderFy.bgbz}</PRE></td>
					</tr>
					<tr>
						<%-- <td><b>附件：</b>${orderFy.fj}</td> --%>
						<c:set var="fj" value="${orderFy.fj}"/>
						<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
						<td><b>附件：</b></td>
						<td>${fn:replace(fjxx,'red', '')}</td>
					</tr>
				</table>
			</div>
			
			<h5 class="header blue" style="margin: 0; padding: 0;">付款保障检查情况</h5>
			<div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<label id="fkbzrz"></label>
			</div>
			<h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
			 <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered hh">
					<tr>
						<th style="width:10%">订单号</th>
						<th style="width:5%">版本号</th>
						<th style="width:10%">操作类型</th>
						<th style="width:10%">操作职位</th>
						<th style="width:20%">操作人账号</th>
						<th style="width:20%">操作人名称</th>
						<th style="width:10%">操作时间</th>
						<th style="width:15%">处理意见</th>
					</tr>
					<c:forEach items="${orderFy.logList}" var="item">
						<tr>
							<td>${item.ddid}</td>
							<td>${item.bbh}</td>
							<td>${item.czlx}</td>
							<td>${item.czzw}</td>
							<td>${item.czr}</td>
							<td>${item.czrmc}</td>
							<td><fmt:formatDate value="${item.czrj}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${item.nr}</td>
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
	$(function($){
		$(".skyradio").prop("disabled","disabled");
		// 打印
		$("#btn-print").click(function(){
			window.open("<c:url value='/order/orderFy/printPage'/>?id=" + $("input[name='id']").val());
		});
		// 查看流程
		$("#btn-flow").click(function(){
			bootbox.dialog({
				title : "流程图",
				message : "<img src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
		// 返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		
		$.bindAjax({
			url:"<c:url value='/payment/payValidate/search'/>",
			data:{id : "${orderFy.id}" },
			action:"search"
		},function(response){
			if(response[0]){
				$("#fkbzrz").html(response[0].zy);
			}else{
				$("#fkbzrz").html('无');
			}
		});
	});
</script>
</html>