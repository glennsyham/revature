package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Payment {
	private int id;
	private double paid;
	private int payment_connection_id;
	private Timestamp created_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPaid() {
		return paid;
	}
	public void setPaid(double paid) {
		this.paid = paid;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public int getPayment_connection_id() {
		return payment_connection_id;
	}
	public void setPayment_connection_id(int payment_connection_id) {
		this.payment_connection_id = payment_connection_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(created_at, id, paid, payment_connection_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(created_at, other.created_at) && id == other.id
				&& Double.doubleToLongBits(paid) == Double.doubleToLongBits(other.paid)
				&& payment_connection_id == other.payment_connection_id;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", paid=" + paid + ", payment_connection_id=" + payment_connection_id
				+ ", created_at=" + created_at + "]";
	}
 
	 
	
	
}
