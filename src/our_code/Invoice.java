package our_code;

public class Invoice {
    
    private static int invoiceCounter = 0;
    private int invoiceId;
    private String customerID;
    private double totalCost;
    private String status; 
    private boolean reminder;
    private boolean warningSent = false;
    private boolean accountCancelled = false;

    public Invoice(String customerID, double totalCost) {
        if (isValidInput(customerID, totalCost)) {
            this.invoiceId = ++invoiceCounter;
            this.customerID = customerID;
            this.totalCost = totalCost;
            this.status = "Unpaid";
            this.reminder = false;
        } else {
            throw new IllegalArgumentException("Invalid customer details or total cost.");
        }
    }

    private boolean isValidInput(String customerID, double totalCost) {
        return customerID != null && !customerID.isEmpty() && totalCost > 0;
    }

    public void checkStatus() {
        if (status.equals("Unpaid")) {
            if (!reminder) {
                System.out.println("Reminder sent to " + customerID);
                reminder = true;
            } else if (!warningSent) {
                System.out.println("Warning sent to " + customerID);
                warningSent = true;
            } else {
                System.out.println("Account cancelled for " + customerID);
                accountCancelled = true;
            }
        }
    }
    
    public void archiveInvoice() {
        if (status.equals("Paid")) {
            System.out.println("Invoice " + invoiceId + " archived for 6 years.");
        } else {
            throw new IllegalStateException("Only paid invoices can be archived.");
        }
    }

    public boolean getAccountCancelled() {
        return accountCancelled;
    }
    
    public int getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public boolean getReminder() {
        return reminder;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void payInvoice(double paymentAmount) {
        if (paymentAmount >= totalCost) {
            status = "Paid";
            System.out.println("Invoice " + invoiceId + " is now paid.");
        } else {
            System.out.println("Insufficient payment for invoice " + invoiceId);
        }
    }

    public String getReminderAsString() {
        return reminder ? "true" : "false";
    }

    public String getInvoiceID() {
        return String.valueOf(invoiceId);
    }
}
