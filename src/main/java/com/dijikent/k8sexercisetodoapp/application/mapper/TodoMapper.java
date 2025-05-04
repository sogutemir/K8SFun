package com.dijikent.k8sexercisetodoapp.application.mapper;

import com.dijikent.k8sexercisetodoapp.application.dto.TodoDto;
import com.dijikent.k8sexercisetodoapp.domain.model.Todo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoMapper {

    public TodoDto toDto(Todo todo) {
        if (todo == null) {
            return null;
        }
        
        return TodoDto.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .description(todo.getDescription())
                .completed(todo.isCompleted())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }

    public Todo toEntity(TodoDto todoDto) {
        if (todoDto == null) {
            return null;
        }
        
        return Todo.builder()
                .id(todoDto.getId())
                .title(todoDto.getTitle())
                .description(todoDto.getDescription())
                .completed(todoDto.isCompleted())
                .createdAt(todoDto.getCreatedAt() != null ? todoDto.getCreatedAt() : LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public List<TodoDto> toDtoList(List<Todo> todos) {
        if (todos == null) {
            return List.of();
        }
        
        return todos.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Todo updateEntityFromDto(Todo entity, TodoDto dto) {
        if (entity == null || dto == null) {
            return entity;
        }
        
        String title = dto.getTitle() != null ? dto.getTitle() : entity.getTitle();
        String description = dto.getDescription() != null ? dto.getDescription() : entity.getDescription();
        
        return Todo.builder()
                .id(entity.getId())
                .title(title)
                .description(description)
                .completed(dto.isCompleted())
                .createdAt(entity.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .build();
    }
} 