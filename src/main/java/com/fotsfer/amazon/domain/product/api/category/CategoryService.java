package com.fotsfer.amazon.domain.product.api.category;


public interface CategoryService {
    CategoryDto save(CategoryDto dto);

    CategoryDto find(Integer id);

    CategoryDto update(Integer id, CategoryDto dto);

    void delete(Integer id);
}
