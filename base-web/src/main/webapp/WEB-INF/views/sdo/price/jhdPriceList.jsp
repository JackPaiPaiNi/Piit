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
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							导出实际出货明细（CKD/SKD不齐套/CBU备损）
						</button>
						&nbsp;
						<button id="btn-import" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload icon-on-right bigger-110"></i>
							导入实际出货明细价格（CKD/SKD不齐套/CBU备损）
						</button>
					
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">		
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
										<label class="input-group-btn">订单号&nbsp;&nbsp;</label>
										<input type="text" id="ddid" name="ddid" class="form-control"/>
									</div>
								</div>						
							</div>	
							<div class="row">		
								<div class="col-xs-12 col-sm-12">
									<font color="red">可查询导出CKD明细、SKD不齐套明细、CBU备损明细
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
			url: "<c:url value='/price/orderBomPrice/searchJhd'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'jhdh', index:'jhdh', label:'交货单号', width:100,  editrules:{edithidden:true}},
				{name:'serino', index:'serino', label:'行项目号', width:80,  editrules:{edithidden:true}},
				{name:'jhsl', index:'jhsl', label:'交货数量', width:100,align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ','},  editrules:{edithidden:true} },
				{name:'ddid', index:'ddid', label:'订单号', width:120,  editrules:{edithidden:true}},
				{name:'chdh', index:'chdh', label:'出货通知书单号', width:120,  editrules:{edithidden:true}},
				{name:'wlbh', index:'wlbh', label:'物料编号', width:120,  editrules:{edithidden:true}},
				{name:'dj', index:'dj', label:'单价', width:100,align:'right' ,formatter:'number', formatoptions:{thousandsSeparator: ',',decimalPlaces:6},  editrules:{edithidden:true} },
				{name:'wlms', index:'wlms', label:'物料描述', width:120,  editrules:{edithidden:true}},
				{name:'bz', index:'bz', label:'币种', width:80,  editrules:{edithidden:true}},
				{name:'wldw', index:'wldw', label:'物料单位', width:80,  editrules:{edithidden:true}},
				{name:'xmlb', index:'xmlb', label:'项目类别', width:80,  editrules:{edithidden:true}},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			]
		},{
			add:false,
			edit:false,
			del:false
		});

		$('#btn-import').click(function(){
			$.importDialog({
				title:"选择CKD/SKD价格文件",
				data: {drlx : "ckd"},
				url:"<c:url value='/price/orderBomPrice/importJhd'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		
		$("#btn-export").click(function(){
			var ddid=$("#form-search [name=ddid]").val();
			var chdh=$("#form-search [name=chdh]").val();
			if(chdh.length==0 || ddid.length==0){
				 swal("出货通知书单号和订单号不能为空！","","warning");
		         return false;
			}
			$("body").bindSweetAlert({
    			title:"确定要导出实际出货明细（CKD/SKD）吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$(grid_selector).exportExcel({url: "<c:url value='/price/orderBomPrice/exportJhd'/>"});
    			}
    		});
	    });	
		
	});
	

	//绑定出货通知书选择框
	function bindChdh(){
		$.tableDialogPage({
			title : "实际出货选择",
			searchCond : [{"name":"订单号","value":"ddid"},
				          {"name":"出货通知书单号","value":"chdh"}],
			colModel : [ {name:'id', index:'id', label:'ID',hidden:true},
				         {name:'khbm', index:'khbm', label:'客户编码'},
				         {name:'khmc', index:'khmc', label:'客户名称'},
				         {name:'chdh', index:'chdh', label:'出货通知书单号'},
				         {name:'ddid', index:'ddid', label:'订单号'}],
			url : "<c:url value='/price/orderBomPrice/searchOrder'/>"
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