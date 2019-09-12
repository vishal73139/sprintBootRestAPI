package com.shapeyourideas.promostandard.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("promoAPI")
public class PromoStandardController {

    @Value("${operations.promostandard.companiesUrl}")
    String companyServiceUrl;

    @GetMapping("saveCompanyDetails")
    public @ResponseBody
    String saveData(){



        RestTemplate restTemplate = new RestTemplate();
        Object[] companiesDetails = restTemplate.getForObject(companyServiceUrl,Object[].class);

        for (Object companyDetail : companiesDetails) {
            System.out.println(companyDetail);
        }

        return companyServiceUrl;
    }

}
