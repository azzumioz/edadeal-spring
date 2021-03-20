package ru.lightapps.edadeal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lightapps.edadeal.dao.ProductDAO;
import ru.lightapps.edadeal.dao.SegmentDAO;
import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    // number segment_id for all_category in DB
    private static final int ID_SEGMENT_ALL = 1;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private SegmentDAO segmentDAO;

    @Autowired
    private ProductParseService productParseService;

    @Override
    @Transactional
    public List<Product> getAllProductsBySegment(Segment segment) {
        if (segment.getId() == ID_SEGMENT_ALL) {
            return productDAO.getAllProducts();
        } else {
            return productDAO.getAllProductsBySegment(segment);
        }
    }

    @Override
    @Transactional
    public void requestProduct(int segmentId) {
        Segment segment = segmentDAO.getSegment(segmentId);
        List<Product> products = productParseService.parse(segmentId, segment.getValue());
        for (Product product : products) {
            productDAO.saveListProducts(product);
        }
    }
}
