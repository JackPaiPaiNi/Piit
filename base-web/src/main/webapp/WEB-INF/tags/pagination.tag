<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="com.ey.piit.core.paginator.domain.Paginator" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
int current = page.getPage();
int begin = Math.max(1, current - page.getTotalPages() / 2);
int end = Math.min(current + (page.getLimit() - 1), page.getTotalPages());
// request.setAttribute("page", page.getPage());
// request.setAttribute("limit", page.getLimit());
%>
<script>
function pageSubmit(page){
	$('#page').val(page);
	
	$('#searchForm').submit();
}
</script>
<div class="row">
	<div class="col-sm-6">
		<div class="dataTables_info" id="sample-table-2_info">页数 ${page.page} / ${page.totalPages}, 共 ${page.totalCount} 条记录</div>
	</div>
	<div class="col-sm-6">
		<div class="dataTables_paginate paging_bootstrap">
			<ul class="pagination">
			<%if(page.isHasPrePage()){%>
				<li class="prev"><a href="javascript:pageSubmit(<%=current - 1%>)"><i class="icon-double-angle-left"></i></a></li>
			<%}else{%>
				<li class="prev disabled"><a href="#"><i class="icon-double-angle-left"></i></a></li>
			<%} %>
			<% for(int i = begin; i < end + 1; i++) {%>
				<li <%if(i == current){ %>class="active"<%} %>><a href="javascript:pageSubmit(<%=i%>)"><%= i %></a></li>
			<% } %>
	        <% if (page.isHasNextPage()){%>
                <li class="next"><a href="javascript:pageSubmit(<%=current + 1%>)"><i class="icon-double-angle-right"></i></a></li>
	         <%}else{%>
	            <li class="next disabled"><a href="#"><i class="icon-double-angle-right"></i></a></li>
	         <%} %>
		</div>
	</div>
</div>
<%-- 上一页: ${page.prePage}  --%>
<%-- 当前页: ${page.page}  --%>
<%-- 下一页: ${page.nextPage}  --%>
<%-- 总页数: ${page.totalPages}  --%>
<%-- 总条数: ${page.totalCount} --%>