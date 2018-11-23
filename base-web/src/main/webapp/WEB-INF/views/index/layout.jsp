<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="sys" uri="/WEB-INF/tlds/sys.tld" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>创维海外营销SDO</title>
    <meta name="keywords" content="SDO" />
    <meta name="description" content="SDO" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/WEB-INF/views/index/head.jsp" %>
    
    <!-- inline scripts related to this page -->
    <script type="text/javascript">
    var hasRoleSite = false;
    <shiro:hasRole name="warn_pubsub|warn_drm|warn_ws|warn_email">hasRoleSite=true;</shiro:hasRole>
    
    try{
    	ace.settings.check('main-container' , 'fixed')
        ace.settings.check('sidebar' , 'collapsed');
        ace.settings.check('sidebar' , 'fixed');
        ace.settings.check('breadcrumbs' , 'fixed');
    }catch(e){}

	jQuery(function($) {
		$(".tab-content").css("height",$(window).height()-84);
     	$(".sidebar").css("height",$(window).height()-50);
     	if(hasRoleSite){
     		$("#warnMsg").show();
     		$.bindAjax({
     			url : "<c:url value='/base/warnUser/findCount'/>",
     			action:"search"
     		},function(response){
     			response>0 ? $("#warnNumber").html(response):$("#warnMsg").hide();
     		});
     	}

     	$(window).resize(function(){
			zheZhaoByLoad();
     	    $(".tab-content").css("height",$(window).height()-90);
			$(".sidebar").css("height",$(window).height()-50);
		});
     	
     	$(".nav-tabs").on("click", "[tabclose]", function (e) {
			id = $(this).attr("tabclose");
			closeTab(id);
		});
     	
     	$("#logout").click(function(){
   			$("#logout").bindSweetAlert({
   				title:"确定要注销吗?",
   			},{
   				callback:function(){
     				window.location.href='<c:url value="/logout"/>';
   				}
   			});
     	});
	});
	
	function zheZhaoByLoad(){
		var hh = $("#main-content").height();
		var ww = $("#main-content").width();
		var x=$("#main-content").offset();
		var ll = x.left;
		var tt = x.top;
		$(".zheZhao").css({left: ll+'px',width:ww+'px',height:hh+'px'});
		var w = $(".loading-indicator").width();
		var h = $(".loading-indicator").height();
		var t = scrollY() + (windowHeight()/2) - (h/2);
		if(t < 0) t = 0;
		var l = scrollX() + (ww/2) - (w/2)+ll;
		if(l < 0) l = 0;
		$(".loading-indicator").css({left: l+'px', top: t+'px'});
	}
        
	//浏览器视口的高度
   	function windowHeight() {
   	    var de = document.documentElement;
   	    return self.innerHeight || (de && de.clientHeight) || document.body.clientHeight;
   	}

   	//浏览器视口的宽度
   	function windowWidth() {
   	    var de = document.documentElement;
   	    return self.innerWidth || (de && de.clientWidth) || document.body.clientWidth
   	}

   	/* 浏览器垂直滚动位置 */
   	function scrollY() {
   	    var de = document.documentElement;
   	    return self.pageYOffset || (de && de.scrollTop) || document.body.scrollTop;
   	}

   	/* 浏览器水平滚动位置 */
   	function scrollX() {
   	    var de = document.documentElement;
   	    return self.pageXOffset || (de && de.scrollLeft) || document.body.scrollLeft;
   	}

    var addTabs = function (options) {
	    var url = window.location.protocol + '//' + window.location.host;
		options.url = url + options.url;
		id = "tab_" + options.id;
		$(".active").removeClass("active");
		//如果TAB不存在，创建一个新的TAB
		if (!$("#" + id)[0]) {
			//固定TAB中IFRAME高度
			// mainHeight = $(document.body).height() - 90;
			//创建新TAB的title
	   	    title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab">' + options.title;
	   	    //是否允许关闭
	   	    if (options.close) {
	   	      title += ' <i class="fa fa-remove" tabclose="' + id + '"></i>';
	   	    }
	   	    title += '</a></li>';
	   	    //是否指定TAB内容
	   	    if (options.content) {
	   	      content = '<div role="tabpanel" class="tab-pane" id="' + id + '" style="height: 100%;">' + options.content + '</div>';
	   	    } else {//没有内容，使用IFRAME打开链接
	   	      content = '<div role="tabpanel" class="tab-pane" id="' + id + '" style="height: 100%;"><iframe id="iframepage" src="' + options.url + '" width="100%" height="100%' +// mainHeight +
	   	          '" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes""></iframe></div>';
	   	    }
	   	    //加入TABS
	   	    $(".nav-tabs").append(title);
	   	    $(".tab-content").append(content);
		}
		//激活TAB
		$("#tab_" + id).addClass('active');
		$("#" + id).addClass("active");
		//菜单选中
		$("#menu_"+options.id).parent().addClass("active");
	};
	var closeTab = function (id) {
		//如果关闭的是当前激活的TAB，激活他的前一个TAB
		if($("#tab_" + id).hasClass("active")){
			$("#tab_" + id).prev().addClass('active');
			$("#" + id).prev().addClass('active');
	 	      
			//激活菜单选中状态
			$("#menu .active").removeClass("active");
			var prevId = $("#tab_" + id).prev().attr("id");
			var modelId = prevId.split("tab_tab_")[1];
			$("#menu_"+modelId).parent().addClass("active");
		}
		//关闭TAB
		$("#tab_" + id).remove();
		$("#" + id).remove();
	};
       	
	function sidebarCollapse(obj){
	   	var flagTemp = obj.className;
	   	if(flagTemp == "icon-double-angle-left"){
	   		$("#sidebar").css("overflow-y","visible");
	   	}else{
	   		$("#sidebar").css("overflow-y","auto");
	   	}
   }
        	
    </script>
</head>

<body style="overflow-y: hidden;">
<div class="navbar navbar-default" id="navbar">
    <div class="navbar-container" id="navbar-container" style="padding-right:10px;">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <!-- <i class="icon-globe" style="font-size:22px;"></i> -->
                    <img style="width:150px;" src="${pageContext.request.contextPath}/static/css/images/skyworth_local_small.png">&nbsp;&nbsp;海外营销SDO
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->
        <div class="navbar-header pull-right">
        	<ul class="nav ace-nav">
        		<li class="white" style="padding-left:10px;padding-right:10px;">
        			${user.compName}&nbsp;&nbsp;${user.defautRole}&nbsp;&nbsp;[${user.empCode}]${user.userName}
        		</li>
        		<li class="white" style="cursor:pointer;padding-left:10px;" id="logout">
        			<i class="icon-off bigger-110 icon-only"></i>
        		</li>
        	</ul>            
		</div>

        <%-- <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
            	<li class="purple" id="warnMsg">
					<a href="javascript:addTabs({id:'88',title: '预警查看',close: true,url: '/base/warnMessage'});">
						<i class="icon-bell-alt icon-animated-bell"></i>
						<span class="badge badge-important" id="warnNumber"></span>
					</a>
				</li>
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									<small>你好,</small><shiro:principal/>
								</span>
								<shiro:principal/>
                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

                        <li>
                            <a href='<c:url value="/logout"/>' id="logout">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div> --%><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar" style="overflow-y:auto;">
            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>

                    <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span>

                    <span class="btn btn-danger"></span>
                </div>
            </div><!-- #sidebar-shortcuts -->

            <ul class="nav nav-list" id="menu">
            	<sys:loadMenus menus="${sessionScope.menus}"/>
            </ul><!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" onclick="sidebarCollapse(this)" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>
        </div>

        <div id="main-content" class="main-content" style="overflow:hidden;">
            <%-- <tiles:insertAttribute name="mainContent"/> --%>
            <div class="page-content" style="padding:5px 0 0 5px;">
		         <div class="row">
		           <div class="col-xs-12">
		             <ul class="nav nav-tabs" role="tablist">
		               <li class="active" id="tab_tab_Index"><a href="#tab_Index" role="tab" data-toggle="tab">首页</a></li>
		             </ul>
		             <div class="tab-content" style="padding:0;">
		               <div role="tabpanel" class="tab-pane active" id="tab_Index" style="height:100%;">
		               <iframe id="iframepage" src="<c:url value='/base/bpm/taskList'/>" width="100%" height="100%"
							frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe>
		               </div>
		             </div>
		           </div>
		         </div>
	       </div>
	       
        </div><!-- /.main-content -->

    </div><!-- /.main-container-inner -->

    <!-- <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a> -->
</div><!-- /.main-container -->
</body>
</html>