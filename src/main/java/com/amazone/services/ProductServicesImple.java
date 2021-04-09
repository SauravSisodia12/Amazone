package com.amazone.services;

import java.util.List;
import java.util.stream.Collectors;

import com.amazone.dao.ProductDAO;
import com.amazone.dao.ProductDAOImple;
import com.amazone.exception.IdNotFoundException;
import com.amazone.exception.UserNotFoundException;
import com.amazone.model.ProductDetails;

public class ProductServicesImple implements ProductServices {
	
	ProductDAO productDAO = new ProductDAOImple();
	
	public int login(String userId, String password) throws UserNotFoundException {
		int result = productDAO.DAOlogin(userId, password);
		if(result == 0)
			throw new UserNotFoundException("Admin Not Found");
		else {
			return result;
		}	
	}

	public void addProduct(ProductDetails productDetails) {
		productDAO.addoOneProduct(productDetails);
		
	}

	public void updateProduct(int productId, double price) throws IdNotFoundException {
		int result = productDAO.updateOneProduct(productId, price);
		if(result == 0)
			throw new IdNotFoundException("Invalid ID for Updating Book");
		
	}

	public void deleteProduct(int productId) throws IdNotFoundException {
		int result = productDAO.deleteOneProduct(productId);
		if(result == 0)
			throw new IdNotFoundException("ID Not Found for Deletion");
		
	}

	@Override
	public List<ProductDetails> viewAllProduct() {
		return productDAO.findAllProduct().stream()
				.sorted((p1,p2)->p1.getProductCategory().compareToIgnoreCase(p2.getProductCategory()))
				.collect(Collectors.toList());
	}	
}
