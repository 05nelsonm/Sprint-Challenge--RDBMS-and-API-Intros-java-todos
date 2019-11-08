package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(long id);

    User save(User user);

    void delete(long id);
}
