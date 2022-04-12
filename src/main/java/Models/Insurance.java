package Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate startInsureDate;
    private LocalDate endInsureDate;

    @OneToOne
    @JoinColumn(name = "carId", referencedColumnName = "id")
    private Car car;

    public Insurance(LocalDate startInsureDate, LocalDate endInsureDate, Car car) {
        this.startInsureDate = startInsureDate;
        this.endInsureDate = endInsureDate;
        this.car = car;
    }

    public Insurance() {}
}
