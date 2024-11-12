package our_code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class deliveryAreatest {

    @Test
    public void testValidAreaID() {
        assertDoesNotThrow(() -> validateAreaID("AT001"));
    }

    @Test
    public void testInvalidAreaID() {
        DeliveryAreaExceptionHandler exception = assertThrows(DeliveryAreaExceptionHandler.class, 
            () -> validateAreaID("AT01"));
        assertEquals("AreaID must be in the format AT000", exception.getMessage());
    }

    @Test
    public void testValidAreaName() {
        assertDoesNotThrow(() -> validateAreaName("Monksland"));
    }

    @Test
    public void testInvalidAreaName() {
        DeliveryAreaExceptionHandler exception = assertThrows(DeliveryAreaExceptionHandler.class, 
            () -> validateAreaName("dj"));
        assertEquals("Area name must be between 3 - 20 characters", exception.getMessage());
    }

    @Test
    public void testValidAddress() {
        assertDoesNotThrow(() -> validateAddress("1 Monksland"));
    }

    @Test
    public void testInvalidAddress() {
        DeliveryAreaExceptionHandler exception = assertThrows(DeliveryAreaExceptionHandler.class, 
            () -> validateAddress(""));
        assertEquals("Invalid address", exception.getMessage());
    }

 
    public void validateAreaID(String areaID) throws DeliveryAreaExceptionHandler {
        if (areaID == null || !areaID.matches("AT\\d{3}")) {
            throw new DeliveryAreaExceptionHandler("AreaID must be in the format AT000");
        }
    }

    public void validateAreaName(String areaName) throws DeliveryAreaExceptionHandler {
        if (areaName == null || areaName.length() < 3 || areaName.length() > 20) {
            throw new DeliveryAreaExceptionHandler("Area name must be between 3 - 20 characters");
        }
    }

    public void validateAddress(String address) throws DeliveryAreaExceptionHandler {
        if (address == null || address.trim().isEmpty()) {
            throw new DeliveryAreaExceptionHandler("Invalid address");
        }
    }
}


		
