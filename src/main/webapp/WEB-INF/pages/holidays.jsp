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
    <h1>List Holidays:</h1>
    <table>
        <c:forEach items="${holidays}" var="holiday">
            <tr>
                <td>
                <a href="<c:url value="/bouquets/get/${holiday.id}"/>">
                    <c:out value="${holiday.description}"/>
                </a>
                </td>
                <td>
                <a href="<c:url value="/bouquets/get/${holiday.id}"/>">
                    <c:out value="${holiday.date}"/>
                </a>
                </td>
                <td>
                    <a href="<c:url value="/holidays/edit/${holiday.id}"/>">
                        <c:out value="Edit"/>
                    </a>
                </td>
                <td>
                    <a href="<c:url value="/holidays/delete/${holiday.id}"/>">
                        <c:out value="Delete"/>
                    </a>
                </td>

            </tr>
        </c:forEach>
    </table>
    <tr/>


    <h1>Add Holiday:</h1>
    <div>
        <sf:form name="f" method="POST" modelAttribute="newHoliday">
            <fieldset>
                <sf:label path="date">Holiday date: </sf:label>
                <sf:input path="date" id="date"/>
                <p/>
                <sf:label path="description">Holiday description: </sf:label>
                <sf:input path="description" id="description"/>
                <p/>
                <br/>

                <input name="commit" type="submit" value="Save" />
            </fieldset>
        </sf:form>

    </div>

</code>
</body>
</html>
