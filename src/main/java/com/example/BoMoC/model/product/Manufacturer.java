package com.example.BoMoC.model.product;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Manufacturer {
    @Id
    private int id;
    private String name;


    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Clothes> clothes;


    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MobilePhone> mobilePhone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Clothes> getClothes() {
        return null;
    }

    public void setClothes(List<Clothes> clothes) {
        this.clothes = clothes;
    }

    public List<MobilePhone> getMobilePhone() {
        return null;
    }

    public void setMobilePhone(List<MobilePhone> mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}