package microservice.client.service;

import lombok.extern.slf4j.Slf4j;
import microservice.client.DTO.AddressDTO;
import microservice.client.models.Address;
import microservice.client.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(AddressDTO addressDTO){
        Address address = new Address(addressDTO.getAddress(),addressDTO.getCep(), addressDTO.getComplemento());

        try{
            this.addressRepository.save(address);
            return address;
        }catch (Exception e){
            log.info("EXCEPTION ON SAVE ADDRES: "+e.getMessage());
            return null;
        }

    }


}
