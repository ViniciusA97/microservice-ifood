package microservice.client.service;

import lombok.extern.slf4j.Slf4j;
import microservice.client.DTO.ClientDTO;
import microservice.client.DTO.UserDTO;
import microservice.client.models.Client;
import microservice.client.models.User;
import microservice.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;

    public Client createClient(ClientDTO clientDTO){

        UserDTO userDTO = new UserDTO(clientDTO.getEmail(), clientDTO.getPassword());
        User user = this.userService.createUser(userDTO);

        Client client = Client.builder().name(clientDTO.getName())
                .user(user).build();

        try{
            this.clientRepository.save(client);
        }catch (Exception e){
            log.info(e.getMessage());
        }

        return client;
    }

}
