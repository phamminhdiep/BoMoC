package com.example.BoMoC.Model.Product;

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

	@OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private List<Product> product;x
	// duong bop
}