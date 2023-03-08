package com.example.practiceweek103.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/kafka")
    public String message() {
        kafkaTemplate.send("likelion", "Hello kafka");
        return "Hi";
    }
}
