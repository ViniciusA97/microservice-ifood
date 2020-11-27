package microservices.plates.controller;

import microservices.plates.DTO.PlateDTO;
import microservices.plates.model.Plate;
import microservices.plates.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1")
@RestController
public class PlateController {

    @Autowired
    private PlateService plateService;

    @PostMapping
    public ResponseEntity<?> createPlate(@RequestBody PlateDTO plateDTO){
        Plate plate = this.plateService.create(plateDTO);
        return new ResponseEntity<>(plate, HttpStatus.CREATED);
    }


}
