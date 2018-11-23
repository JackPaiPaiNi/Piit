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
										<select multiple="" data-placeholder="请选择..." name="jixinCx"  class="width-80 chosen-select">	
											 <%-- ${fns:loadDictOption('JIXIN')} --%>
											 ${fns:loadModelOption('0','0')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">机型&nbsp;&nbsp;</label>
										<select multiple="" data-placeholder="请选择..." name="jixingCx" class="width-80 chosen-select">	
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
	
	$(function($) {
		selectXsyInit();
		// 取周次
		bindWeekselect();
		// select2控件绑定
	    $(".skyselect").select2();
		// 多选控件
		$(".chosen-select").chosen();
		$(grid_selector).bindTable({
			url: "<c:url value='/fcst/fcstSampleData/search'/>",
			editurl: "<c:url value='/fcst/fcstSampleData/edit'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			autoheight:true,
			extraheight:$('#search-box').height(),
			//shrinkToFit: false,
			//autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'xsymc', index:'xsymc', label:'销售员', width:80},
				{name:'zcrq', index:'zcrq', label:'周次', width:140},
				{name:'sl', index:'sl', label:'数量', width:60,align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','}},
				{name:'xwgjmc', index:'xwgjmc', label:'销往国家名称', width:80},
				{name:'jixing', index:'jixing', label:'机型', width:80},
				{name:'jixin', index:'jixin', label:'机芯', width:80},
				{name:'ptbh', index:'ptbh', label:'屏体编号', width:80},
				{name:'wgys', index:'wgys', label:'外观颜色', width:80},
				{name:'logo', index:'logo', label:'Logo', width:80},
				{name:'yjyt', index:'yjyt', label:'样机用途', width:80},
				{name:'chsj', index:'chsj', label:'出货时间', width:80},
				{name:'zt', index:'zt', label:'状态', width:80, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('YJTBZT')}"}},
				{name:'psyj', index:'psyj', label:'SRF序号', width:80},
				{name:'sjc', index:'sjc', label:'时间戳', width:80, editable:false, hidden: true}
			]
		},{
			add:false,
			edit:false,
			del:false
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstSampleData/export'/>"});
	    			}
	    		});
	        }
		});
	});
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
</script>
</html>