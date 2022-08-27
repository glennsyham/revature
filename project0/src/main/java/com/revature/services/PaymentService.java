package com.revature.services;

import java.util.List;

import com.revature.daos.PaymentDAO;
import com.revature.daos.PaymentPostgres;
import com.revature.models.Payment;

public class PaymentService {
	private PaymentDAO pd = new PaymentPostgres();
	
	public Payment createPayment(Payment py) {
		return pd.createPayment(py);
	}	

	public Payment retrievePaymentById(int id) {
		return pd.retrievePaymentById(id);
	}	

	public List<Payment> retrievePayments() {
		return pd.retrievePayments();
	}		
	
	public boolean updatePayment(Payment py) {
		return pd.updatePayment(py);
	}	


	public boolean deletePaymentById(int id) {
		return pd.deletePaymentById(id);
	}		


	public Payment retrievefirstPaymentByUserId(int id){
		return pd.retrievefirstPaymentByUserId(id);
	}		
	
	public List<Payment> retrievePaymentsByConnID(int id) {
		return pd.retrievePaymentsByConnID(id);
	}
	
	
	public double retrievePaymentsSumByPC(int cid) {
		return pd.retrievePaymentsSumByPC(cid);
	}	
}
