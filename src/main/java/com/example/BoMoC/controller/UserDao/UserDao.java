package com.example.BoMoC.controller.UserDao;

import com.example.BoMoC.Model.User.Account;
import com.example.BoMoC.Model.User.Address;
import com.example.BoMoC.Model.User.FullName;
import com.example.BoMoC.Model.User.User;

public interface UserDao {

	public void changePass(Object aPassword);

	public Account login(Account account);

	public FullName getName();

	public Account getAccount();

	public Address getAddress();

	public void ChangeProfile(Object aUser);

	public User register(User user);

}