<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<script type="text/javascript">

</script>
<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
	</script>

	<ul class="breadcrumb">
		<li>
			<i class="icon-home home-icon"></i>
			<a href="#">首页</a>
		</li>
		<li class="active">DEMO</li>
	</ul>
</div>

<div class="page-content">
    <div class="page-header">
        <h1>
            DEMO
            <small>
                <i class="icon-double-angle-right"></i>
                LIST
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
						<a href="#" data-action="close">
							<i class="icon-remove"></i>
						</a>
					</span>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form class="form-search">
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">姓名&nbsp;&nbsp;</label>
											<input type="text" name="name" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">生日&nbsp;&nbsp;</label>
											<input type="text" name="sdate" class="form-control"/>
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">测试&nbsp;&nbsp;</label>
											<select name="country" class="form-control"></select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">测试&nbsp;&nbsp;</label>
											<select  name="country2" class="form-control"></select>
										</div>
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">生日&nbsp;&nbsp;</label>
											<input type="text" class="form-control date-picker"/>
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
											<input type="text" class="form-control date-picker"/>
											<span class="input-group-addon">
												<i class="icon-calendar bigger-110"></i>
											</span>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">测试&nbsp;&nbsp;</label>
											<input type="text" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
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
	var editurl = "<c:url value='/base/demo/editPage'/>";
	
	jQuery(function($) {
		jQuery(grid_selector).bindTable({
			url: "<c:url value='/base/demo/search'/>",
			pager: pager_selector,
			gridParent:"#grid-parent",
			colModel: [
				{name:'id',index:'id',label:'ID',  width:60, editable:false, sorttype:"int"},
				{name:'name',index:'name',label:'姓名', width:150, editoptions:{size:"20",maxlength:"30"}},
				{name:'sdate',index:'sdate',label:'生日',width:90, sorttype:"date"},
				{name:'status',index:'status',label:'是否启用', width:70, edittype:"select",formatter: "select",editoptions: {value:"Y:是;N:否"}},
				{name:'sex',index:'sex',label:'性别', width:90, edittype:"select",formatter: "select",editoptions:{value:"m:男;f:女"}},
				{name:'description',index:'description',label:'描述', width:150, sortable:false,edittype:"textarea", editoptions:{rows:"2",cols:"10"}} 
			]
		},{
			del: false,
			addfunc: addfunc,
			editfunc: editfunc
		});
	
		$("input[name=sdate]").bindDateRange();
		
		$(".date-picker").bindDate();
		
		$("select[name=country]").bindSelect({
			url:"<c:url value='/base/common/selectName'/>",
			type:"1",
			code:"2",
			style:true
		});
		
		$("select[name=country2]").bindSelect({
			url:"<c:url value='/base/common/selectName'/>",
			type:"1",
			code:"2"
		});
		
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
	});
	
	function addfunc(){
		location.href = editurl;
	}
	
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		location.href = editurl + "?id=" + selr;
	}
</script>