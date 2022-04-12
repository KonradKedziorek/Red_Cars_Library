package Models;

import Models.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "fault")
public class Fault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private Boolean fixedStatus;

    @OneToOne
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    public Fault(String description, Boolean fixedStatus, Car car) {
        this.description = description;
        this.fixedStatus = fixedStatus;
        this.car = car;
    }

    public Fault() {}
}
