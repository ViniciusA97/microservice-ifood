package microservice.client.repository;

import microservice.client.models.Restaurant;
import microservice.client.models.User;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    Restaurant getById(long id);
    Restaurant getByUser(User user);
    Restaurant getByName(String name);

}
