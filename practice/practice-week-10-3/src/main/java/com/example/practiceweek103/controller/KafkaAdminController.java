package com.example.practiceweek103.controller;

import com.example.practiceweek103.dto.Topic;
import com.example.practiceweek103.service.KafkaAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class KafkaAdminController {
    @Autowired
    private KafkaAdminService kafkaAdminService;

    @PostMapping("/topic")
    public String createTopic(@RequestBody Topic topic) throws ExecutionException, InterruptedException {
        return kafkaAdminService.createTopic(topic.getName());
    }

    @DeleteMapping("/topic/{name}")
    public String deleteTopic(@PathVariable String name) throws ExecutionException, InterruptedException {
        return kafkaAdminService.deleteTopic(name);
    }
}
