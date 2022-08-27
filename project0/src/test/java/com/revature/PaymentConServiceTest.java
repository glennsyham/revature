package com.revature;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Payment;
import com.revature.models.PaymentConn;
import com.revature.services.PaymentConService;

import org.junit.jupiter.api.Disabled;

public class PaymentConServiceTest {
	private static PaymentConService pcs;
	
	@BeforeAll
	public static void setUp() {
		pcs = new PaymentConService();
	}
	
 	@Test
 	public void add() {
 		PaymentConn pc = new PaymentConn();
 		pc.setUser_id(26);
 		pc.setOffers_id(29);
 		pc.setProduct_id(17);
 		pc.setActive(1);
 		PaymentConn actual = pcs.createPaymentConn(pc);
 		assertNotNull(actual);
 		pcs.deletePaymentConnById(actual.getId());
 	}
 	
	@Test
	public void retrievById() {		
		PaymentConn actual =  pcs.getPaymentConnById(200);
		assertNull(actual);
 	}	
 
	@Test
	public void deletbyId() {
		Boolean actual =  pcs.deletePaymentConnById(0);
		assertFalse(actual);
 	}		
}
