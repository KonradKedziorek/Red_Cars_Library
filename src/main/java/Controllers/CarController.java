package Controllers;

import Models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class CarController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Car> searchCarById(long carId){
        List<Car> cars = em.createQuery("select c from Car c where c.id = :carId")
                .setParameter("carId", carId)
                .getResultList();
        return cars;
    }

    public Car searchCarById2(long carId){
        Car car = (Car) em.createQuery("select c from Car c where c.id = :carId")
                .setParameter("carId", carId)
                .getSingleResult();
        return car;
    }

    public List<Car> searchCarByVIN(String VIN){
        List<Car> cars = em.createQuery("select c from Car c where c.VIN like :VIN")
                .setParameter("VIN","%" + VIN + "%")
                .getResultList();
        return cars;
    }

    public List<Car> searchOneCarByVIN(String VIN){
        List<Car> cars = em.createQuery("select c from Car c where c.VIN like :VIN")
                .setParameter("VIN",VIN)
                .getResultList();
        return cars;
    }

    public List<Car> searchCarByBrand(String brand){
        List<Car> cars =  em.createQuery("select c from Car c where c.brand like :brand")
                .setParameter("brand", "%" + brand + "%")
                .getResultList();
        return cars;
    }

    public List<Car> searchCarByModel(String model){
        List<Car> cars = em.createQuery("select c from Car c where c.model like :model")
                .setParameter("model", "%" + model + "%")
                .getResultList();
        return cars;
    }

    public List<Car> searchAllCars(){
        List<Car> cars = em.createQuery("select c from Car c")
                .getResultList();
        return cars;
    }

    public void addCar(Car car){
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public void deleteCar(Car car){
        em.getTransaction().begin();
        em.remove(car);
        em.getTransaction().commit();
    }

    public void updateCar(Car car){
        em.getTransaction().begin();
        em.merge(car);
        em.getTransaction().commit();
    }

    public boolean isRented(Car car){
        List<Car> cars = em.createQuery("select c from Car c join c.rent r where r.id = :id")
                .setParameter("id", car.getId())
                .getResultList();
        if(cars.isEmpty()) return false;
        else return true;
    }

    public boolean exist(Car car){
        List<Car> cars = em.createQuery("select c from Car c where c.VIN like :VIN")
                .setParameter("VIN", car.getVIN())
                .getResultList();
        if(cars.isEmpty()) return false;
        else return true;
    }

    public boolean existCarByVIN(String VIN){
        List<Car> cars = em.createQuery("select c from Car c where c.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getResultList();
        if(cars.isEmpty()) return false;
        else return true;
    }

    public boolean isAvailable(Car car){
        List<Rent> rents = em.createQuery("select r from Rent r join r.car c where c.VIN like :VIN")
                .setParameter("VIN", car.getVIN())
                .getResultList();
        if(rents.isEmpty()) return true;
        else return false;
    }

    public boolean hasVehicleInspection(Car car){
        List<VehicleInspection> vehicleInspectionList = em.createQuery("select v from VehicleInspection v join v.car c where c.VIN like :VIN")
                .setParameter("VIN", car.getVIN())
                .getResultList();
        if(vehicleInspectionList.isEmpty()) return true;
        else return false;
    }

    public boolean carReserved(String VIN, LocalDate issueDate, LocalDate returnDate){
        List<Car> cars = em.createQuery("select c from Car c join c.reservations r where c.VIN like :VIN and ((r.issueDate < :issueDate and r.returnDate between :issueDate and :returnDate) " +
                "or (r.issueDate between :issueDate and :returnDate and r.returnDate between :issueDate and :returnDate) or (r.issueDate between :issueDate and :returnDate and r.returnDate > :returnDate))")
                .setParameter("VIN", VIN)
                .setParameter("issueDate", issueDate)
                .setParameter("returnDate", returnDate)
                .getResultList();
        for(Car c : cars){
            System.out.println(c);
        }
        if(cars.isEmpty()) return false;
        else return true;
    }

    public boolean carRented(String VIN, LocalDate issueDate){
        List<Car> cars = em.createQuery("select c from Car c join c.rent r where c.VIN like :VIN and r.returnDate > :issueDate")
                .setParameter("VIN", VIN)
                .setParameter("issueDate", issueDate)
                .getResultList();
        if(cars.isEmpty()) return false;
        else return true;
    }

}
