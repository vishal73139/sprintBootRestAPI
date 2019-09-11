package com.shapeyourideas.promostandard.service.impl;

import com.shapeyourideas.promostandard.entity.SubcategoriesEntity;
import com.shapeyourideas.promostandard.repository.SubCategoriesRepository;
import com.shapeyourideas.promostandard.service.SubCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubCategoriesServiceImpl implements SubCategoriesService {

    @Autowired
    private SubCategoriesRepository subCategoriesRepository;

    @Override
    public Iterable<SubcategoriesEntity> getSubCategories(){ return subCategoriesRepository.findAll();}

    @Override
    public Optional<SubcategoriesEntity> getSubCategoryById(Integer id){
        return subCategoriesRepository.findById(id);
    }
}
