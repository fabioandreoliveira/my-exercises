package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class Sandbox {

    public static void main(String[] args) {


        // Use the test persistence unit to configure a new
        // entity manager factory and start up JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        // Open a new database connection by getting a new
        // entity manager from the entity manager factory
        EntityManager em = emf.createEntityManager();

        Category category = new Category();
        Product product1 = new Product();
        Product product2 = new Product();

        product1.setId(1);
        product1.setName("Champoo");
        product2.setId(2);
        product2.setName("Toothpaste");

        category.setId(1);
        category.setName("Hygiene");


        product1.setCategory(category);
        product2.setCategory(category);



        em.getTransaction().begin();
        em.persist(product1);
        em.persist(product2);
        em.persist(category);
        em.getTransaction().commit();

        Category foundCategory = em.find(Category.class, category.getId());
        Product product3 = new Product();
        product3.setName("Deodorant");

        em.getTransaction().begin();
        foundCategory.addProduct(product3);
        em.merge(foundCategory);
        em.getTransaction().commit();

        Category updateCategory = em.find(Category.class, category.getId());


        // Close the database connection
        em.close();

        // Shutdown JPA
        emf.close();


    }
}
