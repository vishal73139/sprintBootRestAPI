package com.shapeyourideas.promostandard.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @NotEmpty(message = "Please provide Category Name")
    private String name;

    @NotNull(message = "Please provide Category Status")
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
