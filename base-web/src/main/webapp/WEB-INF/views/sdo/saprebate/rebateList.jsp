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
										<label class="input-group-addon">公司&nbsp;&nbsp;</label>
										<input type="text" name="bukrs" class="form-control"/>
										<input name="deptCode" type="hidden" value="${sessionScope.user.deptCode}"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">单据类型&nbsp;&nbsp;</label>
										<select role="select" name="zdjlx" size="1" class="form-control skyselect">
											${fns:loadDictOption('SAP_DJLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">提交用户名&nbsp;&nbsp;</label>
										<input type="text" name="userid" class="form-control"/>
									</div>
								</div>
								 <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">提交时间&nbsp;&nbsp;</label>
										<input type="text" name="tjsj" class="form-control timeInterval"/>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">审批流水号&nbsp;&nbsp;</label>
										<input type="text" name="splsh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">返利申报号&nbsp;&nbsp;</label>
										<input type="text" name="flsbh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">返利政策号&nbsp;&nbsp;</label>
										<input type="text" name="flzch" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">单据状态&nbsp;&nbsp;</label>
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
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	var searchurl = "<c:url value='/rebate/rebate/search' />";
	var isEdit = false;
	<shiro:hasPermission name="rebate:rebate:view">isEdit=true;</shiro:hasPermission>

	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		
		$(grid_selector).bindTable({
			url: searchurl,
			//editurl: "<c:url value='/sapspecial/sapSpecialOrder/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			rowNum:20,
			multiselect: true,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			//shrinkToFit: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'sjc', label:'sjc', hidden: true, width:60, editable:false},
				{name:'sfFgs', index:'sfFgs',label:'是否分公司',hidden:true, width:60, editable:false},
				{name:'processId', index:'processId', hidden:true},
				{name:'taskId', index:'taskId', hidden:true},
				{name:'splsh', index:'splsh',label:'审批流水号', width:80},
				{name:'bukrs', index:'bukrs',label:'公司代码', width:40},
				{name:'gsmc', index:'gsmc', label:'公司名称', width:80},
				{name:'zdjlx', index:'zdjlx', label:'单据类型', width:40,editable:false, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('SAP_DJLX')}",dataInit: initSelect2}},
				{name:'userid', index:'userid', label:'提交用户名', width:80,},
				{name:'cpudt', index:'cpudt', label:'提交时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'ztmc', index:'ztmc', label:'状态', width:80},
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:105, formatter:tsSAPCellAddHref},
				{name:'zt', index:'zt', hidden:true},
				{name:'djlx',hidden:true},
				{name:'sjc',  hidden:true}
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:isEdit,
			viewfunc:viewfunc
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"提交审批", 
			buttonicon:"icon-edit", 
			onClickButton: function(){
				fqsp();
			}, position:"second" 
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"推送SAP", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				tsSap();
			},
			position:"last"
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/sapspecial/sapSpecialOrder/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	//查看
	function viewfunc(){
		var rowids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
		var id ="";
		var rowData = "";
		if(rowids.length == 0){
			swal("","请选择一条","warning");
			return;
		}else if(rowids.length == 1){
			var rowData = $(grid_selector).jqGrid("getRowData", rowids[0]);
			id = rowData.splsh ;
		}else{
			swal("","一次只能请选择一条单据查看","warning");
			return ;
		}
		//返利申报单
		if(rowData.zdjlx == 3){
			location.href = "<c:url value='/rebate/rebateApply/viewPage' />"
			+ "?id=" + id + "&processId=" + rowData.processId;
		}
		//返利费用申请
		if(rowData.zdjlx == 2){
			location.href =  "<c:url value='/rebate/expApply/viewPage' />"
			+ "?id=" + id+"&processId="+rowData.processId+"&taskId="+rowData.taskId;
		}
		//返利政策申请
		if(rowData.zdjlx == 1){
			location.href = "<c:url value='/rebate/rebatePolicy/viewPage' />"
			+ "?id=" + id + "&processId=" + rowData.processId;
		}
		
	}	
	//推送SAP
	function tsSap(){
		var  tsurl  = "";
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		if(id==null || id==""){
			swal("","请选择一行数据！","warning");
			return;
		}else{
			var rowData = $(grid_selector).jqGrid('getRowData',id);
			if(rowData.zt ==5){
				swal("","请选择未生效的数据推送SAP！","warning");
			    return ;
			}
			if(rowData.zt!=4 && rowData.zt!=3){
				swal("","审批未通过的数据不能推送SAP！","warning");
			    return ;
			}
			//返利申报单
			if(rowData.zdjlx == 3){
				tsurl= "<c:url value='/rebate/rebateApply/tsSap' />";
			}
			//返利费用申请
			if(rowData.zdjlx == 2){
				tsurl=  "<c:url value='/rebate/expApply/tsSap' />";
			}
			//返利政策申请
			if(rowData.zdjlx == 1){
				tsurl= "<c:url value='/rebate/rebatePolicy/tsSap' />";
			}
			$.bindAjax({
				url:tsurl,
				data:{id : id},
				action:"edit"
			},function(response){
				$(grid_selector).trigger("reloadGrid");
			});
		}
	}
	//提交审批
	function fqsp(){
		var flag = 1 ;
		var position;
		var data = [];
	    var rowids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
	    if(rowids.length == 0){
	    	swal("","请至少选择一条数据","warning");
	    	return;
	    }
	    if(rowids.length > 0){
    	   $.each(rowids,function(index,value){
    		   position = index+1 ;
		        var rowData = $(grid_selector).jqGrid("getRowData", value);
		        if(rowData.zt !=null && rowData.zt !=1){
		        	flag = 0 ;
		        	return false ;
		        }
		        data.push(rowData) ;
		   });
	    }
	    if(flag ==0 ){
	    	swal("","选择的第"+position+"条数据:请选择草稿提交审批","warning");
	    	return  ;
	    }
	    var list = JSON.stringify(data);
	    $("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/rebate/rebate/submit'/>",
					data:{list:list},
					action:"save",
				},function(response){
					$(grid_selector).trigger('reloadGrid');
				}); 
			}
		});
		
	}
	// 初始化编辑表select2
	function initSelect2(elem){
		$(elem).width("100%").addClass("skyselect").select2();
	}
	
	function tsSAPCellAddHref(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html = "已通过";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		} else if(cellvalue == "2"){
			html += "海外通过,制造失败</a>";
		} else if(cellvalue == "3"){
			html += "海外通过,制造不推</a>";
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
</script>
</html>