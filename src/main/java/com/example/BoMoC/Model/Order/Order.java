package com.example.BoMoC.Model.Order;


import com.example.BoMoC.Model.Cart.Cart;
import com.example.BoMoC.Model.Customer.Customer;
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