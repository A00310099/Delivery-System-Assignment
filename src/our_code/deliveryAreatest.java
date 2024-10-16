package our_code;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

public class deliveryAreatest {  
	  @Test  
	  public void areaID() {  
	        String expectedString = "AT001";  
		    assertEquals(expectedString, "AT01");  
	    }  
		   boolean validateAreaID(String areaID) throws DeliveryAreaExceptionHandler {
		   if (areaID != null && areaID.matches("AT\\d{3}") ){
			   return true;
		   }
		   else {
	            throw new DeliveryAreaExceptionHandler("AreaID must be in the format AT000");}
	        }
	   @Test  
	   public void areaName() {  
	   String expectedString = "Monksland";  
	   assertEquals(expectedString, "dj");  
	    }  
		   boolean validateAreaName(String areaName) throws DeliveryAreaExceptionHandler {
			   if (areaName.length() >= 3 && areaName.length() <= 20) {
		            return true;
			   }
			   else {
				   throw new DeliveryAreaExceptionHandler("areaName must be between 3 - 20 letters");
			   }
		}
	    @Test  
	    public void addresses() {  
	    String expectedString = "1 Monksland";  
	    assertEquals(expectedString, "683779 Monksland");  
	    }  
	    boolean validateAddresses(String addresses) throws DeliveryAreaExceptionHandler {
	        if (addresses != null && !addresses.isEmpty()) {
	            return true;
	        } else {
	            throw new DeliveryAreaExceptionHandler("Invalid address");
	        }
	    }
	    
	    @Test  
	    public void Validaddresses() {  
	    String expectedString = "1 Monksland";  
	    assertEquals(expectedString, "1 Monksland");  
	    }  
	    
	    @Test  
	    public void ValidareaName() {  
		String expectedString = "Monksland";  
		assertEquals(expectedString, "Monksland");  
	    } 
	    @Test  
		public void ValidareaID() {  
		String expectedString = "AT001";  
	    assertEquals(expectedString, "AT001");  
	    }  

	    

	        		
	}
		
