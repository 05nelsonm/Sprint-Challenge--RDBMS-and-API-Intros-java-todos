package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.Role;
import com.zerofivenelsonm.todos.models.Todo;
import com.zerofivenelsonm.todos.models.User;
import com.zerofivenelsonm.todos.repositories.TodoRepository;
import com.zerofivenelsonm.todos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImplementation implements UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {

        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserById(long id) {

        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public User save(User user) {

        User newUser = new User();

        newUser.setUsername(user.getUsername());
        newUser.setPrimaryemail(user.getPrimaryemail());
        newUser.setPassword(user.getPassword());

        for (Role r : user.getRoles()) {
            Role newRole = roleService.findRoleById(r.getRoleid());

            newUser.addRole(newRole);
        }

        for (Todo t : user.getTodos()) {
            Todo newTodo = new Todo(t.getDescription(), t.getDatestarted(), newUser);

            newUser.getTodos().add(newTodo);
        }

        return userRepository.save(newUser);
    }

    @Override
    public Todo addTodo(Todo todo, long userid) {

        Todo newTodo = new Todo();

        User existingUser = findUserById(userid);

        newTodo.setDescription(todo.getDescription());
        newTodo.setDatestarted(todo.getDatestarted());
        newTodo.setUser(existingUser);

        return todoRepository.save(newTodo);
    }

    @Transactional
    @Override
    public void delete(long id) {

        if (findUserById(id) != null) {
            userRepository.deleteById(id);
        }
    }
}
