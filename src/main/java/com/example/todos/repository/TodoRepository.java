package com.example.todos.repository;

import com.example.todos.models.Todo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface TodoRepository extends CrudRepository<Todo, String> {
}
