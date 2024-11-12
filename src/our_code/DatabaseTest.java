package our_code;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

class DatabaseTest {

	
	
	// ========== CUSTOMER TESTS ==========
	// ----- CREATE -----
	/**
	 * Test no. 1
	 * Test objective: To test valid customer insertion into database
	 * Input: valid customer entity
	 * Expected output: true (customer inserted into database)
	 */
	@Test
	void testCreateValidCustomer() throws Exception {
		Database db = new Database();
		Customer c = new Customer("test", "test", "test", "1234567890", "active"); // valid customer
		assertTrue(db.insertCustomerDetailsAccount(c));
		db.deleteCustomerById("test"); // remove the customer we just created from the database
	}
	/**
	 * Test no. 2
	 * Test objective: To test invalid customer insertion into database
	 * Input: invalid customer entity
	 * Expected output: Exception (customer not inserted into database)
	 */
	@Test
	void testCreateInvalidCustomer() throws Exception {
		Database db = new Database();
		assertThrows(Exception.class, () -> {
			Customer c = new Customer("in", "va", "lid", "cus", "tomer");
			db.insertCustomerDetailsAccount(c);
		});
	}

	// ----- READ -----
	/**
	 * Test no. 3
	 * Test objective: To test valid customer read from database
	 * Input: Read customer id "test"
	 * Expected output: Non-empty result set
	 */
	@Test
	void testValidReadCustomer() throws Exception {
		Database db = new Database();
		Customer c = new Customer("test", "test", "test", "1234567890", "active");
		db.insertCustomerDetailsAccount(c); // Insert a customer so we can read it back
		ResultSet rs = db.retrieveCustomerAccount("test");
		assertTrue(rs.next()); // result set is not empty
		db.deleteCustomerById("test"); // clean up
	}
	/**
	 * Test no. 4
	 * Test objective: To test valid read all customers from database
	 * Input: "all"
	 * Expected output: Non-empty result set with multiple entries
	 */
	@Test
	void testValidReadAllCustomers() throws Exception {
		Database db = new Database();
		// Create a few customers to ensure database isn't empty
		Customer c1 = new Customer("test", "test", "test", "1234567890", "active");
		Customer c2 = new Customer("test2", "test", "test", "1234567890", "active");
		Customer c3 = new Customer("test3", "test", "test", "1234567890", "active");
		db.insertCustomerDetailsAccount(c1);
		db.insertCustomerDetailsAccount(c2);
		db.insertCustomerDetailsAccount(c3);
		
		ResultSet rs = db.retrieveCustomerAccount("all");
		int count = 0;
		while (rs.next()) count++;
		assertTrue(count >= 3); // Result set should have at least 3 results as we just inserted 3 customers
		
		// Clean up
		db.deleteCustomerById("test");
		db.deleteCustomerById("test2");
		db.deleteCustomerById("test3");
	}
	/**
	 * Test no. 5
	 * Test objective: To test invalid customer read from database
	 * Input: "" (empty string)
	 * Expected output: False (empty result set)
	 */
	@Test
	void testInvalidReadCustomer() throws Exception {
		Database db = new Database();
		ResultSet rs = db.retrieveCustomerAccount(""); // empty string is not a valid id so this customer should not exist
		assertFalse(rs.next());
	}

	// ----- UPDATE -----
	/**
	 * Test no. 6
	 * Test objective: To test valid update customer in database
	 * Input: Update customer ID "test" with new details
	 * Expected output: True (customer record updated)
	 */
	@Test
	void testValidUpdateCustomer() throws Exception {
		Database db = new Database();
		Customer beforeUpdate = new Customer("test", "test", "test", "1234567890", "active"); // Create a customer we can update
		Customer afterUpdate = new Customer("test", "test2", "test2", "0987654321", "paused"); // Updated version of the customer with same ID
		db.insertCustomerDetailsAccount(beforeUpdate);
		assertTrue(db.updateCustomerRecord(afterUpdate));
		db.deleteCustomerById("test"); // clean up
	}
	/**
	 * Test no. 7
	 * Test objective:
	 * Input:
	 * Expected output:
	 */
//	@Test
//	void testInvalidUpdateCustomer() throws Exception {
//		Database db = new Database();
//		db.deleteCustomerById("test"); // Ensure that customer with ID "test" doesn't exist first
//		Customer c = new Customer("test", "test2", "test2", "0987654321", "paused"); // Cannot update a customer if it doesn't exist
//		assertFalse(db.updateCustomerRecord(c));
//	}
	
	// ----- DELETE -----
	/**
	 * Test no. 8
	 * Test objective: To test valid customer deletion from database
	 * Input: Customer ID "test"
	 * Expected output: True (customer with ID "test" deleted)
	 */
	@Test
	void testValidDeleteCustomer() throws Exception {
		Database db = new Database();
		Customer c = new Customer("test", "test", "test", "1234567890", "active"); // Create a customer we can delete
		db.insertCustomerDetailsAccount(c);
		assertTrue(db.deleteCustomerById("test"));
	}
	/**
	 * Test no. 9
	 * Test objective:
	 * Input:
	 * Expected output:
	 */
	@Test
	void testInvalidDeleteCustomer() throws Exception {
		fail("Not yet implemented");
	}
}
