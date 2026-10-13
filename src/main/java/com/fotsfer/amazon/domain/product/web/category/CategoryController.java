package com.fotsfer.amazon.domain.product.web.category;

import com.fotsfer.amazon.domain.product.api.category.CategoryDto;
import com.fotsfer.amazon.domain.product.api.category.CategoryService;
import com.fotsfer.amazon.domain.product.impl.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    CategoryService service;

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest category) {
        CategoryDto dto = service.save(toDto(category));
        return toResponse(dto);
    }
    @GetMapping("/{id}")
    public CategoryResponse find(@PathVariable Integer id) {
        CategoryDto dto = service.find(id);
        return toResponse(dto);
    }
    @PutMapping("/{id}")
    public CategoryResponse update(@RequestBody CategoryRequest category, @PathVariable("id") Integer categoryId) {
        CategoryDto dto = service.update(categoryId, toDto(category));
        return toResponse(dto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


    public CategoryResponse toResponse(CategoryDto dto){
        CategoryResponse response = new CategoryResponse();
        response.setCategoryName(dto.getCategoryName());
        return response;
    }

    public CategoryDto toDto(CategoryRequest category){
        CategoryDto dto = new CategoryDto();
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }
}
