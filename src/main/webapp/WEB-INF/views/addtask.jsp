<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.todo.dto.UserTasks" %>
<%@ page import="com.todo.util.ModelAttributeNames" %>
<html>
    <head>
        <title>Welcome</title>
    </head>
    <body>
        <table>
            <caption><h2>Add Items</h2></caption>
            <tr>
                <th>Title</th>
                <th>Deadline</th>
            </tr>
            <form:form method="POST" modelAttribute="${ModelAttributeNames.TODO_ATTR}">
                <table>
                    <tr>
                        <td><label>ID</label></td>
                        <td>
                            <form:input path="id" readonly="true"/>
                        </td>
                    <tr>
                    <tr>
                        <td><label>Title</label></td>
                        <td>
                            <form:input path="taskName"/>
                        </td>
                    <tr>
                    <tr>
                        <td><label>Due Date</label></td>
                        <td>
                            <form:input path="dueDate"/>
                        </td>
                    <tr>
                    <tr>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                <table>
            </form:form>
         </table>
    </body>
</html>