package Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate issueDate;
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Reservation(LocalDate issueDate, LocalDate returnDate, Client client, Car car) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.client = client;
        this.car = car;
    }

    public Reservation() {}

}
