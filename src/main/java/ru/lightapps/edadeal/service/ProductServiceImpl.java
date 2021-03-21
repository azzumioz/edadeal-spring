package ru.lightapps.edadeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lightapps.edadeal.dao.ProductDAO;
import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;
import ru.lightapps.edadeal.entity.Shop;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    // number segment_id for all_category in DB
    private static final int ID_SEGMENT_ALL = 1;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductParseService productParseService;

    @Override
    @Transactional
    public List<Product> getAllProductsBySegmentAndShop(Segment segment, Shop shop) {
        if (segment.getId() == ID_SEGMENT_ALL) {
            return productDAO.getAllProducts();
        } else {
            return productDAO.getAllProductsBySegmentAndShop(segment, shop);
        }
    }

    @Override
    @Transactional
    public void parseProductsBySegmentAndRetailer(Segment segment, Shop shop) {
        List<Product> products = productParseService.parse(segment, shop);
        for (Product product : products) {
            productDAO.saveListProducts(product);
        }
    }
}
