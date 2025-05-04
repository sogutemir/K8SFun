package com.dijikent.k8sexercisetodoapp.domain.repository;

import com.dijikent.k8sexercisetodoapp.domain.model.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    List<Todo> findAll();

    Optional<Todo> findById(Long id);

    Todo save(Todo todo);

    Todo update(Todo todo);

    void deleteById(Long id);
} 