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
	<%
		String ddid = request.getParameter("ddid");
	%>
<body>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
				
			<div class="widget-box">
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
							<input type="hidden" name="ddid" value="<%=ddid%>"/> 
							<div class="row">
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PI号&nbsp;&nbsp;</label>
										<input type="text" name="piid" class="form-control smaller"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">公司&nbsp;&nbsp;</label>
									<select role="select" id="gsbm" name="gsbm" size="1" class="form-control skyselect">
										${fns:loadCompanyOption('0')}
									</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">我司型号&nbsp;&nbsp;</label>
										<input type="text" name="wlbh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">申请人&nbsp;&nbsp;</label>
										<input type="text" name="zdrmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
						</form>
						<div class="space-4"></div>
					</div>
				</div>
			</div>
			<h5 class="header blue" style="margin-top:4px;">PI信息</h5>
			<div class="space-4"></div>
			<div  id="grid-parent">
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
			</div>
			<div class="space-4"></div>
			<h5 class="header blue" style="margin-top:4px;">已选PI信息</h5>
			<div class="space-4"></div>
			<div id="grid-parent-bs">
				<table id="grid-table-bs"></table>
				<div id="grid-pager-bs"></div>
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
	var grid_selector_bs = "#grid-table-bs";
	var pager_selector_bs = "#grid-pager-bs";
	var isEdit = false;
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZgsj"),endElement:$("#endZgsj")});
 		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/order/orderReferPi/searchDiversity'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			rowList: [5, 10, 20],
			rowNum: 5,
			colModel: [     
				{name:'',index:'', label: '&nbsp', width:20, sortable:false, resize:false, 
					formatter:function(cellvalue, options, rowObject){
						return "<i style='cursor:pointer;' class='fa fa-plus fa-border green'></i>";
					}},
				{name:'id', label:'ID', hidden: true, width:60},
				/* {name:'scjd', index:'scjd', label:'生产基地', width:80, hidden:true},
				{name:'scjdmc', index:'scjdmc', label:'生产基地', width:80}, */
				{name:'piid', index:'piid', label:'PI号', width:80},
				{name:'piitemid', index:'piitemid', label:'PI明细ID', width:80, hidden:true},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:80},
				{name:'bz', index:'bz', label:'币种', width:80},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:60},
				{name:'model', index:'model', label:'我司型号', width:60},
				{name:'khxh', index:'khxh', label:'客户型号', width:60},
				{name:'khxhms', index:'khxhms', label:'描述',width:60},
				{name:'pisl', index:'pisl', label:'PI数量', width:60},
				{name:'yxdsl', index:'yxdsl', label:'已下单数量', width:60},
				{name:'spzsl', index:'spzsl', label:'审批中数量', width:60},
				<shiro:hasPermission name="order:orderDiversity:price">
				{name:'dj', index:'dj', label:'单价', width:60},
				</shiro:hasPermission>
				{name:'mfsl', index:'mfsl', label:'免费数量', width:60},
				{name:'sl', index:'sl', label:'数量', width:60, hidden:true},
				{name:'gsbm', index:'gsbm', label:'公司', width:60,hidden:true},				
				{name:'fktj', index:'fktj', label:'付款条件', width:80,hidden: true},
				{name:'fktjmc', index:'fktjmc', label:'付款条件名称', width:80,hidden: true},
				{name:'gjmytk', index:'gjmytk', label:'国际贸易条款', width:80, hidden:true},
				{name:'gjmytkmc', index:'gjmytkmc', label:'国际贸易条款', width:80, hidden:true},
				{name:'gjmytkbz', index:'gjmytkbz', label:'国际贸易条款备注', width:80 , hidden:true },
				{name:'xsyid', index:'xsyid', label:'销售员ID', width:80,hidden: true},
				{name:'xsymc', index:'xsymc', label:'销售员名称', width:80,hidden: true},
				{name:'xszz', index:'xszz', label:'销售组织', width:80,hidden: true},
				{name:'xszzmc', index:'xszzmc', label:'销售组织名称', width:80,hidden: true},
				{name:'ywz', index:'ywz', label:'业务组', width:80,hidden: true},
				{name:'ywzmc', index:'ywzmc', label:'业务组名称', width:80,hidden: true},
				{name:'zhfs', index:'zhfs', label:'走货方式', width:80,hidden: true},
				{name:'pilx', index:'pilx', label:'PI类型', width:80,hidden: true},
				{name:'sfBd', index:'sfBd', label:'是否白电', width:80,hidden: true}
			],
			onCellSelect: function(rowid,iCol,cellcontent,e){
				if(iCol == 1){
					var rowData = $(grid_selector).jqGrid('getRowData',rowid);
					var ids = $(grid_selector_bs).jqGrid("getDataIDs");
					var i =0 ;
					 $.each(ids, function(j, m){
						 if(m == rowData.id){
							 i+=1;
						 }
						});
					if(i > 0){
						alert(rowid+"已存在请勿重复添加!");
						return;
					}else{
						// 添加
						$(grid_selector_bs).jqGrid("addRowData", rowData.id, rowData);
						// 赋值
						$(grid_selector_bs).jqGrid('setCell',rowData.id,'xdsl',rowData.sl-rowData.yxdsl-rowData.spzsl); 
						// 编辑
						$(grid_selector_bs).jqGrid("editRow", rowData.id);
					}
				}
			}
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
		}); 
		$(grid_selector_bs).bindTable({
			caption: "",
			pager: pager_selector_bs,
			gridParent: "#grid-parent-bs",
			multiselect: true,
			shrinkToFit: false,
			autoScroll: false,
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60},
				/* {name:'scjd', index:'scjd', label:'生产基地', width:80, hidden:true},
				{name:'scjdmc', index:'scjdmc', label:'生产基地', width:80}, */
				{name:'piid', index:'piid', label:'PI号', width:80, editable:false},
				{name:'piitemid', index:'piitemid', label:'PI明细ID', width:80, hidden:true},
				{name:'khbm', index:'khbm', label:'客户编码', width:80, editable:false},
				{name:'khmc', index:'khmc', label:'客户名称', width:80, editable:false},
				{name:'bz', index:'bz', label:'币种', width:80, editable:false},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:60, editable:false},
				{name:'model', index:'model', label:'我司型号', width:60, editable:false},
				{name:'khxh', index:'khxh', label:'客户型号', width:60, editable:false},
				{name:'khxhms', index:'khxhms', label:'描述',width:60, editable:false},
				{name:'pisl', index:'pisl', label:'PI数量', width:60, editable:false},
				{name:'yxdsl', index:'yxdsl', label:'已下单数量', width:60, editable:false},
				{name:'spzsl', index:'spzsl', label:'审批中数量', width:60, editable:false},
				{name:'dj', index:'dj', label:'单价', width:60, editable:false},
				{name:'mfsl', index:'mfsl', label:'免费数量', width:60, editable:false},
				{name:'sl', index:'sl', label:'数量', width:60},
				{name:'je', index:'je', label:'金额', width:60},
				{name:'gsbm', index:'gsbm', label:'公司', width:60,hidden:true},				
				{name:'fktj', index:'fktj', label:'付款条件', width:80,hidden: true},
				{name:'fktjmc', index:'fktjmc', label:'付款条件名称', width:80,hidden: true},
				{name:'gjmytk', index:'gjmytk', label:'国际贸易条款', width:80, hidden:true},
				{name:'gjmytkmc', index:'gjmytkmc', label:'国际贸易条款', width:80, hidden:true},
				{name:'gjmytkbz', index:'gjmytkbz', label:'国际贸易条款备注', width:80 , hidden:true },
				{name:'xsyid', index:'xsyid', label:'销售员ID', width:80,hidden: true},
				{name:'xsymc', index:'xsymc', label:'销售员名称', width:80,hidden: true},
				{name:'xszz', index:'xszz', label:'销售组织', width:80,hidden: true},
				{name:'xszzmc', index:'xszzmc', label:'销售组织名称', width:80,hidden: true},
				{name:'ywz', index:'ywz', label:'业务组', width:80,hidden: true},
				{name:'ywzmc', index:'ywzmc', label:'业务组名称', width:80,hidden: true},
				{name:'zhfs', index:'zhfs', label:'走货方式', width:80,hidden: true},
				{name:'pilx', index:'pilx', label:'PI类型', width:80,hidden: true},
				{name:'sfBd', index:'sfBd', label:'是否白电', width:80,hidden: true}
			],
			editTable:true
		},{
			add:isEdit,
			del:true,
			view:isEdit,
			edit:isEdit,
			refresh:isEdit,
			delfunc:delfunc
		});
		$(grid_selector_bs).navButtonAdd(pager_selector_bs,{
			caption:"确认", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				piConfirm();
			},
			position:"last"
		});
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
			//$(grid_selector_bs).jqGrid("clearGridData");
	    });
		//敲击回车响应查询
		$("body").keypress(function (e) {
			var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if (keyCode == 13){
				$(grid_selector).trigger("reloadGrid");
			}
		}); 
		//PI确认
		function piConfirm(){
			 var obj = $(grid_selector_bs).jqGrid("getDataIDs");
			 var data = []
			 $.each(obj, function(index, id){
				 $(grid_selector_bs).jqGrid("saveRow",id);
				 var rowData = $(grid_selector_bs).jqGrid("getRowData", id);
				 rowData.je = rowData.dj*rowData.sl ;
				 data.push(rowData);
			}); 
			if(data.length <1 ){
				alert("PI信息确认不能为空！");
				
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
	    }
		// 删除
		function delfunc(){
			var selectedRowIds =$(grid_selector_bs).jqGrid("getGridParam","selarrrow"); 
			if(selectedRowIds==null||selectedRowIds==""){
				alert("请选择一行数据！");
				return;
			}else{ 
				var len = selectedRowIds.length;  
				for(var i = 0;i < len ;i ++) {  
				$(grid_selector_bs).jqGrid("delRowData", selectedRowIds[0]);  
				} 
			}
		}
	});
</script>
</html>