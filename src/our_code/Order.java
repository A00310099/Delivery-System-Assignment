package our_code;

public class Order {
	private String orderID;
	private String publicationID;
	private String weekDay;
	private String customerID;
	private String deliveryArea;
	
	public Order() {
		// TODO constructor
	}
	
	// Getters
	public String getOrderID() {
		return this.orderID;
	}
	public String getPublicationID() {
		return this.publicationID;
	}
	public String getWeekDay() {
		return this.weekDay;
	}
	public String getCustomerID() {
		return this.customerID;
	}
	public String getDeliveryArea() {
		return this.deliveryArea;
	}
	
	// Setters
	public void setOrderID(String id) {
		this.orderID = id;
	}
	public void setPublicationID(String id) {
		this.publicationID = id;
	}
	public void setWeekDay(String day) {
		this.weekDay = day;
	}
	public void setCustomerID(String id) {
		this.customerID = id;
	}
	
	public void setDeliveryArea(String id) {
		this.deliveryArea = id;
		
	}

	
	// Validate methods
	public boolean validatePublicationID(String id) throws OrderException {
		// Publication ID cannot be 0 or a negative number
		if (id == null || id.isEmpty()) {
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
	
	public boolean validateCustomerID(String id) throws OrderException {
		// Customer ID cannot be 0 or a negative number
		if (id == null || id.isEmpty()) {
			throw new OrderException("Customer ID must be greater than 0");
		}
		return true;
	}

	
}
