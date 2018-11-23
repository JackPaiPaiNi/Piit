<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/index/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
	<%@include file="/WEB-INF/views/index/head.jsp" %>
<style type="text/css">
	html{
		position:static;
	}
</style>
</head>
<body>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
				
			<div class="widget-box">
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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<input type ="hidden" name ="yzhlx" value="${vo.yzhlx}">
							<div class="row">
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
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">订单号&nbsp;&nbsp;</label> <input
											type="text" name="ddid" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">币种&nbsp;&nbsp;</label> 
										<select role="select" name="bz" size="1" class="form-control skyselect">
											${fns:loadDictOption('BZ')}
										</select>
									</div>
								</div>
							</div>
						    <div class="space-4"></div>
							<div class="row">
							    <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">PID&nbsp;&nbsp;</label> <input
											type="text" name="pid" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售员&nbsp;&nbsp;</label> <input
											type="text" name="xsymc" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">我司型号&nbsp;&nbsp;</label> <input
											type="text" name="jixing" class="form-control" />
									</div>
								</div>
							     <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户型号&nbsp;&nbsp;</label> <input
											type="text" name="khxhms" class="form-control" />
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">销售组织&nbsp;&nbsp;</label> <input
											type="text" name="xszz" class="form-control" />
									</div>
								</div> 
							    <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">业务组&nbsp;&nbsp;</label> <input
											type="text" name="ywz" class="form-control" />
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单人&nbsp;&nbsp;</label> <input
											type="text" name="zdrmc" class="form-control" />
									</div>
								</div>
							   <div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">制单时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZdsj" name="beginZdsj"/>
										<input type="hidden" id="endZdsj" name="endZdsj"/>
										<input type="text" name="zdsj" class="form-control timeInterval "/>
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
										<label class="input-group-addon">交货时间&nbsp;&nbsp;</label>
										<input type="hidden" id="beginJhsj" name="beginJhsj"/>
										<input type="hidden" id="endJhsj" name="endJhsj"/>
										<input type="text" name="jhsj" id="jhsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">生产基地&nbsp;&nbsp;</label> <input
											type="text" name="scjdmc" class="form-control" />
									</div>
								</div>
								
							</div>
						</form>
						<div class="space-4"></div>
					</div>
				</div>
			</div>
			<h5 class="header blue" style="margin-top:4px;">订单信息</h5>
			<div class="space-4"></div>
			<div id="grid-parent">
				<table id="grid-table"></table>
				<div id="grid-pager"></div>
			</div>
			<div class="space-4"></div>
			<h5 class="header blue" style="margin-top:4px;">已选订单信息</h5>
			<div class="space-4"></div>
			<div id="grid-parent-qrxx">
				<table id="grid-table-qrxx"></table>
				<div id="grid-pager-qrxx"></div>
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div><!-- /.col -->
	</div><!-- /.row -->
	
</div>
<!-- /.page-content -->
</body>
<script type="text/javascript">
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	var grid_selector_qrxx = "#grid-table-qrxx";
	var pager_selector_qrxx = "#grid-pager-qrxx";
	var isEdit = false;
	<shiro:hasPermission name="pso:tvPso:view">isEdit = false;</shiro:hasPermission>
	/******************************页面控件加载开始***************************************************/
	$(function($) {
		$('.skyselect').select2();
		$("#form-search [name=zdsj]").bindDateRange({startElement:$("#beginZdsj"),endElement:$("#endZdsj")});
		$("#form-search [name=jhsj]").bindDateRange({startElement:$("#beginJhsj"),endElement:$("#endJhsj")});
		$(".timeInterval").bindDateRange();
  		$(grid_selector).bindTable({
			caption: "",
			url : "<c:url value='/pso/tvPso/queryDdxx'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect: true,
			shrinkToFit : false,
			autoScroll : false,
			colModel: [
				{name : 'id', label : 'ID', hidden : true, width : 60 },
				{name:'scjd', index:'scjd', label:'生产基地', width:80, hidden:true},
				{name:'scjdmc', index:'scjdmc', label:'生产基地', width:80},
			    {name : 'xszz', hidden : true}, 
			    {name : 'xszzmc', label : '销售组织', width : 100}, 
			    {name : 'ywz', hidden : true}, 
			    {name : 'ywzmc', label : '业务组', width : 100}, 
			    {name : 'xsyid', hidden : true}, 
				{name : 'xsymc', label: '销售员', width : 100},
				{name : 'ddlx', hidden : true}, 
				{name : 'ddid', label: '订单号', width : 100}, 
				{name : 'ddlxmc', label:'订单类型', width : 80}, 
				{name : 'khbm', label: '客户编码', width : 120}, 
				{name : 'khmc', label: '客户名称', width : 120},
				{name : 'pid', label: 'PID', width : 60}, 
				{name : 'jixing', label: '我司型号', width : 60}, 
				{name : 'jixin', label: '机芯', width : 60},
				{name : 'khxhms', label: '客户型号描述', width : 60}, 
				{name : 'bz', label : '币种', width : 60}, 
				{name : 'dj', label : '单价', width : 60, align:'right'},
				{name : 'sl', label : '数量', width : 60, align:'right'}, 
				{name : 'slbz', label : '数量说明', width : 90},
				{name : 'je', label : '订单金额', width : 60, align:'right'},
				{name : 'zdrid', hidden : true}, 
				{name : 'zdrmc', label : '制单人', width : 100, editable : false}, 
				{name : 'zdsj', index : 'zdsj', label : '制单时间', width : 80}, 
				{name : 'ddyqjhrq', index : 'ddyqjhrq', label : '交货日期', width : 80},
				{name : 'yzhje', label : '已走货金额', width : 80, align:'right'},
				{name : 'cc', hidden : true},
				{name : 'zhfs', hidden : true},
				{name : 'zhfsmc', hidden : true},
				{name : 'chfl', hidden : true},
				{name : 'pp', hidden : true},
				{name : 'pplx', hidden : true},
				{name : 'fktj', hidden : true},
				{name : 'fktjmc', hidden : true},
				{name : 'ggmx' , hidden : true },
				{name : 'ggmxmc' , hidden : true },
				{name : 'cpfl' , hidden : true },
				{name : 'cpflmc' , hidden : true },
				{name : 'ppp', hidden : true},
				{name : 'pxh', hidden : true},
				{name : 'pbh' , hidden : true },
				{name : 'gsbm' , hidden : true },
				{name : 'gsmc' , hidden : true },
				{name : 'xwgj' , hidden : true },
				{name : 'gjmytk', hidden : true},
				{name : 'piid', hidden : true},
				{name : 'pilx', hidden : true},
				{name : 'pilxmc', hidden : true},
				{name : 'cplx', hidden : true},
				{name : 'cplxmc', hidden : true},
				{name : 'ffbsje', hidden : true},
				{name : 'zhm', hidden : true},
				{name : 'zhmmc', hidden : true},
				{name : 'version', hidden : true},
				{name : 'ffbsje', hidden : true},
				{name : 'dsjlx', hidden : true},
				{name : 'dsjlxmc', hidden : true},
				{name : 'ce', label : '差额', width : 80},
				{name : 'model', label: '我司型号（多元化）', width : 60, hidden : true}, 
				{name : 'khxh', label: '客户型号（多元化）', width : 60, hidden : true},
				{name : 'sfBd', hidden : true}
			],
			beforeSelectRow: function (rowid, e) {
 			    var $myGrid = $(this),  
			        i = $.jgrid.getCellIndex($(e.target).closest('td')[0]),  
			        cm = $myGrid.jqGrid('getGridParam', 'colModel');  
			    return (cm[i].name === 'cb');
			},
 			ondblClickRow: function(id){
 				return ;
		    },
		    onCellSelect: function(rowid,status){
		    	
		    },
		    onSelectAll:function(rowids,status){
		    	if(status){
	 				$.each(rowids,function(index,id){
	 					var rowData =  $(grid_selector).jqGrid('getRowData',id);
	 					checkIsRepeat(rowData);
	 				});
		    	}
		    },
		    onSelectRow: function(rowid,status) {
	    	    if(status==false){
	    	    	$(grid_selector_qrxx).jqGrid('delRowData',rowid);
	    	    }else{
					var selr = $(grid_selector).jqGrid('getGridParam','selrow');
					var rowData = $(grid_selector).jqGrid('getRowData',selr);
					checkIsRepeat(rowData);
				}
    	    }
		},{
			add:isEdit,
			edit:isEdit,
			del:isEdit,
			view:isEdit,
		});  
		$(grid_selector_qrxx).bindTable({
			caption: "",
			pager: pager_selector_qrxx,
			gridParent: "#grid-parent-qrxx",
			multiselect: true,
			shrinkToFit : false,
			autoScroll : false,
			pgbuttons: false,
			pginput: false,
			rowList: [],
			recordtext: "",
			colModel: [
				{name : 'id', label : 'ID', hidden : true, width : 60 },
				{name:'scjd', index:'scjd', label:'生产基地', width:80, hidden:true},
				{name:'scjdmc', index:'scjdmc', label:'生产基地', width:80},
			    {name : 'xszz', hidden : true}, 
			    {name : 'xszzmc', label : '销售组织', width : 100}, 
			    {name : 'ywz', hidden : true}, 
			    {name : 'ywzmc', label : '业务组', width : 100}, 
			    {name : 'xsyid', hidden : true}, 
				{name : 'xsymc', label: '销售员', width : 100},
				{name : 'ddlx', hidden : true}, 
				{name : 'ddid', label: '订单号', width : 100}, 
				{name : 'ddlxmc', label:'订单类型', width : 80}, 
				{name : 'khbm', label: '客户编码', width : 120}, 
				{name : 'khmc', label: '客户名称', width : 120},
				{name : 'pid', label: 'PID', width : 60}, 
				{name : 'jixing', label: '我司型号', width : 60}, 
				{name : 'jixin', label: '机芯', width : 60},
				{name : 'model', label: '我司型号（多元化）', width : 60}, 
				{name : 'khxh', label: '客户型号（多元化）', width : 60},
				{name : 'khxhms', label: '客户型号', width : 60}, 
				{name : 'bz', label : '币种', width : 60}, 
				{name : 'dj', label : '单价', width : 60, align:'right'},
				{name : 'sl', label : '数量', width : 60, align:'right'}, 
				{name : 'je', label : '订单金额', width : 60, align:'right'},
				{name : 'zdrid', hidden : true}, 
				{name : 'zdrmc', label : '制单人', width : 100, editable : false}, 
				{name : 'zdsj', index : 'zdsj', label : '制单时间', width : 80}, 
				{name : 'ddyqjhrq', index : 'ddyqjhrq', label : '交货日期', width : 80},
				{name : 'yzhje', label : '已走货金额', width : 80, align:'right'},
				{name : 'cc', hidden : true},
				{name : 'zhfs', hidden : true},
				{name : 'zhfsmc', hidden : true},
				{name : 'chfl', hidden : true},
				{name : 'pp', hidden : true},
				{name : 'pplx', hidden : true},
				{name : 'fktj', hidden : true},
				{name : 'fktjmc', hidden : true},
				{name : 'ggmx' , hidden : true },
				{name : 'ggmxmc' , hidden : true },
				{name : 'cpfl' , hidden : true },
				{name : 'cpflmc' , hidden : true },
				{name : 'ppp', hidden : true},
				{name : 'pxh', hidden : true},
				{name : 'pbh' , hidden : true },
				{name : 'gsbm' , hidden : true },
				{name : 'gsmc' , hidden : true },
				{name : 'xwgj' , hidden : true },
				{name : 'gjmytk', hidden : true},
				{name : 'piid', hidden : true},
				{name : 'pilx', hidden : true},
				{name : 'pilxmc', hidden : true},
				{name : 'cplx', hidden : true},
				{name : 'cplxmc', hidden : true},
				{name : 'ffbsje', hidden : true},
				{name : 'zhm', hidden : true},
				{name : 'zhmmc', hidden : true},
				{name : 'version', hidden : true},
				{name : 'dsjlx', hidden : true},
				{name : 'dsjlxmc', hidden : true},
				{name : 'ce',  label : '差额', width : 80},
				{name : 'model', label: '我司型号（多元化）', width : 60, hidden : true}, 
				{name : 'khxh', label: '客户型号（多元化）', width : 60, hidden : true},
				{name : 'sfBd', hidden : true},
				{name : 'gtin', label : 'GTIN码', width : 80,hidden : true},
				{name : 'cas', label : 'CAS码', width : 80,hidden : true },
		]
		},{
			add:isEdit,
			view:isEdit,
			edit:isEdit,
			refresh:isEdit,
			delfunc:delfunc
		});
		$(grid_selector_qrxx).navButtonAdd(pager_selector_qrxx,{
			caption:"确认", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				save();
			},
			position:"last"
		});
		
		//价差新添加数据是否重复
		function checkIsRepeat(rowData){
			var msg = "";
			var rows = $(grid_selector_qrxx).jqGrid("getRowData");
			var isRepeat = false;
			var isHFData = false;
			$.each(rows, function(i, m){
	
			     if(m.id == rowData.id){
					 isRepeat = true;
					 msg += "订单号："+rowData.ddid+"的数据已经存在，请勿重重复添加!";
					 return false;
				 } 
				 if(!(m.khbm == rowData.khbm && m.gsbm == rowData.gsbm && m.xsyid == rowData.xsyid && m.scjd == rowData.scjd)){
					 isHFData = true;
					 msg += "请选择同一公司、销售员、客户、生产基地的订单!";
					 return false;
				 }
			});
			if(isRepeat || isHFData){
				swal("",msg,"warning");
				return;
			}else{// 添加主体
				rowData.gtin = "无";
				rowData.cas = "无";
				$(grid_selector_qrxx).jqGrid("addRowData", rowData.id, rowData);
			};
	    }
		
		// 删除
		function delfunc(){
			var selectedRowIds =$(grid_selector_qrxx).jqGrid("getGridParam","selarrrow"); 
			if(selectedRowIds==null||selectedRowIds==""){
				swal("", "请选择需要删除的数据！", "warning");
				return;
			}else{ 
				var len = selectedRowIds.length;  
				for(var i = 0;i < len ;i ++) {  
				$(grid_selector_qrxx).jqGrid("delRowData", selectedRowIds[0]);  
				} 
			}
		}
		// 查询
		$("#btn-search").click(function() {
			$(grid_selector).trigger("reloadGrid");
		});
		// 订单确认
		function save(){
			var data = $(grid_selector_qrxx).jqGrid('getRowData');
			if(data.length ==0){
				swal("", "请选择数据！", "warning");
				return;
			}
		    // 关闭当前窗口
			window.close();
			// 确定后的回调处理
			if(window.showModalDialog){//支持showModalDialog函数
				window.returnValue = data;
			}else{//新版chrome不支持showModalDialog函数
				if(window.openerCallBack && typeof(window.openerCallBack) === "function"){
					// 调用父窗口的方法
					window.openerCallBack(data);
				}
			}
		}
	});
</script>
</html>