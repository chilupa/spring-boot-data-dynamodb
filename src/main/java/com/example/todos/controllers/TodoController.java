package com.example.todos.controllers;

import com.example.todos.constants.ApplicationConstants;
import com.example.todos.models.Todo;
import com.example.todos.models.request.TodoCreationRequest;
import com.example.todos.repository.TodoRepository;
import com.example.todos.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TodoController {

    Logger logger = LoggerFactory.getLogger(TodoController.class);

    private final TodoService todoService;

    @PostMapping(ApplicationConstants.API_TODOS)
    public ResponseEntity<Todo> addTodo(@RequestBody TodoCreationRequest todoCreationRequest) {
        return ResponseEntity.ok(todoService.createTodo(todoCreationRequest));
    }

    @GetMapping(ApplicationConstants.API_TODOS)
    public ResponseEntity getTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @DeleteMapping(ApplicationConstants.API_TODO)
    public ResponseEntity<Void> deleteTodoById(@PathVariable String id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping(ApplicationConstants.API_TODO)
    public ResponseEntity<Todo> patchById(@PathVariable String id, @RequestBody TodoCreationRequest todoCreationRequest) {
        return ResponseEntity.ok(todoService.updateTodo(id, todoCreationRequest));
    }

//
//    private ArrayList<Todo> todosList = new ArrayList<Todo>();
//
//
//    @GetMapping("/hello")
//    public String greetUser() {
//        System.out.println("hey in greet user");
//        return "Hello!";
//    }
//
//    @GetMapping(ApplicationConstants.API_TODOS)
//    public ResponseEntity<ArrayList<Todo>> getTodos() {
//        return new ResponseEntity<>(todosList, HttpStatus.OK);
//    }
//
//    @PostMapping(ApplicationConstants.API_TODOS)
//    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
//        String uniqueID = UUID.randomUUID().toString();
//        todo.setId(uniqueID);
//        todosList.add(todo);
//        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
//    }
//
//    @PatchMapping(ApplicationConstants.API_TODO)
//    public ResponseEntity<Todo> editTodo(@RequestBody Todo todo, @PathVariable String id) {
//
//
//        try{
//            for(Todo todoItem : todosList) {
//                logger.info("todo item -> "+todoItem);
//                if(todoItem.getId().equals(id)) {
//                    //found it!
//                    int index = todosList.indexOf(todoItem);
//                    logger.info("index -> "+ index);
//                    todo.setId(id);
//                    todosList.set(index, todo );
//                }
//            }
//
//        }catch (Exception e){
//                logger.debug("exception -> "+ e);
//        }
//        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
//    }




}
