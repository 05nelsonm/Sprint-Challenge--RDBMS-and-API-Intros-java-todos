package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.Todo;

public interface TodoService {

    Todo updateTodo(Todo todo, long todoid);
}
