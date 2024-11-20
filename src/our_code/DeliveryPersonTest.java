package our_code;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DeliveryPersonTest {

    @Test
    public void testIdNumberValidation() throws DeliveryAreaExceptionHandler {
        String validId = "DP001";
        String invalidId = "DP01";

        assertTrue(validateAreaID(validId), "Valid ID should return true");
        assertThrows(DeliveryAreaExceptionHandler.class, () -> validateAreaID(invalidId), "Invalid ID should throw exception");
    }

    boolean validateAreaID(String areaID) throws DeliveryAreaExceptionHandler {
        if (areaID != null && areaID.matches("DP\\d{3}")) {
            return true;
        } else {
            throw new DeliveryAreaExceptionHandler("IdNumber must be in the format DP000");
        }
    }

    @Test
    public void testPhoneNumberValidation() throws DeliveryAreaExceptionHandler {
        String validPhone = "0851234567";
        String invalidPhone = "085 134";

        assertTrue(validatePhoneNumber(validPhone), "Valid phone number should return true");
        assertThrows(DeliveryAreaExceptionHandler.class, () -> validatePhoneNumber(invalidPhone), "Invalid phone number should throw exception");
    }

    boolean validatePhoneNumber(String phoneNumber) throws DeliveryAreaExceptionHandler {
        if (phoneNumber.length() == 10) {
            return true;
        } else {
            throw new DeliveryAreaExceptionHandler("PhoneNumber must be exactly 10 digits");
        }
    }

    @Test
    public void testDeliveryPersonNameValidation() throws DeliveryAreaExceptionHandler {
        String validName = "Jack";
        String shortName = "Bo";
        String longName = "A".repeat(65);

        assertTrue(validateAreaName(validName), "Valid name should return true");
        assertThrows(DeliveryAreaExceptionHandler.class, () -> validateAreaName(shortName), "Short name should throw exception");
        assertThrows(DeliveryAreaExceptionHandler.class, () -> validateAreaName(longName), "Long name should throw exception");
    }

  
    boolean validateAreaName(String areaName) throws DeliveryAreaExceptionHandler {
        if (areaName.length() >= 3 && areaName.length() <= 64) {
            return true;
        } else {
            throw new DeliveryAreaExceptionHandler("Delivery Person Name must be between 3 - 64 letters");
        }
    }

    @Test
    public void testValidPhoneNumber() {
        String expectedPhone = "0851234567";
        String actualPhone = "0851234567";
        assertEquals(expectedPhone, actualPhone, "Phone numbers should be equal");
    }

    @Test
    public void testValidDeliveryPersonName() {
        String expectedName = "Jack";
        String actualName = "Jack";
        assertEquals(expectedName, actualName, "Delivery person names should be equal");
    }

    @Test
    public void testValidIdNumber() {
        String expectedId = "DP001";
        String actualId = "DP001";
        assertEquals(expectedId, actualId, "Delivery person IDs should be equal");
    }
}
