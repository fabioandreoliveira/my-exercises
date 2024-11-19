package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Sandbox {

    public static void main(String[] args) {


        // Use the test persistence unit to configure a new
        // entity manager factory and start up JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        // Open a new database connection by getting a new
        // entity manager from the entity manager factory
        EntityManager em = emf.createEntityManager();


        Owner owner = new Owner();
        Car car = new Car();

        car.setId(1);
        car.setMake("BMW");
        car.setModel("118");

        owner.setId(1);
        owner.setName("Fábio");

        owner.setCar(car);
        car.setOwner(owner);



        em.getTransaction().begin();
        em.persist(car);
        em.persist(owner);
        em.getTransaction().commit();

        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();


    }
}
