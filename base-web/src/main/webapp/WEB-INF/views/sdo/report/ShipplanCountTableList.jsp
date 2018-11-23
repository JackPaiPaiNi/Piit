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
			<div id="search-box" class="widget-box">
				<div class="widget-header header-color-blue2">
					<h5>查询条件</h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
					<div class="widget-toolbar no-border">
					    <button id="btn-search" type="button" class="btn btn-info btn-minier bigger">
							<i class="icon-search icon-on-right bigger-110"></i>
							查询
						</button>
 						&nbsp;
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							导出
						</button>
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
					<form id="form-search" name="form-search" class="form-search">
                         <div class="row">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">起止日期&nbsp;&nbsp;</label>
									<input type="hidden" id="szgsj" name="szgsj"/>
									<input type="hidden" id="ezgsj" name="ezgsj"/>
									<input type="text"   id="zgsjqj" class="form-control timeInterval"/>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">大区&nbsp;&nbsp;</label>
									<input type="hidden" name="xszz"/>
									<input type="text" id="xszzmc" name="xszzmc" onfocus="this.blur()" class="form-control  parent-node"/>
									<span class="input-group-addon">
										<i class="icon-search bigger-110"></i>
									</span>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">海外供应链&nbsp;&nbsp;</label>
									<select role="select" name="hwgylsl" size="1" class="form-control skyselect">
										${fns:loadDictOption('HWGYL')}
									</select>
								</div>
							</div>
						</div>
						<div class="space-4" ></div>
						<div class="row">
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">HKD到USD汇率&nbsp;&nbsp;</label>
									<input type="text" name="hkdtousd" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">USD到RMB汇率&nbsp;&nbsp;</label>
									<input type="text" name="usdtormb" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">RMB到USD汇率&nbsp;&nbsp;</label>
									<input type="text" name="rmbtousd" class="form-control"/>
								</div>
							</div>
							<div class="col-xs-6 col-sm-3">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">EUR到USD汇率&nbsp;&nbsp;</label>
									<input type="text" name="eurtousd" class="form-control"/>
								</div>
							</div>
						</div>
					</form>
				</div>	
				</div>
			</div>
			
			<table id="grid-table"></table>
			
			<div id="grid-pager"></div>

			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	$(function($) {
		$(".skyselect").select2();
		// 大区选择框
		$("#xszzmc").parent().click(function(){
			bindXszz();
		});
		$("#zgsjqj").bindDateRange({startElement:$("#szgsj"),endElement:$("#ezgsj")});
		$(grid_selector).bindTable({
			url: "<c:url value='/report/ShipplanCountTable/search'/>",
			datatype : "local",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			rowNum:20,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'zgsjqj', index:'zgsjqj', label:'时间', width:150},
				{name:'hwgylmc', index:'hwgylmc', label:'海外供应链', width:90},
				{name:'xszzmc', index:'xszzmc', label:'大区', width:100},
				{name:'ywzmc', index:'ywzmc', label:'业务组', width:90},
				{name:'zchsl', index:'zchsl', label:'总出货数量', width:110, align:'right', formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'dykcsl', index:'dykcsl', label:'当月开船数量', width:110, align:'right', formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'dyjzsl', index:'dyjzsl', label:'当月在途结转下月开船数量', width:190, align:'right', formatter:'integer',formatoptions:{thousandsSeparator: ','}},
				{name:'zchje', index:'zchje', label:'总出货金额 USD', width:120, align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'dykcje', index:'dykcje', label:'当月开船金额 USD', width:120, align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'dyjzje', index:'dyjzje', label:'当月在途结转下月开船金额 USD', width:190, align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
				{name:'zhrmb', index:'zhrmb', label:'转换RMB', width:120, align:'right', formatter:'number',formatoptions:{thousandsSeparator: ','}},
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
		//查询
		$("#btn-search").click(function(){
			var param = $("#form-search").getFormData();
		 	if(param.szgsj == "" || param.ezgsj == ""){
			 	swal("查询条件：起止日期不能为空！","","warning");
	            return false;
		 	}
			/* if(param.szgsj.substring(0,7) != param.ezgsj.substring(0,7)){
				swal("查询条件：只能选择同一个月，不能跨月！","","warning");
	            return false;
			} */
			if(param.hkdtousd == ""){
		 		swal("查询条件：HKD到USD汇率不能为空！","","warning");
	            return false;
		 	}
		 	if(param.usdtormb == ""){
		 		swal("查询条件：USD到RMB汇率不能为空！","","warning");
	            return false;
		 	}
		 	$(grid_selector).setGridParam({datatype: 'json'}).trigger('reloadGrid');
	    });
		
		$("#btn-export").click(function(){
		    var curNum=$(grid_selector).getGridParam("records");
		    if(curNum==0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/report/ShipplanCountTable/export'/>"});
	    			}
	    		});
	        }
		});
	})
	
	//绑定大区选择框
	function bindXszz(){
		$.tableDialogPage({
			title:"销售组织选择",
			searchCond:[{"name":"销售组织编码","value":"code"},
			            {"name":"销售组织名称","value":"name"}],
			colModel:[{name:'code', index:'code', label:'销售组织编码', width:80},
					  {name:'name', index:'name', label:'销售组织名称', width:80}],
			url:"<c:url value='/pub/widget/findOrg'/>?type=2"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=xszz]").val(rows.code);
					$("input[name=xszzmc]").val(rows.name);
				}else {
					$("input[name=xszz]").val("");
					$("input[name=xszzmc]").val("");
				}
			}
		});
	}
</script>
</html>