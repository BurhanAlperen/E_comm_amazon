package com.fotsfer.amazon.domain.customer.api.basketProduct;

import com.fotsfer.amazon.domain.customer.impl.basket.BasketProduct;

public interface BasketProductService {
    BasketProduct exist(int basketId, int productId);
    BasketProductDto save(BasketProductDto basketProduct);
}
