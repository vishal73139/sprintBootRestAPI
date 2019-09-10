package com.shapeyourideas.promostandard.controller;

import com.shapeyourideas.promostandard.dto.CategoryDTO;
import com.shapeyourideas.promostandard.entity.CategoriesEntity;
import com.shapeyourideas.promostandard.repository.CategoriesRepository;
import com.shapeyourideas.promostandard.service.CategoriesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.Context;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<CategoriesEntity> getAll() {
        return categoriesService.getCategories();
    }

    @GetMapping("/getAllCategoriesFromPromoStandard")
    public  @ResponseBody
    Iterable<CategoriesEntity> getAllCategoriesFromPromoStandard(){
        return categoriesService.getCategories();
    }

    @PostMapping(path = "/saveCategory",consumes = "application/json",produces = "application/json")
    public void addCategory(@RequestBody CategoryDTO categoryDTO){

        String categoryName = categoryDTO.getName();
        Integer categoryStatus = categoryDTO.getStatus();

        CategoriesEntity categoriesEntity = new CategoriesEntity(categoryName,categoryStatus);
         categoriesService.addCategory(categoriesEntity);
        }

}
