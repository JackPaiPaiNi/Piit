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
						<button id="export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出
						</button>
						&nbsp;
						<button id="btn-import" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload icon-on-right bigger-110"></i>
							导入
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
	var isEdit = false;
	<shiro:hasPermission name="mdm:materialDescription:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			url: "<c:url value='/mdm/materialDescription/search'/>",
			editurl: "<c:url value='/mdm/materialDescription/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:true},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:300},
				{name:'yy', index:'yy', label:'语言', width:300, edittype:"select", formatter:"select", 
					editoptions:{value:"${fns:loadDictEditOption('XDWLMSYY')}",dataInit: initSelect2}},
				{name:'ms', index:'ms', label:'描述', width:650}
			],
			sortname: 'wlbh',
			sortorder: 'asc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
		
		//导入
		$('#btn-import').click(function(){
			$.importDialog({
				title:"选择文件",
				//data: $('#form-submit').getFormData(),
				url:"<c:url value='/mdm/materialDescription/import'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/materialDescription/export'/>"});
	    			}
	    		});
	        }s
		});
		//模板下载
		$('#btn-download').on('click',function(){
			window.location.href=encodeURI("<c:url value='/template/materalDescription.xlsx'/>");
		})
	});
	
	function initSelect2(elem){
		$(elem).width(140).select2();
	}
</script>
</html>