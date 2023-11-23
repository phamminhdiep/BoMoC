package com.example.BoMoC.Model.Customer;

import com.example.BoMoC.Model.Order.Order;
import com.example.BoMoC.Model.Product.CustomerRating;
import com.example.BoMoC.Model.User.User;
import java.util.Date;

public class Customer extends User {
	private Date _registationTime;
	private String _deliveryAddress;
	public Order _unnamed_Order_;
	public CustomerRating _unnamed_CustomerRating_;
}