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
				
			<form id="form-submit" enctype="multipart/form-data">
				
				<input type="hidden" name="id" value="${userDemo.id}"/>
				<input id="oper" type="hidden" name="oper"/>
				<input type="hidden" name="token" value="${token}" />
				
				<h4 class="header blue" style="margin-top:4px;">用户基本信息</h4>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-btn">用户账号&nbsp;&nbsp;</label>
							<input type="text" name="loginAcct" value="${userDemo.loginAcct}" class="form-control"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-btn">用户名&nbsp;&nbsp;</label>
							<input type="hidden" name="empCode" class="form-control"/>
							<input type="text" name="userName" value="${userDemo.userName}" onfocus="this.blur()" class="form-control parent-node" style="cursor: pointer!important;" />
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-btn">测试长度&nbsp;&nbsp;</label>
							<input type="text" name="testLength" value="大于5报错" class="form-control"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-btn">日期&nbsp;&nbsp;</label>
							<input type="text" name="rq" class="form-control date-picker"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-btn">日期时间&nbsp;&nbsp;</label>
							<input type="text" class="form-control date-time-picker"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6">
						<div class="input-group input-group-sm">
							<label class="input-group-btn">多选下拉框&nbsp;&nbsp;</label>
							<select multiple="" class="width-80 chosen-select" data-placeholder="请选择...">
								<option value="">&nbsp;</option>
								<option value="cn">中国</option>
								<option value="us">美国</option>
								<option value="jp">日本</option>
							</select>
						</div>
					</div>
				</div>
				
				<h4 class="header blue">附件</h4>
				<div class="row" id="attachment" style="margin: 0px 8px;">
					<input type="hidden" name="fileOper"/>
					<div class="col-xs-12">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" style="margin-bottom:0px;">
								<thead><tr>
									<th class="center fileoper" width="4%">
										<label><input id="checkfile" type="checkbox" class="ace fileHead" /><span class="lbl"></span></label>
									</th>
									<th class="hidden-480 center" width="85%">附件名称</th>
									<th class="hidden-480 center filedown" width="11%">操作</th>
								</tr></thead>
								<tbody id="fileUpload">
								<c:forEach  var="file" items="${userDemo.fileList}">
									<tr id="${file.id}"><td class="center fileoper"><label><input type="checkbox" class="ace" /><span class="lbl"></span></label></td>
										<td><div class="center">${file.name}</div></td>
										<td class="center filedown">
											<button class="btn btn-xs btn-success downloadBtn" type="button" style="border-radius:10px;">
												<i class="icon-cloud-download bigger-120"></i>下载
										    </button></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<div class="row fileoper" style="border-top: 1px solid #DDD;padding: 8px 0;margin: 0;background-color: #eff3f8;border-bottom: 1px solid #DDD;">
								<div class="col-sm-6">
									<div class="dataTables_info" id="sample-table-2_info">
										<button class="btn btn-xs btn-success" type="button" style="border-radius:4px;" id="fileAdd"><i class="icon-plus bigger-120"></i>添加</button>&nbsp;&nbsp;
										<button class="btn btn-xs btn-danger" type="button" style="border-radius:4px;" id="fileDel"><i class="icon-trash bigger-120"></i>刪除</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<h4 class="header blue">导入</h4>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<button id="import" class="btn btn-info" type="button">导入</button>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div id="local-grid-import" class="row" style="margin: 0px 8px;">
					<table id="grid-table-import"></table>
					<div id="grid-pager-import"></div>
				</div>
				
				<h4 class="header blue">一次性加载</h4>
				<div id="local-grid" class="row" style="margin: 0px 8px;">
					<table id="grid-table"></table>
					<div id="grid-pager"></div>
				</div>
				
				<h4 class="header blue">报表</h4>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<a href="<c:url value='/user/userDemo/report'/>" class="btn btn-info" target="_blank">预览</a>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<a href="<c:url value='/user/userDemo/reportDown'/>" class="btn btn-info" target="_blank">下载</a>
						</div>
					</div>
				</div>
				
				<h4 class="header blue">Excel合并单元格导出</h4>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<button id="merge-export" class="btn btn-info" type="button">导出</button>
						</div>
					</div>
				</div>
				
				<h4 class="header blue">合并表头、汇总页脚、切换视图</h4>
				<div id="local-grid-title" class="row" style="margin: 0px 8px;">
					<table id="grid-table-title"></table>
					<div id="grid-pager-title"></div>
				</div>
				
				<h4 class="header blue">Tab页</h4>
				<div class="row" style="margin: 0px 8px;">
					<div id="tabs">
						<ul>
							<li>
								<a href="#tabs-1">Tab-1</a>
							</li>
							<li>
								<a href="#tabs-2">Tab-2</a>
							</li>
						</ul>

						<div id="tabs-1">
							<table id="grid-table-1"></table>
							<div id="grid-pager-1"></div>
						</div>

						<div id="tabs-2">
							<table id="grid-table-2"></table>
							<div id="grid-pager-2"></div>
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
							返回
						</button>
					</div>
				</div>
				
			</form>

			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var filesTemp = [];
	
	$(function($) {
		
		$("#tabs").tabs();
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
		$('.date-time-picker').bindDateTime();
		$(".chosen-select").chosen();
		
		$("#save").click(function(){
			$("#save").bindSweetAlert({
				title:"确定要保存吗?",
			},{
				callback:function(){
					var id = $("#id").val();
					if (id != "null" && id != ""){
						$("#oper").val("edit");
					} else {
						$("#oper").val("add");
					}
					
					$.bindAjax({
						cache: false,
						url:"<c:url value='/user/userDemo/edit'/>",
						data:new FormData($('#form-submit')[0]),//param,
						processData: false,
						contentType: false,
						action:"save"
					},function(response){
						var data = eval('('+response+')');
						$("input[name=token]").val(data.token);
						//location.href = "<c:url value='/user/userDemo'/>";
					});
					
					//vo中直接注入list对象
					/* var param = $("#form-submit").serializeObject();
					var data = $("#grid-table").jqGrid("getRowData");
					param.userList = data;
					$.bindAjax({
						url:"<c:url value='/user/userDemo/edit'/>",
						data:JSON.stringify(param),//param,
		                contentType: "application/json",
						action:"save"
					},function(response){
						//location.href = "<c:url value='/user/userDemo'/>";
					}); */
				}
			});
		});
		
		//“附件”添加
		var attachname = "id-input-file-";
	    var ii=1;
		$("#fileAdd").click(function(){
			 if(ii>0){
	             var attach = attachname + ii ;
	             if(createInput(attach))
	                 ii=ii+1;
	         }
		});
		//“附件”删除
		$("#fileDel").click(function(){
			$("#fileUpload tr").each(function(){
				var $tr = $(this).children("td").eq(0).find("input").prop("checked");
				if($tr){
					var fileid = $(this).attr("id");
					if(fileid != undefined){
						var delobj = new Object();
						delobj.id = fileid;
						delobj.oper = "del";
						operFileArray.push(delobj);
						$("input[name=fileOper]").val(JSON.stringify(operFileArray));
					}
					$(this).remove();
				}
			});
		});
		//"附件" 复选框
		$(".fileHead").click(function(){
			if($(this).prop("checked")){
				$("input",$(this).parents("table")).prop("checked",this.checked);
			}else{
				$("input",$(this).parents("table")).attr("checked",this.checked);
			}
		});
		//"附件"下载
		$(document).on("click", ".downloadBtn", function(){
			var data = {id:$(this).parents("tr").attr("id")};
			fileDownload("<c:url value='/user/userDemo/download'/>",data,"post");
		});
		
		$("#undo").click(function(){
			location.href = "<c:url value='/user/userDemo'/>";
	    });
		
		$("input[name=userName]").bindTreeTableDialog({
			title:"员工选择",
			leftUrl : "<c:url value='/core/organization/loadTree'/>",//左侧树查询的url
			rightUrl : "<c:url value='/mdm/employee/search'/>",//右侧列表查询的url
			leftSearchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			rightSearchParams:[{"name":"员工号","value":"empCode"},{"name":"员工名","value":"name"}],
			rightColModel:[{"colName":"empCode","colTitle":"员工号","width":"40%"},
			          {"colName":"name","colTitle":"员工名","width":"40%"},
			          {"colName":"dept","hidden":true}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"},//查询基础架构
			nodeParams:[{"nodeField":"id","searchParam":"deptCode"}]//右侧查询时会附带选中的树节点的信息，取节点的id属性值以deptCode这个参数名传到后台
		},{
			callback:function(record){
				if(record != "" && record != null){
					$("input[name=empCode]").val(record.empCode);//参考rightColModel
					$("input[name=userName]").val(record.name);
				}else if(record == ""){
					$("input[name=empCode]").val("");
					$("input[name=userName]").val("");
				}
			}
		});
		
		$("#grid-table-1").bindTable({
			url: "<c:url value='/user/userDemo/search'/>",
			pager: "#grid-pager-1",
			gridParent: "#tabs-1",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'operation', label:'操作',align:'center', width:30,search:false,sortable:false,editable:false},
				{name:'loginAcct', index:'loginAcct', label:'用户账号', width:80},
				{name:'userName', index:'userName', label:'用户名', width:80},
				{name:'password', index:'password', label:'密码', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'empCode', index:'empCode', label:'工号', width:80},
				{name:'compCode', index:'compCode', label:'所属公司', width:80},
				{name:'email', index:'email', label:'邮件地址', width:80},
				{name:'status', index:'status', label:'状态', width:80, edittype:"select", formatter:"select", editoptions:{value:"0:禁用;1:启用"}},
				{name:'type', index:'type', label:'类型', width:80},
				{name:'description', index:'description', label:'描述', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'lastUpdater.id', index:'lastUpdater.id', label:'最后修改人', width:80, editoptions:{readonly:"true"}},
				{name:'lastUpdateTime', index:'lastUpdateTime', label:'最后修改时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions:{readonly:"true"}},
				{name:'defautRole', index:'defautRole', label:'默认角色', width:80, hidden: true, editrules:{edithidden:true}}
			],
			editTable:true,
		   	gridComplete: function(){
				var ids = $("#grid-table-1").getDataIDs();
	            for(var i=0;i < ids.length;i++) {
	                var all = "<a target='' onclick='doSelect(\""+ids[i]+"\")'>选择</a>";
	                $("#grid-table-1").setRowData(ids[i],{operation:all});
	            }
		   	}
		});
		
		$("#grid-table-2").bindTable({
			url: "<c:url value='/user/userDemo/search'/>",
			pager: "#grid-pager-2",
			gridParent: "#tabs-2",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'loginAcct', index:'loginAcct', label:'用户账号', width:80},
				{name:'userName', index:'userName', label:'用户名', width:80},
				{name:'password', index:'password', label:'密码', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'empCode', index:'empCode', label:'工号', width:80},
				{name:'compCode', index:'compCode', label:'所属公司', width:80},
				{name:'email', index:'email', label:'邮件地址', width:80},
				{name:'status', index:'status', label:'状态', width:80, edittype:"select", formatter:"select", editoptions:{value:"0:禁用;1:启用"}},
				{name:'type', index:'type', label:'类型', width:80},
				{name:'description', index:'description', label:'描述', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'lastUpdater.id', index:'lastUpdater.id', label:'最后修改人', width:80, editoptions:{readonly:"true"}},
				{name:'lastUpdateTime', index:'lastUpdateTime', label:'最后修改时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions:{readonly:"true"}},
				{name:'defautRole', index:'defautRole', label:'默认角色', width:80, hidden: true, editrules:{edithidden:true}}
			],
			editTable:true
		});
		
		var grid_import = $("#grid-table-import").bindTable({
			datatype: "local",
			pager: "#grid-pager-import",
			gridParent: "#local-grid-import",
			height:311,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'loginAcct', index:'loginAcct', label:'用户账号', width:80},
				{name:'userName', index:'userName', label:'用户名', width:80},
				{name:'password', index:'password', label:'密码', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'empCode', index:'empCode', label:'工号', width:80},
				{name:'compCode', index:'compCode', label:'所属公司', width:80},
				{name:'email', index:'email', label:'邮件地址', width:80},
				{name:'status', index:'status', label:'状态', width:80, edittype:"select", formatter:"select", editoptions:{value:"0:禁用;1:启用"}},
				{name:'type', index:'type', label:'类型', width:80},
				{name:'description', index:'description', label:'描述', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'lastUpdater.userName', index:'lastUpdater.userName', label:'最后修改人', width:80, editoptions:{readonly:"true"}},
				{name:'lastUpdateTime', index:'lastUpdateTime', label:'最后修改时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions:{readonly:"true"}},
				{name:'defautRole', index:'defautRole', label:'默认角色', width:80, hidden: true, editrules:{edithidden:true}}
			],
			editTable:true
		});
		
		$('#import').click(function(){
			$.importDialog({
				title:"选择文件",
				//data: $('#form-submit').getFormData(),
				url:"<c:url value='/user/userDemo/import'/>"
			},{
				callback:function(results){
					var rows = eval('(' + results + ')');
					grid_import.setGridParam({data: rows.items}).trigger('reloadGrid');
				}
			});
		});
		
		$("#grid-table").bindTable({
			caption:"",
			url: "<c:url value='/user/userDemo/searchAll'/>",
			pager: "#grid-pager",
			gridParent: "#local-grid",
			loadonce:true,
			height:311,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'loginAcct', index:'loginAcct', label:'用户账号', width:80},
				{name:'userName', index:'userName', label:'用户名', width:80},
				{name:'password', index:'password', label:'密码', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'empCode', index:'empCode', label:'工号', width:80},
				{name:'compCode', index:'compCode', label:'所属公司', width:80},
				{name:'email', index:'email', label:'邮件地址', width:80},
				{name:'status', index:'status', label:'状态', width:80, edittype:"select", formatter:"select", editoptions:{value:"0:禁用;1:启用"}},
				{name:'type', index:'type', label:'类型', width:80},
				{name:'description', index:'description', label:'描述', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'lastUpdateTime', index:'lastUpdateTime', label:'最后修改时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, editoptions:{readonly:"true"}},
				{name:'defautRole', index:'defautRole', label:'默认角色', width:80, hidden: true, editrules:{edithidden:true}}
			],
			editTable:true
		});
		
		var isHide = true;
		
		var grid_title = $("#grid-table-title").bindTable({
			datatype: "local",
			pager: "#grid-pager-title",
			gridParent: "#local-grid-title",
			shrinkToFit: false,
			height:311,
			footerrow: true,
			//altclass:"test",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen:true},
				{name:'ddlx', index:'ddlx', label:'订单类型', width:80, frozen:true, edittype:"select", formatter:"select", editoptions:{value:"0:新订单;1:翻单;2:纯翻单"}},
				{name:'khbm', index:'khbm', label:'客户编码', hidden: true, width:80, editable:false},
				{name:'xsyid', index:'xsyid', label:'销售员', hidden: true, width:80},
				{name:'ywzid', index:'ywzid', label:'业务组', hidden: true, width:80},
				{name:'bmid', index:'bmid', label:'部门', hidden: true, width:80},
				{name:'khmc', index:'khmc', label:'客户', width:80, editable:false},
				{name:'xwgj', index:'xwgj', label:'销往国家', width:80},
				{name:'pp', index:'pp', label:'品牌', hidden: true, width:80},
				{name:'pid', index:'pid', label:'PID', width:80, editable:false},
				{name:'cc', index:'cc', label:'尺寸', hidden: true, width:80, editable:false},
				{name:'jixin', index:'jixin', label:'机芯', hidden: true, width:80, editable:false},
				{name:'jx', index:'jx', label:'机型', hidden: true, width:80, editable:false},
				{name:'zhfs', index:'zhfs', label:'走货方式', hidden: true, width:80, editable:false},
				{name:'mcufa', index:'mcufa', label:'MCU方案', hidden: true, width:80},
				{name:'syp', index:'syp', label:'实用屏', hidden: true, width:80},
			<c:forEach items="${titles}" var="t" varStatus="stat">
				{name:'${t.week}ycs', index:'${t.week}ycs', label:'FCST需求', width:85, editrules:{integer:true}<c:if test="${stat.index<7}" >, editable:false</c:if>},
				{name:'${t.week}dds', index:'${t.week}dds', label:'订单数', width:85, editable:false}<c:if test="${!stat.last}" >,</c:if>
			</c:forEach>
			],
			editTable:true,
			editComplete: function(lastEdit, rowData){
				total();
			},
			gridComplete:function(){
				total();
			}
		});
		
		grid_title.navButtonAdd("#grid-pager-title",{
			caption:"视图", 
			buttonicon:"icon-search", 
			onClickButton: function(){
				if(isHide){
					grid_title.showCol("khbm");
					grid_title.showCol("pp");
					grid_title.showCol("cc");
					grid_title.showCol("jixin");
					grid_title.showCol("jx");
					grid_title.showCol("zhfs");
					grid_title.showCol("mcufa");
					grid_title.showCol("syp");
					isHide = false;
				} else {
					grid_title.hideCol("khbm");
					grid_title.hideCol("pp");
					grid_title.hideCol("cc");
					grid_title.hideCol("jixin");
					grid_title.hideCol("jx");
					grid_title.hideCol("zhfs");
					grid_title.hideCol("mcufa");
					grid_title.hideCol("syp");
					isHide = true;
				}
			}, position:"last" 
		});
		
		/* grid_title.setGroupHeaders({
		    useColSpanStyle: true,
		    groupHeaders:[
			<c:forEach items="${titles}" var="t" varStatus="stat">
		        {startColumnName:'${t.week}ycs', numberOfColumns:1, titleText: '${t.month}<br>W${t.week}<br>${t.day}<br>${t.weekNum}'},
		        {startColumnName:'${t.week}dds', numberOfColumns:1, titleText: '${t.month}<br>W${t.week}<br>${t.day}<br>${t.weekNum}'}<c:if test="${!stat.last}" >,</c:if>
		    </c:forEach>
		    ] 
		}); */
		
		grid_title.setCustomGroupHeaders({
		    useColSpanStyle: true,
		    groupHeaders:[
		       // {startColumnName:'khmc', numberOfColumns:2, titleText: 'ww'},
			<c:forEach items="${titles}" var="t" varStatus="stat">
		        {startColumnName:'${t.week}ycs', numberOfColumns:1, titleText: '${t.month}'},
		        {startColumnName:'${t.week}dds', numberOfColumns:1, titleText: '${t.month}'}<c:if test="${!stat.last}" >,</c:if>
		    </c:forEach>
		    ] 
		});
		
		grid_title.setCustomGroupHeaders({
		    useColSpanStyle: true,
		    groupHeaders:[
			<c:forEach items="${titles}" var="t" varStatus="stat">
		        {startColumnName:'${t.week}ycs', numberOfColumns:1, titleText: 'W${t.week}'},
		        {startColumnName:'${t.week}dds', numberOfColumns:1, titleText: 'W${t.week}'}<c:if test="${!stat.last}" >,</c:if>
		    </c:forEach>
		    ] 
		});
		
		grid_title.setCustomGroupHeaders({
		    useColSpanStyle: true,
		    groupHeaders:[
			<c:forEach items="${titles}" var="t" varStatus="stat">
		        {startColumnName:'${t.week}ycs', numberOfColumns:1, titleText: '${t.day}'},
		        {startColumnName:'${t.week}dds', numberOfColumns:1, titleText: '${t.day}'}<c:if test="${!stat.last}" >,</c:if>
		    </c:forEach>
		    ] 
		});
		
		grid_title.setCustomGroupHeaders({
		    useColSpanStyle: true,
		    groupHeaders:[
			<c:forEach items="${titles}" var="t" varStatus="stat">
		        {startColumnName:'${t.week}ycs', numberOfColumns:1, titleText: '${t.weekNum}'},
		        {startColumnName:'${t.week}dds', numberOfColumns:1, titleText: '${t.weekNum}'}<c:if test="${!stat.last}" >,</c:if>
		    </c:forEach>
		    ] 
		});
		
		grid_title.jqGrid("setFrozenColumns");
		
		var rows = ${datas};
		grid_title.setGridParam({data: rows}).trigger('reloadGrid');
		
		$("#merge-export").click(function(){
			$("#merge-export").bindSweetAlert({
				title:"确定要导出吗?",
				closeOnConfirm: true
			},{
				callback:function(){
					grid_title.exportExcel({url: "<c:url value='/user/userDemo/excelMerge'/>",params:{fileName:"李明W1630周FCST填报周"}});
				}
			});
	    });
	});
	
	function createInput(nm){ 
		var htmlfile = '<tr><td class="center fileoper"><label><input type="checkbox" class="ace" /><span class="lbl"></span></label></td>'+
						'<td><div class="center"><input type="file" name="files" id="'+nm+'" size="50" /></div></td>'+
						'<td class="center filedown"></td>'+
					'</tr>';
	   if($("#fileUpload").append(htmlfile) == null ) return false;
	   addFileInput(nm);
	   return true;
	}
	
	function addFileInput(nm){
		$('#'+nm).ace_file_input({
			no_file:'请选择上传文件 ...',
			btn_choose:'选择',
			btn_change:'重选',
			droppable:false,
			onchange:null,
			thumbnail:false, //| true | large
			whitelist:'xls|xlsx|xlsm'
			//blacklist:'xls|xlsx|xlsm'
			//onchange:''
			//
		});
	}
	
	function fileDownload(url, data, method){
		var inputs = "";
		if(url && data){
			
			//split params into form inputs
			$.each(data, function(p, val){
				var value = val;
				if (val != null && typeof(val) == 'string') {
					value = val.replace(/"/g, "&quot;");
				}
				inputs += "<input type='hidden' name='"+ p +"' value=\""+ value +"\" />";
			});
			
			if (typeof method == 'undefined' || method == null)
				method = "POST";
			//create form to send request
			var form = $("<form action='" + url + "' method='" + method + "' target='_blank'>" + inputs + "</form>").appendTo("body");
			
			form.submit();
			form.remove();
		};
	}
	
	function doSelect(id){
		/* $.tableDialog({
			title:"用户查询",
			searchCond:[{"name":"编码","value":"loginAcct"},{"name":"名称","value":"userName"}],
			colModel:[{"title":"编码","colName":"loginAcct"},{"title":"名称","colName":"userName"}],
			url:"<c:url value='/user/userDemo/search'/>"
		},{
			callback:function(rows){
				$(grid_selector).setRowData(id,rows[0]);
				var d = $(grid_selector).getRowData(id);
				console.log(d);
			}
		}); */
	}
	
	function total(){
		var rowNum = $("#grid-table-title").getGridParam('records');
		if(rowNum>0){
			$("#grid-table-title").footerData("set",{"pid":"合计",
		<c:forEach items="${titles}" var="t" varStatus="stat">
			"${t.week}ycs":colSum("${t.week}ycs"),
			"${t.week}dds":colSum("${t.week}dds")<c:if test="${!stat.last}" >,</c:if>
	    </c:forEach>
			});
		}
	}
	
	function colSum(colName){
		var datas = $("#grid-table-title").getGridParam('data');
		var count = 0;
		for(var i = 0;i<datas.length;i++){
			var num = datas[i][colName];
			num = num == null || num == '' ? 0 : num;
			count += parseInt(num);
		}
		return count;
	}
	
</script>
</html>