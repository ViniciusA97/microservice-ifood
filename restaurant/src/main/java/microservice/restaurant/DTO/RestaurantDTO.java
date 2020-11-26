package microservice.restaurant.DTO;

import lombok.*;
import microservice.client.DTO.AddressDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestaurantDTO {

    private AddressDTO address;

    private String name;

    private String email;


}
