package Controllers;

import Models.Person;
import Models.Wage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class WageController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Wage> searchWageByPosition(String position){
        List<Wage> wages = em.createQuery("select w from Wage w where w.position like :position")
                .setParameter("position", position)
                .getResultList();
        return wages;
    }

    public boolean existPosition(String position){
        List<Wage> wages = em.createQuery("select w from Wage w where w.position like :position")
                .setParameter("position", position)
                .getResultList();
        if(wages.isEmpty()) return false;
        else return true;
    }

    public void addWage(Wage wage){
        em.getTransaction().begin();
        em.merge(wage);
        em.getTransaction().commit();
    }

    public void updateWage(Wage wage){
        em.getTransaction().begin();
        em.merge(wage);
        em.getTransaction().commit();
    }

    public void deleteWage(Wage wage){
        em.getTransaction().begin();
        em.remove(wage);
        em.getTransaction().commit();
    }

}
