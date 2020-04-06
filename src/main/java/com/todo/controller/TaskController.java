package com.todo.controller;

import com.todo.dto.TodoDTO;
import com.todo.dto.User;
import com.todo.service.UserService;
import com.todo.service.UserTaskService;
import com.todo.util.IDGenerator;
import com.todo.util.MappingConstants;
import com.todo.util.ModelAttributeNames;
import com.todo.util.PageNamesConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class TaskController {

    String defaultUserId = "1";

    @Autowired
    UserService userService;

    @Autowired
    UserTaskService userTaskService;


    @GetMapping(MappingConstants.TASKS)
    public String taskes(@RequestParam("userid") String userid, Model model){
        userid=defaultUserId;


        User user = userService.getUserDetails(userid);
        List<TodoDTO> todos = userTaskService.getUserTasks(user);
        log.info("######### todos :{}, size:{}",todos,todos.size());
        log.debug("######### todos :{}",todos, todos.size());
       model.addAttribute(ModelAttributeNames.TASK_LIST, todos);
       model.addAttribute(ModelAttributeNames.USER_ID_ATTR, userid);
       return PageNamesConstants.TASKLIST_PAGE;
    }

    @PostMapping(MappingConstants.TASKADD)
    public String processTasks(@ModelAttribute(ModelAttributeNames.TODO_ATTR) TodoDTO todoDTO,
                               @ModelAttribute(ModelAttributeNames.USER_ID_ATTR) String userId){
        if (todoDTO.getId()==0){
            todoDTO.setId(IDGenerator.getNextTaskId());
            userTaskService.addUserTask(userService.getUserDetails(userId),todoDTO);
        }else{
            TodoDTO taskToModify = userTaskService.getUserTasks(userService.getUserDetails(userId))
                    .stream().filter(t->t.getId() == todoDTO.getId())
                    .findFirst().get();
            userTaskService.removeUserTask(userService.getUserDetails(userId), taskToModify);
            userTaskService.addUserTask(userService.getUserDetails(userId),todoDTO);

        }
        return "redirect:/"+ PageNamesConstants.TASKLIST_PAGE;
    }

    @GetMapping(MappingConstants.TASKADD)
    public String addTasks(@RequestParam("userid") String userId,
                           @RequestParam(name = "taskid",required = false, defaultValue = "-1") String taskId,
                           Model model){
        TodoDTO todoDTO;
        if (!taskId.equals("-1") && !taskId.isEmpty()){
            todoDTO = userTaskService.getUserTasks(userService.
                    getUserDetails(userId)).stream().filter(t->t.getId()==Integer.parseInt(taskId))
                    .findFirst().get();
        }else{
            todoDTO= new TodoDTO();
            todoDTO.setId(0);
        }
        model.addAttribute(ModelAttributeNames.TODO_ATTR, todoDTO);
        model.addAttribute(ModelAttributeNames.USER_ID_ATTR, userId);
        return PageNamesConstants.TASKADD_PAGE;
    }

    @GetMapping(MappingConstants.TASKDELETE)
    public String delTask(@RequestParam("userid") String userid, @RequestParam("taskid") String taskId, Model model){
        TodoDTO task = userTaskService.getUserTasks(userService.
                getUserDetails(userid)).stream().filter(t->t.getId()==Integer.parseInt(taskId))
                .findFirst().get();
        userTaskService.removeUserTask(userService.getUserDetails(userid), task);
        return "redirect:/"+ MappingConstants.TASKS+"?userid="+userid;
    }
}
