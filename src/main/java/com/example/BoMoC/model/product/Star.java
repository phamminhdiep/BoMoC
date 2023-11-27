package com.example.BoMoC.model.product;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Star {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amount;
	private String description;
	@OneToOne
	public CustomerRating customerRating;
}