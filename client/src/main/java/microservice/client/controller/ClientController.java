package microservice.client.controller;

import microservice.client.DTO.ClientDTO;
import microservice.client.models.Client;
import microservice.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customer")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody ClientDTO clientDTO){
        Client client = this.clientService.createClient(clientDTO);

        return new ResponseEntity<>(client, HttpStatus.CREATED);

    }

}
