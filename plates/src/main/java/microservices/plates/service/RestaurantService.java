package microservices.plates.service;

import microservices.plates.model.Restaurant;
import microservices.plates.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant getById(long id){
        Restaurant restaurant = this.restaurantRepository.getById(id);
        return restaurant;
    }


}
