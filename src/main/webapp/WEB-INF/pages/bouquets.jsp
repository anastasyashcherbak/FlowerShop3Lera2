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
    <title>Bouquets</title>
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


<div>
    <h1>List Bouquets:</h1>
    <table>
        <c:forEach items="${bouquets}" var="bouquet">
            <tr>
                <td>
                <a href="<c:url value="/flowerBank/get/${bouquet.id}"/>">
                    <c:out value="${bouquet.name}"/>
                </a>
                </td>
                <td>
                <a href="<c:url value="/bouquets/edit/${bouquet.id}"/>">
                    <c:out value="Edit"/>
                </a>
                </td>
            </tr>
            <br/>
        </c:forEach>
    </table>
    <tr/>
</div>

<div>
    <h1>Add bouquet:</h1>
    <sf:form name="f" method="POST" modelAttribute="bouquet">
            <sf:label path="name">Name: </sf:label>
            <sf:input path="name" id="name"/>
            <br/>

            <input name="commit" type="submit" value="Save" />
    </sf:form>
</div>

</body>
</html>
