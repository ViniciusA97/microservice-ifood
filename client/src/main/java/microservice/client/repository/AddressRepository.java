package microservice.client.repository;

import microservice.client.models.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address,Long> {

    Address getById(long id);
    List<Address> getByCep(String cep);


}
