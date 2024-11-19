package io.codeforall.fanstatics;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "car_type", // Nome da tabela de junção
            joinColumns = @JoinColumn(name = "car_id"), // FK para Car
            inverseJoinColumns = @JoinColumn(name = "type_id") // FK para Type
    )
    private List<Type> types;


    public void addCar(String brand, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Car car = new Car();

        try {
            em.getTransaction().begin();
            em.persist(car);

            car.setBrand(brand);

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public Car findById(Integer id, EntityManagerFactory emf) {

        // open a new connection to the database
        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Car.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }
}