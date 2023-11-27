package com.example.BoMoC.model.product;

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

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Clothes> getClothes() {
		return null;
	}

	public void setClothes(List<Clothes> clothes) {
		this.clothes = clothes;
	}

	public List<MobilePhone> getMobilePhones() {
		return null;
	}

	public void setMobilePhones(List<MobilePhone> mobilePhones) {
		this.mobilePhones = mobilePhones;
	}
}