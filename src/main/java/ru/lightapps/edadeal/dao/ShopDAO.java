package ru.lightapps.edadeal.dao;

import ru.lightapps.edadeal.entity.Shop;

import java.util.List;

public interface ShopDAO {
    public List<Shop> getAllShops();

    public Shop getShop(int id);

}

