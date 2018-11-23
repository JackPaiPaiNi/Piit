<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
	<%
		String id = request.getParameter("id");
	%>
</head>

<body>
<div class="zheZhao"></div>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12" id="grid-parent">
			<!-- PAGE CONTENT BEGINS -->
				<form id="form-submit">	
		             <div class="row">
						<!-- c:import的url默认接受父页面的参数，如果需要添加参数用c:param -->
						<c:import url="/payment/lcReg/qryPage" charEncoding="UTF-8">
							<%-- <c:param name="type">LC登记</c:param> --%>
						</c:import>
					</div>
					<h5 class="header blue" style="margin-top:4px;">交单明细维护</h5>
					<!-- <table id="grid-table"></table>	
			        <div id="grid-pager"></div> -->
					<div class="row" style="margin: 0px;" id="grid-parent">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div>
			        <div class="space-4"></div>
			        <div class="row" align="center">
					 <input type="hidden" name="oper"/>
					 <input type="hidden" name="token" value="${token}"/>
						<button id="btn-submit" type="button"
							class="btn btn-danger btn-sm">
							<i class="icon-ok icon-on-right bigger-110"></i> 提交
						</button>
						&nbsp;
						<button id="btn-undo" class="btn btn-sm" type="button">
							<i class="icon-undo icon-on-right bigger-110"></i>
								返回
						</button>
					</div>
				</form>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->

</body>
<script type="text/javascript">
	var id = '<%=id%>';
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var isEdit = false;
	<shiro:hasPermission name="payment:lcReg:edit">isEdit=true;</shiro:hasPermission>
	$(function($) {
		// 页面id赋值
		$("#form-submit [name=id]").val(id);
		//编辑时加载交单明细
    	initPageData(id);
    	// 初始化grid
 		bindGrid();
		//返回
		$("#btn-undo").click(function(){
			location.href = "<c:url value='/payment/lcReg'/>";
	    });
		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
	});
	
	//编辑时加载交单明细
	function initPageData(id){
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/payment/lcReg/findJdmxByLcbh'  />",
				data : "lcbh=" + $("#lcbh").html().trim(),
				action : "search"
			}, function(response) {
				$("#form-submit [name=oper]").val("edit");
				if(response.itemVoList){
					$(grid_selector).jqGrid("addRowData", null, response.itemVoList, "last");
				}
			});
		};
	}
	function bindGrid(){
		//加载table数据
		$(grid_selector).bindTable({
			caption: "",
			pager: pager_selector,
			gridParent: "#grid-parent",
			shrinkToFit: false,
			autoScroll: false,
			datatype: "local",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:100, editable:false},
				{name:'fph', index:'fph', label:'发票号', width:150, editable:true,  editoptions:{dataInit: initFph}},
				{name:'fpje', index:'fpje', label:'发票金额', width:80, editoptions:{disabled:true}},
				{name:'fprq', index:'fprq', label:'发票日期', width:120, editoptions:{disabled:true}},
				{name:'fpbz', index:'fpbz', label:'发票币种', width:80, editoptions:{disabled:true}},
				{name:'chdh', index:'chdh', label:'出货单号',  width:100, editable:true, editoptions:{dataInit: initChdh}},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号',  width:120, editoptions:{disabled:true}},
				{name:'ddid', index:'ddid', label:'订单号',  width:120, editoptions:{disabled:true}},
				{name:'qy', index:'qy', label:'区域', width:80,editable:true, hidden:true },
				{name:'qymc', index:'qymc', label:'区域名称', width:80, editoptions:{disabled:true} },
				{name:'xsyid', index:'xsyid', label:'销售员代码', width:100 ,editable:true, hidden:true},
				{name:'xsymc', index:'xsymc', label:'销售员', width:100 , editoptions:{disabled:true}},
				{name:'cwyid', index:'cwyid', label:'船务员代码', width:100 ,editable:true, hidden:true},
				{name:'cwymc', index:'cwymc', label:'船务专员', width:100 , editoptions:{disabled:true}},
				{name:'wjjryhrq', index:'wjjryhrq', label:'文件寄入银行日期',  width:120, editable: true,formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions: {
                    dataInit: function (element) {
                        $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                    }
                 }},
				{name:'tzhsdwjrq', index:'tzhsdwjrq', label:'通知行收到文件日期', width:120, editable: true,formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions: {
                    dataInit: function (element) {
                        $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                    }
                 }},
				{name:'etdkcrq', index:'etdkcrq', label:'ETD开船日期', width:120, editable: true,formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions: {
                    dataInit: function (element) {
                        $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                    }
                 }},
				{name:'tzhjdrq', index:'tzhjdrq', label:'通知行寄单日期',  width:120, editable: true,formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions: {
                    dataInit: function (element) {
                        $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                    }
                 }},
				{name:'gzhm', index:'gzhm', label:'跟踪号码', width:140},
				{name:'lcbfxx', index:'lcbfxx', label:'L/C不符信息', width:140},
				{name:'bfdfy', index:'bfdfy', label:'不符点费用', width:100},
				{name:'fjBtn', label:'上传', width:40, edittype:"button", 
					 editoptions:{value: "上传", class:"btn btn-success btn-minier",dataInit: initFjBtn}},
				{name:'fj', index:'fj', label:'附件', width:80, editable:false},
				{name:'bfdyy', index:'bfdyy', label:'不符点原因', width:140},
				/* {name:'dqfkr', index:'dqfkr', label:'到期付款日',  width:120, editable: true,formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions: {
                    dataInit: function (element) {
                        $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                    }
                 }}, */
                {name:'dqfkr', index:'dqfkr', label:'到期付款日',  width:120, editoptions:{disabled:true}},
				{name:'sfyhk', index:'sfyhk', label:'是否已回款' ,editable : true,edittype:"select", formatter:"select", 
					 editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
				{name:'hkje', index:'hkje', label:'回款金额', width:140},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:80}
			],
			gridComplete: function(){
	            //sumGrid();
		   	},
			editTable:true,
			editComplete: function(lastEdit, rowData){
				//sumGrid();
			}
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			complete:isEdit
		});
	}
	//初始化上传附件
	function initFjBtn(elem){
		$(elem).click(function(){
			$.uploadDialog({
				auto : true
			},{callback:function(data){
				if(data){
					//给编辑表不可编辑字段赋值
					$(elem).closest("tr.jqgrow").find("td[aria-describedby$='_fj']").html(data.url);
				}
			}
			});
		});
	}
	//提交
	function submit(){
		var param = $("#form-submit").getFormData();
		/* var lastSel = $(grid_selector).getGridParam('selrow');
		$(grid_selector).saveRow(lastSel, false, 'clientArray'); */
		//结束表格编辑
		var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector).saveRow(lastEdit, false, 'clientArray');
			  $(grid_selector).removeData('lastEdit');
			if(!result){
				return ;
			}
		}
		var data = $(grid_selector).getRowData();
		if(data.length==0){
			swal("","交单明细不能为空","warning");
			return;
		}
		var message = "" ;
		$.each(data, function(i, jdmxData){
			if(jdmxData.wjjryhrq.length == 0 || jdmxData.tzhsdwjrq.length == 0 || jdmxData.etdkcrq.length == 0 || 
					jdmxData.tzhjdrq.length == 0){
				message += "第"+(i+1)+"行,日期不能为空！";
			}
			jdmxData.dqfkr = jdmxData.etdkcrq;
		});
		if(message.length > 0){
			swal("", message, "warning");
    		return ;
		}
		param.itemList = JSON.stringify(data);
		param.lcbh = $("#lcbh").html();
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/lcReg/submitJdmx'/>",
					data : param,
					action : ""
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	
	//选择出货单号
	function initChdh(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage(
				{
					title : "出货选择",
					searchCond : [ {"name" : "出货单号","value" : "chdh"},
					               {"name" : "订单号","value" : "ddid"} ],
		            colModel : [{name:'chdh', index:'chdh', label:'出货单号'},
		                        {name:'yzhdh', index:'yzhdh', label:'预走货单号'},
						        {name:'ddid', index:'ddid', label:'订单号'},
						        {name:'xszz', index:'xszz', label:'区域',hidden:true},
						        {name:'xszzmc', index:'xszzmc', label:'区域'},
						        {name:'xsyid', index:'xsyid', label:'销售员ID',hidden:true},
						        {name:'xsymc', index:'xsymc', label:'销售员'},
						        {name:'zdrid', index:'zdrid', label:'船务专员ID',hidden:true},
						        {name:'zdrmc', index:'zdrmc', label:'船务专员名称'}],
					url : "<c:url value='/deliver/deliver/searchChxx'/>"
				}, {
					callback : function(rows) {
						if(rows){
							$(elem).val(rows.chdh);
							$(elem).closest("tr.jqgrow").find("input[name='yzhdh']").val(rows.yzhdh);
							$(elem).closest("tr.jqgrow").find("input[name='ddid']").val(rows.ddid);
							$(elem).closest("tr.jqgrow").find("input[name='qy']").val(rows.xszz);
							$(elem).closest("tr.jqgrow").find("input[name='qymc']").val(rows.xszzmc);
							$(elem).closest("tr.jqgrow").find("input[name='xsyid']").val(rows.xsyid);
							$(elem).closest("tr.jqgrow").find("input[name='xsymc']").val(rows.xsymc);
							$(elem).closest("tr.jqgrow").find("input[name='cwyid']").val(rows.zdrid);
							$(elem).closest("tr.jqgrow").find("input[name='cwymc']").val(rows.zdrmc);
						}else{
							$(elem).val("");
							$(elem).closest("tr.jqgrow").find("input[name='yzhdh']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='ddid']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='qy']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='qymc']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='xsyid']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='xsymc']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='cwyid']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='cwymc']").val("");
						}
						
					}
				});
		});
	}
	
	//选择预走货单号
	function initYzhdh(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage(
				{
					title : "预走货选择",
					searchCond : [ {"name" : "预走货单号","value" : "yzhdh"},
					               {"name" : "订单号","value" : "ddid"} ],
		            colModel : [{name:'yzhdh', index:'yzhdh', label:'预走货单号'},
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
							$(elem).closest("tr.jqgrow").find("input[name='ddid']").val(rows.ddid);
							$(elem).closest("tr.jqgrow").find("input[name='qy']").val(rows.xszz);
							$(elem).closest("tr.jqgrow").find("input[name='qymc']").val(rows.xszzmc);
							$(elem).closest("tr.jqgrow").find("input[name='xsyid']").val(rows.xsyid);
							$(elem).closest("tr.jqgrow").find("input[name='xsymc']").val(rows.xsymc);
							$(elem).closest("tr.jqgrow").find("input[name='cwyid']").val(rows.cwzyid);
							$(elem).closest("tr.jqgrow").find("input[name='cwymc']").val(rows.cwzymc);
						}else{
							$(elem).val("");
							$(elem).closest("tr.jqgrow").find("input[name='ddid']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='qy']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='qymc']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='xsyid']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='xsymc']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='cwyid']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='cwymc']").val("");
						}
						
					}
				});
		});
	}
	
	//选择发票号	
	function initFph(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title : "发票号选择",
				searchCond : [ {"name" : "发票号","value" : "fph"} ],
                colModel : [{name:'fph', index:'fph', label:'发票号'},
					        {name:'fprq', index:'fprq', label:'发票日期'},
					        {name:'zje', index:'zje', label:'发票金额'},
					        {name:'bz', index:'bz', label:'发票币种'}],
				url : "<c:url value='/invoice/invoicenew/search'/>"
				}, {
					callback : function(rows) {
						if(rows){
							$(elem).val(rows.fph);
							$(elem).closest("tr.jqgrow").find("input[name='fprq']").val(rows.fprq);
							$(elem).closest("tr.jqgrow").find("input[name='fpje']").val(rows.zje);
							$(elem).closest("tr.jqgrow").find("input[name='fpbz']").val(rows.bz);
						}else{
							$(elem).val("");
							$(elem).closest("tr.jqgrow").find("input[name='fprq']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='fpje']").val("");
							$(elem).closest("tr.jqgrow").find("input[name='fpbz']").val("");
						}
					}
				});
		});
	}
</script>
</html>