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
					<h5>采购FCST样机评审</h5>
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
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							导出
						</button>
							&nbsp;
						<button id="btn-save" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-save icon-on-right bigger-110"></i>
							保存
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
										<input type="hidden" name="xsyid" class="form-control"/>
										<input type="text" name="xsymc" onfocus="this.blur()"
											class="form-control parent-node" style="cursor: pointer!important;" />
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">周次&nbsp;&nbsp;</label>
										<input type="text" name="zc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机芯&nbsp;&nbsp;</label>
										<select multiple="" data-placeholder="请选择..." name="jixin"  class="width-80 chosen-select">	
											 <%-- ${fns:loadDictOption('JIXIN')} --%>
											 ${fns:loadModelOption('0','0')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机型&nbsp;&nbsp;</label>
										<select multiple="" data-placeholder="请选择..." name="jixing" class="width-80 chosen-select">	
											 <%-- ${fns:loadDictOption('JIXING')} --%>
											 ${fns:loadModelOption('0','1')}
										</select>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">								
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">状态&nbsp;&nbsp;</label>
										<select role="select" name="zt" size="1" class="form-control skyselect">
											${fns:loadDictOption('YJTBZT')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">SRF序号&nbsp;&nbsp;</label>
										<input type="text" name="psyj" class="form-control"/>
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
<shiro:hasPermission name="fcst:fcstSampleData:edit">isEdit=true;</shiro:hasPermission>
var isHide = true;

$(function($) {
	selectXsyInit();
	// 取周次
	bindWeekselect();
	// select2控件绑定
    $(".skyselect").select2();
	$(".chosen-select").chosen();
	/**************************************************编辑表初始化开始区域************************************************/
	var gridTable = $(grid_selector).bindTable({
		url:"<c:url value='/fcst/fcstSampleData/search'/>",
		pager: pager_selector,
		gridParent: "#grid-parent",
		formSearch: "#form-search",
		autoheight:true,
		extraheight:$('#search-box').height() +5,
		editTable:true,
		rowNum : 100,
		shrinkToFit: false,
		autoScroll: false,
		multiselect: true,
		colModel: [  
			{name:'sjc', index:'sjc', label:'时间戳', width:80, hidden: true},
			{name:'id', label:'ID', hidden: true, width:60},
			{name:'zc', index:'zc', label:'周次', editable:false, width:80,hidden: true},
			{name:'zcrq', index:'zcrq', label:'周次', editable:false, width:120},			
			{name:'xsymc', index:'xsymc', label:'销售员',editable:false, width:80},
			{name:'xsyid', index:'xsyid', label:'销售员',hidden:true, editable:false, width:80},
			{name:'khbm', index:'khbm', label:'客户', editable:false, width:80},
			{name:'khmc', index:'khmc', label:'客户名称', editable:false, width:80, hidden: true},
			{name:'xwgj', index:'xwgj', label:'销往地', width:80, editable:false, edittype:"select", formatter:"select", 
				editoptions:{value:"${fns:loadCountryOption('1')}",dataInit: initSelect2}},
			{name:'jixing', index:'jxing', label:'机型', width:80, editable:false},
			{name:'jixin', index:'jixin', label:'机芯', width:80, editable:false},
			{name:'sl', index:'sl', label:'数量', editable:false, width:60,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
			{name:'ptbh', index:'ptbh', label:'屏体编号', editable:false, width:80},
			{name:'wgys', index:'wgys', label:'外观颜色', editable:false, width:80},
			{name:'logo', index:'logo', label:'Logo', editable:false, width:80},
			{name:'yjyt', index:'yjyt', label:'样机用途', editable:false, edittype:"select", formatter:"select", 
				editoptions:{value:"${fns:loadDictEditOption('YJYT')}",dataInit: initSelect2}, width:80},
			{name:'chsj', index:'chsj', label:'出货时间', editable:false, width:80},
			{name:'psyj', index:'psyj', label:'SRF序号', editable:true, width:80},
			{name:'zt', index:'zt', label:'状态', width:80, editable:true, edittype:"select",formatter: "select",
				editoptions:{value:"${fns:loadDictEditOption('YJTBZT')}"}}
		],editComplete: function(lastEdit, rowData){
			
		} 
	},{
		add:false,
		edit:isEdit,
		del:false,
		complete:isEdit
	});
	
	/**************************************************function开始区域************************************************/	
	//查询
	$("#btn-search").click(function(){
		$(grid_selector).trigger("reloadGrid");
    });
	
	$("#btn-save").click(function(){
		save();
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstSampleData/export'/>?zt=1"});
	    			}
	    		});
	        }
		});		
		
	});
	
	//初始化编辑表select2
	function initSelect2(elem){
		$(elem).width(140).addClass("skyselect").select2();
	}

    // 保存
	function save() {
		var lastSel = $(grid_selector).getGridParam('selrow');
		$(grid_selector).saveRow(lastSel, false, 'clientArray');
		var data = $(grid_selector).jqGrid("getGridParam", "selarrrow");
		// 判断是否选了数据
		if(!data.length > 0){
			swal("","请至少勾选一条记录！","warning");
			return;
		}
		// 循环处理选中数据（可多选）
		var rows = [];
		for (var i = 0; i < data.length; i++) {
			var rowData = $(grid_selector).jqGrid("getRowData", data[i]);
			rows.push(rowData);
		}
		// 获取表单数据
		var param = $("#form-search").getFormData();
		param.itemListStr = JSON.stringify(rows);
		$("body").bindSweetAlert({
			title : "确定要保存吗?"
		}, {
			callback : function() {
				$.bindAjax({
					url : "<c:url value='/fcst/fcstSampleData/edit'/>",
					data : param,
					action : "save"
				}, function(response) {
					$(grid_selector).trigger("reloadGrid");
				});
			}
		});
	} 
	// 销售员选择
	function selectXsyInit(){
		$("#form-search [name=xsymc]").bindTreeTableDialog({
			title:"销售员选择",
			leftUrl : "<c:url value='/core/organization/loadTree'/>",//左侧树查询的url
			rightUrl : "<c:url value='/mdm/employee/search'/>",//右侧列表查询的url
			leftSearchParams:[{"name":"编码","value":"code"},{"name":"名称","value":"name"}],
			rightSearchParams:[{"name":"员工号","value":"empCode"},{"name":"员工名","value":"name"}],
			rightColModel:[{"colName":"empCode","colTitle":"员工号","width":"40%"},
				           {"colName":"name","colTitle":"员工名","width":"40%"},
				           {"colName":"xszz","colTitle":"销售组织",hidden:true},
				           {"colName":"xszzmc","colTitle":"销售组织名称",hidden:true},
				           {"colName":"ywz","colTitle":"业务组",hidden:true},
				           {"colName":"ywzmc","colTitle":"业务组名称",hidden:true}],
			autoParam:["id=parentCode"],
			dataParams:{"sys":"base"},//查询基础架构
			nodeParams:[{"nodeField":"id","searchParam":"deptCode"}]//右侧查询时会附带选中的树节点的信息，取节点的id属性值以deptCode这个参数名传到后台
		},{
			callback:function(record){
				if(record){
					$("#form-search [name=xsyid]").val(record.empCode);//参考rightColModel
					$("#form-search [name=xsymc]").val(record.name);
				}else{
					$("#form-search [name=xsyid]").val("");
					$("#form-search [name=xsymc]").val("");
				}
			}
		});
	}
	//取周次
	function bindWeekselect(){
		$.post("<c:url value='/pub/select2/selectFcstWeek'/>",{},
			function(result){
				var data = $.map(result, function (obj) {
					obj.id = obj.zc;
					obj.text = obj.rq ||obj.rq;     
			        return obj;
				});
					$("#form-search [name=zc]").addClass("skyselect").select2({data:data}).on("change",function(e){
					})
				}, "json");
	}
	/**************************************************function結束区域************************************************/	
</script>
</html>