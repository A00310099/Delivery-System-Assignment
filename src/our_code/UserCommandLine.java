package our_code;

import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCommandLine {
	
	// Reusable strings
	final static String separator = "==================================================";
	final static String invalidOption = "Invalid function selected! Please enter the number displayed next to your chosen option.";
	
	// App functionality - Keeping these static as they're used across different methods
	static Database db = null; // Initialized in main
	static Scanner in = new Scanner(System.in);
	static String functionNumber = "-99";
	
	static void waitForUserInput() {
		System.out.println("Press enter to return.");
		in.nextLine();
	}
	
	public static void main(String[] args) {
		try {
			db = new Database();
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
			System.out.println("Encountered an error:" + e.getMessage() + "\nThe application will now close.");
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
	
	// ==================== CUSTOMER METHODS ====================
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
				try {
					createCustomer();
				} catch (CustomerExceptionHandler e) {
					System.err.println("\nCould not create customer. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
				break;
				
			case "view all":
			case "va":
			case "2":
				try {
					readCustomer("all");
				} catch (Exception e) {
					System.err.println("\nCould not view customer records. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
				break;
				
			case "view":
			case "v":
			case "3":
				try {
					readCustomer();
				} catch (Exception e) {
					System.err.println("\nCould not view customer record. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
				break;
			
			case "update":
			case "u":
			case "4":
				try {
					updateCustomer();
				} catch (Exception e) {
					System.err.println("\nCould not update customer record. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
				break;
				
			case "delete":
			case "d":
			case "5":
				try {
					deleteCustomer();
				} catch (Exception e) {
					System.err.println("\nCould not delete customer record. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
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
	private static void createCustomer() throws CustomerExceptionHandler {
		System.out.println("----- CREATING NEW CUSTOMER -----");
		System.out.print("Enter customer ID: ");
		String id = in.nextLine();
		System.out.print("Enter customer name: ");
		String name = in.nextLine();
		System.out.print("Enter customer address: ");
		String address = in.nextLine();
		System.out.print("Enter customer phone number: ");
		String phoneNumber = in.nextLine();
		System.out.print("Enter customer status (Active/Paused): ");
		String status = in.nextLine();
		
		Customer c = new Customer(id, name, address, phoneNumber, status);
		
		if (db.insertCustomerDetailsAccount(c)) {
			System.out.print("\nNew customer saved to database. ");
		} else {
			System.out.print("\nCustomer NOT saved to database. ");
		}
	}
	/** This version of the method asks the user for input then passes that input to the readCustomer(String custId) method */
	private static void readCustomer() throws SQLException {
		System.out.print("Enter customer ID to view or \"all\" to view all customers: ");
		String id = in.nextLine();
		readCustomer(id);
	}
	private static boolean readCustomer(String custId) throws SQLException {
		ResultSet rs = db.retrieveCustomerAccount(custId);
		
		// Print the table
		if (rs != null && rs.next()) {
			rs.beforeFirst(); // Since we're using rs.next() to check if the result set is empty or not, we need to reset its position here
			System.out.println("TABLE: " + rs.getMetaData().getTableName(1).toUpperCase());
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
			System.out.print("| ");
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.printf("%-30s | ",rs.getMetaData().getColumnName(i).toUpperCase());
			}
			
			System.out.println();
			while (rs.next()) {
				String id = rs.getString("customer_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phone_number");
				String status = rs.getString("status");
				System.out.printf("| %-30s | ", id);
				System.out.printf("%-30s | ", name);
				System.out.printf("%-30s | ", address);
				System.out.printf("%-30s | ", phoneNumber);
				System.out.printf("%-30s | ", status);
				System.out.println();
			}// end while
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
			return true; // Customer successfully displayed
		} else {
			System.out.print("Record(s) not found. ");
			return false; // No customer(s) to display
		}
	}
	private static void updateCustomer() {
		// TODO update customers method
	}
	private static void deleteCustomer() throws Exception {
		System.out.print("Enter the ID of the customer you would like to delete: ");
		String id = in.nextLine();
		
		if (id.equals("all")) {
			throw new Exception("Cannot delete all customers!");
		}
		else if (readCustomer(id)) {
			System.out.println("Warning: You are about to permanently delete the above record! This can not be undone.");
			System.out.print("Type CONFIRM if you are sure you want to do this. ");
			if (in.nextLine().toLowerCase().equals("confirm")) {
				db.deleteCustomerById(id);
				System.out.print("Customer " + id + " deleted. ");
			} else {
				System.out.print("Customer " + id + " not deleted. ");
			}
		}
	}
	
	// ==================== PUBLICATION METHODS ====================
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
	
	// ==================== ORDER METHODS ====================
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
	
	// ==================== INVOICE METHODS ====================
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
	
	// ==================== DELIVERY DOCKET METHODS ====================
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
	
	// ==================== DELIVERY AREA METHODS ====================
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
	
	// ==================== DELIVERY PERSON METHODS ====================
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
