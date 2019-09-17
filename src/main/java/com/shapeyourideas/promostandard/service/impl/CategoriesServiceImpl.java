package com.shapeyourideas.promostandard.service.impl;

import com.shapeyourideas.promostandard.dto.CategoryDTO;
import com.shapeyourideas.promostandard.dto.SubCategoryDTO;
import com.shapeyourideas.promostandard.entity.CategoriesEntity;
import com.shapeyourideas.promostandard.repository.CategoriesRepository;
import com.shapeyourideas.promostandard.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<CategoryDTO> getCategories() {

        Iterable<CategoriesEntity> categoriesEntities = categoriesRepository.findAll();
        List<CategoryDTO> getAllCategory = new ArrayList<>();
        categoriesEntities.forEach(data->{
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(data.getCategoryName());
            categoryDTO.setSlug(data.getCategorySlug());
            categoryDTO.setImage(data.getCategoryImage());
            categoryDTO.setStatus(data.getIsActive());

            List<SubCategoryDTO> mainCategorySubCagtegories = new ArrayList<>();
            data.getSubCategories().forEach(subCatData->{
                SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
                subCategoryDTO.setId(subCatData.getId());
                subCategoryDTO.setName(subCatData.getSubcategoryName());
                subCategoryDTO.setImage(subCatData.getSubcategoryImage());
                subCategoryDTO.setSlug(subCatData.getSubcategorySlug());
                mainCategorySubCagtegories.add(subCategoryDTO);
            });
            categoryDTO.setSubCategories(mainCategorySubCagtegories);

            getAllCategory.add(categoryDTO);
        });

        return getAllCategory;

    }

    @Override
    public String addCategory(CategoryDTO categoryDTO){

        String categoryName = categoryDTO.getName();
        Integer categoryStatus = categoryDTO.getStatus();
        String categorySlug = categoryDTO.getSlug();
        String categoryImage = categoryDTO.getImage();

        CategoriesEntity categoriesEntity = new CategoriesEntity(categoryName,categoryStatus,categorySlug,categoryImage);

        List<CategoriesEntity> categoryListWithSameName = categoriesRepository.findByCategoryName(categoriesEntity.getCategoryName());
        if (categoryListWithSameName.size() > 0) {
           return "Category already available";
        } else {
            categoriesRepository.save(categoriesEntity);
           return "Category Saved Successfully";
        }
    }

    @Override
    public CategoryDTO getCategoryById(Integer id){
         Optional<CategoriesEntity> categoriesEntityDetail = categoriesRepository.findById(id);
         CategoryDTO getCategoryDetails = new CategoryDTO();

         getCategoryDetails.setName(categoriesEntityDetail.get().getCategoryName());
         getCategoryDetails.setSlug(categoriesEntityDetail.get().getCategorySlug());
         getCategoryDetails.setImage(categoriesEntityDetail.get().getCategoryImage());
         getCategoryDetails.setStatus(categoriesEntityDetail.get().getIsActive());

         return getCategoryDetails;
    }
}
