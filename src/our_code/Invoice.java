package our_code;

import sample_code.CustomerExceptionHandler;

public class Invoice {

	
	private String name;
	private String address;
	private String order;
	private String area;
	private int cost;
	private int id;
	
	// Verify Customer Details (name, address, orders, delivery area)
	// Verify Customer total costs 
	// Verify invalid inputs are rejected and an appropriate error message is generated
	
	// Verify valid invoice ID: unique positive integer
	
	public Invoice(String custName, String custAddress, String custOrder, String custArea, int custCost)  {
		
		id = 0;
		
		validateName(custName);
		validateAddress(custAddress);
		validateOrder(custOrder);
		validateArea(custArea);
		validateCost(custCost);
		
		// Set Attributes
		name = custName;
		address = custAddress;
		order = custOrder;
		area = custArea;
		cost = custCost;
	}
	

private void validateCost(int custCost) {
		// TODO Auto-generated method stub
		
	}


private void validateArea(String custArea) {
		// TODO Auto-generated method stub
		
	}


private void validateOrder(String custOrder) {
		// TODO Auto-generated method stub
		
	}


private void validateAddress(String custAddress) {
		// TODO Auto-generated method stub
		
	}


private void validateName(String custName) {
		// TODO Auto-generated method stub
		
	}


public void cusReminder () {
	// Verify reminder sent if not paid at the end of the month
	// Verify warning sent if unpaid at the end of second month
	
}

public void Status () {
	
	// Verify account cancellation if left unpaid for 3 months
	// Verify valid invoice as in User Story One
	// Verify Invoice status paid, partially paid or unpaid
	
}

public void Update () {
	// Verify valid invoice as in User Story One
	// Verify valid payment
	// Verify valid non payment of invoice 
	// Verify valid reminder sent after one month
	// Verify valid warning is sent after 2 months
	// Verify customer account canceled if all invoices unpaid
	
}

public void Archive () {
	// Verify valid paid invoice as in User Story One and 3
	// Verify Invoice archived for 6 years
}
}
