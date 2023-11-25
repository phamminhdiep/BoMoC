package com.example.BoMoC.controller.UserDao;

import com.example.BoMoC.Model.User.Account;
import com.example.BoMoC.Model.User.Address;
import com.example.BoMoC.Model.User.FullName;
import com.example.BoMoC.Model.User.User;
import com.example.BoMoC.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserImplement implements UserDao {
	private DatabaseRepository database;
	private UsersRepository usersRepository;
	private AccountRepository accountRepository;
	private FullNameRepository fullNameRepository;
	private AddressRepository addressRepository;

	public UserImplement(UsersRepository usersRepository, AccountRepository accountRepository,FullNameRepository fullNameRepository,AddressRepository addressRepository) {
		this.usersRepository = usersRepository;
		this.accountRepository = accountRepository;
		this.fullNameRepository = fullNameRepository;
		this.addressRepository = addressRepository;
		database = new DatabaseRepository();
	}

//	@PostMapping("/login")
//	public ResponseEntity<Object> login(@RequestBody Account account) {
//		Statement statement = null;
//		ResultSet resultSet = null;
//		try {
//			statement = database.connect().createStatement();
//			String query = "SELECT * FROM bomoc.useraccount WHERE username = '" + account.getUsername() + "' AND password = '" + account.getPassword() + "'";
//			resultSet = statement.executeQuery(query);
//			System.out.println(resultSet);
//			while (resultSet.next()) {
////				return ApiResponse.buildResponseSuccess(true);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (resultSet != null) {
//					resultSet.close();
//				}
//				if (statement != null) {
//					statement.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return ApiResponse.buildResponseError(false);
//	}


	public void changePass(Object aPassword) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Account login(Account account) {
		String username = account.getUsername();
		String password = account.getPassword();

		Optional<Account> accountOptional = accountRepository.findByUsernameAndPassword(username, password);
//		this.accountRepository.findOne(new String[]{
//				username,
//				password
//		});
		if (accountOptional.isPresent()) {
			System.out.println("abc; " + accountOptional.isPresent());
			System.out.println("account: " + account);
			System.out.println("username: " + username);
			System.out.println("password: " + password);
			Account accountExist = accountOptional.get();
			return accountExist;
		} return null;
	}


	public FullName getName() {
		throw new UnsupportedOperationException();
	}

	public Account getAccount() {
		throw new UnsupportedOperationException();
	}

	public Address getAddress() {
		throw new UnsupportedOperationException();
	}

	public void ChangeProfile(Object aUser) {
		throw new UnsupportedOperationException();
	}

	public User register(User user) {
		// create account
		Account account = new Account();
		account.setUsername(user.getAccount().getUsername());
		account.setPassword(user.getAccount().getPassword());
		Account accountSave = this.accountRepository.save(account);

		// create address
		Address address = new Address();
		address.setHouseNo(user.getAddress().getHouseNo());
		address.setProvince(user.getAddress().getProvince());
		address.setDistrict(user.getAddress().getDistrict());
		address.setWard(user.getAddress().getWard());
		Address addressSave = this.addressRepository.save(address);

		// create fullname
		FullName fullName = new FullName();
		fullName.setFirstName(user.getFullName().getFirstName());
		fullName.setLastName(user.getFullName().getLastName());
		fullName.setMidName(user.getFullName().getMidName());
		FullName fullNameSave = this.fullNameRepository.save(fullName);

		// create User
		user.setAccount(accountSave);
		user.setFullName(fullNameSave);
		user.setAddress(addressSave);
		User userNew = this.usersRepository.save(user);

		// update userId account
//		System.out.println("id account: " + accountSave.getId());
		Optional<Account> accountOptional = accountRepository.findById(accountSave.getId());
		Account existingAccount = accountOptional.get();
//		System.out.println("existingAccount: " + existingAccount);
		existingAccount.setUser(userNew);
		accountRepository.save(existingAccount);
		return userNew;
	}
}