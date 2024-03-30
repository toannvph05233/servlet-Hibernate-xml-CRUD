<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="page-header">Product detail</div>
<div class="products">
	<div class="col-4">
		<img src="images/${product.imageUrl}" width="300">
	</div>
	<div class="col-8">
		<h2>${product.title}</h2>
		<p>ISBN: <b>${product.isbn}</b></p>
		<p>Pages: <b>${product.pages}</b></p>
		<p>Price: <b>${product.price}</b></p>
		<form method="post" action="index.html">
			<input type="hidden" value="${product.productId}" name="productId"  >
			<input type="number" name="quantity" value="1">
			<button class="btn btn-primary">Add to Cart</button>
		</form>
	</div>
</div>