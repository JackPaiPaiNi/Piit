<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String processInstanceId = request.getParameter("processId");
		String sfView = request.getParameter("sfView");
		pageContext.setAttribute("processInstanceId", processInstanceId);
		pageContext.setAttribute("sfView", sfView);
	%>
	<style type="text/css">
		body{
			background: #fff !important;
		}
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
		.print_lable{
			width: 100%;
			float: left;
			color: blue; 
			font-size: 15px; 
			font-weight: bold; 
			background-color: #AAAAAA;
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
	<div style="text-align: center;">
		<input type="hidden" name="id" value="${artSkyworth.id}"/>
		<input type="hidden" name="sjc" value="${artSkyworth.sjc}"/>
		<input type="hidden" name="sfBg" value="${artSkyworth.sfBg}"/>
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 100%; text-align: right;">
					<c:if test="${processInstanceId != 'null' && processInstanceId != '' && processInstanceId != null}">
						<button id="btn-flow" type="button" class="btn btn-yellow btn-sm">
							<i class="fa-file-image-o icon-on-right bigger-110"></i>
							流程图
						</button>
						&nbsp;
					</c:if>
				</td>
			</tr>
		</table>
		<div style="font-size: large; font-weight: bold; padding: 5px;">外销产品美工任务单</div>
		<br>
	</div>
	<br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="4" style="font-size: 13px; text-align: left;">基本信息</th>
		</tr>
		<tr>
			<td style="width: 20%;"><b>任务单号:</b></td>
			<td style="width: 30%;">${artSkyworth.rwdh}</td>
			<td style="width: 20%;"><b>制单人:</b></td>
			<td style="width: 30%;">${artSkyworth.zdrmc}</td>
		</tr>
		<tr>
			<td><b>文件编号:</b></td>
			<td>${artSkyworth.wjbh}</td>
			<td><b>制单时间:</b></td>
			<td><fmt:formatDate value="${artSkyworth.zdsj}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td><b>销售员:</b></td>
			<td>${artSkyworth.xsymc}</td>
			<td><b>业务组:</b></td>
			<td>${artSkyworth.xszzmc} - ${artSkyworth.ywzmc}</td>
		</tr>
		<tr>
			<td><b>PID:</b></td>
			<td>${artSkyworth.pid}</td>
			<td><b>产品颜色标准:</b></td>
			<td>${artSkyworth.wkysbz}</td>
		</tr>
		<tr>
			<td><b>销往国家:</b></td>
			<td>${artSkyworth.xwgjmc}</td>
			<td><b>走货方式:</b></td>
			<td>${artSkyworth.zhfsmc}</td>
		</tr>
		<tr>
			<td><b>品牌:</b></td>
			<td>${artSkyworth.khpp}</td>
			<td><b>认证要求:</b></td>
			<td>
				<c:if test="${artSkyworth.rzWu == 1}">无&nbsp;&nbsp;</c:if>
		      	<c:if test="${artSkyworth.rzCe == 1}">能效&nbsp;&nbsp;</c:if>
				<c:if test="${artSkyworth.rzCb == 1}">CB&nbsp;&nbsp;</c:if>
		      	<c:if test="${artSkyworth.rzEtl == 1}">ETL&nbsp;&nbsp;</c:if>
		    	<c:if test="${artSkyworth.rzFcc == 1}">FCC&nbsp;&nbsp;</c:if>
		    	<c:if test="${artSkyworth.rzDb == 1}">杜比&nbsp;&nbsp;</c:if>
		    	<c:if test="${artSkyworth.rzDts == 1}">DTS&nbsp;&nbsp;</c:if>
		    	<c:if test="${artSkyworth.rzHdmi == 1}">HDMI&nbsp;&nbsp;</c:if>
		      	<c:if test="${artSkyworth.rzQt == 1}">其他&nbsp;&nbsp;${artSkyworth.rzQtBz}</c:if>
			</td>
		</tr>
		<tr>
			<td><b>买家型号:</b></td>
			<td>${artSkyworth.khxh}</td>
			<td><b>条码号:</b></td>
			<td>${artSkyworth.tmh}</td>
		</tr>
	</table>
	<br><br>
	<table class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="3" style="font-size: 13px; text-align: left;">美工要求</th>
		</tr>
		<tr>
			<td rowspan="2" style="width: 20%;"><b>1.面壳/装饰件/装饰条等:</b></td>
			<td rowspan="2" style="width: 40%;">
				<input type="checkbox" class="skycheckbox" <c:if test="${artSkyworth.mk == 1}">checked="checked"</c:if>>带LOGO
			</td>
			<td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.mkLx == 1}">checked="checked"</c:if>>1.公司标准工艺
			</td>
		</tr>
		<tr>
			<td>
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.mkLx == 2}">checked="checked"</c:if>>2.热烫贴牌<br><span style="color:red;">(成本较高且加工工艺复杂,除指定客户,普通客户不能选用）</span>
			</td>
		</tr>
		<tr>
		    <td style="width: 20%;"><b>2.遥控器</b></td>
		    <td colspan="2" style="width: 80%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.ykq == 1}">checked="checked"</c:if>>带LOGO&nbsp;
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.ykq == 2}">checked="checked"</c:if>>带型号
			</td>
		</tr>
		<tr>
		    <td style="width: 20%;"><b>3.端子功能丝印</b></td>
		    <td colspan="2" style="width: 80%;">
				<input type="checkbox" class="skycheckbox" <c:if test="${artSkyworth.dzgntp == 1}">checked="checked"</c:if>>英文
			</td>
		</tr>
		<tr>
		    <td rowspan="3" style="width: 20%;"><b>4.说明书或快速操作指南</b></td>
		    <td colspan="2" style="width: 80%;">
		    	<input type="radio" class="skyradio" <c:if test="${artSkyworth.ksczzn == 1}">checked="checked"</c:if>>英文
		    </td>
	    </tr>
	    <tr>
		    <td colspan="2" style="width: 80%;">
		    	<input type="radio" class="skyradio" <c:if test="${artSkyworth.ksczzn == 2}">checked="checked"</c:if>>其他语种
		    	 <c:if test="${artSkyworth.ksczzn == 2}"><span style="text-decoration: underline;">${artSkyworth.ksczznBz}</span>&nbsp;<span style="color:red;"> (对于多语种，此处语种的排序，即资料语种的排序。）</span></c:if>
		    </td>
		</tr>
		<tr>
		    <td style="width: 40%;">
		    	<input type="checkbox" class="skycheckbox" <c:if test="${artSkyworth.ksczznGwcg == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
			</td>
		    <td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.ksczznSqbh == 1}">checked="checked"</c:if>>需要申请编号
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.ksczznSqbh == 2}">checked="checked"</c:if>>不需要申请编号
			</td>
		</tr>
		<tr>
		    <td rowspan="3" style="width: 20%;"><b>5.底座安装说明</b></td>
		    <td colspan="2" style="width: 80%;">
		    	<input type="radio" class="skyradio" <c:if test="${artSkyworth.dzazsm == 1}">checked="checked"</c:if>>英文
		    </td>
	    </tr>
	    <tr>
		    <td colspan="2" style="width: 80%;">
		    	<input type="radio" class="skyradio" <c:if test="${artSkyworth.dzazsm == 2}">checked="checked"</c:if>>其他语种
		    	 <c:if test="${artSkyworth.dzazsm == 2}"><span style="text-decoration: underline;">${artSkyworth.dzazsmBz}</span>&nbsp;<span style="color:red;"> (对于多语种，此处语种的排序，即资料语种的排序。）</span></c:if>
		    </td>
		</tr>
		<tr>
		    <td style="width: 40%;">
		    	<input type="checkbox" class="skycheckbox" <c:if test="${artSkyworth.dzazsmGwcg == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
			</td>
		    <td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.dzazsmSqbh == 1}">checked="checked"</c:if>>需要申请编号
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.dzazsmSqbh == 2}">checked="checked"</c:if>>不需要申请编号
			</td>
		</tr>
		<tr>
		    <td rowspan="3" style="width: 20%;"><b>6.纸箱</b></td>
		    <td colspan="2" style="width: 80%;">
		    	<input type="radio" class="skyradio" <c:if test="${artSkyworth.zx == 1}">checked="checked"</c:if>>卡通箱
		    </td>
	    </tr>
	    <tr>
		    <td colspan="2" style="width: 80%;">
		    	<input type="radio" class="skyradio" <c:if test="${artSkyworth.zx == 2}">checked="checked"</c:if>>彩箱
		    </td>
		</tr>
		<tr>
		    <td style="width: 40%;">
		    	<input type="checkbox" class="skycheckbox" <c:if test="${artSkyworth.zxGwcg == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
			</td>
		    <td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.zxSqbh == 1}">checked="checked"</c:if>>需要申请编号
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.zxSqbh == 2}">checked="checked"</c:if>>不需要申请编号
			</td>
		</tr>
		<tr>
    		<td rowspan="2" style="width: 20%;"><b>7.纸箱型号贴纸</b></td>
    		<td colspan="2" style="width: 80%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.zxxhtz == 1}">checked="checked"</c:if>>需要,2个用量&nbsp;
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.zxxhtz == 0}">checked="checked"</c:if>>不需要
			</td>
        </tr>
        <tr>
    		<td style="width: 40%;">
            	<input type="checkbox" class="skycheckbox" <c:if test="${artSkyworth.zxxhtzGwcg == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
            </td>
    		<td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.zxxhtzSqbh == 1}">checked="checked"</c:if>>需要申请编号
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.zxxhtzSqbh == 2}">checked="checked"</c:if>>不需要申请编号
			</td>
        </tr>
        <tr>
    		<td rowspan="2" style="width: 20%;"><b>8.后盖贴纸</b></td>
    		<td colspan="2" style="width: 80%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.hgtz == 1}">checked="checked"</c:if>>需要
			</td>
        </tr>
        <tr>
    		<td style="width: 40%;">
            	<input type="radio" class="skyradio" <c:if test="${artSkyworth.hgtz == 2}">checked="checked"</c:if>>国外采购,只提供电子文档资料
            </td>
    		<td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.hgtzSqbh == 1}">checked="checked"</c:if>>需要申请编号
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.hgtzSqbh == 2}">checked="checked"</c:if>>不需要申请编号
			</td>
        </tr>
        <tr>
    		<td rowspan="2" style="width: 20%;"><b>9.能效贴纸</b></td>
    		<td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.nxtz == 1}">checked="checked"</c:if>>需要
			</td>
			<td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.nxtz == 2}">checked="checked"</c:if>>不需要
			</td>
        </tr>
        <tr>
    		<td style="width: 40%;">
            	<input type="radio" class="skyradio" <c:if test="${artSkyworth.nxtz == 3}">checked="checked"</c:if>>国外采购,只提供电子文档资料
            </td>
    		<td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.nxtzSqbh == 1}">checked="checked"</c:if>>需要申请编号
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.nxtzSqbh == 2}">checked="checked"</c:if>>不需要申请编号
			</td>
        </tr>
        <tr>
    		<td rowspan="2" style="width: 20%;"><b>10.保证卡</b></td>
    		<td colspan="2" style="width: 80%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.bzk == 1}">checked="checked"</c:if>>需要&nbsp;
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.bzk == 0}">checked="checked"</c:if>>不需要
			</td>
        </tr>
        <tr>
    		<td style="width: 40%;">
            	<input type="checkbox" class="skycheckbox" <c:if test="${artSkyworth.bzkGwcg == 1}">checked="checked"</c:if>>国外采购,只提供电子文档资料
            </td>
    		<td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.bzkSqbh == 1}">checked="checked"</c:if>>需要申请编号
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.bzkSqbh == 2}">checked="checked"</c:if>>不需要申请编号
			</td>
        </tr>
        <tr>
    		<td rowspan="2" style="width: 20%;"><b>11.维修贴纸</b></td>
    		<td colspan="2" style="width: 80%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.wxtz == 1}">checked="checked"</c:if>>需要
			</td>
        </tr>
        <tr>
    		<td style="width: 40%;">
            	<input type="radio" class="skyradio" <c:if test="${artSkyworth.wxtz == 2}">checked="checked"</c:if>>国外采购,只提供电子文档资料
            </td>
    		<td style="width: 40%;">
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.wxtzSqbh == 1}">checked="checked"</c:if>>需要申请编号
				<input type="radio" class="skyradio" <c:if test="${artSkyworth.wxtzSqbh == 2}">checked="checked"</c:if>>不需要申请编号
			</td>
        </tr>
        <tr>
    		<td rowspan="3" style="width: 20%;"><b>12.整机序号贴纸</b></td>
    		<td colspan="2" style="width: 80%;">
    			<input type="checkbox" class="skycheckbox" <c:if test="${artSkyworth.zjxhtz == 1}">checked="checked"</c:if>>公司标准序列号(订单号+递增流水号）
    		</td>
        </tr>
        <tr>
    		<td colspan="2" style="width: 80%;">
    			<input type="radio" class="skyradio" <c:if test="${artSkyworth.zjxhtzBzcc == 1}">checked="checked"</c:if>>标准尺寸(45X15MM),产线打印
    			<input type="radio" class="skyradio" <c:if test="${artSkyworth.zjxhtzBzcc == 2}">checked="checked"</c:if>>标准尺寸(25X6MM),产线打印
    		</td>
        </tr>
        <tr>
    		<td colspan="2" style="width: 80%;">
    			<input type="radio" class="skyradio" <c:if test="${artSkyworth.zjxhtzYl == 1}">checked="checked"</c:if>>3个用量，分别贴于后壳、纸箱1侧和保证卡上
    			<input type="radio" class="skyradio" <c:if test="${artSkyworth.zjxhtzYl == 2}">checked="checked"</c:if>>其他
    			<c:if test="${artSkyworth.zjxhtzYl == 2}"><span style="text-decoration: underline;">${artSkyworth.zjxhtzYlBz}</span></c:if>
    		</td>
        </tr>
        <tr>
        	<td><b>12.美工其他要求</b></td>
			<td colspan="2"><PRE class="pre">${artSkyworth.mgqtyq}</PRE></td>
		</tr>
			<tr>
				<td><b>&nbsp;&nbsp;附件</b></td>
				<c:set var="fj" value="${artSkyworth.fj}"/>
				<c:set var="fjxx" value="${fn:replace(fj,'icon-remove', 'fa fa-file')}"/>
				<td colspan="2">${fn:replace(fjxx,'red', '')}</td>
			</tr>
		<tr>
        	<td><b>&nbsp;&nbsp;美工组件号</b></td>
			<td colspan="2">${artSkyworth.mgzjh}</td>
		</tr>
	</table>
	<br>
	<c:if test="${artSkyworth.sfBg == 1 || artSkyworth.bbh != 1}">
		<div style="text-align: center;">
			<div style="font-size: large; font-weight: bold; padding: 5px;">外销美工需求变更单</div>
		</div>
		<br>
		<table class="print_table" cellspacing="0" cellpadding="0">
			<tr>
				<td style="width: 15%;" rowspan="3">是否已量产</td>
				<td colspan="3" class="align_left" style="width: 85%;">
					<input type="radio" class="skyradio" <c:if test="${artSkyworth.bgSflc == 0}">checked="checked"</c:if>>否
				</td>
			</tr>
			<tr>
				<td class="align_left" rowspan="2">
					<input type="radio" class="skyradio" <c:if test="${artSkyworth.bgSflc == 1}">checked="checked"</c:if>>是
				</td>
				<td class="align_left" colspan="2" >
					<input type="radio" class="skyradio" <c:if test="${artSkyworth.bgSflcValue == 1}">checked="checked"</c:if>>
					暂无量产订单,从此变更通知发出开始更改
				</td>
			</tr>
			<tr>
				<td class="align_left" colspan="2">
					<input type="radio" class="skyradio" <c:if test="${artSkyworth.bgSflcValue == 2}">checked="checked"</c:if>>
					从&nbsp;<span style="text-decoration: underline;">${artSkyworth.bgLcksddh}</span>订单开始更改
				</td>
			</tr>
			<tr>
				<td style="width: 15%;">变更申请人</td>
				<td class="align_left" style="width: 35%;">${artSkyworth.zdrmc}</td>
				<td>变更申请时间</td>
				<td class="align_left"><fmt:formatDate value="${artSkyworth.zdsj}" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
	        	<td><b>变更内容</b></td>
				<td colspan="3"><PRE class="pre">${artSkyworth.bgNr}</PRE></td>
			</tr>
			<tr>
	        	<td><b>变更原因</b></td>
				<td colspan="3"><PRE class="pre">${artSkyworth.bgYy}</PRE></td>
			</tr>
		</table>
		<br>
	</c:if>
	<c:if test="${sfView == 1 && artSkyworth.bbh > 1}">
	<br>
		<table class="print_table" cellspacing="0" cellpadding="0">
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
			<c:forEach items="${artSkyworth.htylist}" var="item">
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
	<table id="print_table_div" class="print_table" cellspacing="0" cellpadding="0">
		<tr>
			<th colspan="8" style="font-size: 13px; text-align: left;">审批日志</th>
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
		<c:forEach items="${artSkyworth.logList}" var="item">
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
</body>
<script type="text/javascript">
var splog=false;
	$(function($){
		$(".skycheckbox").prop("disabled","disabled");
		$(".skyradio").prop("disabled","disabled");

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
		url = "<c:url value='/art/artSkyworth/showPage'/>" + "?rwdh=" + rwdh + "&bbh=" + bbh + "&sfView=0";
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