<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- start navbar here -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="include.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Page</title>
</head>
<body>

<jsp:include page="navbar.jsp"/>

<br />
<img src="<c:out value="${prod.image}"/>" /> <br />

<c:out value="${prod.productname}"/> <br />

<c:out value="${prod.productcount}" /> <br />

<c:out value="${prod.price }" /> <br />

<c:out value="${prod.productdesc}" /> <br /> <br />


</body>
</html>