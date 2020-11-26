package microservice.client.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Restaurant implements Serializable {

    @Id
    private long id;

    @OneToOne
    private User user;

    @OneToOne
    private Address address;

    @Column(unique = true)
    private String name;

}
