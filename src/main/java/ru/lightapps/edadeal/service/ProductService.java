package ru.lightapps.edadeal.service;

import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;
import ru.lightapps.edadeal.entity.Shop;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProductsBySegmentAndShop(Segment segment, Shop shop);

    public void parseProductsBySegmentAndRetailer(Segment segment, Shop shop);
}
