package uz.pdp.firstservice.rabbitMq.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitMQ.queueForSecondService.name}")
    private String secondServiceQueue;

    @Value("${rabbitMQ.queueForThirdService.name}")
    private String thirdServiceQueue;
    @Value("${rabbitMQ.exchange.name}")
    private String exchange;

    @Value("${rabbitMQ.routing.keyForSecondService}")
    private String routingKeyForSecondService;

    @Value("${rabbitMQ.routing.keyForThirdService}")
    private String routingKeyForThirdService;

    @Bean
    public Queue queueForSecondService (){
        return new Queue(secondServiceQueue);
    }

    @Bean
    public Queue queueForThirdService (){
        return new Queue(thirdServiceQueue);
    }


    @Bean
    public TopicExchange exchange (){
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding bindingForSecondService(){
        return BindingBuilder.bind(queueForSecondService())
                .to(exchange())
                .with(routingKeyForSecondService);
    }


    @Bean
    public Binding bindingForThirdService(){
        return BindingBuilder.bind(queueForThirdService())
                .to(exchange())
                .with(routingKeyForThirdService);
    }
}
