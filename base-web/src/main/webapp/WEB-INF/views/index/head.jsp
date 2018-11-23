<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="author" content="http://mdm.com/"/>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Expires" content="0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Cache-Control" content="no-store">

<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="bookmark" type="image/x-icon" /> 
<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="icon" type="image/x-icon" /> 
<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="shortcut icon" type="image/x-icon" /> 

<!-- basic styles -->
	<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css?v=5" rel="stylesheet" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font-awesome.ace.css" />
	<!-- page specific plugin styles -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui-1.10.3.full.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/jquery-ui-1.10.3.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/datepicker.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/daterangepicker.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap-timepicker.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap-datetimepicker.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/ui.jqgrid.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/chosen.css" /><!-- 下拉框 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/multi-select.css" /><!-- select多选 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/sweetalert.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/simpletooltip.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/select2.css?v=1" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/loading-zhezhao.css" />
	<!-- fonts -->
	<!-- <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" /> -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/fonts.googleapis.com.css" />  <!-- laill -->
	<!-- ace styles -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/ace.min.css?v=53" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/ace-skins.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css.css" />
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css?v=2">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layer/skin/default/layer.css" />
	<!-- basic scripts -->
	<script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.serializeObject.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery-ui-1.10.3.full.min.js"></script>
	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='${pageContext.request.contextPath}/static/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
	</script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/typeahead-bs2.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery-ui-1.10.3.custom.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/date-time/bootstrap-datepicker.zh-CN.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/date-time/bootstrap-datetimepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/date-time/bootstrap-timepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/date-time/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/date-time/daterangepicker.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.easy-pie-chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.sparkline.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/chosen.jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.autosize.min.js"></script><!-- 文本域 -->
	<script src="${pageContext.request.contextPath}/static/js/jquery.inputlimiter.1.3.1.min.js"></script><!-- 文本域 -->
	<script src="${pageContext.request.contextPath}/static/js/jquery.multi-select.js"></script><!-- select 多选 -->
	<script src="${pageContext.request.contextPath}/static/js/sweetalert.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script><!-- 校验 -->
	<script src="${pageContext.request.contextPath}/static/js/bootbox.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/bootstrap-tag.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/simpletooltip.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/select2.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/static/js/flot/jquery.flot.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/flot/jquery.flot.pie.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/flot/jquery.flot.resize.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/static/js/jqGrid/jquery.jqGrid.min.js?v=2"></script>
	<script src="${pageContext.request.contextPath}/static/js/jqGrid/i18n/grid.locale-cn.js?v=1"></script>
	<!-- ace scripts -->
	<script src="${pageContext.request.contextPath}/static/js/ace-elements.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/ace.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/ace-extra.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/static/JQuery zTree v3.5.15/js/jquery.ztree.all-3.5.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.gridUtil.js?v=4"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.datepicker.js?v=6"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.util.js?v=10"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/hashmap.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/Util.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.bootboxUtil.js?v=4"></script>
	<script src="${pageContext.request.contextPath}/static/js/sidebar-menu.js"></script>
	<script src="${pageContext.request.contextPath}/static/layer/layer.js"></script>
	
    <script src="${pageContext.request.contextPath}/static/js/common/skyutil.js"></script>
	
	<style type="text/css">
	.skyselect{
		padding: 0 !important;
		border: none !important;
	}
	.fcst_qlz_td{
		background: #CCFFFF !important;
	}
	.fcst_sdz_td{
		background: #FFFF00 !important;
	}
	.fcst_dqz_td{
		background: #FDCEF9 !important;
	}
	.fcst_dds_td{
		background: #CCCCCC !important;
	}

	</style>
	
	<script type="text/javascript">
		document.onkeydown = function(e){
			var theEvent = window.event || e;
			var code = theEvent.keyCode || theEvent.which;
			if(code==8){
				var elem = theEvent.srcElement;
				var name = elem.nodeName;
				
				if(name!='INPUT' && name!='TEXTAREA' && name!='DIV'){
					if (theEvent && theEvent.preventDefault){
						theEvent.preventDefault();
					} else {
						theEvent.returnValue = false;
					}
					return;
				}
				if(!elem.type){
					return;
				}
				var type_e = elem.type.toUpperCase();
				if(name=='INPUT' && (type_e!='TEXT' && type_e!='TEXTAREA' && type_e!='PASSWORD' && type_e!='FILE')){
					if (theEvent && theEvent.preventDefault){
						theEvent.preventDefault();
					} else {
						theEvent.returnValue = false;
					}
					return;
				}
				if(name=='INPUT' && (elem.readOnly==true || elem.disabled ==true)){
					if (theEvent && theEvent.preventDefault){
						theEvent.preventDefault();
					} else {
						theEvent.returnValue = false;
					}
					return;
				}
			}
		}
	</script>
	