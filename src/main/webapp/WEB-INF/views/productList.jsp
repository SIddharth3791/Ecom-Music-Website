<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<!-- CONTAINER Start -->

<div class="container-wrapper">
	<div class ="container">
		<div class = "page-header">
		<h1>All Products</h1>
		
		<p class = "lead">Check-out our all new awesome products available !!!!</p>
		</div>
		
		<table class = "table table=striped table=hover">
			<thaed>
				<tr class ="bg-success">
					<th>Photo Thumb</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Condition</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thaed>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><img src = "#" alt = "image" /></td>
					<td>${product.productName}</td>
					<td>${product.productCategory}</td>
					<td>${product.productCondition}</td>
					<td>${product.productPrice} USD</td>
					<td><a href="<spring:url value="/productList/viewProduct/${product.productId}" />"><span class="glyphicon glyphicon-info-sign"></span></a></td>
				</tr>
			</c:forEach>
		</table>
    <%@include file ="/WEB-INF/views/template/footer.jsp" %>