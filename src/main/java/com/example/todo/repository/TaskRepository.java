package com.example.todo.repository;

import com.example.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Пока пусто — JpaRepository даёт уже много методов: save(), findAll(), findById(), deleteById() и т.д.
}