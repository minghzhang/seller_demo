package com.louis.sale_demo.demo.product.service;

import com.louis.sale_demo.demo.product.domain.Product;
import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    Product findById(Long productId);

    List<Product> findByIds(List<Long> productIds);
}
