package com.revature;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import com.revature.models.Product;
import com.revature.models.User;
import com.revature.services.ProductService;

import org.junit.jupiter.api.Disabled;

public class ProductServiceTest {
	private static ProductService pservice;
	
	@BeforeAll
	public static void setUp() {
		pservice = new ProductService();
		
	}	
	
	//createProduct,getProductByID,deleteProductById
 	@Test
 	public void add() {
 		Product pcreate = new Product();
 		pcreate.setProduct_name("test");
 		pcreate.setPrice(20);
 		Product actual = pservice.createProduct(pcreate);
  		assertNotNull(actual);
 		pservice.deleteProductById(actual.getId());
 	}

	@Test
	public void updateById() {		
		Product product =  new Product();
		product.setPrice(2.86);
		product.setProduct_name("Calaloo Do Not Delete");
		product.setId(18);
		pservice.setProduct(product);
		
		Product updateProduct = pservice.getProductByID(18);
 		assertEquals(updateProduct.getProduct_name(), product.getProduct_name());
 	}	
 	
	@Test
	public void retrievById() {		
		Product actual =  pservice.getProductByID(200);
		assertNull(actual);
 	}	
 
	@Test
	public void deletbyId() {
		Boolean actual =  pservice.deleteProductById(0);
		assertFalse(actual);
 	}	
}
