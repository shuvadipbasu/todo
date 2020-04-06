package com.todo.service.impl;

import com.todo.dto.TodoDTO;
import com.todo.dto.User;
import com.todo.repo.UserTaskRepo;
import com.todo.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserTaskServiceImpl implements UserTaskService {

    @Autowired
    UserTaskRepo userTaskRepo;

    @Override
    public List<TodoDTO> getUserTasks(User user) {
        try{
            return userTaskRepo.getUserTasks(user);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<User, List<TodoDTO>> getAllUserTasks() {
        return null;
    }

    @Override
    public boolean addUserTask(User user, TodoDTO todoDTO) {
        try {
            userTaskRepo.addUserTask(user, todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean removeUserTask(User user, TodoDTO todoDTO) {
        userTaskRepo.removeUserTask(user,todoDTO);
        return false;
    }
}
