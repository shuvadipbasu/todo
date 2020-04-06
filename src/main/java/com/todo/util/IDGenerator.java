package com.todo.util;

public class IDGenerator {
    private static int taskId=1, userId=1;

    private IDGenerator(){}

    public static int getNextTaskId(){
        taskId++;
        return taskId;
    }

    public static String getNextUserId(){
        userId++;
        return String.valueOf(userId);
    }
}
