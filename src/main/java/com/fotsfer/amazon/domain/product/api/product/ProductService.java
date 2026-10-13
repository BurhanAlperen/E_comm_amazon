package com.fotsfer.amazon.domain.product.api.product;

import com.fotsfer.amazon.domain.customer.impl.basket.Basket;
import com.fotsfer.amazon.domain.product.impl.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductService  {
    public Product getProductById(int productId);
    public void delete(Integer productId);
    public ProductDto save(ProductDto productDto);
    public ProductDto update(ProductDto productDto, Integer productId);
}
