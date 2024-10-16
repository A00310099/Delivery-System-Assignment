package our_code;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {
	Customer customer = new Customer();
	
	@Test
	public void testValidName () throws CustomerExceptionHandler {
		assertTrue(customer.validateName("abcd")); // VEC: 4 characters
        assertTrue(customer.validateName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl")); // VEC: 64 characters
    }

	@Test
	public void testInvalidName () throws CustomerExceptionHandler {
        assertThrows(CustomerExceptionHandler.class, () -> {
            customer.validateName("abc"); // IEC: 3
        });
        assertThrows(CustomerExceptionHandler.class, () -> {
            customer.validateName("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop"); // IEC: > 65 characters
        });
    }

	@Test
	public void testValidCustomerID() throws CustomerExceptionHandler {
		assertTrue(customer.validateCustomerID(001)); 
	}	
	
	@Test
	public void testInvalidCustomerID() throws CustomerExceptionHandler {
		assertTrue(customer.validateCustomerID(35353567)); 
	}
	
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
	@Test
	public void testValidStatus() throws CustomerExceptionHandler	{
		assertTrue(customer.validateStatus("Yes"));
		assertTrue(customer.validateStatus("No"));
	}
	@Test
	public void testInvalidStatus() throws CustomerExceptionHandler	{
		assertTrue(customer.validateStatus("What???"));	
	}

}
	
	
