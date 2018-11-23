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
			multiselect: true,
			rowNum:20,
			autoheight:true,
			extraheight:$('#search-box').height()/*  + 48 */,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'yzhdh', index:'yzhdh', width:80,hidden:true},
				{name:'scjd', index:'scjd',label:'生产基地', width:80, hidden:true},
				{name:'scjdmc', index:'scjdmc',label:'生产基地', width:80},
				{name:'syzhdh', index:'syzhdh',label:'预走货单号', width:80,formatter:yzhxx},
				{name:'dcdh', index:'dcdh',label:'订舱单号', width:80},
				{name:'yzhlx', index:'yzhlx', hidden:true, width:80},
				{name:'yzhlxmc', index:'yzhlxmc', label:'预走货类型', width:80},
				{name:'xsbm', index:'xsbm', hidden:true},
				{name:'xsbmmc', index:'xsbmmc', label:'业务部门名称', width:80},
				{name:'xsymc', index:'xsymc', label:'销售员', width:80},
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
				{name:'mytkmc', index:'mytkmc', label:'贸易条款', width:80},
				{name:'gtin', index:'gtin', label:'GTIN码', width:80},
				{name:'cas', index:'cas', label:'CAS码', width:80},
				{name:'pplx', index:'pplx', label:'品牌类型', width:140},
				{name:'ckxhqk', index:'ckxhqk', label:'出口享惠情况', width:100}
			],
		},{
			add:false,
			edit:false,
			view:false,
			del:false,
			refresh:false
		});
		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"确认", 
			buttonicon:"fa-check-square-o blue", 
			onClickButton: function(){
				yzhConfirm();
			},
			position:"last"
		});
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		
	});
	
	//新增
	function yzhConfirm(){
		var ids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
		var _yzhdhs = "";
		var _datas ;
		var _dataschk ;
		var _msg = "选择多个预走货中 ";
		var _chk = false;
		var _chk2 = false;
		var yzh_data =[];
		$.each(ids,function(index,element){
			_yzhdhs += $(grid_selector).jqGrid('getRowData',element).yzhdh;
			var data = $(grid_selector).jqGrid("getRowData");
			yzh_data.push($(grid_selector).jqGrid('getRowData',element));
			
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
			var requestData = {};
			requestData.yzhdhs = _yzhdhs;
			$.bindAjax({
				url:"<c:url value='/deliver/deliver/findYzh'/>",
				data:requestData,
				action:"search"
			},function(response){
				// 关闭当前窗口
				window.close();
				//上传确定，后的回调处理
				if(window.showModalDialog){//支持showModalDialog函数
					window.returnValue = response;
				}else{//新版chrome不支持showModalDialog函数
					if(window.openerCallBack && typeof(window.openerCallBack) === "function"){
						// 调用父窗口的方法
						window.openerCallBack(response);
					}
				}
			}); 
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