<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Simple Spring Security</title>
    </head>
    <body>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome : ${pageContext.request.userPrincipal.name} |
                <c:url value="/customlogout" var="logOutUrl"/>
                <form:form method="post" action="${logOutUrl}">
                    <input type="submit" value="Logout"/>
                </form:form>
            </h2>
            <p>Your Session id is: "${pageContext.request.session.id}"</p>

            <sec:authorize access="isRememberMe()">
                <p>Remember Me Login</p>
            </sec:authorize>

            <sec:authorize access="isFullyAuthenticated()">
                <p>Full Authentication</p>
            </sec:authorize>

            <a href="${pageContext.request.contextPath}/chief/updateProfile">Only Chief Update Profile</a>
        </c:if>

    </body>
</html>