<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Shopping Cart</title>
</head>
<body>
<jsp:include page="include.jsp" />

<jsp:include page="navbar.jsp"/>

<table style="border:1;">
<c:forEach var="samitem" items="${cartitem}">

							<tr>
							<td>
							user <c:out value="${samitem.samuser.useremail}" /> <br />
							
							</td>
							
							<td>
							purchase date <c:out value="${samitem.purchasedate }" /> <br />

							</td>
							
							<td>
							quantity <c:out value="${samitem.quantity}" /><br/>
							
							</td>
							
							<td>
							price <c:out value="${samitem.price}" /><br/>
							
							</td>
							
							<td>
							list <c:out value="${samitem.list}" />
							
							</td>
							
							<td>
							<a href="DeleteServlet?id=${samitem.itemid}" >Remove from Cart</a>
							</td>
							
							</tr>
				
		</c:forEach>

</table>
	<br />

	<a href="ConfirmationServlet" class="btn btn-success">Checkout</a> 
</body>
</html>