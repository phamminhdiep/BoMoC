package com.example.BoMoC.model.cart;

import com.example.BoMoC.model.customer.Customer;
import com.example.BoMoC.model.order.Order;
import com.example.BoMoC.model.product.Product;
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