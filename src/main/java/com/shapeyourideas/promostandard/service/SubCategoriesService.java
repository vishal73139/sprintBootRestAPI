package com.shapeyourideas.promostandard.service;

import com.shapeyourideas.promostandard.dto.SubCategoryDTO;

import java.util.List; 

public interface SubCategoriesService {
    public abstract List<SubCategoryDTO> getSubCategories();
    public abstract SubCategoryDTO getSubCategoryById(Integer id);
}
