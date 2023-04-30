package uz.pdp.secondservice.rabbitMq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);


    @RabbitListener(queues = {"${rabbitMQ.queueForSecondService.name}"})    // Bu anotatsiya MessageQueue  dan message larni o'qib olish uchun  uni ichiga queues propertysiga qaysi queuelardan listen qilishini yozamiz
    public void receiveMessage (String message){
        LOGGER.info(String.format("Receive message -> %s" , message));
        System.out.println("MESSAGECHA: "  + message);
    }
}
