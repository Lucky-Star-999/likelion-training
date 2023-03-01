package com.example.hellowebsocket.controller;

import com.example.hellowebsocket.model.ChatHistoryList;
import com.example.hellowebsocket.model.ChatMessage;
import com.example.hellowebsocket.model.ChatHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ChatController {
    @Autowired
    private ChatHistoryList chatHistoryList;

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatHistoryList.getChatHistoryList().add(new ChatHistory(chatMessage.getContent(), chatMessage.getSender()));
        chatMessage.setChatHistoryList(chatHistoryList);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        chatMessage.setChatHistoryList(chatHistoryList);
        return chatMessage;
    }
}
