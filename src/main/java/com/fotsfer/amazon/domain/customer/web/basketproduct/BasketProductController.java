package com.fotsfer.amazon.domain.customer.web.basketproduct;

import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductDto;
import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductService;
import com.fotsfer.amazon.domain.customer.impl.basket.BasketProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basketproduct")
public class BasketProductController {

    @Autowired
    BasketProductService service;


    @PostMapping
    public BasketProductResponse save(@RequestBody BasketProductRequest basketProduct) {
        BasketProductDto dto = service.save(toDto(basketProduct));
        return toResponse(dto);
    }




    // TODO: Implement update and delete endpoints
    // @PutMapping("/{id}")
    // @DeleteMapping("/{id}")



    public BasketProductResponse toResponse(BasketProductDto dto){
        BasketProductResponse response = new BasketProductResponse();
        response.setCount(dto.getCount());
        response.setBasketProductAmount(dto.getBasketProductAmount());
        return response;
    }

    public BasketProductDto toDto(BasketProductRequest basketProduct){
        BasketProductDto dto = new BasketProductDto();
        dto.setCount(basketProduct.getCount());
        dto.setBasketProductAmount(basketProduct.getBasketProductAmount());
        return dto;
    }
}
