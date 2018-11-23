<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %> 
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
		.dialog .modal-dialog{
			width:1100px;
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
				<input type="hidden" name="id" value="${orderSpo.id}"/><!-- 订单id -->
				<input type="hidden" name="sjc" value="${orderSpo.sjc}"/>
				<input type="hidden" name="xszz" value="${orderSpo.xszz}"/>
				<input type="hidden" name="ddlx" value="${orderSpo.ddlx}"/>
				<input type="hidden" name="zje" value="${orderSpo.zje}"/>
				<input type="hidden" name="gsbm" value="${orderSpo.gsbm}"/>
				<input type="hidden" name="sfBg" value="${orderSpo.sfBg}"/>
				<input type="hidden" name="wlje" value="${orderSpo.wlje}"/>
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>订单号：</b>${orderSpo.ddid}</td>
						<td style="width: 25%"><b>订单类别：</b>${orderSpo.ddlbmc}</td>
						<td style="width: 30%"><b>是否传制造：</b>
							<input type="radio" class="skyradio" <c:if test="${orderSpo.sfCzz == 1}">checked="checked"</c:if>>是
							<input type="radio" class="skyradio" <c:if test="${orderSpo.sfCzz == 0}">checked="checked"</c:if>>否
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
								<button id="btn-print" type="button" class="btn btn-light btn-sm">
									<i class="icon-print icon-on-right bigger-110"></i>
									打印
								</button>
								&nbsp;
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
						<td style="width: 25%"><b>生产基地：</b>${orderSpo.scjdmc}</td>
						<td style="width: 25%"><b>公司：</b>${orderSpo.gsbm}-${orderSpo.gsmc}</td>
						<td style="width: 25%"><b>订单类型：</b>${orderSpo.ddlxmc}</td>
						<td style="width: 25%"><b>订单状态：</b>${orderSpo.ztmc}</td>
					</tr>
					<tr>
						<td><b>客户编码：</b>${orderSpo.khbm}</td>
						<td><b>客户名称：</b>${orderSpo.khmc}</td>
						<td><b>制单人：</b>${orderSpo.zdrmc}</td>
						<td><b>制单日期：</b><fmt:formatDate value="${orderSpo.zdsj}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>付款条件：</b>${orderSpo.fktjmc}</td>
						<td><b>是否免费：</b>
							<input type="radio" class="skyradio" <c:if test="${orderSpo.sfMf == 1}">checked="checked"</c:if>>是
							<input type="radio" class="skyradio" <c:if test="${orderSpo.sfMf == 0}">checked="checked"</c:if>>否
						</td>
						<td><b>责任划分：</b>${orderSpo.zrhfmc}</td>
						<td><b>客诉编号：</b>${orderSpo.ksbh}</td>
					</tr>
					<tr>
						<td><b>版本号：</b>${orderSpo.bbh}</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</div>
			
			<h5 class="header blue" style="margin-top:4px;">基本信息</h5>
			<div class="row" style="margin: 0px 8px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td style="width: 25%"><b>销售员：</b>${orderSpo.xsymc}</td>
						<td style="width: 25%"><b>业务组：</b>${orderSpo.ywzmc}</td>
						<td style="width: 25%"><b>销售组织：</b>${orderSpo.xszzmc}</td>
						<td style="width: 25%"><b>交货日期：</b><fmt:formatDate value="${orderSpo.jhrq}" pattern="yyyy-MM-dd"/></td>
					</tr>
					<tr>
						<td><b>业务类型：</b>${orderSpo.ywlxmc}</td>
						<td><b>出运类型：</b>${orderSpo.cylxmc}</td>
						<td><b>币种：</b>${orderSpo.bz}</td>
						<td><b>销往国家：</b>${orderSpo.xwgjmc}</td>
					</tr>
					<tr>
						<td><b>装运/起运港：</b>${orderSpo.zygmc}</td>
						<td><b>费用承担部门：</b>${orderSpo.fycdbmmc}</td>
						<td colspan="2"><b>国际贸易条款：</b>${orderSpo.gjmytkmc}&nbsp;&nbsp;${orderSpo.gjmytkbz}</td>
					</tr>
					<tr>
						<td ><b>渠道：</b>${orderSpo.qdmc}</td>
						<td ><b>电视机类型：</b>${orderSpo.dsjlxmc}</td>
						<td >&nbsp;</td>
						<td >&nbsp;</td>
					</tr>
					<tr>
						<c:set var="fj" value="${orderSpo.fj}"/>
						<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
						<td><b>附件：</b></td>
						<td>${fn:replace(fjxx,'red', '')}</td>
						<td >&nbsp;</td>
						<td >&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><PRE class="pre"><b>免费补料原因：</b>${orderSpo.mfblyy}</PRE></td>
						<td colspan="2"><PRE class="pre"><b>备注：</b>${orderSpo.bzxx}</PRE></td>
					</tr>
					<tr>
						<td colspan="4"><PRE class="pre"><b>变更信息备注：</b>${orderSpo.bgbz}</PRE></td>
					</tr>
					<tr>
						<c:set var="gcbfj" value="${orderSpo.gcbfj}"/>
						<c:set var="fjxx" value="${fn:replace(gcbfj,'icon-remove', 'fa fa-file')}"/>
						<td><b>工程部附件：</b></td>
						<td>${fn:replace(fjxx,'red', '')}</td>
						<td >&nbsp;</td>
						<td >&nbsp;</td>
					</tr>
				</table>
			</div>
			
			<h5 class="header blue" style="margin-top:4px;">物料清单</h5>
			  <div class="space-4"></div>
			<div class="row" style="margin: 0px 8px;">
				<table class="table table-bordered">
					<tr>
						<th>PI号</th>
						<th>操作类型</th>
						<!-- <th>物料类型</th> -->
						<th>物料编码</th>
						<th>物料描述</th>
						<th>币种</th>
						<th>数量</th>
						<th>单位</th>
						<shiro:hasPermission name="order:orderSpo:price">
						<th>单价（含税）</th>
						<th>金额</th>
						</shiro:hasPermission>
						<th>参考订单</th>
						<th>机型</th>
						<th>机芯</th>
					</tr>
					<c:forEach items="${orderSpo.orderSpoItemList}" var="item">
						<tr>
							<td>${item.piid}</td>
							<td>${item.flagmc}</td>
							<%-- <td>${item.wllxmc}</td> --%>
							<td>${item.wlbh}</td>
							<td>${item.wlms}</td>
							<td>${item.bz}</td>
							<td align="right"><fmt:formatNumber value="${item.sl}" pattern="#,##0"/></td>
							<td>${item.dw}</td>
							<shiro:hasPermission name="order:orderSpo:price">
							<td align="right"><fmt:formatNumber value="${item.dj}" pattern="#,##0.000000"/></td>
							<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.000000"/></td>
							</shiro:hasPermission>
							<td>${item.ckddh}</td>
							<td>${item.jixing}</td>
							<td>${item.jixin}</td>
						</tr>
					</c:forEach>
						<tr>
							<td><b>合计</b></td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td><b>总数量</b></td>
							<td align="right"><b><fmt:formatNumber value="${orderSpo.zsl}" pattern="#,##0"/></b></td>
							<td><b>总金额</b></td>
							<shiro:hasPermission name="order:orderSpo:price">
							<td>&nbsp;</td>
							<td align="right"><b><fmt:formatNumber value="${orderSpo.zje}" pattern="#,##0.000000"/></b></td>
							</shiro:hasPermission>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
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
								<c:forEach items="${orderSpo.logList}" var="item">
									<tr>
										<td>${item.ddid}</td>
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
			window.open("<c:url value='/order/orderSpo/printPage'/>?id=" + $("input[name='id']").val());
		});
		// 查看流程
		$("#btn-flow").click(function(){
			bootbox.dialog({
				title : "流程图",
				className : "dialog",
				message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
		// 返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		
		$.bindAjax({
			url:"<c:url value='/payment/payValidate/search'/>",
			data:{id : "${orderSpo.id}" },
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