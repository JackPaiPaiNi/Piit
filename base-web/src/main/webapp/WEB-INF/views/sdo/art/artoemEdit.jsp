<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
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
	</style>
	<%
		String id = request.getParameter("id");
		String taskId = request.getParameter("taskId");
		String sfBg = request.getParameter("sfBg");
		String sfFz = request.getParameter("sfFz");
		pageContext.setAttribute("sfBg", sfBg);
	%>
</head>
<body>
<div class="edit_page">
	<div style="text-align: center;">
		<form id="form-submit">
			<input type="hidden" name="id" />
			<input type="hidden" name="bbh" />
			<input type="hidden" name="oper" /> 
			<input type="hidden" name="zt" />
			<input type="hidden" name="sjc" /> 
			<input type="hidden" name="sfBg"/>
			<input type="hidden" name="taskId" />
			<input type="hidden" name="token" value="${token}">
			<table cellspacing="0" cellpadding="0">
				<tr>
					<td style="width: 70%; font-size: 22px;"><b>外&nbsp;销&nbsp;美&nbsp;工&nbsp;任&nbsp;务&nbsp;单</b></td>
					<td style="width: 30%;">
						<button id="btn-save" type="button" class="btn btn-success btn-sm">
							<i class="icon-save icon-on-right bigger-110"></i> 保存
						</button>
						&nbsp;
						<button id="btn-submit" type="button" class="btn btn-info btn-sm">
							<i class="icon-ok icon-on-right bigger-110"></i> 提交
						</button>
						&nbsp;
						<button id="btn-back" class="btn btn-sm" type="button">
							<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
					</td>
				</tr>
			</table>
			<table class="edit_table" cellspacing="0" cellpadding="0">
				<tr>
					<th colspan="4" style="font-size: 14px; text-align: left;">基本信息</th>
				</tr>
				<tr>
					<td style="width: 15%;">任务单号</td>
					<td class="align_left" style="width: 35%;">
						<input type="text" name="rwdh" class="form-control skydisabled" disabled="disabled"/>
					</td>
					<td style="width: 15%;">制单人</td>
					<td class="align_left" style="width: 35%;">
						<input type="text" name="zdrmc" class="form-control skydisabled" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td>文件编号</td>
					<td class="align_left"><input type="text" name="wjbh" class="form-control skydisabled" disabled="disabled"/></td>
					<td>制单日期</td>
					<td class="align_left">
						<div class="input-group input-group-sm">
							<input type="text" name="zdsj" class="form-control skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</td>
				</tr>
				<tr class="jbxx">
					<td>销售员</td>
					<td class="align_left">
						<div class="input-group input-group-sm">
							<input type="hidden" name="xsyid" class="form-control"/>
							<input type="text" name="xsymc" onfocus="this.blur()"
								class="form-control parent-node" style="cursor: pointer!important;" />
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</td>
					<td>业务组</td>
					<td class="align_left">
						<input type="text" name="ywzmc" class="form-control skydisabled" disabled="disabled"/>
						<input type="hidden" name="ywz" />
						<input type="hidden" name="xszz" />
						<input type="hidden" name="xszzmc" />
					</td>
				</tr>
				<tr class="jbxx">
					<td>PID</td>
					<td class="align_left">
						<div class="input-group input-group-sm">
							<input type="text" name="pid" onfocus="this.blur()" class="form-control parent-node"/>
							<input type="hidden" name="jixing" />
							<input type="hidden" name="jixin" />
							<input type="hidden" name="oldJixing" />
							<input type="hidden" name="oldJixin" />
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</td>
					<td>产品颜色标准</td>
					<td class="align_left">
						<select role="select" name="wkysbz" size="1" class="form-control skyselect">
							${fns:loadDictOption('WKYSBZ')}
						</select>
					</td>
				</tr>
				<tr>
					<td>客户名称</td>
					<td class="align_left">
						<div class="input-group input-group-sm">
							<input type="hidden" name="khbm" />
							<input type="text" id="khmc" name="khmc" onfocus="this.blur()" class="form-control  parent-node"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</td>
					<td>买家型号</td>
					<td class="align_left"><input type="text" name="khxh" class="form-control"/></td>
				</tr>
				<tr class="jbxx">
					<td>品牌</td>
					<td class="align_left"><input type="text" name="khpp" class="form-control"/></td>
					<td>销往国家</td>
					<td class="align_left">
						<input type="text" name="xwgj" class="form-control"/>
					</td>
				</tr>
				<tr class="jbxx">
					<td>版本</td>
					<td class="align_left">
						<select role="select" name="vbbh" size="1" class="form-control skyselect">
							${fns:loadDictOption('ART_VBBH')}
						</select>
					</td>
					<td>产品经理</td>
					<td class="align_left">
						<input type="hidden" name="cpjlmc" />
						<input type="text" name="cpjl" class="form-control"/>
					</td>
				</tr>
				<tr>
					<td>走货方式</td>
					<td class="align_left">
					    <select role="select" name="zhfs" size="1" class="form-control skyselect">
							${fns:loadDictOption('PI_ZHFS')}
						</select>
					</td>
					<td>认证要求</td>
					<td class="align_left">
						<input type="checkbox" class="skycheckbox" name="rzWu" value="1" checked="checked">无&nbsp;
			    		<input type="checkbox" class="skycheckbox" name="rzCe" value="1">能效&nbsp;
				    	<input type="checkbox" class="skycheckbox" name="rzCb" value="1">CB&nbsp;
				      	<input type="checkbox" class="skycheckbox" name="rzEtl" value="1">ETL&nbsp;
				      	<input type="checkbox" class="skycheckbox" name="rzFcc" value="1">FCC&nbsp;<br>
				      	<input type="checkbox" class="skycheckbox" name="rzDb" value="1">杜比&nbsp;
				      	<input type="checkbox" class="skycheckbox" name="rzDts" value="1">DTS&nbsp;
				      	<input type="checkbox" class="skycheckbox" name="rzHdmi" value="1">HDMI&nbsp;<br>
				      	<input type="checkbox" class="skycheckbox" name="rzQt" value="1">其他<input type="text" class="radio-inline skydisabled" disabled="disabled" name="rzQtBz" />
					</td>
				</tr>
				<tr>
					<td rowspan="3">品牌造型</td>
					<td class="align_left" colspan="3">
						<input type="radio" class="skyradio" name="ppzx" value="1" checked="checked">旧
					</td>
				</tr>
				<tr>
					<td class="align_left" rowspan="2">
						<input type="radio" class="skyradio" name="ppzx" value="0">新
					</td>
					<td>品牌文件格式</td>
					<td class="align_left">
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="ppwjgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="ppwjgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="ppwjgs" value="3">PDF
					</td>
				</tr>
				<tr>
					<td>品牌文件</td>
					<td class="align_left" colspan="3"><input type="checkbox" class="skycheckbox skydisabled" disabled="disabled" name="ppwj" value="1">已与此需求单同时提供</td>
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
					<td colspan="3" class="align_left"><input type="radio" class="skyradio" name="mkSfLogo" value="0">不带LOGO</td>
				</tr>
				<tr class="mkzsjzstd">
					<td style="width: 20%;" rowspan="4" class="align_left">
						<input type="radio" class="skyradio" name="mkSfLogo" value="1" checked="checked">带LOGO
					</td>
					<td style="width: 15%;">位置</td>
					<td class="align_left" style="width: 55%;">
						<input type="radio" class="skyradio" name="mkLogoWz" value="1" checked="checked">居中&nbsp;
						<input type="radio" class="skyradio" name="mkLogoWz" value="2">其他<input type="text" name="mkLogoWzBz" />
					</td>
				</tr>
				<tr class="mkzsjzstd">
					<td>尺寸</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="mkLogoCc" value="1" checked="checked">设计定义&nbsp;
						<input type="radio" class="skyradio" name="mkLogoCc" value="2">客户指定：
						<input type="text" name="mkLogoCcC" style="width: 50px;" />*<input type="text" name="mkLogoCcK" style="width: 50px;" />MM
					</td>
				</tr>
				<tr class="mkzsjzstd">
					<td>工艺</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="mkLogoGy" value="1" checked="checked">公司标准工艺&nbsp;
						<input type="radio" class="skyradio" name="mkLogoGy" value="2">热烫贴牌&nbsp;
						<input type="radio" class="skyradio" name="mkLogoGy" value="3">其他<input type="text" name="mkLogoGyBz" />
					</td>
				</tr>
				<tr class="mkzsjzstd">
					<td>颜色</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="mkLogoYs" value="1" checked="checked">公司标准颜色&nbsp;
						<input type="radio" class="skyradio" name="mkLogoYs" value="2">其他<input type="text" name="mkLogoYsBz" />
					</td>
				</tr>
				<tr class="mkzsjzstd mkfbzh">
					<td rowspan="6" class="align_left">
						（非标准化项）<br>
						<input type="checkbox" class="skycheckbox" name="mkQt" value="1">其他内容：<input type="text" name="mkQtBz" />
					</td>
					<td>位置</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="mkQtWz" value="1">左上&nbsp;
						<input type="radio" class="skyradio" name="mkQtWz" value="2">右上&nbsp;
						<input type="radio" class="skyradio" name="mkQtWz" value="3">其他<input type="text" name="mkQtWzBz" />
					</td>
				</tr>
				<tr class="mkzsjzstd mkfbzh">
					<td>尺寸</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="mkQtCc" value="1">设计定义&nbsp;
						<input type="radio" class="skyradio" name="mkQtCc" value="2">客户指定：
						<input type="text" name="mkQtCcC" style="width: 50px;" />*<input type="text" name="mkQtCcK" style="width: 50px;" />MM
					</td>
				</tr>
				<tr class="mkzsjzstd mkfbzh">
					<td>工艺</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="mkQtGy" value="1">同公司标准LOGO工艺&nbsp;
						<input type="radio" class="skyradio" name="mkQtGy" value="2">其他<input type="text" name="mkQtGyBz" />
					</td>
				</tr>
				<tr class="mkzsjzstd mkfbzh">
					<td>颜色</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="mkQtYs" value="1">同公司标准LOGO颜色&nbsp;
						<input type="radio" class="skyradio" name="mkQtYs" value="2">其他<input type="text" name="mkQtYsBz" />
					</td>
				</tr>
				<tr class="mkzsjzstd mkfbzh">
					<td>客供其他内容的文件格式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="mkQtKgwjgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="mkQtKgwjgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="mkQtKgwjgs" value="3">PDF
					</td>
				</tr>
				<tr class="mkzsjzstd mkfbzh">
					<td>客供其他内容的文件</td>
					<td class="align_left">
						<input type="checkbox" class="skycheckbox" name="mkQtKgwj" value="1">已与此需求单同时提供
					</td>
				</tr>
				<!-- ***********************************遥控器*********************************** -->
				<tr class="ykq">
					<td rowspan="12">2.遥控器</td>
					<td colspan="3" class="align_left"><input type="radio" class="skyradio" name="ykqSfLogo" value="0">不带LOGO</td>
				</tr>
				<tr class="ykq">
					<td rowspan="4" class="align_left"><input type="radio" class="skyradio" name="ykqSfLogo" value="1" checked="checked">带LOGO</td>
					<td>位置</td>
					<td class="align_left">
						<input type="checkbox" class="skycheckbox" name="ykqLogoWz" value="1" checked="checked">居中
					</td>
				</tr>
				<tr class="ykq">
					<td>尺寸</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="ykqLogoCc" value="1" checked="checked">设计定义&nbsp;
						<input type="radio" class="skyradio" name="ykqLogoCc" value="2">客户指定：
						<input type="text" name="ykqLogoCcC" style="width: 50px;" />*<input type="text" name="ykqLogoCcK" style="width: 50px;" />MM
					</td>
				</tr>
				<tr class="ykq">
					<td>工艺</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="ykqLogoGy" value="1" checked="checked">丝印&nbsp;
						<input type="radio" class="skyradio" name="ykqLogoGy" value="2">其他<input type="text" name="ykqLogoGyBz" />
					</td>
				</tr>
				<tr class="ykq">
					<td>颜色</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="ykqLogoYs" value="1" checked="checked">黑色底材，LOGO颜色 PANTONE Cool Gray 7C<br>
						<input type="radio" class="skyradio" name="ykqLogoYs" value="2">白色底材，LOGO颜色 PANTONE Cool Gray 425C<br>
						<input type="radio" class="skyradio" name="ykqLogoYs" value="3">其他<input type="text" name="ykqLogoYsBz" />
					</td>
				</tr>
				<tr class="ykq ykqfbzh">
					<td rowspan="6" class="align_left">
						（非标准化项）<br>
						<input type="checkbox" class="skycheckbox" name="ykqQt" value="1">其他内容：<input type="text" name="ykqQtBz" />
					</td>
					<td>位置</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="ykqQtWz" value="1">居中
						<input type="radio" class="skyradio" name="ykqQtWz" value="2">其他<input type="text" name="ykqQtWzBz" />
					</td>
				</tr>
				<tr class="ykq ykqfbzh">
					<td>尺寸</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="ykqQtCc" value="1">设计定义&nbsp;
						<input type="radio" class="skyradio" name="ykqQtCc" value="2">客户指定：
						<input type="text" name="ykqQtCcC" style="width: 50px;" />*<input type="text" name="ykqQtCcK" style="width: 50px;" />MM
					</td>
				</tr>
				<tr class="ykq ykqfbzh">
					<td>工艺</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="ykqQtGy" value="1">丝印&nbsp;
						<input type="radio" class="skyradio" name="ykqQtGy" value="2">加贴纸&nbsp;
						<input type="radio" class="skyradio" name="ykqQtGy" value="3">其他<input type="text" name="ykqQtGyBz" />
					</td>
				</tr>
				<tr class="ykq ykqfbzh">
					<td>颜色</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="ykqQtYs" value="1">黑色底材，LOGO颜色 PANTONE Cool Gray 7C<br>
						<input type="radio" class="skyradio" name="ykqQtYs" value="2">白色底材，LOGO颜色 PANTONE Cool Gray 425C<br>
						<input type="radio" class="skyradio" name="ykqQtYs" value="3">其他<input type="text" name="ykqQtYsBz" />
					</td>
				</tr>
				<tr class="ykq ykqfbzh">
					<td>客供其他内容的文件格式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="ykqQtKgwjgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="ykqQtKgwjgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="ykqQtKgwjgs" value="3">PDF
					</td>
				</tr>
				<tr class="ykq ykqfbzh">
					<td>客供其他内容的文件</td>
					<td class="align_left">
						<input type="checkbox" class="skycheckbox" name="ykqQtKgwj" value="1">已与此需求单同时提供
					</td>
				</tr>
				<tr>
					<td colspan="3" class="align_left"><input type="checkbox" class="skycheckbox" name="sfYkq" value="1">不需要</td>
				</tr>
				<!-- ***********************************说明书*********************************** -->
				<tr class="sms">
					<td rowspan="16">3.说明书</td>
					<td colspan="3" class="align_left">
						<input type="radio" class="skyradio" name="smsLx" value="1" checked="checked">标准电子版说明书 + 纸质快速操作指南
					</td>
				</tr>
				<tr class="sms">
					<td colspan="3" class="align_left">
						<input type="radio" class="skyradio" name="smsLx" value="2">纸质说明书
					</td>
				</tr>
				<tr class="sms smsyz">
					<td rowspan="4" class="align_left">
						<input type="checkbox" class="skycheckbox" name="smsYz" value="1" checked="checked">单语种装订
					</td>
					<td>语种</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsYzYz" value="1">繁体中文&nbsp;
						<input type="radio" class="skyradio" name="smsYzYz" value="2" checked="checked">英文&nbsp;
						<input type="radio" class="skyradio" name="smsYzYz" value="3">阿拉伯文&nbsp;
						<input type="radio" class="skyradio" name="smsYzYz" value="4">俄文<br>
						<input type="radio" class="skyradio" name="smsYzYz" value="5">其他<input type="text" name="smsYzYzBz" />
					</td>
				</tr>
				<tr class="sms smsyz">
					<td>尺寸</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsYzCc" value="1" checked="checked">A5尺寸&nbsp;
						<input type="radio" class="skyradio" name="smsYzCc" value="2">其他<input type="text" name="smsYzCcBz" />
					</td>
				</tr>
				<tr class="sms smsyz">
					<td>印刷颜色</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsYzYsys" value="1" checked="checked">封面内页均黑白单色印刷<br>
						<input type="radio" class="skyradio" name="smsYzYsys" value="2">封面彩色,内页黑白印刷<br>
						<input type="radio" class="skyradio" name="smsYzYsys" value="3">其他<input type="text" name="smsYzYsysBz" />
					</td>
				</tr>
				<tr class="sms smsyz">
					<td>材质及装订方式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsYzCz" value="1" checked="checked">封面内页均80G双胶纸，书本形式骑马钉装钉<br>
						<input type="radio" class="skyradio" name="smsYzCz" value="2">封面120G铜版纸,内页80G双胶纸，书本形式骑马钉装钉<br>
						<input type="radio" class="skyradio" name="smsYzCz" value="3">其他<input type="text" name="smsYzCzBz" />
					</td>
				</tr>
				<tr class="sms smsdyz">
					<td rowspan="4" class="align_left"><input type="checkbox" class="skycheckbox" name="smsDyz" value="1">多语种，合本装订</td>
					<td>语种及排序</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsDyzYz" value="1">英文+西班牙文&nbsp;
						<input type="radio" class="skyradio" name="smsDyzYz" value="2">英文+阿拉伯文<br>
						<input type="radio" class="skyradio" name="smsDyzYz" value="3">其他<input type="text" name="smsDyzYzBz" />
					</td>
				</tr>
				<tr class="sms smsdyz">
					<td>尺寸</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsDyzCc" value="1">A5尺寸&nbsp;
						<input type="radio" class="skyradio" name="smsDyzCc" value="2">其他<input type="text" name="smsDyzCcBz" />
					</td>
				</tr>
				<tr class="sms smsdyz">
					<td>印刷颜色</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsDyzYsys" value="1">封面内页均黑白单色印刷<br>
						<input type="radio" class="skyradio" name="smsDyzYsys" value="2">封面彩色,内页黑白印刷<br>
						<input type="radio" class="skyradio" name="smsDyzYsys" value="3">其他<input type="text" name="smsDyzYsysBz" />
					</td>
				</tr>
				<tr class="sms smsdyz">
					<td>材质及装订方式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsDyzCz" value="1">封面内页均80G双胶纸,书本形式骑马钉装订<br>
						<input type="radio" class="skyradio" name="smsDyzCz" value="2">封面内页均80G双胶纸,书本形式胶装<br>
						<input type="radio" class="skyradio" name="smsDyzCz" value="3">封面120G铜版纸,内页80G双胶纸,书本形式骑马钉装订<br>
						<input type="radio" class="skyradio" name="smsDyzCz" value="4">封面120G铜版纸,内页80G双胶纸,书本形式胶装<br>
						<input type="radio" class="skyradio" name="smsDyzCz" value="5">其他<input type="text" name="smsDyzCzBz" />
					</td>
				</tr>
				<tr class="sms smsfbzh">
					<td rowspan="2" class="align_left">
						（非标准化项）<br>
						<input type="checkbox" class="skycheckbox" name="smsZsj" value="1">客供部分素材，需要再设计
					</td>
					<td>客供素材格式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsZsjKgscgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="smsZsjKgscgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="smsZsjKgscgs" value="3">PDF&nbsp;
						<input type="radio" class="skyradio" name="smsZsjKgscgs" value="4">WORD
					</td>
				</tr>
				<tr class="sms smsfbzh">
					<td>客供素材文件</td>
					<td class="align_left">
						<input type="checkbox" class="skycheckbox" name="smsZsjKgscwj" value="1">已与此需求单同时提供
					</td>
				</tr>
				<tr class="sms smsbkg">
					<td rowspan="2" class="align_left"><input type="checkbox" class="skycheckbox" name="smsBkg" value="1">客供资料,不可修改</td>
					<td>客供资料格式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="smsBkgKgzlgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="smsBkgKgzlgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="smsBkgKgzlgs" value="3">PDF
					</td>
				</tr>
				<tr class="sms smsbkg">
					<td>客供资料文件</td>
					<td class="align_left">
						<input type="checkbox" class="skycheckbox" name="smsBkgKgzlwj" value="1">已与此需求单同时提供
					</td>
				</tr>
				<tr class="sms">
					<td colspan="2" class="align_left">
						<input type="checkbox" class="skycheckbox" name="smsWc" value="1">国外采购,只提供电子文档资料
					</td>
					<td class="align_left">
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="smsSqbh" value="1">需要申请编号&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="smsSqbh" value="0">不需要申请编号
					</td>
				</tr>
				<tr>
					<td colspan="3" class="align_left"><input type="checkbox" class="skycheckbox" name="sfSms" value="1">不需要</td>
				</tr>
				<!-- ***********************************底座安装说明*********************************** -->
				<tr class="dzazsm">
					<td rowspan="5">4.底座安装说明</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="dzazsmYz" value="1" checked="checked">英文
					</td>
					<td rowspan="2">材质及印刷方式</td>
					<td class="align_left" rowspan="2">
						<input type="checkbox" class="skycheckbox" name="dzazsmYs" value="1" checked="checked">80G双胶纸单页印刷
					</td>
				</tr>
				<tr class="dzazsm">
					<td class="align_left">
						<input type="radio" class="skyradio" name="dzazsmYz" value="2">其他语种<input type="text" name="dzazsmYzBz" style="width: 70px;" />
					</td>
				</tr>
				<tr class="dzazsm">
					<td colspan="2" class="align_left">
						<input type="checkbox" class="skycheckbox" name="dzazsmWc" value="1">国外采购,只提供电子文档资料
					</td>
					<td class="align_left">
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="dzazsmSqbh" value="1">需要申请编号&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="dzazsmSqbh" value="0">不需要申请编号
					</td>
				</tr>
				<tr class="dzazsm1">
					<td colspan="3" class="align_left">
						<input type="checkbox" class="skycheckbox" name="dzazsmNr" value="1">内容加入说明书或快速操作指南
					</td>
				</tr>
				<tr class="dzazsm2">
					<td colspan="3" class="align_left">
						<input type="checkbox" class="skycheckbox" name="sfDzazsm" value="1">不需要
					</td>
				</tr>
				<!-- ***********************************纸箱*********************************** -->
				<tr class="zx">
					<td rowspan="11">5.纸箱</td>
					<td colspan="3" class="align_left">
						<input type="radio" class="skyradio" name="zxLx" value="1" checked="checked">牛皮卡通箱&nbsp;
						<input type="radio" class="skyradio" name="zxLx" value="2">白皮卡通箱&nbsp;
						<input type="radio" class="skyradio" name="zxLx" value="3">彩盒
					</td>
				</tr>
				<tr class="zx">
					<td colspan="3" class="align_left">
						<input type="radio" class="skyradio" name="zxSjbz" value="1" checked="checked">标准设计1&nbsp;
						<input type="radio" class="skyradio" name="zxSjbz" value="2">标准设计2&nbsp;
						<input type="radio" class="skyradio" name="zxSjbz" value="3">标准设计3
					</td>
				</tr>
				<tr class="zx">
					<td rowspan="2" class="align_left"><input type="radio" class="skyradio" name="zxSjbz" value="4">客供资料,不可修改</td>
					<td>客供资料格式</td>
					<td class="align_left zxbkg">
						<input type="radio" class="skyradio" name="zxBkgKgzlgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="zxBkgKgzlgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="zxBkgKgzlgs" value="3">PDF
					</td>
				</tr>
				<tr class="zx zxbkg">
					<td>客供资料文件</td>
					<td class="align_left"><input type="checkbox" class="skycheckbox" name="zxBkgKgzlwj" value="1">已与此需求单同时提供</td>
				</tr>
				<tr class="zx">
					<td rowspan="5" class="align_left">
						（非标准化项）<br>
						<input type="radio" class="skyradio" name="zxSjbz" value="5">客供部分素材，需要再设计
					</td>
					<td rowspan="3">文字信息</td>
					<td class="align_left zxfbzh">
						系列名：<input type="text" name="zxZsjXlm" />
					</td>
				</tr>
				<tr class="zx zxfbzh">
					<td class="align_left">
						特点功能：<input type="text" name="zxZsjTdgn" />
					</td>
				</tr>
				<tr class="zx zxfbzh">
					<td class="align_left">
						其他：<input type="text" name="zxZsjQt" />
					</td>
				</tr>
				<tr class="zx zxfbzh">
					<td>客供素材格式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="zxZsjKgscgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="zxZsjKgscgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="zxZsjKgscgs" value="3">PDF&nbsp;
						<input type="radio" class="skyradio" name="zxZsjKgscgs" value="4">PSD&nbsp;
						<input type="radio" class="skyradio" name="zxZsjKgscgs" value="5">其他&nbsp;
					</td>
				</tr>
				<tr class="zx zxfbzh">
					<td>客供素材文件</td>
					<td class="align_left"><input type="checkbox" class="skycheckbox" name="zxZsjKgscwj" value="1">已与此需求单同时提供</td>
				</tr>
				<tr class="zx">
					<td colspan="2" class="align_left">
						<input type="checkbox" class="skycheckbox" name="zxWc" value="1">国外采购,只提供电子文档资料
					</td>
					<td class="align_left">
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="zxSqbh" value="1">需要申请编号&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="zxSqbh" value="0">不需要申请编号
					</td>
				</tr>
				<tr>
					<td colspan="3" class="align_left">
						<input type="checkbox" class="skycheckbox" name="sfZx" value="1">不需要
					</td>
				</tr>
				<!-- ***********************************纸箱贴纸 *********************************** -->
				<tr class="zxtz">
					<td rowspan="10">6.纸箱贴纸</td>
					<td class="align_left"><input type="radio" class="skyradio" name="zxtzZlbz" value="1" checked="checked">标准资料</td>
					<td>条码号</td>
					<td class="align_left zxtzbzzl"><input type="text" name="zxtzBzzlTmh" /></td>
				</tr>
				<tr class="zxtz">
					<td rowspan="2" class="align_left"><input type="radio" class="skyradio" name="zxtzZlbz" value="2">客供资料,不可修改</td>
					<td>客供资料格式</td>
					<td class="align_left zxtzbkg">
						<input type="radio" class="skyradio" name="zxtzBkgKgzlgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="zxtzBkgKgzlgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="zxtzBkgKgzlgs" value="3">PDF
					</td>
				</tr>
				<tr class="zxtz zxtzbkg">
					<td>客供资料文件</td>
					<td class="align_left"><input type="checkbox" class="skycheckbox" name="zxtzBkgKgzlwj" value="1">已与此需求单同时提供</td>
				</tr>
				<tr class="zxtz">
					<td rowspan="5" class="align_left">
						（非标准化项）<br>
						<input type="radio" class="skyradio" name="zxtzZlbz" value="3">客供部分素材，需要再设计
					</td>
					<td rowspan="3">文字信息</td>
					<td class="align_left zxtzfbzh">
						条码号：<input type="text" name="zxtzZsjTmh" />
					</td>
				</tr>
				<tr class="zxtz zxtzfbzh">
					<td class="align_left">
						产地信息：<input type="text" name="zxtzZsjCdxx" />
					</td>
				</tr>
				<tr class="zxtz zxtzfbzh">
					<td class="align_left">
						其他：<input type="text" name="zxtzZsjQt" />
					</td>
				</tr>
				<tr class="zxtz zxtzfbzh">
					<td>客供素材格式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="zxtzZsjKgscgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="zxtzZsjKgscgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="zxtzZsjKgscgs" value="3">PDF
					</td>
				</tr>
				<tr class="zxtz zxtzfbzh">
					<td>客供素材文件</td>
					<td class="align_left"><input type="checkbox" class="skycheckbox" name="zxtzZsjKgscwj" value="1">已与此需求单同时提供</td>
				</tr>
				<tr class="zxtz">
					<td colspan="2" class="align_left">
						<input type="checkbox" class="skycheckbox" name="zxtzWc" value="1">国外采购,只提供电子文档资料
					</td>
					<td class="align_left">
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="zxtzSqbh" value="1">需要申请编号&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="zxtzSqbh" value="0">不需要申请编号
					</td>
				</tr>
				<tr>
					<td colspan="3" class="align_left">
						<input type="checkbox" class="skycheckbox" name="sfZxtz" value="1">不需要
					</td>
				</tr>
				<!-- ***********************************后盖贴纸 *********************************** -->
				<tr class="hgtz">
					<td rowspan="11">7.后盖贴纸</td>
					<td class="align_left" rowspan="3"><input type="radio" class="skyradio" name="hgtzZlbz" value="1" checked="checked">标准资料</td>
					<td rowspan="3">基本信息</td>
					<td class="align_left hgtzbzzl">
						进口商信息：<input type="text" name="hgtzBzzlJksxx" />
					</td>
				</tr>
				<tr class="hgtz hgtzbzzl">
					<td class="align_left">
						制造商信息：<input type="text" name="hgtzBzzlZzsxx" />
					</td>
				</tr>
				<tr class="hgtz hgtzbzzl">
					<td class="align_left">
						产地信息：<input type="text" name="hgtzBzzlCdxx" />
					</td>
				</tr>
				<tr class="hgtz">
					<td rowspan="2" class="align_left"><input type="radio" class="skyradio" name="hgtzZlbz" value="2">客供资料,不可修改</td>
					<td>客供资料格式</td>
					<td class="align_left hgtzbkg">
						<input type="radio" class="skyradio" name="hgtzBkgKgzlgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="hgtzBkgKgzlgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="hgtzBkgKgzlgs" value="3">PDF
					</td>
				</tr>
				<tr class="hgtz hgtzbkg">
					<td>客供资料文件</td>
					<td class="align_left"><input type="checkbox" class="skycheckbox" name="hgtzBkgKgzlwj" value="1">已与此需求单同时提供</td>
				</tr>
				<tr class="hgtz">
					<td rowspan="4" class="align_left">
						（非标准化项）<br>
						<input type="radio" class="skyradio" name="hgtzZlbz" value="3">客供部分素材，需要再设计
					</td>
					<td rowspan="2">文字信息</td>
					<td class="align_left hgtzfbzh">
						产地信息：<input type="text" name="hgtzZsjCdxx" />
					</td>
				</tr>
				<tr class="hgtz hgtzfbzh">
					<td class="align_left">
						其他：<input type="text" name="hgtzZsjQt" />
					</td>
				</tr>
				<tr class="hgtz hgtzfbzh">
					<td>客供素材格式</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="hgtzZsjKgscgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="hgtzZsjKgscgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="hgtzZsjKgscgs" value="3">PDF
					</td>
				</tr>
				<tr class="hgtz hgtzfbzh">
					<td>客供素材文件</td>
					<td class="align_left"><input type="checkbox" class="skycheckbox" name="hgtzZsjKgscwj" value="1">已与此需求单同时提供</td>
				</tr>
				<tr class="hgtz">
					<td colspan="2" class="align_left">
						<input type="checkbox" class="skycheckbox" name="hgtzWc" value="1">国外采购,只提供电子文档资料
					</td>
					<td class="align_left">
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="hgtzSqbh" value="1">需要申请编号&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="hgtzSqbh" value="0">不需要申请编号
					</td>
				</tr>
				<tr>
					<td colspan="3" class="align_left">
						<input type="checkbox" class="skycheckbox" name="sfHgtz" value="1">不需要
					</td>
				</tr>
				<!-- ***********************************能效贴纸 *********************************** -->
				<tr>
					<td rowspan="3">8.能效贴纸</td>
					<td class="align_left"><input type="radio" class="skyradio" name="sfNxtz" value="1" checked="checked">需要</td>
					<td>用量及粘贴位置</td>
					<td class="align_left nxtz">
						<input type="radio" class="skyradio" name="nxtzYlWz" value="1" checked="checked">1个用量，粘贴于电视屏幕的左上角<br>
						<input type="radio" class="skyradio" name="nxtzYlWz" value="2">2个用量，1个粘贴于电视屏幕的左上角，1个粘贴于纸箱指定位置<br>
						<input type="radio" class="skyradio" name="nxtzYlWz" value="3">其他<input type="text" name="nxtzYlWzBz" />
					</td>
				</tr>
				<tr class="nxtz">
					<td colspan="2" class="align_left">
						<input type="checkbox" class="skycheckbox" name="nxtzWc" value="1">国外采购,只提供电子文档资料
					</td>
					<td class="align_left">
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="nxtzSqbh" value="1">需要申请编号&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="nxtzSqbh" value="0">不需要申请编号
					</td>
				</tr>
				<tr>
					<td colspan="3" class="align_left">
						<input type="radio" class="skyradio" name="sfNxtz" value="0">不需要
					</td>
				</tr>
				<!-- ***********************************保证卡*********************************** -->
				<tr class="bzk">
					<td rowspan="7">9.保证卡</td>
					<td colspan="3" class="align_left"><input type="radio" class="skyradio" name="bzkZlbz" value="1" checked="checked">标准资料</td>
				</tr>
				<tr class="bzk">
					<td rowspan="4" class="align_left">
						（非标准化项）<br>
						<input type="radio" class="skyradio" name="bzkZlbz" value="2">客供资料,不可修改
					</td>
					<td>客供资料格式</td>
					<td class="align_left bzkfbzh">
						<input type="radio" class="skyradio" name="bzkBkgKgzlgs" value="1">AI&nbsp;
						<input type="radio" class="skyradio" name="bzkBkgKgzlgs" value="2">CDR&nbsp;
						<input type="radio" class="skyradio" name="bzkBkgKgzlgs" value="3">PDF
					</td>
				</tr>
				<tr class="bzk bzkfbzh">
					<td>客供资料材质印刷要求</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="bzkBkgCzysyq" value="1">128G哑粉纸，彩色印刷<br>
						<input type="radio" class="skyradio" name="bzkBkgCzysyq" value="2">其他<input type="text" name="bzkBkgCzysyqBz" />
					</td>
				</tr>
				<tr class="bzk bzkfbzh">
					<td>客供资料装钉要求</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="bzkBkgZdyq" value="1">单页&nbsp;
						<input type="radio" class="skyradio" name="bzkBkgZdyq" value="2">折叠形式&nbsp;
						<input type="radio" class="skyradio" name="bzkBkgZdyq" value="3">书本形式，骑马钉装订<br>
						<input type="radio" class="skyradio" name="bzkBkgZdyq" value="4">其他<input type="text" name="bzkBkgZdyqBz" />
					</td>
				</tr>
				<tr class="bzk bzkfbzh">
					<td>客供资料文件</td>
					<td class="align_left">
					<input type="radio" class="skyradio" name="bzkBkgKgzlwj" value="1">已与此需求单同时提供&nbsp;
					<input type="radio" class="skyradio" name="bzkBkgKgzlwj" value="2">资料已提供，同<input type="text" name="bzkBkgKgzlwjBz" />
					</td>
				</tr>
				<tr class="bzk">
					<td colspan="2" class="align_left">
						<input type="checkbox" class="skycheckbox" name="bzkWc" value="1">国外采购,只提供电子文档资料
					</td>
					<td class="align_left">
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="bzkSqbh" value="1">需要申请编号&nbsp;
						<input type="radio" class="skyradio skydisabled" disabled="disabled" name="bzkSqbh" value="0">不需要申请编号
					</td>
				</tr>
				<tr>
					<td colspan="3" class="align_left">
						<input type="checkbox" class="skycheckbox" name="sfBzk" value="1">不需要
					</td>
				</tr>
				<!-- ***********************************整机序号贴纸*********************************** -->
				<tr class="zjxhtz">
					<td rowspan="6">10.整机序号贴纸</td>
					<td rowspan="2" class="align_left">
						<input type="radio" class="skyradio" name="zjxhtzXhbz" value="1" checked="checked">公司标准序列号
					</td>
					<td>尺寸</td>
					<td class="align_left zjxhtzgsbz">
						<input type="radio" class="skyradio" name="zjxhtzGsbzCc" value="1" checked="checked">45*15MM&nbsp;
						<input type="radio" class="skyradio" name="zjxhtzGsbzCc" value="2">25*6MM
					</td>
				</tr>
				<tr class="zjxhtz zjxhtzgsbz">
					<td>用量及粘贴位置</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="zjxhtzGsbzYljztwz" value="1" checked="checked">3个用量，贴于后壳、纸箱1侧和保证卡上<br>
						<input type="radio" class="skyradio" name="zjxhtzGsbzYljztwz" value="2">其他<input type="text" name="zjxhtzGsbzYljztwzBz" />
					</td>
				</tr>
				<tr class="zjxhtz">
					<td rowspan="3" class="align_left">
						（非标准化项）<br>
						<input type="radio" class="skyradio" name="zjxhtzXhbz" value="2">客供序列号：<input type="text" name="zjxhtzXhbzKgxh" /></td>
					<td>尺寸</td>
					<td class="align_left zjxhtzfbzh">
						<input type="radio" class="skyradio" name="zjxhtzKgCc" value="1">45*15MM&nbsp;
						<input type="radio" class="skyradio" name="zjxhtzKgCc" value="2">26*6MM<br>
						<input type="radio" class="skyradio" name="zjxhtzKgCc" value="3">其他<input type="text" name="zjxhtzKgCcBz" />
					</td>
				</tr>
				<tr class="zjxhtz zjxhtzfbzh">
					<td>用量及粘贴位置</td>
					<td class="align_left">
						<input type="radio" class="skyradio" name="zjxhtzKgYljztwz" value="1">3个用量，贴于后壳、纸箱1侧和保证卡上<br>
						<input type="radio" class="skyradio" name="zjxhtzKgYljztwz" value="2">其他<input type="text" name="zjxhtzKgYljztwzBz" />
					</td>
				</tr>
				<tr class="zjxhtz zjxhtzfbzh">
					<td>材质等特殊要求</td>
					<td class="align_left"><input type="text" name="zjxhtzKgCzdtsyq"></td>
				</tr>
				<tr>
					<td colspan="3" class="align_left">
						<input type="checkbox" class="skycheckbox" name="sfZjxhtz" value="1">不需要
					</td>
				</tr>
				<!-- ***********************************其他美工要求*********************************** -->
				<tr>
					<td>11.其他美工要求</td>
					<td colspan="3">
						<textarea rows="5" style="width: 99%;" name="mgqtyq"></textarea>
					</td>
				</tr>
				<tr>
					<td>附件</td>
					<td>
						<div class="form-control" style="text-align:left;">
							<input id="fj" type="file" class="form-control">
						</div>
						<input type="hidden" name="fj" />
					</td>
					<td colspan="2">
						<div id="fjxx">
							<ul class="list-unstyled spaced"></ul>
						</div>
						<div id="multiFileQueue"> </div>
					</td>
				</tr>
			</table>
			<div id="bgxx" style="display:none;">
				<br>
				<table class="edit_table" cellspacing="0" cellpadding="0">
					<tr>
						<th colspan="4" style="font-size: 14px; text-align: left;">需求变更单</th>
					</tr>
					<tr>
						<td style="width: 15%;" rowspan="3">是否量产过</td>
						<td colspan="3" class="align_left" style="width: 85%;">
							<input type="radio" class="skyradio" name="bgSflc" value="0">否
						</td>
					</tr>
					<tr>
						<td class="align_left" rowspan="2">
							<input type="radio" class="skyradio" name="bgSflc" value="1" checked="checked">是<br>
						</td>
						<td class="align_left" colspan="2" >	
							<label class="radio-inline">
								<input type="radio" class="skyradio" name="bgSflcValue" value="1">暂无量产订单,从此变更通知发出开始更改
							</label>
						</td>
					</tr>
					<tr>
						<td class="align_left" colspan="2" >
							<label class="radio-inline">
								<input type="radio" class="skyradio" name="bgSflcValue" value="2">
								从<input type="text" name="bgLcksddh" class="radio-inline" />订单开始更改
							</label>
						</td>
					</tr>
					<tr>
						<td style="width: 15%;">变更申请人</td>
						<td class="align_left" style="width: 35%;">
							<input type="text" name="bgSqrmc" class="form-control skydisabled" disabled="disabled"/>
						</td>
						<td>变更申请时间</td>
						<td class="align_left">
							<div class="input-group input-group-sm">
								<input type="text" name="bgSqsj" class="form-control skydisabled" disabled="disabled"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</td>
					</tr>
					<tr>
						<td>变更内容</td>
						<td colspan="3">
							<textarea rows="5" style="width: 99%;" name="bgNr"></textarea>
						</td>
					</tr>
					<tr>
						<td>变更原因</td>
						<td colspan="3">
							<textarea rows="5" style="width: 99%;" name="bgYy"></textarea>
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<br><br><br><br>
</div>
</body>
<script type="text/javascript">
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var sfFz = "<%=sfFz%>";
	$(function($){
		$(".skyselect").select2();
		// 初始化PID选择
		$("#form-submit [name=pid]").click(function(){
			selectPidInit();
		});
		// 初始化客户选择
		$("#khmc").click(function(){
			bindKhbm();
		});
		//初始化销往国家选择
		getXwgj();
		// 初始化产品经理
		getCpjl("2-bb-mghwcpjl");
		//初始化销售员选择
		selectXsyInit();
		// 初始化表单信息
		initFormData(id);
		// 表单验证
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: 'input[type=hidden]',
			rules: {
				pid: 'required',
				zhfs: 'required',
				wkysbz: 'required',
				xsymc: 'required',
				khpp: 'required',
				xwgj: 'required',
				khmc: 'required',
				vbbh: 'required'
			},
			messages: {
				pid: 'PID不能为空',
				zhfs: '走货方式不能为空',
				wkysbz: '产品颜色标准不能为空',
				xsymc: '销售员不能为空',
				khpp: '品牌不能为空',
				xwgj: '销往国家不能为空',
				khmc: '客户名称不能为空',
				vbbh: '版本不能为空'
			},
	        showErrors: function(errorMap, errorList) {  
	        	$('.input-group').removeClass('has-error');
	            if(errorList.length != 0){
		            var msg = "";  
		            $.each( errorList, function(i,v){  
		              msg += (v.message+"\r\n"); 
		              $(v.element).closest('.input-group').addClass('has-error');
		            });  
	            	swal({title: "校验不通过！",text: msg,type: "error"},	function(){
						return false;
					});
	            }
	        }
		});
		// 保存
		$("#btn-save").click(function(){
			save();
	    });
		// 提交
		$("#btn-submit").click(function(){
			submit();
	    });
		// 返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		//change事件
		//品牌造型
		$('#form-submit [name=ppzx]').change(function() {
			if($(this).val() == 1 ){//旧
				 $('#form-submit [name=ppwjgs]').prop('disabled','disabled'); 
				 $("#form-submit [name=ppwjgs]").removeAttr("checked"); 
				 $('#form-submit [name=ppwj]').prop('disabled','disabled'); 
				 $("#form-submit [name=ppwj]").removeAttr("checked"); 
			  }else{
				  $('#form-submit [name=ppwjgs]').removeProp('disabled').removeAttr('disabled'); 
				  $("#form-submit [name=ppwjgs][value=3]").prop("checked",true); 
				  $('#form-submit [name=ppwj]').removeProp('disabled').removeAttr('disabled'); 
				  $("#form-submit [name=ppwj]").prop("checked",true); 
			  }
		 }); 
		
		//认证要求选了“无”，不能选后面的多选选项
		$('#form-submit [name=rzWu]').change(function() {
			if($("#form-submit [name=rzWu]").is(":checked")){
			 $("#form-submit [name=rzCe],[name=rzCb],[name=rzEtl],[name=rzFcc],[name=rzDb],[name=rzDts],[name=rzHdmi],[name=rzQt]")
			 .removeAttr("checked"); 
			//选了“无”后，自定义输入框将屏蔽
			 $('#form-submit [name=rzQtBz]').prop('disabled','disabled'); 
			}
		});
		//认证要求选了后面的这些多选选项，不能选“无”
		$("#form-submit [name=rzCe],[name=rzCb],[name=rzEtl],[name=rzFcc],[name=rzDb],[name=rzDts],[name=rzHdmi],[name=rzQt]")
		.change(function() {
			if($("#form-submit [name=rzCe],[name=rzCb],[name=rzEtl],[name=rzFcc],[name=rzDb],[name=rzDts],[name=rzHdmi],[name=rzQt]")
			.is(":checked")){
			$("#form-submit [name=rzWu]").removeAttr("checked"); 
			}
		});
		
		//1.面壳/装饰件/装饰条等
		$('#form-submit [name=mkSfLogo]').change(function() {
			 if($("#form-submit [name=mkSfLogo]:checked").val() == 1){
				 $('#form-submit [name=mkLogoWz][value=1]').prop('checked','checked');
				 $('#form-submit [name=mkLogoCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=mkLogoGy][value=1]').prop('checked','checked');
				 $('#form-submit [name=mkLogoYs][value=1]').prop('checked','checked');
			 } else {
				 $(".mkzsjzstd").find("input[type=radio]").removeAttr("checked");
				 $(".mkzsjzstd").find("input[type=checkbox]").removeAttr("checked");
				 $(".mkzsjzstd").find("input[type=text]").val("");
			 }
		 });
		 $('#form-submit [name=mkQt]').change(function() {
			 if($("#form-submit [name=mkQt]").is(":checked")){
				 $('#form-submit [name=mkQtWz][value=1]').prop('checked','checked');
				 $('#form-submit [name=mkQtCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=mkQtGy][value=1]').prop('checked','checked');
				 $('#form-submit [name=mkQtYs][value=1]').prop('checked','checked');
				 $('#form-submit [name=mkQtKgwjgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=mkQtKgwj]').prop('checked','checked');
			  }else{
				 $(".mkfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".mkfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".mkfbzh").find("input[type=text]").val("");
			  }
		 });
		 //2.遥控器
		 $('#form-submit [name=sfYkq]').change(function() {
			 if($("#form-submit [name=sfYkq]").is(":checked")){
				 $(".ykq").find("input[type=radio]").removeAttr("checked");
				 $(".ykq").find("input[type=checkbox]").removeAttr("checked");
				 $(".ykq").find("input[type=text]").val("");
				 $(".ykq").find("input[type=radio]").prop("disabled","disabled");
				 $(".ykq").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".ykq").find("input[type=text]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=ykqSfLogo][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqLogoWz]').prop('checked','checked');
				 $('#form-submit [name=ykqLogoCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqLogoGy][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqLogoYs][value=1]').prop('checked','checked');
				 $(".ykq").find("input[type=radio]").removeAttr("disabled");
				 $(".ykq").find("input[type=checkbox]").removeAttr("disabled");
				 $(".ykq").find("input[type=text]").removeAttr("disabled");
			 }
		 });
		 $('#form-submit [name=ykqSfLogo]').change(function() {
			 if($("#form-submit [name=ykqSfLogo]:checked").val() == 1){
				 $('#form-submit [name=ykqLogoWz]').prop('checked','checked');
				 $('#form-submit [name=ykqLogoCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqLogoGy][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqLogoYs][value=1]').prop('checked','checked');
			 } else {
				 $(".ykq").find("input[type=radio]").removeAttr("checked");
				 $(".ykq").find("input[type=checkbox]").removeAttr("checked");
				 $(".ykq").find("input[type=text]").val("");
				 $('#form-submit [name=ykqSfLogo][value=0]').prop('checked','checked');
			 }
		 });
		 $('#form-submit [name=ykqQt]').change(function() {
			 if($("#form-submit [name=ykqQt]").is(":checked")){
				 $('#form-submit [name=ykqQtWz][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqQtCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqQtGy][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqQtYs][value=1]').prop('checked','checked');
				 $('#form-submit [name=ykqQtKgwjgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=ykqQtKgwj]').prop('checked','checked');
			  }else{
				 $(".ykqfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".ykqfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".ykqfbzh").find("input[type=text]").val("");
			  }
		 });
		 //3.说明书
		 $('#form-submit [name=sfSms]').change(function() {
			 if($("#form-submit [name=sfSms]").is(":checked")){
				 $(".sms").find("input[type=radio]").removeAttr("checked");
				 $(".sms").find("input[type=checkbox]").removeAttr("checked");
				 $(".sms").find("input[type=text]").val("");
				 $(".sms").find("input[type=radio]").prop("disabled","disabled");
				 $(".sms").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".sms").find("input[type=text]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=smsLx][value=1]').prop('checked','checked');
				 $(".sms").find("input[type=radio]").removeAttr("disabled");
				 $(".sms").find("input[type=checkbox]").removeAttr("disabled");
				 $(".sms").find("input[type=text]").removeAttr("disabled");
			 }
		 });
		 $('#form-submit [name=smsYz]').change(function() {
			 if($("#form-submit [name=smsYz]").is(":checked")){
				 $('#form-submit [name=smsYzYz][value=2]').prop('checked','checked');
				 $('#form-submit [name=smsYzCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=smsYzYsys][value=1]').prop('checked','checked');
				 $('#form-submit [name=smsYzCz][value=1]').prop('checked','checked');
				 $(".smsdyz").find("input[type=radio]").removeAttr("checked");
				 $(".smsdyz").find("input[type=checkbox]").removeAttr("checked");
				 $(".smsdyz").find("input[type=text]").val("");
			  }else{
				 $(".smsyz").find("input[type=radio]").removeAttr("checked");
				 $(".smsyz").find("input[type=checkbox]").removeAttr("checked");
				 $(".smsyz").find("input[type=text]").val("");
			  }
		 });
		 $('#form-submit [name=smsDyz]').change(function() {
			 if($("#form-submit [name=smsDyz]").is(":checked")){
				 $('#form-submit [name=smsDyzYz][value=1]').prop('checked','checked');
				 $('#form-submit [name=smsDyzCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=smsDyzYsys][value=1]').prop('checked','checked');
				 $('#form-submit [name=smsDyzCz][value=1]').prop('checked','checked');
				 $(".smsyz").find("input[type=radio]").removeAttr("checked");
				 $(".smsyz").find("input[type=checkbox]").removeAttr("checked");
				 $(".smsyz").find("input[type=text]").val("");
			  }else{
				 $(".smsdyz").find("input[type=radio]").removeAttr("checked");
				 $(".smsdyz").find("input[type=checkbox]").removeAttr("checked");
				 $(".smsdyz").find("input[type=text]").val("");
			  }
		 });
		 $('#form-submit [name=smsZsj]').change(function() {
			 if($("#form-submit [name=smsZsj]").is(":checked")){
				 $('#form-submit [name=smsZsjKgscgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=smsZsjKgscwj]').prop('checked','checked');
				 $(".smsbkg").find("input[type=radio]").removeAttr("checked");
				 $(".smsbkg").find("input[type=checkbox]").removeAttr("checked");
				 $(".smsbkg").find("input[type=text]").val("");
			  }else{
				 $(".smsfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".smsfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".smsfbzh").find("input[type=text]").val("");
			  }
		 });
		 $('#form-submit [name=smsBkg]').change(function() {
			 if($("#form-submit [name=smsBkg]").is(":checked")){
				 $('#form-submit [name=smsBkgKgzlgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=smsBkgKgzlwj]').prop('checked','checked');
				 $(".smsfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".smsfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".smsfbzh").find("input[type=text]").val("");
			  }else{
				 $(".smsbkg").find("input[type=radio]").removeAttr("checked");
				 $(".smsbkg").find("input[type=checkbox]").removeAttr("checked");
				 $(".smsbkg").find("input[type=text]").val("");
			  }
		 });
		 //4.底座安装说明
		 $('#form-submit [name=sfDzazsm]').change(function() {
			 if($("#form-submit [name=sfDzazsm]").is(":checked")){
				 $(".dzazsm").find("input[type=radio]").removeAttr("checked");
				 $(".dzazsm").find("input[type=checkbox]").removeAttr("checked");
				 $(".dzazsm").find("input[type=text]").val("");
				 $(".dzazsm").find("input[type=radio]").prop("disabled","disabled");
				 $(".dzazsm").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".dzazsm").find("input[type=text]").prop("disabled","disabled");
				 $(".dzazsm1").find("input[type=checkbox]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=dzazsmYz][value=1]').prop('checked','checked');
				 $('#form-submit [name=dzazsmYs][value=1]').prop('checked','checked');
				 $(".dzazsm").find("input[type=radio]").removeAttr("disabled");
				 $(".dzazsm").find("input[type=checkbox]").removeAttr("disabled");
				 $(".dzazsm").find("input[type=text]").removeAttr("disabled");
				 $(".dzazsm1").find("input[type=checkbox]").removeAttr("disabled");
			 }
		 });
		 $('#form-submit [name=dzazsmNr]').change(function() {
			 if($("#form-submit [name=dzazsmNr]").is(":checked")){
				 $(".dzazsm").find("input[type=radio]").removeAttr("checked");
				 $(".dzazsm").find("input[type=checkbox]").removeAttr("checked");
				 $(".dzazsm").find("input[type=text]").val("");
				 $(".dzazsm").find("input[type=radio]").prop("disabled","disabled");
				 $(".dzazsm").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".dzazsm").find("input[type=text]").prop("disabled","disabled");
				 $(".dzazsm2").find("input[type=checkbox]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=dzazsmYz][value=1]').prop('checked','checked');
				 $('#form-submit [name=dzazsmYs][value=1]').prop('checked','checked');
				 $(".dzazsm").find("input[type=radio]").removeAttr("disabled");
				 $(".dzazsm").find("input[type=checkbox]").removeAttr("disabled");
				 $(".dzazsm").find("input[type=text]").removeAttr("disabled");
				 $(".dzazsm2").find("input[type=checkbox]").removeAttr("disabled");
			 }
		 });		 
		 //5.纸箱
		 $('#form-submit [name=sfZx]').change(function() {
			 if($("#form-submit [name=sfZx]").is(":checked")){
				 $(".zx").find("input[type=radio]").removeAttr("checked");
				 $(".zx").find("input[type=checkbox]").removeAttr("checked");
				 $(".zx").find("input[type=text]").val("");
				 $(".zx").find("input[type=radio]").prop("disabled","disabled");
				 $(".zx").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".zx").find("input[type=text]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=zxLx][value=1]').prop('checked','checked');
				 $('#form-submit [name=zxSjbz][value=1]').prop('checked','checked');
				 $(".zx").find("input[type=radio]").removeAttr("disabled");
				 $(".zx").find("input[type=checkbox]").removeAttr("disabled");
				 $(".zx").find("input[type=text]").removeAttr("disabled");
			 }
		 });
		 $('#form-submit [name=zxSjbz]').on('change',function(e){
			 if($(this).val() == 4){
				 $(".zxfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".zxfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxfbzh").find("input[type=text]").val("");
				 $('#form-submit [name=zxBkgKgzlgs][value=1]').prop('checked','checked');
				 $('#form-submit [name=zxBkgKgzlwj]').prop('checked','checked');
			 }else if($(this).val() == 5){
				 $(".zxbkg").find("input[type=radio]").removeAttr("checked");
				 $(".zxbkg").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxbkg").find("input[type=text]").val("");
				 $('#form-submit [name=zxZsjKgscgs][value=1]').prop('checked','checked');
				 $('#form-submit [name=zxZsjKgscwj]').prop('checked','checked');
			 }
		 });
		 //6.纸箱贴纸
		 $('#form-submit [name=sfZxtz]').change(function() {
			 if($("#form-submit [name=sfZxtz]").is(":checked")){
				 $(".zxtz").find("input[type=radio]").removeAttr("checked");
				 $(".zxtz").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxtz").find("input[type=text]").val("");
				 $(".zxtz").find("input[type=radio]").prop("disabled","disabled");
				 $(".zxtz").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".zxtz").find("input[type=text]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=zxtzZlbz][value=1]').prop('checked','checked');
				 $(".zxtz").find("input[type=radio]").removeAttr("disabled");
				 $(".zxtz").find("input[type=checkbox]").removeAttr("disabled");
				 $(".zxtz").find("input[type=text]").removeAttr("disabled");
			 }
		 });
		 $('#form-submit [name=zxtzZlbz]').on('change',function(e){
			 if($(this).val() == 1){
				 $(".zxtzbkg").find("input[type=radio]").removeAttr("checked");
				 $(".zxtzbkg").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxtzbkg").find("input[type=text]").val("");
				 $(".zxtzfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".zxtzfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxtzfbzh").find("input[type=text]").val("");
			 }else if($(this).val() == 2){
				 $(".zxtzbzzl").find("input[type=radio]").removeAttr("checked");
				 $(".zxtzbzzl").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxtzbzzl").find("input[type=text]").val("");
				 $(".zxtzfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".zxtzfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxtzfbzh").find("input[type=text]").val("");
				 $('#form-submit [name=zxtzBkgKgzlgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=zxtzBkgKgzlwj]').prop('checked','checked');
			 }else if($(this).val() == 3){
				 $(".zxtzbzzl").find("input[type=radio]").removeAttr("checked");
				 $(".zxtzbzzl").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxtzbzzl").find("input[type=text]").val("");
				 $(".zxtzbkg").find("input[type=radio]").removeAttr("checked");
				 $(".zxtzbkg").find("input[type=checkbox]").removeAttr("checked");
				 $(".zxtzbkg").find("input[type=text]").val("");
				 $('#form-submit [name=zxtzZsjKgscgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=zxtzZsjKgscwj]').prop('checked','checked');
			 }
		 });
		 //7.后盖贴纸
		 $('#form-submit [name=sfHgtz]').change(function() {
			 if($("#form-submit [name=sfHgtz]").is(":checked")){
				 $(".hgtz").find("input[type=radio]").removeAttr("checked");
				 $(".hgtz").find("input[type=checkbox]").removeAttr("checked");
				 $(".hgtz").find("input[type=text]").val("");
				 $(".hgtz").find("input[type=radio]").prop("disabled","disabled");
				 $(".hgtz").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".hgtz").find("input[type=text]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=hgtzZlbz][value=1]').prop('checked','checked');
				 $(".hgtz").find("input[type=radio]").removeAttr("disabled");
				 $(".hgtz").find("input[type=checkbox]").removeAttr("disabled");
				 $(".hgtz").find("input[type=text]").removeAttr("disabled");
			 }
		 });
		 $('#form-submit [name=hgtzZlbz]').on('change',function(e){
			 if($(this).val() == 1){
				 $(".hgtzbkg").find("input[type=radio]").removeAttr("checked");
				 $(".hgtzbkg").find("input[type=checkbox]").removeAttr("checked");
				 $(".hgtzbkg").find("input[type=text]").val("");
				 $(".hgtzfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".hgtzfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".hgtzfbzh").find("input[type=text]").val("");
			 }else if($(this).val() == 2){
				 $(".hgtzbzzl").find("input[type=radio]").removeAttr("checked");
				 $(".hgtzbzzl").find("input[type=checkbox]").removeAttr("checked");
				 $(".hgtzbzzl").find("input[type=text]").val("");
				 $(".hgtzfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".hgtzfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".hgtzfbzh").find("input[type=text]").val("");
				 $('#form-submit [name=hgtzBkgKgzlgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=hgtzBkgKgzlwj]').prop('checked','checked');
			 }else if($(this).val() == 3){
				 $(".hgtzbzzl").find("input[type=radio]").removeAttr("checked");
				 $(".hgtzbzzl").find("input[type=checkbox]").removeAttr("checked");
				 $(".hgtzbzzl").find("input[type=text]").val("");
				 $(".hgtzbkg").find("input[type=radio]").removeAttr("checked");
				 $(".hgtzbkg").find("input[type=checkbox]").removeAttr("checked");
				 $(".hgtzbkg").find("input[type=text]").val("");
				 $('#form-submit [name=hgtzZsjKgscgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=hgtzZsjKgscwj]').prop('checked','checked');
			 }
		 });
		 //8.能效贴纸
		 $('#form-submit [name=sfNxtz]').change(function() {
			 if($("#form-submit [name=sfNxtz]:checked").val() == 1){
				 $('#form-submit [name=nxtzYlWz][value=1]').prop('checked','checked');
				 $(".nxtz").find("input[type=radio]").removeAttr("disabled");
				 $(".nxtz").find("input[type=checkbox]").removeAttr("disabled");
				 $(".nxtz").find("input[type=text]").removeAttr("disabled");
			 } else {
				 $(".nxtz").find("input[type=radio]").removeAttr("checked");
				 $(".nxtz").find("input[type=checkbox]").removeAttr("checked");
				 $(".nxtz").find("input[type=text]").val("");
				 $(".nxtz").find("input[type=radio]").prop("disabled","disabled");
				 $(".nxtz").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".nxtz").find("input[type=text]").prop("disabled","disabled");
			 }
		 });
		 //9.保证卡
		 $('#form-submit [name=sfBzk]').change(function() {
			 if($("#form-submit [name=sfBzk]").is(":checked")){
				 $(".bzk").find("input[type=radio]").removeAttr("checked");
				 $(".bzk").find("input[type=checkbox]").removeAttr("checked");
				 $(".bzk").find("input[type=text]").val("");
				 $(".bzk").find("input[type=radio]").prop("disabled","disabled");
				 $(".bzk").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".bzk").find("input[type=text]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=bzkZlbz][value=1]').prop('checked','checked');
				 $(".bzk").find("input[type=radio]").removeAttr("disabled");
				 $(".bzk").find("input[type=checkbox]").removeAttr("disabled");
				 $(".bzk").find("input[type=text]").removeAttr("disabled");
			 }
		 });
		 $('#form-submit [name=bzkZlbz]').on('change',function(e){
			 if($(this).val() == 1){
				 $(".bzkfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".bzkfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".bzkfbzh").find("input[type=text]").val("");
			 }else if($(this).val() == 2){
				 $('#form-submit [name=bzkBkgKgzlgs][value=3]').prop('checked','checked');
				 $('#form-submit [name=bzkBkgCzysyq][value=1]').prop('checked','checked');
				 $('#form-submit [name=bzkBkgZdyq][value=1]').prop('checked','checked');
				 $('#form-submit [name=bzkBkgKgzlwj]').prop('checked','checked');
			 }
		 });
		 //10.整机序号贴纸
		 $('#form-submit [name=sfZjxhtz]').change(function() {
			 if($("#form-submit [name=sfZjxhtz]").is(":checked")){
				 $(".zjxhtz").find("input[type=radio]").removeAttr("checked");
				 $(".zjxhtz").find("input[type=checkbox]").removeAttr("checked");
				 $(".zjxhtz").find("input[type=text]").val("");
				 $(".zjxhtz").find("input[type=radio]").prop("disabled","disabled");
				 $(".zjxhtz").find("input[type=checkbox]").prop("disabled","disabled");
				 $(".zjxhtz").find("input[type=text]").prop("disabled","disabled");
			 }else{
				 $('#form-submit [name=zjxhtzXhbz][value=1]').prop('checked','checked');
				 $('#form-submit [name=zjxhtzGsbzCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=zjxhtzGsbzYljztwz][value=1]').prop('checked','checked');
				 $(".zjxhtz").find("input[type=radio]").removeAttr("disabled");
				 $(".zjxhtz").find("input[type=checkbox]").removeAttr("disabled");
				 $(".zjxhtz").find("input[type=text]").removeAttr("disabled");
			 }
		 });
		 $('#form-submit [name=zjxhtzXhbz]').on('change',function(e){
			 if($(this).val() == 1){
				 $(".zjxhtzfbzh").find("input[type=radio]").removeAttr("checked");
				 $(".zjxhtzfbzh").find("input[type=checkbox]").removeAttr("checked");
				 $(".zjxhtzfbzh").find("input[type=text]").val("");
				 $('#form-submit [name=zjxhtzGsbzCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=zjxhtzGsbzYljztwz][value=1]').prop('checked','checked');
			 }else if($(this).val() == 2){
				 $(".zjxhtzgsbz").find("input[type=radio]").removeAttr("checked");
				 $(".zjxhtzgsbz").find("input[type=checkbox]").removeAttr("checked");
				 $(".zjxhtzgsbz").find("input[type=text]").val("");
				 $('#form-submit [name=zjxhtzKgCc][value=1]').prop('checked','checked');
				 $('#form-submit [name=zjxhtzKgYljztwz][value=1]').prop('checked','checked');
			 }
		 });
		 // 附件控件
		 $('#fj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#fj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			multi : true,
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var fjUl = $('#fjxx ul');
						var fjLi = $('<li><i class="icon-remove red" style="cursor:pointer;"></i></li>');
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						fjLi.append(tmpUrl);
						fjUl.append(fjLi);
						$("#form-submit [name=fj]").val($('#fjxx').html());
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#fjxx').on("click", "li .icon-remove", function(){
			var thisLi = $(this).parent("li");
			$("body").bindSweetAlert({
				title : "确定要删除附件吗?",
				closeOnConfirm: true
			}, {
				callback : function() {
					thisLi.remove();
					$("#form-submit [name=fj]").val($('#fjxx').html());
				}
			});
		});
		/**************************************************国外采购 change控制************************************************/
		//3、说明书 国外采购
		$('#form-submit [name=smsWc]').change(function() {
			 if($("#form-submit [name=smsWc]").is(":checked")){
				 $('#form-submit [name=smsSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=smsSqbh][value=0]").prop("checked",true);
			  }else{
				  $('#form-submit [name=smsSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=smsSqbh]").removeAttr("checked"); 
			  }
		 });
		//4、底座安装说明 国外采购
		$('#form-submit [name=dzazsmWc]').change(function() {
			 if($("#form-submit [name=dzazsmWc]").is(":checked")){
				 $('#form-submit [name=dzazsmSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=dzazsmSqbh][value=0]").prop("checked",true);
			  }else{
				  $('#form-submit [name=dzazsmSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=dzazsmSqbh]").removeAttr("checked"); 
			  }
		 });
		//5、纸箱 国外采购
		$('#form-submit [name=zxWc]').change(function() {
			 if($("#form-submit [name=zxWc]").is(":checked")){
				 $('#form-submit [name=zxSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=zxSqbh][value=0]").prop("checked",true);
			  }else{
				  $('#form-submit [name=zxSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=zxSqbh]").removeAttr("checked"); 
			  }
		 });
		 //6、纸箱贴纸 国外采购
		$('#form-submit [name=zxtzWc]').change(function() {
			 if($("#form-submit [name=zxtzWc]").is(":checked")){
				 $('#form-submit [name=zxtzSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=zxtzSqbh][value=0]").prop("checked",true);
			  }else{
				  $('#form-submit [name=zxtzSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=zxtzSqbh]").removeAttr("checked"); 
			  }
		 });
		 //7、后盖贴纸 国外采购
		$('#form-submit [name=hgtzWc]').change(function() {
			 if($("#form-submit [name=hgtzWc]").is(":checked")){
				 $('#form-submit [name=hgtzSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=hgtzSqbh][value=0]").prop("checked",true);
			  }else{
				  $('#form-submit [name=hgtzSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=hgtzSqbh]").removeAttr("checked"); 
			  }
		 });
		 //8、能效贴纸 国外采购
		$('#form-submit [name=nxtzWc]').change(function() {
			 if($("#form-submit [name=nxtzWc]").is(":checked")){
				 $('#form-submit [name=nxtzSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=nxtzSqbh][value=0]").prop("checked",true);
			  }else{
				  $('#form-submit [name=nxtzSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=nxtzSqbh]").removeAttr("checked"); 
			  }
		 });
		 //9、保证卡 国外采购
		$('#form-submit [name=bzkWc]').change(function() {
			 if($("#form-submit [name=bzkWc]").is(":checked")){
				 $('#form-submit [name=bzkSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=bzkSqbh][value=0]").prop("checked",true);
			  }else{
				  $('#form-submit [name=bzkSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=bzkSqbh]").removeAttr("checked"); 
			  }
		 });
		 //认证 其他
		 $('#form-submit [name=rzQt]').change(function() {
			 if($("#form-submit [name=rzQt]").is(":checked")){
				 $('#form-submit [name=rzQtBz]').removeProp('disabled').removeAttr('disabled'); 
			  }else{
				  $('#form-submit [name=rzQtBz]').prop('disabled','disabled'); 
				  $("#form-submit [name=rzQtBz]").val(""); 
			  }
		 });
		/**************************************************国外采购 change控制结束************************************************/
		
		//是否量产
		$('#form-submit [name=bgSflc]').change(function() {
			if($(this).val() == 0 ){
				 $('#form-submit [name=bgSflcValue]').prop('disabled','disabled'); 
				 $("#form-submit [name=bgSflcValue]").removeAttr("checked"); 
			  }else{
				  $('#form-submit [name=bgSflcValue]').removeProp('disabled').removeAttr('disabled'); 
				  $("#form-submit [name=bgSflcValue][value=1]").prop("checked",true); 
			  }
		      $('#form-submit [name=bgLcksddh]').prop('disabled','disabled'); 
			  $("#form-submit [name=bgLcksddh]").val(""); 
		 }); 
		
		 $('#form-submit [name=bgSflcValue]').change(function() {
			 if($(this).val() == 1 ){
				 $('#form-submit [name=bgLcksddh]').prop('disabled','disabled'); 
				 $("#form-submit [name=bgLcksddh]").val(""); 
			  }else{
				  $('#form-submit [name=bgLcksddh]').removeProp('disabled').removeAttr('disabled'); 
			  }
		 }); 
	});
	/**************************************************function开始区域************************************************/
	//初始化销往国家select2信息
	function getXwgj(){
		$.post("<c:url value='/pub/select2/selectCountry'/>",{},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.code;
			       obj.text =  obj.cnName ;		      
			       return obj;
			     });
				$("#form-submit [name=xwgj]").addClass("skyselect").select2({data:data});
		}, "json");
	}
	
	// 销售员选择
	function selectXsyInit(){
		$("#form-submit [name=xsymc]").bindTreeTableDialog({
			title:"销售员选择",
			leftUrl : "<c:url value='/core/organization/loadTree'/>",//左侧树查询的url
			rightUrl : "<c:url value='/mdm/employee/search'/>",//右侧列表查询的url
			leftSearchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			rightSearchParams:[{"name":"员工号","value":"empCode"},{"name":"员工名","value":"name"}],
			rightColModel:[{"colName":"empCode","colTitle":"员工号","width":"40%"},
				           {"colName":"name","colTitle":"员工名","width":"40%"},
				           {"colName":"xszz","colTitle":"销售组织",hidden:true},
				           {"colName":"xszzmc","colTitle":"销售组织名称",hidden:true},
				           {"colName":"ywz","colTitle":"业务组",hidden:true},
				           {"colName":"ywzmc","colTitle":"业务组名称",hidden:true}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"},//查询基础架构
			nodeParams:[{"nodeField":"id","searchParam":"deptCode"}]//右侧查询时会附带选中的树节点的信息，取节点的id属性值以deptCode这个参数名传到后台
		},{
			callback:function(record){
				if(record){
					$("#form-submit [name=xsyid]").val(record.empCode);//参考rightColModel
					$("#form-submit [name=xsymc]").val(record.name);
					$("#form-submit [name=xszz]").val(record.xszz);
					$("#form-submit [name=xszzmc]").val(record.xszzmc);
					$("#form-submit [name=ywz]").val(record.ywz);
					$("#form-submit [name=ywzmc]").val(record.ywzmc);
				}else{
					$("#form-submit [name=xsyid]").val("");
					$("#form-submit [name=xsymc]").val("");
					$("#form-submit [name=xszz]").val("");
					$("#form-submit [name=xszzmc]").val("");
					$("#form-submit [name=ywz]").val("");
					$("#form-submit [name=ywzmc]").val("");
				}
			}
		});
	}
	
	// PID选择
	function selectPidInit(){
		$.tableDialogPage({
			title:"PID选择",
			searchCond:[{"name":"PID","value":"pid"},
			            {"name":"机型","value":"jixing"},
			            {"name":"机芯","value":"jixin"}],
			colModel:[{name:'pid', index:'pid', label:'PID', width:80},
			          {name:'khmc', index:'khmc', label:'客户名称', width:80},
			          {name:'pp', index:'pp', label:'品牌名称', width:80},
			          {name:'jixing', index:'jixing', label:'机型', width:80},
			          {name:'jixin', index:'jixin', label:'机芯', width:80},
			          {name:'zdrmc', index:'zdrmc', label:'申请人', width:80}
			        ],
			url:"<c:url value='/pub/widget/findPid'/>"
		},{
			callback:function(rows){
				if(rows){
					$('#form-submit [name=jixin]').val(rows.jixin);
					$('#form-submit [name=jixing]').val(rows.jixing);
					// 根据所选PID赋值相关信息
					$('#form-submit [name=pid]').val(rows.pid);

				}
			}
		});
	}
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户","value":"khbm"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:80},
		 	          {name:'khmc', index:'khmc', label:'客户名称', width:80}],
				  url:"<c:url value='/pub/widget/findCust'/>"
		},{
			callback:function(rows){
				if(rows){
					$("#form-submit [name=khbm]").val(rows.khbm);
					$("#form-submit [name=khmc]").val(rows.khmc);
				}else{
					$("#form-submit [name=khbm]").val("");
					$("#form-submit [name=khmc]").val("");
				}
			}
		});
	}
	
	//加载产品经理
	function getCpjl(roleCode){
		$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:roleCode},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.empCode;
			       obj.text = obj.text || obj.userName;	
			       return obj;
			     });
				$("#form-submit [name=cpjl]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
					if(e.added){
						$("#form-submit [name=cpjlmc]").val(e.added.userName);
					}
				});
		}, "json");
	}
	
	// 初始化表单数据
	function initFormData(id){
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=bbh]").val("1");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=zt]").val("1");
		} else {
			// edit
			$.bindAjax({
				url : "<c:url value='/art/oem/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				var values = $("#form-submit").getFormData();
				$("#form-submit").find(".skycheckbox").removeProp("checked").removeAttr("checked");
				$.each(values, function(name, value){
					var val = response[name];
					var element = $("#form-submit").find("[name="+name+"]");
					val = (val != null) ? val+"" : "";
					if(element.hasClass("skycheckbox")){
						if(val.indexOf(",") > -1){
							var temp = val.split(",");
							$.each(temp, function(i, n){
								$("#form-submit").find("[name="+name+"][value="+n+"]").prop("checked",true);
							})
						}else if(val == 1){
							$("#form-submit").find("[name="+name+"][value="+val+"]").prop("checked",true);
						}else{
							element.removeProp("checked").removeAttr("checked");
						}
					}else if(element.hasClass("skyselect")){
						if(val.indexOf(",") > -1){
							element.val(val.split(",")).trigger("change");
						}else{
							element.val(val).trigger("change");
						}
					}else if(element.hasClass("skyradio")){
						if(val != ""){
							$("#form-submit").find("[name="+name+"][value="+val+"]").prop("checked",true);
						}else{
							element.removeProp("checked").removeAttr("checked");
						}
					}else {
						element.val(val);
					}
				});
				$("#fjxx").html(response.fj);
				if(sfFz == 1){
					//复制时，清空以下信息
					$("#form-submit [name=id]").val("");
					$("#form-submit [name=sjc]").val("");
					$("#form-submit [name=sfBg]").val("");
					$("#form-submit [name=bbh]").val("1");
					$("#form-submit [name=oper]").val("add");
					$("#form-submit [name=zt]").val("1");
					$("#form-submit [name=rwdh]").val("");
					$("#form-submit [name=wjbh]").val("");
					$("#form-submit [name=zdrmc]").val("");
					$("#form-submit [name=zdsj]").val("");
				}else{
					//if(response.sfBg == 1){
						$(".jbxx").find("input[type=radio]").prop("disabled","disabled").addClass("skydisabled");
						$(".jbxx").find("input[type=checkbox]").prop("disabled","disabled").addClass("skydisabled");
					    $(".jbxx").find("input[type=text]").prop("disabled","disabled").addClass("skydisabled");
					    $(".jbxx").find("input[name=pid]").removeProp("disabled").removeAttr("disabled").removeClass("skydisabled");
						$(".jbxx").find("input[name=cpjl]").removeProp("disabled").removeAttr("disabled").removeClass("skydisabled");
					    $('#form-submit [name=wkysbz]').prop("disabled","disabled").addClass("skydisabled");
					    $('#form-submit [name=vbbh]').prop("disabled","disabled").addClass("skydisabled");
						$("#bgxx").show();
					//}
					if(response.bgSflc == null){
						$("#form-submit [name=bgSflc][value=1]").prop("checked",true);
						$("#form-submit [name=bgSflcValue][value=1]").prop("checked",true);
						$('#form-submit [name=bgLcksddh]').prop('disabled','disabled');
					}else{
						if(response.bgSflcValue == 2){
							$("#form-submit [name=bgSflcValue][value=2]").prop("checked",true);
							$('#form-submit [name=bgLcksddh]').removeProp('disabled').removeAttr('disabled');
						}
					}
					$("#form-submit [name=oper]").val("edit");
					$("#form-submit [name=taskId]").val(taskId);
					$("#form-submit [name=oldJixing]").val(response.jixing);
					$("#form-submit [name=oldJixin]").val(response.jixin);
				}
			});
		}
	}
	// 保存
	function save(){
		// 表单验证
		if(!$('#form-submit').valid()){
			return false;
		}
		if(!qtValid()){
			return false;
		}
		if(!bgValid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		if(param.oldJixing != "" || param.oldJixin != ""){
			if(param.jixing != param.oldJixing || param.jixin != param.oldJixin){
				swal('','修改PID的时候机芯和机型不能变！', "warning");
				return false;
			}
		}
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/art/oem/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=rwdh]").val(result.rwdh);
					$("#form-submit [name=wjbh]").val(result.wjbh);
					$("#form-submit [name=zdrmc]").val(result.zdrmc);
					$("#form-submit [name=zdsj]").val(result.zdsj);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
					$("#form-submit [name=token]").val(result.token);
				}); 
			}
		});
	}
	// 提交
	function submit(){
		// 表单验证
		if(!$('#form-submit').valid()){
			return false;
		}
		if(!qtValid()){
			return false;
		}
		if(!bgValid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		if(param.oldJixing != "" || param.oldJixin != ""){
			if(param.jixing != param.oldJixing || param.jixin != param.oldJixin){
				swal('','修改PID的时候机芯和机型不能变！', "warning");
				return false;
			}
		}
		if(param.cpjl == "" ){
			swal('','请先选择产品经理再提交！','warning'); 
			return false;
		}
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/art/oem/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	
	function qtValid(){
		//选择其他时，需填写备注控制
		 if($("#form-submit [name=rzQt]").is(":checked") && $("#form-submit [name=rzQtBz]").val() == ""){
			swal('','请填写认证要求其他备注！', "warning");
	    	return false;
		 }
		 if(($("input[name='mkLogoWz']:checked").val() == 2 && $("#form-submit [name=mkLogoWzBz]").val() == "") 
		  || ($("input[name='mkLogoCc']:checked").val() == 2 && ($("#form-submit [name=mkLogoCcC]").val() == "" || $("#form-submit [name=mkLogoCcK]").val() == ""))
		  || ($("input[name='mkQtCc']:checked").val() == 2 && ($("#form-submit [name=mkQtCcC]").val() == "" || $("#form-submit [name=mkQtCcK]").val() == ""))
		  || ($("input[name='mkLogoGy']:checked").val() == 3 && $("#form-submit [name=mkLogoGyBz]").val() == "")
		  || ($("input[name='mkLogoYs']:checked").val() == 2 && $("#form-submit [name=mkLogoYsBz]").val() == "")
		  || ($("#form-submit [name=mkQt]").is(":checked") && $("#form-submit [name=mkQtBz]").val() == "")
		  || ($("input[name='mkQtWz']:checked").val() == 3 && $("#form-submit [name=mkQtWzBz]").val() == "")
		  || ($("input[name='mkQtGy']:checked").val() == 2 && $("#form-submit [name=mkQtGyBz]").val() == "")
		  || ($("input[name='mkQtYs']:checked").val() == 2 && $("#form-submit [name=mkQtYsBz]").val() == "")){
			swal('','请检查面壳：其他(和客户指定)选项，并填写备注！', "warning");
	    	return false;
		 }
		 if(($("input[name='ykqLogoGy']:checked").val() == 2 && $("#form-submit [name=ykqLogoGyBz]").val() == "") 
		  || ($("input[name='ykqLogoYs']:checked").val() == 3 && $("#form-submit [name=ykqLogoYsBz]").val() == "")
		  || ($("input[name='ykqLogoCc']:checked").val() == 2 && ($("#form-submit [name=ykqLogoCcC]").val() == "" || $("#form-submit [name=ykqLogoCcK]").val() == ""))
		  || ($("input[name='ykqQtCc']:checked").val() == 2 && ($("#form-submit [name=ykqQtCcC]").val() == "" || $("#form-submit [name=ykqQtCcK]").val() == ""))
		  || ($("#form-submit [name=ykqQt]").is(":checked") && $("#form-submit [name=ykqQtBz]").val() == "")
		  || ($("input[name='ykqQtWz']:checked").val() == 2 && $("#form-submit [name=ykqQtWzBz]").val() == "")
		  || ($("input[name='ykqQtGy']:checked").val() == 3 && $("#form-submit [name=ykqQtGyBz]").val() == "")
		  || ($("input[name='ykqQtY']:checked").val() == 3 && $("#form-submit [name=ykqQtYsBz]").val() == "")){
			swal('','请检查遥控器：其他(和客户指定)选项，并填写备注！', "warning");
	    	return false;
		 }
		 if(($("input[name='smsYzYz']:checked").val() == 5 && $("#form-submit [name=smsYzYzBz]").val() == "") 
		  || ($("input[name='smsYzCc']:checked").val() == 2 && $("#form-submit [name=smsYzCcBz]").val() == "")
		  || ($("input[name='smsYzYsys']:checked").val() == 3 && $("#form-submit [name=smsYzYsysBz]").val() == "")
		  || ($("input[name='smsYzCz']:checked").val() == 3 && $("#form-submit [name=smsYzCzBz]").val() == "")
		  || ($("input[name='smsDyzYz']:checked").val() == 3 && $("#form-submit [name=smsDyzYzBz]").val() == "")
		  || ($("input[name='smsDyzCc']:checked").val() == 2 && $("#form-submit [name=smsDyzCcBz]").val() == "")
		  || ($("input[name='smsDyzYsys']:checked").val() == 3 && $("#form-submit [name=smsDyzYsysBz]").val() == "")
		  || ($("input[name='smsDyzCz']:checked").val() == 5 && $("#form-submit [name=smsDyzCzBz]").val() == "")){
			swal('','请检查说明书：其他选项，并填写备注！', "warning");
	    	return false;
		 }
		 if($("input[name='dzazsmYz']:checked").val() == 2 && $("#form-submit [name=dzazsmYzBz]").val() == ""){
			swal('','请检查底座安装说明：其他选项，并填写备注！', "warning");
	    	return false;
		 }
		 if($("input[name='nxtzYlWz']:checked").val() == 3 && $("#form-submit [name=nxtzYlWzBz]").val() == ""){
			swal('','请检查能效贴纸：其他选项，并填写备注！', "warning");
	    	return false;
		 }
		 if($("input[name='bzkBkgCzysyq']:checked").val() == 2 && $("#form-submit [name=bzkBkgCzysyqBz]").val() == ""){
			swal('','请检查保证卡：其他选项，并填写备注！', "warning");
	    	return false;
		 }
		 if(($("input[name='zjxhtzXhbz']:checked").val() == 2 && $("#form-submit [name=zjxhtzXhbzBz]").val() == "") 
		  || ($("input[name='zjxhtzGsbzYljztwz']:checked").val() == 2 && $("#form-submit [name=zjxhtzGsbzYljztwzBz]").val() == "")
		  || ($("input[name='zjxhtzKgCc']:checked").val() == 2 && $("#form-submit [name=zjxhtzKgCcBz]").val() == "")
		  || ($("input[name='zjxhtzKgYljztwz']:checked").val() == 2 && $("#form-submit [name=zjxhtzKgYljztwzBz]").val() == "")){
			swal('','请检查整机序号贴纸：其他选项，并填写备注！', "warning");
	    	return false;
		 }
		 //部分选项选择后，子项必填
		 if($("input[name='zxtzZlbz']:checked").val() == 1 && $("#form-submit [name=zxtzBzzlTmh]").val() == ""){
			swal('','纸箱贴纸中请填写条码号！', "warning");
	    	return false;
		 }
		 if($("input[name='hgtzZlbz']:checked").val() == 1 && 
	        ($("#form-submit [name=hgtzBzzlJksxx]").val() == "" || $("#form-submit [name=hgtzBzzlZzsxx]").val() == "" || $("#form-submit [name=hgtzBzzlCdxx]").val() == "")){
			swal('','后盖贴纸中，基本信息不能为空，请填写基本信息！', "warning");
	    	return false;
		 }
		return true;
	}
	//变更校验
	function bgValid(){
		if($("#form-submit [name=sfBg]").val() == "1"){
			var bgNr = $("#form-submit [name=bgNr]").val();
			var bgYy = $("#form-submit [name=bgYy]").val();
			if(bgNr == null || bgNr == ""){
				swal('','变更时变更内容不能为空！', "warning");
		    	return false;
			}
			if(bgYy == null || bgYy == ""){
				swal('','变更时变更原因不能为空！', "warning");
		    	return false;
			}
		}
		return true;
	}
</script>
</html>