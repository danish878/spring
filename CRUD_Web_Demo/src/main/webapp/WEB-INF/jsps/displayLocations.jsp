<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Display Locations</title>
    </head>
    <body>
        <h1>All Locations:</h1>
        <div style="color: red">${del}</div>
        <div style="color: red">${msg}</div>
        <table>
            <thead>
                <td>id</td>
                <td>code</td>
                <td>name</td>
                <td>type</td>
            </thead>
            <tbody>
                <c:forEach items="${locs}" var="location">
                    <tr>
                        <td>${location.id}</td>
                        <td>${location.name}</td>
                        <td>${location.code}</td>
                        <td>${location.type}</td>
                        <td>
                            <a href="editLocation?id=${location.id}">Edit</a>
                        </td>
                        <td>
                            <a href="deleteLocation?id=${location.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="showCreate">Add Location</a>
        <a href="generateReport">Report</a>
    </body>
</html>