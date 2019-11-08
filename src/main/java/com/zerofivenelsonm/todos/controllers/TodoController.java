package com.zerofivenelsonm.todos.controllers;

import com.zerofivenelsonm.todos.models.Todo;
import com.zerofivenelsonm.todos.services.TodoService;
import com.zerofivenelsonm.todos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    /**
     * http://localhost:2019/todos/todo/{todoid}
     * Updates a todo based on todoid
     *
     * @param todo : Todo
     * @param todoid : long
     * */
    @PutMapping(value = "/todo/{todoid}", consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo, @PathVariable long todoid) {

        todoService.updateTodo(todo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
