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


        Cadet cadet = new Cadet();
        Address address = new Address();
        //cadet.setId(1);
        cadet.setName("Rona");
        cadet.setAge(39);
        address.setCity("Funchal");
        address.setStreet("Rua 123");
        address.setZipcode("6000-123");
        cadet.setAddress(address);

        em.getTransaction().begin();
        em.persist(cadet);
        em.getTransaction().commit();

        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();


    }
}
