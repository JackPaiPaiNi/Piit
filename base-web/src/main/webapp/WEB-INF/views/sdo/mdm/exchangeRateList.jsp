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
										<label class="input-group-addon">从币种&nbsp;&nbsp;</label>
										<!-- <input type="text" name="cbz" class="form-control"/> -->
										<select role="select" name="cbz" size="1" class="form-control skyselect">
											${fns:loadDictOption('BZ')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">到币种&nbsp;&nbsp;</label>
										<!-- <input type="text" name="dbz" class="form-control"/> -->
										<select role="select" name="dbz" size="1" class="form-control skyselect">
											${fns:loadDictOption('BZ')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">汇率日期&nbsp;&nbsp;</label>
										<input type="text" name="rq" class="form-control date-picker"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
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
	<shiro:hasPermission name="mdm:exchangeRate:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(grid_selector).bindTable({
			url: "<c:url value='/mdm/exchangeRate/search'/>",
			editurl: "<c:url value='/mdm/exchangeRate/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'cbz', index:'cbz', label:'从币种', width:200, edittype:"select", formatter:"select", 
                	 editoptions:{value:"${fns:loadDictEditOption('BZ')}",dataInit: initSelect2}},
				{name:'dbz', index:'dbz', label:'到币种', width:200, edittype:"select", formatter:"select", 
                	 editoptions:{value:"${fns:loadDictEditOption('BZ')}",dataInit: initSelect2}},
              	{name:'yxqks', index:'yxqks', label:'有效期开始', width:250, formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions: {
                       dataInit: function (element) {
                           $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                       }
                    }},
   				{name:'yxqjs', index:'yxqjs', label:'有效期结束', width:250, formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions: {
                       dataInit: function (element) {
                           $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                       }
                    }},
				{name:'bl', index:'bl', label:'比例', width:105, align:'right'/* ,formatter:'number',editrules:{number:true} */},
				{name:'sjc', index:'sjc', label:'时间戳', hidden: true } 
			],
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/exchangeRate/export'/>"});
	    			}
	    		});
	        }
		});
		//导入
		$('#btn-import').click(function(){
			$.importDialog({
				title:"选择文件",
				//data: $('#form-submit').getFormData(),
				url:"<c:url value='/mdm/exchangeRate/import'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		//模板下载
		$('#btn-download').on('click',function(){
			window.location.href=encodeURI("<c:url value='/template/exchangeRate.xlsx'/>");
		})
	});
	function initSelect2(elem){
		$(elem).width(140).select2();
	} 
</script>
</html>