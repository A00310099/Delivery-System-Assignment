package our_code;

public class Publication {
	
	private String publicationID; // Format PB000
	private String publicationName;
	private String publicationType;
	private String publicationFreq;
	private int publicationStock;
	private double publicationCost;
	
	public Publication (String pubID, String pubName, String pubType, String pubFreq, int pubStock, double pubCost){
		this.publicationID = pubID;
		this.publicationName = pubName;
		this.publicationFreq = pubFreq;
		this.publicationStock = pubStock;
		this.publicationCost = pubCost;
		
	}

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
	
	public void validatePubID (String pubID ) throws PublicationExceptionHandler {
		
	}
	
	public void validatePubName (String pubName ) throws PublicationExceptionHandler {
		
	}
	
	public void validatePubFreq (String pubFreq ) throws PublicationExceptionHandler {
		
	}
	
	public void validatePubStock (int pubStock ) throws PublicationExceptionHandler {
		
	}
	
	public void validatePubCost (double pubCost) throws PublicationExceptionHandler {
		
	}

	

}
