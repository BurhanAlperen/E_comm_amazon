package com.fotsfer.amazon.domain.product.impl.product;

import com.fotsfer.amazon.domain.product.api.product.ProductDto;
import com.fotsfer.amazon.domain.product.api.product.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    public ProductDto save(ProductDto product) {
        Product entity = repository.save(toEntity(product));
        return toDto(entity);
    }

    @Override
    public Product getProductById(int productId){
        return repository.findProductByProductId(productId);
    }

    public void delete(Integer productId) {
        Product entity = repository.findById(productId).get();
        repository.delete(entity);
    }
    
    public ProductDto update(ProductDto productDto, Integer productId) {
        Product existingProduct = repository.findById(productId).
                orElseThrow(()-> new IllegalArgumentException("Product not found with id: " + productId));
        existingProduct.setName(productDto.getProductName());
        existingProduct.setAmount(productDto.getProductAmount());
        Product updatedProduct = repository.save(existingProduct);
        return toDto(updatedProduct);
    }



    private ProductDto toDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getName());
        productDto.setProductAmount(product.getAmount());
        return productDto;
    }

    private Product toEntity(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getProductName());
        product.setAmount(productDto.getProductAmount());
        return product;
    }

}
