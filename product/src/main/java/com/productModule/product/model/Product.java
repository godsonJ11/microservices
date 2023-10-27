package com.productModule.product.model;

import jakarta.persistence.*;

@Entity
@Table(name="product_details")
public class Product {
    @Id
    @SequenceGenerator(name = "simple_seq", sequenceName = "simple_seq",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "simple_seq")
    private Integer id;
    private String name;
    private String qty;
    private String modelNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
