<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String id = request.getParameter("id");
		String fplx = request.getParameter("fplx");
		pageContext.setAttribute("id", id);
		pageContext.setAttribute("fplx", fplx);
	%>
<style type="text/css">
	html{
		position:static;
	}
	table{
			width: 100%;
		}
	table td{
		padding: 5px;
	}
	.hh td,.hh th{
		word-wrap : break-word;
		word-break : break-all;
	}
</style>
</head>
<body>
<div class="page-content">
	<h5 class="header blue" style="margin-top:4px;"><label id="mk"></label></h5>
	<div class="row">
		<div class="col-xs-12">
			<input type="hidden" name="id" value="${id}"/>
			<input type="hidden" name="fplx" value="${fplx}"/>
			<!-- PAGE CONTENT BEGINS -->
			<table class="table table-bordered hh">
				<tr>
					<th style="width: 16%">发票号</th>
					<th style="width: 10%">出货单号</th>
					<th style="width: 9%">订单号</th>
					<th style="width: 10%">SAP发票号</th>
					<th style="width: 9%">SAP发票金额</th>
					<th style="width: 5%">推送状态</th>
					<th style="width: 18%">推送返回消息</th>
					<th style="width: 5%">冲销状态</th>
					<th style="width: 18%">冲销返回消息</th>
				</tr>
				<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.fph}</td>
					<td>${item.chdh}</td>
					<td>${item.ddid}</td>
					<td>${item.sapfph}</td>
					<td align="right"><fmt:formatNumber value="${item.sapfpje}" pattern="#,#00.00" /></td>
					<td>${item.result}</td>
					<td>${item.msg}</td>
					<td>${item.sfCx}</td>
					<td>${item.cxmsg}</td>
				</tr>
				</c:forEach>
			</table>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	<!-- <h5 class="header blue" style="margin-top:4px;">返回日志</h5>
	<div class="row">
		<div class="col-xs-12">
			<label id="msg"></label>
		</div>
	</div> -->
</div>
<!-- /.page-content -->
</body>
 <script type="text/javascript">
	var isEdit = false;
	$(function($) {
		var fplx = $("input[name='fplx']").val();
		var mk = "";
		if(fplx == "1"){
			mk = "销售发票";
		}else if (fplx == "2"){
			mk = "公司间发票";
		}else{
			mk = "";
		}
		$("#mk").html("发票对照表("+mk+")");
		/* $.bindAjax({
			url:"<c:url value='/log/sapInterfaceLog/search'/>",
			data:{id:$("input[name='id']").val(),fplx:mk},
			action:"search"
		},function(response){
			if(response[0]){
				$("#msg").html(response[0].fhxx);
			}
		}); */
	});

</script> 
</html>