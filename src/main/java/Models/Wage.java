package Models;

import Models.Employee;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "wage")
public class Wage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String position;
    private double wage;

    public Wage(String position, double wage) {
        this.position = position;
        this.wage = wage;
    }

    @OneToMany(mappedBy="wage")
    private Set<Employee> employees;

    public Wage() {}

}