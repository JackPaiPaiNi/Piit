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
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div id="grid-parent" class="col-xs-12">
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
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<form id="form-search" class="form-search">
								<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PI号&nbsp;&nbsp;</label>
										<input type="text" name="piid" class="form-control"/>
										<input type="hidden" name="oper" />
										<input type="hidden" name="gddh"/>
										<input type="hidden" name="syje"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
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
				<div class="space-4"></div>
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
			</div>
			<div class="space-4"></div>
			<h5 class="header blue" style="margin-top:4px;">待勾兑明细</h5>
			<div class="space-4"></div>
			<div id="grid-parent-gd" class="col-xs-12">
				<table id="grid-table-gd"></table>
				<div id="grid-pager-gd"></div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var grid_selector_gd = "#grid-table-gd";
	var pager_selector_gd = "#grid-pager-gd";
	var isEdit = false;
	var searchurl = "<c:url value='/payment/payPiBindBlend/findByPiid'/>";
	var searchdburl = "<c:url value='/payment/payPiBindBlend/searchDb'/>";
	<shiro:hasPermission name="payment:payPiBindBlend:edit"> isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		var lastsel;
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$("input[name=oper]").val("add");
		
		$(grid_selector).bindTable({
			caption: "",
			url: searchdburl,
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			autoScroll: false,
			multiselect: false,
			footerrow: true,
			//rowList: [5],
			rowNum: 5,
			colModel: [
			           	{name:'id', label:'ID', hidden: true, width:60, editable:false},
						{name:'piid', index:'piid', label:'PI号', width:100},
						{name:'ddid', index:'ddid', label:'订单号', width:100},
						{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100},
						{name:'fklx', index:'fklx', label:'付款类型', width:80},
						{name:'jd', index:'jd', label:'节点', width:80},
						{name:'bz', index:'bz', label:'币种', width:80},
						{name:'syje', index:'syje', label:'使用金额', width:80},
						{name:'gddh', index:'gddh', label:'勾兑单号', width:100},
						{name:'zdsj', index:'zdsj', label:'制单时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			],
			gridComplete:function(){
				sumGrid();
			},
			onCellSelect: function(rowid, iCol, cellcontent, e){
				//结束表格编辑
			    var lastEdit = $(grid_selector_gd).data('lastEdit');
				if(lastEdit){
					result = $(grid_selector_gd).saveRow(lastEdit, false, 'clientArray');
					  $(grid_selector_gd).removeData('lastEdit');
					if(!result){
						return ;
					}
				}
				
				var rowData = $(grid_selector).jqGrid('getRowData', rowid);
				$("input[name=gddh]").val(rowData.gddh);
				$("input[name=syje]").val(rowData.syje);
				SearchByPiid(rowData.piid);
			}
		},{
			add:false,
			edit:false,
			del:false,
			view:false
		});
		
		$(grid_selector_gd).bindTable({
			caption: "",
			datatype : "local",
			pager: pager_selector_gd,
			gridParent: "#grid-parent-gd",
			multiselect: true,
			footerrow: true,
			shrinkToFit: false,
			autoScroll: false,
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60},
				{name:'piid', index:'piid', label:'PI号', width:100, editable:false},
				{name:'dh', index:'dh', label:'认领单/LC编号', width:150, editable:false},
				{name:'fklx', index:'fklx', label:'绑定类型', width:100, editable:false},
				{name:'bz', index:'bz', label:'币种', width:100, editable:false},
				{name:'bdje', index:'bdje', label:'绑定金额', width:100, editable:false},
				{name:'ygdje', index:'ygdje', label:'已勾兑金额', width:100, editable:false},
				{name:'ye', index:'ye', label:'余额', width:100, editable:false},
				{name:'gdje', index:'gdje', label:'本次勾兑金额', width:100},
				{name:'sfWcgd', index:'sfWcgd', label:'是否完成勾兑', hidden:true, width:100, editable:false},
				{name:'skdh', index:'skdh', label:'收款单号', width:100, editable:false}
			],
			gridComplete:function(){
				sumGdGrid();
			},
			editTable:true,
			editComplete: function(lastEdit, rowData){
				sumGdGrid();
			}
		},{
			add:false,
			del:false,
			view:false,
			edit:false,
			refresh:isEdit,
			complete:isEdit
		});
		$(grid_selector_gd).navButtonAdd(pager_selector_gd,{
			caption:"保存", 
			buttonicon:"fa-check-square-o gray", 
			onClickButton: function(){
				saveBlend();
			},
			position:"last"
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
			$(grid_selector_gd).jqGrid("clearGridData");
	    });
		
	});
	
	 function sumGrid(){
			var je;
			$(grid_selector).footerData("set",{"piid":"合计"}); //合计
			var rowNum = $(grid_selector).jqGrid('getGridParam','records');
			if(rowNum >0 ){
				je=$(grid_selector).getCol("syje",false,"sum");
			}
			$(grid_selector).footerData("set",{"syje":je}); //将合计值显示出来
	    } 
	 function sumGdGrid(){
			var gdje;
			var bdje;
			$(grid_selector_gd).footerData("set",{"piid":"合计"}); //合计
			var rowNum = $(grid_selector_gd).jqGrid('getGridParam','records');
			if(rowNum >0 ){
				gdje=$(grid_selector_gd).getCol("gdje",false,"sum");
				bdje=$(grid_selector_gd).getCol("bdje",false,"sum");
			}
			$(grid_selector_gd).footerData("set",{"gdje":gdje,"bdje":bdje}); //将合计值显示出来
	    }
	
	//根据PIID查询待勾兑明细
	function SearchByPiid(piid){
		$.bindAjax({
			url : searchurl,
			data:{piid : piid},
			action:"search"
		},function(response){
			// 清空后添加
			$(grid_selector_gd).jqGrid("clearGridData");
			$(grid_selector_gd).jqGrid("addRowData", null, response, "last");
		});
		
	}

	// 保存勾兑
	function saveBlend(){
		var listData = [];
		var param = $("#form-search").getFormData();
		var syje = $("input[name=syje]").val();
		//结束表格编辑
	    var lastEdit = $(grid_selector_gd).data('lastEdit');
		if(lastEdit){
			result = $(grid_selector_gd).saveRow(lastEdit, false, 'clientArray');
			  $(grid_selector_gd).removeData('lastEdit');
			if(!result){
				return ;
			}
		}
		
		var data = $(grid_selector_gd).jqGrid("getGridParam","selarrrow");
		var total_gdje=0;
		// 判断是否选了数据
		if(data.length == 0){
			swal("","待勾选明细表中，请至少勾选一条记录进行保存！","warning");
			return;
		}
	
		// 循环处理选中数据（可多选）
		for(var i=0; i<data.length; i++){
			$(grid_selector_gd).saveRow(data[i], false, 'clientArray');
			var rowData = $(grid_selector_gd).jqGrid("getRowData",data[i]);
			total_gdje=Number(total_gdje)+Number(rowData.gdje);
			listData.push(rowData);
		}
		if(total_gdje!=Number(syje)){
			swal("","请确保勾选的PI使用金额=勾兑合计金额，您勾选的PI使用金额："+syje+",勾兑合计金额："+total_gdje,"warning");
			return;
		}
		param.list = JSON.stringify(listData);
		
		$("#body").bindSweetAlert({
  			title:"确定保存吗?"
  		},{
  			callback:function(){
  				$.bindAjax({
  					url:"<c:url value='/payment/payPiBindBlend/saveBlend'/>",
  					data:param,
  					action:"save"
  				},function(response){
  					$(grid_selector).trigger("reloadGrid");
  					$(grid_selector_gd).jqGrid("clearGridData");
  				}); 
  			}
  		});
	}
</script>
