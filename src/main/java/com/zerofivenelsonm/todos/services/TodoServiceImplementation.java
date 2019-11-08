package com.zerofivenelsonm.todos.services;

import com.zerofivenelsonm.todos.models.Todo;
import com.zerofivenelsonm.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "todoService")
public class TodoServiceImplementation implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    @Override
    public Todo updateTodo(Todo todo, long todoid) {

        Todo existingTodo = todoRepository.findById(todoid).orElseThrow(() ->
                new EntityNotFoundException(Long.toString(todoid)));

        if (todo.getDescription() != null) {
            existingTodo.setDescription(todo.getDescription());
        }

        if (todo.getDatestarted() != null) {
            existingTodo.setDatestarted(todo.getDatestarted());
        }

        existingTodo.setCompleted(todo.isCompleted());

        return todoRepository.save(existingTodo);
    }
}
