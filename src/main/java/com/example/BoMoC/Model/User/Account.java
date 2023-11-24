package com.example.BoMoC.Model.User;
import com.example.BoMoC.Model.User.User;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;

	@OneToOne
	public User user;

}