package microservice.client.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@RequiredArgsConstructor
public class Address implements Serializable {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false) @NonNull
    private String address;

    @Column(nullable = false) @NonNull
    private String cep;

    @Column(nullable = true) @NonNull
    private String complemento;







}
