package ru.lightapps.edadeal.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        Query query = session.createSQLQuery("Select a.* from product as a inner join (SELECT segment_id, max(date) as md FROM product group by segment_id) as b on a.segment_id = b.segment_id and a.date = b.md;");
        List<Object[]> rows = query.list();
        for (Object[] row : rows) {
            Product product = new Product();
            product.setId((int) row[0]);
            product.setSegmentId((int) row[1]);
            product.setTitle(row[2].toString());
            product.setQuantity(row[3].toString());
            product.setPriceNew((BigDecimal) row[4]);
            product.setPriceOld((BigDecimal) row[5]);
            product.setDiscount(row[6].toString());
            product.setDiscountDate(row[7].toString());
            product.setShopName((String) row[8]);
            if (row[9] instanceof LocalDateTime) {
                product.setDate((LocalDateTime) row[9]);
            }
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
    public List<Product> getAllProductsBySegment(Segment segment) {
        Session session = sessionFactory.getCurrentSession();
        int segmentId = segment.getId();
        Query<Product> query = session.createQuery("select a from Product a where date = (select max(date) from Product where segment_id = :segmentId)", Product.class);
        query.setParameter("segmentId", segmentId);
        return query.getResultList();
    }

}
