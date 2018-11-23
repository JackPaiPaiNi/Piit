<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="breadcrumbs" id="breadcrumbs">
	<ul class="breadcrumb">
		<li>
			<i class="icon-home home-icon"></i>
			<a href="<c:url value='/' />">首页（<s:message code="module" />）</a>
		</li>
		<li class="active">流程资源管理</li>
	</ul>
</div>

<div class="page-content">
    <div class="page-header">
        <h1>
            流程资源管理
            <small>
                <i class="icon-double-angle-right"></i>
                表单元素管理
            </small>
        </h1>
    </div>
    <!-- /.page-header -->
	
	<div class="row">
		<div id="grid-parent" class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
				
			<div class="widget-box">
				<div class="widget-header header-color-blue2">
					<h5>查询条件</h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form class="form-search">
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">模块标识&nbsp;&nbsp;</label>
											<input type="text" name="module" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">资源编号&nbsp;&nbsp;</label>
											<input type="text" name="resId" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">资源名称&nbsp;&nbsp;</label>
											<input type="text" name="resName" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">资源类型&nbsp;&nbsp;</label>
											<select role="select" id="resType" name="resType" size="1" class="form-control">
												<option role="option" value=""></option>
												<option role="option" value="Div">Div</option>
												<option role="option" value="Checkbox">Checkbox</option>
												<option role="option" value="Tab">Tab</option>
												<option role="option" value="Radio">Radio</option>
											</select>
										</div>
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">状态&nbsp;&nbsp;</label>
											<select role="select" id="status" name="status" size="1" class="form-control">
												<option role="option" value=""></option>
												<option role="option" value="1">启用</option>
												<option role="option" value="0">禁用</option>
											</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-2 col-md-offset-8">
										<button id="btn-search" type="button" class="btn btn-info btn-sm">
											<i class="icon-search icon-on-right bigger-110"></i>
											查询
										</button>
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

<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var isEdit = false;
	<shiro:hasPermission name="resModule:edit">isEdit=true;</shiro:hasPermission>
	
	jQuery(function($) {
		jQuery(grid_selector).bindTable({
			url: "<c:url value='/base/resInfo/search'/>",
			editurl: "<c:url value='/base/resInfo/edit'/>",
			pager: pager_selector,
			gridParent:"#grid-parent",
			colModel: [
				{name:'id',index:'id',label:'ID',width:60, editable:false, sorttype:"int",hideCol:false},
				{name:'module',index:'module',label:'模块标识', width:100, editoptions:{size:"20",maxlength:"30"}},
				{name:'resId',index:'resId',label:'资源编号', width:100, editoptions:{size:"20",maxlength:"30"}},
				{name:'resName',index:'resName',label:'资源名称', width:100, editoptions:{size:"20",maxlength:"30"}},
				{name:'resType',index:'resType',label:'资源类型', width:70, edittype:"select",formatter: "select",editoptions: {value:"Div:Div;Checkbox:Checkbox;Tab:tab;Radio;Radio"}},
				{name:'status',index:'status',label:'状态', width:70, edittype:"select",formatter: "select",editoptions: {value:"1:启用;0:禁用"}},
				{name:'description',index:'description',label:'描述', width:150, sortable:false,edittype:"textarea", editoptions:{rows:"2",cols:"20"}} 
			]
		},{
			add:isEdit,
			del:isEdit,
			edit:isEdit,
			view:isEdit
		});
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
	});
</script>