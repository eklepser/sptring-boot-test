package com.example.todo.repository;

import com.example.todo.entity.Message;
import com.example.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Пока пусто — JpaRepository даёт уже много методов: save(), findAll(), findById(), deleteById() и т.д.
}
