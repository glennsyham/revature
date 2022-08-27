package com.revature.models;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;

public class Product {
	private int id;
	private String product_name;
	private double price;
	private int paid_status;
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

 
	public int getPaid_status() {
		return paid_status;
	}

	public void setPaid_status(int paid_status) {
		this.paid_status = paid_status;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, paid_status, price, product_name, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id && paid_status == other.paid_status
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(product_name, other.product_name) && user_id == other.user_id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", price=" + price + ", paid_status="
				+ paid_status + ", user_id=" + user_id + "]";
	}

  
}
