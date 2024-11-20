package our_code;

public class Publication {
	
	private String publicationID; // Format 000
	private String publicationName;
	private String publicationType;
	private String publicationFreq;
	private int publicationStock;
	private double publicationCost;
	
	//constructor
	public Publication (String pubID, String pubName, String pubType, String pubFreq, int pubStock, double pubCost) throws PublicationExceptionHandler{
		
		try {
			this.validatePubID(pubID);
			this.validatePubName(pubName);
			this.validatePublicationType(pubType);
			this.validatePubFreq(pubFreq);
			this.validatePubStock(pubStock);
			this.validatePubCost(pubCost);
			
		} catch (PublicationExceptionHandler e) {
			throw e;
		}
		this.publicationID = pubID;
		this.publicationName = pubName;
		this.publicationType = pubType;
		this.publicationFreq = pubFreq;
		this.publicationStock = pubStock;
		this.publicationCost = pubCost;
		
	}
	
	// Default Constructor
	public Publication() {
		this.publicationID = null;
		this.publicationName = null;
		this.publicationType = null;
		this.publicationFreq = null;
		this.publicationStock = 0;
		this.publicationCost = 0.0;
		
	}
	
	//Getters and Setters
	public String getPublicationID() {
		return this.publicationID;
	}

	public void setPublicationID(String publicationID) {
		this.publicationID = publicationID;
	}

	public String getPublicationName() {
		return this.publicationName;
	}

	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}

	public String getPublicationType() {
		return this.publicationType;
	}

	public void setPublicationType(String publicationType) {
		this.publicationType = publicationType;
	}

	public String getPublicationFreq() {
		return this.publicationFreq;
	}

	public void setPublicationFreq(String publicationFreq) {
		this.publicationFreq = publicationFreq;
	}

	public int getPublicationStock() {
		return this.publicationStock;
	}

	public void setPublicationStock(int publicationStock) {
		this.publicationStock = publicationStock;
	}

	public double getPublicationCost() {
		return this.publicationCost;
	}

	public void setPublicationCost(double publicationCost) {
		this.publicationCost = publicationCost;
	}
	// Checkes for a valid Publication ID if not throw exception handler
	public boolean validatePubID (String pubID ) throws PublicationExceptionHandler {
		
		if(pubID.equals("all")) {
			throw new PublicationExceptionHandler("ID \"all\" is not valid as it is reserved");
		}
		
		if(pubID == null || pubID.isEmpty())
		{
			throw new PublicationExceptionHandler("Publication ID must not be empty: ");
		}

		return true;
	}
		
	//Checks for a valid type of publication and invalid inputs in which case throws exception handler
	public boolean validatePublicationType (String pubType) throws PublicationExceptionHandler {
		
		pubType = pubType.toLowerCase();
		
		if (pubType.equals("newspaper") || pubType.equals("magazine") || pubType.equals("book"))
		{
			return true;
		}
		else
		{
			throw new PublicationExceptionHandler("Invalid Publication Type, Must be ");
		}
	}
	
	// Checks for a valid publication name otherwise throw excetion handler for invalid input
	public boolean validatePubName (String pubName ) throws PublicationExceptionHandler {
		if (pubName.length() < 4 || pubName.length() > 64)
		{
			throw new PublicationExceptionHandler("Invalid User Name, must be between 4 & 64 characters in length");
		}
		else
		{
			return true;
		}
		
	}
	
	//check for valid publication frequency and throw exception handler if not valid
	public boolean validatePubFreq (String pubFreq ) throws PublicationExceptionHandler {
		
		pubFreq = pubFreq.toLowerCase();
		
		if (pubFreq.equals("daily") || pubFreq.equals("weekly") || pubFreq.equals("fortnightly") || pubFreq.equals("monthly") || pubFreq.equals("once"))
		{
			return true;
		}
		else
		{
			throw new PublicationExceptionHandler("Not Daily, ,Fortnightly, Weekly, Monthly, Once");
		}
		
		
	}
	
	//Check for valid stock throw exception handler to indicate clearly empty stock, and throw exception handler for invalid input
	public boolean validatePubStock (int pubStock ) throws PublicationExceptionHandler {
		if (pubStock > 0)
		{
			return true;
		}
		else if (pubStock == 0)
		{
			throw new PublicationExceptionHandler("The Stock of this publication is Zero, empty");
		}
		else
		{
			throw new PublicationExceptionHandler("Invalid Stock input/output");
		}
		
	}
	
	
// Check for valid cost. 0.0 is free and valid. and throws exception handler for invalid inputs the invalid 
	public boolean validatePubCost (double pubCost) throws PublicationExceptionHandler {
		if (pubCost >= 0.0)
		{
			return true;
		}
		else
		{
			throw new PublicationExceptionHandler("Invlaid amount, must in the amount 0.0 (free) or greater ie 3.50");
		}
		
	}

	

}
