package our_code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeliveryDockettest {

	  @Test  
	  public void docketid() {  
	        String expectedString = "DD001";  
		    assertEquals(expectedString, "DD01");  
	    }  
		   boolean validatedocketid(String docketid) throws DeliveryDocketExceptionHandler {
		   if (docketid != null && docketid.matches("DD\\d{3}") ){
			   return true;
		   }
		   else {
	            throw new DeliveryDocketExceptionHandler("docketid must be in the format DD001");}
	        }
		   
		   @Test  
			  public void theTime() {  
			        String expectedString = "00:00";  
				    assertEquals(expectedString, "1:234");  
			    }  
				   boolean validatetheTime(String theTime) throws DeliveryDocketExceptionHandler {
					   if (theTime != null && theTime.matches("(24:00|[02]?[0-3]|2[0-3]):[0-5][0-9]") ){
					   return true;
				   }
				   else {
			            throw new DeliveryDocketExceptionHandler("theTime should be in format 00:00 ");}
			        }
	     @Test  
		  public void statusY() {  
        String expectedString = "Y";  
	    assertEquals(expectedString, "X");  
		  }  
		   boolean validatestatusY(String statusY) throws DeliveryDocketExceptionHandler {
	       if (statusY != null && statusY.matches("Y") ){
		   return true;
	      }
		   else {
		  throw new DeliveryDocketExceptionHandler("Status should be Y or N");}
		  }	
		   @Test  
		  public void statusN() {  
	       String expectedString = "N";  
	       assertEquals(expectedString, "X");  
			 }  
		      boolean validatestatusN(String statusN) throws DeliveryDocketExceptionHandler {
			  if (statusN != null && statusN.matches("N") ){
			   return true;
		     }
			  else {
		     throw new DeliveryDocketExceptionHandler("Status should be N");}
		     }
		      
		      @Test  
			  public void ValidatestatusY() {  
	          String expectedString = "Y";  
		      assertEquals(expectedString, "Y");  
			  }  
		      @Test  
			  public void ValidatestatusN() {  
	          String expectedString = "N";  
		      assertEquals(expectedString, "N");  
			  }  
		      @Test  
			  public void Validatedocketid() {  
	          String expectedString = "DD001";  
		      assertEquals(expectedString, "DD001");  
			  }
		      @Test  
			  public void ValidatetheTime() {  
	          String expectedString = "09:30";  
		      assertEquals(expectedString, "09:30");  
			  }
}
