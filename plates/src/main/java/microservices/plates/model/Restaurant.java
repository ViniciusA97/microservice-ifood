package microservices.plates.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Restaurant implements Serializable {

    @Id
    private long id;

    @Column(unique = true)
    private String name;

}
