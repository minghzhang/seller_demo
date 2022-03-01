package com.louis.sale_demo.demo.product.domain;

import com.louis.sale_demo.demo.common.domain.BaseDomain;
import lombok.Data;

@Data
public class Product extends BaseDomain {

    private String name;

    private Long price;

    private Long sellerId;
}
