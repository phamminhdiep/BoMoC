package com.example.BoMoC.model.customer;

import com.example.BoMoC.model.order.Order;
import com.example.BoMoC.model.product.CustomerRating;
import com.example.BoMoC.model.user.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Customer extends User {
	private Date registrationTime;
	private String deliveryAddress;
	@OneToMany
	public List<Order> order;
	@OneToMany
	public List<CustomerRating> customerRating;
}