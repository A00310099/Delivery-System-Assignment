package our_code;

import java.util.ArrayList;
import java.util.List;

public class DeliveryArea {
    
    private String areaID;           // Unique Area ID (e.g., AT000)
    private String areaName;         // Delivery Area Name (3-20 characters)
    private String addresses;  		 // List of valid addresses
    private boolean isArchived;      // Archive status (for 6 years)

    // Constructor
    public DeliveryArea(String areaID, String areaName, String addresses) {
        this.areaID = areaID;
        this.areaName = areaName;
        this.addresses = addresses;
        this.isArchived = false; 
    }

    // Getter and Setter methods for each attribute
    public String getAreaID() {
        return areaID;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean isArchived) {
        this.isArchived = isArchived;
    }

    // Validation methods (for User Story )
//    public static boolean isValidAreaID(String areaID) {
//        return areaID != null && areaID.matches("AT\\d{3}"); // Format: AT000
//    }
//
//    public static boolean isValidAreaName(String areaName) {
//        return areaName != null && areaName.length() >= 3 && areaName.length() <= 20;
//    }
//
//    public static boolean isValidAddresses(List<String> addresses) {
//        return addresses != null && !addresses.isEmpty();
//    }
}

  
       
    
    	
    