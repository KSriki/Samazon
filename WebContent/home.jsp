<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Welcome to Samazon!</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<jsp:include page="include.jsp" />
<style>
/* Remove the navbar's default rounded borders and increase the bottom margin */
.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}

/* Remove the jumbotron's default bottom margin */
.jumbotron {
	margin-bottom: 0;
}

/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.col1 {
	position: absolute;
	left: 5px;
	padding: 0px;
}

.col2 {
	position: absolute;
	margin-left: 100px;
	padding: 0px;
}

.col3 {
	margin-left: 200px;
	padding: 0px;
}
</style>
</head>
<body>
	<c:if test="${AddCart != null}">
		<script>
			var sent = "${AddCart}";

			alert(sent);
		</script>
	</c:if>
	<div class="jumbotron">
		<div class="container text-center">
			<h1>Samazon Online Store</h1>
			<p>Mission, Vission & Values</p>
		</div>
	</div>

	<jsp:include page="navbar.jsp" />

	<c:forEach var="product" items="${products}" varStatus="loop">
		<div class="row row-eq-height">

			<div class="container">

				<div class="col-md-3 inner">
					<a href="ProductServlet?productid=${product.productid}"><img
						src="${product.image}" class="img-responsive" alt="Image"></a>

				</div>
				<div class="col-md-3 inner">
					$
					<c:out value="${product.price}" />
				</div>
				<div class="col-md-3 inner">
					<c:out value="${product.productcount}" />
					Count
				</div>

				<div class="col-md-3 inner">

				
					
					<form action="EditCart" method="post">
					
						Quantity: <input type="number" value="1" name="Quantity" />
								<input type="hidden" name="productname" value="${product.productid}" />
									<input type="hidden" name="list" value="CART" />
								<input type="submit" class="glyphicon glyphicon-shopping-cart" value="Add to Cart"> <span
						class="glyphicon glyphicon-shopping-cart"></span> </input>
			
					</form>
					


				</div>

			</div>




		</div>

	</c:forEach>

	<!-- 
	<footer class="container-fluid text-center">
	<p>Online Store Copyright</p>
	<form class="form-inline">
		Get deals: <input type="email" class="form-control" size="50"
			placeholder="Email Address">
		<button type="button" class="btn btn-danger">Sign Up</button>
	</form>
	</footer>
 -->
</body>
</html>
