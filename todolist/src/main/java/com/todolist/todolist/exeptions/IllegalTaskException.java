package com.todolist.todolist.exeptions;

public class IllegalTaskException extends RuntimeException{

    public IllegalTaskException(String errorMessage) {
        super(errorMessage);
    }
}
