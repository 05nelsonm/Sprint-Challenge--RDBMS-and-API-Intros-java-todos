package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.Todo;
import com.zerofivenelsonm.todos.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(long id);

    User save(User user);

    Todo addTodo(Todo todo, long userid);

    void delete(long id);
}
