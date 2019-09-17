package com.shapeyourideas.promostandard.service.impl;

import com.shapeyourideas.promostandard.dto.SubCategoryDTO;
import com.shapeyourideas.promostandard.entity.SubcategoriesEntity;
import com.shapeyourideas.promostandard.repository.SubCategoriesRepository;
import com.shapeyourideas.promostandard.service.SubCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubCategoriesServiceImpl implements SubCategoriesService {

    @Autowired
    private SubCategoriesRepository subCategoriesRepository;

    @Override
    public List<SubCategoryDTO> getSubCategories(){
        Iterable<SubcategoriesEntity> subcategoriesEntities = subCategoriesRepository.findAll();
        List<SubCategoryDTO>subCategoryDTOS = new ArrayList<>();
        subcategoriesEntities.forEach(data->{
            SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
            subCategoryDTO.setId(data.getId());
            subCategoryDTO.setName(data.getSubcategoryName());
            subCategoryDTO.setSlug(data.getSubcategorySlug());
            subCategoryDTO.setImage(data.getSubcategoryImage());
            subCategoryDTO.setIsActive(data.getIsActive());
            subCategoryDTOS.add(subCategoryDTO);
        });
        return subCategoryDTOS;
    }

    @Override
    public SubCategoryDTO getSubCategoryById(Integer id){
        Optional<SubcategoriesEntity>subcategoriesEntity = subCategoriesRepository.findById(id);
        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
        subCategoryDTO.setId(subcategoriesEntity.get().getId());
        subCategoryDTO.setName(subcategoriesEntity.get().getSubcategoryName());
        subCategoryDTO.setSlug(subcategoriesEntity.get().getSubcategorySlug());
        subCategoryDTO.setImage(subcategoriesEntity.get().getSubcategoryImage());
        subCategoryDTO.setIsActive(subcategoriesEntity.get().getIsActive());
        return subCategoryDTO;
    }
}
