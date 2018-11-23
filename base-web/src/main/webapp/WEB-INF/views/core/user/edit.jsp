<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>    
<style type="text/css">
	.mosnListMian table thead th{
		background:#E4E8E9;
		font-weight:bold;
		text-align:center;
	}
	.mosnListMian table tbody td{
		text-align:center;
	}
</style>
</head>
<%
	String id = request.getParameter("id");
%>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			
			<form id="form-submit">
				<h5 class="header blue" style="margin-top:4px;">用户基本信息</h5>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">用户类型&nbsp;&nbsp;</label>
							<select name="type" class="form-control">
								<option value="01" selected>内部员工</option>
								<option value="02">外部员工</option>
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3" id="employeeId">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">员工选择&nbsp;&nbsp;</label>
							<input type="text" name="employee" onfocus="this.blur()" class="form-control bootbox-dialog" style="cursor: pointer!important;"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<input type="hidden" name="id"/><!-- 用户id -->
					<input type="hidden" name="oper"/>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">用户帐号&nbsp;&nbsp;</label>
							<input type="text" name="loginAcct" class="form-control" placeholder="请选择员工获取..." />
							<span class="input-group-addon simpletooltip" data-simpletooltip="init" title="<span>重要提示：</br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;内部员工请通过“员工选择”获取!</span>">
								<i class="icon-info-sign bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">密码&nbsp;&nbsp;</label>
							<input type="password" name="password" class="form-control" />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">用户名&nbsp;&nbsp;</label>
							<input type="text" name="userName" class="form-control" placeholder="请选择员工获取..." />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">工号&nbsp;&nbsp;</label>
							<input type="text" name="empCode" class="form-control" placeholder="请选择员工获取..." readonly/>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">所属组织&nbsp;&nbsp;</label>
							<!-- <input type="hidden" name="compCode" class="form-control" readonly/>
							<input type="text" name="compName" class="form-control" readonly/> -->
							
							<input type="hidden" name="compCode" class="form-control"/>
							<input type="text" name="compName" onfocus="this.blur()" class="form-control parent-node" style="cursor: pointer!important;" />
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
							
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">邮箱&nbsp;&nbsp;</label>
							<input type="text" name="email" class="form-control" placeholder="请选择员工获取..." />
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">状态&nbsp;&nbsp;</label>
							<select name="status" class="form-control">
								<option value="1" selected>启用</option>
								<option value="0">禁用</option>
							</select>
						</div>
					</div>
					<!-- <div class="col-sm-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-addon">描述&nbsp;&nbsp;</label>
							<textarea name="applyReason" class="autosize-transition form-control"></textarea>
						</div>
					</div> -->
				</div>
				<h5 class="header blue">角色列表</h5>
				
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-12 col-sm-10">
						<select id='pre-selected-options' multiple='multiple'>
						</select>
					</div>
				</div>
				
				<!-- <h5 class="header blue">组织权限列表</h5>
				<div class="row" style="margin: 0px 8px;">
					<div class="col-xs-7 col-sm-7" id="orgDiv">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div>
				</div> -->
				
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
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
</span>
</body>

<script type="text/javascript">
var id = "<%=id%>";
var grid_selector = "#grid-table";
var pager_selector = "#grid-pager";
var isEdit = false;
<shiro:hasPermission name="user:edit">isEdit=true;</shiro:hasPermission>
var roleTypeFilter_all = "";
var roleTypeFilter_user = "";
var roleOperArray = new Array();//操作角色的动作记录
var orgsOperArray = new Array();
var loginacctTemp ="";var empcodeTemp = "";var companycodeTemp = "";var companynameTemp = "";var nameTemp="";var emailTemp="";

jQuery(function($) {
	if(id != "null"){//view or edit
		$("#form-submit [name=id]").val(id);
		$.loading();
		$.bindAjax({
			url : "<c:url value='/core/user/find'/>",
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
			if(response["type"] == "01"){
				$("#employeeId").hide();
				inEmpCtrl();
			}else{
				outEmpCtrl();
			}
			$("select[name=type]").attr("disabled",true);
			$("select[name=type]").parent().append('<input type="hidden" class="hideTemp" name="type" value="'+response["type"]+'"/>');
			
			//var orgShow = response["orgShow"];
			//withOrgs(orgShow);
			$("#form-submit [name=employee]").val(response["userName"]);
			(!isEdit) ? disableForm():"";//只有查看权限
			$("#form-submit [name=oper]").val("edit");
			$.hideLoad();
		});
	}else{//add
		inEmpCtrl();
		//withOrgs([]);
		$("#form-submit [name=id]").val("");
		$("#form-submit [name=oper]").val("add");
	}
	
	$('.simpletooltip').bindToolTip();
	
	$("select[name=type]").change(function(){
		$("input[name=employee]").val("");
		$("input[name=loginAcct]").val("");
		$("input[name=password]").val("");
		$("input[name=userName]").val("");
		$("input[name=empCode]").val("");
		$("input[name=compCode]").val("");
		$("input[name=compName]").val("");
		$("input[name=email]").val("");
		$("select[name=status]").val("1")
		if ($(this).val() == "01"){//内部员工
			$("#employeeId").show(); 
			$("input[name=loginAcct]").attr("placeholder","请选择员工获取...").attr("readonly",true);
			$("input[name=userName]").attr("placeholder","请选择员工获取...").attr("readonly",true);
			$("input[name=empCode]").attr("placeholder","请选择员工获取...");
			$("input[name=compName]").attr("disabled",true);
			$("input[name=email]").attr("placeholder","请选择员工获取...").attr("readonly",true);
		}else{
			$("#employeeId").hide();
			$("input[name=loginAcct]").removeAttr("placeholder").attr("readonly",false);
			$("input[name=userName]").removeAttr("placeholder").attr("readonly",false);
			$("input[name=empCode]").removeAttr("placeholder");
			$("input[name=compName]").attr("disabled",false);
			$("input[name=email]").removeAttr("placeholder").attr("readonly",false);
		}
	});
	
	$("input[name=employee]").click(function(){
		$.tableDialogPage({
			title:"员工选择",
			searchCond:[{"name":"用户名","value":"name"},
			            {"name":"账号","value":"login_acct"}],
			colModel:[{index:"用户名",label:"用户名", name:"name"},
			          {index:"账号",label:"账号", name:"loginAcct"},
			          {index:"所属组织",label:"所属组织", name:"deptCode"},
			          {index:"员工号",label:"员工号", name:"empCode"}],
			url:"<c:url value='/mdm/employee/search'/>?sfsap='1'"
		},{
			callback:function(rows){
				$("input[name=userName]").val(rows.name);
				$("input[name=employee]").val(rows.name);
				$("input[name=loginAcct]").val(rows.loginAcct);
				$("input[name=empCode]").val(rows.empCode);
				$("input[name=compCode]").val(rows.deptCode);
				$("input[name=compName]").val(rows.deptName);
				$("input[name=email]").val(rows.email);
			},
			clear:function(){
				callback("","","","","","");
			}
		}); 			
	});

	$("input[name=compName]").bindTreeDialog({
		title:"所在公司",
		url : "<c:url value='/core/organization/loadTree'/>",
		searchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
		autoParam:["id=parentCode"],
		dataParams:{"sys":"base"}
	},{
		callback:function(node){
			if(node != "" && node != undefined){
				$("input[name=compCode]").val(node.id);
				$("input[name=compName]").val($.trim(node.name));
			}else if(node == ""){
				$("input[name=compCode]").val("");
				$("input[name=compName]").val("");
			}
		}
	});
	
	//角色列表
	var spaceHtml= "<div class='space-4'></div>";
	var allRoleHtml = '<div class="row"><div class="col-xs-10 col-sm-10 col-md-offset-1"><div class="input-group input-group-sm">'+
						'	<label class="input-group-addon">角色类型&nbsp;&nbsp;</label>'+
						'		<select id="allRoleType" class="form-control">'+
						'			<option value=""></option>'+		
						'			<option value="01">菜单角色</option>'+		
						'			<option value="02">流程角色</option>'+		
						'			<option value="03">预警角色</option>'+		
						'</select>'+
						'</div></div></div>'+spaceHtml+
						'<div class="row"><div class="col-xs-10 col-sm-10 col-md-offset-1">'+
						'	<div class="input-group input-group-sm">'+
						' 		<label class="input-group-addon">查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;&nbsp;</label>'+
						'		<input type="text" id="allRoleSearch" placeholder="请输入角色名..." class="form-control"/>'+
						'</div></div></div>'+spaceHtml;
	
	var userRoleHtml = '<div class="row"><div class="col-xs-10 col-sm-10 col-md-offset-1"><div class="input-group input-group-sm">'+
						'	<label class="input-group-addon">角色类型&nbsp;&nbsp;</label>'+
						'		<select id="userRoleType" class="form-control">'+
						'			<option value=""></option>'+		
						'			<option value="01">菜单角色</option>'+		
						'			<option value="02">流程角色</option>'+		
						'			<option value="03">预警角色</option>'+
						'</select>'+
						'</div></div></div>'+spaceHtml+
						'<div class="row"><div class="col-xs-10 col-sm-10 col-md-offset-1">'+
						'	<div class="input-group input-group-sm">'+
						' 		<label class="input-group-addon">查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;询&nbsp;&nbsp;</label>'+
						'		<input type="text" id="userRoleSearch" placeholder="请输入角色名..." class="form-control"/>'+
						'</div></div></div>'+spaceHtml;
	var time = new Date().getTime();
	$.bindAjax({
		dataType : "html",
		url : "<c:url value='/core/user/loadRoleOption'/>",
		data : "id="+ $("#form-submit [name=id]").val()+"&time="+time,
		action:"search"
	},function(data){
		var obj = $("#pre-selected-options");
		obj.append(data);
		obj.multiSelect({
			selectableHeader: allRoleHtml,
			selectionHeader: userRoleHtml,
			afterSelect: function(values){
				var object = new Object();
				object.id = values[0];
				object.oper = "add";
				roleOperArray.push(object);
				filterInfo("user");
			},
			afterDeselect: function(values){
				var object = new Object();
				object.id = values[0];
				object.oper = "del";
				roleOperArray.push(object);
				filterInfo("all");
			}
		});
	});
	
	//角色过滤
	$(document).on("change", "#allRoleType", function(){
		roleTypeFilter_all = $.trim($(this).val());
		filterInfo("all");
	});
	$(document).on("change", "#userRoleType", function(){
		roleTypeFilter_user = $.trim($(this).val());
		filterInfo("user");
	});
	
	//搜索
	$(document).on("change keyup", "#allRoleSearch", function(){
		filterInfo("all");
	});
	$(document).on("change keyup", "#userRoleSearch", function(){
		filterInfo("user");
	});
	
	$("#save").click(function(){
		var flag=true;
        var password=$("#form-submit [name=password]").val();
        if(password.length>0){
        	var level= getPasswordStrength(password);
        	flag = checkpwdlevel(level);
        }
        
        if(flag){
    		var param = $("#form-submit").serializeObject();
    		param.roles = JSON.stringify(roleOperArray);
    		$("#save").bindSweetAlert({
    			title:"确定要保存吗?"
    		},{
    			callback:function(){
    				$.bindAjax({
    					url:"<c:url value='/core/user/edit'/>",
    					data:param,
    					action:"save",
    					text:"",
    				},function(response){
    					location.href = "<c:url value='/core/user'/>";
    				});
    			}
    		});
        }
    });
	
	$("#undo").click(function(){
		window.history.back(-1);
    });
});


//获取密码强度
function getPasswordStrength(password){
	  if(password.length<8){
		  return 0;
	  }
	  var strength=0;
	  $([/.{6,}/,/[0-9]+/,/[a-z]+/,/[A-Z]+/,/[^0-9a-zA-Z]+/]).each(function(i,o){
	      if(o.test(password)) strength++;
	  });
	  return strength;
	}

//根据密码强度
function checkpwdlevel(level){
	if(level<4){
		swal("弱密码","注意：密码需包含大小写和数字且长度为8位以上（含8位）","warning");
		return false;
	}else{
		return true;
	}
}

function inEmpCtrl(){
	$("input[name=loginAcct]").attr("readonly",true);
	$("input[name=userName]").attr("readonly",true);
	$("input[name=compName]").attr("disabled",true);
	$("input[name=email]").attr("readonly",true);
}

function outEmpCtrl(){
	$("#employeeId").hide();
	$("input[name=loginAcct]").attr("readonly",true);
	$("input[name=userName]").attr("readonly",false);
	$("input[name=compName]").attr("disabled",false);
	$("input[name=email]").attr("readonly",false);
}

function callback(loginacctTemp,empcodeTemp,companycodeTemp,companynameTemp,nameTemp,emailTemp){
	$("input[name=employee]").val(nameTemp);
	$("input[name=loginAcct]").val(loginacctTemp);
	$("input[name=empCode]").val(empcodeTemp);
 	$("input[name=compCode]").val(companycodeTemp);
 	$("input[name=compName]").val(companynameTemp);
	$("input[name=userName]").val(nameTemp);
	$("input[name=email]").val(emailTemp);
}
//使页面不可编辑 
function disableForm(){ 
	$("#form-submit").disableForm();
	$("#save").css("display","none");
	$("#undo").attr("disabled",false);
} 

//过滤
function filterInfo(type){
	var selectRoleType ="";//角色类型
	var searchCond = "";//查询条件
	var selecttable = "";//角色表
	if(type == "all"){
		selectRoleType = roleTypeFilter_all;
		searchCond = $.trim($("#allRoleSearch").val());
		selecttable = ".ms-selectable";
	}else{
		selectRoleType = roleTypeFilter_user;
		searchCond = $.trim($("#userRoleSearch").val());
		selecttable = ".ms-selection"; 
	}
	  $(selecttable+" .ms-list li").each(function(){
	  	var hasselected =false;
		type == "all"?  hasselected = (!$(this).hasClass("ms-selected")):hasselected = ($(this).hasClass("ms-selected"));
		if(hasselected){
			var typerole = $.trim($(this).attr("type"));
			var rolenametemp = $.trim($(this).children("span").html());//角色名
			if(selectRoleType == ""){
				$(this).show();
				(searchCond != "" && rolenametemp.indexOf(searchCond) == -1) ? $(this).hide(): "";
			}else if(!(typerole==selectRoleType)){//过滤角色类别
				$(this).hide();
				(searchCond != "" && rolenametemp.indexOf(searchCond) == -1) ? $(this).hide() : "";
			}else{
				$(this).show();
				(searchCond != "" && rolenametemp.indexOf(searchCond) == -1) ? $(this).hide() : "";
			}
		}
	});  
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