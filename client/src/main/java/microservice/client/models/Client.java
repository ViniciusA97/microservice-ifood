package microservice.client.models;

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
@RequiredArgsConstructor
public class Client implements Serializable {

    @Id @GeneratedValue
    private long id;

    @Column @NonNull
    private String name;

    @OneToOne()
    private Address address;

    @Column(unique = true) @NonNull
    private String email;

    @Column(nullable = false) @NonNull
    private String password;

    public Client(@NonNull String name, Address address, @NonNull String email, @NonNull String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
    }
}
