<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.todo.dto.UserTasks" %>
<%@ page import="com.todo.util.ModelAttributeNames" %>
<%@ page import="com.todo.util.MappingConstants" %>
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

        <c:url var="ADD" value="${MappingConstants.TASKADD}">
            <c:param name="userid" value="${userid}" />
        </c:url>
     <div class="header">
        An Spring MVC example for TODO list
     </div>

     <div class="mainContainer">
            <div class="row" style="margin-top:1%">
                <div class="col-sm-1"></div>
                <div class="col-sm-9 data-window">

                    <div class="row data-row">
                        <div class="col-sm-1"></div>
                        <div class="col-sm-8 todo-caption">
                                  Todo Items
                        </div>
                        <div class="col-sm-3" style="text-align: right; padding:0px">
                            <a href="${ADD}" class="btn btn-primary"> Add task</a>
                        </div>
                    </div>
                </div>
             </div>
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-4 table-heading "><h4>Title<h4></div>
                <div class="col-sm-2 table-heading "><h4>Deadline<h4></div>
                <div class="col-sm-1"></div>
                <div class="col-sm-1"></div>
                <div class="col-sm-2"></div>
            </div>
            <c:forEach items="${tasks}" var="task">
                <c:url var="modify" value="${MappingConstants.TASKADD}">
                   <c:param name="userid" value="${userid}" />
                   <c:param name="taskid" value="${task.id}" />
                </c:url>
                <c:url var="delete" value="${MappingConstants.TASKDELETE}">
                   <c:param name="userid" value="${userid}" />
                   <c:param name="taskid" value="${task.id}" />
                </c:url>
                <div class="row">
                    <div class="col-sm-2"></div>
                   <div class="col-sm-4 data-col"><c:out value="${task.taskName}" /></div>
                   <div class="col-sm-2 data-col"><c:out value="${task.dueDate}" /></div>

                   <div class="col-sm-1 action-col">
                       <a href="${modify}" class="far fa-edit" style="color: limegreen;"> </a>
                       <a href="${delete}" class="fas fa-trash-alt" style="color:red"></a>
                    </div>
                   <div class="col-sm-3"></div>
                </div>
            </c:forEach>
            </div>
    </body>
</html>
