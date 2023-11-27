package com.example.BoMoC.model.product;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
public class Comment {
	@Id
	private int id;
	private String content;
	private Date createTime;

	@OneToOne
	private CustomerRating customerRating;
}