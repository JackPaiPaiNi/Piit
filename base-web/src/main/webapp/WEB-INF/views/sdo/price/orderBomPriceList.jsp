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
				
			<div  id="search-box" class="widget-box">
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
							导出CKD明细
						</button>
						&nbsp;
						<button id="btn-import-ckd" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload icon-on-right bigger-110"></i>
							导入CKD价格
						</button>
						 &nbsp;
						<button id="btn-export-skd" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出SKD明细
						</button>
					<!-- 	&nbsp;
						<button id="ckd-template-download" type="button"  class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							SKD导入模板下载
					   </button> -->
					   	&nbsp;
						<button id="btn-import-skd" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload icon-on-right bigger-110"></i>
							导入SKD价格
						</button>
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">		
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">订单号&nbsp;&nbsp;</label>
										<input type="text" id="ddid" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">出货通知书单号&nbsp;&nbsp;</label>
										<input type="text" name="chdh" id="chdh" onfocus="this.blur()" class="form-control parent-node"/>
										<!-- <span class="input-group-addon">
										  <i class="icon-search bigger-110"></i>
								    	</span> -->
									   <span id="chdhsc" class="input-group-addon" style="cursor:pointer;">
									     <i class="fa fa-times red"></i>
								      </span>
									</div>
								</div>
								 <div class="col-xs-6 col-sm-4">
									<div class="input-group input-group-sm">
										<label class="input-group-btn">PID&nbsp;&nbsp;</label>
										<input type="text" name="pid" class="form-control"/>
									</div>
								</div>	 
							</div>	
							<div class="row">		
								<div class="col-xs-12 col-sm-12">
									<font color="red">导出CKD明细：系统导出的是大货订单导入CKD物料清单明细<br>
									导出SKD出货明细：系统导出的是SAP实际出货明细，出货通知书单号必填。<br>
									导入SKD价格：先导出，后导入，导出的数据只需要填写前4列（订单号，物料编码，单价，币种）
									</font>
								</div>					
							</div>				
						</form>
						<div class="space-4"></div>
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
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	var isEdit = false;
	<shiro:hasPermission name="price:orderBomPrice:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$("#chdh").click(function(){
			bindChdh();
		});
		 $('#chdhsc').click(function(){
			 $("#chdh").val("");
			});
		$(grid_selector).bindTable({
			url: "<c:url value='/price/orderBomPrice/search'/>",
			editurl: "<c:url value='/price/orderBomPrice/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false, frozen:true},
				{name:'ddid', index:'ddid', label:'订单号', width:80,  editrules:{edithidden:true}, frozen:true},
				{name:'wlbm', index:'wlbm', label:'物料编码', width:80,  editrules:{edithidden:true}, frozen:true},	
				{name:'dj', index:'dj', label:'单价', width:80,align:'right'/* ,formatter:'number', formatoptions:{thousandsSeparator: ','},  editrules:{edithidden:true} */},
				{name:'bz', index:'bz', label:'币种', width:80,  editrules:{edithidden:true}},
				{name:'ms', index:'ms', label:'物料描述', width:80,  editrules:{edithidden:true}},
				{name:'djyl', index:'djyl', label:'单机用量',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:80,  editrules:{edithidden:true}},
				{name:'sdjysl', index:'sdjysl', label:'上单结余数量',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:80,  editrules:{edithidden:true}},
				{name:'dhsl', index:'dhsl', label:'大货数量',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:80,  editrules:{edithidden:true}},
				{name:'mfbssl', index:'mfbssl', label:'免费备损数量',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:80,  editrules:{edithidden:true}},
				{name:'ffbssl', index:'ffbssl', label:'付费备损数量',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:80,  editrules:{edithidden:true}},
				{name:'moqsl', index:'moqsl', label:'MOQ数量',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:80,  editrules:{edithidden:true}},
				{name:'xdsl', index:'xdsl', label:'下单数量', width:80,  editrules:{edithidden:true}},
				{name:'sapdhddsl', index:'sapdhddsl', label:'SAP大货订单数量',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:80,  editrules:{edithidden:true}},
				{name:'bdjysl', index:'bdjysl', label:'本单结余数量',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:80,  editrules:{edithidden:true}},
				{name:'ne', index:'ne', label:'NE', width:80,  editrules:{edithidden:true}},
				{name:'po', index:'po', label:'PO', width:80,  editrules:{edithidden:true}},
				{name:'ncmcode', index:'ncmcode', label:'NCMCODE', width:80,  editrules:{edithidden:true}},
				{name:'dw', index:'dw', label:'单位', width:80,  editrules:{edithidden:true}},
				{name:'jz', index:'jz', label:'净重（kg）', width:80,align:'right',  editrules:{edithidden:true}},
				{name:'mz', index:'mz', label:'毛重（kg）', width:80,align:'right',  editrules:{edithidden:true}},
				{name:'gysbm', index:'gysbm', label:'供应商编码', width:80,  editrules:{edithidden:true}},
				{name:'gysmc', index:'gysmc', label:'供应商名称', width:80,  editrules:{edithidden:true}},
				{name:'gysdz', index:'gysdz', label:'供应商地址', width:80,  editrules:{edithidden:true}},
				{name:'ycd', index:'ycd', label:'原产地', width:80,  editrules:{edithidden:true}},
				{name:'pid', index:'pid', label:'PID', width:80,  editrules:{edithidden:true}},
				{name:'zdrid', index:'zdrid', label:'制单人', width:80,  editrules:{edithidden:true}},
				{name:'zdrmc', index:'zdrmc', label:'制单人名称', width:80,  editrules:{edithidden:true}},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'bbh', index:'bbh', label:'版本号', width:80,  editrules:{edithidden:true}},
			]
		},{
			add:false,
			edit:false,
			del:false
		}).jqGrid('setFrozenColumns');
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	    
		$('#btn-import-ckd').click(function(){
			$.importDialog({
				title:"选择CKD文件",
				data: {drlx : "ckd"},
				url:"<c:url value='/price/orderBomPrice/import'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		
		$('#btn-import-skd').click(function(){
			$.importDialog({
				title:"选择SKD文件",
				data: {drlx : "skd"},
				url:"<c:url value='/price/orderBomPrice/import'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		
		 $('#ckd-template-download').click(function(){
			  window.location.href=encodeURI("<c:url value='/template/skd.xlsx'/>");
		  });
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		
		$("#btn-export-skd").click(function(){
			var ddid=$("#form-search [name=ddid]").val();
			var chdh=$("#form-search [name=chdh]").val();
			if(chdh.length==0){
				 swal("导SKD出货明细，出货通知书单号不能为空！","","warning");
		         return false;
			}
			$("#export").bindSweetAlert({
    			title:"确定要导出SKD出货明细吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$(grid_selector).exportExcel({url: "<c:url value='/price/orderBomPrice/exportSKD'/>"});
    			}
    		});
	    });

		$("#export").click(function(){
			var ddid=$("#form-search [name=ddid]").val();
			if(ddid.length==0){
				 swal("导CKD明细，订单号不能为空！","","warning");
		         return false;
			}
			$("#export").bindSweetAlert({
    			title:"确定要导出吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$(grid_selector).exportExcel({url: "<c:url value='/price/orderBomPrice/export'/>"});
    			}
    		});
		   
		});
		
	
		
		
	});
	

	//绑定出货通知书选择框
	function bindChdh(){
		$.tableDialogPage({
			title : "SAP已出货通知书选择",
			searchCond : [{"name":"订单号","value":"ddid"},
				          {"name":"出货通知书单号","value":"chdh"}],
			colModel : [ {name:'id', index:'id', label:'ID',hidden:true},
			             {name:'gsbm', index:'gsbm', label:'公司编码'},
				         {name:'khbm', index:'khbm', label:'客户编码'},
				         {name:'khmc', index:'khmc', label:'客户名称'},
				         {name:'chdh', index:'chdh', label:'出货通知书单号'},
				         {name:'ddid', index:'ddid', label:'订单号'}],
			url : "<c:url value='/invoice/invoice/searchOrder'/>"
		}, {
			callback:function(rows) {
				if(rows){
					$("#chdh").val(rows.chdh);
					$("#ddid").val(rows.ddid);
				}else{
					$("#chdh").val("");
					$("#ddid").val("");
				}
			}
		});
	}
	
	
	
</script>
</html>