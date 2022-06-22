package com.example.todos.exceptions;

import com.example.todos.exceptions.config.GlobalErrorCode;

public class EntityNotFoundException extends GlobalException{
    public EntityNotFoundException(){
        super("Entity Not Found", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND);
    }
    public EntityNotFoundException(String message, Long code) {
        super(message, code);
    }
}
