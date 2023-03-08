# Practice Week 10
## Information
Full name: Nguyễn Hoàng Linh

## Bài 1
### Sử dụng nhiều kênh chat
Ở file **chat.html**, ta thêm form để user nhập vào channel theo ý muốn
```html
<div class="form-group">
    <input type="text" id="channel" placeholder="Channel" autocomplete="off" class="form-control" />
</div>
```
Ta chỉnh sửa phần lấy giá trị channel ở **chat.js** để lấy giá trị từ form
```javascript
channel = document.getElementById('channel').value;
```
Kết quả <br/><br/>
![Result 1](https://github.com/Lucky-Star-999/likelion-training/blob/main/practice/practice-week-10-3/src/main/resources/static/img/image-1.PNG)

Kết quả message khi được lưu vào Redis <br/><br/>
![Result 6](https://github.com/Lucky-Star-999/likelion-training/blob/main/practice/practice-week-10-3/src/main/resources/static/img/image-6.PNG)

## Bài 2
### Lưu message vào Kafka
Ta chỉnh sửa ở hàm **sendMessage** sao cho message có thể lưu vào Kafka
```java
@MessageMapping("/chat.sendMessage/{roomId}")
@SendTo("/topic/{roomId}")
public ChatMessage sendMessage(@Payload ChatMessage chatMessage
        , @DestinationVariable String roomId
) {
    redisTemplate.opsForList().rightPushAll(roomId, chatMessage);
    kafkaTemplate.send("likelion", chatMessage.getContent());
    return chatMessage;
}
```
Kết quả message xuất ra dạng log <br/><br/>
![Result 2](https://github.com/Lucky-Star-999/likelion-training/blob/main/practice/practice-week-10-3/src/main/resources/static/img/image-2.PNG)

Kết quả message khi được lưu vào Kafka <br/><br/>
![Result 3](https://github.com/Lucky-Star-999/likelion-training/blob/main/practice/practice-week-10-3/src/main/resources/static/img/image-3.PNG)

### Docker Desktop
File Dockerfile
```dockerfile
FROM maslick/minimalka:jdk11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} practice-week-10-3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/practice-week-10-3-0.0.1-SNAPSHOT.jar"]
```

Các lệnh build project, tạo image và run container
* Build project để tạo file jar: `mvn clean package -DskipTests`
* Build image: `docker build -t practice-week-10-3 .`
* Build và run container: `docker run --name practice-week-10-3 -p 8080:8080 practice-week-10-3`

## Bài 3
### Thêm và xóa topic động
Tạo component **KafkaAdmin**
```java
@Component
public class KafkaAdminUtil {
    AdminClient adminClient = null;

    public KafkaAdminUtil() {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        adminClient = AdminClient.create(properties);
    }

    public void createTopic(final String topicName, final int partitions, final short replicationFactor)
            throws ExecutionException, InterruptedException {
        NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
        adminClient.createTopics(Collections.singleton(newTopic)).all().get();
    }

    public void deleteTopic(final String topicName) throws ExecutionException, InterruptedException {
        adminClient.deleteTopics(Collections.singleton(topicName)).all().get();
    }
}
```
Tạo service để gọi các phương thức từ **KafkaAdmin**
```java
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
```
Tạo topic mới thông qua phương thức POST <br/><br/>
![Result 4](https://github.com/Lucky-Star-999/likelion-training/blob/main/practice/practice-week-10-3/src/main/resources/static/img/image-4.PNG)

Kết quả sau khi tạo topic mới <br/><br/>
![Result 5](https://github.com/Lucky-Star-999/likelion-training/blob/main/practice/practice-week-10-3/src/main/resources/static/img/image-5.PNG)



