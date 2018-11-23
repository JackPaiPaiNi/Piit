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
							导出
						</button>
						&nbsp;
						<button id="btn-import" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload icon-on-right bigger-110"></i>
							导入
						</button>
					 	&nbsp;	
						<button id="btn-download" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right"></i>
							下载模板
						</button>
				 
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售员&nbsp;&nbsp;</label>
										<input type="text" name="xsymc" class="form-control"/>
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
										<label class="input-group-addon">PID&nbsp;&nbsp;</label>
										<input type="text" name="pid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机型&nbsp;&nbsp;</label>
										<input type="text" name="jixing" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机芯&nbsp;&nbsp;</label>
										<input type="text" name="jixin" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">款式&nbsp;&nbsp;</label>
										<input type="text" name="ks" class="form-control"/>
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
	var editurl= "<c:url value='/price/branchPrice/editPage'/>";
	<shiro:hasPermission name="price:branchPrice:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(grid_selector).bindTable({
			url: "<c:url value='/price/branchPrice/search'/>",
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
				{name:'khbm', index:'khbm', label:'客户编码', width:80,  editrules:{edithidden:true}, frozen:true},
				{name:'khmc', index:'khmc', label:'客户名称', width:80,  editrules:{edithidden:true}, frozen:true},
				{name:'pid', index:'pid', label:'PID', width:80,  editrules:{edithidden:true}, frozen:true},
				{name:'jixing', index:'jixing', label:'机型', width:80,  editrules:{edithidden:true}, frozen:true},
				{name:'jixin', index:'jixin', label:'机芯', width:80,  editrules:{edithidden:true}, frozen:true},
				{name:'fktj', index:'fktj', label:'付款条件', width:80,  editrules:{edithidden:true}, frozen:true},
				{name:'jgfs', index:'jgfs', label:'加工方式', width:80,  editrules:{edithidden:true}},
				{name:'bz', index:'bz', label:'币种', width:80,  editrules:{edithidden:true}},
				{name:'ts', index:'ts', label:'天数', width:80,align:'right',  editrules:{edithidden:true}},
				{name:'bfl', index:'bfl', label:'保费率', width:80,align:'right',  editrules:{edithidden:true}},
				{name:'pp', index:'pp', label:'品牌', width:80,  editrules:{edithidden:true}},
				{name:'qy', index:'qy', label:'区域', width:80,  editrules:{edithidden:true}},
				{name:'zxppbm', index:'zxppbm', label:'最新配屏编码', width:80,  editrules:{edithidden:true}},
				{name:'cc', index:'cc', label:'尺寸', width:80,  editrules:{edithidden:true}},
				{name:'cplb', index:'cplb', label:'产品类别', width:80,  editrules:{edithidden:true}},
				{name:'sf3d', index:'sf3d', label:'2D/3D', width:80,  editrules:{edithidden:true}},
				{name:'paneltype', index:'paneltype', label:'PanelType', width:80,  editrules:{edithidden:true}},
				{name:'ks', index:'ks', label:'款式', width:80,  editrules:{edithidden:true}},
				{name:'pm', index:'pm', label:'泡沫', width:80,  editrules:{edithidden:true}},
				{name:'zx', index:'zx', label:'纸箱', width:80,  editrules:{edithidden:true}},
				{name:'ch', index:'ch', label:'彩盒', width:80,  editrules:{edithidden:true}},
				{name:'gj', index:'gj', label:'挂架', width:80,  editrules:{edithidden:true}},
				{name:'pbc', index:'pbc', label:'屏包材', width:80,  editrules:{edithidden:true}},
				{name:'bsbhp', index:'bsbhp', label:'1%备损（不含屏）', width:120,  editrules:{edithidden:true}},
				{name:'qttsyq', index:'qttsyq', label:'其他特殊要求', width:120,  editrules:{edithidden:true}},
				{name:'fobP', index:'fobP', label:'FOB屏价格',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:120,  editrules:{edithidden:true}},
				{name:'fobSj', index:'fobSj', label:'FOB散件价格',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:120,  editrules:{edithidden:true}},
				{name:'fobZj', index:'fobZj', label:'FOB整机价格', width:120,  formatter:'number', formatoptions:{thousandsSeparator: ','}, width:120,  editrules:{edithidden:true}},
				{name:'fobZb', index:'fobZb', label:'FOB主板价格', width:120,  formatter:'number', formatoptions:{thousandsSeparator: ','}, width:120,  editrules:{edithidden:true}},
				{name:'cifP', index:'cifP', label:'CIF屏价格',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:120,  editrules:{edithidden:true}},
				{name:'cifSj', index:'cifSj', label:'CIF散件价格',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:120,  editrules:{edithidden:true}},
				{name:'cifZj', index:'cifZj', label:'CIF整机价格',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:120,  editrules:{edithidden:true}},
				{name:'cifZb', index:'cifZb', label:'CIF主板价格',align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}, width:120,  editrules:{edithidden:true}},
				{name:'yxqks', index:'yxqks', label:'有效期开始', width:120,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'yxqjs', index:'yxqjs', label:'有效期结束', width:120,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'xsyid', index:'xsyid', label:'销售员', width:80,  editrules:{edithidden:true}},
				{name:'xsymc', index:'xsymc', label:'销售员名称', width:80,  editrules:{edithidden:true}},
				{name:'zdrid', index:'zdrid', label:'制单人', width:80,  editrules:{edithidden:true}},
				{name:'zdrmc', index:'zdrmc', label:'制单人名称', width:80,  editrules:{edithidden:true}},
				{name:'zdsj', index:'zdsj', label:'制单时间', width:80,  editrules:{edithidden:true}, formatter:'date', formatoptions:{newformat:'Y-m-d'}}
			]
		},{
			add:false,
			edit:isEdit,
			del:false,
			editfunc: editfunc,
		}).jqGrid('setFrozenColumns');
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	    
		$('#btn-import').click(function(){
			$.importDialog({
				title:"选择文件",
				//data: $('#form-submit').getFormData(),
				url:"<c:url value='/price/branchPrice/import'/>"
			},{
				callback:function(results){
					/* var rows = eval('(' + results + ')');
					$(grid_selector).setGridParam({data: rows.items}).trigger('reloadGrid'); */
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		// 下载模板
		$("#btn-download").click(function(){
			window.location.href=encodeURI("<c:url value='/template/branchPrice.xlsx'/>");
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/price/branchPrice/export'/>"});
	    			}
	    		});
	        }
		});
		
		//编辑
		function editfunc(){
			var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
			location.href = editurl + "?id=" + selr;
		}
	});
</script>
</html>