<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Student Confirmation</title>
    </head>
    <body>
        The student is confirmed: ${student.firstName} ${student.lastName}
        <br>
        Country: ${student.country}
        <br>
        Favorite Language: ${student.favouriteLanguage}
        <br>
        Operating Systems:
        <ul>
            <c:forEach var="country" items="${student.operatingSystems}">
            <li>${country}
                </c:forEach>
        </ul>
    </body>
</html>