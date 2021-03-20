package ru.lightapps.edadeal.dao;

import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;

import java.util.List;

public interface ProductDAO {
    public List<Product> getAllProducts();

    public void saveListProducts(Product product);

    public List<Product> getAllProductsBySegment(Segment segment);
}
