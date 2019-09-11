package com.shapeyourideas.promostandard.service;

import com.shapeyourideas.promostandard.entity.CategoriesEntity;

import java.util.List;
import java.util.Optional;

public interface CategoriesService {
    public abstract Iterable<CategoriesEntity> getCategories();
    public abstract String addCategory(CategoriesEntity categoriesEntity);
    public abstract Optional<CategoriesEntity> getCategoryById(Integer id);
}
