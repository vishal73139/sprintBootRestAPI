package com.shapeyourideas.promostandard.service;

import com.shapeyourideas.promostandard.entity.CompaniesEntity;

public interface CompaniesService {
    public abstract Iterable<CompaniesEntity> getAllCompanies();
    public abstract String addCompany(CompaniesEntity companiesEntity);
}
