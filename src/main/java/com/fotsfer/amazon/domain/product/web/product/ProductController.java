package com.fotsfer.amazon.domain.product.web.product;

import com.fotsfer.amazon.domain.product.api.product.ProductDto;
import com.fotsfer.amazon.domain.product.api.product.ProductService;
import com.fotsfer.amazon.domain.product.impl.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping
    public ProductResponse save(@RequestBody ProductRequest product){
        ProductDto dto = service.save(toDto(product));
        return toResponse(dto);
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Integer id){
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@RequestBody ProductDto productDto, @PathVariable Integer id){
        ProductDto dto = service.update(productDto, id);
        return toResponse(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    public ProductResponse toResponse(ProductDto dto){
        ProductResponse response = new ProductResponse();
        response.setProductId(dto.getProductId());
        response.setProductName(dto.getProductName());
        response.setProductAmount(dto.getProductAmount());
        return  response;
    }

    public ProductDto toDto(ProductRequest request){
        ProductDto dto = new ProductDto();
        dto.setProductName(request.getProductName());
        dto.setProductAmount(request.getProductAmount());
        return dto;
    }


}
