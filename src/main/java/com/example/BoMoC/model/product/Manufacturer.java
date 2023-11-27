package com.example.BoMoC.model.product;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Manufacturer {
    @Id
    private int id;
    private String name;


    @OneToMany(mappedBy = "manufacturer",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private List<Clothes> clothes;


    @OneToMany(mappedBy = "manufacturer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MobilePhone> mobilePhone;

    public List<Clothes> getClothes() {
        return null;
    }

    public List<MobilePhone> getMobilePhone() {
        return null;
    }
}