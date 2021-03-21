package ru.lightapps.edadeal.dto;

import ru.lightapps.edadeal.entity.Segment;
import ru.lightapps.edadeal.entity.Shop;

public class SelectForm {

    private Segment segment;
    private Shop shop;

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

}
