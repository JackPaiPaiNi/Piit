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
						&nbsp;
						<button id="btn-export-mx" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i> 导出交单明细
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
								<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">信用证号&nbsp;&nbsp;</label>
										<input type="text" name="lcbh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">申请人&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">开证日期&nbsp;&nbsp;</label>
										<input type="text" name="kzrq" id="kzrq" class="form-control"/>
										<input type="hidden" id="skzrq" name="skzrq"/>
										<input type="hidden" id="ekzrq" name="ekzrq"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">受益人&nbsp;&nbsp;</label>
										<select role="select" name="gsbm" size="1" class="form-control skyselect">
											${fns:loadCompanyOption('0')}
										</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">开证行&nbsp;&nbsp;</label>
										<input type="text" name="kzh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">开证行SWIFT&nbsp;&nbsp;</label>
										<input type="text" name="kzhdm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">登记日期&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" id="zdsj" class="form-control"/>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
							    <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>		
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('DJZT')}
										</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">发票号&nbsp;&nbsp;</label>
										<input type="text" name="fph" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人（交单明细）&nbsp;&nbsp;</label>
										<input type="text" name="cwymc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否已维护过交单明细&nbsp;&nbsp;</label>		
										<select role="select" name="sfywh" size="1" class="form-control skyselect">
											${fns:loadDictOption('SF')}
										</select>
									</div>
								</div>
							</div>
						</form>
						<div class="space-4"></div>
					</div>
				</div>
			</div>
			
			<table id="grid-table"></table>
			
			<div id="grid-pager"></div>
			
			<div id="grid-parent-mx" hidden="hidden">
				<table id="grid-table-mx"></table>
				<div id="grid-pager-mx"></div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
<div id="consoleDlg" class="page-content" >
	   <hr cellspacing="0" cellpadding="0">
	   <div id="formContainer" class="row">
	      <div class="col-xs-12">
		      	<form id="consoleForm">
		      	     <input type="hidden"  name="id"  />
		      	     <input type="hidden"  name="sjc"  />
		      	     <input type="hidden"  name="type"  />
			      	 <div class="row">
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">币种&nbsp;&nbsp;</label> 
									<input type="text" name="bz" readonly class="form-control"   />
								</div>
							</div>
							<div class="col-xs-6 col-sm-6">
								<div class="input-group input-group-sm">
									<label class="input-group-addon">LC金额&nbsp;&nbsp;</label> 
								    <input type="text" name="je" readonly class="form-control"   />
								</div>
							</div>
			      	 </div>
			      	 <div class="space-4"></div>
			      	 <div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">已使用金额&nbsp;&nbsp;</label> 
								<input type="text" name="ysyje" readonly class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">已冻结金额&nbsp;&nbsp;</label> 
							    <input type="text" name="djje" readonly class="form-control"   />
							</div>
						</div>
			      	 </div>
			      	 <div class="space-4"></div>
			      	 <div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">本次冻结/解冻金额&nbsp;&nbsp;</label> 
								<input type="text" name="djjdje"  class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">本次冻结/解冻原因&nbsp;&nbsp;</label> 
								<input type="text" name="djyy"  class="form-control"   />
							</div>
						</div>
			      	 </div>
			      	 <div class="space-4"></div>
			      	 <div class="row">
			      	 	 <div class="col-xs-6 col-sm-6" align="left">
							<button id="btn_ok" type="button" class="btn btn-info  btn-minier bigger" onclick="frozen()">
								<i class="icon-ok icon-on-left bigger-110"></i>
								确定
							</button> 
							&nbsp;&nbsp;&nbsp;
						    <button id="btn_cancel" type="button" class="btn btn-danger btn-minier bigger"  onclick="cancel()">
								 <i class="fa-times icon-on-right bigger-110"></i>
								取消
							</button> 
						</div>
			      	 </div>
		      	</form>
	      	</div>
	      </div>
	   </div>
</body>
<script type="text/javascript">
    var grid_mx_selector = "#grid-table-mx";
    var pager_mx_selector = "#grid-pager-mx";
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	var editurl="<c:url value='/payment/lcReg/editPage'/>";
	var delurl="<c:url value='/payment/lcReg/delete'/>";
	var viewurl="<c:url value='/payment/lcReg/qryPage'/>";//查看详情页面
	var isEdit = false;
	<shiro:hasPermission name="payment:lcReg:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		// 配置模态对话框
		$("#consoleDlg").dialog({
		autoOpen : false, // 是否自动弹出窗口
		modal : true, // 设置为模态对话框
		resizable : true,
		width : 600,
		height : 220,
		position : "center" // 窗口显示的位置
		});
		$(".skyselect").select2();
		$("#zdsj").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$("#kzrq").bindDateRange({startElement:$("#skzrq"),endElement:$("#ekzrq")});
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/payment/lcReg/search'/>",
			editurl: editurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, frozen:true},
				{name:'lcbh', index:'lcbh', label:'信用证号', width:120, frozen:true},
				{name:'zt', index:'zt', label:'状态', width:80, hidden:true, frozen:true},
				{name:'ztmc', index:'ztmc', label:'状态',  width:70, frozen:true},
				{name:'khbm', index:'khbm', label:'申请人编码', width:120, frozen:true},
				{name:'khmc', index:'khmc', label:'申请人名称', width:120, frozen:true},
				{name:'processId', label:'processId', hidden: true, width:60},
				{name:'taskId', label:'taskId', hidden: true, width:60},
				{name:'je', index:'je', label:'LC金额', width:120,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'ysyje', index:'ysyje', label:'已使用', width:100,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'ye', index:'ye', label:'余额', width:100,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'djje', index:'djje', label:'冻结金额', width:100,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'djyy', index:'djyy', label:'冻结原因', width:100,align:'right'},
				{name:'kzh', index:'kzh', label:'开证行', width:100,},
				{name:'kzhdm', index:'kzhdm', label:'开证行SWIFT', width:80},
				{name:'zbcfc', index:'zbcfc', label:'正本存放处', width:150},
				{name:'kzrq', index:'kzrq', label:'开证日期', width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'gsbm', index:'gsbm', label:'受益人', width:120, edittype:"select", formatter: "select", editoptions:{value:"${fns:loadCompanyOption('1')}"}},
				{name:'yxq', index:'yxq', label:'有效期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bbh', index:'bbh', label:'版本号', width:60},
				{name:'zdrmc', index:'zdrmc', label:'登记人名称', width:80},
				{name:'zdsj', index:'zdsj', label:'登记日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true},
				{name:'sfBg', label:'sfBg', hidden: true, width:60},
				{name:'sfQx', label:'sfQx', hidden: true, width:60}
			],
			sortname: 'lcbh',
			sortorder: 'asc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:true,
			addfunc:addfunc,
			editfunc:editfunc,
			viewfunc:viewfunc,
			delfunc:delfunc
		}).jqGrid('setFrozenColumns');
		
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"变更", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5){
						swal("","请选择一行已生效数据！","warning");
						return;
					}
					location.href = editurl + "?id=" + id + "&sjc=" + rowData.sjc + "&sfBg=1";
				}
			},
			position:"last"
		});
		
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"维护交单明细", 
			buttonicon:"icon-edit", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id == null || id==""){
					swal("","请选择一行数据！","warning");
					return;
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5){
						swal("","请选择一行已生效数据！","warning");
						return;
					}
					location.href = "<c:url value='/payment/lcReg/jdmxEditPage'/>" + "?id=" + id+ "&processId=" + rowData.processId;
				}
			},
			position:"last"
		});
		<shiro:hasPermission name="payment:lcReg:djjd">
		//冻结
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"冻结", 
			buttonicon:"fa-pencil-square orange", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5){
						swal("","请选择一行已生效的数据！","warning");
						return;
					}
					//冻结
					initDlg(rowData,0);
				}
			},
			position:"last"
		});
		//解冻
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"解冻", 
			buttonicon:"fa-pencil-square green", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if( rowData.zt != 8 && rowData.zt != 5 ){
						swal("","请选择一行已冻结或部分冻结的生效数据！","warning");
						return;
					}
					//冻结
					initDlg(rowData,1);
				}
			},
			position:"last"
		});
		</shiro:hasPermission>
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/lcReg/export'/>"});
	    			}
	    		});
	        }
		});
		
		//交单明细导出
		$(grid_mx_selector).bindTable({
			caption: "",
			pager: pager_mx_selector,
			gridParent: "#grid-parent-mx",
			rowList: [5, 10, 15],
		    rowNum:5,
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
						/* {name : 'id', index : 'id', label : 'ID'},*/
						{name : 'zdsj', index : 'zdsj', label : '登记日期',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'lcbh', index : 'lcbh', label : '信用证号'},
						{name : 'hqrq', index : 'hqrq', label : '收到日期',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'gsmc', index : 'gsmc', label : '受益人'},
						{name : 'khmc', index : 'khmc', label : '申请人'},
						{name : 'khbm', index : 'khbm', label : '申请人编码'},
						{name : 'xsfph', index : 'xsfph', label : '形式发票号'},
						{name : 'yhckh', index : 'yhckh', label : '银行参考号'},
						{name : 'kzh', index : 'kzh', label : '开证行'},
						{name : 'kzhdm', index : 'kzhdm', label : '开证行SWIFT'},
						{name : 'tzh', index : 'tzh', label : '通知行'},
						{name : 'bz', index : 'bz', label : '币种'},
						{name : 'je', index : 'je', label : '信用证总金额'},
						{name : 'kzrq', index : 'kzrq', label : '开证日期',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'yxq', index : 'yxq', label : '信用证有效期',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'zwzcq', index : 'zwzcq', label : '最晚装船期',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'yfjdq', index : 'yfjdq', label : '议付交单期(天）'},
						{name : 'yfhcksj', index : 'yfhcksj', label : '议付后付款期(天)'},
						{name : 'zbcfc', index : 'zbcfc', label : '信用证正本存放处'},
						{name : 'xgbbh', index : 'xgbbh', label : '信用证修改版号'},
						{name : 'ysyje', index : 'ysyje', label : '已使用金额'},
						{name : 'ye', index : 'ye', label : '余额'},
						{name : 'djje', index : 'djje', label : '冻结金额'},
						{name : 'djyy', index : 'djyy', label : '冻结原因'},
						{name : 'fph', index : 'fph', label : '发票号'},
						{name : 'fpje', index : 'fpje', label : '发票金额 (USD)'},
						{name : 'xyzxzmc', index : 'xyzxzmc', label : '信用证性质'},
						{name : 'fktjmc', index : 'fktjmc', label : 'L/C付款条件'},
						{name : 'fprq', index : 'fprq', label : '发票日期',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'chdh', index : 'chdh', label : '出货通知书号'},
						{name : 'yzhdh', index : 'yzhdh', label : '预走货单号'},
						{name : 'ddid', index : 'ddid', label : '订单号'},
						{name : 'qymc', index : 'qymc', label : '区域'},
						{name : 'xsymc', index : 'xsymc', label : '销售员'},
						{name : 'xsyid', index : 'xsyid', label : '销售员代码'},
						{name : 'cwymc', index : 'cwymc', label : '船务员'},
						{name : 'wjjryhrq', index : 'wjjryhrq', label : '文件寄入银行日期',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'etdkcrq', index : 'etdkcrq', label : 'ETD开船日',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'tzhjdrq', index : 'tzhjdrq', label : '通知行寄单日期',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'gzhm', index : 'gzhm', label : '跟踪号码'},
						{name : 'lcbfxx', index : 'lcbfxx', label : '信用证不符(V)'},
						{name : 'bfdfy', index : 'bfdfy', label : '不符点费用(USD)'},
						{name : 'fj', index : 'fj', label : '附件'},
						{name : 'bfdyy', index : 'bfdyy', label : '不符点原因'},
						{name : 'dqfkr', index : 'dqfkr', label : '到期付款日',width : 90, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name : 'sfyhk', index : 'sfyhk', label : '是否已汇款', edittype:"select", formatter: "select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
						{name : 'hkje', index : 'hkje', label : '实收货款金额(USD) - 已扣銀行費用'},
						{name : 'ce', index : 'ce', label : '发票金额与实际货款的差额(原因:扣除相关银行手续费或不符点费用) (USD)'},
						{name : 'mxbzxx', index : 'mxbzxx', label : '备注'}

					]
		},{
			add:false,
			edit:false,
			del:false
			
		});
		
		$("#btn-export-mx").click(function(){  
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
	    				$(grid_mx_selector).exportExcelNoData({url: "<c:url value='/payment/lcReg/exportitem'/>"});
	    			}
	    		});
	        }
		});
	
	});
	
	//新增
	function addfunc(){
		location.href = editurl;
	}
	
	//编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr == null || selr == ""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (zt == 2) {
				swal("", "该单据正在审批中,不能修改！", "warning");
				return;
			}else if(zt == 3){
				swal("", "驳回的单据,请在代办页面进入编辑！", "warning");
				return;
			}else if (zt == 4 || zt == 5) {
				swal("", "该单据已生效,不能修改！", "warning");
				return;
			} else {
				location.href = editurl + "?id=" + selr;
			}
		}
	}
	
	//取消
    function cancel(){
    	$("#consoleDlg input").attr("value","");
    	$("#consoleDlg").dialog("close")
	}
	//冻结，解冻
	function frozen(){
		    var param = $("#consoleForm").getFormData();
		    cancel() ;
		    var msg = "" ;
		    if(param.type==0){
		    	msg="冻结";
		    }else{
		    	msg="解冻";
		    }
			$("body").bindSweetAlert({
				title : "确定要"+msg+"吗?"
			}, {
				callback : function() {
					$.bindAjax({
						url : "<c:url value='/payment/lcReg/frozen'/>",
						data : param,
						action : "save"
					}, function(response) {
						$(grid_selector).trigger("reloadGrid");
					});
				}
		   });
	}
	
	//初始化对话框数据
	function initDlg(rowData,type){
		$('#consoleDlg [name=type]').val(type);
		$('#consoleDlg [name=id]').val(rowData.id);
		$('#consoleDlg [name=sjc]').val(rowData.sjc);
		$('#consoleDlg [name=bz]').val(rowData.bz);
		$('#consoleDlg [name=je]').val(rowData.je);
		$('#consoleDlg [name=ysyje]').val(rowData.ysyje);
		$('#consoleDlg [name=djje]').val(rowData.djje);
		$('#consoleDlg [name=djyy]').val(rowData.djyy);
		$('#consoleDlg [name=djjdje]').val("");
		$("#consoleDlg").dialog("option", "title", "LC(冻结/解冻)").dialog("open");
	}
	
	
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		location.href = viewurl + "?id=" + id + "&processId=" + rowData.processId;
	}
	
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr == null || selr == ""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (zt != 1 && zt !=3) {
				swal("", "只能删除草稿或驳回的单据!", "warning");
				return;
			}else{
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?"/* ,
	    			closeOnConfirm: true */
	    		},{
	    			
	    			callback:function(){
	    				$.bindAjax({
	    					url:delurl,
	    					data:{id : rowData.id, sjc : rowData.sjc, zt : rowData.zt, processId : rowData.processId},
	    					action:"edit"
	    				},function(response){
	    					$(grid_selector).trigger("reloadGrid");
	    				}); 
	    			}
	    		});
			}
		}
	}
</script>
</html>