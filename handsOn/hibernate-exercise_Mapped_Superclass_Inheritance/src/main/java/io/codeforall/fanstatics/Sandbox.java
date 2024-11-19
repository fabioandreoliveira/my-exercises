package io.codeforall.fanstatics;

import net.bytebuddy.asm.Advice;

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


        Customer customer = new Customer();
        Account account = new Account();

        customer.setName("Fábio");
        account.setBalance(5000.00);






        em.getTransaction().begin();
        em.persist(customer);
        em.persist(account);
        em.getTransaction().commit();

        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();


    }
}
