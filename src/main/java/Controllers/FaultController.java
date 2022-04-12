package Controllers;

import Models.Fault;
import Models.Insurance;
import Models.VehicleInspection;
import Models.Wage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class FaultController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public void addFault(Fault fault){
        em.getTransaction().begin();
        em.merge(fault);
        em.getTransaction().commit();
    }

    public void updateFault(Fault fault){
        em.getTransaction().begin();
        em.merge(fault);
        em.getTransaction().commit();
    }

    public void deleteFault(Fault fault){
        em.getTransaction().begin();
        em.remove(fault);
        em.getTransaction().commit();
    }

    public boolean hasFault(String VIN){
        List<Fault> faultList = em.createQuery("select f from Fault f join f.car where f.car.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getResultList();
        if(faultList.isEmpty()) return false;
        else return true;
    }

    public List<Fault> searchByVIN(String VIN){
        List<Fault> faultList = em.createQuery("select f from Fault f join f.car c where c.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getResultList();
        return faultList;
    }

}
