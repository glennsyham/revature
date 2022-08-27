package com.revature;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.revature.controller.ProductController;
import com.revature.controller.UserController;
import com.revature.daos.OfferDAO;
import com.revature.daos.OfferPostgres;
import com.revature.daos.ProductDAO;
import com.revature.daos.ProductPostgres;
import com.revature.daos.UserDAO;
import com.revature.daos.UserPostgres;
import com.revature.exceptions.LoginException;
import com.revature.models.Offer;
import com.revature.models.Product;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.OfferServices;
import com.revature.services.PaymentConService;
import com.revature.services.ProductService;
import com.revature.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverTest {
	 static Scanner scan;
	 static UserService us;
 	 static ProductService ps;
	 static PaymentConService pcs;
	 static Offer o;
	static OfferServices os;
	private static Logger log = LogManager.getLogger(Driver.class);
	static AuthService as;

	public static void main(String[] args) {
		as = new AuthService();
		os = new OfferServices();
		 ps = new ProductService();
		 pcs = new PaymentConService();
		 us = new UserService();
		 UserDAO ud = new UserPostgres();
		// List<User> users = us.getUsers();
		// for(User u : users) {
		// System.out.println(u);
		// }
		// rs = new RoleService();
		// List<Role> roles = rs.getRoles();
		// for(Role r : roles) {
		// System.out.println(r);
		// }

		//
		// List<Product> products = ps.getProducts();
		// for (Product p : products) {
		// System.out.println(p);
		// }

		// Product productTBC = new Product();
		// productTBC.setId(5);
		// productTBC.setPrice(10.00);
		// productTBC.setProduct_name(new String("Pusheen"));
		// if(ps.setProduct(productTBC)) {
		// System.out.println("working");
		// }
		// OfferDAO od = new OfferPostgres();
		// Offer offer = off.retrieveOfferById(50);
		// //System.out.println(offer);
		// if(off.verifyAcceptOffer(offer)) {
		// System.out.println("working");
		// } else {
		// System.out.println("false accept exist");
		// }
		// if(off.acceptOffer(offer)) {
		// System.out.println("working");
		// }
		// List<Offer> offers = od.retrieveOffers();
		// for (Offer o : offers) {
		// System.out.println(o);
		// }
		// scan = new Scanner(System.in);
		//
		// String username = null;
		// String password = null;
		// System.out.println("Please enter username:");
		// username = scan.nextLine();
		// System.out.println("Please enter password:");
		// password = scan.nextLine();
		//
		// try {
		// User u = as.login(username, password);
		// log.info(u);
		// } catch (LoginException e) {
		// System.out.println("Invalid credentials.");
		// log.error("Login exception was thrown: " + e.fillInStackTrace());
		// }
//		UserController u = new UserController();
//		u.login();
		// u.register();;
		// ProductController pc = new ProductController();
		// pc.searchname();
		// Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
		//
		// Date date = new Date();
		// Timestamp timestamp2 = new Timestamp(date.getTime());
		//
		//
		// Date d2 = null;
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// try {
		// d2 = dateFormat.parse("2022-06-20 02:54:19.919");
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// long d1 = System.currentTimeMillis();
		//
		// long diff = d1 - d2.getTime();
		// long diffDays = diff / (24 * 60 * 60 * 1000);
		//
		// System.out.println(diffDays);
		// System.out.println(timestamp2);
		// System.out.print(diffDays + " days, ");
		// int leftLimit = 48; // numeral '0'
		// int rightLimit = 122; // letter 'z'
		// int targetStringLength = 15;
		// Random random = new Random();
		//
		// String generatedString = random.ints(leftLimit, rightLimit + 1)
		// .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		// .limit(targetStringLength)
		// .collect(StringBuilder::new, StringBuilder::appendCodePoint,
		// StringBuilder::append)
		// .toString();
		//
		// System.out.println(generatedString);
		// pcs.resetPaymentConn(10, 52);
		// ps.resetProduct(10);
		// os.retrieveOfferByCustomer(106, 1);
		List<User> users = us.getUsers(); 	
		System.out.println(users); 
	}

}
