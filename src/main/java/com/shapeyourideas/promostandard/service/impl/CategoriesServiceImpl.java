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
    public boolean addCategory(CategoriesEntity categoriesEntity){

        List<CategoriesEntity> categoryListWithSameName = categoriesRepository.findByName(categoriesEntity.getName());
        if (categoryListWithSameName.size() > 0) {
            return false;
        } else {
            categoriesRepository.save(categoriesEntity);
            return true;
        }
    }
}
