package ru.lightapps.edadeal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lightapps.edadeal.entity.Shop;

import java.util.List;

@Repository
public class ShopDAOImpl implements ShopDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Shop> getAllShops() {
        Session session = sessionFactory.getCurrentSession();
        Query<Shop> query = session.createQuery("from Shop", Shop.class);
        return query.getResultList();
    }

    @Override
    public Shop getShop(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Shop.class, id);
    }
}
