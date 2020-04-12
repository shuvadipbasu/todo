<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.todo.dto.UserTasks" %>
<%@ page import="com.todo.util.ModelAttributeNames" %>
<html>
    <head>
        <title>Welcome</title>
        <meta charset="utf-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1">
                  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
                  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
                  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
                  <script src='https://kit.fontawesome.com/a076d05399.js'></script>
                   <link type="text/css"
                            rel="stylesheet"
                            href="${pageContext.request.contextPath}/resources/css/todo.css">

    </head>
    <body>
        <div class="header">
                An Spring MVC example for TODO list
         </div>
         <div class="mainContainer">

        <table>

            <form:form method="POST" modelAttribute="${ModelAttributeNames.TODO_ATTR}">
                <div class="card card-main">
                        <div class="card-header custom-header">Add An Task</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3 label-style"><label>ID</label></div>
                                <div class="col-sm-6 input-style">
                                    <form:input path="id" readonly="true"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3 label-style" style="padding-buttom:5px"><label>Title</label></div>
                                <div class="col-sm-6 ">
                                    <form:textarea path="taskName" type="text"/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3 label-style"><label>Due Date</label></div>
                                <div class="col-sm-6 input-style">
                                    <form:input path="dueDate" type="date"/>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer custom-footer">
                            <input type="submit" class="btn btn-primary" value="Submit"/>
                        </div>
                      </div>
                 </div>
            </form:form>
         </table>
    </body>
</html>