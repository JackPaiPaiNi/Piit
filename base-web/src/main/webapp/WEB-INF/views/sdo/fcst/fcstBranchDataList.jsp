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
							<i class="icon-download-alt icon-on-right bigger-110"></i>
							导出
						</button>
							&nbsp;
						<button id="btn-import" type="button" class="btn btn-success btn-minier bigger">
							<i class="icon-upload-alt icon-on-right bigger-110"></i>
							导入
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
										<label class="input-group-addon">分公司&nbsp;&nbsp;</label>
										<select role="select" name="fgsdm" class="form-control skyselect">
											${fns:loadDictOption('FGSDM')}
										</select>
									</div>
								</div>
								<div class="col-xs-6 col-sm-3">
									<div class="input-group input-group-sm">
										<label class="input-group-addon">分公司型号&nbsp;&nbsp;</label>
										<input type="text" name="jixing" class="form-control" />
									</div>
								</div>
								 <div class="col-xs-6 col-sm-3">
					 				<div class="input-group input-group-sm">
										<label class="input-group-addon">尺寸&nbsp;&nbsp;</label>
										<input type="text" name="cc" class="form-control"/>
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
	<shiro:hasPermission name="fcst:fcstBranchData:edit">isEdit=true;</shiro:hasPermission>
	
	$(function($) {
		$('.skyselect').select2();
		$(grid_selector).bindTable({
			url: "<c:url value='/fcst/fcstBranchData/callQuery'/>",
			pager: pager_selector,
			gridParent: "#grid-parent",
			formSearch: "#form-search",
			multiselect:true,
			shrinkToFit: false,
			autoScroll: false,
			autoheight:true,
			extraheight:$('#search-box').height()+38,
			rowNum : 20,
			footerrow: true,
			multiselect:true,
			colModel: [
				{name:'id', label:'ID', hidden: true, width:60, editable:false},
				{name:'fgsdm', index:'fgsdm', label:'分公司', width:80,editable:true, edittype:"select",formatter: "select",
					editoptions:{value:"${fns:loadDictEditOption('FGSDM')}"},editrules:{required:true}},
				{name:'jixing', index:'jixing', label:'分公司型号', width:80,
					editoptions : {dataInit : InitJixing,readonly:true},editrules:{required:true}},
				{name:'cc', index:'cc', label:'尺寸', width:80,editoptions : {readonly:true}},
				/* 循环取填报数据月份列 */ 
				<c:forEach items="${titles}" var="t" varStatus="stat">
				    {name:'${t.month}', index:'${t.month}', label:'${t.colname}', align: "right", width:120, editrules:{integer:true,minValue:0},
				    align:'right',formatter:'integer', formatoptions:{thousandsSeparator: ','}
				    <c:choose>
					    <c:when test="${t.editable==1}">, editable:true, classes:"fcst_qlz_td"</c:when>
					    <c:otherwise>, editable:false</c:otherwise>
				    </c:choose>},
			    </c:forEach>
			],
			editTable:true,
			editComplete: function(lastEdit, rowData){
				sumGrid();
			},
			gridComplete:function(){
				sumGrid();
			}
		},{
			add:isEdit,
			edit:isEdit,
			deltext:'消除',
			del:isEdit,
			complete:isEdit
		});
		
 		$(grid_selector).navButtonAdd(pager_selector,{
			caption:"删除", 
			buttonicon:"fa-pencil-square grey", 
			onClickButton: function(){
				var  data = [];
			    var rowids = $(grid_selector).jqGrid("getGridParam", "selarrrow");
			    if(rowids.length > 0){
			    	 $.each(rowids,function(index,value){
					        var rowData = $(grid_selector).jqGrid("getRowData", value);
					        data.push(rowData);
					   });
			 		var param = $("#form-search").getFormData();
					// 取产品表数据
					var lastEdit = $(grid_selector).data('lastEdit');
					if(lastEdit){
						$(grid_selector).saveRow(lastEdit, false, 'clientArray');
					}
					param.list = JSON.stringify(data);
					
			    	$("#body").bindSweetAlert({
			  			title:"此操作将删除之前的历史数据，你确定要继续吗?"
			  		},{
			  			callback:function(){
			  				$.bindAjax({
			  					url:"<c:url value='/fcst/fcstBranchData/callDelete'/>",
			  					data:param,
			  					action:"save"
			  				},function(response){
			  					$(grid_selector).trigger("reloadGrid");
			  				}); 
			  			}
			  		});
			    }
			},
			position:"last"
		}); 
		//查询
		$("#btn-search").click(function(){
			$(grid_selector).trigger("reloadGrid");
	    });
		//导出
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
	    				$(grid_selector).exportExcel({url: "<c:url value='/fcst/fcstBranchData/export'/>"});
	    			}
	    		});
	        }
		});
		$('#btn-import').click(function(){
			$.importDialog({
				title:"选择文件",
				data: {sfzg:0,lrfs:1},
				url:"<c:url value='/fcst/fcstBranchData/import'/>"
			},{
				callback:function(results){
					$(grid_selector).trigger("reloadGrid");
				}
			});
		});
		//添加型号
		$('#add-model').click(function(){
			pidSelect();
		});
		//保存
		$('#btn-save').click(function(){
			save();
		});
		//初始化机型绑定
		function InitJixing(elem) {
			$(elem).wrap('<span style="cursor:pointer;" class="input-icon input-icon-right"></span>');
			$(elem).parent("span").append('<i class="icon-search green"></i>').click(function() {
				$.tableDialogPage({
					title:"分公司型号选择",
					searchCond:[{"name":"总部型号","value":"zbxh"},
					            {"name":"分公司型号","value":"fgsxh"}],
					colModel:[{name:'zbxh', index:'zbxh', label:'总部型号', width:80},
					          {name:'fgsxh', index:'fgsxh', label:'分公司型号', width:80},
					          {name:'cc', index:'cc', label:'尺寸', width:80}
					        ],
					url:"<c:url value='/fcst/fcstBranchData/searchModelChart'/>"
				},{
					callback:function(rows){
						if(rows){
							$(elem).closest("tr.jqgrow").find("[name='cc']").val(rows.cc);
							$(elem).val(rows.fgsxh);
						}else{
							$(elem).closest("tr.jqgrow").find("[name='cc']").val("");
							$(elem).val("");
						}
						
					}
				});
			});
		}
	});
	//计算列合计
    function sumGrid(){
		var rowNum = $(grid_selector).getGridParam('records');
		if(rowNum>0){
			$(grid_selector).footerData("set",{"pid":"合计",align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},
			    <c:forEach items="${titles}" var="t" varStatus="stat">
				    "${t.month}":$(grid_selector).getCol("${t.month}",false,"sum")
				    <c:if test="${!stat.last}" >,</c:if>
		        </c:forEach>
			});
	    }else{
			$(grid_selector).footerData("set",{"pid":"合计",align:'right',formatter:'number', formatoptions:{thousandsSeparator: ','},
			    <c:forEach items="${titles}" var="t" varStatus="stat">
				    "${t.month}":null<c:if test="${!stat.last}" >,</c:if>
		        </c:forEach>
			});
	    }
    } 
/* 	//PID选择，新开窗口
	function pidSelect(){
			var width = 1000;
			var height = 800;
			var left =  (window.screen.width-width)/2;
			var top =   (window.screen.height-height)/2;
			var pageUrl = "<c:url value='/fcst/fcstBranchData/pidSelect'/>";
			if(window.showModalDialog && typeof(window.showModalDialog) === "function"){
				var dialogArgs = "resizable=1;dialogWidth="+width+"px;dialogHeight="+height+"px;dialogLeft="+left+"px;dialogTop="+top+"px";
				var data = window.showModalDialog(pageUrl,null,dialogArgs);
				if(data){
					initData(data);
				}
			}else{
				var dialogArgs = "resizable=1,width="+width+"px,height="+height+"px,center=yes,left="+left+"px,top="+top+"px";
				var opener = window.open(pageUrl,null,dialogArgs);
				opener.openerCallBack = function(data){
					initData(data);
				}
			}
	  }
	//后台请求，查出选择的型号的历史预测和同期数据
	function initData(data){
	   var param = {} ;
	   var jixings = "" ;
	   $.each(data,function(index,rowData){
		   flag = check(rowData.jixing);
		   if(!flag){
			   jixings=jixings+rowData.jixing+"," ;
		   }
	   });
	   jixings = jixings.substring(0,jixings.length-1);
	   param.jixings = jixings ;
		$.ajax({
			url:"<c:url value='/fcst/fcstBranchData/queryJoin'/>",
			type:'post',  
			data:param,
			error:function(){
				alert("失败!");
			},
			success:function(response){
				 $(grid_selector).jqGrid("addRowData",null,data,"last");
			}
		});
	} */
/* 	//检查带过来的机型和页面的是否重复，如果有重复返回true如果没有重复，返回false
	function check(jixing){
		  var flag = false ;
		  var rows = $(grid_selector).jqGrid('getRowData');
		  $.each(rows,function(index,value){
		     if(value.jixing == jixing){
		    	 flag = true ;
		    	 return false ;
		     }
		  });
		  return flag ;
	}; */
	//保存
	function  save(){
		var  param = {} ;
		//结束编辑
		var ids = $(grid_selector).jqGrid('getDataIDs');
		var lastEdit = $(grid_selector).data('lastEdit');
		var result = true; 
 		if(lastEdit){
			result = $(grid_selector).saveRow(lastEdit, false, 'clientArray');
		} 
 		if(!result){
			return;
		} 
		var data = $(grid_selector).getRowData();
		if(data.length == 0){
			alert("没有需要保存的数据!");
			return ;
		}else{
			var _chkfgsxh =0;
			var _msg="";
			// 同一分公司和分公司机型在表内只能存在一行
			$.each(data, function(i, m){
				var _fgsdm = data[i].fgsdm;
				var _jixing = data[i].jixing;
				var h =i+1;
				for (var j = h;j < data.length; j++){
					var _fgsdm_list = data[j].fgsdm;
					var _jixing_list = data[j].jixing;
					if(_fgsdm == _fgsdm_list && _jixing ==_jixing_list){
						_chkfgsxh = 1;
						_msg = "错误:第"+Number(i+1)+"行与第"+Number(j+1)+"行的分公司代码,分公司型号相同!";
						break;
					}
				}
				if(_chkfgsxh == 1){
					return false;
				}
			});
			if(_chkfgsxh == 1){
				swal(_msg);
				return;
			}
			param.list = JSON.stringify(data);
			//提交后台
			$("#save").bindSweetAlert({
				title:"保存之后会覆盖历史记录,确定要保存吗?"
			},{
				callback:function(){
					$.bindAjax({
						url:"<c:url value='/fcst/fcstBranchData/callEdit'/>",
						data:param,
						action:"save"
					},function(response){
						$(grid_selector).trigger('reloadGrid');
					}); 
				}
			});
		}
	}
</script>
</html>