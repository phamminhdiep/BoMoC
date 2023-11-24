package com.example.BoMoC.Model.Cart;

import com.example.BoMoC.Model.Customer.Customer;
import com.example.BoMoC.Model.Order.Order;
import com.example.BoMoC.Model.Product.Product;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
@Entity
@Data

public class Cart {
	@Id
	private int id;
	@OneToMany
	private List<Product> product;
	@OneToOne
	private Order order;
	@OneToOne
	private Customer customer;
}