package our_code;

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
	
	

}
