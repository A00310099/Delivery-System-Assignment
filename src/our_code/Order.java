package our_code;

public class Order {
	private int orderID;
	private Publication publication;
	private String weekDay;
	private int customerID;
	
	public Order() {
		// TODO constructor
	}
	
	// Getters
	public int getID() {
		return this.orderID;
	}
	public Publication getPublication() {
		return this.publication;
	}
	public String getWeekDay() {
		return this.weekDay;
	}
	public int getCustomerID() {
		return this.customerID;
	}
	
	// Setters
	public void setPublication(Publication p) {
		this.publication = p;
	}
	public void setWeekDay(String day) {
		this.weekDay = day;
	}
	public void setCustomerID(int id) {
		this.customerID = id;
	}
	
	// Validate methods
	public void validatePublication(Publication p) throws OrderException {
		// TODO validate method
	}
	
	public void validateWeekDay(String day) throws OrderException {
		// TODO validate method
	}
	
	public void validateCustomerID(int id) throws OrderException {
		// TODO validate method
	}
}
