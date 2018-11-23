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
										<label class="input-group-addon">录入方式&nbsp;&nbsp;</label>
										<select role="select" name="lrfs" size="1" class="form-control skyselect">
											${fns:loadDictOption('LRFS')}
										</select>
									</div>
								</div>	
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务部&nbsp;&nbsp;</label>
										<input type="hidden" name="xszz" value="${xszz}"/>
										<input type="text" id="xszzmc" name="xszzmc" value="${xszzmc}" onfocus="this.blur()" class="form-control  parent-node"/>
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务组&nbsp;&nbsp;</label>
										<input type="hidden" name="ywz"/>		
										<input type="text" id="ywzmc" name="ywzmc" onfocus="this.blur()" class="form-control  parent-node"/>
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务员&nbsp;&nbsp;</label>
										<input type="hidden" name="xsyid" class="form-control"/>
										<input type="text" name="xsymc" onfocus="this.blur()"
											class="form-control parent-node" style="cursor: pointer!important;" />
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="hidden" name="khbm" />
										<input type="text" id="khmc" name="khmc" onfocus="this.blur()" class="form-control  parent-node"/>
										<span class="input-group-addon">
											<i class="icon-search bigger-110"></i>
										</span>
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
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">走货开始周&nbsp;&nbsp;</label> 
										<input type="text" name="kszc" value="${zc}" class="form-control" />
									</div>
								</div>
							</div>		
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">走货结束周&nbsp;&nbsp;</label> 
										<input type="text" name="jszc" value="${zc}" class="form-control" />
									</div>
								</div>	
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PID&nbsp;&nbsp;</label>
										<input type="text" id="pid" name="pid" class="form-control"/>
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
		$(".chosen-select").chosen();
		$(".date-picker").bindYearMonth();
		// 销售组织选择框
		$("#xszzmc").parent().click(function(){
			bindXszz();
		});
		// 业务组选择框
		$("#ywzmc").parent().click(function(){
			bindYwz();
		});
		// 客户选择框
		$("#khmc").parent().click(function(){
			bindKhbm();
		});
/* 		// PID选择
		$("#form-search [name=pid]").click(function(){
			selectPidInit();
		}); */
		//销售员选择
		selectXsyInit();
		//取周次
		bindWeekselect();
		$(grid_selector).bindTable({
			url: "<c:url value='/fcst/fcstData/searchFcst'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			rowNum:200,
			footerrow: true,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height(),
			colModel: [
						{name:'id', label:'ID', hidden: true, width:60},
						{name:'lrfs', index:'lrfs', label:'录入方式', width:60, edittype:"select", 
							formatter:"select", editoptions:{value:"${fns:loadDictEditOption('LRFS')}"}},
						{name:'xszzmc', index:'xszzmc', label:'业务部', width:95},
						{name:'ywzmc', index:'ywzmc', label:'业务组', width:95},
						{name:'xsymc', index:'xsymc', label:'业务员', width:60},
						{name:'khmc', index:'khmc', label:'客户', width:200},
						{name:'khbm', index:'khbm', label:'客户编码', width:80},
						{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:80},
						{name:'pp', index:'pp', label:'客户品牌', width:80},
						{name:'pid', index:'pid', label:'PID', width:140},
						{name:'cc', index:'cc', label:'尺寸', width:40},
						{name:'jixing', index:'jixing', label:'机型', width:60},
						{name:'jixin', index:'jixin', label:'机芯', width:60},
						{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:60},
			],
			gridComplete:function(){
				sumGrid();
			}
		},{
			add:false,
			edit:false,
			del:false
		});
		
		$(".date-picker").bindDate();
		$(".timeInterval").bindDateRange();
	
		//查询
		$("#btn-search").click(function(){
			$.bindAjax({
				url : "<c:url value='/fcst/fcstData/findFcstTitles'/>",
				data:{kszc:$("#form-search [name=kszc]").val(),
					  jszc:$("#form-search [name=jszc]").val()},
				action : "search"
			},function(response) {
				var model = [
								{name:'id', label:'ID', hidden: true, width:60},
								{name:'lrfs', index:'lrfs', label:'录入方式', width:60, edittype:"select", 
									formatter:"select", editoptions:{value:"${fns:loadDictEditOption('LRFS')}"}},
								{name:'xszzmc', index:'xszzmc', label:'业务部', width:95},
								{name:'ywzmc', index:'ywzmc', label:'业务组', width:95},
								{name:'xsymc', index:'xsymc', label:'业务员', width:60},
								{name:'khmc', index:'khmc', label:'客户', width:200},
								{name:'khbm', index:'khbm', label:'客户编码', width:80},
								{name:'xwgjmc', index:'xwgjmc', label:'销往国家', width:80},
								{name:'pp', index:'pp', label:'客户品牌', width:80},
								{name:'pid', index:'pid', label:'PID', width:140},
								{name:'cc', index:'cc', label:'尺寸', width:60},
								{name:'jixing', index:'jixing', label:'机型', width:60},
								{name:'jixin', index:'jixin', label:'机芯', width:60},
								{name:'zhfsmc', index:'zhfsmc', label:'走货方式', width:60},
					];
				var groupheadersMonth=[];
				var groupheadersWeek=[];
				var groupheadersDay=[];
				for (var i =0;i <response.titles.length; i++){
					var rowMonth={};
					var rowWeek={};
					var rowDay={};
					var _modelYcs={};
					var _modelDds={};
					var _modelWxds={};
					rowMonth.startColumnName="w"+Number(i+1)+"Ycs";
					rowMonth.numberOfColumns=3;
					rowMonth.titleText=response.titles[i].month;
					groupheadersMonth.push(rowMonth);
					rowWeek.startColumnName="w"+Number(i+1)+"Ycs";
					rowWeek.numberOfColumns=3;
					rowWeek.titleText=response.titles[i].week;
					groupheadersWeek.push(rowWeek);
					rowDay.startColumnName="w"+Number(i+1)+"Ycs";
					rowDay.numberOfColumns=3;
					rowDay.titleText=response.titles[i].day;
					groupheadersDay.push(rowDay);
					_modelYcs.name="w"+Number(i+1)+"Ycs";
					_modelYcs.index="w"+Number(i+1)+"Ycs";
					_modelYcs.label="FCST需求";
					_modelYcs.width="80";
					_modelDds.name="w"+Number(i+1)+"Dds";
					_modelDds.index="w"+Number(i+1)+"Dds";
					_modelDds.label="订单数";
					_modelDds.width="80";
					_modelWxds.name="w"+Number(i+1)+"Wxds";
					_modelWxds.index="w"+Number(i+1)+"Wxds";
					_modelWxds.label="未下单FCST";
					_modelWxds.width="80";
					model.push(_modelYcs);
					model.push(_modelDds);
					model.push(_modelWxds);
				}
				$(grid_selector).GridUnload(); 
				$(grid_selector).bindTable({
					url: "<c:url value='/fcst/fcstData/searchFcst'/>",
					pager: pager_selector,
					gridParent: "#grid-parent",
					formSearch: "#form-search",
					rowNum:200,
					footerrow: true,
					shrinkToFit: false,
					autoScroll: false,
					autoheight:true,
					extraheight:$('#search-box').height()+48,
					colModel: model,
					gridComplete:function(){
						sumGrid();
					}
				},{
					add:false,
					edit:false,
					del:false
				});
				$(grid_selector).destroyCustomGroupHeader();
				$(grid_selector).setCustomGroupHeaders({
					useColSpanStyle: true,
					groupHeaders:groupheadersMonth
				 }).setCustomGroupHeaders({
					useColSpanStyle: true,
					groupHeaders:groupheadersWeek
				 }).setCustomGroupHeaders({
					useColSpanStyle: true,
					groupHeaders:groupheadersDay
					 });
			});
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstData/exportFcst'/>"});
	    			}
	    		});
	        }
		});
		//绑定销售组织选择框
		function bindXszz(){
			$.tableDialogPage({
				title:"销售组织选择",
				searchCond:[{"name":"销售组织编码","value":"code"},
				            {"name":"销售组织名称","value":"name"}],
				colModel:[{name:'code', index:'code', label:'销售组织编码', width:80},
						  {name:'name', index:'name', label:'销售组织名称', width:80}],
				url:"<c:url value='/pub/widget/findOrg'/>?type=2"
			},{
				callback:function(rows){
					if(rows){
						$("input[name=xszz]").val(rows.code);
						$("input[name=xszzmc]").val(rows.name);
						$("input[name=ywz]").val("");
						$("input[name=ywzmc]").val("");
						$("input[name=xsyid]").val("");
						$("input[name=xsymc]").val("");
						$("input[name=khbm]").val("");
						$("input[name=khmc]").val("");
					}else {
						$("input[name=xszz]").val("");
						$("input[name=xszzmc]").val("");
						$("input[name=ywz]").val("");
						$("input[name=ywzmc]").val("");
						$("input[name=xsyid]").val("");
						$("input[name=xsymc]").val("");
						$("input[name=khbm]").val("");
						$("input[name=khmc]").val("");
					}
				}
			});
		}
		
		//绑定业务组选择框
		function bindYwz(){
			$.tableDialogPage({
				title:"业务组选择",
				searchCond:[{"name":"业务组编码","value":"code"},
				            {"name":"业务组名称","value":"name"}],
				colModel:[{name:'code', index:'code', label:'业务组编码', width:80},
						  {name:'name', index:'name', label:'业务组名称', width:80},
						  {name:'baseParentOrgCode', index:'baseParentOrgCode', label:'销售组织编码', width:80},
						  {name:'parentName', index:'parentName', label:'销售组织名称', width:80}],
				url:"<c:url value='/pub/widget/findOrg'/>?type=4"
			},{
				callback:function(rows){
					if(rows){
						$("input[name=ywz]").val(rows.code);
						$("input[name=ywzmc]").val(rows.name);
						$("input[name=xszz]").val(rows.baseParentOrgCode);
						$("input[name=xszzmc]").val(rows.parentName);
						$("input[name=xsyid]").val("");
						$("input[name=xsymc]").val("");
						$("input[name=khbm]").val("");
						$("input[name=khmc]").val("");
					}else{
						$("input[name=ywz]").val("");
						$("input[name=ywzmc]").val("");
						$("input[name=xszz]").val("");
						$("input[name=xszzmc]").val("");
						$("input[name=xsyid]").val("");
						$("input[name=xsymc]").val("");
						$("input[name=khbm]").val("");
						$("input[name=khmc]").val("");
					}
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
						$("#form-search [name=xszz]").val(record.xszz);
						$("#form-search [name=xszzmc]").val(record.xszzmc);
						$("#form-search [name=ywz]").val(record.ywz);
						$("#form-search [name=ywzmc]").val(record.ywzmc);
						$("#form-search [name=khbm]").val("");
						$("#form-search [name=khmc]").val("");
					}else{
						$("#form-search [name=xsyid]").val("");
						$("#form-search [name=xsymc]").val("");
						$("#form-search [name=xszz]").val("");
						$("#form-search [name=xszzmc]").val("");
						$("#form-search [name=ywz]").val("");
						$("#form-search [name=ywzmc]").val("");
						$("#form-search [name=khbm]").val("");
						$("#form-search [name=khmc]").val("");
					}
				}
			});
		}
		
		//绑定客户选择框
		function bindKhbm(){
			$.tableDialogPage({
				title:"客户选择",
				searchCond:[{"name":"客户编码","value":"khbm"},
				            {"name":"客户名称","value":"khmc"}],
				colModel:[{name:'khbm', index:'khbm', label:'客户编码', width:80},
						  {name:'khmc', index:'khmc', label:'客户名称', width:80}],
						  url:"<c:url value='/pub/widget/findCustByXsy'/>?xsyid="+$('#form-search [name=xsyid]').val()
			},{
				callback:function(rows){
					if(rows){
						$("input[name=khbm]").val(rows.khbm);
						$("input[name=khmc]").val(rows.khmc);
					}else{
						$("input[name=khbm]").val("");
						$("input[name=khmc]").val("");
					}
				}
			});
		}

		//PID选择
/* 		function selectPidInit(){
			$.tableDialogPage({
				title:"PID选择",
				searchCond:[{"name":"PID","value":"pid"},
				            {"name":"机型","value":"jixing"}],
				colModel:[{name:'pid', index:'pid', label:'PID', width:80},
				          {name:'khmc', index:'khmc', label:'客户名称', width:80},
				          {name:'pp', index:'pp', label:'品牌名称', width:80},
				          {name:'jixing', index:'jixing', label:'型号', width:80},
				          {name:'jixin', index:'jixin', label:'机芯', width:80},
				          {name:'zdrmc', index:'zdrmc', label:'申请人', width:80}
				        ],
				url:"<c:url value='/pub/widget/findPid'/>"
			},{
				callback:function(rows){
					// 根据所选PID赋值相关信息
					if(rows){
						$("input[name=pid]").val(rows.pid);
					}else{
						$("input[name=pid]").val("");
					}
				}
			});
		} */
		//取周次
		function bindWeekselect(){
			$.post("<c:url value='/pub/select2/selectFcstWeek'/>",{},
				function(result){
					var data = $.map(result, function (obj) {
						obj.id = obj.zc;
				        obj.text = obj.rq ||obj.rq;    
				        return obj;
					});
						$("#form-search [name=kszc]").addClass("skyselect").select2({data:data});
						$("#form-search [name=jszc]").addClass("skyselect").select2({data:data});
					}, "json");
		}
	});
	    function sumGrid(title_length){
			var rowNum = $(grid_selector).getGridParam('records');
			if(rowNum>0){
				$(grid_selector).footerData("set",{"pid":"合计",align: "right",formatter:'number',
				    <c:forEach var="i" begin="1" end="100">
						    "w${i}Ycs":$(grid_selector).getCol("w${i}Ycs",false,"sum"),
						    "w${i}Dds":$(grid_selector).getCol("w${i}Dds",false,"sum"),
						    "w${i}Wxds":$(grid_selector).getCol("w${i}Wxds",false,"sum"),
				    </c:forEach>
				});
		    }
	    } 
</script>
</html>