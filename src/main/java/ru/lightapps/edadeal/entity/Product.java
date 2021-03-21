package ru.lightapps.edadeal.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "price_new")
    private BigDecimal priceNew;

    @Column(name = "price_old")
    private BigDecimal priceOld;

    @Column(name = "discount")
    private String discount;

    @Column(name = "discount_date")
    private String discountDate;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "segment_id")
    private Segment segment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public Product() {
    }

    public Product(String title, String quantity, BigDecimal priceNew, BigDecimal priceOld, String discount, String discountDate, String shopName, LocalDateTime date) {
        this.title = title;
        this.quantity = quantity;
        this.priceNew = priceNew;
        this.priceOld = priceOld;
        this.discount = discount;
        this.discountDate = discountDate;
        this.date = date;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(BigDecimal priceNew) {
        this.priceNew = priceNew;
    }

    public BigDecimal getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(BigDecimal priceOld) {
        this.priceOld = priceOld;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(String discountDate) {
        this.discountDate = discountDate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity='" + quantity + '\'' +
                ", priceNew=" + priceNew +
                ", priceOld=" + priceOld +
                ", discount='" + discount + '\'' +
                ", discountDate='" + discountDate + '\'' +
                ", date=" + date +
                '}';
    }
}
