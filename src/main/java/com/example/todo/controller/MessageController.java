package com.example.todo.controller;

import com.example.todo.entity.Message;
import com.example.todo.entity.Task;
import com.example.todo.repository.MessageRepository;
import com.example.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    // Для JSON
    @PostMapping(consumes = "application/json")
    public Message createMessageJson(@RequestBody Message msg) {
        return messageRepository.save(msg);
    }

    // Для form-data
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public Message createMessageForm(@RequestParam String content) {
        Message message = new Message();
        message.setContent(content);
        return messageRepository.save(message);
    }
}