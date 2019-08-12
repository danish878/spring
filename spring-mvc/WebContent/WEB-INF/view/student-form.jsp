<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Student Registration Form</title>
    </head>
    <body>
        <form:form action="processForm" modelAttribute="student">
            First Name: <form:input path="firstName"/>
            Last Name: <form:input path="lastName"/>
            <br>
            <form:select path="country">
                <form:options items="${student.countryOptions}"/>
            </form:select>

            <br>
            Favourite Language:

            <form:radiobutton path="favouriteLanguage" value="Java"/>Java
            <form:radiobutton path="favouriteLanguage" value="C#"/>C#
            <form:radiobutton path="favouriteLanguage" value="PHP"/>PHP
            <form:radiobutton path="favouriteLanguage" value="Ruby"/>Ruby

            <br>
            Operating Systems:

            <form:checkbox path="operatingSystems" value="Linux"/>Linux
            <form:checkbox path="operatingSystems" value="Mac OS"/>Mac OS
            <form:checkbox path="operatingSystems" value="MS Windows"/>MS Windows

            <br>

            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>