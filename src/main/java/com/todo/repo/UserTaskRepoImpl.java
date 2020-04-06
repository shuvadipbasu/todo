package com.todo.repo;

import com.todo.dto.TodoDTO;
import com.todo.dto.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserTaskRepoImpl implements UserTaskRepo {

    Map<User, List<TodoDTO>> userTasks;

    public UserTaskRepoImpl() {
        this.userTasks = new HashMap<>();
    }

    @Override
    public List<TodoDTO> getUserTasks(User user) throws Exception {
        if (user==null) throw new Exception("User is not passed");
        getDefaultTasks();
        return userTasks.get(user);
    }

    @Override
    public Map<User, List<TodoDTO>> getAllUserTasks() throws Exception {

        return userTasks;
    }

    @Override
    public boolean addUserTask(User user, TodoDTO todoDTO) throws Exception {
        if (user==null) throw new Exception("User is not passed");
        if (userTasks.isEmpty() || userTasks.get(user)==null)
             userTasks.put(user, Arrays.asList(todoDTO));
        else
            userTasks.get(user).add(todoDTO);

        return true;
    }

    @Override
    public boolean removeUserTask(User user, TodoDTO todoDTO) {

        userTasks.get(user).remove(todoDTO);
        return false;
    }

    private void getDefaultTasks(){
        if (userTasks.size()==0){
            List<TodoDTO> todos = new ArrayList<>();
            TodoDTO todoDTO = new TodoDTO("Sample Task","10/10/2020",1);
            todos.add(todoDTO);
            userTasks.put(new User("1","defaule","user"),todos);
        }
    }
}
