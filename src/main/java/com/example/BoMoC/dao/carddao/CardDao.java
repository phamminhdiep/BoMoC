package com.example.BoMoC.controller.CardDao;

public interface CardDao {

	public void removeProduct(Object aProduct);

	public void checkout();

	public void update(Object aProduct, Object aEvent);
}