package com.revature.controller;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.PaymentConService;
import com.revature.services.PaymentService;
import com.revature.services.ProductService;
import com.revature.services.UserService;

public class EmployeeController {
	private Scanner scan;
	private ProductController pc;
	private UserController uc;
	private OfferController oc;

	
	public EmployeeController() {
		pc = new ProductController();
		uc = new UserController();
		oc = new OfferController();
	}
	

	
	public void employeeStartMenu() {
		scan = new Scanner(System.in);
		PaymentController payc = new PaymentController();
		int choice = 0;
		int done = 0;
		 
		while (done == 0) {
			System.out.println("Main Menu:");
			System.out.println("1 = Products");
			System.out.println("2 = Offers");
			System.out.println("3 = Payments");
			System.out.println("4 = Exit");
			choice = scan.nextInt();
			System.out.print("\033[H\033[2J");  
			System.out.flush();  				
			switch (choice) {
			case 1:
				productMenu();
				break;
			case 2:
				offerMenu();
				break;
			case 3:
				payc.allByEmplyee();
				
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
			System.out.println("3 = Add");
			System.out.println("4 = Edit");
			System.out.println("5 = Delete");
			System.out.println("6 = Main Menu");
			choice = scan.nextInt();
			System.out.print("\033[H\033[2J");  
			System.out.flush();  				
			switch (choice) {
			case 1:
				pc.list();
				break;
			case 2:
				pc.searchname();
				break;
			case 3:
				pc.add();
				break;
			case 4:
				pc.edit();
				break;
			case 5:
				pc.delete();
				break;
			case 6:
				done = 1;
				employeeStartMenu();
				break;
			default:
				System.err.println("Please try again");
				break;
			}

		}
	}
	
	
	public void offerMenu() {
		scan = new Scanner(System.in);
		int choice = 0;
		int done = 0;
 
 
		while (done == 0) {
			System.out.println("Offer Menu:");
			System.out.println("1 = List");
			System.out.println("2 = Accept Offer");
			System.out.println("3 = Reject Offer");
			System.out.println("4 = Main Menu");
			choice = scan.nextInt();
			System.out.print("\033[H\033[2J");  
			System.out.flush();  				
			switch (choice) {
			case 1:
				oc.displayoffers();
 				break;
			case 2:
				oc.acceptoffers();
 				break;
			case 3:
				oc.rejectoffers(); 
				break;
			case 4:
				done = 1;
				employeeStartMenu();
				break;
			default:
				System.err.println("Please try again");
				break;
			}

		}
	}
}
