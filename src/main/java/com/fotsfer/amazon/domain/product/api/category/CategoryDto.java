package com.fotsfer.amazon.domain.product.api.category;

import com.fotsfer.amazon.domain.product.impl.product.Product;
import com.fotsfer.amazon.domain.product.impl.store.Store;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private int categoryId;
    private String categoryName;
    private Store store;
    private List<Product> products;

}
