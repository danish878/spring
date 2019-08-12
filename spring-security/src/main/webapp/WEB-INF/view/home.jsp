<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Home</title>
    </head>
    <body>
        Welcome Home
        <hr>

        <!-- display user name and role -->
        <p>
            User:
            <security:authentication property="principal.username"/>
            <br> <br> Role(s):
            <security:authentication property="principal.authorities"/>
        </p>

        <hr>

        <security:authorize access="hasRole('MANAGER')">
            <!-- Add a link to point to /leaders ... this is for the managers -->
            <p>
                <a href="${pageContext.request.contextPath}/leaders">Leadership
                    Meeting</a> Only for Manager peeps
            </p>
        </security:authorize>
        <hr>

        <security:authorize access="hasRole('ADMIN')">
            <!-- Add a link to point to /systems ... this is for the admins -->
            <p>
                <a href="${pageContext.request.contextPath}/systems">IT Systems
                    Meeting</a> Only for Admin peeps
            </p>
        </security:authorize>
        <hr>

        <!-- Logout button -->
        <form:form method="POST"
                   action="${pageContext.request.contextPath}/logout">
            <input type="submit" value="Logout"/>
        </form:form>
    </body>
</html>