package our_code;

public class Order {
	private int orderID;
	private int publicationID;
	private String weekDay;
	private int customerID;
	
	public Order() {
		// TODO constructor
	}
	
	// Getters
	public int getID() {
		return this.orderID;
	}
	public int getPublication() {
		return this.publicationID;
	}
	public String getWeekDay() {
		return this.weekDay;
	}
	public int getCustomerID() {
		return this.customerID;
	}
	
	// Setters
	public void setPublication(int id) {
		this.publicationID = id;
	}
	public void setWeekDay(String day) {
		this.weekDay = day;
	}
	public void setCustomerID(int id) {
		this.customerID = id;
	}
	
	// Validate methods
	public void validatePublication(int id) throws OrderException {
		// TODO validate method
	}
	
	public void validateWeekDay(String day) throws OrderException {
		// TODO validate method
	}
	
	public void validateCustomerID(int id) throws OrderException {
		// TODO validate method
	}
}
