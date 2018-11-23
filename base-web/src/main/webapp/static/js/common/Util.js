/**
 * @描述 工具脚本
 * @作者 wangwei
 * @Copyright (C) CRC（华润集团）
 * @创建时间 2012/8/11
 * @最后更新时间 2012/8/11
 * @版本 1.0
 */
try {
	// document.domain = ""
} catch (e$$5) {
}
/**
 * @ ============================
 * @public prototype method
 * @============================
 */
/**
 * 判断String数组里面是否存在某个元素
 * 
 * @param {}
 *            a
 * @return {Boolean}
 */
String.prototype.hasString = function(a) {
	if (typeof a == "object") {
		for (var b = 0, c = a.length; b < c; b++)
			if (!this.hasString(a[b]))
				return false;
		return true
	} else if (this.indexOf(a) != -1)
		return true
}

/**
 * 判断某个元素是否在数组里面
 */
Array.prototype.contains = function(obj) {
	var i = this.length;
	while (i--) {
		if (this[i] === obj) {
			return true;
		}
	}
	return false;
}

/**
 * @方法:remove(dx)
 * @功能:删除数组元素.
 * @参数:dx删除元素的下标.
 * @返回:在原数组上修改数组.
 * 
 */
Array.prototype.ddRemove = function(dx) {
	if (isNaN(dx) || dx > this.length) {
		return false;
	}
	this.splice(dx, 1);
}
// ==========

var UT = UT || {
	/**
	 * 判断字符中是否包含中文字符（包括日文韩文等）)
	 * 
	 * @param {}
	 *            s
	 * @return {Boolean}
	 */
	isChinese : function(str) {
		var reg = /[\u4E00-\u9FA5\uF900-\uFA2D]/;
		return reg.test(str);
	},
	/**
	 * 判断是否为整数
	 * 
	 * @param {}
	 *            theInt
	 * @return {Boolean}
	 */
	baseIsNaN : function(theInt) {
		theInt = BASEtrim(theInt);
		if ((theInt.length > 1 && theInt.substring(0, 1) == "0") || BASEisNotNum(theInt)) {
			return true;
		}
		return false;

	},
	/**
	 * 判断是否为浮点数
	 * 
	 * @param {}
	 *            theFloat
	 * @return {Boolean}
	 */
	baseisFloat : function(theFloat) {
		len = theFloat.length;
		dotNum = 0;
		if (len == 0)
			return true;
		for (var i = 0; i < len; i++) {
			oneNum = theFloat.substring(i, i + 1);
			if (oneNum == ".")
				dotNum++;
			if (((oneNum < "0" || oneNum > "9") && oneNum != ".") || dotNum > 1)
				return true;
		}
		if (len > 1 && theFloat.substring(0, 1) == "0") {
			if (theFloat.substring(1, 2) != ".")
				return true;
		}
		return false;
	},
	/**
	 * 获取字符长度
	 * 
	 * @param {}
	 *            s
	 * @return {}
	 */
	getByteLen : function(s) {
		var l = 0;
		var a = s.split("");
		for (var i = 0; i < a.length; i++) {
			if (a[i].charCodeAt(0) < 299) {
				l++;
			} else {
				l += 3;
			}
		}
		return l;
	},
	/**
	 * 判断字符中是否包含有特殊字符
	 * 
	 * @param {}
	 *            s
	 * @return {}
	 */
	containSpecial : function(s) {
		var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
		return containSpecial.test(s);
	},
	/**
	 * 验证邮箱格式
	 * 
	 * @param {}
	 *            s
	 * @return {}
	 */
	mailReg : function(s) {
		var gm = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		return gm.test(s);
	},
	/**
	 * @ Extjs 部分==============
	 */

	/**
	 * 获取Component
	 * 
	 * @param {}
	 *            id
	 * @return {}
	 */
	G : function(id) {
		if (Ext) {
			return Ext.getCmp(id);
		}
	},
	/**
	 * 设置值
	 * 
	 * @param {}
	 *            id
	 * @param {}
	 *            a
	 */
	S : function(id, a) {
		if (Ext) {
			UT.G(id).setValue(a);
		}
	},
	/**
	 * 设置置灰或显示
	 * 
	 * @param {}
	 *            id
	 * @param {}
	 *            a
	 */
	D : function(id, a) {
		if (Ext) {
			UT.G(id).setDisabled(a);
		}
	},
	/**
	 * 获取值
	 * 
	 * @param {}
	 *            id
	 */
	V : function(id) {
		if (Ext)
			UT.G(id).getValue();
	},
	isUndefined : function(a) {
		return typeof a == "undefined"
	},
	isFunction : function(a) {
		return this.getType(a) == "Function"
	},
	isString : function(a) {
		return this.getType(a) == "String"
	},
	getType : function(a) {
		return Object.prototype.toString.call(a).slice(8, -1)
	},
	trim : function(a) {
		return a.replace(/^\s+|\s+$/g, "")
	},
	each : function(a, b) {
		if (UT.isUndefined(a[0]))
			for (var c in a)
				UT.isFunction(a[c]) || b(c, a[c]);
		else {
			c = 0;
			for (var d = a.length; c < d; c++)
				UT.isFunction(a[c]) || b(a[c], c)
		}
	},
	EA : function(a, b, c, d) {
		if (UT.isString(a)) {
			var e = c;
			c = function() {
				eval(e)
			}
		}
		if (a.addEventListener) {
			if (b == "mousewheel")
				b = "DOMMouseScroll";
			a.addEventListener(b, c, d);
			return true
		} else
			return a.attachEvent ? a.attachEvent("on" + b, c) : false
	},
	ready : function(a) {
		if (UT.ready.done)
			return a();
		if (UT.isReady.done)
			UT.readyDo.push(a);
		else {
			UT.readyDo = [a];
			UT.isReady()
		}
	},
	readyDo : [],
	isReady : function() {
		if (!UT.isReady.done) {
			UT.isReady.done = true;
			if (document.addEventListener)
				document.addEventListener("DOMContentLoaded", function() {
							document.removeEventListener("DOMContentLoaded", arguments.callee, false);
							UT.onReady()
						}, false);
			else if (document.attachEvent) {
				var a = top != self;
				if (a)
					document.attachEvent("onreadystatechange", function() {
								if (document.readyState === "complete") {
									document.detachEvent("onreadystatechange", arguments.callee);
									UT.onReady()
								}
							});
				else
					document.documentElement.doScroll && !a && function() {
						if (!UT.ready.done) {
							try {
								document.documentElement.doScroll("left")
							} catch (b) {
								setTimeout(arguments.callee, 0);
								return
							}
							UT.onReady()
						}
					}()
			}
			UT.EA(window, "load", UT.onReady)
		}
	},
	onReady : function() {
		if (!UT.ready.done) {
			UT.ready.done = true;
			for (var a = 0, b = UT.readyDo.length; a < b; a++)
				try {
					UT.readyDo[a]()
				} catch (c) {
				}
			UT.readyDo = null
		}
	},
	/**
	 * 判断浏览器类型
	 * 
	 * @return {}
	 */
	browser : function() {
		var a = {}, b = navigator.userAgent;
		a.ie6 = b.hasString("MSIE 6") && !b.hasString("MSIE 7") && !b.hasString("MSIE 8");
		a.ie8 = b.hasString("MSIE 8");
		a.ie = b.hasString("MSIE");
		a.safari = b.hasString("WebKit");
		a.ipad = b.hasString("iPad");
		a.firefox = b.hasString("Firefox");
		return a
	},
	/**
	 * 判断是否为Array  laill
	 * @param v
	 * @returns {Boolean}
	 */
	isArray : function(v){
		   return Object.prototype.toString.apply(v) === '[object Array]';
	 },
    //获取子元素下的表单对象
 	getSubItems:function(itemsObj, itemList){
 		// var obj1 = document.getElementById(itemsObj);
 		 var obj = jQuery("#"+itemsObj);
 		 var arrays = ["input","select","textarea"];
 		 for (var i = 0; i < arrays.length; i++) {
 			//var objs = obj.getElementsByTagName(arrays[i]);
 			 var objs = obj.find(arrays[i]);
 			if(objs.legnth != 0){
 				for (var j = 0; j < objs.length; j++) {
					itemList.push(jQuery(objs[j]));
					//console.log(jQuery(objs[j]));
				}
 			}
		}
		 
 	},

	/**
	 * 根据界面权限框架，设置界面元素的属性
	 */
	initComponentStatus : function(json){
		if (UT.isArray(json)) {
			var array = json;
			for (var i = 0; i < array.length; i++) {
				var obj = array[i];
				UT.setComponentStatus(obj);
			}
		} else if (typeof json === "object") {
			var obj = json;
			UT.setComponentStatus(obj);
		}
	},
	/**
	 * 设置属性
	 */
	setComponentStatus : function(roleObj){
		var isParent = false;
		var itemList = new Array();
		if (roleObj.condition!=null) {//#yesVirtual.checked == checked
			if (!UT.splitCondition(roleObj.condition)) {
				return;
			}
		}
		if (roleObj.isReadonly!=null || roleObj.isEnable!=null) {
			var resTypeList = ["Div","Tab"];
			for (var i = 0; i < resTypeList.length; i++) {
				if (roleObj.resType == resTypeList[i]) {
					isParent = true;
					UT.getSubItems(roleObj.resId, itemList);//getSubItems(Ext.getCmp(roleObj.resId).items, itemList);
					break;
				}
			}
		}
		//var obj = roleObj.resId;
		//var obj = document.getElementById(roleObj.resId);
		var obj = jQuery("#"+roleObj.resId);
		if (isParent) {
			obj = itemList;
			//console.log(obj);
		}
		/*if (roleObj.isRequired!=null) {
			if (roleObj.isRequired=='Y') {
				UT.setRequired(obj);
			} else if (roleObj.isRequired=='N') {
				UT.setRequired(obj,false);
			}
		}*/
		if (roleObj.isHide!=null) {
			//obj = roleObj.resId;
			if (roleObj.isHide=='Y') {
				UT.setVisible(roleObj.resId,false);
			} else if (roleObj.isHide=='N') {
				UT.setVisible(roleObj.resId);
				if(roleObj.resType == "Tab"){
					var x = 0;
					roleObj.value != 'null' ? x=roleObj.value:"";
					jQuery( "#"+roleObj.parentId ).tabs( "option", "active", x );
				}
			}
		}
		if (roleObj.isReadonly!=null) {
			if (roleObj.isReadonly=='Y') {
				UT.setReadOnly(obj);
			} else if (roleObj.isReadonly=='N') {
				UT.setReadOnly(obj,false);
				if(roleObj.resType == "Tab"){
					var x = 0;
					roleObj.value != 'null' ? x=roleObj.value:"";
					jQuery( "#"+roleObj.parentId ).tabs( "option", "active", x );
				}
			}
		}
		if (roleObj.isEnable!=null) {
			if (roleObj.isEnable=='Y') {
				UT.setDisabled(obj,false);
			} else if (roleObj.isEnable=='N') {
				UT.setDisabled(obj);
			}
		}
		if (roleObj.value!=null) {
			var resValue = roleObj.value;
			if (resValue == 'null') {
				jQuery("#"+roleObj.resId).val('');
			} else {
				jQuery("#"+roleObj.resId).val(resValue);
				if (roleObj.resType == 'Checkbox') {
					resValue == "Y" ? jQuery("#"+roleObj.resId).attr("checked",true): jQuery("#"+roleObj.resId).attr("checked",false);
				}
			}
		}
	},
	
	/**
	 * 拆分条件公式
	 * #yesVirtual.checked == checked
	 */
	splitCondition : function(roleObj){//#yesVirtual.checked == checked
		return UT.parserCondition(roleObj);
	},
	/**
	 * 解析条件公式
	 * #yesVirtual.checked == checked
	 */
	parserCondition : function(roleObj){
		var array = roleObj.split(" ");
		var keywords = ["==","!=","||","&&"];
		var id = null;
		var type = null;
		var method = null;
		var keywordIndex = null;
		var value = null;
		var result = null;
		for (var i = 0; i < array.length; i++) {
			var conditionBlock = array[i];//#id.getValue
			if (conditionBlock.indexOf("#") == 0) {
				var methodStartIndex = conditionBlock.indexOf(".");
				type = conditionBlock.substring(0,1);
				id = conditionBlock.substring(1,methodStartIndex);//yesVirtual
				method = conditionBlock.substring(methodStartIndex+1);//checked
			} else if (keywordIndex == null) {
				for (var j = 0; j < keywords.length; j++) {
					if (keywords[j]==conditionBlock) {//  ==
						keywordIndex = j;//0
						break;
					}
				}
			} else {
				value = conditionBlock;//checked
			}
			
			if (id != null && keywordIndex != null && value != null) {//id = #yesVirtual,keywordIndex =0,value =checked
				var componentValue = null;
				if("checked" == method) {
					//componentValue = document.getElementById(id).checked+'';
					componentValue = jQuery(type+id).attr(method);
				} else if("value" ==  method){
					componentValue = jQuery(type+id).val();
				}
				switch(keywordIndex){
					case 0:
					  result = componentValue == value;
					  break;
					case 1:
					  result = componentValue != value;
					  break;
					case 2:
					  result = componentValue || value;
					  break;
					case 3:
					  result = componentValue && value;
					  break;
				}
				id = null;
				method = null;
				keywordIndex = null;
				value = null;
			}
		}
		return result;
	},
	
	//=========之前方法
	/**
	 * 拆分条件公式
	 * (#id.getValue == wanj) || (#id.checked == true)
	 */
	splitCondition2 : function(roleObj){//#yesVirtual.value == Y
		var strCondition = roleObj;
		var keywords = ["==","!=","||","&&"];
		var start = null;
		var end = null;
		var keywordIndex = null;
		var result = null;
		var conditions = new ArrayList();
		while(((start = strCondition.indexOf("(")) != -1) && ((end = strCondition.indexOf(")")) != -1)){
			if (start != 0) {
				var keyword = strCondition.substring(0,start).trim();
				for (var j = 0; j < keywords.length; j++) {
					if (keywords[j]==keyword) {
						keywordIndex = j;
						break;
					}
				}
			}
			
			conditions.add(strCondition.substring(start+1,end));
			if (keywordIndex != null) {
				conditions.add(keywordIndex);
				keywordIndex = null;
			}
			strCondition = strCondition.substring(end+1);
		}
		if (conditions.size() > 0) {//#id.getValue == wanj
			var param1 = null;
			var operator = null;
			var param2 = null;
			for (var i = 0; i < conditions.size(); i++) {
				if (i == 0) {
					param1 = UT.parserCondition(conditions.get(i++));
				} else {
					param1 = result;
				}
				operator = conditions.get(i);
				param2 = UT.parserCondition(conditions.get(++i));
				switch(operator){
					case 0:
					  result = param1 == param2;
					  break;
					case 1:
					  result = param1 != param2;
					  break;
					case 2:
					  result = param1 || param2;
					  break;
					case 3:
					  result = param1 && param2;
					  break;
				}
			}
		} else {
			result = UT.parserCondition(strCondition);
		}
		return result;
	},
	/**
	 * 解析条件公式
	 * #id.getValue == wanj
	 * #id.checked == true
	 */
	parserCondition2 : function(roleObj){
		var array = roleObj.split(" ");//[#id.getValue, == ,wanj]
		var keywords = ["==","!=","||","&&"];
		var id = null;
		var method = null;
		var keywordIndex = null;
		var value = null;
		var result = null;
		for (var i = 0; i < array.length; i++) {
			var conditionBlock = array[i];//#id.getValue
			if (conditionBlock.indexOf("#") == 0) {
				var methodStartIndex = conditionBlock.indexOf(".");
				id = conditionBlock.substring(1,methodStartIndex);//id
				method = conditionBlock.substring(methodStartIndex+1);//getValue
			} else if (keywordIndex == null) {
				for (var j = 0; j < keywords.length; j++) {
					if (keywords[j]==conditionBlock) {
						keywordIndex = j;
						break;
					}
				}
			} else {
				value = conditionBlock;
			}
			
			if (id != null && keywordIndex != null && value != null) {
				var componentValue = null;
				if ("checked" == method) {
				 	//componentValue = Ext.getCmp(id).checked+'';
					componentValue = document.getElementById(id).checked+'';
				} else if ("getValue" == method) {
					//componentValue = Ext.getCmp(id).getValue();
					componentValue = document.getElementById(id).getValue();
				}
				switch(keywordIndex){
					case 0:
					  result = componentValue == value;
					  break;
					case 1:
					  result = componentValue != value;
					  break;
					case 2:
					  result = componentValue || value;
					  break;
					case 3:
					  result = componentValue && value;
					  break;
				}
				id = null;
				method = null;
				keywordIndex = null;
				value = null;
			}
		}
		return result;
	},
	/**
	 * 设置是否只读
	 */
	setReadOnly : function(obj,bln){
		if (bln==null || bln ==undefined) {
			bln = true;
		}
		if (UT.isArray(obj)) {
			var array = obj;
			for (var i = 0; i < array.length; i++) {
				var id = array[i];
				UT.setReadOnly(id,bln);
			}
		}else if(typeof obj === "string"){
			var toObj = jQuery("#"+obj);
			UT.setReadOnly(toObj,bln);
		} else if (typeof obj === "object") {
			//console.log("tagname="+obj[0].tagName+",name="+obj.attr("name")+",id="+obj.attr("id"));
			var eleTagName = obj[0].tagName;
			var eleName = obj.attr("name");
			var eleTemp = obj.attr("name");
			if(eleName != undefined && eleName.indexOf(".") != -1){//name = "companyNc.timeZone" 作为隐藏input的id时使用jquery来获取对象会出现问题（因此去掉"."）
				var temtemp = "";
				var elearr = eleName.split(".");
				for (var i = 0; i < elearr.length; i++) {
					temtemp += elearr[i];
				}
				eleTemp = temtemp;
			}
			var eleValue = obj.val();// != undefined ? obj.attr("value") :"";
			obj.attr("readonly",bln);
			
			if(bln){
				if(obj.hasClass("parent-node")){
					obj.attr("disabled",bln);
				}
				
				if(obj.hasClass("date-picker")){
					obj.attr("disabled",bln);
					if(!(jQuery("#"+eleTemp+"_add").hasClass("hideTemp"))){
						obj.parent().append('<input type="hidden" class="hideTemp" name="'+eleName+'" id="'+eleTemp+'_add" value="'+eleValue+'"/>');
					}
				}
				
				if(eleTagName == "INPUT"){
					var inputCheckbox = obj.attr("type");
					if(inputCheckbox =="checkbox"){
						obj.attr("onclick","return false;");
						obj.parent().find("span").addClass('x-item-disabled');
					}
					if(inputCheckbox == "radio"){
						obj.attr("disabled",bln);
					}
				}
				
				if(eleTagName == "TEXTAREA"){//当textarea为只读时，避免点击文本域时背景色变白，添加事件
					obj.attr("onfocus","this.blur()");
				}
				
				if(eleTagName == "SELECT"){
					obj.attr("disabled",bln);
					if(!(jQuery("#"+eleTemp+"_add").hasClass("hideTemp"))){
						obj.parent().append('<input type="hidden" class="hideTemp" name="'+eleName+'" id="'+eleTemp+'_add" value="'+eleValue+'"/>');
					}
				}
			}else{
				if(obj.hasClass("parent-node")){
					obj.attr("disabled",bln);
					obj.removeAttr("readonly");
				}
				
				if(obj.hasClass("date-picker")){
					obj.attr("disabled",bln);
					jQuery("#"+eleTemp+"_add").remove();
				}
				
				if(eleTagName == "INPUT"){
					var inputCheckbox = obj.attr("type");
					if(inputCheckbox =="checkbox"){
						obj.removeAttr("onclick");
						obj.parent().find("span").removeClass('x-item-disabled');
					}
					if(inputCheckbox == "radio"){
						obj.attr("disabled",bln);
					}
				}
				
				if(eleTagName == "TEXTAREA"){
					if(!obj.hasClass("swChoice")){
						obj.removeAttr("onfocus");
					}
				}
				
				if(eleTagName == "SELECT"){
					obj.attr("disabled",bln);
					jQuery("#"+eleTemp+"_add").remove();
				}
			}
		}
	},
	/**
	 * 设置是否显示
	 */
	setVisible : function(obj,bln){
		if (bln==null) {
			bln = true;
		}
		if (UT.isArray(obj)) {
			var array = obj;
			for (var i = 0; i < array.length; i++) {
				var id = array[i];
				UT.setVisible(id,bln);
			}
		} else if (typeof obj === "string") {
			var id = obj;
			if(bln){
				jQuery("#"+id).css("display","inline-block");
			}else{
				jQuery("#"+id).css("display","none");
			}
		}
	},
	/**
	 * 设置是否可编辑
	 */
	setDisabled : function(obj,bln){
		if (bln==null || bln ==undefined) {
			bln = true;
		}
		if (UT.isArray(obj)) {
			var array = obj;
			for (var i = 0; i < array.length; i++) {
				var id = array[i];
				UT.setDisabled(id,bln);
			}
		} else if (typeof obj === "string") {//Ext.isString(obj)  laill
			var id = obj;
			jQuery("#"+id).attr("disabled",bln);
			//Ext.getCmp(id).setDisabled(bln);
		} else if (typeof obj === "object") {//Ext.isObject(obj)
			//obj.setDisabled(bln);
			var eleTagName = obj[0].tagName;
			var eleName = obj.attr("name");
			
			//var eleTagName = obj.tagName;
			//var eleId = obj.id;
			//var eleName = obj.name;
			obj.attr("disabled",bln);
		}
	},
	/**
	 * 设置是否必填
	 */
	setRequired : function(obj,bln){
		/*if (bln==null) {
			bln = true;
		}
		if (UT.isArray(obj)) {
			var array = obj;
			for (var i = 0; i < array.length; i++) {
				var id = array[i];
				UT.setRequired(id,bln);
			}
		} else if (typeof obj === "string") {//Ext.isString(obj)
			var id = obj;
			var cmp = document.getElementById(id);//var cmp = Ext.getCmp(id);
			if (bln) {
				jQuery('label[for='+id+']').innerHTML = cmp.fieldLabel + '<span style="color:red">*</span>';
				//Ext.DomQuery.selectNode('label[for='+id+']').innerHTML = cmp.fieldLabel + '<span style="color:red">*</span>';
				cmp.allowBlank = false;
			} else {
				var index = cmp.fieldLabel.indexOf('<span style="color:red">*</span>');
				if (index != -1) {
					jQuery('label[for='+id+']').innerHTML = cmp.fieldLabel.substring(index);
					//Ext.DomQuery.selectNode('label[for='+id+']').innerHTML = cmp.fieldLabel.substring(index);
				}
				cmp.clearInvalid(); //清空验证
				cmp.allowBlank = true;
			}
		}*/
	}
}