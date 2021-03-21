package ru.lightapps.edadeal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;
import ru.lightapps.edadeal.entity.Shop;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = new ArrayList<>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product", Product.class);
        List<Product> products = query.getResultList();
        for (Product product : products) {
            System.out.println("product = " + product);
            allProducts.add(product);
        }
        return allProducts;
    }

    @Override
    public void saveListProducts(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
    }

    @Override
    public List<Product> getAllProductsBySegmentAndShop(Segment segment, Shop shop) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("segment = " + segment);
        int segmentId = segment.getId();
        int shopId = shop.getId();
        Query<Product> query = session.createQuery("select a from Product a where date = (select max(date) from Product where segment_id = :segmentId and shop_id = :shopId)", Product.class);
        query.setParameter("segmentId", segmentId);
        query.setParameter("shopId", shopId);
        return query.getResultList();
    }

}
