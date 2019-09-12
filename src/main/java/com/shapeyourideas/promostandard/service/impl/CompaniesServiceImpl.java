package com.shapeyourideas.promostandard.service.impl;

import com.shapeyourideas.promostandard.entity.CompaniesEntity;
import com.shapeyourideas.promostandard.repository.CompaniesRepository;
import com.shapeyourideas.promostandard.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompaniesServiceImpl implements CompaniesService {

    @Autowired
    private CompaniesRepository companiesRepository;

    @Override
    public Iterable<CompaniesEntity> getAllCompanies(){
        return companiesRepository.findAll();
    }

    @Override
    public String addCompany(CompaniesEntity companiesEntity){
        List<CompaniesEntity> categoryListWithSameName = companiesRepository.findByCompanyName(companiesEntity.getCompanyName());
        if (categoryListWithSameName.size() > 0) {
            return "Company already available";
        } else {
            companiesRepository.save(companiesEntity);
            return "Company Saved Successfully";
        }
    }
}
