package com.dijikent.k8sexercisetodoapp.infrastructure.persistence.repository;

import com.dijikent.k8sexercisetodoapp.domain.model.Todo;
import com.dijikent.k8sexercisetodoapp.domain.repository.TodoRepository;
import com.dijikent.k8sexercisetodoapp.infrastructure.persistence.entity.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {

    private final TodoJpaRepository todoJpaRepository;

    @Override
    public List<Todo> findAll() {
        return todoJpaRepository.findAll().stream()
                .map(this::mapToTodo)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Todo> findById(Long id) {
        return todoJpaRepository.findById(id)
                .map(this::mapToTodo);
    }

    @Override
    public Todo save(Todo todo) {
        TodoEntity entity = mapToEntity(todo);
        return mapToTodo(todoJpaRepository.save(entity));
    }

    @Override
    public Todo update(Todo todo) {
        TodoEntity entity = mapToEntity(todo);
        return mapToTodo(todoJpaRepository.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        todoJpaRepository.deleteById(id);
    }

    private Todo mapToTodo(TodoEntity entity) {
        return Todo.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .completed(entity.isCompleted())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    private TodoEntity mapToEntity(Todo todo) {
        return TodoEntity.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .completed(todo.isCompleted())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
} 