<%@ page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Expires" content="0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Cache-Control" content="no-store">
<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="bookmark" type="image/x-icon" />
<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="icon" type="image/x-icon" />
<link href="${pageContext.request.contextPath}/static/css/images/favicon.ico" rel="shortcut icon" type="image/x-icon" />

<link href="${pageContext.request.contextPath}/static/jquery.uploadify/uploadify.css" rel="stylesheet" type="text/css" />

<!--jquery js ,引用本地的标准jquery即可 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery.uploadify/jquery.uploadify.js?v=4"></script>

<script type="text/javascript" charset="utf-8">
	$.lfsUploadOptions = {
		baseUrl : 'http://172.20.99.235',
		swf : '${pageContext.request.contextPath}/static/jquery.uploadify/uploadify.swf',
		uploader : 'http://172.20.99.235/commdisk/uploadFiles.action',
		formData : {
			pid : -1,
			updDstPath : "/附件",
			create : 1,
			dest : 1,
			apikey : "9697a71c025df7188683c8cd5e91f27c",
			usid : "5133b0f917c1c9b0e73b877c72967083-a14ab25439799668-SKY003852",
			filePrefix : "yyyyMMdd",
			dirFormat : "yyyyMM",
			filenameFormat : "{FILE_NAME}_{dateFormat}",
			dateFormat : "yyyyMMddHHmmssSS",
			appName : "SDO"
		},
		successTimeout : 99999,
		removeTimeout : 1,//默认值3，单位秒。文件上传完后延时隐藏queue队列。
		fileTypeDesc : '所有文件',//'所有文件',
		fileTypeExts : '*.*',//'*.jpg;*.gif;*.jpeg;*.png;*.bmp',
		fileObjName : 'filedata',
		queueID : 'multiFileQueue',
		//uploadLimit : 2,
		multi : false,
		auto : true,
		fileSizeLimit : 1024 * 1024 * 1024 * 10,
		queueSizeLimit : 20,
		buttonText : '<i class="icon-upload-alt icon-on-right bigger-110"></i>',
		removeCompleted : true,//上传成功后是否从队列中删除
		height : 18,
		width : 30,
		itemTemplate : '<div id="\${fileID}" class="uploadify-queue-item">\
				<div class="cancel">\
				<a class="uploadify_stop" href="javascript:$(\'#\${instanceID}\').uploadify(\'stop\', \'\${fileID}\')">暂停</a>\
				<a class="uploadify_upload" href="javascript:$(\'#\${instanceID}\').uploadify(\'upload\', \'\${fileID}\')">上传</a>\
				<a class="uploadify_cancel" href="javascript:$(\'#\${instanceID}\').uploadify(\'cancel\', \'\${fileID}\')">取消</a>\
			</div>\
			<span class="fileName">\${fileName} (\${fileSize})</span><span class="data"></span>\
			<div class="uploadify-progress">\
				<div class="uploadify-progress-bar"><!--Progress Bar--></div>\
			</div>\
		</div>',
		onFallback : function() {
			alert("您未安装FLASH控件，无法上传文件！请安装FLASH控件后再试。");
		},
		onSelect : function(file) {
		},
		onCancel : function(file) {
		},
		onUploadStart : function() {
		},
		onUploadSuccess : function(file, data, response) {
			/* if (response) {
				alert(data);
				data = $.parseJSON(data);
				if ("SUCCESS" == data.status) {
				} else {// INVALID or ERROR
					alert(data.msg);
				}
			} */
		},
		onUploadComplete : function(file) {
		},
		onUploadError : function(file, errorCode, errorMsg, errorString) {
		},
		onQueueComplete : function(queueData) {
		}
	};

	(function($) {
		$.uploadDialog = function(options, navOptions) {
			var buttons = new Object();
			buttons.success = {
				"label" : "<i class='icon-ok'></i> 确定",
				"className" : "btn-sm btn-success",
				"callback" : function() {
					var callback = navOptions.callback;
					var data = boxContent.data("data");
					callback(data);
				}
			};
			buttons.cancel = {
				"label" : "<i class='icon-info'></i> 取消",
				"className" : "btn-sm btn-muted",
				"callback" : function() {
				}
			};			

			var id = new Date().getTime();
			var boxContent = $('<div class="container-fluid">' 
				+ '<div class="row">' 
				+ '<div class="col-xs-12 col-sm-12">'
				+ '<div class="input-group input-group-sm">'
				+ '<span class="input-group-addon">'
				+ '<input type="file" id="file_' + id + '">' 
				+ '</span>'
				+ '<div class="form-control"></div>'
				+ '</div>'
				+ '</div>' 
				+ '</div>'
				+ '<div class="space-4"></div>'
				+ '<div class="col-xs-12 col-sm-12" id="multiFileQueue"></div>'
				+ '</div>');
			setTimeout(function(){
				var opts = $.extend($.lfsUploadOptions, options, {
					onUploadSuccess : function(file, data, response) {
						if (response) {
							result = $.parseJSON(data);
							var tmpUrl = "";
							if ("SUCCESS" == result.status) {
								tmpUrl = "<a href='"+$.lfsUploadOptions.baseUrl+result.downloadurl+"'>"+result.filename+"</a>";
								boxContent.find("div.form-control").empty().append(tmpUrl);
							} else {// INVALID or ERROR
								alert(result.msg);
							}
							result.url = tmpUrl;
							boxContent.data("data", result);
						}
					}
				});
				$('#file_' + id).uploadify(opts);
			}, 500);

			bootbox.dialog({
				title : options.title || '上传附件',
				message : boxContent,
				className : "my-modal",
				buttons : buttons
			});
			return this;
		};
	})(jQuery);
</script>