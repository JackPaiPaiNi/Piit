<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<style type="text/css">
		body{
			background: #fff !important;
		}
		.edit_page{
			width: 756px;
			margin: 0 auto;
			font-family: Bookman Old Style;
			font-size: 12px;
		}
		table{
			width: 100%;
		}
		table td{
			padding: 5px;
		}
		.edit_table tr:FIRST-CHILD td, .edit_table tr:FIRST-CHILD th{
			border-top: 1px solid #000;
		}
		.edit_table tr td:FIRST-CHILD, .edit_table tr th:FIRST-CHILD{
			border-left: 1px solid #000;
		}
		.edit_table td,.edit_table th{
			border-bottom: 1px solid #000;
			border-right: 1px solid #000;
			word-wrap : break-word;
			word-break : break-all;
		}
		.align_left{
			text-align: left;
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
		.print_lable{
			width: 100%;
			float: left;
			color: blue; 
			font-size: 15px; 
			font-weight: bold; 
			background-color: #AAAAAA;
		}
	</style>
	<%
		String sfBg = request.getParameter("sfBg");
		String sfApprove = request.getParameter("sfApprove");
		String processInstanceId = request.getParameter("processId");
		String sfView = request.getParameter("sfView");
		pageContext.setAttribute("sfBg", sfBg);
		pageContext.setAttribute("sfApprove", sfApprove);
		pageContext.setAttribute("processInstanceId", processInstanceId);
		pageContext.setAttribute("sfView", sfView);
	%>
</head>
<body>
<div class="edit_page">
	<div style="text-align: center;">
		<input type="hidden" name="id" value="${artoem.id}" />
		<input type="hidden" name="bbh" value="${artoem.bbh}" />
		<input type="hidden" name="zt" value="${artoem.zt}" />
		<input type="hidden" name="sjc" value="${artoem.sjc}" /> 
		<input type="hidden" name="sfBg" value="${artoem.sfBg}" />
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td style="font-size: 22px;"><b>外&nbsp;销&nbsp;美&nbsp;工&nbsp;任&nbsp;务&nbsp;单</b></td>
			</tr>
			<tr align="right">
				<td>
					<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
						<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
							<i class="fa-file-image-o icon-on-right bigger-110"></i>
							流程图
						</button>
						&nbsp;
					</c:if>
					<c:if test="${sfApprove != 1}">
						<c:if test="${artoem.zt == '4' || artoem.zt == '5'}">
							<button id="btn-print" type="button" class="btn btn-light btn-sm">
								<i class="icon-print icon-on-right bigger-110"></i>
								打印
							</button>
						</c:if>
					</c:if>
				</td>
			</tr>
		</table>
		<table class="edit_table" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="4" style="font-size: 14px; text-align: left;">基本信息</th>
			</tr>
			<tr>
				<td style="width: 15%;">任务单号</td>
				<td class="align_left" style="width: 35%;">${artoem.rwdh}</td>
				<td style="width: 15%;">制单人</td>
				<td class="align_left" style="width: 35%;">${artoem.zdrmc}</td>
			</tr>
			<tr>
				<td>文件编号</td>
				<td class="align_left">${artoem.wjbh}</td>
				<td>制单日期</td>
				<td class="align_left"><fmt:formatDate value="${artoem.zdsj}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>销售员</td>
				<td class="align_left">${artoem.xsymc}</td>
				<td>业务组</td>
				<td class="align_left">${artoem.xszzmc} - ${artoem.ywzmc}</td>
			</tr>
			<tr>
				<td>PID</td>
				<td class="align_left">${artoem.pid}</td>
				<td>产品颜色标准</td>
				<td class="align_left">${artoem.wkysbz}</td>
			</tr>
			<tr>
				<td>客户名称</td>
				<td class="align_left">${artoem.khmc}</td>
				<td>买家型号</td>
				<td class="align_left">${artoem.khxh}</td>
			</tr>
			<tr>
				<td>品牌</td>
				<td class="align_left">${artoem.khpp}</td>
				<td>销往国家</td>
				<td class="align_left">${artoem.xwgjmc}</td>
			</tr>
			<tr>
				<td>走货方式</td>
				<td class="align_left">${artoem.zhfsmc}</td>
				<td>认证要求</td>
				<td class="align_left" colspan="3">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzWu == 1}">checked="checked"</c:if>>无&nbsp;
		    		<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzCe == 1}">checked="checked"</c:if>>能效&nbsp;
			    	<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzCb == 1}">checked="checked"</c:if>>CB&nbsp;
			      	<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzEtl == 1}">checked="checked"</c:if>>ETL&nbsp;
			      	<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzFcc == 1}">checked="checked"</c:if>>FCC&nbsp;<br>
			      	<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzDb == 1}">checked="checked"</c:if>>杜比&nbsp;
			      	<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzDts == 1}">checked="checked"</c:if>>DTS&nbsp;
			      	<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzHdmi == 1}">checked="checked"</c:if>>HDMI&nbsp;
			      	<input type="checkbox" class="skycheckbox" <c:if test="${artoem.rzQt == 1}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.rzQtBz}
				</td>
			</tr>
			<tr>
				<td rowspan="3">品牌造型</td>
				<td class="align_left" colspan="3"><input type="radio" class="skyradio" <c:if test="${artoem.ppzx == 1}">checked="checked"</c:if>>旧</td>
			</tr>
			<tr>
				<td class="align_left" rowspan="2"><input type="radio" class="skyradio" <c:if test="${artoem.ppzx == 0}">checked="checked"</c:if>>新</td>
				<td>品牌文件格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ppwjgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ppwjgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ppwjgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>品牌文件</td>
				<td class="align_left" colspan="3">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.ppwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
		</table>
		<br>
		<table class="edit_table" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="4" style="font-size: 14px; text-align: left;">美工要求</th>
			</tr>
			<!-- ***********************************面壳/装饰件/装饰条等*********************************** -->
			<tr>
				<td style="width: 10%;" rowspan="11">1.面壳/装饰件/装饰条等</td>
				<td colspan="3" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkSfLogo == 0}">checked="checked"</c:if>>不带LOGO
				</td>
			</tr>
			<tr>
				<td style="width: 20%;" rowspan="4" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkSfLogo == 1}">checked="checked"</c:if>>带LOGO
				</td>
				<td style="width: 15%;">位置</td>
				<td class="align_left" style="width: 55%;">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoWz == 1}">checked="checked"</c:if>>居中&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoWz == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.mkLogoWzBz}
				</td>
			</tr>
			<tr>
				<td>尺寸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoCc == 1}">checked="checked"</c:if>>设计定义
					<c:if test="${artoem.mkLogoCc == 2}">&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoCc == 2}">checked="checked"</c:if>>客户指定：
					${artoem.mkLogoCcC}&nbsp;*&nbsp;${artoem.mkLogoCcK}&nbsp;&nbsp;MM
					</c:if>
				</td>
			</tr>
			<tr>
				<td>工艺</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoGy == 1}">checked="checked"</c:if>>公司标准工艺&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoGy == 2}">checked="checked"</c:if>>热烫贴牌&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoGy == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.mkLogoGyBz}
				</td>
			</tr>
			<tr>
				<td>颜色</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoYs == 1}">checked="checked"</c:if>>公司标准颜色&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkLogoYs == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.mkLogoYsBz}
				</td>
			</tr>
			<tr>
				<td rowspan="6" class="align_left">
					（非标准化项）<br>
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.mkQt == 1}">checked="checked"</c:if>>其他内容：${artoem.mkQtBz}
				</td>
				<td>位置</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtWz == 1}">checked="checked"</c:if>>左上&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtWz == 2}">checked="checked"</c:if>>右上&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtWz == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.mkQtWzBz}
				</td>
			</tr>
			<tr>
				<td>尺寸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtCc == 1}">checked="checked"</c:if>>设计定义
					<c:if test="${artoem.mkQtCc == 2}">&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtCc == 2}">checked="checked"</c:if>>客户指定：
					${artoem.mkQtCcC}&nbsp;*&nbsp;${artoem.mkQtCcK}&nbsp;&nbsp;MM
					</c:if>
				</td>
			</tr>
			<tr>
				<td>工艺</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtGy == 1}">checked="checked"</c:if>>同公司标准LOGO工艺&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtGy == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.mkQtGyBz}
				</td>
			</tr>
			<tr>
				<td>颜色</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtYs == 1}">checked="checked"</c:if>>同公司标准LOGO颜色&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtYs == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.mkQtYsBz}
				</td>
			</tr>
			<tr>
				<td>客供其他内容的文件格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtKgwjgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtKgwjgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.mkQtKgwjgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供其他内容的文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.mkQtKgwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<!-- ***********************************遥控器*********************************** -->
			<tr>
				<td rowspan="12">2.遥控器</td>
				<td colspan="3" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqSfLogo == 0}">checked="checked"</c:if>>不带LOGO
				</td>
			</tr>
			<tr>
				<td rowspan="4" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqSfLogo == 1}">checked="checked"</c:if>>带LOGO
				</td>
				<td>位置</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.ykqLogoWz == 1}">checked="checked"</c:if>>居中
				</td>
			</tr>
			<tr>
				<td>尺寸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqLogoCc == 1}">checked="checked"</c:if>>设计定义
					<c:if test="${artoem.ykqLogoCc == 2}">&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqLogoCc == 2}">checked="checked"</c:if>>客户指定：
					${artoem.ykqLogoCcC}&nbsp;*&nbsp;${artoem.ykqLogoCcK}&nbsp;&nbsp;MM
					</c:if>
				</td>
			</tr>
			<tr>
				<td>工艺</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqLogoGy == 1}">checked="checked"</c:if>>丝印&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqLogoGy == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.ykqLogoGyBz}
				</td>
			</tr>
			<tr>
				<td>颜色</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqLogoYs == 1}">checked="checked"</c:if>>黑色底材，LOGO颜色 PANTONE Cool Gray 7C<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqLogoYs == 2}">checked="checked"</c:if>>白色底材，LOGO颜色 PANTONE Cool Gray 425C<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqLogoYs == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.ykqLogoYsBz}
				</td>
			</tr>
			<tr>
				<td rowspan="6" class="align_left">
					（非标准化项）<br>
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.ykqQt == 1}">checked="checked"</c:if>>其他内容：${artoem.ykqQtBz}
				</td>
				<td>位置</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtWz == 1}">checked="checked"</c:if>>居中
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtWz == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.ykqQtWzBz}
				</td>
			</tr>
			<tr>
				<td>尺寸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtCc == 1}">checked="checked"</c:if>>设计定义
					<c:if test="${artoem.ykqQtCc == 2}">&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtCc == 2}">checked="checked"</c:if>>客户指定：
					${artoem.ykqQtCcC}&nbsp;*&nbsp;${artoem.ykqQtCcK}&nbsp;&nbsp;MM
					</c:if>
				</td>
			</tr>
			<tr>
				<td>工艺</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtGy == 1}">checked="checked"</c:if>>丝印&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtGy == 2}">checked="checked"</c:if>>加贴纸&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtGy == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.ykqQtGyBz}
				</td>
			</tr>
			<tr>
				<td>颜色</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtYs == 1}">checked="checked"</c:if>>黑色底材，LOGO颜色 PANTONE Cool Gray 7C<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtYs == 2}">checked="checked"</c:if>>白色底材，LOGO颜色 PANTONE Cool Gray 425C<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtYs == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.ykqQtYsBz}
				</td>
			</tr>
			<tr>
				<td>客供其他内容的文件格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtKgwjgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtKgwjgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.ykqQtKgwjgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供其他内容的文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.ykqQtKgwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.sfYkq == 1}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************说明书*********************************** -->
			<tr>
				<td rowspan="16">3.说明书</td>
				<td colspan="3" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsLx == 1}">checked="checked"</c:if>>标准电子版说明书 + 纸质快速操作指南
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsLx == 2}">checked="checked"</c:if>>纸质说明书
				</td>
			</tr>
			<tr>
				<td rowspan="4" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.smsYz == 1}">checked="checked"</c:if>>单语种装订
				</td>
				<td>语种</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzYz == 1}">checked="checked"</c:if>>繁体中文&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzYz == 2}">checked="checked"</c:if>>英文&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzYz == 3}">checked="checked"</c:if>>阿拉伯文&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzYz == 4}">checked="checked"</c:if>>俄文<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzYz == 5}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.smsYzYzBz}
				</td>
			</tr>
			<tr>
				<td>尺寸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzCc == 1}">checked="checked"</c:if>>A5尺寸&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzCc == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.smsYzCcBz}
				</td>
			</tr>
			<tr>
				<td>印刷颜色</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzYsys == 1}">checked="checked"</c:if>>封面内页均黑白单色印刷<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzYsys == 2}">checked="checked"</c:if>>封面彩色，内页黑白印刷<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzYsys == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.smsYzYsysBz}
				</td>
			</tr>
			<tr>
				<td>材质及装订方式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzCz == 1}">checked="checked"</c:if>>封面内页均80G双胶纸，书本形式骑马钉装钉<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzCz == 2}">checked="checked"</c:if>>封面120G铜版纸,内页80G双胶纸，书本形式骑马钉装钉<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsYzCz == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.smsYzCzBz}
				</td>
			</tr>
			<tr>
				<td rowspan="4" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.smsDyz == 1}">checked="checked"</c:if>>多语种，合本装订
				</td>
				<td>语种及排序</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzYz == 1}">checked="checked"</c:if>>英文+西班牙文&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzYz == 2}">checked="checked"</c:if>>英文+阿拉伯文<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzYz == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.smsDyzYzBz}
				</td>
			</tr>
			<tr>
				<td>尺寸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzCc == 1}">checked="checked"</c:if>>A5尺寸&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzCc == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.smsDyzCcBz}
				</td>
			</tr>
			<tr>
				<td>印刷颜色</td>
				<td class="align_left">	
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzYsys == 1}">checked="checked"</c:if>>封面内页均黑白单色印刷<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzYsys == 2}">checked="checked"</c:if>>封面彩色,内页黑白印刷<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzYsys == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.smsDyzYsysBz}
				</td>
			</tr>
			<tr>
				<td>材质及装订方式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzCz == 1}">checked="checked"</c:if>>封面内页均80G双胶纸,书本形式骑马钉装订<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzCz == 2}">checked="checked"</c:if>>封面内页均80G双胶纸,书本形式胶装<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzCz == 3}">checked="checked"</c:if>>封面120G铜版纸,内页80G双胶纸,书本形式骑马钉装订<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzCz == 4}">checked="checked"</c:if>>封面120G铜版纸,内页80G双胶纸,书本形式胶装<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.smsDyzCz == 5}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.smsDyzCzBz}
				</td>
			</tr>
			<tr>
				<td rowspan="2" class="align_left">
					（非标准化项）<br>
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.smsZsj == 1}">checked="checked"</c:if>>客供部分素材，需要再设计
				</td>
				<td>客供素材格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsZsjKgscgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsZsjKgscgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsZsjKgscgs == 3}">checked="checked"</c:if>>PDF&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsZsjKgscgs == 4}">checked="checked"</c:if>>WORD
				</td>
			</tr>
			<tr>
				<td>客供素材文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.smsZsjKgscwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td rowspan="2" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.smsBkg == 1}">checked="checked"</c:if>>客供资料,不可修改
				</td>
				<td>客供资料格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsBkgKgzlgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsBkgKgzlgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsBkgKgzlgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供资料文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.smsBkgKgzlwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td colspan="2" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.smsWc == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
				</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.smsSqbh == 1}">checked="checked"</c:if>>需要申请编号&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.smsSqbh == 0}">checked="checked"</c:if>>不需要申请编号
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.sfSms == 1}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************底座安装说明*********************************** -->
			<tr>
				<td rowspan="5">4.底座安装说明</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.dzazsmYz == 1}">checked="checked"</c:if>>英文
				</td>
				<td rowspan="2">材质及印刷方式</td>
				<td class="align_left" rowspan="2">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.dzazsmYs == 1}">checked="checked"</c:if>>80G双胶纸单页印刷
				</td>
			</tr>
			<tr>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.dzazsmYz == 2}">checked="checked"</c:if>>其他语种&nbsp;&nbsp;${artoem.dzazsmYzBz}
				</td>
			</tr>
			<tr>
				<td colspan="2" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.dzazsmWc == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
				</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.dzazsmSqbh == 1}">checked="checked"</c:if>>需要申请编号&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.dzazsmSqbh == 0}">checked="checked"</c:if>>不需要申请编号
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.dzazsmNr == 1}">checked="checked"</c:if>>内容加入说明书或快速操作指南
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.sfDzazsm == 1}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************纸箱*********************************** -->
			<tr>
				<td rowspan="11">5.纸箱</td>
				<td colspan="3" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxLx == 1}">checked="checked"</c:if>>牛皮卡通箱&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxLx == 2}">checked="checked"</c:if>>白皮卡通箱&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxLx == 3}">checked="checked"</c:if>>彩盒
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxSjbz == 1}">checked="checked"</c:if>>标准设计1&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxSjbz == 2}">checked="checked"</c:if>>标准设计2&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxSjbz == 3}">checked="checked"</c:if>>标准设计3
				</td>
			</tr>
			<tr>
				<td rowspan="2" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxSjbz == 4}">checked="checked"</c:if>>客供资料,不可修改
				</td>
				<td>客供资料格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxBkgKgzlgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxBkgKgzlgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxBkgKgzlgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供资料文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.zxBkgKgzlwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td rowspan="5" class="align_left">
					（非标准化项）<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.zxSjbz == 5}">checked="checked"</c:if>>客供部分素材，需要再设计
				</td>
				<td rowspan="3">文字信息</td>
				<td class="align_left">
					系列名：${artoem.zxZsjXlm}
				</td>
			</tr>
			<tr>
				<td class="align_left">
					特点功能：${artoem.zxZsjTdgn}
				</td>
			</tr>
			<tr>
				<td class="align_left">
					其他：${artoem.zxZsjQt}
				</td>
			</tr>
			<tr>
				<td>客供素材格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxZsjKgscgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxZsjKgscgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxZsjKgscgs == 3}">checked="checked"</c:if>>PDF&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxZsjKgscgs == 4}">checked="checked"</c:if>>PSD&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxZsjKgscgs == 5}">checked="checked"</c:if>>其他&nbsp;
				</td>
			</tr>
			<tr>
				<td>客供素材文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.zxZsjKgscwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td colspan="2" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.zxWc == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
				</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxSqbh == 1}">checked="checked"</c:if>>需要申请编号&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxSqbh == 0}">checked="checked"</c:if>>不需要申请编号
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.sfZx == 1}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************纸箱贴纸 *********************************** -->
			<tr>
				<td rowspan="10">6.纸箱贴纸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzZlbz == 1}">checked="checked"</c:if>>标准资料
				</td>
				<td>条码号</td>
				<td class="align_left">${artoem.zxtzBzzlTmh}</td>
			</tr>
			<tr>
				<td rowspan="2" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzZlbz == 2}">checked="checked"</c:if>>客供资料,不可修改
				</td>
				<td>客供资料格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzBkgKgzlgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzBkgKgzlgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzBkgKgzlgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供资料文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.zxtzBkgKgzlwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td rowspan="5" class="align_left">
					（非标准化项）<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzZlbz == 3}">checked="checked"</c:if>>客供部分素材，需要再设计
				</td>
				<td rowspan="3">文字信息</td>
				<td class="align_left">
					条码号：${artoem.zxtzZsjTmh}
				</td>
			</tr>
			<tr>
				<td class="align_left">
					产地信息：${artoem.zxtzZsjCdxx}
				</td>
			</tr>
			<tr>
				<td class="align_left">
					其他：${artoem.zxtzZsjQt}
				</td>
			</tr>
			<tr>
				<td>客供素材格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzZsjKgscgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzZsjKgscgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzZsjKgscgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供素材文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.zxtzZsjKgscwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td colspan="2" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.zxtzWc == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
				</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzSqbh == 1}">checked="checked"</c:if>>需要申请编号&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zxtzSqbh == 0}">checked="checked"</c:if>>不需要申请编号
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.sfZxtz == 1}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************后盖贴纸 *********************************** -->
			<tr>
				<td rowspan="11">7.后盖贴纸</td>
				<td class="align_left" rowspan="3">
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzZlbz == 1}">checked="checked"</c:if>>标准资料
				</td>
				<td rowspan="3">基本信息</td>
				<td class="align_left">
					进口商信息：${artoem.hgtzBzzlJksxx}
				</td>
			</tr>
			<tr>
				<td class="align_left">
					制造商信息：${artoem.hgtzBzzlZzsxx}
				</td>
			</tr>
			<tr>
				<td class="align_left">
					产地信息：${artoem.hgtzBzzlCdxx}
				</td>
			</tr>
			<tr>
				<td rowspan="2" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzZlbz == 2}">checked="checked"</c:if>>客供资料,不可修改
				</td>
				<td>客供资料格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzBkgKgzlgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzBkgKgzlgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzBkgKgzlgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供资料文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.hgtzBkgKgzlwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td rowspan="4" class="align_left">
					（非标准化项）<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzZlbz == 3}">checked="checked"</c:if>>客供部分素材，需要再设计
				</td>
				<td rowspan="2">文字信息</td>
				<td class="align_left">
					产地信息：${artoem.hgtzZsjCdxx}
				</td>
			</tr>
			<tr>
				<td class="align_left">
					其他：${artoem.hgtzZsjQt}
				</td>
			</tr>
			<tr>
				<td>客供素材格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzZsjKgscgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzZsjKgscgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzZsjKgscgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供素材文件</td>
				<td class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.hgtzZsjKgscwj == 1}">checked="checked"</c:if>>已与此需求单同时提供
				</td>
			</tr>
			<tr>
				<td colspan="2" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.hgtzWc == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
				</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzSqbh == 1}">checked="checked"</c:if>>需要申请编号&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.hgtzSqbh == 0}">checked="checked"</c:if>>不需要申请编号
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.sfHgtz == 1}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************能效贴纸 *********************************** -->
			<tr>
				<td rowspan="3">8.能效贴纸</td>
				<td class="align_left"><input type="radio" class="skyradio" <c:if test="${artoem.sfNxtz == 1}">checked="checked"</c:if>>需要</td>
				<td>用量及粘贴位置</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.nxtzYlWz == 1}">checked="checked"</c:if>>1个用量，粘贴于电视屏幕的左上角<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.nxtzYlWz == 2}">checked="checked"</c:if>>2个用量，1个粘贴于电视屏幕的左上角，1个粘贴于纸箱指定位置<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.nxtzYlWz == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.nxtzYlWzBz}
				</td>
			</tr>
			<tr>
				<td colspan="2" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.nxtzWc == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
				</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.nxtzSqbh == 1}">checked="checked"</c:if>>需要申请编号&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.nxtzSqbh == 0}">checked="checked"</c:if>>不需要申请编号
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.sfNxtz == 0}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************保证卡*********************************** -->
			<tr>
				<td rowspan="7">9.保证卡</td>
				<td colspan="3" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkZlbz == 1}">checked="checked"</c:if>>标准资料
				</td>
			</tr>
			<tr>
				<td rowspan="4" class="align_left">
					（非标准化项）<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkZlbz == 2}">checked="checked"</c:if>>客供资料,不可修改
				</td>
				<td>客供资料格式</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgKgzlgs == 1}">checked="checked"</c:if>>AI&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgKgzlgs == 2}">checked="checked"</c:if>>CDR&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgKgzlgs == 3}">checked="checked"</c:if>>PDF
				</td>
			</tr>
			<tr>
				<td>客供资料材质印刷要求</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgCzysyq == 1}">checked="checked"</c:if>>128G哑粉纸，彩色印刷<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgCzysyq == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.bzkBkgCzysyqBz}
				</td>
			</tr>
			<tr>
				<td>客供资料装钉要求</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgZdyq == 1}">checked="checked"</c:if>>单页&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgZdyq == 2}">checked="checked"</c:if>>折叠形式&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgZdyq == 3}">checked="checked"</c:if>>书本形式，骑马钉装订&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgZdyq == 4}">checked="checked"</c:if>>其他&nbsp;${artoem.bzkBkgZdyqBz}
				</td>
			</tr>
			<tr>
				<td>客供资料文件</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgKgzlwj == 1}">checked="checked"</c:if>>已与此需求单同时提供&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkBkgKgzlwj == 2}">checked="checked"</c:if>>资料已提供，同&nbsp;${artoem.bzkBkgKgzlwjBz}
				</td>
			</tr>
			<tr>
				<td colspan="2" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.bzkWc == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
				</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkSqbh == 1}">checked="checked"</c:if>>需要申请编号&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.bzkSqbh == 0}">checked="checked"</c:if>>不需要申请编号
				</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.sfBzk == 1}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************整机序号贴纸*********************************** -->
			<tr>
				<td rowspan="6">10.整机序号贴纸</td>
				<td rowspan="2" class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzXhbz == 1}">checked="checked"</c:if>>公司标准序列号
				</td>
				<td>尺寸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzGsbzCc == 1}">checked="checked"</c:if>>45*15MM&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzGsbzCc == 2}">checked="checked"</c:if>>25*6MM
				</td>
			</tr>
			<tr>
				<td>用量及粘贴位置</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzGsbzYljztwz == 1}">checked="checked"</c:if>>3个用量，贴于后壳、纸箱1侧和保证卡上<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzGsbzYljztwz == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.zjxhtzGsbzYljztwzBz}
				</td>
			</tr>
			<tr>
				<td rowspan="3" class="align_left">
					（非标准化项）<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzXhbz == 2}">checked="checked"</c:if>>客供序列号：${artoem.zjxhtzXhbzKgxh}
				</td>
				<td>尺寸</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzKgCc == 1}">checked="checked"</c:if>>45*15MM&nbsp;
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzKgCc == 2}">checked="checked"</c:if>>25*6MM<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzKgCc == 3}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.zjxhtzKgCcBz}
				</td>
			</tr>
			<tr>
				<td>用量及粘贴位置</td>
				<td class="align_left">
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzKgYljztwz == 1}">checked="checked"</c:if>>3个用量，贴于后壳、纸箱1侧和保证卡上<br>
					<input type="radio" class="skyradio" <c:if test="${artoem.zjxhtzKgYljztwz == 2}">checked="checked"</c:if>>其他&nbsp;&nbsp;${artoem.zjxhtzKgYljztwzBz}
				</td>
			</tr>
			<tr>
				<td>材质等特殊要求</td>
				<td class="align_left">${artoem.zjxhtzKgCzdtsyq}</td>
			</tr>
			<tr>
				<td colspan="3" class="align_left">
					<input type="checkbox" class="skycheckbox" <c:if test="${artoem.sfZjxhtz == 1}">checked="checked"</c:if>>不需要
				</td>
			</tr>
			<!-- ***********************************其他美工要求*********************************** -->
			<tr>
				<td>11.其他美工要求</td>
				<td class="align_left" colspan="3"><PRE class="pre">${artoem.mgqtyq}</PRE></td>
			</tr>
			<tr>
				<td>附件</td>
				<c:set var="fj" value="${artoem.fj}"/>
				<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
				<td class="align_left" colspan="3">${fn:replace(fjxx,'red', '')}</td>
			</tr>
			<tr>
	        	<td>&nbsp;&nbsp;美工组件号</td>
				<td class="align_left" colspan="3">${artoem.mgzjh}</td>
			</tr>
		</table>
		<c:if test="${artoem.sfBg == 1 || artoem.bbh != 1}">
			<br>
			<table class="edit_table" cellspacing="0" cellpadding="0">
				<tr>
					<th colspan="4" style="font-size: 14px; text-align: left;">需求变更单</th>
				</tr>
				<tr>
					<td style="width: 15%;" rowspan="3">是否已量产</td>
					<td colspan="3" class="align_left" style="width: 85%;">
						<input type="radio" class="skyradio" <c:if test="${artoem.bgSflc == 0}">checked="checked"</c:if>>否
					</td>
				</tr>
				<tr>
					<td class="align_left" rowspan="2">
						<input type="radio" class="skyradio" <c:if test="${artoem.bgSflc == 1}">checked="checked"</c:if>>是
					</td>
					<td class="align_left" colspan="2" >
						<input type="radio" class="skyradio" <c:if test="${artoem.bgSflcValue == 1}">checked="checked"</c:if>>
						暂无量产订单,从此变更通知发出开始更改
					</td>
				</tr>
				<tr>
					<td class="align_left" colspan="2">
						<input type="radio" class="skyradio" <c:if test="${artoem.bgSflcValue == 2}">checked="checked"</c:if>>
						从&nbsp;<span style="text-decoration: underline;">${artoem.bgLcksddh}</span>订单开始更改
					</td>
				</tr>
				<tr>
					<td style="width: 15%;">变更申请人</td>
					<td class="align_left" style="width: 35%;">${artoem.bgSqrmc}</td>
					<td>变更申请时间</td>
					<td class="align_left"><fmt:formatDate value="${artoem.bgSqsj}" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td>变更内容</td>
					<td class="align_left" colspan="3"><PRE class="pre">${artoem.bgNr}</PRE></td>
				</tr>
				<tr>
					<td>变更原因</td>
					<td class="align_left" colspan="3"><PRE class="pre">${artoem.bgYy}</PRE></td>
				</tr>
			</table>
		</c:if>
		<c:if test="${sfView == 1 && artoem.bbh > 1}">
		<br>
		<table class="edit_table" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="5" style="font-size: 13px; text-align: left;">变更历史</th>
			</tr>
			<tr>
				<th style="width:40%">任务单号</th>
				<th style="width:10%">版本号</th>
				<th style="width:15%">状态</th>
				<th style="width:15%">制单人</th>
				<th style="width:20%">操作时间</th>
			</tr>
			<c:forEach items="${artoem.htylist}" var="item">
				<tr>
					<td><a style="cursor: pointer;" onclick="javascript:showRWD('${item.rwdh}','${item.bbh}');">${item.rwdh}</a></td>
					<td>${item.bbh}</td>
					<td>${item.ztmc}</td>
					<td>${item.zdrmc}</td>
					<td><fmt:formatDate value="${item.zdsj}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<br>
		<label class="print_lable"  onclick="javascript:showOrHideSplog();">审批日志（隐藏或显示）</label>
		<table id="print_table_div" class="edit_table" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="8" style="font-size: 13px; text-align: left;">评审日志</th>
			</tr>
			<tr>
				<th style="width:5%">版本号</th>
				<th style="width:10%">操作类型</th>
				<th style="width:10%">操作职位</th>
				<th style="width:20%">操作人账号</th>
				<th style="width:20%">操作人名称</th>
				<th style="width:10%">操作时间</th>
				<th style="width:15%">处理意见</th>
			</tr>
			<c:forEach items="${artoem.logList}" var="item">
				<tr>
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
	<br><br><br>
</div>
</body>
<script type="text/javascript">
var splog=false;
	$(function($){
		$(".skycheckbox").prop("disabled","disabled");
		$(".skyradio").prop("disabled","disabled");
		//打印
		$("#btn-print").click(function(){
			window.open("<c:url value='/art/oem/printPage'/>?id=" + $("input[name='id']").val());
		})
		// 查看流程
		$("#btn-flow").click(function(){
			bootbox.dialog({
				title : "流程图",
				className : "dialog",
				message : "<img style='width:100%;' src=\"<c:url value='/base/bpm/genBpmImage'/>?processInstanceId=<%=processInstanceId%>\" />"
			});
		});
	});
	
	//打开任务单查看页面
	function showRWD(rwdh,bbh){
		var url = "" ;
    	//大货
		url = "<c:url value='/art/oem/showPage'/>" + "?rwdh=" + rwdh + "&bbh=" + bbh + "&sfView=0";
		if(url.length >  0){
			 window.open(url); 
		} 
	}
	
	function showOrHideSplog(){
		if(splog){
			$("#print_table_div").show();
			splog = false;
		}else{
			$("#print_table_div").hide();
			splog = true;
		}
	}
</script>
</html>