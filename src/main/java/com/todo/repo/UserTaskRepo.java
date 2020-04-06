package com.todo.repo;

import com.todo.dto.TodoDTO;
import com.todo.dto.User;

import java.util.List;
import java.util.Map;

public interface UserTaskRepo {
    public List<TodoDTO> getUserTasks(User user) throws Exception;
    public Map<User, List<TodoDTO>> getAllUserTasks() throws Exception;
    public boolean addUserTask(User user, TodoDTO todoDTO) throws Exception;
    public boolean removeUserTask(User user, TodoDTO todoDTO);
}
