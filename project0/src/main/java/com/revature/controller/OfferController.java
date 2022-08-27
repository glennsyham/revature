package com.revature.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Offer;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.services.OfferServices;
import com.revature.services.ProductService;
import com.revature.services.UserService;

public class OfferController {
	private Offer o;
	private OfferServices os;
	private User u;
	private UserService us;
	private Scanner input = null;
	private ProductService ps;

	public OfferController() {
		o = new Offer();
		os = new OfferServices();
		u = new User();
		us = new UserService();
		ps = new ProductService();
	}

	public void displayoffers() {
		List<Offer> offers = os.getOffers(0);
		if (offers != null && offers.size() > 0) {
			System.out.println("Offers: ");
			for (Offer offer : offers) {
				singlelist(offer);
			}
		} else {
			System.out.println("No offers");
		}

	}
	
	public void acceptoffers() {
		input = new Scanner(System.in);
		int id = 0;
		System.out.println("Offer Accept");
		System.out.println("Ener Offer ID");
		id = input.nextInt();
		Offer o = os.getOfferByID(id);
		int allow = 0;
		if (o == null) {
			System.out.println("Cannot find offer");
		} 		
		if (o != null) {
			if(os.verifyAcceptOffer(o.getProduct_id()) == false) {
				System.out.println("Another offer has already been accepted");
			} else {
				allow = 1;
			}
			
		}
		if (allow == 1){
			singlelist(o);
			System.out.println("Do you want to accept this Offer? Y/N");
			String choice = input.next();
			switch (choice) {
			case "y":
			case "Y":
				System.out.println("Offer has been accepted");
				os.acceptOffer(o);
				
				break;
			case "n":
			case "N":
			default:
				System.out.println("Offer was not accepted");
				break;

			}

		}		
	}
	
	public void rejectoffers() {
		input = new Scanner(System.in);
		int id = 0;
		int allow = 1;
		System.out.println("Offer Reject");
		System.out.println("Ener Offer ID");
		id = input.nextInt();
		Offer o = os.getOfferByID(id);
		if(o.getStatus() == 1) {
			System.out.println("Cannot reject accepted offer");
			allow = 0;
		}
		if (o == null) {
			System.out.println("Cannot find offer");
			allow = 0;
		} 
		if(allow == 1){
			singlelist(o);
			System.out.println("Do you want to reject this Offer? Y/N");
			String choice = input.next();
			switch (choice) {
			case "y":
			case "Y":
				System.out.println("Offer has been rejected");
				os.rejectOffer(id);
				break;
			case "n":
			case "N":
			default:
				System.out.println("Offer was not rejected");
				break;

			}

		}

	}

	public void singlelist(Offer offer) {
		u = us.retrieveUserById(offer.getUser_id());
		Product p = ps.getProductByID(offer.getProduct_id());
		System.out.println("ID: " + offer.getId() + " | Date: " + new Date(offer.getCreated_at().getTime())  +" | Paid: "
				+ offer.getOffer_price() + " | Customer name: " + u.getUsername() + " | Product Name: "+ p.getProduct_name());

	}
	
	public void displayoffersCustomer(User cu) {
		List<Offer> offers = os.retrieveOfferByUserId(cu.getId());
		String txt_status = "";
		Product p = new Product();
		if (offers != null && offers.size() > 0) {
			System.out.println("Offers: ");

			for (Offer offer : offers) {
				txt_status = "";
				switch (offer.getStatus()) {
				case 0:
					 txt_status = "Pending";
					break;
				case 1:
					 txt_status = "Accepted";
					break;
				case 2:
					 txt_status = "Rejected";
					break;				
				default:
					break;
				}	
				p = ps.getProductByID(offer.getProduct_id());
				System.out.println("Product Name: "+ p.getProduct_name() +" | Date: " + new Date(offer.getCreated_at().getTime())  + " | Your Offer: "
						+ offer.getOffer_price() + " | Status: "+ txt_status);
			}
		} else {
			System.out.println("You have No Offers");
		}

	}	
}
