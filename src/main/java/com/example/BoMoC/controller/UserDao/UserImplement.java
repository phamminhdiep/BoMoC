package com.example.BoMoC.controller.UserDao;

import com.example.BoMoC.Model.User.Account;
import com.example.BoMoC.Model.User.Address;
import com.example.BoMoC.Model.User.FullName;
import com.example.BoMoC.Model.User.User;
import com.example.BoMoC.repository.DatabaseRepository;
import com.example.BoMoC.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserImplement implements UserDao {
	private DatabaseRepository database;
	public UserImplement() {
		database = new DatabaseRepository();
	}

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Account account) {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = database.connect().createStatement();
			String query = "SELECT * FROM bomoc.useraccount WHERE username = '" + account.getUsername() + "' AND password = '" + account.getPassword() + "'";
			resultSet = statement.executeQuery(query);
			System.out.println(resultSet);
			while (resultSet.next()) {
				return ApiResponse.buildResponseSuccess(true);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ApiResponse.buildResponseError(false);
	}


	public void changePass(Object aPassword) {
		throw new UnsupportedOperationException();
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

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody User user) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;

		try {
			// Tạo user account và lưu vào cơ sở dữ liệu
			connection = database.connect();
			String queryCreateUserAccount = "INSERT INTO bomoc.useraccount (username, password) VALUES (?,?)";
			ps = connection.prepareStatement(queryCreateUserAccount, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getAccount().getUsername());
			ps.setString(2, user.getAccount().getPassword());
			ps.executeUpdate();
			System.out.println(1);
			// Lấy id từ useraccount vừa tạo
			resultSet = ps.getGeneratedKeys();
			String accountId = "";
			if (resultSet.next()) {
				accountId = resultSet.getString(1);
			}
			System.out.println(2);
			// Tạo user và lưu vào cơ sở dữ liệu
			String queryCreateUser = "INSERT INTO bomoc.user (email, dob, gender, phoneNumber, userAccountId) VALUES (?,?,?,?,?)";
			ps = connection.prepareStatement(queryCreateUser, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getEmail());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dobFormatted = sdf.format(user.getDob());
			ps.setString(2, dobFormatted);
			ps.setBoolean(3, user.isGender());
			ps.setString(4, user.getPhoneNumber());
			ps.setString(5, accountId);
			ps.executeUpdate();
			System.out.println(3);
			// Lấy id từ user vừa tạo
			resultSet = ps.getGeneratedKeys();
			String userId = "";
			if (resultSet.next()) {
				userId = resultSet.getString(1);
			}
			System.out.println(4);
			// Tạo địa chỉ và lưu vào cơ sở dữ liệu
			String queryCreateAddress = "INSERT INTO bomoc.address (userId, HouseNo, Province, Distrtict, Ward) VALUES (?,?,?,?,?)";
			ps = connection.prepareStatement(queryCreateAddress);
			ps.setString(1, userId);
			ps.setInt(2, user.getAddress().getHouseNo());
			ps.setString(3, user.getAddress().getProvince());
			ps.setString(4, user.getAddress().getDistrict());
			ps.setString(5, user.getAddress().getWard());
			ps.executeUpdate();
			System.out.println(5);
			// Tạo họ và tên và lưu vào cơ sở dữ liệu
			String queryCreateFullname = "INSERT INTO bomoc.fullname (userId, FirstName, MidName, LastName) VALUES (?,?,?,?)";
			ps = connection.prepareStatement(queryCreateFullname);
			ps.setString(1, userId);
			ps.setString(2, user.getFullName().getFirstName());
			ps.setString(3, user.getFullName().getMidName());
			ps.setString(4, user.getFullName().getLastName());
			ps.executeUpdate();
			System.out.println(6);
			return ApiResponse.buildResponseSuccess(true);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ApiResponse.buildResponseError(false);
	}

}