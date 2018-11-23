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
		String sfFz = request.getParameter("sfFz");
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
					<input type="hidden" name="id"/><!-- 订单id -->
					<input type="hidden" name="oper"/>
					<input type="hidden" name="sjc"/>
					<input type="hidden" name="sfBg"/>
					<input type="hidden" name="taskId" />
					<input type="hidden" name="token" value="${token}" />
					
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
						<button id="btn-back" type="button" class="btn btn-sm" >
							<i class="icon-undo icon-on-right bigger-110"></i>
							返回
						</button>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">基本信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
				    <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">任务单号&nbsp;&nbsp;</label>
							<input type="text" name="rwdh" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">文件编号&nbsp;&nbsp;</label>
							<input type="text" name="wjbh" class="form-control skydisabled" disabled="disabled"/>
					    </div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
							<input type="text" name="zdrmc" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
							<input type="text" name="zdsj" class="form-control date-picker skydisabled" disabled="disabled"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row jbxx" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
							<input type="hidden" name="xsyid" class="form-control"/>
							<input type="text" name="xsymc" onfocus="this.blur()"
								class="form-control parent-node" style="cursor: pointer!important;" />
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
							<input type="text" name="ywzmc" class="form-control skydisabled" disabled="disabled">
							<input type="hidden" name="ywz" />
							<input type="hidden" name="xszz" />
							<input type="hidden" name="xszzmc" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">PID&nbsp;&nbsp;</label>
							<input type="text" name="pid" onfocus="this.blur()" class="form-control parent-node"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
							<input type="hidden" name="jixing"/>
							<input type="hidden" name="jixin"/>
							<input type="hidden" name="oldJixing" />
							<input type="hidden" name="oldJixin" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">产品颜色标准&nbsp;&nbsp;</label>
							<select role="select" name="wkysbz" size="1" class="form-control skyselect">
								${fns:loadDictOption('WKYSBZ')}
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row jbxx" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">版本&nbsp;&nbsp;</label>
						    <select role="select" name="vbbh" size="1" class="form-control skyselect">
								${fns:loadDictOption('ART_VBBH')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">销往国家&nbsp;&nbsp;</label>
							<input type="text" name="xwgj" class="form-control"/>
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
							<label class="input-group-addon">产品经理&nbsp;&nbsp;</label>
							<input type="hidden" name="cpjlmc" />
							<input type="text" name="cpjl" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row jbxx" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-6">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">品牌&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="khpp" value="SKYWORTH" checked="checked">SKYWORTH
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="khpp" value="COOCAA">COOCAA
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="khpp" value="SINOTEC">SINOTEC
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="khpp" value="Metz">Metz
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">认证要求&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzWu" name="rzWu" value="1" checked="checked">无
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzCe" name="rzCe" value="1">能效
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzCb" name="rzCb" value="1">CB
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzEtl" name="rzEtl" value="1">ETL
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzFcc" name="rzFcc" value="1">FCC
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzDb" name="rzDb" value="1">杜比
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzDts" name="rzDts" value="1">DTS
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzHdmi" name="rzHdmi" value="1">HDMI
								</label>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="rzQt" name="rzQt" value="1">其他<input type="text" disabled="disabled" name="rzQtBz" />
								</label>
						    </div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">买家型号&nbsp;&nbsp;</label>
							<input type="text" name="khxh" class="form-control"/>
					    </div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">条码号&nbsp;&nbsp;</label>
							<input type="text" name="tmh" class="form-control"/>
					    </div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">订单状态&nbsp;&nbsp;</label>
							<select role="select" name="zt" size="1" class="form-control skydisabled" disabled="disabled">
								${fns:loadDictOption('DJZT')}
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">版本号&nbsp;&nbsp;</label>
							<input type="text" name="bbh" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin-top:4px;">美工要求</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
				   <div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">1.面壳/装饰件/装饰条等&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="mk" name="mk" value="1" checked="checked">带LOGO
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="mkLx" value="1" checked="checked">1.公司标准工艺
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="mkLx" value="2">2.热烫贴牌 (成本较高且加工工艺复杂,除指定客户,普通客户不能选用）
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">2.遥控器&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" id="ykq" name="ykq" value="1" checked="checked">带LOGO&nbsp;
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" id="ykq" name="ykq" value="2">带型号
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">3.端子功能丝印&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="dzgntp" name="dzgntp" value="1" checked="checked">英文
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">4.说明书或快速操作指南&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="ksczzn" value="1" checked="checked">英文
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="ksczzn" value="2">其他语种
								</label>
								<input type="text" name="ksczznBz" placeholder="对于多语种，此处语种的排序，即资料语种的排序" class="radio-inline" style="width: 350px;"/>
								<br>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="ksczznGwcg" value="1">国外采购,只提供电子文档资料
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="ksczznSqbh" value="1">需要申请编号 
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="ksczznSqbh" value="2">不需要申请编号
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">5.底座安装说明&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="dzazsm" value="1" checked="checked">英文
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="dzazsm" value="2">其他语种
								</label>
								<input type="text" name="dzazsmBz" placeholder="对于多语种，此处语种的排序，即资料语种的排序" class="radio-inline" style="width: 350px;"/>
								<br>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="dzazsmGwcg" value="1">国外采购,只提供电子文档资料
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="dzazsmSqbh" value="1">需要申请编号 
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="dzazsmSqbh" value="2">不需要申请编号
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">6.纸箱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zx" value="1" checked="checked">卡通箱
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zx" value="2">彩箱
								</label>
								<br>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zxGwcg" value="1">国外采购,只提供电子文档资料
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zxSqbh" value="1">需要申请编号 
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zxSqbh" value="2">不需要申请编号
								</label>	
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">7.纸箱型号贴纸&nbsp;&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zxxhtz" value="1" checked="checked">需要,2个用量
								</label>&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zxxhtz" value="0">不需要
								</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<br>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="zxxhtzGwcg" value="1">国外采购,只提供电子文档资料
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zxxhtzSqbh" value="1">需要申请编号 
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zxxhtzSqbh" value="2">不需要申请编号
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">8.后盖贴纸&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="hgtz" value="1" checked="checked">需要
								</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="hgtz" value="2">国外采购,只提供电子文档资料
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="hgtzSqbh" value="1">需要申请编号 
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="hgtzSqbh" value="2">不需要申请编号
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">9.能效贴纸&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="nxtz" value="1" checked="checked">需要
								</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="nxtz" value="2">不需要
								</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="nxtz" value="3">国外采购,只提供电子文档资料
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="nxtzSqbh" value="1">需要申请编号 
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="nxtzSqbh" value="2">不需要申请编号
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">10.保证卡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="bzk" value="1" checked="checked">需要
								</label>&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="bzk" value="0">不需要
								</label>&nbsp;
								<br>
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" name="bzkGwcg" value="1">国外采购,只提供电子文档资料
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="bzkSqbh" value="1">需要申请编号 
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="bzkSqbh" value="2">不需要申请编号
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">11.维修贴纸&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
							<div class="form-control">
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="wxtz" value="1" checked="checked">需要
								</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="wxtz" value="2">国外采购,只提供电子文档资料
								</label>&nbsp;&nbsp;&nbsp;&nbsp;
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="wxtzSqbh" value="1">需要申请编号 
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="wxtzSqbh" value="2">不需要申请编号
								</label>
							</div>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">12.整机序号贴纸&nbsp;</label>
							<div class="form-control">
								<label class="checkbox-inline">
									<input type="checkbox" class="skycheckbox" id="zjxhtz" name="zjxhtz" value="1" checked="checked">公司标准序列号(订单号+递增流水号） 
								</label>
								<br>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zjxhtzBzcc" value="1" checked="checked">标准尺寸(45X15MM),产线打印
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" name="zjxhtzBzcc" value="2">标准尺寸(25X6MM),产线打印
								</label>
								<br>
								<label class="radio-inline">
									<input type="radio" class="skyradio" id="zjxhtzYl" name="zjxhtzYl" value="1" checked="checked">3个用量，分别贴于后壳、纸箱1侧和保证卡上
								</label>
								<label class="radio-inline">
									<input type="radio" class="skyradio" id="zjxhtzYl" name="zjxhtzYl" value="2">其他
								</label>
								<input type="text" name="zjxhtzYlBz" placeholder="用量备注" class="radio-inline" style="width: 350px;"/>
							</div>
						</div>
					</div>
				 </div>
				<div class="space-4"></div>
				<h5 class="header blue" style="margin: 0; padding: 0;">美工其他备注信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px;">
					<div class="col-xs-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">美工其他要求&nbsp;</label>
							<script type="text/plain" id="mgqtyq"
								style="width: 100%; height: 100px;">
							</script>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm" style="width:20px;">
							<label class="input-group-addon">附件&nbsp;&nbsp;</label>
							<div class="form-control" style="text-align:left;">
								<input id="fj" type="file" class="form-control">
							</div>
							<input type="hidden" name="fj" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-6">
						<div id="fjxx">
							<ul class="list-unstyled spaced"></ul>
						</div>
						<div id="multiFileQueue"> </div>
					</div>
				</div>
				<div id="bgxx" class="row" style="margin: 0px;">
				    <!-- 变更需求 -->
				    <h5 class="header blue" style="margin-top:4px;">外销美工需求变更单</h5>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-12 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">是否已量产&nbsp;&nbsp;</label>
								<div class="form-control">
									<label class="radio-inline">
										<input type="radio" class="skyradio" name="bgSflc" value="0">否
									</label>
									<br>
									<label class="radio-inline">
										<input type="radio" class="skyradio" name="bgSflc" value="1" checked="checked">是
									</label><br>
									&nbsp;&nbsp;&nbsp;&nbsp;<label class="radio-inline">
										<input type="radio" class="skyradio" name="bgSflcValue" value="1">暂无量产订单,从此变更通知发出开始更改  
									</label><br>
									&nbsp;&nbsp;&nbsp;&nbsp;<label class="radio-inline">
										<input type="radio" class="skyradio" name="bgSflcValue" value="2">
										从<input type="text" name="bgLcksddh" class="radio-inline"/>订单开始更改
									</label>
								</div>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
					    <div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">变更申请人&nbsp;&nbsp;</label>
								<input type="text" name="zdrmc" class="form-control skydisabled" disabled="disabled"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">变更申请日期&nbsp;&nbsp;</label>
								<input type="text" name="zdsj" class="form-control date-picker skydisabled" disabled="disabled"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
						    </div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">变更内容&nbsp;</label>
								<script type="text/plain" id="bgNr"
									style="width: 100%; height: 100px;">
							</script>
							</div>
						</div>
					</div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">变更原因&nbsp;</label>
								<script type="text/plain" id="bgYy"
									style="width: 100%; height: 100px;">
							</script>
							</div>
						</div>
					</div>
				</div>
				<h5 class="header blue" style="margin: 0; padding: 0;">审批意见</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px;">
					<div class="col-sm-6 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">申请人提交意见&nbsp;&nbsp;</label>
							<textarea name="spyj" class="autosize-transition form-control"></textarea>
						</div>
					</div>
				</div>
				<!-- 审批日志 -->
			    <div class="space-4"></div>
			    <h5 class="header blue" style="margin: 0; padding: 0;">审批日志</h5>
			    <div class="space-4"></div>
			    <c:import url="/pub/showLog/artSkyworth" charEncoding="UTF-8" />
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
	var sfFz = "<%=sfFz%>";
	var taskId = "<%=taskId%>";
	var isEdit = false;
	<shiro:hasPermission name="art:artSkyworth:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($){
		$(".skyselect").select2();
		$(".date-picker").bindDate();
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
		
		UM.getEditor('mgqtyq');
		UM.getEditor('bgNr');
		UM.getEditor('bgYy');
		// PID选择
		$("#form-submit [name=pid]").click(function(){
			selectPidInit();
		});
		//初始化销往国家
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
				khxh: 'required',
				tmh: 'required',
				vbbh: 'required'
			},
			messages: {
				pid: 'PID不能为空',
				zhfs: '走货方式不能为空',
				wkysbz: '产品颜色标准不能为空',
				xsymc: '销售员不能为空',
				khpp: '品牌不能为空',
				xwgj: '销往国家不能为空',
				khxh: '买家型号不能为空',
				tmh: '条码号不能为空',
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
		
		//1、面壳change
		 $('#form-submit [name=mk]').change(function() {
			 if($("#form-submit [name=mk]").is(":checked")){
				 $('#form-submit [name=mkLx]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=mkLx][value=1]").prop("checked",true);
			  }else{
				  $('#form-submit [name=mkLx]').prop('disabled','disabled'); 
				  $("#form-submit [name=mkLx]").removeAttr("checked"); 
			  }
		 });
		//4、语言change
		$('#form-submit [name=ksczzn]').on('change',function(e){
			  if($(this).val() != 2 ){
				  $('#form-submit [name=ksczznBz]').prop('disabled','disabled');
				  $('#form-submit [name=ksczznBz]').val("");
			  }else{
				  $('#form-submit [name=ksczznBz]').removeProp('disabled').removeAttr('disabled');
			  }
		 });
		//4、国外采购change
		$('#form-submit [name=ksczznGwcg]').change(function() {
			 if($("#form-submit [name=ksczznGwcg]").is(":checked")){
				 $('#form-submit [name=ksczznSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=ksczznSqbh][value=1]").prop("checked",true);
			  }else{
				  $('#form-submit [name=ksczznSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=ksczznSqbh]").removeAttr("checked"); 
			  }
		 });
		//5、语言change
		$('#form-submit [name=dzazsm]').on('change',function(e){
			  if($(this).val() != 2 ){
				  $('#form-submit [name=dzazsmBz]').prop('disabled','disabled');
				  $('#form-submit [name=dzazsmBz]').val("");
			  }else{
				  $('#form-submit [name=dzazsmBz]').removeProp('disabled').removeAttr('disabled');
			  }
		 });
		//5、国外采购change
		$('#form-submit [name=dzazsmGwcg]').change(function() {
			 if($("#form-submit [name=dzazsmGwcg]").is(":checked")){
				 $('#form-submit [name=dzazsmSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=dzazsmSqbh][value=1]").prop("checked",true);
			  }else{
				  $('#form-submit [name=dzazsmSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=dzazsmSqbh]").removeAttr("checked"); 
			  }
		 });
		//6、国外采购change
		$('#form-submit [name=zxGwcg]').change(function() {
			 if($("#form-submit [name=zxGwcg]").is(":checked")){
				 $('#form-submit [name=zxSqbh]').removeProp('disabled').removeAttr('disabled'); 
				 $("#form-submit [name=zxSqbh][value=1]").prop("checked",true);
			  }else{
				  $('#form-submit [name=zxSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=zxSqbh]").removeAttr("checked"); 
			  }
		 });
		
		 //纸箱型号贴纸，选了需要，则可以选择国外采购，选了不需要，择不能选国外采购
		 $('#form-submit [name=zxxhtz]').change(function() {
			 if($("#form-submit [name=zxxhtz]:checked").val() == 1){
				 $('#form-submit [name=zxxhtzGwcg]').removeAttr("disabled");
			 } else {
				 $('#form-submit [name=zxxhtzGwcg]').removeAttr("checked");
				 $('#form-submit [name=zxxhtzGwcg]').prop("disabled","disabled");
				 $("#form-submit [name=zxxhtzSqbh]").removeAttr("checked");
				 $("#form-submit [name=zxxhtzSqbh]").prop("disabled","disabled");
			 }
		 });
		 //8、纸箱型号贴纸 选了国外采购，默认需要申请编号
			$('#form-submit [name=zxxhtzGwcg]').change(function() {
				 if($("#form-submit [name=zxxhtzGwcg]").is(":checked")){
					 $('#form-submit [name=zxxhtzSqbh]').removeProp('disabled').removeAttr('disabled'); 
					 $("#form-submit [name=zxxhtzSqbh][value=1]").prop("checked",true);
				  }else{
					  $('#form-submit [name=zxxhtzSqbh]').prop('disabled','disabled'); 
					  $("#form-submit [name=zxxhtzSqbh]").removeAttr("checked"); 
				  }
			 });
		//8、国外采购change
		$('#form-submit [name=hgtz]').on('change',function(e){
			  if($(this).val() != 1 ){
				  $('#form-submit [name=hgtzSqbh]').removeProp('disabled').removeAttr('disabled'); 
				  $("#form-submit [name=hgtzSqbh][value=1]").prop("checked",true);
			  }else{
				  $('#form-submit [name=hgtzSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=hgtzSqbh]").removeAttr("checked"); 
			  }
		 });
		// 能效贴纸
		$('#form-submit [name=nxtz]').on('change',function(e){
			  if($(this).val() == 3 ){
				  $('#form-submit [name=nxtzSqbh]').removeProp('disabled').removeAttr('disabled'); 
				  $("#form-submit [name=nxtzSqbh][value=1]").prop("checked",true);
			  }else{
				  $('#form-submit [name=nxtzSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=nxtzSqbh]").removeAttr("checked"); 
			  }
		 });
		//9、国外采购change
		/* $('#form-submit [name=bzk]').on('change',function(e){
			  if($(this).val() != 1 ){
				  $('#form-submit [name=bzkSqbh]').removeProp('disabled').removeAttr('disabled'); 
				  $("#form-submit [name=bzkSqbh][value=1]").prop("checked",true);
			  }else{
				  $('#form-submit [name=bzkSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=bzkSqbh]").removeAttr("checked"); 
			  }
		 }); */

		 //保证卡，选了需要，则可以选择国外采购，选了不需要，择不能选国外采购
		 $('#form-submit [name=bzk]').change(function() {
			 if($("#form-submit [name=bzk]:checked").val() == 1){
				 $('#form-submit [name=bzkGwcg]').removeAttr("disabled");
			 } else {
				 $('#form-submit [name=bzkGwcg]').removeAttr("checked");
				 $('#form-submit [name=bzkGwcg]').prop("disabled","disabled");
				 $("#form-submit [name=bzkSqbh]").removeAttr("checked");
				 $('#form-submit [name=bzkSqbh]').prop('disabled','disabled'); 
			 }
		 });
		 //8、保证卡 ，选了国外采购，默认需要申请编号
			$('#form-submit [name=bzkGwcg]').change(function() {
				 if($("#form-submit [name=bzkGwcg]").is(":checked")){
					 $('#form-submit [name=bzkSqbh]').removeProp('disabled').removeAttr('disabled'); 
					 $("#form-submit [name=bzkSqbh][value=1]").prop("checked",true);
				  }else{
					  $('#form-submit [name=bzkSqbh]').prop('disabled','disabled'); 
					  $("#form-submit [name=bzkSqbh]").removeAttr("checked"); 
				  }
			 });
		//10、国外采购change
		$('#form-submit [name=wxtz]').on('change',function(e){
			  if($(this).val() != 1 ){
				  $('#form-submit [name=wxtzSqbh]').removeProp('disabled').removeAttr('disabled'); 
				  $("#form-submit [name=wxtzSqbh][value=1]").prop("checked",true);
			  }else{
				  $('#form-submit [name=wxtzSqbh]').prop('disabled','disabled'); 
				  $("#form-submit [name=wxtzSqbh]").removeAttr("checked"); 
			  }
		 });
		//11、整机序号贴纸用量change
		$('#form-submit [name=zjxhtzYl]').on('change',function(e){
			  if($(this).val() != 2 ){
				  $('#form-submit [name=zjxhtzYlBz]').prop('disabled','disabled');
				  $('#form-submit [name=zjxhtzYlBz]').val("");
			  }else{
				  $('#form-submit [name=zjxhtzYlBz]').removeProp('disabled').removeAttr('disabled');
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
						$('input[name=jixin]').val(rows.jixin);
					    $('input[name=jixing]').val(rows.jixing);
						// 根据所选PID赋值相关信息
						$("input[name=pid]").val(rows.pid);

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
		$("#bgxx").hide();
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
			$("#form-submit [name=bbh]").val("1");
			$("#form-submit [name=oper]").val("add");
			$("#form-submit [name=zt]").select2("val","1");
			$('#form-submit [name=ksczznBz]').prop('disabled','disabled');
			$('#form-submit [name=ksczznSqbh]').prop('disabled','disabled');
			$('#form-submit [name=dzazsmBz]').prop('disabled','disabled');
			$('#form-submit [name=dzazsmSqbh]').prop('disabled','disabled');
			$('#form-submit [name=zxSqbh]').prop('disabled','disabled');
			$('#form-submit [name=zxxhtzSqbh]').prop('disabled','disabled');
			$('#form-submit [name=hgtzSqbh]').prop('disabled','disabled'); 
			$('#form-submit [name=nxtzSqbh]').prop('disabled','disabled'); 
			$('#form-submit [name=bzkSqbh]').prop('disabled','disabled');
			$('#form-submit [name=wxtzSqbh]').prop('disabled','disabled');
			$('#form-submit [name=zjxhtzYlBz]').prop('disabled','disabled');
		} else {
			// edit
			$.bindAjax({
				url : "<c:url value='/art/artSkyworth/findById'/>",
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
				// 富文本框赋值
				if(response.mgqtyq){
					UM.getEditor('mgqtyq').setContent(response.mgqtyq);
				}
				if(response.bgNr){
					UM.getEditor('bgNr').setContent(response.bgNr);
				}
				if(response.bgYy){
					UM.getEditor('bgYy').setContent(response.bgYy);
				}
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
						//$(".jbxx").find("input[type=checkbox]").prop("disabled","disabled").addClass("skydisabled");
					    $(".jbxx").find("input[type=text]").prop("disabled","disabled").addClass("skydisabled");
						$(".jbxx").find("input[name=pid]").removeProp("disabled").removeAttr("disabled").removeClass("skydisabled");
						$(".jbxx").find("input[name=cpjl]").removeProp("disabled").removeAttr("disabled").removeClass("skydisabled");
					    $('#form-submit [name=wkysbz]').prop("disabled","disabled").addClass("skydisabled");
					    $('#form-submit [name=vbbh]').prop("disabled","disabled").addClass("skydisabled");
						$("#bgxx").show();
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
					//}
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
		// 富文本框取值
		param.mgqtyq = UM.getEditor('mgqtyq').getContent();
		param.bgNr = UM.getEditor('bgNr').getContent();
		param.bgYy = UM.getEditor('bgYy').getContent();
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/art/artSkyworth/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=rwdh]").val(result.rwdh);
					$("#form-submit [name=wjbh]").val(result.wjbh);
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
		// 富文本框取值
		param.mgqtyq = UM.getEditor('mgqtyq').getContent();
		param.bgNr = UM.getEditor('bgNr').getContent();
		param.bgYy = UM.getEditor('bgYy').getContent();
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/art/artSkyworth/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	
	//选择其他时，需填写备注控制
	function qtValid(){
		 if($("#form-submit [name=rzQt]").is(":checked") && $("#form-submit [name=rzQtBz]").val() == ""){
			swal('','请填写认证要求其他备注！', "warning");
	    	return false;
		 }
		 if($("input[name='ksczzn']:checked").val() == 2 && $("#form-submit [name=ksczznBz]").val() == ""){
			swal('','请检查说明书或快速操作指南：其他语种选项，并填写备注！', "warning");
	    	return false;
		 }
		 if($("input[name='dzazsm']:checked").val() == 2 && $("#form-submit [name=dzazsmBz]").val() == ""){
			swal('','请检查底座安装说明：其他语种选项，并填写备注！', "warning");
	    	return false;
		 }
		 if($("input[name='zjxhtzYl']:checked").val() == 2 && $("#form-submit [name=zjxhtzYlBz]").val() == ""){
				swal('','请检查整机序号贴纸：其他选项，并填写备注！', "warning");
		    	return false;
			 }
		return true;
	}
	
	function bgValid(){
		if($("#form-submit [name=sfBg]").val() == "1"){
			var bgNr = UM.getEditor('bgNr').getContent();
			var bgYy = UM.getEditor('bgYy').getContent();
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