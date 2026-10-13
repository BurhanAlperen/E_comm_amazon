package com.fotsfer.amazon.domain.product.impl.category;


import com.fotsfer.amazon.domain.product.api.category.CategoryDto;
import com.fotsfer.amazon.domain.product.api.category.CategoryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
@Getter
@Setter
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository repository;

    public CategoryDto save(CategoryDto category) {
       Category entity = repository.save(toEntity(category));
       return toDto(entity);
    }

    public CategoryDto find(Integer id) {
        Category entity = repository.findById(id).get();
        return toDto(entity);
    }


    public void delete(Integer id) {
        Category category = repository.findById(id).get();
        repository.delete(category);
    }

    public CategoryDto update(Integer id, CategoryDto categoryDto) {
        Category existingCategory = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        //
        existingCategory.setCategoryName(categoryDto.getCategoryName());
        Category updatedCategory = repository.save(existingCategory);
        return toDto(updatedCategory);
    }


    private CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setCategoryId(category.getCategoryId());
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }

    private Category toEntity(CategoryDto dto) {
        Category entity = new Category();
        entity.setCategoryId(dto.getCategoryId());
        entity.setCategoryName(dto.getCategoryName());
        return entity;
    }


}
