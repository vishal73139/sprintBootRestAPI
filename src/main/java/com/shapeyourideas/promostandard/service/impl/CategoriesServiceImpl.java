package com.shapeyourideas.promostandard.service.impl;

import com.shapeyourideas.promostandard.entity.CategoriesEntity;
import com.shapeyourideas.promostandard.repository.CategoriesRepository;
import com.shapeyourideas.promostandard.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public Iterable<CategoriesEntity> getCategories() {
        return  categoriesRepository.findAll();
    }

    @Override
    public String addCategory(CategoriesEntity categoriesEntity){

        List<CategoriesEntity> categoryListWithSameName = categoriesRepository.findByCategoryName(categoriesEntity.getCategoryName());
        if (categoryListWithSameName.size() > 0) {
           return "Category already available";
        } else {
            categoriesRepository.save(categoriesEntity);
           return "Category Saved Successfully";
        }
    }
}
