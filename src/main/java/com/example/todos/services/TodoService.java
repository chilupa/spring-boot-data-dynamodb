package com.example.todos.services;

import com.example.todos.exceptions.EntityNotFoundException;
import com.example.todos.models.Todo;
import com.example.todos.models.request.TodoCreationRequest;
import com.example.todos.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo createTodo (TodoCreationRequest request) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(request, todo);
        return todoRepository.save(todo);
    }

    public Iterable<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void deleteTodo(String id) {
         todoRepository.deleteById(id);
    }

    public Todo updateTodo(String id, TodoCreationRequest todoCreationRequest) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isPresent()) {
            throw new EntityNotFoundException();
        }
        Todo todo = optionalTodo.get();
        todo.setTitle(todoCreationRequest.getTitle());
        todo.setCompleted(todoCreationRequest.getCompleted());
        return todoRepository.save(todo);
    }

}
