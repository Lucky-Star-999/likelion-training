package com.example.hellowebsocket.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChatHistoryList {
    private List<ChatHistory> chatHistoryList = new ArrayList<>();
}
