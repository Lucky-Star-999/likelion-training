package com.example.practiceweek103.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListenerService {
    private Logger logger = LoggerFactory.getLogger(MessageListenerService.class);

    @KafkaListener(
            topics = "likelion",
            groupId = "groupId"
    )
    void listener(String data) {
        logger.info("Message: " + data);
    }
}
