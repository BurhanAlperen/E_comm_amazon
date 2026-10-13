package com.fotsfer.amazon.domain.customer.impl.basket;

import com.fotsfer.amazon.domain.product.impl.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int count;                      //Sepete eklenen ürünlerin sayısını belirtir
    private double basketProductAmount;     //Sepete eklenen ürünlerin fiyatını belirtir

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @OneToOne
    private Product product;
}
