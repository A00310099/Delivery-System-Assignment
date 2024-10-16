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
	
	public String getphoneNumber()	{
		return phoneNumber;
	}
	
	public void setStatus(String status)	{
		this.status = status;
	}
	
	public String getStatus()	{
		return status;
	}
	
	public boolean validateName(String custName) throws CustomerExceptionHandler {
		return false;
		
		//Agree Formating Rules on "Customer Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
	
		
	}
	
	public boolean validateAddress(String custAddr) throws CustomerExceptionHandler {
		
		return false;
		
	}
	
	public  boolean validatePhoneNumber(String custPhone) throws CustomerExceptionHandler {
		
		return false;
		
	}
	
	public boolean validateCustomerID(int custId) throws CustomerExceptionHandler {
		return false;
	}
	
}
