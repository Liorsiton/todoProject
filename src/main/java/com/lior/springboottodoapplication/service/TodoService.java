package com.lior.springboottodoapplication.service;

import com.lior.springboottodoapplication.model.Todo;
import com.lior.springboottodoapplication.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {


    private final TodoRepository todoRepository;

    public List<Todo> getAll(){

        log.info("get all todos");
        return todoRepository.findAll();

    }

    public Todo getTodo(int todoId) throws NoSuchFieldException {
        Optional<Todo> todoOpt = todoRepository.findById(todoId);
        if(todoOpt.isEmpty()){
            throw  new NoSuchFieldException("not found");
        }
        return todoOpt.get();
    }

    public void deleteTodo(Todo todo){
        log.info("going to delete todo with id {}", todo.getId());
        todoRepository.delete(todo);
    }

    public Todo saveTodo(Todo todo){
        log.info("add new todo {}" , todo);
        if(todo == null){
            throw  new RuntimeException("todo is null");
        }
        return todoRepository.save(todo);
    }
}
