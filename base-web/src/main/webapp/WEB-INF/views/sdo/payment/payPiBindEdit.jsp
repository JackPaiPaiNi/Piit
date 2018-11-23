<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>

</head>
	<%
		String piid = request.getParameter("piid");
		Object myPibind = request.getAttribute("pibindlist");
	%>
<body>
	<div class="zheZhao"></div>
 	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
 				<form id="form-submit">
					<input type="hidden" name="piid" value="${pibind.piid}" />
					<input type="hidden" name="sjc" value="${pibind.sjc}" />
					<input type="hidden" name="lc_yq" value="${pibind.lc_yq}" />
					<input type="hidden" name="tt_hxbdje" value="${pibind.tt_hxbdje}"/>
					<input type="hidden" name="tt_xdyq" value="${pibind.tt_xdyq}" />
					<input type="hidden" name="tt_ckyq" value="${pibind.tt_ckyq}" />
					<!--PI付款保障关联信息 -->
					<div class="row">
						<div class="col-xs-12 col-sm-9">
							<table class="table table-bordered">
								<tr>
									<th>PI号</th>
									<th>客户编码</th>
									<th>客户名称</th>
									<th>付款条件</th>
									<th>总金额</th>
									<th>币种</th>
								</tr>
								<tr>
									<td>${pibind.piid}</td>
									<td>${pibind.khbm}</td>
									<td>${pibind.khmc}</td>
									<td>${pibind.fktjmc}</td>
									<td align='right'><fmt:formatNumber value="${pibind.zje}" pattern="#,#00.00" /></td>
									<td>${pibind.bz}</td>
								</tr>	
							</table>
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-submit" type="button" class="btn btn-info btn-xs">
								<i class="icon-ok icon-on-right bigger-60"></i> 提交
							</button>
							&nbsp;
							<button id="undo" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-60"></i> 返回
							</button>
						</div>
					</div>
					<h5 class="header blue" style="margin-top:4px;">T/T要求</h5>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-9">
							<table class="table table-bordered">
								<tr>
									<th>下单前要求金额</th>
									<th>占总金额的比例</th>
									<th>出库前要求金额</th>
									<th>占总金额的比例</th>
									<th>已绑定定金金额</th>
									<th>还需绑定金额</th>
									<th>已使用金额</th>
									<th>未使用定金金额</th>
								</tr>
								<tr>
									<td align='right'><fmt:formatNumber value="${pibind.tt_xdyq}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.tt_xdzb}" type="percent"/></td>
									<td align='right'><fmt:formatNumber value="${pibind.tt_ckyq}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.tt_ckzb}" type="percent"/></td>
									<td align='right'><fmt:formatNumber value="${pibind.tt_ybdje}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.tt_hxbdje}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.tt_ysyje}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.tt_wsyje}" pattern="#,#00.00" /></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="row">
				        <div class="col-xs-12 col-sm-9" id="grid-parent-ttxx">
							<table id="grid-table-ttxx"></table>
							<div id="grid-pager-ttxx"></div>
						</div>
                   	</div>
					<h5 class="header blue" style="margin-top:4px;">L/C要求</h5>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-12 col-sm-8">
							<table class="table table-bordered">
								<tr>
									<th>L/C要求金额</th>
									<th>占总金额的比例</th>
									<th>已绑定金额</th>
									<th>还需绑定金额</th>
									<th>是否满足要求</th>
									<th>已使用金额</th>
									<th>未使用金额</th>
								</tr>
								<tr>
									<td align='right'><fmt:formatNumber value="${pibind.lc_yq}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.lc_zb}" type="percent"/></td>
									<td align='right'><fmt:formatNumber value="${pibind.lc_ybd}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.lc_hxbd}" pattern="#,#00.00" /></td>
									<td >${pibind.lc_sfmzyq}</td>
									<td>${pibind.lc_ysyje}</td>
									<td>${pibind.lc_wsyje}</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="row">
				        <div class="col-xs-12 col-sm-9" id="grid-parent-lcxx">
							<table id="grid-table-lcxx"></table>
							<div id="grid-pager-lcxx"></div>
						</div>
                   	</div>
					<h5 class="header blue" style="margin-top:4px;">信用额度要求</h5>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							<table class="table table-bordered">
								<tr>
									<th>O/A要求金额</th>
									<th>占总金额的比例</th>
								</tr>
								<tr>
									<td align='right'><fmt:formatNumber value="${pibind.oa_yq}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.oa_zb}" type="percent"/></td>
								</tr>
							</table>
						</div>
						<div class="col-xs-6 col-sm-3">
							<table class="table table-bordered">
								<tr>
									<th>D/P要求金额</th>
									<th>占总金额的比例</th>
								</tr>
								<tr>
									<td align='right'><fmt:formatNumber value="${pibind.dp_yq}" pattern="#,#00.00" /></td>
									<td align='right'><fmt:formatNumber value="${pibind.dp_zb}" type="percent"/></td>
								</tr>
							</table>
						</div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	//变量定义开始
	var myPibind = <%=myPibind%>;
	var piid = "<%=piid%>";
	var grid_selector_ttxx = "#grid-table-ttxx";
	var pager_selector_ttxx = "#grid-pager-ttxx";
	var grid_selector_lcxx = "#grid-table-lcxx";
	var pager_selector_lcxx = "#grid-pager-lcxx";
	// 不可编辑
	var isEdit = false;
	// 权限判断
	<shiro:hasPermission name="payment:payPiBind:edit">isEdit = true;</shiro:hasPermission>
	// 变量定义结束 
	// 加载开始
	$(function($) {
		// 初始化grid
		bindGrid();
		if(myPibind.length > 0){
			bindData(myPibind[0]);
		}
		// 前端数据校验
		$('#form-submit').validate({
			onfocusout : false,
			onkeyup : false,
			onclick : false,
			focusInvalid : false,
			focusCleanup : false,
			rules : {
			//ckddh: 'required'
			},
			messages : {
			//ckddh: '不能为空'
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
		// 提交
		$("#btn-submit").click(function() {
			submit();
		});
		// 返回
		$("#undo").click(function(){
			window.history.back(-1);
	    });
	});
	/**************************************************function开始区域************************************************/
	//初始化grid
	function bindGrid() {
		//TT绑定
		$(grid_selector_ttxx).bindTable({
			caption : "",
			gridParent : "#grid-parent-ttxx",
			pager: pager_selector_ttxx,
			colModel:[{name: 'id',label : 'ID',hidden : true,editable : false},
			          {name : 'rldh',index : 'rldh',label : '认领单号',width : 100,editoptions : {dataInit : initrldh}, editrules:{required:true}}, 
			          {name : 'lcbh',index : 'lcbh',label : 'LC编号',width : 100,hidden : true}, 
			          {name : 'bdlx',index : 'bdlx',label : '绑定类型',width : 100,hidden : true}, 
			          {name : 'edbz',index : 'edbz',label : '认领币种',width : 80,editoptions : {disabled:true}}, 
			          {name : 'edsyed',index : 'edsyed',label : '剩余额度（认领币种）',width : 100, editoptions : {disabled:true},
			        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}}, 
			          {name : 'ydEdHl',index : 'ydEdHl',label : '汇率',width : 100, editoptions : {disabled:true},
			        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 9}},
			          {name : 'syed',index : 'syed',label : '剩余额度（PI币种）',width : 100,editoptions : {disabled:true},
			        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}}, 
			          {name : 'kzh',index : 'kzh',label : '开证行',width : 100, hidden : true}, 
			          {name : 'bz',index : 'bz',label : 'PI币种',width : 80,editoptions : {disabled:true}}, 
			          {name : 'je',index : 'je',label : '本次使用额度（PI币种）',width : 120, editrules:{required:true, number:true, minValue:0},
			        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}}
			          ],
			editTable:true,
			editComplete: function(lastEdit, rowData){
				 $(grid_selector_ttxx).removeData('lastEdit');
			}
		}, {
			add : isEdit,
			edit : false,
			del : isEdit
		});
		//LC绑定
		$(grid_selector_lcxx).bindTable({
			caption : "",
			gridParent : "#grid-parent-lcxx",
			pager: pager_selector_lcxx,
			colModel:[{name : 'id',label : 'ID',hidden : true,editable : false},
			          {name : 'lcbh',index : 'lcbh',label : 'LC编号',width : 100, editoptions : {dataInit : initlcdh}, editrules:{required:true}}, 
			          {name : 'bdlx',index : 'bdlx',label : '绑定类型',width : 100, hidden : true}, 
			          {name : 'kzh',index : 'kzh',label : '开证行',width : 100, editoptions : {disabled:true}},
			          {name : 'kzhdm',index : 'kzhdm',label : '开证行代码',width : 100, hidden : true, editoptions : {disabled:true}},
			          {name : 'edbz',index : 'edbz',label : 'LC币种',width : 80,editoptions : {disabled:true}}, 
			          {name : 'edye',index : 'edye',label : 'LC余额',width : 100, editoptions : {disabled:true},
			        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}}, 
			          {name : 'ydEdHl',index : 'ydEdHl',label : '汇率',width : 100, editoptions : {disabled:true},
			        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 9}},
				      {name : 'bz',index : 'bz',label : 'PI币种',width : 80,editoptions : {disabled:true}},
			          {name : 'ye',index : 'ye',label : 'LC余额（PI币种）',width : 110, editoptions : {disabled:true},
			        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}},  
			          {name : 'je',index : 'je',label : '本次使用额度（PI币种）',width : 140, editrules:{required:true, number:true, minValue:0},
			        	  align:'right',formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}}
			         ],
			editTable:true,
			editComplete: function(lastEdit, rowData){
				 $(grid_selector_lcxx).removeData('lastEdit');
			}
		}, {
			add : isEdit,
			edit : false,
			del : isEdit
		});
		
		if(Number($("#form-submit [name=tt_hxbdje]").val()) == 0){
			//禁用新增按钮
			$("#add_grid-table-ttxx").hide();
		}
		if(Number($("#form-submit [name=lc_yq]").val()) == 0){
			//禁用新增按钮
			$("#add_grid-table-lcxx").hide();
		}
	}
	//初始化tt绑定编辑表认领单号控件
	function initrldh(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title : "认领单选择(预收款)",
				searchCond:[{"name" : "认领单号","value" : "rldh"}],
				colModel:[{name:'id', label:'ID', hidden: true},
				          {name : 'rldh',index:'rldh', label: "认领单号"},
				          {name : 'khbm',index:'khbm', label: "客户编码"}, 
				          {name : 'khmc',index:'khmc', label: "客户名称"}, 
				          {name : 'edbz',index:'edbz', label: "币种"}, 
				          {name : 'je',index:'je', label: "金额",
				        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}},
				          {name : 'edsyed',index:'edsyed', label: "剩余额度",
					          align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}},
				          {name : 'bz',index:'bz', label: "PI币种"}, 
				          {name : 'syed',index:'syed', label: "剩余额度(PI币种)",
				              align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}},
			              {name : 'hl',index:'hl', label: "汇率" ,
					          align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 9} }
						   ],
				url:"<c:url value='/payment/payReceiveClaim/searchDbd'/>?khbm=${pibind.khbm}&bz=${pibind.bz}"
			}, {
				callback : function(rows) {
					if(rows){
						$(elem).val($.trim(rows.rldh));
						$(elem).closest("tr.jqgrow").find("[name='bz']").val(rows.bz);
						$(elem).closest("tr.jqgrow").find("[name='syed']").val(rows.syed);
						if(rows.syed >= $("#form-submit [name=tt_hxbdje]").val()){
							$(elem).closest("tr.jqgrow").find("input[name='je']").val($("#form-submit [name=tt_hxbdje]").val());
						}else{
							$(elem).closest("tr.jqgrow").find("input[name='je']").val(rows.syed);
						}
						$(elem).closest("tr.jqgrow").find("[name='edbz']").val(rows.edbz);
						$(elem).closest("tr.jqgrow").find("[name='edsyed']").val(rows.edsyed);
						$(elem).closest("tr.jqgrow").find("[name='ydEdHl']").val(rows.hl);
					}else{
						$(elem).val($.trim(""));
						$(elem).closest("tr.jqgrow").find("[name='bz']").val("");
						$(elem).closest("tr.jqgrow").find("[name='syed']").val("");
						$(elem).closest("tr.jqgrow").find("[name='je']").val("");
						$(elem).closest("tr.jqgrow").find("[name='edbz']").val("");
						$(elem).closest("tr.jqgrow").find("[name='edsyed']").val("");
						$(elem).closest("tr.jqgrow").find("[name='ydEdHl']").val("");
					}
				}
			});
		});
	}

	//初始化lc绑定编辑表lc编号控件
	function initlcdh(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title : "LC选择",
				searchCond:[{"name" : "LC编号","value" : "lcbh"}, 
				            {"name" : "开证行代码","value" : "kzhdm"} ],
				colModel:[{name:'id', label:'ID', hidden: true},
				          {name : 'lcbh',index:'lcbh', label: "LC编号"},
				          {name : 'khbm',index:'khbm', label: "客户编码"},
				          {name : 'khmc',index:'khmc', label: "客户名称"},
				          {name : 'kzh',index:'kzh', label: "LC开证行"},
				          {name : 'kzhdm',index:'kzhdm', label: "LC开证行代码",hidden:true},
				          {name : 'edbz',index:'edbz', label: "LC币种"}, 
				          {name : 'je',index:'je', label: "LC总金额",
				        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}},
				          {name : 'edye',index:'edye', label: "LC余额",
				        	  align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}},
				          {name : 'bz',index:'bz', label: "PI币种"},
				          {name : 'ye',index:'ye', label: "LC余额（PI币种）",
					          align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}},
				          {name : 'hl',index:'hl', label: "汇率",
					          align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ',',decimalPlaces: 9}}],
				url:"<c:url value='/payment/lcReg/searchDbd'/>?khbm=${pibind.khbm}&bz=${pibind.bz}"
			}, {
				callback : function(rows) {
					if(rows){
						$(elem).val($.trim(rows.lcbh));
						$(elem).closest("tr.jqgrow").find("[name='syed']").val(rows.ye);
						$(elem).closest("tr.jqgrow").find("[name='kzh']").val(rows.kzh);
						$(elem).closest("tr.jqgrow").find("[name='kzhdm']").val(rows.kzhdm);
						$(elem).closest("tr.jqgrow").find("[name='bz']").val(rows.bz);
	 					if(rows.ye >= $("#form-submit [name=lc_yq]").val()){
							$(elem).closest("tr.jqgrow").find("input[name='je']").val($("#form-submit [name=lc_yq]").val());
						}else{
							$(elem).closest("tr.jqgrow").find("input[name='je']").val(rows.ye);
						}
	 					$(elem).closest("tr.jqgrow").find("[name='edbz']").val(rows.edbz);
	 					$(elem).closest("tr.jqgrow").find("[name='edye']").val(rows.edye);
	 					$(elem).closest("tr.jqgrow").find("[name='ydEdHl']").val(rows.hl);
					}else{
						$(elem).val("");
						$(elem).closest("tr.jqgrow").find("[name='syed']").val("");
						$(elem).closest("tr.jqgrow").find("[name='kzh']").val("");
						$(elem).closest("tr.jqgrow").find("[name='kzhdm']").val("");
						$(elem).closest("tr.jqgrow").find("[name='bz']").val("");
						$(elem).closest("tr.jqgrow").find("[name='je']").val("");
	 					$(elem).closest("tr.jqgrow").find("[name='edbz']").val("");
	 					$(elem).closest("tr.jqgrow").find("[name='edye']").val("");
	 					$(elem).closest("tr.jqgrow").find("[name='ydEdHl']").val("");
					}
				}
			});
		});
	}

	//提交
	function submit() {
		if (!$('#form-submit').valid()) {
			return false;
		}
		var result = false;
		var param = $("#form-submit").getFormData();
		// TT信息
		var lastEdit = $(grid_selector_ttxx).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_ttxx).saveRow(lastEdit, false, 'clientArray');
			if(!result){
				return;
			}
		}
		// LC信息
		lastEdit = $(grid_selector_lcxx).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_lcxx).saveRow(lastEdit, false, 'clientArray');
			if(!result){
				return;
			}
		}
		// 取数据
		var tt_data = $(grid_selector_ttxx).getRowData();
		var lc_data = $(grid_selector_lcxx).getRowData();
		var listData = [];
		var tt_bcsyed = 0;
        $.each(tt_data, function(i,v){
        	tt_bcsyed += Number(v.je);
        	v.bdlx = "TT";
        	listData.push(v);
        });
        var tt_xdyqje = Number($("#form-submit [name=tt_xdyq]").val());
        var tt_ckyqje = Number($("#form-submit [name=tt_ckyq]").val());
        var tt_yqje = tt_xdyqje + tt_ckyqje;
        if( Number(tt_bcsyed.toFixed(6)) > tt_yqje.toFixed(6)){
			swal("", "T/T使用额度不能超过PI要求金额!", "warning");
			return;
		}
        var lc_syed = 0;
        $.each(lc_data, function(i,v){  
        	lc_syed += Number(v.je);
        	v.bdlx = "LC";
        	listData.push(v);
        });
	 	if(lc_syed > 0 && Number($("#form-submit [name=lc_yq]").val()) < lc_syed){
			swal("", "L/C本次使用额度超出PI要求L/C金额!", "warning");
			return;
		} 
		// 合并数据
		param.bdList = JSON.stringify(listData);
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payPiBind/submit'/>",
					data : param,
					action : "save"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	
	function bindData(list_data){
		if (list_data.tt_xxlist) {
			$(grid_selector_ttxx).jqGrid("addRowData", null, list_data.tt_xxlist, "last");
		}
 		//加载lc
		if (list_data.lc_xxlist) {
			$(grid_selector_lcxx).jqGrid("addRowData", null, list_data.lc_xxlist, "last");
		}
	}
	// 百分数处理
	function toolsNumber(data) {
		if (isNaN(data) || typeof (data) == "undefined" || data == "") {
			return "";
		} else {
			return Number(data * 100);
		}
	}
</script>
</html>