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
public class Address implements Serializable {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = true)
    private String complemento;



}
