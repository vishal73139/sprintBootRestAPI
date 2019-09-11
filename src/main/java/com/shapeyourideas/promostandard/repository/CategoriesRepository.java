package com.shapeyourideas.promostandard.repository;

import com.shapeyourideas.promostandard.entity.CategoriesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriesRepository  extends CrudRepository<CategoriesEntity,Integer> {
    List<CategoriesEntity> findByCategoryName(String name);
}
