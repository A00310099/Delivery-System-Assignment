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
	public Order(String orderID, String publicationID, String weekDay, String customerID, String deliveryArea) throws OrderExceptionHandler{
		try {
			this.validateOrderID(orderID);
			this.validatePublicationID(publicationID);
			this.validateWeekDay(weekDay);
			this.validateCustomerID(customerID);
			this.validateDeliveryArea(deliveryArea);
		} catch(OrderExceptionHandler e) {
			throw e;
		}
		
		this.orderID = orderID;
		this.publicationID = publicationID;
		this.weekDay = weekDay;
		this.customerID = customerID;
		this.deliveryArea = deliveryArea;
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
	public boolean validatePublicationID(String id) throws OrderExceptionHandler {
		// Publication ID cannot be 0 or a negative number
		if (id == null || id.isEmpty()) {
			throw new OrderExceptionHandler("Publication ID cannot be empty");
		}
		return true;
	}
	
	public boolean validateWeekDay(String day) throws OrderExceptionHandler {
		day = day.toLowerCase(); // Make the passed string case-insensitive
		
		if (day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") || day.equals("thursday") ||
				day.equals("friday") || day.equals("saturday") || day.equals("sunday")) {
			return true;
		} else {
			throw new OrderExceptionHandler("Invalid day of the week entered");
		}
	}
	
	public boolean validateCustomerID(String id) throws OrderExceptionHandler {
		// Customer ID cannot be 0 or a negative number
		if (id == null || id.isEmpty()) {
			throw new OrderExceptionHandler("Customer ID cannot be empty");
		}
		return true;
	}
	
	public boolean validateOrderID(String id) throws OrderExceptionHandler{
		if(id.equals("all")) {
			throw new OrderExceptionHandler("ID \"all\" is not valid as it is reserved");
		}
		
		if(id == null || id.isEmpty())
		{
			throw new OrderExceptionHandler("Order ID cannot be empty");
		}

		return true;
	}
	public boolean validateDeliveryArea(String id) throws OrderExceptionHandler{
		if(id.equals("all")) {
			throw new OrderExceptionHandler("ID \"all\" is not valid as it is reserved");
		}
		
		if(id == null || id.isEmpty())
		{
			throw new OrderExceptionHandler("DeliveryArea ID cannot be empty");
		}

		return true;
		
	}
	
}
