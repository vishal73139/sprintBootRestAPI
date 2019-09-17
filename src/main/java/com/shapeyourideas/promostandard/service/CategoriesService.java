package com.shapeyourideas.promostandard.service;

import com.shapeyourideas.promostandard.dto.CategoryDTO;

import java.util.List;

public interface CategoriesService {
    public abstract List<CategoryDTO> getCategories();
    public abstract String addCategory(CategoryDTO categoryDTO);
    public abstract CategoryDTO getCategoryById(Integer id);
}
