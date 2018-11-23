<c:forEach items="${sessionScope.menus}" var="m">
	<c:choose>
		<c:when test="${m.children == null}">
			<li>
				<a href='javascript:void(0);'>
					<i class="${m.icon }"></i>
					<span class="menu-text"> ${m.name} </span>
				</a>
			</li>
		</c:when>
		<c:otherwise>
			<li>
				<a href="javascript:void(0);" class="dropdown-toggle">
					<i class="${m.icon }"></i>
					<span class="menu-text"> ${m.name} </span>
					<b class="arrow icon-angle-down"></b>
				</a>
				<ul class="submenu">
					<c:forEach items="${m.children}" var="m2">
						<li>
							<a id="menu_${m2.id}" href="javascript:addTabs({id:'${m2.id}',title: '${m2.name}',close: true,url: '${m2.url}'});">
								<i class="${m2.icon}"></i>
								<span class="menu-text">${m2.name}</span>
							</a>
						</li>
					</c:forEach>
				</ul>
			</li>
		</c:otherwise>
	</c:choose>
</c:forEach>