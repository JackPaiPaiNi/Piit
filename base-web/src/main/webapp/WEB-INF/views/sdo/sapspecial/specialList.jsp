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
							    <div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售组织&nbsp;&nbsp;</label>
										<input type="text" name="xszz" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售订单&nbsp;&nbsp;</label>
										<input type="text" name="xsdd" class="form-control"/>
									</div>
								</div>
							    <div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">提交时间&nbsp;&nbsp;</label>
										<input type="text" name="tjsj" class="form-control timeInterval"/>
										<input type="hidden" id="beginTjsj" name="beginZdsj"/>
										<input type="hidden" id="endTjsj" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('DJZT')}
										</select>
									</div>
								</div>
							   <div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">申请人&nbsp;&nbsp;</label>
										<input type="text" name="sqr" class="form-control"/>
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
	var searchurl = "<c:url value='/sapspecial/sapSpecialOrder/search'/>";
	var viewurl = "<c:url value='/sapspecial/sapSpecialOrder/viewPage'/>";
	var submiturl = "<c:url value='/sapspecial/sapSpecialOrder/submit'/>";
	
	var isEdit = false;
	<shiro:hasPermission name="sapspecial:sapSpecialOrder:edit">isEdit=true;</shiro:hasPermission>

	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		
		$(grid_selector).bindTable({
			url: searchurl,
			//editurl: "<c:url value='/sapspecial/sapSpecialOrder/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect: true,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			//shrinkToFit: false,
			colModel: [
				{name:'id', label:'ID', hidden: true},
				{name:'sjc', hidden: true},
				{name:'spcl', hidden: true},
				{name:'sffgs', hidden: true},
				{name:'processId', hidden: true},
				{name:'dept', index:'dept', hidden: true},
				{name:'xszz', index:'xszz', label:'销售组织', width:80},
				{name:'xsdd', index:'xsdd', label:'销售订单', width:80},
				{name:'sqr', index:'sqr', label:'申请人', width:80},
				{name:'sqrq', index:'sqrq', label:'申请日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'khmc', index:'khmc', label:'客户名称', width:80},
				{name:'ztmc', index:'ztmc', label:'单据状态', width:80},
				{name:'zt', hidden:true},
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
				tjsp();
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
		var id = $(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = $(grid_selector).jqGrid('getRowData',id);
		location.href = viewurl+ "?id=" + id + "&processId=" + rowData.processId;
	}	
	//推送SAP
	function tsSap(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		if(id==null || id==""){
			swal("","请选择一行数据！","warning");
		}else{
			var rowData = $(grid_selector).jqGrid('getRowData',id);
			if(rowData.zt != 4){
				swal("","只有审批通过的单据才能推送!","warning");
				return;
			}
			$.bindAjax({
				url:"<c:url value='/sapspecial/sapSpecialOrder/tsSap'/>",
				data:{id : id},
				action:"edit"
			},function(response){
				$(grid_selector).trigger("reloadGrid");
			});
		}
	}
	//提交审批
	function tjsp(){
		var flag = 1 ;
		var position;
		var data = [];
	    var rowids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
	    if(rowids.length == 0){
	    	swal("","请至少选择一条数据","warning")
	    }
	    if(rowids.length > 0){
    	   $.each(rowids,function(index,value){
    		   position = index+1 ;
		        var rowData = $(grid_selector).jqGrid("getRowData", value);
		        if(rowData.zt ==2 || rowData.zt ==5){
		        	flag = 0 ;
		        	return false ;
		        }
		        data.push(rowData) ;
		   });
	    }
	    if(flag ==0 ){
	    	swal("","选择的第"+position+"条数据:审批中或已生效的单据不能提交审批","warning");
	    	return  ;
	    }
	    var list = JSON.stringify(data);
	    $("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url: submiturl+ "?list="+list,
					data:list,
					action:"save",
				},function(response){
					$(grid_selector).trigger('reloadGrid');
				}); 
			}
		});
		
	}
</script>
</html>