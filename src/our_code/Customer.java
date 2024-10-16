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
	
	public void setStatus(String custStatus)	{
		this.status = status;
	}
	
	public String getStatus()	{
		return status;
	}
	
	public boolean validateName(String custName) throws CustomerExceptionHandler {
		if(custName.length() < 4)
		{
			throw new CustomerExceptionHandler("Customer Name length must be more or equal to 4");
		}
		if(custName.length() > 64)
		{
			throw new CustomerExceptionHandler("Customer Name length must be less than or equal to 64");
		}
		return true;
		
		//Agree Formating Rules on "Customer Name"
		//E.G. Name String must be a minimum of 2 characters and a maximum of 50 characters
	
		
	}
	
	public boolean validateAddress(String custAddr) throws CustomerExceptionHandler {
		return false;
		
		
	}
	
	public boolean validatePhoneNumber(String custPhone) throws CustomerExceptionHandler {
		
		return false;
		
	}
	
	public boolean validateCustomerID(int custId) throws CustomerExceptionHandler {
		
		return false;
	}
	

	public boolean validateStatus(String custStatus) throws CustomerExceptionHandler {
		return false;
	}
}