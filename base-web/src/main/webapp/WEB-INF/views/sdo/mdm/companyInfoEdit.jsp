<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>    	
</head>
	 <%
		String id = request.getParameter("id");
	 %>
<body>
<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<div class="row" style="margin: 0px 8px;">
						<input type="hidden" name="id"/>
						<input type="hidden" name="oper"/>
						<div class="col-xs-6 col-sm-6">
						    <button id="btn-back" type="button" class="btn btn-sm">
								<i class="icon-undo icon-on-right bigger-110"></i> 返回
							</button>
							&nbsp;
							<button id="btn-save" type="button"
								class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i> 保存
							</button>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">公司基础信息</h5>
					<div class="space-4"></div>
					<!--公司基础信息你-->
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-8 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司编码&nbsp;&nbsp;</label> <input
									type="text" name="gsbm" class="form-control" />
							</div>
						</div>
						<div class="col-xs-8 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">SAP公司代码&nbsp;&nbsp;</label> <input
									type="text" name="sapgsdm" class="form-control" />
							</div>
						</div>
						<div class="col-xs-8 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司中文名称&nbsp;&nbsp;</label> <input
									type="text" name="gszwmc" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司英文名称&nbsp;&nbsp;</label> 
								<input type="text" name="gsywmc" class="form-control" />
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司中文地址&nbsp;&nbsp;</label> 
								<!-- <input type="text" name="gszwdz" class="form-control" /> -->
								<textarea name="gszwdz" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">公司英文地址&nbsp;&nbsp;</label> 
								<!-- <input type="text" name="gsywdz" class="form-control" /> -->
								<textarea name="gsywdz" class="autosize-transition form-control"></textarea>
							</div>
						</div>
						<div class="col-xs-6 col-sm-4">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">备注&nbsp;&nbsp;</label>
								<!-- <input type="text" name="bz" class="form-control" /> -->
								<textarea name="bz" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<!-- 公司银行账号 -->
					<div class="space-4"></div>
					<h5 class="header blue" style="margin-top: 4px;">公司银行账号信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;" id="grid-parent">
						<table id="grid-table"></table>
						<div id="grid-pager"></div>
					</div>
				</form>
				<!-- PAGE CONTENT ENDS -->
			</div>
		</div>
	</div>
	<!-- /.page-content -->
<span class="loading-indicator">
	<label><i class="icon-spinner icon-spin  icon-large"></i> 处理中... </label>
</span>
</body>
<script type="text/javascript">
	// 变量定义开始
	var id = "<%=id%>";
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	// 不可编辑
	var isEdit = false;
	// 权限判断
	<shiro:hasPermission name="mdm:companyInfo:edit">isEdit = true;</shiro:hasPermission>

	$(function($) {
		//初始化公司银行账号
		$(grid_selector).bindTable({
			caption : "",
		    datatype : "json",
			pager : pager_selector,
			gridParent : "#grid-parent",
			//去掉编辑表分页按钮
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			//shrinkToFit: false,
			//autoScroll: false,
			colModel : [{name : 'id', label : 'ID', hidden : true, width : 60, editable : false},
					    {name : 'zwmc', index : 'zwmc', label : '银行', width : 80, editable : true, editoptions:{dataInit: initYh}}, 
					    {name : 'ywmc', index : 'ywmc', label : '银行（英文）', width : 80,editoptions:{disabled:true}}, 
					    {name : 'swiftdm', index : 'swiftdm', label : 'SWIFT代码', width : 80,editoptions:{disabled:true}}, 
					    {name : 'yhzh', index : 'yhzh', label : '银行账号', width : 80, editable : true},
					    {name : 'bz', index : 'bz', label : '币种', width : 80, editable : true,
					    	edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('BZ')}"}},
					    {name : 'sfLc', index : 'sfLc', label : '是否LC', width : 80, editable : true,
					    	edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
					    {name : 'bzxx', index : 'bzxx', label : '备注信息', width : 80, editable : true}
			],
			editTable : true
		},{ add:isEdit,
			edit:isEdit,
			del:isEdit
		});
		 //加载数据
		if(id != "null"){
			$("#form-submit [name=id]").val(id);
			$.bindAjax({
				url : "<c:url value='/mdm/companyInfo/findById'/>",
				data : "id="+id,
				action : "search"
			},function(result) {
				$("#form-submit").setFormData(result);
			    $(grid_selector).jqGrid("addRowData", null, result.companyBankAccountList,"last");
			    $("#form-submit [name=oper]").val("edit");
			});
		}else{
			$("#form-submit [name=oper]").val("add");
		}
		
		//保存按钮
		$("#btn-save").click(function(){
			save();
		});
		 
		//返回按钮
		$('#btn-back').click(function(){
			location.href = "<c:url value='/mdm/companyInfo'/>";
		});
	});
	
	// 保存
	function save(){
		var param = $("#form-submit").getFormData();
	    //保存编辑数据
		var lastEdit = $(grid_selector).data('lastEdit');
		if(lastEdit){
			$(grid_selector).saveRow(lastEdit, false, 'clientArray');
		}
		//客户银行
		var bankAcount_data = $(grid_selector).getRowData();
		param.bankAccountList = JSON.stringify(bankAcount_data);
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		}, {callback : function(){
				$.bindAjax({
					url : "<c:url value='/mdm/companyInfo/edit'/>",
					data : param,
					action : "save",
					//contentType:"application/json;charset=utf-8",
					text : "成功！",
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	
	// 初始化编辑表银行选择
	function initYh(elem){
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function(){
			$.tableDialogPage({
				title:"银行选择",
				searchCond:[{"name":"银行名称","value":"zwmc"},
				            {"name":"SWIFT代码","value":"swiftdm"}],
				colModel:[{name:'zwmc', index:'zwmc', label:'银行名称', width:80},
				          {name:'ywmc', index:'ywmc', label:'银行英文', width:80},
						  {name:'swiftdm', index:'swiftdm', label:'swift代码', width:80}],
				url:"<c:url value='/pub/widget/findBank'/>"
			},{
				callback:function(rows){
					if(rows){
						$(elem).val(rows.zwmc);
						$(elem).closest("tr.jqgrow").find("input[name='swiftdm']").val(rows.swiftdm);
						$(elem).closest("tr.jqgrow").find("input[name='ywmc']").val(rows.ywmc);
					}else{
						$(elem).val("");
						$(elem).closest("tr.jqgrow").find("input[name='ywmc']").val("");
					}
					
				}
			});
		});
	}	
</script>
</html>