package our_code;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class DeliveryDocketTest {
	DeliveryDocket docket = new DeliveryDocket();
	
	@Test
	public void testValidDocketId () throws DeliveryDocketExceptionHandler {
		assertTrue(docket.validateDocketID(1));
	}
	@Test
	public void testInvalidDocketID () throws DeliveryDocketExceptionHandler{
		assertThrows(DeliveryDocketExceptionHandler .class, () -> {
			docket.validateDocketID(0);
		});
	}
	
	
//	@Test
//	public void testValidTime() throws DeliveryDocketExceptionHandler{
//		assertTrue(docket.validateTime("09:10"));
//	       
//	}
//	@Test
//	public void testInvalidTime() throws DeliveryDocketExceptionHandler{
//		 assertThrows(DeliveryDocketExceptionHandler.class, () -> {
//	            docket.validateTime("25:000"); // IEC: 3
//	        });
//	}
	@Test
	public void testValidDeliveryArea() throws DeliveryDocketExceptionHandler{
		assertTrue(docket.validateDeliveryArea("Monksland Street")); 
	}
	@Test
	public void testInvalidDeliveryArea() throws DeliveryDocketExceptionHandler{
		assertThrows(DeliveryDocketExceptionHandler.class, () -> {
            docket.validateDeliveryArea("abc"); // IEC: 3
        });
        assertThrows(DeliveryDocketExceptionHandler.class, () -> {
            docket.validateDeliveryArea("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnop"); // IEC: > 65 characters
        }); 
	}
	
	@Test
	public void testValidOrderStatus() throws DeliveryDocketExceptionHandler{
		assertTrue(docket.validateOrderStatus("Yes"));
		assertTrue(docket.validateOrderStatus("No"));
	}
	@Test
	public void testInvalidOrderStatus () throws DeliveryDocketExceptionHandler{
		  assertThrows(DeliveryDocketExceptionHandler.class, () -> {
	            docket.validateOrderStatus("What???"); // IEC: > 10 characters
	        }); 
	}


}
