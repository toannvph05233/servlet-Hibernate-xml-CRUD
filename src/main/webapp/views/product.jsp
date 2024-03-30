<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">Product list</div>
<div class="products">
	<c:forEach items="${products}" var="p">
		<div class="col-4">
			<div class="item">
				<img alt="Design-Patterns-in-C.jpg" src="images/${p.imageUrl}">
				<div class="info">
					<a href="detail.html?productId=${p.productId}">${p.title}</a>
				</div>
			</div>					
		</div>
	</c:forEach>
	<div class="clear"></div>
</div>
<ul class="pagination">
	<c:forEach begin="1" end="3" step="1" var="i">
		<li class="page-item">
			<a class="page-link" href="index.html">${i}</a>
		</li>
	</c:forEach>
</ul>