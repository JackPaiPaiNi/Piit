<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
</head>
<body>
	<div class="page-content">
		<div class="row">
			<div id="grid-parent" class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<div class="widget-box">
					<div class="widget-header header-color-blue2">
						<h5>查询条件</h5>
						<span class="widget-toolbar"> <a href="#"
							data-action="collapse"> <i class="icon-chevron-up"></i>
						</a>
						</span>
						<div class="widget-toolbar no-border">
							<button id="btn-search" type="button" class="btn btn-info btn-minier bigger">
								<i class="icon-search icon-on-right"></i> 查询
							</button>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<form id="form-search" class="form-search">
								<div class="row">
									<input type="hidden" name="zt" />
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">客户&nbsp;&nbsp;</label> <input
												type="text" name="khmc" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">中信保买方代码&nbsp;&nbsp;</label> <input
												type="text" name="zxbmfdm" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">国家&nbsp;&nbsp;</label> 
												<select role="select" name="gj" size="1" class="form-control skyselect">
														${fns:loadCountryOption('0')}
								         		</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">信用额度类型&nbsp;&nbsp;</label> <select
												role="select" name="xyedlx" size="1"
												class="form-control skyselect">
												${fns:loadDictOption('XYEDLX')}
											</select>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				
				<table id="grid-table"></table>

				<div id="grid-pager"></div>
				<div class="space-4"></div>
				<div>
					<form id="form-submit" >
						<div class="row">
							<div class="col-xs-9 col-sm-9">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">审批意见&nbsp;&nbsp;</label>
									<textarea name="spyj" class="autosize-transition form-control"></textarea>
									<input type="hidden" id="ids" name="ids" />
								</div>
							</div>
							<div class="col-xs-3 col-sm-3">
								<button id="btn_approve_ok" type="button" class="btn btn-info btn-sm">
									<i class="icon-ok icon-on-right bigger-110"></i> 通过
								</button>
								&nbsp;
								<button id="btn_approve_back" type="button" class="btn btn-danger btn-sm" >
									<i class="fa-times icon-on-right bigger-110"></i> 驳回
								</button>
							</div>
						</div>
					</form>
				</div>
				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var isEdit = false;
	var searchurl = "<c:url value='/payment/payCredit/search'/>";
	<shiro:hasPermission name="payment:payCredit:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$("#form-search [name=zt]").val("2");
		//初始化编辑表
		InitGrid();
		//校验
		$('#form-submit').validate({});
	});

	//查询
	$("#btn-search").click(function() {
		$(grid_selector).trigger("reloadGrid");
	});
	//审核通过
	$("#btn_approve_ok").click(function() {
		approve(3);
	});
	//审核退回
	$("#btn_approve_back").click(function() {
		approve(2);
	});
	/**************************************************function开始区域************************************************/
	//初始化编辑表
	function InitGrid(){
		$(grid_selector).bindTable({
			caption: "",
			shrinkToFit:false,
			autoScroll: false,
			url: searchurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect: true,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'zt', label:'状态', hidden: true, width:60},
				{name:'ztmc', index:'ztmc', label:'状态', width:70},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:80},
				{name:'xyedlx', index:'xyedlx', label:'信用额度类型', width:80, hidden: true},
				{name:'xyedlxmc', index:'xyedlxmc', label:'信用额度类型', width:80},
				{name:'sszz', index:'sszz', label:'所属组织', width:80, hidden: true},
				{name:'sszzmc', index:'sszzmc', label:'客户所属组织', width:80},
				{name:'zxbmfdm', index:'zxbmfdm', label:'中信保买方编码', width:80},
				{name:'gj', index:'gj', label:'国家', width:80, hidden: true},
				{name:'gjmc', index:'gjmc', label:'国家', width:60},
				{name:'kzh', index:'kzh', label:'LC开证行', width:80},
				{name:'kzhdm', index:'kzhdm', label:'LC开证行SWIFT', width:80},
				{name:'zxbed', index:'zxbed', label:'中信保额度', align:'right',width:80,formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'nbgled', index:'nbgled', label:'内部管理额度',align:'right', width:80,formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'ysyed', index:'ysyed', label:'已使用额度',align:'right', width:60,formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'ksyxq', index:'ksyxq', label:'开始有效期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'yxq', index:'yxq', label:'结束有效期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'xexzq', index:'xexzq', label:'限额闲置期', width:80,
					align:'right',formatter:'number'},
				{name:'pfbl', index:'pfbl', label:'赔付比例', width:80,formatter:percentFormat,unformat:unPercentFormat},
				{name:'sfxh', index:'sfxh', label:'是否循环', width:80,edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
				{name:'zdrid', index:'zdrid', label:'登记人ID', width:100, hidden: true, editrules:{edithidden:true}},
				{name:'zdrmc', index:'zdrmc', label:'登记人名称', width:100,  editrules:{edithidden:true}},
				{name:'zdsj', index:'zdsj', label:'登记时间', width:100, editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zq', label:'zq', label:'账期', width:60},
				{name:'pfblJsfx', label:'pfblJsfx', label:'赔付比例（拒收风险）', width:60},
				{name:'bbh', index:'bbh', label:'版本号', width:100, hidden: true, editrules:{edithidden:true}},
				{name:'sjc', index:'sjc', label:'时间戳', width:100, hidden: true, editrules:{edithidden:true}},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:150},
			],
			sortname: 'khbm',
			sortorder: 'asc'
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		}).jqGrid('setFrozenColumns');
	}
	//校验
	$('#form-submit').validate({
		onfocusout : false,
		onkeyup : false,
		onclick : false,
		focusInvalid : false,
		focusCleanup : false,
		rules : {
			spyj : 'required'
		},
		messages : {
			spyj : '审批意见不能为空！'
		},
		showErrors : function(errorMap, errorList) {
			if (errorList.length == 0) {
				$('.input-group').removeClass('has-error');
			} else {
				var msg = "";
				$.each(errorList, function(i, v) {
					msg += (v.message + "\r\n");
					$(v.element).closest('.input-group').addClass('has-error');
				});
				swal({
					title : "校验不通过！",
					text : msg,
					type : "error"
				}, function() {
					return false;
				});
			}
		}
	});
	
	// 审批方法
	function approve(approveType) {
		var data = $(grid_selector).jqGrid("getGridParam", "selarrrow");
		// 判断是否选了数据
		if(!data.length > 0){
			swal("","请至少勾选一条记录！","warning");
			return;
		}
		// 表单验证
		if (!$('#form-submit').valid()) {
			return false;
		}
		// 循环处理选中数据（可多选）
		var rows = [];
		for (var i = 0; i < data.length; i++) {
			var rowData = $(grid_selector).jqGrid("getRowData", data[i]);
			if (rowData.zt != 2) {
				swal("系统只允许操作审批中的单据！","","warning");
				return;
			}
			var row = {};
			row.id = data[i];
			row.sjc = rowData.sjc;
			rows.push(row);
		}
		// 获取表单数据并审批
		var param = $("#form-submit").getFormData();
		param.rows = JSON.stringify(rows);
		param.approveType = approveType;
		$("body").bindSweetAlert({
			title : "确定要审批吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payCredit/approve'/>",
					data : param,
					action : "save"
				}, function(response) {
					$('#form-submit')[0].reset();
					$(grid_selector).trigger("reloadGrid");
				});
			}
		});
	}

	function percentFormat(cellValue) {
		if (cellValue != null && cellValue != "") {
			return cellValue * 100 + "%";
		} else {
			return "";
		}
	}
	function unPercentFormat(cellValue) {
		if (cellValue != null && cellValue != "") {
			var value = cellValue.replace("%", "");
			value = parseFloat(value) / 100;
			return value;
		} else {
			return "";
		}
	}
	/**************************************************function结束区域************************************************/
</script>
</html>