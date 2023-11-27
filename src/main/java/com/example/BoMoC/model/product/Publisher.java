package com.example.BoMoC.model.product;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String name;
	@OneToMany(mappedBy = "publisher")
	public List<Book> book;
}