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
						<button id="btn-export" type="button" class="btn btn-success btn-minier bigger">
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
										<label class="input-group-addon">订舱单号&nbsp;&nbsp;</label>
										<input type="text" name="dcdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货单号&nbsp;&nbsp;</label>
										<input type="text" name="yzhdh" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货类型&nbsp;&nbsp;</label>
										<select role="select" name="yzhlx" size="1" class="form-control skyselect">
											${fns:loadDictOption('YZHLX')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">预走货发起人&nbsp;&nbsp;</label>
										<input type="text" name="yzhfqrmc" class="form-control"/>
									</div>
								</div>
							</div>
							<div class="space-4"></div>
							<div class="row">
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">装柜日期&nbsp;&nbsp;</label>
										<input type="hidden" id="beginZgsj" name="beginZgsj"/>
										<input type="hidden" id="endZgsj" name="endZgsj"/>
										<input type="text" name="zgsj" class="form-control timeInterval"/>
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">客户&nbsp;&nbsp;</label>
										<input type="text" name="khmc" class="form-control"/>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">生产基地&nbsp;&nbsp;</label>
										<select role="select" name="scjd" size="1" class="form-control skyselect">
											${fns:loadDictOption('SCJD')}
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
	var editurl = "<c:url value='/deliver/deliver/editPage'/>";
	var isEdit = false;
	<shiro:hasPermission name="deliver:deliver:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$(".skyselect").select2();
		$(".timeInterval").bindDateRange({startElement:$("#beginZgsj"),endElement:$("#endZgsj")});
		
		$(grid_selector).bindTable({
			caption: "",
			url: "<c:url value='/deliver/deliver/dbSearch'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			//shrinkToFit: false,
			//autoScroll: false,
			multiselect: true,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'yzhdh', index:'yzhdh', width:80,hidden:true},
				{name:'scjd', index:'scjd',label:'生产基地', width:80, hidden:true},
				{name:'scjdmc', index:'scjdmc',label:'生产基地', width:60},
				{name:'syzhdh', index:'syzhdh',label:'预走货单号', width:100,formatter:yzhxx},
				{name:'dcdh', index:'dcdh',label:'订舱单号', width:120},
				{name:'yzhlx', index:'yzhlx', hidden:true, width:80},
				{name:'yzhlxmc', index:'yzhlxmc', label:'预走货类型', width:50},
				{name:'xsbm', index:'xsbm', hidden:true},
				{name:'xsbmmc', index:'xsbmmc', label:'业务部门名称', width:80},
				{name:'xsymc', index:'xsymc', label:'销售员', width:70},
				{name:'qydm', hidden:true},
				{name:'qymc', index:'qymc', label:'业务组名称', width:80},
				{name:'khbm', index:'khbm', label:'客户编码', width:80},
				{name:'khmc', index:'khmc', label:'客户名称', width:80},
				{name:'zgsj', index:'zgsj', label:'装柜日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'yzhsj', index:'yzhsj', label:'预走货日期', width:80, formatter:'date', formatoptions:{newformat:'Y-m-d'}},
				{name:'yzhfqrmc', index:'yzhfqrmc', label:'预走货发起人', width:80},
				{name:'gsbm', index:'gsbm', label:'公司', width:80},
				{name:'cylx', index:'cylx', label:'出运类型', width:80,hidden: true},
				{name:'qyg', index:'qyg', label:'起运港', width:80,hidden: true},
				{name:'mdg', index:'mdg', label:'目的港', width:80,hidden: true},
				{name:'mytk', index:'mytk', label:'贸易条款', width:80,hidden: true},
				{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:80,hidden: true}
			],
		},{
			add:isEdit,
			edit:false,
			view:false,
			del:false,
			addfunc:addfunc
		});
		
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		$("body").keypress(function (e) {
			var keyCode = e.keyCode ? e.keyCode : e.which ? e.which : e.charCode;
			if (keyCode == 13){
				$(grid_selector).trigger("reloadGrid");
			}
		}); 
		$("#btn-export").click(function(){
		    var curNum=$(grid_selector).getGridParam("records");
		    if(curNum==0){
	            swal("结果集为空不能导出","","warning");
	            return false;
	        }else{
	        	$("#btn-export").bindSweetAlert({
	    			title:"确定要导出吗?",
	    			closeOnConfirm: true
	    		},{
	    			callback:function(){
	    				$(grid_selector).exportExcel({url: "<c:url value='/deliver/deliver/export'/>"});
	    			}
	    		});
	        }
		});
		
	});
	
	//新增
	function addfunc(){
		var ids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
		var _yzhdhs = "";
		var _datas ;
		var _dataschk ;
		var _msg = "选择多个预走货中 ";
		var _chk = false;
		var _chk2 = false;
		$.each(ids,function(index,element){
			_yzhdhs += $(grid_selector).jqGrid('getRowData',element).yzhdh;
			if(index < ids.length-1){
				_yzhdhs += ",";
			}
			if(index == 0){
				_datas = $(grid_selector).jqGrid('getRowData',element);
			}else{
				// 客户编码/出运类型/起运港/目的港/付款方式/贸易条款 判断
				_dataschk = $(grid_selector).jqGrid('getRowData',element);
				if(_datas.khbm != _dataschk.khbm){
					_msg += "客户编码/";
					_chk = true;
				}else if(_datas.gsbm != _dataschk.gsbm){
					_msg += "公司抬头/";
					_chk = true;
				}else if(_datas.cylx != _dataschk.cylx){
					_msg += "出运类型/";
					_chk = true;
				}/* else if(_datas.qyg != _dataschk.qyg){
					_msg += "起运港/";
					_chk = true;
				} else if(_datas.mdg != _dataschk.mdg){
					_msg += "目的港/";
					_chk2 = true;
				} */ else if(_datas.mytk != _dataschk.mytk){
					_msg += "贸易条款";
					_chk = true;
				}else if(_datas.scjd != _dataschk.scjd){
					_msg += "生产基地";
					_chk = true;
				}
			}
			if(_chk == true){
				return false;
			}
        });
		if(_yzhdhs == ""){
			swal("请至少选择一行表格数据！","","warning");
			return;
		}
		// 客户编码/出运类型/起运港/目的港/付款方式/贸易条款 判断
		if(_chk == true){
			swal(_msg+"信息存在不一致，请核实！","","warning");
			return;
		}
		if(_chk2 == true){
			$("body").bindSweetAlert({
				title:_msg+"信息存在不一致，请核实！"
			},{
				callback:function(){
					location.href = editurl + "?yzhdhs=" + _yzhdhs;	
				}
			})
		}else{
			location.href = editurl + "?yzhdhs=" + _yzhdhs;
		}

	}
	
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
</script>
</html>