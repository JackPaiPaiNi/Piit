<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
<%@include file="/WEB-INF/views/index/lfs.jsp"%>
</head>
<%
		String id = request.getParameter("id");
		String sjc = request.getParameter("sjc");
	%>
<body>
	<div class="zheZhao"></div>
	<div class="page-content">

		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->

				<form id="form-submit">
					<div class="row" style="margin: 0px;">
							<input type="hidden" name="id" /> 
							<input type="hidden" name="oper" />
							<input type="hidden" name="sjc" /> 
							<input type="hidden" name="bbh" /> 
							<input type="hidden" name="token" value="${token}">
						<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">走货计划单号&nbsp;&nbsp;</label> <input
									type="text" name="zhjhdh" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<!-- <div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label>
								<input type="text" id="khmc" name="khmc" onfocus="this.blur()" class="form-control  parent-node"/>
								<span class="input-group-addon">
									<i class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
								<input type="text" name="khbm" class="form-control skydisabled" disabled="disabled"/>
							</div>
						</div> -->
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">状态&nbsp;&nbsp;</label> <input
									type="text" name="ztmc" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>	
				
							<button id="btn-zhjhSelect" type="button" class="btn btn-purple btn-sm" >
							<i class="fa fa-plus icon-on-right bigger-110"></i>
							预走货选择
							</button>
							&nbsp;
						    <!-- <button id="btn-qry" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 加载走货计划明细
							</button>
							&nbsp; -->
							<button id="btn-save" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
							&nbsp;
							<button id="btn-submit" type="button" class="btn btn-info btn-sm">
								<i class="icon-ok icon-on-right bigger-110"></i> 提交
							</button>
							&nbsp;
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
						</div>
					</div>

					<div class="space-4"></div>
					
					<!-- <div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">装柜日期&nbsp;&nbsp;</label>
								<input type="hidden" id="zgkssj" name="zgkssj"/>
								<input type="hidden" id="zgjssj" name="zgjssj"/>
								<input type="text" name="zgsj" class="form-control timeInterval"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
								<input type="text" name="yzhdh" class="form-control"/>
							</div>
						</div>	
					</div> -->

					<div class="space-4"></div>
					<div id="grid-parent" style="margin: 0px 8px;">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
	<span class="loading-indicator"> <label><i
			class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
	</span>
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var parent_selector = "#grid-parent";
	
	var id = "<%=id%>";
	var sjc = "<%=sjc%>";
	var isEdit = false;
	<shiro:hasPermission name="deliverplan:deliverPlan:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($){
		$(".timeInterval").bindDateRange({startElement:$("#zgkssj"),endElement:$("#zgjssj")});
		$(grid_selector).bindTable({
			caption: "",
			pager: pager_selector,
			//去掉编辑表分页按钮
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			gridParent: "#grid-parent",
			footerrow:true,
			datatype: "local",
			shrinkToFit: false,
			autoScroll: false,
			//autoheight:true,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
/* 				{name:'zhjhdh', index:'zhjhdh', label:'走货计划单号', width:120, editable:false}, */
				{name:'xszzmc', index:'xszzmc', label:'销售组织', width:100, editable:false},
				{name:'xszz', index:'xszz', label:'销售组织', width:100, editable:false, hidden: true},
				{name:'ywzmc', index:'ywzmc', label:'业务组', width:80, editable:false},
				{name:'ywz', index:'ywz', label:'业务组', width:80, editable:false, hidden: true},
				{name:'xsymc', index:'xsymc', label:'销售员', width:80, editable:false},
				{name:'xsyid', index:'xsyid', label:'销售员', width:80, editable:false, hidden: true},
				{name:'zdrmc', index:'zdrmc', label:'预走货制单人', width:80, editable:false},
				{name:'zdrid', index:'zdrid', label:'预走货制单人', width:80, editable:false, hidden: true},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100, editable:false},
				{name:'yzhsj', index:'yzhsj', label:'预走货时间', width:100, editable:false},
				{name:'dcdh', index:'dcdh', label:'订舱单号', width:130, editable:false},
				{name:'yzhlxmc', index:'yzhlxmc', label:'预走货类型', width:80, editable:false},
				{name:'khmc', index:'khmc', label:'客户名称', width:140, editable:false},
				{name:'khbm', index:'khbm', label:'客户编码', width:100, editable:false},
				{name:'ddid', index:'ddid', label:'订单号', width:80, editable:false},
				{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:80, editable:false},
				{name:'zhfs', index:'zhfs', label:'走货方式', width:80, editable:false, hidden: true},
				{name:'jixing', index:'jixing', label:'机型', width:80, editable:false},
				{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:80, editable:false},
				{name:'xwgj', index:'xwgj', label:'销往国家', width:80, editable:false, hidden: true},
				{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:80, editable:false},
				{name:'mytk', index:'mytk', label:'贸易条款', width:80, editable:false, hidden: true},
				{name:'sl', index:'sl', label:'数量',align:'right', width:100, formatter:'number',editrules:{number:true, required:true},
					formatoptions:{thousandsSeparator: ',',decimalPlaces:4}, editable:false},
				{name:'dj', index:'dj', label:'单价', width:120,formatter:'number',editrules:{number:true, required:true},
					formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
			    {name:'je', index:'je', label:'金额', width:120, align:'right',
						 formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
			    {name:'bz', index:'bz', label:'币种', width:60, editable:false},
				{name:'yjyhrq', index:'yjyhrq', label:'预计验货日期', width:100, editable:true,edittype:"text",
					editoptions: {
						dataInit: function (element) {
						   $(element).datetimepicker({
								autoclose: true,
								format: 'yyyy-mm-dd HH:mm:ss',
								orientation : 'auto bottom',
								language:"zh-CN"
							});
						}
					}},
				{name:'zgkssj', index:'zgkssj', label:'装柜开始日期', width:100, editable:true,edittype:"text",
						editoptions: {
							dataInit: function (element) {
							   $(element).datepicker({
									autoclose: true,
									format: 'yyyy-mm-dd',
									orientation : 'auto bottom',
									language:"zh-CN"
								});
							}
						}},
				{name:'zgjssj', index:'zgjssj', label:'装柜结束日期', width:100, editable:true,edittype:"text",
							editoptions: {
								dataInit: function (element) {
								   $(element).datepicker({
										autoclose: true,
										format: 'yyyy-mm-dd',
										orientation : 'auto bottom',
										language:"zh-CN"
									});
								}
							}},
				{name:'jgq', index:'jgq', label:'截关期', width:100, editable:true,edittype:"text",
								editoptions: {
									dataInit: function (element) {
									   $(element).datetimepicker({
											autoclose: true,
											format: 'yyyy-mm-dd HH:mm:ss',
											orientation : 'auto bottom',
											language:"zh-CN"
										});
									}
								}},
				{name:'yjkcq', index:'yjkcq', label:'预计开船期', width:100, editable:true,edittype:"text",
									editoptions: {
										dataInit: function (element) {
										   $(element).datetimepicker({
												autoclose: true,
												format: 'yyyy-mm-dd HH:mm:ss',
												orientation : 'auto bottom',
												language:"zh-CN"
											});
										}
									}},
				{name:'jfxtsj', index:'jfxtsj', label:'截放行条时间', width:100, editable:true,edittype:"text",
					editoptions: {
						dataInit: function (element) {
						   $(element).datetimepicker({
								autoclose: true,
								format: 'yyyy-mm-dd HH:mm:ss',
								orientation : 'auto bottom',
								language:"zh-CN"
							});
						}
					}},
				{name:'kcsj', index:'kcsj', label:'开船时间', width:100, editable:true,edittype:"text",
					editoptions: {
						dataInit: function (element) {
						   $(element).datetimepicker({
								autoclose: true,
								format: 'yyyy-mm-dd HH:mm:ss',
								orientation : 'auto bottom',
								language:"zh-CN"
							});
						}
					}},
				{name:'kcy', index:'kcy', label:'开船月', width:100, editable:true, edittype:"text"},
				{name:'qygmc', index:'qygmc', label:'起运港', width:80, editable:false},
				{name:'qyg', index:'qyg', label:'起运港', width:80, editable:false, hidden: true},
				{name:'chzt', index:'chzt', label:'出货状态', width:80, editable:false},
				{name:'yzhlx', index:'yzhlx', label:'预走货类型', width:80, editable:false, hidden: true},
				{name:'ygZgs', index:'ygZgs', label:'用柜总柜数',align:'right', width:80, formatter:'integer',
					formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
						//合并单元格
						return 'id=\'ygZgs'+rowId+"\'";
					}},
				{name:'yg20gp', index:'yg20gp', label:'20GP',align:'right', width:80, formatter:'integer',
						formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
							//合并单元格
							return 'id=\'yg20gp'+rowId+"\'";
						}},
				{name:'yg40gp', index:'yg40gp', label:'40GP',align:'right', width:80, formatter:'integer',
							formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
								//合并单元格
								return 'id=\'yg40gp'+rowId+"\'";
							}},
				{name:'yg40hq', index:'yg40hq', label:'40HQ',align:'right', width:80, formatter:'integer',
								formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
									//合并单元格
									return 'id=\'yg40hq'+rowId+"\'";
								}},
				{name:'ygGsbz', index:'ygGsbz', label:'用柜备注', width:80,editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'ygGsbz'+rowId+"\'";
				}},
				{name:'dcZcs', index:'dcZcs', label:'吨车总数',align:'right', width:80, formatter:'integer',
					formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
						//合并单元格
						return 'id=\'dcZcs'+rowId+"\'";
					}},
				{name:'dc3d', index:'dc3d', label:'3吨车数',align:'right', width:80, formatter:'integer',
						formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
							//合并单元格
							return 'id=\'dc3d'+rowId+"\'";
						}},
				{name:'dc5d', index:'dc5d', label:'5吨车数',align:'right', width:80, formatter:'integer',
							formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
								//合并单元格
								return 'id=\'dc5d'+rowId+"\'";
							}},
				{name:'dc8d', index:'dc8d', label:'8吨车数',align:'right', width:80, formatter:'integer',
								formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
									//合并单元格
									return 'id=\'dc8d'+rowId+"\'";
								}},
				{name:'dc10d', index:'dc10d', label:'10吨车数',align:'right', width:80, formatter:'integer',
									formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
										//合并单元格
										return 'id=\'dc10d'+rowId+"\'";
									}},
				{name:'dc12d', index:'dc12d', label:'12吨车数',align:'right', width:80, formatter:'integer',
										formatoptions:{thousandsSeparator: ','}, editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
											//合并单元格
											return 'id=\'dc12d'+rowId+"\'";
										}},
				{name:'dcDcbz', index:'dcDcbz', label:'吨车备注', width:80,editable:false,cellattr:function(rowId,tv,rawObject,cm,rdata){
					//合并单元格
					return 'id=\'dcDcbz'+rowId+"\'";
				}},
				{name:'cdgsmc', index:'cdgsmc', label:'船贷公司', width:80, editable:false},
				{name:'cdgsbm', index:'cdgsbm', label:'船贷公司', width:80, editable:false, hidden: true},
				{name:'cylxmc', index:'cylxmc', label:'出运类型', width:80, editable:false},
				{name:'cylx', index:'cylx', label:'出运类型', width:80, editable:false, hidden: true},
				{name:'mdg', index:'mdg', label:'目的港', width:100, editable:true, edittype:"text"},
				{name:'jcsj', index:'jcsj', label:'截重时间', width:100, editable:true,edittype:"text",
					editoptions: {
						dataInit: function (element) {
						   $(element).datetimepicker({
								autoclose: true,
								format: 'yyyy-mm-dd HH:mm:ss',
								orientation : 'auto bottom',
								language:"zh-CN"
							});
						}
					}},
				{name:'jblsj', index:'jblsj', label:'截补料时间', width:100, editable:true,edittype:"text",
						editoptions: {
							dataInit: function (element) {
							   $(element).datetimepicker({
									autoclose: true,
									format: 'yyyy-mm-dd HH:mm:ss',
									orientation : 'auto bottom',
									language:"zh-CN"
								});
							}
						}},
				{name:'gsmc', index:'gsmc', label:'公司', width:80, editable:false, hidden: true},
				{name:'gsbm', index:'gsbm', label:'公司', width:80, editable:false},
			],
			editTable : true,
			gridComplete: function(){
	            sumGrid();
	            //合并单元格
	            merge('yzhdh','yg20gp');
	            merge('yzhdh','yg40gp');
	            merge('yzhdh','yg40hq');
	            merge('yzhdh','ygZgs');
	            merge('yzhdh','ygGsbz');
	            merge('yzhdh','dcZcs');
	            merge('yzhdh','dc3d');
	            merge('yzhdh','dc5d');
	            merge('yzhdh','dc8d');
	            merge('yzhdh','dc10d');
	            merge('yzhdh','dc12d');
	            merge('yzhdh','dcDcbz');
	            
		   	},
		   	editComplete: function(lastEdit, rowData){
		   		$(grid_selector).saveRow(lastEdit, false, 'clientArray');
				$(grid_selector).removeData('lastEdit');
				 sumGrid();
		   	}
		},{
			add:false,
			edit:isEdit,
			view:false,
			del:false,
			complete:isEdit
		});
		
		
		
		// 初始化页面数据
		bindFormData(id);
		
		// 客户选择框
		$("#form-submit [name=khmc]").click(function(){
			selectKhxxInit();
		});
		
		// 计算合计行
		function sumGrid(){
			var je;
			var sl;
			$(grid_selector).footerData("set",{"zhjhdh":"合计"}); //合计
			var rowNum = $(grid_selector).jqGrid('getGridParam','records');
			if(rowNum >0 ){
				 je = $(grid_selector).getCol("je",false,"sum"); 
				 sl = $(grid_selector).getCol("sl",false,"sum"); 
			}
			$(grid_selector).footerData("set",{"je":je, "sl":sl}); //将合计值显示出来
		}
		
		//合并行单元格
		function merge(YzhdhCell,CellName){
			var mya=$(grid_selector).getDataIDs();
			var length=mya.length;
			for(var i=0;i<length;i++){
				var before=$(grid_selector).jqGrid('getRowData',mya[i]);
				var rowSpanCount=1;
				for(var j=i+1;j<=length;j++){
					var end=$(grid_selector).jqGrid('getRowData',mya[j]);
					if(before[CellName]==end[CellName] && before[YzhdhCell]==end[YzhdhCell]){
						rowSpanCount++;
						$(grid_selector).setCell(mya[j],CellName,'',{display:'none'});
					}else{
						rowSpanCount = 1;
						break;
					}
					$("#"+CellName+""+mya[i]+"").attr("rowspan",rowSpanCount);
				}
			}
		}
		
		//保存
		$("#btn-save").click(function(){
			save();
	    });
		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
		//计算
		$("#btn-qry").click(function(){
			loadZhjhmx();
	    });
		// 返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		
		var zt=$("#form-submit [name=zt]").val();
		if(zt == 5){
			$("#btn-save").hide();
			$("#btn-submit").hide();
			$("#btn-qry").hide();
		};
		
		//校验
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			ignore: 'input[type=hidden]',
			rules: {
				khbm : 'required',
				zgsj: 'required'
				
			},
			messages: {
				khbm:'客户编码不能为空，请选择客户！',
				zgsj:'装柜时间不能为空！'
			},
	        showErrors: function(errorMap, errorList) {  
	        	$('.input-group').removeClass('has-error');
	            if(errorList.length != 0){
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
		
		// 走货计划明细选择
		$("#btn-zhjhSelect").click(function(){
		    var width = 1366;
			var height =768;
			var left = 0;
			var top =  0; 
			var pageUrl = "<c:url value='/deliverplan/deliverPlan/zhjhList'/>";
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				var data = window.showModalDialog(pageUrl,null,dialogArgs);
				if(data){
					initYzhData(data);
				}
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,resizable=yes,left="+left+"px,top="+top+"px";
				var opener = window.open(pageUrl,null,dialogArgs);
				opener.openerCallBack = function(data){
					initYzhData(data);
				}
			}
		});
	});
	
	//初始化页面数据（新增/修改/更改）
	function bindFormData(id){	
		$.loading();
    	// 绑定数据
		$.bindAjax({
			url : "<c:url value='/deliverplan/deliverPlan/findById'/>",
			data : {id:id},
			action : "search"
		},function(response){
			removeFormProp();
			$("#form-submit").setFormData(response);
			$("#form-submit [name=zgsj]").val(response.zgkssj+"~"+response.zgjssj);
			addFormProp();
			if(id == "null"){
				// 新增
				$("#form-submit [name=id]").val("");
				$("#form-submit [name=sjc]").val("");
				$("#form-submit [name=bbh]").val("");
				$("#form-submit [name=zgkssj]").val("");
				$("#form-submit [name=zgjssj]").val("");
				$("#form-submit [name=zgsj]").val("");
				$("#form-submit [name=oper]").val("add");
				$("#form-submit [name=zt]").val("1");
				$('#form-submit [name=ztmc]').removeProp("disabled").removeAttr('disabled');
				$("#form-submit [name=ztmc]").val("草稿");
				$('#form-submit [name=ztmc]').prop('disabled','disabled');
			
			} else {
				// 修改
				$("#form-submit [name=oper]").val("edit");
			}
		
		
			// 加载明细
			if(response.deliverPlanItemList){
				$(grid_selector).jqGrid("clearGridData");
				$(grid_selector).jqGrid("addRowData", null, response.deliverPlanItemList, "last");
			  	$(grid_selector).removeData('lastEdit');
			}
			$.hideLoad();
		});
	}
	
	//保存
	function save(){
		var zt=$("#form-submit [name=zt]").val();
		if(zt == 5){
			$("#btn-save").hide();
			$("#btn-submit").hide();
			$("#btn-qry").hide();
			swal("","已生效单据不能再修改","warning");
			return;
		}
		//结束表格编辑
	    var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			$(grid_selector).removeData('lastEdit');
		}
		var param = $('#form-submit').getFormData();
		var data = $(grid_selector).getRowData();
		if(data.length == 0){
			swal("","走货计划单明细不能为空","warning");
			return  ;
		}
		param.mxList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/deliverplan/deliverPlan/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
					$("#form-submit [name=token]").val(result.token);
				    $('#form-submit [name=zhjhdh]').removeProp("disabled").removeAttr('disabled');
					$("#form-submit [name=zhjhdh]").val(result.zhjhdh);
					$('#form-submit [name=zhjhdh]').prop('disabled','disabled');
				}); 
			}
		});
	}
	
	//提交
	function submit(){
		var zt=$("#form-submit [name=zt]").val();
		if(zt == 5){
			$("#btn-save").hide();
			$("#btn-submit").hide();
			$("#btn-qry").hide();
			swal("","已生效单据不能再修改","warning");
			return;
		}
		//结束表格编辑
	    var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			$(grid_selector).removeData('lastEdit');
		}
		var param = $("#form-submit").getFormData();
		var data = $(grid_selector).getRowData();
		if(data.length == 0){
			swal("","走货计划单明细不能为空","warning");
			return;
		}
		param.mxList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/deliverplan/deliverPlan/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	
 	
	//客户
	function selectKhxxInit(){
		$.tableDialogPage({
			title:"客户选择",
			searchCond:[{"name":"客户","value":"khbm"}/* ,
			            {"name":"客户类型","value":"khlx"} */],
			colModel:[{name:'id', index:'id', label:'ID',hidden:true}, 
			          {name:'khbm', index:'khbm', label:'客户编码', width:80},
		 	          {name:'khmc', index:'khmc', label:'客户名称', width:80}],
			url:"<c:url value='/pub/widget/findCust'/>"
		},{
			callback:function(rows){
				if(rows){
					removeFormProp();	
					$("#form-submit [name=khbm]").val(rows.khbm);
					$("#form-submit [name=khmc]").val(rows.khmc);
					addFormProp();
				}else{	
					$("input[name=khbm]").val("");
					$("input[name=khmc]").val("");
				}
			}
		});
		
	} 
	
	function loadZhjhmx(){
		/* if(!$('#form-submit').valid()){
			return false;
		} */
		var param=$("#form-submit").getFormData();
		$.bindAjax({
			url:"<c:url value='/deliverplan/deliverPlan/qryZhmx'/>",
			data:param,
			action:"search"
		},function(response){
			// 加载明细
			if(response.deliverPlanItemList){
				$(grid_selector).jqGrid("clearGridData");
				$(grid_selector).jqGrid("addRowData", null, response.deliverPlanItemList, "last");
			  	$(grid_selector).removeData('lastEdit');
			}
		}); 
	}
	
	// 初始化走货计划明细数据
	function initYzhData(data){
		$(grid_selector).jqGrid("clearGridData");
		// 添加数据到编辑表
  		$(grid_selector).jqGrid("addRowData", null, data, "last");
  		$(grid_selector).removeData('lastEdit');
	}
	
	function removeFormProp(){
		$('#form-submit [name=khbm]').removeProp("disabled").removeAttr('disabled');
		
	}
	function addFormProp(){
		$('#form-submit [name=khbm]').prop('disabled','disabled');
	
	} 
	
</script>
</html>