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
							<shiro:hasPermission name="mdm:employee:plad">
						&nbsp;
						<button id="btn-plsyzh" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-ok icon-on-right"></i>
							批量刷域账号
						</button>
						</shiro:hasPermission>
		
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">工号&nbsp;&nbsp;</label>
										<input type="text" name="empCode" class="form-control"/>
										<input type="hidden" name="sfsap" value="1" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">姓名&nbsp;&nbsp;</label>
										<input type="text" name="name" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">所属组织&nbsp;&nbsp;</label>
										<input type="hidden" name="deptCode" />
										<input type="text" name="deptName" onfocus="this.blur()" class="form-control parent-node"/>
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
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
	var editurl = "<c:url value='/mdm/employee/editPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="mdm:employee:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$("input[name='deptName']").bindTreeDialog({
			title:"所属组织",
			url : "<c:url value='/core/organization/loadTree'/>",
			searchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"}
		},{
			callback:function(node){
				if(node != "" && node != undefined){
					$("input[name='deptCode']").val(node.id);
					$("input[name='deptName']").val(node.name);
				}else if(node == ""){
					$("input[name='deptCode']").val("");
					$("input[name='deptName']").val("");
				}
			}
		});
		
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/mdm/employee/search'/>",
			editurl: "<c:url value='/mdm/employee/edit'/>",
			pager: pager_selector,
			gridParent:"#grid-parent",
			formSearch:"#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, formoptions:{rowpos: 1, colpos: 1}, frozen : true},
				{name:'deptCode', label:'所属组织编码', hidden: true, width:100, formoptions:{rowpos: 1, colpos: 2}, frozen : true},
				{name:'loginAcct', index:'loginAcct', label:'用户账号', width:120, formoptions:{rowpos: 2, colpos: 1}, frozen : true},
				{name:'name', index:'name', label:'姓名', width:120, formoptions:{rowpos: 2, colpos: 2}, frozen : true},
				{name:'status',index:'status',label:'状态',width:40, edittype:"select",formatter: "select",
					editoptions:{value:"1:启用;0:禁用"}, formoptions:{rowpos: 2, colpos: 3}},
				{name:'empCode', index:'empCode', label:'工号', width:70, formoptions:{rowpos: 3, colpos: 1}},
				{name:'sex', index:'sex', label:'性别', width:40, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('XB')}"}, formoptions:{rowpos: 3, colpos: 2}}, 
				{name:'deptName', label:'所属组织', width:180, editoptions:{dataInit: initDept}, formoptions:{rowpos: 3, colpos: 3}},
				{name:'post', index:'post', label:'职位', width:120, formoptions:{rowpos: 4, colpos: 1}},
				{name:'certificateType', index:'certificateType', label:'证件类型', width:70, formoptions:{rowpos: 4, colpos: 2}},
				{name:'certificateNo', index:'certificateNo', label:'证件号', width:120, formoptions:{rowpos: 4, colpos: 3}},
				{name:'phone', index:'phone', label:'电话', width:100, formoptions:{rowpos: 5, colpos: 1}},
				{name:'fax', index:'fax', label:'传真', width:100, formoptions:{rowpos: 5, colpos: 2}},
				{name:'postType', index:'postType', label:'岗位类别', width:70, formoptions:{rowpos: 5, colpos: 3}},
				{name:'mainPost', index:'mainPost', label:'是否主职', width:60, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('SF')}"}, formoptions:{rowpos: 6, colpos: 1}},
					{name:'email', index:'email', label:'邮件地址', width:120, formoptions:{rowpos: 6, colpos: 2}},
				{name:'description', index:'description', label:'描述', width:120, formoptions:{rowpos: 6, colpos: 3}},
				{name:'ywmc', index:'ywmc', label:'英文名称', width:70, formoptions:{rowpos: 7, colpos: 1}},
				{name:'xsy', index:'xsy', label:'SAP销售员代码', width:75, formoptions:{rowpos: 7, colpos: 2}},
				{name:'xsz', index:'xsz', label:'SAP销售组代码', width:75, formoptions:{rowpos: 7, colpos: 3}},
				{name:'xsyZz', index:'xsyZz', label:'销售员(制造SAP)', width:120, formoptions:{rowpos: 8, colpos: 1}},
				{name:'xszZz', index:'xszZz', label:'销售组(制造SAP)', width:120, formoptions:{rowpos: 8, colpos: 2}},
				{name:'ywjc', index:'ywjc', label:'英文简称', width:120, formoptions:{rowpos: 8, colpos: 3}},
				{name:'xszzbm', index:'xszzbm', label:'销售组织编码', width:120, formoptions:{rowpos: 9, colpos: 1}},
				{name:'createTime', index:'createTime', label:'创建时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 9, colpos: 2}, editoptions:{readonly:"true"}}
			],
			sortname: 'loginAcct',
			sortorder: 'asc'
		},{
			add:isEdit,
			edit:isEdit,
			del:false,
			view:isEdit
		}).jqGrid('setFrozenColumns');
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"禁用", 
			buttonicon:"fa-trash-o red", 
			onClickButton: function(){
				operate(0);
			}, position:"last" 
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"启用", 
			buttonicon:"fa-check-square-o green", 
			onClickButton: function(){
				operate(1);
			}, position:"last" 
		});
	
		function operate(status){
			var  title ="确定要启用吗?" ;
			if(status ==0 ){
				title = "确定要禁用吗?"
			}
			var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			if(!selr){
				swal("","请选择一行数据","warning");
				return ;
			}
			var rowData = $(grid_selector).jqGrid('getRowData',selr);
			if(rowData.status == status ){
				swal("","单据已经是您要修改的状态!","warning");
				return ;
			}
			$("#body").bindSweetAlert({
    			title:title,
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$.bindAjax({
    					url:"<c:url value='/mdm/employee/activeOrDisable'/>",
    					data:{id:rowData.id,status:status,loginAcct:rowData.loginAcct},
    					action:"save",
    				},function(response){
    					$(grid_selector).trigger('reloadGrid');
    				}); 
    			}
    		});
		};
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		$("#btn-plsyzh").click(function(){
			batchRefreshAd();
	    });
		
		
		
		//新增
		function addfunc(){
			location.href = editurl;
		}
		
		//编辑
		function editfunc(){
			var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			location.href = editurl + "?id=" + selr;
		}
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/employee/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	
	function batchRefreshAd(){
		$("#body").bindSweetAlert({
			title:"确定要将员工账号全刷进AD域吗?",
			closeOnConfirm: true
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/mdm/employee/batchRefreshAd'/>",
					data:{},
					action:"save",
				},function(response){
				}); 
			}
		});
		
	}
	
	function initDept(elem){
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').bindTreeDialog({
			title:"所属组织",
			url : "<c:url value='/core/organization/loadTree'/>",
			searchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"}
		},{
			callback:function(node){
				if(node){
					$(elem).val($.trim(node.name));
					$(elem).closest("form").find("input[name='deptCode']").val(node.id);
				}else{
					$(elem).val("");
					$(elem).closest("form").find("input[name='deptCode']").val("");
				}
			}
		});
	}
</script>
</html>