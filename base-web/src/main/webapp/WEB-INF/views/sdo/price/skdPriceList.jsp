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
				
			<div  id="search-box" class="widget-box">
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
						<div class="space-4"></div>
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
	var editurl= "<c:url value='/price/skdPrice/editPage'/>";
	<shiro:hasPermission name="price:skdPrice:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			url: "<c:url value='/price/skdPrice/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:140,  editrules:{edithidden:true}},
				{name:'wlms', index:'khmc', label:'物料描述', width:160,  editrules:{edithidden:true}},
				{name:'dw', index:'dw', label:'单位', width:60,  editrules:{edithidden:true}},
				{name:'bz', index:'bz', label:'币种', width:60,  editrules:{edithidden:true}},
				{name:'dj', index:'dj', label:'单价', width:80,  editrules:{edithidden:true}},
				{name:'flagmc', index:'flagmc', label:'价格来源', width:80,  editrules:{edithidden:true}},
				{name:'yxqks', index:'yxqks', label:'有效期开始', width:100,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'yxqjs', index:'yxqjs', label:'有效期结束', width:100,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zdrid', index:'zdrid', label:'制单人', width:80,  editrules:{edithidden:true}},
				{name:'zdrmc', index:'zdrmc', label:'制单人名称', width:100,  editrules:{edithidden:true}},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:100,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			]
		},{
			add:false,
			edit:isEdit,
			del:false,
			editfunc: editfunc,
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	    
		$('#btn-import').click(function(){
			$.importDialog({
				title:"选择文件",
				//data: $('#form-submit').getFormData(),
				url:"<c:url value='/price/skdPrice/import'/>"
			},{
				callback:function(results){
					/* var rows = eval('(' + results + ')');
					$(grid_selector).setGridParam({data: rows.items}).trigger('reloadGrid'); */
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		// 下载模板
		$("#btn-download").click(function(){
			window.location.href=encodeURI("<c:url value='/template/skdPrice.xlsx'/>");
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/price/skdPrice/export'/>"});
	    			}
	    		});
	        }
		});
		
		//编辑
		function editfunc(){
			var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			location.href = editurl + "?id=" + selr;
		}
	});
</script>
</html>