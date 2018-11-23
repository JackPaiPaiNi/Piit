<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>    

<style type="text/css">
	.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
</style>
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
							<h4 class="lighter smaller">资源树</h4>
							<button id="addRoot" class="btn btn-success btn-minier bigger" type="button" style="margin:8px;;float:right;">
								<i class="icon-plus bigger-110"></i>
								添加
							</button>
						</div>

						<div class="widget-body">
							<div class="widget-main padding-8">
								<div class="space-4"></div>
								<div id="tree" class="ztree" style="height: 540px;overflow-y: auto;"></div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="widget-box">
						<div class="widget-header header-color-green2">
							<h4 class="lighter smaller">资源信息</h4>
						</div>

						<div class="widget-body" style=" max-height: 540px; overflow-y: auto;overflow-x: hidden;">
							<div class="widget-main padding-8">
								<form class="form-submit">
									<div class="row">
										<div class="col-xs-10 col-md-offset-1">
											<div class="input-group input-group-sm">
												<label class="input-group-addon">名称：&nbsp;&nbsp;</label>
												<input type="text" name="name" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-10 col-md-offset-1">
											<div class="input-group input-group-sm">
												<label class="input-group-addon">类型：&nbsp;&nbsp;</label>
												<select name="type" class="form-control skyselect">
													<option value="01">菜单</option>
													<option value="02">权限</option>
												</select>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-10 col-md-offset-1">
											<div class="input-group input-group-sm">
												<label class="input-group-addon">地址：&nbsp;&nbsp;</label>
												<input type="text" name="url" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-10 col-md-offset-1">
											<div class="input-group input-group-sm">
												<label class="input-group-addon">权限：&nbsp;&nbsp;</label>
												<input type="text" name="permission" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-10 col-md-offset-1">
											<div class="input-group input-group-sm">
												<label class="input-group-addon">排序：&nbsp;&nbsp;</label>
												<input type="text" name="sort" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-10 col-md-offset-1">
											<div class="input-group input-group-sm">
												<label class="input-group-addon">图标：&nbsp;&nbsp;</label>
												<input type="text" name="icon" class="form-control"/>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<div class="row">
										<div class="col-xs-10 col-md-offset-1">
											<div class="input-group input-group-sm">
												<label class="input-group-addon">状态：&nbsp;&nbsp;</label>
												<select name="status" class="form-control skyselect">
													<option value="1">启用</option>
													<option value="0">禁用</option>
												</select>
											</div>
										</div>
									</div>
									<div class="space-4"></div>
									<hr>
									<div class="row">
										<div class="center">
											<button id="save" class="btn btn-info btn-sm" type="button">
												<i class="icon-ok bigger-110"></i>
												提交
											</button>
										</div>
									</div>
									<input type="hidden" name="parentId"/>
									<input type="hidden" name="oper"/>
									<input type="hidden" name="id"/>
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
	var isEdit = false;
	<shiro:hasPermission name="resource:edit">isEdit=true;</shiro:hasPermission>
	
	jQuery(function($) {
		$(".skyselect").select2();
		initTree();
		if(!isEdit){
			$("#addRoot").hide();
			$("#save").css("display","none");
		}else{
			$("#addRoot").bind("click", {isParent:false}, addRoot);
		}
		
		$("#save").click(function(){
			save();
	    });
	});
	
	function initTree(){
		$("#tree").bindTree({
			dataUrl: "<c:url value='/core/resource/loadTree'/>",
			edit: {
				enable: true,
				drag: {
					isCopy: false,
					isMove: false
				},
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: false
			},
			callback: {
				onClick: find,
				//beforeRename:beforeRename,
				onRename:onRename,
				beforeRemove: beforeRemove
				//onRemove: onRemove
			},
			view:{
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			}
		});
	}
	
	var newCount = 1;
	function addRoot(e){
		$(".form-submit").enableForm();
		var zTree = $.fn.zTree.getZTreeObj("tree"),
		isParent = e.data.isParent;
		treeNode = zTree.addNodes(null, {id:("add_"+100 + newCount), pId:0, isParent:isParent, name:"新增资源" + (newCount++)});
		if (treeNode) {
			zTree.editName(treeNode[0]);
			parentid = treeNode.pId;
			var values = $("form.form-submit").serializeArray();
			for (var index = 0; index < values.length; index++) {
				var name = values[index].name;
				$("form.form-submit [name="+name+"]").val("");
		    }
			$("form.form-submit [name=type]").val("02");
			$("form.form-submit [name=status]").val("1");
			$("form.form-submit [name=id]").val(treeNode[0].id);
			$("form.form-submit [name=name]").val(treeNode[0].name);
			$("form.form-submit [name=oper]").val("add");
		} else {
			swal("叶子节点被锁定，无法增加子节点");
		}
	}
	
	function onRename(e,treeId,treeNode,isCancel){//alert("修改节点的id为："+treeNode.id+"\n修改后的名称为："+treeNode.name);
		$("form.form-submit [name=name]").val(treeNode.name);
	}
	
	function save() {
		if ($.trim($("form.form-submit [name=id]").val()) == "") return ;
		var param = $("form.form-submit").serializeObject();
		if($("form.form-submit [name=id]").val().indexOf("add") != -1){
			param.parentId = parentid;
			param.id = "";
		}
		$("#save").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url : "<c:url value='/core/resource/edit'/>",
		    		data : param,
					action:"save",
					text:"提示：配置信息更改成功，请在线用户重新登录系统！",
				},function(response){
					initTree();
	    			initForm();
	    			$.hideLoad();
				});
			}
		});
	}
	
	function find(event, treeId, treeNode) {
		$(".form-submit").enableForm();
		if(treeNode.id.indexOf("add") != -1){
			parentid = treeNode.pId;
			var values = $("form.form-submit").serializeArray();
			for (var index = 0; index < values.length; index++) {
				var name = values[index].name;
				$("form.form-submit [name="+name+"]").val("");
		    }
			$("form.form-submit [name=type]").val("02");
			$("form.form-submit [name=status]").val("1");
			$("form.form-submit [name=id]").val(treeNode.id);
			$("form.form-submit [name=name]").val(treeNode.name);
			$("form.form-submit [name=oper]").val("add");
			return;
		}
		$.loading();
		$.bindAjax({
			url : "<c:url value='/core/resource/find'/>?id="+treeNode.id,
			action:"search"
		},function(response){
			var values = $("form.form-submit").serializeArray();
			for (var index = 0; index < values.length; index++) {
				var name = values[index].name;
				var value = response[name];
				if(value != null){
					if($("form.form-submit [name="+name+"]").hasClass("skyselect")){
						$("form.form-submit [name="+name+"]").select2("val",value);
					}else{
						$("form.form-submit [name="+name+"]").val(value);
					}
				} else {
					if($("form.form-submit [name="+name+"]").hasClass("skyselect")){
						$("form.form-submit [name="+name+"]").select2("val","");
					}else{
						$("form.form-submit [name="+name+"]").val("");
					}
				}
		    }
			(!isEdit) ? $(".form-submit").disableForm():"";//只有查看权限
			$("form.form-submit [name=oper]").val("edit");
			$.hideLoad();
		});
	};
	
	function beforeRemove(treeId, treeNode){
		/* var isok = confirm("确定要删除节点“"+treeNode.name+"”吗？");
		if(isok){
			initForm();
			var param = {"oper":"del"};
			$.ajax({
				type : "post",
				dataType : "json",
				url : "<c:url value='/core/resource/edit'/>?id="+treeNode.id,
				data : param, 
				success : function(response) {
					//alert("删除成功");//后续通过返回删除条数来判断
				},
	    		complete:function(msg){//alert(JSON.stringify(msg));
	    			msg.statusText == "OK"? swal("删除成功!", "", "success"):swal("删除失败!", "原因："+msg.responseTex, "error");
	    		}
			});
		}
		return isok; */
		
		$("#tree").bindSweetAlert({
			title:"确定要删除节点“"+treeNode.name+"”吗？",
			text: "您将不能在使用该资源数据了!"
		},{
			callback:function(){
				var param = {"oper":"del"};
				$.bindAjax({
					url : "<c:url value='/core/resource/edit'/>?id="+treeNode.id,
					data : param, 
					action:"delete"
				},function(response){
					initForm();initTree();
				});
			}
		});
		
		/* swal({   
			title: "确定要删除节点“"+treeNode.name+"”吗？",
			text: "您将不能在使用该资源数据了!",
			type: "warning",
			showCancelButton: true,
			cancelButtonText: "取消",
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "删除",
			closeOnConfirm: false 
			}, 
			function(){
				var param = {"oper":"del"};
				$.ajax({
					type : "post",
					dataType : "json",
					url : "<c:url value='/core/resource/edit'/>?id="+treeNode.id,
					data : param, 
					success : function(response) {
						//alert("删除成功");//后续通过返回删除条数来判断
					},
		    		complete:function(msg){
		    			msg.statusText == "OK"? swal("删除成功!", "", "success"):swal("删除失败!", "原因："+msg.responseTex, "error");
		    			initForm();initTree();
		    		}
				});
			}); */ 
		return false;
	}
	
	function initForm(){
		var values = $("form.form-submit").serializeArray();
		for (var index = 0; index < values.length; index++) {
			var name = values[index].name;
			$("form.form-submit [name="+name+"]").val("");
	    }
		$("form.form-submit [name=type]").val("02");
		$("form.form-submit [name=status]").val("1");
	}
	
	//var newCount = 1;
	function addHoverDom(treeId, treeNode) {
		if(!isEdit) return false;
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			if(treeNode.id.indexOf("add") != -1 ){
				swal("新增父节点（“"+treeNode.name+"”）还未提交!","注：请先进行对新增父节点（“"+treeNode.name+"”）数据的保存，在做添加子节点操作。","warning")
				return;
			}
			var zTree = $.fn.zTree.getZTreeObj("tree");
			isParent = false;
			if (treeNode) {
				treeNode = zTree.addNodes(treeNode, {id:("add_"+100 + newCount), pId:treeNode.id, isParent:isParent, name:"新增资源" + (newCount++)});
			} else {
				treeNode = zTree.addNodes(null, {id:("add_"+100 + newCount), pId:0, isParent:isParent, name:"新增资源" + (newCount++)});
			}
			if (treeNode) {
				zTree.selectNode(treeNode[0]);
                var sel=zTree.getNodeByParam('id',treeNode[0].id);
                $("#"+sel.tId+"_a").click();
                zTree.editName(treeNode[0]);
			} else {
				swal("叶子节点被锁定，无法增加子节点");
			}
		});
	};
	
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	
	function showRemoveBtn(treeId, treeNode) {
		if(!isEdit) return false;
		return !treeNode.isParent;
	}
</script>
</html>