package com.example.BoMoC.Model.User;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FullName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String midName;
	private String lastName;

	@OneToOne
	private User user;

}