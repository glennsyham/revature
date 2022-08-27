package com.revature.services;

import java.util.List;

import com.revature.daos.ProductDAO;
import com.revature.daos.ProductPostgres;
import com.revature.models.Offer;
import com.revature.models.Product;

public class ProductService {
	private ProductDAO pd = new ProductPostgres();

	public List<Product> getProducts() {
		return pd.retrieveProducts();
	}

	public List<Product> getProducts(int i) {
		return pd.retrieveProductsOwned(i);
	}
	
	public Product createProduct(Product ps) {
		return pd.createProduct(ps);
	}

	public Product getProductByID(int id) {
		return pd.retrieveProductById(id);
	}

	public boolean setProduct(Product ps) {
		return pd.updateProduct(ps);
	}

	public boolean deleteProductById(int id) {
		return pd.deleteProductById(id);
	}
 

	public boolean resetProduct(int id) {
		return pd.resetProduct(id);
	}

	public List<Product> retrieveProductByUserId(int id) {
		return pd.retrieveProductByUserId(id);
	}
	 
	public List<Product>  getProductByName(String n) {
		return pd.retrieveProductByName(n);
	}

	public Product retrieveProductByNameExact(String n) {
		return pd.retrieveProductByNameExact(n);
	}
	
	public Product retrieveProductByNameExact(String n, int pid) {
	return pd.retrieveProductByNameExact(n,pid);
	}

	public List<Product> retrieveProductByNameCustomer(String n) {
		return pd.retrieveProductByNameCustomer(n);
	}
 
	public boolean setProductPaid(int id) {
		return pd.setProductPaid(id);
	}
 }
