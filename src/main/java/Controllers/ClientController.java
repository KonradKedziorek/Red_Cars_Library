package Controllers;

import Models.Client;
import Models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ClientController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Client> searchClientById(long id){
        List<Client> clients = em.createQuery("select c from Client c where c.id = :id")
                .setParameter("id", id)
                .getResultList();
        return clients;
    }

    public void addClient(Client client){
        em.getTransaction().begin();
        em.merge(client);
        em.getTransaction().commit();
    }

    public void deleteClientById(long id){
        em.getTransaction().begin();
        em.remove(searchClientById(id));
        em.getTransaction().commit();
    }

    public void deleteClient(Client client){
        em.getTransaction().begin();
        em.remove(client);
        em.getTransaction().commit();
    }

    public boolean existClient(String pesel){
        List<Client> clientList = em.createQuery("select c from Client c join c.person p where p.pesel like :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        if(clientList.isEmpty()) return false;
        else return true;
    }

    public List<Client> searchClientByPesel(String pesel){
        List<Client> clients = em.createQuery("select c from Client c join c.person p where p.pesel like :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        return clients;
    }

}
