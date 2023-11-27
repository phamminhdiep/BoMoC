package com.example.BoMoC.Model.Product;

import com.example.BoMoC.Model.Customer.Customer;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class CustomerRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@OneToOne
	private Star star;
	@OneToOne
	private Comment comment;
	@OneToOne
	private Customer customer;

	@ManyToOne
	private Product product;

}