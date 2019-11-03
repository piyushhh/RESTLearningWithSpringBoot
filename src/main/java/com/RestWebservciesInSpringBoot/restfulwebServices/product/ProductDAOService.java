package com.RestWebservciesInSpringBoot.restfulwebServices.product;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.hibernate.loader.custom.Return;
import org.springframework.stereotype.Component;

@Component
public class ProductDAOService {

	public static  List<Product> products = new ArrayList<Product>();
	int count = 111;
	static {
		products.add(new Product("GA001", "GamingConsole", "GamingConsole for PlayStation"));
		products.add(new Product("FT001", "Football", "Addidas Footbal"));
		products.add(new Product("CL001", "jeans", "Lee Men jeans "));
		products.add(new Product("FD001", "PiZZA", "Italian cheese Pizza"));
	}
	 public List<Product> getAllProduct(){
		 return products;
	 }
	 public Product getProductById(String productId){

		for(Product product : products){
			if(product.getProductId() == productId){
				return product;
			}
		}
		return null; 
	 }
	 public Product saveProduct(Product product){

		 if(product.getProductId() != null){
		  	 products.add(product);
		 }
		 return product;
		 
	 }
	 public Product deleteById(String Id){

		 Iterator<Product> it = products.iterator(); 
		 while(it.hasNext()){
			 Product product = it.next();
			 if(product.getProductId() == Id){
				 //products.remove(product.getProductId());
				 return product;
			 }
		 }
		 return null;
	 }
	 
}
