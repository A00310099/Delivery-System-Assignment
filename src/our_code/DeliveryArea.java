package our_code;

public class DeliveryArea {
    
    private String areaID;           // Unique Area ID (e.g., AT000)
    private String deliveryPersonID;  // Delivery Person ID
    private String areaNumber;  		 // Area number
    private String customerID;        // Customer ID
    private boolean isArchived;       // Archive status (for 6 years)
    
    public DeliveryArea() {
        this.isArchived = false;
    }

    // Constructor
    public DeliveryArea(String areaID, String deliveryPersonID, String areaNumber, String customerID) throws DeliveryAreaExceptionHandler {
        try {
            this.validateAreaID(areaID);
            this.validateCustomerID(customerID);
            this.validateDeliveryPersonID(deliveryPersonID);
            this.areaID = areaID;
            this.deliveryPersonID = deliveryPersonID;
            this.areaNumber = areaNumber;
            this.customerID = customerID;
            this.isArchived = false;
        } catch (DeliveryAreaExceptionHandler d) {
            throw d;
        }
    }

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    public String getDeliveryPersonID() {
        return deliveryPersonID;
    }

    public void setDeliveryPersonID(String deliveryPersonID) {
        this.deliveryPersonID = deliveryPersonID;
    }

    public String getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(String areaNumber) {
        this.areaNumber = areaNumber;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }
    
    public boolean validateAreaID(String areaId) throws DeliveryAreaExceptionHandler {
        if (areaId == null || areaId.length() < 1) {
            throw new DeliveryAreaExceptionHandler("Area ID must be greater than 0.");
        }
        return true;
    }

    public boolean validateCustomerID(String customerId) throws DeliveryAreaExceptionHandler {
        if (customerId == null || customerId.length() < 1) {
            throw new DeliveryAreaExceptionHandler("Customer ID must be greater than 0.");
        }
        return true;
    }

    public boolean validateDeliveryPersonID(String deliveryPersonId) throws DeliveryAreaExceptionHandler {
        if (deliveryPersonId == null || deliveryPersonId.length() < 1) {
            throw new DeliveryAreaExceptionHandler("Delivery Person ID must be greater than 0.");
        }
        return true;
    }
}


  
       
    
    	
    