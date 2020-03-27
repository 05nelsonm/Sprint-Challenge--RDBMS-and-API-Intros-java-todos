package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.Role;
import com.zerofivenelsonm.todos.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "roleService")
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findRoleById(long id) {
        
        return roleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Role " + id + " not found."));
    }

    @Override
    public Role save(Role role) {

        if (role.getUsers().size() > 0) {
            throw new EntityNotFoundException("Users not added through roles");
        }

        Role newRole = new Role();
        newRole.setUsers(new ArrayList<>());
        newRole.setRolename(role.getRolename());

        return roleRepository.save(newRole);
    }
}
