package com.revature.services;

import java.util.List;

import com.revature.daos.PaymentConnDAO;
import com.revature.daos.PaymentConnPostgres;
import com.revature.models.PaymentConn;

public class PaymentConService {
	private PaymentConnDAO pd = new PaymentConnPostgres();
	
	public PaymentConn createPaymentConn(PaymentConn pc) {
		return pd.createPaymentConn(pc);
	}

	public PaymentConn getPaymentConnById(int id) {
		return pd.retrievePaymentConnById(id);
	}

	public PaymentConn getPaymentConnByProductIdUserId(int pid, int uid ) {
		return pd.retrievePaymentConnByProductIdUserId(pid, uid);
	}
	
 	public List<PaymentConn> getPaymentConnByUserId(int id) {
		return pd.retrievePaymentConnByUserId(id);
	}
	
 	public List<PaymentConn> getPaymentConnByUserId(int id, int active) {
		return pd.retrievePaymentConnByUserId(id,active);
	}

	public boolean updatePaymentConn(PaymentConn pc) {
		return pd.updatePaymentConn(pc);
	}

	public boolean deletePaymentConnById(int id) {
		return pd.deletePaymentConnById(id);
	}
	
	public boolean resetPaymentConn(int pid, int uid) {
		return pd.resetPaymentConn(pid, uid);
	} 

	public boolean paymentConnProductDelete(int pid, int uid) {
		return pd.paymentConnProductDelete(pid, uid);
	} 
}
