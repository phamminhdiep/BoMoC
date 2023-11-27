package com.example.BoMoC.dao.productdao;


import com.example.BoMoC.model.product.CustomerRating;

public interface ProductDAO {

	public ProductImpl get(Object aId);

	public ProductImpl delete(Object aId);

	public ProductImpl search(Object aName);

	public CustomerRating[] getRating(Object aProduct);
}