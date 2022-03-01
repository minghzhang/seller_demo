package com.louis.sale_demo.demo.product.service;

import com.louis.sale_demo.demo.product.domain.Product;
import com.louis.sale_demo.demo.product.repository.ProductRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> findByIds(List<Long> productIds) {
        return productRepository.findByIds(productIds);
    }
}
