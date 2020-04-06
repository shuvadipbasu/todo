package com.todo.dto;

import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Objects;


@Setter
@Getter
public class TodoDTO {

    private int id;
    private String taskName;
    private String dueDate;

    public TodoDTO() {
    }

    public TodoDTO(String taskName, String dueDate, int id) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoDTO todoDTO = (TodoDTO) o;
        return id == todoDTO.id &&
                taskName.equals(todoDTO.taskName) &&
                dueDate.equals(todoDTO.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, dueDate);
    }
}
