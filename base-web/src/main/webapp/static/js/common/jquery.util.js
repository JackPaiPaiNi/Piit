(function($){
	
	$.fn.bindSelect = function(options){
		var time = new Date().getTime();
		var selector = this.selector;
    	$.ajax({
    		async : true,
    		type : "post",
    		dataType : "html",
    		url : options.url,
    		data : {
    			"type":options.type,
    			"code":options.code,
    			"time":time
    		},
    		success : function(data) {
    			var obj = $(selector);
    			obj.append(data);
    			if(options.style){
    				obj.chosen();
    			}
    			if(options.addClass){
    				obj.addClass(options.addClass);
    			}
    		}
    	});
		return this;
	};
	
	$.fn.bindTree = function(options){
		var defaults = {
			expandAll: true,
			view: {
				dblClickExpand: true,
				showLine: true,
				selectedMulti: false,
				fontCss: getFont,
				nameIsHTML: true,
				showTitle : false
			},
			data: {
				simpleData: {
					enable:true
				}
			},
			callback: {
				/*beforeClick: function(treeId, treeNode) {
					var zTree = $.fn.zTree.getZTreeObj(treeId);
					if (treeNode.isParent) {
						zTree.expandNode(treeNode);
					}
					return true;
				}*/
			}
		};
		
		var view = $.extend(defaults.view, options.view);
		options.view = view;
		var data = $.extend(defaults.data, options.data);
		options.data = data;
		var callback = $.extend(defaults.callback, options.callback);
		options.callback = callback;
		
		var settings = $.extend(defaults, options);
		var params = "";
		if(options.dataParams != undefined){
			params = options.dataParams;
		}
		
		var tree = this;
		$.ajax({
    		type : "post",
    		dataType : "json",
    		url : options.dataUrl,
    		data: params,
    		success : function(response) {
    			if(options.numberOut && response.length== 1000){//地区模糊查询数量限制提示
    				swal("","查询数量过多，数据未完整显示，请输入更多查询信息！");
    			}
    			var selectorId = (tree.selector).split("#")[1];
    			if(options.lazyload){//true:节点都设置为文件夹图标
    	    		var treeObj = $.fn.zTree.getZTreeObj(selectorId);
    	    		for (var i = 0; i < response.length; i++) {
    	    			response[i].isParent = true;
    				}
    	    		//searchload：true表示展开节点(科目使用)
    	    		if(!options.searchload) settings.expandAll = false;
    			}

    			if(options.lazyAppend){
    				var treeObj = $.fn.zTree.getZTreeObj(selectorId);
    				if(response.length == 0) return false;
    				for (var i = 0; i < response.length; i++) {
    					var node = treeObj.getNodeByParam("id", response[i].id, null);
    					if(node == null) treeObj.addNodes(options.lazyPidNode, response[i]);
					}    				
    				/*if(response.length == 0) return false;
    				if(!options.lazyPidNode.istrue){
    					options.lazyPidNode.istrue = "checked";
    					newNodes = treeObj.addNodes(options.lazyPidNode, response);
    				}*/
    			}else{
    				var zTree = $.fn.zTree.init(tree, settings, response);
    				if(settings.expandAll){
        				zTree.expandAll(true);
        			}
    				
    				if(options.hideCheckbox){
        				tree.ztreeAllDisabled(zTree);
        			}
    			}
    			$.hideLoad();
    			//$('#loadId').hide();
    		}
    	});
		
		return this;
	};
	
	$.fn.bindAsyncTree = function(options,funOptions){
		var defaults = {
			expandAll: true,
			view: {
				dblClickExpand: true,
				showLine: true,
				selectedMulti: false,
				fontCss: getFont,
				nameIsHTML: true,
				showTitle : false
			},
			async: {
				enable: true,
				url:options.url,
				autoParam:options.autoParam,
				otherParam:options.otherParam,
				dataFilter: filter
			},
			data: {
				simpleData: {
					enable:true
				}
			},
			callback: {
				onAsyncSuccess:function(event, treeId, treeNode, msg){
					if(funOptions && funOptions.complete){
						var complete = funOptions.complete;
						complete();
					}
				},
				onAsyncError:function(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown){
					swal("","数据加载失败!","error");
					if(funOptions && funOptions.complete){
						var complete = funOptions.complete;
						complete();
					}
				}
			}
		};
		
		var view = $.extend(defaults.view, options.view);
		options.view = view;
		var data = $.extend(defaults.data, options.data);
		options.data = data;
		var callback = $.extend(defaults.callback, options.callback);
		options.callback = callback;
		
		var settings = $.extend(defaults, options);
		var params = "";
		if(options.dataParams != undefined){
			params = options.dataParams;
		}
		var zTree = $.fn.zTree.init(this, settings);
		return this;
	};
	
	$.fn.ztreeAllDisabled = function(treeObj){
		var nodes = treeObj.transformToArray(treeObj.getNodes());
	    for (var i = 0; i < nodes.length; i++) {
	        treeObj.setChkDisabled(nodes[i], true);
	    }
	};
	
	$.fn.treeExportExcel = function(options){
		var postData = new Object();
		var k = 0;
		if($("form.form-submit") != null){
    		var params = $("form.form-submit").serializeObject();
    		for ( var param in params) {
    			var $colByName = $(".form-submit [name='"+param+"']");
    			var name = $.trim($colByName.attr("exportColNames"));
    			if(name == "") continue;
				var model = param;
				var tagname = $colByName[0].tagName;
				var n = "";
				if(tagname == "SELECT"){
					var optionTemp = "";
					var cc = 0;
			         $(".form-submit [name='"+param+"'] option").each(function () {
			             var txt = $.trim($(this).text()); 
			             var val = $(this).val(); 
			             if(cc == 0){
			            	 optionTemp += val +":"+ txt;
			             }else{
			            	 optionTemp += ";"+val +":"+txt;
			             }
			             ++ cc;
			         });
					n = {"editable":true,"name":model,"index":model,"label":name,"width":80,"edittype":"select","formatter":"select","editoptions":{"value":optionTemp},"title":true,"lso":"","hidden":false,"widthOrg":100,"resizable":true,"sortable":true};
				}else if($colByName.hasClass("exportDate")){
					n = {"editable":true,"name":model,"index":model,"label":name, "width":80,"formatter":"date","formatoptions":{"newformat":"Y-m-d"}, "editoptions":{"size":"20","maxlength":"30"},"title":true,"lso":"","hidden":false,"widthOrg":100,"resizable":true,"sortable":true};
				}else{
					n = {"editable":true,"name":model,"index":model,"label":name, "width":80, "editoptions":{"size":"20","maxlength":"30"},"title":true,"lso":"","hidden":false,"widthOrg":100,"resizable":true,"sortable":true};
				}
				eval("postData.exportColNames" + k + "=name");
				eval("postData.exportColModels" + k + "=model");
				eval("postData.exportColModelList" + k + "=JSON.stringify(n)");
				++k;
			}
    	}
		var params = $.extend(options.params,postData);
		downloadWindow(options.url, params, "post");
	};
	
	//使表单元素不可编辑 
	$.fn.disableForm = function(){
		//var form = document.forms[0];
		var  form = $(this)[0];
		for ( var i = 0; i < form.length; i++) { 
			var element = form.elements[i];
			element.disabled = "true"; 
		}
	};
	
	//取消不可编辑 
	$.fn.enableForm = function(){
		//var form = document.forms[0]; 
		var  form = $(this)[0];
		for ( var i = 0; i < form.length; i++) { 
			var element = form.elements[i]; 
			element.disabled = false; 
		} 
	};
	
	 /**
     * ajax封装
     * url 发送请求的地址
     * data 发送到服务器的数据，数组存储，如：{"date": new Date().getTime(), "state": 1}
     * async 默认值: true。默认设置下，所有请求均为异步请求。如果需要发送同步请求，请将此选项设置为 false。
     *       注意，同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
     * type 请求方式("POST" 或 "GET")， 默认为 "POST"
     * dataType 预期服务器返回的数据类型，常用的如：xml、html、json、text,默认为json
     * cache 默认true,false(将不缓存)
     * processData false(不要去处理发送的数据),默认true（对data参数进行序列化处理）
     * contentType 默认值: "application/x-www-form-urlencoded"。发送信息至服务器时内容编码类型。
     * action 请求用途（"save"提交/保存 或 "search"查询 或 "" 未填写）
     * title 扩展信息
     * completefn 回调函数
     * limitCount 当配置参数limitCount:true时,表示限制返回数据数量 （默认限制条数defaultLimitCount）
     */
	$.bindAjax = function(options,completefn){
		var async = (options.async==null || options.async==="" || typeof(options.async)=="undefined")? "true" : options.async;
        var type = (options.type==null || options.type==="" || typeof(options.type)=="undefined")? "post" : options.type;
        var dataType = (options.dataType==null || options.dataType==="" || typeof(options.dataType)=="undefined")? "json" : options.dataType;
        var data = (options.data==null || options.data==="" || typeof(options.data)=="undefined")? "": options.data;
        var limitCount = (options.limitCount==null || options.limitCount==="" || typeof(options.limitCount)=="undefined")? false: options.limitCount;
        var cache = (options.cache==null || options.cache==="" || typeof(options.cache)=="undefined")? true: options.cache;
        var processData = (options.processData==null || options.processData==="" || typeof(options.processData)=="undefined")? true: options.processData;
        var contentType = (options.contentType==null || options.contentType==="" || typeof(options.contentType)=="undefined")? "application/x-www-form-urlencoded": options.contentType;
        var action = (options.action==null || options.action==="" || typeof(options.action)=="undefined")? "" : options.action;//""|save|search
        var defaultLimitCount = 300;// 默认配置为100条数据,可配置
        if(limitCount){//限制返回数据数量
        	data.rows = defaultLimitCount;
        	data.page = 1;
        }
        layer.load(1);
        $.ajax({
            type: type,
            async: async,
            data: data,
            url: options.url,
            dataType: dataType,
            cache:cache,
            contentType:contentType,
            processData:processData,
            complete: function(response){
            	layer.closeAll('loading');
				if(response.status == "401"){
					$.hideLoad();
					swal({title: "失败！",text: "会话超时，请重新登录！",type: "error"},	function(){
						return  false;
					});
				}else if(response.status == "200"){
					var subStr = response.responseText.substring(0,14);
					if(subStr.indexOf("success:false") != -1){
						$.hideLoad();
						var msg = response.responseText.substring(24,response.responseText.length-2);
						swal({title: "失败！",text: "失败原因："+msg,type: "error"	},function(){
							return  false;
						});
					}else{//success
						if(action == "save" || action == "upload" || action == "edit" ){
							$.hideLoad();
							var resultJson ="";
							if(response.responseText && !response.responseText==""){
								 resultJson =JSON.parse(response.responseText);
							}
							if(!resultJson.msg || resultJson.msg=="" ){
								swal({title: "成功！",text: "",type: "success"},	function(){
									completefn(response.responseText);
								});
							}else{
								
								swal({title: "",text: resultJson.msg,type: (resultJson.result == "0")? "error":"success"},	function(){
									completefn(response.responseText);
								});
							}
							
						}else if(action == "search"){
							var datass = (response.responseJSON != undefined) ? response.responseJSON : response.responseText;
							 if(limitCount){
								 if(datass["items"].length== defaultLimitCount){
									 swal("","为您查询到相关结果"+datass["totalCount"]+"条，未完整显示全部结果，请输入更多查询信息！");
								 }
							 }
							 completefn(datass);
						}else{
							$.hideLoad();
							swal({title: "成功！",text: response.responseText,type: "success"},	function(){
								completefn(response.responseText);
							});
						}
					}
				}else{//500...
					$.hideLoad();
					swal({title:"失败！",text: "系统错误，请联系管理员!",type: "error"	},function(){
						return  false;
					});
				}
				
            }
        
        });
	}
	
	$.fn.bindToolTip = function(){
		$(this).simpletooltip({
	         position: 'bottom-right',
	         border_color: '#111111',
	         color: '#000000',
	         background_color: '#FFFFFF',
	         border_width: 2,
	         max_width:400
	     });
	};
	
	$.loading = function(){
		$(".loading-indicator").css("display","block");
		$(".zheZhao").css("display","block");
		/*//var height = document.body.clientHeight;//var height = $(".page-content").height();
		var scorllHeight = document.body.scrollTop;
		var height = window.innerHeight;
		//var left = document.body.clientWidth;//var left = $(".page-content").width();
		var left = window.innerWidth;
		$(".loading-indicator").css("left",(left/2 - $(".loading-indicator").width()/2)+"px");
		$(".loading-indicator").css("top",(scorllHeight+(height/2-$(".loading-indicator").height()/2))+"px");*/
		
		/*var w = $(".loading-indicator").width();
	    var h = $(".loading-indicator").height();
	    
	    var t = scrollY() + (windowHeight()/2) - (h/2)-80;
	    if(t < 0) t = 0;
	    
	    var l = scrollX() + (windowWidth()/2) - (w/2);
	    if(l < 0) l = 0;
	    
	    $(".loading-indicator").css({left: l+'px', top: t+'px'});*/
	};
	
	$.hideLoad = function(){
		$(".loading-indicator").css("display","none");
		$(".zheZhao").css("display","none");
	};
	
	$.fn.bindAutoComplete = function(options){
		$(this).autocomplete({
			 minLength: 0,
			 width:235,
		     source: function( request, response ) {
		    	//options.hideCode.val("");
		    	$.trim(request.term) != ""?options.loadIcon.show():"";
		        $.ajax({
		          url: options.dataUrl,
		          type:"post",
		          dataType: "json",
		          data: {
		        	  simple: "Y",
		              page: 1,
		              rows: 10,
		              name: request.term
		          },
		          success: function( data ) {
		        	$.trim(request.term) == ""? data.items = "":"";
		            response( $.map( data.items, function( item ) {
		              return {
		                label: item.name,// + (item.adminName1 ? ", " + item.adminName1 : "") + ", " + item.countryName,
		                value: item.code
		              }
		            }));
		            options.loadIcon.hide();
		          }
		        });
		      },
		      /* focus: function( event, ui ) {
		    	  $("input[name=supplierName]").val( ui.item.label );
		        return false;
		      }, */
		      select: function( event, ui ) {
		    	  $(this).val( ui.item.label );
		    	  //options.hideCode.val( ui.item.value );
		        return false;
		      }
		});
	}
	
	$.fn.bindSweetAlert = function(options,funOptions){
		var defaults = {
				title: "确定要执行此操作么?",
				text: "",
				type: "warning",
				confirmButtonText: "确定",
				cancelButtonText:"取消",
				showCancelButton: true,
				showLoaderOnConfirm: true,
				closeOnConfirm: false
			};
		var settings = $.extend(defaults, options);
		swal(settings,function(){
				if(funOptions && funOptions.callback){
					var callback = funOptions.callback;
					callback();
				}
		});
	}

})(jQuery);

function filter(treeId, parentNode, childNodes) {
	if (!childNodes) return null;
	for (var i=0, l=childNodes.length; i<l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}

function getFont(treeId, node) {
	return node.font ? node.font : {};
}

function downloadWindow(url, data, method){
	var inputs = "";

	if(url && data){
		
		//split params into form inputs
		$.each(data, function(p, val){
			var value = val;
			if (val != null && typeof(val) == 'string') {
				value = val.replace(/"/g, "&quot;");
			}
			inputs += "<input type='hidden' name='"+ p +"' value=\""+ value +"\" />";
		});
		
		if (typeof method == 'undefined' || method == null)
			method = "POST";
		//create form to send request
		var form = $("<form action='" + url + "' method='" + method + "' target='_blank'>" + inputs + "</form>").appendTo("body");
		
		form.submit();
		form.remove();
	};
}

jQuery.fn.extend({
	getFormData : function() {
		var form = $(this);
		form.removeDisabled();
		var formArray = form.serializeArray();
		form.addDisabled();
		var data = {};
		$.each(formArray, function(i, n){
			if (n.name) {
				if (typeof (data[n.name]) == 'undefined') {
					data[n.name] = n.value;
				} else {
					if(n.value != ""){
						data[n.name] += "," + n.value;
					}
				}
			}
		});
		return data;
	},
	setFormData : function(data){
		var form = $(this);
		form.find(".skycheckbox").prop("checked","checked");
		var values = form.getFormData();
		form.find(".skycheckbox").removeProp("checked").removeAttr("checked");
		$.each(values, function(name, value){
			var val = data[name];
			var element = form.find("[name="+name+"]");			
			
			val = (val != null) ? val+"" : "";
			
			if(element.hasClass("skycheckbox")){
				if(val.indexOf(",") > -1){
					var temp = val.split(",");
					$.each(temp, function(i, n){
						form.find("[name="+name+"][value="+n+"]").prop("checked","checked").trigger("change");
					})
				}else if(val == 1){
					form.find("[name="+name+"][value="+val+"]").prop("checked","checked").trigger("change");
				}else{
					element.removeProp("checked").removeAttr("checked").trigger("change");
				}
			}else if(element.hasClass("skyselect")){
				if(val.indexOf(",") > -1){
					element.val(val.split(",")).trigger("change");
				}else{
					element.val(val).trigger("change");
				}
			}else if(element.hasClass("skyradio")){
				if(val != ""){
					form.find("[name="+name+"][value="+val+"]").prop("checked","checked").trigger("change");
				}else{
					element.removeProp("checked").removeAttr("checked").trigger("change");
				}
			}else {
				element.val(val);
			}
		});
	},
	addDisabled : function(){
		var form = $(this);
		form.find(".skydisabled").prop("disabled","disabled");
	},
    removeDisabled : function(){
    	var form = $(this);
    	form.find(".skydisabled").removeProp("disabled").removeAttr("disabled");
	},
	addReadonly : function(){
		$(this).on({
			  click: function() {
				 return false;
			  },
			  mouseover: function() {
			     return false;
			  },
			  mousedown: function() {
				 return false;
			  },
			  dblclick: function() {
			     return false;
			  },
			  mouseup : function (){
				  return false;
			  }
			});
	}
});