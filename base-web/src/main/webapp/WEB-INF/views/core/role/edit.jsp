<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %> 
<%
	String id = request.getParameter("id");
%>
</head>
<body>

<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12 col-sm-6">
			<!-- PAGE CONTENT BEGINS -->
			<h5 class="header blue" style="margin-top:4px;">角色基本信息</h5>
			<form id="form-submit">
				<div class="row" style="margin: 0px 8px;">
					<input type="hidden" name="id"/><!-- 角色id -->
					<input type="hidden" name="oper"/>
					<div class="col-xs-12 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">角色编码&nbsp;&nbsp;</label>
							<input type="text" name="code" class="form-control" placeholder="请输入角色编码"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">角色名称&nbsp;&nbsp;</label>
							<input type="text" name="name" class="form-control" placeholder="请输入角色名称"/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">角色类型&nbsp;&nbsp;</label>
							<select name="type" class="form-control">
								<option value="">--请选择--</option>
								<option value="01">菜单角色</option>
								<option value="02">流程角色</option>
								<option value="03">预警角色</option>
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">状态&nbsp;&nbsp;</label>
							<select name="status" class="form-control">
								<option value="">--请选择--</option>
								<option value="1">启用</option>
								<option value="0">禁用</option>
							</select>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述&nbsp;&nbsp;</label>
							<textarea name="description" class="autosize-transition form-control"></textarea>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<h5 class="header blue">组织权限列表</h5>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-12" id="orgDiv">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="center">
						<button id="save" class="btn btn-info btn-sm" type="button">
							<i class="icon-ok bigger-110"></i>
							提交
						</button>
						&nbsp; &nbsp; &nbsp;
						<button id="undo" class="btn btn-sm" type="button">
							<i class="icon-undo bigger-110"></i>
							返回
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="col-xs-12 col-sm-6">
			<h5 class="header blue" style="margin-top:4px;">资源管理</h5>
			<div class="row" style="margin: 0px 8px;">
				<div class="col-sm-12">
					<div id="tree" class="ztree" style="height: 500px; overflow: scroll;"></div>
				</div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
</span>
</body>

<script type="text/javascript">
var id = "<%=id%>";
var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";
var isEdit = false;
<shiro:hasPermission name="role:edit">isEdit=true;</shiro:hasPermission>
var orgsOperArray = new Array();
function treeHeight(){
	$("#tree").height($(window).height()-100);
}
jQuery(function($) {
	treeHeight();
	$(window).resize(treeHeight());
	if(id != "null"){//view or edit
		$("#form-submit [name=id]").val(id);
		$.loading();
		$.bindAjax({
			url : "<c:url value='/core/role/find'/>",
			data : "id="+$("#form-submit [name=id]").val(),
			action:"search"
		},function(response){
			var values = $("#form-submit").serializeArray();
			for (var index = 0; index < values.length; index++) {
				var name = values[index].name;
				var value = response[name];
				if(value != null){
					$("#form-submit [name="+name+"]").val(value);
				} else {
					$("#form-submit [name="+name+"]").val("");
				}
		    }
			var orgShow = response["orgShow"];
			withOrgs(orgShow);
			(!isEdit) ? disableForm():"";//只有查看权限
			$("#form-submit [name=oper]").val("edit");
			$.hideLoad();
		});
	}else{//add
		$("#form-submit [name=id]").val("");
		$("#form-submit [name=oper]").val("add");
		withOrgs([]);
	}
	
	$("input[name='fieldradio']").change(function(){
		//var radioFlag = $("input[name='fieldradio']:checked").attr("alt");
		/* var zTree = $.fn.zTree.getZTreeObj("tree"),
		nodes = zTree.getSelectedNodes();alert(nodes.length);
		if (nodes.length == 0) {
			alert("请至少选择一个节点");
			return;
		}
		zTree.hideNodes(nodes); */
		//if(radioFlag == "1"){
			
		//}else if(radioFlag = "2"){
			var treeObj=$.fn.zTree.getZTreeObj("tree"),
            nodes=treeObj.getCheckedNodes(true);
            v="";
            treeObj.hideNodes(nodes);
            for(var i=0;i<nodes.length;i++){
            	treeObj.hideNode(nodes[i]);
            v+=nodes[i].name + ",";
            alert(nodes[i].id); //获取选中节点的值
            } 
           /*  var treeObj = $.fn.zTree.getZTreeObj("tree");
            var nodes = treeObj.getSelectedNodes();
            treeObj.hideNodes(nodes); */
		//}else{
			
		//}
	});
	
	$("#save").click(function(){
		var resourceOperArray = new Array();
		var treeObj = $.fn.zTree.getZTreeObj("tree");
		var nodes = treeObj.getChangeCheckedNodes();
		for(var i =0;i<nodes.length;i++){
			var node = nodes[i];
			var resObj = new Object();
			resObj.id = node.id;
			node.checked ? resObj.oper = "add":resObj.oper = "del";
			resourceOperArray.push(resObj);
		}
		
		var lastSel = $(grid_selector).getGridParam('selrow');
		$(grid_selector).saveRow(lastSel, false, 'clientArray');
		var param = $("#form-submit").serializeObject();
		param.resources =JSON.stringify(resourceOperArray);
		param.orgs = JSON.stringify(orgsOperArray);
		$("#save").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/core/role/edit'/>",
					data:param,
					text:"提示：配置信息更改成功，请在线用户重新登录系统！",
					action:"save"
				},function(response){
					window.history.back(-1);
				});
			}
		});
    });
	
	$("#undo").click(function(){
		window.history.back(-1);
    });
	
	//资源管理树
	$("#tree").bindTree({
		dataUrl: "<c:url value='/core/role/loadResourceTree'/>?id="+$("#form-submit [name=id]").val(),
		hideCheckbox:!isEdit,
		check:{
			enable:true,
			chkboxType: { "Y": "p", "N": "s" }
		}
	});
});

//使页面不可编辑 
function disableForm(){ 
	$("#form-submit").disableForm();
	$("select[name=formCompCode]").removeAttr("disabled");
	$("input[name=inputSearchCond]").removeAttr("disabled");
	$("#save").css("display","none");
	$("#undo").attr("disabled",false);
} 

function withOrgs(orgShow){
	jQuery(grid_selector).bindTable({
		data:orgShow,
		datatype:"local",
		pager: pager_selector,
		caption:"",
		multiselect:true,
		multiboxonly:true,
		rownumbers:false,
		gridParent:"#orgDiv",
		pgbuttons:false,//不显示翻页按钮
		pginput:false, //定义导航栏是否有页码输入框。
		rowList:"",
		recordtext:"共{2}条" ,
		loadonce:true,
		editTable:true,
		colModel: [
			{name:'id',label:'ID', hidden: true, width:60, editable:false, sorttype:"int",hideCol:false},
			{name:'code',index:'code',label:'组织编码', width:100, editable:false},
			{name:'name',index:'name',label:'组织名称', width:150, editable:false},
			{name:'path',index:'path',label:'全路径',hidden: true, width:100},
			{name:'operType',index:'operType',label:'控制类型', width:100, edittype:"select", formatter:"select", editoptions:{value:"0:可查看;1:可编辑",
				dataEvents: [{ type: 'change',
			                       fn: function(e) {
			                    	   var lastSel = $(grid_selector).getGridParam('selrow');
			                    	   var lastRow = $(grid_selector).getRowData(lastSel)
			                    	   var obj = new Object();
				                   		obj.orgId = lastRow.code;
				                   		obj.oper = "edit";
				                   		obj.type = this.value
				                   		orgsOperArray.push(obj);
			                       }
			                   }
			                ]
				}
			}
		]
	},{
		add:isEdit,
		addfunc:addfunc,
		edit:false,
		del:isEdit,
		delfunc:delfunc,
		refresh:false,
		view:false
	});
}

function addfunc(){
	$.treeDialog({
		title:"组织机构",
		url : "<c:url value='/core/organization/loadTree'/>",
		searchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
		autoParam:["id=parentCode"],
		dataParams:{"sys":"base"},
		cacelClearBtn:true
	},{
		callback:function(node){
			node != undefined ? add(node):"";
		}
	});
}

function add(node){
	var id = node.ext;
	var code= node.id;	
	var name = node.name;
	var path = node.path;
	var flag = false;
	$(grid_selector+" tr:gt(0)").each(function(){
		var dataCode = $(this).children("td").eq(2).html();
		var trPath = $.trim($(this).children("td").eq(4).html());
		if(dataCode == code){//说明已经有这个code了
			flag = true;
			return false;
		}
		var tableFindTc = trPath.indexOf(path);
		var tcFindtable = path.indexOf(trPath);
		if(tableFindTc != -1){
			flag = true;
			swal("","下级组织已存在，如需更改请先删除!","warning");
			return false;
		}
		if(tcFindtable != -1){
			flag = true;
			swal("","上级组织已存在，如需更改请先删除!","warning");
			return false;
		}
	});
	if(!flag){//没有添加多的code
		var addobj = new Object();
		addobj.orgId = id;
		addobj.oper = "add";
		addobj.type = "0";
		orgsOperArray.push(addobj);
		var dataRow = {
					id:id,
					code:code,
					name:name,
					path:path,
					operType:'0'
				};
	    $(grid_selector).jqGrid("addRowData", code, dataRow, "first");//将新添加的行插入到第一列
	}
		
}

function delfunc(){
	var selectedRowIds = $(grid_selector).jqGrid("getGridParam","selarrrow");  
	var len = selectedRowIds.length;  
	for(var i = 0;i < len ;i ++) {  
		var id = $("#"+selectedRowIds[0]).children("td").eq(1).html();
		var delObj = new Object();
		delObj.orgId = id;
		delObj.oper = "del";
		orgsOperArray.push(delObj);
		$(grid_selector).jqGrid("delRowData", selectedRowIds[0]);  
	}
}
</script>
</html>