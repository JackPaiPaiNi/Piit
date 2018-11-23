<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
<style type="text/css">
	html{
		position:static;
	}
</style>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div class="widget-box">
			<form id="form-search" name="form-search" class="form-search">
						<input id="pid" name="pid" type="hidden" value="${pid}"/>
						<input id="khbm" name="khbm" type="hidden" value="${khbm}"/>
						<input id="jhrq" name="jhrq" type="hidden" value="${jhrq}"/>
						<input id="xsyid" name="xsyid" type="hidden" value="${xsyid}"/>
			</form>
				<div class="widget-header header-color-blue2">
					<h5>预测信息</h5>
					<span class="widget-toolbar">
						<a href="#" data-action="collapse">
							<i class="icon-chevron-up"></i>
						</a>
					</span>
<!-- 					<div class="widget-toolbar no-border">
						<button id="btn-comfirm" type="button" class="btn btn-info btn-minier bigger">
							<i class="icon-search icon-on-right"></i>
							确定
						</button>
					</div> -->
				</div>
			</div>
			<div class="space-4"></div>
			<div id="grid-parent">
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var isEdit = false;
	$(function($) {
 		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/order/orderReferPi/searchOrderFcst'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//去掉编辑表分页按钮
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'zdsj', label:'zdsj', hidden: true, width:60},
				{name:'zc', label:'zc', hidden: true, width:60},
				{name:'ycs', label:'ycs', hidden: true, width:60},
			    <c:forEach items="${hbtitles}" var="t" varStatus="stat">
			    <c:if test="${t.flag==2}" >
				    {name:'${t.week}Ycs', index:'${t.week}Ycs', label:'未下单FCST', align: "right", width:70},
				    {name:'${t.week}Dds', index:'${t.week}Dds', label:'订单数量', align:'right',width:70}
				    <c:if test="${!stat.last}" >,</c:if>
			    </c:if>
			    </c:forEach>
			]
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit
		}); 
 		$(grid_selector).setCustomGroupHeaders({
 			useColSpanStyle: true,
 			groupHeaders:[
 			      		<c:forEach items="${hbtitles}" var="t" varStatus="stat">
 			      		<c:if test="${t.flag==1}" >
 			      	        {startColumnName:'${t.week}Ycs', numberOfColumns:'${t.colspan}', titleText: '${t.colname}'}<c:if test="${!stat.last}" >,</c:if>
 			      	    </c:if>
 			      	    </c:forEach>
 			] 
 		 }).setCustomGroupHeaders({
 			 useColSpanStyle: true,
 		     groupHeaders:[
 					<c:forEach items="${hbtitles}" var="t" varStatus="stat">
 						<c:if test="${t.flag==2}" >
 					      {startColumnName:'${t.week}Ycs', numberOfColumns:'${t.colspan}', titleText: '${t.colname}'}<c:if test="${!stat.last}" >,</c:if>
 					  </c:if>
 					  </c:forEach>
 		     ] 
 		 });
/* 		//确认
		$("#btn-comfirm").click(function(){
			var data = $(grid_selector).jqGrid("getRowData");
			if(data.length < 1){
				swal("该客户、型号尚未做过预测，需先在预测表录入预测数据！");
				//return;
				// 关闭当前窗口
				window.close();
				//上传确定，后的回调处理
				if(window.showModalDialog){//支持showModalDialog函数
					window.returnValue = data;
				}else{//新版chrome不支持showModalDialog函数
					if(window.openerCallBack && typeof(window.openerCallBack) === "function"){
						// 调用父窗口的方法
						window.openerCallBack(data);
					}
				}
			}else{
				// 关闭当前窗口
				window.close();
				//上传确定，后的回调处理
				if(window.showModalDialog){//支持showModalDialog函数
					window.returnValue = data;
				}else{//新版chrome不支持showModalDialog函数
					if(window.openerCallBack && typeof(window.openerCallBack) === "function"){
						// 调用父窗口的方法
						window.openerCallBack(data);
					}
				}
			}
	    });*/
	}); 
</script>
</html>