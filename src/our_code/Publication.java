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
	
	public Publication() {
		this.publicationID = null;
		this.publicationName = null;
		this.publicationFreq = null;
		this.publicationStock = 0;
		this.publicationCost = 0.0;
		
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
	
	public boolean validatePubID (String pubID ) throws PublicationExceptionHandler {
		return false;
		
	}
	
	public boolean validatePubName (String pubName ) throws PublicationExceptionHandler {
		return false;
		
	}
	
	public boolean validatePubFreq (String pubFreq ) throws PublicationExceptionHandler {
		return false;
		
	}
	
	public boolean validatePubStock (int pubStock ) throws PublicationExceptionHandler {
		return false;
		
	}
	
	public boolean validatePubCost (double pubCost) throws PublicationExceptionHandler {
		return false;
		
	}

	

}
