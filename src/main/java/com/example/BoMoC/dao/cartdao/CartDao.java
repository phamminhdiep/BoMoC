package com.example.BoMoC.dao.cartdao;

public interface CartDao {

	public void removeProduct(Object aProduct);

	public void checkout();

	public void update(Object aProduct, Object aEvent);
}