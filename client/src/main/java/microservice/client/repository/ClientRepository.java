package microservice.client.repository;

import microservice.client.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Long> {

    Client getById(long id);
    List<Client> getByName(String name);

}
