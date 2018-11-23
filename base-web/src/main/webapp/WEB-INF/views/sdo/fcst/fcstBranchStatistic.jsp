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
										<label class="input-group-addon">分公司&nbsp;&nbsp;</label>
										<select role="select" name="fgsdm" class="form-control skyselect">
											${fns:loadDictOption('FGSDM')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">年月&nbsp;&nbsp;</label>
										<input type="text" name="beginNy"  value="${yyyymm}" class="form-control  date-picker"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
										<input type="text" name="endNy"  value="${yyyymm}" class="form-control  date-picker"/>
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
	var isEdit = false;
	<shiro:hasPermission name="fcstBranchData:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$('.skyselect').select2();
		
		$(grid_selector).bindTable({
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [{name:'ny', index:'ny', label:'月度', width:80},
			             {name:'xm', index:'xm', label:'项目', width:80},
			             {name:'jhjcc', index:'jhjcc', label:'合计', width:80}
			]
		},{
			add:false,
			edit:false,
			del:false
		});
		$(".date-picker").bindYearMonth();
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).GridUnload(); 
			var _date = [{name:'ny', index:'ny', label:'月度', width:80},
			             {name:'xm', index:'xm', label:'项目', width:80},
			             {name:'jhjcc', index:'jhjcc', label:'合计', width:80}];
			$.bindAjax({
				url : "<c:url value='/fcst/fcstBranchData/searchStatisticTitle'/>?beginNy="+$("#form-search [name=beginNy]").val()+"&endNy="+$("#form-search [name=endNy]").val()
																				+"&fgsdm="+$("#form-search [name=fgsdm]").val(),
				action : "search"
			}, function(response) {
				if(response.length > 0){
					for (var i=0;i<response.length ;i++){
						var _map ={ width:'80'};
						_map.name="j"+response[i].cc+"cc";
						_map.index="j"+response[i].cc+"cc";
						_map.label=response[i].cc+"寸";
						_map.align= "right",
						_date.push(_map);
					}
					$(grid_selector).bindTable({
						url: "<c:url value='/fcst/fcstBranchData/searchStatistic'/>",
						pager: pager_selector,
						gridParent: "#grid-parent",
						formSearch: "#form-search",
						shrinkToFit: false,
						autoScroll: false,
						autoheight:true,
						extraheight:$('#search-box').height(),
						rowNum : 20,
						colModel: _date
					},{
						add:false,
						edit:false,
						del:false
					});
				}
			});
	    });
		//导出
		$("#export").click(function(){
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstBranchData/exportStatistic'/>?beginNy="+$("#form-submit [name=beginNy]").val("")+"&endNy="+$("#form-submit [name=endNy]").val("")});
	    			}
	    		});
	        }
		});
		
	});
	
	
</script>
</html>