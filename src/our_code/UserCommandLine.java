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
	
	// Extra methods for making the read methods look nicer and more like the SQL Command Line
	private static int[] calculateColumnWidths(ResultSet rs) throws SQLException {
		int[] columnWidths = new int[rs.getMetaData().getColumnCount()]; // Set the size of the array to the number of columns
		
		// Column index starts at 1, so we will need to offset the array by -1 to get the corresponding array index
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) { // Iterate through each column
			columnWidths[i - 1] = rs.getMetaData().getColumnName(i).length(); // Set initial widths to column name lengths
		}
		
		while (rs.next()) {	// Iterate through each result in the result set
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				int currentWidth = rs.getString(i).length();
				if (columnWidths[i - 1] < currentWidth) {
					columnWidths[i - 1] = currentWidth; // Set to new width if it's shorter
				}
			}
		}
		
		rs.beforeFirst(); // Reset the cursor on the result set for the read method
		
		return columnWidths;
	}
	
	private static String generateHorizontalBorder(int[] widths) {
		String border = "+-"; // Start of border
		for (int i = 0; i < widths.length; i++) { // Get the index of the int
			for (int j = 0; j < widths[i]; j++) { // Get the int stored at the above index
				border += "-";
			}
			if (i == widths.length - 1) { // Last index
				border += "-+";
			} else { // Everything in-between
				border += "-+-";
			}
		}
		return border;
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
				} catch (Exception e) {
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
	
	/** This version of the method asks the user for input then passes that input to the readCustomer(String) method */
	private static void readCustomer() throws SQLException {
		System.out.print("Enter customer ID to view or \"all\" to view all customers: ");
		String id = in.nextLine();
		readCustomer(id);
	}
	
	private static boolean readCustomer(String custId) throws SQLException {
		ResultSet rs = db.retrieveCustomerAccount(custId);
		
		int[] columnWidth = calculateColumnWidths(rs);
		String horizontalBorder = generateHorizontalBorder(columnWidth);
		
		// Print the table
		if (rs != null && rs.next()) {
			rs.beforeFirst(); // Since we're using rs.next() to check if the result set is empty or not, we need to reset its position here
			System.out.println("TABLE: " + rs.getMetaData().getTableName(1).toUpperCase());
			System.out.println(horizontalBorder);
			System.out.print("| ");
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.printf("%-" + columnWidth[i - 1] + "s | ",rs.getMetaData().getColumnName(i).toUpperCase());
			}
			System.out.println("\n" + horizontalBorder);

			while (rs.next()) {
				String id = rs.getString("customer_id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String phoneNumber = rs.getString("phone_number");
				String status = rs.getString("status");
				System.out.printf("| %-" + columnWidth[0] + "s ", id);
				System.out.printf("| %-" + columnWidth[1] + "s ", name);
				System.out.printf("| %-" + columnWidth[2] + "s ", address);
				System.out.printf("| %-" + columnWidth[3] + "s ", phoneNumber);
				System.out.printf("| %-" + columnWidth[4] + "s | ", status);
				System.out.println();
			}// end while
			System.out.println(horizontalBorder);
			return true; // Customer successfully displayed
		} else {
			System.out.print("Record(s) not found. ");
			return false; // No customer(s) to display
		}
	}
	
	private static void updateCustomer() throws Exception {
		System.out.print("Enter the ID of the customer you would like to update: ");
		String id = in.nextLine();
		
		if (id.equals("all")) {
			throw new Exception("Cannot update all customers at once!");
		}
		else if (readCustomer(id)) {
			System.out.println("You are about to update the above record. Enter new values where relevant, or leave blank to keep the old value.");
			
			ResultSet rs = db.retrieveCustomerAccount(id); // Retrieve the result set so values can be kept the same by leaving them blank
			rs.first(); // Set cursor to first (only) entry
			
			System.out.print("Enter new customer name: ");
			String name = in.nextLine();
			if (name.isEmpty()) {
				name = rs.getString("name");
			}
			System.out.print("Enter new customer address: ");
			String address = in.nextLine();
			if (address.isEmpty()) {
				address = rs.getString("address");
			}
			System.out.print("Enter new customer phone number: ");
			String phoneNumber = in.nextLine();
			if (phoneNumber.isEmpty()) {
				phoneNumber = rs.getString("phone_number");
			}
			System.out.print("Enter new customer status (Active/Paused): ");
			String status = in.nextLine();
			if (status.isEmpty()) {
				status = rs.getString("status");
			}
			
			Customer c = new Customer(id, name, address, phoneNumber, status);
			
			if (db.updateCustomerRecord(c)) {
				System.out.println("\nCustomer record updated. Customer is now:");
				readCustomer(id);
			} else {
				System.out.print("\nCustomer NOT updated. ");
			}
		}
	}
	
	private static void deleteCustomer() throws Exception {
		System.out.print("Enter the ID of the customer you would like to delete: ");
		String id = in.nextLine();
		
		if (id.equals("all")) {
			throw new Exception("Cannot delete all customers at once!");
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
				try {
					createPublication();
				}
				catch(Exception e) {
					System.err.println("\nCould not create Publication. Error: " + e.getMessage());
				}
				finally {
					waitForUserInput();
				}
				break;
				
			case "view all":
			case "va":
			case "2":
				try {
					readPublication("all");
				}
				catch(Exception e) {
					System.err.println("\nCould not view all Publications. Error: " + e.getMessage());
				}
				finally {
					waitForUserInput();
				}
				break;
				
			case "view":
			case "v":
			case "3":
				try {
					readPublication();
				}
				catch(Exception e) {
					System.err.println("\nCould not read Publication. Error: " + e.getMessage());
				}
				finally {
					waitForUserInput();
				}
				break;
				
			case "update":
			case "u":
			case "4":
				try {
					updatePublication();
				}
				catch(Exception e) {
					System.err.println("\nCould not update Publication. Error: " + e.getMessage());
				}
				finally {
					waitForUserInput();
				}
				break;
				
			case "delete":
			case "d":
			case "5":
				try {
					deletePublication();
				}
				catch(Exception e) {
					System.err.println("\nCould not delete Publication. Error: " + e.getMessage());
				}
				finally {
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
	
	private static void createPublication() throws PublicationExceptionHandler {
		System.out.println("----- CREATING NEW Publication -----");
		System.out.print("Enter Publication ID: ");
		String id = in.nextLine();
		System.out.print("Enter Publication name: ");
		String name = in.nextLine();
		System.out.print("Enter Publication Type: ");
		String type = in.nextLine();
		System.out.print("Enter Publication Frequency: ");
		String frequency = in.nextLine();
		System.out.print("Enter Publication Stock: ");
		int stock = in.nextInt();
		System.out.print("Enter Publication Cost: ");
		double cost = in.nextDouble();
		
		Publication p = new Publication(id, name, type, frequency, stock, cost);
		
		if (db.insertPublication(p)) {
			System.out.print("\nNew Publication saved to database. ");
		} else {
			System.out.print("\nPublication NOT saved to database. ");
		}
	}
	
	private static void readPublication() throws SQLException {
		System.out.print("Enter publication ID to view or \"all\" to view all publications: ");
		String id = in.nextLine();
		readPublication(id);
	}
	
	private static boolean readPublication(String pubId) throws SQLException {
		ResultSet rs = db.retrievePublication(pubId);
		
		int[] columnWidth = calculateColumnWidths(rs);
		String horizontalBorder = generateHorizontalBorder(columnWidth);
		
		// Print the table
		if (rs != null && rs.next()) {
			rs.beforeFirst(); // Since we're using rs.next() to check if the result set is empty or not, we need to reset its position here
			System.out.println("TABLE: " + rs.getMetaData().getTableName(1).toUpperCase());
			System.out.println(horizontalBorder);
			System.out.print("| ");
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.printf("%-" + columnWidth[i - 1] + "s | ",rs.getMetaData().getColumnName(i).toUpperCase());
			}
			System.out.println("\n" + horizontalBorder);

			while (rs.next()) {
				String id = rs.getString("publication_id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				String frequency = rs.getString("frequency");
				String stock = rs.getString("stock");
				String cost = rs.getString("cost");
				System.out.printf("| %-" + columnWidth[0] + "s ", id);
				System.out.printf("| %-" + columnWidth[1] + "s ", name);
				System.out.printf("| %-" + columnWidth[2] + "s ", type);
				System.out.printf("| %-" + columnWidth[3] + "s ", frequency);
				System.out.printf("| %-" + columnWidth[4] + "s ", stock);
				System.out.printf("| %-" + columnWidth[5] + "s | ", cost);
				System.out.println();
			}// end while
			System.out.println(horizontalBorder);
			return true; // publication successfully displayed
		} else {
			System.out.print("Record(s) not found. ");
			return false; // No publications(s) to display
		}
	}
	
	private static void updatePublication() throws Exception {
		System.out.print("Enter the ID of the publication you would like to update: ");
		String id = in.nextLine();
		
		if (id.equals("all")) {
			throw new Exception("Cannot update all publications at once!");
		}
		else if (readPublication(id)) {
			System.out.println("You are about to update the above record. Enter new values where relevant, or leave blank to keep the old value.");
			
			ResultSet rs = db.retrievePublication(id); // Retrieve the result set so values can be kept the same by leaving them blank
			rs.first(); // Set cursor to first (only) entry
			
			System.out.print("Enter new publication name: ");
			String name = in.nextLine();
			if (name.isEmpty()) {
				name = rs.getString("name");
			}
			System.out.print("Enter new publication type: ");
			String type = in.nextLine();
			if (type.isEmpty()) {
				type = rs.getString("type");
			}
			System.out.print("Enter new publication frequency: ");
			String frequency = in.nextLine();
			if (frequency.isEmpty()) {
				frequency = rs.getString("frequency");
			}
			System.out.print("Enter new publication Stock: ");
			int stock = in.nextInt();
			if (stock < 0) {
				stock = rs.getInt("stock");
			}
			System.out.print("Enter new publication cost: ");
			double cost = in.nextDouble();
			if (cost < 0.0) {
				cost = rs.getDouble("cost");
			}
			
			Publication p = new Publication(id, name, type, frequency, stock, cost);
			
			if (db.updatePublication(p)) {
				System.out.println("\nPublication record updated. Publication is now:");
				readPublication(id);
			} else {
				System.out.print("\nPublication NOT updated. ");
			}
		}
	}
	
	private static void deletePublication() throws Exception {
		System.out.print("Enter the ID of the publication you would like to delete: ");
		String id = in.nextLine();
		
		if (id.equals("all")) {
			throw new Exception("Cannot delete all publications at once!");
		}
		else if (readPublication(id)) {
			System.out.println("Warning: You are about to permanently delete the above record! This can not be undone.");
			System.out.print("Type CONFIRM if you are sure you want to do this. ");
			if (in.nextLine().toLowerCase().equals("confirm")) {
				db.deletePublicationById(id);
				System.out.print("Publication " + id + " deleted. ");
			} else {
				System.out.print("Publication " + id + " not deleted. ");
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
				try {
					createOrder();
				} catch (Exception e) {
					System.err.println("\nCould not create order. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
				break;
				
			case "view all":
			case "va":
			case "2":
				try {
					readOrder("all");
				} catch (Exception e) {
					System.err.println("\nCould not read order records. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
				break;
				
			case "view":
			case "v":
			case "3":
				
				try {
					readOrder();
				} catch (Exception e) {
					System.err.println("\nCould not read order records. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
				break;
				
			case "update":
			case "u":
			case "4":
				try {
					updateOrder();
				} catch (Exception e) {
					System.err.println("\nCould not update order records. Error: " + e.getMessage());
				} finally {
					waitForUserInput();
				}
				break;
				
			case "delete":
			case "d":
			case "5":
				try {
					deleteOrder();
				} catch (Exception e) {
					System.err.println("\nCould not delete order records. Error: " + e.getMessage());
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
	
	private static void createOrder() throws Exception {
		System.out.println("----- CREATING NEW ORDER -----");
		System.out.print("Enter order ID: ");
		String orderID = in.nextLine();
		System.out.print("Enter delivery Area: ");
		String deliveryArea = in.nextLine();
		System.out.print("Enter customer id: ");
		String customerID = in.nextLine();
		System.out.print("Enter publication id: ");
		String publicationID = in.nextLine();
		System.out.print("Enter week day: ");
		String weekDay = in.nextLine();
		
		Order o = new Order(orderID, publicationID, weekDay, customerID, deliveryArea);
		
		if (db.insertOrderDetailsAccount(o)) {
			System.out.print("\nNew order saved to database. ");
		} else {
			System.out.print("\nOrder NOT saved to database. ");
		}
	}
	
	/** This version of the method asks the user for input then passes that input to the readCustomer(String) method */
	private static void readOrder() throws SQLException {
		System.out.print("Enter Order ID to view or \"all\" to view all orders: ");
		String id = in.nextLine();
		readOrder(id);
	}
	
	private static boolean readOrder(String orderId) throws SQLException {
		ResultSet rs = db.retrieveOrderAccount(orderId);
		
		int[] columnWidth = calculateColumnWidths(rs);
		String horizontalBorder = generateHorizontalBorder(columnWidth);
		
		// Print the table
		if (rs != null && rs.next()) {
			rs.beforeFirst(); // Since we're using rs.next() to check if the result set is empty or not, we need to reset its position here
			System.out.println("TABLE: " + rs.getMetaData().getTableName(1).toUpperCase());
			System.out.println(horizontalBorder);
			System.out.print("| ");
			for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
				System.out.printf("%-" + columnWidth[i - 1] + "s | ",rs.getMetaData().getColumnName(i).toUpperCase());
			}
			System.out.println("\n" + horizontalBorder);

			while (rs.next()) {
				String orderID = rs.getString("order_id");
				String deliveryArea = rs.getString("delivery_area");
				String customerID = rs.getString("customer_id");
				String publicationID = rs.getString("publication_id");
				String weekDay = rs.getString("week_day");
				System.out.printf("| %-" + columnWidth[0] + "s ", orderID);
				System.out.printf("| %-" + columnWidth[1] + "s ", deliveryArea);
				System.out.printf("| %-" + columnWidth[2] + "s ", customerID);
				System.out.printf("| %-" + columnWidth[3] + "s ", publicationID);
				System.out.printf("| %-" + columnWidth[4] + "s | ", weekDay);
				System.out.println();
			}// end while
			System.out.println(horizontalBorder);
			return true; // Order successfully displayed
		} else {
			System.out.print("Record(s) not found. ");
			return false; // No order(s) to display
		}
	}
	
	private static void updateOrder() throws Exception {
		System.out.print("Enter the ID of the order you would like to update: ");
		String orderID = in.nextLine();
		
		if (orderID.equals("all")) {
			throw new Exception("Cannot update all orders at once!");
		}
		else if (readOrder(orderID)) {
			System.out.println("You are about to update the above record. Enter new values where relevant, or leave blank to keep the old value.");
			
			ResultSet rs = db.retrieveOrderAccount(orderID); // Retrieve the result set so values can be kept the same by leaving them blank
			rs.first(); // Set cursor to first (only) entry
			
			System.out.print("Enter new Delivery Area ID: ");
			String deliveryArea = in.nextLine();
			if (deliveryArea.isEmpty()) {
				deliveryArea = rs.getString("delivery_area");
			}
			System.out.print("Enter new Customer id: ");
			String customerID = in.nextLine();
			if (customerID.isEmpty()) {
				customerID = rs.getString("customer_id");
			}
			System.out.print("Enter new Publication ID: ");
			String publicationID = in.nextLine();
			if (publicationID.isEmpty()) {
				publicationID = rs.getString("publication_id");
			}
			System.out.print("Enter new Week Day: ");
			String weekDay = in.nextLine();
			if (weekDay.isEmpty()) {
				weekDay = rs.getString("week_day");
			}
			
			Order o = new Order(orderID, publicationID, weekDay, customerID, deliveryArea);
			
			if (db.updateOrderRecord(o)) {
				System.out.println("\nOrder record updated. Order is now:");
				readOrder(orderID);
			} else {
				System.out.print("\nCustomer NOT updated. ");
			}
		}
	}
	
	private static void deleteOrder() throws Exception {
		System.out.print("Enter the ID of the Order you would like to delete: ");
		String orderID = in.nextLine();
		
		if (orderID.equals("all")) {
			throw new Exception("Cannot delete all Order at once!");
		}
		else if (readOrder(orderID)) {
			System.out.println("Warning: You are about to permanently delete the above record! This can not be undone.");
			System.out.print("Type CONFIRM if you are sure you want to do this. ");
			if (in.nextLine().toLowerCase().equals("confirm")) {
				db.deleteOrderById(orderID);
				System.out.print("Order " + orderID + " deleted. ");
			} else {
				System.out.print("Order " + orderID + " not deleted. ");
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
	            try {
	                createInvoice();
	            } catch (Exception e) {
	                System.err.println("\nCould not create invoice. Error: " + e.getMessage());
	            } finally {
	                waitForUserInput();
	            }
	            break;

	        case "view all":
	        case "va":
	        case "2":
	            try {
	                readInvoice("all");
	            } catch (Exception e) {
	                System.err.println("\nCould not view invoice records. Error: " + e.getMessage());
	            } finally {
	                waitForUserInput();
	            }
	            break;

	        case "view":
	        case "v":
	        case "3":
	            try {
	                readInvoice();
	            } catch (Exception e) {
	                System.err.println("\nCould not view invoice record. Error: " + e.getMessage());
	            } finally {
	                waitForUserInput();
	            }
	            break;

	        case "update":
	        case "u":
	        case "4":
	            try {
	                updateInvoice();
	            } catch (Exception e) {
	                System.err.println("\nCould not update invoice record. Error: " + e.getMessage());
	            } finally {
	                waitForUserInput();
	            }
	            break;

	        case "delete":
	        case "d":
	        case "5":
	            try {
	                deleteInvoice();
	            } catch (Exception e) {
	                System.err.println("\nCould not delete invoice record. Error: " + e.getMessage());
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

	private static void createInvoice() throws InvoiceExceptionHandler {
	    System.out.println("----- CREATING NEW INVOICE -----");
	    System.out.print("Enter customer ID for this invoice: ");
	    String customerId = in.nextLine();
	    System.out.print("Enter invoice total cost: ");
	    double totalCost = Double.parseDouble(in.nextLine());

	    try {
	        Invoice invoice = new Invoice(customerId, totalCost);
	
	        if (db.insertCustomerDetailsAccount(invoice)) {
	            System.out.println("New invoice created and saved to database.");
	        } else {
	            System.out.println("Failed to save the new invoice.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.err.println("Error creating invoice: " + e.getMessage());
	    }
	}

	private static void readInvoice() throws SQLException {
	    System.out.print("Enter invoice ID to view or \"all\" to view all invoices: ");
	    String id = in.nextLine();
	    readInvoice(id);
	}

	private static boolean readInvoice(String invoiceId) throws SQLException {
	    ResultSet rs = db.retrieveInvoiceAccount(invoiceId);
	    rs.first();
	    
	    int[] columnWidth = calculateColumnWidths(rs);
	    String horizontalBorder = generateHorizontalBorder(columnWidth);

	    if (rs != null && rs.next()) {
	        rs.beforeFirst(); 
	        System.out.println("TABLE: " + rs.getMetaData().getTableName(1).toUpperCase());
	        System.out.println(horizontalBorder);
	        System.out.print("| ");
	        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
	            System.out.printf("%-" + columnWidth[i - 1] + "s | ", rs.getMetaData().getColumnName(i).toUpperCase());
	        }
	        System.out.println("\n" + horizontalBorder);

	        while (rs.next()) {
	            String id = rs.getString("invoice_id");
	            String customerId = rs.getString("customer_id");
	            double amount = rs.getDouble("total_cost");
	            boolean reminder = rs.getBoolean("reminder");
	            String status = rs.getString("status");

	            System.out.printf("| %-" + columnWidth[0] + "s ", id);
	            System.out.printf("| %-" + columnWidth[1] + "s ", customerId);
	            System.out.printf("| %-" + columnWidth[2] + ".2f ", amount);
	            System.out.printf("| %-" + columnWidth[3] + "s ", reminder ? "Yes" : "No");
	            System.out.printf("| %-" + columnWidth[4] + "s |", status);
	            
	            System.out.println();
	        } 
	        System.out.println(horizontalBorder);
	        return true;
	    } else {
	        System.out.print("Record(s) not found. ");
	        return false; 
	    }
	}

	private static void updateInvoice() throws Exception {
	    System.out.print("Enter the ID of the invoice you would like to update: ");
	    String id = in.nextLine();

	    if (id.equals("all")) {
	        throw new Exception("Cannot update all invoices at once!");
	    } else if (readInvoice(id)) {
	        System.out.println("You are about to update the above record. Enter new values where relevant, or leave blank to keep the old value.");

	        ResultSet rs = db.retrieveInvoiceAccount(id); 
	        rs.first();

	        System.out.print("Enter new invoice total cost: ");
	        double totalCost = Double.parseDouble(in.nextLine());
	        if (totalCost == 0) {
	            totalCost = rs.getDouble("total_cost");
	            
	        }
	        System.out.print("Enter new invoice status (Paid/Unpaid): ");
	        String status = in.nextLine();
	        if (status.isEmpty()) {
	            status = rs.getString("status");
	        }

	        Invoice invoice = new Invoice(rs.getString("customer_id"), totalCost);
	        invoice.setStatus(status);
	        int invoiceID = Integer.parseInt(id);
	        invoice.setInvoiceID(invoiceID);
	        
	     

	        if (db.updateInvoiceRecord(invoice)) {
	            System.out.println("\nInvoice record updated.");
	            readInvoice(id);
	        } else {
	            System.out.println("\nInvoice NOT updated.");
	        }
	    }
	}

	private static void deleteInvoice() throws Exception {
	    System.out.print("Enter the ID of the invoice you would like to delete: ");
	    String id = in.nextLine();

	    if (id.equals("all")) {
	        throw new Exception("Cannot delete all invoices at once!");
	    } else if (readInvoice(id)) {
	        System.out.println("Warning: You are about to permanently delete the above record! This cannot be undone.");
	        System.out.print("Type CONFIRM if you are sure you want to do this. ");
	        if (in.nextLine().toLowerCase().equals("confirm")) {
	            db.deleteInvoiceById(id);
	            System.out.println("Invoice " + id + " deleted.");
	        } else {
	            System.out.println("Invoice " + id + " not deleted.");
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
