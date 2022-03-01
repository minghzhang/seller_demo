package com.louis.sale_demo.demo.product.converter;

import com.louis.sale_demo.demo.product.domain.Product;
import com.louis.sale_demo.demo.product.entity.ProductPo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductConvert {

    public ProductPo toPo(Product product) {
        ProductPo productPo = new ProductPo();
        BeanUtils.copyProperties(product, productPo);
        return productPo;
    }

    public Product toModel(ProductPo po) {
        Product product = new Product();
        BeanUtils.copyProperties(po, product);
        return product;
    }
}
