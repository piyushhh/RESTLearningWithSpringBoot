package com.RestWebservciesInSpringBoot.restfulwebServices.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResoure {
	@Autowired
	ProductDAOService productDAOService;

	@GetMapping(path="/getAllProduct")
	public String getAllProduct(){
		return "productDAOService.getAllProduct()";
	}
	@GetMapping(path="/getProductById/id/{id}")
	public Product getProductById(@PathVariable String ID){
		return productDAOService.getProductById(ID);
	}
	
	@PostMapping(path="/saveProduct")
	public Product saveProduct(@RequestBody Product product){
		productDAOService.saveProduct(product);
		return null;
		
	}
	@DeleteMapping(path="/deleteById/id/{id}")
	public void deleteProductById(@PathVariable String id){
		productDAOService.deleteById(id);
		
	}
	
	
	

}
