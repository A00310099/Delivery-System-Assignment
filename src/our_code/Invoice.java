package our_code;

import sample_code.CustomerExceptionHandler;

public class Invoice {
	
	private String invoiceID; // Format IN000
	private double totalCost;
	private String paymentReminder1;
	private String paymentReminder2;
	private String paymentReminder3;
	
	public String getInvoiceID() {
		return this.invoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}
	public double getTotalCost() {
		return this.totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getPaymentReminder1() {
		return this.paymentReminder1;
	}
	public void setPaymentReminder1(String paymentReminder1) {
		this.paymentReminder1 = paymentReminder1;
	}
	public String getPaymentReminder2() {
		return this.paymentReminder2;
	}
	public void setPaymentReminder2(String paymentReminder2) {
		this.paymentReminder2 = paymentReminder2;
	}
	public String getPaymentReminder3() {
		return this.paymentReminder3;
	}
	public void setPaymentReminder3(String paymentReminder3) {
		this.paymentReminder3 = paymentReminder3;
	}
	
	public void validateInvoiceID (String InvoiceID) {
		
	}
	
	public void validateTotalCost (double totalCost) throws InvoiceExceptionHandler {
		
	}
	
	public void validatePaymentReminder1(String paymentReminder1) throws InvoiceExceptionHandler{
		
	}
	
	public void validatePaymentReminder2(String paymentReminder2) throws InvoiceExceptionHandler {
		
	}

	public void validatePaymentReminder3(String paymentReminder3) throws InvoiceExceptionHandler {
	
	}
	
	

	
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
