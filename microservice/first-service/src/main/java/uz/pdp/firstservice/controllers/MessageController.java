package uz.pdp.firstservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.firstservice.rabbitMq.publisher.RabbitMQProducer;


@RestController
@RequestMapping("/api/v1/first")
@RequiredArgsConstructor
public class MessageController {

    private final RabbitMQProducer rabbitMQProducer;

    @PostMapping("/publish-message-to-second-service")
    public ResponseEntity<String> sendMessageToSecondService(@RequestParam("message") String message){
        rabbitMQProducer.sendMessageForSecondService(message);
        return ResponseEntity.ok("Message sent to for Second service ");
    }

    @PostMapping("/publish-message-to-third-service")
    public ResponseEntity<String> sendMessageToThirdService(@RequestParam("message") String message){
        rabbitMQProducer.sendMessageForThirdService(message);
        return ResponseEntity.ok("Message sent to RabbitMQ for Third service ");
    }

}
