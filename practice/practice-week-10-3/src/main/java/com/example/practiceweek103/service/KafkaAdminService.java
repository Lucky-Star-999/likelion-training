package com.example.practiceweek103.service;

import com.example.practiceweek103.admin.KafkaAdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class KafkaAdminService {

    @Autowired
    private KafkaAdminUtil kafkaAdminUtil;

    public String createTopic(String name) throws ExecutionException, InterruptedException {
        try {
            kafkaAdminUtil.createTopic(name, 1, (short) 1);
            return "Topic \"" + name + "\" has been created!";
        } catch (Exception e) {
            return "Create topic unsuccessfully!";
        }
    }

    public String deleteTopic(String name) throws ExecutionException, InterruptedException {
        try {
            kafkaAdminUtil.deleteTopic(name);
            return "Topic \"" + name + "\" has been deleted!";
        } catch (Exception e) {
            return "Delete unsuccessfully!";
        }
    }

}
