<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <table class="table table-striped">
        <caption><spring:message code="todo.caption"/></caption>
        <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Completed?</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.desc}</td>
                    <td><fmt:formatDate pattern="dd/MM/yyyy"
                                        value="${todo.targetDate}"/></td>
                    <td>${todo.done}</td>
                    <td><a class="btn btn-success"
                           href="/update-todo?id=${todo.id}">Update</a> <a
                            class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <a class="btn btn-primary" href="add-todo">Add</a>
    </div>

</div>

<%@ include file="common/footer.jspf" %>