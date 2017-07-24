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
<title>Confirmation Page</title>
</head>
<body>

	<jsp:include page="navbar.jsp" />
	<c:out value="${total}"/>
	<c:out value="${user.address}"/>

</body>
</html>

