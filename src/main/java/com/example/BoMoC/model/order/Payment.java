package com.example.BoMoC.model.order;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String method;
	private int totalBill;

	@OneToOne
	private Order order;
}