package microservices.plates.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import microservices.plates.DTO.RestaurantDTO;
import microservices.plates.DTO.RestaurantsDto;
import microservices.plates.service.RestaurantService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class Consumer {


    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private RestaurantService restaurantService;

    @RabbitListener(queues = {"all-rest-sync-queue"}, concurrency = "5")
    @SneakyThrows
    public void consumerQueueSyncAnyRest(String msg){

        log.info("Email consumido. MSG: {}",msg);
        RestaurantsDto restaurantDTOList = mapper.readValue(msg, RestaurantsDto.class);
        this.restaurantService.syncAnyRestaurant(restaurantDTOList);
        log.info(msg.toString());

    }

    @RabbitListener(queues = {"new-rest-sync-queue"}, concurrency = "5")
    @SneakyThrows
    public void consumerQueueSyncRest(String msg){
        log.info("Email consumido. MSG: {}",msg);
        RestaurantDTO restaurantDTOList = mapper.readValue(msg, RestaurantDTO.class);
        this.restaurantService.syncRestaurant(restaurantDTOList);
    }


    @RabbitListener(queues = {"delete-rest-sync-queue"}, concurrency = "5")
    @SneakyThrows
    public void consumerQueueDeleteSyncRest(String msg){
        log.info("Email consumido. MSG: {}",msg);
        RestaurantDTO restaurantDTOList = mapper.readValue(msg, RestaurantDTO.class);
        this.restaurantService.syncDeleteRestaurant(restaurantDTOList);
    }

}
