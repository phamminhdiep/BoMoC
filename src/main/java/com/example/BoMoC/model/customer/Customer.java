package com.example.BoMoC.Model.Customer;

import com.example.BoMoC.Model.Order.Order;
import com.example.BoMoC.Model.Product.CustomerRating;
import com.example.BoMoC.Model.User.User;
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