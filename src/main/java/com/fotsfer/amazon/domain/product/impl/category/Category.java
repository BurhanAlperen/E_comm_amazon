package com.fotsfer.amazon.domain.product.impl.category;

import com.fotsfer.amazon.domain.product.impl.product.Product;
import com.fotsfer.amazon.domain.product.impl.store.Store;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    public static final String COLUMN_NAME_CATEGORY_ID = "category_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany
    @JoinColumn(name = COLUMN_NAME_CATEGORY_ID)
    private List<Product> products;
}