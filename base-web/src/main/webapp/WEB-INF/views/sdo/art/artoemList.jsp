<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>
<%@page import="com.ey.piit.core.utils.UserUtils"%>  

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div  id="grid-parent" class="col-xs-12">
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
										<label class="input-group-addon">任务单号&nbsp;&nbsp;</label>
										<input type="text" name="rwdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PID&nbsp;&nbsp;</label>
										<input type="text" name="pid" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">品牌&nbsp;&nbsp;</label>
										<input type="text" name="khpp" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否模板标识&nbsp;&nbsp;</label>
										<select role="select" name="mbbs" size="1" class="form-control skyselect">								
											${fns:loadDictOption('SF')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否有美工组件号&nbsp;&nbsp;</label>
										<select role="select" name="sfmgzjh" size="1" class="form-control skyselect">								
											${fns:loadDictOption('SF')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单日期&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">								
											${fns:loadDictOption('DJZT')}
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
<div id="consoleDlg" class="page-content" >
  <div id="formContainer" class="row">
     <div class="col-xs-12">
      	<form id="consoleForm">
      	     <input type="hidden"  name="id"  />
      	     <input type="hidden"  name="sjc"  />
      	     <input type="hidden"  name="rwdh"  />
	      	 <div class="row">
				<div class="col-xs-12 col-sm-12">
					<div class="input-group input-group-sm">
						<label class="input-group-addon">美工组件号&nbsp;&nbsp;</label> 
						<input type="text" name="mgzjh" class="form-control"   />
					</div>
				</div>
			 </div>
	      	 <div class="space-4"></div>
	      	 <div class="row">
				<div class="col-xs-12 col-sm-12">
					<div class="input-group input-group-sm">
						<label class="input-group-addon">模板标识&nbsp;&nbsp;</label> 
						<select role="select" name="mbbs" size="1" class="form-control skyselect">								
							${fns:loadDictOption('SF')}
						</select>
					</div>
				</div>
			</div>
	      	 <div class="space-4"></div>
	      	 <div class="row">
	      	 	 <div class="col-xs-12 col-sm-12" align="center">
					<button id="btn-ok" type="button" class="btn btn-info  btn-minier bigger">
						<i class="icon-ok icon-on-left bigger-110"></i>
						确定
					</button> 
					&nbsp;&nbsp;&nbsp;
				    <button id="btn-cancel" type="button" class="btn btn-danger btn-minier bigger">
						 <i class="fa-times icon-on-right bigger-110"></i>
						取消
					</button> 
				</div>
	      	 </div>
    	</form>
     </div>
   </div>
</div>
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var grid_selector_dcxx = "#grid-table";
	var editurl="<c:url value='/art/oem/editPage'/>";
	var viewurl ="<c:url value='/art/oem/viewPage'/>";
	var getbackurl = "<c:url value='/art/oem/getback'/>";
	var cancelurl = "<c:url value='/art/oem/cancel'/>";
	var changeurl = "<c:url value='/art/oem/change'/>";
	var isEdit = false;
	<shiro:hasPermission name="art:oem:edit">isEdit=true;</shiro:hasPermission>
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		// 配置模态对话框
		$("#consoleDlg").dialog({
			autoOpen : false, // 是否自动弹出窗口
			modal : true, // 设置为模态对话框
			resizable : true,
			width : 400,
			height : 150,
			position : "center" // 窗口显示的位置
		}); 
 		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/art/oem/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			sortname:'zdsj',
			sortorder:'desc',
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, frozen:true},
				{name:'sjc', label:'SJC', hidden: true, width:60, frozen:true},
				{name:'processId', label:'processId', hidden: true, width:60, frozen:true},
				{name:'taskId', label:'taskId', hidden: true, width:60, frozen:true},
				{name:'zt', index:'zt', label:'订单状态', width:80, hidden : true, frozen:true},
				{name:'ztmc', index:'ztmc', label:'订单状态', width:80, frozen:true},
				{name : 'rwdh', index :  'rwdh', label :  '任务单号',  width : 230, frozen:true},
				{name : 'pid', index :  'pid', label :  'PID',  width : 180, frozen:true},
				{name : 'wkysbz', index :  'wkysbz', label :  '产品颜色标准',  width : 90, frozen:true},
				{name : 'zhfs', index :  'zhfs', label :  '走货方式',  width : 80, hidden : true, frozen:true},
				{name : 'zhfsmc', index :  'zhfsmc', label :  '走货方式',  width : 100, frozen:true},
				{name : 'khpp', index :  'khpp', label :  '品牌',  width : 80, frozen:true},
				{name : 'xsymc', index :  'xsymcs', label :  '销售员',  width : 80},
				{name : 'xwgj', index :  'xwgj', label :  '销往国家',  width : 80, hidden : true},
				{name : 'xwgjmc', index :  'xwgjmc', label :  '销往国家',  width : 80},
				{name : 'jixing', index :  'jixing', label :  '机型',  width : 80,},
				{name : 'jixin', index :  'jixin', label :  '机芯',  width : 80},
				{name:'bbh', index:'bbh', label:'版本号',width:60},
				{name:'sfBg', index:'sfBg', label:'是否变更', width:80, hidden : true},
				{name:'zdrmc', index:'zdrmc', label:'制单人', width:80},
				{name:'zdsj', index:'zdsj', label:'制单日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d H:i:s'}},
				{name:'mbbs', index:'mbbs', label:'模板标识', width:70, edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
				{name:'mgzjh', index:'mgzjh', label:'美工组件号', width:220}
			]
		},{
			add:isEdit,
			edit:isEdit,
			view:isEdit,
			del:isEdit,
			addfunc:addfunc,
			editfunc:editfunc,
			viewfunc:viewfunc,
			delfunc:delfunc
		}); 
 		<shiro:hasPermission name="art:oem:edit">
 		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"复制", 
			buttonicon:"fa-pencil-square purple", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					location.href = editurl + "?id=" + id + "&sfFz=1";
				}
			},
			position:"last"
		});
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
			caption:"取回", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt == 2 || rowData.zt == 4 || rowData.zt == 3){
						$("body").bindSweetAlert({
							title:"确定要取回吗?"
						},{
							callback:function(){
								$.bindAjax({
									url:getbackurl,
									data:{id:id, sjc:rowData.sjc, processId:rowData.processId},
									action:"edit"
								},function(response){
									$(grid_selector).trigger("reloadGrid");
								});
							}
						});
						
					} else{
						swal("","请选择一行审批中或审批通过的单据！","warning");
					}
				}
			},
			position:"last"
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"取消", 
			buttonicon:"fa-square-o orange", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5){
						swal("","请选择一行已生效数据！","warning");
					} else{
						$("body").bindSweetAlert({
							title:"确定要取消吗?"
						},{
							callback:function(){
								$.bindAjax({
									url:cancelurl,
									data:{id:id, sjc:rowData.sjc, rwdh:rowData.rwdh},
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
		</shiro:hasPermission>
		
 		<shiro:hasPermission name="art:oem:bc">
 		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"补充", 
			buttonicon:"fa-pencil-square green",
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5){
						swal("","请选择一行已生效数据！","warning");
						return;
					} 
					initDlg(rowData);
				}
			},
			position:"last"
		});
 		</shiro:hasPermission>
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		//回车键响应
		$("body").keypress(function (e) {
			var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if (keyCode == 13){
				$(grid_selector).trigger("reloadGrid");
			}
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/art/oem/export'/>"});
	    			}
	    		});
	        }
		});
		
		$("#btn-ok").click(function(){
			btn_ok();
	    });
		
		$("#btn-cancel").click(function(){
			btn_cancel();
	    });
	});
	// 新增
	function addfunc() {
		location.href = "<c:url value='/art/oem/editPage'/>";
	}
	
	// 编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if(zt == 1){
				location.href = editurl + "?id=" + selr + "&sfBg=" + rowData.sfBg;
			}else if (zt == 3){
				swal("","驳回的单据请从待办页面进行编辑","warning");
				return;
			}else {
				swal("","只有草稿单据才可编辑","warning");
				return;
			}
		}
	}
	// 删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		var processId = rowData.processId;
		if(selr==null||selr==""){
			swal("","请选择一条记录！","warning");
			return;
		}else{
			if (zt != 1 && zt != 3) {
				swal("", "只能删除草稿或驳回的单据!", "warning");
				return;
			} else {
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?"
	    		},{
	    			callback:function(){
	    				$.bindAjax({
	    					url:"<c:url value='/art/oem/delete'/>",
	    					data:{id:rowData.id,sjc :rowData.sjc, zt: zt, processId: processId},
	    					action:"edit"
	    				},function(response){
	    					$(grid_selector).trigger("reloadGrid");
	    				}); 
	    			}
	    		});
			}
		}
	}
	// 查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		window.open(viewurl + "?id=" + id + "&processId=" + rowData.processId + "&sfBg=" + rowData.sfBg+ "&sfView=1");
	}
	 
	//初始化对话框数据
	function initDlg(rowData){
		$('#consoleDlg [name=id]').val(rowData.id);
		$('#consoleDlg [name=sjc]').val(rowData.sjc);
		$('#consoleDlg [name=rwdh]').val(rowData.rwdh);
		$('#consoleDlg [name=mgzjh]').val(rowData.mgzjh);
		$('#consoleDlg [name=mbbs]').select2("val",rowData.mbbs);
		$("#consoleDlg").dialog("option", "title", "补充").dialog("open");
	}
	
	//取消
    function btn_cancel(){
    	$("#consoleDlg input").attr("value","");
    	$("#consoleDlg").dialog("close");
	}
	
	//确定
	function btn_ok(){
		var param = $("#consoleForm").getFormData();
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		}, {
			callback : function() {
				 $.bindAjax({
						url:"<c:url value='/art/oem/bc'/>",
						data:param,
						action:"save"
					},function(response){
						btn_cancel(); 
						$(grid_selector).trigger("reloadGrid");
					}); 
			}
	   }); 
	}
</script>
</html>