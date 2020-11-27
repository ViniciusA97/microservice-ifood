package microservices.plates.service;

import microservices.plates.DTO.PlateDTO;
import microservices.plates.model.Plate;
import microservices.plates.model.Restaurant;
import microservices.plates.repository.PlateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateService {

    @Autowired
    private PlateRepository plateRepository;

    @Autowired
    private RestaurantService restaurantService;

    public Plate create(PlateDTO plateDTO){
        Restaurant restaurant = this.restaurantService.getById(plateDTO.getRestaurant_id());

        if(restaurant==null){
            //trow exception
            return null;
        }

        Plate plate = new Plate(plateDTO.getName(), plateDTO.getDescription(), plateDTO.getPrice(), restaurant);

        this.plateRepository.save(plate);
        return plate;
    }


}
