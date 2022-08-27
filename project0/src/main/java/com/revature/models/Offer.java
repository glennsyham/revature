package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Offer {
	private int id;
	private int user_id;
	private int product_id;
	private double offer_price;
	private int status;
	private Timestamp created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public double getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(double offer_price) {
		this.offer_price = offer_price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(created_at, id, offer_price, product_id, status, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		return Objects.equals(created_at, other.created_at) && id == other.id
				&& Double.doubleToLongBits(offer_price) == Double.doubleToLongBits(other.offer_price)
				&& product_id == other.product_id && status == other.status && user_id == other.user_id;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", offer_price="
				+ offer_price + ", status=" + status + ", created_at=" + created_at + "]";
	}

}
