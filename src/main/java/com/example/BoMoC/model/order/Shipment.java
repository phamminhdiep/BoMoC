package com.example.BoMoC.model.order;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String method;
	private int fee;
	private Date shippingDate;
	@OneToOne
	private Order order;
}