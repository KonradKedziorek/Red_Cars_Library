package Controllers;

import Models.Client;
import Models.Employee;
import Models.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
    EntityManager em = entityManagerFactory.createEntityManager();

    public List<Employee> searchById(long id){
        List<Employee> employees = em.createQuery("select e from Employee e where e.id = :id")
                .setParameter("id", id)
                .getResultList();
        return employees;
    }

    public boolean existEmployee(long id){
        List<Employee> employeeList = em.createQuery("select e from Employee e where e.id = :id")
                .setParameter("id", id)
                .getResultList();
        if(employeeList.isEmpty()) return false;
        else return true;
    }

    public boolean existEmployee(String pesel){
        List<Employee> employeeList = em.createQuery("select e from Employee e join e.person p where p.pesel like :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        if(employeeList.isEmpty()) return false;
        else return true;
    }

    public boolean existEmployeeOnPosition(String position){
        List<Employee> employeeList = em.createQuery("select e from Employee e join e.wage w where w.position like :position")
                .setParameter("position", position)
                .getResultList();
        if(employeeList.isEmpty()) return false;
        else return true;
    }

    public void addEmployee(Employee employee){
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    public void updateEmployee(Employee employee){
        em.getTransaction().begin();
        em.merge(employee);
        em.getTransaction().commit();
    }

    public boolean existEmployee(Employee employee){
        List<Employee> employeeList = em.createQuery("select e from Employee e join e.person p join e.wage w where p.pesel like :pesel and w.position like :position")
                .setParameter("pesel", employee.getPerson().getPesel())
                .setParameter("position", employee.getWage().getPosition())
                .getResultList();
        if(employeeList.isEmpty()) return false;
        else return true;
    }

    public List<Employee> searchByPesel(String pesel){
        List<Employee> employees = em.createQuery("select e from Employee e join e.person p where p.pesel = :pesel")
                .setParameter("pesel", pesel)
                .getResultList();
        return employees;
    }

    public void deleteEmployee(Employee employee){
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();
    }

}
