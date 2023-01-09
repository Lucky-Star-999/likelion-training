package com.example.exercise2.service.impl;

import com.example.exercise2.repository.HelloRepository;
import com.example.exercise2.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private HelloRepository helloRepository;

    @Override
    public String hello() {
        return helloRepository.hello();
    }
}
