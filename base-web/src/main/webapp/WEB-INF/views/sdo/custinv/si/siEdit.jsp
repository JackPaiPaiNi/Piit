<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<%
	String id = request.getParameter("id");
%>
</head>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">No.&nbsp;&nbsp;</label>
								<input type="text" name="sino" class="form-control" readonly />
								<input type="hidden" name="zt" />
								<input type="hidden" name="id" />
								<input type="hidden" name="sjc" />
								<input type="hidden" name="chdh" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-bldSelect" type="button"
								class="btn btn-purple btn-sm">
								<i class="fa fa-plus icon-on-right bigger-110"></i> 出货通知书选择
							</button>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm"></div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-save" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp;
							<button id="btn-submit" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">FM</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">SKYWORTH-MICHAEL.&nbsp;&nbsp;</label>
								<input type="text" name="chrmc" class="form-control" />
								<input type="hidden" name="chrid">
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">TEL&nbsp;&nbsp;</label> <input
									type="text" name="chrdh" class="form-control " />
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">E-mail&nbsp;&nbsp;</label> <input
									type="text" name="chryx" class="form-control " />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">发票号&nbsp;&nbsp;</label> <input
									type="text" name="fph" class="form-control " />
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;"></h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">SHIPPER&nbsp;&nbsp;</label>
								<textarea rows="4" name="fhrxx"
									class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">CONSIGNEE&nbsp;&nbsp;</label>
								<textarea rows="4" name="shrxx"
									class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">NOTIFY&nbsp;&nbsp;</label>
								<textarea rows="6" name="tzrxx"
									class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">PORT OF
									LOADING&nbsp;&nbsp;</label> <input type="text" name="qyg"
									class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">PORT OF RECEIPT
									&nbsp;&nbsp;</label> <input type="text" name="shd" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">PORT OF
									DISCHARGE&nbsp;&nbsp;</label> <input type="text" name="mdg"
									class="form-control" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">PLACE OF
									DELIVERY&nbsp;&nbsp;</label> <input type="text" name="zzmdd"
									class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-9">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">VESSEL&nbsp;&nbsp;</label> <input
									type="text" name="cmhc" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-9">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">MARKS & NOS.&nbsp;&nbsp;</label> <input
									type="text" name="marks" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-9">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">DESCRIPTION&nbsp;&nbsp;</label>
								<textarea rows="4" name="ms" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-12 col-sm-12">
							<div id="grid-parent">
								<table id="grid-table"></table>
								<div id="grid-pager"></div>
							</div>
						</div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
	<!-- /.page-content -->
	<span class="loading-indicator"> <label><i
			class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
	</span>
</body>
<script type="text/javascript">
	// 变量定义开始
	var id = "<%=id%>";
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	// 不可编辑
	var isEdit = false;
	// 权限判断
	<shiro:hasPermission name="custinv:si:edit">isEdit = true;</shiro:hasPermission>

	$(function($) {
		// 日期控件绑定
		var isEdit = true;
		$(".date-picker").bindDate();
		//出货订单信息选择
		$("#btn-bldSelect").click(
			function() {
				var width = 900;
				var height = 600;
				var left = (window.screen.width - width) / 2;
				var top = (window.screen.height - height) / 2;
				var pageUrl = "<c:url value='/custinv/si/searhListPage'/>";
				if (window.showModalDialog
						&& typeof (window.showModalDialog) === "function") {
					var dialogArgs = "resizable=1;dialogWidth=" + width
							+ "px;dialogHeight=" + height
							+ "px;dialogLeft=" + left + "px;dialogTop="
							+ top + "px";
					var data = window.showModalDialog(pageUrl, null,
							dialogArgs);
					if (data) {
						//初始出货明细数据
						initData(data);
					}
				} else {
					var dialogArgs = "resizable=1,width=" + width
							+ "px,height=" + height + "px,center=yes,left="
							+ left + "px,top=" + top + "px";
					var opener = window.open(pageUrl, null, dialogArgs);
					opener.openerCallBack = function(data) {
						initData(data);
					}
				}
			}
		);
		// 集装箱信息编辑表
		bindGridJzxxx();
		//初始化页面数据
		bindFormData(id);
		//保存
		$("#btn-save").click(function() {
			save();
		});
		$("#btn-submit").click(function() {
			submit();
		});
		//返回
		$('#btn-back').click(function() {
			window.history.back(-1);
		});
	});
	/**************************************************function开始区域************************************************/
	// 初始化出货明细信息
	function initData(data) {
		var chxx = "";
		$.each(data, function(i, value) {
			if(chxx.indexOf(value.chdno) < 0){
				chxx += value.chdno;
				chxx += ",";
			}
		});
		chxx = chxx.substr(0, chxx.length-1);
		$("#form-submit [name=chxx]").val(chxx);
		$.bindAjax({
			url : "<c:url value='/custinv/si/searhShippingInfo'/>",
			data : {
				chdNo : chxx
			},
			action : "search"
		}, function(response) {
			$("#form-submit [name=chdh]").val(chxx);
			$("#form-submit [name=chrid]").val(response.chrid);
			$("#form-submit [name=chrmc]").val(response.chrmc);
			$("#form-submit [name=chrdh]").val(response.chrdh);
			$("#form-submit [name=chryx]").val(response.chryx);
			$("#form-submit [name=fph]").val(response.fph);
			$("#form-submit [name=fhrxx]").val(response.fhrxx);
			$("#form-submit [name=shrxx]").val(response.shrxx);
			$("#form-submit [name=tzrxx]").val(response.tzrxx);
			$("#form-submit [name=qyg]").val(response.qyg);
			$("#form-submit [name=shd]").val(response.shd);
			$("#form-submit [name=mdg]").val(response.mdg);
			$("#form-submit [name=zzmdd]").val(response.zzmdd);
			$("#form-submit [name=cmhc]").val(response.cmhc);
			// 加载集装箱信息明细
			if (response.siItemList) {
				$(grid_selector).jqGrid("addRowData", null,
						response.siItemList, "last");
			}
		});
	}

	//初始化页面数据
	function bindFormData(id) {
		//view or edit
		if (id != "null") {
			$.bindAjax({
				url : "<c:url value='/custinv/si/findById'/>",
				data : {
					id : id
				},
				action : "search"
			}, function(response) {
				$("#form-submit").setFormData(response);
				// 加载集装箱信息明细
				if (response.siItemList) {
					$(grid_selector).jqGrid("addRowData", null, response.siItemList, "last");
				}
				$("#form-submit [name=oper]").val("edit");//编辑权限
			});
		} else {
			//初始化页面参数
			$("#form-submit [name=id]").val("");//id:空
			$("#form-submit [name=oper]").val("add");//操作:add
			$("#form-submit [name=zt]").val("1");//状态
			$("#form-submit [name=marks]").val("N/M");
		}
	}
	//初始化集装箱信息grid
	function bindGridJzxxx() {
		$(grid_selector).bindTable({
			caption : "",
			pager : pager_selector,
			gridParent : "#grid-parent",
			multiselect : true,
			footerrow : true,
			datatype : "local",
			//shrinkToFit: false,
			//autoScroll: false,
			colModel : [ 
			    {name : 'guino', index : 'guino', editable : false, label : 'CTNR NO.', width : 80}, 
			    {name : 'ftno', index : 'ftno', editable : false, label : 'SEAL NO.', width : 80}, 
			    {name : 'kbzwet', index : 'kbzwet', label : 'TTL G.W.(KGS)', width : 80, align : 'right', formatter : 'number', 
			    	editrules : {number : true}, formatoptions : {thousandsSeparator : ','}, editoptions : {dataInit : initKGS}}, 
			    {name : 'kbzv', index : 'kbzv', label : '  TTL MEAS.(CBM)', width : 80, align : 'right', formatter : 'number',
					editrules : {number : true}, formatoptions : {thousandsSeparator : ','}}, 
				{name : 'vgm', index : 'vgm', label : 'VGM(KGS)', width : 80, align : 'right', formatter : 'number',
					editrules : {number : true}, formatoptions : {thousandsSeparator : ','}, editoptions : {readonly:true}}, 
				{name : 'boxsum', index : 'boxsum', label : 'QTY OF PKGS(CTNS)', width : 80, align : 'right', formatter : 'integer',
					editrules : {number : true}, formatoptions : {thousandsSeparator : ','}}, 
				{name : 'kbsum', index : 'kbsum', label : 'QTY OF PKGS(PLTS)', width : 80, align : 'right', formatter : 'integer',
					editrules : {number : true}, formatoptions : {thousandsSeparator : ','}}, 
				{name : 'gxnam', index : 'gxnam', label : 'CTNR TYPE', editable : false, width : 80}, 
				{name : 'dcno', index : 'dcno', label : 'S/O NO.', editable : false, width : 80}, 
				{name : 'tare', index : 'tare', label : 'TARE', editable : false, width : 80} 
			],
			editTable : true,
			gridComplete : function() {
				sumGrid();
			},
			editComplete : function(lastEdit, rowData) {
				sumGrid();
			}
		}, {
			add : false,
			edit : isEdit,
			del : isEdit,
			complete : isEdit,
			view : false
		});
	}
	//TTL G.W.(KGS)
	function initKGS(elem) {
		$(elem).on("blur",function() {
			var kgs = $(elem).val();
			var tare = $.trim($(elem).closest("tr.jqgrow").find("[name='tare']").val());
			debugger;
			if (tare == null || tare == "") {
				tare = 0.0;
			}
			if (kgs == null || kgs == "") {
				kgs = 0.0;
			}
			var je = parseFloat(kgs) + parseFloat(tare) /* + parseFloat(ce)*/;
			$(elem).closest("tr.jqgrow").find("[name='vgm']").val(je.toFixed(2));
		});
	}

	// 计算合计行
	function sumGrid() {
		$(grid_selector).footerData("set", {
			"gh" : "TOTAL"
		}); //合计
		var rowNum = $(grid_selector).jqGrid('getGridParam', 'records');
		if (rowNum > 0) {
			var kb_count = $(grid_selector).getCol("kbzwet", false, "sum");
			var xs_count = $(grid_selector).getCol("kbzv", false, "sum");
			var zsl_count = $(grid_selector).getCol("vgm", false, "sum");
			var gmz_count = $(grid_selector).getCol("boxsum", false, "sum");
			var pz_count = $(grid_selector).getCol("kbsum", false, "sum");
			$(grid_selector).footerData("set", {
				"kbzwet" : kb_count,
				"kbzv" : xs_count,
				"vgm" : zsl_count,
				"boxsum" : gmz_count,
				"kbsum" : pz_count
			}); //将合计值显示出来
		}
	}
	
	//保存
	function save() {
		var param = $("#form-submit").getFormData();
		// 取产品表数据
		var lastSel = $(grid_selector).getGridParam('selrow');
		$(grid_selector).saveRow(lastSel, false, 'clientArray');
		var data = $(grid_selector).getRowData();
		param.mxList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		},{
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/custinv/si/save'/>",
					data : param,
					action : "save"
				},
				function(response) {
					location.href = "<c:url value='/custinv/si'/>";
				});
			}
		});
	}

	function submit() {
		var param = $("#form-submit").getFormData();
		// 取产品表数据
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		},{
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/custinv/si/submit'/>",
					data : {
						id:param.id,
						sjc:param.sjc
					},
					action : "submit"
				},
				function(response) {
					location.href = "<c:url value='/custinv/si'/>";
				});
			}
		});
	}
</script>
</html>