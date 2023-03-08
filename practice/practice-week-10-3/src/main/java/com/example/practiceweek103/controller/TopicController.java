package com.example.practiceweek103.controller;

import com.example.practiceweek103.config.KafkaAdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class TopicController {
    @Autowired
    private KafkaAdminConfig kafkaAdminConfig;

    @GetMapping("/add/topic/{name}")
    public String addTopic(@PathVariable String name) throws ExecutionException, InterruptedException{
        kafkaAdminConfig.createTopic(name, 1, (short) 1);
        return "Hi";
    }
}
