<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%@include file="/WEB-INF/views/index/lfs.jsp" %>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div id="grid-parent" class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
				
			<div id="search-box"  class="widget-box">
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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
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
										<label class="input-group-addon">美工确认状态&nbsp;&nbsp;</label>
										<select role="select" name="mgqrzt" size="1" class="form-control skyselect ">
											${fns:loadDictOption('DDZGDZT')}
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
			<table id="grid-table-art"></table>
			<div id="grid-pager-art"></div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	
	var grid_selector_art = "#grid-table-art";
	var pager_selector_art = "#grid-pager-art";
	
	var form_search = "#form-search";
	var isEdit = false;
	<shiro:hasPermission name="track:trackValidationArt:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$('.skyselect').select2();
		$("#xdrq").bindDateRange({startElement:$("#beginXd"),endElement:$("#endXd")});
		
		//主信息表
		$(grid_selector).bindTable({
			//美工确认只取大货订单数据
			url: "<c:url value='/track/trackInfo/search'/>?ddlx=1",
			editurl: "<c:url value='/track/trackValidationArt/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			rowNum:5,
			//multiselect: true,
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true},
				{name:'zbid', label:'zbid', hidden: true},
				{name:'ddid', index:'ddid', label:'订单号', width:80,editoptions:{readonly:"true"}},
				{name:'mgqrzt', index:'mgqrzt', label:'美工确认状态',width:40,editoptions:{readonly:"true"}},
				{name:'khbm', index:'khbm', label:'客户编码',width:80,editoptions:{readonly:"true"}},
				{name:'khmc', index:'khmc', label:'客户名称',width:80,editoptions:{readonly:"true"}},
				{name:'pid', index:'pid', label:'PID',width:80,editoptions:{readonly:"true"}}
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
		
		//美工信息确认明细表
		$(grid_selector_art).bindTable({
			pager: pager_selector_art,
			gridParent: "#grid-parent",
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			colModel: [
				{name:'id', label:'ID', hidden: true},
				{name:'ddid', index:'ddid', label:'订单号', width:40,editoptions:{readonly:"true"}},
				{name:'mgzl', index:'mgzl', label:'美工资料名称',width:40,editoptions:{readonly:"true"}},
				{name:'fjBtn', label:'上传', width:20, edittype:"button", 
					editoptions:{value: "上传", class:"btn btn-success btn-minier",dataInit: initFjBtn}},
				{name:'qrfj', index:'qrfj', label:'美工资料附件',width:80,editoptions:{readonly:"true"}},
				{name:'bzxx', index:'bzxx', label:'备注信息',width:120}
			],
			editTable:true
		},{
			add:false,
			edit:false,
			del:false
		});
		
		$(grid_selector_art).navButtonAdd(pager_selector_art,{
			caption:"保存", 
			buttonicon:"icon-save", 
			onClickButton: function(){
				saveArtMatel();
			},
			position:"last"
		});
		
	});
	
	//保存延误原因
	function saveArtMatel(){
		var  param = {} ;
		//结束编辑
	    var lastEdit = $(grid_selector_art).data('lastEdit');
		if(lastEdit){
			$(grid_selector_art).saveRow(lastEdit, false, 'clientArray');
		}
		//拿到表格数据
		var data = $(grid_selector_art).getRowData();
		if(data.length == 0){
			swal("","没有需要保存的数据","warning");
			return ;
		}
		param.artList = JSON.stringify(data);
		//提交后台
		$("#save").bindSweetAlert({
			title:"保存之后会覆盖历史记录,确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/track/trackValidationArt/saveArtMatel'/>",
					data:param,
					action:"save"
				},function(response){
					  $(grid_selector_art).removeData('lastEdit');
					  request(data[0].ddid);
				}); 
			}
		});
	}
	
	//根据订单id查询美工资料
	function request(ddid){
	    $.ajax({
		     type: 'POST',
		     url: "<c:url value='/track/trackValidationArt/selectByDdid' />",
		     data: {ddid:ddid},
		     success: function(response){
		    	 $(grid_selector_art).jqGrid('clearGridData');
		    	 $(grid_selector_art).jqGrid("addRowData", null, response, "last");
		     } 
		}); 
	}
	
	//上传控件初始化
	function initFjBtn(elem){
		$(elem).click(function(){
			$.uploadDialog({
				auto : true
			},{
				callback:function(data){
					if(data){
						//给编辑表不可编辑字段赋值
						$(elem).closest("tr.jqgrow").find("td[aria-describedby$='_qrfj']").html(data.url);
					}
				}
			});
		});
	}
	
	//select样式
	function initSelect2(elem){
		$(elem).width(140).select2();
	}
</script>
</html>