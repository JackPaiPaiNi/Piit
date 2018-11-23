<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.util.js?v=12"></script>
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
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">基本信息</th>
		</tr>
		<tr>
			<td style="width: 25%"><b>PID：</b>${pidInfo.pid}</td>
			<td style="width: 25%"><b>申请人：</b>${pidInfo.zdrmc}</td>
			<td style="width: 25%"><b>申请人日期：</b><fmt:formatDate value="${pidInfo.cjsj}" pattern="yyyy-MM-dd"/></td>
			<td style="width: 25%"><b>计划完成时间：</b><fmt:formatDate value="${pidInfo.jhwcsj}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td><b>出货要求完成时间：</b><fmt:formatDate value="${pidInfo.chyqwcsj}" pattern="yyyy-MM-dd"/></td>
			<td><b>预计年销售量：</b>${pidInfo.yjnxsl}</td>
			<td><b>状态：</b>${pidInfo.ztmc}</td>
			<td><b>PID流水号：</b>${pidInfo.pidxh}</td>
		</tr>
		<tr>
			<td style="width: 25%"><b>客户名称：</b>${pidInfo.khmc}</td>
			<td style="width: 25%"><b>品牌名称：</b>${pidInfo.pp}</td>
			<td style="width: 25%"><b>机型：</b>${pidInfo.jixing}</td>
			<td style="width: 25%"><b>机芯：</b>${pidInfo.jixin}</td>
		</tr>
		<tr>
			<td><b>尺寸：</b>${pidInfo.cc}</td>
			<td><b>走货方式：</b>${pidInfo.zhfsmc}</td>
		    <td><b>加工方式：</b>${pidInfo.jgfsmc}</td>
			<td><b>销往国家：</b>${pidInfo.xwgjmc}</td>		
		</tr>
		<tr>
			<td><b>网络：</b>${pidInfo.wlmc}</td>
			<td></td>
			<td></td>
		    <td></td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">产品概述</th>
		</tr>
		<tr>
			<td style="width: 25%"><b>客户名称：</b>${pidInfo.khmc}</td>
			<td style="width: 25%"><b>品牌名称：</b>${pidInfo.pp}</td>
			<td style="width: 25%"><b>机型：</b>${pidInfo.jixing}</td>
			<td style="width: 25%"><b>机芯：</b>${pidInfo.jixin}</td>
		</tr>
		<tr>
			<td><b>尺寸：</b>${pidInfo.cc}</td>
			<td><b>走货方式：</b>${pidInfo.zhfsmc}</td>
			<td><b>销往国家：</b>${pidInfo.xwgjmc}</td>
			<td><b>网络：</b>${pidInfo.wlmc}</td>
		</tr>
		<tr>
			<td colspan="3"><b>认证：安全</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Cb == 1}">checked="checked"</c:if>>CB&nbsp;&nbsp;  
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Etl == 1}">checked="checked"</c:if>>ETL&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Cetl == 1}">checked="checked"</c:if>>cETL&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Paq == 1}">checked="checked"</c:if>>PSE-安全&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Raq == 1}">checked="checked"</c:if>>RED-安全&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Smaq == 1}">checked="checked"</c:if>>S-mark 安全
			</td>
			<td colspan="1">${pidInfo.rz1Bz}</td>
		</tr>
		<tr>
			<td colspan="3"><b>认证：电磁兼容</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz2Emc == 1}">checked="checked"</c:if>>EMC&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz2Fcc == 1}">checked="checked"</c:if>>FCC&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz2Rtte == 1}">checked="checked"</c:if>>RTTE&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz2Pe == 1}">checked="checked"</c:if>>PSE-EMC&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz2Rr == 1}">checked="checked"</c:if>>RED-RF&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz2Sme == 1}">checked="checked"</c:if>>S-mark -EMC
			</td >
			<td colspan="1">${pidInfo.rz2Bz}</td>
		</tr>
		<tr>
			<td colspan="3"><b>认证：能效</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz4Erp == 1}">checked="checked"</c:if>>ERP&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz4Gems == 1}">checked="checked"</c:if>>GEMS&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz4Bee == 1}">checked="checked"</c:if>>BEE&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz4Nrc == 1}">checked="checked"</c:if>>NRcan&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz4Nfnx == 1}">checked="checked"</c:if>>南非能效&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz4Eg == 1}">checked="checked"</c:if>>Energy Guide
			</td>
			<td colspan="1">${pidInfo.rz4Bz}</td>
		</tr>
		<tr>
			<td colspan="3"><b>认证：专利</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz3Hdmi == 1}">checked="checked"</c:if>>HDMI&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz3Dd == 1}">checked="checked"</c:if>>DD&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz3Dts == 1}">checked="checked"</c:if>>DTS&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz3Cij == 1}">checked="checked"</c:if>>CI+&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz3Bqb == 1}">checked="checked"</c:if>>BQB&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz3Mhl == 1}">checked="checked"</c:if>>MHL
			</td>
			<td colspan="1">${pidInfo.rz3Bz}</td>
		</tr>
		<tr>
			<td colspan="4"><b>老格式认证项：（新下PID不能勾选）</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Ce == 1}">checked="checked"</c:if>>CE&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Ul == 1}">checked="checked"</c:if>>UL&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Pse == 1}">checked="checked"</c:if>>PSE&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz2Meps == 1}">checked="checked"</c:if>>MEPS&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz2Es == 1}">checked="checked"</c:if>>Energy Star&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz3Usb == 1}">checked="checked"</c:if>>USB&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Rf == 1}">checked="checked"</c:if>>RF&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Rte == 1}">checked="checked"</c:if>>RTE&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Cet == 1}">checked="checked"</c:if>>cETLus&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz1Nom == 1}">checked="checked"</c:if>>NOM&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz3Ddj == 1}">checked="checked"</c:if>>DD+&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz4Es7 == 1}">checked="checked"</c:if>>Energy star 7.0
			</td>
		</tr>
		<tr>
			<td colspan="4"><b>认证：其他</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.rz5Qt == 1}">checked="checked"</c:if>>其他
			</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">产品功能需求</th>
		</tr>
		<tr>
			<td style="width: 25%"><b>电源插头：</b>${pidInfo.ctlxmc}</td>
			<td style="width: 25%">${pidInfo.ctlxbz}</td>
			<td style="width: 25%"><b>电压：</b>${pidInfo.dianyamc}</td>
			<td style="width: 25%">${pidInfo.dianyabz}</td>
		</tr>
		<tr>
			<td><b>是否需要电源开关：</b>
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sfDykg == 1}">checked="checked"</c:if>>需要
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sfDykg == 0}">checked="checked"</c:if>>不需要
			</td>
			<td><b>是否需要REACH：</b>
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sfReach == 1}">checked="checked"</c:if>>需要
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sfReach == 0}">checked="checked"</c:if>>不需要
			</td>
			<td><b>待机功率：</b>${pidInfo.djglmc}</td>
			<td>${pidInfo.djglbz}</td>
		</tr>
		<tr>
			<td><b>WIFI：</b>${pidInfo.wifimc}</td>
			<td>${pidInfo.wifibz}</td>
			<td colspan="4"><b>附加功能：</b>
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fjgbPgs3d == 1}">checked="checked"</c:if>>偏光式3D&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fjgnKms3d == 1}">checked="checked"</c:if>>快门式3D&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fjgnCij == 1}">checked="checked"</c:if>>CI+&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fjgnCi == 1}">checked="checked"</c:if>>CI&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fjgnScart == 1}">checked="checked"</c:if>>SCART&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td><b>3D眼镜盒：</b>${pidInfo.sl3dyjh}</td>
			<td colspan="3"><b>OSD语言：</b>${pidInfo.osdyy}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">结构特性</th>
		</tr>
		<tr>
			<td style="width: 25%"><b>外壳颜色标准化：</b>${pidInfo.wkysbz}</td>
			<td style="width: 25%"><b>屏分类：</b>${pidInfo.pfl}</td>
			<td style="width: 25%"><b>屏品牌：</b>${pidInfo.ppp}</td>
			<td style="width: 25%"><b>屏型号：</b>${pidInfo.pxh}</td>
		</tr>
		<tr>
			<td><b>屏编号：</b>${pidInfo.pbh}</td>
			<td><b>挂机包装：</b>${pidInfo.gjbzmc}</td>
			<td><b>泡沫：</b>${pidInfo.paomomc}</td>
			<td>${pidInfo.paomobz}</td>
		</tr>
		<tr>
			<td colspan="2"><b>防火料：</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fhlQk == 1}">checked="checked"</c:if>>前壳&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fhlHk == 1}">checked="checked"</c:if>>后壳&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fhlDzjlz == 1}">checked="checked"</c:if>>底座及立柱&nbsp;&nbsp;
		      	<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.fhlAvzj == 1}">checked="checked"</c:if>>AV支架
			</td>
			<td><b>底座包装：</b>${pidInfo.dzbzmc}</td>
			<td>${pidInfo.dzbzbz}</td>
		</tr>
		<tr>
			<td><b>挂架：</b>${pidInfo.guajiamc}</td>
			<td>${pidInfo.guajiabz}</td>
			<td><b>分辨率：</b>${pidInfo.fblmc}</td>
			<td>${pidInfo.fblbz}</td>
		</tr>
		<tr>
			<td><b>电源：</b>${pidInfo.dymc}</td>
			<td>${pidInfo.dybz}</td>
			<td><b>遥控器：</b>${pidInfo.ykqmc}</td>
			<td>${pidInfo.ykqbz}</td>
		</tr>
		<tr>
			<td><b>2D/3D：</b>
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sf3d == 0}">checked="checked"</c:if>>2D
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sf3d == 1}">checked="checked"</c:if>>3D
			</td>
			<td><b>电池：</b>
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sfDc == 1}">checked="checked"</c:if>>需要
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sfDc == 0}">checked="checked"</c:if>>不需要
			</td>
			<td><b>OSD出厂语言设置：</b>${pidInfo.osdccyysz}</td>
			<td><b>开机LOGO：</b>${pidInfo.kjlogo}</td>
		</tr>
		<tr>
			<td><b>模拟量标准：</b>${pidInfo.mnlbzmc}</td>
			<td>${pidInfo.mnlbzbz}</td>
			<td><b>质量标准：</b>${pidInfo.zlbzmc}</td>
			<td>${pidInfo.zlbzbz}</td>
		</tr>
		<tr>
			<td><b>实验报告：</b>
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sfSybg == 1}">checked="checked"</c:if>>是
				<input type="radio" class="skyreadonly" <c:if test="${pidInfo.sfSybg == 0}">checked="checked"</c:if>>否
			</td>
			<td colspan="3">${pidInfo.sybgbz}</td>
		</tr>
		<tr>
			<td colspan="2"><b>音视频支持格式：</b>${pidInfo.yspzcgsmc}</td>
			<td colspan="2">${pidInfo.yspzcgebz}</td>
		</tr>
		<tr>
			<td colspan="2"><b>网络功能要求：</b>${pidInfo.wlgnyqmc}</td>
			<td colspan="2">${pidInfo.wlgnyqbz}</td>
		</tr>
		<tr>
			<td colspan="2"><b>附件：</b>${pidInfo.fj}</td>
			<td colspan="2"><b>其他备注：</b>${pidInfo.qtbz}</td>
		</tr>
	</table>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">工程师选择</th>
		</tr>
		<tr>
			<td style="width: 25%"><b>电子工程师：</b>${pidInfo.dzgcsmc}</td>
			<td style="width: 25%"><b>电源工程师：</b>${pidInfo.dygcsmc}</td>
			<td style="width: 25%"><b>结构工程师：</b>${pidInfo.jggcsmc}</td>
			<td style="width: 25%">&nbsp;</td>
		</tr>
	</table>
	<br>

	<table  class="print_table" cellspacing="0" cellpadding="0">
	    <tr>
			<th colspan="6" style="font-size: 13px; text-align: left;">其他信息</th>
		</tr>
		<tr>
			<td colspan="4"><b>专利名称：</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc1 == 1}">checked="checked"</c:if>>DD&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc2 == 1}">checked="checked"</c:if>>DD+&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc3 == 1}">checked="checked"</c:if>>Vision&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc4 == 1}">checked="checked"</c:if>>MS12 version2.0&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc5 == 1}">checked="checked"</c:if>>MS12 version2.0+Atmos for TV&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc6 == 1}">checked="checked"</c:if>>MS12 version2.0+Atmos for TV+Atmos speaker system&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc7 == 1}">checked="checked"</c:if>>MS12 version1.3&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc8 == 1}">checked="checked"</c:if>>MS12 version1.3+DAP&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc9 == 1}">checked="checked"</c:if>>Premium Sound&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc10 == 1}">checked="checked"</c:if>>Sound&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc11 == 1}">checked="checked"</c:if>>Freespace&nbsp;&nbsp;<br>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc12 == 1}">checked="checked"</c:if>>MHL&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc13 == 1}">checked="checked"</c:if>>HDMI&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc14 == 1}">checked="checked"</c:if>>JAVA&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc15 == 1}">checked="checked"</c:if>>HEAAC&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc16 == 1}">checked="checked"</c:if>>ATSC&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc17 == 1}">checked="checked"</c:if>>MPEG-4&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc21 == 1}">checked="checked"</c:if>>MS11&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.zlmc22 == 1}">checked="checked"</c:if>>MS11+DAP
			</td>
		</tr>
		<tr>
			<td colspan="4"><b>平台名称：</b>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc1 == 1}">checked="checked"</c:if>>playready&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc2 == 1}">checked="checked"</c:if>>Opera 2016（浏览器）&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc3 == 1}">checked="checked"</c:if>>Opera 2016（TV store）&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc4 == 1}">checked="checked"</c:if>>Opera 2018&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc5 == 1}">checked="checked"</c:if>>Access BML Browser&nbsp;&nbsp;<br>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc6 == 1}">checked="checked"</c:if>>Seraphic浏览器（6488）&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc7 == 1}">checked="checked"</c:if>>Seraphic浏览器（72563）&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc8 == 1}">checked="checked"</c:if>>米高乐多国语言输入法&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc9 == 1}">checked="checked"</c:if>>Monotype字库&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc10 == 1}">checked="checked"</c:if>>Netrange2982/2984&nbsp;&nbsp;<br>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc11 == 1}">checked="checked"</c:if>>Netrange6488&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc12 == 1}">checked="checked"</c:if>>ICFLIX &nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc13 == 1}">checked="checked"</c:if>>Ginga库（mirakulo）&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc14 == 1}">checked="checked"</c:if>>Foxxum埃及72563&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc15 == 1}">checked="checked"</c:if>>Foxxum欧洲72562&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc16 == 1}">checked="checked"</c:if>>Coocaa后台&nbsp;&nbsp;<br>
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc17 == 1}">checked="checked"</c:if>>Updatelogic&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc18 == 1}">checked="checked"</c:if>>BBC&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc19 == 1}">checked="checked"</c:if>>Aptoide&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc20 == 1}">checked="checked"</c:if>>CI KEY&nbsp;&nbsp;
				<input type="checkbox" class="skyreadonly" <c:if test="${pidInfo.ptmc21 == 1}">checked="checked"</c:if>>widewine
			</td>
		</tr>
		<tr>
			<td style="width: 25%"><b>商标：</b>${pidInfo.sb}</td>
			<td style="width: 25%"><b>产品名称：</b>${pidInfo.cpmc}</td>
			<td style="width: 25%"><b>客户型号：</b>${pidInfo.khxh}</td>
			<td style="width: 25%"><b>制造商：</b>${pidInfo.zzs}</td>
		</tr>
		<tr>
			<td style="width: 25%"><b>WIFI型号：</b>${pidInfo.wifixh}</td>
			<td style="width: 25%"><b>主板组件号：</b>${pidInfo.zbzjh}</td>
			<td style="width: 25%"><b>特殊需求：</b>${pidInfo.tsxq}</td>
			<td style="width: 25%"><b>主板组件号：</b>${pidInfo.zbzjh}</td>
		</tr>
		<tr>
			<td colspan="4"><PRE class="pre"><b>工厂：</b>${pidInfo.gc}</PRE></td>
		</tr>
		<tr>
			<td colspan="4"><PRE class="pre"><b>提交人意见：</b>${pidInfo.tjryj}</PRE></td>
		</tr>
	</table>
    <br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="7" style="font-size: 13px; text-align: left;">审批日志</th>
		</tr>
		<tr>
			<td style="width: 14%"><b>PID：</b></td>
			<td style="width: 14%"><b>操作类型：</b></td>
			<td style="width: 14%"><b>操作职位：</b></td>
			<td style="width: 14%"><b>操作人账号：</b></td>
			<td style="width: 14%"><b>操作人名称：</b></td>
			<td style="width: 14%"><b>操作时间：</b></td>
			<td style="width: 14%"><b>处理意见：</b></td>
		</tr>
		<c:forEach items="${pidInfo.logList}" var="item">
			<tr>
				<td>${item.pid}</td>
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
</body>
<script type="text/javascript">
	$(function($){
		$(".skyreadonly").addReadonly();
	});
</script>
</html>