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
										<label class="input-group-addon">收款银行&nbsp;&nbsp;</label>		
										<select role="select" name="skyh" size="1" class="form-control skyselect">										
												${fns:loadBankInfoOption('0')}
										</select>
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
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>		
										<select role="select" name="zt" size="1" class="form-control skyselect">											
											${fns:loadDictOption('DJZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">认领状态&nbsp;&nbsp;</label>		
										<select role="select" name="rlzt" size="1" class="form-control skyselect">											
											${fns:loadDictOption('SKRLZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">财务登记人&nbsp;&nbsp;</label>
										<input type="text" name="zdrmc" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">接单主体&nbsp;&nbsp;</label>
										<select role="select" name="gsbm" size="1" class="form-control skyselect">
											${fns:loadCompanyOption('0')}
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
									<label class="input-group-addon">总金额&nbsp;&nbsp;</label> 
								    <input type="text" name="zje" readonly class="form-control"   />
								</div>
							</div>
			      	 </div>
			      	 <div class="space-4"></div>
			      	 <div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">已认领金额&nbsp;&nbsp;</label> 
								<input type="text" name="yrlje" readonly class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">未认领金额&nbsp;&nbsp;</label> 
							    <input type="text" name="wrlje" readonly class="form-control"   />
							</div>
						</div>
			      	 </div>
			      	 <div class="space-4"></div>
			      	 <div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">已冻结金额&nbsp;&nbsp;</label> 
								<input type="text" name="djje" readonly class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">参考手续费&nbsp;&nbsp;</label> <input
									type="text" name="cksxf" readonly class="form-control"   />
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
		      	
		      		<form id="consoleBzxxDlg">
		      	     <input type="hidden"  name="id"  />
		      	     <input type="hidden"  name="sjc"  />
			      	
			      	 <div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">备注信息（参考号）&nbsp;&nbsp;</label> 
								<input type="text" name="bzxx"  class="form-control"   />
							</div>
						</div>
					
			      	 </div>
			      	 <div class="space-4"></div>
			      	 <div class="row">
			      	 	 <div class="col-xs-6 col-sm-6" align="left">
							<button id="btn_ok" type="button" class="btn btn-info  btn-minier bigger" onclick="modifyBzxx()">
								<i class="icon-ok icon-on-left bigger-110"></i>
								确定
							</button> 
							&nbsp;&nbsp;&nbsp;
						    <button id="btn_cancel" type="button" class="btn btn-danger btn-minier bigger"  onclick="cancel2()">
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
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	var isEdit = false;
	var editurl = "<c:url value='/payment/payReceive/editPage'/>";
	var searchurl = "<c:url value='/payment/payReceive/search'/>";
	var cancelurl = "<c:url value='/payment/payReceive/cancel'/>";
	var tssapurl = "<c:url value='/payment/payReceive/pushSAP'/>";
	<shiro:hasPermission name="payment:payReceive:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		// 配置模态对话框
		$("#consoleDlg").dialog({
		autoOpen : false, // 是否自动弹出窗口
		modal : true, // 设置为模态对话框
		resizable : true,
		width : 600,
		height : 250,
		position : "center" // 窗口显示的位置
		});
		
		// 配置模态对话框
		$("#consoleBzxxDlg").dialog({
		autoOpen : false, // 是否自动弹出窗口
		modal : true, // 设置为模态对话框
		resizable : true,
		width : 600,
		height : 250,
		position : "center" // 窗口显示的位置
		});
		$(".skyselect").select2();
		$("#form-search [name=zdsj]").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$("#form-search [name=skrq]").bindDateRange({startElement:$("#ssksj"),endElement:$("#esksj")});
		
		$(grid_selector).bindTable({
			caption: "",
			url: searchurl,
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
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'skdh', index:'skdh', label:'收款单号', width:80, formoptions:{rowpos: 2, colpos: 1}},
				{name:'zt', label:'状态', hidden: true, width:60},
				{name:'ztmc', index:'ztmc', label:'状态', width:80},
				{name:'rlzt', index:'rlzt', label:'认领状态', width:80},
				{name:'je', index:'je', label:'金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'sjsxf', index:'sjsxf', label:'实际手续费', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'zje', index:'zje', label:'总金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'yrlje', index:'yrlje', label:'已认领金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'wrlje', index:'wrlje', label:'未认领金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'sykrlje', index:'sykwrlje', label:'剩余可认领金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'bz', index:'bz', label:'币种', width:60},
				{name:'sklb', index:'sklb', label:'收款类别', width:60, hidden:true},
				{name:'sklbmc', index:'sklbmc', label:'收款类别', width:80},
				{name:'fkr', index:'fkr', label:'付款人', width:100},
				{name:'fkyh', index:'fkyh', label:'付款银行', width:100},
				{name:'fkgj', index:'fkgj', label:'付款国家', width:80, hidden: true},
				{name:'fkgjmc', index:'fkgjmc', label:'付款国家', width:80, formoptions:{rowpos: 4, colpos: 2}},
				{name:'skrq', index:'skrq', label:'收款日期', width:100, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'skyh', index:'skyh', label:'收款银行', width:100, hidden: true},
				{name:'skyhmc', index:'skyhmc', label:'收款银行', width:100},
				{name:'gsbm', index:'gsbm', label:'接单主体', width:80},
				{name:'cksxf', index:'cksxf', label:'参考手续费', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:105, formatter:tsSAPCellAddHref},
				{name:'bzxx', index:'bzxx', label:'备注信息（参考号）', width:100},
				{name:'zdrmc', index:'zdrmc', label:'财务登记人', width:100},
				{name:'zdsj', index:'zdsj', label:'登记时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bbh', index:'bbh', label:'版本号', width:60, hidden: true},
				{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true},
				/* {name:'sprid', index:'sprid', label:'审批人', width:80, hidden: true},
				{name:'sprmc', index:'sprmc', label:'审批人', width:80},
				{name:'spsj', index:'spsj', label:'审批时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'spyj', index:'spyj', label:'审批意见', width:100, hidden: true}, */
				{name:'sfBg', label:'sfBg', hidden: true, width:60},
				{name:'sfQx', label:'sfQx', hidden: true, width:60},
				{name:'djje', index:'djje', label:'冻结金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'djyy', index:'djyy', label:'冻结原因', width:150},
				{name:'jybz', index:'jybz', label:'认领币种', width:150},
				{name:'hl', index:'hl', label:'汇率', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}}
			],
			sortname: 'skdh',
			sortorder: 'asc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:false,
			addfunc:addfunc,
			editfunc:editfunc,
			delfunc:delfunc
		}).jqGrid('setFrozenColumns');
		
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"取消", 
			buttonicon:"fa-square-o orange", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5){
						swal("","请选择一行已生效数据！","warning");
					}else{
						$("body").bindSweetAlert({
							title:"确定要取消吗?"
						},{
							callback:function(){
								$.bindAjax({
									url:cancelurl,
									data:{id:id, sjc:rowData.sjc, sklb:rowData.sklb},
									action:"edit"
								},function(response){
									$(grid_selector).trigger("reloadGrid");
								});
							}
						});
					}
				}
			},
			position:"last"
		});
		
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
						swal("","请选择一行已生效数据！","warning");
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
					if(rowData.zt != 8 && rowData.zt!=5){
						swal("","请选择一行已冻结或生效数据！","warning");
						return;
					}
					//解冻
					initDlg(rowData,1);
				}
			},
			position:"last"
		});
		//修改参考号
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"修改参考号", 
			buttonicon:"fa-pencil-square green", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					
					//修改参考号
					initBzxxDlg(rowData);
				}
			},
			position:"last"
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"推送SAP", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
					if(rowData.zt != 5 || rowData.tssapzt == "已通过" || rowData.sklb == 3){
						swal("","请选择一行已生效且未推送sap且收款类别不为CN的数据！","warning");
						return;
					}
					$.bindAjax({
						url : tssapurl,
						data:{id : id},
						action:"edit"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
				}
			},
			position:"last"
		});
		//初始化对话框数据
		function initDlg(rowData,type){
			$('#consoleDlg [name=type]').val(type);
			$('#consoleDlg [name=id]').val(rowData.id);
			$('#consoleDlg [name=sjc]').val(rowData.sjc);
			$('#consoleDlg [name=bz]').val(rowData.bz);
			$('#consoleDlg [name=zje]').val(rowData.zje);
			$('#consoleDlg [name=yrlje]').val(rowData.yrlje);
			$('#consoleDlg [name=wrlje]').val(rowData.wrlje);
			$('#consoleDlg [name=djje]').val(rowData.djje);
			$('#consoleDlg [name=cksxf]').val(rowData.cksxf);
			$('#consoleDlg [name=djyy]').val(rowData.djyy);
			$('#consoleDlg [name=djjdje]').val("");
			$("#consoleDlg").dialog("option", "title", "收款(冻结/解冻)").dialog("open");
		}
		
		//初始化对话框数据
		function initBzxxDlg(rowData){
			$('#consoleBzxxDlg [name=id]').val(rowData.id);
			$('#consoleBzxxDlg [name=sjc]').val(rowData.sjc);
			$('#consoleBzxxDlg [name=bzxx]').val("");
			$("#consoleBzxxDlg").dialog("option", "title", "修改参考号").dialog("open");
		}
		
		
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/payReceive/export'/>"});
	    			}
	    		});
	        }
		});
		function initSelect2(elem){
			$(elem).width(140).select2();
		}
		
	});
	//取消
    function cancel(){
    	$("#consoleDlg input").attr("value","");
    	$("#consoleDlg").dialog("close")
	}
	
  //取消
    function cancel2(){
    	$("#consoleBzxxDlg input").attr("value","");
    	$("#consoleBzxxDlg").dialog("close")
	}
	
	//确定冻结/解冻
	function frozen(){
		var param = $("#consoleForm").getFormData();
		cancel(); 
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
					url : "<c:url value='/payment/payReceive/frozen'/>",
					data : param,
					action : "save"
				}, function(response) {
					$(grid_selector).trigger("reloadGrid");
				});
			}
	   }); 
	}
	
	//修改备注信息
	function modifyBzxx(){
		var param = $("#consoleBzxxDlg").getFormData();
		cancel2(); 
		$("body").bindSweetAlert({
			title : "确定要调整备注信息吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payReceive/modifyBzxx'/>",
					data : param,
					action : "save"
				}, function(response) {
					$(grid_selector).trigger("reloadGrid");
				});
			}
	   }); 
	}
	
	//新增
	function addfunc(){
		location.href = editurl+"?oper=add";
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
			if (zt == 2 || zt == 5 || zt == 6) {
				swal("","只允许修改草稿和驳回状态的单据！","warning");
				return;
			}else{
				location.href = editurl + "?id=" + selr;
			}
		}
	}
	
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr == null || selr == ""){
			swal("", "请选择一行数据！", "warning");
			return;
		}else{
			if(zt != 1) {
				swal("", "只允许删除草稿状态的单据！", "warning");
				return;
			} else {
				$("body").bindSweetAlert({
					title:"确定要删除吗?"
				},{
					callback:function(){
						$.bindAjax({
							url:"<c:url value='/payment/payReceive/delete'/>",
							data:{id:rowData.id,sjc :rowData.sjc},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
			}
		}
	}
	
	function tsSAPCellAddHref(cellvalue, options, rowData){
		var html = "<a onclick=\"tssapCellShowLog('"+ rowData.id +"')\" style='text-decoration:underline;color:blue;cursor:pointer;'>"
		if(cellvalue == "1"){
			html = "已通过";
		} else if(cellvalue == "0"){
			html += "未通过</a>";
		}
		return html;
	}
	
	function tssapCellShowLog(id){
		$.bindAjax({
			url:"<c:url value='/log/sapInterfaceLog/search'/>",
			data:{id:id},
			action:"search"
		},function(response){
			if(response[0]){
				bootbox.dialog({
					title : "推送SAP日志",
					message : response[0].fhxx
				});
			}
		});
	}
</script>
</html>