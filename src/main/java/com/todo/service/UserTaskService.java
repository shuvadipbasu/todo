package com.todo.service;

import com.todo.dto.TodoDTO;
import com.todo.dto.User;

import java.util.List;
import java.util.Map;

public interface UserTaskService {

    public List<TodoDTO> getUserTasks(User user);
    public Map<User, List<TodoDTO>> getAllUserTasks();
    public boolean addUserTask(User user, TodoDTO todoDTO);
    public boolean removeUserTask(User user, TodoDTO todoDTO);

}
