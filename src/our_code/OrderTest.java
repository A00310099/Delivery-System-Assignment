package our_code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

	Order order = new Order();
	
	// Tests for valid week days
	@Test
	void testValidWeekdayMonday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("monday"));
	}
	@Test
	void testValidWeekdayTuesday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("Tuesday"));
	}
	@Test
	void testValidWeekdayWednesday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("WEDnesday"));
	}
	@Test
	void testValidWeekdayThursday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("THURSDAY"));
	}
	@Test
	void testValidWeekdayFriday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("friDAY"));
	}
	@Test
	void testValidWeekdaySaturday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("SaTuRdAy"));
	}
	@Test
	void testValidWeekdaySunday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("sUnDaY"));
	}
	
	// Tests for invalid week days
	@Test
	void testInvalidWeekday() {
		assertThrows(OrderExceptionHandler.class, () -> {
			order.validateWeekDay("testingday");
		});
	}

	
	// Tests for valid publication ID
	@Test
	void testValidPublicationID() throws OrderExceptionHandler {
		assertTrue(order.validatePublicationID("P1111"));
	}
	
	// Tests for invalid publication ID
	@Test
	void testInvalidPublicationID() throws OrderExceptionHandler {
		assertThrows(OrderExceptionHandler.class, () -> {
			order.validatePublicationID("");
		});
	}
	
	// Tests for valid customer ID
	@Test
	void testValidCustomerID() throws OrderExceptionHandler {
		assertTrue(order.validateCustomerID("A6666"));
	}
	
	// Tests for invalid customer ID
	@Test
	void testInvalidCustomerID() throws OrderExceptionHandler {
		assertThrows(OrderExceptionHandler.class, () -> {
			order.validateCustomerID("");
		});
	}
}
