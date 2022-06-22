package com.example.todos.exceptions;


public class GlobalException extends  RuntimeException{

    private Long code;

    public GlobalException(String message, Long code){
        super(message);
        this.code = code;
    }
}
