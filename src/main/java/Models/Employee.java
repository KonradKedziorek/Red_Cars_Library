package Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate employedSince;

    @OneToOne
    @JoinColumn(name = "personId", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name="positionId", nullable=false)
    private Wage wage;

    public Employee() {}

    public Employee(LocalDate employedSince, Person person, Wage wage) {
        this.employedSince = employedSince;
        this.person = person;
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee: " +
                ", id: " + id +
                ", employedSince: " + employedSince +
                ", name: " + person.getName() +
                ", surname: " + person.getSurname();
    }
}
