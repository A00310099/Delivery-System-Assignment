package our_code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

	Order order = new Order();
	
	// ========== Tests for valid week days ==========
	/**
	 * Test no. 1
	 * Test objective: To test "monday" as a valid weekday
	 * Input: "monday"
	 * Expected output: true (monday is a valid weekday)
	 */
	@Test
	void testValidWeekdayMonday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("monday"));
	}
	/**
	 * Test no. 2
	 * Test objective: To test "tuesday" as a valid weekday
	 * Input: "tuesday"
	 * Expected output: true (tuesday is a valid weekday)
	 */
	@Test
	void testValidWeekdayTuesday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("Tuesday"));
	}
	/**
	 * Test no. 3
	 * Test objective: To test "wednesday" as a valid weekday
	 * Input: "wednesday"
	 * Expected output: true (wednesday is a valid weekday)
	 */
	@Test
	void testValidWeekdayWednesday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("WEDnesday"));
	}
	/**
	 * Test no. 4
	 * Test objective: To test "thursday" as a valid weekday
	 * Input: "thursday"
	 * Expected output: true (thursday is a valid weekday)
	 */
	@Test
	void testValidWeekdayThursday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("THURSDAY"));
	}
	/**
	 * Test no. 5
	 * Test objective: To test "friday" as a valid weekday
	 * Input: "friday"
	 * Expected output: true (friday is a valid weekday)
	 */
	@Test
	void testValidWeekdayFriday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("friDAY"));
	}
	/**
	 * Test no. 6
	 * Test objective: To test "saturday" as a valid weekday
	 * Input: "saturday"
	 * Expected output: true (saturday is a valid weekday)
	 */
	@Test
	void testValidWeekdaySaturday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("SaTuRdAy"));
	}
	/**
	 * Test no. 7
	 * Test objective: To test "sunday" as a valid weekday
	 * Input: "sunday"
	 * Expected output: true (sunday is a valid weekday)
	 */
	@Test
	void testValidWeekdaySunday() throws OrderExceptionHandler {
		assertTrue(order.validateWeekDay("sUnDaY"));
	}
	
	// ========== Tests for invalid week days ==========
	/**
	 * Test no. 8
	 * Test objective: To test for invalid weekdays
	 * Input: "testingday"
	 * Expected output: Exception ("Invalid day of the week entered")
	 */
	@Test
	void testInvalidWeekday() {
		assertThrows(OrderExceptionHandler.class, () -> {
			order.validateWeekDay("testingday");
		});
	}

	
	// ========== Tests for valid publication ID ==========
	/**
	 * Test no. 9
	 * Test objective: To test for valid publication ID
	 * Input: "P1111"
	 * Expected output: True ("P1111" is a valid publication ID)
	 */
	@Test
	void testValidPublicationID() throws OrderExceptionHandler {
		assertTrue(order.validatePublicationID("P1111"));
	}
	
	// ========== Tests for invalid publication ID ==========
	/**
	 * Test no. 10
	 * Test objective: To test for invalid publication ID
	 * Input: "" (empty string)
	 * Expected output: Exception ("Publication ID cannot be empty")
	 */
	@Test
	void testInvalidPublicationID() throws OrderExceptionHandler {
		assertThrows(OrderExceptionHandler.class, () -> {
			order.validatePublicationID("");
		});
	}
	
	// ========== Tests for valid customer ID ==========
	/**
	 * Test no. 11
	 * Test objective: To test for valid customer ID
	 * Input: "A6666"
	 * Expected output: True ("A6666" is a valid customer ID) 
	 */
	@Test
	void testValidCustomerID() throws OrderExceptionHandler {
		assertTrue(order.validateCustomerID("A6666"));
	}
	
	// ========== Tests for invalid customer ID ==========
	/**
	 * Test no. 12
	 * Test objective: To test for invalid customer ID
	 * Input: "" (empty string)
	 * Expected output: Exception ("Customer ID cannot be empty")
	 */
	@Test
	void testInvalidCustomerID() throws OrderExceptionHandler {
		assertThrows(OrderExceptionHandler.class, () -> {
			order.validateCustomerID("");
		});
	}
	// ========== Tests for valid Order ID ==========
	/**
	 * Test no. 13
	 * Test objective: To test for valid order ID
	 * Input: "O6666"
	 * Expected output: True ("O6666" is a valid order ID)
	 */
	@Test
	void testValidOrderID() throws OrderExceptionHandler{
		assertTrue(order.validateOrderID("O6666"));
	}
	// ========== Tests for invalid Order ID ==========
	/**
	 * Test no. 14
	 * Test objective: To test for invalid order ID
	 * Input: "" (empty string)
	 * Expected output: Exception ("Order ID cannot be empty")
	 */
	@Test
	void testInvalidOrderID() throws OrderExceptionHandler {
		assertThrows(OrderExceptionHandler.class, () -> {
			order.validateOrderID("");
		});
	}
	// ========== Tests for valid Delivery Area ID ==========
	/**
	 * Test no. 15
	 * Test objective: To test for valid Delivery Area ID
	 * Input: "AT001"
	 * Expected output: True ("AT001" is a valid Delivery Area ID)
	 */
	@Test
	void testValidDeliveryAreaID() throws OrderExceptionHandler{
		assertTrue(order.validateDeliveryArea("AT001"));
	}
	// ========== Tests for invalid Delivery Area ID ==========
	/**
	 * Test no. 16
	 * Test objective: To test for invalid Delivery Area ID
	 * Input: "" (empty string)
	 * Expected output: Exception ("Delivery Area ID cannot be empty")
	 */
	@Test
	void testInvalidDeliveryArea() throws OrderExceptionHandler {
		assertThrows(OrderExceptionHandler.class, () -> {
			order.validateOrderID("");
		});
	}
	
}
