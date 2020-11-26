package microservice.restaurant.repository;


import microservice.restaurant.model.Restaurant;
import org.springframework.data.repository.CrudRepository;


public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    Restaurant getById(long id);
    Restaurant getByName(String name);

}
