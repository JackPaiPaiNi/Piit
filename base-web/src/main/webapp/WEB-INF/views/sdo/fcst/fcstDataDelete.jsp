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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">录入方式&nbsp;&nbsp;</label>
										<select role="select" name="lrfs" size="1" class="form-control skyselect">
											${fns:loadDictOption('LRFS')}
										</select>
									</div>
								</div>	
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务部&nbsp;&nbsp;</label>
										<input type="hidden" name="xszz" value="${xszz}"/>
										<input type="text" id="xszzmc" name="xszzmc" value="${xszzmc}" onfocus="this.blur()" class="form-control  parent-node"/>
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
										<input type="hidden" name="ywz"/>		
										<input type="text" id="ywzmc" name="ywzmc" onfocus="this.blur()" class="form-control  parent-node"/>
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务员&nbsp;&nbsp;</label>
										<input type="hidden" name="xsyid" class="form-control"/>
										<input type="text" name="xsymc" onfocus="this.blur()"
											class="form-control parent-node" style="cursor: pointer!important;" />
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PID&nbsp;&nbsp;</label>
										<input type="text" id="pid" name="pid" onfocus="this.blur()" class="form-control  parent-node"/>
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="hidden" name="khbm" />
										<input type="text" id="khmc" name="khmc" onfocus="this.blur()" class="form-control  parent-node"/>
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>	
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">删除状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('SFYC')}
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
	<shiro:hasPermission name="fcst:fcstData:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		// 销售组织选择框
		$("#xszzmc").parent().click(function(){
			bindXszz();
		});
		// 业务组选择框
		$("#ywzmc").parent().click(function(){
			bindYwz();
		});
		//销售员选择
		selectXsyInit();
		// 客户选择框
		$("#khmc").parent().click(function(){
			bindKhbm();
		});
		// PID选择
		$("#form-search [name=pid]").click(function(){
			selectPidInit();
		});
		$(".chosen-select").chosen();
		$(".skyselect").select2();
		$(grid_selector).bindTable({	
			url: "<c:url value='/fcst/fcstData/query'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			autoheight:true, 
			multiselect:true,
			editTable:true,
			extraheight:$('#search-box').height(),
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, formoptions:{rowpos: 1, colpos: 1}},
				{name:'pid', index:'pid', label:'PID', width:80, editable:false,formoptions:{rowpos: 1, colpos: 2}},
				{name:'khbm', index:'khbm', label:'客户编码', width:80, editable:false,formoptions:{rowpos: 1, colpos: 3}},
				{name:'khmc', index:'khmc', label:'客户名称', width:80, editable:false,formoptions:{rowpos: 2, colpos: 1}},
				{name:'xsyid', index:'xsyid', label:'销售员', editable:false,width:80, hidden: true, editrules:{edithidden:true}, formoptions:{rowpos: 2, colpos: 2}},
				{name:'xsymc', index:'xsymc', label:'销售员名称', editable:false,width:80, formoptions:{rowpos: 2, colpos: 3}},
				{name:'ywz', index:'ywz', label:'业务组', editable:false, width:80, hidden: true, editrules:{edithidden:true}, formoptions:{rowpos: 3, colpos: 1}},
				{name:'ywzmc', index:'ywzmc', label:'业务组名称', editable:false,width:80, formoptions:{rowpos: 3, colpos: 2}},
				{name:'xszz', index:'xszz', label:'销售组织', editable:false, width:80, hidden: true, editrules:{edithidden:true}, formoptions:{rowpos: 3, colpos: 3}},
				{name:'xszzmc', index:'xszzmc', label:'销售组织名称', editable:false,width:80, formoptions:{rowpos: 4, colpos: 1}},
				{name:'lrfs', index:'lrfs', label:'录入方式', editable:false,width:80, hidden: true, editrules:{edithidden:true}, formoptions:{rowpos: 4, colpos: 2}},
				{name:'lrfsmc', index:'lrfsmc', label:'录入方式名称', editable:false,width:80, formoptions:{rowpos: 4, colpos: 3}},
				{name:'zt', index:'zt', label:'状态', editable:false,width:60,edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SFYC')}"}, formoptions:{rowpos: 5, colpos: 1}}
			]
		},{
			add:false,
			edit:false,
			del:isEdit,
			view:true,
			delfunc:delfunc
		});

		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
	
	});
	
	//删除
	function delfunc(){
	/* 		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			var rowData = jQuery(grid_selector).jqGrid('getRowData',selr); */
		var param = $("#form-search").getFormData();
		var data = [];
		var rowids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
		if(rowids == null || rowids == ""){
			swal("", "请选择需要删除的数据！", "warning");
			return;
		}else{
	    	   $.each(rowids,function(index,value){
			        var rowData = $(grid_selector).jqGrid("getRowData", value);
			        data.push(rowData);
			   });
	    	   param.list = JSON.stringify(data);
				$("body").bindSweetAlert({
					title:"确定要删除吗?"
				},{
					callback:function(){
						$.bindAjax({
							url:"<c:url value='/fcst/fcstData/delete'/>",
							data:param,
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
		}
	}
	//绑定销售组织选择框
	function bindXszz(){
		$.tableDialogPage({
			title:"销售组织选择",
			searchCond:[{"name":"销售组织编码","value":"code"},
			            {"name":"销售组织名称","value":"name"}],
			colModel:[{name:'code', index:'code', label:'销售组织编码', width:80},
					  {name:'name', index:'name', label:'销售组织名称', width:80}],
			url:"<c:url value='/pub/widget/findOrg'/>?type=2"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=xszz]").val(rows.code);
					$("input[name=xszzmc]").val(rows.name);
					$("input[name=ywz]").val("");
					$("input[name=ywzmc]").val("");
					$("input[name=xsyid]").val("");
					$("input[name=xsymc]").val("");
				}else {
					$("input[name=xszz]").val("");
					$("input[name=xszzmc]").val("");
					$("input[name=ywz]").val("");
					$("input[name=ywzmc]").val("");
					$("input[name=xsyid]").val("");
					$("input[name=xsymc]").val("");
				}
			}
		});
	}
	
	//绑定业务组选择框
	function bindYwz(){
		$.tableDialogPage({
			title:"业务组选择",
			searchCond:[{"name":"业务组编码","value":"code"},
			            {"name":"业务组名称","value":"name"}],
			colModel:[{name:'code', index:'code', label:'业务组编码', width:80},
					  {name:'name', index:'name', label:'业务组名称', width:80},
					  {name:'baseParentOrgCode', index:'baseParentOrgCode', label:'销售组织编码', width:80},
					  {name:'parentName', index:'parentName', label:'销售组织名称', width:80}],
			url:"<c:url value='/pub/widget/findOrg'/>?type=4"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=ywz]").val(rows.code);
					$("input[name=ywzmc]").val(rows.name);
					$("input[name=xszz]").val(rows.baseParentOrgCode);
					$("input[name=xszzmc]").val(rows.parentName);
					$("input[name=xsyid]").val("");
					$("input[name=xsymc]").val("");
				}else{
					$("input[name=ywz]").val("");
					$("input[name=ywzmc]").val("");
					$("input[name=xszz]").val("");
					$("input[name=xszzmc]").val("");
					$("input[name=xsyid]").val("");
					$("input[name=xsymc]").val("");
				}
			}
		});
	}
	
	// 销售员选择
	function selectXsyInit(){
		$("#form-search [name=xsymc]").bindTreeTableDialog({
			title:"销售员选择",
			leftUrl : "<c:url value='/core/organization/loadTree'/>",//左侧树查询的url
			rightUrl : "<c:url value='/mdm/employee/search'/>",//右侧列表查询的url
			leftSearchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			rightSearchParams:[{"name":"员工号","value":"empCode"},{"name":"员工名","value":"name"}],
			rightColModel:[{"colName":"empCode","colTitle":"员工号","width":"40%"},
				           {"colName":"name","colTitle":"员工名","width":"40%"},
				           {"colName":"xszz","colTitle":"销售组织",hidden:true},
				           {"colName":"xszzmc","colTitle":"销售组织名称",hidden:true},
				           {"colName":"ywz","colTitle":"业务组",hidden:true},
				           {"colName":"ywzmc","colTitle":"业务组名称",hidden:true}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"},//查询基础架构
			nodeParams:[{"nodeField":"id","searchParam":"deptCode"}]//右侧查询时会附带选中的树节点的信息，取节点的id属性值以deptCode这个参数名传到后台
		},{
			callback:function(record){
				if(record){
					$("#form-search [name=xsyid]").val(record.empCode);//参考rightColModel
					$("#form-search [name=xsymc]").val(record.name);
					$("#form-search [name=xszz]").val(record.xszz);
					$("#form-search [name=xszzmc]").val(record.xszzmc);
					$("#form-search [name=ywz]").val(record.ywz);
					$("#form-search [name=ywzmc]").val(record.ywzmc);
				}else{
					$("#form-search [name=xsyid]").val("");
					$("#form-search [name=xsymc]").val("");
					$("#form-search [name=xszz]").val("");
					$("#form-search [name=xszzmc]").val("");
					$("#form-search [name=ywz]").val("");
					$("#form-search [name=ywzmc]").val("");
				}
			}
		});
	}
	//绑定客户选择框
	function bindKhbm(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户编码","value":"khbm"},
			            {"name":"客户名称","value":"khmc"}],
			colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:80},
					  {name:'khmc', index:'khmc', label:'客户名称', width:80}],
			url:"<c:url value='/pub/widget/findCust'/>"
		},{
			callback:function(rows){
				if(rows){
					$("input[name=khbm]").val(rows.khbm);
					$("input[name=khmc]").val(rows.khmc);
				}else{
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
				}
			}
		});
	}

	//PID选择
	function selectPidInit(){
		$.tableDialogPage({
			title:"PID选择",
			searchCond:[{"name":"PID","value":"pid"},
			            {"name":"机型","value":"jixing"}],
			colModel:[{name:'pid', index:'pid', label:'PID', width:80},
			          {name:'khmc', index:'khmc', label:'客户名称', width:80},
			          {name:'pp', index:'pp', label:'品牌名称', width:80},
			          {name:'jixing', index:'jixing', label:'型号', width:80},
			          {name:'jixin', index:'jixin', label:'机芯', width:80},
			          {name:'zdrmc', index:'zdrmc', label:'申请人', width:80}
			        ],
			url:"<c:url value='/pub/widget/findPid'/>"
		},{
			callback:function(rows){
				// 根据所选PID赋值相关信息
				if(rows){
					$("input[name=pid]").val(rows.pid);
				}else{
					$("input[name=pid]").val("");
				}
			}
		});
	}
</script>
</html>