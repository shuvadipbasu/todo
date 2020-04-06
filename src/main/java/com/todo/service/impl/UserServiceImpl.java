package com.todo.service.impl;

import com.todo.dto.User;
import com.todo.repo.UserRepository;
import com.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    UserRepository userRepositoryImpl;

    @Autowired
    public UserServiceImpl(UserRepository userRepositoryImpl) {
        this.userRepositoryImpl = userRepositoryImpl;
    }

    @Override
    public boolean createUser(User user) {
        return userRepositoryImpl.createUser(user);
    }

    @Override
    public User getUserDetails(final String userId) {

        return userRepositoryImpl.getUserDetails(userId);
    }

    @Override
    public Set<User> getAllUser() {
        return userRepositoryImpl.getAllUser();
    }

    @Override
    public boolean deleteAUser(User user) {
        return userRepositoryImpl.deleteAUser(user);
    }
}
