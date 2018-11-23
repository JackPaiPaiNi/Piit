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
							<i class="icon-search icon-on-right bigger-110"></i>
							查询
						</button>
 						&nbsp;
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							导出
						</button>
			
					</div>
			</div>
				<div class="widget-body">
				<div class="widget-main">
					<form id="form-search" name="form-search" class="form-search">
                         <div class="row">
                         		<input type="hidden" name="level"/>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单类型&nbsp;&nbsp;</label>
										<select role="select" name="ddlx" size="1" class="form-control skyselect">
											${fns:loadDictOption('DDLX')}
										</select>
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
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('DJZT')}
										</select>
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
							<div class="space-4" ></div>
							 <div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">版本号&nbsp;&nbsp;</label>
										<input type="text" name="bbh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label>
										<input type="text" name="zdrid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机芯&nbsp;&nbsp;</label>
										<input type="text" name="jixin" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机型&nbsp;&nbsp;</label>
										<input type="text" name=wsxh class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4" ></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">最晚交货时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZwjhsj" name="beginZwjhsj"/>
										<input type="hidden" id="endZwjhsj" name="endZwjhsj"/>
										<input type="text" name="zwjhsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">推送SAP时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginTssapsj" name="beginTssapsj"/>
										<input type="hidden" id="endTssapsj" name="endTssapsj"/>
										<input type="text" name="tssapsj" class="form-control timeInterval"/>
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
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var form_search = "#form-search";
	$(function($) {
		$(".skyselect").select2();
		//$(".timeInterval").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")},{startElement:$("#beginZwjhsj"),endElement:$("#endZwjhsj")});
		$("#form-search [name=zdsj]").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$("#form-search [name=zwjhsj]").bindDateRange({startElement:$("#beginZwjhsj"),endElement:$("#endZwjhsj")});
		$("#form-search [name=tssapsj]").bindDateRange({startElement:$("#beginTssapsj"),endElement:$("#endTssapsj")});
		$(grid_selector).bindTable({
			url: "<c:url value='/report/orderLinkDataReport/searchOrderLink'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			rowNum:20,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
						{name:'yf', index:'yf', label:'月份', width:100},
						{name:'zdsj', index:'zdsj', label:'制单时间',formatter:'date', formatoptions:{newformat:'Y-m-d'}, width:100},
						{name:'ztmc', index:'ztcmc', label:'状态', width:100},
						{name:'ddid', index:'ddid', label:'订单号', width:100},
						{name:'bbh', index:'bbh', label:'版本号', width:50},
						{name:'ddlbmc', index:'ddlbmc', label:'订单类别', width:100},
						{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:100},
						{name:'jgfsmc', index:'jgfsmc', label:'加工方式', width:100},
						{name:'pid', index:'pid', label:'PID', width:100},
						{name:'pxxbc', index:'pxxbc', label:'屏编码', width:100},
						{name:'cc', index:'cc', label:'尺寸', width:100},
						{name:'jixin', index:'jixin', label:'机芯', width:100},
						{name:'wsxh', index:'wsxh', label:'机型', width:100},
						{name:'mjxh', index:'mjxh', label:'买家型号', width:100},
						{name:'dsjlxmc', index:'dsjlxmc', label:'电视机类型', width:100},
						{name:'sl', index:'sl', label:'数量', width:100},
						<shiro:hasPermission name="report:orderLinkDataReport:price">
						{name:'dj', index:'dj', label:'单价', width:100},
						{name:'zje', index:'zje', label:'金额', width:100},
						</shiro:hasPermission>
						{name:'pp', index:'pp', label:'品牌', width:100},
						{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:100},
						{name:'khmc', index:'khmc', label:'客户名称', width:100},
						{name:'xsymc', index:'xsymc', label:'销售员', width:100},
						{name:'ywzmc', index:'ywzmc', label:'业务组', width:100},
						{name:'xszzmc', index:'xszzmc', label:'销售组', width:100},
						{name:'gsbm', index:'gsbm', label:'公司', width:60},
						{name:'fktjmc', index:'fktjmc', label:'付款条件', width:100},
						{name:'gjmytkmc', index:'gjmytkmc', label:'国际贸易条款', width:100},
						{name:'gjmytkbz', index:'gjmytkbz', label:'国际贸易备注', width:100},
						{name:'rz1', index:'rz1', label:'认证1', width:100},
						{name:'rz2', index:'rz2', label:'认证2', width:100},
						{name:'rz3', index:'rz3', label:'认证3', width:100},
						{name:'sf_rohs', index:'sf_rohs', label:'是否要RoHS', width:100},
						{name:'sf_reach', index:'sf_reach', label:'是否需要REACH', width:100},
						{name:'sf_yh', index:'sf_yh', label:'是否验货', width:100},
						{name:'sf_ffbs', index:'sf_ffbs', label:'是否付费备损', width:100},
						{name:'mfbsmc', index:'mfbsmc', label:'免费备损名称', width:100},
						{name:'tssapsj', index:'tssapsj', label:'推送SAP时间',formatter:'date', formatoptions:{newformat:'Y-m-d'}, width:100},
						{name:'ycps', index:'ycps', label:'一次评审时间',formatter:'date', formatoptions:{newformat:'Y-m-d'}, width:100},
						{name:'ddzgd', index:'ddzgd', label:'订单转工单', width:100},
						{name:'zzjhrq', index:'zzjhrq', label:'最早交货日期', width:100,formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name:'zwjhrq', index:'zwjhrq', label:'最晚交货日期', width:100,formatter:'date', formatoptions:{newformat:'Y-m-d'}},
						{name:'ycrq', index:'ycrq', label:'预测日期',formatter:'date', formatoptions:{newformat:'Y-m-d'}, width:100},
						{name:'yczc', index:'yczc', label:'预测周次', width:100},
						{name:'ycsl', index:'ycsl', label:'预测数量', width:100},
						{name:'zc', index:'zc', label:'周次', width:100},
						/* {name:'jhrq', index:'jhrq', label:'交货日期',formatter:'date', formatoptions:{newformat:'Y-m-d'}, width:100},
						{name:'ycpsjhrq', index:'ycpsjhrq', label:'一次评审交货日期',formatter:'date', formatoptions:{newformat:'Y-m-d'}, width:100}, */
						{name:'sf_p', index:'sf_p', label:'是否有屏', width:100},
						{name:'khbm', index:'khbm', label:'客户编码', width:100},
						{name:'ddlxmc', index:'ddlxmc', label:'订单类型', width:100},
						{name:'mgrwdh', index:'mgrwdh', label:'美工任务单号', width:150},
						{name:'wkysbz', index:'wkysbz', label:'外壳颜色标准', width:100},
						{name:'kjlogo', index:'kjlogo', label:'开机LOGO', width:100},
						{name:'ccyymc', index:'ccyymc', label:'出厂语言', width:100},
						{name:'zhm', index:'zhm', label:'走货码', width:80},
						{name:'version', index:'version', label:'版本号', width:80},
						{name:'bs', index:'bs', label:'标识号', width:100},
						{name:'zhmt', index:'zhmt', label:'走货码', width:80},
						{name:'versiont', index:'versiont', label:'版本号', width:80},
						{name:'bst', index:'bst', label:'标识号', width:100},
			]
		},{
			add:false,
			edit:false,
			del:false
		});
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
		$("#btn-export").click(function(){
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/report/orderLinkDataReport/export'/>"});
	    			}
	    		});
	        }
		});
	})
</script>
</html>