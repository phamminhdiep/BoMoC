package com.example.BoMoC.model.product;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String description;
	private int sold;
	private int remain;
	private int price;
	private String status;
	private String coverImage;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<CustomerRating> customerRating;

}