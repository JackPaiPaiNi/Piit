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
							<input type="hidden" name="zt" value="2">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">认领单号&nbsp;&nbsp;</label>
										<input type="text" name="rldh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款单号&nbsp;&nbsp;</label>
										<input type="text" name="skdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款类型&nbsp;&nbsp;</label>		
										<select role="select" name="sklx" size="1" class="form-control skyselect">
											
											${fns:loadDictOption('SKLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
										<input type="text" name="fph" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">LC编号&nbsp;&nbsp;</label>
										<input type="text" name="lcbh" class="form-control"/>
									</div>
								</div>
								 <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								   </div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">认领时间&nbsp;&nbsp;</label>
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
					</div>
				</div>
			</div>
			
			<table id="grid-table"></table>	
			<div id="grid-pager"></div>
			<div class="space-4"></div>
			<form id="form-submit" class="form-search">
				<div class="row">
					<input type="hidden" name="token" value="${token}" />
					<div class="col-xs-6 col-sm-9">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">审批意见&nbsp;&nbsp;</label> 
							<textarea name="spyj" class="autosize-transition form-control" ></textarea>
								<input type="hidden" id="ids" name="ids"/>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<button id="btn_approve_ok" type="button" class="btn btn-info  btn-minier bigger">
							<i class="icon-ok icon-on-right bigger-110"></i>
							通过
						</button> 
						&nbsp;
					 	<button id="btn_approve_back" type="button" class="btn btn-danger btn-minier bigger">
							 <i class="fa-times icon-on-right bigger-110"></i>
							驳回
						</button> 
                	</div>
				</div>
			</form>
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
	<shiro:hasPermission name="payment:payReceiveClaim:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/payment/payReceiveClaim/approveSearch'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect: true,
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, frozen:true},
				{name:'rldh', index:'rldh', label:'认领单号', width:100, frozen:true},
				{name:'zt', index:'zt', label:'状态', hidden:true, frozen:true},
				{name:'ztmc', index:'ztmc', label:'状态', width:70, frozen:true},
				{name:'skdh', index:'skdh', label:'收款单号', width:100, frozen:true},
				{name:'khbm', index:'khbm', label:'客户编码', width:100},
				{name:'khmc', index:'khmc', label:'客户名称', width:120},
				{name:'sklxmc', index:'sklxmc', label:'收款类型', width:100},
				{name:'bz', index:'bz', label:'收款币种', width:80},
				{name:'je', index:'je', label:'认领金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'rljetz', index:'rljetz', label:'认领金额调整', width:120,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'sjsxf', index:'sjsxf', label:'实际手续费', width:120,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'fph', index:'fph', label:'发票号', width:100},
				{name:'fpje', index:'fpje', label:'发票金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'fpbz', index:'fpbz', label:'发票币种', width:80},
				{name:'ddh', index:'ddh', label:'订单号', width:100},
				{name:'lcbh', index:'lcbh', label:'LC编号', width:100},
				{name:'gsbm', index:'gsbm', label:'接单主体', width:120, edittype:"select",formatter: "select",editoptions:{value:"${fns:loadCompanyOption('1')}"}},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:140},
				{name:'zdrid', index:'zdrid', label:'认领人ID', width:80},
				{name:'zdrmc', index:'zdrmc', label:'认领人名称', width:80},
				{name:'zdsj', index:'zdsj', label:'认领日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bbh', index:'bbh', label:'版本号', width:80, hidden: true},
				{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true},
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', hidden: true, width:120},
				{name:'fj', index:'fj', label:'附件', width:120}
			],
			sortname: 'rldh',
			sortorder: 'asc'
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		}).jqGrid('setFrozenColumns');
		
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			rules: {
				spyj: 'required'
			},
			messages: {
				spyj: '审批意见不能为空！'
			},
	        showErrors: function(errorMap, errorList) {  
	            if(errorList.length == 0){
	            	$('.input-group').removeClass('has-error');
	            }else{
		            var msg = "";  
		            $.each( errorList, function(i,v){  
		              msg += (v.message+"\r\n"); 
		              $(v.element).closest('.input-group').addClass('has-error');
		            });  
	            	swal({title: "校验不通过！",text: msg,type: "error"},	function(){
						return false;
					});
	            }
	        }
		});
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		//审核通过
		$("#btn_approve_ok").click(function(){
			approve(3);
	    });
		//审核退回
		$("#btn_approve_back").click(function(){
			approve(2);
	    });
		//导出
		$("#export").click(function(){
		    var curNum=$(grid_selector).getGridParam("records");
		    if(curNum==0){
	            swal("","结果集为空不能导出","warning");
	            return false;
	        }else{
	        	$("body").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/payReceiveClaim/approveExport'/>"});
	    			}
	    		});
	        }
		});
		
	});

	function initSelect2(elem){
		$(elem).width(140).select2();
	}

	// 审批方法
	function approve(approveType){
		var data = $(grid_selector).jqGrid("getGridParam","selarrrow");
		// 判断是否选了数据
		if(!data.length > 0){
			swal("","请至少勾选一条记录！","warning");
			return;
		}
		// 表单验证
		if(!$('#form-submit').valid()){
			return false;
		}
		// 循环处理选中数据（可多选）
		var rows = [];
		for(var i=0; i<data.length; i++){
			var rowData = $(grid_selector).jqGrid("getRowData",data[i]);
			if(rowData.zt!=2){
				swal("","系统只允许操作审批中的单据！","warning");
				return;
			}
			var row={};
			row.id=data[i];
			row.sjc=rowData.sjc;
			rows.push(row);
		}
		// 获取表单数据并审批
		var param = $("#form-submit").getFormData();
		param.rows = JSON.stringify(rows);
		param.approveType = approveType;
		$("body").bindSweetAlert({
			title : "确定要审批吗?"
		},{
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payReceiveClaim/approve'/>",
					data : param,
					action : "save",
					//contentType:"application/json;charset=utf-8",
					text : "",
				}, function(response) {
                     $('#form-submit')[0].reset();
                     $(grid_selector).trigger("reloadGrid");
				});
			}
		});
	}
	
</script>
</html>