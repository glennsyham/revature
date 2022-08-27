package com.revature.daos;

import java.sql.ResultSet;
import java.util.List;

import com.revature.models.Payment;

public interface PaymentDAO {
	Payment createPayment(Payment p);
	Payment retrievePaymentById(int id);
	List<Payment> retrievePayments();
	boolean updatePayment(Payment p);
	boolean deletePaymentById(int id);
	Payment retrievefirstPaymentByUserId(int id);	
	Payment returnData(ResultSet rs,Payment user);
	List<Payment> retrievePaymentsByConnID(int cid);
	double retrievePaymentsSumByPC(int cid);
}
