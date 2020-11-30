package microservices.plates.DTO;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RestaurantsDto {

    private List<RestaurantDTO> restaurantDTOList;

}
