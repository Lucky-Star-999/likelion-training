package com.example.practiceweek83submission.controller;

import com.example.practiceweek83submission.component.ActuatorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorPropertiesController {
    @Autowired
    private ActuatorProperties actuatorProperties;

    @GetMapping("/port")
    public String getActuatorPort() {
        return actuatorProperties.getPort();
    }
}
