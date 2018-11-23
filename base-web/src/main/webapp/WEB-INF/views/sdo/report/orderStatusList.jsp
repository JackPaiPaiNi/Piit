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
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
					<div class="widget-toolbar no-border">
						<button id="btn-search" type="button" class="btn btn-info btn-minier bigger">
							<i class="icon-search icon-on-right"></i>
							查询
						</button>
						&nbsp;
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单类型&nbsp;&nbsp;</label>
										<select role="select" name="ddlx" size="1" class="form-control skyselect">
											${fns:loadDictOption('DDLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">当前处理人&nbsp;&nbsp;</label>
										<input type="text" name="czr" class="form-control"/>
									</div>
								</div>
							  </div>
							  <div class="space-4" ></div>
						      <div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<input type="text"   id="zdsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							    <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">交货时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginJhsj" name="beginJhsj"/>
										<input type="hidden" id="endJhsj" name="endJhsj"/>
										<input type="text"   id="jhsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">版本号&nbsp;&nbsp;</label>
										<input type="text" name="bbh" class="form-control"/>
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
	$("#zdsj").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
	$("#jhsj").bindDateRange({startElement:$("#beginJhsj"),endElement:$("#endJhsj")});
	$(grid_selector).bindTable({
		url: "<c:url value='/report/orderStatus/search'/>",
		pager: pager_selector,
		gridParent: "#grid-parent",
		formSearch: "#form-search",
		rowNum:20,
		//shrinkToFit: false,
		//autoScroll: false,
		autoheight:true,
		extraheight:$('#search-box').height(),
		colModel: [
					{name:'zdsj', index:'zdsj', label:'下单日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'ddid', index:'ddid', label:'订单号', width:100},
					{name:'bbh', index:'bbh', label:'版本号', width:100},
					{name:'ddlxmc', index:'ddlxmc', label:'订单类型', width:100},
					{name:'zdrmc', index:'zdrmc', label:'制单人', width:100},
					{name:'jhrq', index:'jhrq', label:'交货日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'sl', index:'sl', label:'数量', width:100},
					{name:'czr', index:'czr', label:'当前审批人账号', width:100},
					{name:'czrmc', index:'czrmc', label:'当前审批人名称', width:100}
		]
	},{
		add:false,
		edit:false,
		del:false
	});
	//敲击回车响应查询
	$("body").keypress(function (e) {
		var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
		if (keyCode == 13){
			$(grid_selector).trigger("reloadGrid");
		}
	}); 
	//查询
	$("#btn-search").click(function(){
		$(grid_selector).trigger("reloadGrid");
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
    				$(grid_selector).exportExcel({url: "<c:url value='/report/orderStatus/export'/>"});
    			}
    		});
        }
	});
});
</script>
</html>