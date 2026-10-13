package com.fotsfer.amazon.domain.customer.web.basket;

import com.fotsfer.amazon.domain.customer.api.basket.BasketDto;
import com.fotsfer.amazon.domain.customer.api.basket.BasketService;
import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    BasketService service;

    // Sepete ürün ekleme (BASKET_STATUS_NONE)
    @PostMapping
    public BasketResponse addBasket(@RequestBody BasketRequest request) {
        BasketDto dto = service.addBasket(toDto(request));
        return toResponse(dto);
    }

    private BasketDto toDto(BasketRequest request) {
        BasketDto dto = new BasketDto();
        dto.setUserId(request.getUserId());

        BasketProductDto productDto = new BasketProductDto();
        productDto.setProductId(request.getProductId());
        productDto.setCount(request.getCount());

        List<BasketProductDto> products = new ArrayList<>();
        products.add(productDto);
        dto.setProducts(products);

        return dto;
    }

    private BasketResponse toResponse(BasketDto dto) {
        BasketResponse response = new BasketResponse();
        if (dto.getBasketId() != null) {
            response.setBasketId(dto.getBasketId());
        }
        response.setUserId(dto.getUserId());
        response.setStatus(dto.getStatus());
        response.setTotalPrice(dto.getTotalPrice());
        response.setProducts(dto.getProducts());
        return response;
    }

}
