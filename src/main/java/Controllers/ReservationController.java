package Controllers;

import Models.Person;
import Models.Rent;
import Models.Reservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class ReservationController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public boolean exist(Reservation reservation){
        List<Reservation> reservationList = em.createQuery("select r from Reservation r join r.client join r.car where r.client = :client " +
                        "and r.car = :car and r.issueDate = :issueDate and r.returnDate = :returnDate")
                .setParameter("client", reservation.getClient())
                .setParameter("car", reservation.getCar())
                .setParameter("issueDate", reservation.getIssueDate())
                .setParameter("returnDate", reservation.getReturnDate())
                .getResultList();
        if(reservationList.isEmpty()) return false;
        else return true;
    }

    public void addReservation(Reservation reservation){
        em.getTransaction().begin();
        em.merge(reservation);
        em.getTransaction().commit();
    }

    public void removeOutOfDateReservations(){
        List<Reservation> reservationList = em.createQuery("select r from Reservation r where r.issueDate = :today")
                .setParameter("today", LocalDate.now().minusDays(1))
                .getResultList();
        for(Reservation r : reservationList){
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
        }
    }

    public List<Reservation> searchReservationByClientsPesel(String pesel){
        List<Reservation> reservationList = em.createQuery("select r from Reservation r join r.client c join c.person p where p.pesel like :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        return reservationList;
    }

    public void deleteReservation(Reservation reservation){
        em.getTransaction().begin();
        em.remove(reservation);
        em.getTransaction().commit();
    }

}
