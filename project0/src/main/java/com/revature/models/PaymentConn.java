package com.revature.models;

import java.util.Objects;

public class PaymentConn {
	private int id;
	private double offer_price;
	private String payment_details;
	private int active;
	private int user_id;
	private int product_id;
	private int offers_id;
	private String transaction_no;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getOffer_price() {
		return offer_price;
	}
	public void setOffer_price(double offer_price) {
		this.offer_price = offer_price;
	}
 
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
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
	public int getOffers_id() {
		return offers_id;
	}
	public void setOffers_id(int offers_id) {
		this.offers_id = offers_id;
	}
	public String getPayment_details() {
		return payment_details;
	}
	public void setPayment_details(String payment_details) {
		this.payment_details = payment_details;
	}
	public String getTransaction_no() {
		return transaction_no;
	}
	public void setTransaction_no(String transaction_no) {
		this.transaction_no = transaction_no;
	}
	@Override
	public int hashCode() {
		return Objects.hash(active, id, offer_price, offers_id, payment_details, product_id, transaction_no, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentConn other = (PaymentConn) obj;
		return active == other.active && id == other.id
				&& Double.doubleToLongBits(offer_price) == Double.doubleToLongBits(other.offer_price)
				&& offers_id == other.offers_id && Objects.equals(payment_details, other.payment_details)
				&& product_id == other.product_id && Objects.equals(transaction_no, other.transaction_no)
				&& user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "PaymentConn [id=" + id + ", offer_price=" + offer_price + ", payment_details=" + payment_details
				+ ", active=" + active + ", user_id=" + user_id + ", product_id=" + product_id + ", offers_id="
				+ offers_id + ", transaction_no=" + transaction_no + "]";
	}
 
 
	
 }
