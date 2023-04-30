package uz.pdp.firstservice.rabbitMq.publisher;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer {

    @Value("${rabbitMQ.exchange.name}")
    private String exchange;


    @Value("${rabbitMQ.routing.keyForSecondService}")
    private String routingKeyForSecondService;

    @Value("${rabbitMQ.routing.keyForThirdService}")
    private String routingKeyForThirdService;


    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate rabbitTemplate;

    public void sendMessageForSecondService(String message) {
        LOGGER.info(String.format("Message sent to -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKeyForSecondService, message);
    }

    public void sendMessageForThirdService(String message) {
        LOGGER.info(String.format("Message sent to -> %s", message));
        rabbitTemplate.convertAndSend(exchange, routingKeyForThirdService, message);
    }

}
