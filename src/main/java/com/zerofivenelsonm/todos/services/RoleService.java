package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.Role;

public interface RoleService {

    Role findRoleById(long id);

    Role save(Role role);
}
