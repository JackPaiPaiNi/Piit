<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
<style type="text/css">
	.ztree li span.button.add {margin-left:9px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
	.modalClearBtn{
		float:left;
	}
</style>
<script type="text/javascript">

</script>
</head>
<body>

<div class="zheZhao"></div>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="row">
				<div class="col-sm-6">
					<div class="widget-box">
						<div class="widget-header header-color-blue2">
							<h4 class="lighter smaller">组织机构树</h4>
							<button id="addRoot" class="btn btn-success header-color-green2" type="button" style="float:right;">
								<i class="icon-plus bigger-110"></i>
								新增组织机构
							</button>
							&nbsp;&nbsp;
							<button id="pdaInfoExport" type="button" class="btn header-color-green2" style="float:right;">
								<i class="icon-download-alt icon-on-right bigger-110"></i>
								导出
							</button>
						</div>
						<div class="widget-body">
							<div class="widget-main padding-8">
								<div class="space-4"></div>
								<div class="row" style="border-bottom: 1px dotted #e2e2e2;padding-bottom: 10px;margin:0px;">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">编码：&nbsp;</label>
											<input type="text" id="areaSearchCode" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-4">
										<div class="input-group">
											<label class="input-group-btn">名称：&nbsp;</label>
											<input type="text" id="areaSearchName" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group">
											<label class="input-group-btn">状态：&nbsp;&nbsp;</label>
											<select id="statusSearch" size="1" class="form-control">
												<option value=""></option>
												<option value="1" selected>启用</option>
												<option value="0">禁用</option>
											</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-1">
										<button id="btnSearch" type="button" class="btn btn-info btn-sm">
											<i class="icon-search icon-on-right bigger-110"></i>查询
										</button>
									</div>
								</div> 
								<div class="space-4"></div>
								<div id="tree" class="ztree" style="height: 465px;overflow-y: auto;"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="widget-box">
						<div class="widget-header header-color-green2">
							<h4 class="lighter smaller">组织机构信息</h4>
						</div>

						<div class="widget-body" style="height: 546px; overflow: hidden;">
							<div class="widget-main padding-8">
								<form class="form-submit">
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：&nbsp;&nbsp;</label>
												<input type="text" name="code" exportColNames="编码" class="form-control"/>
											</div>
										</div>
										<div class="col-xs-1" style="margin-top: 9px;"><b style="color: #F00;">*</b></div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">上级节点：&nbsp;&nbsp;</label>
												<input type="hidden" name="parentCode" id="parentCodeId" exportColNames="上级节点" class="form-control"/>
												<input type="text" name="parentName" id="parentNameId" onfocus="this.blur()" style="cursor: pointer!important;" class="form-control parent-node"/>
												<span class="input-group-addon">
													<i class="icon-search bigger-110"></i>
												</span>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">中文名称：&nbsp;&nbsp;</label>
												<input type="text" name="cnName" exportColNames="中文名称" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">中文全称：&nbsp;&nbsp;</label>
												<input type="text" name="cnFullName" exportColNames="中文全称" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">英文名称：&nbsp;&nbsp;</label>
												<input type="text" name="enName" exportColNames="英文名称" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">英文全称：&nbsp;&nbsp;</label>
												<input type="text" name="enFullName" exportColNames="英文全称" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：&nbsp;&nbsp;</label>
												<select name="levels" exportColNames="级别" class="form-control">
													<option value="1">国家</option>
													<option value="2">省/直辖市</option>
													<option value="3">市/区</option>
													<option value="4">县/区</option>
												</select>
												<!-- <input type="text" name="levels" class="form-control"/> -->
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序：&nbsp;&nbsp;</label>
												<input type="text" name="sort" exportColNames="排序" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-6 col-md-offset-1">
											<div class="input-group">
												<label class="input-group-btn">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：&nbsp;&nbsp;</label>
												<input type="hidden" name="oldStatus" class="form-control"/>
												<select name="status" size="1" exportColNames="状态" class="form-control">
													<option value="1" selected>启用</option>
													<option value="0">禁用</option>
												</select>
											</div>
									</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div style="border-top:1px solid #e5e5e5;margin: 13px 40px;padding: 12px 14px 6px;width:60%;">
											<div class="center">
												<button id="save" class="btn btn-info" type="button">
													<i class="icon-ok bigger-110"></i>
													提交
												</button>
											</div>
										</div>
									</div>
									<input type="hidden" name="oper"/>
									<input type="hidden" name="id"/><!-- 为节点ext（数据库的id值）的值 -->
									<input type="hidden" name="fullPathCode"/>
									<input type="hidden" name="childCount"/>
								</form>
							</div>
						</div>
					</div>
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
	var parentid = "";//新增资源时的父id
	var parentFullPath = "";//父的全路径
	var oldParentNode = "";
	var newParentNode = "";
	var changFullPath = "";
	var changFlag = false;
	var addClick = false;
	var searchStatus = "";
	var isEdit = false;
	<shiro:hasPermission name="area:edit">isEdit=true;</shiro:hasPermission>
	
	jQuery(function($) {
		$.loading();
		loadTree("","",$("#statusSearch").val());
		
		if(!isEdit){
			$("#addRoot").hide();
			$("#save").css("display","none");
		}else{
			$("#addRoot").bind("click", {isParent:false}, addRoot);
		}
		//导出数据
		 $("#pdaInfoExport").click(function(){
			 var treeObj = $.fn.zTree.getZTreeObj("tree");
			 var nodes = treeObj.getNodes();
			 var curNum = nodes.length;
		       if(curNum==0){ 
		                swal("结果集为空不能导出","","warning");
		                return false;
		            }else{  
		            	$("#pdaInfoExport").bindSweetAlert({
		        			title:"确定要导出吗?",
		        			closeOnConfirm:true
		        		},{
		        			callback:function(){
		        				$(this).treeExportExcel({
		        					url:"<c:url value='/base/area/export'/>",
		        					params:{
		        						"code":$.trim($("#areaSearchCode").val()),
		        						"cnName":$.trim($("#areaSearchName").val()),
		        						"fileName":"地区"
		        					}
		        				});
		        			}
		        		});
		            } 
		    });
		//查询按钮
		$('#btnSearch').bind("click",function(){
			$.loading();
			var code = $.trim($("#areaSearchCode").val());
			var name = $.trim($("#areaSearchName").val());
			loadTree(code,name,$("#statusSearch").val());
		});
		//上级节点选择
		$("#parentNameId").bindTreeDialog({
			title:"上级节点",
			searchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			url : "<c:url value='/base/area/loadTree'/>",
			autoParam:["id=parentCode"],
			dataParams:{"status":1}//启用
		},{
			callback:function(node){
				if(node != "" && node != undefined){
					$("#parentCodeId").val(node.id);
					$("#parentNameId").val(node.name.split("-")[1]);
					changFullPath = node.path;
				}else if(node == ""){
					$("#parentCodeId").val("");
					$("#parentNameId").val("");
					changFullPath = "";
				}
				newParentNode = $("form.form-submit [name=parentCode]").val();
		    	oldParentNode != newParentNode ? changFlag = true:"";
			}
		});
		//保存
		$("#save").click(function(){
			save();
	    });
	});
	//根据节点和id进行加载
	function loadTree(code,name,status){
		$("#tree").bindAsyncTree({
			url:"<c:url value='/core/organization/loadTree'/>",
			autoParam:["id=parentCode"],
			otherParam:{"code":code,"name":name,"status":status},
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			},
			/* async: {
				enable: true,
				url:"<c:url value='/base/area/loadTree'/>",
				autoParam:["id=parentCode"],
				otherParam:{"status":searchStatus},
				dataFilter: filter
			}, */
			callback: {
				onClick: find,
				onRename:onRename,
				onAsyncSuccess: zTreeOnAsyncSuccess
				//onExpand: lazyLoad
			}
		},{
			complete:function(){
				$.hideLoad();
			}
		});
	}
	
	//异步加载成功
	function zTreeOnAsyncSuccess(event, treeId, treeNode, msg){
		$.hideLoad();
		var zTree = $.fn.zTree.getZTreeObj("tree");
		if(addClick){
				if(treeNode.ext.indexOf("<ADD>") != -1){
					swal("新增父节点（“"+treeNode.name+"”）还未提交!","注：请先进行对新增父节点（“"+treeNode.name+"”）数据的保存，在做添加子节点操作。","warning")
					return;
				}
				UT.setReadOnly($("#parentNameId"),false);
				isParent = false;
				parentFullPath = treeNode.path;
				var pidname = treeNode.name.split("-")[1];
				var addcount = newCount++;
				 if (treeNode) {
					treeNode = zTree.addNodes(treeNode, {ext:("<ADD>_"+100 + addcount),id:addcount, pId:treeNode.id,pIdName:pidname, isParent:isParent, name:"新增地区" + (addcount)});
				} else {
					treeNode = zTree.addNodes(null, {ext:("<ADD>_"+100 + addcount),id:addcount, pId:0, isParent:isParent, name:"新增地区" + (addcount)});
				} 
				if (treeNode) {
					$("form.form-submit [name=code]").attr("readonly",false);
					initForm();
					zTree.selectNode(treeNode[0]);
	                var sel=zTree.getNodeByParam('id',treeNode[0].id);
	                if(sel != null) $("#"+sel.tId+"_a").click();
	                zTree.editName(treeNode[0]);
	                $("form.form-submit [name=parentCode]").val(treeNode[0].pId);
	    			$("form.form-submit [name=parentName]").val(treeNode[0].pIdName);
	                $("form.form-submit [name=levels]").val(treeNode[0].level+1);
	                $("form.form-submit [name=levels]").attr("disabled","disabled");
	                $("form.form-submit [name=status]").val("1");
	                
	                $("form.form-submit [name=id]").val(treeNode[0].ext);
	    			$("form.form-submit [name=oper]").val("add");
	                
	                oldParentNode = $("form.form-submit [name=parentCode]").val();
				} else {
					swal("叶子节点被锁定，无法增加子节点");
				}
				addClick = false;
		}
	}
	//铲鲟过滤
	function filter(treeId, parentNode, childNodes) {
		if(childNodes.length== 1000){//地区模糊查询数量限制提示
			swal("","查询数量过多，数据未完整显示，请输入更多查询信息！");
		}
		if (!childNodes)return null;
		for (var i=0, l=childNodes.length; i<l; i++) {
			childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
		}
		return childNodes;
	}
	
	//新增组织根节点
	var newCount = 1;
	function addRoot(e){
		$(".form-submit").enableForm();
		$("form.form-submit [name=code]").attr("readonly",false);
		var zTree = $.fn.zTree.getZTreeObj("tree"),
		isParent = e.data.isParent;
		var addcount = newCount++;
		treeNode = zTree.addNodes(null, {ext:("<ADD>_"+100 + addcount),id:addcount, pId:0, isParent:isParent, name:"新增地区" + (addcount)});
		if (treeNode) {
			zTree.editName(treeNode[0]);
			parentid = treeNode[0].pId;
			initForm();
			$("form.form-submit [name=levels]").val(1);
			$("form.form-submit [name=levels]").attr("disabled","disabled");
			$("form.form-submit [name=id]").val(treeNode[0].ext);
			$("form.form-submit [name=name]").val(treeNode[0].name);
			 $("form.form-submit [name=status]").val("1");
			$("form.form-submit [name=oper]").val("add");
			UT.setReadOnly($("#parentNameId"),true);
			oldParentNode = $("form.form-submit [name=parentCode]").val();
		} else {
			swal("叶子节点被锁定，无法增加子节点");
		}
	}
	
	//重命名节点
	function onRename(e,treeId,treeNode,isCancel){
		$("form.form-submit [name=cnName]").val(treeNode.name);
	}
	
	
	//保存修改
	function save() {
		var idTemp = $.trim($("form.form-submit [name=id]").val());//相对于节点的ext
		if ( idTemp== "") return ;
		var code = $.trim($("form.form-submit [name=code]").val());
		if(code == ""){
			swal("编码不能为空！","","warning");
			$("form.form-submit [name=code]").focus();
			return false;
		}
		$("form.form-submit [name=levels]").removeAttr("disabled");
		var param = $("form.form-submit").serializeObject();
		param.oldParentCode = oldParentNode;
		if(changFlag){
			 //param.oldParentCode = oldParentNode;
			 var fullpath = "";
			 changFullPath != "" ? fullpath = changFullPath+"/"+code : fullpath = code;
			 param.fullPathCode = fullpath;
			 var pathArr = fullpath.split("/");
			 param.levels = pathArr.length;
		}else{
			//param.oldParentCode = "";
		}
		if(idTemp.indexOf("<ADD>") != -1){
			//param.parentCode = parentid;
			parentid == null ? param.fullPathCode = code : param.fullPathCode = parentFullPath +"/"+code;
			param.id = "";
		}else{param.oper="edit";} 
		$("#save").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url : "<c:url value='/base/area/edit'/>",
		    		data : param,
					action:"save"
				},function(msg){
					if(msg != ''){
						var response = eval('('+msg+')');
						var treeObj = $.fn.zTree.getZTreeObj("tree");
						var nodes = treeObj.getNodesByParam("ext", idTemp, null);
						nodes[0].id = response.code;
						if(response.status == 1){//1启用,0禁用
							nodes[0].name = response.code+"-"+response.cnName;
						}else{
							nodes[0].name = "<del>"+response.code+"-"+response.cnName+"</del>";
							var nodes4 = treeObj.getNodesByParam("id", response.code, null)[0];//alert(JSON.stringify(nodes[0]));
							//console.log(nodes4.open +","+ nodes4.children != undefined +","+ (nodes4.children).length>0);
							if(nodes4.open && nodes4.children != undefined && nodes4.children.length>0){
								var childrens = nodes4.children;
								for (var k = 0; k < childrens.length; k++) {
									var child = childrens[k];
									child.name = "<del>"+child.name+"</del>";
									treeObj.updateNode(child);
								}
							}
						}
						nodes[0].ext = response.id;
						nodes[0].path= response.fullPathCode;
						nodes[0].pId = response.parentCode;
						response.childCount >0 ? nodes[0].isParent = true:nodes[0].isParent = false;
						treeObj.updateNode(nodes[0]);
						if(changFlag){
							var nodes2 = treeObj.getNodesByParam("id", newParentNode, null);//alert(JSON.stringify(nodes[0]));
							treeObj.removeNode(nodes[0]);
							if(nodes2[0] != undefined){//已加载节点  
								if(nodes2[0].isParent && nodes2[0].open){
									treeObj.addNodes(nodes2[0], nodes[0]);
								}else if(!nodes2[0].isParent){//nodes2表示没有子节点的根节点，在此添加子节点回显
									nodes2[0].isParent = true;
									treeObj.updateNode(nodes2[0]);
									treeObj.addNodes(nodes2[0], nodes[0]);
								}else{
									
								}
								//treeObj.addNodes(nodes2[0], nodes[0]);
								//treeObj.expandNode(nodes2[0], true, false, true);
							}else if(response.levels == 1){//说明是根节点
								treeObj.addNodes(null, nodes[0]);
							}else{//不是根节点 未加载加点
							}
						}
						swal("保存成功!", "", "success");
						backDatas(response);
						$("form.form-submit [name=levels]").val(response.levels);
						oldParentNode = response.parentCode;
						$("form.form-submit [name=id]").val(response.id);
						$("form.form-submit [name=levels]").attr("disabled","disabled");
						changFlag = false;
					}
				}); 
			}
		});
	}
    
	//根据点加载子节点
	var intervalTimer = null; 
	function find(event, treeId, treeNode) {
	    if(intervalTimer != null){
	    	clearTimeout(intervalTimer);
	    	intervalTimer = null;
	    	return false;
	    }else{
	    	intervalTimer = setTimeout(function() { 
	        	$.loading();
	        	UT.setReadOnly($("#parentNameId"),false);
	    		$(".form-submit").enableForm();
	    		$("form.form-submit [name=code]").attr("readonly",false);
	    		$("form.form-submit [name=levels]").removeAttr("disabled");
	    		if(treeNode.ext.indexOf("<ADD>") != -1){
	    			parentid = treeNode.pId;
	    			initForm();
	    			$("form.form-submit [name=id]").val(treeNode.ext);
	    			$("form.form-submit [name=cnName]").val(treeNode.name);
	    			$("form.form-submit [name=parentCode]").val(treeNode.pId);
		    		$("form.form-submit [name=parentName]").val(treeNode.pIdName);
	    			$("form.form-submit [name=levels]").val(treeNode.level+1);
	    			$("form.form-submit [name=levels]").attr("disabled","disabled");
	    			$("form.form-submit [name=status]").val("1");
	    			$("form.form-submit [name=oper]").val("add");
	    			$.hideLoad();
	    			return;
	    		}else{
	    			$("form.form-submit [name=code]").attr("readonly",true);
	    		}
	    		$.bindAjax({
	    			url : "<c:url value='/base/area/find'/>",
	    			data: {"id" : treeNode.ext},
	    			action:"search"
	    		},function(response){
	    			var values = $("form.form-submit").serializeArray();
	    			for (var index = 0; index < values.length; index++) {
	    				var name = values[index].name;
	    				var value = response[name];
	    				if(value != null){
	    					$("form.form-submit [name="+name+"]").val(value);
	    				} else {
	    					$("form.form-submit [name="+name+"]").val("");
	    				}
	    		    }
	    			$("form.form-submit [name=levels]").val(response["levels"]);
	    			$("form.form-submit [name=oldStatus]").val(response["status"]);
	    		    oldParentNode = $("form.form-submit [name=parentCode]").val();
	    			$("form.form-submit [name=levels]").attr("disabled","disabled");
	    			(!isEdit) ? $(".form-submit").disableForm():"";//只有查看权限
	    			$("form.form-submit [name=oper]").val("edit");
	    			$.hideLoad();
	    		});
	    		intervalTimer = null;
	        }, 250); 
	    }
	};
	//初始化form
	function initForm(){
		var values = $("form.form-submit").serializeArray();
		for (var index = 0; index < values.length; index++) {
			var name = values[index].name;
			$("form.form-submit [name="+name+"]").val("");
	    }
	} 
	
	//节点上的新增按钮事件
	function addHoverDom(treeId, treeNode) {
		if(!isEdit) return false;
		if(treeNode.status == 0){//0禁用，1启用
			return false;
		}
		if(treeNode.level == 3) return false;//第4层县/区没有添加动作
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='新增下级地区' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			var zTree = $.fn.zTree.getZTreeObj("tree");
			 if(treeNode.zAsync){
				if(treeNode.ext.indexOf("<ADD>") != -1){
					swal("新增父节点（“"+treeNode.name+"”）还未提交!","注：请先进行对新增父节点（“"+treeNode.name+"”）数据的保存，在做添加子节点操作。","warning")
					return;
				}
				UT.setReadOnly($("#parentNameId"),false);
				initForm();
				isParent = false;
				parentFullPath = treeNode.path;
				var pidname = treeNode.name.split("-")[1];
				var addcount = newCount++;
				if (treeNode) {
					treeNode = zTree.addNodes(treeNode, {ext:("<ADD>_"+100 + addcount),id:addcount, isHidden:true,pId:treeNode.id,pIdName:pidname, isParent:isParent, name:"新增地区" + (addcount)});
				} else {
					treeNode = zTree.addNodes(null, {ext:("<ADD>_"+100 + addcount),id:addcount, pId:0, isParent:isParent, name:"新增地区" + (addcount)});
				}
				if (treeNode) {
					zTree.selectNode(treeNode[0]);
	                var sel=zTree.getNodeByParam('id',treeNode[0].id);
	                if(sel != null) $("#"+sel.tId+"_a").click();
	                zTree.editName(treeNode[0]);
	                $("form.form-submit [name=id]").val(treeNode[0].ext);
	                $("form.form-submit [name=parentCode]").val(treeNode[0].pId);
	    			$("form.form-submit [name=parentName]").val(treeNode[0].pIdName);
	                $("form.form-submit [name=levels]").val(treeNode[0].level+1);
	                $("form.form-submit [name=status]").val("1");
	                $("form.form-submit [name=oper]").val("add");
	                oldParentNode = $("form.form-submit [name=parentCode]").val();
				} else {
					swal("叶子节点被锁定，无法增加子节点");
				}
			
			 }else{
				 addClick = true;
				 UT.setReadOnly($("#parentNameId"),false);
				 zTree.expandNode(treeNode, true, true, true);
			 }
		});
	};
	
	function backDatas(response){
		var values = $("form.form-submit").serializeArray();
		for (var index = 0; index < values.length; index++) {
			var name = values[index].name;
			var value = response[name];
			if(value != null){
				$("form.form-submit [name="+name+"]").val(value);
			} else {
				$("form.form-submit [name="+name+"]").val("");
			}
	    }
		$("form.form-submit [name=levels]").val(response["levels"]);
		$("form.form-submit [name=oldStatus]").val(response["status"]);
	    oldParentNode = $("form.form-submit [name=parentCode]").val();
		$("form.form-submit [name=levels]").attr("disabled","disabled");
		(!isEdit) ? $(".form-submit").disableForm():"";//只有查看权限
		$("form.form-submit [name=oper]").val("edit");
	}
	
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
</script>
</html>