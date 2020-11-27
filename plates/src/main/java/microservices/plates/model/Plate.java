package microservices.plates.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Plate implements Serializable {

    @Id @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    @ManyToOne
    private Restaurant restaurant;

    public Plate(String name, String description, double price, Restaurant restaurant) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
    }
}
