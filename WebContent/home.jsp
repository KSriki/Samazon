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
</style>
</head>
<body>

	<div class="jumbotron">
		<div class="container text-center">
			<h1>Samazon Online Store</h1>
			<p>Mission, Vission & Values</p>
		</div>
	</div>

	<jsp:include page="navbar.jsp"/>


	<div class="container" >
		<c:forEach var="product" items="${products}">

			<div class="col-md-4" >
				<div class="panel panel-primary" >
					<div class="panel-heading " >
						<c:out value="${product.productname}" />
					</div>
					<div class="panel-body" >
						
						<a href=""><img src="${product.image }" class="img-responsive" alt="Image"></a>

						<div class="col-md-4 inner">
							<c:out value="${product.productdesc}" />
						</div>
						<div class="col-md-4 inner">
							$<c:out value="${product.price}" />
						</div>
						<div class="col-md-4 inner">
							<c:out value="${product.productcount}" /> Count
						</div>



					</div>
				</div>

			</div>

		</c:forEach>
	</div>


	<footer class="container-fluid text-center">
	<p>Online Store Copyright</p>
	<form class="form-inline">
		Get deals: <input type="email" class="form-control" size="50"
			placeholder="Email Address">
		<button type="button" class="btn btn-danger">Sign Up</button>
	</form>
	</footer>

</body>
</html>