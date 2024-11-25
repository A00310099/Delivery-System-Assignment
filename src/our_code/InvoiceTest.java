package our_code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    private Invoice invoice;

    @BeforeEach
    void setUp() {
        invoice = new Invoice("A6666", 20.0);
    }

    
    /*
     Test no.1
     Test Objective - Test the creation of a valid invoice
     Input - Customer ID A6666 and total cost 20.00
     Expected output - Valid Invoice fields are created (InvoiceID, CustomerID, TotalCost, status)
     */
    @Test
    void testInvoiceCreation() {
        assertNotNull(invoice.getInvoiceId()); 
        assertEquals("A6666", invoice.getCustomerID());
        assertEquals(20.0, invoice.getTotalCost());
        assertFalse(invoice.getReminder());
        assertEquals("Unpaid", invoice.getStatus());
    }

    /*
    Test no.2
    Test Objective - Test the creation of an invalid invoice with empty or negative values
    Input - Empty Customer ID or negative Total Cost
    Expected output - IllegalArgumentException is thrown
    */
    
    @Test
    void testInvalidInvoiceCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("", 200.0);  
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("Michael Shelley", -50.0); 
        });
    }

    
    /*
    Test no.3
    Test Objective - Test payment functionality of the invoice
    Input - Payment of 20.00
    Expected output - Total Cost becomes 0.0 and status changes to Paid
    */

    @Test
    void testPayInvoice() {
        invoice.payInvoice(20.0);  
        assertEquals(0.0, invoice.getTotalCost());  
        assertEquals("Paid", invoice.getStatus()); 
    }

    
    /*
    Test no.4
    Test Objective - Test payment functionality that throws exceptions
    Input - Over payment 30.00 or negative payment -10.00 
    Expected output - IllegalStateException for over payment and IllegalArgumentException for negative payment
    */
 
    @Test
    void testPayInvoiceThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            invoice.payInvoice(30.0);  
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            invoice.payInvoice(-10.0);  
        });
    }

    
    /*
    Test no.5
    Test Objective - Check initial status of an invoice
    Input - Newly created invoice
    Expected output - Status set to Unpaid
    */
    
    @Test
    void testCheckStatusInitially() {
        assertEquals("Unpaid", invoice.getStatus());
    }

    
    /*
    Test no.6
    Test Objective - Test invoice status after payment
    Input - Paid invoice
    Expected output - Status set to Paid
    */
    
    @Test
    void testCheckStatusAfterPayment() {
        invoice.payInvoice(20.0);
        assertEquals("Paid", invoice.getStatus());
    }

    /*
    Test no.7
    Test Objective - Test archive functionality for paid invoices
    Input - Paid invoice
    Expected output - Invoice should be archived
    */
    
    @Test
    void testArchiveInvoice() {
        invoice.payInvoice(20.0); 
        assertDoesNotThrow(() -> {
            invoice.archiveInvoice(); 
        });

        Invoice unpaidInvoice = new Invoice("C9999", 50.0);
        assertThrows(IllegalStateException.class, unpaidInvoice::archiveInvoice); 
    }

    /*
    Test no.8
    Test Objective - Test the reminder and status update
    Input - Call checkStatus multiple times on an invoice
    Expected output - Reminder set to true and status changes to Unpaid or Account Cancelled
    */
  
    @Test
    void testReminderAndStatusUpdate() {
        invoice.checkStatus();
        assertTrue(invoice.getReminder());  
        assertEquals("Unpaid", invoice.getStatus());  

        invoice.checkStatus(); 
        invoice.checkStatus();  
        
        assertTrue(invoice.getAccountCancelled());
    }
}