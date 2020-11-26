package microservice.client.DTO;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String email;
    private String password;
    private String name;


}
