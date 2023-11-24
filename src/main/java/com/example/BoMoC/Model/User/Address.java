package com.example.BoMoC.Model.User;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int houseNo;
	private String province;
	private String district;
	private String ward;
	@OneToOne
	private User user;

}