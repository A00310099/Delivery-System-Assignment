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
	public int getPublicationID() {
		return this.publicationID;
	}
	public String getWeekDay() {
		return this.weekDay;
	}
	public int getCustomerID() {
		return this.customerID;
	}
	
	// Setters
	public void setPublicationID(int id) {
		this.publicationID = id;
	}
	public void setWeekDay(String day) {
		this.weekDay = day;
	}
	public void setCustomerID(int id) {
		this.customerID = id;
	}
	
	// Validate methods
	public boolean validatePublicationID(int id) throws OrderException {
		// Publication ID cannot be 0 or a negative number
		if (id <= 0) {
			throw new OrderException("Publication ID must be greater than 0");
		}
		return true;
	}
	
	public boolean validateWeekDay(String day) throws OrderException {
		day = day.toLowerCase(); // Make the passed string case-insensitive
		
		if (day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") || day.equals("thursday") ||
				day.equals("friday") || day.equals("saturday") || day.equals("sunday")) {
			return true;
		} else {
			throw new OrderException("Invalid day of the week entered");
		}
	}
	
	public boolean validateCustomerID(int id) throws OrderException {
		// Customer ID cannot be 0 or a negative number
		if (id <= 0) {
			throw new OrderException("Customer ID must be greater than 0");
		}
		return true;
	}
}
