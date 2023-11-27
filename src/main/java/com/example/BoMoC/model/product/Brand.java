package com.example.BoMoC.model.product;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Brand {
	@Id
	private int ID;
	private String name;
	private String description;


	@OneToMany(mappedBy = "brand",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<Clothes> clothes;


	@OneToMany(mappedBy = "brand",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List <MobilePhone> mobilePhones;

	public List<Clothes> getClothes() {
		return null;
	}

	public List<MobilePhone> getMobilePhones() {
		return null;
	}
}
