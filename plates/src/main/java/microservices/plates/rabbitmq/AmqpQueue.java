package microservices.plates.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class AmqpQueue{

    @Bean
    public Queue mailQueueCreate() {
        return new Queue("new-rest-sync-queue", true);
    }

    @Bean
    public Queue mailQueueUpdate() {
        return new Queue("all-rest-sync-queue", true);
    }

    @Bean
    public Queue mailQueueDelete() {
        return new Queue("delete-rest-sync-queue", true);
    }

}
