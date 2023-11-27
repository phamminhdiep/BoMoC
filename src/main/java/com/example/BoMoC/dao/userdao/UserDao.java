package com.example.BoMoC.dao.userdao;

import com.example.BoMoC.model.user.Account;
import com.example.BoMoC.model.user.Address;
import com.example.BoMoC.model.user.FullName;
import com.example.BoMoC.model.user.User;

public interface UserDao {

	public void changePass(Object aPassword);

	public Account login(Account account);

	public FullName getName();

	public Account getAccount();

	public Address getAddress();

	public void ChangeProfile(Object aUser);

	public User register(User user);

}