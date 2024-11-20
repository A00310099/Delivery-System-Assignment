package our_code;

import our_code.CustomerExceptionHandler;

public class Customer {

	private String name;
	private String phoneNumber;
	private String customerID;
	private String address;
	private String status;
	
	public Customer() {
		
	}
	public Customer(String customerID, String name, String address, String phoneNumber, String status) throws CustomerExceptionHandler
	{
		try {
			this.validateCustomerID(customerID);
			this.validateName(name);
			this.validateAddress(address);
			this.validatePhoneNumber(phoneNumber);
			this.validateStatus(status);
		} catch (CustomerExceptionHandler e) {
			throw e;
		}
		
		this.customerID = customerID;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.status = status;
	}
	
	// getters and setters
	void setCustomerId(String custId) {
		this.customerID = custId;
	}
	
	public String getCustomerID()	{
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
	
	public String getPhoneNumber()	{
		return phoneNumber;
	}
	
	public void setStatus(String custStatus)	{
		this.status = custStatus;
	}
	
	public String getStatus()	{
		return status;
	}
	// validation for Name of Customer, throws exception handler for invalid inputs, returns true for valid inputs
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
	
	
		
	}
	// validation for Address throws exception handler for invalid inputs, returns true for valid inputs
	public boolean validateAddress(String custAddr) throws CustomerExceptionHandler {
		if(custAddr.length() < 4)
		{
			throw new CustomerExceptionHandler("Customer Address length must be more or equal to 4");
		}
		if(custAddr.length() > 64)
		{
			throw new CustomerExceptionHandler("Customer Address length must be less than or equal to 64");
		}
		return true;
		
		
		
		
		
	}
	// validation for Customer Phone Number throws exception handler for invalid inputs, returns true for valid inputs
	public boolean validatePhoneNumber(String custPhone) throws CustomerExceptionHandler{
	if(custPhone.length() > 10)
	{
		throw new CustomerExceptionHandler("Phone number is too big");
	}
	if(custPhone.length() < 10)
	{
		throw new CustomerExceptionHandler("Phone number is too short");
	}
		
		return true;
		
	}
	// validation for Customer ID throws exception handler for invalid inputs, throws return true for valid inputs
	public boolean validateCustomerID(String custId) throws CustomerExceptionHandler {
		
		if(custId.equals("all")) {
			throw new CustomerExceptionHandler("ID \"all\" is not valid as it is reserved");
		}
		
		if(custId == null || custId.isEmpty())
		{
			throw new CustomerExceptionHandler("Customer ID must be greater than 0");
		}

		return true;
	}
	
	// validation for Customer Status, throws true if valid, throws exception handler for invalid inputs
	public boolean validateStatus(String custStatus) throws CustomerExceptionHandler {
		custStatus = custStatus.toLowerCase();
		if(custStatus.equals("active"))
		{
			return true;
		}
		
		if(custStatus.equals("paused")) {
			return true;
		}
		
		else
		{		
			throw new CustomerExceptionHandler("Invalid Status");	
		}
	}
}
	
	

