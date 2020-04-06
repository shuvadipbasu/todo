package com.todo.repo;

import com.todo.dto.User;

import java.util.Set;

public interface UserRepository {
    public boolean createUser(User user);
    public User getUserDetails(String userId);
    public Set<User> getAllUser();
    public boolean deleteAUser(User user);
}
