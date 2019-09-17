package com.shapeyourideas.promostandard.controller;

import com.shapeyourideas.promostandard.dto.PromoCompanyDTO;
import com.shapeyourideas.promostandard.entity.CompaniesEntity;
import com.shapeyourideas.promostandard.service.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompaniesService companiesService;


    @GetMapping("getAll")
    public @ResponseBody
    List<PromoCompanyDTO> getAll(){

        Iterable<CompaniesEntity> companiesEntities =companiesService.getAllCompanies();
        List<PromoCompanyDTO> getDataList = new ArrayList<>();
        companiesEntities.forEach(data->{
            PromoCompanyDTO promoCompanyDTO = new PromoCompanyDTO();
            promoCompanyDTO.setType(data.getCompanyType());
            promoCompanyDTO.setCode(data.getCompanyCode());
            promoCompanyDTO.setName(data.getCompanyName());
            getDataList.add(promoCompanyDTO);
        });
        return getDataList;
    }


}
