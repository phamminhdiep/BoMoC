package com.example.BoMoC.Model.Order;


import com.example.BoMoC.Model.Cart.Cart;
import com.example.BoMoC.Model.Customer.Customer;

import java.util.Date;

public class Order {
	private int _id;
	private Payment _payment;
	private Shipment _shipment;
	private Cart _cart;
	private Date _createTime;
	private Customer _customer;
	private String _status;
	public Payment _unnamed_Payment_;
	public Shipment _unnamed_Shipment_;
	public Cart _unnamed_Cart_;
	public Customer _unnamed_Customer_;
}