package com.revature.dto;

public class ReqReimbursementDTO {

	private int id;

	private double amount;

	private String receipt;

	private int author_id;

	private int resolver_id;

	private int reim_status_id;

	private int reimb_type_id;

	private String description; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public int getResolver_id() {
		return resolver_id;
	}

	public void setResolver_id(int resolver_id) {
		this.resolver_id = resolver_id;
	}

	public int getReim_status_id() {
		return reim_status_id;
	}

	public void setReim_status_id(int reim_status_id) {
		this.reim_status_id = reim_status_id;
	}

	public int getReimb_type_id() {
		return reimb_type_id;
	}

	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ReqReimbursementDTO [id=" + id + ", amount=" + amount + ", receipt=" + receipt + ", author_id="
				+ author_id + ", resolver_id=" + resolver_id + ", reim_status_id=" + reim_status_id + ", reimb_type_id="
				+ reimb_type_id + ", description=" + description + "]";
	}

 
}
