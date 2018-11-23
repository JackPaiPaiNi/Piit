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
								<i class="icon-search icon-on-right"></i> 查询
							</button>
							&nbsp;
							<button id="export" type="button" class="btn btn-success btn-minier bigger">
								<i class="icon-download-alt icon-on-right"></i> 导出
							</button>
							&nbsp;
							<button id="btn-tbddzt" type="button" class="btn btn-success btn-minier bigger">
								<i class="icon-download-alt icon-on-right"></i>
								同步
							</button>
						</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">下单日期&nbsp;&nbsp;</label>
										<input type="hidden" id="beginXd" name="beginXd"/>
										<input type="hidden" id="endXd" name="endXd"/>
										<input type="text" id="xdrq" id="xdrq" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">出货日期（要求）&nbsp;&nbsp;</label>
										<input type="hidden" id="beginCy" name="beginCy"/>
										<input type="hidden" id="endCy" name="endCy"/>
										<input type="text" id="chrq" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
										<select role="select" name="ywz" size="1" class="form-control skyselect ">
												${fns:loadYwzOption('0')}
										</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
									<div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">客户&nbsp;&nbsp;</label>
											<input type="text" name="khbm" class="form-control"/>
										</div>
								    </div>
								    <div class="col-xs-6 col-sm-3">
										<div class="input-group input-group-sm">
											<label class="input-group-addon">创维型号&nbsp;&nbsp;</label>
											<input type="text" name="jixing" class="form-control"/>
										</div>
									</div>
									<div class="col-xs-6 col-sm-3">
									    <div class="input-group input-group-sm">
											<label class="input-group-addon">买家型号&nbsp;&nbsp;</label>
											<input type="text" name="khxhms" class="form-control"/>
										</div>
								    </div>
								    <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单整体状态&nbsp;&nbsp;</label>
										<select role="select" name="ddztzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('DDZTZT')}
										</select>
									 </div>
							   </div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否存在延误节点&nbsp;&nbsp;</label>
										<select role="select" name="sfczywjd" size="1" class="form-control skyselect ">
										    <option value="">--请选择--</option>
											<option value="是">是</option>
										    <option value="否">否</option>
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">延误节点&nbsp;&nbsp;</label>
										<select role="select" name="ywjd" size="1" class="form-control skyselect ">
												${fns:loadDictOption('YWJD')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单审批状态&nbsp;&nbsp;</label>
										<select role="select" name="ddspzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('DDZGDZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单转工单状态&nbsp;&nbsp;</label>
										<select role="select" name="ddzgdzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('DDZGDZT')}
										</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">是否维护计划完成时间&nbsp;&nbsp;</label>
										<select role="select" name="sfwhjhwcsj" size="1" class="form-control skyselect ">
												<option value="">--请选择--</option>
												<option value="是">是</option>
												<option value="否">否</option>
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货创建&nbsp;&nbsp;</label>
										<select role="select" name="yzhcjzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('YZHCJZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
								    <div class="input-group input-group-sm">
											<label class="input-group-addon">预走货完成&nbsp;&nbsp;</label>
											<select role="select" name="yzhwczt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('YZHCJZT')}
											</select>
									</div>
							   </div>
							    <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">入库状态&nbsp;&nbsp;</label>
											<select role="select" name="rkzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('YZHCJZT')}
											</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">一次评审状态&nbsp;&nbsp;</label>
											<select role="select" name="ycpszt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('DDZGDZT')}
											</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">美工确认状态&nbsp;&nbsp;</label>
											<select role="select" name="mgqrzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('DDZGDZT')}
											</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">软件确认状态&nbsp;&nbsp;</label>
											<select role="select" name="rjqrzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('DDZGDZT')}
											</select>
									</div>
								</div>
								<%-- <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">报关状态&nbsp;&nbsp;</label>
											<select role="select" name="bgzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('YZHCJZT')}
											</select>
									</div>
								</div> --%>							
								<%-- <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">出运状态&nbsp;&nbsp;</label>
											<select role="select" name="cyzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('YZHCJZT')}
											</select>
									</div>
								</div> --%>
								<%-- <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
											<label class="input-group-addon">散件收货状态&nbsp;&nbsp;</label>
											<select role="select" name="sjshzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('YZHCJZT')}
											</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">整机收货状态&nbsp;&nbsp;</label>
										<select role="select" name="zjshzt" size="1" class="form-control skyselect ">
												${fns:loadDictOption('YZHCJZT')}
										</select>
									</div>
								</div> --%>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单类型&nbsp;&nbsp;</label>
										<select role="select" name="ddlx" size="1" class="form-control skyselect ">
												${fns:loadDictOption('DDLX')}
										</select>
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
	<shiro:hasPermission name="track:trackInfo:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$('.skyselect').select2();
		$(".date-picker").bindDate();
		$("#xdrq").bindDateRange({startElement:$("#beginXd"),endElement:$("#endXd")});
		$("#chrq").bindDateRange({startElement:$("#beginCy"),endElement:$("#endCy")});
		$(grid_selector).bindTable({
			url: "<c:url value='/track/trackInfo/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true,frozen : true},
				{name:'', label:'ID', hidden: true,frozen : true},
				{name:'ddid', index:'ddid', label:'订单号', width:80,frozen : true},
				{name:'ddlxmc', index:'ddlxmc', label:'订单类型', width:80,frozen : true},
				{name:'DelBtn', index:'DelBtn', label:'整体状态查看', width:90,frozen : true},
				{name:'ddztzt', index:'ddztzt', label:'订单整体状态', width:80,frozen : true},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:80},
				{name:'jixing', index:'jixing', label:'创维型号', width:80},
				{name:'khxhms', index:'khxhms', label:'买家型号', width:80},
				{name:'sfczywjd', index:'sfczywjd', label:'是否存在延误节点', width:120},
				{name:'xd', index:'xd', label:'下单日期', width:80, formatter:'date',formatoptions:{newformat:'Y-m-d'}},
				{name:'ckyq', index:'ckyq', label:'出货日期（要求）', width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'scjhwc', index:'scjhwc', label:'生产计划完成确认', width:120, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'ddspzt', index:'ddspzt', label:'订单审批状态', width:80},
				{name:'scddxdzt', index:'scddxdzt', label:'生产订单下达状态', width:120},
				{name:'ycpszt', index:'ycpszt', label:'一次评审状态', width:80},
				{name:'mgqrzt', index:'mgqr', label:'美工确认', width:80},
				{name:'ddzgdzt', index:'ddzgd', label:'订单转工单', width:80},
				{name:'rjqrzt', index:'rjqr', label:'软件确认', width:80},
				{name:'yzhcjzt', index:'yzhcj', label:'预走货创建', width:80},
				{name:'yzhwczt', index:'yzhwc', label:'预走货完成', width:80},
				{name:'rkzt', index:'rk', label:'入库', width:80},
				{name:'ckzt', index:'ck', label:'出库', width:80},
			/* 	{name:'bgzt', index:'bg', label:'报关', hidden: true, width:80},
				{name:'cyzt', index:'cy', label:'出运', hidden: true, width:80},
				{name:'sjshzt', index:'sjsh', label:'散件收货', width:80},
				{name:'zjshzt', index:'zjsh', label:'整机收货', width:80} */
			],
			gridComplete:function(){
				var ids =$(grid_selector).jqGrid('getDataIDs') ;
				 for(var i=0;i < ids.length;i++) {
					    var rowData = $(grid_selector).jqGrid("getRowData",ids[i]);
						var delBtn = "<a href='#'  onclick='javascript:showDdzt(\""+rowData.ddid+"\");' >状态查看</a>";
		                $(grid_selector).setRowData(ids[i],{DelBtn:delBtn});
		            }
			}
		},{
			add:false,
			edit:false,
			del:false,
			view:true,
			viewfunc:viewfunc
		}).jqGrid('setFrozenColumns');
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/track/trackInfo/export'/>"});
	    			}
	    		});
	        }
		});
		//同步订单状态
		$("#btn-tbddzt").click(function(){
        	$("body").bindSweetAlert({
    			title:"确定要同步吗?",
    			closeOnConfirm: true
    		},{
    			callback:function(){
    				$.bindAjax({
						url:"<c:url value='/track/trackInfo/tbddzt'/>",
						action:"edit"
					},function(response){
						$(grid_selector).trigger("reloadGrid");
					});
    			}
    		});
		});
	});
	
	function showDdzt(ddid){
		var width = 1000;
		var height = 360;
		var left = (window.screen.width-width)/2;
		var top = (window.screen.height-height)/2;
		var pageUrl = "<c:url value='/track/trackInfo/viewZtzt'/>?ddid="+ddid;
		if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
			var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
			window.showModalDialog(pageUrl,null,dialogArgs);
		}else{
			var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
			window.open(pageUrl,null,dialogArgs);
		}
	}
	//查看
	function viewfunc(){
		var id = jQuery(grid_selector).jqGrid('getGridParam','selrow');
		var rowData = jQuery(grid_selector).jqGrid('getRowData',id);
		location.href = "<c:url value='/track/trackInfo/viewDdxq'/>" + "?ddid=" + rowData.ddid;
	}
</script>
</html>