package com.zerofivenelsonm.todos.repositories;

import com.zerofivenelsonm.todos.models.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
