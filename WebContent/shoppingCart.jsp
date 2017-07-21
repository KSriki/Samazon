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


<c:forEach var="samitem" items="${cartitem}">

							user <c:out value="${samitem.samuser.useremail}" /> <br />
							
							
							purchase date <c:out value="${samitem.purchasedate }" /> <br />

							quantity <c:out value="${samitem.quantity}" /><br/>
							
							price <c:out value="${samitem.price}" /><br/>
							
							list <c:out value="${samitem.list}" />
				
		</c:forEach>



</body>
</html>