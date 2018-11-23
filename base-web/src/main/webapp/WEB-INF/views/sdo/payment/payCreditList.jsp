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
						<span class="widget-toolbar"> <a href="#"
							data-action="collapse"> <i class="icon-chevron-up"></i>
						</a>
						</span>
						<div class="widget-toolbar no-border">
							<button id="btn-search" type="button" class="btn btn-info btn-minier bigger">
								<i class="icon-search icon-on-right"></i> 查询
							</button>
							&nbsp;
							<button id="export" type="button" class="btn btn-success btn-minier bigger">
								<i class="icon-download-alt icon-on-right"></i> 导出
							</button>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<form id="form-search" class="form-search">
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">客户&nbsp;&nbsp;</label> <input
												type="text" name="khmc" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">中信保买方代码&nbsp;&nbsp;</label> <input
												type="text" name="zxbmfdm" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">国家&nbsp;&nbsp;</label>
												<select role="select" name="gj" size="1" class="form-control skyselect">
													${fns:loadCountryOption('0')}
								         		</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">信用额度类型&nbsp;&nbsp;</label> <select
												role="select" name="xyedlx" size="1"
												class="form-control skyselect">
												${fns:loadDictOption('XYEDLX')}
											</select>
										</div>
									</div>
								</div>
								<div class="space-4"></div>
								<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">是否超期&nbsp;&nbsp;</label>		
											<select role="select" name="sfcq" size="1" class="form-control skyselect">
												${fns:loadDictOption('SF')}
											</select>
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
											<label class="input-group-addon">有效期&nbsp;&nbsp;</label>
											<input type="hidden" id="beginZdsj" name="beginZdsj"/>
											<input type="hidden" id="endZdsj" name="endZdsj"/>
											<input type="text" name="zdsj" class="form-control timeInterval"/>
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

				<!-- PAGE CONTENT ENDS -->
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
	<div id="consoleDlg" class="page-content" >
	<hr cellspacing="0" cellpadding="0">
	   <div id="formContainer" class="row">
	      <div class="col-xs-12">
		      	<form id="consoleForm">
		      	     <input type="hidden"  name="id"  />
		      	     <input type="hidden"  name="sjc"  />
		      	      <div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户编码&nbsp;&nbsp;</label> 
								<input type="text" name="khbm" readonly class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> 
								<input type="text" name="khmc" readonly class="form-control"   />
							</div>
						</div>
			      	 </div>
			      	 	<div class="space-4"></div>
			      	 
			      	 <div class="row">
			      	 	 <div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">信用额度类型&nbsp;&nbsp;</label> 
								<input type="text" name="xyedlxmc" readonly class="form-control"   />
							</div>
						</div>
							<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">内部管理额度&nbsp;&nbsp;</label> 
								<input type="text" name="nbgled" readonly class="form-control"   />
							</div>
						</div>
			      	 </div>
			      	   <div class="space-4"></div>
			      	 <div class="row">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">已使用额度&nbsp;&nbsp;</label> 
								<input type="text" name="ysyed" readonly class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">剩余额度&nbsp;&nbsp;</label> 
								<input type="text" name="ye" readonly class="form-control"   />
							</div>
						</div>	
			      	 </div>
			      	  <div class="space-4"></div>
			      	 <div class="row">
			      	 <div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">调整额度&nbsp;&nbsp;</label> 
								<input type="text" name="tzje"  class="form-control"   />
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">调整原因&nbsp;&nbsp;</label> 
								<input type="text" name="tzyy"  class="form-control"   />
							</div>
						</div>
			      	 </div>
			      	 <div class="space-4"></div>
			      	 <div class="row">
			      	 	 <div class="col-xs-6 col-sm-12" align="center">
							<button id="btn_ok" type="button" class="btn btn-info  btn-minier bigger" onclick="adjust()">
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
	var searchurl = "<c:url value='/payment/payCredit/search'/>";
	var editurl = "<c:url value='/payment/payCredit/editPage'/>";
	var delurl = "<c:url value='/payment/payCredit/delete'/>";
	var viewurl = "<c:url value='/payment/payCredit/viewPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="payment:payCredit:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$("#form-search [name=zdsj]").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$("#form-search [name=jhrq]").bindDateRange({startElement:$("#beginJhrq"),endElement:$("#endJhrq")});
		// 配置模态对话框
		$("#consoleDlg").dialog({
		autoOpen : false, // 是否自动弹出窗口
		modal : true, // 设置为模态对话框
		resizable : true,
		width : 600,
		height : 300,
		position : "center" // 窗口显示的位置
		});
		
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
				{name:'id', label:'ID', hidden: true, width:60, frozen:true},
				{name:'sjc', label:'SJC', hidden: true, width:60, frozen:true},
				{name:'zt', label:'状态', hidden: true, width:60, frozen:true},
				{name:'ztmc', index:'ztmc', label:'状态', width:120,/* formatter:ztmcChange, */ frozen:true},
				{name:'khbm', index:'khbm', label:'客户编码', width:100, frozen:true},
				{name:'khmc', index:'khmc', label:'客户名称', width:120, frozen:true},
				{name:'xyedlx', index:'xyedlx', label:'信用额度类型', width:80, hidden: true, frozen:true},
				{name:'xyedlxmc', index:'xyedlxmc', label:'信用额度类型', width:80, frozen:true},
				{name:'sszz', index:'sszz', label:'所属组织', width:80, hidden: true},
				{name:'sszzmc', index:'sszzmc', label:'客户所属组织', width:100, hidden: true},
				{name:'zxbmfdm', index:'zxbmfdm', label:'中信保买方编码', width:120},
				{name:'zxbed', index:'zxbed', label:'中信保额度', width:100, align:'right', formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'nbgled', index:'nbgled', label:'内部管理额度', width:100, align:'right', formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'ysyed', index:'ysyed', label:'已使用额度', width:100, align:'right', formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'syed', index:'syed', label:'剩余额度', width:100, align:'right', formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'bz', index:'bz', label:'币种', width:50},
				{name:'gj', index:'gj', label:'国家', width:80, hidden: true},
				{name:'gjmc', index:'gjmc', label:'国家', width:80},
				{name:'kzh', index:'kzh', label:'LC开证行', width:80},
				{name:'kzhdm', index:'kzhdm', label:'LC开证行SWIFT', width:80},
				{name:'ksyxq', index:'ksyxq', label:'开始有效期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'yxq', index:'yxq', label:'结束有效期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'xexzq', index:'xexzq', label:'限额闲置期', width:70},
				{name:'pfbl', index:'pfbl', label:'赔付比例', width:60,formatter:percentFormat,unformat:unPercentFormat},
				{name:'sfxh', index:'sfxh', label:'是否循环', width:60,edittype:"select", formatter:"select", editoptions:{value:"${fns:loadDictEditOption('SF')}"}},
				{name:'zq', index:'zq', label:'账期', width:60},
				{name:'pfblJsfx', index:'pfblJsfx', label:'赔付比例（拒收风险）', width:60},
				{name:'sfBg', label:'sfBg', hidden: true, width:60},
				{name:'sfQx', label:'sfQx', hidden: true, width:60}
			],
			sortname: 'khbm',
			sortorder: 'asc'
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:true,
			addfunc:addfunc,
			editfunc:editfunc,
			delfunc:delfunc,
			viewfunc:viewfunc
			
		}).jqGrid('setFrozenColumns');
		 <shiro:hasPermission name="payment:payCredit:edit"> 
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
					if(rowData.zt != 5 ){
						swal("","请选择一行已生效数据！","warning");
						return;
					}
					//冻结
					frozen(id,0,rowData.sjc);
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
					if(rowData.zt != 8){
						swal("","请选择一行已冻结的数据！","warning");
						return;
					}
					//解冻
					frozen(id,1,rowData.sjc);
				}
			},
			position:"last"
		});
		 </shiro:hasPermission> 
		
		 <shiro:hasPermission name="payment:payCredit:adjust"> 
			//信用额度调整
			$(grid_selector).navButtonAdd(pager_selector,{
				caption:"额度调整", 
				buttonicon:"fa-pencil-square orange", 
				onClickButton: function(){
					var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
					if(id==null || id==""){
						swal("","请选择一行数据！","warning");
					}else{
						var rowData = jQuery(grid_selector).jqGrid('getRowData',id); 
					    //初始化对话框数据
					    initDlg(rowData);

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
	            swal("","结果集为空不能导出","warning");
	            return false;
	        }else{
	        	$("body").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/payment/payCredit/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	
	//初始化对话框数据
	function initDlg(rowData){
		$('#consoleDlg [name=id]').val(rowData.id);
		$('#consoleDlg [name=sjc]').val(rowData.sjc);
		$('#consoleDlg [name=khbm]').val(rowData.khbm);
		$('#consoleDlg [name=khmc]').val(rowData.khmc);
		$('#consoleDlg [name=xyedlxmc]').val(rowData.xyedlxmc);
		$('#consoleDlg [name=nbgled]').val(rowData.nbgled);
		$('#consoleDlg [name=ysyed]').val(rowData.ysyed);
		$('#consoleDlg [name=ye]').val(Number(rowData.nbgled)-Number(rowData.ysyed));
		$('#consoleDlg [name=tzje]').val("");
		$('#consoleDlg [name=tzyy]').val("");
		$("#consoleDlg").dialog("option", "title", "信用额度调整").dialog("open");
	}
	
	//新增
	function addfunc(){
		location.href = editurl;
	}
	
	//编辑
	function editfunc(){
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(selr==null||selr==""){
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (zt == 2 || zt == 5) {
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
			swal("", "请选择一行数据!", "warning");
			return;
		}else{
			if (zt != 1) {
				swal("", "只能删除草稿!", "warning");
				return;
			}else{
				$("body").bindSweetAlert({
	    			title:"确定要删除吗?"/* ,
	    			closeOnConfirm: true */
	    		},{
	    			callback:function(){
	    				$.bindAjax({
	    					url:delurl,
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
	//冻结，解冻
	function frozen(id,type,sjc){
		    var msg = "" ;
		    if(type==0){
		    	msg="冻结";
		    }else{
		    	msg="解冻";
		    }
			$("body").bindSweetAlert({
				title : "确定要"+msg+"吗?"
			}, {
				callback : function() {
					$.bindAjax({
						url : "<c:url value='/payment/payCredit/frozen'/>",
						data : {id:id,type:type,sjc:sjc},
						action : "save"
					}, function(response) {
						$(grid_selector).trigger("reloadGrid");
					});
				}
		   });
	}
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		window.open(viewurl + "?id=" + id);
	}
	
	function percentFormat(cellValue){
		if(cellValue != null && cellValue != ""){
			return cellValue*100+"%";
		}else{
			return "";
		}		
	}
	function unPercentFormat(cellValue){
		if(cellValue != null && cellValue != ""){
			var value = cellValue.replace("%","");
			value = parseFloat(value)/100;
			return value;
		}else{
			return "";
		}
	}
	/* function ztmcChange(cellvalue, options, rowData){
		var currDate = new Date();
		var currYxq = rowData.yxq.replace(/-/g,"/");
		var yxq = new Date(Date.parse(currYxq));
		if(currDate>yxq){
			html = rowData.ztmc + "(已超期)";
		} else {
			html = rowData.ztmc;
		}
		return html;
	} */
	
	//取消
    function cancel(){
    	$("#consoleDlg input").attr("value","");
    	$("#consoleDlg").dialog("close");
	}
	
	
	//额度调整
	function adjust(){
		var param = $("#consoleForm").getFormData();
		$("body").bindSweetAlert({
			title : "确定要对客户："+param.khmc+",信用额度类型："+param.xyedlxmc+"，调整额度："+param.tzje+"吗?"
		}, {
			callback : function() {
				 $.bindAjax({
						url:"<c:url value='/payment/payCredit/adjust'/>",
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