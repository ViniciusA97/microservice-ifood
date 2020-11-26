package microservice.restaurant.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Restaurant implements Serializable {

    @Id @GeneratedValue
    private long id;

    @OneToOne
    private Address address;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    public Restaurant(Address address, String name, String email) {
        this.address = address;
        this.name = name;
        this.email = email;
    }
}
