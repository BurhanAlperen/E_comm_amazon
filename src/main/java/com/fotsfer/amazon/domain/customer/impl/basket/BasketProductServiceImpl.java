package com.fotsfer.amazon.domain.customer.impl.basket;

import com.fotsfer.amazon.domain.customer.api.basket.BasketService;
import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductDto;
import com.fotsfer.amazon.domain.customer.api.basketProduct.BasketProductService;
import com.fotsfer.amazon.domain.customer.web.basketproduct.BasketProductResponse;
import com.fotsfer.amazon.domain.product.impl.product.Product;
import com.fotsfer.amazon.domain.user.impl.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketProductServiceImpl implements BasketProductService {
    @Autowired
    BasketProductRepository repository;


    @Override
    public BasketProduct exist(int basketId, int productId) {
        return repository.findBasketProductByBasket_BasketIdAndProduct_ProductId(basketId, productId);
    }

    public BasketProductDto save(BasketProductDto basketProduct) {
        BasketProduct entity = repository.save(toEntity(basketProduct));
        return toDto(entity);
    }

    public void delete(int basketId, int productId) {
        BasketProduct entity = repository.findBasketProductByBasket_BasketIdAndProduct_ProductId(basketId, productId);
        repository.delete(entity);
    }




    private BasketProductDto toDto(BasketProduct basketProduct) {
        BasketProductDto dto = new BasketProductDto();
        dto.setBasketProductId(basketProduct.getId());
        dto.setBasketProductAmount(basketProduct.getBasketProductAmount());
        dto.setCount(basketProduct.getCount());
        return dto;
    }

    private BasketProduct toEntity(BasketProductDto dto) {
        BasketProduct entity = new BasketProduct();
        entity.setBasketProductAmount(dto.getBasketProductAmount());
        entity.setCount(dto.getCount());
        return entity;
    }
}
