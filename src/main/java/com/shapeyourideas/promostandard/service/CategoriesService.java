package com.shapeyourideas.promostandard.service;

import com.shapeyourideas.promostandard.entity.CategoriesEntity;

public interface CategoriesService {
    public abstract Iterable<CategoriesEntity> getCategories();
    public abstract String addCategory(CategoriesEntity categoriesEntity);
}
