package Controllers;

import Models.Car;
import Models.Employee;
import Models.Insurance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class InsuranceController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public void addInsurance(Insurance insurance){
        em.getTransaction().begin();
        em.merge(insurance);
        em.getTransaction().commit();
    }

    public void deleteInsurance(Insurance insurance){
        em.getTransaction().begin();
        em.remove(insurance);
        em.getTransaction().commit();
    }

    public boolean hasInsurance(String VIN){
        List<Insurance> insuranceList = em.createQuery("select i from Insurance i join i.car where i.car.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getResultList();
        if(insuranceList.isEmpty()) return false;
        else return true;
    }

    public List<Insurance> searchByVIN(String VIN){
        List<Insurance> insuranceList = em.createQuery("select i from Insurance i join i.car c where c.VIN like :VIN")
                .setParameter("VIN", VIN)
                .getResultList();
        return insuranceList;
    }

}
