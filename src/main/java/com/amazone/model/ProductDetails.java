package com.amazone.model;

public class ProductDetails {

	private String productName;
	private Integer productId;
	private String brandName;
	private String productCategory;
	private Double price;
	
	public ProductDetails(String productName, Integer productId, String brandName, String productCategory,
			Double price) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.brandName = brandName;
		this.productCategory = productCategory;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDetails [productName = " + productName + ", productId = " + productId + ", brandName = " + brandName
				+ ", productCategory = " + productCategory + ", price = " + price + "]";
	}
	
}
