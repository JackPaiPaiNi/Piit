(function($){	
	$.tableDialogPage = function(options,navOptions){
		var settings = {
				multiselect: false	
		}
		var objs = $.extend({},settings,options);
		
		var tableId = "id"+new Date().getTime();
		var boxContent ='<div class="container-fluid">\
			<form id="f_'+tableId+'" action="javascript:void(0);" class="form-dialog-search">';
		$.each(options.searchCond, function(i, n){
			if(i % 3 == 0){
				if(i != 0){
					boxContent += '<div class="space-4"></div>';
				}
				boxContent += '<div class="row">';
			}
			boxContent +='<div class="col-sm-4">\
				<div class="input-group input-group-sm">\
					<label class="input-group-addon">'+n.name+'：&nbsp;</label>\
					<input type="text" name="'+n.value+'" class="form-control"/>\
				</div>\
			</div>';

			var btn = '<button type="button" class="btn btn-info btn-sm btn-dialog-search">\
					<i class="icon-search icon-on-right bigger-110"></i>查询</button>';
			if(i != 0 && (i + 1) % 3 == 0){
				boxContent += '</div>';
				if(i == options.searchCond.length - 1){
					boxContent +='<div class="space-4"></div>\
						<div class="row"><div class="col-sm-3 pull-right">' + btn + '</div></div>';
				}
			}else{
				if(i == options.searchCond.length - 1){
					boxContent += '<div class="col-sm-3">' + btn + '</div></div>';
				}
			}
		});
		boxContent +='</form>\
			<div class="space-4"></div>\
			<div class="row">\
				<div class="col-xs-12 col-sm-12" id="parent_'+tableId+'">\
					<table id="'+tableId+'"></table>\
					<div id="pager_'+tableId+'"></div>\
				</div>\
			</div>\
		</div>';
		var object = $(boxContent).appendTo("body");
		setTimeout(function(){
			object.find('#'+tableId).bindTable({
				url : options.url,
				multiselect: objs.multiselect,
				caption : "",
				colModel : options.colModel,
				rowNum : 10,
				rowList : [ 5,10 ],
				pager : '#pager_' + tableId,
				gridParent : '#parent_' + tableId,
				formSearch : '#f_' + tableId,
				autoScroll: false,
				ondblClickRow : function(rowid,iRow,iCol,e){
					var rowData = null;
					$.each(object.data("data"), function(i, n){
						if(rowid == n.id){
							rowData = n;
							return;
						}
					});
					navOptions.callback(rowData);
					dlg.modal('hide');
				},
				loadComplete: function(data){
					object.data("data", data.items);
				}
			}, {
				add : false,
				edit : false,
				view : false,
				refresh : false,
				del : false
			});
		},300);		
	
		object.find('.btn-dialog-search').bind("click",function(){
			object.find("#"+tableId).trigger("reloadGrid");
		});
		
		var dlg = bootbox.dialog({
		    title : options.title,
		    message : object,
		    className: "my-modal",
		    buttons : {
			    	success : {
			            label : "<i class='icon-ok'></i> 确定",
			            className : "btn-sm btn-success",
			            callback : function() {
			            	if(!options.multiselect){
			            		var rowid = object.find("#"+tableId).jqGrid('getGridParam','selrow');
				    			var rowData = null;
								$.each(object.data("data"), function(i, n){
									if(rowid == n.id){
										rowData = n;
										return;
									}
								});
								navOptions.callback(rowData);
			            	}else{
			            		 var data = [];
			            		 var rowIds = jQuery("#"+tableId).jqGrid('getGridParam', 'selarrrow');
			            		 $.each(rowIds,function(index,value){
			            			   var rowData = $("#"+tableId).jqGrid("getRowData",value);
			            			   data[index] = rowData ;
			            		 });
			            		 navOptions.callback(data);
			            	}
			            }
			        },
			        cancel : {
			            label : "<i class='icon-info'></i> 取消",
			            className : "btn-sm btn-muted",
			            callback : function() {}
			        },
			        clear : {
			            label : "<i class='icon-remove'></i> 清除",
			            className : "btn-sm btn-danger modalClearBtn",
			            callback : function() {
			            	navOptions.callback(null);
			            }
			        }
			}
		});
	};
	
	$.viewTableInfoDialog = function(options){
		var colmodel = options.colModel;
		var collength = colmodel.length;
		var tableHeadHtml = '';
		for (var i = 0; i < colmodel.length; i++) {
			tableHeadHtml += '<th width="'+colmodel[i].width+'">'+colmodel[i].title+'</th>';
		}
		var boxContentBefore ='<div class="container-fluid">'+
							'<div class="row tableMain" style="margin:0px;">'+
									'<div style="max-height:322px;overflow-y:auto;margin-top:8px;">'+
										'<table class="table table-bordered table-hover table-striped table-condensed">'+
												'<thead id="tableThead"><tr>'+tableHeadHtml+'</tr></thead>'+
												'<tbody id="datasTable">';
		var boxContentAfter = '</tbody></table></div></div></div>';
		
		var response = options.data;
		if(response.length>0){
			var dataHtml = '';
			for (var j = 0; j < response.length; j++) {
				var datatemp = response[j];
				var trhtml = '<tr>';
				for (var k = 0; k < colmodel.length; k++) {
					var tmp = datatemp[colmodel[k].colName];
					trhtml += '<td>'+(tmp==null?'':tmp)+'</td>';
				}
				dataHtml += trhtml+'</tr>';
			}
			var boxContent = boxContentBefore + dataHtml +boxContentAfter;
			var object = $('<div/>').html(boxContent).contents();
		}else{
			var nodata = '<tr><td colspan="'+collength+'">未找到匹配数据!</td></tr>'+
							'<tr><td colspan="'+collength+'"></td></tr>';
			var boxContent2 = boxContentBefore + nodata +boxContentAfter;
			var object = $('<div/>').html(boxContent2).contents();
		}
		
		bootbox.dialog({
		    title : options.title,
		    message : object,
		    className: "my-modal",
		    buttons : {
		    	"cancel" : {
		            "label" : "<i class='icon-remove'></i> 关闭",
		            "className" : "btn-sm btn-muted",
		            "callback" : function() { }
		        }
		    }
		});
	};
	
	$.treeDialog = function(options,navOptions){
		treeDialog(options,navOptions);
	};
	
	$.importDialog = function(options,navOptions){
		var buttons = new Object();
		buttons.success = {
	            "label" : "<i class='icon-ok'></i> 确定",
	            "className" : "btn-sm btn-success",
	            "callback" : function() {
	            	var param = new FormData($('#form-import-bootbox')[0]);
	            	if(options.data){
	                	$.each(options.data,function(name,value){
	                		param.append(name,value);
	                	});
	            	}
	            	$.bindAjax({
						cache: false,
						url:options.url,
						data:param,
						processData: false,
						contentType: false,
						action:"upload"
					},function(response){
						var callback = navOptions.callback;
						callback(response);
					});
	            }
	        };
		buttons.cancel = {
	            "label" : "<i class='icon-info'></i> 取消",
	            "className" : "btn-sm btn-muted",
	            "callback" : function() { }
	        };
		

		var boxContent = '<div class="container-fluid">\
			<div class="row">\
				<div class="col-md-2 col-sm-2"></div>\
				<div class="col-md-6 col-sm-6">\
					<form id="form-import-bootbox" action="javascript:void(0);" enctype="multipart/form-data"><input type="file" name="file"></form>\
				</div>\
				<div class="col-md-2 col-sm-2"></div>\
			</div>\
		</div>';
		var object = $('<div/>').html(boxContent).contents();
		object.find('input[name=file]').ace_file_input({
			no_file:'请选择上传文件 ...',
			btn_choose:'选择',
			btn_change:'重选',
			droppable:false,
			onchange:null,
			thumbnail:false,
			whitelist:'xls|xlsx|xlsm'
		});
		
		bootbox.dialog({
		    title : options.title,
		    message : object,
		    className: "my-modal",
		    buttons : buttons
		});
		return this;
	};
	
	$.fn.bindTreeDialog = function(options,navOptions){
		this.next().on(ace.click_event, function(){
			var $pNode = $(this).parent().children(".parent-node");
			if($pNode.attr("disabled")== "disabled"|| $pNode.attr("readonly")=="readonly"){
				return;
			}
			treeDialog(options,navOptions);
		});
		this.on(ace.click_event,function(){
			treeDialog(options,navOptions);
		});
		return this;
	};
	
	$.fn.bindTreeTableDialog = function(options,navOptions){
		this.next().on(ace.click_event, function(){
			var $pNode = $(this).parent().children(".parent-node");
			if($pNode.attr("disabled")== "disabled"|| $pNode.attr("readonly")=="readonly"){
				return;
			}
			treeTableDialog(options,navOptions);
		});
		this.on(ace.click_event,function(){
			treeTableDialog(options,navOptions);
		});
		return this;
	};

})(jQuery);


function treeDialog(options,navOptions){
	var buttons = new Object();
	buttons.success = {
            "label" : "<i class='icon-ok'></i> 确定",
            "className" : "btn-sm btn-success",
            "callback" : function() {
				var treeObj = $.fn.zTree.getZTreeObj("treeNode");
				var nodes = treeObj.getSelectedNodes();
				var callback = navOptions.callback;
				callback(nodes[0]);
            }
        };
	buttons.cancel = {
            "label" : "<i class='icon-info'></i> 取消",
            "className" : "btn-sm btn-muted",
            "callback" : function() { }
        };
	if(!options.cacelClearBtn){
		buttons.clear = {
            "label" : "<i class='icon-remove'></i> 清除",
            "className" : "btn-sm btn-danger modalClearBtn",
            "callback" : function() {
				var callback = navOptions.callback;
				callback("");
            }
        }
	};
	
	bootbox.dialog({
	    title : options.title,
	    message : BootboxContentWithTree(options),
	    className: "my-modal",
	    buttons : buttons
	});
}

function BootboxContentWithTree(options){
	var searchcond = "";
	if(!options.cancelSearch){
		searchcond ='<div class="row" >'
				+'<div class="col-sm-4">'
					+'<div class="input-group input-group-sm">'
						+'<label class="input-group-addon">'+(options.searchParams)[0].name+'：&nbsp;</label>'
						+'<input type="text" id="searchTreeCond1" class="form-control" />'
					+'</div>'
				+'</div>'
				+'<div class="col-sm-6">'
					+'<div class="input-group input-group-sm">'
						+'<label class="input-group-addon">'+(options.searchParams)[1].name+'：&nbsp;</label>'
						+'<input type="text" id="searchTreeCond2" class="form-control" />'
					+'</div>'
				+'</div>'
				+'<div class="col-sm-2">'
					+'<button id="btn-search" type="button" class="btn btn-info btn-sm">'
						+'<i class="icon-search icon-on-right bigger-110"></i>查询'
					+'</button>'
				+'</div>'
		+'</div>';
	}
	
	var frmm = searchcond+'<div class="row" style="max-height:300px;overflow: auto;border-top: 1px dotted #e2e2e2;margin-top:10px;">'
				+'<div style="text-align: center;display:none;" id="loadId"><label><i class="icon-spinner icon-spin  icon-large"></i> 加载中... </label></div>'
				+'<div id="treeNode" class="ztree"></div></div>'
	var object = $('<div/>').html(frmm).contents();

	object.find('#loadId').show();
	object.find('#treeNode').bindAsyncTree({
		url:options.url,
		autoParam:options.autoParam,
		otherParam:options.dataParams
	},{
		complete:function(){
			object.find('#loadId').hide();
		}
	});
	/*object.find('#treeNode').bindTree({
		dataUrl: options.urlByParent,
		dataParams:options.dataParams,
		lazyload:options.lazyload,//懒加载时 初始化节点当为true时全部设置为isParent=true
		expandAll: options.lazyload,
		callback: {
			onExpand: lazyLoad
		}
	});*/
	object.find('#btn-search').bind("click",function(){
		object.find('#loadId').show();
		var searchCond1 = $.trim($("#searchTreeCond1").val());
		var searchCond2 = $.trim($("#searchTreeCond2").val());
		$("#treeNode").bindAsyncTree({
			url:options.url+"?"+(options.searchParams)[0].value+"="+searchCond1+"&"+(options.searchParams)[1].value+"="+searchCond2,
			autoParam:options.autoParam,
			otherParam:options.dataParams
		},{
			complete:function(){
				object.find('#loadId').hide();
			}
		});
	
		/*$("#treeNode").bindTree({
			dataUrl: options.url+"?code="+code+"&name="+name,
			dataParams:options.dataParams,
			lazyload:options.lazyload,
			searchload:true,
			callback: {
				onExpand: lazyLoad
			}
		});*/
	});
	
/*	function lazyLoad(event, treeId, treeNode) {
		$("#treeNode").bindTree({
			dataUrl: options.urlByParent+"?code="+treeNode.id,
			dataParams:options.dataParams,
			lazyload:options.lazyload,
			lazyAppend:true,//懒加载  添加子节点数据
			lazyPidNode:treeNode
		});
	};*/
     return object
}

var varTreeTableDialog;
function treeTableDialog(options,navOptions){
	var buttons = new Object();
	buttons.success = {
            "label" : "<i class='icon-ok'></i> 确定",
            "className" : "btn-sm btn-success",
            "callback" : function() {
            	var record = new Object();
            	for (var i = 0; i < options["rightColModel"].length; i++) {
            		var colName = options["rightColModel"][i].colName;
            		record[colName] = $(".choiceRecord td").eq(i).html();
            	}
				var callback = navOptions.callback;
				callback(record);
            }
        };
	buttons.cancel = {
            "label" : "<i class='icon-info'></i> 取消",
            "className" : "btn-sm btn-muted",
            "callback" : function() { }
        };
	if(!options.cacelClearBtn){
		buttons.clear = {
            "label" : "<i class='icon-remove'></i> 清除",
            "className" : "btn-sm btn-danger modalClearBtn",
            "callback" : function() {
				var callback = navOptions.callback;
				callback("");
            }
        }
	};
	
	varTreeTableDialog = bootbox.dialog({
	    title : options.title,
	    message : BootboxContentWithTreeTable(options,navOptions),
	    className: "bootbox-dialog-two",
	    buttons : buttons
	});
}

function BootboxContentWithTreeTable(options,navOptions){
	var colModelLength = options["rightColModel"].length + 1;
	var curTreeNode = null;
	var multiple = false;
	if(options.multiple) {
		multiple = options.multiple;
	}
	/*var leftSearchCond ='<div class="row" style="margin:0px;">'
			+'<div class="col-sm-5">'
				+'<div class="input-group">'
					+'<label class="input-group-btn">'+options["leftSearchParams"][0].name+'：&nbsp;</label>'
					+'<input type="text" id="searchTreeCond1" class="form-control" />'
				+'</div>'
			+'</div>'
			+'<div class="col-sm-5">'
				+'<div class="input-group">'
					+'<label class="input-group-btn">'+options["leftSearchParams"][1].name+'：&nbsp;</label>'
					+'<input type="text" id="searchTreeCond2" class="form-control" />'
				+'</div>'
			+'</div>'
			+'<div class="col-sm-2">'
				+'<button id="btn-search-left" type="button" class="btn btn-info btn-sm">'
					+'<i class="icon-search icon-on-right bigger-110"></i>查询'
				+'</button>'
			+'</div>'
	+'</div>';*/
	var rightSearchCond = '<div class="row" style="margin:0px;">'
					+'<div class="col-sm-5" style="padding-left:0px;">'
					+'<div class="input-group input-group-sm">'
						+'<label class="input-group-addon">'+options["rightSearchParams"][0].name+'：&nbsp;</label>'
						+'<input type="text" id="searchGridCond1" class="form-control" />'
					+'</div>'
				+'</div>'
				+'<div class="col-sm-5">'
					+'<div class="input-group input-group-sm">'
						+'<label class="input-group-addon">'+options["rightSearchParams"][1].name+'：&nbsp;</label>'
						+'<input type="text" id="searchGridCond2" class="form-control" />'
					+'</div>'
				+'</div>'
				+'<div class="col-sm-2">'
					+'<button id="btn-search-right" type="button" class="btn btn-info btn-sm">'
						+'<i class="icon-search icon-on-right bigger-110"></i>查询'
					+'</button>'
				+'</div>'
			+'</div><div class="space-4"></div>';
	var rightTableHeadHtml = '';
	if (multiple) {
		rightTableHeadHtml += '<th width="10%"><input type="checkbox" class="headCheck"/></th>';
	}
	for (var i = 0; i < options["rightColModel"].length; i++) {
		if(!options["rightColModel"][i].hidden){
			rightTableHeadHtml += '<th width="'+options["rightColModel"][i].width+'" colName="'+options["rightColModel"][i].colName+'">'+options["rightColModel"][i].colTitle+'</th>';
		}
	}
	var boxContent = '<div class="row contentMian">'+
						'<div class="col-sm-5 leftdiv">'/*+leftSearchCond*/
							+'<div style="text-align: center;display:none;" id="loadId"><label><i class="icon-spinner icon-spin  icon-large"></i> 加载中... </label></div>'
							+'<div id="treeNode" class="ztree"></div>'
						+'</div>'+
						'<div class="col-sm-7 rightdiv">'+rightSearchCond+
							'<div class="row" style="margin:0px;">'+
								'<table class="table table-bordered table-hover">'+
								'<thead>'+rightTableHeadHtml+'</thead>'+
								'<tbody id="accountsTable">'+
									'<tr class="noDataClass"><td colspan="3">请在搜索栏中输入条件查询!</td></tr>'
								'</tbody></table>'+
							'</div>'+
						'</div>'+
					'</div>';
	var object = $('<div/>').html(boxContent).contents();
	
	var searchGrid = function(){
		var searchCond1 = $.trim($("#searchGridCond1").val());
		var searchCond2 = $.trim($("#searchGridCond2").val());
		if (multiple) {
			$("input",$(".headCheck").parents("table")).prop("checked",false);
		}
		$("#accountsTable").html('<tr class="dataloading"><td colspan="'+colModelLength+'"><label><i class="icon-spinner icon-spin  icon-large"></i> 加载中... </label></td></tr>');
		var params = new Object();
		params[options.rightSearchParams[0].value]= searchCond1;
		params[options.rightSearchParams[1].value]= searchCond2;
		if (options.nodeParams != null) {
			for (var i = 0; i < options.nodeParams.length; i++) {
				//节点未选择去除参数  赵明  2016.12.13
				if(curTreeNode != null){
					params[options.nodeParams[i].searchParam] = curTreeNode[options.nodeParams[i].nodeField];
				}
			}
		}
		$.bindAjax({
			url:options.rightUrl,
			data:params,
			limitCount:true,//限制查询数量
			action:"search"
		},function(response){
			response = response.items;
			if(response.length>0){
				var dataHtml = "";
				for (var i = 0; i < response.length; i++) {
					dataHtml += '<tr>';
					if (multiple) {
						dataHtml += '<td><input type="checkbox" onclick="window.event.cancelBubble=true;"/></td>';
					}
					for (var k = 0; k < options["rightColModel"].length; k++) {
						var colAttr = options["rightColModel"][k].colName;
						if(!options["rightColModel"][k].hidden){
							dataHtml += '<td>'+response[i][colAttr]+'</td>';
						}else{
							dataHtml += '<td style="display:none;">'+response[i][colAttr]+'</td>';
						}
					}
					dataHtml += '</tr>';
				}
				$("#accountsTable").html(dataHtml);
			}else{
				var nodata = '<tr class="noDataClass"><td colspan="'+colModelLength+'">未找到匹配查询条件的信息!</td></tr>';
				$("#accountsTable").html(nodata);
			}
			
			$("#accountsTable tr").bind("click",function(){
				$("#accountsTable tr").removeClass("choiceRecord");
				$(this).addClass("choiceRecord");
				if (multiple) {
					var trStatus = $(this).children("td").eq(0).children("input").prop("checked");
					if(trStatus){
						$(this).children("td").eq(0).children("input").prop("checked",false);
					}else{
						$(this).children("td").eq(0).children("input").prop("checked",true);
					}
				}
			});
			
			$("#accountsTable tr").bind("dblclick",function(){
				var record = new Object();
				for (var i = 0; i < options["rightColModel"].length; i++) {
					var colName = options["rightColModel"][i].colName;
					record[colName] = $(this).children("td").eq(i).html();
				}
				var callback = navOptions.callback;
				callback(record);
				varTreeTableDialog.modal('hide');
			});
		});
	};

	object.find('#loadId').show();
	object.find('#treeNode').bindAsyncTree({
		url:options.leftUrl,
		autoParam:options.autoParam,
		otherParam:options.dataParams,
		callback:{
			onClick:function(event, treeId, treeNode){
				curTreeNode = treeNode;
				searchGrid();
			}
		}
	},{
		complete:function(){
			object.find('#loadId').hide();
		}
	});
	object.find('#btn-search-left').bind("click",function(){
		object.find('#loadId').show();
		curTreeNode = null;
		var searchCond1 = $.trim($("#searchTreeCond1").val());
		var searchCond2 = $.trim($("#searchTreeCond2").val());
		$("#treeNode").bindAsyncTree({
			url:options.leftUrl+"?"+options.leftSearchParams[0].value+"="+searchCond1+"&"+options.leftSearchParams[1].value+"="+searchCond2,
			autoParam:options.autoParam,
			otherParam:options.dataParams,
			callback:{
				onClick:function(event, treeId, treeNode){
					curTreeNode = treeNode;
					searchGrid();
				}
			}
		},{
			complete:function(){
				object.find('#loadId').hide();
			}
		});
	});
	object.find('#btn-search-right').bind("click",function(){
		//去除判断节点 赵明  2016.12.13
/*		if(curTreeNode == null){
			swal("请先选择节点!","","warning");
			return;
		}*/
		searchGrid();
	});
	
     return object
}