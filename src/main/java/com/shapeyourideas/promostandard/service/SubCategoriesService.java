package com.shapeyourideas.promostandard.service;

import com.shapeyourideas.promostandard.entity.SubcategoriesEntity;

import java.util.Optional;

public interface SubCategoriesService {
    public abstract Iterable<SubcategoriesEntity> getSubCategories();
    public abstract Optional<SubcategoriesEntity> getSubCategoryById(Integer id);
}
