package microservices.plates.service;

import lombok.extern.slf4j.Slf4j;
import microservices.plates.DTO.RestaurantDTO;
import microservices.plates.DTO.RestaurantsDto;
import microservices.plates.model.Restaurant;
import microservices.plates.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant getById(long id){
        Restaurant restaurant = this.restaurantRepository.getById(id);
        return restaurant;
    }

    public void syncRestaurant(RestaurantDTO dto){

        Restaurant restaurant = new Restaurant(dto.getId(),dto.getName());
        try{
            this.restaurantRepository.save(restaurant);
        }catch (Exception e){
            log.info("Sync Database Rest exception "+e.getMessage());
        }
    }

    public void syncAnyRestaurant(RestaurantsDto restaurantDTOList){
        for (RestaurantDTO i: restaurantDTOList.getRestaurantDTOList()) {
            Restaurant restaurant = new Restaurant(i.getId() , i.getName());
            try{
                this.restaurantRepository.save(restaurant);
                log.info("[saved rest] " +i.getId()+" " +i.getName());
            }catch (Exception e){
                log.info("Exception any rest. [ID]: "+i.getId()+" [nome]: "+i.getName());
            }
        }
    }

    public void syncDeleteRestaurant(RestaurantDTO dto){
        Restaurant restaurant = new Restaurant(dto.getId(),dto.getName());
        try{
            this.restaurantRepository.delete(restaurant);
        }catch (Exception e){
            log.info("Sync Database Rest exception "+e.getMessage());
        }
    }




}
