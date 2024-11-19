package io.codeforall.fanstatics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sandbox {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Type suv = new Type();
            suv.setName("SUV");
            Type sport = new Type();
            sport.setName("Sport");

            em.persist(suv);
            em.persist(sport);

            Car mercedes = new Car();
            mercedes.setBrand("Mercedes");
            Car ferrari = new Car();
            ferrari.setBrand("Ferrari");

            List<Type> mercedesTypes = new ArrayList<>();
            mercedesTypes.add(suv);
            mercedes.setTypes(mercedesTypes);

            List<Type> ferrariTypes = new ArrayList<>();
            ferrariTypes.add(sport);
            ferrari.setTypes(ferrariTypes);

            em.persist(mercedes);
            em.persist(ferrari);

            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

}