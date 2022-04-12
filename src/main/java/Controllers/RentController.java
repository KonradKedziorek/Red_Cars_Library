package Controllers;

import Models.Car;
import Models.Rent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class RentController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Rent> searchRentById(long id){
        List<Rent> rents = em.createQuery("select r from Rent r where r.id = :id")
                .setParameter("id", id)
                .getResultList();
        return rents;
    }

    public Rent searchRentById2(long rentId){
        Rent rent = (Rent) em.createQuery("select r from Rent r where r.id = :rentId")
                .setParameter("rentId", rentId)
                .getSingleResult();
        return rent;
    }

    public List<Rent> searchRentByClientsPesel(String pesel){
        List<Rent> rent = em.createQuery("select r from Rent r join r.client c join c.person p where p.pesel like :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        return rent;
    }

    public void addRent(Rent rent){
        em.getTransaction().begin();
        em.merge(rent);
        em.getTransaction().commit();
    }

    public void deleteRentById(long id){
        em.getTransaction().begin();
        em.remove(searchRentById(id));
        em.getTransaction().commit();
    }

    public void deleteRent(Rent rent){
        em.getTransaction().begin();
        em.remove(rent);
        em.getTransaction().commit();
    }

    public boolean exist(Rent rent){
        List<Rent> rents = em.createQuery("select r from Rent r where r.car = :car and r.client = :client and r.issueDate = :issueDate and r.returnDate = :returnDate")
                .setParameter("car", rent.getCar())
                .setParameter("client", rent.getClient())
                .setParameter("issueDate", rent.getIssueDate())
                .setParameter("returnDate", rent.getReturnDate())
                .getResultList();
        if(rents.isEmpty()) return false;
        else return true;
    }

}
