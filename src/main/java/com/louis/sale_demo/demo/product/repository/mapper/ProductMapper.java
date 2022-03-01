package com.louis.sale_demo.demo.product.repository.mapper;

import com.louis.sale_demo.demo.product.entity.ProductPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductMapper extends JpaRepository<ProductPo, Long> {

}
