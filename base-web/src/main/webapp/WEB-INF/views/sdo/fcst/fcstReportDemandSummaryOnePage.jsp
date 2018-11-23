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
						<button id="export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right bigger-110"></i>
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
										<label class="input-group-addon">评审周&nbsp;&nbsp;</label> 
										<input type="text" name="zc" value="${zc}" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">年月&nbsp;&nbsp;</label>
										<input type="text" name="ny"  value="${yyyymm}" class="form-control  date-picker"/>
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
	var form_search = "#form-search";
	$(function($) {
		$(".date-picker").bindYearMonth();
		bindWeekselect();
		$(grid_selector).bindTable({
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 100,
			colModel: [{name:'zhfsmc', index:'zhfsmc', label:'出货方式', width:80},
			           {name:'xszzmc', index:'xszzmc', label:'业务团队/月份/周次', width:180},
			           {name:'tsfcst', index:'tsfcst', label:'特殊录入FCST', width:120},
			           {name:'ddhj', index:'ddhj', label:'合计', width:80} 
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
		
		//查询
		$("#btn-search").click(function(){
			var ny = $("#form-search [name = ny]").val();
			$.bindAjax({
				url:"<c:url value='/fcst/fcstReport/searchDemandSummaryTitles'/>",
				data:{ny:ny},
				action:"search"
			},function(response){
				$(grid_selector).setCustomGroupHeaders({
					useColSpanStyle: true,
					groupHeaders:[
					      	      {startColumnName:'dds01', numberOfColumns:'2', titleText: response.titles[0].month},
					      	      {startColumnName:'dds02', numberOfColumns:'2', titleText: response.titles[1].month},
					      	      {startColumnName:'dds03', numberOfColumns:'2', titleText: response.titles[2].month}
					] 
				 }).setCustomGroupHeaders({
						useColSpanStyle: true,
						groupHeaders:[
						      	      {startColumnName:'dds01', numberOfColumns:'2', titleText: response.titles[0].week},
						      	      {startColumnName:'dds02', numberOfColumns:'2', titleText: response.titles[1].week},
						      	      {startColumnName:'dds03', numberOfColumns:'2', titleText: response.titles[2].week}
						] 
				 }).setCustomGroupHeaders({
						useColSpanStyle: true,
						groupHeaders:[
						      	      {startColumnName:'dds01', numberOfColumns:'2', titleText: response.titles[0].day},
						      	      {startColumnName:'dds02', numberOfColumns:'2', titleText: response.titles[1].day},
						      	      {startColumnName:'dds03', numberOfColumns:'2', titleText: response.titles[2].day}
						] 
					 });
			}); 
			
			$(grid_selector).GridUnload(); 
			$(grid_selector).bindTable({
				url: "<c:url value='/fcst/fcstReport/searchDemandSummaryOne'/>",
				pager: pager_selector,
				gridParent: "#grid-parent",
				formSearch: "#form-search",
				shrinkToFit: false,
				autoScroll: false,
				autoheight:true,
				extraheight:$('#search-box').height()+75,
				rowNum : 20,
				colModel: [{name:'zhfsmc', index:'zhfsmc', label:'出货方式', width:80},
				           {name:'xszzmc', index:'xszzmc', label:'业务团队/月份/周次', width:180},
				           {name:'dds01', index:'dds01', label:'已接单', width:100, align:"right"},
				           {name:'fcst01', index:'fcst01', label:'FCST', width:100, align:"right"},
				           {name:'dds02', index:'dds02', label:'已接单', width:100, align:"right"},
				           {name:'fcst02', index:'fcst02', label:'FCST', width:100, align:"right"},
				           {name:'dds03', index:'dds03', label:'已接单', width:100, align:"right"},
				           {name:'fcst03', index:'fcst03', label:'FCST', width:100, align:"right"},
				           {name:'tsfcst', index:'tsfcst', label:'特殊录入FCST', width:120, align:"right"},
				           {name:'ddhj', index:'ddhj', label:'合计', width:122, align:"right"} ]
			},{
				add:false,
				edit:false,
				del:false,
				view:false
			});
	    });
		//导出
		$("#export").click(function(){
			var ny = $("#form-search [name = ny]").val();
			if(ny ==null || ny.length ==0){
				swal("", "请选择年月", "warning");
				return;
			}
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstReport/exportDemandSummaryOne'/>"});
	    			}
	    		});
	        }
		});
		//取周次
		function bindWeekselect(){
			$.post("<c:url value='/pub/select2/selectFcstWeek'/>",{},
				function(result){
					var data = $.map(result, function (obj) {
						obj.id = obj.zc;
				        obj.text = obj.rq ||obj.rq;    
				        return obj;
					});
						$("#form-search [name=zc]").addClass("skyselect").select2({data:data});
					}, "json");
		}
	});
</script>
</html>