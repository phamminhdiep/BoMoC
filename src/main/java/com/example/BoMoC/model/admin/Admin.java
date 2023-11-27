package com.example.BoMoC.model.admin;


import com.example.BoMoC.model.user.User;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Admin extends User {
	private String role;
	private String permission;
}