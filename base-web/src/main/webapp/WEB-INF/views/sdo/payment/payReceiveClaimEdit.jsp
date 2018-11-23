<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
    <%@include file="/WEB-INF/views/index/lfs.jsp" %>   
</head>
<%
	String id = request.getParameter("id");
    String skdh = request.getParameter("skdh");
	String sjc = request.getParameter("sjc");
	String sfBg = request.getParameter("sfBg");
%>
<body>
<div class="page-content">
	<div class="row">
		<div id="grid-parent" class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
            <h5 class="header blue" style="margin-top:4px;">收款信息</h5>
            <table class="table table-bordered">
				<tr>
					<th>收款单号</th>
					<th>财务登记人</th>
					<th>登记时间</th>
					<th>付款人</th>
					<th>收款日期</th>
					<th>收款银行</th>
					<th>接单主体</th>
					<th>付款银行</th>
					<th>付款国家</th>
					<th>币种</th>
					<th>金额</th>
					<th>参考手续费</th>
					<th>实际手续费</th>
					<th>已认领</th>
					<th>未认领</th>
					<th>认领状态</th>
					<th>备注信息</th>
					<th>冻结金额</th>
					<th>冻结原因</th>
					<th>认领币种</th>
					<th>汇率</th>
				</tr>
				<tr>
					<td>${skd.skdh}</td>
					<td>${skd.zdrmc}</td>
					<td><fmt:formatDate value="${skd.zdsj}" pattern="yyyy-MM-dd" /></td>
					<td>${skd.fkr}</td>
					<td><fmt:formatDate value="${skd.skrq}" pattern="yyyy-MM-dd" /></td>
					<td>${skd.skyhmc}</td>
					<td>${skd.gsbm}</td>
					<td>${skd.fkyh}</td>
					<td>${skd.fkgj}</td>
					<td>${skd.bz}</td>
					<td align="right"><fmt:formatNumber value="${skd.je}" pattern="#,##0.00"/></td>
					<td align="right"><fmt:formatNumber value="${skd.cksxf}" pattern="#,##0.00"/></td>
					<td align="right"><fmt:formatNumber value="${skd.sjsxf}" pattern="#,##0.00"/></td>
					<td align="right"><fmt:formatNumber value="${skd.yrlje}" pattern="#,##0.00"/></td>
					<td align="right"><fmt:formatNumber value="${skd.wrlje}" pattern="#,##0.00"/></td>
					<td align="right">${skd.rlzt}</td>
					<td align="right">${skd.bzxx}</td>
					<td align="right"><fmt:formatNumber value="${skd.djje}" pattern="#,##0.00"/></td>
					<td>${skd.djyy}</td>
					<td>${skd.jybz}</td>
					<td align="right"><fmt:formatNumber value="${skd.hl}" pattern="#0.00"/></td>
				</tr>
			</table>
			<div class="space-4"></div>
            <h5 class="header blue" style="margin-top:4px;">已认领信息</h5>
            <table class="table table-bordered">
				<tr>
					<th>认领单号</th>
					<th>收款类型</th>
					<th>认领金额</th>
					<th>实际手续费</th>
					<th>认领金额（调整）</th>
					<th>发票号</th>
					<th>交易币种</th>
					<th>发票金额</th>
					<th>订单号</th>
					<th>LC编号</th>
					<th>接单主体</th>
					<th>备注信息</th>
				</tr>
				<c:forEach items="${skd.payReceiveClaimList}" var="item">
					<tr>
						<td>${item.rldh}</td>
						<td>${item.sklxmc}</td>
						<td align="right"><fmt:formatNumber value="${item.je}" pattern="#,##0.00"/></td>
						<td align="right"><fmt:formatNumber value="${item.sjsxf}" pattern="#,##0.00"/></td>
						<td align="right"><fmt:formatNumber value="${item.rljetz}" pattern="#,##0.00"/></td>
						<td>${item.fph}</td>
						<td>${item.fpbz}</td>
						<td align="right"><fmt:formatNumber value="${item.fpje}" pattern="#,##0.00"/></td>
						<td>${item.ddh}</td>
						<td>${item.lcbh}</td>
						<td>${item.gsbm}</td>
						<td>${item.bzxx}</td>
					</tr>
				</c:forEach>
				<tr>
					<td>合计</td>
					<td align="right"><fmt:formatNumber value="${skd.yrlje}" pattern="#,##0.00"/></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
			<div class="space-4"></div>
		    <input type="hidden" id="wrlje" value="${skd.wrlje}" />
			<form id="form-submit">
	            <input type="hidden" name="id" />
		    	<input type="hidden" name="skdh" value="${skd.skdh}" />
				<input type="hidden" name="sfBg" />
		    	<input type="hidden" name="token" value="${token}"/>
		    	<input type="hidden" name="sksjsxf" value="${skd.sjsxf}" />
		    	<input type="hidden" name="gsbm" value="${skd.gsbm}" />
				<h5 class="header blue" style="margin-top:4px;">认领信息</h5>
				<div class="row">
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户编码&nbsp;&nbsp;</label>
							<input type="text" name="khbm" onfocus="this.blur()" class="form-control  parent-node"/>
							<span class="input-group-addon">
								<i class="icon-search bigger-110"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">客户名称&nbsp;&nbsp;</label> <input
								type="text" name="khmc" class="form-control" readonly />
						</div>
					</div>
					<%-- <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">手续费&nbsp;&nbsp;</label> <input
								type="text" id="sjsxf" name="sjsxf" value="${skd.sjsxf}" class="form-control" />
						</div>
					</div> --%>
					 <div class="col-xs-6 col-sm-3">
						<div class="input-group input-group-sm">
							<label class="input-group-addon">收款币种&nbsp;&nbsp;</label> <input
								type="text" name="bz" value="${skd.bz}" class="form-control" readonly />
						</div>
					</div>
				</div>
				<div class="space-4"></div>
				<div class="row" >
					<div class="col-xs-6 col-sm-6">
						<div class="input-group input-group-sm">
							<input type="hidden" name="fj" /><label class="input-group-addon">附件&nbsp;&nbsp;</label> <span
								class="input-group-addon"><input id="fj" type="file"
								class="form-control"></span>
							<div id="fjxx" class="form-control"></div>							
							<span id="fjsc" class="input-group-addon" style="cursor:pointer;">
								<i class="fa fa-times red"></i>
							</span>
						</div>
					</div>
					<div class="col-xs-6 col-sm-6">
						<div id="multiFileQueue">
						</div>
		           </div>
				</div>
	        	<div class="space-4"></div>
				<div class="row" style="margin: 0px;" id="grid-parent-rl">
					<table id="grid-table-rl"></table>
					<div id="grid-pager-rl"></div>
				</div>
			</form>
			<div class="space-4"></div>
			<div class="row" align="center">
				<button id="btn_submit" type="button"
					class="btn btn-info btn-minier bigger">
					<i class="icon-ok icon-on-right biggqer-110"></i> 提交
				</button>
				&nbsp;
				<button id="btn_back" type="button"
					class="btn  btn-minier bigger">
					<i class="icon-undo icon-on-right bigger-110"></i> 返回
				</button>
			</div>
		</div>
		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.row -->
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
    var id = '<%=id%>';
    var skdh = '<%=skdh%>';
	var sjc = "<%=sjc%>";
	var sfBg = "<%=sfBg%>";
	var grid_selector_rl = "#grid-table-rl";
	var pager_selector_rl = "#grid-pager-rl";
	var searchurl = "<c:url value='/payment/payReceive/search'/>";
	var isEdit = false;
	<shiro:hasPermission name="payment:payReceiveClaim:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		// select2控件绑定
	    $(".skyselect").select2();

		//加载table数据
		$(grid_selector_rl).bindTable({
			caption: "",
			pager: pager_selector_rl,
			gridParent: "#grid-parent-rl",
			//shrinkToFit: false,
			//autoScroll: false,
			footerrow:true,
			datatype: "local",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:true},
				{name:'rldh', index:'rldh', label:'认领单号', width:80, editable:false},
				{name:'zt', label:'状态', hidden: true, width:60},
				{name:'ztmc', index:'ztmc', label:'状态', width:70, editoptions:{disabled:true,dataInit: function(elem){$(elem).val("草稿")}}},
				{name:'sklx', index:'sklx', label:'收款类型', width:120,editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('SKLX')}",dataInit: initSKLX}},
				{name:'je', index:'je', label:'认领金额',  width:80, editable:true,formatter:'number',
					align:'right', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true,required:true,number:true,minValue:0},editoptions:{dataInit: initRLJE}},
				{name:'sjsxf', index:'sjsxf', label:'实际手续费',  width:60,align:'right', formatoptions:{thousandsSeparator: ','}},
				{name:'rljetz', index:'rljetz', label:'认领金额（调整）',  width:100, formatter:'number',
					align:'right', formatoptions:{thousandsSeparator: ','},editrules:{edithidden:true,number:true,minValue:0},hidden:true},
				{name:'fph', index:'fph', label:'发票号', width:100,editable : true, editoptions:{dataInit: initFph}},
				{name:'fpbz', index:'fpbz', label:'交易币种', width:80,editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('BZ')}",dataInit: initSelect2}},
				{name:'fpje', index:'fpje', label:'发票金额',  width:60,align:'right', formatoptions:{thousandsSeparator: ','}},
				//{name:'ddh', index:'ddh', label:'订单号', width:80, editoptions:{disabled:true}}, 
				{name:'lcbh', index:'lcbh', label:'LC编号',  width:100,	editable : true, editoptions:{dataInit: initLC}},
				{name:'gsbm', index:'gsbm', label:'接单主体', width:100,editable:true, editrules:{erequired:true},edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadCompanyOption('1')}",dataInit: initGSBM}}, 
				{name:'bzxx', index:'bzxx', label:'备注信息', width:150},
				{name:'sjc', index:'sjc', label:'时间戳',  hidden:true,  width:80},
				{name:'bbh', index:'bbh', label:'版本号',  hidden:true,  width:80},
				{name:'zt', index:'zt', label:'状态', hidden:true}
			],	
			gridComplete: function(){
	            sumGrid();
		   	},
			editTable:true,
			editComplete: function(lastEdit, rowData){
				sumGrid();
			}
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			complete:isEdit,
			delfunc:delfunc
		});
		
		function initGSBM(elem){
			$(elem).width(140).addClass("skyselect").select2();
			$(elem).select2("val",$("input[name=gsbm]").val());
		}
		//初始化订单选择框
	    function initDdid(elem){
	    	$(elem).addClass("skyselect").select2({width:"100%"}).on("change", function(){
					$(elem).closest("tr.jqgrow").find("[name='ddh']").attr({"disabled":false});
			});
		}
	   //初始化发票号
	    function initFpid(elem){
	    	$(elem).addClass("skyselect").select2({width:"100%"}).on("change", function(){
	    		$(elem).closest("tr.jqgrow").find("[name='fph']").attr({"disabled":false});
			});
		}
		
		//初始化收款类型
		function initSKLX(elem){
			$(elem).addClass("skyselect").select2({width:"100%"}).on("change", function(){
				var sklx = $(elem).val();
				if(sklx=='1'){
					$(elem).closest("tr.jqgrow").find("[name='fpbz']").attr({"disabled":false});
				}else{
					$(elem).closest("tr.jqgrow").find("[name='fpbz']").attr({"disabled":true});
				} 
			});
		} 
		
		// 初始化编辑表认领金额调整
		function initRLJE(elem){
			$(elem).on("blur", function(){
				var je = $(elem).val();
				$(elem).closest("tr.jqgrow").find("[name='rljetz']").val(je);
			});
		}
		
		// 客户选择框
		$("#form-submit [name=khbm]").click(function(){
			$.tableDialogPage({
				title:"客户选择",
				searchCond:[{"name":"客户编码","value":"khbm"},
				            {"name":"客户名称","value":"khmc"}],
				colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:60},
						  {name:'khmc', index:'khmc', label:'客户名称', width:100}],
				url:"<c:url value='/pub/widget/findCust'/>"
			},{
				callback:function(rows){
					if(rows){
						$("input[name=khbm]").val(rows.khbm);
						$("input[name=khmc]").val(rows.khmc);
					}else{
						$("input[name=khbm]").val("");
						$("input[name=khmc]").val("");
					}
				
				}
			});
		});
		
		$('#form-submit').validate({
			onfocusout: false,
			onkeyup: false,
			onclick: false,
			focusInvalid: false,
			focusCleanup: false,
			rules: {
				khbm: 'required'
			},
			messages: {
				khbm: '客户编码不能为空，请选择！'
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
		
		$('#fj').uploadify($.extend($.lfsUploadOptions, {
			width : $('#fj').parent().width(),
			queueID : 'multiFileQueue',// 上传队列容器
			onUploadSuccess : function(file, data, response) {
				if (response) {
					result = $.parseJSON(data);
					if ("SUCCESS" == result.status) {
						var tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
						$("#form-submit [name=fj]").val(tmpUrl);
						$("#fjxx").empty().append(tmpUrl);
					} else {// INVALID or ERROR
						alert(result.msg);
					}
				}
			}
		}));
		$('#fjsc').click(function(){
			if($("#form-submit [name=fj]").val() != ""){
				$("body").bindSweetAlert({
					title : "确定要删除附件吗?",
					closeOnConfirm: true
				}, {
					callback : function() {
						$("#form-submit [name=fj]").val("");
						$("#fjxx").empty();
					}
				});
			}
		});
		
		initPageData(id);
		
		//提交
		$("#btn_submit").click(function() {
			submit();
		});

		//返回按钮
		$('#btn_back').click(function() {
			window.history.back(-1);
		});
	
	});
	
	// 初始化编辑表select2
	function initSelect2(elem){
		$(elem).width(140).addClass("skyselect").select2();
	}
	
	// 计算合计行
	function sumGrid(){
		var je;
		var rljetz;
		$(grid_selector_rl).footerData("set",{"rldh":"合计"}); //合计
		var rowNum = $(grid_selector_rl).jqGrid('getGridParam','records');
		if(rowNum >0 ){
			je = $(grid_selector_rl).getCol("je",false,"sum"); 
			rljetz = $(grid_selector_rl).getCol("rljetz",false,"sum"); 
		}
		$(grid_selector_rl).footerData("set",{"je":je,"rljetz":rljetz}); //将合计值显示出来
	}
	
	function initPageData(id){
		if(id == "null"){
			// add
			$("#form-submit [name=id]").val("");
		} else {
			// edit
			var editUrl = "<c:url value='/payment/payReceiveClaim/findById'/>";
			var param = {id : id};
			if(sfBg == 1){
				editUrl = "<c:url value='/payment/payReceiveClaim/changeById'/>";
				param.sjc = sjc;
			}
			$.bindAjax({
				url : editUrl,
				data : param,
				action : "search"
			}, function(response) {
				//alert(JSON.stringify(response));
				$("#form-submit").setFormData(response);
				if(response){
					$(grid_selector_rl).jqGrid("addRowData", null, response, "last");
				}
				$("#fjxx").html(response.fj);
			});
		}
	}
	
	//选择发票号	
	function initFph(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			if($("input[name=khbm]").val() == ""){
				swal("", "请先选择客户！", "warning");
				return;
			}
			$.tableDialogPage({
				title : "发票选择",
				searchCond : [{"name":"发票号","value":"fph"}
				              /* {"name":"订单号","value":"ddh"} */
				              ],
				colModel : [ /* {name:'ddid', index:'ddid', label:'订单号'}, */
				             {name:'fph', index:'fph', label:'发票号'},
				            /*  {name:'tdh', index:'tdh', label:'提单号'}, */
				             {name:'fpje', index:'fpje', label:'发票金额'},
					         {name:'bz', index:'bz', label:'发票币种'}/*,
					          {name:'wshje', index:'wshje', label:'订单开票金额'} ,
					         {name:'yshje', index:'yshje', label:'已收汇金额'} */],
			      url : "<c:url value='/payment/payReceiveClaim/searchInvoice'/>"+ "?khbm=" + $("input[name=khbm]").val()
			}, {
				callback : function(rows) {
					if(rows){
						$(elem).closest("tr.jqgrow").find("[name='fph']").val(rows.fph);
						$(elem).closest("tr.jqgrow").find("[name='fpje']").val(rows.fpje);
						$(elem).closest("tr.jqgrow").find("[name='fpbz']").select2("val",rows.bz);
						/* $(elem).closest("tr.jqgrow").find("[name='ddh']").val(rows.ddid); */
					}else{
						$(elem).closest("tr.jqgrow").find("[name='fph']").val("");
						$(elem).closest("tr.jqgrow").find("[name='fpje']").val("");
						$(elem).closest("tr.jqgrow").find("[name='fpbz']").select2("val","");
						/* $(elem).closest("tr.jqgrow").find("[name='ddh']").val(""); */
					}
				}
			});
		});
	}

	//选择LC	
	function initLC(elem) {
		$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
		$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
			$.tableDialogPage({
				title : "LC选择",
				searchCond : [{"name":"信用证号","value":"lcbh"},
					          {"name":"客户名称","value":"khmc"}],
				colModel : [ {name:'id', index:'id', label:'ID',hidden:true},
				             {name:'lcbh', index:'lcbh', label:'信用证号'},
					         {name:'khbm', index:'khbm', label:'客户编码'},
					         {name:'khmc', index:'khmc', label:'客户名称'},
					         {name:'kzh', index:'kzh', label:'开证行'}],
				url : "<c:url value='/pub/widget/findLc'/>"+ "?khbm=" + $("input[name=khbm]").val()
			}, {
				callback : function(rows) {
					if(rows){
						$(elem).val(rows.lcbh);
					}else{
						$(elem).val("");
					}
				}
			});
		});
	}
	
	function delfunc(){
		var lastEdit = $(grid_selector_rl).data('lastEdit');
		if(lastEdit){
			$(grid_selector_rl).saveRow(lastEdit, false, 'clientArray');
		}
		var rowData = jQuery(grid_selector_rl).jqGrid('getRowData',lastEdit);
		var zt = rowData.zt;
		if(lastEdit == null || lastEdit == ""){
			swal("", "请选择一行数据！", "warning");
			return;
		}else{
			if(zt == 1 || zt == "") {
				$(grid_selector_rl).jqGrid("delRowData", lastEdit);
			} else {
				swal("", "只允许删除草稿或新增的数据！", "warning");
			}
		}
	}
	
	function submit(){
		// 编辑表结束编辑
		var lastEdit = $(grid_selector_rl).data('lastEdit');
		if(lastEdit){
			$(grid_selector_rl).saveRow(lastEdit, false, 'clientArray');
		}
		if (!$('#form-submit').valid()) {
			return false;
		}
		var param = $("#form-submit").getFormData();
		// 验证收款币种和交易币种一致，如果不一致调整金额必填
		var data = $(grid_selector_rl).getRowData();
		var message = "";
		var zje = 0;
		var rljezh = 0;//认领金额总和
		var sjsxf = 0;
		var gsbm = "${skd.gsbm}";
		$.each(data,function(i,n){
			sjsxf += parseFloat(n.sjsxf);
			rljezh += parseFloat(n.je);
			if(n.fpbz!=param.bz && n.rljetz<=0){
				zje += parseFloat(n.je);
				message += "第"+(i+1)+"行,'交易币种'和'收款币种'不一致，'认领金额（调整）' 必须大于0！\n";
			}
			//当为回款时，需确认发票号是否填写
			if((n.sklx == "2" || n.sklx == "3") && n.fph == ""){
				message += "第"+(i+1)+"行,当收款类型为回款时，必须选择发票！\n";
			}
			//当为回款时，需确认发票号是否填写
			if((n.sklx == "2" || n.sklx == "3") && n.fpbz == ""){
				message += "第"+(i+1)+"行,当收款类型为回款时，发票币种不能为空！\n";
			}
			if(parseFloat(n.je)>parseFloat(n.fpje)+1){
				message += "第"+(i+1)+"行,认领金额不能大于发票实际金额！";
			}
			if(gsbm != "" && gsbm != n.gsbm){
				message += "第"+(i+1)+"行,认领单接单主体与收款单接单主体不一致！";
			}
		});
		//判断实际手续费，给予提醒
		var sksjsxf=$("#form-submit [name=sksjsxf]").val();
		if(sksjsxf != "" && sksjsxf != "0" && sjsxf > 0 ){
			message += "该认领单的实际手续费已填写，不能重复填写！";
		}
		/* if($("#wrlje").val() < zje){
			message += "认领总金额不能大于收款单未认领金额！";
		} */
		/* if(rljezh > parseFloat($("#wrlje").val()) + parseFloat($("#sjsxf").val())){
			message += "认领总金额不能大于未认领金额与实际手续费之和！";
		} */
		if(message.length > 0){
			swal("", message, "warning");
			return;
		}
		param.list = JSON.stringify(data);
		$("body").bindSweetAlert({
			title : "确定要提交吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/payment/payReceiveClaim/submit'/>",
					data : param,
					action : "save"
				}, function(response) {
					window.history.back(-1);
				});
			}
		});
	}
	
	// 初始化编辑表select2
	function initSelect2(elem){
		$(elem).width("100%").addClass("skyselect").select2();
	}
	
</script>
</html>