package com.shapeyourideas.promostandard.controller;

import com.shapeyourideas.promostandard.entity.CompaniesEntity;
import com.shapeyourideas.promostandard.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompaniesService companiesService;


    @GetMapping("getAll")
    public @ResponseBody
    Iterable<CompaniesEntity> getAll(){
        return companiesService.getAllCompanies();
    }


}
