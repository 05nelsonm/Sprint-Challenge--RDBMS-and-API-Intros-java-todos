package com.zerofivenelsonm.todos.repositories;

import com.zerofivenelsonm.todos.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
