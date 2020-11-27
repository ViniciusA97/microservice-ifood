package microservices.plates.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlateDTO {

    private String name;

    private String description;

    private double price;

    private long restaurant_id;

}
