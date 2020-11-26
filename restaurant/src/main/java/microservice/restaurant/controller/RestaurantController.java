package microservice.restaurant.controller;

import microservice.restaurant.DTO.RestaurantDTO;
import microservice.restaurant.model.Restaurant;
import microservice.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    private ResponseEntity<?> createRestaurant(@RequestBody RestaurantDTO restaurantDTO){
        Restaurant restaurant = this.restaurantService.createRestaurant(restaurantDTO);

        if(restaurant== null){
            return new ResponseEntity<>("Erro ao criar o restaurante.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);

    }

    @GetMapping
    private ResponseEntity<?> getAll(){
        Iterable<Restaurant> restaurants = this.restaurantService.getAllRestaurant();

        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }


}
