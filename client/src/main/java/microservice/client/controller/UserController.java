package microservice.client.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {


    @GetMapping()
    public ResponseEntity<?> anotherTest(){
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }


    @GetMapping(path = "/test")
    public ResponseEntity<?> test(){
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }
}
