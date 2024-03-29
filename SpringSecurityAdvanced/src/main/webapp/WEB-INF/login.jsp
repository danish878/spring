<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<head>
    <title>Login</title>
</head>
<body>
    <p><s:message code="label.welcome"/></p>
    <c:url value="/login" var="loginUrl"/>
    <form:form name="form" action="${loginUrl}" method="post">

        <c:if test="${param.error != null}">
            Invalid username and password.
        </c:if>
        <table>
            <tr>
                <td><label for="username"><s:message code="label.username"/></label></td>
                <td><input type="text" id="username" name="username"
                           value="${username}"/></td>
            </tr>
            <tr>
                <td><label for="password"><s:message code="label.password"/></label></td>
                <td><input type="password" id="password" name="password"/></td>
            </tr>
            <tr>
                <td>Remember Me:</td>
                <td><input type="checkbox" name="remember-me"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="log In"/></td>
            </tr>
        </table>
        <%--
            Section 2 - Video 2.4 - CSRF
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
        <!-- <sec:csrfInput/> -->
    </form:form>
</body>
</html>