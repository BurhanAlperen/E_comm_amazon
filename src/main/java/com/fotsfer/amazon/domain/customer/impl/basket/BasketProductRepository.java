package com.fotsfer.amazon.domain.customer.impl.basket;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketProductRepository extends JpaRepository<BasketProduct, Integer> {
   public BasketProduct findBasketProductByBasket_BasketIdAndProduct_ProductId(int basketId,int productId);
   /*
    "Basket productın içine gir, onun içerisindeki basketin içerisinde basket idisi benim sana verdiğimi al
    ve yine aynı basketproduct içerisindeki productın içerisinde sana verdiğim idli productı bana ver" demek
    */
}

