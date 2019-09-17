package com.shapeyourideas.promostandard.controller;

import com.shapeyourideas.promostandard.dto.CategoryDTO;
import com.shapeyourideas.promostandard.dto.SubCategoryDTO;
import com.shapeyourideas.promostandard.service.CategoriesService;
import com.shapeyourideas.promostandard.service.SubCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private SubCategoriesService subCategoriesService;

    @GetMapping("/all")
    public @ResponseBody
    List<CategoryDTO> getAll() {
        return categoriesService.getCategories();
    }

    @GetMapping("/{ID}")
    public @ResponseBody
    CategoryDTO getCategoryDetail(@PathVariable(value = "ID") Integer id){
        return categoriesService.getCategoryById(id);
    }

    @PostMapping(path = "/saveCategory",consumes = "application/json",produces = "application/json")
    ResponseEntity<String> addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
         return ResponseEntity.ok(categoriesService.addCategory(categoryDTO));
        }

    @GetMapping("/subcategory")
    public @ResponseBody
    List<SubCategoryDTO> getAllSubCategory(){
        return subCategoriesService.getSubCategories();
    }

    @GetMapping("/subcategory/{ID}")
    public @ResponseBody
    SubCategoryDTO getSubCategoryById(@PathVariable(value = "ID") Integer id){
        return subCategoriesService.getSubCategoryById(id);
    }


}
