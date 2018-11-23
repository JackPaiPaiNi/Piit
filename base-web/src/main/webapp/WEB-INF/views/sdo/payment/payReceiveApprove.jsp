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
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款单号&nbsp;&nbsp;</label>
										<input type="text" name="skdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">付款人&nbsp;&nbsp;</label>
										<input type="text" name="fkr" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款日期&nbsp;&nbsp;</label>
										<input type="hidden" id="ssksj" name="ssksj"/>
										<input type="hidden" id="esksj" name="esksj"/>
										<input type="text" name="skrq" class="form-control"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">收款银行&nbsp;&nbsp;</label>		
										<select role="select" name="skyh" size="1" class="form-control skyselect">											
												${fns:loadBankInfoOption('0')}
										</select>
									</div>
								</div>
							</div>	
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">登记时间&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" class="form-control"/>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>	
							</div>	
							<input type="hidden" name='zt' value="2"/>									
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
		</div><!-- /.col -->
	</div><!-- /.row -->
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	var searchurl = "<c:url value='/payment/payReceive/approveSearch'/>";
	var isEdit = false;
	<shiro:hasPermission name="payment:payReceive:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$("#form-search [name=zdsj]").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$("#form-search [name=skrq]").bindDateRange({startElement:$("#ssksj"),endElement:$("#esksj")});
		
		$(grid_selector).bindTable({
			caption:"",
			url: searchurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect: true,
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen:true},
				{name:'skdh', index:'skdh', label:'收款单号', width:80, formoptions:{rowpos: 2, colpos: 1}, frozen:true},
				{name:'zt', index:'zt', label:'状态', hidden:true, frozen:true},
				{name:'ztmc', index:'ztmc', label:'状态', width:70, frozen:true},
				{name:'je', index:'je', label:'金额', width:120,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'fkr', index:'fkr', label:'付款人', width:80},
				{name:'fkyh', index:'fkyh', label:'付款银行', width:100},
				{name:'fkgj', index:'fkgj', label:'付款国家', width:80, hidden: true},
				{name:'fkgjmc', index:'fkgjmc', label:'付款国家', width:80, formoptions:{rowpos: 4, colpos: 2}},
				{name:'skrq', index:'skrq', label:'收款日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'skyh', index:'skyh', label:'收款银行', width:100, hidden: true},
				{name:'skyhmc', index:'skyhmc', label:'收款银行', width:100},
				{name:'cksxf', index:'cksxf', label:'参考手续费', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:100, hidden: true},
				{name:'zdrmc', index:'zdrmc', label:'财务登记人', width:80},
				{name:'zdsj', index:'zdsj', label:'登记时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bbh', index:'bbh', label:'版本号', width:60, hidden: true},
				{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true},
			],
			sortname: 'skdh',
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
		
	});

	function initSelect2(elem){
		$(elem).width(140).select2();
	}
	
	//审批方法
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
			if(rowData.zt != 2){
				swal("","系统只允许操作审批中的单据！","warning");
				return;
			}
			var row = {};
			row.id = data[i];
			row.sjc = rowData.sjc;
			rows.push(row);
		}
		// 获取表单数据并审批
		var param = $("#form-submit").getFormData();
		param.rows = JSON.stringify(rows);
		param.approveType=approveType;
		$("body").bindSweetAlert({
			title : "确定要审批吗?"
		},{
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payReceive/approve'/>",
					data : param,
					action : "save"
				}, function(response) {
                     $('#form-submit')[0].reset();
                     $(grid_selector).trigger("reloadGrid");
				});
			}
		});
	}
		
</script>
</html>