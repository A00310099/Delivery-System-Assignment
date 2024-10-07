package our_code;

public class DeliveryDocket {
	private int docketID;
	private String theTime;// Possibly?
	private String deliveryArea;
	private boolean orderStatus;
	private String listofOrders;
	
	public DeliveryDocket() {
		
	}
	void setId(int dockID) {
		docketID = dockID;
	}
	
	public int getID()	{
		return docketID;
	}
	
	void setTime(String time)	{
		theTime = time;
	}
	
	public String getTime(){
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
	void setStatus(boolean status)
	{
		orderStatus = status;
		
	}
	void setOrders(String orders)
	{
		listofOrders = orders;
	}
	public String getOrders()
	{
		return listofOrders;
	}
	
}
