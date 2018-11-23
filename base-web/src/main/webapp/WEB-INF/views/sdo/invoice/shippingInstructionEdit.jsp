<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
	<%
		String id = request.getParameter("id");
	%>
</head>
<body>
<div class="zheZhao"></div>
	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<form id="form-submit">
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">No.&nbsp;&nbsp;</label>
								<input type="text" name="bldh" class="form-control" readonly/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-bldSelect" type="button" class="btn btn-purple btn-sm" >
								<i class="fa fa-plus icon-on-right bigger-110"></i>
								补料单信息选择
							</button>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<button id="btn-save" type="button" class="btn btn-success btn-sm">
								<i class="icon-save icon-on-right bigger-110"></i>
								保存
							</button>
							&nbsp;
							<button id="btn-back" class="btn btn-sm" type="button">
								<i class="icon-undo icon-on-right bigger-110"></i>
								返回
							</button>
						</div>
			    	</div>
					<h5 class="header blue" style="margin-top: 4px;">SHIPPING INSTRUCTION</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<input type="hidden" name="id"/>
						<input type="hidden" name="oper"/>
						<input type="hidden" name="chxx"/>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">TO&nbsp;&nbsp;</label>
								<input type="text" name="cdgs" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">DATE&nbsp;&nbsp;</label> 
								<input type="text" name="zdsj" class="form-control date-picker"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">ATTN&nbsp;&nbsp;</label>
								<input type="text" name="cdgslxr" class="form-control"/>
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;">FM</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">SHIPPING DEPT.&nbsp;&nbsp;</label> 
								<input type="text" name="cwzy" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-8 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">TEL&nbsp;&nbsp;</label> 
								<input type="text" name="dh" class="form-control "/>
							</div>
						</div>
					    <div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">FAX&nbsp;&nbsp;</label> 
								<input type="text" name="cz" class="form-control "/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-3">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">EMAIL&nbsp;&nbsp;</label> 
								<input type="text" name="yx" class="form-control "/>
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin-top: 4px;"></h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">SHIPPER&nbsp;&nbsp;</label> 
								<textarea rows="3" name="gsxx" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">CONSIGNEE&nbsp;&nbsp;</label> 
								<textarea rows="5" name="shrxx" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">NOTIFY&nbsp;&nbsp;</label> 
								<textarea rows="10" name="tzrxx" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">PORT OF LOADING&nbsp;&nbsp;</label> 
								<input type="text" name="qyg" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">PORT OF DISCHARGE&nbsp;&nbsp;</label>
								<input type="text" name="xhg" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">PLACE OF DELIVERY&nbsp;&nbsp;</label> 
								<input type="text" name="mdg" class="form-control"/>
							</div>
						</div>
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">VESSEL NAME&nbsp;&nbsp;</label>
								<input type="text" name="cmhchbh" class="form-control"/>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">DESCRIPTION&nbsp;&nbsp;</label> 
								<textarea rows="8" name="wlms" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-12">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">FREIGHT&nbsp;&nbsp;</label> 
								<textarea name="mytk" class="autosize-transition form-control"></textarea>
							</div>
						</div>
					</div>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px 8px;">
						<div class="col-xs-6 col-sm-6">
							<div class="input-group input-group-sm">
								<label class="input-group-addon">MARKS & NOS&nbsp;&nbsp;</label> 
								<input type="text" name="mtxx" class="form-control"/>
							</div>
						</div>
					</div>
					<h5 class="header blue" style="margin: 0; padding: 0;">集装箱信息</h5>
					<div class="space-4"></div>
					<div class="row" style="margin: 0px;">
						<div class="col-xs-12 col-sm-12">
							<div id="grid-parent">
								<table id="grid-table"></table>
								<div id="grid-pager"></div>
							</div>
						</div>
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
	<shiro:hasPermission name="invoice:shippingInstruction:edit">isEdit = true;</shiro:hasPermission>

	$(function($){
	  	// 日期控件绑定
		$(".date-picker").bindDate();
		//出货订单信息选择
		$("#btn-bldSelect").click(function(){
			var width = 900;
			var height = 600;
			var left = (window.screen.width-width)/2;
			var top = (window.screen.height-height)/2;
			var pageUrl = "<c:url value='/invoice/shippingInstruction/shippingSearhList'/>";
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				var data = window.showModalDialog(pageUrl,null,dialogArgs);
				if(data){
					//初始出货明细数据
					initData(data);
				}
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
				var opener = window.open(pageUrl,null,dialogArgs);
				opener.openerCallBack = function(data){
					initData(data);
				}
			}
		});
		// 集装箱信息编辑表
		bindGridJzxxx();
	  	//初始化页面数据
		bindFormData(id);
		//保存
		$("#btn-save").click(function(){
			save();
	    });
		//返回
		$('#btn-back').click(function(){
			window.history.back(-1);
		});
	});
	/**************************************************function开始区域************************************************/
	//初始化出货明细信息
	function initData(data){
		var chxx = "";
		$.each(data, function(i, value){
			chxx += value.chdh + "|" + value.ddid;
			if(i != data.length-1){
				chxx += ",";
			}
		});
		$("#form-submit [name=chxx]").val(chxx);
		$.bindAjax({
			url : "<c:url value='/invoice/shippingInstruction/searchBlxx'/>",
			data : {chxx : chxx},
			action : "search"
		},function(response){
			$("#form-submit [name=cdgs]").val(response.cdgs);
			$("#form-submit [name=zdsj]").val(response.zdsj);
			$("#form-submit [name=cwzy]").val(response.cwzy);
			$("#form-submit [name=dh]").val(response.dh);
			$("#form-submit [name=cz]").val(response.cz);
			$("#form-submit [name=yx]").val(response.yx);
			$("#form-submit [name=gsxx]").val(response.gsxx);
			$("#form-submit [name=shrxx]").val(response.shrxx);
			$("#form-submit [name=tzrxx]").val(response.tzrxx);
			$("#form-submit [name=qyg]").val(response.qyg);
			$("#form-submit [name=mdg]").val(response.mdg);
			$("#form-submit [name=cmhchbh]").val(response.cmhchbh);
			$("#form-submit [name=mytk]").val(response.mytk);
			// 加载集装箱信息明细
			if(response.shippingInstructionItemList){
				$(grid_selector).jqGrid("addRowData", null, response.shippingInstructionItemList, "last");
			}
		});
	}
	
	//初始化页面数据
	function bindFormData(id){	
		//view or edit
		if(id != "null"){
			$.bindAjax({
				url : "<c:url value='/invoice/shippingInstruction/findById'/>",
				data : {id : id},
				action : "search"
			},function(response){
				$("#form-submit").setFormData(response);
				// 加载集装箱信息明细
				if(response.shippingInstructionItemList){
					$(grid_selector).jqGrid("addRowData", null, response.shippingInstructionItemList, "last");
				}
				$("#form-submit [name=oper]").val("edit");//编辑权限
			});
		}else{
			//初始化页面参数
			$("#form-submit [name=id]").val("");//id:空
			$("#form-submit [name=oper]").val("add");//操作:add
			$("#form-submit [name=cdgslxr]").val("DOC DEPT");//船代公司联系人：DOC DEPT
			$("#form-submit [name=mtxx]").val("N/M");
		}
	}
	//初始化集装箱信息grid
	function bindGridJzxxx(){		
		$(grid_selector).bindTable({
			caption: "",
			pager: pager_selector,
			gridParent: "#grid-parent",
			multiselect: true,
			footerrow:true,
			datatype: "local",
			//shrinkToFit: false,
			//autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'bldh', index:'bldh', label:'补料单号', hidden: true, width:80},
				{name:'ddid', index:'ddid', label:'订单号', hidden: true, width:80},
				{name:'gh', index:'gh', label:'CTNR NO.', width:80},
				{name:'fth', index:'fth', label:'SEAL NO.', width:80},
				{name:'kbtj', index:'kbtj', label:'TTL MEAS', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'xs', index:'xs', label:'TTL CTNS', width:80,
					align:'right',formatter:'integer',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zsl', index:'zsl', label:'TTL PKGS', width:80,
					align:'right',formatter:'integer',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'gmz', index:'gmz', label:'TTL GW', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'pz', index:'pz', label:'TARE', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'zmz', index:'zmz', label:'VGM', width:80,
					align:'right',formatter:'number',editrules:{number:true},formatoptions:{thousandsSeparator: ','}},
				{name:'gx', index:'gx', label:'CTNR TYPE', width:80},
				{name:'dch', index:'dch', label:'S/O NO.', width:80}
			],
			gridComplete: function(){
	            sumGrid();
		   	}
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
	}
	// 计算合计行
	function sumGrid(){
		$(grid_selector).footerData("set",{"gh":"TOTAL"}); //合计
		var rowNum = $(grid_selector).jqGrid('getGridParam','records');
		if(rowNum >0 ){
			 var kb_count=$(grid_selector).getCol("kbtj",false,"sum");
			 var xs_count=$(grid_selector).getCol("xs",false,"sum"); 
			 var zsl_count=$(grid_selector).getCol("zsl",false,"sum"); 
			 var gmz_count=$(grid_selector).getCol("gmz",false,"sum"); 
			 var pz_count=$(grid_selector).getCol("pz",false,"sum"); 
			 var zmz_count=$(grid_selector).getCol("zmz",false,"sum"); 
			$(grid_selector).footerData("set",{"kbtj":kb_count,"xs":xs_count,"zsl":zsl_count,
				"gmz":gmz_count,"pz":pz_count,"zmz":zmz_count}); //将合计值显示出来
		}
	}
	//保存
	function save(){
		var param = $("#form-submit").getFormData();
		// 取产品表数据
		var lastSel = $(grid_selector).getGridParam('selrow');
		$(grid_selector).saveRow(lastSel, false, 'clientArray');
		var data = $(grid_selector).getRowData();
		param.jzxList = JSON.stringify(data);
		$("body").bindSweetAlert({
			title:"确定要保存吗?"
		},{
			callback:function(){
				$.bindAjax({
					url:"<c:url value='/invoice/shippingInstruction/edit'/>",
					data:param,
					action:"save"
				},function(response){
					location.href = "<c:url value='/invoice/shippingInstruction'/>";
				}); 
			}
		});
	}
	
	//导出出库明细
/* 	function ckmxBindExport(){
		$("#ckmx-export").click(function(){
		    var chxx = $("#form-submit [name=chxx]").val();
		    if(chxx == ""){
	            swal("请先选择补料单信息","","warning");
	            return false;
	        }else{
	        	$("#ckmx-export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/invoice/shippingInstruction/ckmxExport'/>"+"?chxx="+chxx});
	    			}
	    		});
	        }
		});
	} */
</script>
</html>