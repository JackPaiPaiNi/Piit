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
						&nbsp;
						<button id="btn-tbkhxx" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							同步
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
													<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户简称&nbsp;&nbsp;</label>
										<input type="text" name="khjc" class="form-control"/>
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
	<shiro:hasPermission name="mdm:customerInfo:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/mdm/customerInfo/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', width:60, hidden: true, editable:false, formoptions:{rowpos: 1, colpos: 1}, frozen : true},
				{name:'khbm', index:'khbm', label:'客户编码', width:80, formoptions:{rowpos: 2, colpos: 1}, frozen : true},
				{name:'khmc', index:'khmc', label:'客户名称', width:150, formoptions:{rowpos: 2, colpos: 2}, frozen : true},
				{name:'khjc', index:'khjc', label:'客户简称', width:80, formoptions:{rowpos: 2, colpos: 3}},
				{name:'khlx', index:'khlx', label:'客户类型', width:80,formoptions:{rowpos: 3, colpos: 1},frozen : true,
			    	 edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('KHLX')}",dataInit: initSelect2}},
				{name:'pp', index:'pp', label:'品牌', width:80, formoptions:{rowpos: 3, colpos: 2}},
				{name:'fktj', index:'fktj', label:'付款条件', width:80, formoptions:{rowpos: 3, colpos: 3}},
				{name:'zxbmfdm', index:'zxbmfdm', label:'中信保买方代码', width:120, formoptions:{rowpos: 4, colpos: 1}},
				{name:'xsyid', index:'xsyid', label:'销售员', width:80, formoptions:{rowpos: 4, colpos: 2}},
				{name:'xsymc', index:'xsymc', label:'销售员名称', width:80, formoptions:{rowpos: 4, colpos: 3}},
				{name:'bz', index:'bz', label:'币种', width:80, formoptions:{rowpos: 5, colpos: 1}},
				{name:'dh', index:'dh', label:'电话', width:80, formoptions:{rowpos: 5, colpos: 2}},
				{name:'lxr', index:'lxr', label:'联系人', width:80, formoptions:{rowpos: 5, colpos: 3}},
				{name:'sjh', index:'sjh', label:'手机号', width:80, formoptions:{rowpos: 6, colpos: 1}},
				{name:'wz', index:'wz', label:'网址', width:80, formoptions:{rowpos: 6, colpos: 2}},
				{name:'yx', index:'yx', label:'邮箱', width:80, formoptions:{rowpos: 6, colpos: 3}},
				{name:'skype', index:'skype', label:'Skype', width:80, formoptions:{rowpos: 7, colpos: 1}},
				{name:'whatapp', index:'whatapp', label:'Whatapp', width:80, formoptions:{rowpos: 7, colpos: 2}},
				{name:'xwgj', index:'xwgj', label:'销往国家编码', width:80, formoptions:{rowpos: 7, colpos: 3}},
				{name:'xwgjmc', index:'xwgjmc', label:'销往国家名称', width:80, formoptions:{rowpos: 8, colpos: 1}},
				{name:'glkhbm', index:'glkhbm', label:'关联客户编码', width:80, formoptions:{rowpos: 8, colpos: 2}},
				{name:'bzxx', index:'bzxx', label:'备注', width:80, formoptions:{rowpos: 8, colpos: 3}},
				{name:'dz', index:'dz', label:'地址', width:80, formoptions:{rowpos: 9, colpos: 1}},
			    {name:'zt', hidden :true}
			],
			sortname: 'khbm',
			sortorder: 'asc'
		},{
			add:false,
			edit:false,
			del:false,
			view:true
		}).jqGrid('setFrozenColumns');	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		//导出
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/customerInfo/export'/>"});
	    			}
	    		});
	        }
		});
		//同步客户信息
		$("#btn-tbkhxx").click(function(){
        	$("body").bindSweetAlert({
    			title:"确定要同步吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$.bindAjax({
						url:"<c:url value='/mdm/customerInfo/tbkhxx'/>",
						action:"edit"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
    			}
    		});
		});
	});
	function initSelect2(elem){
		$(elem).width(140).select2();
	}
</script>
</html>