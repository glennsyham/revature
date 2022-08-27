package com.revature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.models.Offer;
import com.revature.services.OfferServices;

public class OfferServicesTest {
	private static OfferServices oservices; 
	
	@BeforeAll
	public static void setUp() {
		oservices = new OfferServices();
	}
	
 	@Test
 	public void add() {
 		Offer pc = new Offer();
 		pc.setOffer_price(29);
 		pc.setProduct_id(17);
 		pc.setUser_id(4);
 		Offer actual = oservices.createOffer(pc);
 		assertNotNull(actual);
 		oservices.deleteOfferById(actual.getId());
 	}
 	
	@Test
	public void retrievById() {		
		Offer actual =  oservices.getOfferByID(200);
		assertNull(actual);
 	}	
 
	@Test
	public void deletbyId() {
		Boolean actual =  oservices.deleteOfferById(0);
		assertFalse(actual);
 	}		
}
