<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function() {
        $("#updateBtn").click(function() {
            $("#form")
                    .attr("action", "${pageContext.request.contextPath}/core/organization/${organization.id}/update")
                    .submit();
            return false;
        });
        $("#deleteBtn").click(function() {
            if(confirm("确认删除吗？")) {
                $("#form")
                        .attr("action", "${pageContext.request.contextPath}/core/organization/${organization.id}/delete")
                        .submit();
            }
            return false;
        });

        $("#appendChildBtn").click(function() {
            location.href="${pageContext.request.contextPath}/core/organization/${organization.id}/appendChild";
            return false;
        });

        $("#moveBtn").click(function() {
            location.href="${pageContext.request.contextPath}/core/organization/${organization.id}/move";
            return false;
        });
    });
</script>
<div class="breadcrumbs" id="breadcrumbs">
    <ul class="breadcrumb">
        <li>
            <i class="icon-home home-icon"></i>
            <a href="#">首页</a>
        </li>
        <li class="active">组织</li>
    </ul>
</div>

<div class="page-content">
    <div class="page-header">
        <h1>
            组织
            <small>
                <i class="icon-double-angle-right"></i>
                组织管理
            </small>
        </h1>
    </div>
    <!-- /.page-header -->

    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <form:form id="form" method="post" commandName="child">
                <form:hidden path="id"/>
                <form:hidden path="available"/>
                <form:hidden path="parentId"/>
                <form:hidden path="parentIds"/>

                <div class="form-group">
                    <label>父节点名称：</label>
                        ${parent.name}
                </div>

                <div class="form-group">
                    <form:label path="name">子节点名称：</form:label>
                    <form:input path="name"/>
                </div>

                <form:button>新增子节点</form:button>
            </form:form>
            <!-- PAGE CONTENT ENDS -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</div>
<!-- /.page-content -->