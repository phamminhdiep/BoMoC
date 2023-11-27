package com.example.BoMoC.model.product;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {

	@Id
	private int ID;
	private String productType;
	private String name;

	// hí anh em

	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Product> product;
}