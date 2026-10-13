package com.fotsfer.amazon.domain.customer.impl.basket;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
    Basket findBasketByUser_UserIdAndStatus(int userId, int basketStatus);
}
