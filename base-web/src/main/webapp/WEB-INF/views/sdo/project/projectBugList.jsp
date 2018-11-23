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
										<label class="input-group-addon">项目阶段&nbsp;&nbsp;</label>
										<select role="select" name="xmjd" size="1" class="form-control skyselect">
											${fns:loadDictOption('PROJECT_XMJD')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('BUG_ZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">处理人 &nbsp;&nbsp;</label> 
									    <input type="text" name="clr" class="form-control" />
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
	var editurl = "<c:url value='/project/projectBug/editPage'/>";
	var viewurl = "<c:url value='/project/projectBug/viewPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="project:projectBug:view">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		 $(".skyselect").select2();
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/project/projectBug/search'/>",
			editurl: "<c:url value='/project/projectBug/edit'/>",
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
					{name:'processId', label:'processId', hidden: true, width:60, frozen:true},
					{name:'taskId', label:'taskId', hidden: true, width:60, frozen:true},
					{name:'wtdh', index:'wtdh', label:'问题单号', width:80,  editrules:{edithidden:true}},
					{name:'xmjd', index:'xmjd', label:'项目阶段', width:80,  editrules:{edithidden:true}, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('PROJECT_XMJD')}"}},
					{name:'cdmc', index:'cdmc', label:'菜单名称', width:80,  editrules:{edithidden:true}},
					{name:'tcbmmc', index:'tcbmmc', label:'提出部门', width:80,  editrules:{edithidden:true}},
					{name:'tcrmc', index:'tcrmc', label:'提出人', width:80,  editrules:{edithidden:true}},
					{name:'tcsj', index:'tcsj', label:'提出时间', width:80, editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				    {name:'yxj', index:'yxj', label:'优先级', width:80, hidden: true, editrules:{edithidden:true}, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('BUG_YXJ')}"}},
				    {name:'wtms', index:'wtms', label:'问题描述', width:80, editrules:{edithidden:true}},
				    {name:'clrmc', index:'clrmc', label:'处理人名称', width:80, editrules:{edithidden:true}},
					{name:'zt', index:'zt', label:'状态', width:80,editrules:{edithidden:true}, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('BUG_ZT')}"}},
					{name:'clsm', index:'clsm', label:'处理说明', width:80, editrules:{edithidden:true}},
					{name:'sjclsj', index:'sjclsj', label:'实际处理时间', width:80, hidden: true, editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'wtfl', index:'wtfl', label:'问题分类', width:80, hidden: true, editrules:{edithidden:true}, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('')}"}},
					{name:'rwfpsj', index:'rwfpsj', label:'任务分派时间', width:80,editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'gbsj', index:'gbsj', label:'关闭时间', width:80, editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'yjclsj', index:'yjclsj', label:'预计处理时间', width:80, editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'yqclsj', index:'yqclsj', label:'要求处理时间', width:80, editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
					{name:'wtdh', index:'wtdh', label:'问题单号', width:80,editrules:{edithidden:true}}
			],
		
			sortorder: 'asc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			addfunc:addfunc,
			editfunc:editfunc,
			viewfunc:viewfunc
			
		}).jqGrid('setFrozenColumns');
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/project/projectBug/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
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
			swal("", "驳回的单据,请在代办页面进入编辑！", "warning");
			return;
		}else if (zt == 7) {
			swal("", "该申请已生效,不能修改！", "warning");
			return;
		} else {
			location.href =editurl + "?id=" + selr;
		}
	}
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		window.open(viewurl + "?id=" + id + "&processId=" + rowData.processId);
	}
</script>
</html>