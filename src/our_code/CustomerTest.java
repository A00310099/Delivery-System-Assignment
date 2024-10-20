package our_code;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {
	Customer customer = new Customer();
	
	@Test
	public void testValidName () throws CustomerExceptionHandler {
		assertTrue(customer.validateName("abcde")); // VEC: 4 characters
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
		assertTrue(customer.validateCustomerID(1)); 
	}	
	
	@Test
	void testInvalidCustomerID() throws CustomerExceptionHandler {
		assertThrows(CustomerExceptionHandler .class, () -> {
			customer.validateCustomerID(0);
		});
	}
	
	@Test
	public void testInvalidPhoneNumber() throws CustomerExceptionHandler {
	     assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validatePhoneNumber("089334456"); // IEC < 10
	        });
	        assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validatePhoneNumber("08933445678"); // IEC: > 10 characters
	        }); 
	}
	@Test
	public void testValidPhoneNumber() throws CustomerExceptionHandler {
		assertTrue(customer.validatePhoneNumber("0893344567")); 
	}
	@Test
	public void testValidAddress() throws CustomerExceptionHandler {
		assertTrue(customer.validateAddress("13 Monksland ")); 
	}	
	
	@Test
	public void testInvalidAddress() throws CustomerExceptionHandler {
	     assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validateAddress("abc"); // IEC: 3
	        });
	        assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validateAddress("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop"); // IEC: > 65 characters
	        }); 
	}
	@Test
	public void testValidStatus() throws CustomerExceptionHandler	{
		assertTrue(customer.validateStatus("Active"));
		assertTrue(customer.validateStatus("Paused"));
	}
	@Test
	public void testInvalidStatus() throws CustomerExceptionHandler	{
		  assertThrows(CustomerExceptionHandler.class, () -> {
	            customer.validateStatus("What???"); // IEC: > 10 characters
	        }); 
	}

}
	
	
