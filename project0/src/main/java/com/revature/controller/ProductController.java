package com.revature.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Offer;
import com.revature.models.Payment;
import com.revature.models.PaymentConn;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.services.OfferServices;
import com.revature.services.PaymentConService;
import com.revature.services.PaymentService;
import com.revature.services.ProductService;
import com.revature.services.UserService;

public class ProductController {
	private ProductService ps;
	private UserService us;
	private PaymentService pys;
	private PaymentConService pcs;
	private Scanner input = null;
	private List<Product> products = null;
	private User u = null;
	private OfferServices os;

	public ProductController() {
		ps = new ProductService();
		os = new OfferServices();
		us = new UserService();
		pys = new PaymentService();
		pcs = new PaymentConService();
		input = new Scanner(System.in);
	}

	public void list() {
		List<Product> products = null;
		System.out.println("Product List");
		products = ps.getProducts(0);
		for (Product p : products) {

			System.out.println("ID: " + p.getId() + " | Product Name: " + p.getProduct_name() + " | Minimum Price: "
					+ p.getPrice());
		}
		products = ps.getProducts(1);
		if (products != null) {
			System.out.println("Owned Products");
		}

		for (Product p : products) {
			displayList(p);
		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}

	}

	public void searchname() {
		System.out.println("Product search");
		System.out.println("Type in Product name");
		String pd_name = input.nextLine();
		products = ps.getProductByName(pd_name);
		if (products.size() < 1) {
			System.out.println("Product not found");
		}
		for (Product p : products) {
			displayList(p);
		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}

	}

	public void add() {
		input = new Scanner(System.in);
		System.out.println("Product add");

		System.out.println("Ener name");
		String pd_name = input.nextLine();
		System.out.println("Enter price");
		Double pd_price = input.nextDouble();
		Product p = new Product();
		p.setProduct_name(pd_name);
		p.setPrice(pd_price);

		Product psearch = ps.retrieveProductByNameExact(pd_name);
		if (psearch != null) {
			System.out.println("name already exist");
		} else if (pd_price < 1) {
			System.out.println("price cannot be lesser than 1");

		} else {
			ps.createProduct(p);
			System.out.println("Successfully added");
		}

		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void edit() {
		int id = 0;
		input = new Scanner(System.in);
		System.out.println("Product edit");
		System.out.println("Ener Product ID");
		id = input.nextInt();
		Product p = ps.getProductByID(id);
		if (p == null) {
			System.out.println("Cannot find Product");
		} else if (p.getUser_id() > 0) {
			System.out.println("Cannot Delete Product that been paid");		
		} else {
			displayList(p);
			System.out.println("Ener name");
			String pd_name = input.next();
			System.out.println("Enter price");
			Double pd_price = input.nextDouble();
			Product product = new Product();
			product.setProduct_name(pd_name);
			product.setPrice(pd_price);
			product.setId(id);
			;

			Product psearch = ps.retrieveProductByNameExact(pd_name, id);

			if (psearch != null) {
				System.out.println("name already exist");
			} else if (pd_price < 1) {
				System.out.println("price cannot be lesser than 1");
			} else {
				ps.setProduct(product);
				System.out.println("Successfully edit");
			}
		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void delete() {
		int id = 0;
		System.out.println("Product Delete");
		System.out.println("Ener Product ID");
		id = input.nextInt();
		Product p = ps.getProductByID(id);
	 
		if (p == null) {
			System.out.println("Cannot find Product");
		} else if (p.getUser_id() >= 1) {
				System.out.println("Cannot Delete Product that been paid");	
		} else {
			displayList(p);
			System.out.println("Do you want to delete this product Y/N");
			String choice = input.next();
			switch (choice) {
				case "y":
				case "Y":
					System.out.println("Product has been deleted");
//					os.deleteOfferByProductId(id);
					ps.deleteProductById(id);
					break;
				case "n":
				case "N":
				default:
					System.out.println("Product was not deleted");
					break;

			}

		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

//	public void resetProduct() {
//		int id = 0;
//		System.out.println("Product Reset Ownership");
//		System.out.println("Ener Product ID");
//		id = input.nextInt();
//		Product p = ps.getProductByID(id);
//		if (p == null) {
//			System.out.println("Cannot find product");
//		} else if (p.getUser_id() < 1) {
//			System.out.println("Product has no user");
//		} else {
//			displayList(p);
//			System.out.println("Do you want to reset this product Y/N");
//			String choice = input.next();
//			switch (choice) {
//				case "y":
//				case "Y":
//					System.out.println("Product has been reset");
//					pcs.resetPaymentConn(id, p.getUser_id());
//					os.deleteOfferByProductId(id);
//					ps.resetProduct(id);
//					break;
//				case "n":
//				case "N":
//				default:
//					System.out.println("Product was not reset");
//					break;
//
//			}
//
//		}
//		System.out.println("Press enter to continue");
//		try {
//			System.in.read();
//		} catch (Exception e) {
//		}
//	}

	/*
	 * display product
	 */
	public void displayList(Product p) {
		u = null;
		PaymentConn pc = null;
		int usid = 0;
		String extra = new String();
		extra = "";
		usid = p.getUser_id();
		List<Payment> payments = null;

		if (usid > 0) {
			u = us.retrieveUserById(p.getUser_id());
			extra = " | Customer Owned: " + u.getUsername();
			PaymentConn paymentconn = pcs.getPaymentConnByProductIdUserId(p.getId(), p.getUser_id());
			payments = pys.retrievePaymentsByConnID(paymentconn.getId());

		}
		System.out.println(" ");
		System.out.println("ID: " + p.getId() + " | Product Name: " + p.getProduct_name() + " | Minimum Price: "
				+ p.getPrice() + extra);
		if (payments != null && payments.size() > 0) {
			System.out.println(" ");
			System.out.println("Payments: ");
			for (Payment payment : payments) {

				System.out.println(
						"Date: " + new Date(payment.getCreated_at().getTime()) + " | Paid: " + payment.getPaid());
			}
		}

	}

	public void listForCustomer() {
		List<Product> products = null;
		System.out.println("Product List");
		products = ps.getProducts(0);
		String extra = "";

		for (Product p : products) {
			extra = "";
			Offer offer = os.retrieveMaxOfferByProductId(p.getId());
			if (offer != null) {
				extra = " | Current Highest Offer: " + offer.getOffer_price();
			}
			System.out.println("ID: " + p.getId() + " | Product Name: " + p.getProduct_name() + " | Minimum Price: "
					+ p.getPrice() + " " + extra);
		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}

	}

	public void searchnameCustomer() {
		System.out.println("Product search");
		System.out.println("Type in Product name");
		String pd_name = input.nextLine();
		products = ps.retrieveProductByNameCustomer(pd_name);
		if (products.size() < 1) {
			System.out.println("Product not found");
		}
		for (Product p : products) {
			displayList(p);
		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void makeoffer(User cu) {
		int id = 0;
		int allow = 1;
		int allow_create = 0;
 		Offer checkoffer = new  Offer();
		input = new Scanner(System.in);
		System.out.println("Product Offer");
		System.out.println("Ener Product ID");
		id = input.nextInt();
		Product p = ps.getProductByID(id);
		if (p == null  ) {
			System.out.println("Cannot find Product");
			allow = 0;
		} else if( p.getUser_id() > 0) {
			System.out.println("Cannot find Product");
			allow = 0;			
		} 
	
		if (allow == 1) {
			displayList(p);
			System.out.println("Enter offer price");
			Double pd_price = input.nextDouble();
			if (pd_price >= p.getPrice()) {
				Offer o = new Offer();
				o.setOffer_price(pd_price);
				o.setProduct_id(id);
				o.setUser_id(cu.getId());

				checkoffer = os.retrieveOfferByCustomer(id, cu.getId(), 0);
				if (checkoffer == null) {
					os.createOffer(o);
				} else {
					o.setId(checkoffer.getId());
					os.setOffer(o);
					
				}

				System.out.println("Your offer has been created");
			} else {
				System.out.println("Offer price cannot be less than current " + p.getPrice());
			}
		}
		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void listCustomer(User cu) {
		List<Product> products = null;
		System.out.println("Product List");
		products = ps.retrieveProductByUserId(cu.getId());
		PaymentConn payc = new PaymentConn();
		double sum = 0;
		double paid_left = 0;
		String extra = "";
		if (products.size() < 1) {
			System.out.println("You have No Products");
		}
		for (Product p : products) {
			extra = "";
			payc = pcs.getPaymentConnByProductIdUserId(p.getId(), cu.getId());
			sum = pys.retrievePaymentsSumByPC(payc.getId());

			paid_left = payc.getOffer_price() - sum;
			if (p.getPaid_status() == 1) {
				extra = " Fully Paid";
			} else {
				DecimalFormat df = new DecimalFormat("###.##");
				extra = "  Remaining payments " + df.format(paid_left);
			}
			System.out.println("ID: " + p.getId() + " | Product Name: " + p.getProduct_name() + " | Payment Price: "
					+ payc.getOffer_price() + extra);
		}

		System.out.println("Press enter to continue");
		try {
			System.in.read();
		} catch (Exception e) {
		}

	}

}
