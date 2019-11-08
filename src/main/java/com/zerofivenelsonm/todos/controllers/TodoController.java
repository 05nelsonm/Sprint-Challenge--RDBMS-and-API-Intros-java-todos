package com.zerofivenelsonm.todos.controllers;

import com.zerofivenelsonm.todos.models.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    /**
     * http://localhost:2019/todos/todo/{todoid}
     * Updates a todo based on todoid
     *
     * @param updateTodo : Todo
     * @param todoid : long
     * */
    @PutMapping(value = "/todo/{todoid}", consumes = {"application/json"})
    public ResponseEntity<?> updateTodo(@RequestBody Todo updateTodo, @PathVariable long todoid) {

        return null;
    }
}
