package our_code;

import java.util.Scanner;

public class UserCommandLine {
	
	// Reusable strings
	final static String separator = "==================================================";
	final static String invalidOption = "Invalid function selected! Please enter the number displayed next to your chosen option.";
	
	// App functionality - Keeping these static as they're used across different methods
	// TODO Connect database
	static Scanner in = new Scanner(System.in);
	static String functionNumber = "-99";
	
	public static void main(String[] args) {
		try {
			boolean appRunning = true;
			
			while (appRunning) {
				listEntitiesAvailable();
				functionNumber = in.nextLine();
				functionNumber = functionNumber.toLowerCase();
				
				switch (functionNumber) {
				case "customer":
				case "c":
				case "1":
					manageCustomer();
					break;
					
				case "publication":
				case "p":
				case "2":
					managePublication();
					break;
					
				case "order":
				case "o":
				case "3":
					manageOrder();
					break;
					
				case "invoice":
				case "i":
				case "4":
					manageInvoice();
					break;
					
				case "delivery docket":
				case "dd":
				case "5":
					manageDeliveryDocket();
					break;
					
				case "delivery area":
				case "da":
				case "6":
					manageDeliveryArea();
					break;
					
				case "delivery person":
				case "dp":
				case "7":
					manageDeliveryPerson();
					break;
					
				case "exit":
				case "close":
				case "x":
				case "0":
					appRunning = false;
					System.out.println("Closing the application...");
					break;
					
				default:
					System.out.println(invalidOption);
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	private static void listEntitiesAvailable() {
		System.out.println(separator);
		System.out.println("Please select the entity you would like to manage:");
		System.out.println("1. Customer");
		System.out.println("2. Publication");
		System.out.println("3. Order");
		System.out.println("4. Invoice");
		System.out.println("5. Delivery Docket");
		System.out.println("6. Delivery Area");
		System.out.println("7. Delivery Person");
		System.out.println("\n0. [Close] the application");
		System.out.println(separator + "\n");
	}
	
	private static void listEntityOptions(String entity) {
		System.out.println(separator);
		System.out.println("MANAGING " + entity.toUpperCase() + "S - Please select one option:");
		System.out.println("1. [Create] a new " + entity + " record");
		System.out.println("2. [View All] " + entity + " records");
		System.out.println("3. [View] " + entity + " record by ID");
		System.out.println("4. [Update] " + entity + " record by ID");
		System.out.println("5. [Delete] " + entity + " record by ID");
		System.out.println("\n0. [Return] to Entity Management");
		System.out.println(separator + "\n");
	}
	
	private static void manageCustomer() {
		boolean managingEntity = true;
		
		while (managingEntity) {
			listEntityOptions("Customer");
			functionNumber = in.nextLine();
			functionNumber = functionNumber.toLowerCase();
			
			switch(functionNumber) {
			case "create":
			case "c":
			case "1":
				System.out.println("Creating customer... [NOT YET IMPLEMENTED]"); //TODO Create Customer
				break;
				
			case "view all":
			case "va":
			case "2":
				System.out.println("Viewing all Customer records... [NOT YET IMPLEMENTED]"); //TODO Read all Customers
				break;
				
			case "view":
			case "v":
			case "3":
				System.out.println("Viewing specific Customer record... [NOT YET IMPLEMENTED]"); //TODO Read Customer by ID
				break;
			
			case "update":
			case "u":
			case "4":
				System.out.println("Updating Customer record... [NOT YET IMPLEMENTED]"); //TODO Update Customer
				break;
				
			case "delete":
			case "d":
			case "5":
				System.out.println("Deleting Customer record... [NOT YET IMPLEMENTED]"); //TODO Delete Customer
				break;
				
			case "back":
			case "return":
			case "exit":
			case "close":
			case "0":
				managingEntity = false;
				System.out.println("Returning to Entity Management...");
				break;
				
			default:
				System.out.println(invalidOption);
				break;
			}
			
		}
	}
	
	private static void managePublication() {
		boolean managingEntity = true;
		
		while (managingEntity) {
			listEntityOptions("Publication");
			functionNumber = in.nextLine();
			functionNumber = functionNumber.toLowerCase();
			
			switch(functionNumber) {
			case "create":
			case "c":
			case "1":
				System.out.println("Creating Publication... [NOT YET IMPLEMENTED]"); //TODO Create Publication
				break;
				
			case "view all":
			case "va":
			case "2":
				System.out.println("Viewing all Publication records... [NOT YET IMPLEMENTED]"); //TODO Read all Publications
				break;
				
			case "view":
			case "v":
			case "3":
				System.out.println("Viewing specific Publication record... [NOT YET IMPLEMENTED]"); //TODO Read Publication by ID
				break;
				
			case "update":
			case "u":
			case "4":
				System.out.println("Updating Publication record... [NOT YET IMPLEMENTED]"); //TODO Update Publication
				break;
				
			case "delete":
			case "d":
			case "5":
				System.out.println("Deleting Publication record... [NOT YET IMPLEMENTED]"); //TODO Delete Publication
				break;
				
			case "back":
			case "return":
			case "exit":
			case "close":
			case "0":
				managingEntity = false;
				System.out.println("Returning to Entity Management...");
				break;
				
			default:
				System.out.println(invalidOption);
				break;
			}
			
		}
	}
	
	private static void manageOrder() {
		boolean managingEntity = true;
		
		while (managingEntity) {
			listEntityOptions("Order");
			functionNumber = in.nextLine();
			functionNumber = functionNumber.toLowerCase();
			
			switch(functionNumber) {
			case "create":
			case "c":
			case "1":
				System.out.println("Creating Order... [NOT YET IMPLEMENTED]"); //TODO Create Order
				break;
				
			case "view all":
			case "va":
			case "2":
				System.out.println("Viewing all Order records... [NOT YET IMPLEMENTED]"); //TODO Read all Orders
				break;
				
			case "view":
			case "v":
			case "3":
				System.out.println("Viewing specific Order record... [NOT YET IMPLEMENTED]"); //TODO Read Order by ID
				break;
				
			case "update":
			case "u":
			case "4":
				System.out.println("Updating Order record... [NOT YET IMPLEMENTED]"); //TODO Update Order
				break;
				
			case "delete":
			case "d":
			case "5":
				System.out.println("Deleting Order record... [NOT YET IMPLEMENTED]"); //TODO Delete Order
				break;
				
			case "back":
			case "return":
			case "exit":
			case "close":
			case "0":
				managingEntity = false;
				System.out.println("Returning to Entity Management...");
				break;
				
			default:
				System.out.println(invalidOption);
				break;
			}
			
		}
	}
	
	private static void manageInvoice() {
		boolean managingEntity = true;
		
		while (managingEntity) {
			listEntityOptions("Invoice");
			functionNumber = in.nextLine();
			functionNumber = functionNumber.toLowerCase();
			
			switch(functionNumber) {
			case "create":
			case "c":
			case "1":
				System.out.println("Creating Invoice... [NOT YET IMPLEMENTED]"); //TODO Create Invoice
				break;
				
			case "view all":
			case "va":
			case "2":
				System.out.println("Viewing all Invoice records... [NOT YET IMPLEMENTED]"); //TODO Read all Invoices
				break;
				
			case "view":
			case "v":
			case "3":
				System.out.println("Viewing specific Invoice record... [NOT YET IMPLEMENTED]"); //TODO Read Invoice by ID
				break;
				
			case "update":
			case "u":
			case "4":
				System.out.println("Updating Invoice record... [NOT YET IMPLEMENTED]"); //TODO Update Invoice
				break;
				
			case "delete":
			case "d":
			case "5":
				System.out.println("Deleting Invoice record... [NOT YET IMPLEMENTED]"); //TODO Delete Invoice
				break;
				
			case "back":
			case "return":
			case "exit":
			case "close":
			case "0":
				managingEntity = false;
				System.out.println("Returning to Entity Management...");
				break;
				
			default:
				System.out.println(invalidOption);
				break;
			}
			
		}
	}
	
	private static void manageDeliveryDocket() {
		boolean managingEntity = true;
		
		while (managingEntity) {
			listEntityOptions("Delivery Docket");
			functionNumber = in.nextLine();
			functionNumber = functionNumber.toLowerCase();
			
			switch(functionNumber) {
			case "create":
			case "c":
			case "1":
				System.out.println("Creating Delivery Docket... [NOT YET IMPLEMENTED]"); //TODO Create Delivery Docket
				break;
				
			case "view all":
			case "va":
			case "2":
				System.out.println("Viewing all Delivery Docket records... [NOT YET IMPLEMENTED]"); //TODO Read all Delivery Dockets
				break;
				
			case "view":
			case "v":
			case "3":
				System.out.println("Viewing specific Delivery Docket record... [NOT YET IMPLEMENTED]"); //TODO Read Delivery Docket by ID
				break;
				
			case "update":
			case "u":
			case "4":
				System.out.println("Updating Delivery Docket record... [NOT YET IMPLEMENTED]"); //TODO Update Delivery Docket
				break;
				
			case "delete":
			case "d":
			case "5":
				System.out.println("Deleting Delivery Docket record... [NOT YET IMPLEMENTED]"); //TODO Delete Delivery Docket
				break;
				
			case "back":
			case "return":
			case "exit":
			case "close":
			case "0":
				managingEntity = false;
				System.out.println("Returning to Entity Management...");
				break;
				
			default:
				System.out.println(invalidOption);
				break;
			}
			
		}
	}
	
	private static void manageDeliveryArea() {
		boolean managingEntity = true;
		
		while (managingEntity) {
			listEntityOptions("Delivery Area");
			functionNumber = in.nextLine();
			functionNumber = functionNumber.toLowerCase();
			
			switch(functionNumber) {
			case "create":
			case "c":
			case "1":
				System.out.println("Creating Delivery Area... [NOT YET IMPLEMENTED]"); //TODO Create Delivery Area
				break;
				
			case "view all":
			case "va":
			case "2":
				System.out.println("Viewing all Delivery Area records... [NOT YET IMPLEMENTED]"); //TODO Read all Delivery Areas
				break;
				
			case "view":
			case "v":
			case "3":
				System.out.println("Viewing specific Delivery Area record... [NOT YET IMPLEMENTED]"); //TODO Read Delivery Area by ID
				break;
				
			case "update":
			case "u":
			case "4":
				System.out.println("Updating Delivery Area record... [NOT YET IMPLEMENTED]"); //TODO Update Delivery Area
				break;
				
			case "delete":
			case "d":
			case "5":
				System.out.println("Deleting Delivery Area record... [NOT YET IMPLEMENTED]"); //TODO Delete Delivery Area
				break;
				
			case "back":
			case "return":
			case "exit":
			case "close":
			case "0":
				managingEntity = false;
				System.out.println("Returning to Entity Management...");
				break;
				
			default:
				System.out.println(invalidOption);
				break;
			}
			
		}
	}
	
	private static void manageDeliveryPerson() {
		boolean managingEntity = true;
		
		while (managingEntity) {
			listEntityOptions("Delivery Person");
			functionNumber = in.nextLine();
			functionNumber = functionNumber.toLowerCase();
			
			switch(functionNumber) {
			case "create":
			case "c":
			case "1":
				System.out.println("Creating Delivery Person... [NOT YET IMPLEMENTED]"); //TODO Create Delivery Person
				break;
				
			case "view all":
			case "va":
			case "2":
				System.out.println("Viewing all Delivery Person records... [NOT YET IMPLEMENTED]"); //TODO Read all Delivery People
				break;
				
			case "view":
			case "v":
			case "3":
				System.out.println("Viewing specific Delivery Person record... [NOT YET IMPLEMENTED]"); //TODO Read Delivery Person by ID
				break;
				
			case "update":
			case "u":
			case "4":
				System.out.println("Updating Delivery Person record... [NOT YET IMPLEMENTED]"); //TODO Update Delivery Person
				break;
				
			case "delete":
			case "d":
			case "5":
				System.out.println("Deleting Delivery Person record... [NOT YET IMPLEMENTED]"); //TODO Delete Delivery Person
				break;
				
			case "back":
			case "return":
			case "exit":
			case "close":
			case "0":
				managingEntity = false;
				System.out.println("Returning to Entity Management...");
				break;
				
			default:
				System.out.println(invalidOption);
				break;
			}
			
		}
	}
}
