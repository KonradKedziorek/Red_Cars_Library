package Models;

import Models.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicleInspection")
public class VehicleInspection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate validityDate;

    @OneToOne
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    public VehicleInspection(LocalDate validityDate, Car car) {
        this.validityDate = validityDate;
        this.car = car;
    }

    public VehicleInspection() {}
}
