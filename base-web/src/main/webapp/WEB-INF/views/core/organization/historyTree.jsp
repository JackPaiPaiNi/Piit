<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style type="text/css">
	.ftx04{
		color: #F00;
	}
</style>
<div class="breadcrumbs" id="breadcrumbs">
	<ul class="breadcrumb">
		<li>
			<i class="icon-home home-icon"></i>
			<a href="<c:url value='/' />">首页</a>
		</li>
		<li class="active">历史版本</li>
	</ul>
</div>

<div class="page-content">
	 <div class="page-header">
        <h1>
          架构历史
        </h1>
    </div> 
    <!-- /.page-header -->
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			
			<form id="form-submit">
				<h4 class="header blue">架构历史信息查询</h4>
				<div class="row" style="margin: 0px 8px;">
					<input type="hidden" name="id"/><!-- 用户id -->
					<input type="hidden" name="oper"/>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">架构系统&nbsp;&nbsp;</label>
							<select name="sys" class="form-control">
								<option value="base">基础架构</option>
								<option value="zj">资金架构</option>
								<option value="ys">预算架构</option>
							</select>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">组织编码&nbsp;&nbsp;</label>
							<input type="text" name="code" class="form-control" placeholder="请输入组织编码..."/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">组织名称&nbsp;&nbsp;</label>
							<input type="text" name="name" class="form-control" placeholder="请输入组织名称..."/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group">
							<label class="input-group-btn">日期<b class="ftx04">&nbsp;*</b>&nbsp;&nbsp;</label>
							<input type="text" name="date" class="form-control date-picker"/>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" style="margin: 0px 8px;border-bottom: 1px dotted #e2e2e2;padding-bottom: 10px;">
					<div class="col-xs-6 col-sm-2 col-md-offset-10">
						<button id="btn-search" type="button" class="btn btn-info btn-sm" style="float: right;margin-right: 79px;">
							<i class="icon-search icon-on-right bigger-110"></i>
							查询
						</button>
					</div>
				</div>
			</form>
			
			<div class="widget-body">
				<div class="widget-main padding-8">
				    <div style="text-align: center;display:none;" id="loadID"><label><i class="icon-spinner icon-spin  icon-large"></i> 加载中... </label></div>
					<div id="tree" class="ztree"></div>
				</div>
			</div>
			
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->

<script type="text/javascript">
var sysCode = "";
var date = "";

jQuery(function($) {
	$(".date-picker").bindDate();
	
	$('#btn-search').bind("click",function(){
		sysCode = $("select[name='sys']").val();
		var code = $.trim($("input[name=code]").val());
		var name = $.trim($("input[name=name]").val());
		date = $.trim($("input[name=date]").val());
		
		if(date == ""){
			swal("日期不能为空！","","warning");
			$("input[name=date]").focus();
			return false;
		}
		$("#loadID").show();
		$("#tree").bindAsyncTree({
			url:"<c:url value='/core/organization/loadHistoryTree'/>",
			autoParam:["id=parentCode"],
			otherParam:{"sys":sysCode,"name":name,"date":date},
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			}
		},{
			complete:function(){
				$("#loadID").hide();
			}
		});
		/* $("#tree").bindTree({
			dataUrl: "<c:url value='/core/organization/loadHistoryTree'/>?sys="+sysCode+"&code="+code+"&name="+name+"&date="+date,
			lazyload:true,
			view:{
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			},
			callback: {
				onExpand: lazyLoad
			}
		}); */
	});
	
	/* function lazyLoad(event, treeId, treeNode) {
		$("#tree").bindTree({
			//dataUrl: "<c:url value='/core/organization/loadHistoryTreeByParent'/>?sys="+sysCode+"&code="+treeNode.id+"&date=2015-11-02",
			dataUrl: "<c:url value='/core/organization/loadHistoryTreeByParent'/>?sys="+sysCode+"&code="+treeNode.id+"&date="+date,
			lazyload:true,
			lazyAppend:true,//懒加载  添加子节点数据
			lazyPidNode:treeNode,
			view:{
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			}
		});
	}; */
	
	function addHoverDom(treeId, treeNode) {
		//if (treeNode.parentNode && treeNode.parentNode.id!=1) return;
		var aObj = $("#" + treeNode.tId + "_a");
		if ($("#diyBtn1_"+treeNode.id).length>0) return;
		if ($("#diyBtn2_"+treeNode.id).length>0) return;
		//var editStr = "<a id='diyBtn1_" +treeNode.id+ "' onclick='linkPage(\""+treeNode.id+"\",\""+treeNode.ext2+"\");' title='跳转' style='margin:0 0 0 5px;background:url(4.png) no-repeat center center;'><i class='icon-link icon-4x'></i></a>" ;
		var editStr = "<a id='diyBtn1_" +treeNode.id+ "' onclick='linkPage(\""+treeNode.id+"\",\""+treeNode.ext2+"\");' title='进入历史' style='margin:0 0 0 5px;'><span class='hreflink' style='font-size:14px;' onfocus='this.blur();'></span></a>" ;
		aObj.append(editStr);
	}
	
	function removeHoverDom(treeId, treeNode) {
		//if (treeNode.parentTId && treeNode.getParentNode().id!=1) return;
		$("#diyBtn1_"+treeNode.id).unbind().remove();
		$("#diyBtn2_"+treeNode.id).unbind().remove();
	}
	
});

function linkPage(code,version){
	location.href = "<c:url value='/base/company/editPage'/>?code="+code+"&histVersion="+version;
}

</script>