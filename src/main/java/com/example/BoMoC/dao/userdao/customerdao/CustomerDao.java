package com.example.BoMoC.dao.userdao.customerdao;


import com.example.BoMoC.model.customer.Customer;

public interface CustomerDao {

	public void add(Object aCustomer);

	public Customer get(Object aCustomerId);

	public Customer search(Object aName);
}