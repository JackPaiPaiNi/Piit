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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PID&nbsp;&nbsp;</label>
										<input type="text" name="pid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机芯&nbsp;&nbsp;</label>
										<input type="text" name="jixin" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机型&nbsp;&nbsp;</label>
										<input type="text" name="jixing" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('DJZT')}
										</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">品牌名称&nbsp;&nbsp;</label>
										<input type="text" name="pp" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">创建人&nbsp;&nbsp;</label>
										<input type="text" name="cjrmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否推送SAP状态&nbsp;&nbsp;</label>
										<select role="select" name="tssapzt" size="1" class="form-control skyselect">
											${fns:loadDictOption('SF')}
										</select>
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
	var changeurl = "<c:url value='/mdm/pidInfo/change'/>";
	var editurl = "<c:url value='/mdm/pidInfo/editPage'/>";
	var viewurl = "<c:url value='/mdm/pidInfo/viewPage'/>";
	var delurl = "<c:url value='/mdm/pidInfo/delete'/>";
	var isEdit = false;
	<shiro:hasPermission name="mdm:pidInfo:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".date-picker").bindDate();
		$(grid_selector).bindTable({
			url: "<c:url value='/mdm/pidInfo/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen : true},
				{name:'processId', label:'processId', hidden: true,width:60, editable:false, frozen : true},
				{name:'taskId', label:'taskId', hidden: true, width:60, editable:false, frozen : true},
				{name:'sjc', label:'sjc', hidden: true, width:60, editable:false, frozen : true},
				{name:'zt',lable:'zt',hidden: true, width:60, editable:false, frozen : true},
				{name:'ztmc',index:'ztmc',label:'状态',width:80},
				{name:'pid', index:'pid', label:'PID', width:140},
				{name:'khbm', index:'khbm', label:'客户编码', width:100},
				{name:'khmc', index:'khmc', label:'客户名称', width:140},
				{name:'pp', index:'pp', label:'品牌', width:80},
				{name:'jixin', index:'jixin', label:'机芯', width:80},
				{name:'jixing', index:'jixing', label:'机型', width:80},
				{name:'cc', index:'cc', label:'尺寸', width:40, align:'right'},
				{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80},
				{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:100},
				{name:'cpflmc', index:'cpflmc', label:'产品分类', width:80},
				{name:'ggmxmc', index:'ggmxmc', label:'规格明细', width:80},
				{name:'cpxl', index:'cpxl', label:'产品系列', width:80},
				{name:'pbh', index:'pbh', label:'屏编号', width:100},
				{name:'fbl', index:'fbl', label:'分辨率', width:60},
				{name:'wkysbz', index:'wkysbz', label:'外壳颜色标准', width:100},
				{name:'wlmc', index:'wlmc', label:'网络', width:110},
				{name:'jgfsmc', index:'jgfsmc', label:'加工方式', width:80},
				{name:'pidxh', index:'pidxh', label:'PID流水号', width:110},
				{name:'jhwcsj', index:'jhwcsj', label:'计划完成时间', width:90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'chyqwcsj', index:'chyqwcsj', label:'出货要求完成时间', width:110, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'zdrmc', index:'zdrmc', label:'创建人名称', width:80},
				{name:'cjsj', index:'cjsj', label:'创建时间', width:90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:90, formatter:tsSAPCellAddHref}
			],
			sortname: 'cjsj',
			sortorder: 'desc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
			addfunc:addfunc,
			editfunc:editfunc,
			delfunc: delfunc,
			viewfunc:viewfunc
		}).jqGrid('setFrozenColumns');
		
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"变更", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5){
						swal("","请选择一行已生效数据！","warning");
						return;
					} else {
						$("body").bindSweetAlert({
							title:"确定要变更吗?"
						},{
							callback:function(){
								$.bindAjax({
									url:changeurl,
									data:{id:id, sjc:rowData.sjc},
									action:"edit"
								},function(response){
									$(grid_selector).trigger("reloadGrid");
								});
							}
						});
					}
				}
			},
			position:"last"
		});
		
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"推送SAP", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(!((rowData.zt ==4 || rowData.zt ==5) && rowData.tssapzt != "已通过" )){
						swal("","请选择一行审批通过或已生效且未推送SAP状态的数据！","warning");
						return;
					}
					$("body").bindSweetAlert({
						title:"确定要推送吗?"
					},{
						callback:function(){
							$.bindAjax({
								url:"<c:url value='/mdm/pidInfo/pushSAP'/>",
								data:{id:id, sjc:rowData.sjc,pid:rowData.pid},
								action:"edit"
							},function(response){
								$(grid_selector).trigger("reloadGrid");
							});
						}
					});
					
				}
			},
			position:"last"
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/mdm/pidInfo/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	
	//查看推送SAP日志
	function tsSAPCellAddHref(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html += "已通过</a>";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		} else {
			html = "";
		}
		return html;
	}
	
	function tssapCellShowLog(id){
		$.bindAjax({
			url:"<c:url value='/log/sapInterfaceLog/search'/>",
			data:{id:id},
			action:"search"
		},function(response){
			if(response[0]){
				bootbox.dialog({
					title : "推送SAP日志",
					message : response[0].fhxx
				});
			}
		});
	}
	
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (zt != 1 && zt !=3) {
				swal("", "只能删除草稿或驳回的单据!", "warning");
				return;
			}else{ 
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?",
	    			closeOnConfirm: true
	    		},{
	    		callback:function(){
    				$.bindAjax({
    					url:delurl,
    					data:{id : rowData.id, sjc : rowData.sjc, zt : rowData.zt, processId : rowData.processId},
    					action:"edit"
    				},function(response){
    					$(grid_selector).trigger("reloadGrid");
    				}); 
    			}
	    		});
			} 
		}
	}
	
	//新增
	function addfunc(){
		location.href = editurl;
	}
	
	//编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if (zt == 2) {
			swal("", "该申请正在审批中,不能修改！", "warning");
			return;
		}else if(zt == 3){
			swal("", "驳回的单据,请在代办页面进入编辑！", "warning");
			return;
		}else if (zt == 4 || zt == 5) {
			swal("", "该申请已生效,不能修改！", "warning");
			return;
		} else {
			location.href = editurl + "?id=" + selr;
		}
	}
	
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		//location.href = viewurl + "?id=" + id + "&processId=" + rowData.processId;
		window.open(viewurl + "?id=" + id + "&processId=" + rowData.processId);
	}
</script>
</html>