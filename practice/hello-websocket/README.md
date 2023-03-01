# WebSocket Practice (+ Store messages)
## Information
Full name: Nguyễn Hoàng Linh

## Description
Thêm tính năng lưu trữ tin nhắn sau khi reload trang

## Phương pháp
### Model
Thêm class **ChatHistory** và **ChatHistoryList**
```java
public class ChatHistory {
    private String content;
    private String sender;
}
```

```java
public class ChatHistoryList {
    private List<ChatHistory> chatHistoryList = new ArrayList<>();
}
```

Ở class **ChatMessage** ta thêm thuộc tính **chatHistoryList** để lưu trữ lịch sử của các message cũ
```java
private ChatHistoryList chatHistoryList;
```

Class **ChatController** sẽ có một chút thay đổi khi ta add các message vào chatHistoryList mỗi khi ai đó gửi lên
```java
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
```

Sau đó, ở client, **message** nhận được từ Spring Boot sẽ thay đổi về cấu trúc
```json
{"type":"CHAT","content":"Hi","sender":"Guest","chatHistoryList":{"chatHistoryList":[{"content":"Hi","sender":"Linh"},{"content":"Hi","sender":"Guest"}]}}
```
File **main.js** sẽ sửa một số chỗ để nó có thể lấy được và xuất nội dung từ **chatHistoryList**

## Result
