<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
        <style>
            .failed {
                color: red;
            }
        </style>
    </head>
    <body>
        <h2>My Customer Login Page</h2>

        <form:form action="${pageContext.request.contextPath}/authenticateTheUser">

            <!-- Check for login error -->
            <c:if test="${param.error != null}">
                <i class="failed">Sorry! You entered invalid username or password!</i>
            </c:if>
            <p>
                Username: <input type="text" name="username"/>
            </p>
            <p>
                Password: <input type="password" name="password"/>
            </p>

            <input type="submit" value="Login"/>
        </form:form>
    </body>
</html>