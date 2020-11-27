package microservices.plates.repository;

import microservices.plates.model.Plate;
import microservices.plates.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlateRepository extends CrudRepository<Plate, Long> {

    Plate getById(long id);
    List<Plate> getByRestaurant(Restaurant restaurant);


}
