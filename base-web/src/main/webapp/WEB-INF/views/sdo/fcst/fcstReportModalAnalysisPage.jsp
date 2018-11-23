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
			colModel: [{name:'jixing', index:'jixing', label:'机型', width:80}
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
			if(ny ==null || ny.length ==0){
				swal("", "请选择年月", "warning");
				return;
			}
			var _ny = ny.substring(4,6);
			var _num = ny.substring(4,5);
			if(_num ==0){
				_ny = ny.substring(5,6);
			}
			$(grid_selector).GridUnload(); 
			$(grid_selector).bindTable({
				url: "<c:url value='/fcst/fcstReport/searchModalAnalysis'/>",
				pager: pager_selector,
				gridParent: "#grid-parent",
				formSearch: "#form-search",
				shrinkToFit: false,
				autoScroll: false,
				autoheight:true,
				extraheight:$('#search-box').height()+30,
				rowNum : 20,
				colModel: [{name:'jixing', index:'jixing', label:'机型', width:100},
				           {name:'ycs1Sz', index:'ycs1Sz', label:'上周数量', width:70},
				           {name:'ycs1Bz', index:'ycs1Bz', label:'本周数量', width:70},
				           {name:'ycs1Cy', index:'ycs1Cy', label:'差异', width:70},
				           {name:'ycs2Sz', index:'ycs2Sz', label:'上周数量', width:70},
				           {name:'ycs2Bz', index:'ycs2Bz', label:'本周数量', width:70},
				           {name:'ycs2Cy', index:'ycs2Cy', label:'差异', width:70},
				           {name:'ycs3Sz', index:'ycs3Sz', label:'上周数量', width:70},
				           {name:'ycs3Bz', index:'ycs3Bz', label:'本周数量', width:70},
				           {name:'ycs3Cy', index:'ycs3Cy', label:'差异', width:70},
				           {name:'hjSz', index:'hjSz', label:'上周数量', width:70},
				           {name:'hjBz', index:'hjBz', label:'本周数量', width:70},
				           {name:'hjCy', index:'hjCy', label:'差异', width:70}]
			},{
				add:false,
				edit:false,
				del:false,
				view:false
			});
			$(grid_selector).setCustomGroupHeaders({
				useColSpanStyle: true,
				groupHeaders:[
				      	      {startColumnName:'ycs1Sz', numberOfColumns:'3', titleText: _ny+'月'},
				      	      {startColumnName:'ycs2Sz', numberOfColumns:'3', titleText: get_month(_ny,1)+'月'},
				      	      {startColumnName:'ycs3Sz', numberOfColumns:'3', titleText: get_month(_ny,2)+'月'},
				      	      {startColumnName:'hjSz', numberOfColumns:'3', titleText: _ny+'-'+get_month(_ny,2)+'月'}
				] 
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstReport/exportModalAnalysis'/>"});
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
	// 取月份
	function get_month(ny,num){
		var _date = 0;
		_date = Number(ny) + Number(num);
		if(_date > 12){
			_date = Number(_date) - Number(12);
		}
		return _date;
	}
</script>
</html>