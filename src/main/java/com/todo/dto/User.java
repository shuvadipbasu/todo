package com.todo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Data
@Getter
@Setter
public class User {
    private String userId;
    private String fname;
    private String lname;

    public User(String userId, String fname, String lname) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) &&
                fname.equals(user.fname) &&
                lname.equals(user.lname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, fname, lname);
    }
}
