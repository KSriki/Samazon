<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="include.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Purchase History</title>
</head>
<body>
	<jsp:include page="navbar.jsp" />



	<c:forEach var="samitem" items="${purchases}">
		<tr>
			<td class="col-md-4">
				<div class="media">
					<a class="thumbnail pull-left" href="#"> <img
						class="media-object" src="${samitem.product.image}"
						style="width: 72px; height: 72px;">
					</a>
					<div class="media-body">
						<h5 class="media-heading">
							<c:out value="${samitem.product.productname}" />
						</h5>
						<h5 class="media-heading">
							<c:out value="${samitem.product.productdesc}" />
						</h5>
					</div>
				</div>
			</td>
			<td class="col-md-2"><c:out value="${samitem.price}" /></td>
			<td class="col-md-2"><c:out value="${samitem.quantity}" /></td>
			<td class="col-md-2"><c:out
					value="${samitem.price * samitem.quantity}" /></td>
			<td class="col-md-2"><c:out value="${samitem.purchasedate}"/></td>
		</tr>

	</c:forEach>




</body>
</html>