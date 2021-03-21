package ru.lightapps.edadeal.dao;

import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;
import ru.lightapps.edadeal.entity.Shop;

import java.util.List;

public interface ProductDAO {
    public List<Product> getAllProducts();

    public void saveListProducts(Product product);

    public List<Product> getAllProductsBySegmentAndShop(Segment segment, Shop shop);
}
