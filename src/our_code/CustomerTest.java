package our_code;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {
	Customer customer = new Customer();
	
	@Test
	public void testValidName () throws CustomerExceptionHandler {
		assertTrue(customer.validateName("abcdef")); // VEC: 4 characters
        assertTrue(customer.validateName("abcdefghijklmno")); // VEC: 64 characters
    }

	@Test
	public void testInvalidName () throws CustomerExceptionHandler {
		assertTrue(customer.validateName("abcdef")); // VEC: 3 characters
        assertTrue(customer.validateName("abcdefghijklmno")); // VEC: 65 characters
    }

	@Test
	public void testValidCustomerID() throws CustomerExceptionHandler {
		assertTrue(customer.validateCustomerID(001)); 
	}	
	
	@Test
//	public void testInvalidCustomerID() throws CustomerExceptionHandler {
//		assertTrue(customer.validateCustomerID(35353567)); 
//	}
	
	public void testValidPhoneNumber() throws CustomerExceptionHandler {
		assertTrue(customer.validatePhoneNumber("0893344567")); 
	}	
	
	@Test
	public void testInvalidPhoneNumber() throws CustomerExceptionHandler {
		assertTrue(customer.validatePhoneNumber(" 0s97x9778-")); 
	}
	
	public void testValidAddress() throws CustomerExceptionHandler {
		assertTrue(customer.validateAddress("13 Monksland ")); 
	}	
	
	@Test
	public void testInvalidAddress() throws CustomerExceptionHandler {
		assertTrue(customer.validateAddress("13 ")); 
	}
	
	
}
	
	
