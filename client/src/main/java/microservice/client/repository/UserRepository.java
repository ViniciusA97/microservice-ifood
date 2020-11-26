package microservice.client.repository;

import microservice.client.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User getByEmail(String email);
}
