<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>List Customers</title>
        <link type="text/css" rel="stylesheet"
              href="${pageContext.request.contextPath}/resources/css/style.css"/>

    </head>
    <body>

        <div id="wrapper">
            <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
            </div>
        </div>

        <div id="container">
            <div id="content">

                <!-- Add Customer Button -->
                <input type="button" value="Add Customer" class="add-button"
                       onclick="window.location.href='showFormForAdd'; return false;"/>

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                    </tr>

                    <!-- loop over and print customers -->
                    <c:forEach var="customer" items="${customers}">

                        <!-- construct an update link with customer id -->
                        <c:url var="updateLink" value="/customer/showFormForUpdate">
                            <c:param name="customerId" value="${customer.id}"></c:param>
                        </c:url>

                        <!-- construct a delete link with customer id -->
                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${customer.id}"></c:param>
                        </c:url>

                        <tr>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.email}</td>
                            <td><a href="${updateLink}">Update</a> | <a
                                    href="${deleteLink}"
                                    onclick="if( !confirm('Are you sure you want to delete this customer?') ) return false;">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
    </body>
</html>