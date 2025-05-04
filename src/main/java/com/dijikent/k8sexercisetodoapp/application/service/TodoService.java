package com.dijikent.k8sexercisetodoapp.application.service;

import com.dijikent.k8sexercisetodoapp.application.dto.TodoDto;
import com.dijikent.k8sexercisetodoapp.application.mapper.TodoMapper;
import com.dijikent.k8sexercisetodoapp.domain.model.Todo;
import com.dijikent.k8sexercisetodoapp.domain.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todoMapper.toDtoList(todos);
    }

    public Optional<TodoDto> getTodoById(Long id) {
        return todoRepository.findById(id)
                .map(todoMapper::toDto);
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = todoMapper.toEntity(todoDto);
        Todo savedTodo = todoRepository.save(todo);
        return todoMapper.toDto(savedTodo);
    }

    public Optional<TodoDto> updateTodo(Long id, TodoDto todoDto) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    Todo updatedTodo = todoMapper.updateEntityFromDto(existingTodo, todoDto);
                    return todoRepository.update(updatedTodo);
                })
                .map(todoMapper::toDto);
    }

    public Optional<TodoDto> markTodoAsCompleted(Long id) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setCompleted(true);
                    return todoRepository.update(existingTodo);
                })
                .map(todoMapper::toDto);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
} 