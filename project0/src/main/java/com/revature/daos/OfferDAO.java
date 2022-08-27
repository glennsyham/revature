package com.revature.daos;

import java.sql.ResultSet;
import java.util.List;

import com.revature.models.Offer;

public interface OfferDAO {
	Offer createOffer(Offer o);
	Offer retrieveOfferById(int id);
	List<Offer> retrieveOffers();
	List<Offer> retrieveOffers(int status);
	boolean updateOffer(Offer o);
	boolean deleteOfferById(int id);
	List<Offer> retrieveOfferByUserId(int id);
	boolean acceptOffer(int id, int pid);
	boolean rejectOffer(int id);
	boolean verifyAcceptOffer(int pid);
	boolean deleteOfferByProductId(int id);
	Offer retrieveMaxOfferByProductId(int pid);
	Offer retrieveOfferByCustomer(int pid, int uid, int status);
	Offer returnData(ResultSet rs,Offer o);	
}
