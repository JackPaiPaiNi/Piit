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
							<input type="hidden" name="sfczywjd" value="是"/>
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
										<label class="input-group-addon">延误节点&nbsp;&nbsp;</label>
										<select role="select" name="ywjd" size="1" class="form-control skyselect ">
											${fns:loadDictOption('YWJD')}
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
			<table id="grid-table-delay"></table>
			<div id="grid-pager-delay"></div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	
	var grid_selector_delay = "#grid-table-delay";
	var pager_selector_delay = "#grid-pager-delay";
	
	var form_search = "#form-search";
	var isEdit = false;
	<shiro:hasPermission name="track:trackDelay:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$('#xdrq').bindDateRange({startElement:$("#beginXd"),endElement:$("#endXd")});
		$('.skyselect').select2();
		
		//主信息表
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/track/trackInfo/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true},
				{name:'ddId', label:'ddId', hidden: true},
				{name:'ddid', index:'ddid', label:'订单号', width:80},
				{name:'ddztzt', index:'ddztzt', label:'订单整体状态', width:80},
				{name:'khbm', index:'khbm', label:'客户编码',width:80},
				{name:'khbm', index:'khbm', label:'客户编码',width:80},
				{name:'khmc', index:'khmc', label:'客户名称',width:80}
			],
			ondblClickRow : function(rowid) {
				 var rowData = $(grid_selector).jqGrid("getRowData", rowid);
				 request(rowData.ddid);
			}
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		//延误原因明细表
		$(grid_selector_delay).bindTable({
			pager: pager_selector_delay,
			gridParent: "#grid-parent",
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			colModel: [
                {name:'id',index:"id",label:'ID', hidden:true},
				{name:'ddid', index:'ddid', label:'订单号', width:80,editoptions:{readonly:true}},
				{name:'khbm', index:'khbm', label:'客户编码',width:80,editoptions:{readonly:true}},
				{name:'khmc', index:'khmc', label:'客户名称',width:80,editoptions:{readonly:true}},
				{name:'ywjd', index:'ywjd', label:'延误节点',hidden:true},
				{name:'ywjdmc',index:'ywjdmc', label:'延误节点名称',width:80,editoptions:{readonly:true}},
				{name:'ywyy', index:'ywyy', label:'延误原因',width:120,},
			],
			editTable:true
		},{
			add:false,
			edit:false,
			del:false
		});
		
		$(grid_selector_delay).navButtonAdd(pager_selector_delay,{
			caption:"保存", 
			buttonicon:"icon-save", 
			onClickButton: function(){
				saveDelayReasons();
			},
			position:"last"
		});
		
		
		
		
		//导出选中的订单信息
		$("#export").click(function(){
			var data = $(grid_selector_delay).jqGrid("getRowData");
	    	var list = JSON.stringify(data);
		    if(data.length == 0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){                                       
	    				$(grid_selector_delay).exportExcel({url: encodeURI("<c:url value='/track/trackDelay/export'/>"), 
	    					params:{list : list}});
	    		    }
	    		});
	        }
		});
		
		
		
		
		//导入控件绑定
		$('#import').click(function(){
			$.importDialog({
				title:"选择文件",
				url:"<c:url value='/track/trackDelay/import'/>"
			},{
				callback:function(result){
					$(grid_selector_delay).jqGrid('clearGridData');
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		
	});
	
	//保存延误原因
	function saveDelayReasons(){
		var param = {};
		//结束编辑
		var lastEdit = $(grid_selector_delay).data('lastEdit');
		if(lastEdit){
			$(grid_selector_delay).saveRow(lastEdit, false, 'clientArray');
		}
		//拿到表格数据
		var data = $(grid_selector_delay).getRowData();
		if(data.length == 0){
			swal("","没有需要保存的数据！","warning");
			return ;
		}
		param.reasonList = JSON.stringify(data);
		//提交后台
		$("body").bindSweetAlert({
			title:"保存之后会覆盖历史记录,确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/track/trackDelay/saveDelayReasons'/>",
					data:param,
					action:"save"
				} ,function(response){
					 $(grid_selector_delay).removeData('lastEdit');
					 request(data[0].ddid);
				}); 
			}
		});
	}
	
	//根据订单id查询此订单节点延误明细
	function request(ddid){
	    $.ajax({
		     type: 'POST',
		     url: "<c:url value='/track/trackDelay/selectByDdid' />",
		     data: {ddid:ddid},
		     success: function(response){
		    	 $(grid_selector_delay).jqGrid('clearGridData');
		    	 $(grid_selector_delay).jqGrid("addRowData", null, response, "last");
		     } 
		}); 
	}
	
/* 	//select样式
	function initSelect2(elem){
		$(elem).width("100%").select2();
	} */
	
</script>
</html>