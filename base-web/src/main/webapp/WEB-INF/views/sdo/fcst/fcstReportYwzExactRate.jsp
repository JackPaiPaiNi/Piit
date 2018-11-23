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
							汇总导出
						</button>
<!-- 						&nbsp;
						<button id="btn-export-mx" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							明细导出
						</button> -->			
					</div>
				</div>
				<div class="widget-body">
				<div class="widget-main">
					<form id="form-search" name="form-search" class="form-search">
                         <div class="row">
                         		<input type="hidden" name="level" value="4"/>
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
										<label class="input-group-addon">年月&nbsp;&nbsp;</label>
										<input type="text" name="ny"  value="${yyyymm}" class="form-control  date-picker"/>
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
			<div class="space-4"></div>
			<div id="grid-table-div">
			    <table id="grid-table"></table>
			</div>
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
	$(".date-picker").bindYearMonth();
	// 销售组织选择框
	$("#xszzmc").parent().click(function(){
		bindXszz();
	});
	// 业务组选择框
	$("#ywzmc").parent().click(function(){
		bindYwz();
	});
	/**************************************************编辑表初始化开始区域************************************************/
	$(grid_selector).bindTable({
		url:"<c:url value='/fcst/fcstReport/searchExactRate'/>",
		pager: pager_selector,
		gridParent: "#grid-parent",
		formSearch: "#form-search",
		autoheight:true,
		extraheight:$('#search-box').height()+28,
		editTable:false,
		rowNum : 100,
		shrinkToFit: false,
		autoScroll: false,
		colModel: [  
			{name:'id', label:'ID', hidden: true, width:60, editable:false},
			{name:'xszzmc', index:'xszzmc', label:'业务部', width:80},
			{name:'ywzmc', index:'ywzmc', label:'业务组', width:80},
			{name:'xsymc', index:'xsymc', label:'业务员', width:80},
			{name:'khmc', index:'khmc', label:'客户', width:80},
			{name:'pid', index:'pid', label:'PID', width:80},
		    {name:'ycs', index:'ycs', label:'FCST需求', align: "right", width:70,
		    	editable:false},
		    {name:'dds', index:'dds', label:'订单数', align: "right", width:70, 
		    	editable:false},
			{name:'pcz', index:'pcz', label:'偏差值', align: "right", width:70,
		    	editable:false},
			{name:'zql', index:'zql', label:'准确率', align: "right", width:70,
		    	formatter:formatZql,editable:false},
			<c:forEach items="${monthtitles}" var="t" varStatus="stat">
			    {name:'${t.week}Ycs', index:'${t.week}Ycs', label:'FCST需求', align: "right", width:70,
			    	editable:false},
			    {name:'${t.week}Dds', index:'${t.week}Dds', label:'订单数', align: "right", width:70, 
			    	editable:false},
				{name:'${t.week}Pcz', index:'${t.week}Pcz', label:'偏差值', align: "right", width:70,
			    	editable:false},
				{name:'${t.week}Zql', index:'${t.week}Zql', label:'准确率', align: "right", width:70,
			    	formatter:formatZql,editable:false}
			    <c:if test="${!stat.last}" >,</c:if>
		    </c:forEach>

		]
	},{
		add:false,
		edit:false,
		del:false,
		view:false
	});

	$(grid_selector).setCustomGroupHeaders({
		useColSpanStyle: true,
		groupHeaders:[
		      		<c:forEach items="${monthtitles}" var="t" varStatus="stat">
		      	        {startColumnName:'${t.week}Ycs', numberOfColumns:'${t.colspan}', titleText: '${t.colname}'}<c:if test="${!stat.last}" >,</c:if>
		      	    </c:forEach>
		] 
	 }); 
	//hideCol("${hide}");
	/**************************************************编辑表初始化开始区域************************************************/	
	
	/**************************************************function开始区域************************************************/	

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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstReport/exportExactRate'/>"});
	    			}
	    		});
	        }
		});
	$("#btn-export-mx").click(function(){
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
    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstReport/exportExactRateDetail'/>"});
    			}
    		});
        }
	});
	//查询
	$("#btn-search").click(function(){
		var xszz = $("#form-search [name=xszz]").val();
		var ywz = $("#form-search [name=ywz]").val();
		if(ywz.length != 0){
			$("#form-search [name=level]").val("5");
		}else{
			$("#form-search [name=level]").val("4");
		}
		$.bindAjax({
			url : "<c:url value='/fcst/fcstReport/findExactRateTitles'/>",
			data : {yyyymm :$("#form-search input[name=ny]").val()},
			action : "search"
		},function(response) {		
			var titles=response.titles;
			var colname=response.colname;
			var groupheaders=[{startColumnName:'ycs', numberOfColumns:4, titleText: colname}];
			for(var i=0;i<titles.length;i++){
				var titleRow=titles[i];
				var row={};
				row.startColumnName=titleRow.week+"Ycs";
				row.numberOfColumns=titleRow.colspan;
				row.titleText=titleRow.colname;
				groupheaders.push(row);
			}
			$(grid_selector).destroyCustomGroupHeader();
			$(grid_selector).setCustomGroupHeaders({
				 useColSpanStyle: true,
			     groupHeaders:groupheaders
			 });
			hideCol(response.hide);
			$(grid_selector).trigger("reloadGrid");

		}); 
    });
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
				}else {
					$("input[name=xszz]").val("");
					$("input[name=xszzmc]").val("");
					$("input[name=ywz]").val("");
					$("input[name=ywzmc]").val("");
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
				}else{
					$("input[name=ywz]").val("");
					$("input[name=ywzmc]").val("");
					$("input[name=xszz]").val("");
					$("input[name=xszzmc]").val("");
				}
			}
		});
	}
	//计算列合计
    function sumGrid(){
		var rowNum = $(grid_selector).getGridParam('records');
		if(rowNum>0){
			$(grid_selector).footerData("set",{"pid":"合计", align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},
			    "ycs":$(grid_selector).getCol("ycs",false,"sum"),
			    "dds":$(grid_selector).getCol("dds",false,"sum"),
			    "pcz":$(grid_selector).getCol("pcz",false,"sum"),
		        <c:forEach items="${monthtitles}" var="t" varStatus="stat">
				    "${t.week}Ycs":$(grid_selector).getCol("${t.week}Ycs",false,"sum"),
				    "${t.week}Dds":$(grid_selector).getCol("${t.week}Dds",false,"sum"),
				    "${t.week}Pcz":$(grid_selector).getCol("${t.week}Pcz",false,"sum")<c:if test="${!stat.last}" >,</c:if>
		        </c:forEach>
			});
	    }else{
			$(grid_selector).footerData("set",{"pid":"合计",align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},
			    "ycs":null,
			    "dds":null,
			    "pcz":null,
		        <c:forEach items="${monthtitles}" var="t" varStatus="stat">
				    "${t.week}Ycs":null,
				    "${t.week}Dds":null,
				    "${t.week}Pcz":null<c:if test="${!stat.last}" >,</c:if>
		        </c:forEach>
			});
	    }
    } 
	
	function hideCol(ishide){
		if(ishide=="1"){	
			$(grid_selector).hideCol("w5Ycs");
			$(grid_selector).hideCol("w5Dds");
			$(grid_selector).hideCol("w5Pcz");
			$(grid_selector).hideCol("w5Zql");
		}else{
			$(grid_selector).showCol("w5Ycs");
			$(grid_selector).showCol("w5Dds");
			$(grid_selector).showCol("w5Pcz");
			$(grid_selector).showCol("w5Zql");
		}
	}
	
	function formatZql(cellvalue){
		if(cellvalue){
			return cellvalue+"%";
		}else{
			return 0;
		}
	}

	/**************************************************function結束区域************************************************/	
</script>
</html>