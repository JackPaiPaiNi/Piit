(function($){
	$.fn.bindDateRange = function(options){
		var defaults = {
			// startDate: moment().startOf('day'),
			//endDate: moment(),
			//minDate: '01/01/2012',	//最小时间
			/* maxDate : moment(), //最大时间
			dateLimit : {
				days : 30
			}, //起止时间的最大间隔
			showDropdowns : true,
			showWeekNumbers : false, //是否显示第几周
			timePicker : true, //是否显示小时和分钟
			timePickerIncrement : 60, //时间的增量，单位为分钟
			timePicker12Hour : false, //是否使用12小时制来显示时间
			ranges : {
				//'最近1小时': [moment().subtract('hours',1), moment()],
				'今日': [moment().startOf('day'), moment()],
				'昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
				'最近7日': [moment().subtract('days', 6), moment()],
				'最近30日': [moment().subtract('days', 29), moment()]
			},
			opens : 'right', //日期选择框的弹出位置
			buttonClasses : [ 'btn btn-default' ],
			applyClass : 'btn-small btn-primary blue',
			cancelClass : 'btn-small',
			*/
			separator : ' ~ ',
			format : 'YYYY-MM-DD', //YYYY-MM-DD HH:mm:ss 控件中from和to 显示的日期格式
			locale : {
				applyLabel : '确定',
				cancelLabel : '取消',
				fromLabel : '起始时间',
				toLabel : '结束时间',
				customRangeLabel : '自定义',
				daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
				monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
						'七月', '八月', '九月', '十月', '十一月', '十二月' ],
				firstDay : 1
			}
		}
		var settings = $.extend(defaults, options);
		$(this).daterangepicker(settings,function(start, end, label) {
			if(settings.startElement){
				settings.startElement.val(start.format(settings.format));
			} 
			if(settings.endElement){
				settings.endElement.val(end.format(settings.format));
			}
		});
		$(this).on('apply.daterangepicker',function(event,obj){
			if(settings.startElement){
				settings.startElement.val(obj.startDate.format(settings.format));
			} 
			if(settings.endElement){
				settings.endElement.val(obj.endDate.format(settings.format));
			}
		}).on('cancel.daterangepicker',function(event,obj){
			if(settings.startElement){
				settings.startElement.val("");
			} 
			if(settings.endElement){
				settings.endElement.val("");
			}
			$(this).val("");
		});
	};
	
	$.fn.bindDate = function(options){
		var defaults = {
			autoclose: true,
			language: 'zh-CN',
			format:'yyyy-mm-dd'
		}
		if(options && options.disabledWrite) $(this).attr("onfocus","this.blur()");
		var settings = $.extend(defaults, options);
		this.datepicker(settings).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		return this;
	};
	
	$.fn.bindYearMonth = function(options){
		var defaults = {
			autoclose: true,
			language: 'zh-CN',
			startView:1,
			minViewMode:1,
			format:'yyyymm'
		}
		if(options && options.disabledWrite) $(this).attr("onfocus","this.blur()");
		var settings = $.extend(defaults, options);
		this.datepicker(settings).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		return this;
	};
	
	$.fn.bindDateTime = function(options){
		var defaults = {
			autoclose: true,
			language: 'zh-CN'
		}
		if(options && options.disabledWrite) $(this).attr("onfocus","this.blur()");
		var settings = $.extend(defaults, options);
		this.datetimepicker(settings).next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		return this;
	};

})(jQuery);