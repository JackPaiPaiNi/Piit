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
			<a href="<c:url value='/' />">首页</a>
		</li>
		<li class="active">模块</li>
	</ul>
</div>

<div class="page-content">
    <div class="page-header">
        <h1>
            DEMO
            <small>
                <i class="icon-double-angle-right"></i>
                EDIT
            </small>
        </h1>
    </div>
    <!-- /.page-header -->
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			
			<form id="form-submit">
				<h4 class="header blue">模块信息</h4>
				<div class="row">
					<!-- <div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">申请人名称&nbsp;&nbsp;</label>
							<input type="text" name="applyName" class="form-control" readonly=""/>
						</div>
					</div> -->
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">模块&nbsp;&nbsp;</label>
							<input type="text" name="module" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">状态&nbsp;&nbsp;</label>
							<select name="status" class="form-control">
								<option value="">&nbsp;</option>
								<option value="1">启用</option>
								<option value="0">禁用</option>
							</select>
						</div>
					</div>
					<!-- <div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">描述&nbsp;&nbsp;</label>
							<input type="text" name="applyEmail" class="form-control"/>
						</div>
					</div> -->
					<!-- <div class="col-xs-6 col-sm-3">
						<label>
							<input name="isPublicCompany5" class="ace ace-switch ace-switch-5" type="checkbox" />
							<span class="lbl">&nbsp;&nbsp;是否上市公司</span>
						</label>
					</div> -->
				</div>
				<div class="space-4"></div>
				<div class="row">
					<div class="col-sm-6">
						<div class="input-group">
							<label class="input-group-btn">描述&nbsp;&nbsp;</label>
							<!-- 限制输入量<textarea name="description" class="form-control limited" maxlength="50"></textarea> -->
							<textarea name="description" class="autosize-transition form-control"></textarea>
						</div>
					</div>
				</div>
				
				<div class="clearfix form-actions">
					<div class="center">
						<button id="save" class="btn btn-info" type="button">
							<i class="icon-ok bigger-110"></i>
							新增
						</button>

						&nbsp; &nbsp; &nbsp;
						<button id="undo" class="btn" type="button">
							<i class="icon-undo bigger-110"></i>
							取消
						</button>
					</div>
				</div>
			</form>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->

<script type="text/javascript">
jQuery(function($) {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	
	/* jQuery(grid_selector).bindTable({
		url: "<c:url value='/base/demo/search'/>",
		pager: pager_selector,
		editurl: "<c:url value='/base/demo/edit'/>",
		gridParent:"#tabs-1",
		colModel: [
			{name:'id',index:'id',label:'ID',  width:60, editable:false, sorttype:"int"},
			{name:'name',index:'name',label:'姓名', width:150, editoptions:{size:"20",maxlength:"30"}},
			{name:'sdate',index:'sdate',label:'生日',width:90, sorttype:"date"},
			{name:'status',index:'status',label:'是否启用', width:70, edittype:"select",formatter: "select",editoptions: {value:"Y:是;N:否"}},
			{name:'sex',index:'sex',label:'性别', width:90, edittype:"select",formatter: "select",editoptions:{value:"m:男;f:女"}},
			{name:'description',index:'description',label:'描述', width:150, sortable:false,edittype:"textarea", editoptions:{rows:"2",cols:"10"}} 
		]
	}); */
	
	$('textarea[class*=autosize]').autosize({append: "\n"});//描述表框输入
	/* $('textarea.limited').inputlimiter({//输入描述限制
		remText: '%n character%s remaining...',
		limitText: 'max allowed : %n.'
	}); */
	
	//新增保存
	$("#save").click(function(){
		save();
    });
	
	//取消
	$("#undo").click(function(){
		window.history.go(-1);
    });
});

function save(){
	var param = $("#form-submit").serializeObject();
	$.ajax({
		type : "post",
		dataType : "json",
		url : "<c:url value='/base/system/module/edit'/>",
		data : param,
		success : function(data) {
			window.history.go(-1);
		}
	});
}
</script>