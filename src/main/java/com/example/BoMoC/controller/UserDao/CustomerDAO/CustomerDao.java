package com.example.BoMoC.controller.UserDao.CustomerDAO;


import com.example.BoMoC.Model.Customer.Customer;

public interface CustomerDao {

	public void add(Object aCustomer);

	public Customer get(Object aCustomerId);

	public Customer search(Object aName);
}