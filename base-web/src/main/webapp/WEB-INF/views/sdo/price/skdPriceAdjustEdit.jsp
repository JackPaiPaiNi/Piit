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
						<div class="col-xs-12 col-sm-8">
							<input type="hidden" name="id" /> 
							<input type="hidden" name="oper" />
							 <input type="hidden" name="sjc" /> 
							 <input type="hidden" name="bbh" /> 
							 <input type="hidden" name="token" value="${token}">
							<font color="red"> 请先选择订单（系统只支持单个订单进行调价，请注意：本调价单只适用于SKD齐套出货）。</font>
						</div>
						<div class="col-xs-12 col-sm-4">
						    <button id="btn-compute" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 计算差额
							</button>
							&nbsp;
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
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">调价单号&nbsp;&nbsp;</label> <input
									type="text" name="tjdid" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订单号&nbsp;&nbsp;</label> <input
									type="text" name="ddid" onfocus="this.blur()"
									class="form-control parent-node" /> <span
									class="input-group-addon"> <i
									class="icon-search bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">出货通知书单号&nbsp;&nbsp;</label> <input
									type="text" name="chdh" class="form-control skydisabled"
								disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">状态&nbsp;&nbsp;</label> <input
									type="text" name="ztmc" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>

					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label> <input
									type="text" name="khbm" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
									type="text" name="khmc" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订单总金额&nbsp;&nbsp;</label> <input
									type="text" name="ddzje" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">订单币种&nbsp;&nbsp;</label> <input
									type="text" name="bz" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">差额(订单总金额-调整汇总金额)&nbsp;&nbsp;</label> <input
									type="text" name="ce" class="form-control"/>
							</div>
						</div>	
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">制单人&nbsp;&nbsp;</label> <input
									type="text" name="zdrmc" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">制单时间&nbsp;&nbsp;</label> <input
									type="text" name="zdsj" class="form-control skydisabled"
									disabled="disabled" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div id="grid-parent" style="margin: 0px 8px;">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div>
					<div class="col-xs-12 col-sm-12">
							<font color="red">注意：如果查不到数据，请检查该出货通知书单号或订单号是否已经开过票（含草稿），已开票不允许再调价（一定要调价则先取消或删除发票），其次再检查交货明细。</font>
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
	<shiro:hasPermission name="price:skdPriceAdjust:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($){

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
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:120, editable:false},
				{name:'wlms', index:'wlms', label:'物料描述', width:120, editable:false},
				{name:'xmlb', index:'xmlb', label:'项目类别', width:100, editable:false},
				{name:'wldw', index:'wldw', label:'单位', width:80, editable:false},
				{name:'dj', index:'dj', label:'单价', width:80,formatter:'number',editrules:{number:true, required:true},
					formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editable:false},
				{name:'tzdj', index:'tzdj', label:'调整单价', width:80,formatter:'number',editrules:{number:true,minValue:0},
					formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editoptions:{dataInit: initDj},editable:true},
				{name:'sl', index:'sl', label:'数量',align:'right', width:50, formatter:'number',editrules:{number:true, required:true},
						formatoptions:{thousandsSeparator: ',',decimalPlaces:4}, hidden: true},
				{name:'jhsl', index:'jhsl', label:'数量',align:'right', width:50, formatter:'number',editrules:{number:true, required:true},
							formatoptions:{thousandsSeparator: ',',decimalPlaces:4}, editable:false},
			    {name:'je', index:'je', label:'金额', width:80, align:'right',
						 formatter:'number',formatoptions:{thousandsSeparator: ',',decimalPlaces:4}, editable:false},
			    {name:'tzje', index:'tzje', label:'调整金额',align:'right', width:80,formatter:'number', editrules:{number:true,minValue:0},
								formatoptions:{thousandsSeparator: ',',decimalPlaces:6}, editoptions:{dataInit: initJe},editable:true},
			    {name:'jhdh', index:'jhdh', label:'交货单号',hidden:true, width:100, editable:false},
				{name:'serino', index:'serino', label:'行项目号',hidden:true, width:100, editable:false},
				{name:'jgdw', index:'jgdw', label:'价格单位',hidden:true, width:100, editable:false},
				{name:'bz', index:'bz', label:'交货单币种', width:100, editable:false},
			],
			editTable : true,
			gridComplete: function(){
	            sumGrid();
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
		
		// 计算合计行
		function sumGrid(){
			var je;
			var tzje;
			$(grid_selector).footerData("set",{"wlbh":"合计"}); //合计
			var rowNum = $(grid_selector).jqGrid('getGridParam','records');
			if(rowNum >0 ){
				 je = $(grid_selector).getCol("je",false,"sum"); 
				 tzje = $(grid_selector).getCol("tzje",false,"sum"); 
			}
			$(grid_selector).footerData("set",{"je":je, "tzje":tzje}); //将合计值显示出来
		}
		
		// 参考订单号选择
		$("#form-submit [name=ddid]").click(function(){
			selectDdidInit();
		});
		//保存
		$("#btn-save").click(function(){
			save();
	    });
		//提交
		$("#btn-submit").click(function(){
			submit();
	    });
		//计算
		$("#btn-compute").click(function(){
			compute();
	    });
		// 返回
		$("#btn-back").click(function(){
			window.history.back(-1);
	    });
		
		var zt=$("#form-submit [name=zt]").val();
		if(zt == 5){
			$("#btn-save").hide();
			$("#btn-submit").hide();
			$("#btn-compute").hide();
		}
	});
	
	//初始化页面数据（新增/修改/更改）
	function bindFormData(id){	
		$.loading();
    	// 绑定数据
		$.bindAjax({
			url : "<c:url value='/price/skdPriceAdjust/findById'/>",
			data : {id:id},
			action : "search"
		},function(response){
			$("#form-submit").setFormData(response);
			if(id == "null"){
				// 新增
				$("#form-submit [name=id]").val("");
				$("#form-submit [name=sjc]").val("");
				$("#form-submit [name=bbh]").val("");
				$("#form-submit [name=oper]").val("add");
				$("#form-submit [name=zt]").val("1");
				$('#form-submit [name=ztmc]').removeProp("disabled").removeAttr('disabled');
				$("#form-submit [name=ztmc]").val("草稿");
				$('#form-submit [name=ztmc]').prop('disabled','disabled');
				$("#form-submit [name=ce]").val("");
			} else {
				// 修改
				$("#form-submit [name=oper]").val("edit");
			}
		
			// 加载明细
			if(response.skdPriceAdjustItemList){
				$(grid_selector).jqGrid("clearGridData");
				$(grid_selector).jqGrid("addRowData", null, response.skdPriceAdjustItemList, "last");
			  	$(grid_selector).removeData('lastEdit');
			}
			$.hideLoad();
		});
	}
	
	function initDj(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).closest("tr.jqgrow").find("[name='sl']").val();
			var tzdj = $(elem).val();
			var tzje = "";
			if(sl != "" && tzdj != ""){
				tzje = sl*tzdj;
			}
			$(elem).closest("tr.jqgrow").find("[name='tzje']").val(tzje.toFixed(6));
		});
		
	}
	function initJe(elem){
		$(elem).on("blur", function(){
			var sl = $(elem).closest("tr.jqgrow").find("[name='sl']").val();
			var tzje = $(elem).val();
			var tzdj = "";
			if(sl != "" && tzje != ""){
				tzdj = tzje/sl;
			}
			$(elem).closest("tr.jqgrow").find("[name='tzdj']").val(tzdj.toFixed(6));
		});
		
	}
	//保存
	function save(){
		var zt=$("#form-submit [name=zt]").val();
		if(zt == 5){
			$("#btn-save").hide();
			$("#btn-submit").hide();
			$("#btn-compute").hide();
			swal("","已生效单据不能再修改","warning");
			return;
		}
		if(!validate()){
			return;
		}	
		var param = $('#form-submit').getFormData();
		var data = $(grid_selector).getRowData();
		var hh = validData(data);
		if(data.length == 0){
			swal("","SKD价格调整明细不能为空","warning");
			return  ;
		}
		if( hh != ""){
			swal("",hh,"warning");
			return  ;
		}
		param.mxList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/price/skdPriceAdjust/edit'/>",
					data:param,
					action:"save"
				},function(response){
					var result = JSON.parse(response);
					$("#form-submit [name=id]").val(result.id);
					$("#form-submit [name=sjc]").val(result.sjc);
					$("#form-submit [name=bbh]").val(result.bbh);
					$("#form-submit [name=token]").val(result.token);
				    $('#form-submit [name=tjdid]').removeProp("disabled").removeAttr('disabled');
					$("#form-submit [name=tjdid]").val(result.tjdid);
					$('#form-submit [name=tjdid]').prop('disabled','disabled');
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
			$("#btn-compute").hide();
			swal("","已生效单据不能再修改","warning");
			return;
		}
		if(!validate()){
			return;
		}
		var param = $("#form-submit").getFormData();
		var data = $(grid_selector).getRowData();
		var hh = validData(data);
		if(data.length == 0){
			swal("","SKD价格调整明细不能为空","warning");
			return;
		}
		if( hh != ""){
			swal("",hh,"warning");
			return  ;
		}
		param.mxList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要提交吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/price/skdPriceAdjust/submit'/>",
					data:param,
					action:"save"
				},function(response){
					window.history.back(-1);
				}); 
			}
		});
	}
	
	//计算差额
	function compute(){
		//结束表格编辑
	    var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
			$(grid_selector).removeData('lastEdit');
		}
		var ddzje = $("#form-submit [name=ddzje]").val();
		if(ddzje==""){
			swal("", "订单总金额不能为空!", "warning");
			return;
		}
		
		var rowNum = $(grid_selector).jqGrid('getGridParam','records');
		var tzje="";
		var ce = "";
		if(rowNum > 0 ){
			 tzje = $(grid_selector).getCol("tzje",false,"sum"); 
			 ce = (ddzje - tzje).toFixed(6);
			 $('#form-submit [name=ce]').removeProp("disabled").removeAttr('disabled');
			 $("#form-submit [name=ce]").val(ce);
			 $('#form-submit [name=ce]').prop('disabled','disabled');
			 if(ce != 0){
				 swal("", "订单总金额-调整汇总金额="+ce, "warning");
				 return;
			 }
		}else{
			 swal("", "物料明细为空！", "warning");
		}
	}
	//验证调整汇总金额
	function validate(){
		this.compute();
		var ce= $("#form-submit [name=ce]").val();
		if(ce!=0){
			 swal("", "调整完仍有差额（订单总金额-调整汇总金额="+ce+"）", "warning");
			return false;
		}else{
			return true;
		}
	}
	
	//订单号
	function selectDdidInit(){
		$.tableDialogPage({
			title:"订单选择",
			searchCond:[
			            {"name":"订单号","value":"ddid"},
			            {"name":"出货通知书单号","value":"chdh"},
			            {"name":"客户","value":"khbm"}],
			colModel:[
			          {name:'id', index:'id',hidden:true},
			          {name:'ddid', index:'ddid', label:'订单号'},
			          {name:'chdh', index:'chdh', label:'出货通知书单号'},
			          {name:'khbm', index:'khbm', label:'客户编码'},
			          {name:'khmc', index:'khmc', label:'客户名称'},
			          {name:'ddzje', index:'ddzje', label:'订单总金额'},
			          {name:'bz', index:'bz', label:'订单币种'}
			          ],
		    url:"<c:url value='/price/skdPriceAdjust/qryDdxx'/>"
		},{
			callback:function(rows){
				if(rows){			
					removeFormProp();	
					$("#form-submit [name=ddid]").val(rows.ddid);
					$("#form-submit [name=chdh]").val(rows.chdh);
					$("#form-submit [name=khbm]").val(rows.khbm);
					$("#form-submit [name=khmc]").val(rows.khmc);
					$("#form-submit [name=ddzje]").val(rows.ddzje);
					$("#form-submit [name=bz]").val(rows.bz);
					addFormProp();
					$.bindAjax({
						url:"<c:url value='/price/skdPriceAdjust/qryJhd'/>",
						data:{ddid:rows.ddid,chdh:rows.chdh},
						action:"search"
					},function(response){
						
						// 加载明细
						if(response.skdPriceAdjustItemList){
							$(grid_selector).jqGrid("clearGridData");
							$(grid_selector).jqGrid("addRowData", null, response.skdPriceAdjustItemList, "last");
						  	$(grid_selector).removeData('lastEdit');
		
						}
					}); 
					

				}else{
					removeFormProp();
					$("#form-submit [name=ddid]").val("");
					$("#form-submit [name=chdh]").val("");
					$("#form-submit [name=khbm]").val("");
					$("#form-submit [name=khmc]").val("");
					$("#form-submit [name=ddzje]").val("");
					$("#form-submit [name=bz]").val("");
					addFormProp();
				}
			}
		});
	}
	
	
	function removeFormProp(){
	
		$('#form-submit [name=chdh]').removeProp("disabled").removeAttr('disabled');
		$('#form-submit [name=khbm]').removeProp("disabled").removeAttr('disabled');
		$('#form-submit [name=khmc]').removeProp("disabled").removeAttr('disabled');
		$('#form-submit [name=ddzje]').removeProp("disabled").removeAttr('disabled');
		$('#form-submit [name=ztmc]').removeProp("disabled").removeAttr('disabled');
	}
	function addFormProp(){
	
		$('#form-submit [name=chdh]').prop('disabled','disabled');
		$('#form-submit [name=khbm]').prop('disabled','disabled');
		$('#form-submit [name=khmc]').prop('disabled','disabled');
		$('#form-submit [name=ddzje]').prop('disabled','disabled');
		$('#form-submit [name=ztmc]').prop('disabled','disabled');
	
	}
	//校验明细行中，免费行项目不允许有单价
	function validData(data){
		var flag = true;	
		var hh = "";
		$.each(data, function(i,v){  
			if((v.xmlb == "免费备损" || v.xmlb == "免费大货") && (Number(v.tzdj) != 0 || Number(v.tzje) != 0)){
				flag = false;
				hh = hh + (i+1) + ",";
			}
        }); 
		if(!flag){
			hh = "第" + hh +"免费项目单价必须为0！";
		}
		return hh;
	}
</script>
</html>