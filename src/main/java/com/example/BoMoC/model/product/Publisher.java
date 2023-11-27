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
public class Publisher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	private String name;
	@OneToMany(mappedBy = "publisher",fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	public List<Book> book;

	public List<Book> getBook() {
		return null;
	}
}
