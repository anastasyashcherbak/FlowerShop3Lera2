<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: panser
  Date: 4/28/14
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Spring Security Login Page</title>
</head>
<body onload="document.f.username.focus();">

<c:if test="${not empty param.login_error}">
    <font color="red"> Login Error. <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/> </font>
</c:if>

<c:url var="authUrl" value="/j_spring_security_check" />
<form name="f" method="post" class="signin" action="${authUrl}">
    <table>
        <tr>
            <td align="right">Login: </td>
            <td><input id="username" type="text" name="j_username" /></td>
        </tr>
        <tr>
            <td align="right">Password: </td>
            <td><input type="password" name="j_password" /></td>
        </tr>
        <tr>
            <td align="right">Don't ask for my password for two weeks </td>
            <td><input type="checkbox" name="_spring_security_remember_me" /></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="Login" />
                <a href="<c:url value="/user/register"/> ">Register</a>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
