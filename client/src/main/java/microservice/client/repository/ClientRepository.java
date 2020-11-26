package microservice.client.repository;

import microservice.client.models.Client;
import microservice.client.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long> {

    Client getById(long id);
    Client getByUser(User user);
    List<Client> getByName(String name);

}
