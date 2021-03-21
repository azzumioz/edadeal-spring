package ru.lightapps.edadeal.service;

import ru.lightapps.edadeal.entity.Shop;

import java.util.List;

public interface ShopService {
    public List<Shop> getAllShops();

    public Shop getShop(int id);
}
