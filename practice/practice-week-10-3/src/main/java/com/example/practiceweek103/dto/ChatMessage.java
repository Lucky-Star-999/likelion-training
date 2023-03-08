package com.example.practiceweek103.dto;

import com.example.practiceweek103.enumf.MessageType;
import lombok.Data;

@Data
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;

    // constructors, getters and setters
}
