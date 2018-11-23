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
					<h5>查询条件(系统默认查询装柜时间为本月的数据)</h5>
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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">订单号&nbsp;&nbsp;</label>
										<input type="text" name="ddid" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">目的国家&nbsp;&nbsp;</label>
										<input type="text" name="xwgjmc" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜时间&nbsp;&nbsp;</label>
										<input type="hidden" id="szgsj" name="szgsj"/>
										<input type="hidden" id="ezgsj" name="ezgsj"/>
										<input type="text" id="zgsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">订舱号&nbsp;&nbsp;</label>
										<input type="text" name="dch" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">截关期&nbsp;&nbsp;</label>
										<input type="hidden" id="sjgq" name="sjgq"/>
										<input type="hidden" id="ejgq" name="ejgq"/>
										<input type="text" id="jgq" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">截VGM&nbsp;&nbsp;</label>
										<input type="hidden" id="sjvgm" name="sjvgm"/>
										<input type="hidden" id="ejvgm" name="ejvgm"/>
										<input type="text" id="jvgm" class="form-control timeInterval"/>
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
										<label class="input-group-addon">截SI&nbsp;&nbsp;</label>
										<input type="hidden" id="sjsi" name="sjsi"/>
										<input type="hidden" id="ejsi" name="ejsi"/>
										<input type="text" id="jsi" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预计开船期&nbsp;&nbsp;</label>
										<input type="hidden" id="syjkcq" name="syjkcq"/>
										<input type="hidden" id="eyjkcq" name="eyjkcq"/>
										<input type="text" id="yjkcq" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">拖车公司&nbsp;&nbsp;</label>
										<input type="text" name="tcgs" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
									<label class="input-group-addon">船务跟单&nbsp;&nbsp;</label>
										<input type="text" name="cwzymc" class="form-control" />
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
	var isEdit = false;
	<shiro:hasPermission name="shipmentplan:shipmentplan:edit">isEdit=true;</shiro:hasPermission>
	$(function($) {
		$("#zgsj").bindDateRange({startElement:$("#szgsj"),endElement:$("#ezgsj")});
		$("#jgq").bindDateRange({startElement:$("#sjgq"),endElement:$("#ejgq")});
		$("#jvgm").bindDateRange({startElement:$("#sjvgm"),endElement:$("#ejvgm")});
		$("#jsi").bindDateRange({startElement:$("#sjsi"),endElement:$("#ejsi")});
		$("#yjkcq").bindDateRange({startElement:$("#syjkcq"),endElement:$("#eyjkcq")});
		$(".skyselect").select2();
		
		$(grid_selector).bindTable({
			caption:"",
			url: "<c:url value='/shipmentplan/shipmentplan/search'/>",
			editurl: "<c:url value='/shipmentplan/shipmentplan/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			rowNum : 20,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name : 'hwgylmc', index : 'hwgylmc', label : '海外供应链', width : 80, editable:false, formoptions:{rowpos: 1, colpos: 1}},
				{name : 'xszzmc', index : 'xszzmc', label : '销售组织', width : 80, editable:false, formoptions:{rowpos: 1, colpos: 2}},
				{name : 'ywzmc', index : 'ywzmc', label : '业务组', width : 80, editable:false, formoptions:{rowpos: 1, colpos: 3}},
				{name : 'xsymc', index : 'xsymc', label : '销售员', width : 60, editable:false, formoptions:{rowpos: 1, colpos: 3}},
				{name : 'xszcmc', index : 'xszcmc', label : '销售支持', width : 70, editable:false, formoptions:{rowpos: 1, colpos: 3}},
				{name : 'yzhlxmc', index : 'yzhlxmc', label : '预走货类型', width : 80, editable:false, formoptions:{rowpos: 1, colpos: 3}},
				{name : 'yzhdh', index : 'yzhdh', label : '预走货单号', width : 95, formoptions:{rowpos: 2, colpos: 1},editrules:{edithidden:true},editoptions:{disabled:true}},
				{name : 'ztyzhdh', index : 'ztyzhdh', label : '主体预走货单号', width : 100, editable:false, formoptions:{rowpos: 2, colpos: 2}},
				{name : 'gsbm', index : 'gsbm', label : '公司', width : 40, editable:false, formoptions:{rowpos: 2, colpos: 2}},
				/* {name : 'gsmc', index : 'gsmc', label : '公司', width : 60, hidden:true, formoptions:{rowpos: 2, colpos: 2}}, */
				{name : 'khmc', index : 'khmc', label : '客户', width : 160, editable:false, formoptions:{rowpos: 2, colpos: 2}},
				{name : 'ddid', index : 'ddid', label : '订单号', width : 90, editable:false, formoptions:{rowpos: 2, colpos: 2}},
				{name : 'zhfsmc', index : 'zhfsmc', label : '走货方式', width : 40, editable:false, formoptions:{rowpos: 2, colpos: 2}},
				{name : 'jixing', index : 'jixing', label : '我司型号', width : 65, editable:false, formoptions:{rowpos: 2, colpos: 2}},
				{name : 'xwgjmc', index : 'xwgjmc', label : '目的国家', width : 80, editable:false, formoptions:{rowpos: 2, colpos: 2}},
				{name : 'mytkmc', index : 'mytkmc', label : '贸易条款', width : 65, editable:false, formoptions:{rowpos: 2, colpos: 2}},
				{name : 'sl', index : 'sl', label : '数量', width : 60, editable:false, align:'right', /* formatter:'integer', formatoptions:{thousandsSeparator:','}, */ formoptions:{rowpos: 2, colpos: 2}},
				{name : 'sjsl', index : 'sjsl', label : '散件数量', width : 60, editable:false, align:'right', /* formatter:'integer', formatoptions:{thousandsSeparator:','}, */ formoptions:{rowpos: 2, colpos: 2}},
				{name : 'zgsj', index : 'zgsj', label : '开始装柜时间', width : 90, editrules:{edithidden:true},formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 2, colpos: 2}, editoptions: {
                    dataInit: function (element) {
                        $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                    }
                 }},
                {name : 'dch', index : 'dch', label : '订舱号', width : 80, formoptions:{rowpos: 2, colpos: 3},editrules:{edithidden:true}},
 				{name : 'jgq', index : 'jgq', label : '截关期', width : 80, editrules:{edithidden:true},formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 3, colpos: 1}, editoptions: {
                     dataInit: function (element) {
                         $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                     }
                  }},
                {name : 'jvgm', index : 'jvgm', label : '截VGM', width : 80, editrules:{edithidden:true},formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 3, colpos: 2}, editoptions: {
                      dataInit: function (element) {
                          $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                      }
                   }},
  				{name : 'jsi', index : 'jsi', label : '截SI', width : 80, editrules:{edithidden:true},formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 3, colpos: 3}, editoptions: {
                      dataInit: function (element) {
                          $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                      }
                   }},
                {name : 'tcgs', index : 'tcgs', label : '拖车公司', width : 65, formoptions:{rowpos: 4, colpos: 1},editrules:{edithidden:true}},
                {name : 'sgap', index : 'sgap', label : '上柜安排', width : 65, formoptions:{rowpos: 4, colpos: 2},editrules:{edithidden:true}},
				{name : 'cwzymc', index : 'cwzymc', label : '船务跟单', width : 65, editable:false, formoptions:{rowpos: 4, colpos: 3}},
				{name : 'jszgsj', index : 'jszgsj', label : '结束装柜时间', width : 90, editrules:{edithidden:true},formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 4, colpos: 3}, editoptions: {
                    dataInit: function (element) {
                        $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                    }
                 }},
				{name : 'chflmc', index : 'chflmc', label : '出货分类', width : 65, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'spmc', index : 'spmc', label : '商品名称', width : 80, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'mdg', index : 'mdg', label : '目的港', width : 80, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'pp', index : 'pp', label : '品牌', width : 80, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'cc', index : 'cc', label : '尺寸', width : 40, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'khxhms', index : 'khxhms', label : '客户型号', width : 70, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'mfjsl', index : 'mfjsl', label : '免费机数量', width : 80, editable:false, align:'right', /* formatter:'integer', */ formoptions:{rowpos: 5, colpos: 1}},
				{name : 'bz', index : 'bz', label : '币种', width : 40, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'dj', index : 'dj', label : '单价', width : 60, editable:false, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'je', index : 'je', label : '总价', width : 60, editable:false, align:'right', formatter:'integer', formatoptions:{thousandsSeparator:','}, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'ztmc', index : 'ztmc', label : '预走货状态', width : 80, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'bbh', index : 'bbh', label : '预走货版本号', width : 90, editable:false, formoptions:{rowpos: 5, colpos: 1}},
				{name : 'yjkcq', index : 'yjkcq', label : '预计开船期', width : 80, editrules:{edithidden:true},formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 5, colpos: 1}, editoptions: {
                    dataInit: function (element) {
                        $(element).datepicker({autoclose: true, format: 'yyyy-mm-dd'});
                    }
                 }},
				{name : 'kcy', index : 'kcy', label : '开船月', width : 50, editable:false, formoptions:{rowpos: 5, colpos: 2}},
				{name : 'chdh', index : 'chdh', label : '出货通知书号', width : 90, editable:false, formoptions:{rowpos: 5, colpos: 2}},
				{name : 'chzt', index : 'chzt', label : '出货状态', width : 65, editable:false, formoptions:{rowpos: 5, colpos: 2}},
				{name : 'cylxmc', index : 'cylxmc', label : '出运类型', width : 65, editable:false, formoptions:{rowpos: 5, colpos: 2}},
				{name : 'qyg', index : 'qyg', label : '起运港', width:60, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('QYG')}"},formoptions:{rowpos: 5, colpos: 2},editrules:{edithidden:true}},
				{name : 'yg20gp', index : 'yg20gp', label : "20'GP", width : 50, formoptions:{rowpos: 5, colpos: 3},editrules:{edithidden:true}},
				{name : 'yg40gp', index : 'yg40gp', label : "40'GP", width : 50, formoptions:{rowpos: 6, colpos: 1},editrules:{edithidden:true}},
				{name : 'yg40hq', index : 'yg40hq', label : "40'HQ", width : 50, formoptions:{rowpos: 6, colpos: 2},editrules:{edithidden:true}},
				{name : 'dc3d', index : 'dc3d', label : '3吨', width : 50, formoptions:{rowpos: 6, colpos: 3},editrules:{edithidden:true}},
				{name : 'dc5d', index : 'dc5d', label : "5吨", width : 50, formoptions:{rowpos: 7, colpos: 1},editrules:{edithidden:true}},
				{name : 'dc8d', index : 'dc8d', label : "8吨", width : 50, formoptions:{rowpos: 7, colpos: 2},editrules:{edithidden:true}},
				{name : 'dc10d', index : 'dc10d', label : "10吨", width : 50, formoptions:{rowpos: 7, colpos: 3},editrules:{edithidden:true}},
				{name : 'dc12d', index : 'dc12d', label : "12吨", width : 50, formoptions:{rowpos: 8, colpos: 1},editrules:{edithidden:true}},
				{name : 'yzhddsj', index : 'yzhddsj', label : '收到预走货时间', width : 90, editable:false,formatter:'date', formatoptions:{newformat:'Y-m-d'}, formoptions:{rowpos: 8, colpos: 2}},
				{name : 'bzxx', index : 'bzxx', label : '备注', width : 150, formoptions:{rowpos: 8, colpos: 2},editrules:{edithidden:true}}
			]
		},{
			add:false,
			edit:isEdit,
			del:false,
			view:false
		});
	
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/shipmentplan/shipmentplan/export'/>"});
	    			}
	    		});
	        }
		});
	});
</script>
</html>