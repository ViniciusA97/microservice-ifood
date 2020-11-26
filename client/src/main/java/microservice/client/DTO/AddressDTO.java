package microservice.client.DTO;

import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private String address;

    private String cep;

    private String complemento;
}
