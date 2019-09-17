package com.shapeyourideas.promostandard.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shapeyourideas.promostandard.dto.PromoCompanyDTO;
import com.shapeyourideas.promostandard.entity.CompaniesEntity;
import com.shapeyourideas.promostandard.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


@RestController
@RequestMapping("promoAPI")
public class PromoStandardController {

    @Autowired
    CompaniesService companiesService;

    @Value("${operations.promostandard.companiesUrl}")
    String companyServiceUrl;

    @GetMapping("saveCompanyDetails")
    public @ResponseBody
    String saveData(){

        RestTemplate restTemplate = new RestTemplate();
        LinkedHashMap[] companiesDetails = restTemplate.getForObject(companyServiceUrl,LinkedHashMap[].class);

        for(LinkedHashMap getCompanyDetail : companiesDetails){
            LinkedHashMap code = (LinkedHashMap) getCompanyDetail;
            String comingCode = (String) code.get("Code");
            String comingName = (String) code.get("Name");
            String comingType = (String) code.get("Type");

            CompaniesEntity companiesEntity = new CompaniesEntity(comingName,comingCode,comingType);
            companiesService.addCompany(companiesEntity);
        }


        return "Saved Successfully";
    }

}
