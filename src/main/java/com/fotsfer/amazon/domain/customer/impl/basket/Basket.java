package com.fotsfer.amazon.domain.customer.impl.basket;

import com.fotsfer.amazon.domain.user.impl.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Basket {
    public static final int BASKET_STATUS_NONE = 0;
    public static final int BASKET_STATUS_READY_TO_PAY = 1;
    public static final int BASKET_STATUS_PAYED = 2;
    public static final int BASKET_STATUS_PROCESSING = 3;
    public static final int BASKET_STATUS_DELIVERED = 4;
    public static final int BASKET_STATUS_DONE = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer basketId;
    private double amount;
    private int status;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketProduct> basketProductList;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
