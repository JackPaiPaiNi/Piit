<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
</head>
<body>
<div class="zheZhao"></div>
<div class="page-content">
	
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			
			<form id="form-submit">
				<div id="search-box" class="row" style="margin: 0px 8px;">
					<input type="hidden" id="drdh" name="drdh" value="${drdh}"/>
					<div class="col-xs-12 col-sm-12">
						<span style="color: red;">（*操作类型：M-新增或修改，D-删除。每次提交时均会推送SAP！）</span>
						<div class="btn-group">
							<button id="template-download" type="button" class="btn btn-info btn-sm">
								<i class="icon-download-alt icon-on-right bigger-110"></i>
								模板下载
							</button>
							<button id="import" type="button" class="btn btn-info btn-sm">
								<i class="icon-upload-alt icon-on-right bigger-110"></i>
								导入
							</button>
							<button id="export" type="button" class="btn btn-info btn-sm">
								<i class="icon-download-alt icon-on-right bigger-110"></i>
								导出
							</button>
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i>
								提交
							</button>
							&nbsp;
							<button id="undo" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
								返回
							</button>
						</div>
					</div>
				</div>
			   <div class="space-4"></div>
			   <div class="row" style="margin: 0px;">
			     <div class="col-xs-12 col-sm-12">
				   <div id="grid-parent">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
				    </div>
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
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var parent_selector = "#grid-parent";
	
	$(function($){
 		// 初始化grid
 		bindGrid();
  		// 返回
		$("#undo").click(function(){
			window.history.back(-1);
	    });
  		// 提交
		$("#btn-submit").click(function(){
			submit();
	    });
  		// 模板下载
		$('#template-download').click(function(){
		    window.location.href=encodeURI("<c:url value='/template/chzlb.xlsx'/>");
	  	});
  		// 导入
		$('#import').click(function(){
			$.importDialog({
				title:"选择文件",
				data: {drdh:'${drdh}'},
				url:"<c:url value='/price/shippingsheet/Import'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger('reloadGrid');
				}
			});
		});
  		// 导出
		$("#export").click(function(){
		    var curNum = $(grid_selector).getGridParam("records");
		    if(curNum == 0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/price/shippingsheet/Export'/>"+"?drdh=${drdh}"});
	    			}
	    		});
	        }
		});
	});
	/**************************************************function开始区域************************************************/
	//初始化grid
	function bindGrid(){	
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/price/shippingsheet/findByDrdh'/>?drdh=${drdh}",
			pager: pager_selector,
			gridParent: parent_selector,
		    shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				//{name:'id', index:'id', label:'ID', hidden:true},
				{name:'flag', index:'flag', label:'操作类型', width:80},
				{name:'ddid', index:'ddid', label:'订单号', width:130}, 
				{name:'wlbh', index:'wlbh', label:'物料编码', width:180}, 
				{name:'bz', index:'bz', label:'币种', width:80},
				{name:'dj', index:'dj', label:'单价', width:100, align:'right', 
					formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:4}},
				{name:'dw', index:'dw', label:'单位', width:80}
			]
		},{
			add:false,
			edit:false,
			view:false,
			del:false
		});
	}
	
	//提交
	function submit(){
		var curNum = $(grid_selector).getGridParam("records");
	    if(curNum == 0){
            swal("请导入出货资料表！","","warning");
            return false;
        }
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/price/shippingsheet/submit'/>",
					data:{drdh : '${drdh}'},
					action:"save"
				},function(response){
					swal(response.resultMsg,"","warning");
 					window.history.back(-1);
				}); 
			}
		});
	}
	/**************************************************function结束区域************************************************/
</script>
</html>