package com.zerofivenelsonm.todos.controllers;

import com.zerofivenelsonm.todos.models.Todo;
import com.zerofivenelsonm.todos.models.User;
import com.zerofivenelsonm.todos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * http://localhost:2019/users/users
     * Return all of the users and their todos.
     * */
    @GetMapping(value = "/users", produces = {"application/json"})
    public ResponseEntity<?> getAllUsers() {

        List<User> allUsers = userService.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    /**
     * http://localhost:2019/users/user/{userid}
     * Return the user and their todos based off of id.
     *
     * @param userid : long
     * */
    @GetMapping(value = "/user/{userid}", produces = {"application/json"})
    public ResponseEntity<?> findUserById(@PathVariable long userid) {

        User theUser = userService.findUserById(userid);
        return new ResponseEntity<>(theUser, HttpStatus.OK);
    }

    /**
     * http://localhost:2019/users/user
     * Add a user.
     *
     * @param newUser : User
     * */
    @PostMapping(value = "/user", consumes = {"application/json"})
    public ResponseEntity<?> addNewUser(@Valid @RequestBody User newUser) {

        newUser = userService.save(newUser);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newUserURI = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{userid}")
                .buildAndExpand(newUser.getUserid())
                .toUri();
        responseHeaders.setLocation(newUserURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
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

        userService.delete(userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
