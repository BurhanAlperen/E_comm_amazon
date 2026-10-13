package com.fotsfer.amazon.domain.product.impl.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByProductId(int productId);
}
