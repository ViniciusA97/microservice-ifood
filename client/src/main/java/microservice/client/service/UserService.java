package microservice.client.service;

import lombok.extern.slf4j.Slf4j;
import microservice.client.DTO.UserDTO;
import microservice.client.models.User;
import microservice.client.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO){

        User user = new User(userDTO.getEmail(),userDTO.getPassword());

        try{
            userRepository.save(user);
        }catch(Exception e){
            log.info("EXCEPTION ON USER CREATE: "+ e.getMessage());
        }

        return user;

    }

}
