package microservices.plates.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true)
    private String name;

}
