<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/WEB-INF/views/index/taglib.jsp"%>
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.util.js?v=12"></script>
	<style type="text/css">
		.print_page{
			width: 968px;
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
    <div align='right'><b>编号：</b><u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    								</u></div>
    <h2 align='center'><u>深圳创维-RGB电子有限公司研发总部海外产品研究院 </u></h2>
    <h1 align='center'><u>PID软件发布表</u></h1>
	<table  cellspacing="0" cellpadding="0" border='0'>
		<tr>
			<td style="width: 33%"><b>部门：</b>
			   <u>
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			   </u></td>
			<td style="width: 33%"><b>产品（机芯+机型）：</b><u>
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      ${pidInfo.jixin}-${pidInfo.jixing}
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			     </u></td>
			<td style="width: 33%"><b>软件虚拟物料号：</b>
				<u>
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</u>
		    </td>
			
		</tr>
		<tr>
		    <td style="width: 33%"><b>数据包编号：</b>
		    <u>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;</u></td>
			<td style="width: 33%"><b>屏编号及分辨率：</b>
			<u>
			      &nbsp;&nbsp;&nbsp;
			       ${pidInfo.pbh}(${pidInfo.fblmc})
			      &nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp</u></td>
			<td style="width: 33%"><b>PID号/订单号：</b>
			     <u>
			     	 &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
			          ${pidInfo.pid}
			         &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
			     </u>
			</td>
		</tr>
		<tr>
			 <td style="width: 25%"><b>设计师：</b><u>
					  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				      &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
			</u></td>
			<td style="width: 25%"><b>日期：</b><u>
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
			</u></td>
			 <td style="width: 33%"><b>项目经理审核：</b><u>
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;
			</u></td>
		</tr>
		<tr>
			<td style="width: 33%"><b>日期：</b><u>
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      
			</u></td>
			<td style="width: 33%"><b>部门领导批准：</b><u>
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			 </u></td>
			 <td style="width: 33%"><b>日期：</b><u>
				  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			      
			      </u></td>
		</tr>
	</table>
	<h2>1、摘要</h2>
	<table  class="print_table"  cellspacing="0" cellpadding="0" boder="1px">
	  <tr>
	    <td style="width: 10%"><b>方案主芯片</b></td>
	    <td colspan="2" style="width: 90%"><b></b></td>
	  </tr>
	   <tr>
	    <td style="width: 10%"><b>源代码路径</b></td>
	    <td colspan="2" style="width: 90%"><b></b></td>
	  </tr>
	  <tr>
	     <td style="width: 10%" rowspan="3"  ><b>校验码信息</b></td>
	     <td style="width: 15%" ><b>校验码</b></td>
	     <td style="width: 75%" >&nbsp;</td>
	  </tr>
	  <tr>
	    <td  style="width: 10%"><b>校验码获取方式 </b></td>
	    <td  style="width: 90%">&nbsp;</td>
	  </tr>
	  <tr>
	    <td  style="width: 10%"><b>未使用字节填充方式</b></td>
	    <td  style="width: 90%">&nbsp;</td>
	  </tr>
	</table>
	<h2>2、软件主要功能或设置</h2>
	<table  class="print_table"  cellspacing="0" cellpadding="0" boder="1px">
	  <tr>
	     <td  style="width: 10%" ><b>声音功能</b></td>
	     <td  style="width: 90%" >
	     	  <input type="checkbox" class="skyreadonly" >NICAM &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > A2  &nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" > SAP  &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 其他功能:<u>
	     	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
	     </td>
	  </tr>
	  <tr>
	     <td  style="width: 10%" ><b>语言</b></td>
	     <td  style="width: 90%" >
	     	  <input type="checkbox" class="skyreadonly" > 简体中文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 繁体中文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 英文&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 法文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 德文  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	     	  <input type="checkbox" class="skyreadonly" > 意大利文  &nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 西班牙文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 葡萄牙文  &nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 俄文  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <br>
	     	  <input type="checkbox" class="skyreadonly" > 保加利亚文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 塞尔维亚文&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 土耳其文&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 波兰文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 克罗地亚文
	     	  <input type="checkbox" class="skyreadonly" > 捷克文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 丹麦文  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 罗马尼亚文 
	     	  <input type="checkbox" class="skyreadonly" > 斯洛文尼亚文&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>
	     	  <input type="checkbox" class="skyreadonly" > 斯洛伐克文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" > 泰文  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; 
	     	  <input type="checkbox" class="skyreadonly" > 挪威文  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 瑞典文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	     	  <input type="checkbox" class="skyreadonly" > 阿拉伯文&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 波斯文 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
	     	  <input type="checkbox" class="skyreadonly" > 芬兰文  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 希伯来文  &nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 越南文 &nbsp;&nbsp;&nbsp;&nbsp;<br>
	     	  <input type="checkbox" class="skyreadonly" > 其它语言   &nbsp;&nbsp;
	     	  <u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	     ${pidInfo.osdyy}
	     	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
	      </td>
	  </tr>
	   <tr>
	     <td  style="width: 10%" ><b>其他功能</b></td>
	     <td  style="width: 90%" >
	     	  <input type="checkbox" class="skyreadonly" > 120HZ  &nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" >  酒店功能   &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > Android  &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 3D/PR   &nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" > 3D/SG   &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 内置 WIFI  &nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" > 网络功能    &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > 在线升级  &nbsp;&nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" > Miracast   &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > DLNA   &nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" > Divx   &nbsp;&nbsp;<br>
	     	  <input type="checkbox" class="skyreadonly" > MHL   &nbsp;&nbsp; &nbsp; 
	     	  <input type="checkbox" class="skyreadonly" > Netflix   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > CTS 认证    
	     	  <input type="checkbox" class="skyreadonly" > OFTA    &nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" > CI    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > CI+   &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;	   
	     	  <input type="checkbox" class="skyreadonly" > Hbb TV    &nbsp;&nbsp; &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > Free View     &nbsp;&nbsp;
	     	  <input type="checkbox" class="skyreadonly" > youtube    &nbsp;&nbsp;  
	     	  <input type="checkbox" class="skyreadonly" > Opera     &nbsp;&nbsp;<br>
	     	  <input type="checkbox" class="skyreadonly" >  其它功能  &nbsp;&nbsp;
	     	  <u>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	     	     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</u>
	     </td>
	  </tr>
	</table>
	<h4 align="center">研发总部海外产品研究院 </h4>
	<hr>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0" boder="1px">
	<tr>
		<td style="width: 25%"><b>LOGO</b></td>
		<td style="width: 25%" colspan="2">软件默认设置</td>
	</tr>
	<tr>
		<td style="width: 25%"><b>国家（地区）</b></td>
		<td style="width: 25%" colspan="2">${pidInfo.xwgjmc}</td>
	</tr>
	<tr>
		<td style="width: 25%"><b>语言</b></td>
		<td style="width: 25%" colspan="2"></td>
	</tr>
	<tr>
		<td style="width: 25%"><b>其他</b></td>
		<td style="width: 25%" colspan="3"></td>	
	</tr>
	</table>
	<h2 align="left">附录一 编译次序及关键配置技术说明</h2>
	<table style="border:1px solid ">
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	</table>
	<h2 align="left">附录二 软件烧写方法详细步骤说明（只限文字说明，不可使图片） </h2>
	<table style="border:1px solid 	#000000">
	    <tr><td>&nbsp;</td></tr>
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	</table>
	<table style="border:1px solid 	#000000">
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	    <tr><td>&nbsp;</tr>
	</table>
</div>
</body>
<script type="text/javascript">
	$(function($){
		$(".skyreadonly").addReadonly();
	});
</script>
</html>