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
					<span class="widget-toolbar"> <a href="#"
						data-action="collapse"> <i class="icon-chevron-up"></i>
					</a>
					</span>
					<div class="widget-toolbar no-border">
						<button id="btn-search" type="button" class="btn btn-info btn-minier bigger">
							<i class="icon-search icon-on-right"></i> 查询
						</button>
						&nbsp;
						<button id="export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i> 导出
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">特批单号&nbsp;&nbsp;</label>
										<input type="text" name="tpdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">特批节点&nbsp;&nbsp;</label>
											<select role="select" name="tpjd" size="1" class="form-control skyselect">
												${fns:loadDictOption('TPJD')}
											</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">单号&nbsp;&nbsp;</label>
										<input type="text" name="dh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否已消除&nbsp;&nbsp;</label>
										<select role="select" name="sfYxc" size="1" class="form-control skyselect">
											${fns:loadDictOption('SF')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">特批时间&nbsp;&nbsp;</label>
										<input type="text" name="tpsj" id="tpsj" class="form-control"/>
										<input type="hidden" id="stpsj" name="stpsj"/>
										<input type="hidden" id="etpsj" name="etpsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PI号&nbsp;&nbsp;</label>
										<input type="text" name="piid" class="form-control"/>
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
	var editurl = "<c:url value='/payment/paySpecial/editPage'/>";
	var deleteurl = "<c:url value='/payment/paySpecial/delete'/>";
	var viewurl = "<c:url value='/payment/paySpecial/viewPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="payment:paySpecial:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$("#tpsj").bindDateRange({startElement:$("#stpsj"),endElement:$("#etpsj")});
		
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/payment/paySpecial/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: form_search,
			//shrinkToFit: false,
			//autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, frozen : true},
				{name:'sjc', label:'SJC', hidden: true, width:60, frozen : true},
				{name:'tpdh', index:'tpdh', label:'特批单号', width:120, frozen : true},
				{name:'tplbmc', index:'tplbmc', label:'特批类别', width:80, frozen : true},
				{name:'khbm', index:'khbm', label:'客户编码', width:80, frozen : true},
				{name:'khmc', index:'khmc', label:'客户名称', width:180, frozen : true},
				{name:'dh', index:'yzhdh', label:'单号',width:80},
				{name:'tpjdmc', index:'tpjdmc', label:'特批节点', width:80},
				{name:'sfYsy', index:'sfYsy', label:'是否已使用', width:80,edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
				{name:'sfYxc', index:'sfYxc', label:'是否已消除', width:80,edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
				{name:'tpsj', index:'tpsj', label:'特批时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:180}
			]
		},{
			add:isEdit,
			edit:isEdit,
			edittext:"消除",
			del:isEdit,
			view:isEdit,
			addfunc:addfunc,
			editfunc:editfunc,
			delfunc:delfunc,
			viewfunc:viewfunc
		}).jqGrid('setFrozenColumns');
	});
	
	//查询
	$("#btn-search").click(function(){
		$(grid_selector).trigger("reloadGrid");
    });
	
	//新增
	function addfunc(){
		location.href = editurl;
	}
	
	//消除
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		if(selr == null || selr == ""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if(rowData.sfYsy == 0){
				swal("", "未使用的特批不可消除!", "warning");
				return;
			}else{
				$("body").bindSweetAlert({
					title : "确定要消除吗?"
				}, {
					callback : function() {
						$.bindAjax({
							url : "<c:url value='/payment/paySpecial/xc'/>",
							data : {id:selr, sjc:rowData.sjc},
							action : "save"
						}, function(response) {
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
			}
		}
	}
	
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		if(selr == null || selr == ""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (rowData.sfYsy == 1) {
				swal("", "只能删除未使用的特批!", "warning");
				return;
			}else{
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?"
	    		},{
	    			callback:function(){
	    				$.bindAjax({
	    					url:deleteurl,
	    					data:{id:selr, sjc:rowData.sjc},
	    					action:"edit"
	    				},function(response){
	    					$(grid_selector).trigger("reloadGrid");
	    				}); 
	    			}
	    		});
			}
		}
	}
	
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		location.href = viewurl + "?id=" + id;
	}
	
	$("#export").click(function(){
	    var curNum=$(grid_selector).getGridParam("records");
	    if(curNum==0){
            swal("结果集为空不能导出","","warning");
            return false;
        }else{
        	$("body").bindSweetAlert({
    			title:"确定要导出吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$(grid_selector).exportExcel({url: "<c:url value='/payment/paySpecial/export'/>"});
    			}
    		});
        }
	});
	
</script>
</html>