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
								<i class="icon-search icon-on-right"></i> 查询
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
							<!-- <input type="hidden" name="rjqrzt" value="未完成"/> -->
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PID&nbsp;&nbsp;</label>
										<input type="text" name="pid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">下单日期&nbsp;&nbsp;</label>
										<input type="hidden" id="beginXd" name="beginXd"/>
										<input type="hidden" id="endXd" name="endXd"/>
										<input type="text" id="xdrq" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否确认&nbsp;&nbsp;</label>
										<select role="select" name="sfqr" size="1" class="form-control skyselect ">
											${fns:loadDictOption('SF')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">软件是否存在问题&nbsp;&nbsp;</label>
										<select role="select" name="rjsfczwtd" size="1" class="form-control skyselect ">
											${fns:loadDictOption('SF')}
										</select>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="space-4"></div>
			<div class="row">
			  <div class="col-xs-12 col-sm-6">
				  <button id="import" type="button" class="btn btn-info btn-sm">
						<i class="icon-upload-alt icon-on-right bigger-110"></i>
						导入
				  </button>
	         </div>
		    </div>
		    <div class="space-4"></div>
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
	<shiro:hasPermission name="track:trackValidation:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$("#xdrq").bindDateRange({startElement:$("#beginXd"),endElement:$("#endXd")});
		$('.skyselect').select2();
		$(grid_selector).bindTable({
			url: "<c:url value='/track/trackInfo/search'/>",
			editurl: "<c:url value='/track/trackValidation/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			multiselect: true,
			editTable:true ,
			formSearch: "#form-search",
			//shrinkToFit: false,
			// autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, editable:false, formoptions:{rowpos: 1, colpos: 1}},
				{name:'qrlx', label:'确认类型', hidden:true, editoptions:{dataInit: function(elem){$(elem).val("0")}},
					formoptions:{rowpos: 1, colpos: 2}},
				{name:'ddid', index:'ddid', label:'订单号', width:80, 
				  	editoptions:{readonly:"true"},formoptions:{rowpos: 2, colpos: 1}},
				{name:'khbm', index:'khbm', label:'客户编码', width:80,
					editoptions:{readonly:"true"},formoptions:{rowpos: 2, colpos: 2}},
				{name:'khmc', index:'khmc', label:'客户名称', width:80,
				  	editoptions:{readonly:"true"},formoptions:{rowpos: 2, colpos: 3}},
				{name:'pid', index:'pid', label:'PID', width:80, 
				  	editoptions:{readonly:"true"},formoptions:{rowpos: 3, colpos: 1}},
				{name:'rjqrsj', index:'rjqrsj', label:'软件确认时间', width:80, formatter:'date',
					editoptions:{dataInit:innitTime}, formatoptions:{newformat:'Y-m-d'},
					formoptions:{rowpos: 3, colpos: 2}},
				{name:'rjzywtd', index:'rjzywtd', label:'软件主要问题点', width:80,formoptions:{rowpos: 3, colpos: 3}},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:80,formoptions:{rowpos: 4, colpos: 1}}
			]
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"保存", 
			buttonicon:"icon-save", 
			onClickButton: function(){
				save();
			},
			position:"last"
		});
	
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		//导出选中的订单信息
		$("#export").click(function(){
			var lastEdit = $(grid_selector).data('lastEdit');
			if(lastEdit){
				$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			}
			$(grid_selector).removeData('lastEdit');
		    var data = [];
		    var ddlist = "";
		    var rowids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
		    if(rowids.length > 0){
	    	   $.each(rowids,function(index,value){
			        var rowData = $(grid_selector).jqGrid("getRowData", value);
			        rowData.rjqrsj = null;
			        data.push(rowData) ;
			   });
	    	   ddlist = JSON.stringify(data);
		    }
		    if(data.length == 0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: encodeURI("<c:url value='/track/trackValidation/softwareExport'/>"), 
	    					params:{ddList : ddlist}});
	    		    }
	    		});
	        }
		});
		
		// 导入控件绑定
		$('#import').click(function(){
			$.importDialog({
				title:"选择文件",
				url:"<c:url value='/track/trackValidation/softwareImport'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger('reloadGrid');
				}
			});
		});
		
	});
	
	//保存
	function save(){
		//结束编辑
		var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
		}
		var data = [];
		var rowids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
		if(rowids.length == 0 ){
			swal("","请至少勾选一条你要修改的数据","warning") ;
			return  ;
		}
		if(rowids.length > 0){
	      $.each(rowids,function(index,rowid){
			   var rowData = $(grid_selector).jqGrid("getRowData", rowid);
			   data.push(rowData) ;
		  });
		}
		var  param = {} ;
		param.list = JSON.stringify(data);
		//提交后台
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/track/trackValidation/edit'/>",
					data:param,
					action:"save"
				} ,function(response){
					  $(grid_selector).removeData('lastEdit');
				} ); 
			}
		});
	}
	
	function innitTime(elem){
		$(elem).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
	}
</script>
</html>