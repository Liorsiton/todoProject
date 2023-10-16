package com.lior.springboottodoapplication.controller;

import com.lior.springboottodoapplication.model.Todo;
import com.lior.springboottodoapplication.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@Slf4j
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/getAllTodos")
    public List<Todo> getAllTodos(){
        return todoService.getAll();

    }

    @DeleteMapping("/deleteTodo/{todoId}")
    public void deleteTodo(@PathVariable  Integer todoId) throws NoSuchFieldException {
        log.info("delete totd {}", todoId);
        Todo todo = todoService.getTodo(todoId);
        todoService.deleteTodo(todo);
    }

    @PostMapping("addTodo")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.saveTodo(todo);
    }

}
