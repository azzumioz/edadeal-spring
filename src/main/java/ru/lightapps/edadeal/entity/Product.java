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

    @Column(name = "segment_id")
    private int segmentId;

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

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "date")
    private LocalDateTime date;

    public Product() {
    }

    public Product(int segmentId, String title, String quantity, BigDecimal priceNew, BigDecimal priceOld, String discount, String discountDate, String shopName, LocalDateTime date) {
        this.segmentId = segmentId;
        this.title = title;
        this.quantity = quantity;
        this.priceNew = priceNew;
        this.priceOld = priceOld;
        this.discount = discount;
        this.discountDate = discountDate;
        this.shopName = shopName;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", segmentId=" + segmentId +
                ", title='" + title + '\'' +
                ", quantity='" + quantity + '\'' +
                ", priceNew=" + priceNew +
                ", priceOld=" + priceOld +
                ", discount='" + discount + '\'' +
                ", discountDate='" + discountDate + '\'' +
                ", shopName='" + shopName + '\'' +
                ", date=" + date +
                '}';
    }
}
