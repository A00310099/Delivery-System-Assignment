package our_code;

import java.util.ArrayList;
import java.util.List;

public class DeliveryArea {
    
    private String areaID;           // Unique Area ID (e.g., AT000)
    private String deliveryPersonID;         // Delivery Area Name (3-20 characters)
    private String areaNumber;  		 // List of valid addressess
    private String customerID;
    private boolean isArchived;      // Archive status (for 6 years)
    
    public DeliveryArea() {
        this.isArchived = false;
    }

    // Constructor
    public DeliveryArea(String areaID, String deliveryPersonID, String areaNumber, String customerID) {
        this.areaID = areaID;
        this.deliveryPersonID = deliveryPersonID;
        this.areaNumber = areaNumber;
        this.customerID = customerID;
        this.isArchived = false; 
    }

    // Getter and Setter methods for each attribute
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
        this.deliveryPersonID = areaID;
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

	


}

  
       
    
    	
    