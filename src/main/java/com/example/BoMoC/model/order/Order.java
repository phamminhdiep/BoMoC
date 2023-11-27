package com.example.BoMoC.model.order;


import com.example.BoMoC.model.cart.Cart;
import com.example.BoMoC.model.customer.Customer;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private Payment payment;
	@OneToOne
	private Shipment shipment;
	@OneToOne
	private Cart cart;
	private Date createTime;
	@OneToOne
	private Customer customer;
	private String status;

}