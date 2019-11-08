package com.zerofivenelsonm.todos.controllers;

import com.zerofivenelsonm.todos.models.Todo;
import com.zerofivenelsonm.todos.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * http://localhost:2019/users/users
     * Return all of the users and their todos.
     * */
    @GetMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<?> getAllUsers() {
        
        return null;
    }

    /**
     * http://localhost:2019/users/user/{userid}
     * Return the user and their todos based off of id.
     *
     * @param userid : long
     * */
    @GetMapping(value = "/user/{userid}", produces = {"application/json"})
    public ResponseEntity<?> findUserById(@PathVariable long userid) {

        return null;
    }

    /**
     * http://localhost:2019/users/user
     * Add a user.
     *
     * @param newUser : User
     * */
    @PostMapping(value = "/user", consumes = {"application/json"})
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User newUser) {

        return null;
    }

    /**
     * http://localhost:2019/users/todo/{userid}
     * Adds a todo to the user.
     *
     * @param newTodo : Todo
     * @param userid : long
     * */
    @PostMapping(value = "/todo/{userid}", consumes = {"application/json"})
    public ResponseEntity<?> addNewTodo(@Valid @RequestBody Todo newTodo, @PathVariable long userid) {

        return null;
    }

    /**
     * http://localhost:2019/users/userid/{userid}
     * Deletes a user based off of their userid & deletes all their associated todos.
     *
     * @param userid : long
     * */
    @DeleteMapping("/userid/{userid}")
    public ResponseEntity<?> deleteUser(@PathVariable long userid) {

        return null;
    }
}
