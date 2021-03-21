package ru.lightapps.edadeal.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "value")
    private String value;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
    private List<Product> products;

    public Shop() {
    }

    public Shop(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
