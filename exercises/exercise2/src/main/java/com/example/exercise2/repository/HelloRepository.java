package com.example.exercise2.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
    public String hello() {
        return "Hello World!";
    }
}
