package com.fotsfer.amazon.domain.product.impl.store;

import com.fotsfer.amazon.domain.product.impl.category.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;
    private String storeName;
    private double rate;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Category> categoryList;
}
