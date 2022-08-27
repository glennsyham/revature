/**
 * 
 */
package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column( columnDefinition = "NUMERIC(19,2)" )
	private double amount;
	
	@Column 
	private Timestamp  submitted;
	
	@Column
 	private Timestamp  resolved;
	
	@Column
	private String receipt;
	
	@Column
	private String description;
	
	@ManyToOne 
	@JoinColumn(name = "author_id")	
	private User author;
	
	@ManyToOne 
	@JoinColumn(name = "resolver_id")		
	private User resolver;	

	@ManyToOne 
	@JoinColumn(name = "reim_status_id")	
	private ReimbursementStatus  reim_status;
	
	@ManyToOne 
	@JoinColumn(name = "reimb_type_id")		
	private ReimbursementType  reim_type;

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

	public Timestamp  getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp  submitted) {
		this.submitted = submitted;
	}

	public Timestamp  getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp  resolved) {
		this.resolved = resolved;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public ReimbursementStatus getReim_status() {
		return reim_status;
	}

	public void setReim_status(ReimbursementStatus reim_status) {
		this.reim_status = reim_status;
	}

	public ReimbursementType getReim_type() {
		return reim_type;
	}

	public void setReim_type(ReimbursementType reim_type) {
		this.reim_type = reim_type;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(amount, id, receipt, resolved, submitted);
//	}
//	
//	@Override
//	public String toString() {
//		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
//				+ ", receipt=" + receipt + ", description=" + description + ", author=" + author + ", resolver="
//				+ resolver + ", reim_status=" + reim_status + ", reim_type=" + reim_type + "]";
//	}
 
	
}
