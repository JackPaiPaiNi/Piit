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
							<i class="icon-search icon-on-right"></i>
							查询
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
										<input type="hidden" name="cxlx" value="2"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货类型&nbsp;&nbsp;</label>
										<select role="select" name="yzhlx" size="1" class="form-control skyselect">
											
								           	${fns:loadDictOption('YZHLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船务专员&nbsp;&nbsp;</label>
										<input type="text" name="cwzyid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								   <div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
											<select role="select" name="scjd" size="1" class="form-control skyselect">
												${fns:loadDictOption('SCJD')}
											</select>
										</div>
								  </div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜时间&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<input type="hidden" id="beginZgsj" name="beginZgsj"/>
										<input type="hidden" id="endZgsj" name="endZgsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
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
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZgsj"),endElement:$("#endZgsj")});
 		$(grid_selector).bindTable({
			url: "<c:url value='/pso/tvPso/searchCwfp'/>",
			editurl: "<c:url value='/pso/tvPso/editCwfp'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'sjc', label:'sjc', hidden: true, width:60},
 				{name:'yzhlx', index:'yzhlx',hidden: true, label:'预走货类型', width:60,editable:false},
				{name:'yzhlxmc', index:'yzhlxmc', label:'预走货类型', width:60 ,editable:false},
				{name:'scjdmc', index:'scjdmc', label:'生产基地', width:60,formoptions:{rowpos: 2, colpos: 1},editoptions:{readonly:true}}, 
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:80, formoptions:{rowpos: 2, colpos: 2},editoptions:{readonly:true}},
				{name:'khbm', index:'khbm', label:'客户编码', width:80, formoptions:{rowpos: 2, colpos: 3},editoptions:{readonly:true}},
				{name:'khmc', index:'khmc', label:'客户名称', width:80, formoptions:{rowpos: 3, colpos: 1},editoptions:{readonly:true}},
				{name:'zgsj', index:'zgsj', label:'装柜时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'},editable:false},
				{name:'xszzmc', index:'xszzmc', label:'业务部门', width:80, formoptions:{rowpos: 3, colpos: 2},editoptions:{readonly:true}},
  				{name:'xwgjmc', index:'xwgjmc', label:'目的国家', width:60,editable:false},
				{name:'qygmc', index:'qygmc', label:'起运港', width:60,editable:false},
				{name:'mdg', index:'mdg', label:'目的港口', width:60,editable:false},
				{name:'cwzyid', index:'cwzyid', label:'调整后船务专员', width:70, editoptions:{dataInit:bindCwzy}, formoptions:{rowpos: 3, colpos: 3}},
				{name:'cwzymc', index:'cwzymc', label:'船务专员名称', width:60, formoptions:{rowpos: 4, colpos: 1},editoptions:{readonly:true}}
			]
		},{
			add:false,
			edit:true,
			del:false,
			view:false,
		}); 
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
	});
	
	function bindCwzy(elem){
		$.post("<c:url value='/pub/select2/selectUserByRole'/>",{roleCode:"1-yx-cwzy"},
				function(result){
					var data = $.map(result, function (obj) {
				       obj.id = obj.empCode;
				       obj.text = obj.text || obj.userName;	
				       return obj;
				     });
					$(elem).addClass("skyselect").select2({data:data, width:140}).on("change",function(e){ 
						if(e.added){
							$(elem).closest("form").find("input[name='cwzymc']").val(e.added.userName);
						}
					});
			}, "json");
	}
</script>
</html>