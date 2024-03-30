<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mini Shop</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
</head>
<body>
	<div class="nav">
		<div class="container">
			<div class="brand"><a href="index.html">Mini Shop</a></div>
			<div class="nav-right">
				<form class="form-search" method="get" action="search.html">
					<input type="text" placeholder="Search..." name="q" >
					<button class="btn btn-primary">Search</button>
				</form>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="page">
		<div class="container">
			<div class="col-3">
				<jsp:include page="views/category.jsp"/>
			</div>
			<div class="col-9">
				<div class="page-header"></div>
				<c:choose>
					<c:when test="${param.categoryId!=null}">
						<jsp:include page="views/browse.jsp"/>
					</c:when>
					<c:when test="${param.productId!=null}">
						<jsp:include page="views/detail.jsp"/>
					</c:when>
					<c:when test="${param.q!=null}">
						<jsp:include page="views/search.jsp"/>
					</c:when>
					<c:otherwise>
						<jsp:include page="views/product.jsp"/>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>