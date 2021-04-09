package com.amazone.dao;

import com.amazone.model.ProductDetails;

public interface ProductDAO {

	public void DAOlogin(String userName, String password);
	void addoOneProduct(ProductDetails productDetails);
	int updateOneProduct(int ProductId, double price);
	int deleteOneProduct(int ProductId);
}
