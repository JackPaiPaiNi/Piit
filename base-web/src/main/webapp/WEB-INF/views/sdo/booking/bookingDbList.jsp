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
					</div>
				</div>
				<div class="widget-body">
					<div class="widget-main">
						<form id="form-search" class="form-search">
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
										<input type="hidden" name="cxlx" value="1"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">船务专员&nbsp;&nbsp;</label>
										<input type="text" name="cwzyid" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khbm" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜时间&nbsp;&nbsp;</label>
										<input type="text" name="zdsj" class="form-control timeInterval"/>
										<input type="hidden" id="beginZgsj" name="beginZgsj"/>
										<input type="hidden" id="endZgsj" name="endZgsj"/>
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
			<h5 class="header blue" style="margin-top:4px;">主体预走货信息</h5>
			<div class="space-4"></div>
			<table id="grid-table"></table>
			<div id="grid-pager"></div>
			<div class="space-4"></div>
				<h5 class="header blue" style="margin-top:4px;">发起订舱信息</h5>
				<div class="space-4"></div>
			<div id="grid-parent-ktyzhxx">
				<table id="grid-table-ktyzhxx"></table>
				<div id="grid-pager-ktyzhxx"></div>
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
	
	var grid_selector_ktyzhxx = "#grid-table-ktyzhxx";
	var pager_selector_ktyzhxx = "#grid-pager-ktyzhxx";
	
	var isEdit = false;
	// 权限判断
 	<shiro:hasPermission name="booking:bookingDb:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZgsj"),endElement:$("#endZgsj")});
		
 		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/booking/bookingDb/search'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect: true,
			//shrinkToFit: false,
			//autoScroll: false,
			rowNum:5,
			//autoheight:true,
			//extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [      
				{name:'id', label:'ID', hidden: true, width:60, frozen:true},
				{name:'scjdmc', index:'scjdmc', label:'生产基地', width:80},
				{name:'sfZtyzh', index:'sfZtyzh',label:'预走货主客类型', width:100, hidden: true, edittype:"select", 
					formatter:"select", editoptions:{value:"0:客体;1:主体"}, frozen:true},
				//{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100,formatter:yzhxx, frozen:true},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100, frozen:true},
				{name:'yzhlx', index:'yzhlx',label:'预走货类型', width:80, edittype:"select", 
					formatter:"select", editoptions:{value:"${fns:loadDictEditOption('YZHLX')}"}, frozen:true}, 
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:120},
				{name:'zgsj', index:'zgsj', label:'装柜时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'cwzymc', index:'cwzymc', label:'船务专员', width:100},
				{name:'xszzmc', index:'xszzmc', label:'业务部门', width:80},
				{name:'zdrmc', index:'zdrmc', label:'预走货发起人', width:80},
				{name:'cdgslxr', index:'cdgslxr', label:'货贷联系人', width:80},
				{name:'xwgjmc', index:'xwgjmc', label:'目的国家', width:80},
				{name:'qyg', index:'qyg', label:'起运港', width:80},
				{name:'mdg', index:'mdg', label:'目的港口', width:80},
				{name:'mytk', index:'mytk', label:'贸易条款', width:80, edittype:"select", 
					formatter:"select", editoptions:{value:"${fns:loadDictEditOption('PIGJMYTK')}"}},
				{name:'cylx', index:'cylx', label:'出运类型', width:80, edittype:"select", 
					formatter:"select", editoptions:{value:"${fns:loadDictEditOption('CYLX')}"}}
			],
			beforeSelectRow: function (rowid, e) {
 			    var $myGrid = $(this),  
			        i = $.jgrid.getCellIndex($(e.target).closest('td')[0]),  
			        cm = $myGrid.jqGrid('getGridParam', 'colModel');  
			    return (cm[i].name === 'cb');
			},
 			ondblClickRow: function(id){
				return;
		    },
		    onCellSelect: function(rowid,iCol){
		    	return ;
		    },
		    onSelectRow: function(rowid, status) {
		    	var dcData = $(grid_selector_ktyzhxx).jqGrid("getRowData");
	    	    if(!status){
	    	    	$(grid_selector_ktyzhxx).jqGrid('delRowData', rowid);
	    	    	var ztData = $(grid_selector).jqGrid('getRowData', rowid);
	    	    	$.each(dcData, function(i, data){
	    	    		if(ztData.yzhdh == data.ztyzhdh){
	    	    			$(grid_selector_ktyzhxx).jqGrid('delRowData', data.id);
	    	    		}
	    	    	});
	    	    }else{
					var ztData = $(grid_selector).jqGrid('getRowData', rowid);
					//是否可以添加标志位
					var flag = true;
					var msg = "";
					$.each(dcData, function(index, m){
						 if(m.yzhdh == ztData.yzhdh){
							 msg="预走货单号"+ztData.yzhdh+"已经选择，请勿重复选择" ;
							 flag = false;
							 return false ;
						 }
						 if(m.gsbm != ztData.gsbm){
							 msg="预走货单号"+ztData.yzhdh+"的公司信息和已经选择的不一致不能合并订舱" ;
							 flag = false;
							 return false ;
						 }
						 if(m.khbm != ztData.khbm){
							 msg="预走货单号"+ztData.yzhdh+"的客户信息和已经选择的不一致不能合并订舱" ;
							 flag = false;
							 return false ;
						 }
						 if(m.cylx != ztData.cylx){
							 msg="预走货单号"+ztData.yzhdh+"的出运类型和已经选择的不一致不能合并订舱" ;
							 flag = false;
							 return false ;
						 }
						 if(m.mytk != ztData.mytk){
							 msg="预走货单号"+ztData.yzhdh+"的贸易条款和已经选择的不一致不能合并订舱" ;
							 flag = false;
							 return false ;
						 }
						 /*if(m.qyg != ztData.qyg){
							 msg="预走货单号"+ztData.yzhdh+"的起运港和已经选择的不一致不能合并订舱" ;
							 flag = false;
							 return false ;
						 }*/
/* 						 if(m.mdg != ztData.mdg){
							 msg="预走货单号"+ztData.yzhdh+"的目的港和已经选择的不一致不能合并订舱" ;
							 flag = false;
							 return false ;
						 } */
						 if(m.xwgj != ztData.xwgj){
							 msg="预走货单号"+ztData.yzhdh+"的目的国家和已经选择的不一致不能合并订舱" ;
							 flag = false;
							 return false ;
						 }
					});
					if(!flag){
						swal("",msg,"warning");
						return;
					}else{
						$.bindAjax({
							url:"<c:url value='/booking/bookingDb/findKtyzh'/>",
							data:{yzhdh : ztData.yzhdh},
							action:"search",
						},function(response){
							// 添加主体
							dcData.push(ztData);
							if(response){
								// 添加客体
								dcData = dcData.concat(response);
							}
							$(grid_selector_ktyzhxx)[0].addJSONData({items:dcData});
						});
					}
	    	    }
		     }
		},{
			add:false,
			edit:false,
			del:false,
			view:false,
		}).jqGrid('setFrozenColumns'); 
 		
		$(grid_selector_ktyzhxx).bindTable({
			caption: "",
			pager: pager_selector_ktyzhxx,
			gridParent: "#grid-parent",
			multiselect: true,
			shrinkToFit: false,
			autoScroll: false,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, frozen:true},
				{name:'scjdmc', index:'scjdmc', label:'生产基地', width:80},
				{name:'sfZtyzh', index:'sfZtyzh',label:'预走货主客类型', width:100, edittype:"select", 
					formatter:"select", editoptions:{value:"0:客体;1:主体"}, frozen:true},
				{name:'ztyzhdh', index:'ztyzhdh', label:'主体预走货单号', width:100, hidden: true, frozen:true},
				{name:'yzhdh', index:'yzhdh', label:'预走货单号', width:100, frozen:true},
				{name:'yzhlx', index:'yzhlx',label:'预走货类型', width:80, edittype:"select", 
					formatter:"select", editoptions:{value:"${fns:loadDictEditOption('YZHLX')}"}, frozen:true}, 
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:120},
				{name:'zgsj', index:'zgsj', label:'装柜时间', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'cwzymc', index:'cwzymc', label:'船务专员', width:100},
				{name:'xszzmc', index:'xszzmc', label:'业务部门', width:80},
				{name:'zdrmc', index:'zdrmc', label:'预走货发起人', width:80},
				{name:'cdgslxr', index:'cdgslxr', label:'货贷联系人', width:80},
				{name:'xwgjmc', index:'xwgjmc', label:'目的国家', width:80},
				{name:'qyg', index:'qyg', label:'起运港', width:80},
				{name:'mdg', index:'mdg', label:'目的港口', width:80},
				{name:'mytk', index:'mytk', label:'贸易条款', width:80, edittype:"select", 
					formatter:"select", editoptions:{value:"${fns:loadDictEditOption('PIGJMYTK')}"}},
				{name:'cylx', index:'cylx', label:'出运类型', width:80, edittype:"select", 
					formatter:"select", editoptions:{value:"${fns:loadDictEditOption('CYLX')}"}}
			],
			beforeSelectRow: function (rowid, e) {
 			    var $myGrid = $(this),  
			        i = $.jgrid.getCellIndex($(e.target).closest('td')[0]),  
			        cm = $myGrid.jqGrid('getGridParam', 'colModel');  
			    return (cm[i].name === 'cb');
			},
 			ondblClickRow: function(id){
				return;
		    },
		    onCellSelect: function(rowid,iCol){
		    	return ;
		    },
		    onSelectRow: function(rowid, status) {
		    	var dcData = $(grid_selector_ktyzhxx).jqGrid("getRowData");
		    	var rowData = $(grid_selector_ktyzhxx).jqGrid('getRowData', rowid);;
	    	    if(status && rowData.sfZtyzh == 1){
	    	    	$.each(dcData, function(i, data){
	    	    		if(rowData.yzhdh == data.ztyzhdh){
	    	    			$(grid_selector_ktyzhxx).setSelection(data.id)
	    	    		}
	    	    	});
	    	    }
		    }
		},{
			add:false,
			edit:false,
			view:false,
			refresh:false,
			del:true,
			delfunc:delfunc
		}).jqGrid('setFrozenColumns'); 
		
		$(grid_selector_ktyzhxx).navButtonAdd(pager_selector_ktyzhxx,{
			caption:"发起订舱", 
			buttonicon:"icon-edit", 
			onClickButton: function(){
				fqdc();
			}, position:"last" 
		});
		
		//$(grid_selector).jqGrid('hideCol','cb');
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
			$(grid_selector_ktyzhxx).jqGrid("clearGridData");
	    });
		//回车键响应
		 $("body").keypress(function (e) {
				var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
				if (keyCode == 13){
					$(grid_selector).trigger("reloadGrid");
				}
		}); 
		
	});
	
	//预走货弹窗
	function yzhxx(cellvalue, options, rowData){
	    var href = "<a onclick='javascript:show(\""+rowData.yzhlx+"\""+"\,"+"\""+rowData.id+"\""+");'>"+rowData.yzhdh+"</a>";
		return  href ;
	}
	

    function show(yzhlx, id){
    	var url = "" ;
    	//大货
		if(yzhlx == 1){
			 url = "<c:url value='/pso/tvPso/viewPage'/>" + "?id=" + id;
		} 
		//多元化和多元化屏
		if(yzhlx == 2 || yzhlx==3){
		    url ="<c:url value='/pso/diversityPso/viewPage'/>" + "?id=" + id;
		}
		//样机
		if(yzhlx == 4){
			url ="<c:url value='/pso/samplePso/viewPage'/>" + "?id=" + id;
		}
		//备损
		if(yzhlx == 5){
			 url ="<c:url value='/pso/spoPso/viewPage'/>" + "?id=" + id;
		}
		if(url.length > 0){
			 window.open(url); 
		}
    }
	
	//发起订舱
	function fqdc(){
		var ids = $(grid_selector_ktyzhxx).getDataIDs();
		if(ids.length > 0){
			ids = ids.join(",");
			location.href = "<c:url value='/booking/bookingDb/editPage'/>"+ "?ids=" + ids;
		}else{
			swal("","发起订舱，预走货信息不能为空！","warning");
		}
	}
	
	// 删除
	function delfunc(){
		//debugger;
		//selectRowIds是一个指向选中行数组的一个引用，在用 jqgrid删除数据时会动态的变化;
		//所以在循环中i的循环条件会在每一次循环后都在动态变化，故会出问题.
		var selectedRowIds = $(grid_selector_ktyzhxx).jqGrid("getGridParam","selarrrow");
		var length = selectedRowIds.length;
		if(length > 0){
			for(var i=0; i<length; i++) {
				$(grid_selector_ktyzhxx).jqGrid("delRowData", selectedRowIds[0]);
			}
		}else{
			swal("","请选择一行数据！","warning");
		}
	}
</script>
</html>