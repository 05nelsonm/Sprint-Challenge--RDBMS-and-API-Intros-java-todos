package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.User;
import com.zerofivenelsonm.todos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Transactional
    @Override
    public User save(User user) {
        return null;
    }

    @Transactional
    @Override
    public void delete(long id) {

    }
}
