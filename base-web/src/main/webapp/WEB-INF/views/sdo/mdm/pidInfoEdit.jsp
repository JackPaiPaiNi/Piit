<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
	
<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
	<!-- 富文本框使用引入 -->
	<link href="<%=request.getContextPath()%>/static/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/umeditor/umeditor.config.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/umeditor/umeditor.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/umeditor/lang/zh-cn/zh-cn.js"></script>
	
	
</head>
	<%
		String id = request.getParameter("id");
		String taskId = request.getParameter("taskId");
	%>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			
			<form id="form-submit">
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
						</div>
					</div>
			       <div class="col-xs-6 col-sm-3">
						<button id="btn-save" type="button" class="btn btn-success btn-sm">
							<i class="icon-save icon-on-right bigger-110"></i>
							保存
						</button>
						&nbsp;
						<button id="btn-submit" type="button" class="btn btn-info btn-sm">
							<i class="icon-ok icon-on-right bigger-110"></i>
							提交
						</button>
						&nbsp;
						<button id="btn-back" class="btn btn-sm" type="button">
							<i class="icon-undo icon-on-right bigger-110"></i>
							返回
						</button>
					</div>
			    </div>
				<h5 class="header blue" style="margin-top:-2px;">基本信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<input type="hidden" name="id"/><!--id -->
					<input type="hidden" name="oper"/>
					<input type="hidden" name="sjc"/>
					<input type="hidden" name="taskId" />
					<input type="hidden" name="token" value="${token}"/>
					<input type="hidden" name="sfBg">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">PID&nbsp;&nbsp;</label>
							<input type="text" name="pid" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">申请人&nbsp;&nbsp;</label>
							<input type="text" name="zdrmc" class="form-control" readonly/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">申请人日期&nbsp;&nbsp;</label>
							<input type="text" name="cjsj" class="form-control date-picker skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">计划完成时间&nbsp;&nbsp;</label>
							<input type="text" name="jhwcsj" class="form-control date-picker"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">出货要求完成时间&nbsp;&nbsp;</label>
							<input type="text" name="chyqwcsj" class="form-control date-picker"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">预计年销量&nbsp;&nbsp;</label>
							<input type="text" name="yjnxsl" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
							<input type="hidden" name="xsyid" />
							<input type="text" name="xsymc" class="form-control" >
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">状态&nbsp;&nbsp;</label>
							<select role="select" name="zt" size="1" class="form-control skydisabled" disabled="disabled">
								${fns:loadDictOption('DJZT')}
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">PID流水号&nbsp;&nbsp;</label>
							<input type="text" name="pidxh" class="form-control" readonly/>
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">产品概述</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
							<input type="text" id="khbm" name="khbm" hidden=true />
							<input type="text" id="khmc" name="khmc" onfocus="this.blur()" class="form-control  parent-node"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">品牌名称&nbsp;&nbsp;</label>
							<input type="text" name="pp" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group  input-group-sm">
							<label class="input-group-addon">机型&nbsp;&nbsp;</label>
							<select role="select" name="jixing" size="1" class="form-control skyselect">
								 <%-- ${fns:loadDictOption('JIXING')} --%>
								 ${fns:loadModelOption('0','1')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">机芯&nbsp;&nbsp;</label>
							<select role="select" name="jixin" size="1" class="form-control skyselect">
								 <%-- ${fns:loadDictOption('JIXIN')} --%>
								 ${fns:loadModelOption('0','0')}
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group  input-group-sm">
							<label class="input-group-addon">尺寸&nbsp;&nbsp;</label>
							<input type="text" name="cc" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">走货方式&nbsp;&nbsp;</label>
							<select role="select" name="zhfs" size="1" class="form-control skyselect">
								 ${fns:loadDictOption('PI_ZHFS')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">加工方式&nbsp;&nbsp;</label>
							<select role="select" name="jgfs" size="1" class="form-control skyselect">
								 ${fns:loadDictOption('ZHFS')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销往国家&nbsp;&nbsp;</label>
							<select role="select" name="xwgj" size="1" class="form-control skyselect">
								${fns:loadCountryOption('0')}
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">网络&nbsp;&nbsp;</label>
							<select role="select" name="wl" size="1" class="form-control skyselect">
								 ${fns:loadDictOption('WL')}
							</select>
						</div>
					</div>
				   <%-- <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">产品分类&nbsp;&nbsp;</label>
							<select role="select" name="cpfl" size="1" class="form-control skyselect">
								 ${fns:loadDictOption('PID_CPFL')}
							</select>
						</div>
					</div> --%>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">规格明细&nbsp;&nbsp;</label>
							<select role="select" name="ggmx" size="1" class="form-control skyselect">
								 ${fns:loadDictOption('PID_GGMX')}
							</select>
						</div>
					</div> 
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">产品系列&nbsp;&nbsp;</label>
							<select role="select" name="cpxl" size="1" class="form-control skyselect">
								 <%-- ${fns:loadDictOption('PID_CPXL')} --%>
								 ${fns:loadModelOption('0','2')}
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">认证：安全&nbsp;&nbsp;</label>
							<div class="form-control">
							    <label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="rz1Cb" value="1">CB
							    </label>
						    	<label class="checkbox-inline">
							    	<input type="checkbox" class="skycheckbox" name="rz1Etl" value="1">ETL
							    </label>
							    <label class="checkbox-inline">
							    	<input type="checkbox" class="skycheckbox" name="rz1Cetl" value="1">cETL
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Paq" value="1">PSE-安全
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Raq" value="1">RED-安全
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Smaq" value="1">S-mark 安全
							    </label>
							  <!--   <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" id="rz1Qt" name="rz1Qt" value="1">其他
							    </label> -->
						    </div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="rz1Bz" placeholder="备注" class="form-control" />
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">认证：电磁兼容&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="rz2Emc" value="1">EMC
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz2Fcc" value="1">FCC
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz2Rtte" value="1">RTTE
							    </label>
							    <label class="checkbox-inline">
							    	<input type="checkbox" class="skycheckbox" name="rz2Pe" value="1">PSE-EMC
							    </label>
							     <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz2Rr" value="1">RED-RF
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz2Sme" value="1">S-mark -EMC
							    </label>
							   <!--  <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" id="rz2Qt" name="rz2Qt" value="1">其他
							    </label> -->
						    </div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="rz2Bz" placeholder="备注" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">认证：能效&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="rz4Erp" value="1">ERP
							    </label>
							    <label class="checkbox-inline">
							    	<input type="checkbox" class="skycheckbox" name="rz4Gems" value="1">GEMS
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz4Bee" value="1">BEE
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz4Nrc" value="1">NRcan
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz4Nfnx" value="1">南非能效
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz4Eg" value="1">Energy Guide
							    </label>
						    </div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="rz4Bz" placeholder="备注" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">认证：专利&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="rz3Hdmi" value="1">HDMI
							    </label>
							     <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz3Dd" value="1">DD
							    </label>
							       <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz3Dts" value="1">DTS
							    </label>
							    <label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="rz3Cij" value="1">CI+
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz3Bqb" value="1">BQB
							    </label>
							    <label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="rz3Mhl" value="1">MHL
							    </label>
							    <!--  <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" id="rz3Qt" name="rz3Qt" value="1">其他
							    </label> -->
						    </div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="rz3Bz" placeholder="备注" class="form-control" />
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">老格式认证项：（新下PID不能勾选）&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Ce" value="1">CE
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Ul" value="1">UL
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Pse" value="1">PSE
							    </label>
							    <label class="checkbox-inline">
							    	<input type="checkbox" class="skycheckbox" name="rz2Meps" value="1">MEPS
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz2Es" value="1">Energy Star
							    </label>
							     <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz3Usb" value="1">USB
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Rf" value="1">RF
							    </label>
							     <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Rte" value="1">RTE
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Cet" value="1">cETLus
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz1Nom" value="1">NOM
							    </label>
							     <label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="rz3Ddj" value="1">DD+
							    </label>
							     <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="rz4Es7" value="1">Energy star 7.0
							    </label>
						    </div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">认证：其他&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="rz5Qt" value="1">其他
							    </label>
						    </div>
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">产品功能需求</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">电源插头&nbsp;&nbsp;</label>
							<select role="select" name="ctlx" size="1" class="form-control skyselect">
								${fns:loadDictOption('CTLX')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="ctlxbz" placeholder="电源插头备注" class="form-control skydisabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">电压&nbsp;&nbsp;</label>
							<select role="select" name="dianya" size="1" class="form-control skyselect">
								${fns:loadDictOption('DIANYA')} 
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="dianyabz" placeholder="电压备注" class="form-control skydisabled" />
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">是否需要电源开关&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfDykg" value="1" checked="checked">需要
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfDykg" value="0">不需要
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">是否需要REACH&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfReach" value="1" checked="checked">需要
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfReach" value="0">不需要
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">待机功率&nbsp;&nbsp;</label>
							<select role="select" name="djgl" size="1" class="form-control skyselect">
								${fns:loadDictOption('DJGL')} 
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="djglbz" placeholder="待机功率备注" class="form-control skydisabled"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">WIFI&nbsp;&nbsp;</label>
							<select role="select" name="wifi" size="1" class="form-control skyselect">
								${fns:loadDictOption('WF')} 
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="wifibz" placeholder="Wifi备注" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-6">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">附加功能&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="fjgbPgs3d" value="1">偏光式3D
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="fjgnKms3d" value="1">快门式3D
							    </label>
						    	<label class="checkbox-inline">
							    	<input type="checkbox" class="skycheckbox" name="fjgnCij" value="1">CI+
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="fjgnCi" value="1">CI
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="fjgnScart" value="1">SCART
							    </label>
						    </div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">3D眼镜盒&nbsp;&nbsp;</label>
							<input type="text" name="sl3dyjh" class="form-control" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">OSD语言&nbsp;&nbsp;</label>
							<input type="text" name="osdyy" class="form-control" />
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">结构特性</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">外壳颜色标准化&nbsp;&nbsp;</label>
							<input type="text" name="wkysbz" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">泡沫&nbsp;&nbsp;</label>
							<select role="select" name="paomo" size="1" class="form-control skyselect">
								${fns:loadDictOption('PM')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="paomobz" placeholder="泡沫备注" class="form-control skydisabled" />
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-6">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">防火料&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
						    		<input type="checkbox" class="skycheckbox" name="fhlQk" value="1">前壳
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="fhlHk" value="1">后壳
							    </label>
						    	<label class="checkbox-inline">
							    	<input type="checkbox" class="skycheckbox" name="fhlDzjlz" value="1">底座及立柱
							    </label>
							    <label class="checkbox-inline">
							      	<input type="checkbox" class="skycheckbox" name="fhlAvzj" value="1">AV支架
							    </label>
						    </div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">底座包装&nbsp;&nbsp;</label>
							<select role="select" name="dzbz" size="1" class="form-control skyselect">
								${fns:loadDictOption('DZBZFS')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="dzbzbz" placeholder="底座包装备注" class="form-control skydisabled" />
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">挂架&nbsp;&nbsp;</label>
							<select role="select" name="guajia" size="1" class="form-control skyselect">
								${fns:loadDictOption('GJLX')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="guajiabz" placeholder="挂架备注" class="form-control skydisabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">挂架包装&nbsp;&nbsp;</label>
							<select role="select" name="gjbz" size="1" class="form-control skyselect">
								${fns:loadDictOption('GJBZ')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">屏品牌&nbsp;&nbsp;</label>
							<input type="text" name="ppp" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">屏型号&nbsp;&nbsp;</label>
							<input type="text" name="pxh" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">屏编号&nbsp;&nbsp;</label>
							<input type="text" name="pbh" class="form-control"/>
						</div>
					</div>
					<!-- <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">屏分类&nbsp;&nbsp;</label>
							<input type="text" name="pfl" class="form-control"/>
						</div>
					</div> -->
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">分辨率&nbsp;&nbsp;</label>
							<select role="select" name="fbl" size="1" class="form-control skyselect">
								${fns:loadDictOption('FBL')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="fblbz" placeholder="分辨率备注" class="form-control skydisabled"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">2D/3D&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sf3d" value="0" checked="checked">2D
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sf3d" value="1">3D
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">电源&nbsp;&nbsp;</label>
							<select role="select" name="dy" size="1" class="form-control skyselect">
								${fns:loadDictOption('DY')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="dybz" placeholder="电源备注" class="form-control skydisabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">遥控器&nbsp;&nbsp;</label>
							<select role="select" name="ykq" size="1" class="form-control skyselect">
								${fns:loadDictOption('YKQ')}
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="ykqbz" placeholder="遥控器备注" class="form-control skydisabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">电池&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfDc" value="1">需要
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfDc" value="0" checked="checked">不需要
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">OSD出厂语言设置&nbsp;&nbsp;</label>
							<input type="text" name="osdccyysz" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">开机LOGO&nbsp;&nbsp;</label>
							<input type="text" name="kjlogo" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">模拟量标准&nbsp;&nbsp;</label>
							<select role="select" name="mnlbz" size="1" class="form-control skyselect">
								${fns:loadDictOption('MNLBZ')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="mnlbzbz" placeholder="模拟量标准备注" class="form-control skydisabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">质量标准&nbsp;&nbsp;</label>
							<select role="select" name="zlbz" size="1" class="form-control skyselect">
								${fns:loadDictOption('ZLBZ')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="zlbzbz" placeholder="模拟量标准备注" class="form-control skydisabled"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">实验报告&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfSybg" value="1" checked="checked">是
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="sfSybg" value="0" >否
								</label>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="sybgbz" placeholder="实验报告备注" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">音视频支持格式&nbsp;&nbsp;</label>
							<select role="select" name="yspzcgs" size="1" multiple="multiple" class="form-control skyselect">
								${fns:loadDictOption('YSPZCGS')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="yspzcgebz" placeholder="音频支持格式备注" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">网络功能要求&nbsp;&nbsp;</label>
							<select role="select" name="wlgnyq" size="1" multiple="multiple" class="form-control skyselect">
								${fns:loadDictOption('WLGNYQ')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group-sm">
							<input type="text" name="wlgnyqbz" placeholder="网络功能要求备注" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div class="input-group input-group-sm">
						<label class="input-group-addon">附件&nbsp;&nbsp;</label>
							<input type="hidden" name="fj" />
							<span class="input-group-addon"><input id="fj"
								type="file" class="form-control"></span>
							<div id="fjxx" class="form-control"></div>
							<span id="fjsc" class="input-group-addon" style="cursor:pointer;">
								<i class="fa fa-times red"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-sm-12 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">其他备注&nbsp;&nbsp;</label>
							<textarea name="qtbz" class="autosize-transition form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div id="multiFileQueue">
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">其他信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">专利名称&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc1" value="1">DD
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc2" value="1">DD+
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc3" value="1">Vision
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc4" value="1">MS12 version2.0
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc5" value="1">MS12 version2.0+Atmos for TV
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc6" value="1">MS12 version2.0+Atmos for TV+Atmos speaker system
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc7" value="1">MS12 version1.3
								</label>
								<br>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc8" value="1">MS12 version1.3+DAP
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc9" value="1">Premium Sound
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc10" value="1">Sound
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc11" value="1">Freespace
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc12" value="1">MHL
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc13" value="1">HDMI
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc14" value="1">JAVA
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc15" value="1">HEAAC
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc16" value="1">ATSC
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc17" value="1">MPEG-4
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc21" value="1">MS11
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zlmc22" value="1">MS11+DAP
								</label>
						    </div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">平台名称&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc1" value="1">playready
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc2" value="1">Opera 2016（浏览器）
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc3" value="1">Opera 2016（TV store）
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc4" value="1">Opera 2018
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc5" value="1">Access BML Browser
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc6" value="1">Seraphic浏览器（6488）
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc7" value="1">Seraphic浏览器（72563）
								</label>
								<br>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc8" value="1">米高乐多国语言输入法
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc9" value="1">Monotype字库
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc10" value="1">Netrange2982/2984
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc11" value="1">Netrange6488
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc12" value="1">ICFLIX 
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc13" value="1">Ginga库（mirakulo）
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc14" value="1">Foxxum埃及72563
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc15" value="1">Foxxum欧洲72562
								</label>
								<br>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc16" value="1">Coocaa后台
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc17" value="1">Updatelogic
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc18" value="1">BBC
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc19" value="1">Aptoide
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc20" value="1">CI KEY
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ptmc21" value="1">widewine
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">商标&nbsp;&nbsp;</label>
							<input type="text" name="sb" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">产品名称&nbsp;&nbsp;</label>
							<input type="text" name="cpmc" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户型号&nbsp;&nbsp;</label>
							<input type="text" name="khxh" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">制造商&nbsp;&nbsp;</label>
							<input type="text" name="zzs" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">WIFI型号&nbsp;&nbsp;</label>
							<input type="text" name="wifixh" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">特殊需求&nbsp;&nbsp;</label>
							<input type="text" name="tsxq" class="form-control"/>
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">工程师选择</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">电子工程师&nbsp;&nbsp;</label>
							<input type="hidden" name="dzgcsmc" />
							<input type="text" name="dzgcs" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">电源工程师&nbsp;&nbsp;</label>
							<input type="hidden" name="dygcsmc" />
							<input type="text" name="dygcs" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">结构工程师&nbsp;&nbsp;</label>
							<input type="hidden" name="jggcsmc" />
							<input type="text" name="jggcs" class="form-control"/>
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">PID样机数量</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">PID样机数量&nbsp;&nbsp;</label>
							<input type="text" name="pidyjsl" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">提交人意见&nbsp;&nbsp;</label>
							<input type="text" name="tjryj" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-12">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">工厂&nbsp;&nbsp;</label>
									<script type="text/plain" id="gc"
										style="width: 100%; height: 100px;">
									</script>
								</div>
							</div>
						</div>
				<!-- 审批日志 -->
			    <div class="space-4"></div>
			    <h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
			    <div class="space-4"></div>
			    <c:import url="/pub/showLog/pid" charEncoding="UTF-8" />
			</form>
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
	var id = "<%=id%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	<shiro:hasPermission name="mdm:pidInfo:edit">isEdit=true;</shiro:hasPermission>

	$(function($){
		//销售员绑定
		selectXsyInit();
		// 富文本框初始化(操作API可参照static/umeditor下的index.html)
		UM.getEditor('gc');
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
	  	// 页面id赋值
		$("#form-submit [name=id]").val(id);
		//初始化页面数据
		bindFormData(id);
  		// 电源插头的绑定事件 为其他时可填备注
  		bindCtlxEvent();
  		// 电压的绑定事件 为其他时可填备注
  		bindDianyaEvent();
  		// 待机功率的绑定事件 为其他时可填备注
  		bindDjglEvent();
  		// 泡沫的绑定事件 为其他时可填备注
  		bindPaomoEvent();
  		// 底座包装的绑定事件 为其他时可填备注
  		bindDzbzEvent();
  		// 分辨率的绑定事件 为其他时可填备注
  		bindFblEvent();
  		// 遥控器的绑定事件 为其他时可填备注
  		bindYkqEvent();
  		// 模拟量标准的绑定事件 为客户模拟量标准时可填备注
  		bindMnlbzEvent();
  		// 质量标准的绑定事件 为客户标准时可填备注
  		bindZlbzEvent();
  		//实验报告选择是可编辑备注
  		bindSfsybgEvent();
		// 前端数据校验
		validate();
		// 客户选择框
		$("#khmc").parent().click(function(){
			bindKhbm();
		});
		// 电子工程师选择框
		bindGcs("3-yf-dzsjs,1-yx-wxdzsjs");
		// 电源工程师选择框
		bindGcs("3-yf-dysjs,1-yx-wxdysjs");
		// 结构工程师选择框
		bindGcs("3-yf-jgsjs,1-yx-wxjgsjs");
		// 保存
		$("#btn-save").click(function(){
			save();
	    });
		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		//上传附件
		$('#fj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#fj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						$("#form-submit [name=fj]").val(tmpUrl);
						$("#fjxx").empty().append(tmpUrl);
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#fjsc').click(function(){
			if($("#form-submit [name=fj]").val() != ""){
				$("body").bindSweetAlert({
					title : "确定要删除附件吗?",
					closeOnConfirm: true
				}, {
					callback : function() {
						$("#form-submit [name=fj]").val("");
						$("#fjxx").empty();
					}
				});
			}
		});
	});
	//初始化页面数据
	function bindFormData(id){
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/mdm/pidInfo/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$("#form-submit [name=taskId]").val(taskId);
				$("#form-submit [name=oper]").val("edit");//编辑权限
				if(response.gc){
					UM.getEditor('gc').setContent(response.gc);
				}
			    if(!response.sfBg || response.sfBg==null || response.sfBg.length==0 ){
			    	$("#form-submit [name=sfBg]").val("0") ;
			    }
			    var sfbg = $("#form-submit [name=sfBg]").val() ;
				if(sfbg == 1){
					$("#form-submit [name=pid]").prop('disabled','disabled').addClass("skydisabled");
					$("#form-submit [name=zhfs]").prop('disabled','disabled').addClass("skydisabled");
				}; 
			});
		}else{
			//初始化页面参数
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=oper]").val("add");//权限:add
			$("#form-submit [name=zt]").val("1");//状态:草稿
			$('#form-submit [name=ctlxbz]').prop("disabled","disabled");//插头类型备注
			$('#form-submit [name=dianyabz]').prop("disabled","disabled");//电源备注
			$('#form-submit [name=djglbz]').prop("disabled","disabled");//待机功率备注
			$('#form-submit [name=paomobz]').prop("disabled","disabled");//泡沫备注
			$('#form-submit [name=dzbzbz]').prop("disabled","disabled");//底座包装备注
			$('#form-submit [name=fblbz]').prop("disabled","disabled");//分辨率备注
			$('#form-submit [name=ykqbz]').prop("disabled","disabled");//遥控器备注
			$('#form-submit [name=mnlbzbz]').prop("disabled","disabled");//模拟量标准备注
			$('#form-submit [name=zlbzbz]').prop("disabled","disabled");//质量标准备注
			$('#form-submit [name=sl3dyjh]').prop("disabled","disabled");//3D眼镜盒数
			$("#form-submit [name=sfBg]").val("0");//是否变更：非变更
		}
	}
	// 电源插头的绑定事件 为其他时可填备注
	function bindCtlxEvent(){
		$('#form-submit [name=ctlx]').on('change',function(e){
			if(e.val == 5){
				$('#form-submit [name=ctlxbz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=ctlxbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=ctlxbz]').val("");
				$('#form-submit [name=ctlxbz]').prop('disabled','disabled');
			}
		});
	}
	// 电压的绑定事件 为其他时可填备注
	function bindDianyaEvent(){
		$('#form-submit [name=dianya]').on('change',function(e){
			if(e.val == 3){
				$('#form-submit [name=dianyabz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=dianyabz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=dianyabz]').val("");
				$('#form-submit [name=dianyabz]').prop('disabled','disabled');
			}
		});
	}
	// 待机功率的绑定事件 为其他时可填备注
	function bindDjglEvent(){
		$('#form-submit [name=djgl]').on('change',function(e){
			if(e.val == 4){
				$('#form-submit [name=djglbz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=djglbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=djglbz]').val("");
				$('#form-submit [name=djglbz]').prop('disabled','disabled');
			}
		});
	}
	// 泡沫的绑定事件 为其他时可填备注
	function bindPaomoEvent(){
		$('#form-submit [name=paomo]').on('change',function(e){
			if(e.val == 3){
				$('#form-submit [name=paomobz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=paomobz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=paomobz]').val("");
				$('#form-submit [name=paomobz]').prop('disabled','disabled');
			}
		});
	}
	// 底座包装的绑定事件 为其他时可填备注
	function bindDzbzEvent(){
		$('#form-submit [name=dzbz]').on('change',function(e){
			if(e.val == 4){
				$('#form-submit [name=dzbzbz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=dzbzbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=dzbzbz]').val("");
				$('#form-submit [name=dzbzbz]').prop('disabled','disabled');
			}
		});
	}
	// 分辨率的绑定事件 为其他时可填备注
	function bindFblEvent(){
		$('#form-submit [name=fbl]').on('change',function(e){
			if(e.val == 4){
				$('#form-submit [name=fblbz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=fblbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=fblbz]').val("");
				$('#form-submit [name=fblbz]').prop('disabled','disabled');
			}
		});
	}
	// 遥控器的绑定事件 为其他时可填备注
	function bindYkqEvent(){
		$('#form-submit [name=ykq]').on('change',function(e){
			if(e.val == 2){
				$('#form-submit [name=ykqbz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=ykqbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=ykqbz]').val("");
				$('#form-submit [name=ykqbz]').prop('disabled','disabled');
			}
		});
	}
	// 模拟量标准的绑定事件 为客户模拟量标准时可填备注
	function bindMnlbzEvent(){
		$('#form-submit [name=mnlbz]').on('change',function(e){
			if(e.val == 2){
				$('#form-submit [name=mnlbzbz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=mnlbzbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=mnlbzbz]').val("");
				$('#form-submit [name=mnlbzbz]').prop('disabled','disabled');
			}
		});
	}
	// 质量标准的绑定事件 为客户标准时可填备注
	function bindZlbzEvent(){
		$('#form-submit [name=zlbz]').on('change',function(e){
			if(e.val == 1){
				$('#form-submit [name=zlbzbz]').removeProp('disabled').removeAttr("disabled");;
			}else{
				$('#form-submit [name=zlbzbz]').removeProp("disabled").removeAttr("disabled");
				$('#form-submit [name=zlbzbz]').val("");
				$('#form-submit [name=zlbzbz]').prop('disabled','disabled');
			}
		});
	}
	//实验报告选择是可编辑备注
	function bindSfsybgEvent(){
		$('#form-submit [name=sfSybg]').click(function(){
			var value = $("input[name='sfSybg']:checked").val();
			if(value == 1){
				$('#form-submit [name=sybgbz]').removeProp("disabled").removeAttr("disabled");
			}else{
				$('#form-submit [name=sybgbz]').val("");
	  			$('#form-submit [name=sybgbz]').prop("disabled","disabled");
			}
		});
	}
	// 前端数据校验
	function validate(){
		// 前端数据校验
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: 'input[type=hidden]',
			rules: {
				pid: 'required',
				jixing: 'required',
				jixin: 'required',
				yjnxsl : 'number',
				cc : 'number',
				sl3dyjh : 'number',
				dzgcs : 'required',
				dygcs :'required',
				jggcs :'required',
				pidyjsl : 'number'
			},
			messages: {
				pid: 'PID不能为空',
				jixing: '机型不能为空',
				jixin: '机芯不能为空',
				yjnxsl: '预计年销售量必须为数字!',
				cc: '尺寸必须为数字!',
				sl3dyjh: '3D眼镜盒必须为数字!',
				dzgcs : '电子工程师必选',
				dygcs :'电源工程师必选',
				jggcs :'结构工程师必选',
				pidyjsl : 'PID样机数量必须为数字!'
			},
	        showErrors: function(errorMap, errorList) {  
	            if(errorList.length == 0){
	            	$('.input-group').removeClass('has-error');
	            }else{
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
	}
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户编码","value":"khbm"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:80},
					  {name:'khmc', index:'khmc', label:'客户名称', width:80},
					  {name:'fktj', index:'fktj', label:'付款条件', width:80}],
			url:"<c:url value='/pub/widget/findCust'/>"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
				}
				
			}
		});
	}
	// 保存
	function save(){
		if(!$('#form-submit').valid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		param.gc = UM.getEditor('gc').getContent();
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			 callback:function(){
				$.bindAjax({
					url:"<c:url value='/mdm/pidInfo/edit'/>",
					data:param,
					action:"save"
				},function(response){
 					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=pid]").val(result.pid);
					$("#form-submit [name=zt]").val(result.zt);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
					$("#form-submit [name=token]").val(result.token);
					$("#form-submit [name=pidxh]").val(result.pidxh);
				}); 
			} 
		});
	}
	//提交
	function submit(){
		if(!$('#form-submit').valid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/mdm/pidInfo/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	
	//绑定客户选择框
	function bindGcs(roleCode){
		$.post("<c:url value='/pub/select2/selectSjsByRole'/>",{roleCode:roleCode},
				function(result){
					var data = $.map(result, function (obj) {
				       obj.id = obj.empCode;
				       obj.text = obj.text || obj.userName;		      
				       return obj;
				     });
					if(roleCode == "3-yf-dzsjs,1-yx-wxdzsjs"){
						$("#form-submit [name=dzgcs]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
							if(e.added){
								$("#form-submit [name=dzgcsmc]").val(e.added.userName);
							}
						});
					} else if(roleCode == "3-yf-dysjs,1-yx-wxdysjs"){
						$("#form-submit [name=dygcs]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
							if(e.added){
								$("#form-submit [name=dygcsmc]").val(e.added.userName);
							}
						});
					} else if(roleCode == "3-yf-jgsjs,1-yx-wxjgsjs"){
						$("#form-submit [name=jggcs]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
							if(e.added){
								$("#form-submit [name=jggcsmc]").val(e.added.userName);
							}
						});
					}
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
	
</script>
</html>