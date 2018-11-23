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
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddh" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">认领单号&nbsp;&nbsp;</label>
										<input type="text" name="rldh" class="form-control"/>
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
										<label class="input-group-addon">认领时间&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">接单主体&nbsp;&nbsp;</label>		
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
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>		
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('DJZT')}
										</select>
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
										<label class="input-group-addon">认领人&nbsp;&nbsp;</label>
										<input type="text" name="zdrmc" class="form-control"/>
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
								<label class="input-group-addon">已认领金额&nbsp;&nbsp;</label> 
								<input type="text" name="je" readonly class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">已冻结金额&nbsp;&nbsp;</label> 
								<input type="text" name="ydjje" readonly class="form-control"   />
							</div>
						</div>
					
			      	 </div>
			      	
			      	  <div class="space-4"></div>
			      	 <div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">本次冻结/解冻金额&nbsp;&nbsp;</label> 
								<input type="text" name="djje"  class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">本次冻结/解冻原因&nbsp;&nbsp;</label> 
								<input type="text" name="bzxx"  class="form-control"   />
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
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	var searchurl = "<c:url value='/payment/payReceiveClaim/search'/>";
	var editurl = "<c:url value='/payment/payReceiveClaim/editPage'/>";
	var cancelurl = "<c:url value='/payment/payReceiveClaim/cancel'/>";
	var isEdit = false;
	<shiro:hasPermission name="payment:payReceiveClaim:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		// 配置模态对话框
		$("#consoleDlg").dialog({
		autoOpen : false, // 是否自动弹出窗口
		modal : true, // 设置为模态对话框
		resizable : true,
		width : 600,
		height : 250,
		position : "center" // 窗口显示的位置
		});
		$(grid_selector).bindTable({
			caption: "",
			url: searchurl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:true},
				{name:'rldh', index:'rldh', label:'认领单号', width:100,  editrules:{edithidden:true}},
				{name:'skdh', index:'skdh', label:'收款单号', width:100,  editrules:{edithidden:true}},
				{name:'zdrmc', index:'zdrmc', label:'认领人', width:80,  editrules:{edithidden:true}},
				{name:'zt', label:'状态', hidden: true, width:60, frozen:true},
				{name:'ztmc', index:'ztmc', label:'状态', width:70, frozen:true},
				{name:'khbm', index:'khbm', label:'客户编码', width:100,  editrules:{edithidden:true}},
				{name:'khmc', index:'khmc', label:'客户名称', width:120, editrules:{edithidden:true}},
				{name:'sklxmc', index:'sklxmc', label:'收款类型', width:100, editrules:{edithidden:true}},
				{name:'bz', index:'bz', label:'收款币种', width:80 ,editrules:{edithidden:true}},
				{name:'je', index:'je', label:'认领金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true}},
				{name:'sjsxf', index:'sjsxf', label:'实际手续费', width:100,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true}},
				{name:'zje', index:'zje', label:'总金额', width:100,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true}},
				{name:'rljetz', index:'rljetz', label:'认领金额调整', width:100,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true},  hidden: true},
				{name:'ybdje', index:'ybdje', label:'已绑定金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true}},
				{name:'djje', index:'djje', label:'冻结金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true}},
				{name:'fph', index:'fph', label:'发票号', width:100,  editrules:{edithidden:true}},
				{name:'fktj', index:'fktj', label:'付款条件', width:100, editrules:{edithidden:true}},
				{name:'fktjmc', index:'fktjmc', label:'付款条件名称', width:100, editrules:{edithidden:true}},
				{name:'fpje', index:'fpje', label:'发票金额', width:80,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true}},
				{name:'fpbz', index:'fpbz', label:'发票币种', width:80, editrules:{edithidden:true}},
				{name:'ddh', index:'ddh', label:'订单号', width:100, editrules:{edithidden:true}},
				{name:'lcbh', index:'lcbh', label:'LC编号', width:100,  editrules:{edithidden:true}},
				{name:'gsbm', index:'gsbm', label:'接单主体', width:120,edittype:"select",formatter: "select",editoptions:{value:"${fns:loadCompanyOption('1')}"}},
				{name:'zdsj', index:'zdsj', label:'认领日期', width:80, editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bbh', index:'bbh', label:'版本号', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true, editrules:{edithidden:true}},
				{name:'sprid', index:'sprid', label:'审批人', width:80,  hidden: true, editrules:{edithidden:true}},
				{name:'sprmc', index:'sprmc', label:'审批人名称', width:80},
				{name:'spsj', index:'spsj', label:'审批时间', width:80,  hidden: true, editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'spyj', index:'spyj', label:'审批意见', width:120 },
				{name:'tssapzt', index:'tssapzt', label:'推送SAP状态', width:105, formatter:tsSAPCellAddHref},
				{name:'bzxx', index:'bzxx', label:'备注信息', width:140, editrules:{edithidden:true}},
				{name:'fj', index:'fj', label:'附件', width:120, editrules:{edithidden:true}},
				{name:'sfBg', label:'sfBg', hidden: true, width:60},
				{name:'sfQx', label:'sfQx', hidden: true, width:60},
				{name:'zdrid', index:'zdrid', label:'认领人ID', width:80,  editrules:{edithidden:true}},
			],
			sortname: 'rldh',
			sortorder: 'desc'
		},{
			add:false,
			edit:isEdit,
			del:isEdit,
			view:false,
			editfunc:editfunc,
			delfunc:delfunc
		});
	
		/* $(grid_selector).navButtonAdd(pager_selector,{
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
					location.href = editurl + "?id=" + id + "&skdh=" + rowData.skdh + "&sjc=" + rowData.sjc + "&&sfBg=1";
				}
			},
			position:"last"
		}); */
		
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
					} else{
						$("body").bindSweetAlert({
							title:"确定要取消吗?"
						},{
							callback:function(){
								$.bindAjax({
									url:cancelurl,
									data:{id:id, sjc:rowData.sjc,rldh:rowData.rldh},
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
		
		$(grid_selector).navButtonAdd(pager_selector,{
				caption:"推送SAP", 
				buttonicon:"fa-pencil-square grey", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
						 if(rowData.zt != 5 || rowData.tssapzt == "已通过"){
							swal("","请选择一行已生效且未推送sap的数据！","warning");
							return;
						}  
						$.bindAjax({
							url:"<c:url value='/payment/payReceiveClaim/pushSAP'/>",
							data:{id:id, rldh:rowData.rldh, sjc:rowData.sjc},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				},
				position:"last"
			});
		//预收款转回款
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"预收转回款", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id); 
					 if(rowData.sklxmc!='预收款' && rowData.je<=rowData.ybdje ){
							swal("","请选择一条认领金额>已绑定金额记录！","warning");
							return;
						}
					 $("body").bindSweetAlert({
							title:"确定要转回款吗?,系统将自动生成一张认领回款审批中单据！"
						},{
							callback:function(){
								$.bindAjax({
									url:"<c:url value='/payment/payReceiveClaim/yskzhk'/>",
									data:{id:id, rldh:rowData.rldh, sjc:rowData.sjc},
									action:"save"
								},function(response){
									$(grid_selector).trigger("reloadGrid");
								});
							}
						});
			
				}
			},
			position:"last"
		});
		 <shiro:hasPermission name="payment:payReceiveClaim:djAndJd"> 
		//预收款冻结
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"预收款冻结", 
			buttonicon:"fa-pencil-square orange", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id); 
					 if(rowData.sklxmc!='预收款' && rowData.je<=rowData.ybdje ){
							swal("","请选择一条认领金额>已绑定金额记录！","warning");
							return;
						} 
						//初始化对话框数据
						initDlg(rowData,1);

				}
			},
			position:"last"
		});
		//预收款冻结
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"预收款解冻", 
			buttonicon:"fa-pencil-square green", 
			onClickButton: function(){
				var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
				if(id==null || id==""){
					swal("","请选择一行数据！","warning");
				}else{
					var rowData = jQuery(grid_selector).jqGrid('getRowData',id); 
					 if(rowData.sklxmc!='预收款' && rowData.djje>0 ){
							swal("","请选择一条预收款冻结金额>0记录！","warning");
							return;
						}
					//初始化对话框数据
						initDlg(rowData,2);
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
		     iexport();
		});
	});
	
	//初始化对话框数据
	function initDlg(rowData,type){
		$('#consoleDlg [name=type]').val(type);
		$('#consoleDlg [name=id]').val(rowData.id);
		$('#consoleDlg [name=sjc]').val(rowData.sjc);
		$('#consoleDlg [name=je]').val(rowData.je);
		$('#consoleDlg [name=ydjje]').val(rowData.djje);
		$('#consoleDlg [name=djje]').val("");
		$('#consoleDlg [name=bzxx]').val("");
		$("#consoleDlg").dialog("option", "title", "预收款(冻结/解冻)").dialog("open");
	}
	
	//编辑
	function editfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		var zt = rowData.zt;
		if(id == null || id == ""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (zt == 2 || zt == 5) {
				swal("","只允许修改草稿和驳回状态的单据！","warning");
				return;
			}else{
				location.href = editurl + "?id=" + id + "&skdh=" + rowData.skdh;
			}
		}
	}
	
	//导出
	function iexport(){
		var curNum = $(grid_selector).getGridParam("records");
	    if(curNum == 0){
            swal("结果集为空不能导出","","warning");
            return false;
        }else{
        	$("#export").bindSweetAlert({
    			title:"确定要导出吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$(grid_selector).exportExcel({url: "<c:url value='/payment/payReceiveClaim/export'/>"});
    			}
    		});
        }
	}
	
	//删除
	function delfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		//var sfqx = rowData.sfQx;
		if(selr == null || selr == ""){
			swal("", "请选择一行数据！", "warning");
			return;
		}else{
			if(zt == 1 ||  zt == 3 ) {
				$("body").bindSweetAlert({
					title:"确定要删除吗?"
				},{
					callback:function(){
						$.bindAjax({
							url:"<c:url value='/payment/payReceiveClaim/delete'/>",
							data:{id:rowData.id,sjc :rowData.sjc},
							action:"edit"
						},function(response){
							$(grid_selector).trigger("reloadGrid");
						});
					}
				});
			} else {
				swal("", "只允许删除草稿或者驳回状态的单据！", "warning");
				return;
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
	
	//取消
    function cancel(){
    	$("#consoleDlg input").attr("value","");
    	$("#consoleDlg").dialog("close");
	}
	
	//确定冻结/解冻
	function frozen(){
		var param = $("#consoleForm").getFormData();
	    var msg = "" ;
	    if(param.type==1){
	    	msg="冻结";
	    }else{
	    	msg="解冻";
	    }
		$("body").bindSweetAlert({
			title : "确定要"+msg+"吗?"
		}, {
			callback : function() {
				 $.bindAjax({
						url:"<c:url value='/payment/payReceiveClaim/yskdjjd'/>",
						data:param,
						action:"save"
					},function(response){
						cancel(); 
						$(grid_selector).trigger("reloadGrid");
					}); 
			}
	   }); 
	}
	
</script>
</html>