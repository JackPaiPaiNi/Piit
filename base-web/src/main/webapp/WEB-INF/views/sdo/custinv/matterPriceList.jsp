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
						&nbsp;
						<button id="btn-import" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload-alt icon-on-right"></i>
							导入
						</button>
						&nbsp;
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出
						</button>
						&nbsp;	
						<button id="btn-download" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							下载模板
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control smaller"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">物料编号&nbsp;&nbsp;</label>
										<input type="text" name="wlbh" class="form-control"/>
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
	var searchurl= "<c:url value='/custinv/matterPrice/search'/>";
	
	$(function($) {
		$(grid_selector).bindTable({
			caption: "",
			url: searchurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'khbm', index:'khbm', label:'客户编码', width:120},	
				{name:'wlbh', index:'wlbh', label:'物料编号', width:180},
				{name:'bz', index:'bz', label:'币种', width:60},
			    {name:'dj', index:'dj', label:'单价', width:100, align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:6}},
				{name:'dw', index:'dw', label:'单位', width:80},
				{name:'wlms', index:'wlms', label:'货描', width:200},
				{name:'zdsj', index:'zdsj', label:'维护时间', width:90, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		$("body").keypress(function (e) {
			var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if (keyCode == 13){
				$(grid_selector).trigger("reloadGrid");
			}
		});
		// 导入
		$("#btn-import").click(function(){
			$.importDialog({
				title:"选择文件",
				url:"<c:url value='/custinv/matterPrice/Import'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger('reloadGrid');
				}
			});
	    });
		// 导出
		$("#btn-export").click(function(){
			var curNum = $(grid_selector).getGridParam("records");
		    if(curNum == 0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/custinv/matterPrice/Export'/>"});
	    			}
	    		});
	        }
	    });
		// 模板下载
		$("#btn-download").click(function(){
			window.location.href = encodeURI("<c:url value='/template/matterPrice.xlsx'/>");
		});
	});
</script>
</html>