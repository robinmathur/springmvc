<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label>${employee.empName}</label>
	<a href="<c:url value="user_logout" />">logout</a>
	<sec:authorize access="segment('testSegment')">
		<p>Hello Admin permission</p>
	</sec:authorize>
	<sec:authorize access="segment('testSegmentsdsd')">
		<p>Hello Normal User permission</p>
	</sec:authorize>
	<p>${test}</p>
</body>
</html>