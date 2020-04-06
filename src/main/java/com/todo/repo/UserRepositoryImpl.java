package com.todo.repo;

import com.todo.dto.User;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository{
    Set<User> allUsers;

    public UserRepositoryImpl() {
        this.allUsers = new HashSet<>();
        allUsers.add(new User("1","defaule","user"));
    }

    @Override
    public boolean createUser(User user) {
        return allUsers.add(user);
    }

    @Override
    public User getUserDetails(final String userId) {

        return allUsers.stream().
                filter(u->u.getUserId().equals(userId))
                .findAny().get();
    }

    @Override
    public Set<User> getAllUser() {
        return allUsers;
    }

    @Override
    public boolean deleteAUser(User user) {
        return allUsers.remove(user);
    }
}
