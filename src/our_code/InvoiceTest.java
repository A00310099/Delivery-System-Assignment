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

    @Test
    void testInvoiceCreation() {
        assertNotNull(invoice.getInvoiceId()); 
        assertEquals("A6666", invoice.getCustomerID());
        assertEquals(20.0, invoice.getTotalCost());
        assertFalse(invoice.getReminder());
        assertEquals("Unpaid", invoice.getStatus());
    }

    @Test
    void testInvalidInvoiceCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("", 200.0);  
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Invoice("Michael Shelley", -50.0); 
        });
    }

    @Test
    void testPayInvoice() {
        invoice.payInvoice(20.0);  
        assertEquals(0.0, invoice.getTotalCost());  
        assertEquals("Paid", invoice.getStatus()); 
    }

    @Test
    void testPayInvoiceThrowsException() {
        assertThrows(IllegalStateException.class, () -> {
            invoice.payInvoice(30.0);  
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            invoice.payInvoice(-10.0);  
        });
    }

    @Test
    void testCheckStatusInitially() {
        assertEquals("Unpaid", invoice.getStatus());
    }

    @Test
    void testCheckStatusAfterPayment() {
        invoice.payInvoice(20.0);
        assertEquals("Paid", invoice.getStatus());
    }

    @Test
    void testArchiveInvoice() {
        invoice.payInvoice(20.0); 
        assertDoesNotThrow(() -> {
            invoice.archiveInvoice(); 
        });

        Invoice unpaidInvoice = new Invoice("C9999", 50.0);
        assertThrows(IllegalStateException.class, unpaidInvoice::archiveInvoice); 
    }

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
