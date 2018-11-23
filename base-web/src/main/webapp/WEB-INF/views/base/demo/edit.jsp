<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
                EDIT
            </small>
        </h1>
    </div>
    <!-- /.page-header -->
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<s:message code="title" />
			<form id="form-submit">
				<h4 class="header blue">申请人基本信息</h4>
				<div class="row">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">申请人名称&nbsp;&nbsp;</label>
							<input type="text" name="applyName" class="form-control" readonly=""/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">申请人工号&nbsp;&nbsp;</label>
							<input type="text" name="applyNo" class="form-control" disabled=""/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">申请人电话&nbsp;&nbsp;</label>
							<input type="text" name="applyPhone" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">申请人邮箱&nbsp;&nbsp;</label>
							<input type="text" name="applyEmail" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">业务单位&nbsp;&nbsp;</label>
							<input type="text" name="bu" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">所属业务单元&nbsp;&nbsp;</label>
							<input type="text" name="bu" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">所属部门&nbsp;&nbsp;</label>
							<input type="text" name="dept" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">申请日期&nbsp;&nbsp;</label>
							<input type="text" name="applyDate" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row">
					<div class="col-sm-6">
						<div class="input-group">
							<label class="input-group-btn">申请事由&nbsp;&nbsp;</label>
							<textarea name="applyReason" class="autosize-transition form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row">
					<div class="col-sm-6">
						<div class="input-group">
							<label class="input-group-btn">申请事由&nbsp;&nbsp;</label>
							<textarea name="applyReason2" class="form-control limited" maxlength="50"></textarea>
						</div>
					</div>
				</div>
				<h4 class="header blue">公司基本信息</h4>
				<div class="row">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">公司编码&nbsp;&nbsp;</label>
							<input type="text" name="companyCode" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">公司名称&nbsp;&nbsp;</label>
							<input type="text" name="companyName" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">组织类型&nbsp;&nbsp;</label>
							<select name="orgType" class="form-control"></select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<label>
							<input name="isPublicCompany5" class="ace ace-switch ace-switch-5" type="checkbox" />
							<span class="lbl">&nbsp;&nbsp;是否上市公司</span>
						</label>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">是否上市公司&nbsp;&nbsp;</label>
							<select name="isPublicCompany" class="form-control">
								<option value="">&nbsp;</option>
								<option value="Y">是</option>
								<option value="N">否</option>
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="checkbox">
							<label>
								<input name="isPublicCompany2" type="checkbox" class="ace" />
								<span class="lbl">&nbsp;&nbsp;是否上市公司</span>
							</label>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">是否上市公司&nbsp;&nbsp;</label>
							<input name="isPublicCompany3" type="checkbox" class="ace" disabled=""/>
							<span class="lbl"></span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">是否上市公司&nbsp;&nbsp;</label>
							<input name="isPublicCompany4" class="ace ace-switch ace-switch-5" type="checkbox" disabled=""/>
							<span class="lbl"></span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">公司生效日期&nbsp;&nbsp;</label>
							<input name="sdate" type="text" class="form-control date-picker"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">自动完成&nbsp;&nbsp;</label>
							<input name="tags" type="text" class="form-control"/>
						</div>
					</div>
				</div>
				<h4 class="header blue">文件上传</h4>
				<div class="row">
					<div class="col-xs-6 col-sm-3">
						<input type="file" name="file" id="id-input-file-1"/>
					</div>
					<div class="col-xs-6 col-sm-3">
						<input type="file" multiple="" name="file" id="id-input-file-2"/>
					</div>
				</div>
				<h4 class="header blue">公司架构</h4>
				<div class="row">
					<div id="tabs">
						<ul>
							<li>
								<a href="#tabs-1">NC架构</a>
							</li>
							<li>
								<a href="#tabs-2">资金架构</a>
							</li>
							<li>
								<a href="#tabs-3">财务架构</a>
							</li>
						</ul>

						<div id="tabs-1">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group">
										<label class="input-group-btn">上级管理公司编码&nbsp;&nbsp;</label>
										<input type="text" name="superCompanyCode" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group">
										<label class="input-group-btn">上级管理公司名称&nbsp;&nbsp;</label>
										<input type="text" name="superCompanyName" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group">
										<label class="input-group-btn">生效日期&nbsp;&nbsp;</label>
										<input name="onDate" type="text" class="form-control date-picker"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group">
										<label class="input-group-btn">多选实例&nbsp;&nbsp;</label>
										<select name="multiple1" multiple="" class="width-80 chosen-select">
											<option value="">&nbsp;</option>
											<option value="AL">Alabama</option>
											<option value="AK">Alaska</option>
											<option value="AZ">Arizona</option>
											<option value="AR">Arkansas</option>
											<option value="CA">California</option>
											<option value="CO">Colorado</option>
											<option value="CT">Connecticut</option>
											<option value="DE">Delaware</option>
											<option value="FL">Florida</option>
											<option value="GA">Georgia</option>
											<option value="HI">Hawaii</option>
											<option value="ID">Idaho</option>
											<option value="IL">Illinois</option>
											<option value="IN">Indiana</option>
											<option value="IA">Iowa</option>
											<option value="KS">Kansas</option>
											<option value="KY">Kentucky</option>
											<option value="LA">Louisiana</option>
											<option value="ME">Maine</option>
											<option value="MD">Maryland</option>
											<option value="MA">Massachusetts</option>
											<option value="MI">Michigan</option>
											<option value="MN">Minnesota</option>
											<option value="MS">Mississippi</option>
											<option value="MO">Missouri</option>
											<option value="MT">Montana</option>
											<option value="NE">Nebraska</option>
											<option value="NV">Nevada</option>
											<option value="NH">New Hampshire</option>
											<option value="NJ">New Jersey</option>
											<option value="NM">New Mexico</option>
											<option value="NY">New York</option>
											<option value="NC">North Carolina</option>
											<option value="ND">North Dakota</option>
											<option value="OH">Ohio</option>
											<option value="OK">Oklahoma</option>
											<option value="OR">Oregon</option>
											<option value="PA">Pennsylvania</option>
											<option value="RI">Rhode Island</option>
											<option value="SC">South Carolina</option>
											<option value="SD">South Dakota</option>
											<option value="TN">Tennessee</option>
											<option value="TX">Texas</option>
											<option value="UT">Utah</option>
											<option value="VT">Vermont</option>
											<option value="VA">Virginia</option>
											<option value="WA">Washington</option>
											<option value="WV">West Virginia</option>
											<option value="WI">Wisconsin</option>
											<option value="WY">Wyoming</option>
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group">
										<label class="input-group-btn">多选实例&nbsp;&nbsp;</label>
										<select name="multiple2" multiple="" class="width-80 chosen-select">
											<option value="">&nbsp;</option>
											<option value="AL">Alabama</option>
											<option value="AK">Alaska</option>
											<option value="AZ">Arizona</option>
											<option value="AR">Arkansas</option>
											<option value="CA">California</option>
											<option value="CO">Colorado</option>
											<option value="CT">Connecticut</option>
											<option value="DE">Delaware</option>
											<option value="FL">Florida</option>
											<option value="GA">Georgia</option>
											<option value="HI">Hawaii</option>
											<option value="ID">Idaho</option>
											<option value="IL">Illinois</option>
											<option value="IN">Indiana</option>
											<option value="IA">Iowa</option>
											<option value="KS">Kansas</option>
											<option value="KY">Kentucky</option>
											<option value="LA">Louisiana</option>
											<option value="ME">Maine</option>
											<option value="MD">Maryland</option>
											<option value="MA">Massachusetts</option>
											<option value="MI">Michigan</option>
											<option value="MN">Minnesota</option>
											<option value="MS">Mississippi</option>
											<option value="MO">Missouri</option>
											<option value="MT">Montana</option>
											<option value="NE">Nebraska</option>
											<option value="NV">Nevada</option>
											<option value="NH">New Hampshire</option>
											<option value="NJ">New Jersey</option>
											<option value="NM">New Mexico</option>
											<option value="NY">New York</option>
											<option value="NC">North Carolina</option>
											<option value="ND">North Dakota</option>
											<option value="OH">Ohio</option>
											<option value="OK">Oklahoma</option>
											<option value="OR">Oregon</option>
											<option value="PA">Pennsylvania</option>
											<option value="RI">Rhode Island</option>
											<option value="SC">South Carolina</option>
											<option value="SD">South Dakota</option>
											<option value="TN">Tennessee</option>
											<option value="TX">Texas</option>
											<option value="UT">Utah</option>
											<option value="VT">Vermont</option>
											<option value="VA">Virginia</option>
											<option value="WA">Washington</option>
											<option value="WV">West Virginia</option>
											<option value="WI">Wisconsin</option>
											<option value="WY">Wyoming</option>
										</select>
									</div>
								</div>
							</div>
						</div>

						<div id="tabs-2">
							<table id="grid-table"></table>
							<div id="grid-pager"></div>
						</div>

						<div id="tabs-3">
						</div>
					</div>
				</div>
				
				<div class="clearfix form-actions">
					<div class="center">
						<button id="save" class="btn btn-info" type="button">
							<i class="icon-ok bigger-110"></i>
							提交
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
	console.log('<s:message code="title" />');
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	
	$("#tabs").tabs();
	$(".date-picker").bindDate();
	$(".chosen-select").chosen();
	
	jQuery(grid_selector).bindTable({
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
	});
	
	$('textarea[class*=autosize]').autosize({append: "\n"});
	$('textarea.limited').inputlimiter({
		remText: '%n character%s remaining...',
		limitText: 'max allowed : %n.'
	});
	
	$("select[name=multiple1]").chosen();
	
	$("select[name=multiple2]").chosen();
	$("select[name=multiple2]").addClass('tag-input-style');
	
	$("#save").click(function(){
		save();
    });
	
	$("#undo").click(function(){
		window.history.go(-1);
    });
	
	$('#id-input-file-1').ace_file_input({
		no_file:'No File ...',
		btn_choose:'Choose',
		btn_change:'Change',
		droppable:false,
		onchange:null,
		thumbnail:false //| true | large
		//whitelist:'gif|png|jpg|jpeg'
		//blacklist:'exe|php'
		//onchange:''
		//
	});
	
	$('#id-input-file-2').ace_file_input({
		style:'well',
		btn_choose:'Drop files here or click to choose',
		btn_change:null,
		no_icon:'icon-cloud-upload',
		droppable:true,
		thumbnail:'small'//large | fit
		//,icon_remove:null//set null, to hide remove/reset button
		/**,before_change:function(files, dropped) {
			//Check an example below
			//or examples/file-upload.html
			return true;
		}*/
		/**,before_remove : function() {
			return true;
		}*/
		,
		preview_error : function(filename, error_code) {
			//name of the file that failed
			//error_code values
			//1 = 'FILE_LOAD_FAILED',
			//2 = 'IMAGE_LOAD_FAILED',
			//3 = 'THUMBNAIL_FAILED'
			//alert(error_code);
		}

	}).on('change', function(){
		//console.log($(this).data('ace_input_files'));
		//console.log($(this).data('ace_input_method'));
	});
	
	$("input[name=tags]").autocomplete({
		source: "<c:url value='/base/common/autoName'/>"
	});
});

function save(){
	var param = $("#form-submit").serializeObject();
	$.ajax({
		async : true,
		type : "post",
		dataType : "json",
		url : "<c:url value='/base/demo/edit'/>",
		data : param,
		success : function(data) {
			
		}
	});
}
</script>