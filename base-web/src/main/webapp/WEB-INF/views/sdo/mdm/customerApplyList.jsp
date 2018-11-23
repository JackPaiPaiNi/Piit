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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">申请单号&nbsp;&nbsp;</label>
										<input type="text" name="sqdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('DJZT')}
										</select>
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
	var editurl = "<c:url value='/mdm/customerApply/editPage'/>";
	var viewurl = "<c:url value='/mdm/customerApply/viewPage'/>";
	var delurl = "<c:url value='/mdm/customerApply/delete'/>";
	var isEdit = false;
	<shiro:hasPermission name="mdm:customerApply:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/mdm/customerApply/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen : true},
				{name:'processId', label:'processId', hidden: true, width:60, editable:false, frozen : true},
				{name:'taskId', label:'taskId', hidden: true, width:60, editable:false, frozen : true},
				{name:'sjc', label:'sjc', hidden: true, width:60, editable:false, frozen : true},
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen : true},
				{name:'zt',index:'zt',label:'状态',width:100, edittype:"select", formatter:"select", editable:false, frozen : true,
					editoptions:{value:"${fns:loadDictEditOption('DJZT')}"}},
				{name:'sqdh', index:'sqdh', label:'申请单号', width:160, frozen : true},
				{name:'khmc', index:'khmc', label:'客户名称', width:160, frozen : true},
				{name:'khjc', index:'khjc', label:'客户简称', width:120},
				{name:'pp', index:'pp', label:'品牌', width:100},
				{name:'fktj', index:'fktj', label:'付款条件', width:120},
				{name:'xsymc', index:'xsymc', label:'销售员名称', width:120},
				{name:'glkhbm', index:'glkhbm', label:'关联客户编码', width:120},
				{name:'glkhbm', index:'glkhbm', label:'关联客户编码', width:120},
				{name:'zdrmc', index:'zdrmc', label:'创建人名称', width:120},
				{name:'cjsj', index:'cjsj', label:'创建时间', width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			],
			sortname: 'sqdh',
			sortorder: 'desc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
			addfunc:addfunc,
			editfunc:editfunc,
			delfunc: delfunc,
			viewfunc:viewfunc
		}).jqGrid('setFrozenColumns');
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/customerApply/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (zt != 1 && zt != 3) {
				swal("", "只能删除草稿或驳回的单据!", "warning");
				return;
			}else{
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?",
	    			closeOnConfirm: true
	    		},{
		    		callback:function(){
	    				$.bindAjax({
	    					url:"<c:url value='/mdm/customerApply/delete'/>",
	    					data:{id : rowData.id, sjc : rowData.sjc, zt : rowData.zt, processId : rowData.processId},
	    					action:"edit"
	    				},function(response){
	    					$(grid_selector).trigger("reloadGrid");
	    				}); 
	    			}
	    		});
			}
		}
	}
	
	//新增
	function addfunc(){
		location.href = editurl;
	}
	
	//编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if (zt == 2) {
			swal("", "该申请正在审批中,不能修改！", "warning");
			return;
		}else if(zt == 3){
			swal("", "驳回单据请到代办页面进入编辑！", "warning");
			return;
		}else if (zt == 4 || zt == 5) {
			swal("", "该申请已生效,不能修改！", "warning");
			return;
		} else {
			location.href = editurl + "?id=" + selr;
		}
	}
	
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		location.href = viewurl + "?id=" + id + "&processId=" + rowData.processId;
	}
</script>
</html>