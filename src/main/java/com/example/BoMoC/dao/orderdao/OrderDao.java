package com.example.BoMoC.controller.OrderDao;

import com.example.BoMoC.model.Customer.Customer;

public interface OrderDao {

	public void setBill(Object aPayment, Object aShipment);

	public void cancel();

	public void create(Object aCart);

	public Customer getCustomer(Object aCustomer);
}