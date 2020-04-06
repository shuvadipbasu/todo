package com.todo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Data
@Setter
@Getter
public class UserTasks {
    User user;
    Set<TodoDTO> todos;
}
