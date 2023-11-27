package com.example.BoMoC.Model.Admin;


import com.example.BoMoC.Model.User.User;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Admin extends User {
	private String role;
	private String permission;
}