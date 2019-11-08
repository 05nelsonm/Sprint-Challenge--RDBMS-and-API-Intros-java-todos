package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.Role;
import com.zerofivenelsonm.todos.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findRoleById(long id) {
        return null;
    }

    @Override
    public Role save(Role role) {
        return null;
    }
}
