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
		String ids = request.getParameter("ids");
		String sfBg = request.getParameter("sfBg");
	%>
<body>
<div class="zheZhao"></div>
	<div class="page-content">

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<form id="form-submit">
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<input type="hidden" name="id" />
						<!-- id -->
						<input type="hidden" name="oper" /> 
						<input type="hidden" name="sjc" /> 
						<input type="hidden" name="token" value="${token}">
						<input type="hidden" name="sapgsbm" />
						<input type="hidden" name="khlx" />
					</div>
					<div class="space-4"></div>
					<div class="col-xs-6 col-sm-12"
						style="text-align: center; margin: 0 auto;">
						<button id="btn-save" type="button" class="btn btn-success btn-sm">
							<i class="icon-save icon-on-right bigger-110"></i> 保存
						</button>
						&nbsp;
						<button id="btn-submit" type="button" class="btn btn-info btn-sm">
							<i class="icon-ok icon-on-right bigger-110"></i> 提交
						</button>
						&nbsp;
						<button id="undo" class="btn btn-sm" type="button"
							onclick="javascript:history.back(-1);">
							<i class="icon-undo icon-on-right bigger-110"></i> 返回
						</button>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">预走货信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-12 col-sm-12">
							<div id="grid-parent-yzhxx">
								<table id="grid-table-yzhxx"></table>
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">订舱信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
							<select role="select" name="scjd" size="1" class="form-control skydisabled" disabled="disabled">
								${fns:loadDictOption('SCJD')}
							</select>
						</div>
					  </div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订舱流水号&nbsp;&nbsp;</label> <input
									type="text" name="dcdh" class="form-control  skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">制单人&nbsp;&nbsp;</label> <input
									type="text" name="zdrmc" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">制单时间&nbsp;&nbsp;</label> <input
									type="text" name="zdsj"
									class="form-control date-picker skydisabled"
									disabled="disabled" /> <span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">状态&nbsp;&nbsp;</label>
								<select role="select" name="zt" size="1" class="form-control skyselect skydisabled" disabled="disabled">
									${fns:loadDictOption('DJZT')}
								</select>
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label> <input
									type="text" name="khbm" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
									type="text" name="khmc" class="form-control" readonly />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司编码&nbsp;&nbsp;</label> <input
									type="text" name="gsbm" class="form-control" readonly />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司名称&nbsp;&nbsp;</label> <input
									type="text" name="gsmc" class="form-control" readonly />
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">出运类型&nbsp;&nbsp;</label> <select
									role="select" name="cylx" size="1"
									class="form-control skyselect">
									${fns:loadDictOption('CYLX')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">目的国家&nbsp;&nbsp;</label> <input
									type="hidden" name="xwgj" /> <input type="text" name="xwgjmc"
									class="form-control" readonly />
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
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">目的港口&nbsp;&nbsp;</label> <input
									type="text" name="mdg" class="form-control" />
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">贸易条款&nbsp;&nbsp;</label> <select
									role="select" name="mytk" size="1"
									class="form-control skyselect">
									${fns:loadDictOption('PIGJMYTK')}
								</select>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">船代公司编码&nbsp;&nbsp;</label> <input
									type="text" name="cdgsbm" onfocus="this.blur()"
									class="form-control  parent-node" /> <span
									class="input-group-addon"> <i
									class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">船代公司名称&nbsp;&nbsp;</label> <input
									type="text" name="cdgsmc" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">船代公司联系人&nbsp;&nbsp;</label> <input
									type="text" name="cdgslxr" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">船代公司电话&nbsp;&nbsp;</label> <input
									type="text" name="cdgsdh" class="form-control skydisabled" disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">快递类型&nbsp;&nbsp;</label> <input
									type="text" name="kdlx" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">快递公司&nbsp;&nbsp;</label> <input
									type="text" name="kd" class="form-control skydisabled"
									disabled="disabled" />

							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">快递备注&nbsp;&nbsp;</label> <input
									type="text" name="kdbz" class="form-control skydisabled"
									disabled="disabled">
							</div>
						</div>
	                    <div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">预计开船期&nbsp;&nbsp;</label> <input
									type="text" name="yjkcq" class="form-control date-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">装柜日期&nbsp;&nbsp;</label> <input
									type="text" name="zgrq" class="form-control date-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
							<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">到付账户&nbsp;&nbsp;</label> <input
									type="text" name="dfzh" class="form-control">
							</div>
						</div>
					
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">预计到港期&nbsp;&nbsp;</label> <input
									type="text" name="yjdgq" class="form-control date-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">柜数(20'GP)&nbsp;&nbsp;</label> <input
									type="text" name="yg20gp" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">柜数(40'GP)&nbsp;&nbsp;</label> <input
									type="text" name="yg40gp" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">柜数(40'HQ)&nbsp;&nbsp;</label> <input
									type="text" name="yg40hq" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">总柜数&nbsp;&nbsp;</label> <input
									type="text" name="ygZgs" class="form-control" />
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">柜数备注&nbsp;&nbsp;</label> <input
									type="text" name="ygGsbz" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">3吨车&nbsp;&nbsp;</label> <input
									type="text" name="dc3d" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">5吨车&nbsp;&nbsp;</label> <input
									type="text" name="dc5d" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">8吨车&nbsp;&nbsp;</label> <input
									type="text" name="dc8d" class="form-control" />
							</div>
						</div>

						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">10吨车&nbsp;&nbsp;</label> <input
									type="text" name="dc10d" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">12吨车&nbsp;&nbsp;</label> <input
									type="text" name="dc12d" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">总车数&nbsp;&nbsp;</label> <input
									type="text" name="dcZcs" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">吨车备注&nbsp;&nbsp;</label> <input
									type="text" name="dcDcbz" class="form-control" />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">订舱确认信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订舱号&nbsp;&nbsp;</label> <input
									type="text" name="dch" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">船名&nbsp;&nbsp;</label> <input
									type="text" name="cm" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">航次&nbsp;&nbsp;</label> <input
									type="text" name="hc" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
				   	<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">航班号&nbsp;&nbsp;</label> <input
									type="text" name="hbh" class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">截重时间&nbsp;&nbsp;</label> <input
									type="text" name="jcsj" class="form-control date-time-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">截放行条时间&nbsp;&nbsp;</label> <input
									type="text" name="jfxtsj" class="form-control date-time-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
					    </div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">截补料/ENS/AMS时间&nbsp;&nbsp;</label>
								<input type="text" name="jblsj" class="form-control date-time-picker" />
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">开舱时间&nbsp;&nbsp;</label> <input
									type="text" name="kcsj" class="form-control date-time-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">截VGM&nbsp;&nbsp;</label> <input
									type="text" name="jgq" class="form-control date-time-picker" /> <span
									class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-sm-6 col-sm-8">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">备注&nbsp;&nbsp;</label> <input
									type="text" name="bzxx"
									class="autosize-transition form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
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

				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
</span>
</body>
<script type="text/javascript">
	var ids = "<%=ids%>";
	var id = "<%=id%>";
	var sfBg = "<%=sfBg%>";
	var grid_selector_yzhxx = "#grid-table-yzhxx";
	var isEdit = false;
	// 权限判断
 	<shiro:hasPermission name="booking:booking:edit">isEdit=true;</shiro:hasPermission>
 	// 加载开始
	$(function($){
		// select2控件绑定
	    $(".skyselect").select2();
	  	// 日期控件绑定
		$(".date-picker").bindDate();
	  	// 日期控件（精确到时分秒）
	  	$(".date-time-picker").bindDateTime();
		// 船代公司选择
		$("#form-submit [name=cdgsbm]").parent().click(function(){
			bindCdgsbm();
		});
		// 快递类型
		getKdlxInfo();
		// 出运类型change事件
		cylxBindChangeEvent();
		
		bindFormData(id,ids);
		
		initGrid();
		//前段数据校验
		validate();
			
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
		
		// 保存
		$("#btn-save").click(function(){
			save();
		});
		// 提交
		$("#btn-submit").click(function(){
			submit();
		});
	})
 	
	// 出运类型change事件
	function cylxBindChangeEvent(){
		$('#form-submit [name=cylx]').on('change',function(e){
			  if($(this).val() != 4 ){
				  $('#form-submit [name=kdlx]').select2("val","");
			      $('#form-submit [name=kd]').select2("val","");
			      $('#form-submit [name=kdbz]').val("");
				  $('#form-submit [name=kdlx]').prop('disabled','disabled');
			      $('#form-submit [name=kd]').prop('disabled','disabled');
			      $('#form-submit [name=kdbz]').prop('disabled','disabled');
			  }else{
				  $('#form-submit [name=kdlx]').removeProp('disabled').removeAttr('disabled');
			      $('#form-submit [name=kd]').removeProp('disabled').removeAttr('disabled');
			      $('#form-submit [name=kdbz]').removeProp('disabled').removeAttr('disabled');
			  }
		 });
	}
 	
	// 变量定义结束
	function initGrid(){
		$(grid_selector_yzhxx).bindTable({
			caption: "",
			gridParent: "#grid-parent-yzhxx",
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60},
				{name:'sfkt', index:'sfkt', label:'预走货主客类型', width:90},
				//{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:90,formatter:yzhxx},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:90},
				{name:'yzhlx', index:'yzhlx', label:'预走货类型', width:80, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('YZHLX')}"}}, 
				{name:'zgsj', index:'zgsj', label:'装柜日期', width:80},
				{name:'yg_20gp', index:'yg_20gp',align:'right', label:"柜数（20'GP）", width:100,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'yg_40gp', index:'yg_40gp',align:'right', label:"柜数（40'GP）", width:100,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'yg_40hq', index:'yg_40hq',align:'right', label:"柜数（40'HQ）", width:100,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'yg_gsbz', index:'yg_gsbz', label:'柜数备注', width:100},
				{name:'dc_3d', index:'dc_3d',align:'right', label:'3吨车', width:80,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'dc_5d', index:'dc_5d',align:'right', label:'5吨车', width:80,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'dc_8d', index:'dc_8d',align:'right', label:'8吨车', width:80,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'dc_10d', index:'dc_10d',align:'right', label:'10吨车', width:80,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'dc_12d', index:'dc_12d',align:'right', label:'12吨车', width:80,
					formatter:'integer',formatoptions:{thousandsSeparator: ','},editrules:{integer:true}},
				{name:'dc_dcbz', index:'dc_dcbz', label:'吨车备注', width:100}
			]
		});
	}
	//船代公司选择框
	function bindCdgsbm(){
		$.tableDialogPage({
			title:"船代公司选择",
			searchCond:[{"name":"船代公司编码","value":"gsbm"},
			            {"name":"船代公司名称","value":"gsmc"}],
			colModel:[{name:'gsbm', index:'gsbm', label:'船代公司编码', width:60},
					  {name:'gsmc', index:'gsmc', label:'船代公司名称', width:100}],
			url:"<c:url value='/mdm/shippingCompany/search'/>"
		},{
			callback:function(rows){
// 				if(rows){
// 					$("#form-submit [name=cdgsbm]").val(rows.gsbm);
// 					$("#form-submit [name=cdgsmc]").val(rows.gsmc);
// 					$("#form-submit [name=cdgslxr]").val(rows.lxr);
// 					$("#form-submit [name=cdgsdh]").val(rows.dh);
// 				}else{
// 					$("#form-submit [name=cdgsbm]").val("");
// 					$("#form-submit [name=cdgsmc]").val("");
// 					$("#form-submit [name=cdgslxr]").val("");
// 					$("#form-submit [name=cdgsdh]").val("");
// 				}
				if(rows.gsbm == 'GS000'){
					$('#form-submit [name=cdgsbm]').removeAttr('disabled');
					$('#form-submit [name=cdgsmc]').removeAttr('disabled');
					$('#form-submit [name=cdgslxr]').removeAttr('disabled');
					$('#form-submit [name=cdgsdh]').removeAttr('disabled');
					$("#form-submit [name=cdgsbm]").val("");
					$("#form-submit [name=cdgsmc]").val("");
					$("#form-submit [name=cdgslxr]").val("");
					$("#form-submit [name=cdgsdh]").val("");
				}else{
					$("#form-submit [name=cdgsbm]").val(rows.gsbm);
					$("#form-submit [name=cdgsmc]").val(rows.gsmc);
					$("#form-submit [name=cdgslxr]").val(rows.lxr);
					$("#form-submit [name=cdgsdh]").val(rows.dh);
					$('#form-submit [name=cdgsmc]').attr('disabled','disabled');
					$('#form-submit [name=cdgslxr]').attr('disabled','disabled');
					$('#form-submit [name=cdgsdh]').attr('disabled','disabled');
				}
			}
		});
	}
	
	//取快递类型select2信息
	function getKdlxInfo(){
		$.post("<c:url value='/pub/select2/dict'/>",{type : "KDLX"},
			function(result){
				var data = $.map(result, function (obj) {
			       obj.id = obj.code || obj.name;
			       obj.text =  obj.name ;		      
			       return obj;
			     });
				$("#form-submit [name=kdlx]").addClass("skyselect").select2({data:data}).on("change",function(e){
					if(e.added){
						$.post("<c:url value='/pub/select2/dict'/>",{type : getKdType($("#form-submit [name=kdlx]").val())},
								function(result){
									var data = $.map(result, function (obj) {
								       obj.id = obj.code || obj.name;
								       obj.text =  obj.name ;		      
								       return obj;
								     });
								$("#form-submit [name=kd]").addClass("skyselect").select2({data:data});
						}, "json")
					};
				  });
		}, "json");
	}
	
	// 取快递公司select2
	function selectKd(type){
		$.post("<c:url value='/pub/select2/dict'/>",{type : getKdType(type)},
				function(result){
					var data = $.map(result, function (obj) {
				       obj.id = obj.code || obj.name;
				       obj.text =  obj.name ;		      
				       return obj;
				     });
				$("#form-submit [name=kd]").addClass("skyselect").select2({data:data});
		}, "json")
	}
	
	// 取字典快递类型
	function getKdType(type){
	    var Type = "";
	    if(type == "1"){
		    Type = "GNKD"; 
	    }else if(type == "2"){
		    Type = "GJKD"; 
	    }else if(type == "3"){
		    Type = "QTKD"; 
	    }
	    return Type;
	}
	
	// 保存
	function save(){
		if(!$('#form-submit').valid()){
			return false;
		}
		var param = $("#form-submit").getFormData();
		debugger ;
		// 取预走货信息
		var yzh_data = $(grid_selector_yzhxx).getRowData();
		// 数据转换
		param.bookingList = JSON.stringify(yzh_data);
		$("#save").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/booking/booking/edit'/>",
					data:param,
					action:"save",
				},function(response){
 					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=dcdh]").val(result.dcdh);
					$("#form-submit [name=zdrmc]").val(result.zdrmc);
					$("#form-submit [name=zdsj]").val(result.zdsj);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=zt]").select2('val',result.zt);
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
		var param = $("#form-submit").getFormData();
		// 取预走货信息
		var yzh_data = $(grid_selector_yzhxx).getRowData();
		// 数据转换
		param.bookingList = JSON.stringify(yzh_data);
		$("#submit").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/booking/booking/submit'/>",
					data:param,
					action:"save",
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	
	//初始化页面数据
	function bindFormData(id, ids){	
		if(id != "null" && ids == "null"){
			//edit
			$.bindAjax({
				url : "<c:url value='/booking/booking/findById'/>",
				data : {id:id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$("#fjxx").html(response.fj);
				if(sfBg == 1){
					$("#form-submit [name=zt]").select2("val", 1);//草稿
				}
				// 预走货加载
				if(response.bookingItemList){
					$(grid_selector_yzhxx)[0].addJSONData({items:response.bookingItemList});
				} 
				$("#form-submit [name=oper]").val("edit");//编辑
				$("#form-submit [name=id]").val(id);
				selectKd(response.kdlx);
			});
		} else if(id == "null" && ids != "null"){	
			$.bindAjax({
				url : "<c:url value='/booking/bookingDb/findByYzhdhs'/>",
				data : {ids:ids},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				// 预走货加载
				if(response.bookingItemList){
					$(grid_selector_yzhxx)[0].addJSONData({items:response.bookingItemList});
				} 
				$("#form-submit [name=oper]").val("add");//新增
				$("#form-submit [name=zt]").select2("val", 1);//草稿
				selectKd(response.kdlx);
			});
		}
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
				cylx  : 'required',
				mytk  : 'required',
				qyg   : 'required',
				zgrq  : 'required',
				yjkcq : 'required',
				yjdgq : 'required',
				//cdgsbm : 'required',
			    yg40hq :'number',
			    yg40gp :'number',
			    yg20gp :'number',
			    dc3d   :'number',
			    dc5d   :'number',
			    dc8d   :'number',
			    dc10d   :'number',
			    dc12d   :'number',
			},
			messages: {
				cylx  : '出运类型未填写',
				mytk  : '贸易条款未填写',
				qyg   : '起运港未填写',
				zgrq  : '装柜日期未填写',
				yjkcq : '预计开船未填写',
				yjdgq : '预计到货日期未填写',
				//cdgsbm :'船公司编码',
				yg40hq :'柜数40HQ只能填数字',
			    yg40gp :'柜数40GP只能填数字',
			    yg20gp :'柜数20GP只能填数字',
			    dc3d   :'吨车3只能填数字',
			    dc5d   :'柜数5只能填数字',
			    dc8d   :'柜数8只能填数字',
			    dc10d  :'柜数10只能填数字',
			    dc12d  :'柜数12只能填数字',
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
	
	//预走货弹窗
	function yzhxx(cellvalue, options, rowData){
	    var href = "<a onclick='javascript:show(\""+rowData.yzhlx+"\""+"\,"+"\""+rowData.id+"\""+");'>"+rowData.yzhdh+"</a>";
		return  href ;
	}
	

    function show(yzhlx, id){
    	var url = "" ;
    	//大货
		if(yzhlx == 1){
			 url = "<c:url value='/pso/tvPso/viewPage'/>" + "?id=" + id;
		} 
		//多元化和多元化屏
		if(yzhlx == 2 || yzhlx==3){
		    url ="<c:url value='/pso/diversityPso/viewPage'/>" + "?id=" + id;
		}
		//样机
		if(yzhlx == 4){
			url ="<c:url value='/pso/samplePso/viewPage'/>" + "?id=" + id;
		}
		//备损
		if(yzhlx == 5){
			 url ="<c:url value='/pso/spoPso/viewPage'/>" + "?id=" + id;
		}
		if(url.length > 0){
			 window.open(url); 
		}
    }
	
</script>
</html>