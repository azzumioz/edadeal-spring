package ru.lightapps.edadeal.service;

import ru.lightapps.edadeal.entity.Product;
import ru.lightapps.edadeal.entity.Segment;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProductsBySegment(Segment segment);

    public void requestProduct(int segmentId);
}
