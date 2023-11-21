package com.example.BoMoC.controller.UserDao;

import com.example.BoMoC.Model.User.Account;
import com.example.BoMoC.Model.User.Address;
import com.example.BoMoC.Model.User.FullName;
import com.example.BoMoC.Model.User.User;
import com.example.BoMoC.utils.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface UserDao {

	public void changePass(Object aPassword);

	public ResponseEntity<Object> login(Account account);

	public FullName getName();

	public Account getAccount();

	public Address getAddress();

	public void ChangeProfile(Object aUser);

	public ResponseEntity<Object> register(User user);
}