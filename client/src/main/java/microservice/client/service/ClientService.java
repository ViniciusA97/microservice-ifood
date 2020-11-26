package microservice.client.service;

import lombok.extern.slf4j.Slf4j;
import microservice.client.DTO.ClientDTO;
import microservice.client.models.Address;
import microservice.client.models.Client;
import microservice.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressService addressService;

    public Client createClient(ClientDTO clientDTO){

        Address address = null;

        if(clientDTO.getAddress()!=null){
            address = this.addressService.createAddress(clientDTO.getAddress());
        }

        Client client = new Client(clientDTO.getName(),
                address,
                clientDTO.getEmail(),
                clientDTO.getPassword());

        try{
            this.clientRepository.save(client);
            return client;
        }catch (Exception e){
            log.info("EXCEPTION ON CLIENT: "+e.getMessage());
            return null;
        }
    }



}
