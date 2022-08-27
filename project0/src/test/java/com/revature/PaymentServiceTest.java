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
import org.junit.jupiter.api.Disabled;

import com.revature.models.Payment;
import com.revature.models.Product;
import com.revature.services.PaymentService;

public class PaymentServiceTest {
	private static PaymentService pservice;

	@BeforeAll
	public static void setUp() {
		pservice = new PaymentService();
	}

	@Test
	public void add() {
		Payment pcreate = new Payment();
		pcreate.setPaid(1);
		pcreate.setPayment_connection_id(12);
		Payment actual = pservice.createPayment(pcreate);
		assertNotNull(actual);
		pservice.deletePaymentById(actual.getId());
	}
	
	@Test
	public void retrievById() {		
		Payment actual =  pservice.retrievePaymentById(200);
		assertNull(actual);
 	}	
 
	@Test
	public void deletbyId() {
		Boolean actual =  pservice.deletePaymentById(0);
		assertFalse(actual);
 	}		
}
