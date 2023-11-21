package com.example.BoMoC.controller.ProductDao;


import com.example.BoMoC.Model.Product.CustomerRating;

public interface ProductDAO {

	public ProductImpl get(Object aId);

	public ProductImpl delete(Object aId);

	public ProductImpl search(Object aName);

	public CustomerRating[] getRating(Object aProduct);
}