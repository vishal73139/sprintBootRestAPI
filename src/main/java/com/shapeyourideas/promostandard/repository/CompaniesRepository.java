package com.shapeyourideas.promostandard.repository;

import com.shapeyourideas.promostandard.entity.CompaniesEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompaniesRepository extends CrudRepository<CompaniesEntity,Integer> {
    List<CompaniesEntity> findByCompanyName(String name);
}
