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
public class Client implements Serializable {

    @Id
    private long id;

    @Column
    private String name;

    @OneToOne()
    private Address address;

    @OneToOne
    private User user;


}
