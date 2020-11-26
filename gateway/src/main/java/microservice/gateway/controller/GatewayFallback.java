package microservice.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
@Slf4j
public class GatewayFallback {

    @GetMapping
    public ResponseEntity<?> errorGet(){
        log.info("Error Get");
        return new ResponseEntity<>("Error. Service disconnected", HttpStatus.BAD_GATEWAY);
    }

    @PostMapping
    public ResponseEntity<?> errorPost(){
        log.info("Error Post");
        return new ResponseEntity<>("Error. Service disconnected", HttpStatus.BAD_GATEWAY);
    }
}
