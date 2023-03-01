package com.example.hellowebsocket.model;

import lombok.Data;

@Data
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private ChatHistoryList chatHistoryList;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
