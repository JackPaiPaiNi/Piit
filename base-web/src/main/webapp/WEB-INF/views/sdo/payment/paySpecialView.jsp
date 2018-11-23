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
%>
<body>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<h5 class="header blue" style="margin-top: 4px;">特批信息</h5>
					<div class="row">
						<div class="col-xs-6 col-sm-12">
							<button id="btn-back" type="button" class="btn btn-xs">
								<i class="icon-undo icon-on-right"></i> 返回
							</button>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">特批单号&nbsp;&nbsp;</label>
								<input type="text" name="tpdh" class="form-control" readonly="true" />
								<input type="hidden" name="id" />
								<input type="hidden" name="sjc" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">单号&nbsp;&nbsp;</label>
								<input type="text" name="dh" class="form-control" readonly="true" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">单据类型&nbsp;&nbsp;</label>
								<input type="text" name="djlxmc" class="form-control" readonly="true" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
								<input type="text" name="khbm" class="form-control" readonly="true" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
								<input type="text" name="khmc" class="form-control" readonly="true" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">特批类别&nbsp;&nbsp;</label>
								<input type="text" name="tplbmc" value="领导特批" class="form-control" readonly="true" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">特批节点&nbsp;&nbsp;</label>
								<input type="text" name="tpjdmc" class="form-control" readonly="true" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">备注信息&nbsp;&nbsp;</label>
								<input type="text" name="bzxx" class="form-control" readonly="true" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">附件&nbsp;&nbsp;</label>
								<div id="fjxx" class="form-control">
								</div>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<h5 class="header blue" style="margin-top: 4px;">特批使用明细</h5>
					<div class="space-4"></div>
					<div id="grid-parent">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
</body>
<script type="text/javascript">
	var id = "<%=id%>";
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	
	$(function($) {
		//初始化查询grid
		InitGrid();
		//初始化数据
		bindFormData(id);
		//返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
	});
	
	//初始化查询grid
	function InitGrid(){
		$(grid_selector).bindTable({
			caption: "",
			pager: pager_selector,
			gridParent: "#grid-parent",
			colModel: [
				{name:'id', index:'id', label:'ID', hidden:true, width:60},
				{name:'piid', index:'piid', label:'PI号', width:100, editable:false,formatter:pibdxx},
				{name:'ddid', index:'ddid', label:'订单号', width:100, editable:false},
				{name:'tplxmc', index:'tplxmc', label:'特批类型', width:80, editable:false},
				{name:'lcKzh', index:'lcKzh', label:'开证行SwiftCode', width:120, editable:false},
				{name:'bz', index:'bz', label:'币种', width:60, editable:false},
				{name:'tpje', index:'tpje', label:'特批金额', width:80, editable:false, align:'right', 
					formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces: 4}},
				{name:'edbz', index:'edbz', label:'额度币种', width:60, editable:false},
				{name:'edje', index:'edje', label:'额度金额', width:80, editable:false, align:'right', 
					formatter:'number', formatoptions:{thousandsSeparator: ',', decimalPlaces: 4}},
			    {name:'ydEdHl', index:'ydEdHl', label:'额度汇率', width:80, editable:false, align:'right', 
					formatter:'number', formatoptions:{thousandsSeparator: ',', decimalPlaces: 9}},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:150, editable:false}
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
	}
	
	function bindFormData(id){
		if(id != "null"){
			$.loading();
			$.bindAjax({
				url: "<c:url value='/payment/paySpecial/findById'/>",
				data : { id : id },
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				$('#fjxx').html(response.fj);
				//$(grid_selector).jqGrid("addRowData", null, response.itemList, "last");
				$(grid_selector)[0].addJSONData({items:response.itemList});
				$.hideLoad();
			});
		}
	}
	function pibdxx(cellvalue, options, rowData){
	    var href = "<a onclick='javascript:show(\""+rowData.piid+"\""+");'>"+rowData.piid+"</a>";
		return  href ;
	}
	function show(piid){
	    	var url = "<c:url value='/payment/payPiBind/viewPage'/>" + "?piid=" + piid;
			window.open(url); 
	}
	
</script>
</html>