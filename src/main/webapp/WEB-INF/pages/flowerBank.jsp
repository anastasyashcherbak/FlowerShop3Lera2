<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div id="container">
    <span style="float: right">
        <security:authorize access="!isAuthenticated()">
            <c:url value="/user/login" var="url"/>
            <a href="<c:out value='${url}'/>">
                Login
            </a>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <p>
                Hello <security:authentication property="principal.username" />,
            </p>
            <p>
                <a href="javascript:formSubmit()">
                    LogOut
                </a>
                <script>
                    function formSubmit() {
                        document.getElementById("logoutForm").submit();
                    }
                </script>
                <c:url value="/logout" var="logoutUrl" />
            <form action="${logoutUrl}" method="post" id="logoutForm">
            </form>
            </p>
        </security:authorize>
        <security:authorize url="/user/profile">
            <a href="${pageContext.request.contextPath}/user/profile" > Profile</a>
        </security:authorize>

    </span>
</div>


<code>
    <h1>List FlowerBanks:</h1>
    <table>
        <c:forEach items="${flowerBanks}" var="flowerBank">
            <tr>
                <td><c:out value="${flowerBank.count}"/> </td>
                <td><c:out value="${flowerBank.flower.name}"/> </td>
                <td><c:out value="${flowerBank.flower.color}"/> </td>
                <td>
                <a href="<c:url value="/flowerBank/edit/${flowerBank.id}"/>">
                    <c:out value="Edit"/>
                </a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <tr/>

    <h1>Add Flower:</h1>
    <div>
        <form action="" method="post">
            <fieldset>
                <%--<input type="hidden" path="flower.id" id="flower.id"/>--%>
                <%--<input type="hidden" path="flowerBank.id" id="flowerBank.id"/>--%>
<%--
                <spring:bind path="flower.id">
                    <input type="hidden" name="${status.expression}" value="${status.value}"><br />
                </spring:bind>
--%>
                <spring:bind  path="flowerBank.id">
                    <input type="hidden" name="${status.expression}" value="${status.value}"><br />
                </spring:bind>

                <spring:bind path="flower.name">
                    <label path="flower.name">Flower Name: </label>
                    <input type="text" name="${status.expression}" value="${status.value}"><br />
                </spring:bind>
                <spring:bind path="flower.color">
                    <label path="flower.color">Flower color: </label>
                    <input type="text" name="${status.expression}" value="${status.value}"><br />
                </spring:bind>
                <spring:bind path="flowerBank.count">
                    <label path="flowerBank.count">Count: </label>
                    <input type="text" name="${status.expression}" value="${status.value}"><br />
                </spring:bind>

                <input name="commit" type="submit" value="Save" />
            </fieldset>
        </form>
    </div>
</code>
</body>
</html>
