package com.revature.controller;

import java.util.Scanner;

import com.revature.models.User;

public class CustomerController {
	private Scanner scan;
	private ProductController pc;
	private  User currentUser;
	private OfferController oc;
	private PaymentController pyc;

	public CustomerController() {
		pc = new ProductController();
		oc = new OfferController();
		pyc = new PaymentController();
	}
	
	public void save(User u) {
		currentUser = u;
	}	
	public void customerStartMenu() {
		scan = new Scanner(System.in);
 		int choice = 0;
		int done = 0;
		 
		while (done == 0) {
			System.out.println("Main Menu:");
			System.out.println("1 = Products");
			System.out.println("2 = Your Offers");
			System.out.println("3 = Payments");
			System.out.println("4 = exit");
			choice = scan.nextInt();
			System.out.print("\033[H\033[2J");  
			System.out.flush();  		
			switch (choice) {
			case 1:
				productMenu();
 				break;
			case 2:
				oc.displayoffersCustomer(currentUser);
 				break;
			case 3:
				paymentMenu();
 				break;				
			case 4:
				done = 1;	
				System.out.println("Bye");
				System.exit(0); 
				break;
			default:
				System.err.println("Please try again");
				break;
			}
			
		}

	}	

	public void productMenu() {
		scan = new Scanner(System.in);
		int choice = 0;
		int done = 0;
 
 
		while (done == 0) {
			System.out.println("Products Menu:");
			System.out.println("1 = List");
			System.out.println("2 = Search by Name");
			System.out.println("3 = Make An Offer");
			System.out.println("4 = Products You own");
			System.out.println("5 = Main Menu");
			choice = scan.nextInt();
			System.out.print("\033[H\033[2J");  
			System.out.flush();  			
			switch (choice) {
			case 1:
				pc.listForCustomer();
				break;
			case 2:
				pc.searchnameCustomer();
				break;
			case 3:
				pc.makeoffer(currentUser);
				break;	
			case 4:
				pc.listCustomer(currentUser);
				break;
			case 5:
				done = 1;
				customerStartMenu();
				break;
				default:
				System.err.println("Please try again");
				break;
			}

		}
	}
	
	public void paymentMenu() {
		scan = new Scanner(System.in);
		int choice = 0;
		int done = 0;
 
 
		while (done == 0) {
			System.out.println("Payment Menu:");
			System.out.println("1 = List");
			System.out.println("2 = Make A Payment");
			System.out.println("3 = Main Menu");
			choice = scan.nextInt();
			System.out.print("\033[H\033[2J");  
			System.out.flush();  			
			switch (choice) {
			case 1:
				pyc.allByCustomer(currentUser);
				break;
			case 2:
				pyc.makepayment(currentUser);
				break;
 
			case 3:
				done = 1;
				customerStartMenu();
				break;
				default:
				System.err.println("Please try again");
				break;
			}

		}
	}	
}
