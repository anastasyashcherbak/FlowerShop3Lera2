<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title></title>
</head>
<body>


<ul>
    <li><a href="${pageContext.request.contextPath}/holidays/list" >/holidays/list</a></li>
    <security:authorize url="/user/profile">
        <li><a href="${pageContext.request.contextPath}/user/profile" > Profile</a></li>
    </security:authorize>
</ul>


</body>
</html>
