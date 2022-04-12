package Models;

import Models.Car;
import Models.Client;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long employeeId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    @OneToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    public Rent(long employeeId, LocalDate issueDate, LocalDate returnDate, Client client, Car car) {
        this.employeeId = employeeId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.client = client;
        this.car = car;
    }

    public Rent() {}

}
