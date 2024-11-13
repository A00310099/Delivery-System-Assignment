package our_code;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {
	Customer customer = new Customer();
	
	/**
	 * Test no. 1
	 * Test objective: To test name is 4 or more letters
	 * Input: "abcde"
	 * Expected output: true (abcde is a valid name)
	 */
	

	@Test
	public void testValidName () throws CustomerExceptionHandler {
		assertTrue(customer.validateName("abcde")); // VEC: 4 characters
		/**
		 * Test no. 2
		 * Test objective: To test "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl" as a valid name
		 * Input: "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl"
		 * Expected output: true (abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl is a valid name)
		 */
        assertTrue(customer.validateName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl")); // VEC: 64 characters
    }

	/**
	 * Test no. 3
	 * Test objective: To test name is 3 letters or less is invalid
	 * Input: "abc"
	 * Expected output: false (abc is a invalid name)
	 */
	@Test
	public void testInvalidName () throws CustomerExceptionHandler {
        assertThrows(CustomerExceptionHandler.class, () -> {
            customer.validateName("abc"); // IEC: 3
        });
    	/**
    	 * Test no. 4
    	 * Test objective: To test name is 65 or more letters is invalid
    	 * Input: "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop"
    	 * Expected output: false (abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop is a invalid name)
    	 */
        assertThrows(CustomerExceptionHandler.class, () -> {
            customer.validateName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop"); // IEC: > 65 characters
        });
    }
	
	/**
	 * Test no. 5
	 * Test objective: To test "1" as a valid customer
	 * Input: "1"
	 * Expected output: true (1 is a valid customer id)
	 */
	@Test
	public void testValidCustomerID() throws CustomerExceptionHandler {
		assertTrue(customer.validateCustomerID("1")); 
	}	
	/**
	 * Test no. 6
	 * Test objective: To test " " as a valid customer
	 * Input: " "
	 * Expected output: true ( is a invalid customer id)
	 */
	@Test
	void testInvalidCustomerID() throws CustomerExceptionHandler {
		assertThrows(CustomerExceptionHandler .class, () -> {
			customer.validateCustomerID("");
		});
	}
	/**
	 * Test no. 7
	 * Test objective: To test "089334456" as a invalid phone number < 10 digits
	 * Input: "089334456"
	 * Expected output: false (089334456 is a invalid phone number)
	 */
	@Test
	public void testInvalidPhoneNumber() throws CustomerExceptionHandler {
	     assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validatePhoneNumber("089334456"); // IEC < 10
	        });
	 /**
	  * Test no. 8
	  * Test objective: To test "08933445678" as a invalid phone number > 10 digits
	  * Input: "08933445678"
	  * Expected output: false (08933445678 is a invalid phone number)
	  */
	        assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validatePhoneNumber("08933445678"); // IEC: > 10 characters
	        }); 
	}
	/**
	 * Test no. 9
	 * Test objective: To test "0893344567" as a valid phone number
	 * Input: "0893344567"
	 * Expected output: true (0893344567 is a valid phone number)
	 */
	@Test
	public void testValidPhoneNumber() throws CustomerExceptionHandler {
		assertTrue(customer.validatePhoneNumber("0893344567")); 
		
		/**
		 * Test no. 10
		 * Test objective: To test "13 Monksland" as a valid address
		 * Input: "13 Monksland"
		 * Expected output: true (13 Monksland is a valid address)
		 */
	}
	@Test
	public void testValidAddress() throws CustomerExceptionHandler {
		assertTrue(customer.validateAddress("13 Monksland ")); 
	}	
	/**
	 * Test no. 11
	 * Test objective: To test "abc" as a invalid address < 4 characters
	 * Input: "abc"
	 * Expected output: false (abc is a invalid address)
	 */
	@Test
	public void testInvalidAddress() throws CustomerExceptionHandler {
	     assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validateAddress("abc"); // IEC: 3
	        });
	 	/**
	 	 * Test no. 12
	 	 * Test objective: To test "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop" as a invalid address > 64 characters 
	 	 * Input: "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop"
	 	 * Expected output: false (abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop is a invalid address)
	 	 */
	        assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validateAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop"); // IEC: > 65 characters
	        }); 
	}
	/**
 	 * Test no. 13
 	 * Test objective: To test "Active" as a valid status
 	 * Input: "Active"
 	 * Expected output: True (Active is a valid address)
 	 */
	@Test
	public void testValidStatus() throws CustomerExceptionHandler	{
		assertTrue(customer.validateStatus("Active"));
		
		/**
	 	 * Test no. 14
	 	 * Test objective: To test "Paused" as a valid status
	 	 * Input: "Paused"
	 	 * Expected output: True (Active is a valid address)
	 	 */
		assertTrue(customer.validateStatus("Paused"));
	}
	/**
 	 * Test no. 15
 	 * Test objective: To test "What???" as a invalid status
 	 * Input: "What???"
 	 * Expected output: false (What??? is a invalid status)
 	 */
	@Test
	public void testInvalidStatus() throws CustomerExceptionHandler	{
		  assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validateStatus("What???"); // IEC: > 10 characters
	        }); 
	}

}
	
	
