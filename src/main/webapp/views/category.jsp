<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<ul>
	<c:forEach items="${categoryParents}" var="c">
		<c:if test="${true}">
			<li>${c.getCategoryName()}</li>
			<ul class="category">
				<c:forEach items="${c.getParent()}" var="p">
					<c:if test="${param.categoryId == p.categoryId}">
						<li><a style="background: #10707f" href="browse.html?categoryId=${p.categoryId}" class="${p.categoryId eq child.id?"active":""}"> ${p.categoryName}</a></li>
					</c:if>
					<c:if test="${param.categoryId != p.categoryId}">
						<li><a href="browse.html?categoryId=${p.categoryId}" class="${p.categoryId eq child.id?"active":""}"> ${p.categoryName}</a></li>
					</c:if>

				</c:forEach>
			</ul>
		</c:if>
	</c:forEach>
</ul>
