package ru.lightapps.edadeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lightapps.edadeal.dao.ShopDAO;
import ru.lightapps.edadeal.entity.Shop;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;

    @Override
    @Transactional
    public List<Shop> getAllShops() {
        return shopDAO.getAllShops();
    }

    @Override
    @Transactional
    public Shop getShop(int id) {
        return shopDAO.getShop(id);
    }
}
