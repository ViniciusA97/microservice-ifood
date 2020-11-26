package microservice.restaurant.service;

import lombok.extern.slf4j.Slf4j;
import microservice.client.DTO.AddressDTO;
import microservice.restaurant.DTO.RestaurantDTO;
import microservice.restaurant.model.Address;
import microservice.restaurant.model.Restaurant;
import microservice.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressService addressService;

    public Restaurant createRestaurant(RestaurantDTO restaurantDTO){

        AddressDTO addressDTO = restaurantDTO.getAddress();
        Address address = null;
        if(addressDTO!=null){
            address= this.addressService.createAddress(addressDTO);
        }

        Restaurant restaurant = new Restaurant(address, restaurantDTO.getName(), restaurantDTO.getEmail());

        try{
            this.restaurantRepository.save(restaurant);
            return restaurant;
        }catch (Exception e){
            log.info("ERROR AO CRIAR UM RESTAURANT: "+e.getMessage());
            return null;
        }

    }

    public Iterable<Restaurant> getAllRestaurant(){
        Iterable<Restaurant> restaurantList = this.restaurantRepository.findAll();
        return restaurantList;
    }

}
