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
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
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
										<label class="input-group-addon">编码&nbsp;&nbsp;</label>
										<input type="text" name="code" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">名称&nbsp;&nbsp;</label>
										<input type="text" name="name" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">类别&nbsp;&nbsp;</label>
										<select role="select" name="type" size="1" class="form-control">
											<option role="option" value="">--请选择--</option>
											<option role="option" value="1">机型</option>
											<option role="option" value="0">机芯</option>
											<option role="option" value="2">产品系列</option>
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="status" size="1" class="form-control">
											<option role="option" value="">--请选择--</option>
											<option role="option" value="1">启用</option>
											<option role="option" value="0">禁用</option>
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
	var isEdit = false;
	<shiro:hasPermission name="mdm:modelInfo:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/mdm/modelInfo/search'/>",
			editurl: "<c:url value='/mdm/modelInfo/edit'/>",
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
				{name:'code', index:'code', label:'编码', width:100, editrules:{edithidden:true}},
				{name:'name', index:'name', label:'名称', width:160},
				{name:'type', index:'type', label:'类别', width:140, edittype:"select",formatter: "select",editoptions:{value:"1:机型;0:机芯;2:产品系列"}},
				{name:'sort', index:'sort', label:'序号', width:80},
				{name:'status',index:'status',label:'状态',width:120, edittype:"select",formatter: "select",editoptions:{value:"1:启用;0:禁用"}},
				{name:'createTime',index:'createTime',label:'创建时间', width:120,formatter:'date',formatoptions:{newformat:'Y-m-d'},editoptions:{size:"20",maxlength:"30",readonly:"true"}},
				{name:'lastUpdateTime',index:'lastUpdateTime',label:'最后修改时间', width:120,formatter:'date',formatoptions:{newformat:'Y-m-d'},editoptions:{size:"20",maxlength:"30",readonly:"true"}},
				{name:'remark',index:'remark',label:'备注', sortable:false,width:240, edittype:"textarea", editoptions:{rows:"2",cols:"20"}}
			],
			sortable:true,
			sortname:"lastUpdateTime",
			sortorder:"desc"
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
		
		$("#btn-export").click(function(){
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/modelInfo/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
</script>
</html>