package Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    private String licensePlate;
    private long productionDate;
    private long mileage;
    private String fuel;
    private String VIN;
    private double price;

    public Car(String brand, String model, String licensePlate, Long productionDate, Long mileage, String fuel, String VIN, double price) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.productionDate = productionDate;
        this.mileage = mileage;
        this.fuel = fuel;
        this.VIN = VIN;
        this.price = price;
    }

    @OneToMany(mappedBy = "car")
    private Set<Reservation> reservations;


    @OneToOne(mappedBy = "car")
    private Fault fault;

    @OneToOne(mappedBy = "car")
    private Rent rent;

    public Car() {}

    @OneToOne(mappedBy = "car")
    private VehicleInspection vehicleInspection;

    @OneToOne(mappedBy = "car")
    private Insurance insurance;

    @Override
    public String toString() {
        return "Car:" +
                " brand: " + brand + ',' +
                " model: " + model + ',' +
                " licensePlate: " + licensePlate + ',' +
                " productionDate: " + productionDate + ',' +
                " mileage: " + mileage + ',' +
                " fuel: " + fuel + ',' +
                " VIN: " + VIN + ',' +
                "\r\n";
    }
}
