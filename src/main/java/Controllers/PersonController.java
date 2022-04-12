package Controllers;

import Models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PersonController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Person> searchPersonByPesel(String pesel){
        List<Person> persons = em.createQuery("select p from Person p where p.pesel like :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        return persons;
    }

    public List<Person> searchPersonById(long id){
        List<Person> persons = em.createQuery("select p from Person p where p.id = :id")
                .setParameter("id", id)
                .getResultList();
        return persons;
    }

    public Person searchPersonById2(long personId){
        Person person = (Person) em.createQuery("select p from Person p where p.id = :personId")
                .setParameter("personId", personId)
                .getSingleResult();
        return person;
    }

    public void addPerson(Person person){
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void deletePersonById(long id){
        em.getTransaction().begin();
        em.remove(searchPersonById(id));
        em.getTransaction().commit();
    }

    public void updatePerson(Person person){
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public void deletePerson(Person person){
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }

    public boolean exist(Person person){
        List<Person> personList = em.createQuery("select p from Person p where p.pesel like :pesel")
                .setParameter("pesel", person.getPesel())
                .getResultList();
        if(personList.isEmpty()) return false;
        else return true;
    }

    public boolean exist(String pesel){
        List<Person> personList = em.createQuery("select p from Person p where p.pesel like :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        if(personList.isEmpty()) return false;
        else return true;
    }

}
