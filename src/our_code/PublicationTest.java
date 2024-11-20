package our_code;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class PublicationTest {
	
	private final Publication publication = new Publication();

	//Valid Tests
	
	@Test
	public void testValidPublicationID() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubID("001"));
	}
	
	@Test
	public void testValidPublicationName() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubName("Irish Times"));
	}
	
	@Test
	public void testPublicationType() throws PublicationExceptionHandler {
		assertTrue(publication.validatePublicationType("newspaper"));
	}
	
	// Frequency tests
	
	@Test
	public void testValidPublicationFrequency1() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Daily"));
	}
	
	@Test
	public void testValidPublicationFrequency2() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Weekly"));
	}
	
	@Test
	public void testValidPublicationFrequency3() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Fortnightly"));
	}
	
	@Test
	public void testValidPublicationFrequency4() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Monthly"));
	}
	
	@Test
	public void testValidPublicationFrequency5() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Once"));
	}
	//Stock tests
	
	@Test
	public void testValidPublicationStock() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubStock(5));
	}
	// zero value stock
	@Test
	public void testValidPublicationStockZero() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubStock(0));
	}
	
	//zero value cost
	@Test
	public void testValidatePublicationCostFree() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubCost(0.0));
	}
	
	@Test
	public void testValidatePublicationCost() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubCost(2.50));
	}
	
	@Test
	public void testInvalidPublicationID() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubID("xxxx") || publication.validatePubID("0.0"));
	}
	
	@Test
	public void testInvalidPublicationName() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubName("0x0x0x0"));
	}
	
	@Test
	public void testInvalidPublicationFrequency1() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Every hour on the hour"));
	}
	
	@Test
	public void testInvalidPublicationFrequency() throws PublicationExceptionHandler {
		assertTrue(publication.validatePubFreq("Never"));
	}
	

}
