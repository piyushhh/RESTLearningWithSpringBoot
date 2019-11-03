package com.RestWebservciesInSpringBoot.restfulwebServices.product;

public class Product {
	public Product(){		
     }
	String productId;
	String productName;
	String productDesc;
	
	public String getProductId(){
		return productId;
	}
	
	public void setProductId(String productId){
		this.productId = productId;
	}
	
	public String getProductName(){
		return productName;
	}
	public void setProductName(String productName){
		this.productName = productName;
	}
	
	public String getProductDesc(){
		return productDesc;
	}
	public void setProductDesc(String productDesc){
		this.productDesc = productDesc;
	}
	
	Product(String productId ,String productName, String productDesc){
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ "]";
	}

}
