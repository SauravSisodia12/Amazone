package com.amazone.services;

import com.amazone.dao.ProductDAO;
import com.amazone.dao.ProductDAOImple;
import com.amazone.exception.IdNotFoundException;
import com.amazone.model.ProductDetails;

public class ProductServicesImple implements ProductServices {
	
	ProductDAO productDAO = new ProductDAOImple();
	
	public void login(String userName, String password) {
		// TODO Auto-generated method stub
		
	}

	public void addProduct(ProductDetails productDetails) {
		productDAO.addoOneProduct(productDetails);
		
	}

	public void updateProduct(int ProductId, double price) throws IdNotFoundException {
		productDAO.updateOneProduct(ProductId, price);
		
	}

	public void deleteProduct(int ProductId) throws IdNotFoundException {
		productDAO.deleteOneProduct(ProductId);
		
	}

	
}
