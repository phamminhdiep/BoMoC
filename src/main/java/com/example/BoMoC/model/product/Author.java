package com.example.BoMoC.Model.Product;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String name;
	private boolean gender;
	private String country;
	private String image;
	@OneToMany(mappedBy = "author")
	public List<Book> book;
}