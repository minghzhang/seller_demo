package com.louis.sale_demo.demo.product.repository;

import com.louis.sale_demo.demo.product.converter.ProductConvert;
import com.louis.sale_demo.demo.product.domain.Product;
import com.louis.sale_demo.demo.product.entity.ProductPo;
import com.louis.sale_demo.demo.product.repository.mapper.ProductMapper;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class ProductJpaRepository implements ProductRepository {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductConvert productConvert;

    @Override
    public void saveProduct(Product product) {
        ProductPo productPo = productConvert.toPo(product);
        productPo.setCreatedTime(Instant.now());
        productPo.setModifiedTime(Instant.now());
        productMapper.save(productPo);
    }

    @Override
    public Product findById(Long productId) {
        Optional<ProductPo> productPoOptional = productMapper.findById(productId);
        if (productPoOptional.isPresent()) {
            return productConvert.toModel(productPoOptional.get());
        }
        return null;
    }

    @Override
    public List<Product> findByIds(List<Long> productIds) {
        if (CollectionUtils.isEmpty(productIds)) {
            return Collections.emptyList();
        }
        List<ProductPo> productPoList = productMapper.findAllById(productIds);
        if (CollectionUtils.isEmpty(productPoList)) {
            return Collections.emptyList();
        }

        return productPoList.stream()
                .filter(Objects::nonNull)
                .map(po -> productConvert.toModel(po))
                .collect(Collectors.toList());
    }
}
