package our_code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestOrder {

	Order order = new Order();
	
	// Tests for valid week days
	@Test
	void testValidWeekdayMonday() throws OrderException {
		assertTrue(order.validateWeekDay("monday"));
	}
	@Test
	void testValidWeekdayTuesday() throws OrderException {
		assertTrue(order.validateWeekDay("Tuesday"));
	}
	@Test
	void testValidWeekdayWednesday() throws OrderException {
		assertTrue(order.validateWeekDay("WEDnesday"));
	}
	@Test
	void testValidWeekdayThursday() throws OrderException {
		assertTrue(order.validateWeekDay("THURSDAY"));
	}
	@Test
	void testValidWeekdayFriday() throws OrderException {
		assertTrue(order.validateWeekDay("friDAY"));
	}
	@Test
	void testValidWeekdaySaturday() throws OrderException {
		assertTrue(order.validateWeekDay("SaTuRdAy"));
	}
	@Test
	void testValidWeekdaySunday() throws OrderException {
		assertTrue(order.validateWeekDay("sUnDaY"));
	}
	
	// Tests for invalid week days
	@Test
	void testInvalidWeekday() {
		assertThrows(OrderException.class, () -> {
			order.validateWeekDay("testingday");
		});
	}

	
	// Tests for valid publication ID
	@Test
	void testValidPublicationID() throws OrderException {
		assertTrue(order.validatePublicationID(1));
	}
	
	// Tests for invalid publication ID
	@Test
	void testInvalidPublicationID() throws OrderException {
		assertThrows(OrderException.class, () -> {
			order.validatePublicationID(-1);
		});
	}
	
	// Tests for valid customer ID
	@Test
	void testValidCustomerID() throws OrderException {
		assertTrue(order.validateCustomerID(2));
	}
	
	// Tests for invalid customer ID
	@Test
	void testInvalidCustomerID() throws OrderException {
		assertThrows(OrderException.class, () -> {
			order.validateCustomerID(0);
		});
	}
}
