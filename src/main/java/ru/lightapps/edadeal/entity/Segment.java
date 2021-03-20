package ru.lightapps.edadeal.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "segment")
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "value")
    private String value;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "segment_id")
    private List<Product> products;

    public Segment() {
    }

    public Segment(String title, String value) {
        this.title = title;
        this.value = value;
    }

    public void addProductToSegment(Product product) {
        if (products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
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
        return "Segment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
