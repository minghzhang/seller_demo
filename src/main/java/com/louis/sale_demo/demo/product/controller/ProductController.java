package com.louis.sale_demo.demo.product.controller;

import com.louis.sale_demo.demo.product.domain.Product;
import com.louis.sale_demo.demo.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public void createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId) {
        Product product = productService.findById(productId);
        return product;
    }


}
