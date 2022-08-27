package com.revature.services;

import java.util.List;

import com.revature.daos.OfferDAO;
import com.revature.daos.OfferPostgres;
import com.revature.daos.PaymentConnDAO;
import com.revature.daos.PaymentConnPostgres;
import com.revature.daos.PaymentDAO;
import com.revature.daos.PaymentPostgres;
import com.revature.daos.ProductDAO;
import com.revature.daos.ProductPostgres;
import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.PaymentConn;
import com.revature.models.Product;

public class OfferServices {
	private OfferDAO od = new OfferPostgres();
	private PaymentConnDAO pdc = new PaymentConnPostgres();
	private ProductDAO pd = new ProductPostgres();
	private PaymentDAO payd = new PaymentPostgres();
	
	public List<Offer> getOffers() {
		return od.retrieveOffers();
	}

	public List<Offer> getOffers(int status) {
		return od.retrieveOffers(status);
	}

	public Offer createOffer(Offer os) {
		return od.createOffer(os);
	}

	public Offer getOfferByID(int id) {
		return od.retrieveOfferById(id);
	}

	public boolean setOffer(Offer os) {
		return od.updateOffer(os);
	}

	public boolean deleteOfferById(int id) {
		return od.deleteOfferById(id);
	}

	public List<Offer> retrieveOfferByUserId(int id) {
		return od.retrieveOfferByUserId(id);
	}

	public boolean acceptOffer(Offer o) {
		
		Product p = pd.retrieveProductById(o.getProduct_id());
		pd.setProducttoUser(o.getProduct_id(), o.getUser_id());
		PaymentConn paymentconn = new PaymentConn();
		//offer_price, product_details, user_id, product_id, offers_id
		paymentconn.setOffer_price(o.getOffer_price());
		paymentconn.setPayment_details(p.getProduct_name());
		paymentconn.setUser_id(o.getUser_id());
		paymentconn.setProduct_id(o.getProduct_id());
		paymentconn.setOffers_id(o.getId());
		paymentconn = pdc.createPaymentConn(paymentconn);
		Payment payment = new Payment();
		//paid, payment_connection_id
		payment.setPaid((o.getOffer_price()/2) );
		payment.setPayment_connection_id(paymentconn.getId());
		payd.createPayment(payment);
		
		return od.acceptOffer(o.getId(),o.getProduct_id());
	}

	public boolean verifyAcceptOffer(int pid) {
		return od.verifyAcceptOffer( pid);
	}

	public boolean deleteOfferByProductId(int id) {
		return od.deleteOfferByProductId(id);
	}	
	
	public boolean rejectOffer(int id) {
		return od.rejectOffer(id);
	}
	
	public Offer retrieveMaxOfferByProductId(int pid) {
		return od.retrieveMaxOfferByProductId(pid);
	}	
	
	public Offer retrieveOfferByCustomer(int pid, int uid, int status) {
		return od.retrieveOfferByCustomer(pid,uid,status);	
	}
}
