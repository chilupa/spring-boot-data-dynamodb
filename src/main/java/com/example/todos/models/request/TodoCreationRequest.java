package com.example.todos.models.request;

import lombok.Data;

@Data
public class TodoCreationRequest {
    private String title;
    private Boolean completed;
}
