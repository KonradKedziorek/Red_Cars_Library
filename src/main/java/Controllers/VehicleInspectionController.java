package Controllers;

import Models.Insurance;
import Models.VehicleInspection;
import Models.Wage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VehicleInspectionController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public void addVehicleInspection(VehicleInspection vehicleInspection){
        em.getTransaction().begin();
        em.merge(vehicleInspection);
        em.getTransaction().commit();
    }

    public void deleteVehicleInspection(VehicleInspection vehicleInspection){
        em.getTransaction().begin();
        em.remove(vehicleInspection);
        em.getTransaction().commit();
    }

    public boolean hasVehicleInspection(String VIN){
        List<VehicleInspection> vehicleInspectionList = em.createQuery("select v from VehicleInspection v join v.car where v.car.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getResultList();
        if(vehicleInspectionList.isEmpty()) return false;
        else return true;
    }

    public List<VehicleInspection> searchByVIN(String VIN){
        List<VehicleInspection> vehicleInspectionList = em.createQuery("select v from VehicleInspection v join v.car c where c.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getResultList();
        return vehicleInspectionList;
    }

    public VehicleInspection searchEntityByVIN(String VIN){
        VehicleInspection vehicleInspection = (VehicleInspection) em.createQuery("select v from VehicleInspection v join v.car c where c.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getSingleResult();
        return vehicleInspection;
    }

    public boolean exist(String VIN){
        List<VehicleInspection> vehicleInspectionList = em.createQuery("select v from VehicleInspection v join v.car c where c.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getResultList();
        if(vehicleInspectionList.isEmpty()) return false;
        else return true;
    }
}
