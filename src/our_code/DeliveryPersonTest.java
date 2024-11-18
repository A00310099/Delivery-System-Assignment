package our_code; 

 

import static org.junit.jupiter.api.Assertions.*; 



import org.junit.jupiter.api.Test; 

 

public class DeliveryPersonTest {  

 @Test  

 public void IdNumber() {  

 String expectedString = "DP001";  

 assertEquals(expectedString, "DP01");  

 }  

 boolean validateAreaID(String areaID) throws DeliveryAreaExceptionHandler { 

 if (areaID != null && areaID.matches("DP\\d{3}") ){ 

 return true; 

 } 

 else { 

 throw new DeliveryAreaExceptionHandler("IdNumber must be in the format DP000");} 

 } 

 @Test  

 public void PhoneN() {  

 String expectedString = "0851234567";  

 assertEquals(expectedString, "085 134");  

 }  

 boolean validatePhoneN(String PhoneN) throws DeliveryPersonExceptionHandler { 

 if (PhoneN.length() == 10 ) { 

 return true; 

 } 

 else { 

 throw new DeliveryAreaExceptionHandler("PhoneNumber must be between 10 numbers"); 

 } 

} 

 @Test  

 public void DpName() {  

 String expectedString = "Jack";  

 assertEquals(expectedString, "Bo");  

 }  

 boolean validateAreaName(String areaName) throws DeliveryAreaExceptionHandler { 

 if (DpName.length() >= 3 && DpName.length() <= 64) { 

 return true; 

 } 

 else { 

 throw new DeliveryAreaExceptionHandler("Delivery Person Name must be between 3 - 64 letters"); 

 } 

} 

  

 @Test  

 public void PhoneN() {  

 String expectedString = "0851234567";  

 assertEquals(expectedString, "0851234567");  

 }  

  

 @Test  

 public void ValidateDpName() {  

String expectedString = "Jack";  

assertEquals(expectedString, "Jack");  

 }  

 @Test  

public void ValidateIdNumber() {  

String expectedString = "DP001";  

 assertEquals(expectedString, "DP001");  

 }  

 

  

 

 		 

} 