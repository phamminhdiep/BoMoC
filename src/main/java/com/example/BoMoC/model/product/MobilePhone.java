package com.example.BoMoC.model.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data

public class MobilePhone extends Product {
    private String name;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufacturer manufacturer;
    private String operatingSystem;
    private String screenSize;

}
