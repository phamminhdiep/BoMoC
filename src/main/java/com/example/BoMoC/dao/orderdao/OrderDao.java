package com.example.BoMoC.dao.orderdao;

import com.example.BoMoC.model.customer.Customer;

public interface OrderDao {

	public void setBill(Object aPayment, Object aShipment);

	public void cancel();

	public void create(Object aCart);

	public Customer getCustomer(Object aCustomer);
}