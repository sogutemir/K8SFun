package com.dijikent.k8sexercisetodoapp.infrastructure.persistence.repository;

import com.dijikent.k8sexercisetodoapp.infrastructure.persistence.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoJpaRepository extends JpaRepository<TodoEntity, Long> {
} 