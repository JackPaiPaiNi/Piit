<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
</head>
	<%
		String id = request.getParameter("id");
		String sjc = request.getParameter("sjc");
		String sfBg = request.getParameter("sfBg");
		String yzhdhs = request.getParameter("yzhdhs");
	%>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			
			<form id="form-submit">
				<div class="row" style="margin: 0px 8px;">
					<input type="hidden" name="id"/><!-- 出货通知书id -->
					<input type="hidden" name="oper"/>
					<input type="hidden" name="sjc"/>
					<input type="hidden" name="bbh"/>
					<input type="hidden" name="sfBg" />
					<input type="hidden" name="token" value="${token}">
					<div class="col-xs-6 col-sm-9"></div>
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
				<h5 class="header blue" style="margin-top:4px;">表头信息</h5>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">出货单号&nbsp;&nbsp;</label>
							<input type="text" name="chdh" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3 skyhidden">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">原出货单号&nbsp;&nbsp;</label>
							<input type="text" name="ychdh" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					
					<div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">收函人&nbsp;&nbsp;</label>
							<input type="text" name="shr" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">发函人&nbsp;&nbsp;</label>
							<input type="text" name="fhr" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
				</div>
				<div class="row" style="margin: 0px 8px;">
				<div class="space-4"></div>
				   <div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">公司&nbsp;&nbsp;</label>
							<select role="select" name="gsbm" size="1" class="form-control skyselect">
								${fns:loadCompanyOption('0')}
							</select>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">单据状态&nbsp;&nbsp;</label>
							<input type="hidden" name="zt" />
							<input type="text" name="ztmc" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>	
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
							<input type="hidden" name="scjd" />
							<input type="text" name="scjdmc" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
							<input type="text" name="fph" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="row" style="margin: 0px 8px;">
				<div class="space-4"></div>
				    <div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">船务开票人&nbsp;&nbsp;</label>
							<input type="hidden" name="cwkprmc" />
							<input type="text" name="cwkpr" class="form-control" />
						</div>
					</div>
					<div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">发货人代码&nbsp;&nbsp;</label>
							<input type="text" name="fhr_dm" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">发货人电话&nbsp;&nbsp;</label>
							<input type="text" name="fhr_dh" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">发货人AEO企业编码&nbsp;&nbsp;</label>
							<input type="text" name="fhr_aeoqybm" class="form-control skydisabled" disabled="disabled"/>
						</div>
					</div>
				</div>
				<div class="space-4 skyhidden"></div>
				<div class="row skyhidden" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-8">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">更改说明&nbsp;&nbsp;</label>
							<input type="text" name="ggsm" class="form-control"/>
						</div>
					</div>
				</div>
				
				<div class="space-8"></div>
				<ul class="nav nav-tabs">
					<li class="active"><a href="#chxx-tab" data-toggle="tab">出货信息</a></li>
					<li><a href="#zgxx-tab" data-toggle="tab">装柜信息</a></li>
					<li><a href="#cwxx-tab" data-toggle="tab">船务信息</a></li>
					<li><a href="#shrxx-tab" data-toggle="tab">收货人信息</a></li>
				</ul>
				
				<div class="tab-content">
					<!-- 出货信息TAB -->
					<div class="tab-pane fade active in" id="chxx-tab">
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
									<input type="text" name="khbm" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
									<input type="text" name="khmc" class="form-control skydisabled" disabled="disabled"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
									<input type="hidden" name="xsyid" />
									<input type="text" name="xsymc" class="form-control skydisabled" disabled="disabled"/>
									<input type="hidden" name="ywz" />
									<input type="hidden" name="ywzmc" />
									<input type="hidden" name="xszz" />
									<input type="hidden" name="xszzmc" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">报关方式&nbsp;&nbsp;</label>
									<select role="select" name="bgfs" size="1" class="form-control skyselect">
										${fns:loadDictOption('BGFS')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="bgfsbz" placeholder="报关方式备注" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<button id="btn-yzhSelect" type="button" class="btn btn-purple btn-sm" >
								<i class="fa fa-plus icon-on-right bigger-110"></i>
								预走货选择
								</button>
							</div>
						</div>
						<div class="space-4"></div>
						<div id="grid-parent" style="margin: 0px 8px;">
							<table id="grid-table"></table>
							<div id="grid-pager"></div>
						</div>
						<!--展会样机  -->
						<!-- <div class="space-4"></div>
						<div id="grid-parent-exhibition" style="margin: 0px 8px;">
							<table id="grid-table-exhibition"></table>
							<div id="grid-pager-exhibition"></div>
						</div> -->
						<!--费用明细  -->
						<div class="space-4"></div>
							<h5 class="header blue" style="margin-top: 4px;">费用明细</h5>
							<div id="grid-parent-other">
								<table id="grid-table-other"></table>
								<div id="grid-pager-other"></div>
						</div>
						
					</div>
					<!-- 装柜信息TAB -->
					<div class="tab-pane fade" id="zgxx-tab">
						<div class="row" style="margin: 0;">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">跟单备损&nbsp;&nbsp;</label>
								<textarea name="bcGdbs" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">SPO备损&nbsp;&nbsp;</label>
								<textarea name="bcSpobs" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">文件要求&nbsp;&nbsp;</label>
								<textarea name="bcWjyq" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">装柜要求&nbsp;&nbsp;</label>
								<textarea name="bcZgyq" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">其他&nbsp;&nbsp;</label>
								<textarea name="bcQt" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">屏信息&nbsp;&nbsp;</label>
								<textarea name="pxx" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<!-- 船务信息TAB -->
					<div class="tab-pane fade" id="cwxx-tab">
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">出运类型&nbsp;&nbsp;</label>
								    <select role="select" name="cylx" size="1" class="form-control skyselect">
										${fns:loadDictOption('CYLX')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">船名&nbsp;&nbsp;</label>
									<input type="text" name="cm" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">航次&nbsp;&nbsp;</label>
									<input type="text" name="hc" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">航班号&nbsp;&nbsp;</label>
									<input type="text" name="hbh" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">订舱号&nbsp;&nbsp;</label>
									<input type="text" name="dch" class="form-control"/>
								</div>
							</div>	
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">总柜数&nbsp;&nbsp;</label>
									<input type="text" name="ygZgs" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">柜数备注&nbsp;&nbsp;</label>
									<input type="text" name="ygGsbz" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">20'GP&nbsp;&nbsp;</label>
									<input type="text" name="yg20gp" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">40'GP&nbsp;&nbsp;</label>
									<input type="text" name="yg40gp" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">40'HQ&nbsp;&nbsp;</label>
									<input type="text" name="yg40hq" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">总车数&nbsp;&nbsp;</label> 
									<input type="text" name="dcZcs" class="form-control"/>   
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">3吨车:&nbsp;&nbsp;</label>
									<input type="text" name="dc3d" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">5吨车:&nbsp;&nbsp;</label>
									<input type="text" name="dc5d" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">8吨车:&nbsp;&nbsp;</label>
									<input type="text" name="dc8d" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">10吨车:&nbsp;&nbsp;</label>
									<input type="text" name="dc10d" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">12吨车:&nbsp;&nbsp;</label>
									<input type="text" name="dc12d" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">吨车备注&nbsp;&nbsp;</label>
									<input type="text" name="dcDcbz" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">目的国家&nbsp;&nbsp;</label>
									<select role="select" name="xwgj" size="1" class="form-control skyselect">
										${fns:loadCountryOption('0')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">起运港&nbsp;&nbsp;</label>
									<select role="select" name="qyg" size="1" class="form-control skyselect">
							           	 ${fns:loadDictOption('QYG')}
									</select>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group-sm">
									<input type="text" name="qygbz" placeholder="起运港备注" class="form-control skydisabled" 
										disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">目的港&nbsp;&nbsp;</label>
									<input type="text" name="mdg" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">装柜时间&nbsp;&nbsp;</label>
									<input type="text" name="zgrq" class="form-control date-time-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">截放行条时间&nbsp;&nbsp;</label>
									<input type="text" name="jfxtsj" class="form-control date-time-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">截重时间&nbsp;&nbsp;</label>
									<input type="text" name="jcsj" class="form-control date-time-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">开舱时间&nbsp;&nbsp;</label>
									<input type="text" name="kcsj" class="form-control date-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">截补料/ENS/AMS时间&nbsp;&nbsp;</label>
									<input type="text" name="jblsj" class="form-control date-time-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">截VGM&nbsp;&nbsp;</label>
									<input type="text" name="jgq" class="form-control date-time-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">预计开船期（ETD）&nbsp;&nbsp;</label>
									<input type="text" name="yjkcq" class="form-control date-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">预计到港期（ETA）&nbsp;&nbsp;</label>
									<input type="text" name="yjdgq" class="form-control date-picker"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">快递信息&nbsp;&nbsp;</label>
									<input type="text" name="kdxx" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">船代公司&nbsp;&nbsp;</label>
									<input type="text" name="cdgsmc" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">船代公司联系人&nbsp;&nbsp;</label>
									<input type="text" name="cdgslxr" class="form-control"/>
								</div>
							</div>					
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">船代公司电话&nbsp;&nbsp;</label>
									<input type="text" name="cdgsdh" class="form-control"/>
								</div>
							</div>	
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">船代公司传真&nbsp;&nbsp;</label>
									<input type="text" name="cdgscz" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">船代公司邮箱&nbsp;&nbsp;</label>
									<input type="text" name="cdgsyx" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">船代公司邮编&nbsp;&nbsp;</label>
									<input type="text" name="cdgsyb" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0;">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm" style="width:40px;">
									<label class="input-group-addon">附件&nbsp;&nbsp;</label>
									<div class="form-control" style="text-align:center;width:40px;">
										<input id="fj" type="file" class="form-control">
									</div>
									<input type="hidden" name="fj" />
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">拖车公司&nbsp;&nbsp;</label>
									<input type="text" name="tcgs" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
									<input type="text" name="bzxx" class="form-control"/>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px;">
							<div class="col-xs-6 col-sm-6">
								<div id="multiFileQueue"> </div>
								<div id="fjxx">
									<ul class="list-unstyled spaced"></ul>
								</div>
							</div>
						</div>
					</div>
					<!--收货人信息 -->
					<div class="tab-pane fade" id="shrxx-tab">
					    <h5 class="header blue" style="margin-top: 4px;">收货人信息[CONSIGNEE]</h5>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px 8px;">
							<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收货人代码&nbsp;&nbsp;</label> 
									<input type="text" name="shfdm" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
						 	<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收货人名称&nbsp;&nbsp;</label> 
									<input type="text" name="shfmc" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
							<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收货人电话&nbsp;&nbsp;</label> 
									<input type="text" name="shrdh" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
							<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">收货人地址&nbsp;&nbsp;</label> 
									<input type="text" name="shfdz" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px 8px;">
							<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">AEO企业编码&nbsp;&nbsp;</label> 
									<input type="text" name="aeoqybm" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
						 	<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">具体联络人&nbsp;&nbsp;</label> 
									<input type="text" name="shflxr" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
							<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">具体联络人电话&nbsp;&nbsp;</label> 
									<input type="text" name="shfdh" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
							<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">传真&nbsp;&nbsp;</label> 
									<input type="text" name="shfcz" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<div class="row" style="margin: 0px 8px;">
						 	<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">邮编&nbsp;&nbsp;</label> 
									<input type="text" name="shfyb" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
							<div class="col-xs-3 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">邮箱&nbsp;&nbsp;</label> 
									<input type="text" name="shfyx" class="form-control skydisabled" disabled="disabled">
								</div>
							</div>
						</div>
						<div class="space-4"></div>
						<h5 class="header blue" style="margin-top: 4px;">提单通知人信息[NOTIFY PARTY]</h5>
						<div class="row" style="margin: 0px 8px;">
							<div class="col-xs-12 col-sm-12">
								<div id="grid-parent-notify">
									<table id="grid-table-notify"></table>
									<div id="grid-pager-notify"></div>
								</div>
							</div>
						</div>
						<div class="space-4"></div>
					</div>
				</div>
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
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var parent_selector = "#grid-parent";
	// 展会样机
	var grid_selector_exhibition = "#grid-table-exhibition";
	var pager_selector_exhibition = "#grid-pager-exhibition";
	// 费用明细
	var grid_selector_other = "#grid-table-other";
	var pager_selector_other = "#grid-pager-other";
	// 提单通知人信息
	var grid_selector_notify = "#grid-table-notify";
	var pager_selector_notify = "#grid-pager-notify";
	
	var id = "<%=id%>";
	var sjc = "<%=sjc%>";
	var sfBg = "<%=sfBg%>";
	var yzhdhs = "<%=yzhdhs%>";
	var isEdit = false;
	<shiro:hasPermission name="deliver:deliver:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($){
		$(".skyselect").select2();
		$(".date-picker").bindDate();
		// 日期控件（精确到时分秒）
	  	$(".date-time-picker").bindDateTime();
		fjUpload();
		validate();
		//bindBgfsEvent();
		bindQygEvent();
		
		$(grid_selector).bindTable({
			caption: "",
			pager: pager_selector,
			gridParent: parent_selector,
			footerrow:true,
			datatype: "local",
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:120, editable:false},
				{name:'ddid', index:'ddid', label:'订单号', width:100, editable:false},
				{name:'ddlx', index:'ddlx', label:'订单类型', width:80, hidden:true},
				{name:'cplx', index:'cplx', label:'产品类型', width:80, hidden:true},
				{name:'mytk', index:'mytk', label:'贸易条款', width:100, editable:false, hidden:true},
				{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:100, editable:false},
				{name:'spmc', index:'spmc', label:'商品名称', width:140},
				{name:'sl', index:'sl', label:'数量', width:60, align:'right',
					 formatter:'integer',formatoptions:{thousandsSeparator: ','}, editable:false},
				{name:'mfjsl', index:'mfjsl', label:'免费机数量', width:80, align:'right',
						 formatter:'integer',formatoptions:{thousandsSeparator: ','}, editable:false},
				{name:'js', index:'js', label:'件数', width:60, align:'right',
					 	 formatter:'integer',formatoptions:{thousandsSeparator: ','}, editable:false},
				{name:'jixing', index:'jixing', label:'我司型号/物料编号', width:140, editable:false},
				{name:'khxhms', index:'khxhms', label:'客户型号/产品描述', width:140},
				{name:'pp', index:'pp', label:'品牌', width:80, editable:false},
				{name:'pplx', index:'pplx', label:'品牌类型', width:140, editoptions:{disabled:true}},
				{name:'ckxhqk', index:'ckxhqk', label:'出口享惠情况',edittype:"select",formatter:"select", 
					  editoptions:{value:"${fns:loadDictEditOption('CKXHQK')}"},width : 100},
				{name:'chfl', index:'chfl', label:'出货分类', editable:false,edittype:"select",formatter:"select", 
					  editoptions:{value:"${fns:loadDictEditOption('CHFL')}"},width : 140},
				{name:'chfl', index:'chfl', hidden:true},
				{name:'bz', index:'bz', label:'币种', width:60, editable:false},
				<shiro:hasPermission name="deliver:deliver:price">{name:'dj', index:'dj', label:'单价', width:100, align:'right',
					 formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
				{name:'ffbsje', index:'ffbsje', label:'付费备损金额', width:120, align:'right',
					 formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
				{name:'je', index:'je', label:'总价', width:120, align:'right',
					 formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},</shiro:hasPermission>
				{name:'bzxx', index:'bzxx', label:'备注', width:80,edittype:"textarea"},
				{name:'piid', index:'piid', label:'PI号', width:80, hidden: true},
				{name:'cc', index:'cc', label:'尺寸', width:80, hidden: true},
				{name:'zhfs', index:'zhfs', label:'走货方式', width:80, hidden: true},
				{name:'ggmx', index:'ggmx', label:'规格明细', width:80, hidden: true},
				{name:'ggmxmc', index:'ggmxmc', label:'规格明细', width:80, hidden: true},
				{name:'gtin', index:'gtin', label:'GTIN码', width:80/* , editable:false */},
				{name:'cas', index:'cas', label:'CAS码', width:80/* , editable:false */},
				{name:'dsjlx', index:'dsjlx', label:'电视机类型', editable:false,edittype:"select",formatter:"select", 
					  editoptions:{value:"${fns:loadDictEditOption('DSJLX')}"},width : 140},
				{name:'balh', index:'balh', label:'备案料号', width:80},
				{name:'yzhbbh', index:'yzhbbh', label:'预走货版本号', width:80, hidden: true},
				{name:'bgzj', index:'bgzj', label:'报关总价', width:80, hidden: true}
			],
			editTable : true,
			gridComplete: function(){
	            sumGrid();
		   	}
		},{
			add:false,
			edit:isEdit,
			view:false,
			del:false,
			complete:isEdit
		});
		
		initExhibitionGrid();
		initOtherGrid();
		initNotifyGrid();
		
		// 初始化页面数据
		bindFormData(id, yzhdhs);
		//保存
		$("#btn-save").click(function(){
			save();
	    });
		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
		// 返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		//加载船务开票人
		initCwkpr();
	});
	
	function initCwkpr(){
		$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:"1-yx-cwzy"}, function(result){
			var data = $.map(result, function (obj) {
		        obj.id = obj.empCode;
		        obj.text = obj.text || obj.userName;	
		        return obj;
		     });
			$("#form-submit [name=cwkpr]").addClass("skyselect").select2({data:data}).on("change",function(e){ 
				if(e.added){
					$("#form-submit [name=cwkprmc]").val(e.added.userName);
				}
			});
		}, "json");
	} 
	
	// 初始化展会样机，认证样机
	function initExhibitionGrid(){
		$(grid_selector_exhibition).bindTable({
			caption : "",
			pager : pager_selector_exhibition,
			gridParent :"#grid-parent-exhibition",
			footerrow:true,
			//shrinkToFit : false,
			autoScroll : false,
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			colModel : [ 
			    {name : 'id',label : 'ID',hidden : true,width : 200},
			    {name : 'yzhdh',index : 'yzhdh',label : '样机预走货单号',width : 120},
			    {name : 'bbh',index : 'bbh',label : '版本号',width : 60},
			    {name : 'spmc',index : 'spmc',label : '商品名称',width : 120},
			    {name : 'spmc',index : 'spmc',label : '商品名称',width : 120},
				{name : 'yjly',index : 'yjly',label : '样机来源',width : 80},
				{name : 'jixing',index : 'jixing',label : '机型',width : 100},
				{name : 'sl',index : 'sl',label : '数量',width : 80,align:'right', formatter:'integer'/* ,editoptions:{dataInit: initSl} */},
				{name : 'dj',index : 'dj',label : '单价',width : 80,align:'right'/* ,editoptions:{dataInit: initDj} */},
				{name :  'bz',index : 'bz',label : '币种',width : 80,edittype:"select", formatter:"select", 
					 editoptions:{value:"${fns:loadDictEditOption('BZ')}"}},
				{name : 'je',index : 'je',label : '金额', editoptions:{disabled:true},width : 100,align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name : 'bzxx',index : 'bzxx',label : '备注信息',width : 200} 
			],
			gridComplete: function(){
				sumItemExhibition();
		   	},
		}, {	
			view : false,
			add : false,
			edit : false,
			del : false
		});
	}
	
	// 初始化费用明细
	function initOtherGrid(){
		$(grid_selector_other).bindTable({
			caption : "",
			datetype :"local",
			pager : pager_selector_other,
			gridParent :"#grid-parent-other",
			footerrow:true,
			shrinkToFit : false,
			autoScroll : false,
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			colModel : [ 
			    {name : 'id',label : 'ID',hidden : true,width : 200},
				{name : 'yzhdh',index : 'yzhdh',label : '预走货单号',editable : true,width : 120, editoptions:{dataInit: initYzhdh}},
				{name : 'bbh',index : 'bbh',label : '预走货版本号',width : 100},
			    {name : 'qtxm',index : 'qtxm',label : '费用项目',editable : true,edittype:"select",formatter:"select", 
				 editoptions:{value:"${fns:loadDictEditOption('QTFYXM')}"},width : 140},
				{name :  'bz',index : 'bz',label : '币种',editable : true,edittype:"select", formatter:"select", 
				 editoptions:{value:"${fns:loadDictEditOption('BZ')}"}},
				{name : 'yt',index : 'yt',label : '用途',width : 180},
				{name : 'je',index : 'je',label : '金额',width : 120,align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name : 'skdh',index : 'skdh',label : '收款单号',width : 140} 
			],
			editTable : true,
			gridComplete: function(){
				sumItemOther();
		   	},
		   	editComplete:function(lastEdit,rowData){
				sumItemOther();
		   	}
		}, {
			add : isEdit,
			edit : isEdit,
			del : isEdit
		});
	}
	
	//提单通知人信息明细表
	function initNotifyGrid(){
		$(grid_selector_notify).bindTable({
			caption : "",
			pager : pager_selector_notify,
			gridParent : "#grid-parent-notify",
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			datatype:"local",
			colModel : [ 
				 {name : 'tzfdm',index : 'tzfdm',label : '通知方代码',width : 120},
				 {name : 'tzfdh',index : 'tzfdh',label : '通知方电话',width : 120},
				 {name : 'tzrmc',index : 'tzrmc',label : '公司名称',width : 120},
				 {name : 'tzrlxr',index: 'tzrdz',label : '联系人',width :120},
				 {name : 'tzrdh',index : 'tzrdz',label : '电话',width : 120},
				 {name : 'tzrcz',index : 'tzrdz',label : '传真',width : 120},
				 {name : 'tzryb',index : 'tzrdz',label : '邮编',width : 120},
				 {name : 'tzryx',index : 'tzrdz',label : '邮箱',width : 120}, 
				 {name : 'tzrdz',index : 'tzrdz',label : '地址',width : 300}
				],
			editTable : false
		}, {
			add : false,
			edit : false,
			del : false,
			view:false
		});
	}
	
	//选择预走货单号	
	function initYzhdh(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title : "预走货选择",
				searchCond : [ {"name" : "预走货单号","value" : "yzhdh"},
				               {"name" : "订单号","value" : "ddid"} ],
	            colModel : [{name:'yzhdh', index:'yzhdh', label:'预走货单号'},
	                        {name:'bbh', index:'bbh', label:'预走货版本号'},
					        {name:'ddid', index:'ddid', label:'订单号'},
					        {name:'xszz', index:'xszz', label:'区域',hidden:true},
					        {name:'xszzmc', index:'xszzmc', label:'区域'},
					        {name:'xsyid', index:'xsyid', label:'销售员ID',hidden:true},
					        {name:'xsymc', index:'xsymc', label:'销售员'},
					        {name:'cwzyid', index:'cwzyid', label:'船务专员ID',hidden:true},
					        {name:'cwzymc', index:'cwzymc', label:'船务专员名称'}],
				url : "<c:url value='/pso/tvPso/searchYzhxx'/>"
			}, {
				callback : function(rows) {
					if(rows){
						$(elem).val(rows.yzhdh);
						$(elem).closest("tr.jqgrow").find("input[name='bbh']").val(rows.bbh);
					
					}else{
						$(elem).val("");
						$(elem).closest("tr.jqgrow").find("input[name='bbh']").val("");
						
					}
					
				}
			});
		});
	}
	
	// 初始化PI数据
	function initYzhData(data){
		//客户重新赋值
		if(data !=null){
			$("#form-submit [name=khbm]").val(data.khbm);
			$("#form-submit [name=khmc]").val(data.khmc);
		}
		$(grid_selector).jqGrid("clearGridData");
		// 添加数据到编辑表
  		$(grid_selector).jqGrid("addRowData", null, data.deliverItemList, "last");
	}
	
	//初始化页面数据（新增/修改/更改）
	function bindFormData(id, yzhdhs){	
		$.loading();
		var requestUrl = "";
		var requestData = {};
		if(id == "null"){
			// 新增
			$(".skyhidden").hide();
			requestUrl = "<c:url value='/deliver/deliver/findYzh'/>";
			requestData.yzhdhs = yzhdhs;
		} else {
			if(sfBg == 1){
				// 变更
				requestUrl = "<c:url value='/deliver/deliver/changeById'/>";
				requestData.id = id;
				requestData.sjc = sjc;
			} else {
				// 修改
				requestUrl = "<c:url value='/deliver/deliver/findById'/>";
				requestData.id = id;
			}
		}
		// 绑定数据
		$.bindAjax({
			url : requestUrl,
			data : requestData,
			action : "search"
		},function(response){
			$("#form-submit").setFormData(response);
			console.info(response);
			$("#fjxx").html(response.fj);
			if(id == "null"){
				// 新增
				$("#form-submit [name=id]").val("");
				$("#form-submit [name=sjc]").val("");
				$("#form-submit [name=bbh]").val("");
				$("#form-submit [name=oper]").val("add");
				$("#form-submit [name=zt]").val("1");
				$("#form-submit [name=ztmc]").val("草稿");
				// 非多元化：收函人显示“进出口事务部，计划管理科--储运”
				if(response.deliverItemList[0]["yzhlx"]==4 || response.deliverItemList[0]["yzhlx"]==5){
					$("#form-submit [name=shr]").val(response.shr);
				}else{
					$("#form-submit [name=shr]").val("关务，计划管理科--储运");
				}
				$("#form-submit [name=fhr]").val(response.fhr);
				
			} else {
				// 修改或变更
				$("#form-submit [name=oper]").val("edit");
			}
			// 原出货单号、更改说明是否显示
			if(response.sfBg != 1){
				$(".skyhidden").hide();
			}
			// 根据生产基地填写发货人信息
			if(response.scjd == '2110'){
				$("#form-submit [name=fhr_dm]").val("4403131697");
				$("#form-submit [name=fhr_dh]").val("0755-27357825");
				$("#form-submit [name=fhr_aeoqybm]").val("AEOCN4403131697");
			} else if(response.scjd == '2120'){
				$("#form-submit [name=fhr_dm]").val("4401330026");
				$("#form-submit [name=fhr_dh]").val("0755-27357825");
				$("#form-submit [name=fhr_aeoqybm]").val("");
			}
			// 加载明细F
			if(response.deliverItemList){
				$(grid_selector).jqGrid("addRowData", null, response.deliverItemList, "last");
			}
			// 加载明细
			if(response.deliverExhibitionList){
				$(grid_selector_exhibition).jqGrid("addRowData", null, response.deliverExhibitionList, "last");
			}
			// 加载费用明细
			if(response.deliverCostList){
				$(grid_selector_other).jqGrid("clearGridData");
				$(grid_selector_other).jqGrid("addRowData", null, response.deliverCostList, "last");
			}
			// 加载收货人
			if(response.notifyList){
				$(grid_selector_notify).jqGrid("addRowData", null, response.notifyList, "last");
			}
			$.hideLoad();
		});
	}
	//计算报关金额
	function computeBgje(data){
		var gs=$("#form-submit [name=gsbm]").val();
		var jd=$("#form-submit [name=scjd]").val();
		//if("SOS" "MCO" ){
			
		//}
		
	}
	
	/************************文件上传控件初始化开始********************************/
	// 附件
	function fjUpload(){
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
	}
	/************************文件上传控件初始化结束********************************/
 	//报关方式绑定
	/* function bindBgfsEvent(){
		$('#form-submit [name=bgfs]').on('change',function(e){
			if($(this).val() != 6){
				$('#form-submit [name=bgfsbz]').prop('disabled','disabled');
			}else{
				$('#form-submit [name=bgfsbz]').removeProp('disabled').removeAttr('disabled');
			}
		});
	} */
	
	// 预走货选择
	$("#btn-yzhSelect").click(function(){
	    var width = 1366;
		var height =768;
		var left = 0;
		var top =  0; 
		var pageUrl = "<c:url value='/deliver/deliver/yzhList'/>";
		if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
			var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
			var data = window.showModalDialog(pageUrl,null,dialogArgs);
			if(data){
				initYzhData(data);
			}
		}else{
			var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,resizable=yes,left="+left+"px,top="+top+"px";
			var opener = window.open(pageUrl,null,dialogArgs);
			opener.openerCallBack = function(data){
				initYzhData(data);
			}
		}
	});
	
	//起运港绑定
	function bindQygEvent(){
		$('#form-submit [name=qyg]').on('change',function(e){
			if($(this).val() != 4){
				$('#form-submit [name=qygbz]').prop('disabled','disabled');
			}else{
				$('#form-submit [name=qygbz]').removeProp('disabled').removeAttr('disabled');
			}
		});
	}
	
	// 计算合计行
	function sumGrid(){
		var sl;
		var je;
		var ffbsje;
		$(grid_selector).footerData("set",{"yzhdh":"合计"}); //合计
		var rowNum = $(grid_selector).jqGrid('getGridParam','records');
		if(rowNum >0 ){
			 sl = $(grid_selector).getCol("sl",false,"sum"); 
			 je = $(grid_selector).getCol("je",false,"sum"); 
			 ffbsje = $(grid_selector).getCol("ffbsje",false,"sum");
		}
		$(grid_selector).footerData("set",{"sl":sl, "je":je, "ffbsje":ffbsje}); //将合计值显示出来
	}
	
	// 计算展会样机明细合计行
	function sumItemExhibition(){
		var je;
		$(grid_selector_exhibition).footerData("set",{"spmc":"合计"}); //合计
		var rowNum = $(grid_selector_exhibition).jqGrid('getGridParam','records');
		if(rowNum >=0 ){
			je = $(grid_selector_exhibition).getCol("je",false,"sum"); 
		}
		$(grid_selector_exhibition).footerData("set",{"je":je}); //将合计值显示出来
	}
	
	// 计算其他费用明细合计行
	function sumItemOther(){
		var je;
		$(grid_selector_other).footerData("set",{"yt":"合计"}); //合计
		var rowNum = $(grid_selector_other).jqGrid('getGridParam','records');
		if(rowNum >=0 ){
			je = $(grid_selector_other).getCol("je",false,"sum"); 
		}
		$(grid_selector_other).footerData("set",{"je":je}); //将合计值显示出来
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
			ignore: ["hidden","disabled"],
			rules: {	
				gsbm:'required',
				cwkpr:'required',
				bgfs:'required',
				cylx:'required',
				qyg :'required',
		        mdg :'required',
		        yg20gp:'number',
		        yg40gp:'number',
		        yg40hq:'number',
		        dcZcs:'number',
		        dc3d:'number',
		        dc5d:'number',
		        dc8d:'number',
		        dc10d:'number',
		        dc12d:'number',
		        xwgj:'required',
		        zgsj:'required' 
		        	
			},
			messages: {
				gsbm  : '公司编码不能为空',
				cwkpr : '船务开票人未填写',
				bgfs: '报关方式未填写',
				cylx: '出运类型未填写',
				qyg : '起运港未填写',
		        mdg : '目的港未填写',
		        yg20gp :"20'GP只能填数字",
		        yg40gp :"40'GP只能填数字",
		        yg40hq :"40'HQ只能填数字",
		        dcZcs  :'总车数只能填数字',
		        dc3d   :'吨车3吨只能填数字',
		        dc5d   :'吨车5吨只能填数字',
		        dc8d   :'吨车8吨只能填数字',
		        dc10d  :'吨车10吨只能填数字',
		        dc12d  :'吨车12吨只能填数字',
		        xwgj   :'目的国家不能为空',
		        zgsj   :'装柜时间未填写' 
		        
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
	//保存
	function save(){
		if(!$('#form-submit').valid()){
			return false;
		}
		//结束表格编辑
	    var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			$(grid_selector).removeData('lastEdit');
		}
		//结束编辑行
	   lastEdit = $(grid_selector_other).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_other).saveRow(lastEdit, false, 'clientArray');
		    $(grid_selector_other).removeData('lastEdit');
		}
		
		var param = $('#form-submit').getFormData();
		var data = $(grid_selector).getRowData();
		if(data.length == 0){
			swal("","出货明细信息不能为空","warning");
			return  ;
		}
		result = true;
		var message = "";
		$.each(data, function(i,order){  
            if(order.ckxhqk == "" || order.ckxhqk == null){
            	message += "第"+(i+1)+"行，出口享惠情况不能为空.";
    			result = false;
            }
          }); 
		if(result == false){
			swal("",message,"warning");
			return;
		}
		param.mxList = JSON.stringify(data);
		param.mxOtherList = JSON.stringify($(grid_selector_other).getRowData());
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/deliver/deliver/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=chdh]").val(result.chdh);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
					$("#form-submit [name=token]").val(result.token);
				}); 
			}
		});
	}
	
	//提交
	function submit(){
		if(!$('#form-submit').valid()){
			return false;
		}
		//结束表格编辑
	    var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			$(grid_selector).removeData('lastEdit');
		}
		var param = $("#form-submit").getFormData();
		var data = $(grid_selector).getRowData();
		if(data.length == 0){
			swal("","出货明细信息不能为空","warning");
			return  ;
		}
		result = true;
		var message = "";
		$.each(data, function(i,order){  
            if(order.ckxhqk == "" || order.ckxhqk == null){
            	message += "第"+(i+1)+"行，出口享惠情况不能为空.";
    			result = false;
            }
          }); 
		if(result == false){
			swal("",message,"warning");
			return;
		}
		
		param.mxList = JSON.stringify(data);
		param.mxOtherList = JSON.stringify($(grid_selector_other).getRowData());
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/deliver/deliver/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	
</script>
</html>