package com.todo.service;

import com.todo.dto.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    public boolean createUser(User user);
    public User getUserDetails(String userId);
    public Set<User> getAllUser();
    public boolean deleteAUser(User user);
}
