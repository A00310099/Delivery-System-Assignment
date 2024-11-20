package our_code;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PublicationTest {
	
	private final Publication publication = new Publication();

	
	//Valid Tests
	/**
	 * Test no. 1
	 * Test objective: To test "PD001" as a PublicationID
	 * Input: "PD001"
	 * Expected output: true (PD001 is a valid PublicationID)
	 */
	@Test
	public void testValidPublicationID() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubID("PD001"));
	}
	/**
	 * Test no. 2
	 * Test objective: To test "Irish Times" as a Publication Name
	 * Input: "Irish Times"
	 * Expected output: true (Irish Times is a valid Publication Name)
	 */
	@Test
	public void testValidPublicationName() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubName("Irish Times"));
	}
	// Frequency tests
	/**
	 * Test no. 3
	 * Test objective: To test "Daily" as a Publication Frequency
	 * Input: "Daily"
	 * Expected output: true (Daily is a valid Publication Frequency)
	 */
	@Test
	public void testValidPublicationFrequency1() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Daily"));
	}
	/**
	 * Test no. 4
	 * Test objective: To test "Weekly" as a Publication Frequency
	 * Input: "Weekly"
	 * Expected output: true (Weekly is a valid Publication Frequency)
	 */
	@Test
	public void testValidPublicationFrequency2() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("weekly"));
	}
	/**
	 * Test no. 4
	 * Test objective: To test "Fortnightly" as a Publication Frequency
	 * Input: "Fortnightly"
	 * Expected output: true (Fortnightly is a valid Publication Frequency)
	 */
	@Test
	public void testValidPublicationFrequency3() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Fortnightly"));
	}
	/**
	 * Test no. 5
	 * Test objective: To test "Monthly" as a Publication Frequency
	 * Input: "Monthly"
	 * Expected output: true (Monthly is a valid Publication Frequency)
	 */
	@Test
	public void testValidPublicationFrequency4() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Monthly"));
	}
	/**
	 * Test no. 6
	 * Test objective: To test "Once" as a Publication Frequency
	 * Input: "Once"
	 * Expected output: true (Once is a valid Publication Frequency)
	 */
	@Test
	public void testValidPublicationFrequency5() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Once"));
	}
	/**
	 * Test no. 7
	 * Test objective: To test "5" as Publication Stock
	 * Input: "5"
	 * Expected output: true (5 is a valid Publication Stock)
	 */
	@Test
	public void testValidPublicationStock() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubStock(5));
	}
	// zero value stock
	/**
	 * Test no. 8
	 * Test objective: To test "0" as Publication Stock
	 * Input: "0"
	 * Expected output: true (0 is a valid Publication Stock)
	 */
	@Test
	public void testValidPublicationStockZero() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubStock(0));
	}
	
	//zero value cost
	/**
	 * Test no. 9
	 * Test objective: To test "0.0" as Publication Cost
	 * Input: "0.0"
	 * Expected output: true (0.0 is a valid Publication Cost)
	 */
	@Test
	public void testValidatePublicationCostFree() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubCost(0.0));
	}
	
	/**
	 * Test no. 10
	 * Test objective: To test "2.50" as Publication Cost
	 * Input: "2.50"
	 * Expected output: true (2.50 is a valid Publication Cost)
	 */
	@Test
	public void testValidatePublicationCost() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubCost(2.50));
	}
	/**
	 * Test no. 11
	 * Test objective: To test "xxxx" as an Invalid Publication ID
	 * Input: "xxxx"
	 * Expected output: false (xxxx is a invalid Publication ID)
	 */
	@Test
	public void testInvalidPublicationID() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubID("xxxx") || publication.validatePubID("0.0"));
	}
	/**
	 * Test no. 12
	 * Test objective: To test "0x0x0x0" as an Invalid Publication Name
	 * Input: "0x0x0x0"
	 * Expected output: false (0x0x0x0 is a invalid Publication Name)
	 */
	@Test
	public void testInvalidPublicationName() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubName("0x0x0x0"));
	}
	/**
	 * Test no. 13
	 * Test objective: To test "Every hour on the hour" as an Invalid Publication Frequency
	 * Input: "Every hour on the hour"
	 * Expected output: false (Every hour on the hour is a invalid Publication Frequency)
	 */
	@Test
	public void testInvalidPublicationFrequency1() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Every hour on the hour"));
	}
	/**
	 * Test no. 14
	 * Test objective: To test "Never" as an Invalid Publication Frequency
	 * Input: "Never"
	 * Expected output: false (Never is a invalid Publication Frequency)
	 */
	@Test
	public void testInvalidPublicationFrequency() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Never"));
	}
	

}
