<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/views/index/head.jsp"%>
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
							<button id="btn-search" type="button" class="btn btn-info btn-xs">
								<i class="icon-search icon-on-right"></i> 查询
							</button>
							&nbsp;
							<button id="export" type="button" class="btn btn-success btn-xs">
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
											<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
											<input type="hidden" name="yzhlx" value="1" />
											<input type="text" name="yzhdh" class="form-control" />
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">公司&nbsp;&nbsp;</label>
											<select role="select" name="gsbm" size="1" class="form-control skyselect">
												${fns:loadCompanyOption('0')}
											</select>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">客户&nbsp;&nbsp;</label> <input
												type="text" name="khmc" class="form-control" />
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
								<div class="space-4"></div>
							    <div class="row">
							    	<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
											<select role="select" name="scjd" size="1" class="form-control skyselect">
												${fns:loadDictOption('SCJD')}
											</select>
										</div>
								  </div>
								  <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
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
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->

	</div>
	<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	var isEdit = false;
	var editurl = "<c:url value='/pso/tvPsoCybl/editPage'/>";
	var viewurl = "<c:url value='/pso/tvPsoCybl/viewPage'/>";
	<shiro:hasPermission name="pso:tvPsoCybl:edit">isEdit = true;</shiro:hasPermission>

	$(function($) {
		$('.skyselect').select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$(grid_selector).bindTable({
			caption : "",
			url : "<c:url value='/pso/tvPsoCybl/search'/>",
			pager : pager_selector,
			gridParent : "#grid-parent",
			formSearch : "#form-search",
			sortname:'zdsj',
			sortorder:'desc',
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel : [ {name : 'id',label : 'ID',hidden : true,width : 60,editable : false}, 
			             {name : 'zt',label : 'zt',hidden : true,width : 60,editable : false},
			             {name : 'bbh',label : 'bbh',hidden : true,width : 60,editable : false}, 
			             {name : 'sjc',label : 'sjc',hidden : true,width : 60,editable : false}, 
			             {name : 'scjdmc',index : 'scjdmc',label : '生产基地名称',width : 80}, 
			             {name : 'yzhdh',index : 'yzhdh',label : '预走货单号',width : 80}, 
			             {name : 'ztmc',index : 'ztmc',label : '状态',width : 80},
			             {name : 'ckyzhdh',index : 'ckyzhdh',label : '参考预走货单号',width : 80,hidden : true},
			             {name : 'yzhlxmc',index : 'yzhlxmc',label : '预走货类型名称',width : 80}, 
			             {name : 'gsbm',index : 'gsbm',label : '公司',width : 80}, 
			             {name : 'khbm',index : 'khbm',label : '客户编码',width : 80}, 
			             {name : 'khmc',index : 'khmc',label : '客户名称',width : 80}, 
			             {name : 'xsymc',index : 'xsymc',label : '销售员',width : 80},
			             {name : 'ywzmc',index : 'ywzmc',label : '业务组',width : 80},
			             {name : 'zdrmc',index : 'zdrmc',label : '申请人名称',width : 80,hidden : true,editrules : {edithidden : true}}, 
			             {name : 'zdsj',index : 'zdsj',label : '制单时间',width : 80,formatter : 'date',formatoptions : {newformat : 'Y-m-d'}},
			             {name : 'bbh',index : 'bbh',label : '版本号',width : 80,hidden : true,editrules : {edithidden : true}}, 
			             {name : 'sjc',index : 'sjc',label : '时间戳',width : 80,hidden : true,editrules : {edithidden : true}} 
			           ]
		}, {
			add : false,
			edit : isEdit,
			del : false,
			view : isEdit,
			editfunc : editfunc,
			viewfunc : viewfunc
		});

		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();

		//查询
		$("#btn-search").click(function() {
			$(grid_selector).trigger("reloadGrid");
		});
		//回车键响应
		 $("body").keypress(function (e) {
				var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
				if (keyCode == 13){
					$(grid_selector).trigger("reloadGrid");
				}
		}); 

		$("#export").click(function() {
			var curNum = $(grid_selector).getGridParam("records");
			if (curNum == 0) {
				swal("结果集为空不能导出", "", "warning");
				return false;
			} else {
				$("#export").bindSweetAlert({
					title : "确定要导出吗?",
					closeOnConfirm : true
				}, {
					callback : function() {
						$(grid_selector).exportExcel({
							url : "<c:url value='/pso/tvPso/export'/>"
						});
					}
				});
			}
		});

	});

	 // 编辑
	function editfunc() {
		var selr = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',selr);
		var zt = rowData.zt;
		if(zt ==1 || zt==3 ){
			var id = jQuery(grid_selector).jqGrid('getGridParam', 'selrow');
			location.href = editurl + "?id=" + id;
		}else{
			swal("","只有草稿和驳回的单据才可编辑","warning");
		}
		 
	}

	//查看
	function viewfunc() {
		var id = jQuery(grid_selector).jqGrid('getGridParam', 'selrow');
		location.href = viewurl + "?id=" + id;
	}
</script>
</html>