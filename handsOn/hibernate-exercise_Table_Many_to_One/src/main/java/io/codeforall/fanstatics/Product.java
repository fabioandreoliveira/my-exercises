package io.codeforall.fanstatics;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    private Integer id;
    private String name;

    @ManyToOne
    private Category category; // for bidirectionality

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
