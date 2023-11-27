package com.example.BoMoC.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String name;
	private String gender;
	private String country;
	private String image;
	@OneToMany(mappedBy = "author",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	public List<Book> book;

	public List<Book> getBook() {
		return null;
	}
}