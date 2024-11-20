package our_code;

public class DeliveryDocket {
	private int docketID;
	private String theTime;// Possibly?
	private String deliveryArea;
	private String orderStatus;
	private String listOfOrders;
	
	public DeliveryDocket()
	{
		
	}
	
	public DeliveryDocket(int docketID, String theTime, String deliveryArea, String orderStatus, String listOfOrders) throws DeliveryDocketExceptionHandler 
	{
		try {
			this.validateDocketID(docketID);
			//this.validateTime(theTime);
			this.validateDeliveryArea(deliveryArea);
			this.validateOrderStatus(orderStatus);
			
		} catch(DeliveryDocketExceptionHandler d) {
			throw d;
		}
		this.docketID = docketID;
		this.theTime = theTime;
		this.deliveryArea = deliveryArea;
		this.orderStatus = orderStatus;
		this.listOfOrders = listOfOrders;
	}
	// getters and setters
	void setId(int docID) 
	{
		docketID = docID;
	}
	
	public int getID()	
	{
		return docketID;
	}
	
	void setTime(String time)	
	{
		theTime = time;
	}
	
	public String getTime()
	{
		return theTime;
	}
	
	void setArea(String delArea)
	{
		deliveryArea = delArea;
	}
	
	public String getArea()
	{
		return deliveryArea;
	}
	
	
	void setStatus(String status)
	{
		orderStatus = status;
		
	}
	public String getStatus()
	{
		return orderStatus;
	}
	
	void setOrders(String orders)
	{
		listOfOrders = orders;
	}
	
	public String getOrders()
	{
		return listOfOrders;
	}
	
	// validation for Docket ID throws exception handler for invalid inputs, return true for valid
	public boolean validateDocketID(int docId) throws DeliveryDocketExceptionHandler{
		if(docId <= 0)
		{
			throw new DeliveryDocketExceptionHandler("Docket Id must be greater than 0");
		}
		return true;
		
	}
	// validation for Docket Order Status, return true for valid statements, throw Exception Handler for invalid inputs
	public boolean validateOrderStatus(String status) throws DeliveryDocketExceptionHandler{
		if(status.equals("Yes"))
		{
			return true;
			
		}
		if(status.equals("No"))
		{
			return true;
		}
		else
		{
			throw new DeliveryDocketExceptionHandler("Invalid Status");
		}
	}
	// validation for Docket Delivery Area throws exception handler for invalid inputs, return true for valid
	public boolean validateDeliveryArea(String deliveryArea) throws DeliveryDocketExceptionHandler{
		if(deliveryArea.length() < 4)
		{
			throw new DeliveryDocketExceptionHandler("Delivery Area Name length must be more or equal to 4");
		}
		if(deliveryArea.length() > 64)
		{
			throw new DeliveryDocketExceptionHandler("Delivery Area Name length must be less than or equal to 64");
		}
		return true;
					
		
	}

}
