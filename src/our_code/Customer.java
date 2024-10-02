package our_code;

public class Customer {

	private String name;
	private String phoneNumber;
	private int customerID;
	private String address;
	private String status;
	
	public Customer()
	{
		
	}
	void setId(int custId) {
		customerID = custId;
	}
	
	public int getID()	{
		return customerID;
	}
	
	
	public void setName(String custName) {
		this.name = custName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String custAddr)	{
		this.address = custAddr;
	}
	
	public String getAddress()	{
		return address;
	}
	
	
	public void setPhoneNumber(String custPhone)	{
		this.phoneNumber = custPhone;
	}
	
	public String phoneNumber()	{
		return phoneNumber;
	}
	
	public void setStatus(String status)	{
		this.status = status;
	}
	
	public String getStatus()	{
		return status;
	}
	
}
