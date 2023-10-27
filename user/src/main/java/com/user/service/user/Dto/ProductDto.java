package com.user.service.user.Dto;

import org.springframework.stereotype.Component;

@Component
public class ProductDto {
    private String name;
    private  String qty;
    private String modelNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public ProductDto(String name, String qty, String modelNumber) {
        this.name = name;
        this.qty = qty;
        this.modelNumber = modelNumber;
    }

    public ProductDto() {
    }
}
