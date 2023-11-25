package com.example.BoMoC.Model.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	private FullName fullName;
	@OneToOne
	private Address address;
	@OneToOne
	private Account account;
	private String email;
	private Date dob;
	private boolean gender;
	private String phoneNumber;

}