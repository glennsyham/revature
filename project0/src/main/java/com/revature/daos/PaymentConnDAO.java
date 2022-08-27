package com.revature.daos;

import java.sql.ResultSet;
import java.util.List;

import com.revature.models.PaymentConn;
import com.revature.models.Product;

public interface PaymentConnDAO {
	PaymentConn createPaymentConn(PaymentConn pc);

	PaymentConn retrievePaymentConnById(int id);

	PaymentConn retrievePaymentConnByProductIdUserId(int pid, int uid);

	List<PaymentConn> retrievePaymentConnByUserId(int id);

	List<PaymentConn> retrievePaymentConnByUserId(int id, int active);

	boolean updatePaymentConn(PaymentConn pc);

	boolean deletePaymentConnById(int id);

	PaymentConn returnData(ResultSet rs, PaymentConn paymentconn);

	boolean resetPaymentConn(int pid, int uid);

	boolean paymentConnProductDelete(int pid, int uid);

}
