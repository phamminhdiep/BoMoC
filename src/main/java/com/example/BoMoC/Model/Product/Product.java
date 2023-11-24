package com.example.BoMoC.Model.Product;


import com.example.BoMoC.Model.Cart.Cart;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	private String name;
	private String description;
	private int sold;
	private int remain;
	private int price;
	private String status;
	private String coverImage;

	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;

	@OneToMany(mappedBy = "product",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	private List<CustomerRating> customerRating;

}