package com.todolist.todolist.repository;

import com.todolist.todolist.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    Optional<ToDo> findByTaskIgnoreCase(String taskName);
    boolean existsByTaskIgnoreCase(String taskName);
}
