(function($) {
	jQuery.extend(jQuery.jgrid.edit, {
		closeAfterAdd : true,
		closeAfterEdit : true,// 提交后关闭
		closeOnEscape : true,
		viewPagerButtons : false,
		// jqModal: true,
		recreateForm : true,
	});

	$.fn.bindTable = function(options, navOptions) {
		var $this = jQuery(this);
		var captionheight = 0;
		var extraheight = 0;
		var height = 0;
		var defaults = {
			// direction: "rtl",
			// url:$searchurl,
			datatype : "json", // 数据来源，本地数据
			// datatype: "local",
			mtype : "POST",// 提交方式
			// data: grid_data,
			height : "auto",
			// caption: "&nbsp;查询结果",
			autowidth : true,
			autoheight : false,
			pagerpos : "right",
			viewrecords : true,
			altRows : true,// 设置为交替行表格
			// toppager: true,
			multiselect : false,
			// multikey: "ctrlKey",
			multiboxonly : true,
			rownumbers : true,
			rowNum : 10,
			rowList : [ 5, 10, 20, 50, 100, 200 ],
			shrinkToFit : true,// true时没有水平滚动条，按比例初始化列宽度
			// forceFit: true,//ture时，调整列宽度不会改变表格的宽度
			cmTemplate : {
				editable : true
			},
			prmNames : {
				page : "page",
				rows : "rows",
				sort : "sidx",
				order : "sord",
				search : "search",
				nd : "nd",
				npage : null
			},
			jsonReader : {
				root : "items",
				// nd: "nd",
				page : "page",
				total : "totalPages",
				records : "totalCount",
				repeatitems : false,
				// cell: "cell",
				// id: "id",
				userdata : "userdata",
				subgrid : {
					root : "rows",
					page : "page",
					total : "total",
					records : "records",
					repeatitems : false,
					cell : "cell"
				}
			},
			ondblClickRow : function(rowid) {
				if (options.editTable) {
					var result = true;
					var lastEdit = $(this).data('lastEdit');
					if (lastEdit && lastEdit!=rowid) {
						/*验证通过返回true*/
						result = $(this).jqGrid('saveRow', lastEdit, false, 'clientArray');
					}
					if(result){
						$(this).jqGrid('editRow', rowid);
						$(this).data('lastEdit', rowid);
					}
				}else if (navOptions && navOptions.viewfunc) {
					var viewfunc = navOptions.viewfunc;
					viewfunc();
					return;
				}else if (navOptions && navOptions.view) {
					jQuery(this).jqGrid('viewGridRow', rowid, {
						width : 800,
						beforeShowForm : function(e) {
							show_form(e);
						}
					});
				}
			},
			serializeGridData : function(postData) {
				if (options && options.formSearch) {
					var formSearch = $(options.formSearch);
					//var param = formSearch.serializeObject();//多选下拉框多值后传到后台保存
					var param = formSearch.getFormData();
					
					var lastFormSearch = jQuery(this).getGridParam("searchParam");
					if(lastFormSearch != null){//改变查询条件后分页信息应该改为第一页
						$.each(lastFormSearch, function(name, value) {
							if (name != "nd" && name != "page" && name != "rows" && name != "search" && name != "sidx" && name != "sord") {
								if (value != param[name]) {
									postData.page = 1
									return;
								}
							}
						});
					}
					jQuery(this).setGridParam({"searchParam":param});
					$.extend(postData, param);
				}
				return postData;
			}
		}

		var settings = $.extend(defaults, options);

		// 为了解决预留垂直滚动条位置的问题
		if (settings.height != "auto") {
			height = settings.height;
			settings = $.extend(settings, {
				height : "auto"
			});
		}

		$this.jqGrid(settings);

		// navbar options
		var navbarOptions = {
			edit : true,
			editicon : 'fa-pencil-square-o blue',
			edittext : '修改',
			add : true,
			addicon : 'fa-plus-square-o purple',
			addtext : '新增',
			del : true,
			delicon : 'fa-trash-o red',
			deltext : '删除',
			search : false,
			searchicon : 'fa-search-plus orange',
			refresh : true,
			refreshicon : 'fa-refresh green',
			refreshtext : '刷新',
			view : true,
			viewicon : 'fa-television grey',
			viewtext : '查看',
			complete : false,
			completeicon : 'fa-check-square-o blue',
			completetext : '完成'
		};

		if (settings.editTable) {
			navbarOptions = $.extend(navbarOptions, {
				edit : false,
				view : false,
				refresh : false,
				addfunc : function() {
					var result = true;
					var lastEdit = $(this).data('lastEdit');
					if (lastEdit) {
						/*验证通过返回true*/
						result = $(this).jqGrid('saveRow', lastEdit, false, 'clientArray');
						var _lastEdit = $(this).data('lastEdit');
						if(_lastEdit == lastEdit){
							return;
						}
					}
					
					if(result){
						var id = new Date().getTime();
						$(this).jqGrid('addRow', {
							rowID : id,
							initdata : {},
							position : "last",
							useDefValues : false,
							useFormatter : false,
							addRowParams : {
								extraparam : {}
							}
						});
						$(this).data('lastEdit', id);
					}
				},
				editfunc : function() {
					var result = true;
					var lastEdit = $(this).data('lastEdit');
					if (lastEdit) {
						/*验证通过返回true*/
						result = $(this).jqGrid('saveRow', lastEdit, false, 'clientArray');
						if(_lastEdit == lastEdit){
							return;
						}
					}
					if(result){
						var _lastEdit = $(this).data('lastEdit');
						var lastSel = $(this).jqGrid('getGridParam', 'selrow');
						$(this).jqGrid('editRow', lastSel);
						$(this).data('lastEdit', lastSel);
					}
				},
				delfunc : function() {
					var lastEdit = $(this).data('lastEdit');
					var lastSel = $(this).jqGrid('getGridParam', 'selrow');
					$(this).jqGrid('delRowData', lastSel);
					
					if(lastEdit == lastSel){
						$(this).removeData('lastEdit');
					}
				}
			});
			if (settings.editComplete) {
				$(this).bind("jqGridInlineAfterSaveRow", function (e, rowid ,result ,rowData) {
					var _result = settings.editComplete(rowid, rowData);
					if(_result != undefined && !_result){
						$(this).jqGrid('editRow', rowid);
						return false;
					}
					$(this).removeData('lastEdit');
				});
			}
		}

		navbarOptions = $.extend(navbarOptions, navOptions);

		// navButtons
		$this.jqGrid('navGrid', options.pager, navbarOptions, {
			// edit record form
			beforeShowForm : function(e) {
				show_form(e);

				var form = $(e[0]);
				style_edit_form(form);
			},
			width : 800,
			onclickSubmit : function(params, postData) {
				var eidtPostData = $this.getGridParam("editPostData");
				if(eidtPostData){
					$.extend(postData, eidtPostData);
				}
			},
			afterSubmit : afterRowSubmit
		}, {
			// new record form
			beforeShowForm : function(e) {
				show_form(e);

				var form = $(e[0]);
				style_edit_form(form);
			},
			width : 800,
			onclickSubmit : function(params, postData) {
				var eidtPostData = $this.getGridParam("editPostData");
				if(eidtPostData){
					$.extend(postData, eidtPostData);
				}
			},
			afterSubmit : afterRowSubmit
		}, {
			// delete record form
			beforeShowForm : function(e) {
				show_form(e);

				var form = $(e[0]);
				if (form.data('styled'))
					return false;
				style_delete_form(form);

				form.data('styled', true);
			},
			width : 550,
			onclickSubmit : function(params, postData) {
				var eidtPostData = $this.getGridParam("editPostData");
				if(eidtPostData){
					$.extend(postData, eidtPostData);
				}
			},
			afterSubmit : afterRowSubmit
		}, {
			// search form
			afterShowSearch : function(e) {
				var form = $(e[0]);
				style_search_form(form);
			},
			afterRedraw : function() {
				style_search_filters($(this));
			},
			multipleSearch : true,
		}, {
			// view record form
			beforeShowForm : function(e) {
				show_form(e);
			},
			width : 800
		});
		
		if (settings.editTable && navbarOptions.complete) {
			this.navButtonAdd(options.gridParent, {
				caption : navbarOptions.completetext,
				buttonicon : navbarOptions.completeicon,
				onClickButton : function() {					
					var lastEdit = $(this).data('lastEdit');
					if (lastEdit) {
						$(this).jqGrid('saveRow', lastEdit, false, 'clientArray');
					}
				},
				position : "last"
			});
		}

		if (settings.shrinkToFit) {
			$(this).closest(".ui-jqgrid-bdiv").css({
				'overflow-x' : 'hidden'
			});
		}

		if (options.gridParent) {
			$this.jqGrid('setGridWidth', $(options.gridParent).width());
			if (settings.autoheight) {
				if (settings.caption && settings.caption != "") {
					captionheight = 38;
				}
				if (settings.extraheight != null) {
					extraheight = settings.extraheight;
				}
				// 设置高度要在设置宽度之后，否则会预留垂直滚动条的位置
				$this.jqGrid('setGridHeight', $(window).height() - extraheight - captionheight - 111);
			} else if (height != 0) {
				$this.jqGrid('setGridHeight', height);
			}

			$(function() {
				if (settings.autoheight) {
					$(window).resize(function() {
						$this.jqGrid('setGridHeight', $(window).height() - extraheight - captionheight - 111);
					});
				}
				$(options.gridParent).resize(function() {
					$this.jqGrid('setGridWidth', $(options.gridParent).width());
				});
			});
		}

		return this;
	};

	$.fn.exportExcel = function(options, callback) {
		var rowData = jQuery(this).jqGrid('getRowData');
		if (typeof (rowData) == 'undefined' || rowData == null || rowData.length < 1) {
			swal('下载数据为空，请重新过滤查询条件！');
			return false;
		}

		var postData = new Object();
		var k = 0;
		var colModel = jQuery(this).getGridParam("colModel");
		$.each(colModel, function(i, n) {
			if (typeof (n['index']) != 'undefined' && n['index'] != null) {
				// && !n['hidden']
				var name = n['label'];
				var model = n['name'];
				eval("postData.exportColNames" + k + "=name");
				eval("postData.exportColModels" + k + "=model");
				eval("postData.exportColModelList" + k + "=JSON.stringify(n)");
				++k;
			}
		});
		
		var groupHeaders = jQuery(this).getGridParam("groupHeaders");
		$.each(groupHeaders, function(i, n) {
			if (typeof (n[i]) != 'undefined' && n[i] != null) {
				eval("postData.exportGroupHeaderList" + i + "=JSON.stringify(n)");
			}
		});

		var params;
		if ($("form.form-search") != null) {
			params = $("form.form-search").getFormData();
		}
		
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		$.extend(params, {"userAgent":userAgent});
		$.extend(params, postData);
		$.extend(params, options.params);
		downloadWindow(options.url, params, "post", callback);
	}
	
	$.fn.exportExcelNoData = function(options, callback) {
		/*var rowData = jQuery(this).jqGrid('getRowData');
		if (typeof (rowData) == 'undefined' || rowData == null || rowData.length < 1) {
			swal('下载数据为空，请重新过滤查询条件！');
			return false;
		}*/

		var postData = new Object();
		var k = 0;
		var colModel = jQuery(this).getGridParam("colModel");
		$.each(colModel, function(i, n) {
			if (typeof (n['index']) != 'undefined' && n['index'] != null) {
				// && !n['hidden']
				var name = n['label'];
				var model = n['name'];
				eval("postData.exportColNames" + k + "=name");
				eval("postData.exportColModels" + k + "=model");
				eval("postData.exportColModelList" + k + "=JSON.stringify(n)");
				++k;
			}
		});
		
		var groupHeaders = jQuery(this).getGridParam("groupHeaders");
		$.each(groupHeaders, function(i, n) {
			if (typeof (n[i]) != 'undefined' && n[i] != null) {
				eval("postData.exportGroupHeaderList" + i + "=JSON.stringify(n)");
			}
		});

		var params;
		if ($("form.form-search") != null) {
			params = $("form.form-search").getFormData();
		}
		
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		$.extend(params, {"userAgent":userAgent});
		$.extend(params, postData);
		$.extend(params, options.params);
		downloadWindow(options.url, params, "post", callback);
	}
	
	$.fn.setCustomGroupHeaders = function(options) {
		jQuery(this).setGroupHeaders(options);
		var groupHeaders = jQuery(this).getGridParam("groupHeaders");
		if(groupHeaders == null){
			groupHeaders = new Array();
		}
		groupHeaders[groupHeaders.length] = options.groupHeaders;
		jQuery(this).setGridParam({"groupHeaders":groupHeaders});
		return jQuery(this);
	}
	
	$.fn.destroyCustomGroupHeader = function(options) {
		jQuery(this).destroyGroupHeader();
		jQuery(this).setGridParam({"groupHeaders":null});
		return jQuery(this);
	}

})(jQuery);

function afterRowSubmit(response, postdata) {
	if (response.responseText != '') {
		var result = eval('(' + response.responseText + ')');
		if (result.success != null) {
			return [ result.success, result.message, postdata.id ];
		}
	}
	return [ true, 'success', postdata.id ];
}

function show_form(e) {
	var dlgDiv = e.closest("div[id*=mod]");
	var parentDiv = e.closest("div[id^=gbox_]");
	var parentWidth = parentDiv.width();
	var dlgWidth = dlgDiv.width();
	var parentLeft = parentDiv.offset().left;
	var parentTop = parentDiv.offset().top;
	dlgDiv[0].style.left = Math.round(parentLeft + (parentWidth - dlgWidth) / 2) + "px";
	dlgDiv[0].style.top = Math.round(parentTop - parentTop / 2) + "px";
}

function style_edit_form(form) {
	// update buttons classes
	var buttons = form.next().find('.EditButton .fm-button');
	buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();// ui-icon,
	// s-icon
	buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
	buttons.eq(1).prepend('<i class="icon-remove"></i>')

	buttons = form.next().find('.navButton a');
	buttons.find('.ui-icon').remove();
	buttons.eq(0).append('<i class="icon-chevron-left"></i>');
	buttons.eq(1).append('<i class="icon-chevron-right"></i>');
}

function style_delete_form(form) {
	var buttons = form.next().find('.EditButton .fm-button');
	buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();// ui-icon,
	// s-icon
	buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
	buttons.eq(1).prepend('<i class="icon-remove"></i>')
}

function style_search_filters(form) {
	form.find('.delete-rule').val('X');
	form.find('.add-rule').addClass('btn btn-xs btn-primary');
	form.find('.add-group').addClass('btn btn-xs btn-success');
	form.find('.delete-group').addClass('btn btn-xs btn-danger');
}

function style_search_form(form) {
	var dialog = form.closest('.ui-jqdialog');
	var buttons = dialog.find('.EditTable')
	buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
	buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
	buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
}

function downloadWindow(url, data, method, callback) {
	var inputs = "";
	if (url && data) {
		// split params into form inputs
		$.each(data, function(p, val) {
			var value = val;
			if (val != null && typeof (val) == 'string') {
				value = val.replace(/"/g, "&quot;");
			}
			inputs += "<input type='hidden' name='" + p + "' value=\"" + value + "\" />";
		});

		if (typeof method == 'undefined' || method == null)
			method = "POST";
		// create form to send request
		var form = $("<form action='" + url + "' method='" + method + "' target='_blank'>" + inputs + "</form>").appendTo("body");

		form.submit();
		form.remove();
	}
}
