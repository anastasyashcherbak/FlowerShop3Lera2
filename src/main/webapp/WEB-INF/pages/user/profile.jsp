<%@ page session="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
</head>

<body onload="document.f.login.focus();">
<div id="container">
    <sf:form name="f" method="POST" modelAttribute="user">
        <sf:input type="hidden" path="id" id="id"/>

        <sf:label path="username">username: </sf:label>
        <sf:input path="username" id="username" name="username" />
        <sf:errors path="username"/>
        <p/>
        <sf:label path="password">password</sf:label>
        <sf:password path="password" showPassword="true" id="password"/>
        <sf:errors path="password"/>
        <p/>
        <sf:label path="role">role: </sf:label>
        <sf:input path="role" id="role" name="role" />
        <sf:errors path="role"/>
        <p/>

        <input name="commit" type="submit" value="save" />
        <input type="button" class="back-button" onclick="history.back();" value="back" />
        <security:csrfInput />
    </sf:form>


</div>

</body>
</html>