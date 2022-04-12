package Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String driversLicenseNumber;

    public Client() {}

    public Client(String driversLicenseNumber, Person person) {
        this.driversLicenseNumber = driversLicenseNumber;
        this.person = person;
    }

    @OneToOne
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private Person person;

    @OneToOne(mappedBy = "client")
    private Rent rent;

    @OneToMany(mappedBy = "client")
    private Set<Reservation> reservations;

    @Override
    public String toString() {
        return "Client: " +
                "id: " + id +
                ", driversLicenseNumber: " + driversLicenseNumber +
                "\r\n";
    }

}
