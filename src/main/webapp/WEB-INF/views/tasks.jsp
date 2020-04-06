<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.todo.dto.UserTasks" %>
<%@ page import="com.todo.util.ModelAttributeNames" %>
<%@ page import="com.todo.util.MappingConstants" %>
<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>

        <c:url var="ADD" value="${MappingConstants.TASKADD}">
            <c:param name="userid" value="${userid}" />
        </c:url>


        <a href="${ADD}"> Add task</a>
        <table>
            <caption><h2>Todo Items</h2></caption>
            <tr>
                <th>Title</th>
                <th>Deadline</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${tasks}" var="task">
                <c:url var="modify" value="${MappingConstants.TASKADD}">
                   <c:param name="userid" value="${userid}" />
                   <c:param name="taskid" value="${task.id}" />
                </c:url>
                <c:url var="delete" value="${MappingConstants.TASKDELETE}">
                   <c:param name="userid" value="${userid}" />
                   <c:param name="taskid" value="${task.id}" />
                </c:url>
                <tr>
                   <td><c:out value="${task.taskName}" /></td>
                   <td><c:out value="${task.dueDate}" /></td>

                   <td><a href="${modify}"> Modify</a></td>
                   <td><a href="${delete}">delete</td>
                </tr>
            </c:forEach>
         </table>
    </body>
</html>
